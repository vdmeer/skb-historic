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

package org.skb.base.stringtemplate;

import java.io.IOException;
import java.io.Writer;

import org.antlr.stringtemplate.AutoIndentWriter;
import org.apache.log4j.Logger;

/**
 * Writer implementation for String Templates that limits the characters per output line.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class STWriterXtoY extends AutoIndentWriter {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(STWriterXtoY.class);

	/** Start for writing characters in a line, default is 2 */
	protected int start=2;

	/** End for writing characters in a line, default is 78 */
	protected int end=78;

	/** Internal counter for number of written characters */
	protected int done=0;

	/**
	 * Class constructor, initialises super class with the given writer.
	 * @param out writer to be used
	 */
	public STWriterXtoY(Writer out){
		super(out);
	}

	/**
	 * Writes a string between start and and using count.
	 * @param str string to be written
	 * @param co current count of already used (written) characters in the current line
	 * @return string with \n added to not exceed end of each line
	 */
	private String printXtoY(String str, int co){
		String ret=""; int count;
		if(co<start)
			count=start;
		else
			count=co;
		if(co==0){
			for(int i=start;i>0;i-=1)
				ret+=" ";
		}
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
		if(str.contains("\n"))
			done=0;
		return ret;
	}

	/**
	 * Sets the line end.
	 * @param i new line end, alternative to {@link STWriterXtoY#setLineWidth(int)}
	 */
	public void setEnd(int i){
		this.end=i;
	}

	/**
	 * Sets the line end, alternative to {@link STWriterXtoY#setEnd(int)}.
	 * @param w new line end
	 */
	public void setLineWidth(int w){
		this.end=w;
	}

	/**
	 * Sets the printable areas (line start and line end).
	 * @param start new starting point in the line
	 * @param end new final width of the line
	 */
	public void setPrintableArea(int start, int end){
		this.start=start;
		this.end=end;
	}

	/**
	 * Sets new starting point for the line.
	 * @param i new starting point
	 */
	public void setStart(int i){
		this.start=i;
	}

	/**
	 * Writes a string.
	 * @param str string to be written
	 * @return number of characters written
	 */
	@Override public int write(String str){
		try{
			out.write(printXtoY(str,done));
		}catch (IOException e){
			logger.error("catched IO exception while writing\n"+e);
		}
		return done;
	}
}
