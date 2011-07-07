/* Copyright (c) 2010-2011 Sven van der Meer
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
 *     + Neither the name of the the author nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS  IS"
 * AND ANY EXPRESS  OR IMPLIED WARRANTIES,  INCLUDING, BUT NOT  LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY  AND FITNESS FOR A  PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN  NO EVENT SHALL  THE COPYRIGHT HOLDER  OR CONTRIBUTORS BE
 * LIABLE  FOR  ANY  DIRECT,  INDIRECT,  INCIDENTAL,  SPECIAL,  EXEMPLARY,   OR
 * CONSEQUENTIAL  DAMAGES  (INCLUDING,  BUT  NOT  LIMITED  TO,  PROCUREMENT  OF
 * SUBSTITUTE GOODS  OR SERVICES;  LOSS OF  USE, DATA,  OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER  CAUSED AND  ON ANY  THEORY OF  LIABILITY, WHETHER  IN
 * CONTRACT,  STRICT LIABILITY,  OR TORT  (INCLUDING NEGLIGENCE  OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE  USE OF THIS SOFTWARE, EVEN IF ADVISED  OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 */

package org.skb.types.base;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.skb.types.base.OatBaseArrayList;
import org.skb.types.base.OatBaseAtomic;
import org.skb.types.base.OatBaseComposite;
import org.skb.types.base.OatBaseMap;
import org.skb.types.base.OatBaseTable;
import org.skb.types.composite.util.OatLanguageRuleMap;
import org.skb.types.composite.util.OatMapLH;
import org.skb.types.composite.util.OatPropertyMap;
import org.skb.types.composite.util.OatTable;
import org.skb.types.composite.util.OatTableRow;
import org.skb.types.OatValueIsNullException;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;
import org.skb.types.atomic.antlr.OatAntlrToken;
import org.skb.types.atomic.antlr.OatStringTemplate;
import org.skb.types.atomic.antlr.OatStringTemplateGroup;
import org.skb.types.atomic.java.OatBoolean;
import org.skb.types.atomic.java.OatByte;
import org.skb.types.atomic.java.OatDouble;
import org.skb.types.atomic.java.OatFloat;
import org.skb.types.atomic.java.OatInteger;
import org.skb.types.atomic.java.OatLong;
import org.skb.types.atomic.java.OatShort;
import org.skb.types.atomic.java.OatString;
import org.skb.types.atomic.util.OatArrayListAtomic;
import org.skb.types.atomic.util.OatArrayListString;
import org.skb.types.atomic.util.OatPDO;
import org.skb.types.atomic.util.OatSTGManager;
import org.skb.types.atomic.util.OatScope;

