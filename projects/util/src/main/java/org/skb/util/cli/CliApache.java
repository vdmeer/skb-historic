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

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.skb.util.types.TSRepository;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.atomic.java.TSBoolean;
import org.skb.util.types.atomic.java.TSDouble;
import org.skb.util.types.atomic.java.TSInteger;
import org.skb.util.types.atomic.java.TSLong;
import org.skb.util.types.atomic.java.TSString;
import org.skb.util.types.composite.util.TSPropertyMap;

/**
 * Implementation of the CLI interface using Apache Commons CLI.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class CliApache implements Cli {
	/**
	 * The application name for reporting error and warnings
	 */
	private TSString applicationName;

	/**
	 * The command line options
	 */
	private Options options;

	/**
	 * The command line parsed
	 */
	private CommandLine line;

	/**
	 * List of options
	 */
	private LinkedHashMap<String, String> optionList;

	/**
	 * Class constructor, initialises all private data structures
	 */
	public CliApache() {
		this.applicationName=new TSString();
		this.options=new Options();
		this.optionList=new LinkedHashMap<String, String>();
	}

	/* (non-Javadoc)
	 * @see org.skb.util.Cli#setApplicationName(org.skb.types.base.TSAtomic)
	 */
	public void setApplicationName(TSBase appName){
		if(appName!=null&&appName.tsIsType(TEnum.TS_ATOMIC_JAVA_STRING))
			this.applicationName=(TSString)appName;
	}

	/* (non-Javadoc)
	 * @see org.skb.util.Cli#setApplicationName(java.lang.String)
	 */
	public void setApplicationName(String appName){
		if(appName!=null)
			this.applicationName=new TSString(appName);
	}

	/* (non-Javadoc)
	 * @see org.skb.util.Cli#setPropOptions(org.skb.types.util.TSPropertyMap)
	 */
	public void setPropOptions(TSPropertyMap prop){
		String optType;
		String optShort;
		String optLong;
		String optDescr;
		String optArgName;

		HashSet<String> ts=new HashSet<String>(prop.getRows());
        for (Iterator<String> i = ts.iterator(); i.hasNext(); i.hasNext()){
        	String current=i.next();
        	if(prop.get(current, TSPropertyMap.pmValCliOptionType)!=null){
       			optType=prop.get(current, TSPropertyMap.pmValCliOptionType).toString();
       			if(!(prop.get(current, TSPropertyMap.pmValCliOptionShort)).tsIsType(TEnum.TS_NULL))
       				optShort=prop.get(current, TSPropertyMap.pmValCliOptionShort).toString();
       			else
       				optShort=null;
       			if(!(prop.get(current, TSPropertyMap.pmValCliOptionLong)).tsIsType(TEnum.TS_NULL))
       				optLong=prop.get(current, TSPropertyMap.pmValCliOptionLong).toString();
       			else
       				optLong=null;
       			optDescr=prop.get(current, TSPropertyMap.pmValCliUsageDescr).toString();
       			optArgName=prop.get(current, TSPropertyMap.pmValCliUsageDescrAdd).toString();

        		if(  optType.equals(TSRepository.TString.TS_ATOMIC_JAVA_STRING)||
        		     optType.equals(TSRepository.TString.TS_ATOMIC_JAVA_INTEGER)||
        		     optType.equals(TSRepository.TString.TS_ATOMIC_JAVA_DOUBLE)||
                	 optType.equals(TSRepository.TString.TS_ATOMIC_JAVA_LONG)
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
        		else if(optType.equals(TSRepository.TString.TS_ATOMIC_JAVA_BOOLEAN)){
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
	}

	/* (non-Javadoc)
	 * @see org.skb.util.Cli#parse(java.lang.String[])
	 */
	public void parse(String[] args) throws ParseException {
        CommandLineParser parser=new PosixParser();
        try {
            this.line=parser.parse(this.options, args, true);
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
	 * @see org.skb.util.Cli#setOptions(org.skb.types.util.TSPropertyMap)
	 */
	public void setOptions(TSPropertyMap prop){
		String val;
        for(String key:this.optionList.keySet()){
        	val=this.optionList.get(key);
        	if(this.line.hasOption(val)){
        		String valType;
        		try {
        			valType=prop.get(key, TSPropertyMap.pmValCliOptionType).toString();
        		} catch (Exception e) {
        			valType="";
        		}
        		switch(TSRepository.type(valType)){
        			case TS_ATOMIC_JAVA_STRING:  prop.setValueCli(key, new TSString(line.getOptionValue(val))); break;
        			case TS_ATOMIC_JAVA_BOOLEAN: prop.setValueCli(key, new TSBoolean(true)); break;
        			case TS_ATOMIC_JAVA_INTEGER: prop.setValueCli(key, new TSInteger(line.getOptionValue(val))); break;
        			case TS_ATOMIC_JAVA_DOUBLE:  prop.setValueCli(key, new TSDouble(line.getOptionValue(val))); break;
        			case TS_ATOMIC_JAVA_LONG:    prop.setValueCli(key, new TSLong(line.getOptionValue(val))); break;
        			default: //System.err.println("Apache CL, UNKNOWN TYPE for <"+key+"> <"+valType+">");
        		}
        	}
        }
	}
}
