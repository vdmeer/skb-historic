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

import java.io.PrintWriter;
import java.io.StringWriter;
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
import org.apache.log4j.Logger;
import org.skb.util.FieldKeys;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.java.TSBoolean;
import org.skb.util.patterns.structural.composite.atomic.java.TSDouble;
import org.skb.util.patterns.structural.composite.atomic.java.TSInteger;
import org.skb.util.patterns.structural.composite.atomic.java.TSLong;
import org.skb.util.patterns.structural.composite.atomic.java.TSString;
import org.skb.util.patterns.structural.composite.composite.util.TSPropertyMap;

/**
 * Implementation of the CLI interface using Apache Commons CLI.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class CliApache implements Cli {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(CliApache.class);


	/** The application name for reporting error and warnings */
	private TSString applicationName;


	/** The command line options */
	private Options options;


	/** The command line parsed */
	private CommandLine line;


	/** List of options */
	private LinkedHashMap<String, String> optionList;


	/** Class constructor, initialises all private data structures */
	public CliApache() {
		this.applicationName=new TSString();
		this.options=new Options();
		this.optionList=new LinkedHashMap<String, String>();
	}


	@Override public boolean setApplicationName(TSBaseAPI appName){
		boolean ret=false;
		if(appName!=null&&appName.tsIsType(TEnum.TS_ATOMIC_JAVA_STRING)){
			this.applicationName=(TSString)appName;
			ret=true;
		}
		return ret;
	}


	@Override public boolean setApplicationName(String appName){
		boolean ret=false;
		if(appName!=null){
			this.applicationName=new TSString(appName);
			ret=true;
		}
		return ret;
	}


	@Override public String getApplicationName(){
		return this.applicationName.tsToString(0);
	}


	@Override public void setPropOptions(TSPropertyMap prop){
		String optShort;
		String optLong;
		String optArgName;

		HashSet<String> ts=new HashSet<String>(prop.getRows());
        for (Iterator<String> i = ts.iterator(); i.hasNext(); i.hasNext()){
        	String current=i.next();
        	if(prop.get(current, FieldKeys.fieldCliOptionType)!=null){
       			if(!(prop.get(current, FieldKeys.fieldCliOptionLong)).tsIsType(TEnum.TS_NULL))
       				optLong=prop.get(current, FieldKeys.fieldCliOptionLong).toString();
       			else
       				optLong=null;
       			OptionBuilder.withLongOpt(optLong);

       			OptionBuilder.withDescription(prop.get(current, FieldKeys.fieldCliOptionDescriptionShort).toString());

       			optArgName=prop.get(current, FieldKeys.fieldCliOptionDescriptionArguments).toString();
				if(optArgName.length()>0){
					OptionBuilder.hasArg();
					OptionBuilder.withArgName(optArgName);
				}
				else
					OptionBuilder.hasArg(false);

				TEnum optType=TSRepository.type(prop.get(current, FieldKeys.fieldCliOptionType).toString());
				switch(optType){
					case TS_ATOMIC_JAVA_BOOLEAN:
						OptionBuilder.withType(Boolean.class);
						break;
					case TS_ATOMIC_JAVA_DOUBLE:
						OptionBuilder.withType(Double.class);
						break;
					case TS_ATOMIC_JAVA_INTEGER:
						OptionBuilder.withType(Integer.class);
						break;
					case TS_ATOMIC_JAVA_LONG:
						OptionBuilder.withType(Long.class);
						break;
					case TS_ATOMIC_JAVA_STRING:
						OptionBuilder.withType(String.class);
						break;
					default: break;
				}

       			if(!(prop.get(current, FieldKeys.fieldCliOptionShort)).tsIsType(TEnum.TS_NULL))
       				optShort=prop.get(current, FieldKeys.fieldCliOptionShort).toString();
       			else
       				optShort=null;
       			if(optShort!=null&&optLong!=null){
       				this.options.addOption(OptionBuilder.create(optShort.charAt(0)));
					this.optionList.put(current, optLong);
       			}
       			else if(optLong!=null){
       				this.options.addOption(OptionBuilder.create());
					this.optionList.put(current, optLong);
       			}
       			else{
       				//dummy create, nothing to be done since no option set (short/long)
       				//TODO log warning or error
       				OptionBuilder.withLongOpt("__dummyLongOpt__");
       				OptionBuilder.create();
       			}
        	}
		}
	}


	/**
	 * Returns the options set for the command line parser
	 * @return options
	 */
	public Options getPropOptions(){
		return this.options;
	}


	@Override public void parse(String[] args, boolean stopAtNonOption) throws ParseException {
        CommandLineParser parser=new PosixParser();
        try {
            this.line=parser.parse(this.options, args, stopAtNonOption);
        }
        catch(ParseException exp){
        	logger.warn("catched ParserException: "+exp);
            throw exp;
        }
	}


	@Override public String usage(String header, String footer, int width, boolean autoUsage){
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);

        HelpFormatter formatter=new HelpFormatter();
        //formatter.printWrapped(pw, width, header); // formatter didn't accept "\n" ...
		formatter.printHelp(pw, width, this.applicationName.toString(), null, this.options, 2, 2, null, autoUsage);
		//formatter.printWrapped(pw, width, footer); // formatter didn't accept "\n" ...
		return header+sw.toString()+footer;
	}


	@Override public void setOptions(TSPropertyMap prop){
		String val;
        for(String key:this.optionList.keySet()){
        	val=this.optionList.get(key);
        	if(this.line.hasOption(val)){
        		String valType;
        		try {
        			valType=prop.get(key, FieldKeys.fieldCliOptionType).toString();
        		} catch (Exception e) {
        			valType="";
        		}

				switch(TSRepository.type(valType)){
        			case TS_ATOMIC_JAVA_STRING:
        				prop.setValueCli(key, new TSString(line.getOptionValue(val)));
        				break;
        			case TS_ATOMIC_JAVA_BOOLEAN:
        				prop.setValueCli(key, new TSBoolean(true));
        				break;
        			case TS_ATOMIC_JAVA_INTEGER:
        				int i;
        				try{
        					i=Integer.parseInt(line.getOptionValue(val).toString());
        				} catch(Exception e) {i=0;}
        				prop.setValueCli(key, new TSInteger(i));
        				break;
        			case TS_ATOMIC_JAVA_DOUBLE:
        				double d;
        				try{
        					d=Double.parseDouble(line.getOptionValue(val).toString());
        				} catch(Exception e) {d=0;}
        				prop.setValueCli(key, new TSDouble(d));
        				break;
        			case TS_ATOMIC_JAVA_LONG:
        				long l;
        				try{
        					l=Long.parseLong(line.getOptionValue(val).toString());
        				} catch(Exception e) {l=0;}
        				prop.setValueCli(key, new TSLong(l));
        				break;
        			default:
        				logger.warn("unknown type <"+valType+"> for <"+key+">");
        		}
        	}
        }
	}
}