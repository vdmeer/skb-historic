/* Copyright (c) 2011-2011 Sven van der Meer
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

package org.skb.base.composite;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.skb.base.composite.TSRepository.TEnum;

/**
 * Default Class.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSDefault implements TSAtomicAPI, TSCompositeAPI {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSDefault.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE, TSRepository.TString.TS_ATOMIC, TSRepository.TString.TS_COMPOSITE, TSRepository.TString.TS_DEFAULT));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE, TEnum.TS_ATOMIC, TEnum.TS_COMPOSITE, TEnum.TS_DEFAULT));

	/** Message for the class, can be used to express why it is used/returned */
	protected String message=null;

	/** Explanation for the class, i.e. explaining the message in more detail */
	protected String explanation=null;

	/**
	 * Class constructor.
	 */
	public TSDefault(){
	}

	/**
	 * Gets the message of the object.
	 * @return current message
	 */
	public String tsGetMessage(){
		if(this.message==null)
			return "";
		return this.message;
	}

	/**
	 * Sets a message for the object.
	 * @param msg new message
	 */
	public void tsSetMessage(String msg){
		this.message=msg;
	}

	/**
	 * Gets the explanation of the object.
	 * @return current explanation
	 */
	public String tsGetExplanation(){
		if(this.explanation==null)
			return "";
		return this.explanation;
	}

	/**
	 * Sets an explanation for the object.
	 * @param expl new explanation
	 */
	public void tsSetExplanation(String expl){
		this.explanation=expl;
	}

	@Override
	public TSCompositeAPI tsCopyComposite() {
		return new TSDefault();
	}

	@Override
	public TSAtomicAPI tsCopyAtomic() {
		return new TSDefault();
	}

	@Override
	public void tsClean() {
		logger.warn("tsClean has no effect on TSNull, yet someone called it");
	}

	@Override
	public TEnum tsGetTypeEnum() {
		return TSRepository.type(this.typeString.lastElement());
	}

	@Override
	public Set<TEnum> tsGetTypeEnumSet() {
		return this.typeEnum;
	}

	@Override
	public String tsGetTypeString() {
		return this.typeString.lastElement();
	}

	@Override
	public List<String> tsGetTypeStringList() {
		return this.typeString;
	}

	@Override
	public boolean tsIsAtomic() {
		return true;
	}

	@Override
	public boolean tsIsComposite() {
		return true;
	}

	@Override
	public boolean tsIsType(String type) {
		return this.typeString.contains(type);
	}

	@Override
	public boolean tsIsType(TEnum type) {
		return this.typeEnum.contains(type);
	}

	@Override
	public void tsPlus(TSBaseAPI tb) {
		logger.warn("tsPlus has no effect on TSNull, yet someone called it");
	}

	@Override
	public String toString(){
		return this.tsToString(0);
	}

	@Override
	public String tsToString(int indent) {
		String ret=new String();
		if(this.message!=null)
			ret+=this.message;
		if(this.explanation!=null)
			ret+="\n"+this.explanation;
		return ret;
	}

	@Override
	public void tsTrim() {
		logger.warn("tsTrim has no effect on TSNull, yet someone called it");
	}
}
