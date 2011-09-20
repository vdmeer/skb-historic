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

package org.skb.util.patterns.structural.composite;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;

/**
 * Abstract class implementing the core functionality of {@link TSAtomicAPI}
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public abstract class TSAtomic implements TSAtomicAPI {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSAtomic.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE, TSRepository.TString.TS_ATOMIC));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE, TEnum.TS_ATOMIC));


	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsClean()
	 */
	@Override
	public void tsClean() {
		logger.warn("not implemented");
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsGetTypeEnum()
	 */
	@Override
	public TEnum tsGetTypeEnum() {
		return TSRepository.type(this.typeString.lastElement());
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsGetTypeEnumSet()
	 */
	@Override
	public Set<TEnum> tsGetTypeEnumSet() {
		return this.typeEnum;
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsGetTypeString()
	 */
	@Override
	public String tsGetTypeString() {
		return this.typeString.lastElement();
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsGetTypeStringList()
	 */
	@Override
	public List<String> tsGetTypeStringList() {
		return this.typeString;
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsIsAtomic()
	 */
	@Override
	public boolean tsIsAtomic() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsIsComposite()
	 */
	@Override
	public boolean tsIsComposite() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsIsType(java.lang.String)
	 */
	@Override
	public boolean tsIsType(String type) {
		return this.typeString.contains(type);
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsIsType(org.skb.util.patterns.structural.composite.TSRepository.TEnum)
	 */
	@Override
	public boolean tsIsType(TEnum type) {
		return this.typeEnum.contains(type);
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsPlus(org.skb.util.patterns.structural.composite.TSBaseAPI)
	 */
	@Override
	public void tsPlus(TSBaseAPI tb) {
		logger.warn("not implemented");
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsToString(int)
	 */
	@Override
	public String tsToString(int indent) {
		logger.warn("not implemented");
		return "";
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSBaseAPI#tsTrim()
	 */
	@Override
	public void tsTrim() {
		logger.warn("not implemented");
	}

	/* (non-Javadoc)
	 * @see org.skb.util.patterns.structural.composite.TSAtomicAPI#tsCopyAtomic()
	 */
	@Override
	public TSAtomicAPI tsCopyAtomic() {
		logger.warn("not implemented");
		return null;
	}

}
