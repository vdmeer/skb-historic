// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g 2011-07-07 22:25:01

  package org.skb.lang.glue.proto.grammars;

  import org.skb.lang.glue.proto.GluePass2_Ast;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.glue.proto.GlueTokensConstants;
  import org.skb.util.ReportManager;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class glueAst extends TreeParser {
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


        public glueAst(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public glueAst(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return glueAst.tokenNames; }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g"; }


      private LanguageTokens myTokens;
      private GluePass2_Ast pass;

      public void init() {
        this.pass=new GluePass2_Ast();
        this.myTokens = new LanguageTokens();
        this.myTokens.addTokens(tokenNames);
      }

      public void setFilename(String f){ReportManager.getInstance().setFileName(f);}
      public String getFilename(){return ReportManager.getInstance().getFileName();}

      private void setCppFile(String cpp){
        String fn=cpp.substring(1,cpp.lastIndexOf(':'));
        fn=fn.replace("file \"","");
        this.setFilename(fn);
      }

      public int  numberOfErrors() {return ReportManager.getInstance().noOfErrors();}
      public void resetErrors()    {ReportManager.getInstance().resetNoOfErrors();}
      public void displayRecognitionError(String[] tokenNames, RecognitionException re){ReportManager.getInstance().reportError(super.getErrorMessage(re, this.myTokens.getTokenNames()), re);}


    public static class glueSpecification_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueSpecification"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:85:1: glueSpecification : ^( AT_SPEC IDENT ( glueTopology )* ) ;
    public final glueAst.glueSpecification_return glueSpecification() throws RecognitionException {
        glueAst.glueSpecification_return retval = new glueAst.glueSpecification_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_SPEC1=null;
        CommonTree IDENT2=null;
        glueAst.glueTopology_return glueTopology3 = null;


        CommonTree AT_SPEC1_tree=null;
        CommonTree IDENT2_tree=null;

        this.init();
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:86:20: ( ^( AT_SPEC IDENT ( glueTopology )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:86:22: ^( AT_SPEC IDENT ( glueTopology )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_SPEC1=(CommonTree)match(input,AT_SPEC,FOLLOW_AT_SPEC_in_glueSpecification86); 
            AT_SPEC1_tree = (CommonTree)adaptor.dupNode(AT_SPEC1);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_SPEC1_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueSpecification88); 
            IDENT2_tree = (CommonTree)adaptor.dupNode(IDENT2);

            adaptor.addChild(root_1, IDENT2_tree);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:86:38: ( glueTopology )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TOPOLOGY) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:86:38: glueTopology
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_glueTopology_in_glueSpecification90);
            	    glueTopology3=glueTopology();

            	    state._fsp--;

            	    adaptor.addChild(root_1, glueTopology3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueTopology"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:1: glueTopology : ^( TOPOLOGY ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* ) ;
    public final glueAst.glueTopology_return glueTopology() throws RecognitionException {
        glueAst.glueTopology_return retval = new glueAst.glueTopology_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TOPOLOGY4=null;
        CommonTree IDENT5=null;
        glueAst.scoped_name_lang_return scoped_name_lang6 = null;

        glueAst.glueDomain_return glueDomain7 = null;

        glueAst.glueNode_return glueNode8 = null;

        glueAst.glueConnection_return glueConnection9 = null;


        CommonTree TOPOLOGY4_tree=null;
        CommonTree IDENT5_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:20: ( ^( TOPOLOGY ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:22: ^( TOPOLOGY ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TOPOLOGY4=(CommonTree)match(input,TOPOLOGY,FOLLOW_TOPOLOGY_in_glueTopology107); 
            TOPOLOGY4_tree = (CommonTree)adaptor.dupNode(TOPOLOGY4);

            root_1 = (CommonTree)adaptor.becomeRoot(TOPOLOGY4_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:33: ( IDENT )?
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENT) ) {
                    alt2=1;
                }
                switch (alt2) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:33: IDENT
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueTopology109); 
                        IDENT5_tree = (CommonTree)adaptor.dupNode(IDENT5);

                        adaptor.addChild(root_1, IDENT5_tree);


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:40: ( scoped_name_lang )?
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==AT_LANG) ) {
                    alt3=1;
                }
                switch (alt3) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:40: scoped_name_lang
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_scoped_name_lang_in_glueTopology112);
                        scoped_name_lang6=scoped_name_lang();

                        state._fsp--;

                        adaptor.addChild(root_1, scoped_name_lang6.getTree());

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:58: ( glueDomain )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==DOMAIN) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:58: glueDomain
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_glueDomain_in_glueTopology115);
                	    glueDomain7=glueDomain();

                	    state._fsp--;

                	    adaptor.addChild(root_1, glueDomain7.getTree());

                	    }
                	    break;

                	default :
                	    break loop4;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:70: ( glueNode )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==NODE) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:70: glueNode
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_glueNode_in_glueTopology118);
                	    glueNode8=glueNode();

                	    state._fsp--;

                	    adaptor.addChild(root_1, glueNode8.getTree());

                	    }
                	    break;

                	default :
                	    break loop5;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:80: ( glueConnection )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==CONNECTION) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:88:80: glueConnection
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_glueConnection_in_glueTopology121);
                	    glueConnection9=glueConnection();

                	    state._fsp--;

                	    adaptor.addChild(root_1, glueConnection9.getTree());

                	    }
                	    break;

                	default :
                	    break loop6;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueDomain"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:1: glueDomain : ^( DOMAIN ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) ;
    public final glueAst.glueDomain_return glueDomain() throws RecognitionException {
        glueAst.glueDomain_return retval = new glueAst.glueDomain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOMAIN10=null;
        CommonTree IDENT11=null;
        glueAst.scoped_name_lang_return scoped_name_lang12 = null;

        glueAst.glueDomain_return glueDomain13 = null;

        glueAst.glueNode_return glueNode14 = null;

        glueAst.glueConnection_return glueConnection15 = null;

        glueAst.gluePort_return gluePort16 = null;

        glueAst.glueContracts_return glueContracts17 = null;

        glueAst.gluePolicies_return gluePolicies18 = null;

        glueAst.key_value_list_return key_value_list19 = null;


        CommonTree DOMAIN10_tree=null;
        CommonTree IDENT11_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:20: ( ^( DOMAIN ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:22: ^( DOMAIN ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            DOMAIN10=(CommonTree)match(input,DOMAIN,FOLLOW_DOMAIN_in_glueDomain141); 
            DOMAIN10_tree = (CommonTree)adaptor.dupNode(DOMAIN10);

            root_1 = (CommonTree)adaptor.becomeRoot(DOMAIN10_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:31: ( IDENT )?
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENT) ) {
                    alt7=1;
                }
                switch (alt7) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:31: IDENT
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENT11=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueDomain143); 
                        IDENT11_tree = (CommonTree)adaptor.dupNode(IDENT11);

                        adaptor.addChild(root_1, IDENT11_tree);


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:38: ( scoped_name_lang )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==AT_LANG) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:38: scoped_name_lang
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_scoped_name_lang_in_glueDomain146);
                        scoped_name_lang12=scoped_name_lang();

                        state._fsp--;

                        adaptor.addChild(root_1, scoped_name_lang12.getTree());

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:56: ( glueDomain )*
                loop9:
                do {
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==DOMAIN) ) {
                        alt9=1;
                    }


                    switch (alt9) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:56: glueDomain
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_glueDomain_in_glueDomain149);
                	    glueDomain13=glueDomain();

                	    state._fsp--;

                	    adaptor.addChild(root_1, glueDomain13.getTree());

                	    }
                	    break;

                	default :
                	    break loop9;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:68: ( glueNode )*
                loop10:
                do {
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==NODE) ) {
                        alt10=1;
                    }


                    switch (alt10) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:68: glueNode
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_glueNode_in_glueDomain152);
                	    glueNode14=glueNode();

                	    state._fsp--;

                	    adaptor.addChild(root_1, glueNode14.getTree());

                	    }
                	    break;

                	default :
                	    break loop10;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:78: ( glueConnection )*
                loop11:
                do {
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==CONNECTION) ) {
                        alt11=1;
                    }


                    switch (alt11) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:78: glueConnection
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_glueConnection_in_glueDomain155);
                	    glueConnection15=glueConnection();

                	    state._fsp--;

                	    adaptor.addChild(root_1, glueConnection15.getTree());

                	    }
                	    break;

                	default :
                	    break loop11;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:94: ( gluePort )*
                loop12:
                do {
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==PORT) ) {
                        alt12=1;
                    }


                    switch (alt12) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:94: gluePort
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_gluePort_in_glueDomain158);
                	    gluePort16=gluePort();

                	    state._fsp--;

                	    adaptor.addChild(root_1, gluePort16.getTree());

                	    }
                	    break;

                	default :
                	    break loop12;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:104: ( glueContracts )?
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==CONTRACTS) ) {
                    alt13=1;
                }
                switch (alt13) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:104: glueContracts
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_glueContracts_in_glueDomain161);
                        glueContracts17=glueContracts();

                        state._fsp--;

                        adaptor.addChild(root_1, glueContracts17.getTree());

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:119: ( gluePolicies )?
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==POLICIES) ) {
                    alt14=1;
                }
                switch (alt14) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:119: gluePolicies
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_gluePolicies_in_glueDomain164);
                        gluePolicies18=gluePolicies();

                        state._fsp--;

                        adaptor.addChild(root_1, gluePolicies18.getTree());

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:133: ( key_value_list )?
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==AT_KVL) ) {
                    alt15=1;
                }
                switch (alt15) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:90:133: key_value_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_key_value_list_in_glueDomain167);
                        key_value_list19=key_value_list();

                        state._fsp--;

                        adaptor.addChild(root_1, key_value_list19.getTree());

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueNode"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:1: glueNode : ^( NODE ( IDENT )? ( scoped_name_lang )? ( glueComponent )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) ;
    public final glueAst.glueNode_return glueNode() throws RecognitionException {
        glueAst.glueNode_return retval = new glueAst.glueNode_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NODE20=null;
        CommonTree IDENT21=null;
        glueAst.scoped_name_lang_return scoped_name_lang22 = null;

        glueAst.glueComponent_return glueComponent23 = null;

        glueAst.glueConnection_return glueConnection24 = null;

        glueAst.gluePort_return gluePort25 = null;

        glueAst.glueContracts_return glueContracts26 = null;

        glueAst.gluePolicies_return gluePolicies27 = null;

        glueAst.key_value_list_return key_value_list28 = null;


        CommonTree NODE20_tree=null;
        CommonTree IDENT21_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:20: ( ^( NODE ( IDENT )? ( scoped_name_lang )? ( glueComponent )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:22: ^( NODE ( IDENT )? ( scoped_name_lang )? ( glueComponent )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NODE20=(CommonTree)match(input,NODE,FOLLOW_NODE_in_glueNode188); 
            NODE20_tree = (CommonTree)adaptor.dupNode(NODE20);

            root_1 = (CommonTree)adaptor.becomeRoot(NODE20_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:29: ( IDENT )?
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==IDENT) ) {
                    alt16=1;
                }
                switch (alt16) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:29: IDENT
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENT21=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueNode190); 
                        IDENT21_tree = (CommonTree)adaptor.dupNode(IDENT21);

                        adaptor.addChild(root_1, IDENT21_tree);


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:36: ( scoped_name_lang )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==AT_LANG) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:36: scoped_name_lang
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_scoped_name_lang_in_glueNode193);
                        scoped_name_lang22=scoped_name_lang();

                        state._fsp--;

                        adaptor.addChild(root_1, scoped_name_lang22.getTree());

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:54: ( glueComponent )*
                loop18:
                do {
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==COMPONENT) ) {
                        alt18=1;
                    }


                    switch (alt18) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:54: glueComponent
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_glueComponent_in_glueNode196);
                	    glueComponent23=glueComponent();

                	    state._fsp--;

                	    adaptor.addChild(root_1, glueComponent23.getTree());

                	    }
                	    break;

                	default :
                	    break loop18;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:69: ( glueConnection )*
                loop19:
                do {
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==CONNECTION) ) {
                        alt19=1;
                    }


                    switch (alt19) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:69: glueConnection
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_glueConnection_in_glueNode199);
                	    glueConnection24=glueConnection();

                	    state._fsp--;

                	    adaptor.addChild(root_1, glueConnection24.getTree());

                	    }
                	    break;

                	default :
                	    break loop19;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:85: ( gluePort )*
                loop20:
                do {
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==PORT) ) {
                        alt20=1;
                    }


                    switch (alt20) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:85: gluePort
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_gluePort_in_glueNode202);
                	    gluePort25=gluePort();

                	    state._fsp--;

                	    adaptor.addChild(root_1, gluePort25.getTree());

                	    }
                	    break;

                	default :
                	    break loop20;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:95: ( glueContracts )?
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==CONTRACTS) ) {
                    alt21=1;
                }
                switch (alt21) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:95: glueContracts
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_glueContracts_in_glueNode205);
                        glueContracts26=glueContracts();

                        state._fsp--;

                        adaptor.addChild(root_1, glueContracts26.getTree());

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:110: ( gluePolicies )?
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==POLICIES) ) {
                    alt22=1;
                }
                switch (alt22) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:110: gluePolicies
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_gluePolicies_in_glueNode208);
                        gluePolicies27=gluePolicies();

                        state._fsp--;

                        adaptor.addChild(root_1, gluePolicies27.getTree());

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:124: ( key_value_list )?
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==AT_KVL) ) {
                    alt23=1;
                }
                switch (alt23) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:92:124: key_value_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_key_value_list_in_glueNode211);
                        key_value_list28=key_value_list();

                        state._fsp--;

                        adaptor.addChild(root_1, key_value_list28.getTree());

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueConnection"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:94:1: glueConnection : ^( CONNECTION IDENT ( DIRECTED )? glueSource glueTarget ) ;
    public final glueAst.glueConnection_return glueConnection() throws RecognitionException {
        glueAst.glueConnection_return retval = new glueAst.glueConnection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CONNECTION29=null;
        CommonTree IDENT30=null;
        CommonTree DIRECTED31=null;
        glueAst.glueSource_return glueSource32 = null;

        glueAst.glueTarget_return glueTarget33 = null;


        CommonTree CONNECTION29_tree=null;
        CommonTree IDENT30_tree=null;
        CommonTree DIRECTED31_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:94:20: ( ^( CONNECTION IDENT ( DIRECTED )? glueSource glueTarget ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:94:22: ^( CONNECTION IDENT ( DIRECTED )? glueSource glueTarget )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            CONNECTION29=(CommonTree)match(input,CONNECTION,FOLLOW_CONNECTION_in_glueConnection226); 
            CONNECTION29_tree = (CommonTree)adaptor.dupNode(CONNECTION29);

            root_1 = (CommonTree)adaptor.becomeRoot(CONNECTION29_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT30=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueConnection228); 
            IDENT30_tree = (CommonTree)adaptor.dupNode(IDENT30);

            adaptor.addChild(root_1, IDENT30_tree);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:94:41: ( DIRECTED )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==DIRECTED) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:94:41: DIRECTED
                    {
                    _last = (CommonTree)input.LT(1);
                    DIRECTED31=(CommonTree)match(input,DIRECTED,FOLLOW_DIRECTED_in_glueConnection230); 
                    DIRECTED31_tree = (CommonTree)adaptor.dupNode(DIRECTED31);

                    adaptor.addChild(root_1, DIRECTED31_tree);


                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_glueSource_in_glueConnection233);
            glueSource32=glueSource();

            state._fsp--;

            adaptor.addChild(root_1, glueSource32.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_glueTarget_in_glueConnection235);
            glueTarget33=glueTarget();

            state._fsp--;

            adaptor.addChild(root_1, glueTarget33.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueSource"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:96:1: glueSource : ^( SOURCE scoped_name ( glueSourcePort )? ) ;
    public final glueAst.glueSource_return glueSource() throws RecognitionException {
        glueAst.glueSource_return retval = new glueAst.glueSource_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SOURCE34=null;
        glueAst.scoped_name_return scoped_name35 = null;

        glueAst.glueSourcePort_return glueSourcePort36 = null;


        CommonTree SOURCE34_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:96:20: ( ^( SOURCE scoped_name ( glueSourcePort )? ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:96:22: ^( SOURCE scoped_name ( glueSourcePort )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            SOURCE34=(CommonTree)match(input,SOURCE,FOLLOW_SOURCE_in_glueSource253); 
            SOURCE34_tree = (CommonTree)adaptor.dupNode(SOURCE34);

            root_1 = (CommonTree)adaptor.becomeRoot(SOURCE34_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scoped_name_in_glueSource255);
            scoped_name35=scoped_name();

            state._fsp--;

            adaptor.addChild(root_1, scoped_name35.getTree());
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:96:43: ( glueSourcePort )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==SOURCEPORT) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:96:43: glueSourcePort
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_glueSourcePort_in_glueSource257);
                    glueSourcePort36=glueSourcePort();

                    state._fsp--;

                    adaptor.addChild(root_1, glueSourcePort36.getTree());

                    }
                    break;

            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueTarget"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:97:1: glueTarget : ^( TARGET scoped_name ( glueTargetPort )? ) ;
    public final glueAst.glueTarget_return glueTarget() throws RecognitionException {
        glueAst.glueTarget_return retval = new glueAst.glueTarget_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TARGET37=null;
        glueAst.scoped_name_return scoped_name38 = null;

        glueAst.glueTargetPort_return glueTargetPort39 = null;


        CommonTree TARGET37_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:97:20: ( ^( TARGET scoped_name ( glueTargetPort )? ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:97:22: ^( TARGET scoped_name ( glueTargetPort )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TARGET37=(CommonTree)match(input,TARGET,FOLLOW_TARGET_in_glueTarget275); 
            TARGET37_tree = (CommonTree)adaptor.dupNode(TARGET37);

            root_1 = (CommonTree)adaptor.becomeRoot(TARGET37_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scoped_name_in_glueTarget277);
            scoped_name38=scoped_name();

            state._fsp--;

            adaptor.addChild(root_1, scoped_name38.getTree());
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:97:43: ( glueTargetPort )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==TARGETPORT) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:97:43: glueTargetPort
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_glueTargetPort_in_glueTarget279);
                    glueTargetPort39=glueTargetPort();

                    state._fsp--;

                    adaptor.addChild(root_1, glueTargetPort39.getTree());

                    }
                    break;

            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gluePort"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:99:1: gluePort : ^( PORT IDENT ) ;
    public final glueAst.gluePort_return gluePort() throws RecognitionException {
        glueAst.gluePort_return retval = new glueAst.gluePort_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PORT40=null;
        CommonTree IDENT41=null;

        CommonTree PORT40_tree=null;
        CommonTree IDENT41_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:99:20: ( ^( PORT IDENT ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:99:22: ^( PORT IDENT )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PORT40=(CommonTree)match(input,PORT,FOLLOW_PORT_in_gluePort300); 
            PORT40_tree = (CommonTree)adaptor.dupNode(PORT40);

            root_1 = (CommonTree)adaptor.becomeRoot(PORT40_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT41=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_gluePort302); 
            IDENT41_tree = (CommonTree)adaptor.dupNode(IDENT41);

            adaptor.addChild(root_1, IDENT41_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueSourcePort"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:101:1: glueSourcePort : ^( SOURCEPORT scoped_name ) ;
    public final glueAst.glueSourcePort_return glueSourcePort() throws RecognitionException {
        glueAst.glueSourcePort_return retval = new glueAst.glueSourcePort_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SOURCEPORT42=null;
        glueAst.scoped_name_return scoped_name43 = null;


        CommonTree SOURCEPORT42_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:101:20: ( ^( SOURCEPORT scoped_name ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:101:22: ^( SOURCEPORT scoped_name )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            SOURCEPORT42=(CommonTree)match(input,SOURCEPORT,FOLLOW_SOURCEPORT_in_glueSourcePort316); 
            SOURCEPORT42_tree = (CommonTree)adaptor.dupNode(SOURCEPORT42);

            root_1 = (CommonTree)adaptor.becomeRoot(SOURCEPORT42_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scoped_name_in_glueSourcePort318);
            scoped_name43=scoped_name();

            state._fsp--;

            adaptor.addChild(root_1, scoped_name43.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueTargetPort"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:102:1: glueTargetPort : ^( TARGETPORT scoped_name ) ;
    public final glueAst.glueTargetPort_return glueTargetPort() throws RecognitionException {
        glueAst.glueTargetPort_return retval = new glueAst.glueTargetPort_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TARGETPORT44=null;
        glueAst.scoped_name_return scoped_name45 = null;


        CommonTree TARGETPORT44_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:102:20: ( ^( TARGETPORT scoped_name ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:102:22: ^( TARGETPORT scoped_name )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TARGETPORT44=(CommonTree)match(input,TARGETPORT,FOLLOW_TARGETPORT_in_glueTargetPort331); 
            TARGETPORT44_tree = (CommonTree)adaptor.dupNode(TARGETPORT44);

            root_1 = (CommonTree)adaptor.becomeRoot(TARGETPORT44_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scoped_name_in_glueTargetPort333);
            scoped_name45=scoped_name();

            state._fsp--;

            adaptor.addChild(root_1, scoped_name45.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueComponent"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:1: glueComponent : ^( COMPONENT ( IDENT )? ( scoped_name_lang )? ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) ;
    public final glueAst.glueComponent_return glueComponent() throws RecognitionException {
        glueAst.glueComponent_return retval = new glueAst.glueComponent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COMPONENT46=null;
        CommonTree IDENT47=null;
        glueAst.scoped_name_lang_return scoped_name_lang48 = null;

        glueAst.gluePort_return gluePort49 = null;

        glueAst.glueContracts_return glueContracts50 = null;

        glueAst.gluePolicies_return gluePolicies51 = null;

        glueAst.key_value_list_return key_value_list52 = null;


        CommonTree COMPONENT46_tree=null;
        CommonTree IDENT47_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:20: ( ^( COMPONENT ( IDENT )? ( scoped_name_lang )? ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:22: ^( COMPONENT ( IDENT )? ( scoped_name_lang )? ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COMPONENT46=(CommonTree)match(input,COMPONENT,FOLLOW_COMPONENT_in_glueComponent348); 
            COMPONENT46_tree = (CommonTree)adaptor.dupNode(COMPONENT46);

            root_1 = (CommonTree)adaptor.becomeRoot(COMPONENT46_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:34: ( IDENT )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDENT) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:34: IDENT
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENT47=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_glueComponent350); 
                        IDENT47_tree = (CommonTree)adaptor.dupNode(IDENT47);

                        adaptor.addChild(root_1, IDENT47_tree);


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:41: ( scoped_name_lang )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==AT_LANG) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:41: scoped_name_lang
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_scoped_name_lang_in_glueComponent353);
                        scoped_name_lang48=scoped_name_lang();

                        state._fsp--;

                        adaptor.addChild(root_1, scoped_name_lang48.getTree());

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:59: ( gluePort )*
                loop29:
                do {
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==PORT) ) {
                        alt29=1;
                    }


                    switch (alt29) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:59: gluePort
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_gluePort_in_glueComponent356);
                	    gluePort49=gluePort();

                	    state._fsp--;

                	    adaptor.addChild(root_1, gluePort49.getTree());

                	    }
                	    break;

                	default :
                	    break loop29;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:69: ( glueContracts )?
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==CONTRACTS) ) {
                    alt30=1;
                }
                switch (alt30) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:69: glueContracts
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_glueContracts_in_glueComponent359);
                        glueContracts50=glueContracts();

                        state._fsp--;

                        adaptor.addChild(root_1, glueContracts50.getTree());

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:84: ( gluePolicies )?
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==POLICIES) ) {
                    alt31=1;
                }
                switch (alt31) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:84: gluePolicies
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_gluePolicies_in_glueComponent362);
                        gluePolicies51=gluePolicies();

                        state._fsp--;

                        adaptor.addChild(root_1, gluePolicies51.getTree());

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:98: ( key_value_list )?
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==AT_KVL) ) {
                    alt32=1;
                }
                switch (alt32) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:104:98: key_value_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_key_value_list_in_glueComponent365);
                        key_value_list52=key_value_list();

                        state._fsp--;

                        adaptor.addChild(root_1, key_value_list52.getTree());

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueContracts"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:106:1: glueContracts : ^( CONTRACTS ( scoped_name )* ( scoped_name_lang )* ) ;
    public final glueAst.glueContracts_return glueContracts() throws RecognitionException {
        glueAst.glueContracts_return retval = new glueAst.glueContracts_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CONTRACTS53=null;
        glueAst.scoped_name_return scoped_name54 = null;

        glueAst.scoped_name_lang_return scoped_name_lang55 = null;


        CommonTree CONTRACTS53_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:106:20: ( ^( CONTRACTS ( scoped_name )* ( scoped_name_lang )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:106:22: ^( CONTRACTS ( scoped_name )* ( scoped_name_lang )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            CONTRACTS53=(CommonTree)match(input,CONTRACTS,FOLLOW_CONTRACTS_in_glueContracts381); 
            CONTRACTS53_tree = (CommonTree)adaptor.dupNode(CONTRACTS53);

            root_1 = (CommonTree)adaptor.becomeRoot(CONTRACTS53_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:106:34: ( scoped_name )*
                loop33:
                do {
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==AT_SCOPE) ) {
                        alt33=1;
                    }


                    switch (alt33) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:106:34: scoped_name
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_scoped_name_in_glueContracts383);
                	    scoped_name54=scoped_name();

                	    state._fsp--;

                	    adaptor.addChild(root_1, scoped_name54.getTree());

                	    }
                	    break;

                	default :
                	    break loop33;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:106:47: ( scoped_name_lang )*
                loop34:
                do {
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==AT_LANG) ) {
                        alt34=1;
                    }


                    switch (alt34) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:106:47: scoped_name_lang
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_scoped_name_lang_in_glueContracts386);
                	    scoped_name_lang55=scoped_name_lang();

                	    state._fsp--;

                	    adaptor.addChild(root_1, scoped_name_lang55.getTree());

                	    }
                	    break;

                	default :
                	    break loop34;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gluePolicies"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:108:1: gluePolicies : ^( POLICIES ( scoped_name )* ( scoped_name_lang )* ) ;
    public final glueAst.gluePolicies_return gluePolicies() throws RecognitionException {
        glueAst.gluePolicies_return retval = new glueAst.gluePolicies_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLICIES56=null;
        glueAst.scoped_name_return scoped_name57 = null;

        glueAst.scoped_name_lang_return scoped_name_lang58 = null;


        CommonTree POLICIES56_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:108:20: ( ^( POLICIES ( scoped_name )* ( scoped_name_lang )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:108:22: ^( POLICIES ( scoped_name )* ( scoped_name_lang )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            POLICIES56=(CommonTree)match(input,POLICIES,FOLLOW_POLICIES_in_gluePolicies403); 
            POLICIES56_tree = (CommonTree)adaptor.dupNode(POLICIES56);

            root_1 = (CommonTree)adaptor.becomeRoot(POLICIES56_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:108:33: ( scoped_name )*
                loop35:
                do {
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==AT_SCOPE) ) {
                        alt35=1;
                    }


                    switch (alt35) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:108:33: scoped_name
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_scoped_name_in_gluePolicies405);
                	    scoped_name57=scoped_name();

                	    state._fsp--;

                	    adaptor.addChild(root_1, scoped_name57.getTree());

                	    }
                	    break;

                	default :
                	    break loop35;
                    }
                } while (true);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:108:46: ( scoped_name_lang )*
                loop36:
                do {
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==AT_LANG) ) {
                        alt36=1;
                    }


                    switch (alt36) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:108:46: scoped_name_lang
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_scoped_name_lang_in_gluePolicies408);
                	    scoped_name_lang58=scoped_name_lang();

                	    state._fsp--;

                	    adaptor.addChild(root_1, scoped_name_lang58.getTree());

                	    }
                	    break;

                	default :
                	    break loop36;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scoped_name"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:110:1: scoped_name : ^( AT_SCOPE ( IDENT )* ) ;
    public final glueAst.scoped_name_return scoped_name() throws RecognitionException {
        glueAst.scoped_name_return retval = new glueAst.scoped_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_SCOPE59=null;
        CommonTree IDENT60=null;

        CommonTree AT_SCOPE59_tree=null;
        CommonTree IDENT60_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:110:20: ( ^( AT_SCOPE ( IDENT )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:110:22: ^( AT_SCOPE ( IDENT )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_SCOPE59=(CommonTree)match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_scoped_name426); 
            AT_SCOPE59_tree = (CommonTree)adaptor.dupNode(AT_SCOPE59);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_SCOPE59_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:110:33: ( IDENT )*
                loop37:
                do {
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==IDENT) ) {
                        alt37=1;
                    }


                    switch (alt37) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:110:33: IDENT
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    IDENT60=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_scoped_name428); 
                	    IDENT60_tree = (CommonTree)adaptor.dupNode(IDENT60);

                	    adaptor.addChild(root_1, IDENT60_tree);


                	    }
                	    break;

                	default :
                	    break loop37;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scoped_name_lang"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:111:1: scoped_name_lang : ^( AT_LANG IDENT scoped_name ) ;
    public final glueAst.scoped_name_lang_return scoped_name_lang() throws RecognitionException {
        glueAst.scoped_name_lang_return retval = new glueAst.scoped_name_lang_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_LANG61=null;
        CommonTree IDENT62=null;
        glueAst.scoped_name_return scoped_name63 = null;


        CommonTree AT_LANG61_tree=null;
        CommonTree IDENT62_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:111:20: ( ^( AT_LANG IDENT scoped_name ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:111:22: ^( AT_LANG IDENT scoped_name )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_LANG61=(CommonTree)match(input,AT_LANG,FOLLOW_AT_LANG_in_scoped_name_lang440); 
            AT_LANG61_tree = (CommonTree)adaptor.dupNode(AT_LANG61);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_LANG61_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT62=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_scoped_name_lang442); 
            IDENT62_tree = (CommonTree)adaptor.dupNode(IDENT62);

            adaptor.addChild(root_1, IDENT62_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scoped_name_in_scoped_name_lang444);
            scoped_name63=scoped_name();

            state._fsp--;

            adaptor.addChild(root_1, scoped_name63.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "key_value_list"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:113:1: key_value_list : ^( AT_KVL ( key_value )* ) ;
    public final glueAst.key_value_list_return key_value_list() throws RecognitionException {
        glueAst.key_value_list_return retval = new glueAst.key_value_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_KVL64=null;
        glueAst.key_value_return key_value65 = null;


        CommonTree AT_KVL64_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:113:20: ( ^( AT_KVL ( key_value )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:113:22: ^( AT_KVL ( key_value )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_KVL64=(CommonTree)match(input,AT_KVL,FOLLOW_AT_KVL_in_key_value_list458); 
            AT_KVL64_tree = (CommonTree)adaptor.dupNode(AT_KVL64);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_KVL64_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:113:31: ( key_value )*
                loop38:
                do {
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==AT_KVL) ) {
                        alt38=1;
                    }


                    switch (alt38) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:113:31: key_value
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_key_value_in_key_value_list460);
                	    key_value65=key_value();

                	    state._fsp--;

                	    adaptor.addChild(root_1, key_value65.getTree());

                	    }
                	    break;

                	default :
                	    break loop38;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "key_value"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:115:1: key_value : ^( AT_KVL ^( AT_KVL ( IDENT )? ( VAL_STRING )? ) ^( AT_KVL ( VAL_XSTRING )? ( VAL_STRING )? ) ) ;
    public final glueAst.key_value_return key_value() throws RecognitionException {
        glueAst.key_value_return retval = new glueAst.key_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_KVL66=null;
        CommonTree AT_KVL67=null;
        CommonTree IDENT68=null;
        CommonTree VAL_STRING69=null;
        CommonTree AT_KVL70=null;
        CommonTree VAL_XSTRING71=null;
        CommonTree VAL_STRING72=null;

        CommonTree AT_KVL66_tree=null;
        CommonTree AT_KVL67_tree=null;
        CommonTree IDENT68_tree=null;
        CommonTree VAL_STRING69_tree=null;
        CommonTree AT_KVL70_tree=null;
        CommonTree VAL_XSTRING71_tree=null;
        CommonTree VAL_STRING72_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:115:20: ( ^( AT_KVL ^( AT_KVL ( IDENT )? ( VAL_STRING )? ) ^( AT_KVL ( VAL_XSTRING )? ( VAL_STRING )? ) ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:115:22: ^( AT_KVL ^( AT_KVL ( IDENT )? ( VAL_STRING )? ) ^( AT_KVL ( VAL_XSTRING )? ( VAL_STRING )? ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_KVL66=(CommonTree)match(input,AT_KVL,FOLLOW_AT_KVL_in_key_value480); 
            AT_KVL66_tree = (CommonTree)adaptor.dupNode(AT_KVL66);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_KVL66_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_KVL67=(CommonTree)match(input,AT_KVL,FOLLOW_AT_KVL_in_key_value483); 
            AT_KVL67_tree = (CommonTree)adaptor.dupNode(AT_KVL67);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_KVL67_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:115:40: ( IDENT )?
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==IDENT) ) {
                    alt39=1;
                }
                switch (alt39) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:115:40: IDENT
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENT68=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_key_value485); 
                        IDENT68_tree = (CommonTree)adaptor.dupNode(IDENT68);

                        adaptor.addChild(root_2, IDENT68_tree);


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:115:47: ( VAL_STRING )?
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==VAL_STRING) ) {
                    alt40=1;
                }
                switch (alt40) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:115:47: VAL_STRING
                        {
                        _last = (CommonTree)input.LT(1);
                        VAL_STRING69=(CommonTree)match(input,VAL_STRING,FOLLOW_VAL_STRING_in_key_value488); 
                        VAL_STRING69_tree = (CommonTree)adaptor.dupNode(VAL_STRING69);

                        adaptor.addChild(root_2, VAL_STRING69_tree);


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_KVL70=(CommonTree)match(input,AT_KVL,FOLLOW_AT_KVL_in_key_value493); 
            AT_KVL70_tree = (CommonTree)adaptor.dupNode(AT_KVL70);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_KVL70_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:115:69: ( VAL_XSTRING )?
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==VAL_XSTRING) ) {
                    alt41=1;
                }
                switch (alt41) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:115:69: VAL_XSTRING
                        {
                        _last = (CommonTree)input.LT(1);
                        VAL_XSTRING71=(CommonTree)match(input,VAL_XSTRING,FOLLOW_VAL_XSTRING_in_key_value495); 
                        VAL_XSTRING71_tree = (CommonTree)adaptor.dupNode(VAL_XSTRING71);

                        adaptor.addChild(root_2, VAL_XSTRING71_tree);


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:115:82: ( VAL_STRING )?
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==VAL_STRING) ) {
                    alt42=1;
                }
                switch (alt42) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueAst.g:115:82: VAL_STRING
                        {
                        _last = (CommonTree)input.LT(1);
                        VAL_STRING72=(CommonTree)match(input,VAL_STRING,FOLLOW_VAL_STRING_in_key_value498); 
                        VAL_STRING72_tree = (CommonTree)adaptor.dupNode(VAL_STRING72);

                        adaptor.addChild(root_2, VAL_STRING72_tree);


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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


 

    public static final BitSet FOLLOW_AT_SPEC_in_glueSpecification86 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueSpecification88 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_glueTopology_in_glueSpecification90 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_TOPOLOGY_in_glueTopology107 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueTopology109 = new BitSet(new long[]{0x0000000000800388L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueTopology112 = new BitSet(new long[]{0x0000000000000388L});
    public static final BitSet FOLLOW_glueDomain_in_glueTopology115 = new BitSet(new long[]{0x0000000000000388L});
    public static final BitSet FOLLOW_glueNode_in_glueTopology118 = new BitSet(new long[]{0x0000000000000308L});
    public static final BitSet FOLLOW_glueConnection_in_glueTopology121 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_DOMAIN_in_glueDomain141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueDomain143 = new BitSet(new long[]{0x0000000001862388L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueDomain146 = new BitSet(new long[]{0x0000000001062388L});
    public static final BitSet FOLLOW_glueDomain_in_glueDomain149 = new BitSet(new long[]{0x0000000001062388L});
    public static final BitSet FOLLOW_glueNode_in_glueDomain152 = new BitSet(new long[]{0x0000000001062308L});
    public static final BitSet FOLLOW_glueConnection_in_glueDomain155 = new BitSet(new long[]{0x0000000001062208L});
    public static final BitSet FOLLOW_gluePort_in_glueDomain158 = new BitSet(new long[]{0x0000000001062008L});
    public static final BitSet FOLLOW_glueContracts_in_glueDomain161 = new BitSet(new long[]{0x0000000001040008L});
    public static final BitSet FOLLOW_gluePolicies_in_glueDomain164 = new BitSet(new long[]{0x0000000001000008L});
    public static final BitSet FOLLOW_key_value_list_in_glueDomain167 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NODE_in_glueNode188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueNode190 = new BitSet(new long[]{0x0000000001872208L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueNode193 = new BitSet(new long[]{0x0000000001072208L});
    public static final BitSet FOLLOW_glueComponent_in_glueNode196 = new BitSet(new long[]{0x0000000001072208L});
    public static final BitSet FOLLOW_glueConnection_in_glueNode199 = new BitSet(new long[]{0x0000000001062208L});
    public static final BitSet FOLLOW_gluePort_in_glueNode202 = new BitSet(new long[]{0x0000000001062008L});
    public static final BitSet FOLLOW_glueContracts_in_glueNode205 = new BitSet(new long[]{0x0000000001040008L});
    public static final BitSet FOLLOW_gluePolicies_in_glueNode208 = new BitSet(new long[]{0x0000000001000008L});
    public static final BitSet FOLLOW_key_value_list_in_glueNode211 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONNECTION_in_glueConnection226 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueConnection228 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_DIRECTED_in_glueConnection230 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_glueSource_in_glueConnection233 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_glueTarget_in_glueConnection235 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SOURCE_in_glueSource253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_glueSource255 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_glueSourcePort_in_glueSource257 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TARGET_in_glueTarget275 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_glueTarget277 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_glueTargetPort_in_glueTarget279 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PORT_in_gluePort300 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_gluePort302 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SOURCEPORT_in_glueSourcePort316 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_glueSourcePort318 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TARGETPORT_in_glueTargetPort331 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_glueTargetPort333 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMPONENT_in_glueComponent348 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_glueComponent350 = new BitSet(new long[]{0x0000000001862008L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueComponent353 = new BitSet(new long[]{0x0000000001062008L});
    public static final BitSet FOLLOW_gluePort_in_glueComponent356 = new BitSet(new long[]{0x0000000001062008L});
    public static final BitSet FOLLOW_glueContracts_in_glueComponent359 = new BitSet(new long[]{0x0000000001040008L});
    public static final BitSet FOLLOW_gluePolicies_in_glueComponent362 = new BitSet(new long[]{0x0000000001000008L});
    public static final BitSet FOLLOW_key_value_list_in_glueComponent365 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONTRACTS_in_glueContracts381 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_glueContracts383 = new BitSet(new long[]{0x0000000000C00008L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueContracts386 = new BitSet(new long[]{0x0000000000800008L});
    public static final BitSet FOLLOW_POLICIES_in_gluePolicies403 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_gluePolicies405 = new BitSet(new long[]{0x0000000000C00008L});
    public static final BitSet FOLLOW_scoped_name_lang_in_gluePolicies408 = new BitSet(new long[]{0x0000000000800008L});
    public static final BitSet FOLLOW_AT_SCOPE_in_scoped_name426 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name428 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_AT_LANG_in_scoped_name_lang440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name_lang442 = new BitSet(new long[]{0x0000000000C00008L});
    public static final BitSet FOLLOW_scoped_name_in_scoped_name_lang444 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_KVL_in_key_value_list458 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_key_value_in_key_value_list460 = new BitSet(new long[]{0x0000000001000008L});
    public static final BitSet FOLLOW_AT_KVL_in_key_value480 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_AT_KVL_in_key_value483 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_key_value485 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_VAL_STRING_in_key_value488 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_KVL_in_key_value493 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VAL_XSTRING_in_key_value495 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_VAL_STRING_in_key_value498 = new BitSet(new long[]{0x0000000000000008L});

}