// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g 2011-07-07 22:24:49

  package org.skb.lang.pola.proto.grammars;

  import java.util.LinkedHashMap;

  import org.skb.lang.pola.proto.PolaPass1_Ebnf;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.pola.proto.PolaTokensConstants;
  import org.skb.util.ReportManager;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class polaEbnfParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AT_STAGE", "AT_ENVIRONMENT", "AT_CLEVEL", "AT_LANGUAGE", "IDENT", "AT_SPEC", "CPP_DIRECTIVE", "POLA_POLICY", "POLA_DEONT_AUTH", "POLA_DEONT_EXEM", "POLA_DEONT_OBLG", "POLA_DEONT_PROH", "POLA_MEPO_DELE", "POLA_MEPO_REVO", "POLA_PC_LEVEL", "POLA_RULE_STRUCT_ECA", "POLA_RULE_STRUCT_GOAL", "POLA_RULE_STRUCT_UTIL", "POLA_EVENT", "POLA_GROUP", "POLA_COMPOSITE", "POLA_ATOMIC", "POLA_NONSTD", "POLA_CONDITION", "POLA_ACTION", "POLA_SEQ_NUMER", "VAL_INTEGER", "POLA_HASBEEN_EVALED", "VAL_DSTRING", "VOID", "SHORT", "INTEGER", "LONG", "OCTET", "HEX", "BINARY", "FLOAT", "DOUBLE", "CHAR", "STRING", "BOOLEAN", "VAL_OCT", "VAL_HEX", "VAL_BINARY", "VAL_FLOAT", "VAL_CHAR", "VAL_STRING", "POLA_NULL", "POLA_TRUE", "POLA_FALSE", "ARRAY", "BODY", "STRUCT", "TYPEDEF", "AT_PROVIDES", "AT_SCOPE", "WS", "SL_COMMENT", "ML_COMMENT", "ESC", "UnicodeEscape", "OctalEscape", "HexDigit", "OctDigit", "BinDigit", "Exponent", "FloatSuffix", "CPP_FILENAME", "'architecture'", "'model'", "'design'", "'development'", "'deployment'", "'runtime'", "'production'", "'test'", "'demonstrator'", "'business'", "'system'", "'element'", "';'", "'{'", "'}'", "'='", "'administration'", "'device'", "'instance'", "'::='", "':'", "'::'", "'['", "']'"
    };
    public static final int EOF=-1;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__95=95;
    public static final int AT_STAGE=4;
    public static final int AT_ENVIRONMENT=5;
    public static final int AT_CLEVEL=6;
    public static final int AT_LANGUAGE=7;
    public static final int IDENT=8;
    public static final int AT_SPEC=9;
    public static final int CPP_DIRECTIVE=10;
    public static final int POLA_POLICY=11;
    public static final int POLA_DEONT_AUTH=12;
    public static final int POLA_DEONT_EXEM=13;
    public static final int POLA_DEONT_OBLG=14;
    public static final int POLA_DEONT_PROH=15;
    public static final int POLA_MEPO_DELE=16;
    public static final int POLA_MEPO_REVO=17;
    public static final int POLA_PC_LEVEL=18;
    public static final int POLA_RULE_STRUCT_ECA=19;
    public static final int POLA_RULE_STRUCT_GOAL=20;
    public static final int POLA_RULE_STRUCT_UTIL=21;
    public static final int POLA_EVENT=22;
    public static final int POLA_GROUP=23;
    public static final int POLA_COMPOSITE=24;
    public static final int POLA_ATOMIC=25;
    public static final int POLA_NONSTD=26;
    public static final int POLA_CONDITION=27;
    public static final int POLA_ACTION=28;
    public static final int POLA_SEQ_NUMER=29;
    public static final int VAL_INTEGER=30;
    public static final int POLA_HASBEEN_EVALED=31;
    public static final int VAL_DSTRING=32;
    public static final int VOID=33;
    public static final int SHORT=34;
    public static final int INTEGER=35;
    public static final int LONG=36;
    public static final int OCTET=37;
    public static final int HEX=38;
    public static final int BINARY=39;
    public static final int FLOAT=40;
    public static final int DOUBLE=41;
    public static final int CHAR=42;
    public static final int STRING=43;
    public static final int BOOLEAN=44;
    public static final int VAL_OCT=45;
    public static final int VAL_HEX=46;
    public static final int VAL_BINARY=47;
    public static final int VAL_FLOAT=48;
    public static final int VAL_CHAR=49;
    public static final int VAL_STRING=50;
    public static final int POLA_NULL=51;
    public static final int POLA_TRUE=52;
    public static final int POLA_FALSE=53;
    public static final int ARRAY=54;
    public static final int BODY=55;
    public static final int STRUCT=56;
    public static final int TYPEDEF=57;
    public static final int AT_PROVIDES=58;
    public static final int AT_SCOPE=59;
    public static final int WS=60;
    public static final int SL_COMMENT=61;
    public static final int ML_COMMENT=62;
    public static final int ESC=63;
    public static final int UnicodeEscape=64;
    public static final int OctalEscape=65;
    public static final int HexDigit=66;
    public static final int OctDigit=67;
    public static final int BinDigit=68;
    public static final int Exponent=69;
    public static final int FloatSuffix=70;
    public static final int CPP_FILENAME=71;

    // delegates
    // delegators


        public polaEbnfParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public polaEbnfParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return polaEbnfParser.tokenNames; }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g"; }


      private LanguageTokens myTokens;
      private PolaPass1_Ebnf pass;
      private Token base_type;
      private boolean isArray=false;

      public void init() {
        this.pass=new PolaPass1_Ebnf();
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


    public static class a3dsStage_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "a3dsStage"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:114:1: a3dsStage : ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' );
    public final polaEbnfParser.a3dsStage_return a3dsStage() throws RecognitionException {
        polaEbnfParser.a3dsStage_return retval = new polaEbnfParser.a3dsStage_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set1=null;

        CommonTree set1_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:114:25: ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set1=(Token)input.LT(1);
            if ( (input.LA(1)>=72 && input.LA(1)<=77) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set1));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "a3dsStage"

    public static class a3dsEnvironment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "a3dsEnvironment"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:115:1: a3dsEnvironment : ( 'production' | 'test' | 'demonstrator' );
    public final polaEbnfParser.a3dsEnvironment_return a3dsEnvironment() throws RecognitionException {
        polaEbnfParser.a3dsEnvironment_return retval = new polaEbnfParser.a3dsEnvironment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set2=null;

        CommonTree set2_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:115:25: ( 'production' | 'test' | 'demonstrator' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set2=(Token)input.LT(1);
            if ( (input.LA(1)>=78 && input.LA(1)<=80) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set2));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "a3dsEnvironment"

    public static class a3dsCLevel_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "a3dsCLevel"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:116:1: a3dsCLevel : ( 'business' | 'system' | 'element' );
    public final polaEbnfParser.a3dsCLevel_return a3dsCLevel() throws RecognitionException {
        polaEbnfParser.a3dsCLevel_return retval = new polaEbnfParser.a3dsCLevel_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set3=null;

        CommonTree set3_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:116:25: ( 'business' | 'system' | 'element' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set3=(Token)input.LT(1);
            if ( (input.LA(1)>=81 && input.LA(1)<=83) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set3));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "a3dsCLevel"

    public static class polaSpecification_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "polaSpecification"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:118:1: polaSpecification : cpp_directive AT_STAGE a3dsStage ';' AT_ENVIRONMENT a3dsEnvironment ';' AT_CLEVEL a3dsCLevel ';' AT_LANGUAGE l= IDENT ';' AT_SPEC spec= IDENT ';' ( polaDefinition )* EOF -> ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE $l) ^( AT_SPEC $spec) cpp_directive ( polaDefinition )* ) ;
    public final polaEbnfParser.polaSpecification_return polaSpecification() throws RecognitionException {
        polaEbnfParser.polaSpecification_return retval = new polaEbnfParser.polaSpecification_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token l=null;
        Token spec=null;
        Token AT_STAGE5=null;
        Token char_literal7=null;
        Token AT_ENVIRONMENT8=null;
        Token char_literal10=null;
        Token AT_CLEVEL11=null;
        Token char_literal13=null;
        Token AT_LANGUAGE14=null;
        Token char_literal15=null;
        Token AT_SPEC16=null;
        Token char_literal17=null;
        Token EOF19=null;
        polaEbnfParser.cpp_directive_return cpp_directive4 = null;

        polaEbnfParser.a3dsStage_return a3dsStage6 = null;

        polaEbnfParser.a3dsEnvironment_return a3dsEnvironment9 = null;

        polaEbnfParser.a3dsCLevel_return a3dsCLevel12 = null;

        polaEbnfParser.polaDefinition_return polaDefinition18 = null;


        CommonTree l_tree=null;
        CommonTree spec_tree=null;
        CommonTree AT_STAGE5_tree=null;
        CommonTree char_literal7_tree=null;
        CommonTree AT_ENVIRONMENT8_tree=null;
        CommonTree char_literal10_tree=null;
        CommonTree AT_CLEVEL11_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree AT_LANGUAGE14_tree=null;
        CommonTree char_literal15_tree=null;
        CommonTree AT_SPEC16_tree=null;
        CommonTree char_literal17_tree=null;
        CommonTree EOF19_tree=null;
        RewriteRuleTokenStream stream_AT_STAGE=new RewriteRuleTokenStream(adaptor,"token AT_STAGE");
        RewriteRuleTokenStream stream_AT_CLEVEL=new RewriteRuleTokenStream(adaptor,"token AT_CLEVEL");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_AT_SPEC=new RewriteRuleTokenStream(adaptor,"token AT_SPEC");
        RewriteRuleTokenStream stream_AT_LANGUAGE=new RewriteRuleTokenStream(adaptor,"token AT_LANGUAGE");
        RewriteRuleTokenStream stream_AT_ENVIRONMENT=new RewriteRuleTokenStream(adaptor,"token AT_ENVIRONMENT");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_a3dsCLevel=new RewriteRuleSubtreeStream(adaptor,"rule a3dsCLevel");
        RewriteRuleSubtreeStream stream_cpp_directive=new RewriteRuleSubtreeStream(adaptor,"rule cpp_directive");
        RewriteRuleSubtreeStream stream_polaDefinition=new RewriteRuleSubtreeStream(adaptor,"rule polaDefinition");
        RewriteRuleSubtreeStream stream_a3dsStage=new RewriteRuleSubtreeStream(adaptor,"rule a3dsStage");
        RewriteRuleSubtreeStream stream_a3dsEnvironment=new RewriteRuleSubtreeStream(adaptor,"rule a3dsEnvironment");
        this.init();
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:119:25: ( cpp_directive AT_STAGE a3dsStage ';' AT_ENVIRONMENT a3dsEnvironment ';' AT_CLEVEL a3dsCLevel ';' AT_LANGUAGE l= IDENT ';' AT_SPEC spec= IDENT ';' ( polaDefinition )* EOF -> ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE $l) ^( AT_SPEC $spec) cpp_directive ( polaDefinition )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:120:27: cpp_directive AT_STAGE a3dsStage ';' AT_ENVIRONMENT a3dsEnvironment ';' AT_CLEVEL a3dsCLevel ';' AT_LANGUAGE l= IDENT ';' AT_SPEC spec= IDENT ';' ( polaDefinition )* EOF
            {
            pushFollow(FOLLOW_cpp_directive_in_polaSpecification226);
            cpp_directive4=cpp_directive();

            state._fsp--;

            stream_cpp_directive.add(cpp_directive4.getTree());
            AT_STAGE5=(Token)match(input,AT_STAGE,FOLLOW_AT_STAGE_in_polaSpecification228);  
            stream_AT_STAGE.add(AT_STAGE5);

            pushFollow(FOLLOW_a3dsStage_in_polaSpecification230);
            a3dsStage6=a3dsStage();

            state._fsp--;

            stream_a3dsStage.add(a3dsStage6.getTree());
            char_literal7=(Token)match(input,84,FOLLOW_84_in_polaSpecification232);  
            stream_84.add(char_literal7);

            AT_ENVIRONMENT8=(Token)match(input,AT_ENVIRONMENT,FOLLOW_AT_ENVIRONMENT_in_polaSpecification234);  
            stream_AT_ENVIRONMENT.add(AT_ENVIRONMENT8);

            pushFollow(FOLLOW_a3dsEnvironment_in_polaSpecification236);
            a3dsEnvironment9=a3dsEnvironment();

            state._fsp--;

            stream_a3dsEnvironment.add(a3dsEnvironment9.getTree());
            char_literal10=(Token)match(input,84,FOLLOW_84_in_polaSpecification238);  
            stream_84.add(char_literal10);

            AT_CLEVEL11=(Token)match(input,AT_CLEVEL,FOLLOW_AT_CLEVEL_in_polaSpecification240);  
            stream_AT_CLEVEL.add(AT_CLEVEL11);

            pushFollow(FOLLOW_a3dsCLevel_in_polaSpecification242);
            a3dsCLevel12=a3dsCLevel();

            state._fsp--;

            stream_a3dsCLevel.add(a3dsCLevel12.getTree());
            char_literal13=(Token)match(input,84,FOLLOW_84_in_polaSpecification244);  
            stream_84.add(char_literal13);

            AT_LANGUAGE14=(Token)match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_polaSpecification246);  
            stream_AT_LANGUAGE.add(AT_LANGUAGE14);

            l=(Token)match(input,IDENT,FOLLOW_IDENT_in_polaSpecification250);  
            stream_IDENT.add(l);

            char_literal15=(Token)match(input,84,FOLLOW_84_in_polaSpecification252);  
            stream_84.add(char_literal15);

            AT_SPEC16=(Token)match(input,AT_SPEC,FOLLOW_AT_SPEC_in_polaSpecification254);  
            stream_AT_SPEC.add(AT_SPEC16);

            spec=(Token)match(input,IDENT,FOLLOW_IDENT_in_polaSpecification258);  
            stream_IDENT.add(spec);

            char_literal17=(Token)match(input,84,FOLLOW_84_in_polaSpecification260);  
            stream_84.add(char_literal17);

            this.pass.atoms.specificationName(spec);
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:120:214: ( polaDefinition )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=CPP_DIRECTIVE && LA1_0<=POLA_POLICY)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:120:214: polaDefinition
            	    {
            	    pushFollow(FOLLOW_polaDefinition_in_polaSpecification264);
            	    polaDefinition18=polaDefinition();

            	    state._fsp--;

            	    stream_polaDefinition.add(polaDefinition18.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF19=(Token)match(input,EOF,FOLLOW_EOF_in_polaSpecification267);  
            stream_EOF.add(EOF19);



            // AST REWRITE
            // elements: polaDefinition, l, AT_SPEC, cpp_directive, AT_LANGUAGE, spec, a3dsCLevel, a3dsStage, AT_SPEC, a3dsEnvironment
            // token labels: spec, l
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_spec=new RewriteRuleTokenStream(adaptor,"token spec",spec);
            RewriteRuleTokenStream stream_l=new RewriteRuleTokenStream(adaptor,"token l",l);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 121:27: -> ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE $l) ^( AT_SPEC $spec) cpp_directive ( polaDefinition )* )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:121:30: ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE $l) ^( AT_SPEC $spec) cpp_directive ( polaDefinition )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_AT_SPEC.nextNode(), root_1);

                adaptor.addChild(root_1, stream_a3dsStage.nextTree());
                adaptor.addChild(root_1, stream_a3dsEnvironment.nextTree());
                adaptor.addChild(root_1, stream_a3dsCLevel.nextTree());
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:121:77: ^( AT_LANGUAGE $l)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_LANGUAGE.nextNode(), root_2);

                adaptor.addChild(root_2, stream_l.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:121:95: ^( AT_SPEC $spec)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_SPEC.nextNode(), root_2);

                adaptor.addChild(root_2, stream_spec.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_cpp_directive.nextTree());
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:121:126: ( polaDefinition )*
                while ( stream_polaDefinition.hasNext() ) {
                    adaptor.addChild(root_1, stream_polaDefinition.nextTree());

                }
                stream_polaDefinition.reset();

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
    // $ANTLR end "polaSpecification"

    public static class polaDefinition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "polaDefinition"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:122:1: polaDefinition : ( cpp_directive | managementPolicy );
    public final polaEbnfParser.polaDefinition_return polaDefinition() throws RecognitionException {
        polaEbnfParser.polaDefinition_return retval = new polaEbnfParser.polaDefinition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.cpp_directive_return cpp_directive20 = null;

        polaEbnfParser.managementPolicy_return managementPolicy21 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:122:25: ( cpp_directive | managementPolicy )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==CPP_DIRECTIVE) ) {
                alt2=1;
            }
            else if ( (LA2_0==POLA_POLICY) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:122:27: cpp_directive
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_cpp_directive_in_polaDefinition366);
                    cpp_directive20=cpp_directive();

                    state._fsp--;

                    adaptor.addChild(root_0, cpp_directive20.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:122:43: managementPolicy
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_managementPolicy_in_polaDefinition370);
                    managementPolicy21=managementPolicy();

                    state._fsp--;

                    adaptor.addChild(root_0, managementPolicy21.getTree());

                    }
                    break;

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
    // $ANTLR end "polaDefinition"

    public static class cpp_directive_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cpp_directive"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:124:1: cpp_directive : s= CPP_DIRECTIVE ;
    public final polaEbnfParser.cpp_directive_return cpp_directive() throws RecognitionException {
        polaEbnfParser.cpp_directive_return retval = new polaEbnfParser.cpp_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:124:25: (s= CPP_DIRECTIVE )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:124:27: s= CPP_DIRECTIVE
            {
            root_0 = (CommonTree)adaptor.nil();

            s=(Token)match(input,CPP_DIRECTIVE,FOLLOW_CPP_DIRECTIVE_in_cpp_directive390); 
            s_tree = (CommonTree)adaptor.create(s);
            adaptor.addChild(root_0, s_tree);

            this.setCppFile(s.getText());

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
    // $ANTLR end "cpp_directive"

    public static class managementPolicy_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "managementPolicy"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:134:1: managementPolicy : POLA_POLICY managementPolicyType s= IDENT '{' policyRuleStructure '}' -> ^( POLA_POLICY IDENT managementPolicyType policyRuleStructure ) ;
    public final polaEbnfParser.managementPolicy_return managementPolicy() throws RecognitionException {
        polaEbnfParser.managementPolicy_return retval = new polaEbnfParser.managementPolicy_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token POLA_POLICY22=null;
        Token char_literal24=null;
        Token char_literal26=null;
        polaEbnfParser.managementPolicyType_return managementPolicyType23 = null;

        polaEbnfParser.policyRuleStructure_return policyRuleStructure25 = null;


        CommonTree s_tree=null;
        CommonTree POLA_POLICY22_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree char_literal26_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_POLA_POLICY=new RewriteRuleTokenStream(adaptor,"token POLA_POLICY");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_managementPolicyType=new RewriteRuleSubtreeStream(adaptor,"rule managementPolicyType");
        RewriteRuleSubtreeStream stream_policyRuleStructure=new RewriteRuleSubtreeStream(adaptor,"rule policyRuleStructure");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:134:25: ( POLA_POLICY managementPolicyType s= IDENT '{' policyRuleStructure '}' -> ^( POLA_POLICY IDENT managementPolicyType policyRuleStructure ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:134:27: POLA_POLICY managementPolicyType s= IDENT '{' policyRuleStructure '}'
            {
            POLA_POLICY22=(Token)match(input,POLA_POLICY,FOLLOW_POLA_POLICY_in_managementPolicy415);  
            stream_POLA_POLICY.add(POLA_POLICY22);

            pushFollow(FOLLOW_managementPolicyType_in_managementPolicy417);
            managementPolicyType23=managementPolicyType();

            state._fsp--;

            stream_managementPolicyType.add(managementPolicyType23.getTree());
            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_managementPolicy421);  
            stream_IDENT.add(s);

            this.pass.atoms.putAtom(s,null);
            char_literal24=(Token)match(input,85,FOLLOW_85_in_managementPolicy477);  
            stream_85.add(char_literal24);

            pushFollow(FOLLOW_policyRuleStructure_in_managementPolicy479);
            policyRuleStructure25=policyRuleStructure();

            state._fsp--;

            stream_policyRuleStructure.add(policyRuleStructure25.getTree());
            char_literal26=(Token)match(input,86,FOLLOW_86_in_managementPolicy481);  
            stream_86.add(char_literal26);



            // AST REWRITE
            // elements: POLA_POLICY, managementPolicyType, policyRuleStructure, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 137:27: -> ^( POLA_POLICY IDENT managementPolicyType policyRuleStructure )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:137:30: ^( POLA_POLICY IDENT managementPolicyType policyRuleStructure )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_POLA_POLICY.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_managementPolicyType.nextTree());
                adaptor.addChild(root_1, stream_policyRuleStructure.nextTree());

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
    // $ANTLR end "managementPolicy"

    public static class managementPolicyType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "managementPolicyType"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:138:1: managementPolicyType : ( deonticPolicy | managementMetaPolicy );
    public final polaEbnfParser.managementPolicyType_return managementPolicyType() throws RecognitionException {
        polaEbnfParser.managementPolicyType_return retval = new polaEbnfParser.managementPolicyType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.deonticPolicy_return deonticPolicy27 = null;

        polaEbnfParser.managementMetaPolicy_return managementMetaPolicy28 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:138:25: ( deonticPolicy | managementMetaPolicy )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=POLA_DEONT_AUTH && LA3_0<=POLA_DEONT_PROH)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=POLA_MEPO_DELE && LA3_0<=POLA_MEPO_REVO)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:138:27: deonticPolicy
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_deonticPolicy_in_managementPolicyType529);
                    deonticPolicy27=deonticPolicy();

                    state._fsp--;

                    adaptor.addChild(root_0, deonticPolicy27.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:138:43: managementMetaPolicy
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_managementMetaPolicy_in_managementPolicyType533);
                    managementMetaPolicy28=managementMetaPolicy();

                    state._fsp--;

                    adaptor.addChild(root_0, managementMetaPolicy28.getTree());

                    }
                    break;

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
    // $ANTLR end "managementPolicyType"

    public static class deonticPolicy_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deonticPolicy"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:139:1: deonticPolicy : ( POLA_DEONT_AUTH | POLA_DEONT_EXEM | POLA_DEONT_OBLG | POLA_DEONT_PROH );
    public final polaEbnfParser.deonticPolicy_return deonticPolicy() throws RecognitionException {
        polaEbnfParser.deonticPolicy_return retval = new polaEbnfParser.deonticPolicy_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set29=null;

        CommonTree set29_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:139:25: ( POLA_DEONT_AUTH | POLA_DEONT_EXEM | POLA_DEONT_OBLG | POLA_DEONT_PROH )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set29=(Token)input.LT(1);
            if ( (input.LA(1)>=POLA_DEONT_AUTH && input.LA(1)<=POLA_DEONT_PROH) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set29));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "deonticPolicy"

    public static class managementMetaPolicy_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "managementMetaPolicy"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:140:1: managementMetaPolicy : ( POLA_MEPO_DELE | POLA_MEPO_REVO );
    public final polaEbnfParser.managementMetaPolicy_return managementMetaPolicy() throws RecognitionException {
        polaEbnfParser.managementMetaPolicy_return retval = new polaEbnfParser.managementMetaPolicy_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set30=null;

        CommonTree set30_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:140:25: ( POLA_MEPO_DELE | POLA_MEPO_REVO )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set30=(Token)input.LT(1);
            if ( (input.LA(1)>=POLA_MEPO_DELE && input.LA(1)<=POLA_MEPO_REVO) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set30));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "managementMetaPolicy"

    public static class policyRuleStructure_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyRuleStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:144:1: policyRuleStructure : ( ( policyContinuumLevel )? ecaPolicyRule | goalPolicyRule | utilityFunctionPolicyRule );
    public final polaEbnfParser.policyRuleStructure_return policyRuleStructure() throws RecognitionException {
        polaEbnfParser.policyRuleStructure_return retval = new polaEbnfParser.policyRuleStructure_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyContinuumLevel_return policyContinuumLevel31 = null;

        polaEbnfParser.ecaPolicyRule_return ecaPolicyRule32 = null;

        polaEbnfParser.goalPolicyRule_return goalPolicyRule33 = null;

        polaEbnfParser.utilityFunctionPolicyRule_return utilityFunctionPolicyRule34 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:144:26: ( ( policyContinuumLevel )? ecaPolicyRule | goalPolicyRule | utilityFunctionPolicyRule )
            int alt5=3;
            switch ( input.LA(1) ) {
            case POLA_PC_LEVEL:
            case POLA_RULE_STRUCT_ECA:
                {
                alt5=1;
                }
                break;
            case POLA_RULE_STRUCT_GOAL:
                {
                alt5=2;
                }
                break;
            case POLA_RULE_STRUCT_UTIL:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:144:28: ( policyContinuumLevel )? ecaPolicyRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:144:28: ( policyContinuumLevel )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==POLA_PC_LEVEL) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:144:29: policyContinuumLevel
                            {
                            pushFollow(FOLLOW_policyContinuumLevel_in_policyRuleStructure592);
                            policyContinuumLevel31=policyContinuumLevel();

                            state._fsp--;

                            adaptor.addChild(root_0, policyContinuumLevel31.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_ecaPolicyRule_in_policyRuleStructure596);
                    ecaPolicyRule32=ecaPolicyRule();

                    state._fsp--;

                    adaptor.addChild(root_0, ecaPolicyRule32.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:144:68: goalPolicyRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_goalPolicyRule_in_policyRuleStructure600);
                    goalPolicyRule33=goalPolicyRule();

                    state._fsp--;

                    adaptor.addChild(root_0, goalPolicyRule33.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:144:85: utilityFunctionPolicyRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_utilityFunctionPolicyRule_in_policyRuleStructure604);
                    utilityFunctionPolicyRule34=utilityFunctionPolicyRule();

                    state._fsp--;

                    adaptor.addChild(root_0, utilityFunctionPolicyRule34.getTree());

                    }
                    break;

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
    // $ANTLR end "policyRuleStructure"

    public static class policyContinuumLevel_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyContinuumLevel"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:145:1: policyContinuumLevel : POLA_PC_LEVEL '=' ( 'business' | 'system' | 'administration' | 'device' 'instance' ) ';' ;
    public final polaEbnfParser.policyContinuumLevel_return policyContinuumLevel() throws RecognitionException {
        polaEbnfParser.policyContinuumLevel_return retval = new polaEbnfParser.policyContinuumLevel_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_PC_LEVEL35=null;
        Token char_literal36=null;
        Token string_literal37=null;
        Token string_literal38=null;
        Token string_literal39=null;
        Token string_literal40=null;
        Token string_literal41=null;
        Token char_literal42=null;

        CommonTree POLA_PC_LEVEL35_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree string_literal37_tree=null;
        CommonTree string_literal38_tree=null;
        CommonTree string_literal39_tree=null;
        CommonTree string_literal40_tree=null;
        CommonTree string_literal41_tree=null;
        CommonTree char_literal42_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:145:26: ( POLA_PC_LEVEL '=' ( 'business' | 'system' | 'administration' | 'device' 'instance' ) ';' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:145:28: POLA_PC_LEVEL '=' ( 'business' | 'system' | 'administration' | 'device' 'instance' ) ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_PC_LEVEL35=(Token)match(input,POLA_PC_LEVEL,FOLLOW_POLA_PC_LEVEL_in_policyContinuumLevel615); 
            POLA_PC_LEVEL35_tree = (CommonTree)adaptor.create(POLA_PC_LEVEL35);
            adaptor.addChild(root_0, POLA_PC_LEVEL35_tree);

            char_literal36=(Token)match(input,87,FOLLOW_87_in_policyContinuumLevel617); 
            char_literal36_tree = (CommonTree)adaptor.create(char_literal36);
            adaptor.addChild(root_0, char_literal36_tree);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:145:46: ( 'business' | 'system' | 'administration' | 'device' 'instance' )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt6=1;
                }
                break;
            case 82:
                {
                alt6=2;
                }
                break;
            case 88:
                {
                alt6=3;
                }
                break;
            case 89:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:145:47: 'business'
                    {
                    string_literal37=(Token)match(input,81,FOLLOW_81_in_policyContinuumLevel620); 
                    string_literal37_tree = (CommonTree)adaptor.create(string_literal37);
                    adaptor.addChild(root_0, string_literal37_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:145:60: 'system'
                    {
                    string_literal38=(Token)match(input,82,FOLLOW_82_in_policyContinuumLevel624); 
                    string_literal38_tree = (CommonTree)adaptor.create(string_literal38);
                    adaptor.addChild(root_0, string_literal38_tree);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:145:71: 'administration'
                    {
                    string_literal39=(Token)match(input,88,FOLLOW_88_in_policyContinuumLevel628); 
                    string_literal39_tree = (CommonTree)adaptor.create(string_literal39);
                    adaptor.addChild(root_0, string_literal39_tree);


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:145:90: 'device' 'instance'
                    {
                    string_literal40=(Token)match(input,89,FOLLOW_89_in_policyContinuumLevel632); 
                    string_literal40_tree = (CommonTree)adaptor.create(string_literal40);
                    adaptor.addChild(root_0, string_literal40_tree);

                    string_literal41=(Token)match(input,90,FOLLOW_90_in_policyContinuumLevel634); 
                    string_literal41_tree = (CommonTree)adaptor.create(string_literal41);
                    adaptor.addChild(root_0, string_literal41_tree);


                    }
                    break;

            }

            char_literal42=(Token)match(input,84,FOLLOW_84_in_policyContinuumLevel637); 
            char_literal42_tree = (CommonTree)adaptor.create(char_literal42);
            adaptor.addChild(root_0, char_literal42_tree);


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
    // $ANTLR end "policyContinuumLevel"

    public static class ecaPolicyRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecaPolicyRule"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:147:1: ecaPolicyRule : POLA_RULE_STRUCT_ECA '::=' ecaPolicyRuleBody -> ^( POLA_RULE_STRUCT_ECA ecaPolicyRuleBody ) ;
    public final polaEbnfParser.ecaPolicyRule_return ecaPolicyRule() throws RecognitionException {
        polaEbnfParser.ecaPolicyRule_return retval = new polaEbnfParser.ecaPolicyRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_RULE_STRUCT_ECA43=null;
        Token string_literal44=null;
        polaEbnfParser.ecaPolicyRuleBody_return ecaPolicyRuleBody45 = null;


        CommonTree POLA_RULE_STRUCT_ECA43_tree=null;
        CommonTree string_literal44_tree=null;
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleTokenStream stream_POLA_RULE_STRUCT_ECA=new RewriteRuleTokenStream(adaptor,"token POLA_RULE_STRUCT_ECA");
        RewriteRuleSubtreeStream stream_ecaPolicyRuleBody=new RewriteRuleSubtreeStream(adaptor,"rule ecaPolicyRuleBody");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:147:26: ( POLA_RULE_STRUCT_ECA '::=' ecaPolicyRuleBody -> ^( POLA_RULE_STRUCT_ECA ecaPolicyRuleBody ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:147:28: POLA_RULE_STRUCT_ECA '::=' ecaPolicyRuleBody
            {
            POLA_RULE_STRUCT_ECA43=(Token)match(input,POLA_RULE_STRUCT_ECA,FOLLOW_POLA_RULE_STRUCT_ECA_in_ecaPolicyRule656);  
            stream_POLA_RULE_STRUCT_ECA.add(POLA_RULE_STRUCT_ECA43);

            string_literal44=(Token)match(input,91,FOLLOW_91_in_ecaPolicyRule658);  
            stream_91.add(string_literal44);

            pushFollow(FOLLOW_ecaPolicyRuleBody_in_ecaPolicyRule660);
            ecaPolicyRuleBody45=ecaPolicyRuleBody();

            state._fsp--;

            stream_ecaPolicyRuleBody.add(ecaPolicyRuleBody45.getTree());


            // AST REWRITE
            // elements: ecaPolicyRuleBody, POLA_RULE_STRUCT_ECA
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 148:28: -> ^( POLA_RULE_STRUCT_ECA ecaPolicyRuleBody )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:148:31: ^( POLA_RULE_STRUCT_ECA ecaPolicyRuleBody )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_POLA_RULE_STRUCT_ECA.nextNode(), root_1);

                adaptor.addChild(root_1, stream_ecaPolicyRuleBody.nextTree());

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
    // $ANTLR end "ecaPolicyRule"

    public static class ecaPolicyRuleBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecaPolicyRuleBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:149:1: ecaPolicyRuleBody : ( policyEventStructure )* ( policyConditionStructure )* ( policyActionStructure )* ;
    public final polaEbnfParser.ecaPolicyRuleBody_return ecaPolicyRuleBody() throws RecognitionException {
        polaEbnfParser.ecaPolicyRuleBody_return retval = new polaEbnfParser.ecaPolicyRuleBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyEventStructure_return policyEventStructure46 = null;

        polaEbnfParser.policyConditionStructure_return policyConditionStructure47 = null;

        polaEbnfParser.policyActionStructure_return policyActionStructure48 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:149:26: ( ( policyEventStructure )* ( policyConditionStructure )* ( policyActionStructure )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:149:28: ( policyEventStructure )* ( policyConditionStructure )* ( policyActionStructure )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:149:28: ( policyEventStructure )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==POLA_EVENT) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:149:28: policyEventStructure
            	    {
            	    pushFollow(FOLLOW_policyEventStructure_in_ecaPolicyRuleBody709);
            	    policyEventStructure46=policyEventStructure();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyEventStructure46.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:149:50: ( policyConditionStructure )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==POLA_CONDITION) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:149:50: policyConditionStructure
            	    {
            	    pushFollow(FOLLOW_policyConditionStructure_in_ecaPolicyRuleBody712);
            	    policyConditionStructure47=policyConditionStructure();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyConditionStructure47.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:149:76: ( policyActionStructure )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==POLA_ACTION) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:149:76: policyActionStructure
            	    {
            	    pushFollow(FOLLOW_policyActionStructure_in_ecaPolicyRuleBody715);
            	    policyActionStructure48=policyActionStructure();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyActionStructure48.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


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
    // $ANTLR end "ecaPolicyRuleBody"

    public static class goalPolicyRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "goalPolicyRule"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:150:1: goalPolicyRule : POLA_RULE_STRUCT_GOAL ;
    public final polaEbnfParser.goalPolicyRule_return goalPolicyRule() throws RecognitionException {
        polaEbnfParser.goalPolicyRule_return retval = new polaEbnfParser.goalPolicyRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_RULE_STRUCT_GOAL49=null;

        CommonTree POLA_RULE_STRUCT_GOAL49_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:150:26: ( POLA_RULE_STRUCT_GOAL )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:150:28: POLA_RULE_STRUCT_GOAL
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_RULE_STRUCT_GOAL49=(Token)match(input,POLA_RULE_STRUCT_GOAL,FOLLOW_POLA_RULE_STRUCT_GOAL_in_goalPolicyRule733); 
            POLA_RULE_STRUCT_GOAL49_tree = (CommonTree)adaptor.create(POLA_RULE_STRUCT_GOAL49);
            adaptor.addChild(root_0, POLA_RULE_STRUCT_GOAL49_tree);


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
    // $ANTLR end "goalPolicyRule"

    public static class utilityFunctionPolicyRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "utilityFunctionPolicyRule"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:151:1: utilityFunctionPolicyRule : POLA_RULE_STRUCT_UTIL ;
    public final polaEbnfParser.utilityFunctionPolicyRule_return utilityFunctionPolicyRule() throws RecognitionException {
        polaEbnfParser.utilityFunctionPolicyRule_return retval = new polaEbnfParser.utilityFunctionPolicyRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_RULE_STRUCT_UTIL50=null;

        CommonTree POLA_RULE_STRUCT_UTIL50_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:151:26: ( POLA_RULE_STRUCT_UTIL )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:151:28: POLA_RULE_STRUCT_UTIL
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_RULE_STRUCT_UTIL50=(Token)match(input,POLA_RULE_STRUCT_UTIL,FOLLOW_POLA_RULE_STRUCT_UTIL_in_utilityFunctionPolicyRule740); 
            POLA_RULE_STRUCT_UTIL50_tree = (CommonTree)adaptor.create(POLA_RULE_STRUCT_UTIL50);
            adaptor.addChild(root_0, POLA_RULE_STRUCT_UTIL50_tree);


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
    // $ANTLR end "utilityFunctionPolicyRule"

    public static class policyRuleComponentStructure_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyRuleComponentStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:155:1: policyRuleComponentStructure : ( policyEventStructure | policyConditionStructure | policyActionStructure );
    public final polaEbnfParser.policyRuleComponentStructure_return policyRuleComponentStructure() throws RecognitionException {
        polaEbnfParser.policyRuleComponentStructure_return retval = new polaEbnfParser.policyRuleComponentStructure_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyEventStructure_return policyEventStructure51 = null;

        polaEbnfParser.policyConditionStructure_return policyConditionStructure52 = null;

        polaEbnfParser.policyActionStructure_return policyActionStructure53 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:155:29: ( policyEventStructure | policyConditionStructure | policyActionStructure )
            int alt10=3;
            switch ( input.LA(1) ) {
            case POLA_EVENT:
                {
                alt10=1;
                }
                break;
            case POLA_CONDITION:
                {
                alt10=2;
                }
                break;
            case POLA_ACTION:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:155:31: policyEventStructure
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyEventStructure_in_policyRuleComponentStructure750);
                    policyEventStructure51=policyEventStructure();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventStructure51.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:155:54: policyConditionStructure
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyConditionStructure_in_policyRuleComponentStructure754);
                    policyConditionStructure52=policyConditionStructure();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionStructure52.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:155:81: policyActionStructure
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyActionStructure_in_policyRuleComponentStructure758);
                    policyActionStructure53=policyActionStructure();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionStructure53.getTree());

                    }
                    break;

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
    // $ANTLR end "policyRuleComponentStructure"

    public static class policyEventStructure_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:157:1: policyEventStructure : POLA_EVENT ( policyEventStructureBody )* ;
    public final polaEbnfParser.policyEventStructure_return policyEventStructure() throws RecognitionException {
        polaEbnfParser.policyEventStructure_return retval = new polaEbnfParser.policyEventStructure_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_EVENT54=null;
        polaEbnfParser.policyEventStructureBody_return policyEventStructureBody55 = null;


        CommonTree POLA_EVENT54_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:157:25: ( POLA_EVENT ( policyEventStructureBody )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:157:27: POLA_EVENT ( policyEventStructureBody )*
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_EVENT54=(Token)match(input,POLA_EVENT,FOLLOW_POLA_EVENT_in_policyEventStructure769); 
            POLA_EVENT54_tree = (CommonTree)adaptor.create(POLA_EVENT54);
            adaptor.addChild(root_0, POLA_EVENT54_tree);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:157:38: ( policyEventStructureBody )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=POLA_GROUP && LA11_0<=POLA_NONSTD)||LA11_0==84) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:157:38: policyEventStructureBody
            	    {
            	    pushFollow(FOLLOW_policyEventStructureBody_in_policyEventStructure771);
            	    policyEventStructureBody55=policyEventStructureBody();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyEventStructureBody55.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


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
    // $ANTLR end "policyEventStructure"

    public static class policyEventStructureBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventStructureBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:158:1: policyEventStructureBody : ( policyEventGroup | policyEvent );
    public final polaEbnfParser.policyEventStructureBody_return policyEventStructureBody() throws RecognitionException {
        polaEbnfParser.policyEventStructureBody_return retval = new polaEbnfParser.policyEventStructureBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyEventGroup_return policyEventGroup56 = null;

        polaEbnfParser.policyEvent_return policyEvent57 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:158:25: ( policyEventGroup | policyEvent )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==POLA_GROUP) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=POLA_COMPOSITE && LA12_0<=POLA_NONSTD)||LA12_0==84) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:158:27: policyEventGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyEventGroup_in_policyEventStructureBody778);
                    policyEventGroup56=policyEventGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventGroup56.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:158:46: policyEvent
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyEvent_in_policyEventStructureBody782);
                    policyEvent57=policyEvent();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEvent57.getTree());

                    }
                    break;

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
    // $ANTLR end "policyEventStructureBody"

    public static class policyEventGroup_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventGroup"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:159:1: policyEventGroup : POLA_GROUP IDENT '{' ( policyEventGroupBody )* '}' ';' -> ^( POLA_GROUP IDENT ( policyEventGroupBody )* ) ;
    public final polaEbnfParser.policyEventGroup_return policyEventGroup() throws RecognitionException {
        polaEbnfParser.policyEventGroup_return retval = new polaEbnfParser.policyEventGroup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_GROUP58=null;
        Token IDENT59=null;
        Token char_literal60=null;
        Token char_literal62=null;
        Token char_literal63=null;
        polaEbnfParser.policyEventGroupBody_return policyEventGroupBody61 = null;


        CommonTree POLA_GROUP58_tree=null;
        CommonTree IDENT59_tree=null;
        CommonTree char_literal60_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree char_literal63_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_POLA_GROUP=new RewriteRuleTokenStream(adaptor,"token POLA_GROUP");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_policyEventGroupBody=new RewriteRuleSubtreeStream(adaptor,"rule policyEventGroupBody");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:159:25: ( POLA_GROUP IDENT '{' ( policyEventGroupBody )* '}' ';' -> ^( POLA_GROUP IDENT ( policyEventGroupBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:159:27: POLA_GROUP IDENT '{' ( policyEventGroupBody )* '}' ';'
            {
            POLA_GROUP58=(Token)match(input,POLA_GROUP,FOLLOW_POLA_GROUP_in_policyEventGroup796);  
            stream_POLA_GROUP.add(POLA_GROUP58);

            IDENT59=(Token)match(input,IDENT,FOLLOW_IDENT_in_policyEventGroup798);  
            stream_IDENT.add(IDENT59);

            char_literal60=(Token)match(input,85,FOLLOW_85_in_policyEventGroup800);  
            stream_85.add(char_literal60);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:159:48: ( policyEventGroupBody )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=POLA_GROUP && LA13_0<=POLA_NONSTD)||LA13_0==84) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:159:48: policyEventGroupBody
            	    {
            	    pushFollow(FOLLOW_policyEventGroupBody_in_policyEventGroup802);
            	    policyEventGroupBody61=policyEventGroupBody();

            	    state._fsp--;

            	    stream_policyEventGroupBody.add(policyEventGroupBody61.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            char_literal62=(Token)match(input,86,FOLLOW_86_in_policyEventGroup805);  
            stream_86.add(char_literal62);

            char_literal63=(Token)match(input,84,FOLLOW_84_in_policyEventGroup807);  
            stream_84.add(char_literal63);



            // AST REWRITE
            // elements: IDENT, POLA_GROUP, policyEventGroupBody
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 160:27: -> ^( POLA_GROUP IDENT ( policyEventGroupBody )* )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:160:30: ^( POLA_GROUP IDENT ( policyEventGroupBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_POLA_GROUP.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:160:49: ( policyEventGroupBody )*
                while ( stream_policyEventGroupBody.hasNext() ) {
                    adaptor.addChild(root_1, stream_policyEventGroupBody.nextTree());

                }
                stream_policyEventGroupBody.reset();

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
    // $ANTLR end "policyEventGroup"

    public static class policyEventGroupBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventGroupBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:161:1: policyEventGroupBody : ( policyEventGroup | policyEvent );
    public final polaEbnfParser.policyEventGroupBody_return policyEventGroupBody() throws RecognitionException {
        polaEbnfParser.policyEventGroupBody_return retval = new polaEbnfParser.policyEventGroupBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyEventGroup_return policyEventGroup64 = null;

        polaEbnfParser.policyEvent_return policyEvent65 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:161:25: ( policyEventGroup | policyEvent )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==POLA_GROUP) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=POLA_COMPOSITE && LA14_0<=POLA_NONSTD)||LA14_0==84) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:161:27: policyEventGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyEventGroup_in_policyEventGroupBody854);
                    policyEventGroup64=policyEventGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventGroup64.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:161:46: policyEvent
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyEvent_in_policyEventGroupBody858);
                    policyEvent65=policyEvent();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEvent65.getTree());

                    }
                    break;

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
    // $ANTLR end "policyEventGroupBody"

    public static class policyEvent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEvent"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:162:1: policyEvent : ( policyEventBody )* ';' -> ^( BODY ( policyEventBody )* ) ;
    public final polaEbnfParser.policyEvent_return policyEvent() throws RecognitionException {
        polaEbnfParser.policyEvent_return retval = new polaEbnfParser.policyEvent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal67=null;
        polaEbnfParser.policyEventBody_return policyEventBody66 = null;


        CommonTree char_literal67_tree=null;
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_policyEventBody=new RewriteRuleSubtreeStream(adaptor,"rule policyEventBody");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:162:25: ( ( policyEventBody )* ';' -> ^( BODY ( policyEventBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:162:27: ( policyEventBody )* ';'
            {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:162:27: ( policyEventBody )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=POLA_COMPOSITE && LA15_0<=POLA_NONSTD)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:162:27: policyEventBody
            	    {
            	    pushFollow(FOLLOW_policyEventBody_in_policyEvent877);
            	    policyEventBody66=policyEventBody();

            	    state._fsp--;

            	    stream_policyEventBody.add(policyEventBody66.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            char_literal67=(Token)match(input,84,FOLLOW_84_in_policyEvent880);  
            stream_84.add(char_literal67);



            // AST REWRITE
            // elements: policyEventBody
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 162:48: -> ^( BODY ( policyEventBody )* )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:162:51: ^( BODY ( policyEventBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BODY, "BODY"), root_1);

                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:162:58: ( policyEventBody )*
                while ( stream_policyEventBody.hasNext() ) {
                    adaptor.addChild(root_1, stream_policyEventBody.nextTree());

                }
                stream_policyEventBody.reset();

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
    // $ANTLR end "policyEvent"

    public static class policyEventBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:163:1: policyEventBody : ( policyEventComposite | policyEventAtomic | policyEventNonStd );
    public final polaEbnfParser.policyEventBody_return policyEventBody() throws RecognitionException {
        polaEbnfParser.policyEventBody_return retval = new polaEbnfParser.policyEventBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyEventComposite_return policyEventComposite68 = null;

        polaEbnfParser.policyEventAtomic_return policyEventAtomic69 = null;

        polaEbnfParser.policyEventNonStd_return policyEventNonStd70 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:163:25: ( policyEventComposite | policyEventAtomic | policyEventNonStd )
            int alt16=3;
            switch ( input.LA(1) ) {
            case POLA_COMPOSITE:
                {
                alt16=1;
                }
                break;
            case POLA_ATOMIC:
                {
                alt16=2;
                }
                break;
            case POLA_NONSTD:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:163:27: policyEventComposite
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyEventComposite_in_policyEventBody904);
                    policyEventComposite68=policyEventComposite();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventComposite68.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:163:50: policyEventAtomic
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyEventAtomic_in_policyEventBody908);
                    policyEventAtomic69=policyEventAtomic();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventAtomic69.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:163:70: policyEventNonStd
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyEventNonStd_in_policyEventBody912);
                    policyEventNonStd70=policyEventNonStd();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventNonStd70.getTree());

                    }
                    break;

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
    // $ANTLR end "policyEventBody"

    public static class policyEventComposite_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventComposite"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:164:1: policyEventComposite : POLA_COMPOSITE policyECAInherited '{' ( policyEvent )* '}' -> ^( POLA_COMPOSITE policyECAInherited ( policyEvent )* ) ;
    public final polaEbnfParser.policyEventComposite_return policyEventComposite() throws RecognitionException {
        polaEbnfParser.policyEventComposite_return retval = new polaEbnfParser.policyEventComposite_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_COMPOSITE71=null;
        Token char_literal73=null;
        Token char_literal75=null;
        polaEbnfParser.policyECAInherited_return policyECAInherited72 = null;

        polaEbnfParser.policyEvent_return policyEvent74 = null;


        CommonTree POLA_COMPOSITE71_tree=null;
        CommonTree char_literal73_tree=null;
        CommonTree char_literal75_tree=null;
        RewriteRuleTokenStream stream_POLA_COMPOSITE=new RewriteRuleTokenStream(adaptor,"token POLA_COMPOSITE");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_policyEvent=new RewriteRuleSubtreeStream(adaptor,"rule policyEvent");
        RewriteRuleSubtreeStream stream_policyECAInherited=new RewriteRuleSubtreeStream(adaptor,"rule policyECAInherited");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:164:25: ( POLA_COMPOSITE policyECAInherited '{' ( policyEvent )* '}' -> ^( POLA_COMPOSITE policyECAInherited ( policyEvent )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:164:27: POLA_COMPOSITE policyECAInherited '{' ( policyEvent )* '}'
            {
            POLA_COMPOSITE71=(Token)match(input,POLA_COMPOSITE,FOLLOW_POLA_COMPOSITE_in_policyEventComposite922);  
            stream_POLA_COMPOSITE.add(POLA_COMPOSITE71);

            pushFollow(FOLLOW_policyECAInherited_in_policyEventComposite924);
            policyECAInherited72=policyECAInherited();

            state._fsp--;

            stream_policyECAInherited.add(policyECAInherited72.getTree());
            char_literal73=(Token)match(input,85,FOLLOW_85_in_policyEventComposite926);  
            stream_85.add(char_literal73);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:164:65: ( policyEvent )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=POLA_COMPOSITE && LA17_0<=POLA_NONSTD)||LA17_0==84) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:164:65: policyEvent
            	    {
            	    pushFollow(FOLLOW_policyEvent_in_policyEventComposite928);
            	    policyEvent74=policyEvent();

            	    state._fsp--;

            	    stream_policyEvent.add(policyEvent74.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            char_literal75=(Token)match(input,86,FOLLOW_86_in_policyEventComposite931);  
            stream_86.add(char_literal75);



            // AST REWRITE
            // elements: POLA_COMPOSITE, policyECAInherited, policyEvent
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 165:27: -> ^( POLA_COMPOSITE policyECAInherited ( policyEvent )* )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:165:30: ^( POLA_COMPOSITE policyECAInherited ( policyEvent )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_POLA_COMPOSITE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_policyECAInherited.nextTree());
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:165:66: ( policyEvent )*
                while ( stream_policyEvent.hasNext() ) {
                    adaptor.addChild(root_1, stream_policyEvent.nextTree());

                }
                stream_policyEvent.reset();

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
    // $ANTLR end "policyEventComposite"

    public static class policyEventAtomic_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventAtomic"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:166:1: policyEventAtomic : POLA_ATOMIC policyECAInherited pola_string ;
    public final polaEbnfParser.policyEventAtomic_return policyEventAtomic() throws RecognitionException {
        polaEbnfParser.policyEventAtomic_return retval = new polaEbnfParser.policyEventAtomic_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_ATOMIC76=null;
        polaEbnfParser.policyECAInherited_return policyECAInherited77 = null;

        polaEbnfParser.pola_string_return pola_string78 = null;


        CommonTree POLA_ATOMIC76_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:166:25: ( POLA_ATOMIC policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:166:27: POLA_ATOMIC policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_ATOMIC76=(Token)match(input,POLA_ATOMIC,FOLLOW_POLA_ATOMIC_in_policyEventAtomic981); 
            POLA_ATOMIC76_tree = (CommonTree)adaptor.create(POLA_ATOMIC76);
            adaptor.addChild(root_0, POLA_ATOMIC76_tree);

            pushFollow(FOLLOW_policyECAInherited_in_policyEventAtomic983);
            policyECAInherited77=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited77.getTree());
            pushFollow(FOLLOW_pola_string_in_policyEventAtomic985);
            pola_string78=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string78.getTree());

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
    // $ANTLR end "policyEventAtomic"

    public static class policyEventNonStd_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventNonStd"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:167:1: policyEventNonStd : POLA_NONSTD policyECAInherited pola_string ;
    public final polaEbnfParser.policyEventNonStd_return policyEventNonStd() throws RecognitionException {
        polaEbnfParser.policyEventNonStd_return retval = new polaEbnfParser.policyEventNonStd_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_NONSTD79=null;
        polaEbnfParser.policyECAInherited_return policyECAInherited80 = null;

        polaEbnfParser.pola_string_return pola_string81 = null;


        CommonTree POLA_NONSTD79_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:167:25: ( POLA_NONSTD policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:167:27: POLA_NONSTD policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_NONSTD79=(Token)match(input,POLA_NONSTD,FOLLOW_POLA_NONSTD_in_policyEventNonStd998); 
            POLA_NONSTD79_tree = (CommonTree)adaptor.create(POLA_NONSTD79);
            adaptor.addChild(root_0, POLA_NONSTD79_tree);

            pushFollow(FOLLOW_policyECAInherited_in_policyEventNonStd1000);
            policyECAInherited80=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited80.getTree());
            pushFollow(FOLLOW_pola_string_in_policyEventNonStd1002);
            pola_string81=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string81.getTree());

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
    // $ANTLR end "policyEventNonStd"

    public static class policyConditionStructure_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:169:1: policyConditionStructure : POLA_CONDITION ( policyConditionStructureBody )* ;
    public final polaEbnfParser.policyConditionStructure_return policyConditionStructure() throws RecognitionException {
        polaEbnfParser.policyConditionStructure_return retval = new polaEbnfParser.policyConditionStructure_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_CONDITION82=null;
        polaEbnfParser.policyConditionStructureBody_return policyConditionStructureBody83 = null;


        CommonTree POLA_CONDITION82_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:169:29: ( POLA_CONDITION ( policyConditionStructureBody )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:169:31: POLA_CONDITION ( policyConditionStructureBody )*
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_CONDITION82=(Token)match(input,POLA_CONDITION,FOLLOW_POLA_CONDITION_in_policyConditionStructure1013); 
            POLA_CONDITION82_tree = (CommonTree)adaptor.create(POLA_CONDITION82);
            adaptor.addChild(root_0, POLA_CONDITION82_tree);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:169:46: ( policyConditionStructureBody )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=POLA_GROUP && LA18_0<=POLA_NONSTD)||LA18_0==84) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:169:46: policyConditionStructureBody
            	    {
            	    pushFollow(FOLLOW_policyConditionStructureBody_in_policyConditionStructure1015);
            	    policyConditionStructureBody83=policyConditionStructureBody();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyConditionStructureBody83.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


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
    // $ANTLR end "policyConditionStructure"

    public static class policyConditionStructureBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionStructureBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:170:1: policyConditionStructureBody : ( policyConditionGroup | policyCondition );
    public final polaEbnfParser.policyConditionStructureBody_return policyConditionStructureBody() throws RecognitionException {
        polaEbnfParser.policyConditionStructureBody_return retval = new polaEbnfParser.policyConditionStructureBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyConditionGroup_return policyConditionGroup84 = null;

        polaEbnfParser.policyCondition_return policyCondition85 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:170:29: ( policyConditionGroup | policyCondition )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==POLA_GROUP) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=POLA_COMPOSITE && LA19_0<=POLA_NONSTD)||LA19_0==84) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:170:31: policyConditionGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyConditionGroup_in_policyConditionStructureBody1022);
                    policyConditionGroup84=policyConditionGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionGroup84.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:170:54: policyCondition
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyCondition_in_policyConditionStructureBody1026);
                    policyCondition85=policyCondition();

                    state._fsp--;

                    adaptor.addChild(root_0, policyCondition85.getTree());

                    }
                    break;

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
    // $ANTLR end "policyConditionStructureBody"

    public static class policyConditionGroup_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionGroup"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:171:1: policyConditionGroup : POLA_GROUP IDENT '{' ( policyConditionGroupBody )* '}' ';' -> ^( POLA_GROUP IDENT ( policyConditionGroupBody )* ) ;
    public final polaEbnfParser.policyConditionGroup_return policyConditionGroup() throws RecognitionException {
        polaEbnfParser.policyConditionGroup_return retval = new polaEbnfParser.policyConditionGroup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_GROUP86=null;
        Token IDENT87=null;
        Token char_literal88=null;
        Token char_literal90=null;
        Token char_literal91=null;
        polaEbnfParser.policyConditionGroupBody_return policyConditionGroupBody89 = null;


        CommonTree POLA_GROUP86_tree=null;
        CommonTree IDENT87_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree char_literal90_tree=null;
        CommonTree char_literal91_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_POLA_GROUP=new RewriteRuleTokenStream(adaptor,"token POLA_GROUP");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_policyConditionGroupBody=new RewriteRuleSubtreeStream(adaptor,"rule policyConditionGroupBody");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:171:29: ( POLA_GROUP IDENT '{' ( policyConditionGroupBody )* '}' ';' -> ^( POLA_GROUP IDENT ( policyConditionGroupBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:171:31: POLA_GROUP IDENT '{' ( policyConditionGroupBody )* '}' ';'
            {
            POLA_GROUP86=(Token)match(input,POLA_GROUP,FOLLOW_POLA_GROUP_in_policyConditionGroup1040);  
            stream_POLA_GROUP.add(POLA_GROUP86);

            IDENT87=(Token)match(input,IDENT,FOLLOW_IDENT_in_policyConditionGroup1042);  
            stream_IDENT.add(IDENT87);

            char_literal88=(Token)match(input,85,FOLLOW_85_in_policyConditionGroup1044);  
            stream_85.add(char_literal88);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:171:52: ( policyConditionGroupBody )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=POLA_GROUP && LA20_0<=POLA_NONSTD)||LA20_0==84) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:171:52: policyConditionGroupBody
            	    {
            	    pushFollow(FOLLOW_policyConditionGroupBody_in_policyConditionGroup1046);
            	    policyConditionGroupBody89=policyConditionGroupBody();

            	    state._fsp--;

            	    stream_policyConditionGroupBody.add(policyConditionGroupBody89.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            char_literal90=(Token)match(input,86,FOLLOW_86_in_policyConditionGroup1049);  
            stream_86.add(char_literal90);

            char_literal91=(Token)match(input,84,FOLLOW_84_in_policyConditionGroup1051);  
            stream_84.add(char_literal91);



            // AST REWRITE
            // elements: POLA_GROUP, IDENT, policyConditionGroupBody
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 172:31: -> ^( POLA_GROUP IDENT ( policyConditionGroupBody )* )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:172:34: ^( POLA_GROUP IDENT ( policyConditionGroupBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_POLA_GROUP.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:172:53: ( policyConditionGroupBody )*
                while ( stream_policyConditionGroupBody.hasNext() ) {
                    adaptor.addChild(root_1, stream_policyConditionGroupBody.nextTree());

                }
                stream_policyConditionGroupBody.reset();

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
    // $ANTLR end "policyConditionGroup"

    public static class policyConditionGroupBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionGroupBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:173:1: policyConditionGroupBody : ( policyConditionGroup | policyCondition );
    public final polaEbnfParser.policyConditionGroupBody_return policyConditionGroupBody() throws RecognitionException {
        polaEbnfParser.policyConditionGroupBody_return retval = new polaEbnfParser.policyConditionGroupBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyConditionGroup_return policyConditionGroup92 = null;

        polaEbnfParser.policyCondition_return policyCondition93 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:173:29: ( policyConditionGroup | policyCondition )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==POLA_GROUP) ) {
                alt21=1;
            }
            else if ( ((LA21_0>=POLA_COMPOSITE && LA21_0<=POLA_NONSTD)||LA21_0==84) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:173:31: policyConditionGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyConditionGroup_in_policyConditionGroupBody1102);
                    policyConditionGroup92=policyConditionGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionGroup92.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:173:54: policyCondition
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyCondition_in_policyConditionGroupBody1106);
                    policyCondition93=policyCondition();

                    state._fsp--;

                    adaptor.addChild(root_0, policyCondition93.getTree());

                    }
                    break;

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
    // $ANTLR end "policyConditionGroupBody"

    public static class policyCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyCondition"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:174:1: policyCondition : ( policyConditionBody )* ';' -> ^( BODY ( policyConditionBody )* ) ;
    public final polaEbnfParser.policyCondition_return policyCondition() throws RecognitionException {
        polaEbnfParser.policyCondition_return retval = new polaEbnfParser.policyCondition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal95=null;
        polaEbnfParser.policyConditionBody_return policyConditionBody94 = null;


        CommonTree char_literal95_tree=null;
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_policyConditionBody=new RewriteRuleSubtreeStream(adaptor,"rule policyConditionBody");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:174:29: ( ( policyConditionBody )* ';' -> ^( BODY ( policyConditionBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:174:31: ( policyConditionBody )* ';'
            {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:174:31: ( policyConditionBody )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=POLA_COMPOSITE && LA22_0<=POLA_NONSTD)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:174:31: policyConditionBody
            	    {
            	    pushFollow(FOLLOW_policyConditionBody_in_policyCondition1125);
            	    policyConditionBody94=policyConditionBody();

            	    state._fsp--;

            	    stream_policyConditionBody.add(policyConditionBody94.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            char_literal95=(Token)match(input,84,FOLLOW_84_in_policyCondition1128);  
            stream_84.add(char_literal95);



            // AST REWRITE
            // elements: policyConditionBody
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 174:56: -> ^( BODY ( policyConditionBody )* )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:174:59: ^( BODY ( policyConditionBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BODY, "BODY"), root_1);

                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:174:66: ( policyConditionBody )*
                while ( stream_policyConditionBody.hasNext() ) {
                    adaptor.addChild(root_1, stream_policyConditionBody.nextTree());

                }
                stream_policyConditionBody.reset();

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
    // $ANTLR end "policyCondition"

    public static class policyConditionBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:175:1: policyConditionBody : ( policyConditionComposite | policyConditionAtomic | policyConditionNonStd );
    public final polaEbnfParser.policyConditionBody_return policyConditionBody() throws RecognitionException {
        polaEbnfParser.policyConditionBody_return retval = new polaEbnfParser.policyConditionBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyConditionComposite_return policyConditionComposite96 = null;

        polaEbnfParser.policyConditionAtomic_return policyConditionAtomic97 = null;

        polaEbnfParser.policyConditionNonStd_return policyConditionNonStd98 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:175:29: ( policyConditionComposite | policyConditionAtomic | policyConditionNonStd )
            int alt23=3;
            switch ( input.LA(1) ) {
            case POLA_COMPOSITE:
                {
                alt23=1;
                }
                break;
            case POLA_ATOMIC:
                {
                alt23=2;
                }
                break;
            case POLA_NONSTD:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:175:31: policyConditionComposite
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyConditionComposite_in_policyConditionBody1152);
                    policyConditionComposite96=policyConditionComposite();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionComposite96.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:175:58: policyConditionAtomic
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyConditionAtomic_in_policyConditionBody1156);
                    policyConditionAtomic97=policyConditionAtomic();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionAtomic97.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:175:82: policyConditionNonStd
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyConditionNonStd_in_policyConditionBody1160);
                    policyConditionNonStd98=policyConditionNonStd();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionNonStd98.getTree());

                    }
                    break;

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
    // $ANTLR end "policyConditionBody"

    public static class policyConditionComposite_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionComposite"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:176:1: policyConditionComposite : POLA_COMPOSITE policyECAInherited '{' ( policyCondition )* '}' -> ^( POLA_COMPOSITE policyECAInherited ( policyCondition )* ) ;
    public final polaEbnfParser.policyConditionComposite_return policyConditionComposite() throws RecognitionException {
        polaEbnfParser.policyConditionComposite_return retval = new polaEbnfParser.policyConditionComposite_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_COMPOSITE99=null;
        Token char_literal101=null;
        Token char_literal103=null;
        polaEbnfParser.policyECAInherited_return policyECAInherited100 = null;

        polaEbnfParser.policyCondition_return policyCondition102 = null;


        CommonTree POLA_COMPOSITE99_tree=null;
        CommonTree char_literal101_tree=null;
        CommonTree char_literal103_tree=null;
        RewriteRuleTokenStream stream_POLA_COMPOSITE=new RewriteRuleTokenStream(adaptor,"token POLA_COMPOSITE");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_policyECAInherited=new RewriteRuleSubtreeStream(adaptor,"rule policyECAInherited");
        RewriteRuleSubtreeStream stream_policyCondition=new RewriteRuleSubtreeStream(adaptor,"rule policyCondition");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:176:29: ( POLA_COMPOSITE policyECAInherited '{' ( policyCondition )* '}' -> ^( POLA_COMPOSITE policyECAInherited ( policyCondition )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:176:31: POLA_COMPOSITE policyECAInherited '{' ( policyCondition )* '}'
            {
            POLA_COMPOSITE99=(Token)match(input,POLA_COMPOSITE,FOLLOW_POLA_COMPOSITE_in_policyConditionComposite1170);  
            stream_POLA_COMPOSITE.add(POLA_COMPOSITE99);

            pushFollow(FOLLOW_policyECAInherited_in_policyConditionComposite1172);
            policyECAInherited100=policyECAInherited();

            state._fsp--;

            stream_policyECAInherited.add(policyECAInherited100.getTree());
            char_literal101=(Token)match(input,85,FOLLOW_85_in_policyConditionComposite1174);  
            stream_85.add(char_literal101);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:176:69: ( policyCondition )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=POLA_COMPOSITE && LA24_0<=POLA_NONSTD)||LA24_0==84) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:176:69: policyCondition
            	    {
            	    pushFollow(FOLLOW_policyCondition_in_policyConditionComposite1176);
            	    policyCondition102=policyCondition();

            	    state._fsp--;

            	    stream_policyCondition.add(policyCondition102.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            char_literal103=(Token)match(input,86,FOLLOW_86_in_policyConditionComposite1179);  
            stream_86.add(char_literal103);



            // AST REWRITE
            // elements: policyECAInherited, POLA_COMPOSITE, policyCondition
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 177:27: -> ^( POLA_COMPOSITE policyECAInherited ( policyCondition )* )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:177:30: ^( POLA_COMPOSITE policyECAInherited ( policyCondition )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_POLA_COMPOSITE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_policyECAInherited.nextTree());
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:177:66: ( policyCondition )*
                while ( stream_policyCondition.hasNext() ) {
                    adaptor.addChild(root_1, stream_policyCondition.nextTree());

                }
                stream_policyCondition.reset();

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
    // $ANTLR end "policyConditionComposite"

    public static class policyConditionAtomic_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionAtomic"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:178:1: policyConditionAtomic : POLA_ATOMIC policyECAInherited pola_string ;
    public final polaEbnfParser.policyConditionAtomic_return policyConditionAtomic() throws RecognitionException {
        polaEbnfParser.policyConditionAtomic_return retval = new polaEbnfParser.policyConditionAtomic_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_ATOMIC104=null;
        polaEbnfParser.policyECAInherited_return policyECAInherited105 = null;

        polaEbnfParser.pola_string_return pola_string106 = null;


        CommonTree POLA_ATOMIC104_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:178:29: ( POLA_ATOMIC policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:178:31: POLA_ATOMIC policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_ATOMIC104=(Token)match(input,POLA_ATOMIC,FOLLOW_POLA_ATOMIC_in_policyConditionAtomic1229); 
            POLA_ATOMIC104_tree = (CommonTree)adaptor.create(POLA_ATOMIC104);
            adaptor.addChild(root_0, POLA_ATOMIC104_tree);

            pushFollow(FOLLOW_policyECAInherited_in_policyConditionAtomic1231);
            policyECAInherited105=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited105.getTree());
            pushFollow(FOLLOW_pola_string_in_policyConditionAtomic1233);
            pola_string106=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string106.getTree());

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
    // $ANTLR end "policyConditionAtomic"

    public static class policyConditionNonStd_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionNonStd"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:179:1: policyConditionNonStd : POLA_NONSTD policyECAInherited pola_string ;
    public final polaEbnfParser.policyConditionNonStd_return policyConditionNonStd() throws RecognitionException {
        polaEbnfParser.policyConditionNonStd_return retval = new polaEbnfParser.policyConditionNonStd_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_NONSTD107=null;
        polaEbnfParser.policyECAInherited_return policyECAInherited108 = null;

        polaEbnfParser.pola_string_return pola_string109 = null;


        CommonTree POLA_NONSTD107_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:179:29: ( POLA_NONSTD policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:179:31: POLA_NONSTD policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_NONSTD107=(Token)match(input,POLA_NONSTD,FOLLOW_POLA_NONSTD_in_policyConditionNonStd1246); 
            POLA_NONSTD107_tree = (CommonTree)adaptor.create(POLA_NONSTD107);
            adaptor.addChild(root_0, POLA_NONSTD107_tree);

            pushFollow(FOLLOW_policyECAInherited_in_policyConditionNonStd1248);
            policyECAInherited108=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited108.getTree());
            pushFollow(FOLLOW_pola_string_in_policyConditionNonStd1250);
            pola_string109=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string109.getTree());

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
    // $ANTLR end "policyConditionNonStd"

    public static class policyActionStructure_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:181:1: policyActionStructure : POLA_ACTION ( policyActionStructureBody )* ;
    public final polaEbnfParser.policyActionStructure_return policyActionStructure() throws RecognitionException {
        polaEbnfParser.policyActionStructure_return retval = new polaEbnfParser.policyActionStructure_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_ACTION110=null;
        polaEbnfParser.policyActionStructureBody_return policyActionStructureBody111 = null;


        CommonTree POLA_ACTION110_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:181:26: ( POLA_ACTION ( policyActionStructureBody )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:181:28: POLA_ACTION ( policyActionStructureBody )*
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_ACTION110=(Token)match(input,POLA_ACTION,FOLLOW_POLA_ACTION_in_policyActionStructure1261); 
            POLA_ACTION110_tree = (CommonTree)adaptor.create(POLA_ACTION110);
            adaptor.addChild(root_0, POLA_ACTION110_tree);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:181:40: ( policyActionStructureBody )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=POLA_GROUP && LA25_0<=POLA_NONSTD)||LA25_0==84) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:181:40: policyActionStructureBody
            	    {
            	    pushFollow(FOLLOW_policyActionStructureBody_in_policyActionStructure1263);
            	    policyActionStructureBody111=policyActionStructureBody();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyActionStructureBody111.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


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
    // $ANTLR end "policyActionStructure"

    public static class policyActionStructureBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionStructureBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:182:1: policyActionStructureBody : ( policyActionGroup | policyAction );
    public final polaEbnfParser.policyActionStructureBody_return policyActionStructureBody() throws RecognitionException {
        polaEbnfParser.policyActionStructureBody_return retval = new polaEbnfParser.policyActionStructureBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyActionGroup_return policyActionGroup112 = null;

        polaEbnfParser.policyAction_return policyAction113 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:182:26: ( policyActionGroup | policyAction )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==POLA_GROUP) ) {
                alt26=1;
            }
            else if ( ((LA26_0>=POLA_COMPOSITE && LA26_0<=POLA_NONSTD)||LA26_0==84) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:182:28: policyActionGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyActionGroup_in_policyActionStructureBody1270);
                    policyActionGroup112=policyActionGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionGroup112.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:182:48: policyAction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyAction_in_policyActionStructureBody1274);
                    policyAction113=policyAction();

                    state._fsp--;

                    adaptor.addChild(root_0, policyAction113.getTree());

                    }
                    break;

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
    // $ANTLR end "policyActionStructureBody"

    public static class policyActionGroup_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionGroup"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:183:1: policyActionGroup : POLA_GROUP IDENT '{' ( policyActionGroupBody )* '}' ';' -> ^( POLA_GROUP IDENT ( policyActionGroupBody )* ) ;
    public final polaEbnfParser.policyActionGroup_return policyActionGroup() throws RecognitionException {
        polaEbnfParser.policyActionGroup_return retval = new polaEbnfParser.policyActionGroup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_GROUP114=null;
        Token IDENT115=null;
        Token char_literal116=null;
        Token char_literal118=null;
        Token char_literal119=null;
        polaEbnfParser.policyActionGroupBody_return policyActionGroupBody117 = null;


        CommonTree POLA_GROUP114_tree=null;
        CommonTree IDENT115_tree=null;
        CommonTree char_literal116_tree=null;
        CommonTree char_literal118_tree=null;
        CommonTree char_literal119_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_POLA_GROUP=new RewriteRuleTokenStream(adaptor,"token POLA_GROUP");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_policyActionGroupBody=new RewriteRuleSubtreeStream(adaptor,"rule policyActionGroupBody");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:183:26: ( POLA_GROUP IDENT '{' ( policyActionGroupBody )* '}' ';' -> ^( POLA_GROUP IDENT ( policyActionGroupBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:183:28: POLA_GROUP IDENT '{' ( policyActionGroupBody )* '}' ';'
            {
            POLA_GROUP114=(Token)match(input,POLA_GROUP,FOLLOW_POLA_GROUP_in_policyActionGroup1288);  
            stream_POLA_GROUP.add(POLA_GROUP114);

            IDENT115=(Token)match(input,IDENT,FOLLOW_IDENT_in_policyActionGroup1290);  
            stream_IDENT.add(IDENT115);

            char_literal116=(Token)match(input,85,FOLLOW_85_in_policyActionGroup1292);  
            stream_85.add(char_literal116);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:183:49: ( policyActionGroupBody )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=POLA_GROUP && LA27_0<=POLA_NONSTD)||LA27_0==84) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:183:49: policyActionGroupBody
            	    {
            	    pushFollow(FOLLOW_policyActionGroupBody_in_policyActionGroup1294);
            	    policyActionGroupBody117=policyActionGroupBody();

            	    state._fsp--;

            	    stream_policyActionGroupBody.add(policyActionGroupBody117.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            char_literal118=(Token)match(input,86,FOLLOW_86_in_policyActionGroup1297);  
            stream_86.add(char_literal118);

            char_literal119=(Token)match(input,84,FOLLOW_84_in_policyActionGroup1299);  
            stream_84.add(char_literal119);



            // AST REWRITE
            // elements: IDENT, policyActionGroupBody, POLA_GROUP
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 184:31: -> ^( POLA_GROUP IDENT ( policyActionGroupBody )* )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:184:34: ^( POLA_GROUP IDENT ( policyActionGroupBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_POLA_GROUP.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:184:53: ( policyActionGroupBody )*
                while ( stream_policyActionGroupBody.hasNext() ) {
                    adaptor.addChild(root_1, stream_policyActionGroupBody.nextTree());

                }
                stream_policyActionGroupBody.reset();

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
    // $ANTLR end "policyActionGroup"

    public static class policyActionGroupBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionGroupBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:185:1: policyActionGroupBody : ( policyActionGroup | policyAction );
    public final polaEbnfParser.policyActionGroupBody_return policyActionGroupBody() throws RecognitionException {
        polaEbnfParser.policyActionGroupBody_return retval = new polaEbnfParser.policyActionGroupBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyActionGroup_return policyActionGroup120 = null;

        polaEbnfParser.policyAction_return policyAction121 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:185:26: ( policyActionGroup | policyAction )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==POLA_GROUP) ) {
                alt28=1;
            }
            else if ( ((LA28_0>=POLA_COMPOSITE && LA28_0<=POLA_NONSTD)||LA28_0==84) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:185:28: policyActionGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyActionGroup_in_policyActionGroupBody1350);
                    policyActionGroup120=policyActionGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionGroup120.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:185:48: policyAction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyAction_in_policyActionGroupBody1354);
                    policyAction121=policyAction();

                    state._fsp--;

                    adaptor.addChild(root_0, policyAction121.getTree());

                    }
                    break;

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
    // $ANTLR end "policyActionGroupBody"

    public static class policyAction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyAction"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:186:1: policyAction : ( policyActionBody )* ';' -> ^( BODY ( policyActionBody )* ) ;
    public final polaEbnfParser.policyAction_return policyAction() throws RecognitionException {
        polaEbnfParser.policyAction_return retval = new polaEbnfParser.policyAction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal123=null;
        polaEbnfParser.policyActionBody_return policyActionBody122 = null;


        CommonTree char_literal123_tree=null;
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_policyActionBody=new RewriteRuleSubtreeStream(adaptor,"rule policyActionBody");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:186:26: ( ( policyActionBody )* ';' -> ^( BODY ( policyActionBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:186:28: ( policyActionBody )* ';'
            {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:186:28: ( policyActionBody )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=POLA_COMPOSITE && LA29_0<=POLA_NONSTD)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:186:28: policyActionBody
            	    {
            	    pushFollow(FOLLOW_policyActionBody_in_policyAction1373);
            	    policyActionBody122=policyActionBody();

            	    state._fsp--;

            	    stream_policyActionBody.add(policyActionBody122.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            char_literal123=(Token)match(input,84,FOLLOW_84_in_policyAction1376);  
            stream_84.add(char_literal123);



            // AST REWRITE
            // elements: policyActionBody
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 186:50: -> ^( BODY ( policyActionBody )* )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:186:53: ^( BODY ( policyActionBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BODY, "BODY"), root_1);

                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:186:60: ( policyActionBody )*
                while ( stream_policyActionBody.hasNext() ) {
                    adaptor.addChild(root_1, stream_policyActionBody.nextTree());

                }
                stream_policyActionBody.reset();

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
    // $ANTLR end "policyAction"

    public static class policyActionBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:187:1: policyActionBody : ( policyActionComposite | policyActionAtomic | policyActionNonStd );
    public final polaEbnfParser.policyActionBody_return policyActionBody() throws RecognitionException {
        polaEbnfParser.policyActionBody_return retval = new polaEbnfParser.policyActionBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.policyActionComposite_return policyActionComposite124 = null;

        polaEbnfParser.policyActionAtomic_return policyActionAtomic125 = null;

        polaEbnfParser.policyActionNonStd_return policyActionNonStd126 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:187:26: ( policyActionComposite | policyActionAtomic | policyActionNonStd )
            int alt30=3;
            switch ( input.LA(1) ) {
            case POLA_COMPOSITE:
                {
                alt30=1;
                }
                break;
            case POLA_ATOMIC:
                {
                alt30=2;
                }
                break;
            case POLA_NONSTD:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:187:28: policyActionComposite
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyActionComposite_in_policyActionBody1400);
                    policyActionComposite124=policyActionComposite();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionComposite124.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:187:52: policyActionAtomic
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyActionAtomic_in_policyActionBody1404);
                    policyActionAtomic125=policyActionAtomic();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionAtomic125.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:187:73: policyActionNonStd
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_policyActionNonStd_in_policyActionBody1408);
                    policyActionNonStd126=policyActionNonStd();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionNonStd126.getTree());

                    }
                    break;

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
    // $ANTLR end "policyActionBody"

    public static class policyActionComposite_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionComposite"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:188:1: policyActionComposite : POLA_COMPOSITE policyECAInherited '{' ( policyAction )* '}' -> ^( POLA_COMPOSITE policyECAInherited ( policyAction )* ) ;
    public final polaEbnfParser.policyActionComposite_return policyActionComposite() throws RecognitionException {
        polaEbnfParser.policyActionComposite_return retval = new polaEbnfParser.policyActionComposite_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_COMPOSITE127=null;
        Token char_literal129=null;
        Token char_literal131=null;
        polaEbnfParser.policyECAInherited_return policyECAInherited128 = null;

        polaEbnfParser.policyAction_return policyAction130 = null;


        CommonTree POLA_COMPOSITE127_tree=null;
        CommonTree char_literal129_tree=null;
        CommonTree char_literal131_tree=null;
        RewriteRuleTokenStream stream_POLA_COMPOSITE=new RewriteRuleTokenStream(adaptor,"token POLA_COMPOSITE");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_policyAction=new RewriteRuleSubtreeStream(adaptor,"rule policyAction");
        RewriteRuleSubtreeStream stream_policyECAInherited=new RewriteRuleSubtreeStream(adaptor,"rule policyECAInherited");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:188:26: ( POLA_COMPOSITE policyECAInherited '{' ( policyAction )* '}' -> ^( POLA_COMPOSITE policyECAInherited ( policyAction )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:188:28: POLA_COMPOSITE policyECAInherited '{' ( policyAction )* '}'
            {
            POLA_COMPOSITE127=(Token)match(input,POLA_COMPOSITE,FOLLOW_POLA_COMPOSITE_in_policyActionComposite1418);  
            stream_POLA_COMPOSITE.add(POLA_COMPOSITE127);

            pushFollow(FOLLOW_policyECAInherited_in_policyActionComposite1420);
            policyECAInherited128=policyECAInherited();

            state._fsp--;

            stream_policyECAInherited.add(policyECAInherited128.getTree());
            char_literal129=(Token)match(input,85,FOLLOW_85_in_policyActionComposite1422);  
            stream_85.add(char_literal129);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:188:66: ( policyAction )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=POLA_COMPOSITE && LA31_0<=POLA_NONSTD)||LA31_0==84) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:188:66: policyAction
            	    {
            	    pushFollow(FOLLOW_policyAction_in_policyActionComposite1424);
            	    policyAction130=policyAction();

            	    state._fsp--;

            	    stream_policyAction.add(policyAction130.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            char_literal131=(Token)match(input,86,FOLLOW_86_in_policyActionComposite1427);  
            stream_86.add(char_literal131);



            // AST REWRITE
            // elements: policyECAInherited, policyAction, POLA_COMPOSITE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 189:27: -> ^( POLA_COMPOSITE policyECAInherited ( policyAction )* )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:189:30: ^( POLA_COMPOSITE policyECAInherited ( policyAction )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_POLA_COMPOSITE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_policyECAInherited.nextTree());
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:189:66: ( policyAction )*
                while ( stream_policyAction.hasNext() ) {
                    adaptor.addChild(root_1, stream_policyAction.nextTree());

                }
                stream_policyAction.reset();

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
    // $ANTLR end "policyActionComposite"

    public static class policyActionAtomic_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionAtomic"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:190:1: policyActionAtomic : POLA_ATOMIC policyECAInherited pola_string ;
    public final polaEbnfParser.policyActionAtomic_return policyActionAtomic() throws RecognitionException {
        polaEbnfParser.policyActionAtomic_return retval = new polaEbnfParser.policyActionAtomic_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_ATOMIC132=null;
        polaEbnfParser.policyECAInherited_return policyECAInherited133 = null;

        polaEbnfParser.pola_string_return pola_string134 = null;


        CommonTree POLA_ATOMIC132_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:190:26: ( POLA_ATOMIC policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:190:28: POLA_ATOMIC policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_ATOMIC132=(Token)match(input,POLA_ATOMIC,FOLLOW_POLA_ATOMIC_in_policyActionAtomic1477); 
            POLA_ATOMIC132_tree = (CommonTree)adaptor.create(POLA_ATOMIC132);
            adaptor.addChild(root_0, POLA_ATOMIC132_tree);

            pushFollow(FOLLOW_policyECAInherited_in_policyActionAtomic1479);
            policyECAInherited133=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited133.getTree());
            pushFollow(FOLLOW_pola_string_in_policyActionAtomic1481);
            pola_string134=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string134.getTree());

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
    // $ANTLR end "policyActionAtomic"

    public static class policyActionNonStd_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionNonStd"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:191:1: policyActionNonStd : POLA_NONSTD policyECAInherited pola_string ;
    public final polaEbnfParser.policyActionNonStd_return policyActionNonStd() throws RecognitionException {
        polaEbnfParser.policyActionNonStd_return retval = new polaEbnfParser.policyActionNonStd_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POLA_NONSTD135=null;
        polaEbnfParser.policyECAInherited_return policyECAInherited136 = null;

        polaEbnfParser.pola_string_return pola_string137 = null;


        CommonTree POLA_NONSTD135_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:191:26: ( POLA_NONSTD policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:191:28: POLA_NONSTD policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            POLA_NONSTD135=(Token)match(input,POLA_NONSTD,FOLLOW_POLA_NONSTD_in_policyActionNonStd1494); 
            POLA_NONSTD135_tree = (CommonTree)adaptor.create(POLA_NONSTD135);
            adaptor.addChild(root_0, POLA_NONSTD135_tree);

            pushFollow(FOLLOW_policyECAInherited_in_policyActionNonStd1496);
            policyECAInherited136=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited136.getTree());
            pushFollow(FOLLOW_pola_string_in_policyActionNonStd1498);
            pola_string137=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string137.getTree());

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
    // $ANTLR end "policyActionNonStd"

    public static class policyECAInherited_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyECAInherited"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:193:1: policyECAInherited : IDENT POLA_SEQ_NUMER ':' VAL_INTEGER POLA_HASBEEN_EVALED ':' boolean_value -> ^( POLA_SEQ_NUMER VAL_INTEGER ) ^( POLA_HASBEEN_EVALED boolean_value ) ;
    public final polaEbnfParser.policyECAInherited_return policyECAInherited() throws RecognitionException {
        polaEbnfParser.policyECAInherited_return retval = new polaEbnfParser.policyECAInherited_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT138=null;
        Token POLA_SEQ_NUMER139=null;
        Token char_literal140=null;
        Token VAL_INTEGER141=null;
        Token POLA_HASBEEN_EVALED142=null;
        Token char_literal143=null;
        polaEbnfParser.boolean_value_return boolean_value144 = null;


        CommonTree IDENT138_tree=null;
        CommonTree POLA_SEQ_NUMER139_tree=null;
        CommonTree char_literal140_tree=null;
        CommonTree VAL_INTEGER141_tree=null;
        CommonTree POLA_HASBEEN_EVALED142_tree=null;
        CommonTree char_literal143_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_VAL_INTEGER=new RewriteRuleTokenStream(adaptor,"token VAL_INTEGER");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleTokenStream stream_POLA_HASBEEN_EVALED=new RewriteRuleTokenStream(adaptor,"token POLA_HASBEEN_EVALED");
        RewriteRuleTokenStream stream_POLA_SEQ_NUMER=new RewriteRuleTokenStream(adaptor,"token POLA_SEQ_NUMER");
        RewriteRuleSubtreeStream stream_boolean_value=new RewriteRuleSubtreeStream(adaptor,"rule boolean_value");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:193:23: ( IDENT POLA_SEQ_NUMER ':' VAL_INTEGER POLA_HASBEEN_EVALED ':' boolean_value -> ^( POLA_SEQ_NUMER VAL_INTEGER ) ^( POLA_HASBEEN_EVALED boolean_value ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:193:25: IDENT POLA_SEQ_NUMER ':' VAL_INTEGER POLA_HASBEEN_EVALED ':' boolean_value
            {
            IDENT138=(Token)match(input,IDENT,FOLLOW_IDENT_in_policyECAInherited1509);  
            stream_IDENT.add(IDENT138);

            POLA_SEQ_NUMER139=(Token)match(input,POLA_SEQ_NUMER,FOLLOW_POLA_SEQ_NUMER_in_policyECAInherited1511);  
            stream_POLA_SEQ_NUMER.add(POLA_SEQ_NUMER139);

            char_literal140=(Token)match(input,92,FOLLOW_92_in_policyECAInherited1513);  
            stream_92.add(char_literal140);

            VAL_INTEGER141=(Token)match(input,VAL_INTEGER,FOLLOW_VAL_INTEGER_in_policyECAInherited1515);  
            stream_VAL_INTEGER.add(VAL_INTEGER141);

            POLA_HASBEEN_EVALED142=(Token)match(input,POLA_HASBEEN_EVALED,FOLLOW_POLA_HASBEEN_EVALED_in_policyECAInherited1517);  
            stream_POLA_HASBEEN_EVALED.add(POLA_HASBEEN_EVALED142);

            char_literal143=(Token)match(input,92,FOLLOW_92_in_policyECAInherited1519);  
            stream_92.add(char_literal143);

            pushFollow(FOLLOW_boolean_value_in_policyECAInherited1521);
            boolean_value144=boolean_value();

            state._fsp--;

            stream_boolean_value.add(boolean_value144.getTree());


            // AST REWRITE
            // elements: boolean_value, POLA_HASBEEN_EVALED, POLA_SEQ_NUMER, VAL_INTEGER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 194:25: -> ^( POLA_SEQ_NUMER VAL_INTEGER ) ^( POLA_HASBEEN_EVALED boolean_value )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:194:28: ^( POLA_SEQ_NUMER VAL_INTEGER )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_POLA_SEQ_NUMER.nextNode(), root_1);

                adaptor.addChild(root_1, stream_VAL_INTEGER.nextNode());

                adaptor.addChild(root_0, root_1);
                }
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:194:58: ^( POLA_HASBEEN_EVALED boolean_value )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_POLA_HASBEEN_EVALED.nextNode(), root_1);

                adaptor.addChild(root_1, stream_boolean_value.nextTree());

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
    // $ANTLR end "policyECAInherited"

    public static class pola_string_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pola_string"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:197:1: pola_string : VAL_DSTRING ;
    public final polaEbnfParser.pola_string_return pola_string() throws RecognitionException {
        polaEbnfParser.pola_string_return retval = new polaEbnfParser.pola_string_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VAL_DSTRING145=null;

        CommonTree VAL_DSTRING145_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:197:25: ( VAL_DSTRING )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:197:27: VAL_DSTRING
            {
            root_0 = (CommonTree)adaptor.nil();

            VAL_DSTRING145=(Token)match(input,VAL_DSTRING,FOLLOW_VAL_DSTRING_in_pola_string1580); 
            VAL_DSTRING145_tree = (CommonTree)adaptor.create(VAL_DSTRING145);
            adaptor.addChild(root_0, VAL_DSTRING145_tree);


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
    // $ANTLR end "pola_string"

    public static class scoped_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scoped_name"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:199:1: scoped_name : (s= IDENT ( '::' s= IDENT )* '::' )? s= IDENT -> ^( AT_SCOPE ( IDENT )* ) ;
    public final polaEbnfParser.scoped_name_return scoped_name() throws RecognitionException {
        polaEbnfParser.scoped_name_return retval = new polaEbnfParser.scoped_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token string_literal146=null;
        Token string_literal147=null;

        CommonTree s_tree=null;
        CommonTree string_literal146_tree=null;
        CommonTree string_literal147_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:199:25: ( (s= IDENT ( '::' s= IDENT )* '::' )? s= IDENT -> ^( AT_SCOPE ( IDENT )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:199:27: (s= IDENT ( '::' s= IDENT )* '::' )? s= IDENT
            {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:199:27: (s= IDENT ( '::' s= IDENT )* '::' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==IDENT) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==93) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:199:28: s= IDENT ( '::' s= IDENT )* '::'
                    {
                    s=(Token)match(input,IDENT,FOLLOW_IDENT_in_scoped_name1603);  
                    stream_IDENT.add(s);

                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:199:36: ( '::' s= IDENT )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==93) ) {
                            int LA32_1 = input.LA(2);

                            if ( (LA32_1==IDENT) ) {
                                int LA32_2 = input.LA(3);

                                if ( (LA32_2==93) ) {
                                    alt32=1;
                                }


                            }


                        }


                        switch (alt32) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:199:37: '::' s= IDENT
                    	    {
                    	    string_literal146=(Token)match(input,93,FOLLOW_93_in_scoped_name1606);  
                    	    stream_93.add(string_literal146);

                    	    s=(Token)match(input,IDENT,FOLLOW_IDENT_in_scoped_name1610);  
                    	    stream_IDENT.add(s);


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    string_literal147=(Token)match(input,93,FOLLOW_93_in_scoped_name1614);  
                    stream_93.add(string_literal147);


                    }
                    break;

            }

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_scoped_name1620);  
            stream_IDENT.add(s);



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
            // 199:67: -> ^( AT_SCOPE ( IDENT )* )
            {
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:199:70: ^( AT_SCOPE ( IDENT )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_SCOPE, "AT_SCOPE"), root_1);

                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:199:81: ( IDENT )*
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

    public static class void_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "void_type"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:201:1: void_type : VOID ;
    public final polaEbnfParser.void_type_return void_type() throws RecognitionException {
        polaEbnfParser.void_type_return retval = new polaEbnfParser.void_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VOID148=null;

        CommonTree VOID148_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:201:25: ( VOID )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:201:27: VOID
            {
            root_0 = (CommonTree)adaptor.nil();

            VOID148=(Token)match(input,VOID,FOLLOW_VOID_in_void_type1651); 
            VOID148_tree = (CommonTree)adaptor.create(VOID148);
            adaptor.addChild(root_0, VOID148_tree);


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
    // $ANTLR end "void_type"

    public static class simple_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simple_type"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:202:1: simple_type : ( scoped_name | base_type ) ( array )? ;
    public final polaEbnfParser.simple_type_return simple_type() throws RecognitionException {
        polaEbnfParser.simple_type_return retval = new polaEbnfParser.simple_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        polaEbnfParser.scoped_name_return scoped_name149 = null;

        polaEbnfParser.base_type_return base_type150 = null;

        polaEbnfParser.array_return array151 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:202:25: ( ( scoped_name | base_type ) ( array )? )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:202:27: ( scoped_name | base_type ) ( array )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:202:27: ( scoped_name | base_type )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==IDENT) ) {
                alt34=1;
            }
            else if ( ((LA34_0>=SHORT && LA34_0<=BOOLEAN)) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:202:28: scoped_name
                    {
                    pushFollow(FOLLOW_scoped_name_in_simple_type1671);
                    scoped_name149=scoped_name();

                    state._fsp--;

                    adaptor.addChild(root_0, scoped_name149.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:202:42: base_type
                    {
                    pushFollow(FOLLOW_base_type_in_simple_type1675);
                    base_type150=base_type();

                    state._fsp--;

                    adaptor.addChild(root_0, base_type150.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:202:53: ( array )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==94) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:202:53: array
                    {
                    pushFollow(FOLLOW_array_in_simple_type1678);
                    array151=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array151.getTree());

                    }
                    break;

            }


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
    // $ANTLR end "simple_type"

    public static class base_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "base_type"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:1: base_type : (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN ) ;
    public final polaEbnfParser.base_type_return base_type() throws RecognitionException {
        polaEbnfParser.base_type_return retval = new polaEbnfParser.base_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:25: ( (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:27: (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:27: (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN )
            int alt36=11;
            switch ( input.LA(1) ) {
            case SHORT:
                {
                alt36=1;
                }
                break;
            case INTEGER:
                {
                alt36=2;
                }
                break;
            case LONG:
                {
                alt36=3;
                }
                break;
            case OCTET:
                {
                alt36=4;
                }
                break;
            case HEX:
                {
                alt36=5;
                }
                break;
            case BINARY:
                {
                alt36=6;
                }
                break;
            case FLOAT:
                {
                alt36=7;
                }
                break;
            case DOUBLE:
                {
                alt36=8;
                }
                break;
            case CHAR:
                {
                alt36=9;
                }
                break;
            case STRING:
                {
                alt36=10;
                }
                break;
            case BOOLEAN:
                {
                alt36=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:28: s= SHORT
                    {
                    s=(Token)match(input,SHORT,FOLLOW_SHORT_in_base_type1730); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:38: s= INTEGER
                    {
                    s=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_base_type1736); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:50: s= LONG
                    {
                    s=(Token)match(input,LONG,FOLLOW_LONG_in_base_type1742); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:59: s= OCTET
                    {
                    s=(Token)match(input,OCTET,FOLLOW_OCTET_in_base_type1748); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:69: s= HEX
                    {
                    s=(Token)match(input,HEX,FOLLOW_HEX_in_base_type1754); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:77: s= BINARY
                    {
                    s=(Token)match(input,BINARY,FOLLOW_BINARY_in_base_type1760); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:88: s= FLOAT
                    {
                    s=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_base_type1766); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:98: s= DOUBLE
                    {
                    s=(Token)match(input,DOUBLE,FOLLOW_DOUBLE_in_base_type1772); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 9 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:109: s= CHAR
                    {
                    s=(Token)match(input,CHAR,FOLLOW_CHAR_in_base_type1778); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 10 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:118: s= STRING
                    {
                    s=(Token)match(input,STRING,FOLLOW_STRING_in_base_type1784); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 11 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:204:129: s= BOOLEAN
                    {
                    s=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_base_type1790); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;

            }

            this.base_type=s;

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
    // $ANTLR end "base_type"

    public static class array_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "array"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:207:1: array : '[' ']' -> ARRAY ;
    public final polaEbnfParser.array_return array() throws RecognitionException {
        polaEbnfParser.array_return retval = new polaEbnfParser.array_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal152=null;
        Token char_literal153=null;

        CommonTree char_literal152_tree=null;
        CommonTree char_literal153_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:207:25: ( '[' ']' -> ARRAY )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:207:27: '[' ']'
            {
            char_literal152=(Token)match(input,94,FOLLOW_94_in_array1871);  
            stream_94.add(char_literal152);

            char_literal153=(Token)match(input,95,FOLLOW_95_in_array1873);  
            stream_95.add(char_literal153);

            this.isArray=true;


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 207:56: -> ARRAY
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(ARRAY, "ARRAY"));

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
    // $ANTLR end "array"

    public static class const_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "const_value"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:209:1: const_value : ( VAL_INTEGER -> ^( AT_PROVIDES INTEGER VAL_INTEGER ) | VAL_OCT -> ^( AT_PROVIDES OCTET VAL_OCT ) | VAL_HEX -> ^( AT_PROVIDES HEX VAL_HEX ) | VAL_BINARY -> ^( AT_PROVIDES BINARY VAL_BINARY ) | VAL_FLOAT -> ^( AT_PROVIDES FLOAT VAL_FLOAT ) | VAL_CHAR -> ^( AT_PROVIDES CHAR VAL_CHAR ) | string_value -> ^( AT_PROVIDES STRING string_value ) | boolean_value -> ^( AT_PROVIDES BOOLEAN boolean_value ) );
    public final polaEbnfParser.const_value_return const_value() throws RecognitionException {
        polaEbnfParser.const_value_return retval = new polaEbnfParser.const_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VAL_INTEGER154=null;
        Token VAL_OCT155=null;
        Token VAL_HEX156=null;
        Token VAL_BINARY157=null;
        Token VAL_FLOAT158=null;
        Token VAL_CHAR159=null;
        polaEbnfParser.string_value_return string_value160 = null;

        polaEbnfParser.boolean_value_return boolean_value161 = null;


        CommonTree VAL_INTEGER154_tree=null;
        CommonTree VAL_OCT155_tree=null;
        CommonTree VAL_HEX156_tree=null;
        CommonTree VAL_BINARY157_tree=null;
        CommonTree VAL_FLOAT158_tree=null;
        CommonTree VAL_CHAR159_tree=null;
        RewriteRuleTokenStream stream_VAL_BINARY=new RewriteRuleTokenStream(adaptor,"token VAL_BINARY");
        RewriteRuleTokenStream stream_VAL_INTEGER=new RewriteRuleTokenStream(adaptor,"token VAL_INTEGER");
        RewriteRuleTokenStream stream_VAL_CHAR=new RewriteRuleTokenStream(adaptor,"token VAL_CHAR");
        RewriteRuleTokenStream stream_VAL_OCT=new RewriteRuleTokenStream(adaptor,"token VAL_OCT");
        RewriteRuleTokenStream stream_VAL_FLOAT=new RewriteRuleTokenStream(adaptor,"token VAL_FLOAT");
        RewriteRuleTokenStream stream_VAL_HEX=new RewriteRuleTokenStream(adaptor,"token VAL_HEX");
        RewriteRuleSubtreeStream stream_string_value=new RewriteRuleSubtreeStream(adaptor,"rule string_value");
        RewriteRuleSubtreeStream stream_boolean_value=new RewriteRuleSubtreeStream(adaptor,"rule boolean_value");
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:209:25: ( VAL_INTEGER -> ^( AT_PROVIDES INTEGER VAL_INTEGER ) | VAL_OCT -> ^( AT_PROVIDES OCTET VAL_OCT ) | VAL_HEX -> ^( AT_PROVIDES HEX VAL_HEX ) | VAL_BINARY -> ^( AT_PROVIDES BINARY VAL_BINARY ) | VAL_FLOAT -> ^( AT_PROVIDES FLOAT VAL_FLOAT ) | VAL_CHAR -> ^( AT_PROVIDES CHAR VAL_CHAR ) | string_value -> ^( AT_PROVIDES STRING string_value ) | boolean_value -> ^( AT_PROVIDES BOOLEAN boolean_value ) )
            int alt37=8;
            switch ( input.LA(1) ) {
            case VAL_INTEGER:
                {
                alt37=1;
                }
                break;
            case VAL_OCT:
                {
                alt37=2;
                }
                break;
            case VAL_HEX:
                {
                alt37=3;
                }
                break;
            case VAL_BINARY:
                {
                alt37=4;
                }
                break;
            case VAL_FLOAT:
                {
                alt37=5;
                }
                break;
            case VAL_CHAR:
                {
                alt37=6;
                }
                break;
            case VAL_STRING:
            case POLA_NULL:
                {
                alt37=7;
                }
                break;
            case POLA_TRUE:
            case POLA_FALSE:
                {
                alt37=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:209:27: VAL_INTEGER
                    {
                    VAL_INTEGER154=(Token)match(input,VAL_INTEGER,FOLLOW_VAL_INTEGER_in_const_value1899);  
                    stream_VAL_INTEGER.add(VAL_INTEGER154);



                    // AST REWRITE
                    // elements: VAL_INTEGER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 209:41: -> ^( AT_PROVIDES INTEGER VAL_INTEGER )
                    {
                        // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:209:44: ^( AT_PROVIDES INTEGER VAL_INTEGER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_PROVIDES, "AT_PROVIDES"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(INTEGER, "INTEGER"));
                        adaptor.addChild(root_1, stream_VAL_INTEGER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:210:27: VAL_OCT
                    {
                    VAL_OCT155=(Token)match(input,VAL_OCT,FOLLOW_VAL_OCT_in_const_value1940);  
                    stream_VAL_OCT.add(VAL_OCT155);



                    // AST REWRITE
                    // elements: VAL_OCT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 210:41: -> ^( AT_PROVIDES OCTET VAL_OCT )
                    {
                        // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:210:44: ^( AT_PROVIDES OCTET VAL_OCT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_PROVIDES, "AT_PROVIDES"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(OCTET, "OCTET"));
                        adaptor.addChild(root_1, stream_VAL_OCT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:211:27: VAL_HEX
                    {
                    VAL_HEX156=(Token)match(input,VAL_HEX,FOLLOW_VAL_HEX_in_const_value1985);  
                    stream_VAL_HEX.add(VAL_HEX156);



                    // AST REWRITE
                    // elements: VAL_HEX
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 211:41: -> ^( AT_PROVIDES HEX VAL_HEX )
                    {
                        // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:211:44: ^( AT_PROVIDES HEX VAL_HEX )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_PROVIDES, "AT_PROVIDES"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(HEX, "HEX"));
                        adaptor.addChild(root_1, stream_VAL_HEX.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:212:27: VAL_BINARY
                    {
                    VAL_BINARY157=(Token)match(input,VAL_BINARY,FOLLOW_VAL_BINARY_in_const_value2030);  
                    stream_VAL_BINARY.add(VAL_BINARY157);



                    // AST REWRITE
                    // elements: VAL_BINARY
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 212:41: -> ^( AT_PROVIDES BINARY VAL_BINARY )
                    {
                        // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:212:44: ^( AT_PROVIDES BINARY VAL_BINARY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_PROVIDES, "AT_PROVIDES"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(BINARY, "BINARY"));
                        adaptor.addChild(root_1, stream_VAL_BINARY.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:213:27: VAL_FLOAT
                    {
                    VAL_FLOAT158=(Token)match(input,VAL_FLOAT,FOLLOW_VAL_FLOAT_in_const_value2072);  
                    stream_VAL_FLOAT.add(VAL_FLOAT158);



                    // AST REWRITE
                    // elements: VAL_FLOAT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 213:41: -> ^( AT_PROVIDES FLOAT VAL_FLOAT )
                    {
                        // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:213:44: ^( AT_PROVIDES FLOAT VAL_FLOAT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_PROVIDES, "AT_PROVIDES"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(FLOAT, "FLOAT"));
                        adaptor.addChild(root_1, stream_VAL_FLOAT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:214:27: VAL_CHAR
                    {
                    VAL_CHAR159=(Token)match(input,VAL_CHAR,FOLLOW_VAL_CHAR_in_const_value2115);  
                    stream_VAL_CHAR.add(VAL_CHAR159);



                    // AST REWRITE
                    // elements: VAL_CHAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 214:41: -> ^( AT_PROVIDES CHAR VAL_CHAR )
                    {
                        // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:214:44: ^( AT_PROVIDES CHAR VAL_CHAR )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_PROVIDES, "AT_PROVIDES"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(CHAR, "CHAR"));
                        adaptor.addChild(root_1, stream_VAL_CHAR.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:215:27: string_value
                    {
                    pushFollow(FOLLOW_string_value_in_const_value2159);
                    string_value160=string_value();

                    state._fsp--;

                    stream_string_value.add(string_value160.getTree());


                    // AST REWRITE
                    // elements: string_value
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 215:41: -> ^( AT_PROVIDES STRING string_value )
                    {
                        // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:215:44: ^( AT_PROVIDES STRING string_value )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_PROVIDES, "AT_PROVIDES"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(STRING, "STRING"));
                        adaptor.addChild(root_1, stream_string_value.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:216:27: boolean_value
                    {
                    pushFollow(FOLLOW_boolean_value_in_const_value2199);
                    boolean_value161=boolean_value();

                    state._fsp--;

                    stream_boolean_value.add(boolean_value161.getTree());


                    // AST REWRITE
                    // elements: boolean_value
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 216:41: -> ^( AT_PROVIDES BOOLEAN boolean_value )
                    {
                        // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:216:44: ^( AT_PROVIDES BOOLEAN boolean_value )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_PROVIDES, "AT_PROVIDES"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(BOOLEAN, "BOOLEAN"));
                        adaptor.addChild(root_1, stream_boolean_value.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

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
    // $ANTLR end "const_value"

    public static class string_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "string_value"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:217:1: string_value : ( VAL_STRING | POLA_NULL );
    public final polaEbnfParser.string_value_return string_value() throws RecognitionException {
        polaEbnfParser.string_value_return retval = new polaEbnfParser.string_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set162=null;

        CommonTree set162_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:217:25: ( VAL_STRING | POLA_NULL )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set162=(Token)input.LT(1);
            if ( (input.LA(1)>=VAL_STRING && input.LA(1)<=POLA_NULL) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set162));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "string_value"

    public static class boolean_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "boolean_value"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:218:1: boolean_value : ( POLA_TRUE | POLA_FALSE );
    public final polaEbnfParser.boolean_value_return boolean_value() throws RecognitionException {
        polaEbnfParser.boolean_value_return retval = new polaEbnfParser.boolean_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set163=null;

        CommonTree set163_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:218:25: ( POLA_TRUE | POLA_FALSE )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set163=(Token)input.LT(1);
            if ( (input.LA(1)>=POLA_TRUE && input.LA(1)<=POLA_FALSE) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set163));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "boolean_value"

    // Delegated rules


 

    public static final BitSet FOLLOW_set_in_a3dsStage0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_a3dsEnvironment0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_a3dsCLevel0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cpp_directive_in_polaSpecification226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_AT_STAGE_in_polaSpecification228 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003F00L});
    public static final BitSet FOLLOW_a3dsStage_in_polaSpecification230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_polaSpecification232 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_AT_ENVIRONMENT_in_polaSpecification234 = new BitSet(new long[]{0x0000000000000000L,0x000000000001C000L});
    public static final BitSet FOLLOW_a3dsEnvironment_in_polaSpecification236 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_polaSpecification238 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_AT_CLEVEL_in_polaSpecification240 = new BitSet(new long[]{0x0000000000000000L,0x00000000000E0000L});
    public static final BitSet FOLLOW_a3dsCLevel_in_polaSpecification242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_polaSpecification244 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_AT_LANGUAGE_in_polaSpecification246 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_polaSpecification250 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_polaSpecification252 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_AT_SPEC_in_polaSpecification254 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_polaSpecification258 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_polaSpecification260 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_polaDefinition_in_polaSpecification264 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_EOF_in_polaSpecification267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cpp_directive_in_polaDefinition366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_managementPolicy_in_polaDefinition370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CPP_DIRECTIVE_in_cpp_directive390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_POLICY_in_managementPolicy415 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_managementPolicyType_in_managementPolicy417 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_managementPolicy421 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_managementPolicy477 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_policyRuleStructure_in_managementPolicy479 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_managementPolicy481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deonticPolicy_in_managementPolicyType529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_managementMetaPolicy_in_managementPolicyType533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_deonticPolicy0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_managementMetaPolicy0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyContinuumLevel_in_policyRuleStructure592 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_ecaPolicyRule_in_policyRuleStructure596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalPolicyRule_in_policyRuleStructure600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_utilityFunctionPolicyRule_in_policyRuleStructure604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_PC_LEVEL_in_policyContinuumLevel615 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_policyContinuumLevel617 = new BitSet(new long[]{0x0000000000000000L,0x0000000003060000L});
    public static final BitSet FOLLOW_81_in_policyContinuumLevel620 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_82_in_policyContinuumLevel624 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_88_in_policyContinuumLevel628 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_89_in_policyContinuumLevel632 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_policyContinuumLevel634 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_policyContinuumLevel637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_RULE_STRUCT_ECA_in_ecaPolicyRule656 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_ecaPolicyRule658 = new BitSet(new long[]{0x0000000018400000L});
    public static final BitSet FOLLOW_ecaPolicyRuleBody_in_ecaPolicyRule660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventStructure_in_ecaPolicyRuleBody709 = new BitSet(new long[]{0x0000000018400002L});
    public static final BitSet FOLLOW_policyConditionStructure_in_ecaPolicyRuleBody712 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_policyActionStructure_in_ecaPolicyRuleBody715 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_POLA_RULE_STRUCT_GOAL_in_goalPolicyRule733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_RULE_STRUCT_UTIL_in_utilityFunctionPolicyRule740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventStructure_in_policyRuleComponentStructure750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionStructure_in_policyRuleComponentStructure754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionStructure_in_policyRuleComponentStructure758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_EVENT_in_policyEventStructure769 = new BitSet(new long[]{0x0000000007800002L,0x0000000000100000L});
    public static final BitSet FOLLOW_policyEventStructureBody_in_policyEventStructure771 = new BitSet(new long[]{0x0000000007800002L,0x0000000000100000L});
    public static final BitSet FOLLOW_policyEventGroup_in_policyEventStructureBody778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEvent_in_policyEventStructureBody782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_GROUP_in_policyEventGroup796 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_policyEventGroup798 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_policyEventGroup800 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_policyEventGroupBody_in_policyEventGroup802 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_86_in_policyEventGroup805 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_policyEventGroup807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventGroup_in_policyEventGroupBody854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEvent_in_policyEventGroupBody858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventBody_in_policyEvent877 = new BitSet(new long[]{0x0000000007000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_policyEvent880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventComposite_in_policyEventBody904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventAtomic_in_policyEventBody908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventNonStd_in_policyEventBody912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_COMPOSITE_in_policyEventComposite922 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyEventComposite924 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_policyEventComposite926 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_policyEvent_in_policyEventComposite928 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_86_in_policyEventComposite931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_ATOMIC_in_policyEventAtomic981 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyEventAtomic983 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyEventAtomic985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_NONSTD_in_policyEventNonStd998 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyEventNonStd1000 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyEventNonStd1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_CONDITION_in_policyConditionStructure1013 = new BitSet(new long[]{0x0000000007800002L,0x0000000000100000L});
    public static final BitSet FOLLOW_policyConditionStructureBody_in_policyConditionStructure1015 = new BitSet(new long[]{0x0000000007800002L,0x0000000000100000L});
    public static final BitSet FOLLOW_policyConditionGroup_in_policyConditionStructureBody1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyCondition_in_policyConditionStructureBody1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_GROUP_in_policyConditionGroup1040 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_policyConditionGroup1042 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_policyConditionGroup1044 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_policyConditionGroupBody_in_policyConditionGroup1046 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_86_in_policyConditionGroup1049 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_policyConditionGroup1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionGroup_in_policyConditionGroupBody1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyCondition_in_policyConditionGroupBody1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionBody_in_policyCondition1125 = new BitSet(new long[]{0x0000000007000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_policyCondition1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionComposite_in_policyConditionBody1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionAtomic_in_policyConditionBody1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionNonStd_in_policyConditionBody1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_COMPOSITE_in_policyConditionComposite1170 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyConditionComposite1172 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_policyConditionComposite1174 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_policyCondition_in_policyConditionComposite1176 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_86_in_policyConditionComposite1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_ATOMIC_in_policyConditionAtomic1229 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyConditionAtomic1231 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyConditionAtomic1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_NONSTD_in_policyConditionNonStd1246 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyConditionNonStd1248 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyConditionNonStd1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_ACTION_in_policyActionStructure1261 = new BitSet(new long[]{0x0000000007800002L,0x0000000000100000L});
    public static final BitSet FOLLOW_policyActionStructureBody_in_policyActionStructure1263 = new BitSet(new long[]{0x0000000007800002L,0x0000000000100000L});
    public static final BitSet FOLLOW_policyActionGroup_in_policyActionStructureBody1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyAction_in_policyActionStructureBody1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_GROUP_in_policyActionGroup1288 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_policyActionGroup1290 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_policyActionGroup1292 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_policyActionGroupBody_in_policyActionGroup1294 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_86_in_policyActionGroup1297 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_policyActionGroup1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionGroup_in_policyActionGroupBody1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyAction_in_policyActionGroupBody1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionBody_in_policyAction1373 = new BitSet(new long[]{0x0000000007000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_policyAction1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionComposite_in_policyActionBody1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionAtomic_in_policyActionBody1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionNonStd_in_policyActionBody1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_COMPOSITE_in_policyActionComposite1418 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyActionComposite1420 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_policyActionComposite1422 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_policyAction_in_policyActionComposite1424 = new BitSet(new long[]{0x0000000007800000L,0x0000000000500000L});
    public static final BitSet FOLLOW_86_in_policyActionComposite1427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_ATOMIC_in_policyActionAtomic1477 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyActionAtomic1479 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyActionAtomic1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_NONSTD_in_policyActionNonStd1494 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyActionNonStd1496 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyActionNonStd1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_policyECAInherited1509 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_POLA_SEQ_NUMER_in_policyECAInherited1511 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_policyECAInherited1513 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_VAL_INTEGER_in_policyECAInherited1515 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_POLA_HASBEEN_EVALED_in_policyECAInherited1517 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_policyECAInherited1519 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_boolean_value_in_policyECAInherited1521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_DSTRING_in_pola_string1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name1603 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_scoped_name1606 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name1610 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_scoped_name1614 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_void_type1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_name_in_simple_type1671 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_base_type_in_simple_type1675 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_array_in_simple_type1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHORT_in_base_type1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_base_type1736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_base_type1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTET_in_base_type1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_in_base_type1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINARY_in_base_type1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_base_type1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_base_type1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_base_type1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_base_type1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_base_type1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_array1871 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_array1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_INTEGER_in_const_value1899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_OCT_in_const_value1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_HEX_in_const_value1985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_BINARY_in_const_value2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_FLOAT_in_const_value2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_CHAR_in_const_value2115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_value_in_const_value2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_value_in_const_value2199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_string_value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_boolean_value0 = new BitSet(new long[]{0x0000000000000002L});

}