/**
 * The base class for all SKB types.
 * 
 * OatBase is the root class for the SKB Type Hierarchy. 
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public abstract class OatBase {
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TypeRepository.OAT_BASE));
	protected final EnumSet<ATType> typeEnum=EnumSet.of(ATType.OAT_BASE);

	/**
	 * 
	 */
	protected Object oatValue=null;

	/**
	 * Returns the oatValue object.
	 * @return Object The local oatValue object.
	 * @throws OatValueIsNullException 
	 */
	public Object getValue() throws OatValueIsNullException {
		if(this.oatValue!=null)
			return this.oatValue;
		throw new OatValueIsNullException(ATType.OAT_BASE);
	}

	public final String getTypeString(){
		return this.typeString.lastElement();
	}

	public final ATType getTypeEnum(){
		return TypeRepository.type(this.typeString.lastElement());
	}

	public final boolean isType(String t){
		return this.typeString.contains(t);
	}

	public final boolean isType(ATType t){
		return this.typeEnum.contains(t);
		//return t.equals(TypeRepository.type(this.typeString.lastElement()));
	}

	public final List<String> getTypeStringList(){
		return this.typeString;
	}

	public final Set<ATType> getTypeEnumSet(){
		return this.typeEnum;
	}

	abstract public boolean isAtomic();

	abstract public boolean isComposite();

	abstract public void clean();

	abstract public void trim();

	/**
	 * Compare the oatValue to the specified object.
	 * @param obj Object to be compared to oatValue
	 * @return boolean true if oatValue is instantiated and equals obj, false otherwise
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		try{
			return this.getValue().equals(obj);
		} catch (Exception e){
			return false;
		}
	}

	/**
	 * Return the hash code of oatValue.
	 * @return int hash code of oatValue if instantiated, 0 otherwise 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		try{
			return this.getValue().hashCode();
		} catch (Exception e){
			return 0;
		}
	}

	/**
	 * Return a string representation of oatValue.
	 * @return String string representation of oatValue if instantiated, null otherwise 
	 * @see java.lang.Object#toString()

	 */
	public String toString(){
		try{
			return this.getValue().toString();
		} catch (Exception e){
			return null;
		}
	}

	public OatBaseAtomic getValOatAtomic(){
		return null;
	}

	public OatBaseComposite getValOatComposite(){
		return null;
	}

	public OatString getValOatAtomicString(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_STRING)
			return (OatString)this.oatValue;
		return null;
	}

	public OatBoolean getValOatAtomicBoolean(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_BOOLEAN)
			return (OatBoolean)this.oatValue;
		return null;
	}

	public OatInteger getValOatAtomicInteger(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_INTEGER)
			return (OatInteger)this.oatValue;
		return null;
	}

	public OatDouble getValOatAtomicDouble(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_DOUBLE)
			return (OatDouble)this.oatValue;
		return null;
	}

	public OatFloat getValOatAtomicFloat(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_FLOAT)
			return (OatFloat)this.oatValue;
		return null;
	}

	public OatLong getValOatAtomicLong(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_LONG)
			return (OatLong)this.oatValue;
		return null;
	}

	public OatShort getValOatAtomicShort(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_SHORT)
			return (OatShort)this.oatValue;
		return null;
	}

	public OatByte getValOatAtomicByte(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_BYTE)
			return (OatByte)this.oatValue;
		return null;
	}

	public OatAntlrToken getValOatAtomicAntlrToken(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_ANTLR_TOKEN)
			return (OatAntlrToken)this.oatValue;
		return null;
	}

	public OatStringTemplateGroup getValOatAtomicStringTemplateGroup(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_ANTLR_STGROUP)
			return (OatStringTemplateGroup)this.oatValue;
		return null;
	}

	public OatStringTemplate getValOatAtomicStringTemplate(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_ANTLR_ST)
			return (OatStringTemplate)this.oatValue;
		return null;
	}

	public OatSTGManager getValOatAtomicSTGManager(){
		if(this.getTypeEnum()==ATType.OAT_ATOMIC_STG_MANAGER)
			return (OatSTGManager)this.oatValue;
		return null;
	}

	public OatBaseArrayList getValOatArrayList(){
		if(this.getTypeEnum()==ATType.OAT_ARRAYLIST)
			return (OatBaseArrayList)this.oatValue;
		return null;
	}

	public OatArrayListAtomic getValOatArrayListAtomic(){
		if(this.getTypeEnum()==ATType.OAT_ARRAYLIST_ATOMIC)
			return (OatArrayListAtomic)this.oatValue;
		return null;
	}

	public OatArrayListString getValOatArrayListString(){
		if(this.getTypeEnum()==ATType.OAT_ARRAYLIST_STRING)
			return (OatArrayListString)this.oatValue;
		return null;
	}

	public OatTable getValOatTable(){
		if(this.getTypeEnum()==ATType.OAT_COMPOSITE_TABLE)
			return (OatTable)this.oatValue;
		return null;
	}

	public OatTableRow getValOatTableRow(){
		if(this.getTypeEnum()==ATType.OAT_COMPOSITE_TABLE_ROW)
			return (OatTableRow)this.oatValue;
		return null;
	}

	public OatPropertyMap getValOatPropertyMap(){
		if(this.getTypeEnum()==ATType.OAT_COMPOSITE_PROPERTY_MAP)
			return (OatPropertyMap)this.oatValue;
		return null;
	}

	public OatLanguageRuleMap getValOatLanguageRuleMap(){
		if(this.getTypeEnum()==ATType.OAT_COMPOSITE_LANGUAGE_RULE_MAP)
			return (OatLanguageRuleMap)this.oatValue;
		return null;
	}

	public OatMapLH getValOatMapLH(){
		if(getTypeEnum()==ATType.OAT_COMPOSITE_MAP_LH)
			return (OatMapLH)oatValue;
		return null;
	}

	public OatPDO getValOatPdo(){
		if(this.getTypeEnum()==ATType.OAT_PDO)
			return (OatPDO)this.oatValue;
		return null;
	}

	public OatBaseTable getValOatBaseCompositeTable(){
		if(this.getTypeEnum()==ATType.OAT_BASE_COMPOSITE_TABLE)
			return (OatBaseTable)this.oatValue;
		return null;
	}

	public OatBaseMap getValOatBaseCompositeMap(){
		if(this.getTypeEnum()==ATType.OAT_BASE_COMPOSITE_MAP)
			return (OatBaseMap)this.oatValue;
		return null;
	}

	public OatScope getValOatScope(){
		if(this.getTypeEnum()==ATType.OAT_SCOPE)
			return (OatScope)this.oatValue;
		return null;
	}

}
