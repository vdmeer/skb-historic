/* Copyright (c) 2007-2011 Sven van der Meer
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

package org.skb.util.patterns.structural.composite.atomic.misc;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.skb.util.misc.ReportManager;
import org.skb.util.patterns.structural.composite.TSAtomicAPI;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.db.TSPDO;
import org.skb.util.stringtemplate.STGroupManager;

/**
 * Wrapper for the report manager class {@link ReportManager}.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSReportManager extends ReportManager implements TSAtomicAPI {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSPDO.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));


	/**
	 * Class constructor, initialises local fields.
	 */
	public TSReportManager(){
		super();
		this._initRM();
	}


	/**
	 * Initialisation.
	 */
	private void _initRM(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_ATOMIC_REPORTMANAGER);
		this.typeEnum.add(TEnum.TS_ATOMIC_REPORTMANAGER);
	}


	@Override
	public void tsClean() {
		// TODO Auto-generated method stub
		logger.warn("tsClean not implemented");
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
		return false;
	}


	@Override
	public boolean tsIsType(String t) {
		return this.typeString.contains(t);
	}


	@Override
	public boolean tsIsType(TEnum t) {
		return this.typeEnum.contains(t);
	}


	@Override
	public void tsPlus(TSBaseAPI tb) {
		logger.warn("tsPlus not implemented");
	}


	@Override
	public String tsToString(int indent) {
		logger.warn("tsToString not implemented");
		return "";
	}


	@Override
	public void tsTrim() {
		logger.warn("tsTrim not implemented");
	}


	@Override
	public TSReportManager tsCopyAtomic(){
		TSReportManager ret=new TSReportManager();
		ret.stgm=new STGroupManager(this.stgm);
		ret.noOfErrors=this.noOfErrors;
		ret.noOfWarnings=this.noOfWarnings;
		ret.noWarnings=this.noWarnings;
		ret.noErrors=this.noErrors;
		ret.fileFN=new String(this.fileFN);
		ret.applicationName=new String(this.applicationName);
		return ret;
	}
}
