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

package org.skb.util.cli;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.skb.util.cli.Cli;
import org.skb.util.types.TypeRepository;
import org.skb.util.types.atomic.java.OatBoolean;
import org.skb.util.types.atomic.java.OatDouble;
import org.skb.util.types.atomic.java.OatInteger;
import org.skb.util.types.atomic.java.OatLong;
import org.skb.util.types.atomic.java.OatString;
import org.skb.util.types.composite.util.OatPropertyMap;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

/**
 * Implementation of the CLI interface using Apache Commons cli.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class CliApache implements Cli {
	private OatString applicationName;
	private Options options;
	private CommandLine line;
	private LinkedHashMap<String, String> optionList;

	public CliApache() {
		this.applicationName=new OatString();
		this.options=new Options();
		this.optionList=new LinkedHashMap<String, String>();
	}

	/* (non-Javadoc)
	 * @see org.skb.util.Cli#setApplicationName(org.skb.types.base.OatBaseAtomic)
	 */
	public void setApplicationName(OatString appName){
		if(appName!=null)
			this.applicationName=(OatString)appName;
	}

	/* (non-Javadoc)
	 * @see org.skb.util.Cli#setApplicationName(java.lang.String)
	 */
	public void setApplicationName(String appName){
		if(appName!=null)
			this.applicationName=new OatString(appName);
	}

	/* (non-Javadoc)
	 * @see org.skb.util.Cli#setPropOptions(org.skb.types.util.OatPropertyMap)
	 */
	public void setPropOptions(OatPropertyMap prop){
		HashSet<String> ts=new HashSet<String>(prop.getRows());
        for (Iterator<String> i = ts.iterator(); i.hasNext(); i.hasNext()){
        	String current=i.next();
        	if(prop.get(current, OatPropertyMap.pmValCliOptionType)!=null){
        		String optType;
        		String optShort;
        		String optLong;
        		String optDescr;
        		String optArgName;

        		try{
        			optType=prop.get(current, OatPropertyMap.pmValCliOptionType).toString();
        		} catch (Exception e) {
        			optType=null;
        		}

        		try{
        			optShort=prop.get(current, OatPropertyMap.pmValCliOptionShort).toString();
        		} catch (Exception e) {
        			optShort=null;
        		}

        		try{
        			optLong=prop.get(current, OatPropertyMap.pmValCliOptionLong).toString();
        		} catch (Exception e) {
        			optLong=null;
        		}

        		try{
        			optDescr=prop.get(current, OatPropertyMap.pmValCliUsageDescr).toString();
        		} catch (Exception e) {
        			optDescr=null;
        		}

        		try{
        			optArgName=prop.get(current, OatPropertyMap.pmValCliUsageDescrAdd).toString();
        		} catch (Exception e) {
        			optArgName=null;
        		}

        		if(  optType.equals(TypeRepository.OAT_ATOMIC_STRING)||
        		     optType.equals(TypeRepository.OAT_ATOMIC_INTEGER)||
        		     optType.equals(TypeRepository.OAT_ATOMIC_DOUBLE)||
                	 optType.equals(TypeRepository.OAT_ATOMIC_LONG)
        		  ){
        			if(optShort!=null&&optLong!=null){
        				OptionBuilder.hasArg();
						OptionBuilder.withDescription(optDescr);
						OptionBuilder.withLongOpt(optLong);
						OptionBuilder.withArgName(optArgName);
						this.options.addOption(OptionBuilder.create(optShort.charAt(0)));
						this.optionList.put(current, optLong);
        			}
        			else if(optLong!=null){
        				OptionBuilder.hasArg();
						OptionBuilder.withDescription(optDescr);
						OptionBuilder.withLongOpt(optLong);
						OptionBuilder.withArgName(optArgName);
						this.options.addOption(OptionBuilder.create());
						this.optionList.put(current, optLong);
        			}
        		}
        		else if(optType.equals(TypeRepository.OAT_ATOMIC_BOOLEAN)){
        			if(optShort!=null&&optLong!=null){
        				OptionBuilder.withDescription(optDescr);
						OptionBuilder.withLongOpt(optLong);
						this.options.addOption(OptionBuilder.create(optShort.charAt(0)));
						this.optionList.put(current, optLong);
        			}
        			else if(optLong!=null){
        				OptionBuilder.withDescription(optDescr);
						OptionBuilder.withLongOpt(optLong);
						this.options.addOption(OptionBuilder.create());
						this.optionList.put(current, optLong);
        			}
        		}
			}
		}
		//this.setOptions();
	}

	/* (non-Javadoc)
	 * @see org.skb.util.Cli#parse(java.lang.String[])
	 */
	public void parse(String[] args) throws ParseException {
        CommandLineParser parser=new PosixParser();
        try {
            this.line=parser.parse(this.options, args, false);
        }
        catch(ParseException exp){
            throw exp;
        }
	}

	/* (non-Javadoc)
	 * @see org.skb.util.Cli#usage()
	 */
	public void usage(){
        HelpFormatter formatter=new HelpFormatter();
        formatter.printHelp(this.applicationName.toString(), this.options);
	}

	/* (non-Javadoc)
	 * @see org.skb.util.Cli#setOptions(org.skb.types.util.OatPropertyMap)
	 */
	public void setOptions(OatPropertyMap prop){
		String val;
        for(String key:this.optionList.keySet()){
        	val=this.optionList.get(key);
        	if(this.line.hasOption(val)){
        		String valType;
        		try {
        			valType=prop.get(key, OatPropertyMap.pmValCliOptionType).toString();
        		} catch (Exception e) {
        			valType="";
        		}
        		switch(TypeRepository.type(valType)){
        			case OAT_ATOMIC_STRING:  prop.setValueCli(key, new OatString(line.getOptionValue(val))); break;
        			case OAT_ATOMIC_BOOLEAN: prop.setValueCli(key, new OatBoolean(true)); break;
        			case OAT_ATOMIC_INTEGER: prop.setValueCli(key, new OatInteger(line.getOptionValue(val))); break;
        			case OAT_ATOMIC_DOUBLE:  prop.setValueCli(key, new OatDouble(line.getOptionValue(val))); break;
        			case OAT_ATOMIC_LONG:    prop.setValueCli(key, new OatLong(line.getOptionValue(val))); break;
        			default: System.err.println("UNKNOWN TYPE");
        		
        		}
/*
        		if(valType.equals(TypeRepository.OAT_ATOMIC_STRING))
        			prop.setValueCli(key, new OatString(line.getOptionValue(val)));
        		else if(valType.equals(TypeRepository.OAT_ATOMIC_BOOLEAN))
        			prop.setValueCli(key, new OatBoolean(true));
        		else if(valType.equals(TypeRepository.OAT_ATOMIC_INTEGER))
        			prop.setValueCli(key, new OatInteger(line.getOptionValue(val)));
        		else if(valType.equals(TypeRepository.OAT_ATOMIC_DOUBLE))
        			prop.setValueCli(key, new OatDouble(line.getOptionValue(val)));
        		else if(valType.equals(TypeRepository.OAT_ATOMIC_LONG))
        			prop.setValueCli(key, new OatLong(line.getOptionValue(val)));
        		else
        			System.err.println("UNKNOWN TYPE");
*/
        	}
        }
	}
}
