/* Copyright (c) 2009-2011 Sven van der Meer
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
 *       documentation and/or other materials provided with the distribution.
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

package org.skb.lang.pola.proto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.log4j.Logger;
import org.skb.lang.pola.proto.constants.PolaConstants;
import org.skb.lang.pola.proto.grammars.polaAst;
import org.skb.lang.pola.proto.grammars.polaEbnfLexer;
import org.skb.lang.pola.proto.grammars.polaEbnfParser;
import org.skb.lang.pola.proto.grammars.polaGen;
import org.skb.tribe.LanguageConfiguration;
import org.skb.tribe.LanguageParser;
import org.skb.tribe.LanguageProperties;
import org.skb.tribe.TargetSTG;
import org.skb.tribe.TribeProperties;
import org.skb.util.io.files.FileManager;
import org.skb.util.io.files.FileTemplateList;
import org.skb.util.misc.ReportManager;
import org.skb.util.stringtemplate.STGManager;
import org.skb.util.types.TSRepository;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.atomic.java.TSBoolean;
import org.skb.util.types.atomic.util.TSArrayListString;
import org.skb.util.types.composite.util.TSMapLH;
import org.skb.util.types.composite.util.TSPropertyMap;

/**
 * The core of the Pola parser implementing the whole parsing process.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class PolaParser extends LanguageParser{
	static Logger logger = Logger.getLogger(PolaParser.class);

	private TargetSTG target;
	private PolaStatistics stats;

	public TSPropertyMap getMap(){
		return LanguageProperties.getInstance().getMap();
	}

	public PolaParser(){
		this.xs="pola";
		this.xt=new TSArrayListString();

		LanguageConfiguration cfg=LanguageConfiguration.getInstanceInit();
		cfg.read("/org/skb/lang/pola/proto/proto.json");

		Set<String> lang=cfg.getLanguageTargets().keySet();
		Iterator<String> it=lang.iterator();
		while(it.hasNext())
			this.xt.add(it.next().toString());
	}

	public void setOptions(){
		logger.trace("setOptions -- in");
		LanguageProperties lp=LanguageProperties.getInstance();
		lp.setClassName(PolaConstants.Properties.class.getName());
		lp.setKey("key");
		lp.setOptions();
		super.setOptions();
		logger.trace("setOptions -- out");
	}

	public void parse(InputStream is){
		ReportManager repMgr=ReportManager.getInstance();

		try {
			ANTLRInputStream input = new ANTLRInputStream(is);

			polaEbnfLexer lexer=new polaEbnfLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			polaEbnfParser parser = new polaEbnfParser(tokens);
			polaEbnfParser.polaSpecification_return fromEbnf=parser.polaSpecification();

			int ret=repMgr.noOfErrors();
			String msg=ret+" error";
			if (ret == 0 || ret > 1)
				msg+="s";
			if (ret > 0) {
				msg+=", exiting at pass 1";
				repMgr.reportError(msg);
				System.exit(1);
			}
			else
				msg+=" in pass 1 (Syntax Check)";
			repMgr.reportMessageNoFile(msg);

			repMgr.resetNoOfErrors();
			CommonTree treeForAst=(CommonTree)fromEbnf.getTree();
			CommonTreeNodeStream nodesForAst = new CommonTreeNodeStream(treeForAst);
			nodesForAst.setTokenStream(tokens);
			polaAst ast = new polaAst(nodesForAst);

			polaAst.polaSpecification_return fromAst = ast.polaSpecification();
			ret=repMgr.noOfErrors();
			msg=ret+" error";
			if (ret == 0 || ret > 1)
				msg+="s";
			if (ret > 0) {
				msg+=", exiting at pass 2";
				repMgr.reportError(msg);
				System.exit(1);
			}
			else
				msg+=" in pass 2 (Semantic Check)";
			repMgr.reportMessageNoFile(msg);

			this.stats=new PolaStatistics();

			TSBase ata=this.prop.getValue(PolaConstants.Properties.keyPrStat);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.genSimpleStats();
			ata=this.prop.getValue(PolaConstants.Properties.keyPrStatAll);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.genCompleteStats();

			ata=this.prop.getValue(TribeProperties.tpmKeyGC);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true){
				//repMgr.resetNoOfErrors();
				CommonTree treeForGen=(CommonTree)fromAst.getTree();
				CommonTreeNodeStream nodesForGen = new CommonTreeNodeStream(treeForGen);
				nodesForGen.setTokenStream(tokens);
				polaGen gen = new polaGen(nodesForGen);

				gen.setTemplateLib(this.stgl.getSTG());
				gen.polaSpecification();

				msg="success  in pass 3 (Code Generation)";
				repMgr.reportMessageNoFile(msg);
				PolaPass4_Files cfm=new PolaPass4_Files();

				FileTemplateList ftl=cfm.getFileTemplateList();
				ftl.init(TribeProperties.getInstance().getValue(TribeProperties.tpmKeyTgtDir));

				FileManager fm=new FileManager(this.target.getStdHeaderST(), this.target.getFileStartST(), this.target.getFileEndST());
				fm.init(TribeProperties.getInstance().getValue(TribeProperties.tpmKeySrcLanguage),
						TribeProperties.getInstance().getValue(TribeProperties.tpmKeySrcFile),
						TribeProperties.getInstance().getValue(TribeProperties.tpmKeyTgtLanguage),
						TribeProperties.getInstance().getValue(TribeProperties.tpmKeyTgtFileExt),
						TribeProperties.getInstance().getValue(TribeProperties.tpmKeyGC));
				fm.writeList(ftl);
				msg="success  in pass 4 (Write Files)";
				repMgr.reportMessageNoFile(msg);
			}
			// print stats if wanted
			ata=this.prop.getValue(PolaConstants.Properties.keyPrStat);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.printSimpleStatistic();
			ata=this.prop.getValue(PolaConstants.Properties.keyPrStatAll);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.printCompleteStatistic();

		 } catch (IOException io) {repMgr.reportError("catched exception while parsing", "IOException: " + io.toString());}
		   catch (Exception e)    {repMgr.reportError("catched exception while parsing", "Exception: " + e.toString());
		}
	}

	public void loadTarget(){
		if(TribeProperties.getInstance().getValue(TribeProperties.tpmKeyTgtLanguage)!=null)
			this.target=new TargetSTG();	
	}

	public void loadStg(){
		this.stgl=new STGManager();
		TSBase obt=TribeProperties.getInstance().getValue(TribeProperties.tpmKeyTgtStgAngleBr);
		Boolean _t=false;
		if(obt.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN))
			_t=((TSBoolean)obt).tsvalue;

		if(Boolean.TRUE.equals(_t))
			this.stgl.useLexerAngelB();
		else
			this.stgl.useLexerDefault();

		this.stgl.setApplicationName(prop.getValue(TribeProperties.tpmKeyNameLC));
		this.stgl.setSTGFileName(prop.getValueCli(TribeProperties.tpmKeyTgtStg));
		this.stgl.setSTGUrlName(prop.getValueDefault(TribeProperties.tpmKeyTgtStg));
		this.stgl.loadSTG("code generation", prop.getValue(TribeProperties.tpmKeyTgtLanguage));

		TSMapLH chMan=this.target.getMandatory();
		TSMapLH chOpt=this.target.getOptional();
		this.stgl.setChunks(chMan, chOpt);
		if(this.stgl.testChunks()==false)
			System.exit(-10);
	}

	public void printStg(){
		if(this.stgl!=null)
			System.out.println(this.stgl.getSTG().toString());
	}

	@Override
	public void tsClean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TEnum tsGetTypeEnum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TEnum> tsGetTypeEnumSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String tsGetTypeString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> tsGetTypeStringList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean tsIsAtomic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tsIsComposite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tsIsType(String t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tsIsType(TEnum t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void tsPlus(TSBase tb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String tsToString(int indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tsTrim() {
		// TODO Auto-generated method stub
		
	}
}
