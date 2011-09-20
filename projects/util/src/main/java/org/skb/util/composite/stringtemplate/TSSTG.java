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

package org.skb.util.composite.stringtemplate;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.antlr.stringtemplate.StringTemplateErrorListener;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.util.composite.TSAtomicAPI;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;

/**
 * Wrapper for the string template class {@link StringTemplateGroup}.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSSTG extends StringTemplateGroup implements TSAtomicAPI {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSSTG.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));


	/**
	 * @see StringTemplateGroup#StringTemplateGroup(java.io.Reader)
	 */
	public TSSTG(java.io.Reader r){
		super(r);
		this._init();
	}


	public TSSTG(java.io.Reader r, @SuppressWarnings("rawtypes") java.lang.Class lexer){
		super(r, lexer);
		this._init();
	}


	public TSSTG(java.io.Reader r, @SuppressWarnings("rawtypes") java.lang.Class lexer, StringTemplateErrorListener errors){
		super(r, lexer, errors);
		this._init();
	}


	public TSSTG(java.io.Reader r, @SuppressWarnings("rawtypes") java.lang.Class lexer, StringTemplateErrorListener errors, StringTemplateGroup superGroup){
		super(r, lexer, errors, superGroup);
		this._init();
	}


	public TSSTG(java.io.Reader r, StringTemplateErrorListener errors){
		super(r, errors);
		this._init();
	}


	public TSSTG(String s){
		super(s);
		this._init();
	}


	public TSSTG(String s, @SuppressWarnings("rawtypes") java.lang.Class lexer){
		super(s, lexer);
		this._init();
	}


	public TSSTG(String s, String rootDir){
		super(s, rootDir);
		this._init();
	}


	public TSSTG(String s, String rootDir, @SuppressWarnings("rawtypes") java.lang.Class lexer){
		super(s, rootDir, lexer);
		this._init();
	}


	/**
	 * Initialisation.
	 */
	private void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_ATOMIC_STRINGTEMPLATE_STG);
		this.typeEnum.add(TEnum.TS_ATOMIC_STRINGTEMPLATE_STG);
	}


	@Override
	public void tsClean(){
		//TODO
		logger.warn("tsClean not implemented");
	}


	@Override
	public final TEnum tsGetTypeEnum(){
		return TSRepository.type(this.typeString.lastElement());
	}


	@Override
	public final Set<TEnum> tsGetTypeEnumSet(){
		return this.typeEnum;
	}


	@Override
	public final String tsGetTypeString(){
		return this.typeString.lastElement();
	}


	@Override
	public final List<String> tsGetTypeStringList(){
		return this.typeString;
	}


	@Override
	public boolean tsIsAtomic(){
		return true;
	}


	@Override
	public boolean tsIsComposite(){
		return false;
	}


	@Override
	public final boolean tsIsType(String t){
		return this.typeString.contains(t);
	}


	@Override
	public final boolean tsIsType(TEnum t){
		return this.typeEnum.contains(t);
	}


	@Override
	public void tsPlus(TSBaseAPI tb){
		//TODO
		logger.warn("tsPlus not implemented");
	}


	@Override
	public String tsToString(int indent){
		String ret=new String();
		for(int i=indent;i>0;i--)
			ret+=" ";
		ret+=super.toString();
		return ret;
	}


	@Override
	public void tsTrim(){
		//TODO
		logger.warn("tsTrim not implemented");
	}


	@Override
	public TSSTG tsCopyAtomic(){
		return this;
	}

}
