// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g 2011-07-07 22:24:52

  package org.skb.lang.pola.proto.grammars;

  import org.skb.util.languages.AtomList;
  import org.skb.lang.pola.proto.PolaPass2_Ast;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.pola.proto.PolaTokensConstants;
  import org.skb.util.ReportManager;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class polaAst extends TreeParser {
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


        public polaAst(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public polaAst(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return polaAst.tokenNames; }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g"; }


      private LanguageTokens myTokens;
      private AtomList atoms;
      private PolaPass2_Ast pass;

      public void init() {
        this.atoms=AtomList.getInstance();
        this.pass=new PolaPass2_Ast();
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


    public static class a3dsStage_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "a3dsStage"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:88:1: a3dsStage : ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' );
    public final polaAst.a3dsStage_return a3dsStage() throws RecognitionException {
        polaAst.a3dsStage_return retval = new polaAst.a3dsStage_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set1=null;

        CommonTree set1_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:88:25: ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set1=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=72 && input.LA(1)<=77) ) {
                input.consume();

                set1_tree = (CommonTree)adaptor.dupNode(set1);

                adaptor.addChild(root_0, set1_tree);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "a3dsStage"

    public static class a3dsEnvironment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "a3dsEnvironment"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:89:1: a3dsEnvironment : ( 'production' | 'test' | 'demonstrator' );
    public final polaAst.a3dsEnvironment_return a3dsEnvironment() throws RecognitionException {
        polaAst.a3dsEnvironment_return retval = new polaAst.a3dsEnvironment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set2=null;

        CommonTree set2_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:89:25: ( 'production' | 'test' | 'demonstrator' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set2=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=78 && input.LA(1)<=80) ) {
                input.consume();

                set2_tree = (CommonTree)adaptor.dupNode(set2);

                adaptor.addChild(root_0, set2_tree);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "a3dsEnvironment"

    public static class a3dsCLevel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "a3dsCLevel"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:90:1: a3dsCLevel : ( 'business' | 'system' | 'element' );
    public final polaAst.a3dsCLevel_return a3dsCLevel() throws RecognitionException {
        polaAst.a3dsCLevel_return retval = new polaAst.a3dsCLevel_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set3=null;

        CommonTree set3_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:90:25: ( 'business' | 'system' | 'element' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set3=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=81 && input.LA(1)<=83) ) {
                input.consume();

                set3_tree = (CommonTree)adaptor.dupNode(set3);

                adaptor.addChild(root_0, set3_tree);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "a3dsCLevel"

    public static class polaSpecification_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "polaSpecification"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:92:1: polaSpecification : ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE IDENT ) ^( AT_SPEC IDENT ) cpp_directive ( polaDefinition )* ) ;
    public final polaAst.polaSpecification_return polaSpecification() throws RecognitionException {
        polaAst.polaSpecification_return retval = new polaAst.polaSpecification_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_SPEC4=null;
        CommonTree AT_LANGUAGE8=null;
        CommonTree IDENT9=null;
        CommonTree AT_SPEC10=null;
        CommonTree IDENT11=null;
        polaAst.a3dsStage_return a3dsStage5 = null;

        polaAst.a3dsEnvironment_return a3dsEnvironment6 = null;

        polaAst.a3dsCLevel_return a3dsCLevel7 = null;

        polaAst.cpp_directive_return cpp_directive12 = null;

        polaAst.polaDefinition_return polaDefinition13 = null;


        CommonTree AT_SPEC4_tree=null;
        CommonTree AT_LANGUAGE8_tree=null;
        CommonTree IDENT9_tree=null;
        CommonTree AT_SPEC10_tree=null;
        CommonTree IDENT11_tree=null;

        this.init();
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:93:25: ( ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE IDENT ) ^( AT_SPEC IDENT ) cpp_directive ( polaDefinition )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:93:27: ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE IDENT ) ^( AT_SPEC IDENT ) cpp_directive ( polaDefinition )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_SPEC4=(CommonTree)match(input,AT_SPEC,FOLLOW_AT_SPEC_in_polaSpecification184); 
            AT_SPEC4_tree = (CommonTree)adaptor.dupNode(AT_SPEC4);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_SPEC4_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_a3dsStage_in_polaSpecification186);
            a3dsStage5=a3dsStage();

            state._fsp--;

            adaptor.addChild(root_1, a3dsStage5.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_a3dsEnvironment_in_polaSpecification188);
            a3dsEnvironment6=a3dsEnvironment();

            state._fsp--;

            adaptor.addChild(root_1, a3dsEnvironment6.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_a3dsCLevel_in_polaSpecification190);
            a3dsCLevel7=a3dsCLevel();

            state._fsp--;

            adaptor.addChild(root_1, a3dsCLevel7.getTree());
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_LANGUAGE8=(CommonTree)match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_polaSpecification193); 
            AT_LANGUAGE8_tree = (CommonTree)adaptor.dupNode(AT_LANGUAGE8);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_LANGUAGE8_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_polaSpecification195); 
            IDENT9_tree = (CommonTree)adaptor.dupNode(IDENT9);

            adaptor.addChild(root_2, IDENT9_tree);


            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_SPEC10=(CommonTree)match(input,AT_SPEC,FOLLOW_AT_SPEC_in_polaSpecification199); 
            AT_SPEC10_tree = (CommonTree)adaptor.dupNode(AT_SPEC10);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_SPEC10_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT11=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_polaSpecification201); 
            IDENT11_tree = (CommonTree)adaptor.dupNode(IDENT11);

            adaptor.addChild(root_2, IDENT11_tree);


            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cpp_directive_in_polaSpecification204);
            cpp_directive12=cpp_directive();

            state._fsp--;

            adaptor.addChild(root_1, cpp_directive12.getTree());
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:93:126: ( polaDefinition )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=CPP_DIRECTIVE && LA1_0<=POLA_POLICY)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:93:126: polaDefinition
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_polaDefinition_in_polaSpecification206);
            	    polaDefinition13=polaDefinition();

            	    state._fsp--;

            	    adaptor.addChild(root_1, polaDefinition13.getTree());

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
    // $ANTLR end "polaSpecification"

    public static class polaDefinition_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "polaDefinition"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:94:1: polaDefinition : ( managementPolicy | cpp_directive );
    public final polaAst.polaDefinition_return polaDefinition() throws RecognitionException {
        polaAst.polaDefinition_return retval = new polaAst.polaDefinition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.managementPolicy_return managementPolicy14 = null;

        polaAst.cpp_directive_return cpp_directive15 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:94:25: ( managementPolicy | cpp_directive )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==POLA_POLICY) ) {
                alt2=1;
            }
            else if ( (LA2_0==CPP_DIRECTIVE) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:94:27: managementPolicy
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_managementPolicy_in_polaDefinition224);
                    managementPolicy14=managementPolicy();

                    state._fsp--;

                    adaptor.addChild(root_0, managementPolicy14.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:94:46: cpp_directive
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cpp_directive_in_polaDefinition228);
                    cpp_directive15=cpp_directive();

                    state._fsp--;

                    adaptor.addChild(root_0, cpp_directive15.getTree());

                    }
                    break;

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
    // $ANTLR end "polaDefinition"

    public static class cpp_directive_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cpp_directive"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:96:1: cpp_directive : s= CPP_DIRECTIVE ;
    public final polaAst.cpp_directive_return cpp_directive() throws RecognitionException {
        polaAst.cpp_directive_return retval = new polaAst.cpp_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:96:25: (s= CPP_DIRECTIVE )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:96:27: s= CPP_DIRECTIVE
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,CPP_DIRECTIVE,FOLLOW_CPP_DIRECTIVE_in_cpp_directive248); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_0, s_tree);

            setCppFile(s.getText());

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
    // $ANTLR end "cpp_directive"

    public static class managementPolicy_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "managementPolicy"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:98:1: managementPolicy : ^( POLA_POLICY IDENT managementPolicyType policyRuleStructure ) ;
    public final polaAst.managementPolicy_return managementPolicy() throws RecognitionException {
        polaAst.managementPolicy_return retval = new polaAst.managementPolicy_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_POLICY16=null;
        CommonTree IDENT17=null;
        polaAst.managementPolicyType_return managementPolicyType18 = null;

        polaAst.policyRuleStructure_return policyRuleStructure19 = null;


        CommonTree POLA_POLICY16_tree=null;
        CommonTree IDENT17_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:98:25: ( ^( POLA_POLICY IDENT managementPolicyType policyRuleStructure ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:98:27: ^( POLA_POLICY IDENT managementPolicyType policyRuleStructure )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            POLA_POLICY16=(CommonTree)match(input,POLA_POLICY,FOLLOW_POLA_POLICY_in_managementPolicy266); 
            POLA_POLICY16_tree = (CommonTree)adaptor.dupNode(POLA_POLICY16);

            root_1 = (CommonTree)adaptor.becomeRoot(POLA_POLICY16_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT17=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_managementPolicy268); 
            IDENT17_tree = (CommonTree)adaptor.dupNode(IDENT17);

            adaptor.addChild(root_1, IDENT17_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_managementPolicyType_in_managementPolicy270);
            managementPolicyType18=managementPolicyType();

            state._fsp--;

            adaptor.addChild(root_1, managementPolicyType18.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_policyRuleStructure_in_managementPolicy272);
            policyRuleStructure19=policyRuleStructure();

            state._fsp--;

            adaptor.addChild(root_1, policyRuleStructure19.getTree());

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
    // $ANTLR end "managementPolicy"

    public static class managementPolicyType_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "managementPolicyType"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:99:1: managementPolicyType : ( deonticPolicy | managementMetaPolicy );
    public final polaAst.managementPolicyType_return managementPolicyType() throws RecognitionException {
        polaAst.managementPolicyType_return retval = new polaAst.managementPolicyType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.deonticPolicy_return deonticPolicy20 = null;

        polaAst.managementMetaPolicy_return managementMetaPolicy21 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:99:25: ( deonticPolicy | managementMetaPolicy )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:99:27: deonticPolicy
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_deonticPolicy_in_managementPolicyType283);
                    deonticPolicy20=deonticPolicy();

                    state._fsp--;

                    adaptor.addChild(root_0, deonticPolicy20.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:99:43: managementMetaPolicy
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_managementMetaPolicy_in_managementPolicyType287);
                    managementMetaPolicy21=managementMetaPolicy();

                    state._fsp--;

                    adaptor.addChild(root_0, managementMetaPolicy21.getTree());

                    }
                    break;

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
    // $ANTLR end "managementPolicyType"

    public static class deonticPolicy_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deonticPolicy"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:100:1: deonticPolicy : ( POLA_DEONT_AUTH | POLA_DEONT_EXEM | POLA_DEONT_OBLG | POLA_DEONT_PROH );
    public final polaAst.deonticPolicy_return deonticPolicy() throws RecognitionException {
        polaAst.deonticPolicy_return retval = new polaAst.deonticPolicy_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set22=null;

        CommonTree set22_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:100:25: ( POLA_DEONT_AUTH | POLA_DEONT_EXEM | POLA_DEONT_OBLG | POLA_DEONT_PROH )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set22=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=POLA_DEONT_AUTH && input.LA(1)<=POLA_DEONT_PROH) ) {
                input.consume();

                set22_tree = (CommonTree)adaptor.dupNode(set22);

                adaptor.addChild(root_0, set22_tree);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "deonticPolicy"

    public static class managementMetaPolicy_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "managementMetaPolicy"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:101:1: managementMetaPolicy : ( POLA_MEPO_DELE | POLA_MEPO_REVO );
    public final polaAst.managementMetaPolicy_return managementMetaPolicy() throws RecognitionException {
        polaAst.managementMetaPolicy_return retval = new polaAst.managementMetaPolicy_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set23=null;

        CommonTree set23_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:101:25: ( POLA_MEPO_DELE | POLA_MEPO_REVO )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set23=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=POLA_MEPO_DELE && input.LA(1)<=POLA_MEPO_REVO) ) {
                input.consume();

                set23_tree = (CommonTree)adaptor.dupNode(set23);

                adaptor.addChild(root_0, set23_tree);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "managementMetaPolicy"

    public static class policyRuleStructure_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyRuleStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:105:1: policyRuleStructure : ( ( policyContinuumLevel )? ecaPolicyRule | goalPolicyRule | utilityFunctionPolicyRule );
    public final polaAst.policyRuleStructure_return policyRuleStructure() throws RecognitionException {
        polaAst.policyRuleStructure_return retval = new polaAst.policyRuleStructure_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyContinuumLevel_return policyContinuumLevel24 = null;

        polaAst.ecaPolicyRule_return ecaPolicyRule25 = null;

        polaAst.goalPolicyRule_return goalPolicyRule26 = null;

        polaAst.utilityFunctionPolicyRule_return utilityFunctionPolicyRule27 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:105:26: ( ( policyContinuumLevel )? ecaPolicyRule | goalPolicyRule | utilityFunctionPolicyRule )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:105:28: ( policyContinuumLevel )? ecaPolicyRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:105:28: ( policyContinuumLevel )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==POLA_PC_LEVEL) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:105:29: policyContinuumLevel
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_policyContinuumLevel_in_policyRuleStructure346);
                            policyContinuumLevel24=policyContinuumLevel();

                            state._fsp--;

                            adaptor.addChild(root_0, policyContinuumLevel24.getTree());

                            }
                            break;

                    }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ecaPolicyRule_in_policyRuleStructure350);
                    ecaPolicyRule25=ecaPolicyRule();

                    state._fsp--;

                    adaptor.addChild(root_0, ecaPolicyRule25.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:105:68: goalPolicyRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_goalPolicyRule_in_policyRuleStructure354);
                    goalPolicyRule26=goalPolicyRule();

                    state._fsp--;

                    adaptor.addChild(root_0, goalPolicyRule26.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:105:85: utilityFunctionPolicyRule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_utilityFunctionPolicyRule_in_policyRuleStructure358);
                    utilityFunctionPolicyRule27=utilityFunctionPolicyRule();

                    state._fsp--;

                    adaptor.addChild(root_0, utilityFunctionPolicyRule27.getTree());

                    }
                    break;

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
    // $ANTLR end "policyRuleStructure"

    public static class policyContinuumLevel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyContinuumLevel"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:106:1: policyContinuumLevel : POLA_PC_LEVEL '=' ( 'business' | 'system' | 'administration' | 'device' 'instance' ) ';' ;
    public final polaAst.policyContinuumLevel_return policyContinuumLevel() throws RecognitionException {
        polaAst.policyContinuumLevel_return retval = new polaAst.policyContinuumLevel_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_PC_LEVEL28=null;
        CommonTree char_literal29=null;
        CommonTree string_literal30=null;
        CommonTree string_literal31=null;
        CommonTree string_literal32=null;
        CommonTree string_literal33=null;
        CommonTree string_literal34=null;
        CommonTree char_literal35=null;

        CommonTree POLA_PC_LEVEL28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree string_literal30_tree=null;
        CommonTree string_literal31_tree=null;
        CommonTree string_literal32_tree=null;
        CommonTree string_literal33_tree=null;
        CommonTree string_literal34_tree=null;
        CommonTree char_literal35_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:106:26: ( POLA_PC_LEVEL '=' ( 'business' | 'system' | 'administration' | 'device' 'instance' ) ';' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:106:28: POLA_PC_LEVEL '=' ( 'business' | 'system' | 'administration' | 'device' 'instance' ) ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_PC_LEVEL28=(CommonTree)match(input,POLA_PC_LEVEL,FOLLOW_POLA_PC_LEVEL_in_policyContinuumLevel369); 
            POLA_PC_LEVEL28_tree = (CommonTree)adaptor.dupNode(POLA_PC_LEVEL28);

            adaptor.addChild(root_0, POLA_PC_LEVEL28_tree);

            _last = (CommonTree)input.LT(1);
            char_literal29=(CommonTree)match(input,87,FOLLOW_87_in_policyContinuumLevel371); 
            char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);

            adaptor.addChild(root_0, char_literal29_tree);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:106:46: ( 'business' | 'system' | 'administration' | 'device' 'instance' )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:106:47: 'business'
                    {
                    _last = (CommonTree)input.LT(1);
                    string_literal30=(CommonTree)match(input,81,FOLLOW_81_in_policyContinuumLevel374); 
                    string_literal30_tree = (CommonTree)adaptor.dupNode(string_literal30);

                    adaptor.addChild(root_0, string_literal30_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:106:60: 'system'
                    {
                    _last = (CommonTree)input.LT(1);
                    string_literal31=(CommonTree)match(input,82,FOLLOW_82_in_policyContinuumLevel378); 
                    string_literal31_tree = (CommonTree)adaptor.dupNode(string_literal31);

                    adaptor.addChild(root_0, string_literal31_tree);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:106:71: 'administration'
                    {
                    _last = (CommonTree)input.LT(1);
                    string_literal32=(CommonTree)match(input,88,FOLLOW_88_in_policyContinuumLevel382); 
                    string_literal32_tree = (CommonTree)adaptor.dupNode(string_literal32);

                    adaptor.addChild(root_0, string_literal32_tree);


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:106:90: 'device' 'instance'
                    {
                    _last = (CommonTree)input.LT(1);
                    string_literal33=(CommonTree)match(input,89,FOLLOW_89_in_policyContinuumLevel386); 
                    string_literal33_tree = (CommonTree)adaptor.dupNode(string_literal33);

                    adaptor.addChild(root_0, string_literal33_tree);

                    _last = (CommonTree)input.LT(1);
                    string_literal34=(CommonTree)match(input,90,FOLLOW_90_in_policyContinuumLevel388); 
                    string_literal34_tree = (CommonTree)adaptor.dupNode(string_literal34);

                    adaptor.addChild(root_0, string_literal34_tree);


                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            char_literal35=(CommonTree)match(input,84,FOLLOW_84_in_policyContinuumLevel391); 
            char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

            adaptor.addChild(root_0, char_literal35_tree);


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
    // $ANTLR end "policyContinuumLevel"

    public static class ecaPolicyRule_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecaPolicyRule"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:108:1: ecaPolicyRule : ^( POLA_RULE_STRUCT_ECA ecaPolicyRuleBody ) ;
    public final polaAst.ecaPolicyRule_return ecaPolicyRule() throws RecognitionException {
        polaAst.ecaPolicyRule_return retval = new polaAst.ecaPolicyRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_RULE_STRUCT_ECA36=null;
        polaAst.ecaPolicyRuleBody_return ecaPolicyRuleBody37 = null;


        CommonTree POLA_RULE_STRUCT_ECA36_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:108:26: ( ^( POLA_RULE_STRUCT_ECA ecaPolicyRuleBody ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:108:28: ^( POLA_RULE_STRUCT_ECA ecaPolicyRuleBody )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            POLA_RULE_STRUCT_ECA36=(CommonTree)match(input,POLA_RULE_STRUCT_ECA,FOLLOW_POLA_RULE_STRUCT_ECA_in_ecaPolicyRule411); 
            POLA_RULE_STRUCT_ECA36_tree = (CommonTree)adaptor.dupNode(POLA_RULE_STRUCT_ECA36);

            root_1 = (CommonTree)adaptor.becomeRoot(POLA_RULE_STRUCT_ECA36_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                _last = (CommonTree)input.LT(1);
                pushFollow(FOLLOW_ecaPolicyRuleBody_in_ecaPolicyRule413);
                ecaPolicyRuleBody37=ecaPolicyRuleBody();

                state._fsp--;

                adaptor.addChild(root_1, ecaPolicyRuleBody37.getTree());

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
    // $ANTLR end "ecaPolicyRule"

    public static class ecaPolicyRuleBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecaPolicyRuleBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:109:1: ecaPolicyRuleBody : ( policyEventStructure )* ( policyConditionStructure )* ( policyActionStructure )* ;
    public final polaAst.ecaPolicyRuleBody_return ecaPolicyRuleBody() throws RecognitionException {
        polaAst.ecaPolicyRuleBody_return retval = new polaAst.ecaPolicyRuleBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyEventStructure_return policyEventStructure38 = null;

        polaAst.policyConditionStructure_return policyConditionStructure39 = null;

        polaAst.policyActionStructure_return policyActionStructure40 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:109:26: ( ( policyEventStructure )* ( policyConditionStructure )* ( policyActionStructure )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:109:28: ( policyEventStructure )* ( policyConditionStructure )* ( policyActionStructure )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:109:28: ( policyEventStructure )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==POLA_EVENT) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:109:28: policyEventStructure
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyEventStructure_in_ecaPolicyRuleBody428);
            	    policyEventStructure38=policyEventStructure();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyEventStructure38.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:109:50: ( policyConditionStructure )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==POLA_CONDITION) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:109:50: policyConditionStructure
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyConditionStructure_in_ecaPolicyRuleBody431);
            	    policyConditionStructure39=policyConditionStructure();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyConditionStructure39.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:109:76: ( policyActionStructure )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==POLA_ACTION) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:109:76: policyActionStructure
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyActionStructure_in_ecaPolicyRuleBody434);
            	    policyActionStructure40=policyActionStructure();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyActionStructure40.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


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
    // $ANTLR end "ecaPolicyRuleBody"

    public static class goalPolicyRule_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "goalPolicyRule"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:110:1: goalPolicyRule : POLA_RULE_STRUCT_GOAL ;
    public final polaAst.goalPolicyRule_return goalPolicyRule() throws RecognitionException {
        polaAst.goalPolicyRule_return retval = new polaAst.goalPolicyRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_RULE_STRUCT_GOAL41=null;

        CommonTree POLA_RULE_STRUCT_GOAL41_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:110:26: ( POLA_RULE_STRUCT_GOAL )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:110:28: POLA_RULE_STRUCT_GOAL
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_RULE_STRUCT_GOAL41=(CommonTree)match(input,POLA_RULE_STRUCT_GOAL,FOLLOW_POLA_RULE_STRUCT_GOAL_in_goalPolicyRule452); 
            POLA_RULE_STRUCT_GOAL41_tree = (CommonTree)adaptor.dupNode(POLA_RULE_STRUCT_GOAL41);

            adaptor.addChild(root_0, POLA_RULE_STRUCT_GOAL41_tree);


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
    // $ANTLR end "goalPolicyRule"

    public static class utilityFunctionPolicyRule_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "utilityFunctionPolicyRule"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:111:1: utilityFunctionPolicyRule : POLA_RULE_STRUCT_UTIL ;
    public final polaAst.utilityFunctionPolicyRule_return utilityFunctionPolicyRule() throws RecognitionException {
        polaAst.utilityFunctionPolicyRule_return retval = new polaAst.utilityFunctionPolicyRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_RULE_STRUCT_UTIL42=null;

        CommonTree POLA_RULE_STRUCT_UTIL42_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:111:26: ( POLA_RULE_STRUCT_UTIL )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:111:28: POLA_RULE_STRUCT_UTIL
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_RULE_STRUCT_UTIL42=(CommonTree)match(input,POLA_RULE_STRUCT_UTIL,FOLLOW_POLA_RULE_STRUCT_UTIL_in_utilityFunctionPolicyRule459); 
            POLA_RULE_STRUCT_UTIL42_tree = (CommonTree)adaptor.dupNode(POLA_RULE_STRUCT_UTIL42);

            adaptor.addChild(root_0, POLA_RULE_STRUCT_UTIL42_tree);


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
    // $ANTLR end "utilityFunctionPolicyRule"

    public static class policyRuleComponentStructure_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyRuleComponentStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:115:1: policyRuleComponentStructure : ( policyEventStructure | policyConditionStructure | policyActionStructure );
    public final polaAst.policyRuleComponentStructure_return policyRuleComponentStructure() throws RecognitionException {
        polaAst.policyRuleComponentStructure_return retval = new polaAst.policyRuleComponentStructure_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyEventStructure_return policyEventStructure43 = null;

        polaAst.policyConditionStructure_return policyConditionStructure44 = null;

        polaAst.policyActionStructure_return policyActionStructure45 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:115:29: ( policyEventStructure | policyConditionStructure | policyActionStructure )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:115:31: policyEventStructure
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyEventStructure_in_policyRuleComponentStructure469);
                    policyEventStructure43=policyEventStructure();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventStructure43.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:115:54: policyConditionStructure
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyConditionStructure_in_policyRuleComponentStructure473);
                    policyConditionStructure44=policyConditionStructure();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionStructure44.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:115:81: policyActionStructure
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyActionStructure_in_policyRuleComponentStructure477);
                    policyActionStructure45=policyActionStructure();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionStructure45.getTree());

                    }
                    break;

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
    // $ANTLR end "policyRuleComponentStructure"

    public static class policyEventStructure_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:117:1: policyEventStructure : POLA_EVENT ( policyEventStructureBody )* ;
    public final polaAst.policyEventStructure_return policyEventStructure() throws RecognitionException {
        polaAst.policyEventStructure_return retval = new polaAst.policyEventStructure_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_EVENT46=null;
        polaAst.policyEventStructureBody_return policyEventStructureBody47 = null;


        CommonTree POLA_EVENT46_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:117:25: ( POLA_EVENT ( policyEventStructureBody )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:117:27: POLA_EVENT ( policyEventStructureBody )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_EVENT46=(CommonTree)match(input,POLA_EVENT,FOLLOW_POLA_EVENT_in_policyEventStructure488); 
            POLA_EVENT46_tree = (CommonTree)adaptor.dupNode(POLA_EVENT46);

            adaptor.addChild(root_0, POLA_EVENT46_tree);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:117:38: ( policyEventStructureBody )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==POLA_GROUP||LA11_0==BODY) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:117:38: policyEventStructureBody
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyEventStructureBody_in_policyEventStructure490);
            	    policyEventStructureBody47=policyEventStructureBody();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyEventStructureBody47.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


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
    // $ANTLR end "policyEventStructure"

    public static class policyEventStructureBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventStructureBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:118:1: policyEventStructureBody : ( policyEventGroup | policyEvent );
    public final polaAst.policyEventStructureBody_return policyEventStructureBody() throws RecognitionException {
        polaAst.policyEventStructureBody_return retval = new polaAst.policyEventStructureBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyEventGroup_return policyEventGroup48 = null;

        polaAst.policyEvent_return policyEvent49 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:118:25: ( policyEventGroup | policyEvent )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==POLA_GROUP) ) {
                alt12=1;
            }
            else if ( (LA12_0==BODY) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:118:27: policyEventGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyEventGroup_in_policyEventStructureBody497);
                    policyEventGroup48=policyEventGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventGroup48.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:118:46: policyEvent
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyEvent_in_policyEventStructureBody501);
                    policyEvent49=policyEvent();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEvent49.getTree());

                    }
                    break;

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
    // $ANTLR end "policyEventStructureBody"

    public static class policyEventGroup_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventGroup"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:119:1: policyEventGroup : ^( POLA_GROUP IDENT ( policyEventGroupBody )* ) ;
    public final polaAst.policyEventGroup_return policyEventGroup() throws RecognitionException {
        polaAst.policyEventGroup_return retval = new polaAst.policyEventGroup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_GROUP50=null;
        CommonTree IDENT51=null;
        polaAst.policyEventGroupBody_return policyEventGroupBody52 = null;


        CommonTree POLA_GROUP50_tree=null;
        CommonTree IDENT51_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:119:25: ( ^( POLA_GROUP IDENT ( policyEventGroupBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:119:27: ^( POLA_GROUP IDENT ( policyEventGroupBody )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            POLA_GROUP50=(CommonTree)match(input,POLA_GROUP,FOLLOW_POLA_GROUP_in_policyEventGroup516); 
            POLA_GROUP50_tree = (CommonTree)adaptor.dupNode(POLA_GROUP50);

            root_1 = (CommonTree)adaptor.becomeRoot(POLA_GROUP50_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT51=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_policyEventGroup518); 
            IDENT51_tree = (CommonTree)adaptor.dupNode(IDENT51);

            adaptor.addChild(root_1, IDENT51_tree);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:119:46: ( policyEventGroupBody )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==POLA_GROUP||LA13_0==BODY) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:119:46: policyEventGroupBody
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyEventGroupBody_in_policyEventGroup520);
            	    policyEventGroupBody52=policyEventGroupBody();

            	    state._fsp--;

            	    adaptor.addChild(root_1, policyEventGroupBody52.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // $ANTLR end "policyEventGroup"

    public static class policyEventGroupBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventGroupBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:120:1: policyEventGroupBody : ( policyEventGroup | policyEvent );
    public final polaAst.policyEventGroupBody_return policyEventGroupBody() throws RecognitionException {
        polaAst.policyEventGroupBody_return retval = new polaAst.policyEventGroupBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyEventGroup_return policyEventGroup53 = null;

        polaAst.policyEvent_return policyEvent54 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:120:25: ( policyEventGroup | policyEvent )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==POLA_GROUP) ) {
                alt14=1;
            }
            else if ( (LA14_0==BODY) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:120:27: policyEventGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyEventGroup_in_policyEventGroupBody532);
                    policyEventGroup53=policyEventGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventGroup53.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:120:46: policyEvent
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyEvent_in_policyEventGroupBody536);
                    policyEvent54=policyEvent();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEvent54.getTree());

                    }
                    break;

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
    // $ANTLR end "policyEventGroupBody"

    public static class policyEvent_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEvent"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:121:1: policyEvent : ^( BODY ( policyEventBody )* ) ;
    public final polaAst.policyEvent_return policyEvent() throws RecognitionException {
        polaAst.policyEvent_return retval = new polaAst.policyEvent_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BODY55=null;
        polaAst.policyEventBody_return policyEventBody56 = null;


        CommonTree BODY55_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:121:25: ( ^( BODY ( policyEventBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:121:27: ^( BODY ( policyEventBody )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            BODY55=(CommonTree)match(input,BODY,FOLLOW_BODY_in_policyEvent556); 
            BODY55_tree = (CommonTree)adaptor.dupNode(BODY55);

            root_1 = (CommonTree)adaptor.becomeRoot(BODY55_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:121:34: ( policyEventBody )*
                loop15:
                do {
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( ((LA15_0>=POLA_COMPOSITE && LA15_0<=POLA_NONSTD)) ) {
                        alt15=1;
                    }


                    switch (alt15) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:121:34: policyEventBody
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_policyEventBody_in_policyEvent558);
                	    policyEventBody56=policyEventBody();

                	    state._fsp--;

                	    adaptor.addChild(root_1, policyEventBody56.getTree());

                	    }
                	    break;

                	default :
                	    break loop15;
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
    // $ANTLR end "policyEvent"

    public static class policyEventBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:122:1: policyEventBody : ( policyEventComposite | policyEventAtomic | policyEventNonStd );
    public final polaAst.policyEventBody_return policyEventBody() throws RecognitionException {
        polaAst.policyEventBody_return retval = new polaAst.policyEventBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyEventComposite_return policyEventComposite57 = null;

        polaAst.policyEventAtomic_return policyEventAtomic58 = null;

        polaAst.policyEventNonStd_return policyEventNonStd59 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:122:25: ( policyEventComposite | policyEventAtomic | policyEventNonStd )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:122:27: policyEventComposite
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyEventComposite_in_policyEventBody575);
                    policyEventComposite57=policyEventComposite();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventComposite57.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:122:50: policyEventAtomic
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyEventAtomic_in_policyEventBody579);
                    policyEventAtomic58=policyEventAtomic();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventAtomic58.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:122:70: policyEventNonStd
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyEventNonStd_in_policyEventBody583);
                    policyEventNonStd59=policyEventNonStd();

                    state._fsp--;

                    adaptor.addChild(root_0, policyEventNonStd59.getTree());

                    }
                    break;

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
    // $ANTLR end "policyEventBody"

    public static class policyEventComposite_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventComposite"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:123:1: policyEventComposite : ^( POLA_COMPOSITE policyECAInherited ( policyEvent )* ) ;
    public final polaAst.policyEventComposite_return policyEventComposite() throws RecognitionException {
        polaAst.policyEventComposite_return retval = new polaAst.policyEventComposite_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_COMPOSITE60=null;
        polaAst.policyECAInherited_return policyECAInherited61 = null;

        polaAst.policyEvent_return policyEvent62 = null;


        CommonTree POLA_COMPOSITE60_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:123:25: ( ^( POLA_COMPOSITE policyECAInherited ( policyEvent )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:123:27: ^( POLA_COMPOSITE policyECAInherited ( policyEvent )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            POLA_COMPOSITE60=(CommonTree)match(input,POLA_COMPOSITE,FOLLOW_POLA_COMPOSITE_in_policyEventComposite594); 
            POLA_COMPOSITE60_tree = (CommonTree)adaptor.dupNode(POLA_COMPOSITE60);

            root_1 = (CommonTree)adaptor.becomeRoot(POLA_COMPOSITE60_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_policyECAInherited_in_policyEventComposite596);
            policyECAInherited61=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_1, policyECAInherited61.getTree());
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:123:63: ( policyEvent )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==BODY) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:123:63: policyEvent
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyEvent_in_policyEventComposite598);
            	    policyEvent62=policyEvent();

            	    state._fsp--;

            	    adaptor.addChild(root_1, policyEvent62.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // $ANTLR end "policyEventComposite"

    public static class policyEventAtomic_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventAtomic"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:124:1: policyEventAtomic : POLA_ATOMIC policyECAInherited pola_string ;
    public final polaAst.policyEventAtomic_return policyEventAtomic() throws RecognitionException {
        polaAst.policyEventAtomic_return retval = new polaAst.policyEventAtomic_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_ATOMIC63=null;
        polaAst.policyECAInherited_return policyECAInherited64 = null;

        polaAst.pola_string_return pola_string65 = null;


        CommonTree POLA_ATOMIC63_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:124:25: ( POLA_ATOMIC policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:124:27: POLA_ATOMIC policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_ATOMIC63=(CommonTree)match(input,POLA_ATOMIC,FOLLOW_POLA_ATOMIC_in_policyEventAtomic613); 
            POLA_ATOMIC63_tree = (CommonTree)adaptor.dupNode(POLA_ATOMIC63);

            adaptor.addChild(root_0, POLA_ATOMIC63_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_policyECAInherited_in_policyEventAtomic615);
            policyECAInherited64=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited64.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_pola_string_in_policyEventAtomic617);
            pola_string65=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string65.getTree());

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
    // $ANTLR end "policyEventAtomic"

    public static class policyEventNonStd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyEventNonStd"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:125:1: policyEventNonStd : POLA_NONSTD policyECAInherited pola_string ;
    public final polaAst.policyEventNonStd_return policyEventNonStd() throws RecognitionException {
        polaAst.policyEventNonStd_return retval = new polaAst.policyEventNonStd_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_NONSTD66=null;
        polaAst.policyECAInherited_return policyECAInherited67 = null;

        polaAst.pola_string_return pola_string68 = null;


        CommonTree POLA_NONSTD66_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:125:25: ( POLA_NONSTD policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:125:27: POLA_NONSTD policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_NONSTD66=(CommonTree)match(input,POLA_NONSTD,FOLLOW_POLA_NONSTD_in_policyEventNonStd630); 
            POLA_NONSTD66_tree = (CommonTree)adaptor.dupNode(POLA_NONSTD66);

            adaptor.addChild(root_0, POLA_NONSTD66_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_policyECAInherited_in_policyEventNonStd632);
            policyECAInherited67=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited67.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_pola_string_in_policyEventNonStd634);
            pola_string68=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string68.getTree());

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
    // $ANTLR end "policyEventNonStd"

    public static class policyConditionStructure_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:127:1: policyConditionStructure : POLA_CONDITION ( policyConditionStructureBody )* ;
    public final polaAst.policyConditionStructure_return policyConditionStructure() throws RecognitionException {
        polaAst.policyConditionStructure_return retval = new polaAst.policyConditionStructure_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_CONDITION69=null;
        polaAst.policyConditionStructureBody_return policyConditionStructureBody70 = null;


        CommonTree POLA_CONDITION69_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:127:29: ( POLA_CONDITION ( policyConditionStructureBody )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:127:31: POLA_CONDITION ( policyConditionStructureBody )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_CONDITION69=(CommonTree)match(input,POLA_CONDITION,FOLLOW_POLA_CONDITION_in_policyConditionStructure645); 
            POLA_CONDITION69_tree = (CommonTree)adaptor.dupNode(POLA_CONDITION69);

            adaptor.addChild(root_0, POLA_CONDITION69_tree);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:127:46: ( policyConditionStructureBody )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==POLA_GROUP||LA18_0==BODY) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:127:46: policyConditionStructureBody
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyConditionStructureBody_in_policyConditionStructure647);
            	    policyConditionStructureBody70=policyConditionStructureBody();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyConditionStructureBody70.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


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
    // $ANTLR end "policyConditionStructure"

    public static class policyConditionStructureBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionStructureBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:128:1: policyConditionStructureBody : ( policyConditionGroup | policyCondition );
    public final polaAst.policyConditionStructureBody_return policyConditionStructureBody() throws RecognitionException {
        polaAst.policyConditionStructureBody_return retval = new polaAst.policyConditionStructureBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyConditionGroup_return policyConditionGroup71 = null;

        polaAst.policyCondition_return policyCondition72 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:128:29: ( policyConditionGroup | policyCondition )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==POLA_GROUP) ) {
                alt19=1;
            }
            else if ( (LA19_0==BODY) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:128:31: policyConditionGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyConditionGroup_in_policyConditionStructureBody654);
                    policyConditionGroup71=policyConditionGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionGroup71.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:128:54: policyCondition
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyCondition_in_policyConditionStructureBody658);
                    policyCondition72=policyCondition();

                    state._fsp--;

                    adaptor.addChild(root_0, policyCondition72.getTree());

                    }
                    break;

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
    // $ANTLR end "policyConditionStructureBody"

    public static class policyConditionGroup_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionGroup"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:129:1: policyConditionGroup : ^( POLA_GROUP IDENT ( policyConditionGroupBody )* ) ;
    public final polaAst.policyConditionGroup_return policyConditionGroup() throws RecognitionException {
        polaAst.policyConditionGroup_return retval = new polaAst.policyConditionGroup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_GROUP73=null;
        CommonTree IDENT74=null;
        polaAst.policyConditionGroupBody_return policyConditionGroupBody75 = null;


        CommonTree POLA_GROUP73_tree=null;
        CommonTree IDENT74_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:129:29: ( ^( POLA_GROUP IDENT ( policyConditionGroupBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:129:31: ^( POLA_GROUP IDENT ( policyConditionGroupBody )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            POLA_GROUP73=(CommonTree)match(input,POLA_GROUP,FOLLOW_POLA_GROUP_in_policyConditionGroup673); 
            POLA_GROUP73_tree = (CommonTree)adaptor.dupNode(POLA_GROUP73);

            root_1 = (CommonTree)adaptor.becomeRoot(POLA_GROUP73_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT74=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_policyConditionGroup675); 
            IDENT74_tree = (CommonTree)adaptor.dupNode(IDENT74);

            adaptor.addChild(root_1, IDENT74_tree);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:129:50: ( policyConditionGroupBody )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==POLA_GROUP||LA20_0==BODY) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:129:50: policyConditionGroupBody
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyConditionGroupBody_in_policyConditionGroup677);
            	    policyConditionGroupBody75=policyConditionGroupBody();

            	    state._fsp--;

            	    adaptor.addChild(root_1, policyConditionGroupBody75.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // $ANTLR end "policyConditionGroup"

    public static class policyConditionGroupBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionGroupBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:130:1: policyConditionGroupBody : ( policyConditionGroup | policyCondition );
    public final polaAst.policyConditionGroupBody_return policyConditionGroupBody() throws RecognitionException {
        polaAst.policyConditionGroupBody_return retval = new polaAst.policyConditionGroupBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyConditionGroup_return policyConditionGroup76 = null;

        polaAst.policyCondition_return policyCondition77 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:130:29: ( policyConditionGroup | policyCondition )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==POLA_GROUP) ) {
                alt21=1;
            }
            else if ( (LA21_0==BODY) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:130:31: policyConditionGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyConditionGroup_in_policyConditionGroupBody689);
                    policyConditionGroup76=policyConditionGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionGroup76.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:130:54: policyCondition
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyCondition_in_policyConditionGroupBody693);
                    policyCondition77=policyCondition();

                    state._fsp--;

                    adaptor.addChild(root_0, policyCondition77.getTree());

                    }
                    break;

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
    // $ANTLR end "policyConditionGroupBody"

    public static class policyCondition_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyCondition"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:131:1: policyCondition : ^( BODY ( policyConditionBody )* ) ;
    public final polaAst.policyCondition_return policyCondition() throws RecognitionException {
        polaAst.policyCondition_return retval = new polaAst.policyCondition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BODY78=null;
        polaAst.policyConditionBody_return policyConditionBody79 = null;


        CommonTree BODY78_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:131:29: ( ^( BODY ( policyConditionBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:131:31: ^( BODY ( policyConditionBody )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            BODY78=(CommonTree)match(input,BODY,FOLLOW_BODY_in_policyCondition713); 
            BODY78_tree = (CommonTree)adaptor.dupNode(BODY78);

            root_1 = (CommonTree)adaptor.becomeRoot(BODY78_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:131:38: ( policyConditionBody )*
                loop22:
                do {
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( ((LA22_0>=POLA_COMPOSITE && LA22_0<=POLA_NONSTD)) ) {
                        alt22=1;
                    }


                    switch (alt22) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:131:38: policyConditionBody
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_policyConditionBody_in_policyCondition715);
                	    policyConditionBody79=policyConditionBody();

                	    state._fsp--;

                	    adaptor.addChild(root_1, policyConditionBody79.getTree());

                	    }
                	    break;

                	default :
                	    break loop22;
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
    // $ANTLR end "policyCondition"

    public static class policyConditionBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:132:1: policyConditionBody : ( policyConditionComposite | policyConditionAtomic | policyConditionNonStd );
    public final polaAst.policyConditionBody_return policyConditionBody() throws RecognitionException {
        polaAst.policyConditionBody_return retval = new polaAst.policyConditionBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyConditionComposite_return policyConditionComposite80 = null;

        polaAst.policyConditionAtomic_return policyConditionAtomic81 = null;

        polaAst.policyConditionNonStd_return policyConditionNonStd82 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:132:29: ( policyConditionComposite | policyConditionAtomic | policyConditionNonStd )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:132:31: policyConditionComposite
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyConditionComposite_in_policyConditionBody732);
                    policyConditionComposite80=policyConditionComposite();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionComposite80.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:132:58: policyConditionAtomic
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyConditionAtomic_in_policyConditionBody736);
                    policyConditionAtomic81=policyConditionAtomic();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionAtomic81.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:132:82: policyConditionNonStd
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyConditionNonStd_in_policyConditionBody740);
                    policyConditionNonStd82=policyConditionNonStd();

                    state._fsp--;

                    adaptor.addChild(root_0, policyConditionNonStd82.getTree());

                    }
                    break;

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
    // $ANTLR end "policyConditionBody"

    public static class policyConditionComposite_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionComposite"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:133:1: policyConditionComposite : ^( POLA_COMPOSITE policyECAInherited ( policyCondition )* ) ;
    public final polaAst.policyConditionComposite_return policyConditionComposite() throws RecognitionException {
        polaAst.policyConditionComposite_return retval = new polaAst.policyConditionComposite_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_COMPOSITE83=null;
        polaAst.policyECAInherited_return policyECAInherited84 = null;

        polaAst.policyCondition_return policyCondition85 = null;


        CommonTree POLA_COMPOSITE83_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:133:29: ( ^( POLA_COMPOSITE policyECAInherited ( policyCondition )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:133:31: ^( POLA_COMPOSITE policyECAInherited ( policyCondition )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            POLA_COMPOSITE83=(CommonTree)match(input,POLA_COMPOSITE,FOLLOW_POLA_COMPOSITE_in_policyConditionComposite751); 
            POLA_COMPOSITE83_tree = (CommonTree)adaptor.dupNode(POLA_COMPOSITE83);

            root_1 = (CommonTree)adaptor.becomeRoot(POLA_COMPOSITE83_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_policyECAInherited_in_policyConditionComposite753);
            policyECAInherited84=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_1, policyECAInherited84.getTree());
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:133:67: ( policyCondition )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==BODY) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:133:67: policyCondition
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyCondition_in_policyConditionComposite755);
            	    policyCondition85=policyCondition();

            	    state._fsp--;

            	    adaptor.addChild(root_1, policyCondition85.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // $ANTLR end "policyConditionComposite"

    public static class policyConditionAtomic_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionAtomic"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:134:1: policyConditionAtomic : POLA_ATOMIC policyECAInherited pola_string ;
    public final polaAst.policyConditionAtomic_return policyConditionAtomic() throws RecognitionException {
        polaAst.policyConditionAtomic_return retval = new polaAst.policyConditionAtomic_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_ATOMIC86=null;
        polaAst.policyECAInherited_return policyECAInherited87 = null;

        polaAst.pola_string_return pola_string88 = null;


        CommonTree POLA_ATOMIC86_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:134:29: ( POLA_ATOMIC policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:134:31: POLA_ATOMIC policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_ATOMIC86=(CommonTree)match(input,POLA_ATOMIC,FOLLOW_POLA_ATOMIC_in_policyConditionAtomic770); 
            POLA_ATOMIC86_tree = (CommonTree)adaptor.dupNode(POLA_ATOMIC86);

            adaptor.addChild(root_0, POLA_ATOMIC86_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_policyECAInherited_in_policyConditionAtomic772);
            policyECAInherited87=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited87.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_pola_string_in_policyConditionAtomic774);
            pola_string88=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string88.getTree());

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
    // $ANTLR end "policyConditionAtomic"

    public static class policyConditionNonStd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyConditionNonStd"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:135:1: policyConditionNonStd : POLA_NONSTD policyECAInherited pola_string ;
    public final polaAst.policyConditionNonStd_return policyConditionNonStd() throws RecognitionException {
        polaAst.policyConditionNonStd_return retval = new polaAst.policyConditionNonStd_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_NONSTD89=null;
        polaAst.policyECAInherited_return policyECAInherited90 = null;

        polaAst.pola_string_return pola_string91 = null;


        CommonTree POLA_NONSTD89_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:135:29: ( POLA_NONSTD policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:135:31: POLA_NONSTD policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_NONSTD89=(CommonTree)match(input,POLA_NONSTD,FOLLOW_POLA_NONSTD_in_policyConditionNonStd787); 
            POLA_NONSTD89_tree = (CommonTree)adaptor.dupNode(POLA_NONSTD89);

            adaptor.addChild(root_0, POLA_NONSTD89_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_policyECAInherited_in_policyConditionNonStd789);
            policyECAInherited90=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited90.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_pola_string_in_policyConditionNonStd791);
            pola_string91=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string91.getTree());

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
    // $ANTLR end "policyConditionNonStd"

    public static class policyActionStructure_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:137:1: policyActionStructure : POLA_ACTION ( policyActionStructureBody )* ;
    public final polaAst.policyActionStructure_return policyActionStructure() throws RecognitionException {
        polaAst.policyActionStructure_return retval = new polaAst.policyActionStructure_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_ACTION92=null;
        polaAst.policyActionStructureBody_return policyActionStructureBody93 = null;


        CommonTree POLA_ACTION92_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:137:26: ( POLA_ACTION ( policyActionStructureBody )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:137:28: POLA_ACTION ( policyActionStructureBody )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_ACTION92=(CommonTree)match(input,POLA_ACTION,FOLLOW_POLA_ACTION_in_policyActionStructure802); 
            POLA_ACTION92_tree = (CommonTree)adaptor.dupNode(POLA_ACTION92);

            adaptor.addChild(root_0, POLA_ACTION92_tree);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:137:40: ( policyActionStructureBody )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==POLA_GROUP||LA25_0==BODY) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:137:40: policyActionStructureBody
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyActionStructureBody_in_policyActionStructure804);
            	    policyActionStructureBody93=policyActionStructureBody();

            	    state._fsp--;

            	    adaptor.addChild(root_0, policyActionStructureBody93.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


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
    // $ANTLR end "policyActionStructure"

    public static class policyActionStructureBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionStructureBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:138:1: policyActionStructureBody : ( policyActionGroup | policyAction );
    public final polaAst.policyActionStructureBody_return policyActionStructureBody() throws RecognitionException {
        polaAst.policyActionStructureBody_return retval = new polaAst.policyActionStructureBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyActionGroup_return policyActionGroup94 = null;

        polaAst.policyAction_return policyAction95 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:138:26: ( policyActionGroup | policyAction )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==POLA_GROUP) ) {
                alt26=1;
            }
            else if ( (LA26_0==BODY) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:138:28: policyActionGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyActionGroup_in_policyActionStructureBody811);
                    policyActionGroup94=policyActionGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionGroup94.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:138:48: policyAction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyAction_in_policyActionStructureBody815);
                    policyAction95=policyAction();

                    state._fsp--;

                    adaptor.addChild(root_0, policyAction95.getTree());

                    }
                    break;

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
    // $ANTLR end "policyActionStructureBody"

    public static class policyActionGroup_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionGroup"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:139:1: policyActionGroup : ^( POLA_GROUP IDENT ( policyActionGroupBody )* ) ;
    public final polaAst.policyActionGroup_return policyActionGroup() throws RecognitionException {
        polaAst.policyActionGroup_return retval = new polaAst.policyActionGroup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_GROUP96=null;
        CommonTree IDENT97=null;
        polaAst.policyActionGroupBody_return policyActionGroupBody98 = null;


        CommonTree POLA_GROUP96_tree=null;
        CommonTree IDENT97_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:139:26: ( ^( POLA_GROUP IDENT ( policyActionGroupBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:139:28: ^( POLA_GROUP IDENT ( policyActionGroupBody )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            POLA_GROUP96=(CommonTree)match(input,POLA_GROUP,FOLLOW_POLA_GROUP_in_policyActionGroup830); 
            POLA_GROUP96_tree = (CommonTree)adaptor.dupNode(POLA_GROUP96);

            root_1 = (CommonTree)adaptor.becomeRoot(POLA_GROUP96_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT97=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_policyActionGroup832); 
            IDENT97_tree = (CommonTree)adaptor.dupNode(IDENT97);

            adaptor.addChild(root_1, IDENT97_tree);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:139:47: ( policyActionGroupBody )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==POLA_GROUP||LA27_0==BODY) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:139:47: policyActionGroupBody
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyActionGroupBody_in_policyActionGroup834);
            	    policyActionGroupBody98=policyActionGroupBody();

            	    state._fsp--;

            	    adaptor.addChild(root_1, policyActionGroupBody98.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // $ANTLR end "policyActionGroup"

    public static class policyActionGroupBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionGroupBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:140:1: policyActionGroupBody : ( policyActionGroup | policyAction );
    public final polaAst.policyActionGroupBody_return policyActionGroupBody() throws RecognitionException {
        polaAst.policyActionGroupBody_return retval = new polaAst.policyActionGroupBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyActionGroup_return policyActionGroup99 = null;

        polaAst.policyAction_return policyAction100 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:140:26: ( policyActionGroup | policyAction )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==POLA_GROUP) ) {
                alt28=1;
            }
            else if ( (LA28_0==BODY) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:140:28: policyActionGroup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyActionGroup_in_policyActionGroupBody846);
                    policyActionGroup99=policyActionGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionGroup99.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:140:48: policyAction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyAction_in_policyActionGroupBody850);
                    policyAction100=policyAction();

                    state._fsp--;

                    adaptor.addChild(root_0, policyAction100.getTree());

                    }
                    break;

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
    // $ANTLR end "policyActionGroupBody"

    public static class policyAction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyAction"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:141:1: policyAction : ^( BODY ( policyActionBody )* ) ;
    public final polaAst.policyAction_return policyAction() throws RecognitionException {
        polaAst.policyAction_return retval = new polaAst.policyAction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BODY101=null;
        polaAst.policyActionBody_return policyActionBody102 = null;


        CommonTree BODY101_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:141:26: ( ^( BODY ( policyActionBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:141:28: ^( BODY ( policyActionBody )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            BODY101=(CommonTree)match(input,BODY,FOLLOW_BODY_in_policyAction870); 
            BODY101_tree = (CommonTree)adaptor.dupNode(BODY101);

            root_1 = (CommonTree)adaptor.becomeRoot(BODY101_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:141:35: ( policyActionBody )*
                loop29:
                do {
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=POLA_COMPOSITE && LA29_0<=POLA_NONSTD)) ) {
                        alt29=1;
                    }


                    switch (alt29) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:141:35: policyActionBody
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_policyActionBody_in_policyAction872);
                	    policyActionBody102=policyActionBody();

                	    state._fsp--;

                	    adaptor.addChild(root_1, policyActionBody102.getTree());

                	    }
                	    break;

                	default :
                	    break loop29;
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
    // $ANTLR end "policyAction"

    public static class policyActionBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:142:1: policyActionBody : ( policyActionComposite | policyActionAtomic | policyActionNonStd );
    public final polaAst.policyActionBody_return policyActionBody() throws RecognitionException {
        polaAst.policyActionBody_return retval = new polaAst.policyActionBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        polaAst.policyActionComposite_return policyActionComposite103 = null;

        polaAst.policyActionAtomic_return policyActionAtomic104 = null;

        polaAst.policyActionNonStd_return policyActionNonStd105 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:142:26: ( policyActionComposite | policyActionAtomic | policyActionNonStd )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:142:28: policyActionComposite
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyActionComposite_in_policyActionBody889);
                    policyActionComposite103=policyActionComposite();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionComposite103.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:142:52: policyActionAtomic
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyActionAtomic_in_policyActionBody893);
                    policyActionAtomic104=policyActionAtomic();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionAtomic104.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:142:73: policyActionNonStd
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_policyActionNonStd_in_policyActionBody897);
                    policyActionNonStd105=policyActionNonStd();

                    state._fsp--;

                    adaptor.addChild(root_0, policyActionNonStd105.getTree());

                    }
                    break;

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
    // $ANTLR end "policyActionBody"

    public static class policyActionComposite_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionComposite"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:143:1: policyActionComposite : ^( POLA_COMPOSITE policyECAInherited ( policyAction )* ) ;
    public final polaAst.policyActionComposite_return policyActionComposite() throws RecognitionException {
        polaAst.policyActionComposite_return retval = new polaAst.policyActionComposite_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_COMPOSITE106=null;
        polaAst.policyECAInherited_return policyECAInherited107 = null;

        polaAst.policyAction_return policyAction108 = null;


        CommonTree POLA_COMPOSITE106_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:143:26: ( ^( POLA_COMPOSITE policyECAInherited ( policyAction )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:143:28: ^( POLA_COMPOSITE policyECAInherited ( policyAction )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            POLA_COMPOSITE106=(CommonTree)match(input,POLA_COMPOSITE,FOLLOW_POLA_COMPOSITE_in_policyActionComposite908); 
            POLA_COMPOSITE106_tree = (CommonTree)adaptor.dupNode(POLA_COMPOSITE106);

            root_1 = (CommonTree)adaptor.becomeRoot(POLA_COMPOSITE106_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_policyECAInherited_in_policyActionComposite910);
            policyECAInherited107=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_1, policyECAInherited107.getTree());
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:143:64: ( policyAction )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==BODY) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:143:64: policyAction
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_policyAction_in_policyActionComposite912);
            	    policyAction108=policyAction();

            	    state._fsp--;

            	    adaptor.addChild(root_1, policyAction108.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // $ANTLR end "policyActionComposite"

    public static class policyActionAtomic_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionAtomic"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:144:1: policyActionAtomic : POLA_ATOMIC policyECAInherited pola_string ;
    public final polaAst.policyActionAtomic_return policyActionAtomic() throws RecognitionException {
        polaAst.policyActionAtomic_return retval = new polaAst.policyActionAtomic_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_ATOMIC109=null;
        polaAst.policyECAInherited_return policyECAInherited110 = null;

        polaAst.pola_string_return pola_string111 = null;


        CommonTree POLA_ATOMIC109_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:144:26: ( POLA_ATOMIC policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:144:28: POLA_ATOMIC policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_ATOMIC109=(CommonTree)match(input,POLA_ATOMIC,FOLLOW_POLA_ATOMIC_in_policyActionAtomic927); 
            POLA_ATOMIC109_tree = (CommonTree)adaptor.dupNode(POLA_ATOMIC109);

            adaptor.addChild(root_0, POLA_ATOMIC109_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_policyECAInherited_in_policyActionAtomic929);
            policyECAInherited110=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited110.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_pola_string_in_policyActionAtomic931);
            pola_string111=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string111.getTree());

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
    // $ANTLR end "policyActionAtomic"

    public static class policyActionNonStd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyActionNonStd"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:145:1: policyActionNonStd : POLA_NONSTD policyECAInherited pola_string ;
    public final polaAst.policyActionNonStd_return policyActionNonStd() throws RecognitionException {
        polaAst.policyActionNonStd_return retval = new polaAst.policyActionNonStd_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_NONSTD112=null;
        polaAst.policyECAInherited_return policyECAInherited113 = null;

        polaAst.pola_string_return pola_string114 = null;


        CommonTree POLA_NONSTD112_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:145:26: ( POLA_NONSTD policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:145:28: POLA_NONSTD policyECAInherited pola_string
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            POLA_NONSTD112=(CommonTree)match(input,POLA_NONSTD,FOLLOW_POLA_NONSTD_in_policyActionNonStd944); 
            POLA_NONSTD112_tree = (CommonTree)adaptor.dupNode(POLA_NONSTD112);

            adaptor.addChild(root_0, POLA_NONSTD112_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_policyECAInherited_in_policyActionNonStd946);
            policyECAInherited113=policyECAInherited();

            state._fsp--;

            adaptor.addChild(root_0, policyECAInherited113.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_pola_string_in_policyActionNonStd948);
            pola_string114=pola_string();

            state._fsp--;

            adaptor.addChild(root_0, pola_string114.getTree());

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
    // $ANTLR end "policyActionNonStd"

    public static class policyECAInherited_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "policyECAInherited"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:147:1: policyECAInherited : ^( POLA_SEQ_NUMER VAL_INTEGER ) ^( POLA_HASBEEN_EVALED boolean_value ) ;
    public final polaAst.policyECAInherited_return policyECAInherited() throws RecognitionException {
        polaAst.policyECAInherited_return retval = new polaAst.policyECAInherited_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POLA_SEQ_NUMER115=null;
        CommonTree VAL_INTEGER116=null;
        CommonTree POLA_HASBEEN_EVALED117=null;
        polaAst.boolean_value_return boolean_value118 = null;


        CommonTree POLA_SEQ_NUMER115_tree=null;
        CommonTree VAL_INTEGER116_tree=null;
        CommonTree POLA_HASBEEN_EVALED117_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:147:23: ( ^( POLA_SEQ_NUMER VAL_INTEGER ) ^( POLA_HASBEEN_EVALED boolean_value ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:147:25: ^( POLA_SEQ_NUMER VAL_INTEGER ) ^( POLA_HASBEEN_EVALED boolean_value )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            POLA_SEQ_NUMER115=(CommonTree)match(input,POLA_SEQ_NUMER,FOLLOW_POLA_SEQ_NUMER_in_policyECAInherited960); 
            POLA_SEQ_NUMER115_tree = (CommonTree)adaptor.dupNode(POLA_SEQ_NUMER115);

            root_1 = (CommonTree)adaptor.becomeRoot(POLA_SEQ_NUMER115_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            VAL_INTEGER116=(CommonTree)match(input,VAL_INTEGER,FOLLOW_VAL_INTEGER_in_policyECAInherited962); 
            VAL_INTEGER116_tree = (CommonTree)adaptor.dupNode(VAL_INTEGER116);

            adaptor.addChild(root_1, VAL_INTEGER116_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            POLA_HASBEEN_EVALED117=(CommonTree)match(input,POLA_HASBEEN_EVALED,FOLLOW_POLA_HASBEEN_EVALED_in_policyECAInherited966); 
            POLA_HASBEEN_EVALED117_tree = (CommonTree)adaptor.dupNode(POLA_HASBEEN_EVALED117);

            root_1 = (CommonTree)adaptor.becomeRoot(POLA_HASBEEN_EVALED117_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_boolean_value_in_policyECAInherited968);
            boolean_value118=boolean_value();

            state._fsp--;

            adaptor.addChild(root_1, boolean_value118.getTree());

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
    // $ANTLR end "policyECAInherited"

    public static class pola_string_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pola_string"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:149:1: pola_string : VAL_DSTRING ;
    public final polaAst.pola_string_return pola_string() throws RecognitionException {
        polaAst.pola_string_return retval = new polaAst.pola_string_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree VAL_DSTRING119=null;

        CommonTree VAL_DSTRING119_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:149:25: ( VAL_DSTRING )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:149:27: VAL_DSTRING
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            VAL_DSTRING119=(CommonTree)match(input,VAL_DSTRING,FOLLOW_VAL_DSTRING_in_pola_string989); 
            VAL_DSTRING119_tree = (CommonTree)adaptor.dupNode(VAL_DSTRING119);

            adaptor.addChild(root_0, VAL_DSTRING119_tree);


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
    // $ANTLR end "pola_string"

    public static class scoped_name_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scoped_name"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:151:1: scoped_name : ^( AT_SCOPE (s= IDENT )* ) ;
    public final polaAst.scoped_name_return scoped_name() throws RecognitionException {
        polaAst.scoped_name_return retval = new polaAst.scoped_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree AT_SCOPE120=null;

        CommonTree s_tree=null;
        CommonTree AT_SCOPE120_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:151:25: ( ^( AT_SCOPE (s= IDENT )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:151:27: ^( AT_SCOPE (s= IDENT )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_SCOPE120=(CommonTree)match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_scoped_name1010); 
            AT_SCOPE120_tree = (CommonTree)adaptor.dupNode(AT_SCOPE120);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_SCOPE120_tree, root_1);


            this.pass.sn.clear();

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:151:62: (s= IDENT )*
                loop32:
                do {
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==IDENT) ) {
                        alt32=1;
                    }


                    switch (alt32) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:151:63: s= IDENT
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_scoped_name1017); 
                	    s_tree = (CommonTree)adaptor.dupNode(s);

                	    adaptor.addChild(root_1, s_tree);

                	    this.pass.sn.push(s.token);

                	    }
                	    break;

                	default :
                	    break loop32;
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

    public static class void_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "void_type"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:153:1: void_type : VOID ;
    public final polaAst.void_type_return void_type() throws RecognitionException {
        polaAst.void_type_return retval = new polaAst.void_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree VOID121=null;

        CommonTree VOID121_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:153:25: ( VOID )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:153:27: VOID
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            VOID121=(CommonTree)match(input,VOID,FOLLOW_VOID_in_void_type1044); 
            VOID121_tree = (CommonTree)adaptor.dupNode(VOID121);

            adaptor.addChild(root_0, VOID121_tree);


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
    // $ANTLR end "void_type"

    public static class simple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simple_type"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:154:1: simple_type : ( scoped_name | base_type ) ( ARRAY )? ;
    public final polaAst.simple_type_return simple_type() throws RecognitionException {
        polaAst.simple_type_return retval = new polaAst.simple_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARRAY124=null;
        polaAst.scoped_name_return scoped_name122 = null;

        polaAst.base_type_return base_type123 = null;


        CommonTree ARRAY124_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:154:25: ( ( scoped_name | base_type ) ( ARRAY )? )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:154:27: ( scoped_name | base_type ) ( ARRAY )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:154:27: ( scoped_name | base_type )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==AT_SCOPE) ) {
                alt33=1;
            }
            else if ( ((LA33_0>=SHORT && LA33_0<=BOOLEAN)) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:154:28: scoped_name
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scoped_name_in_simple_type1064);
                    scoped_name122=scoped_name();

                    state._fsp--;

                    adaptor.addChild(root_0, scoped_name122.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:154:42: base_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_base_type_in_simple_type1068);
                    base_type123=base_type();

                    state._fsp--;

                    adaptor.addChild(root_0, base_type123.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:154:53: ( ARRAY )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==ARRAY) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:154:53: ARRAY
                    {
                    _last = (CommonTree)input.LT(1);
                    ARRAY124=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_simple_type1071); 
                    ARRAY124_tree = (CommonTree)adaptor.dupNode(ARRAY124);

                    adaptor.addChild(root_0, ARRAY124_tree);


                    }
                    break;

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
    // $ANTLR end "simple_type"

    public static class base_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "base_type"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:1: base_type : (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN ) ;
    public final polaAst.base_type_return base_type() throws RecognitionException {
        polaAst.base_type_return retval = new polaAst.base_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:25: ( (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:27: (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:27: (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN )
            int alt35=11;
            switch ( input.LA(1) ) {
            case SHORT:
                {
                alt35=1;
                }
                break;
            case INTEGER:
                {
                alt35=2;
                }
                break;
            case LONG:
                {
                alt35=3;
                }
                break;
            case OCTET:
                {
                alt35=4;
                }
                break;
            case HEX:
                {
                alt35=5;
                }
                break;
            case BINARY:
                {
                alt35=6;
                }
                break;
            case FLOAT:
                {
                alt35=7;
                }
                break;
            case DOUBLE:
                {
                alt35=8;
                }
                break;
            case CHAR:
                {
                alt35=9;
                }
                break;
            case STRING:
                {
                alt35=10;
                }
                break;
            case BOOLEAN:
                {
                alt35=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:28: s= SHORT
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,SHORT,FOLLOW_SHORT_in_base_type1096); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:38: s= INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_base_type1102); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:50: s= LONG
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,LONG,FOLLOW_LONG_in_base_type1108); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:59: s= OCTET
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,OCTET,FOLLOW_OCTET_in_base_type1114); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:69: s= HEX
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,HEX,FOLLOW_HEX_in_base_type1120); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:77: s= BINARY
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,BINARY,FOLLOW_BINARY_in_base_type1126); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:88: s= FLOAT
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_base_type1132); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:98: s= DOUBLE
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_base_type1138); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 9 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:109: s= CHAR
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,CHAR,FOLLOW_CHAR_in_base_type1144); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 10 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:118: s= STRING
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,STRING,FOLLOW_STRING_in_base_type1150); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 11 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:155:129: s= BOOLEAN
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_base_type1156); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;

            }

            this.pass.setLastBaseType(s.token);

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
    // $ANTLR end "base_type"

    public static class const_value_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "const_value"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:158:1: const_value : ( ^( AT_PROVIDES type= INTEGER value= VAL_INTEGER ) | ^( AT_PROVIDES type= OCTET value= VAL_OCT ) | ^( AT_PROVIDES type= HEX value= VAL_HEX ) | ^( AT_PROVIDES type= BINARY value= VAL_BINARY ) | ^( AT_PROVIDES type= FLOAT value= VAL_FLOAT ) | ^( AT_PROVIDES type= CHAR value= VAL_CHAR ) | ^( AT_PROVIDES type= STRING string_value ) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) );
    public final polaAst.const_value_return const_value() throws RecognitionException {
        polaAst.const_value_return retval = new polaAst.const_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree type=null;
        CommonTree value=null;
        CommonTree AT_PROVIDES125=null;
        CommonTree AT_PROVIDES126=null;
        CommonTree AT_PROVIDES127=null;
        CommonTree AT_PROVIDES128=null;
        CommonTree AT_PROVIDES129=null;
        CommonTree AT_PROVIDES130=null;
        CommonTree AT_PROVIDES131=null;
        CommonTree AT_PROVIDES133=null;
        polaAst.string_value_return string_value132 = null;

        polaAst.boolean_value_return boolean_value134 = null;


        CommonTree type_tree=null;
        CommonTree value_tree=null;
        CommonTree AT_PROVIDES125_tree=null;
        CommonTree AT_PROVIDES126_tree=null;
        CommonTree AT_PROVIDES127_tree=null;
        CommonTree AT_PROVIDES128_tree=null;
        CommonTree AT_PROVIDES129_tree=null;
        CommonTree AT_PROVIDES130_tree=null;
        CommonTree AT_PROVIDES131_tree=null;
        CommonTree AT_PROVIDES133_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:158:25: ( ^( AT_PROVIDES type= INTEGER value= VAL_INTEGER ) | ^( AT_PROVIDES type= OCTET value= VAL_OCT ) | ^( AT_PROVIDES type= HEX value= VAL_HEX ) | ^( AT_PROVIDES type= BINARY value= VAL_BINARY ) | ^( AT_PROVIDES type= FLOAT value= VAL_FLOAT ) | ^( AT_PROVIDES type= CHAR value= VAL_CHAR ) | ^( AT_PROVIDES type= STRING string_value ) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) )
            int alt36=8;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:158:27: ^( AT_PROVIDES type= INTEGER value= VAL_INTEGER )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES125=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1206); 
                    AT_PROVIDES125_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES125);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES125_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_const_value1210); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_INTEGER,FOLLOW_VAL_INTEGER_in_const_value1214); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:159:27: ^( AT_PROVIDES type= OCTET value= VAL_OCT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES126=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1248); 
                    AT_PROVIDES126_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES126);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES126_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,OCTET,FOLLOW_OCTET_in_const_value1252); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_OCT,FOLLOW_VAL_OCT_in_const_value1258); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:160:27: ^( AT_PROVIDES type= HEX value= VAL_HEX )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES127=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1296); 
                    AT_PROVIDES127_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES127);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES127_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,HEX,FOLLOW_HEX_in_const_value1300); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_HEX,FOLLOW_VAL_HEX_in_const_value1308); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:161:27: ^( AT_PROVIDES type= BINARY value= VAL_BINARY )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES128=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1346); 
                    AT_PROVIDES128_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES128);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES128_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,BINARY,FOLLOW_BINARY_in_const_value1350); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_BINARY,FOLLOW_VAL_BINARY_in_const_value1355); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:162:27: ^( AT_PROVIDES type= FLOAT value= VAL_FLOAT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES129=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1390); 
                    AT_PROVIDES129_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES129);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES129_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_const_value1394); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_FLOAT,FOLLOW_VAL_FLOAT_in_const_value1400); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:163:27: ^( AT_PROVIDES type= CHAR value= VAL_CHAR )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES130=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1436); 
                    AT_PROVIDES130_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES130);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES130_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,CHAR,FOLLOW_CHAR_in_const_value1440); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_CHAR,FOLLOW_VAL_CHAR_in_const_value1447); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:164:27: ^( AT_PROVIDES type= STRING string_value )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES131=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1484); 
                    AT_PROVIDES131_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES131);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES131_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,STRING,FOLLOW_STRING_in_const_value1488); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_string_value_in_const_value1491);
                    string_value132=string_value();

                    state._fsp--;

                    adaptor.addChild(root_1, string_value132.getTree());
                    this.pass.setLastCommonValueType(type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:165:27: ^( AT_PROVIDES type= BOOLEAN boolean_value )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES133=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1529); 
                    AT_PROVIDES133_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES133);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES133_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_const_value1533); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_boolean_value_in_const_value1535);
                    boolean_value134=boolean_value();

                    state._fsp--;

                    adaptor.addChild(root_1, boolean_value134.getTree());
                    this.pass.setLastCommonValueType(type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;

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
    // $ANTLR end "const_value"

    public static class string_value_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "string_value"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:166:1: string_value : (value= VAL_STRING | value= POLA_NULL ) ;
    public final polaAst.string_value_return string_value() throws RecognitionException {
        polaAst.string_value_return retval = new polaAst.string_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree value=null;

        CommonTree value_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:166:25: ( (value= VAL_STRING | value= POLA_NULL ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:166:27: (value= VAL_STRING | value= POLA_NULL )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:166:27: (value= VAL_STRING | value= POLA_NULL )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==VAL_STRING) ) {
                alt37=1;
            }
            else if ( (LA37_0==POLA_NULL) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:166:28: value= VAL_STRING
                    {
                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_STRING,FOLLOW_VAL_STRING_in_string_value1563); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_0, value_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:166:47: value= POLA_NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,POLA_NULL,FOLLOW_POLA_NULL_in_string_value1569); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_0, value_tree);


                    }
                    break;

            }

            this.pass.setLastCommonValue(value.token);

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
    // $ANTLR end "string_value"

    public static class boolean_value_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "boolean_value"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:167:1: boolean_value : (value= POLA_TRUE | value= POLA_FALSE ) ;
    public final polaAst.boolean_value_return boolean_value() throws RecognitionException {
        polaAst.boolean_value_return retval = new polaAst.boolean_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree value=null;

        CommonTree value_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:167:25: ( (value= POLA_TRUE | value= POLA_FALSE ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:167:27: (value= POLA_TRUE | value= POLA_FALSE )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:167:27: (value= POLA_TRUE | value= POLA_FALSE )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==POLA_TRUE) ) {
                alt38=1;
            }
            else if ( (LA38_0==POLA_FALSE) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:167:28: value= POLA_TRUE
                    {
                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,POLA_TRUE,FOLLOW_POLA_TRUE_in_boolean_value1593); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_0, value_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaAst.g:167:47: value= POLA_FALSE
                    {
                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,POLA_FALSE,FOLLOW_POLA_FALSE_in_boolean_value1600); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_0, value_tree);


                    }
                    break;

            }

            this.pass.setLastCommonValue(value.token);

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
    // $ANTLR end "boolean_value"

    // Delegated rules


    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA36_eotS =
        "\13\uffff";
    static final String DFA36_eofS =
        "\13\uffff";
    static final String DFA36_minS =
        "\1\72\1\2\1\43\10\uffff";
    static final String DFA36_maxS =
        "\1\72\1\2\1\54\10\uffff";
    static final String DFA36_acceptS =
        "\3\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10";
    static final String DFA36_specialS =
        "\13\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\1\uffff\1\4\1\5\1\6\1\7\1\uffff\1\10\1\11\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "158:1: const_value : ( ^( AT_PROVIDES type= INTEGER value= VAL_INTEGER ) | ^( AT_PROVIDES type= OCTET value= VAL_OCT ) | ^( AT_PROVIDES type= HEX value= VAL_HEX ) | ^( AT_PROVIDES type= BINARY value= VAL_BINARY ) | ^( AT_PROVIDES type= FLOAT value= VAL_FLOAT ) | ^( AT_PROVIDES type= CHAR value= VAL_CHAR ) | ^( AT_PROVIDES type= STRING string_value ) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) );";
        }
    }
 

    public static final BitSet FOLLOW_set_in_a3dsStage0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_a3dsEnvironment0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_a3dsCLevel0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_SPEC_in_polaSpecification184 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_a3dsStage_in_polaSpecification186 = new BitSet(new long[]{0x0000000000000000L,0x000000000001C000L});
    public static final BitSet FOLLOW_a3dsEnvironment_in_polaSpecification188 = new BitSet(new long[]{0x0000000000000000L,0x00000000000E0000L});
    public static final BitSet FOLLOW_a3dsCLevel_in_polaSpecification190 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_AT_LANGUAGE_in_polaSpecification193 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_polaSpecification195 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_SPEC_in_polaSpecification199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_polaSpecification201 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cpp_directive_in_polaSpecification204 = new BitSet(new long[]{0x0000000000000C08L});
    public static final BitSet FOLLOW_polaDefinition_in_polaSpecification206 = new BitSet(new long[]{0x0000000000000C08L});
    public static final BitSet FOLLOW_managementPolicy_in_polaDefinition224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cpp_directive_in_polaDefinition228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CPP_DIRECTIVE_in_cpp_directive248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_POLICY_in_managementPolicy266 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_managementPolicy268 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_managementPolicyType_in_managementPolicy270 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_policyRuleStructure_in_managementPolicy272 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_deonticPolicy_in_managementPolicyType283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_managementMetaPolicy_in_managementPolicyType287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_deonticPolicy0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_managementMetaPolicy0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyContinuumLevel_in_policyRuleStructure346 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_ecaPolicyRule_in_policyRuleStructure350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalPolicyRule_in_policyRuleStructure354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_utilityFunctionPolicyRule_in_policyRuleStructure358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_PC_LEVEL_in_policyContinuumLevel369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_policyContinuumLevel371 = new BitSet(new long[]{0x0000000000000000L,0x0000000003060000L});
    public static final BitSet FOLLOW_81_in_policyContinuumLevel374 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_82_in_policyContinuumLevel378 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_88_in_policyContinuumLevel382 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_89_in_policyContinuumLevel386 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_policyContinuumLevel388 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_policyContinuumLevel391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_RULE_STRUCT_ECA_in_ecaPolicyRule411 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ecaPolicyRuleBody_in_ecaPolicyRule413 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_policyEventStructure_in_ecaPolicyRuleBody428 = new BitSet(new long[]{0x0000000018400002L});
    public static final BitSet FOLLOW_policyConditionStructure_in_ecaPolicyRuleBody431 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_policyActionStructure_in_ecaPolicyRuleBody434 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_POLA_RULE_STRUCT_GOAL_in_goalPolicyRule452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_RULE_STRUCT_UTIL_in_utilityFunctionPolicyRule459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventStructure_in_policyRuleComponentStructure469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionStructure_in_policyRuleComponentStructure473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionStructure_in_policyRuleComponentStructure477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_EVENT_in_policyEventStructure488 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyEventStructureBody_in_policyEventStructure490 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyEventGroup_in_policyEventStructureBody497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEvent_in_policyEventStructureBody501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_GROUP_in_policyEventGroup516 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_policyEventGroup518 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyEventGroupBody_in_policyEventGroup520 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyEventGroup_in_policyEventGroupBody532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEvent_in_policyEventGroupBody536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_in_policyEvent556 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyEventBody_in_policyEvent558 = new BitSet(new long[]{0x0000000007000008L});
    public static final BitSet FOLLOW_policyEventComposite_in_policyEventBody575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventAtomic_in_policyEventBody579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventNonStd_in_policyEventBody583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_COMPOSITE_in_policyEventComposite594 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyEventComposite596 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyEvent_in_policyEventComposite598 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_POLA_ATOMIC_in_policyEventAtomic613 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyEventAtomic615 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyEventAtomic617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_NONSTD_in_policyEventNonStd630 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyEventNonStd632 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyEventNonStd634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_CONDITION_in_policyConditionStructure645 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyConditionStructureBody_in_policyConditionStructure647 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyConditionGroup_in_policyConditionStructureBody654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyCondition_in_policyConditionStructureBody658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_GROUP_in_policyConditionGroup673 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_policyConditionGroup675 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyConditionGroupBody_in_policyConditionGroup677 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyConditionGroup_in_policyConditionGroupBody689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyCondition_in_policyConditionGroupBody693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_in_policyCondition713 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyConditionBody_in_policyCondition715 = new BitSet(new long[]{0x0000000007000008L});
    public static final BitSet FOLLOW_policyConditionComposite_in_policyConditionBody732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionAtomic_in_policyConditionBody736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionNonStd_in_policyConditionBody740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_COMPOSITE_in_policyConditionComposite751 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyConditionComposite753 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyCondition_in_policyConditionComposite755 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_POLA_ATOMIC_in_policyConditionAtomic770 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyConditionAtomic772 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyConditionAtomic774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_NONSTD_in_policyConditionNonStd787 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyConditionNonStd789 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyConditionNonStd791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_ACTION_in_policyActionStructure802 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyActionStructureBody_in_policyActionStructure804 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyActionGroup_in_policyActionStructureBody811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyAction_in_policyActionStructureBody815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_GROUP_in_policyActionGroup830 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_policyActionGroup832 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyActionGroupBody_in_policyActionGroup834 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyActionGroup_in_policyActionGroupBody846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyAction_in_policyActionGroupBody850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_in_policyAction870 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyActionBody_in_policyAction872 = new BitSet(new long[]{0x0000000007000008L});
    public static final BitSet FOLLOW_policyActionComposite_in_policyActionBody889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionAtomic_in_policyActionBody893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionNonStd_in_policyActionBody897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_COMPOSITE_in_policyActionComposite908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyActionComposite910 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyAction_in_policyActionComposite912 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_POLA_ATOMIC_in_policyActionAtomic927 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyActionAtomic929 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyActionAtomic931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_NONSTD_in_policyActionNonStd944 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyActionNonStd946 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyActionNonStd948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_SEQ_NUMER_in_policyECAInherited960 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VAL_INTEGER_in_policyECAInherited962 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POLA_HASBEEN_EVALED_in_policyECAInherited966 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolean_value_in_policyECAInherited968 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VAL_DSTRING_in_pola_string989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_SCOPE_in_scoped_name1010 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name1017 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_VOID_in_void_type1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_name_in_simple_type1064 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_base_type_in_simple_type1068 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_simple_type1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHORT_in_base_type1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_base_type1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_base_type1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTET_in_base_type1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_in_base_type1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINARY_in_base_type1126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_base_type1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_base_type1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_base_type1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_base_type1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_base_type1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1206 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_const_value1210 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_VAL_INTEGER_in_const_value1214 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OCTET_in_const_value1252 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_VAL_OCT_in_const_value1258 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1296 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_HEX_in_const_value1300 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_VAL_HEX_in_const_value1308 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1346 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BINARY_in_const_value1350 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_VAL_BINARY_in_const_value1355 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1390 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FLOAT_in_const_value1394 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_VAL_FLOAT_in_const_value1400 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1436 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_in_const_value1440 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_VAL_CHAR_in_const_value1447 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1484 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_const_value1488 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_string_value_in_const_value1491 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1529 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOLEAN_in_const_value1533 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_boolean_value_in_const_value1535 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VAL_STRING_in_string_value1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_NULL_in_string_value1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_TRUE_in_boolean_value1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_FALSE_in_boolean_value1600 = new BitSet(new long[]{0x0000000000000002L});

}