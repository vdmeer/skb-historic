/* Copyright (c) 2008-2011 Sven van der Meer
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

package org.skb.util.stringtemplate;

import java.io.IOException;
import java.io.Writer;

import org.antlr.stringtemplate.AutoIndentWriter;
import org.apache.log4j.Logger;

/**
 * An writer implementation for String Templates that limits the charachters per output line.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class STGWriterXtoY extends AutoIndentWriter {
	/** Logger instance */
	static Logger logger;

	protected int start=2;
	protected int end=78;
	protected int done=0;

	public STGWriterXtoY(Writer out){
		super(out);

		logger=Logger.getLogger(STGWriterXtoY.class);
	}

	private String printXtoY(String str, int co){
		String ret=""; int count;
		if(co<start) count=start; else count=co;
		if(co==0) for(int i=start;i>0;i-=1) ret+=" ";
		// not enough room for printing in the same line
		if((count+str.length()+1)>end){
			ret+="\n";
			for(int i=start;i>0;i-=1)
				ret+=" ";
			ret+=str;
		  count=start+str.length();
		}
		else{
		  ret+=str;
		  count+=+str.length();
		}
		done=count;
		if(str.contains("\n")) done=0;
		return ret;
	}

	public void setEnd(int i){
		this.end=i;
	}

	public void setLineWidth (int w){
		this.end=w;
	}

	public void setPrintableArea(int start, int end){
		this.start=start;
		this.end=end;
	}

	public void setStart(int i){
		this.start=i;
	}

	public int write(String str){
		try{out.write(printXtoY(str,done));}
		catch (IOException e){System.err.println("STGWriterXtoY exception "+e);}
		return done;
	}
}
