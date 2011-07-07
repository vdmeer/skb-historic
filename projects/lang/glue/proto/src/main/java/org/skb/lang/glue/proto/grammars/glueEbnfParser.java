// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g 2011-07-07 22:24:59

  package org.skb.lang.glue.proto.grammars;

  import java.util.LinkedHashMap;

  import org.skb.util.languages.AtomList;
  import org.skb.lang.glue.proto.GluePass1_Ebnf;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.glue.proto.GlueTokensConstants;
  import org.skb.util.ReportManager;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class glueEbnfParser extends Parser {
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


        public glueEbnfParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public glueEbnfParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return glueEbnfParser.tokenNames; }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g"; }


      private LanguageTokens myTokens;
      private GluePass1_Ebnf pass;
      private Token base_type;
      private boolean isArray=false;

      public void init() {
        this.pass=new GluePass1_Ebnf();
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


    public static class glueSpecification_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueSpecification"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:115:1: glueSpecification : AT_SPEC s= IDENT ';' ( glueTopology )* EOF -> ^( AT_SPEC IDENT ( glueTopology )* ) ;
    public final glueEbnfParser.glueSpecification_return glueSpecification() throws RecognitionException {
        glueEbnfParser.glueSpecification_return retval = new glueEbnfParser.glueSpecification_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token AT_SPEC1=null;
        Token char_literal2=null;
        Token EOF4=null;
        glueEbnfParser.glueTopology_return glueTopology3 = null;


        CommonTree s_tree=null;
        CommonTree AT_SPEC1_tree=null;
        CommonTree char_literal2_tree=null;
        CommonTree EOF4_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_AT_SPEC=new RewriteRuleTokenStream(adaptor,"token AT_SPEC");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
        RewriteRuleSubtreeStream stream_glueTopology=new RewriteRuleSubtreeStream(adaptor,"rule glueTopology");
        this.init();
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:116:20: ( AT_SPEC s= IDENT ';' ( glueTopology )* EOF -> ^( AT_SPEC IDENT ( glueTopology )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:116:22: AT_SPEC s= IDENT ';' ( glueTopology )* EOF
            {
            AT_SPEC1=(Token)match(input,AT_SPEC,FOLLOW_AT_SPEC_in_glueSpecification93);  
            stream_AT_SPEC.add(AT_SPEC1);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_glueSpecification97);  
            stream_IDENT.add(s);

            char_literal2=(Token)match(input,34,FOLLOW_34_in_glueSpecification99);  
            stream_34.add(char_literal2);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:116:42: ( glueTopology )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TOPOLOGY) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:116:42: glueTopology
            	    {
            	    pushFollow(FOLLOW_glueTopology_in_glueSpecification101);
            	    glueTopology3=glueTopology();

            	    state._fsp--;

            	    stream_glueTopology.add(glueTopology3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_glueSpecification104);  
            stream_EOF.add(EOF4);



            // AST REWRITE
            // elements: AT_SPEC, glueTopology, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 117:22: -> ^( AT_SPEC IDENT ( glueTopology )* )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:117:25: ^( AT_SPEC IDENT ( glueTopology )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_AT_SPEC.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:117:41: ( glueTopology )*
                while ( stream_glueTopology.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueTopology.nextTree());

                }
                stream_glueTopology.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueSpecification"

    public static class glueTopology_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueTopology"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:119:1: glueTopology : TOPOLOGY ( IDENT | scoped_name_lang ) '[' ( glueDomain | glueNode | glueConnection )* ']' -> ^( TOPOLOGY ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* ) ;
    public final glueEbnfParser.glueTopology_return glueTopology() throws RecognitionException {
        glueEbnfParser.glueTopology_return retval = new glueEbnfParser.glueTopology_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TOPOLOGY5=null;
        Token IDENT6=null;
        Token char_literal8=null;
        Token char_literal12=null;
        glueEbnfParser.scoped_name_lang_return scoped_name_lang7 = null;

        glueEbnfParser.glueDomain_return glueDomain9 = null;

        glueEbnfParser.glueNode_return glueNode10 = null;

        glueEbnfParser.glueConnection_return glueConnection11 = null;


        CommonTree TOPOLOGY5_tree=null;
        CommonTree IDENT6_tree=null;
        CommonTree char_literal8_tree=null;
        CommonTree char_literal12_tree=null;
        RewriteRuleTokenStream stream_TOPOLOGY=new RewriteRuleTokenStream(adaptor,"token TOPOLOGY");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleSubtreeStream stream_glueDomain=new RewriteRuleSubtreeStream(adaptor,"rule glueDomain");
        RewriteRuleSubtreeStream stream_glueNode=new RewriteRuleSubtreeStream(adaptor,"rule glueNode");
        RewriteRuleSubtreeStream stream_scoped_name_lang=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name_lang");
        RewriteRuleSubtreeStream stream_glueConnection=new RewriteRuleSubtreeStream(adaptor,"rule glueConnection");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:119:20: ( TOPOLOGY ( IDENT | scoped_name_lang ) '[' ( glueDomain | glueNode | glueConnection )* ']' -> ^( TOPOLOGY ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:119:22: TOPOLOGY ( IDENT | scoped_name_lang ) '[' ( glueDomain | glueNode | glueConnection )* ']'
            {
            TOPOLOGY5=(Token)match(input,TOPOLOGY,FOLLOW_TOPOLOGY_in_glueTopology150);  
            stream_TOPOLOGY.add(TOPOLOGY5);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:119:31: ( IDENT | scoped_name_lang )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENT) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==41) ) {
                    alt2=2;
                }
                else if ( (LA2_1==35) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:119:32: IDENT
                    {
                    IDENT6=(Token)match(input,IDENT,FOLLOW_IDENT_in_glueTopology153);  
                    stream_IDENT.add(IDENT6);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:119:40: scoped_name_lang
                    {
                    pushFollow(FOLLOW_scoped_name_lang_in_glueTopology157);
                    scoped_name_lang7=scoped_name_lang();

                    state._fsp--;

                    stream_scoped_name_lang.add(scoped_name_lang7.getTree());

                    }
                    break;

            }

            char_literal8=(Token)match(input,35,FOLLOW_35_in_glueTopology160);  
            stream_35.add(char_literal8);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:119:62: ( glueDomain | glueNode | glueConnection )*
            loop3:
            do {
                int alt3=4;
                switch ( input.LA(1) ) {
                case DOMAIN:
                    {
                    alt3=1;
                    }
                    break;
                case NODE:
                    {
                    alt3=2;
                    }
                    break;
                case CONNECTION:
                    {
                    alt3=3;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:119:63: glueDomain
            	    {
            	    pushFollow(FOLLOW_glueDomain_in_glueTopology163);
            	    glueDomain9=glueDomain();

            	    state._fsp--;

            	    stream_glueDomain.add(glueDomain9.getTree());

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:119:76: glueNode
            	    {
            	    pushFollow(FOLLOW_glueNode_in_glueTopology167);
            	    glueNode10=glueNode();

            	    state._fsp--;

            	    stream_glueNode.add(glueNode10.getTree());

            	    }
            	    break;
            	case 3 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:119:87: glueConnection
            	    {
            	    pushFollow(FOLLOW_glueConnection_in_glueTopology171);
            	    glueConnection11=glueConnection();

            	    state._fsp--;

            	    stream_glueConnection.add(glueConnection11.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            char_literal12=(Token)match(input,36,FOLLOW_36_in_glueTopology175);  
            stream_36.add(char_literal12);



            // AST REWRITE
            // elements: glueDomain, TOPOLOGY, glueNode, glueConnection, scoped_name_lang, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 120:22: -> ^( TOPOLOGY ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:120:25: ^( TOPOLOGY ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_TOPOLOGY.nextNode(), root_1);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:120:36: ( IDENT )?
                if ( stream_IDENT.hasNext() ) {
                    adaptor.addChild(root_1, stream_IDENT.nextNode());

                }
                stream_IDENT.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:120:43: ( scoped_name_lang )?
                if ( stream_scoped_name_lang.hasNext() ) {
                    adaptor.addChild(root_1, stream_scoped_name_lang.nextTree());

                }
                stream_scoped_name_lang.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:120:61: ( glueDomain )*
                while ( stream_glueDomain.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueDomain.nextTree());

                }
                stream_glueDomain.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:120:73: ( glueNode )*
                while ( stream_glueNode.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueNode.nextTree());

                }
                stream_glueNode.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:120:83: ( glueConnection )*
                while ( stream_glueConnection.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueConnection.nextTree());

                }
                stream_glueConnection.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueTopology"

    public static class glueDomain_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueDomain"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:1: glueDomain : DOMAIN ( IDENT | scoped_name_lang ) '[' ( glueDomain | glueNode | glueConnection | gluePort )* ( glueContracts )? ( gluePolicies )? ( '{' key_value_list '}' )? ']' -> ^( DOMAIN ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) ;
    public final glueEbnfParser.glueDomain_return glueDomain() throws RecognitionException {
        glueEbnfParser.glueDomain_return retval = new glueEbnfParser.glueDomain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DOMAIN13=null;
        Token IDENT14=null;
        Token char_literal16=null;
        Token char_literal23=null;
        Token char_literal25=null;
        Token char_literal26=null;
        glueEbnfParser.scoped_name_lang_return scoped_name_lang15 = null;

        glueEbnfParser.glueDomain_return glueDomain17 = null;

        glueEbnfParser.glueNode_return glueNode18 = null;

        glueEbnfParser.glueConnection_return glueConnection19 = null;

        glueEbnfParser.gluePort_return gluePort20 = null;

        glueEbnfParser.glueContracts_return glueContracts21 = null;

        glueEbnfParser.gluePolicies_return gluePolicies22 = null;

        glueEbnfParser.key_value_list_return key_value_list24 = null;


        CommonTree DOMAIN13_tree=null;
        CommonTree IDENT14_tree=null;
        CommonTree char_literal16_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree char_literal26_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_DOMAIN=new RewriteRuleTokenStream(adaptor,"token DOMAIN");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_gluePolicies=new RewriteRuleSubtreeStream(adaptor,"rule gluePolicies");
        RewriteRuleSubtreeStream stream_glueDomain=new RewriteRuleSubtreeStream(adaptor,"rule glueDomain");
        RewriteRuleSubtreeStream stream_glueContracts=new RewriteRuleSubtreeStream(adaptor,"rule glueContracts");
        RewriteRuleSubtreeStream stream_glueNode=new RewriteRuleSubtreeStream(adaptor,"rule glueNode");
        RewriteRuleSubtreeStream stream_gluePort=new RewriteRuleSubtreeStream(adaptor,"rule gluePort");
        RewriteRuleSubtreeStream stream_scoped_name_lang=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name_lang");
        RewriteRuleSubtreeStream stream_glueConnection=new RewriteRuleSubtreeStream(adaptor,"rule glueConnection");
        RewriteRuleSubtreeStream stream_key_value_list=new RewriteRuleSubtreeStream(adaptor,"rule key_value_list");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:20: ( DOMAIN ( IDENT | scoped_name_lang ) '[' ( glueDomain | glueNode | glueConnection | gluePort )* ( glueContracts )? ( gluePolicies )? ( '{' key_value_list '}' )? ']' -> ^( DOMAIN ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:22: DOMAIN ( IDENT | scoped_name_lang ) '[' ( glueDomain | glueNode | glueConnection | gluePort )* ( glueContracts )? ( gluePolicies )? ( '{' key_value_list '}' )? ']'
            {
            DOMAIN13=(Token)match(input,DOMAIN,FOLLOW_DOMAIN_in_glueDomain233);  
            stream_DOMAIN.add(DOMAIN13);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:29: ( IDENT | scoped_name_lang )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENT) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==41) ) {
                    alt4=2;
                }
                else if ( (LA4_1==35) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:30: IDENT
                    {
                    IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_glueDomain236);  
                    stream_IDENT.add(IDENT14);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:38: scoped_name_lang
                    {
                    pushFollow(FOLLOW_scoped_name_lang_in_glueDomain240);
                    scoped_name_lang15=scoped_name_lang();

                    state._fsp--;

                    stream_scoped_name_lang.add(scoped_name_lang15.getTree());

                    }
                    break;

            }

            char_literal16=(Token)match(input,35,FOLLOW_35_in_glueDomain243);  
            stream_35.add(char_literal16);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:60: ( glueDomain | glueNode | glueConnection | gluePort )*
            loop5:
            do {
                int alt5=5;
                switch ( input.LA(1) ) {
                case DOMAIN:
                    {
                    alt5=1;
                    }
                    break;
                case NODE:
                    {
                    alt5=2;
                    }
                    break;
                case CONNECTION:
                    {
                    alt5=3;
                    }
                    break;
                case PORT:
                    {
                    alt5=4;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:61: glueDomain
            	    {
            	    pushFollow(FOLLOW_glueDomain_in_glueDomain246);
            	    glueDomain17=glueDomain();

            	    state._fsp--;

            	    stream_glueDomain.add(glueDomain17.getTree());

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:74: glueNode
            	    {
            	    pushFollow(FOLLOW_glueNode_in_glueDomain250);
            	    glueNode18=glueNode();

            	    state._fsp--;

            	    stream_glueNode.add(glueNode18.getTree());

            	    }
            	    break;
            	case 3 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:85: glueConnection
            	    {
            	    pushFollow(FOLLOW_glueConnection_in_glueDomain254);
            	    glueConnection19=glueConnection();

            	    state._fsp--;

            	    stream_glueConnection.add(glueConnection19.getTree());

            	    }
            	    break;
            	case 4 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:102: gluePort
            	    {
            	    pushFollow(FOLLOW_gluePort_in_glueDomain258);
            	    gluePort20=gluePort();

            	    state._fsp--;

            	    stream_gluePort.add(gluePort20.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:113: ( glueContracts )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==CONTRACTS) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:113: glueContracts
                    {
                    pushFollow(FOLLOW_glueContracts_in_glueDomain262);
                    glueContracts21=glueContracts();

                    state._fsp--;

                    stream_glueContracts.add(glueContracts21.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:128: ( gluePolicies )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==POLICIES) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:128: gluePolicies
                    {
                    pushFollow(FOLLOW_gluePolicies_in_glueDomain265);
                    gluePolicies22=gluePolicies();

                    state._fsp--;

                    stream_gluePolicies.add(gluePolicies22.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:142: ( '{' key_value_list '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==37) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:122:143: '{' key_value_list '}'
                    {
                    char_literal23=(Token)match(input,37,FOLLOW_37_in_glueDomain269);  
                    stream_37.add(char_literal23);

                    pushFollow(FOLLOW_key_value_list_in_glueDomain271);
                    key_value_list24=key_value_list();

                    state._fsp--;

                    stream_key_value_list.add(key_value_list24.getTree());
                    char_literal25=(Token)match(input,38,FOLLOW_38_in_glueDomain273);  
                    stream_38.add(char_literal25);


                    }
                    break;

            }

            char_literal26=(Token)match(input,36,FOLLOW_36_in_glueDomain277);  
            stream_36.add(char_literal26);



            // AST REWRITE
            // elements: glueNode, gluePolicies, IDENT, glueDomain, gluePort, scoped_name_lang, DOMAIN, glueContracts, key_value_list, glueConnection
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 123:22: -> ^( DOMAIN ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:123:25: ^( DOMAIN ( IDENT )? ( scoped_name_lang )? ( glueDomain )* ( glueNode )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_DOMAIN.nextNode(), root_1);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:123:34: ( IDENT )?
                if ( stream_IDENT.hasNext() ) {
                    adaptor.addChild(root_1, stream_IDENT.nextNode());

                }
                stream_IDENT.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:123:41: ( scoped_name_lang )?
                if ( stream_scoped_name_lang.hasNext() ) {
                    adaptor.addChild(root_1, stream_scoped_name_lang.nextTree());

                }
                stream_scoped_name_lang.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:123:59: ( glueDomain )*
                while ( stream_glueDomain.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueDomain.nextTree());

                }
                stream_glueDomain.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:123:71: ( glueNode )*
                while ( stream_glueNode.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueNode.nextTree());

                }
                stream_glueNode.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:123:81: ( glueConnection )*
                while ( stream_glueConnection.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueConnection.nextTree());

                }
                stream_glueConnection.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:123:97: ( gluePort )*
                while ( stream_gluePort.hasNext() ) {
                    adaptor.addChild(root_1, stream_gluePort.nextTree());

                }
                stream_gluePort.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:123:107: ( glueContracts )?
                if ( stream_glueContracts.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueContracts.nextTree());

                }
                stream_glueContracts.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:123:122: ( gluePolicies )?
                if ( stream_gluePolicies.hasNext() ) {
                    adaptor.addChild(root_1, stream_gluePolicies.nextTree());

                }
                stream_gluePolicies.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:123:136: ( key_value_list )?
                if ( stream_key_value_list.hasNext() ) {
                    adaptor.addChild(root_1, stream_key_value_list.nextTree());

                }
                stream_key_value_list.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueDomain"

    public static class glueNode_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueNode"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:1: glueNode : NODE ( IDENT | scoped_name_lang ) '[' ( glueComponent | glueConnection | gluePort )* ( glueContracts )? ( gluePolicies )? ( '{' key_value_list '}' )? ']' -> ^( NODE ( IDENT )? ( scoped_name_lang )? ( glueComponent )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) ;
    public final glueEbnfParser.glueNode_return glueNode() throws RecognitionException {
        glueEbnfParser.glueNode_return retval = new glueEbnfParser.glueNode_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NODE27=null;
        Token IDENT28=null;
        Token char_literal30=null;
        Token char_literal36=null;
        Token char_literal38=null;
        Token char_literal39=null;
        glueEbnfParser.scoped_name_lang_return scoped_name_lang29 = null;

        glueEbnfParser.glueComponent_return glueComponent31 = null;

        glueEbnfParser.glueConnection_return glueConnection32 = null;

        glueEbnfParser.gluePort_return gluePort33 = null;

        glueEbnfParser.glueContracts_return glueContracts34 = null;

        glueEbnfParser.gluePolicies_return gluePolicies35 = null;

        glueEbnfParser.key_value_list_return key_value_list37 = null;


        CommonTree NODE27_tree=null;
        CommonTree IDENT28_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree char_literal39_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_NODE=new RewriteRuleTokenStream(adaptor,"token NODE");
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_gluePolicies=new RewriteRuleSubtreeStream(adaptor,"rule gluePolicies");
        RewriteRuleSubtreeStream stream_glueContracts=new RewriteRuleSubtreeStream(adaptor,"rule glueContracts");
        RewriteRuleSubtreeStream stream_glueComponent=new RewriteRuleSubtreeStream(adaptor,"rule glueComponent");
        RewriteRuleSubtreeStream stream_gluePort=new RewriteRuleSubtreeStream(adaptor,"rule gluePort");
        RewriteRuleSubtreeStream stream_scoped_name_lang=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name_lang");
        RewriteRuleSubtreeStream stream_glueConnection=new RewriteRuleSubtreeStream(adaptor,"rule glueConnection");
        RewriteRuleSubtreeStream stream_key_value_list=new RewriteRuleSubtreeStream(adaptor,"rule key_value_list");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:20: ( NODE ( IDENT | scoped_name_lang ) '[' ( glueComponent | glueConnection | gluePort )* ( glueContracts )? ( gluePolicies )? ( '{' key_value_list '}' )? ']' -> ^( NODE ( IDENT )? ( scoped_name_lang )? ( glueComponent )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:22: NODE ( IDENT | scoped_name_lang ) '[' ( glueComponent | glueConnection | gluePort )* ( glueContracts )? ( gluePolicies )? ( '{' key_value_list '}' )? ']'
            {
            NODE27=(Token)match(input,NODE,FOLLOW_NODE_in_glueNode349);  
            stream_NODE.add(NODE27);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:27: ( IDENT | scoped_name_lang )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENT) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==41) ) {
                    alt9=2;
                }
                else if ( (LA9_1==35) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:28: IDENT
                    {
                    IDENT28=(Token)match(input,IDENT,FOLLOW_IDENT_in_glueNode352);  
                    stream_IDENT.add(IDENT28);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:36: scoped_name_lang
                    {
                    pushFollow(FOLLOW_scoped_name_lang_in_glueNode356);
                    scoped_name_lang29=scoped_name_lang();

                    state._fsp--;

                    stream_scoped_name_lang.add(scoped_name_lang29.getTree());

                    }
                    break;

            }

            char_literal30=(Token)match(input,35,FOLLOW_35_in_glueNode359);  
            stream_35.add(char_literal30);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:58: ( glueComponent | glueConnection | gluePort )*
            loop10:
            do {
                int alt10=4;
                switch ( input.LA(1) ) {
                case COMPONENT:
                    {
                    alt10=1;
                    }
                    break;
                case CONNECTION:
                    {
                    alt10=2;
                    }
                    break;
                case PORT:
                    {
                    alt10=3;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:59: glueComponent
            	    {
            	    pushFollow(FOLLOW_glueComponent_in_glueNode362);
            	    glueComponent31=glueComponent();

            	    state._fsp--;

            	    stream_glueComponent.add(glueComponent31.getTree());

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:75: glueConnection
            	    {
            	    pushFollow(FOLLOW_glueConnection_in_glueNode366);
            	    glueConnection32=glueConnection();

            	    state._fsp--;

            	    stream_glueConnection.add(glueConnection32.getTree());

            	    }
            	    break;
            	case 3 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:92: gluePort
            	    {
            	    pushFollow(FOLLOW_gluePort_in_glueNode370);
            	    gluePort33=gluePort();

            	    state._fsp--;

            	    stream_gluePort.add(gluePort33.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:103: ( glueContracts )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==CONTRACTS) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:103: glueContracts
                    {
                    pushFollow(FOLLOW_glueContracts_in_glueNode374);
                    glueContracts34=glueContracts();

                    state._fsp--;

                    stream_glueContracts.add(glueContracts34.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:118: ( gluePolicies )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==POLICIES) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:118: gluePolicies
                    {
                    pushFollow(FOLLOW_gluePolicies_in_glueNode377);
                    gluePolicies35=gluePolicies();

                    state._fsp--;

                    stream_gluePolicies.add(gluePolicies35.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:132: ( '{' key_value_list '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==37) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:125:133: '{' key_value_list '}'
                    {
                    char_literal36=(Token)match(input,37,FOLLOW_37_in_glueNode381);  
                    stream_37.add(char_literal36);

                    pushFollow(FOLLOW_key_value_list_in_glueNode383);
                    key_value_list37=key_value_list();

                    state._fsp--;

                    stream_key_value_list.add(key_value_list37.getTree());
                    char_literal38=(Token)match(input,38,FOLLOW_38_in_glueNode385);  
                    stream_38.add(char_literal38);


                    }
                    break;

            }

            char_literal39=(Token)match(input,36,FOLLOW_36_in_glueNode389);  
            stream_36.add(char_literal39);



            // AST REWRITE
            // elements: glueContracts, gluePort, glueComponent, key_value_list, NODE, scoped_name_lang, IDENT, gluePolicies, glueConnection
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 126:22: -> ^( NODE ( IDENT )? ( scoped_name_lang )? ( glueComponent )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:126:25: ^( NODE ( IDENT )? ( scoped_name_lang )? ( glueComponent )* ( glueConnection )* ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_NODE.nextNode(), root_1);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:126:32: ( IDENT )?
                if ( stream_IDENT.hasNext() ) {
                    adaptor.addChild(root_1, stream_IDENT.nextNode());

                }
                stream_IDENT.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:126:39: ( scoped_name_lang )?
                if ( stream_scoped_name_lang.hasNext() ) {
                    adaptor.addChild(root_1, stream_scoped_name_lang.nextTree());

                }
                stream_scoped_name_lang.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:126:57: ( glueComponent )*
                while ( stream_glueComponent.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueComponent.nextTree());

                }
                stream_glueComponent.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:126:72: ( glueConnection )*
                while ( stream_glueConnection.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueConnection.nextTree());

                }
                stream_glueConnection.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:126:88: ( gluePort )*
                while ( stream_gluePort.hasNext() ) {
                    adaptor.addChild(root_1, stream_gluePort.nextTree());

                }
                stream_gluePort.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:126:98: ( glueContracts )?
                if ( stream_glueContracts.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueContracts.nextTree());

                }
                stream_glueContracts.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:126:113: ( gluePolicies )?
                if ( stream_gluePolicies.hasNext() ) {
                    adaptor.addChild(root_1, stream_gluePolicies.nextTree());

                }
                stream_gluePolicies.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:126:127: ( key_value_list )?
                if ( stream_key_value_list.hasNext() ) {
                    adaptor.addChild(root_1, stream_key_value_list.nextTree());

                }
                stream_key_value_list.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueNode"

    public static class glueConnection_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueConnection"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:128:1: glueConnection : CONNECTION IDENT '[' ( DIRECTED )? glueSource glueTarget ']' -> ^( CONNECTION IDENT ( DIRECTED )? glueSource glueTarget ) ;
    public final glueEbnfParser.glueConnection_return glueConnection() throws RecognitionException {
        glueEbnfParser.glueConnection_return retval = new glueEbnfParser.glueConnection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONNECTION40=null;
        Token IDENT41=null;
        Token char_literal42=null;
        Token DIRECTED43=null;
        Token char_literal46=null;
        glueEbnfParser.glueSource_return glueSource44 = null;

        glueEbnfParser.glueTarget_return glueTarget45 = null;


        CommonTree CONNECTION40_tree=null;
        CommonTree IDENT41_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree DIRECTED43_tree=null;
        CommonTree char_literal46_tree=null;
        RewriteRuleTokenStream stream_CONNECTION=new RewriteRuleTokenStream(adaptor,"token CONNECTION");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_DIRECTED=new RewriteRuleTokenStream(adaptor,"token DIRECTED");
        RewriteRuleSubtreeStream stream_glueSource=new RewriteRuleSubtreeStream(adaptor,"rule glueSource");
        RewriteRuleSubtreeStream stream_glueTarget=new RewriteRuleSubtreeStream(adaptor,"rule glueTarget");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:128:20: ( CONNECTION IDENT '[' ( DIRECTED )? glueSource glueTarget ']' -> ^( CONNECTION IDENT ( DIRECTED )? glueSource glueTarget ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:128:22: CONNECTION IDENT '[' ( DIRECTED )? glueSource glueTarget ']'
            {
            CONNECTION40=(Token)match(input,CONNECTION,FOLLOW_CONNECTION_in_glueConnection452);  
            stream_CONNECTION.add(CONNECTION40);

            IDENT41=(Token)match(input,IDENT,FOLLOW_IDENT_in_glueConnection454);  
            stream_IDENT.add(IDENT41);

            char_literal42=(Token)match(input,35,FOLLOW_35_in_glueConnection456);  
            stream_35.add(char_literal42);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:128:43: ( DIRECTED )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==DIRECTED) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:128:43: DIRECTED
                    {
                    DIRECTED43=(Token)match(input,DIRECTED,FOLLOW_DIRECTED_in_glueConnection458);  
                    stream_DIRECTED.add(DIRECTED43);


                    }
                    break;

            }

            pushFollow(FOLLOW_glueSource_in_glueConnection461);
            glueSource44=glueSource();

            state._fsp--;

            stream_glueSource.add(glueSource44.getTree());
            pushFollow(FOLLOW_glueTarget_in_glueConnection463);
            glueTarget45=glueTarget();

            state._fsp--;

            stream_glueTarget.add(glueTarget45.getTree());
            char_literal46=(Token)match(input,36,FOLLOW_36_in_glueConnection465);  
            stream_36.add(char_literal46);



            // AST REWRITE
            // elements: glueTarget, DIRECTED, CONNECTION, glueSource, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 129:22: -> ^( CONNECTION IDENT ( DIRECTED )? glueSource glueTarget )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:129:25: ^( CONNECTION IDENT ( DIRECTED )? glueSource glueTarget )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_CONNECTION.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:129:44: ( DIRECTED )?
                if ( stream_DIRECTED.hasNext() ) {
                    adaptor.addChild(root_1, stream_DIRECTED.nextNode());

                }
                stream_DIRECTED.reset();
                adaptor.addChild(root_1, stream_glueSource.nextTree());
                adaptor.addChild(root_1, stream_glueTarget.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueConnection"

    public static class glueSource_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueSource"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:131:1: glueSource : SOURCE '=' scoped_name ( glueSourcePort )? -> ^( SOURCE scoped_name ( glueSourcePort )? ) ;
    public final glueEbnfParser.glueSource_return glueSource() throws RecognitionException {
        glueEbnfParser.glueSource_return retval = new glueEbnfParser.glueSource_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SOURCE47=null;
        Token char_literal48=null;
        glueEbnfParser.scoped_name_return scoped_name49 = null;

        glueEbnfParser.glueSourcePort_return glueSourcePort50 = null;


        CommonTree SOURCE47_tree=null;
        CommonTree char_literal48_tree=null;
        RewriteRuleTokenStream stream_SOURCE=new RewriteRuleTokenStream(adaptor,"token SOURCE");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_glueSourcePort=new RewriteRuleSubtreeStream(adaptor,"rule glueSourcePort");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:131:20: ( SOURCE '=' scoped_name ( glueSourcePort )? -> ^( SOURCE scoped_name ( glueSourcePort )? ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:131:22: SOURCE '=' scoped_name ( glueSourcePort )?
            {
            SOURCE47=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_glueSource517);  
            stream_SOURCE.add(SOURCE47);

            char_literal48=(Token)match(input,39,FOLLOW_39_in_glueSource519);  
            stream_39.add(char_literal48);

            pushFollow(FOLLOW_scoped_name_in_glueSource521);
            scoped_name49=scoped_name();

            state._fsp--;

            stream_scoped_name.add(scoped_name49.getTree());
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:131:45: ( glueSourcePort )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==SOURCEPORT) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:131:45: glueSourcePort
                    {
                    pushFollow(FOLLOW_glueSourcePort_in_glueSource523);
                    glueSourcePort50=glueSourcePort();

                    state._fsp--;

                    stream_glueSourcePort.add(glueSourcePort50.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: scoped_name, glueSourcePort, SOURCE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 132:22: -> ^( SOURCE scoped_name ( glueSourcePort )? )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:132:25: ^( SOURCE scoped_name ( glueSourcePort )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_SOURCE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_scoped_name.nextTree());
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:132:46: ( glueSourcePort )?
                if ( stream_glueSourcePort.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueSourcePort.nextTree());

                }
                stream_glueSourcePort.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueSource"

    public static class glueTarget_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueTarget"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:133:1: glueTarget : TARGET '=' scoped_name ( glueTargetPort )? -> ^( TARGET scoped_name ( glueTargetPort )? ) ;
    public final glueEbnfParser.glueTarget_return glueTarget() throws RecognitionException {
        glueEbnfParser.glueTarget_return retval = new glueEbnfParser.glueTarget_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TARGET51=null;
        Token char_literal52=null;
        glueEbnfParser.scoped_name_return scoped_name53 = null;

        glueEbnfParser.glueTargetPort_return glueTargetPort54 = null;


        CommonTree TARGET51_tree=null;
        CommonTree char_literal52_tree=null;
        RewriteRuleTokenStream stream_TARGET=new RewriteRuleTokenStream(adaptor,"token TARGET");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_glueTargetPort=new RewriteRuleSubtreeStream(adaptor,"rule glueTargetPort");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:133:20: ( TARGET '=' scoped_name ( glueTargetPort )? -> ^( TARGET scoped_name ( glueTargetPort )? ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:133:22: TARGET '=' scoped_name ( glueTargetPort )?
            {
            TARGET51=(Token)match(input,TARGET,FOLLOW_TARGET_in_glueTarget571);  
            stream_TARGET.add(TARGET51);

            char_literal52=(Token)match(input,39,FOLLOW_39_in_glueTarget573);  
            stream_39.add(char_literal52);

            pushFollow(FOLLOW_scoped_name_in_glueTarget575);
            scoped_name53=scoped_name();

            state._fsp--;

            stream_scoped_name.add(scoped_name53.getTree());
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:133:45: ( glueTargetPort )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==TARGETPORT) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:133:45: glueTargetPort
                    {
                    pushFollow(FOLLOW_glueTargetPort_in_glueTarget577);
                    glueTargetPort54=glueTargetPort();

                    state._fsp--;

                    stream_glueTargetPort.add(glueTargetPort54.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: scoped_name, glueTargetPort, TARGET
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 134:22: -> ^( TARGET scoped_name ( glueTargetPort )? )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:134:25: ^( TARGET scoped_name ( glueTargetPort )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_TARGET.nextNode(), root_1);

                adaptor.addChild(root_1, stream_scoped_name.nextTree());
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:134:46: ( glueTargetPort )?
                if ( stream_glueTargetPort.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueTargetPort.nextTree());

                }
                stream_glueTargetPort.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueTarget"

    public static class gluePort_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gluePort"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:136:1: gluePort : PORT '=' IDENT -> ^( PORT IDENT ) ;
    public final glueEbnfParser.gluePort_return gluePort() throws RecognitionException {
        glueEbnfParser.gluePort_return retval = new glueEbnfParser.gluePort_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PORT55=null;
        Token char_literal56=null;
        Token IDENT57=null;

        CommonTree PORT55_tree=null;
        CommonTree char_literal56_tree=null;
        CommonTree IDENT57_tree=null;
        RewriteRuleTokenStream stream_PORT=new RewriteRuleTokenStream(adaptor,"token PORT");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:136:20: ( PORT '=' IDENT -> ^( PORT IDENT ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:136:22: PORT '=' IDENT
            {
            PORT55=(Token)match(input,PORT,FOLLOW_PORT_in_gluePort628);  
            stream_PORT.add(PORT55);

            char_literal56=(Token)match(input,39,FOLLOW_39_in_gluePort630);  
            stream_39.add(char_literal56);

            IDENT57=(Token)match(input,IDENT,FOLLOW_IDENT_in_gluePort632);  
            stream_IDENT.add(IDENT57);



            // AST REWRITE
            // elements: PORT, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 137:22: -> ^( PORT IDENT )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:137:25: ^( PORT IDENT )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_PORT.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gluePort"

    public static class glueSourcePort_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueSourcePort"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:139:1: glueSourcePort : SOURCEPORT '=' scoped_name -> ^( SOURCEPORT scoped_name ) ;
    public final glueEbnfParser.glueSourcePort_return glueSourcePort() throws RecognitionException {
        glueEbnfParser.glueSourcePort_return retval = new glueEbnfParser.glueSourcePort_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SOURCEPORT58=null;
        Token char_literal59=null;
        glueEbnfParser.scoped_name_return scoped_name60 = null;


        CommonTree SOURCEPORT58_tree=null;
        CommonTree char_literal59_tree=null;
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_SOURCEPORT=new RewriteRuleTokenStream(adaptor,"token SOURCEPORT");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:139:20: ( SOURCEPORT '=' scoped_name -> ^( SOURCEPORT scoped_name ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:139:22: SOURCEPORT '=' scoped_name
            {
            SOURCEPORT58=(Token)match(input,SOURCEPORT,FOLLOW_SOURCEPORT_in_glueSourcePort673);  
            stream_SOURCEPORT.add(SOURCEPORT58);

            char_literal59=(Token)match(input,39,FOLLOW_39_in_glueSourcePort675);  
            stream_39.add(char_literal59);

            pushFollow(FOLLOW_scoped_name_in_glueSourcePort677);
            scoped_name60=scoped_name();

            state._fsp--;

            stream_scoped_name.add(scoped_name60.getTree());


            // AST REWRITE
            // elements: SOURCEPORT, scoped_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 140:22: -> ^( SOURCEPORT scoped_name )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:140:25: ^( SOURCEPORT scoped_name )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_SOURCEPORT.nextNode(), root_1);

                adaptor.addChild(root_1, stream_scoped_name.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueSourcePort"

    public static class glueTargetPort_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueTargetPort"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:141:1: glueTargetPort : TARGETPORT '=' scoped_name -> ^( TARGETPORT scoped_name ) ;
    public final glueEbnfParser.glueTargetPort_return glueTargetPort() throws RecognitionException {
        glueEbnfParser.glueTargetPort_return retval = new glueEbnfParser.glueTargetPort_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TARGETPORT61=null;
        Token char_literal62=null;
        glueEbnfParser.scoped_name_return scoped_name63 = null;


        CommonTree TARGETPORT61_tree=null;
        CommonTree char_literal62_tree=null;
        RewriteRuleTokenStream stream_TARGETPORT=new RewriteRuleTokenStream(adaptor,"token TARGETPORT");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:141:20: ( TARGETPORT '=' scoped_name -> ^( TARGETPORT scoped_name ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:141:22: TARGETPORT '=' scoped_name
            {
            TARGETPORT61=(Token)match(input,TARGETPORT,FOLLOW_TARGETPORT_in_glueTargetPort717);  
            stream_TARGETPORT.add(TARGETPORT61);

            char_literal62=(Token)match(input,39,FOLLOW_39_in_glueTargetPort719);  
            stream_39.add(char_literal62);

            pushFollow(FOLLOW_scoped_name_in_glueTargetPort721);
            scoped_name63=scoped_name();

            state._fsp--;

            stream_scoped_name.add(scoped_name63.getTree());


            // AST REWRITE
            // elements: TARGETPORT, scoped_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 142:22: -> ^( TARGETPORT scoped_name )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:142:25: ^( TARGETPORT scoped_name )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_TARGETPORT.nextNode(), root_1);

                adaptor.addChild(root_1, stream_scoped_name.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueTargetPort"

    public static class glueComponent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueComponent"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:1: glueComponent : COMPONENT ( IDENT | scoped_name_lang ) '[' ( gluePort )* ( glueContracts )? ( gluePolicies )? ( '{' key_value_list '}' )? ']' -> ^( COMPONENT ( IDENT )? ( scoped_name_lang )? ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) ;
    public final glueEbnfParser.glueComponent_return glueComponent() throws RecognitionException {
        glueEbnfParser.glueComponent_return retval = new glueEbnfParser.glueComponent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMPONENT64=null;
        Token IDENT65=null;
        Token char_literal67=null;
        Token char_literal71=null;
        Token char_literal73=null;
        Token char_literal74=null;
        glueEbnfParser.scoped_name_lang_return scoped_name_lang66 = null;

        glueEbnfParser.gluePort_return gluePort68 = null;

        glueEbnfParser.glueContracts_return glueContracts69 = null;

        glueEbnfParser.gluePolicies_return gluePolicies70 = null;

        glueEbnfParser.key_value_list_return key_value_list72 = null;


        CommonTree COMPONENT64_tree=null;
        CommonTree IDENT65_tree=null;
        CommonTree char_literal67_tree=null;
        CommonTree char_literal71_tree=null;
        CommonTree char_literal73_tree=null;
        CommonTree char_literal74_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_COMPONENT=new RewriteRuleTokenStream(adaptor,"token COMPONENT");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_gluePolicies=new RewriteRuleSubtreeStream(adaptor,"rule gluePolicies");
        RewriteRuleSubtreeStream stream_glueContracts=new RewriteRuleSubtreeStream(adaptor,"rule glueContracts");
        RewriteRuleSubtreeStream stream_gluePort=new RewriteRuleSubtreeStream(adaptor,"rule gluePort");
        RewriteRuleSubtreeStream stream_scoped_name_lang=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name_lang");
        RewriteRuleSubtreeStream stream_key_value_list=new RewriteRuleSubtreeStream(adaptor,"rule key_value_list");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:20: ( COMPONENT ( IDENT | scoped_name_lang ) '[' ( gluePort )* ( glueContracts )? ( gluePolicies )? ( '{' key_value_list '}' )? ']' -> ^( COMPONENT ( IDENT )? ( scoped_name_lang )? ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:22: COMPONENT ( IDENT | scoped_name_lang ) '[' ( gluePort )* ( glueContracts )? ( gluePolicies )? ( '{' key_value_list '}' )? ']'
            {
            COMPONENT64=(Token)match(input,COMPONENT,FOLLOW_COMPONENT_in_glueComponent763);  
            stream_COMPONENT.add(COMPONENT64);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:32: ( IDENT | scoped_name_lang )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==IDENT) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==41) ) {
                    alt17=2;
                }
                else if ( (LA17_1==35) ) {
                    alt17=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:33: IDENT
                    {
                    IDENT65=(Token)match(input,IDENT,FOLLOW_IDENT_in_glueComponent766);  
                    stream_IDENT.add(IDENT65);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:41: scoped_name_lang
                    {
                    pushFollow(FOLLOW_scoped_name_lang_in_glueComponent770);
                    scoped_name_lang66=scoped_name_lang();

                    state._fsp--;

                    stream_scoped_name_lang.add(scoped_name_lang66.getTree());

                    }
                    break;

            }

            char_literal67=(Token)match(input,35,FOLLOW_35_in_glueComponent773);  
            stream_35.add(char_literal67);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:63: ( gluePort )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==PORT) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:64: gluePort
            	    {
            	    pushFollow(FOLLOW_gluePort_in_glueComponent776);
            	    gluePort68=gluePort();

            	    state._fsp--;

            	    stream_gluePort.add(gluePort68.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:75: ( glueContracts )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==CONTRACTS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:75: glueContracts
                    {
                    pushFollow(FOLLOW_glueContracts_in_glueComponent780);
                    glueContracts69=glueContracts();

                    state._fsp--;

                    stream_glueContracts.add(glueContracts69.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:90: ( gluePolicies )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==POLICIES) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:90: gluePolicies
                    {
                    pushFollow(FOLLOW_gluePolicies_in_glueComponent783);
                    gluePolicies70=gluePolicies();

                    state._fsp--;

                    stream_gluePolicies.add(gluePolicies70.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:104: ( '{' key_value_list '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==37) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:144:105: '{' key_value_list '}'
                    {
                    char_literal71=(Token)match(input,37,FOLLOW_37_in_glueComponent787);  
                    stream_37.add(char_literal71);

                    pushFollow(FOLLOW_key_value_list_in_glueComponent789);
                    key_value_list72=key_value_list();

                    state._fsp--;

                    stream_key_value_list.add(key_value_list72.getTree());
                    char_literal73=(Token)match(input,38,FOLLOW_38_in_glueComponent791);  
                    stream_38.add(char_literal73);


                    }
                    break;

            }

            char_literal74=(Token)match(input,36,FOLLOW_36_in_glueComponent795);  
            stream_36.add(char_literal74);



            // AST REWRITE
            // elements: gluePort, COMPONENT, gluePolicies, IDENT, key_value_list, glueContracts, scoped_name_lang
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 145:22: -> ^( COMPONENT ( IDENT )? ( scoped_name_lang )? ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:145:25: ^( COMPONENT ( IDENT )? ( scoped_name_lang )? ( gluePort )* ( glueContracts )? ( gluePolicies )? ( key_value_list )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_COMPONENT.nextNode(), root_1);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:145:37: ( IDENT )?
                if ( stream_IDENT.hasNext() ) {
                    adaptor.addChild(root_1, stream_IDENT.nextNode());

                }
                stream_IDENT.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:145:44: ( scoped_name_lang )?
                if ( stream_scoped_name_lang.hasNext() ) {
                    adaptor.addChild(root_1, stream_scoped_name_lang.nextTree());

                }
                stream_scoped_name_lang.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:145:62: ( gluePort )*
                while ( stream_gluePort.hasNext() ) {
                    adaptor.addChild(root_1, stream_gluePort.nextTree());

                }
                stream_gluePort.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:145:72: ( glueContracts )?
                if ( stream_glueContracts.hasNext() ) {
                    adaptor.addChild(root_1, stream_glueContracts.nextTree());

                }
                stream_glueContracts.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:145:87: ( gluePolicies )?
                if ( stream_gluePolicies.hasNext() ) {
                    adaptor.addChild(root_1, stream_gluePolicies.nextTree());

                }
                stream_gluePolicies.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:145:101: ( key_value_list )?
                if ( stream_key_value_list.hasNext() ) {
                    adaptor.addChild(root_1, stream_key_value_list.nextTree());

                }
                stream_key_value_list.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueComponent"

    public static class glueContracts_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "glueContracts"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:147:1: glueContracts : CONTRACTS ( '=' )? '{' ( scoped_name | scoped_name_lang )* '}' -> ^( CONTRACTS ( scoped_name )* ( scoped_name_lang )* ) ;
    public final glueEbnfParser.glueContracts_return glueContracts() throws RecognitionException {
        glueEbnfParser.glueContracts_return retval = new glueEbnfParser.glueContracts_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONTRACTS75=null;
        Token char_literal76=null;
        Token char_literal77=null;
        Token char_literal80=null;
        glueEbnfParser.scoped_name_return scoped_name78 = null;

        glueEbnfParser.scoped_name_lang_return scoped_name_lang79 = null;


        CommonTree CONTRACTS75_tree=null;
        CommonTree char_literal76_tree=null;
        CommonTree char_literal77_tree=null;
        CommonTree char_literal80_tree=null;
        RewriteRuleTokenStream stream_CONTRACTS=new RewriteRuleTokenStream(adaptor,"token CONTRACTS");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_scoped_name_lang=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name_lang");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:147:20: ( CONTRACTS ( '=' )? '{' ( scoped_name | scoped_name_lang )* '}' -> ^( CONTRACTS ( scoped_name )* ( scoped_name_lang )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:147:22: CONTRACTS ( '=' )? '{' ( scoped_name | scoped_name_lang )* '}'
            {
            CONTRACTS75=(Token)match(input,CONTRACTS,FOLLOW_CONTRACTS_in_glueContracts853);  
            stream_CONTRACTS.add(CONTRACTS75);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:147:32: ( '=' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==39) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:147:33: '='
                    {
                    char_literal76=(Token)match(input,39,FOLLOW_39_in_glueContracts856);  
                    stream_39.add(char_literal76);


                    }
                    break;

            }

            char_literal77=(Token)match(input,37,FOLLOW_37_in_glueContracts860);  
            stream_37.add(char_literal77);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:147:43: ( scoped_name | scoped_name_lang )*
            loop23:
            do {
                int alt23=3;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==IDENT) ) {
                    int LA23_2 = input.LA(2);

                    if ( (LA23_2==41) ) {
                        alt23=2;
                    }
                    else if ( (LA23_2==IDENT||LA23_2==38||LA23_2==40) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:147:44: scoped_name
            	    {
            	    pushFollow(FOLLOW_scoped_name_in_glueContracts863);
            	    scoped_name78=scoped_name();

            	    state._fsp--;

            	    stream_scoped_name.add(scoped_name78.getTree());

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:147:58: scoped_name_lang
            	    {
            	    pushFollow(FOLLOW_scoped_name_lang_in_glueContracts867);
            	    scoped_name_lang79=scoped_name_lang();

            	    state._fsp--;

            	    stream_scoped_name_lang.add(scoped_name_lang79.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            char_literal80=(Token)match(input,38,FOLLOW_38_in_glueContracts871);  
            stream_38.add(char_literal80);



            // AST REWRITE
            // elements: CONTRACTS, scoped_name, scoped_name_lang
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 148:22: -> ^( CONTRACTS ( scoped_name )* ( scoped_name_lang )* )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:148:25: ^( CONTRACTS ( scoped_name )* ( scoped_name_lang )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_CONTRACTS.nextNode(), root_1);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:148:37: ( scoped_name )*
                while ( stream_scoped_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_scoped_name.nextTree());

                }
                stream_scoped_name.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:148:50: ( scoped_name_lang )*
                while ( stream_scoped_name_lang.hasNext() ) {
                    adaptor.addChild(root_1, stream_scoped_name_lang.nextTree());

                }
                stream_scoped_name_lang.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "glueContracts"

    public static class gluePolicies_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gluePolicies"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:150:1: gluePolicies : POLICIES ( '=' )? '{' ( scoped_name | scoped_name_lang )* '}' -> ^( POLICIES ( scoped_name )* ( scoped_name_lang )* ) ;
    public final glueEbnfParser.gluePolicies_return gluePolicies() throws RecognitionException {
        glueEbnfParser.gluePolicies_return retval = new glueEbnfParser.gluePolicies_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLICIES81=null;
        Token char_literal82=null;
        Token char_literal83=null;
        Token char_literal86=null;
        glueEbnfParser.scoped_name_return scoped_name84 = null;

        glueEbnfParser.scoped_name_lang_return scoped_name_lang85 = null;


        CommonTree POLICIES81_tree=null;
        CommonTree char_literal82_tree=null;
        CommonTree char_literal83_tree=null;
        CommonTree char_literal86_tree=null;
        RewriteRuleTokenStream stream_POLICIES=new RewriteRuleTokenStream(adaptor,"token POLICIES");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_scoped_name_lang=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name_lang");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:150:20: ( POLICIES ( '=' )? '{' ( scoped_name | scoped_name_lang )* '}' -> ^( POLICIES ( scoped_name )* ( scoped_name_lang )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:150:22: POLICIES ( '=' )? '{' ( scoped_name | scoped_name_lang )* '}'
            {
            POLICIES81=(Token)match(input,POLICIES,FOLLOW_POLICIES_in_gluePolicies918);  
            stream_POLICIES.add(POLICIES81);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:150:31: ( '=' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==39) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:150:32: '='
                    {
                    char_literal82=(Token)match(input,39,FOLLOW_39_in_gluePolicies921);  
                    stream_39.add(char_literal82);


                    }
                    break;

            }

            char_literal83=(Token)match(input,37,FOLLOW_37_in_gluePolicies925);  
            stream_37.add(char_literal83);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:150:42: ( scoped_name | scoped_name_lang )*
            loop25:
            do {
                int alt25=3;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IDENT) ) {
                    int LA25_2 = input.LA(2);

                    if ( (LA25_2==41) ) {
                        alt25=2;
                    }
                    else if ( (LA25_2==IDENT||LA25_2==38||LA25_2==40) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:150:43: scoped_name
            	    {
            	    pushFollow(FOLLOW_scoped_name_in_gluePolicies928);
            	    scoped_name84=scoped_name();

            	    state._fsp--;

            	    stream_scoped_name.add(scoped_name84.getTree());

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:150:57: scoped_name_lang
            	    {
            	    pushFollow(FOLLOW_scoped_name_lang_in_gluePolicies932);
            	    scoped_name_lang85=scoped_name_lang();

            	    state._fsp--;

            	    stream_scoped_name_lang.add(scoped_name_lang85.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            char_literal86=(Token)match(input,38,FOLLOW_38_in_gluePolicies936);  
            stream_38.add(char_literal86);



            // AST REWRITE
            // elements: scoped_name_lang, scoped_name, POLICIES
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 151:22: -> ^( POLICIES ( scoped_name )* ( scoped_name_lang )* )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:151:25: ^( POLICIES ( scoped_name )* ( scoped_name_lang )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_POLICIES.nextNode(), root_1);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:151:36: ( scoped_name )*
                while ( stream_scoped_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_scoped_name.nextTree());

                }
                stream_scoped_name.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:151:49: ( scoped_name_lang )*
                while ( stream_scoped_name_lang.hasNext() ) {
                    adaptor.addChild(root_1, stream_scoped_name_lang.nextTree());

                }
                stream_scoped_name_lang.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gluePolicies"

    public static class scoped_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scoped_name"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:153:1: scoped_name : ( IDENT ( '::' IDENT )* '::' )? IDENT -> ^( AT_SCOPE ( IDENT )* ) ;
    public final glueEbnfParser.scoped_name_return scoped_name() throws RecognitionException {
        glueEbnfParser.scoped_name_return retval = new glueEbnfParser.scoped_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT87=null;
        Token string_literal88=null;
        Token IDENT89=null;
        Token string_literal90=null;
        Token IDENT91=null;

        CommonTree IDENT87_tree=null;
        CommonTree string_literal88_tree=null;
        CommonTree IDENT89_tree=null;
        CommonTree string_literal90_tree=null;
        CommonTree IDENT91_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:153:20: ( ( IDENT ( '::' IDENT )* '::' )? IDENT -> ^( AT_SCOPE ( IDENT )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:153:22: ( IDENT ( '::' IDENT )* '::' )? IDENT
            {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:153:22: ( IDENT ( '::' IDENT )* '::' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==IDENT) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==40) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:153:23: IDENT ( '::' IDENT )* '::'
                    {
                    IDENT87=(Token)match(input,IDENT,FOLLOW_IDENT_in_scoped_name985);  
                    stream_IDENT.add(IDENT87);

                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:153:29: ( '::' IDENT )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==40) ) {
                            int LA26_1 = input.LA(2);

                            if ( (LA26_1==IDENT) ) {
                                int LA26_2 = input.LA(3);

                                if ( (LA26_2==40) ) {
                                    alt26=1;
                                }


                            }


                        }


                        switch (alt26) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:153:30: '::' IDENT
                    	    {
                    	    string_literal88=(Token)match(input,40,FOLLOW_40_in_scoped_name988);  
                    	    stream_40.add(string_literal88);

                    	    IDENT89=(Token)match(input,IDENT,FOLLOW_IDENT_in_scoped_name990);  
                    	    stream_IDENT.add(IDENT89);


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    string_literal90=(Token)match(input,40,FOLLOW_40_in_scoped_name994);  
                    stream_40.add(string_literal90);


                    }
                    break;

            }

            IDENT91=(Token)match(input,IDENT,FOLLOW_IDENT_in_scoped_name998);  
            stream_IDENT.add(IDENT91);



            // AST REWRITE
            // elements: IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 153:56: -> ^( AT_SCOPE ( IDENT )* )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:153:59: ^( AT_SCOPE ( IDENT )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_SCOPE, "AT_SCOPE"), root_1);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:153:70: ( IDENT )*
                while ( stream_IDENT.hasNext() ) {
                    adaptor.addChild(root_1, stream_IDENT.nextNode());

                }
                stream_IDENT.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "scoped_name"

    public static class scoped_name_lang_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scoped_name_lang"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:154:1: scoped_name_lang : IDENT '@' scoped_name -> ^( AT_LANG IDENT scoped_name ) ;
    public final glueEbnfParser.scoped_name_lang_return scoped_name_lang() throws RecognitionException {
        glueEbnfParser.scoped_name_lang_return retval = new glueEbnfParser.scoped_name_lang_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT92=null;
        Token char_literal93=null;
        glueEbnfParser.scoped_name_return scoped_name94 = null;


        CommonTree IDENT92_tree=null;
        CommonTree char_literal93_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:154:20: ( IDENT '@' scoped_name -> ^( AT_LANG IDENT scoped_name ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:154:22: IDENT '@' scoped_name
            {
            IDENT92=(Token)match(input,IDENT,FOLLOW_IDENT_in_scoped_name_lang1016);  
            stream_IDENT.add(IDENT92);

            char_literal93=(Token)match(input,41,FOLLOW_41_in_scoped_name_lang1018);  
            stream_41.add(char_literal93);

            pushFollow(FOLLOW_scoped_name_in_scoped_name_lang1020);
            scoped_name94=scoped_name();

            state._fsp--;

            stream_scoped_name.add(scoped_name94.getTree());


            // AST REWRITE
            // elements: IDENT, scoped_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 154:44: -> ^( AT_LANG IDENT scoped_name )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:154:47: ^( AT_LANG IDENT scoped_name )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_LANG, "AT_LANG"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_scoped_name.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "scoped_name_lang"

    public static class key_value_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "key_value_list"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:156:1: key_value_list : key_value ( key_value )* -> ^( AT_KVL ( key_value )* ) ;
    public final glueEbnfParser.key_value_list_return key_value_list() throws RecognitionException {
        glueEbnfParser.key_value_list_return retval = new glueEbnfParser.key_value_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        glueEbnfParser.key_value_return key_value95 = null;

        glueEbnfParser.key_value_return key_value96 = null;


        RewriteRuleSubtreeStream stream_key_value=new RewriteRuleSubtreeStream(adaptor,"rule key_value");
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:156:20: ( key_value ( key_value )* -> ^( AT_KVL ( key_value )* ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:156:22: key_value ( key_value )*
            {
            pushFollow(FOLLOW_key_value_in_key_value_list1042);
            key_value95=key_value();

            state._fsp--;

            stream_key_value.add(key_value95.getTree());
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:156:32: ( key_value )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==IDENT||LA28_0==VAL_STRING) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:156:32: key_value
            	    {
            	    pushFollow(FOLLOW_key_value_in_key_value_list1044);
            	    key_value96=key_value();

            	    state._fsp--;

            	    stream_key_value.add(key_value96.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);



            // AST REWRITE
            // elements: key_value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 156:43: -> ^( AT_KVL ( key_value )* )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:156:46: ^( AT_KVL ( key_value )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_KVL, "AT_KVL"), root_1);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:156:55: ( key_value )*
                while ( stream_key_value.hasNext() ) {
                    adaptor.addChild(root_1, stream_key_value.nextTree());

                }
                stream_key_value.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "key_value_list"

    public static class key_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "key_value"
    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:1: key_value : ( IDENT | VAL_STRING ) '=' ( VAL_XSTRING | VAL_STRING ) -> ^( AT_KVL ^( AT_KVL ( IDENT )? ( VAL_STRING )? ) ^( AT_KVL ( VAL_XSTRING )? ( VAL_STRING )? ) ) ;
    public final glueEbnfParser.key_value_return key_value() throws RecognitionException {
        glueEbnfParser.key_value_return retval = new glueEbnfParser.key_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT97=null;
        Token VAL_STRING98=null;
        Token char_literal99=null;
        Token VAL_XSTRING100=null;
        Token VAL_STRING101=null;

        CommonTree IDENT97_tree=null;
        CommonTree VAL_STRING98_tree=null;
        CommonTree char_literal99_tree=null;
        CommonTree VAL_XSTRING100_tree=null;
        CommonTree VAL_STRING101_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_VAL_STRING=new RewriteRuleTokenStream(adaptor,"token VAL_STRING");
        RewriteRuleTokenStream stream_VAL_XSTRING=new RewriteRuleTokenStream(adaptor,"token VAL_XSTRING");

        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:20: ( ( IDENT | VAL_STRING ) '=' ( VAL_XSTRING | VAL_STRING ) -> ^( AT_KVL ^( AT_KVL ( IDENT )? ( VAL_STRING )? ) ^( AT_KVL ( VAL_XSTRING )? ( VAL_STRING )? ) ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:22: ( IDENT | VAL_STRING ) '=' ( VAL_XSTRING | VAL_STRING )
            {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:22: ( IDENT | VAL_STRING )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==IDENT) ) {
                alt29=1;
            }
            else if ( (LA29_0==VAL_STRING) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:23: IDENT
                    {
                    IDENT97=(Token)match(input,IDENT,FOLLOW_IDENT_in_key_value1071);  
                    stream_IDENT.add(IDENT97);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:31: VAL_STRING
                    {
                    VAL_STRING98=(Token)match(input,VAL_STRING,FOLLOW_VAL_STRING_in_key_value1075);  
                    stream_VAL_STRING.add(VAL_STRING98);


                    }
                    break;

            }

            char_literal99=(Token)match(input,39,FOLLOW_39_in_key_value1078);  
            stream_39.add(char_literal99);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:47: ( VAL_XSTRING | VAL_STRING )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==VAL_XSTRING) ) {
                alt30=1;
            }
            else if ( (LA30_0==VAL_STRING) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:48: VAL_XSTRING
                    {
                    VAL_XSTRING100=(Token)match(input,VAL_XSTRING,FOLLOW_VAL_XSTRING_in_key_value1081);  
                    stream_VAL_XSTRING.add(VAL_XSTRING100);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:62: VAL_STRING
                    {
                    VAL_STRING101=(Token)match(input,VAL_STRING,FOLLOW_VAL_STRING_in_key_value1085);  
                    stream_VAL_STRING.add(VAL_STRING101);


                    }
                    break;

            }



            // AST REWRITE
            // elements: IDENT, VAL_STRING, VAL_XSTRING, VAL_STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 157:74: -> ^( AT_KVL ^( AT_KVL ( IDENT )? ( VAL_STRING )? ) ^( AT_KVL ( VAL_XSTRING )? ( VAL_STRING )? ) )
            {
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:77: ^( AT_KVL ^( AT_KVL ( IDENT )? ( VAL_STRING )? ) ^( AT_KVL ( VAL_XSTRING )? ( VAL_STRING )? ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_KVL, "AT_KVL"), root_1);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:86: ^( AT_KVL ( IDENT )? ( VAL_STRING )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_KVL, "AT_KVL"), root_2);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:95: ( IDENT )?
                if ( stream_IDENT.hasNext() ) {
                    adaptor.addChild(root_2, stream_IDENT.nextNode());

                }
                stream_IDENT.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:102: ( VAL_STRING )?
                if ( stream_VAL_STRING.hasNext() ) {
                    adaptor.addChild(root_2, stream_VAL_STRING.nextNode());

                }
                stream_VAL_STRING.reset();

                adaptor.addChild(root_1, root_2);
                }
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:115: ^( AT_KVL ( VAL_XSTRING )? ( VAL_STRING )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_KVL, "AT_KVL"), root_2);

                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:124: ( VAL_XSTRING )?
                if ( stream_VAL_XSTRING.hasNext() ) {
                    adaptor.addChild(root_2, stream_VAL_XSTRING.nextNode());

                }
                stream_VAL_XSTRING.reset();
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:157:137: ( VAL_STRING )?
                if ( stream_VAL_STRING.hasNext() ) {
                    adaptor.addChild(root_2, stream_VAL_STRING.nextNode());

                }
                stream_VAL_STRING.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "key_value"

    // Delegated rules


 

    public static final BitSet FOLLOW_AT_SPEC_in_glueSpecification93 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_glueSpecification97 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_glueSpecification99 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_glueTopology_in_glueSpecification101 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EOF_in_glueSpecification104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOPOLOGY_in_glueTopology150 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_glueTopology153 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueTopology157 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_glueTopology160 = new BitSet(new long[]{0x0000001000000380L});
    public static final BitSet FOLLOW_glueDomain_in_glueTopology163 = new BitSet(new long[]{0x0000001000000380L});
    public static final BitSet FOLLOW_glueNode_in_glueTopology167 = new BitSet(new long[]{0x0000001000000380L});
    public static final BitSet FOLLOW_glueConnection_in_glueTopology171 = new BitSet(new long[]{0x0000001000000380L});
    public static final BitSet FOLLOW_36_in_glueTopology175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOMAIN_in_glueDomain233 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_glueDomain236 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueDomain240 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_glueDomain243 = new BitSet(new long[]{0x0000003000062380L});
    public static final BitSet FOLLOW_glueDomain_in_glueDomain246 = new BitSet(new long[]{0x0000003000062380L});
    public static final BitSet FOLLOW_glueNode_in_glueDomain250 = new BitSet(new long[]{0x0000003000062380L});
    public static final BitSet FOLLOW_glueConnection_in_glueDomain254 = new BitSet(new long[]{0x0000003000062380L});
    public static final BitSet FOLLOW_gluePort_in_glueDomain258 = new BitSet(new long[]{0x0000003000062380L});
    public static final BitSet FOLLOW_glueContracts_in_glueDomain262 = new BitSet(new long[]{0x0000003000040000L});
    public static final BitSet FOLLOW_gluePolicies_in_glueDomain265 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_37_in_glueDomain269 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_key_value_list_in_glueDomain271 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_glueDomain273 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_glueDomain277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NODE_in_glueNode349 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_glueNode352 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueNode356 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_glueNode359 = new BitSet(new long[]{0x0000003000072380L});
    public static final BitSet FOLLOW_glueComponent_in_glueNode362 = new BitSet(new long[]{0x0000003000072380L});
    public static final BitSet FOLLOW_glueConnection_in_glueNode366 = new BitSet(new long[]{0x0000003000072380L});
    public static final BitSet FOLLOW_gluePort_in_glueNode370 = new BitSet(new long[]{0x0000003000072380L});
    public static final BitSet FOLLOW_glueContracts_in_glueNode374 = new BitSet(new long[]{0x0000003000040000L});
    public static final BitSet FOLLOW_gluePolicies_in_glueNode377 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_37_in_glueNode381 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_key_value_list_in_glueNode383 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_glueNode385 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_glueNode389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONNECTION_in_glueConnection452 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_glueConnection454 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_glueConnection456 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_DIRECTED_in_glueConnection458 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_glueSource_in_glueConnection461 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_glueTarget_in_glueConnection463 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_glueConnection465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SOURCE_in_glueSource517 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_glueSource519 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_glueSource521 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_glueSourcePort_in_glueSource523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TARGET_in_glueTarget571 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_glueTarget573 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_glueTarget575 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_glueTargetPort_in_glueTarget577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PORT_in_gluePort628 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_gluePort630 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_gluePort632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SOURCEPORT_in_glueSourcePort673 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_glueSourcePort675 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_glueSourcePort677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TARGETPORT_in_glueTargetPort717 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_glueTargetPort719 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_glueTargetPort721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMPONENT_in_glueComponent763 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_glueComponent766 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueComponent770 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_glueComponent773 = new BitSet(new long[]{0x0000003000062380L});
    public static final BitSet FOLLOW_gluePort_in_glueComponent776 = new BitSet(new long[]{0x0000003000062380L});
    public static final BitSet FOLLOW_glueContracts_in_glueComponent780 = new BitSet(new long[]{0x0000003000040000L});
    public static final BitSet FOLLOW_gluePolicies_in_glueComponent783 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_37_in_glueComponent787 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_key_value_list_in_glueComponent789 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_glueComponent791 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_glueComponent795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTRACTS_in_glueContracts853 = new BitSet(new long[]{0x000000A000000000L});
    public static final BitSet FOLLOW_39_in_glueContracts856 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_glueContracts860 = new BitSet(new long[]{0x0000004000000020L});
    public static final BitSet FOLLOW_scoped_name_in_glueContracts863 = new BitSet(new long[]{0x0000004000000020L});
    public static final BitSet FOLLOW_scoped_name_lang_in_glueContracts867 = new BitSet(new long[]{0x0000004000000020L});
    public static final BitSet FOLLOW_38_in_glueContracts871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLICIES_in_gluePolicies918 = new BitSet(new long[]{0x000000A000000000L});
    public static final BitSet FOLLOW_39_in_gluePolicies921 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_gluePolicies925 = new BitSet(new long[]{0x0000004000000020L});
    public static final BitSet FOLLOW_scoped_name_in_gluePolicies928 = new BitSet(new long[]{0x0000004000000020L});
    public static final BitSet FOLLOW_scoped_name_lang_in_gluePolicies932 = new BitSet(new long[]{0x0000004000000020L});
    public static final BitSet FOLLOW_38_in_gluePolicies936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name985 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_scoped_name988 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name990 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_scoped_name994 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name_lang1016 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_scoped_name_lang1018 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_scoped_name_lang1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_key_value_in_key_value_list1042 = new BitSet(new long[]{0x0000000000080022L});
    public static final BitSet FOLLOW_key_value_in_key_value_list1044 = new BitSet(new long[]{0x0000000000080022L});
    public static final BitSet FOLLOW_IDENT_in_key_value1071 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_VAL_STRING_in_key_value1075 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_key_value1078 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_VAL_XSTRING_in_key_value1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_STRING_in_key_value1085 = new BitSet(new long[]{0x0000000000000002L});

}