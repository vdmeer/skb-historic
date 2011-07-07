// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g 2011-07-07 22:25:03

  package org.skb.lang.glue.proto.grammars;

  import java.util.ArrayList;
  import java.util.LinkedHashMap;

  import org.skb.util.languages.AtomList;
  import org.skb.util.languages.ScopeToken;
  import org.skb.lang.glue.proto.GluePass3_Gen;
  import org.skb.lang.glue.proto.GlueTokensConstants;
  import org.skb.util.ReportManager;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
public class glueGen extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AT_SPEC", "IDENT", "TOPOLOGY", "DOMAIN", "NODE", "CONNECTION", "DIRECTED", "SOURCE", "TARGET", "PORT", "SOURCEPORT", "TARGETPORT", "COMPONENT", "CONTRACTS", "POLICIES", "VAL_STRING", "VAL_XSTRING", "INTERFACE", "AT_SCOPE", "AT_LANG", "AT_KVL", "WS", "SL_COMMENT", "ML_COMMENT", "ESC", "VAL_CHAR", "UnicodeEscape", "OctalEscape", "HexDigit", "VAL_HEX", "';'", "'['", "']'", "'{'", "'}'", "'='", "'::'", "'@'"
    };
    public static final int EOF=-1;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int AT_SPEC=4;
    public static final int IDENT=5;
    public static final int TOPOLOGY=6;
    public static final int DOMAIN=7;
    public static final int NODE=8;
    public static final int CONNECTION=9;
    public static final int DIRECTED=10;
    public static final int SOURCE=11;
    public static final int TARGET=12;
    public static final int PORT=13;
    public static final int SOURCEPORT=14;
    public static final int TARGETPORT=15;
    public static final int COMPONENT=16;
    public static final int CONTRACTS=17;
    public static final int POLICIES=18;
    public static final int VAL_STRING=19;
    public static final int VAL_XSTRING=20;
    public static final int INTERFACE=21;
    public static final int AT_SCOPE=22;
    public static final int AT_LANG=23;
    public static final int AT_KVL=24;
    public static final int WS=25;
    public static final int SL_COMMENT=26;
    public static final int ML_COMMENT=27;
    public static final int ESC=28;
    public static final int VAL_CHAR=29;
    public static final int UnicodeEscape=30;
    public static final int OctalEscape=31;
    public static final int HexDigit=32;
    public static final int VAL_HEX=33;

    // delegates
    // delegators


        public glueGen(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public glueGen(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected StringTemplateGroup templateLib =
      new StringTemplateGroup("glueGenTemplates", AngleBracketTemplateLexer.class);

    public void setTemplateLib(StringTemplateGroup templateLib) {
      this.templateLib = templateLib;
    }
    public StringTemplateGroup getTemplateLib() {
      return templateLib;
    }
    /** allows convenient multi-value initialization:
     *  "new STAttrMap().put(...).put(...)"
     */
    public static class STAttrMap extends HashMap {
      public STAttrMap put(String attrName, Object value) {
        super.put(attrName, value);
        return this;
      }
      public STAttrMap put(String attrName, int value) {
        super.put(attrName, new Integer(value));
        return this;
      }
    }

    public String[] getTokenNames() { return glueGen.tokenNames; }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g"; }


      private GluePass3_Gen pass;

      public void init() {
        this.pass=new GluePass3_Gen();
      }


    public static class glueSpecification_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "glueSpecification"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:73:1: glueSpecification : ^( AT_SPEC s= IDENT (def+= glueTopology )* ) -> template(specification=spectoken=$def) \"<specification>\\n\\n<token>\";
    public final glueGen.glueSpecification_return glueSpecification() throws RecognitionException {
        glueGen.glueSpecification_return retval = new glueGen.glueSpecification_return();
        retval.start = input.LT(1);

        CommonTree s=null;
        List list_def=null;
        RuleReturnScope def = null;
        this.init();
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:77:25: ( ^( AT_SPEC s= IDENT (def+= glueTopology )* ) -> template(specification=spectoken=$def) \"<specification>\\n\\n<token>\")
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:77:27: ^( AT_SPEC s= IDENT (def+= glueTopology )* )
            {
            match(input,AT_SPEC,FOLLOW_AT_SPEC_in_glueSpecification94); 

            match(input, Token.DOWN, null); 
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueSpecification98); 
            StringTemplate spec=templateLib.getInstanceOf("glueSpecification");
                                        spec.setAttribute("id", s);
            //                            this.pass.atoms.addST(ColaTokens.colaSPECIFICATION,spec);
                                       
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:82:28: (def+= glueTopology )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TOPOLOGY) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:82:29: def+= glueTopology
            	    {
            	    pushFollow(FOLLOW_glueTopology_in_glueSpecification159);
            	    def=glueTopology();

            	    state._fsp--;

            	    if (list_def==null) list_def=new ArrayList();
            	    list_def.add(def.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input, Token.UP, null); 

            spec.setAttribute("body", list_def);
            System.out.println(spec);



            // TEMPLATE REWRITE
            // 88:27: -> template(specification=spectoken=$def) \"<specification>\\n\\n<token>\"
            {
                retval.st = new StringTemplate(templateLib, "<specification>\\n\\n<token>",
              new STAttrMap().put("specification", spec).put("token", list_def));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueSpecification"

    public static class glueTopology_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "glueTopology"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:1: glueTopology : ^( TOPOLOGY (id= IDENT )? (snl= scoped_name_lang )? (d+= glueDomain )* (n+= glueNode )* (c+= glueConnection )* ) -> glueTopology(id=$id.textidlang=$snl.stdomains=$dnodes=$nconnections=$c);
    public final glueGen.glueTopology_return glueTopology() throws RecognitionException {
        glueGen.glueTopology_return retval = new glueGen.glueTopology_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_d=null;
        List list_n=null;
        List list_c=null;
        glueGen.scoped_name_lang_return snl = null;

        RuleReturnScope d = null;
        RuleReturnScope n = null;
        RuleReturnScope c = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:20: ( ^( TOPOLOGY (id= IDENT )? (snl= scoped_name_lang )? (d+= glueDomain )* (n+= glueNode )* (c+= glueConnection )* ) -> glueTopology(id=$id.textidlang=$snl.stdomains=$dnodes=$nconnections=$c))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:22: ^( TOPOLOGY (id= IDENT )? (snl= scoped_name_lang )? (d+= glueDomain )* (n+= glueNode )* (c+= glueConnection )* )
            {
            match(input,TOPOLOGY,FOLLOW_TOPOLOGY_in_glueTopology250); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:33: (id= IDENT )?
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENT) ) {
                    alt2=1;
                }
                switch (alt2) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:34: id= IDENT
                        {
                        id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueTopology255); 

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:45: (snl= scoped_name_lang )?
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==AT_LANG) ) {
                    alt3=1;
                }
                switch (alt3) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:46: snl= scoped_name_lang
                        {
                        pushFollow(FOLLOW_scoped_name_lang_in_glueTopology262);
                        snl=scoped_name_lang();

                        state._fsp--;


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:69: (d+= glueDomain )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==DOMAIN) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:70: d+= glueDomain
                	    {
                	    pushFollow(FOLLOW_glueDomain_in_glueTopology269);
                	    d=glueDomain();

                	    state._fsp--;

                	    if (list_d==null) list_d=new ArrayList();
                	    list_d.add(d.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop4;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:86: (n+= glueNode )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==NODE) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:87: n+= glueNode
                	    {
                	    pushFollow(FOLLOW_glueNode_in_glueTopology276);
                	    n=glueNode();

                	    state._fsp--;

                	    if (list_n==null) list_n=new ArrayList();
                	    list_n.add(n.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop5;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:101: (c+= glueConnection )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==CONNECTION) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:92:102: c+= glueConnection
                	    {
                	    pushFollow(FOLLOW_glueConnection_in_glueTopology283);
                	    c=glueConnection();

                	    state._fsp--;

                	    if (list_c==null) list_c=new ArrayList();
                	    list_c.add(c.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop6;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            // TEMPLATE REWRITE
            // 93:22: -> glueTopology(id=$id.textidlang=$snl.stdomains=$dnodes=$nconnections=$c)
            {
                retval.st = templateLib.getInstanceOf("glueTopology",
              new STAttrMap().put("id", (id!=null?id.getText():null)).put("idlang", (snl!=null?snl.st:null)).put("domains", list_d).put("nodes", list_n).put("connections", list_c));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueTopology"

    public static class glueDomain_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "glueDomain"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:1: glueDomain : ^( DOMAIN (id= IDENT )? (snl= scoped_name_lang )? (dom+= glueDomain )* (node+= glueNode )* (conn+= glueConnection )* (port+= gluePort )* (con+= glueContracts )? (pol+= gluePolicies )? (kvl+= key_value_list )? ) -> glueDomain(id=$id.textidlang=$snl.stdomains=$domnodes=$nodeconnections=$connports=$portcontracts=$conpolicies=$polkvl=$kvl);
    public final glueGen.glueDomain_return glueDomain() throws RecognitionException {
        glueGen.glueDomain_return retval = new glueGen.glueDomain_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_dom=null;
        List list_node=null;
        List list_conn=null;
        List list_port=null;
        List list_con=null;
        List list_pol=null;
        List list_kvl=null;
        glueGen.scoped_name_lang_return snl = null;

        RuleReturnScope dom = null;
        RuleReturnScope node = null;
        RuleReturnScope conn = null;
        RuleReturnScope port = null;
        RuleReturnScope con = null;
        RuleReturnScope pol = null;
        RuleReturnScope kvl = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:20: ( ^( DOMAIN (id= IDENT )? (snl= scoped_name_lang )? (dom+= glueDomain )* (node+= glueNode )* (conn+= glueConnection )* (port+= gluePort )* (con+= glueContracts )? (pol+= gluePolicies )? (kvl+= key_value_list )? ) -> glueDomain(id=$id.textidlang=$snl.stdomains=$domnodes=$nodeconnections=$connports=$portcontracts=$conpolicies=$polkvl=$kvl))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:22: ^( DOMAIN (id= IDENT )? (snl= scoped_name_lang )? (dom+= glueDomain )* (node+= glueNode )* (conn+= glueConnection )* (port+= gluePort )* (con+= glueContracts )? (pol+= gluePolicies )? (kvl+= key_value_list )? )
            {
            match(input,DOMAIN,FOLLOW_DOMAIN_in_glueDomain353); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:31: (id= IDENT )?
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENT) ) {
                    alt7=1;
                }
                switch (alt7) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:32: id= IDENT
                        {
                        id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueDomain358); 

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:43: (snl= scoped_name_lang )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==AT_LANG) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:44: snl= scoped_name_lang
                        {
                        pushFollow(FOLLOW_scoped_name_lang_in_glueDomain365);
                        snl=scoped_name_lang();

                        state._fsp--;


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:67: (dom+= glueDomain )*
                loop9:
                do {
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==DOMAIN) ) {
                        alt9=1;
                    }


                    switch (alt9) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:68: dom+= glueDomain
                	    {
                	    pushFollow(FOLLOW_glueDomain_in_glueDomain372);
                	    dom=glueDomain();

                	    state._fsp--;

                	    if (list_dom==null) list_dom=new ArrayList();
                	    list_dom.add(dom.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop9;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:86: (node+= glueNode )*
                loop10:
                do {
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==NODE) ) {
                        alt10=1;
                    }


                    switch (alt10) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:87: node+= glueNode
                	    {
                	    pushFollow(FOLLOW_glueNode_in_glueDomain379);
                	    node=glueNode();

                	    state._fsp--;

                	    if (list_node==null) list_node=new ArrayList();
                	    list_node.add(node.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop10;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:104: (conn+= glueConnection )*
                loop11:
                do {
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==CONNECTION) ) {
                        alt11=1;
                    }


                    switch (alt11) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:105: conn+= glueConnection
                	    {
                	    pushFollow(FOLLOW_glueConnection_in_glueDomain386);
                	    conn=glueConnection();

                	    state._fsp--;

                	    if (list_conn==null) list_conn=new ArrayList();
                	    list_conn.add(conn.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop11;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:128: (port+= gluePort )*
                loop12:
                do {
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==PORT) ) {
                        alt12=1;
                    }


                    switch (alt12) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:129: port+= gluePort
                	    {
                	    pushFollow(FOLLOW_gluePort_in_glueDomain393);
                	    port=gluePort();

                	    state._fsp--;

                	    if (list_port==null) list_port=new ArrayList();
                	    list_port.add(port.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop12;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:146: (con+= glueContracts )?
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==CONTRACTS) ) {
                    alt13=1;
                }
                switch (alt13) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:147: con+= glueContracts
                        {
                        pushFollow(FOLLOW_glueContracts_in_glueDomain400);
                        con=glueContracts();

                        state._fsp--;

                        if (list_con==null) list_con=new ArrayList();
                        list_con.add(con.getTemplate());


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:168: (pol+= gluePolicies )?
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==POLICIES) ) {
                    alt14=1;
                }
                switch (alt14) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:169: pol+= gluePolicies
                        {
                        pushFollow(FOLLOW_gluePolicies_in_glueDomain407);
                        pol=gluePolicies();

                        state._fsp--;

                        if (list_pol==null) list_pol=new ArrayList();
                        list_pol.add(pol.getTemplate());


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:189: (kvl+= key_value_list )?
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==AT_KVL) ) {
                    alt15=1;
                }
                switch (alt15) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:95:190: kvl+= key_value_list
                        {
                        pushFollow(FOLLOW_key_value_list_in_glueDomain414);
                        kvl=key_value_list();

                        state._fsp--;

                        if (list_kvl==null) list_kvl=new ArrayList();
                        list_kvl.add(kvl.getTemplate());


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            // TEMPLATE REWRITE
            // 96:22: -> glueDomain(id=$id.textidlang=$snl.stdomains=$domnodes=$nodeconnections=$connports=$portcontracts=$conpolicies=$polkvl=$kvl)
            {
                retval.st = templateLib.getInstanceOf("glueDomain",
              new STAttrMap().put("id", (id!=null?id.getText():null)).put("idlang", (snl!=null?snl.st:null)).put("domains", list_dom).put("nodes", list_node).put("connections", list_conn).put("ports", list_port).put("contracts", list_con).put("policies", list_pol).put("kvl", list_kvl));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueDomain"

    public static class glueNode_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "glueNode"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:1: glueNode : ^( NODE (id= IDENT )? (snl= scoped_name_lang )? (com+= glueComponent )* (con+= glueConnection )* (p+= gluePort )* (con+= glueContracts )? (pol+= gluePolicies )? (kvl+= key_value_list )? ) -> glueNode(id=$id.textidlang=$snl.stcomponents=$comconnections=$conports=$pcontracts=$conpolicies=$polkvl=$kvl);
    public final glueGen.glueNode_return glueNode() throws RecognitionException {
        glueGen.glueNode_return retval = new glueGen.glueNode_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_com=null;
        List list_con=null;
        List list_p=null;
        List list_pol=null;
        List list_kvl=null;
        glueGen.scoped_name_lang_return snl = null;

        RuleReturnScope com = null;
        RuleReturnScope con = null;
        RuleReturnScope p = null;
        RuleReturnScope pol = null;
        RuleReturnScope kvl = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:20: ( ^( NODE (id= IDENT )? (snl= scoped_name_lang )? (com+= glueComponent )* (con+= glueConnection )* (p+= gluePort )* (con+= glueContracts )? (pol+= gluePolicies )? (kvl+= key_value_list )? ) -> glueNode(id=$id.textidlang=$snl.stcomponents=$comconnections=$conports=$pcontracts=$conpolicies=$polkvl=$kvl))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:22: ^( NODE (id= IDENT )? (snl= scoped_name_lang )? (com+= glueComponent )* (con+= glueConnection )* (p+= gluePort )* (con+= glueContracts )? (pol+= gluePolicies )? (kvl+= key_value_list )? )
            {
            match(input,NODE,FOLLOW_NODE_in_glueNode506); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:29: (id= IDENT )?
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==IDENT) ) {
                    alt16=1;
                }
                switch (alt16) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:30: id= IDENT
                        {
                        id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueNode511); 

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:41: (snl= scoped_name_lang )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==AT_LANG) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:42: snl= scoped_name_lang
                        {
                        pushFollow(FOLLOW_scoped_name_lang_in_glueNode518);
                        snl=scoped_name_lang();

                        state._fsp--;


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:65: (com+= glueComponent )*
                loop18:
                do {
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==COMPONENT) ) {
                        alt18=1;
                    }


                    switch (alt18) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:66: com+= glueComponent
                	    {
                	    pushFollow(FOLLOW_glueComponent_in_glueNode525);
                	    com=glueComponent();

                	    state._fsp--;

                	    if (list_com==null) list_com=new ArrayList();
                	    list_com.add(com.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop18;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:87: (con+= glueConnection )*
                loop19:
                do {
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==CONNECTION) ) {
                        alt19=1;
                    }


                    switch (alt19) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:88: con+= glueConnection
                	    {
                	    pushFollow(FOLLOW_glueConnection_in_glueNode532);
                	    con=glueConnection();

                	    state._fsp--;

                	    if (list_con==null) list_con=new ArrayList();
                	    list_con.add(con.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop19;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:110: (p+= gluePort )*
                loop20:
                do {
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==PORT) ) {
                        alt20=1;
                    }


                    switch (alt20) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:111: p+= gluePort
                	    {
                	    pushFollow(FOLLOW_gluePort_in_glueNode539);
                	    p=gluePort();

                	    state._fsp--;

                	    if (list_p==null) list_p=new ArrayList();
                	    list_p.add(p.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop20;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:125: (con+= glueContracts )?
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==CONTRACTS) ) {
                    alt21=1;
                }
                switch (alt21) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:126: con+= glueContracts
                        {
                        pushFollow(FOLLOW_glueContracts_in_glueNode546);
                        con=glueContracts();

                        state._fsp--;

                        if (list_con==null) list_con=new ArrayList();
                        list_con.add(con.getTemplate());


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:147: (pol+= gluePolicies )?
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==POLICIES) ) {
                    alt22=1;
                }
                switch (alt22) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:148: pol+= gluePolicies
                        {
                        pushFollow(FOLLOW_gluePolicies_in_glueNode553);
                        pol=gluePolicies();

                        state._fsp--;

                        if (list_pol==null) list_pol=new ArrayList();
                        list_pol.add(pol.getTemplate());


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:168: (kvl+= key_value_list )?
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==AT_KVL) ) {
                    alt23=1;
                }
                switch (alt23) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:98:169: kvl+= key_value_list
                        {
                        pushFollow(FOLLOW_key_value_list_in_glueNode560);
                        kvl=key_value_list();

                        state._fsp--;

                        if (list_kvl==null) list_kvl=new ArrayList();
                        list_kvl.add(kvl.getTemplate());


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            // TEMPLATE REWRITE
            // 99:22: -> glueNode(id=$id.textidlang=$snl.stcomponents=$comconnections=$conports=$pcontracts=$conpolicies=$polkvl=$kvl)
            {
                retval.st = templateLib.getInstanceOf("glueNode",
              new STAttrMap().put("id", (id!=null?id.getText():null)).put("idlang", (snl!=null?snl.st:null)).put("components", list_com).put("connections", list_con).put("ports", list_p).put("contracts", list_con).put("policies", list_pol).put("kvl", list_kvl));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueNode"

    public static class glueConnection_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "glueConnection"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:101:1: glueConnection : ^( CONNECTION id= IDENT ( DIRECTED )? src+= glueSource tgt+= glueTarget ) -> glueConnection(id=$id.textdirected=$DIRECTED.textsource=$srctarget=$tgt);
    public final glueGen.glueConnection_return glueConnection() throws RecognitionException {
        glueGen.glueConnection_return retval = new glueGen.glueConnection_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        CommonTree DIRECTED1=null;
        List list_src=null;
        List list_tgt=null;
        RuleReturnScope src = null;
        RuleReturnScope tgt = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:101:20: ( ^( CONNECTION id= IDENT ( DIRECTED )? src+= glueSource tgt+= glueTarget ) -> glueConnection(id=$id.textdirected=$DIRECTED.textsource=$srctarget=$tgt))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:101:22: ^( CONNECTION id= IDENT ( DIRECTED )? src+= glueSource tgt+= glueTarget )
            {
            match(input,CONNECTION,FOLLOW_CONNECTION_in_glueConnection641); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueConnection645); 
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:101:44: ( DIRECTED )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==DIRECTED) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:101:44: DIRECTED
                    {
                    DIRECTED1=(CommonTree)match(input,DIRECTED,FOLLOW_DIRECTED_in_glueConnection647); 

                    }
                    break;

            }

            pushFollow(FOLLOW_glueSource_in_glueConnection652);
            src=glueSource();

            state._fsp--;

            if (list_src==null) list_src=new ArrayList();
            list_src.add(src.getTemplate());

            pushFollow(FOLLOW_glueTarget_in_glueConnection656);
            tgt=glueTarget();

            state._fsp--;

            if (list_tgt==null) list_tgt=new ArrayList();
            list_tgt.add(tgt.getTemplate());


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 102:22: -> glueConnection(id=$id.textdirected=$DIRECTED.textsource=$srctarget=$tgt)
            {
                retval.st = templateLib.getInstanceOf("glueConnection",
              new STAttrMap().put("id", (id!=null?id.getText():null)).put("directed", (DIRECTED1!=null?DIRECTED1.getText():null)).put("source", list_src).put("target", list_tgt));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueConnection"

    public static class glueSource_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "glueSource"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:104:1: glueSource : ^( SOURCE sn= scoped_name (src+= glueSourcePort )? ) -> glueSource(id=$sn.stsourceport=$src);
    public final glueGen.glueSource_return glueSource() throws RecognitionException {
        glueGen.glueSource_return retval = new glueGen.glueSource_return();
        retval.start = input.LT(1);

        List list_src=null;
        glueGen.scoped_name_return sn = null;

        RuleReturnScope src = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:104:20: ( ^( SOURCE sn= scoped_name (src+= glueSourcePort )? ) -> glueSource(id=$sn.stsourceport=$src))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:104:22: ^( SOURCE sn= scoped_name (src+= glueSourcePort )? )
            {
            match(input,SOURCE,FOLLOW_SOURCE_in_glueSource719); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_scoped_name_in_glueSource723);
            sn=scoped_name();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:104:46: (src+= glueSourcePort )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==SOURCEPORT) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:104:47: src+= glueSourcePort
                    {
                    pushFollow(FOLLOW_glueSourcePort_in_glueSource728);
                    src=glueSourcePort();

                    state._fsp--;

                    if (list_src==null) list_src=new ArrayList();
                    list_src.add(src.getTemplate());


                    }
                    break;

            }


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 105:22: -> glueSource(id=$sn.stsourceport=$src)
            {
                retval.st = templateLib.getInstanceOf("glueSource",
              new STAttrMap().put("id", (sn!=null?sn.st:null)).put("sourceport", list_src));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueSource"

    public static class glueTarget_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "glueTarget"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:106:1: glueTarget : ^( TARGET sn= scoped_name (tgt+= glueTargetPort )? ) -> glueTarget(id=$sn.sttargetport=$tgt);
    public final glueGen.glueTarget_return glueTarget() throws RecognitionException {
        glueGen.glueTarget_return retval = new glueGen.glueTarget_return();
        retval.start = input.LT(1);

        List list_tgt=null;
        glueGen.scoped_name_return sn = null;

        RuleReturnScope tgt = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:106:20: ( ^( TARGET sn= scoped_name (tgt+= glueTargetPort )? ) -> glueTarget(id=$sn.sttargetport=$tgt))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:106:22: ^( TARGET sn= scoped_name (tgt+= glueTargetPort )? )
            {
            match(input,TARGET,FOLLOW_TARGET_in_glueTarget782); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_scoped_name_in_glueTarget786);
            sn=scoped_name();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:106:46: (tgt+= glueTargetPort )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==TARGETPORT) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:106:47: tgt+= glueTargetPort
                    {
                    pushFollow(FOLLOW_glueTargetPort_in_glueTarget791);
                    tgt=glueTargetPort();

                    state._fsp--;

                    if (list_tgt==null) list_tgt=new ArrayList();
                    list_tgt.add(tgt.getTemplate());


                    }
                    break;

            }


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 107:22: -> glueTarget(id=$sn.sttargetport=$tgt)
            {
                retval.st = templateLib.getInstanceOf("glueTarget",
              new STAttrMap().put("id", (sn!=null?sn.st:null)).put("targetport", list_tgt));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueTarget"

    public static class gluePort_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "gluePort"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:109:1: gluePort : ^( PORT id= IDENT ) -> gluePort(id=$id);
    public final glueGen.gluePort_return gluePort() throws RecognitionException {
        glueGen.gluePort_return retval = new glueGen.gluePort_return();
        retval.start = input.LT(1);

        CommonTree id=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:109:20: ( ^( PORT id= IDENT ) -> gluePort(id=$id))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:109:22: ^( PORT id= IDENT )
            {
            match(input,PORT,FOLLOW_PORT_in_gluePort848); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_gluePort852); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 110:22: -> gluePort(id=$id)
            {
                retval.st = templateLib.getInstanceOf("gluePort",
              new STAttrMap().put("id", id));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gluePort"

    public static class glueSourcePort_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "glueSourcePort"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:112:1: glueSourcePort : ^( SOURCEPORT sn= scoped_name ) -> glueSourcePort(id=$sn.st);
    public final glueGen.glueSourcePort_return glueSourcePort() throws RecognitionException {
        glueGen.glueSourcePort_return retval = new glueGen.glueSourcePort_return();
        retval.start = input.LT(1);

        glueGen.scoped_name_return sn = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:112:20: ( ^( SOURCEPORT sn= scoped_name ) -> glueSourcePort(id=$sn.st))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:112:22: ^( SOURCEPORT sn= scoped_name )
            {
            match(input,SOURCEPORT,FOLLOW_SOURCEPORT_in_glueSourcePort896); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_scoped_name_in_glueSourcePort900);
            sn=scoped_name();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 113:22: -> glueSourcePort(id=$sn.st)
            {
                retval.st = templateLib.getInstanceOf("glueSourcePort",
              new STAttrMap().put("id", (sn!=null?sn.st:null)));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueSourcePort"

    public static class glueTargetPort_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "glueTargetPort"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:115:1: glueTargetPort : ^( TARGETPORT sn= scoped_name ) -> glueTargetPort(id=$sn.st);
    public final glueGen.glueTargetPort_return glueTargetPort() throws RecognitionException {
        glueGen.glueTargetPort_return retval = new glueGen.glueTargetPort_return();
        retval.start = input.LT(1);

        glueGen.scoped_name_return sn = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:115:20: ( ^( TARGETPORT sn= scoped_name ) -> glueTargetPort(id=$sn.st))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:115:22: ^( TARGETPORT sn= scoped_name )
            {
            match(input,TARGETPORT,FOLLOW_TARGETPORT_in_glueTargetPort944); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_scoped_name_in_glueTargetPort948);
            sn=scoped_name();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 116:22: -> glueTargetPort(id=$sn.st)
            {
                retval.st = templateLib.getInstanceOf("glueTargetPort",
              new STAttrMap().put("id", (sn!=null?sn.st:null)));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueTargetPort"

    public static class glueComponent_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "glueComponent"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:1: glueComponent : ^( COMPONENT (id= IDENT )? (snl= scoped_name_lang )? (p+= gluePort )* (con+= glueContracts )? (pol+= gluePolicies )? (kvl+= key_value_list )? ) -> glueComponent(id=$id.textidlang=$snl.stports=$pcontracts=$conpolicies=$polkvl=$kvl);
    public final glueGen.glueComponent_return glueComponent() throws RecognitionException {
        glueGen.glueComponent_return retval = new glueGen.glueComponent_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_p=null;
        List list_con=null;
        List list_pol=null;
        List list_kvl=null;
        glueGen.scoped_name_lang_return snl = null;

        RuleReturnScope p = null;
        RuleReturnScope con = null;
        RuleReturnScope pol = null;
        RuleReturnScope kvl = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:20: ( ^( COMPONENT (id= IDENT )? (snl= scoped_name_lang )? (p+= gluePort )* (con+= glueContracts )? (pol+= gluePolicies )? (kvl+= key_value_list )? ) -> glueComponent(id=$id.textidlang=$snl.stports=$pcontracts=$conpolicies=$polkvl=$kvl))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:22: ^( COMPONENT (id= IDENT )? (snl= scoped_name_lang )? (p+= gluePort )* (con+= glueContracts )? (pol+= gluePolicies )? (kvl+= key_value_list )? )
            {
            match(input,COMPONENT,FOLLOW_COMPONENT_in_glueComponent993); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:34: (id= IDENT )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDENT) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:35: id= IDENT
                        {
                        id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueComponent998); 

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:46: (snl= scoped_name_lang )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==AT_LANG) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:47: snl= scoped_name_lang
                        {
                        pushFollow(FOLLOW_scoped_name_lang_in_glueComponent1005);
                        snl=scoped_name_lang();

                        state._fsp--;


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:70: (p+= gluePort )*
                loop29:
                do {
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==PORT) ) {
                        alt29=1;
                    }


                    switch (alt29) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:71: p+= gluePort
                	    {
                	    pushFollow(FOLLOW_gluePort_in_glueComponent1012);
                	    p=gluePort();

                	    state._fsp--;

                	    if (list_p==null) list_p=new ArrayList();
                	    list_p.add(p.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop29;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:85: (con+= glueContracts )?
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==CONTRACTS) ) {
                    alt30=1;
                }
                switch (alt30) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:86: con+= glueContracts
                        {
                        pushFollow(FOLLOW_glueContracts_in_glueComponent1019);
                        con=glueContracts();

                        state._fsp--;

                        if (list_con==null) list_con=new ArrayList();
                        list_con.add(con.getTemplate());


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:107: (pol+= gluePolicies )?
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==POLICIES) ) {
                    alt31=1;
                }
                switch (alt31) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:108: pol+= gluePolicies
                        {
                        pushFollow(FOLLOW_gluePolicies_in_glueComponent1026);
                        pol=gluePolicies();

                        state._fsp--;

                        if (list_pol==null) list_pol=new ArrayList();
                        list_pol.add(pol.getTemplate());


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:128: (kvl+= key_value_list )?
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==AT_KVL) ) {
                    alt32=1;
                }
                switch (alt32) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:118:129: kvl+= key_value_list
                        {
                        pushFollow(FOLLOW_key_value_list_in_glueComponent1033);
                        kvl=key_value_list();

                        state._fsp--;

                        if (list_kvl==null) list_kvl=new ArrayList();
                        list_kvl.add(kvl.getTemplate());


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            // TEMPLATE REWRITE
            // 119:22: -> glueComponent(id=$id.textidlang=$snl.stports=$pcontracts=$conpolicies=$polkvl=$kvl)
            {
                retval.st = templateLib.getInstanceOf("glueComponent",
              new STAttrMap().put("id", (id!=null?id.getText():null)).put("idlang", (snl!=null?snl.st:null)).put("ports", list_p).put("contracts", list_con).put("policies", list_pol).put("kvl", list_kvl));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueComponent"

    public static class glueContracts_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "glueContracts"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:121:1: glueContracts : ^( CONTRACTS ( scoped_name )* ( scoped_name_lang )* ) -> template() \"<!-- Contracts TO DE DONE### -->\";
    public final glueGen.glueContracts_return glueContracts() throws RecognitionException {
        glueGen.glueContracts_return retval = new glueGen.glueContracts_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:121:20: ( ^( CONTRACTS ( scoped_name )* ( scoped_name_lang )* ) -> template() \"<!-- Contracts TO DE DONE### -->\")
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:121:22: ^( CONTRACTS ( scoped_name )* ( scoped_name_lang )* )
            {
            match(input,CONTRACTS,FOLLOW_CONTRACTS_in_glueContracts1105); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:121:34: ( scoped_name )*
                loop33:
                do {
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==AT_SCOPE) ) {
                        alt33=1;
                    }


                    switch (alt33) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:121:34: scoped_name
                	    {
                	    pushFollow(FOLLOW_scoped_name_in_glueContracts1107);
                	    scoped_name();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop33;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:121:47: ( scoped_name_lang )*
                loop34:
                do {
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==AT_LANG) ) {
                        alt34=1;
                    }


                    switch (alt34) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:121:47: scoped_name_lang
                	    {
                	    pushFollow(FOLLOW_scoped_name_lang_in_glueContracts1110);
                	    scoped_name_lang();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop34;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            // TEMPLATE REWRITE
            // 121:66: -> template() \"<!-- Contracts TO DE DONE### -->\"
            {
                retval.st = new StringTemplate(templateLib, "<!-- Contracts TO DE DONE### -->");
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueContracts"

    public static class gluePolicies_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "gluePolicies"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:123:1: gluePolicies : ^( POLICIES ( scoped_name )* ( scoped_name_lang )* ) -> template() \"<!-- Policies TO DE DONE### -->\";
    public final glueGen.gluePolicies_return gluePolicies() throws RecognitionException {
        glueGen.gluePolicies_return retval = new glueGen.gluePolicies_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:123:20: ( ^( POLICIES ( scoped_name )* ( scoped_name_lang )* ) -> template() \"<!-- Policies TO DE DONE### -->\")
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:123:22: ^( POLICIES ( scoped_name )* ( scoped_name_lang )* )
            {
            match(input,POLICIES,FOLLOW_POLICIES_in_gluePolicies1135); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:123:33: ( scoped_name )*
                loop35:
                do {
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==AT_SCOPE) ) {
                        alt35=1;
                    }


                    switch (alt35) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:123:33: scoped_name
                	    {
                	    pushFollow(FOLLOW_scoped_name_in_gluePolicies1137);
                	    scoped_name();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop35;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:123:46: ( scoped_name_lang )*
                loop36:
                do {
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==AT_LANG) ) {
                        alt36=1;
                    }


                    switch (alt36) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:123:46: scoped_name_lang
                	    {
                	    pushFollow(FOLLOW_scoped_name_lang_in_gluePolicies1140);
                	    scoped_name_lang();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop36;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            // TEMPLATE REWRITE
            // 123:65: -> template() \"<!-- Policies TO DE DONE### -->\"
            {
                retval.st = new StringTemplate(templateLib, "<!-- Policies TO DE DONE### -->");
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gluePolicies"

    public static class scoped_name_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "scoped_name"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:125:1: scoped_name : ^( AT_SCOPE (id+= IDENT )* ) -> scoped_name(id=$id);
    public final glueGen.scoped_name_return scoped_name() throws RecognitionException {
        glueGen.scoped_name_return retval = new glueGen.scoped_name_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_id=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:125:20: ( ^( AT_SCOPE (id+= IDENT )* ) -> scoped_name(id=$id))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:125:22: ^( AT_SCOPE (id+= IDENT )* )
            {
            match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_scoped_name1166); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:125:33: (id+= IDENT )*
                loop37:
                do {
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==IDENT) ) {
                        alt37=1;
                    }


                    switch (alt37) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:125:34: id+= IDENT
                	    {
                	    id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_scoped_name1171); 
                	    if (list_id==null) list_id=new ArrayList();
                	    list_id.add(id);


                	    }
                	    break;

                	default :
                	    break loop37;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            // TEMPLATE REWRITE
            // 125:47: -> scoped_name(id=$id)
            {
                retval.st = templateLib.getInstanceOf("scoped_name",
              new STAttrMap().put("id", list_id));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "scoped_name"

    public static class scoped_name_lang_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "scoped_name_lang"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:126:1: scoped_name_lang : ^( AT_LANG IDENT sn= scoped_name ) -> scoped_name_lang(sn=$sn.st);
    public final glueGen.scoped_name_lang_return scoped_name_lang() throws RecognitionException {
        glueGen.scoped_name_lang_return retval = new glueGen.scoped_name_lang_return();
        retval.start = input.LT(1);

        glueGen.scoped_name_return sn = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:126:20: ( ^( AT_LANG IDENT sn= scoped_name ) -> scoped_name_lang(sn=$sn.st))
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:126:22: ^( AT_LANG IDENT sn= scoped_name )
            {
            match(input,AT_LANG,FOLLOW_AT_LANG_in_scoped_name_lang1193); 

            match(input, Token.DOWN, null); 
            match(input,IDENT,FOLLOW_IDENT_in_scoped_name_lang1195); 
            pushFollow(FOLLOW_scoped_name_in_scoped_name_lang1199);
            sn=scoped_name();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 126:54: -> scoped_name_lang(sn=$sn.st)
            {
                retval.st = templateLib.getInstanceOf("scoped_name_lang",
              new STAttrMap().put("sn", (sn!=null?sn.st:null)));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "scoped_name_lang"

    public static class key_value_list_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "key_value_list"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:128:1: key_value_list : ^( AT_KVL ( key_value )* ) ;
    public final glueGen.key_value_list_return key_value_list() throws RecognitionException {
        glueGen.key_value_list_return retval = new glueGen.key_value_list_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:128:20: ( ^( AT_KVL ( key_value )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:128:22: ^( AT_KVL ( key_value )* )
            {
            match(input,AT_KVL,FOLLOW_AT_KVL_in_key_value_list1222); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:128:31: ( key_value )*
                loop38:
                do {
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==AT_KVL) ) {
                        alt38=1;
                    }


                    switch (alt38) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:128:31: key_value
                	    {
                	    pushFollow(FOLLOW_key_value_in_key_value_list1224);
                	    key_value();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop38;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "key_value_list"

    public static class key_value_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "key_value"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:130:1: key_value : ^( AT_KVL ^( AT_KVL ( IDENT )? ( VAL_STRING )? ) ^( AT_KVL ( VAL_XSTRING )? ( VAL_STRING )? ) ) ;
    public final glueGen.key_value_return key_value() throws RecognitionException {
        glueGen.key_value_return retval = new glueGen.key_value_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:130:20: ( ^( AT_KVL ^( AT_KVL ( IDENT )? ( VAL_STRING )? ) ^( AT_KVL ( VAL_XSTRING )? ( VAL_STRING )? ) ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:130:22: ^( AT_KVL ^( AT_KVL ( IDENT )? ( VAL_STRING )? ) ^( AT_KVL ( VAL_XSTRING )? ( VAL_STRING )? ) )
            {
            match(input,AT_KVL,FOLLOW_AT_KVL_in_key_value1244); 

            match(input, Token.DOWN, null); 
            match(input,AT_KVL,FOLLOW_AT_KVL_in_key_value1247); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:130:40: ( IDENT )?
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==IDENT) ) {
                    alt39=1;
                }
                switch (alt39) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:130:40: IDENT
                        {
                        match(input,IDENT,FOLLOW_IDENT_in_key_value1249); 

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:130:47: ( VAL_STRING )?
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==VAL_STRING) ) {
                    alt40=1;
                }
                switch (alt40) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:130:47: VAL_STRING
                        {
                        match(input,VAL_STRING,FOLLOW_VAL_STRING_in_key_value1252); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }
            match(input,AT_KVL,FOLLOW_AT_KVL_in_key_value1257); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:130:69: ( VAL_XSTRING )?
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==VAL_XSTRING) ) {
                    alt41=1;
                }
                switch (alt41) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:130:69: VAL_XSTRING
                        {
                        match(input,VAL_XSTRING,FOLLOW_VAL_XSTRING_in_key_value1259); 

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:130:82: ( VAL_STRING )?
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==VAL_STRING) ) {
                    alt42=1;
                }
                switch (alt42) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueGen.g:130:82: VAL_STRING
                        {
                        match(input,VAL_STRING,FOLLOW_VAL_STRING_in_key_value1262); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "key_value"

    // Delegated rules


 

    public static final BitSet FOLLOW_AT_SPEC_in_glueSpecification94 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueSpecification98 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_glueTopology_in_glueSpecification159 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_TOPOLOGY_in_glueTopology250 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueTopology255 = new BitSet(new long[]{0x0000000000800388L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueTopology262 = new BitSet(new long[]{0x0000000000000388L});
    public static final BitSet FOLLOW_glueDomain_in_glueTopology269 = new BitSet(new long[]{0x0000000000000388L});
    public static final BitSet FOLLOW_glueNode_in_glueTopology276 = new BitSet(new long[]{0x0000000000000308L});
    public static final BitSet FOLLOW_glueConnection_in_glueTopology283 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_DOMAIN_in_glueDomain353 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueDomain358 = new BitSet(new long[]{0x0000000001862388L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueDomain365 = new BitSet(new long[]{0x0000000001062388L});
    public static final BitSet FOLLOW_glueDomain_in_glueDomain372 = new BitSet(new long[]{0x0000000001062388L});
    public static final BitSet FOLLOW_glueNode_in_glueDomain379 = new BitSet(new long[]{0x0000000001062308L});
    public static final BitSet FOLLOW_glueConnection_in_glueDomain386 = new BitSet(new long[]{0x0000000001062208L});
    public static final BitSet FOLLOW_gluePort_in_glueDomain393 = new BitSet(new long[]{0x0000000001062008L});
    public static final BitSet FOLLOW_glueContracts_in_glueDomain400 = new BitSet(new long[]{0x0000000001040008L});
    public static final BitSet FOLLOW_gluePolicies_in_glueDomain407 = new BitSet(new long[]{0x0000000001000008L});
    public static final BitSet FOLLOW_key_value_list_in_glueDomain414 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NODE_in_glueNode506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueNode511 = new BitSet(new long[]{0x0000000001872208L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueNode518 = new BitSet(new long[]{0x0000000001072208L});
    public static final BitSet FOLLOW_glueComponent_in_glueNode525 = new BitSet(new long[]{0x0000000001072208L});
    public static final BitSet FOLLOW_glueConnection_in_glueNode532 = new BitSet(new long[]{0x0000000001062208L});
    public static final BitSet FOLLOW_gluePort_in_glueNode539 = new BitSet(new long[]{0x0000000001062008L});
    public static final BitSet FOLLOW_glueContracts_in_glueNode546 = new BitSet(new long[]{0x0000000001040008L});
    public static final BitSet FOLLOW_gluePolicies_in_glueNode553 = new BitSet(new long[]{0x0000000001000008L});
    public static final BitSet FOLLOW_key_value_list_in_glueNode560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONNECTION_in_glueConnection641 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueConnection645 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_DIRECTED_in_glueConnection647 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_glueSource_in_glueConnection652 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_glueTarget_in_glueConnection656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SOURCE_in_glueSource719 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_glueSource723 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_glueSourcePort_in_glueSource728 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TARGET_in_glueTarget782 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_glueTarget786 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_glueTargetPort_in_glueTarget791 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PORT_in_gluePort848 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_gluePort852 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SOURCEPORT_in_glueSourcePort896 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_glueSourcePort900 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TARGETPORT_in_glueTargetPort944 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_glueTargetPort948 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMPONENT_in_glueComponent993 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueComponent998 = new BitSet(new long[]{0x0000000001862008L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueComponent1005 = new BitSet(new long[]{0x0000000001062008L});
    public static final BitSet FOLLOW_gluePort_in_glueComponent1012 = new BitSet(new long[]{0x0000000001062008L});
    public static final BitSet FOLLOW_glueContracts_in_glueComponent1019 = new BitSet(new long[]{0x0000000001040008L});
    public static final BitSet FOLLOW_gluePolicies_in_glueComponent1026 = new BitSet(new long[]{0x0000000001000008L});
    public static final BitSet FOLLOW_key_value_list_in_glueComponent1033 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONTRACTS_in_glueContracts1105 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_glueContracts1107 = new BitSet(new long[]{0x0000000000C00008L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueContracts1110 = new BitSet(new long[]{0x0000000000800008L});
    public static final BitSet FOLLOW_POLICIES_in_gluePolicies1135 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_gluePolicies1137 = new BitSet(new long[]{0x0000000000C00008L});
    public static final BitSet FOLLOW_scoped_name_lang_in_gluePolicies1140 = new BitSet(new long[]{0x0000000000800008L});
    public static final BitSet FOLLOW_AT_SCOPE_in_scoped_name1166 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name1171 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_AT_LANG_in_scoped_name_lang1193 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name_lang1195 = new BitSet(new long[]{0x0000000000C00008L});
    public static final BitSet FOLLOW_scoped_name_in_scoped_name_lang1199 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_KVL_in_key_value_list1222 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_key_value_in_key_value_list1224 = new BitSet(new long[]{0x0000000001000008L});
    public static final BitSet FOLLOW_AT_KVL_in_key_value1244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_AT_KVL_in_key_value1247 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_key_value1249 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_VAL_STRING_in_key_value1252 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_KVL_in_key_value1257 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VAL_XSTRING_in_key_value1259 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_VAL_STRING_in_key_value1262 = new BitSet(new long[]{0x0000000000000008L});

}