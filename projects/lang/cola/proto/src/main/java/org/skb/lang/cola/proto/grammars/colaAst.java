// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g 2011-07-07 22:24:40

  package org.skb.lang.cola.proto.grammars;

  import org.skb.util.languages.AtomList;
  import org.skb.lang.cola.proto.ColaPass2_Ast;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.cola.proto.ColaTokensConstants;
  import org.skb.util.ReportManager;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class colaAst extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FUNCTION", "IDENT", "AT_LANGUAGE", "PARAMETER", "AT_RETURN", "PROPERTY", "AT_TYPE", "AT_SCOPE", "AT_ALTERABLE", "AT_NEGOTIABLE", "AT_EXTENDS", "AT_REQUIRES", "AT_PRIORITY", "PACKAGE", "ELEMENT", "FACILITY", "ACTION", "ATTRIBUTE", "REQUIRED", "MANDATORY", "OPTIONAL", "NOT_DEF", "AT_APPLY", "PRE", "POST", "INV", "AT_VISIBILITY", "AT_SPEC", "AT_RUNTIME", "COLA_TRUE", "AT_DESCRIPTION", "CONTRACT", "ITEM", "AT_RANK", "AT_STAGE", "AT_ENVIRONMENT", "AT_CLEVEL", "CPP_DIRECTIVE", "AT_PROVIDES", "AT_CONTAINS", "TYPEDEF", "STRUCT", "VOID", "SHORT", "INTEGER", "LONG", "OCTET", "HEX", "BINARY", "FLOAT", "DOUBLE", "CHAR", "STRING", "BOOLEAN", "VAL_INTEGER", "VAL_OCT", "VAL_HEX", "VAL_BINARY", "VAL_FLOAT", "VAL_CHAR", "VAL_STRING", "COLA_NULL", "COLA_FALSE", "INLINE_CODE", "ARRAY", "MEMBER", "WS", "SL_COMMENT", "ML_COMMENT", "ESC", "UnicodeEscape", "OctalEscape", "HexDigit", "OctDigit", "BinDigit", "Exponent", "FloatSuffix", "CPP_FILENAME", "'architecture'", "'model'", "'design'", "'development'", "'deployment'", "'runtime'", "'production'", "'test'", "'demonstrator'", "'business'", "'system'", "':'", "'='", "'('", "')'", "';'", "'['", "']'", "','", "'-'", "'+'", "'{'", "'}'", "'::'"
    };
    public static final int EOF=-1;
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
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__99=99;
    public static final int T__100=100;
    public static final int T__101=101;
    public static final int T__102=102;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int FUNCTION=4;
    public static final int IDENT=5;
    public static final int AT_LANGUAGE=6;
    public static final int PARAMETER=7;
    public static final int AT_RETURN=8;
    public static final int PROPERTY=9;
    public static final int AT_TYPE=10;
    public static final int AT_SCOPE=11;
    public static final int AT_ALTERABLE=12;
    public static final int AT_NEGOTIABLE=13;
    public static final int AT_EXTENDS=14;
    public static final int AT_REQUIRES=15;
    public static final int AT_PRIORITY=16;
    public static final int PACKAGE=17;
    public static final int ELEMENT=18;
    public static final int FACILITY=19;
    public static final int ACTION=20;
    public static final int ATTRIBUTE=21;
    public static final int REQUIRED=22;
    public static final int MANDATORY=23;
    public static final int OPTIONAL=24;
    public static final int NOT_DEF=25;
    public static final int AT_APPLY=26;
    public static final int PRE=27;
    public static final int POST=28;
    public static final int INV=29;
    public static final int AT_VISIBILITY=30;
    public static final int AT_SPEC=31;
    public static final int AT_RUNTIME=32;
    public static final int COLA_TRUE=33;
    public static final int AT_DESCRIPTION=34;
    public static final int CONTRACT=35;
    public static final int ITEM=36;
    public static final int AT_RANK=37;
    public static final int AT_STAGE=38;
    public static final int AT_ENVIRONMENT=39;
    public static final int AT_CLEVEL=40;
    public static final int CPP_DIRECTIVE=41;
    public static final int AT_PROVIDES=42;
    public static final int AT_CONTAINS=43;
    public static final int TYPEDEF=44;
    public static final int STRUCT=45;
    public static final int VOID=46;
    public static final int SHORT=47;
    public static final int INTEGER=48;
    public static final int LONG=49;
    public static final int OCTET=50;
    public static final int HEX=51;
    public static final int BINARY=52;
    public static final int FLOAT=53;
    public static final int DOUBLE=54;
    public static final int CHAR=55;
    public static final int STRING=56;
    public static final int BOOLEAN=57;
    public static final int VAL_INTEGER=58;
    public static final int VAL_OCT=59;
    public static final int VAL_HEX=60;
    public static final int VAL_BINARY=61;
    public static final int VAL_FLOAT=62;
    public static final int VAL_CHAR=63;
    public static final int VAL_STRING=64;
    public static final int COLA_NULL=65;
    public static final int COLA_FALSE=66;
    public static final int INLINE_CODE=67;
    public static final int ARRAY=68;
    public static final int MEMBER=69;
    public static final int WS=70;
    public static final int SL_COMMENT=71;
    public static final int ML_COMMENT=72;
    public static final int ESC=73;
    public static final int UnicodeEscape=74;
    public static final int OctalEscape=75;
    public static final int HexDigit=76;
    public static final int OctDigit=77;
    public static final int BinDigit=78;
    public static final int Exponent=79;
    public static final int FloatSuffix=80;
    public static final int CPP_FILENAME=81;

    // delegates
    // delegators


        public colaAst(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public colaAst(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return colaAst.tokenNames; }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g"; }


      private LanguageTokens myTokens;
      private ColaPass2_Ast pass;

      public void init() {
        this.pass=new ColaPass2_Ast();
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:86:1: a3dsStage : ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' );
    public final colaAst.a3dsStage_return a3dsStage() throws RecognitionException {
        colaAst.a3dsStage_return retval = new colaAst.a3dsStage_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set1=null;

        CommonTree set1_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:86:25: ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set1=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=82 && input.LA(1)<=87) ) {
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:87:1: a3dsEnvironment : ( 'production' | 'test' | 'demonstrator' );
    public final colaAst.a3dsEnvironment_return a3dsEnvironment() throws RecognitionException {
        colaAst.a3dsEnvironment_return retval = new colaAst.a3dsEnvironment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set2=null;

        CommonTree set2_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:87:25: ( 'production' | 'test' | 'demonstrator' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set2=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=88 && input.LA(1)<=90) ) {
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:88:1: a3dsCLevel : ( 'business' | 'system' | 'element' );
    public final colaAst.a3dsCLevel_return a3dsCLevel() throws RecognitionException {
        colaAst.a3dsCLevel_return retval = new colaAst.a3dsCLevel_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set3=null;

        CommonTree set3_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:88:25: ( 'business' | 'system' | 'element' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set3=(CommonTree)input.LT(1);
            if ( input.LA(1)==ELEMENT||(input.LA(1)>=91 && input.LA(1)<=92) ) {
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

    public static class colaFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaFunction"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:90:1: colaFunction : ^( FUNCTION IDENT ( colaFunctionParam )* base_type ( ARRAY )? ^( AT_LANGUAGE string_value ) ) ;
    public final colaAst.colaFunction_return colaFunction() throws RecognitionException {
        colaAst.colaFunction_return retval = new colaAst.colaFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNCTION4=null;
        CommonTree IDENT5=null;
        CommonTree ARRAY8=null;
        CommonTree AT_LANGUAGE9=null;
        colaAst.colaFunctionParam_return colaFunctionParam6 = null;

        colaAst.base_type_return base_type7 = null;

        colaAst.string_value_return string_value10 = null;


        CommonTree FUNCTION4_tree=null;
        CommonTree IDENT5_tree=null;
        CommonTree ARRAY8_tree=null;
        CommonTree AT_LANGUAGE9_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:90:25: ( ^( FUNCTION IDENT ( colaFunctionParam )* base_type ( ARRAY )? ^( AT_LANGUAGE string_value ) ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:90:27: ^( FUNCTION IDENT ( colaFunctionParam )* base_type ( ARRAY )? ^( AT_LANGUAGE string_value ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION4=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_colaFunction167); 
            FUNCTION4_tree = (CommonTree)adaptor.dupNode(FUNCTION4);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION4_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaFunction169); 
            IDENT5_tree = (CommonTree)adaptor.dupNode(IDENT5);

            adaptor.addChild(root_1, IDENT5_tree);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:90:44: ( colaFunctionParam )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PARAMETER) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:90:44: colaFunctionParam
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaFunctionParam_in_colaFunction171);
            	    colaFunctionParam6=colaFunctionParam();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaFunctionParam6.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_base_type_in_colaFunction174);
            base_type7=base_type();

            state._fsp--;

            adaptor.addChild(root_1, base_type7.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:90:73: ( ARRAY )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ARRAY) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:90:73: ARRAY
                    {
                    _last = (CommonTree)input.LT(1);
                    ARRAY8=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_colaFunction176); 
                    ARRAY8_tree = (CommonTree)adaptor.dupNode(ARRAY8);

                    adaptor.addChild(root_1, ARRAY8_tree);


                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_LANGUAGE9=(CommonTree)match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_colaFunction180); 
            AT_LANGUAGE9_tree = (CommonTree)adaptor.dupNode(AT_LANGUAGE9);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_LANGUAGE9_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_string_value_in_colaFunction182);
            string_value10=string_value();

            state._fsp--;

            adaptor.addChild(root_2, string_value10.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
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
    // $ANTLR end "colaFunction"

    public static class colaFunctionParam_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaFunctionParam"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:91:1: colaFunctionParam : ^( PARAMETER base_type ( ARRAY )? IDENT ) ;
    public final colaAst.colaFunctionParam_return colaFunctionParam() throws RecognitionException {
        colaAst.colaFunctionParam_return retval = new colaAst.colaFunctionParam_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARAMETER11=null;
        CommonTree ARRAY13=null;
        CommonTree IDENT14=null;
        colaAst.base_type_return base_type12 = null;


        CommonTree PARAMETER11_tree=null;
        CommonTree ARRAY13_tree=null;
        CommonTree IDENT14_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:91:25: ( ^( PARAMETER base_type ( ARRAY )? IDENT ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:91:27: ^( PARAMETER base_type ( ARRAY )? IDENT )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PARAMETER11=(CommonTree)match(input,PARAMETER,FOLLOW_PARAMETER_in_colaFunctionParam198); 
            PARAMETER11_tree = (CommonTree)adaptor.dupNode(PARAMETER11);

            root_1 = (CommonTree)adaptor.becomeRoot(PARAMETER11_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_base_type_in_colaFunctionParam200);
            base_type12=base_type();

            state._fsp--;

            adaptor.addChild(root_1, base_type12.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:91:49: ( ARRAY )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ARRAY) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:91:49: ARRAY
                    {
                    _last = (CommonTree)input.LT(1);
                    ARRAY13=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_colaFunctionParam202); 
                    ARRAY13_tree = (CommonTree)adaptor.dupNode(ARRAY13);

                    adaptor.addChild(root_1, ARRAY13_tree);


                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            IDENT14=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaFunctionParam205); 
            IDENT14_tree = (CommonTree)adaptor.dupNode(IDENT14);

            adaptor.addChild(root_1, IDENT14_tree);


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
    // $ANTLR end "colaFunctionParam"

    public static class colaPropertyDecl_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaPropertyDecl"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:93:1: colaPropertyDecl : ^( PROPERTY s= IDENT ^( AT_TYPE base_type const_value ( ARRAY )? ) ^( AT_SCOPE ( propertyScope )* ) ^( AT_APPLY ( ^( PRE ( scoped_name )* ) )? ( ^( POST ( scoped_name )* ) )? ( ^( INV ( scoped_name )* ) )? ) ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( aExtends )? ( aRequires )? ( ^( AT_PRIORITY base_type const_value ) )? ) ;
    public final colaAst.colaPropertyDecl_return colaPropertyDecl() throws RecognitionException {
        colaAst.colaPropertyDecl_return retval = new colaAst.colaPropertyDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree PROPERTY15=null;
        CommonTree AT_TYPE16=null;
        CommonTree ARRAY19=null;
        CommonTree AT_SCOPE20=null;
        CommonTree AT_APPLY22=null;
        CommonTree PRE23=null;
        CommonTree POST25=null;
        CommonTree INV27=null;
        CommonTree AT_ALTERABLE30=null;
        CommonTree AT_NEGOTIABLE31=null;
        CommonTree AT_PRIORITY35=null;
        colaAst.base_type_return base_type17 = null;

        colaAst.const_value_return const_value18 = null;

        colaAst.propertyScope_return propertyScope21 = null;

        colaAst.scoped_name_return scoped_name24 = null;

        colaAst.scoped_name_return scoped_name26 = null;

        colaAst.scoped_name_return scoped_name28 = null;

        colaAst.atVisibility_return atVisibility29 = null;

        colaAst.atDescription_return atDescription32 = null;

        colaAst.aExtends_return aExtends33 = null;

        colaAst.aRequires_return aRequires34 = null;

        colaAst.base_type_return base_type36 = null;

        colaAst.const_value_return const_value37 = null;


        CommonTree s_tree=null;
        CommonTree PROPERTY15_tree=null;
        CommonTree AT_TYPE16_tree=null;
        CommonTree ARRAY19_tree=null;
        CommonTree AT_SCOPE20_tree=null;
        CommonTree AT_APPLY22_tree=null;
        CommonTree PRE23_tree=null;
        CommonTree POST25_tree=null;
        CommonTree INV27_tree=null;
        CommonTree AT_ALTERABLE30_tree=null;
        CommonTree AT_NEGOTIABLE31_tree=null;
        CommonTree AT_PRIORITY35_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:93:25: ( ^( PROPERTY s= IDENT ^( AT_TYPE base_type const_value ( ARRAY )? ) ^( AT_SCOPE ( propertyScope )* ) ^( AT_APPLY ( ^( PRE ( scoped_name )* ) )? ( ^( POST ( scoped_name )* ) )? ( ^( INV ( scoped_name )* ) )? ) ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( aExtends )? ( aRequires )? ( ^( AT_PRIORITY base_type const_value ) )? ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:93:27: ^( PROPERTY s= IDENT ^( AT_TYPE base_type const_value ( ARRAY )? ) ^( AT_SCOPE ( propertyScope )* ) ^( AT_APPLY ( ^( PRE ( scoped_name )* ) )? ( ^( POST ( scoped_name )* ) )? ( ^( INV ( scoped_name )* ) )? ) ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( aExtends )? ( aRequires )? ( ^( AT_PRIORITY base_type const_value ) )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PROPERTY15=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_colaPropertyDecl222); 
            PROPERTY15_tree = (CommonTree)adaptor.dupNode(PROPERTY15);

            root_1 = (CommonTree)adaptor.becomeRoot(PROPERTY15_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaPropertyDecl226); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_TYPE16=(CommonTree)match(input,AT_TYPE,FOLLOW_AT_TYPE_in_colaPropertyDecl229); 
            AT_TYPE16_tree = (CommonTree)adaptor.dupNode(AT_TYPE16);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_TYPE16_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_base_type_in_colaPropertyDecl231);
            base_type17=base_type();

            state._fsp--;

            adaptor.addChild(root_2, base_type17.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_value_in_colaPropertyDecl233);
            const_value18=const_value();

            state._fsp--;

            adaptor.addChild(root_2, const_value18.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:93:78: ( ARRAY )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ARRAY) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:93:78: ARRAY
                    {
                    _last = (CommonTree)input.LT(1);
                    ARRAY19=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_colaPropertyDecl235); 
                    ARRAY19_tree = (CommonTree)adaptor.dupNode(ARRAY19);

                    adaptor.addChild(root_2, ARRAY19_tree);


                    }
                    break;

            }


            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            this.pass.atoms.scope.push(s.token);
            this.pass.testBaseTypeWithConstValue(ColaTokensConstants.colaPROPERTY);
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_SCOPE20=(CommonTree)match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_colaPropertyDecl328); 
            AT_SCOPE20_tree = (CommonTree)adaptor.dupNode(AT_SCOPE20);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_SCOPE20_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:96:40: ( propertyScope )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==PARAMETER||(LA5_0>=PACKAGE && LA5_0<=ATTRIBUTE)) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:96:40: propertyScope
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_propertyScope_in_colaPropertyDecl330);
                	    propertyScope21=propertyScope();

                	    state._fsp--;

                	    adaptor.addChild(root_2, propertyScope21.getTree());

                	    }
                	    break;

                	default :
                	    break loop5;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_APPLY22=(CommonTree)match(input,AT_APPLY,FOLLOW_AT_APPLY_in_colaPropertyDecl363); 
            AT_APPLY22_tree = (CommonTree)adaptor.dupNode(AT_APPLY22);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_APPLY22_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:40: ( ^( PRE ( scoped_name )* ) )?
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==PRE) ) {
                    alt7=1;
                }
                switch (alt7) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:41: ^( PRE ( scoped_name )* )
                        {
                        _last = (CommonTree)input.LT(1);
                        {
                        CommonTree _save_last_3 = _last;
                        CommonTree _first_3 = null;
                        CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                        PRE23=(CommonTree)match(input,PRE,FOLLOW_PRE_in_colaPropertyDecl367); 
                        PRE23_tree = (CommonTree)adaptor.dupNode(PRE23);

                        root_3 = (CommonTree)adaptor.becomeRoot(PRE23_tree, root_3);



                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:47: ( scoped_name )*
                            loop6:
                            do {
                                int alt6=2;
                                int LA6_0 = input.LA(1);

                                if ( (LA6_0==AT_SCOPE) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:48: scoped_name
                            	    {
                            	    _last = (CommonTree)input.LT(1);
                            	    pushFollow(FOLLOW_scoped_name_in_colaPropertyDecl370);
                            	    scoped_name24=scoped_name();

                            	    state._fsp--;

                            	    adaptor.addChild(root_3, scoped_name24.getTree());
                            	    this.pass.testSN(ColaTokensConstants.colaFUNCTION, null);

                            	    }
                            	    break;

                            	default :
                            	    break loop6;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }adaptor.addChild(root_2, root_3);_last = _save_last_3;
                        }


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:125: ( ^( POST ( scoped_name )* ) )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==POST) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:126: ^( POST ( scoped_name )* )
                        {
                        _last = (CommonTree)input.LT(1);
                        {
                        CommonTree _save_last_3 = _last;
                        CommonTree _first_3 = null;
                        CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                        POST25=(CommonTree)match(input,POST,FOLLOW_POST_in_colaPropertyDecl381); 
                        POST25_tree = (CommonTree)adaptor.dupNode(POST25);

                        root_3 = (CommonTree)adaptor.becomeRoot(POST25_tree, root_3);



                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:133: ( scoped_name )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==AT_SCOPE) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:134: scoped_name
                            	    {
                            	    _last = (CommonTree)input.LT(1);
                            	    pushFollow(FOLLOW_scoped_name_in_colaPropertyDecl384);
                            	    scoped_name26=scoped_name();

                            	    state._fsp--;

                            	    adaptor.addChild(root_3, scoped_name26.getTree());
                            	    this.pass.testSN(ColaTokensConstants.colaFUNCTION, null);

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }adaptor.addChild(root_2, root_3);_last = _save_last_3;
                        }


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:211: ( ^( INV ( scoped_name )* ) )?
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==INV) ) {
                    alt11=1;
                }
                switch (alt11) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:212: ^( INV ( scoped_name )* )
                        {
                        _last = (CommonTree)input.LT(1);
                        {
                        CommonTree _save_last_3 = _last;
                        CommonTree _first_3 = null;
                        CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                        INV27=(CommonTree)match(input,INV,FOLLOW_INV_in_colaPropertyDecl395); 
                        INV27_tree = (CommonTree)adaptor.dupNode(INV27);

                        root_3 = (CommonTree)adaptor.becomeRoot(INV27_tree, root_3);



                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:218: ( scoped_name )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==AT_SCOPE) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:97:219: scoped_name
                            	    {
                            	    _last = (CommonTree)input.LT(1);
                            	    pushFollow(FOLLOW_scoped_name_in_colaPropertyDecl398);
                            	    scoped_name28=scoped_name();

                            	    state._fsp--;

                            	    adaptor.addChild(root_3, scoped_name28.getTree());
                            	    this.pass.testSN(ColaTokensConstants.colaFUNCTION, null);

                            	    }
                            	    break;

                            	default :
                            	    break loop10;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }adaptor.addChild(root_2, root_3);_last = _save_last_3;
                        }


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:98:29: ( atVisibility )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==AT_VISIBILITY) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:98:29: atVisibility
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atVisibility_in_colaPropertyDecl437);
                    atVisibility29=atVisibility();

                    state._fsp--;

                    adaptor.addChild(root_1, atVisibility29.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:98:43: ( AT_ALTERABLE )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==AT_ALTERABLE) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:98:43: AT_ALTERABLE
                    {
                    _last = (CommonTree)input.LT(1);
                    AT_ALTERABLE30=(CommonTree)match(input,AT_ALTERABLE,FOLLOW_AT_ALTERABLE_in_colaPropertyDecl440); 
                    AT_ALTERABLE30_tree = (CommonTree)adaptor.dupNode(AT_ALTERABLE30);

                    adaptor.addChild(root_1, AT_ALTERABLE30_tree);


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:98:57: ( AT_NEGOTIABLE )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==AT_NEGOTIABLE) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:98:57: AT_NEGOTIABLE
                    {
                    _last = (CommonTree)input.LT(1);
                    AT_NEGOTIABLE31=(CommonTree)match(input,AT_NEGOTIABLE,FOLLOW_AT_NEGOTIABLE_in_colaPropertyDecl443); 
                    AT_NEGOTIABLE31_tree = (CommonTree)adaptor.dupNode(AT_NEGOTIABLE31);

                    adaptor.addChild(root_1, AT_NEGOTIABLE31_tree);


                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_atDescription_in_colaPropertyDecl446);
            atDescription32=atDescription();

            state._fsp--;

            adaptor.addChild(root_1, atDescription32.getTree());
            this.pass.eprStart(ColaTokensConstants.colaPROPERTY);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:99:85: ( aExtends )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==AT_EXTENDS) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:99:85: aExtends
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_aExtends_in_colaPropertyDecl478);
                    aExtends33=aExtends();

                    state._fsp--;

                    adaptor.addChild(root_1, aExtends33.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:99:95: ( aRequires )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==AT_REQUIRES) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:99:95: aRequires
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_aRequires_in_colaPropertyDecl481);
                    aRequires34=aRequires();

                    state._fsp--;

                    adaptor.addChild(root_1, aRequires34.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:100:29: ( ^( AT_PRIORITY base_type const_value ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==AT_PRIORITY) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:100:30: ^( AT_PRIORITY base_type const_value )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PRIORITY35=(CommonTree)match(input,AT_PRIORITY,FOLLOW_AT_PRIORITY_in_colaPropertyDecl514); 
                    AT_PRIORITY35_tree = (CommonTree)adaptor.dupNode(AT_PRIORITY35);

                    root_2 = (CommonTree)adaptor.becomeRoot(AT_PRIORITY35_tree, root_2);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_base_type_in_colaPropertyDecl516);
                    base_type36=base_type();

                    state._fsp--;

                    adaptor.addChild(root_2, base_type36.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_value_in_colaPropertyDecl518);
                    const_value37=const_value();

                    state._fsp--;

                    adaptor.addChild(root_2, const_value37.getTree());
                    this.pass.testBaseTypeWithConstValue(ColaTokensConstants.colaAT_PRIORITY);

                    match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
                    }


                    }
                    break;

            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "colaPropertyDecl"

    public static class propertyScope_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyScope"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:103:1: propertyScope : ^( propertyScopeAtom propertyScopeRank ) ;
    public final colaAst.propertyScope_return propertyScope() throws RecognitionException {
        colaAst.propertyScope_return retval = new colaAst.propertyScope_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        colaAst.propertyScopeAtom_return propertyScopeAtom38 = null;

        colaAst.propertyScopeRank_return propertyScopeRank39 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:103:25: ( ^( propertyScopeAtom propertyScopeRank ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:103:27: ^( propertyScopeAtom propertyScopeRank )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_propertyScopeAtom_in_propertyScope597);
            propertyScopeAtom38=propertyScopeAtom();

            state._fsp--;

            root_1 = (CommonTree)adaptor.becomeRoot(propertyScopeAtom38.getTree(), root_1);


            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_propertyScopeRank_in_propertyScope599);
            propertyScopeRank39=propertyScopeRank();

            state._fsp--;

            adaptor.addChild(root_1, propertyScopeRank39.getTree());

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
    // $ANTLR end "propertyScope"

    public static class propertyScopeAtom_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyScopeAtom"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:104:1: propertyScopeAtom : ( PACKAGE | ELEMENT | FACILITY | ACTION | ATTRIBUTE | PARAMETER );
    public final colaAst.propertyScopeAtom_return propertyScopeAtom() throws RecognitionException {
        colaAst.propertyScopeAtom_return retval = new colaAst.propertyScopeAtom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set40=null;

        CommonTree set40_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:104:25: ( PACKAGE | ELEMENT | FACILITY | ACTION | ATTRIBUTE | PARAMETER )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set40=(CommonTree)input.LT(1);
            if ( input.LA(1)==PARAMETER||(input.LA(1)>=PACKAGE && input.LA(1)<=ATTRIBUTE) ) {
                input.consume();

                set40_tree = (CommonTree)adaptor.dupNode(set40);

                adaptor.addChild(root_0, set40_tree);

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
    // $ANTLR end "propertyScopeAtom"

    public static class propertyScopeRank_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyScopeRank"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:105:1: propertyScopeRank : ( REQUIRED | MANDATORY | OPTIONAL | NOT_DEF );
    public final colaAst.propertyScopeRank_return propertyScopeRank() throws RecognitionException {
        colaAst.propertyScopeRank_return retval = new colaAst.propertyScopeRank_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set41=null;

        CommonTree set41_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:105:25: ( REQUIRED | MANDATORY | OPTIONAL | NOT_DEF )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set41=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=REQUIRED && input.LA(1)<=NOT_DEF) ) {
                input.consume();

                set41_tree = (CommonTree)adaptor.dupNode(set41);

                adaptor.addChild(root_0, set41_tree);

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
    // $ANTLR end "propertyScopeRank"

    public static class aExtends_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "aExtends"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:106:1: aExtends : ^( AT_EXTENDS ( scoped_name )* ) ;
    public final colaAst.aExtends_return aExtends() throws RecognitionException {
        colaAst.aExtends_return retval = new colaAst.aExtends_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_EXTENDS42=null;
        colaAst.scoped_name_return scoped_name43 = null;


        CommonTree AT_EXTENDS42_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:106:25: ( ^( AT_EXTENDS ( scoped_name )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:106:27: ^( AT_EXTENDS ( scoped_name )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_EXTENDS42=(CommonTree)match(input,AT_EXTENDS,FOLLOW_AT_EXTENDS_in_aExtends681); 
            AT_EXTENDS42_tree = (CommonTree)adaptor.dupNode(AT_EXTENDS42);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_EXTENDS42_tree, root_1);


            this.pass.eprCategory(ColaTokensConstants.colaAT_EXTENDS);

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:106:103: ( scoped_name )*
                loop18:
                do {
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==AT_SCOPE) ) {
                        alt18=1;
                    }


                    switch (alt18) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:106:104: scoped_name
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_scoped_name_in_aExtends688);
                	    scoped_name43=scoped_name();

                	    state._fsp--;

                	    adaptor.addChild(root_1, scoped_name43.getTree());
                	    this.pass.eprAdd((scoped_name43!=null?(input.getTokenStream().toString(
                	      input.getTreeAdaptor().getTokenStartIndex(scoped_name43.start),
                	      input.getTreeAdaptor().getTokenStopIndex(scoped_name43.start))):null));

                	    }
                	    break;

                	default :
                	    break loop18;
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
    // $ANTLR end "aExtends"

    public static class aProvides_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "aProvides"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:107:1: aProvides : ^( AT_PROVIDES ( scoped_name )* ) ;
    public final colaAst.aProvides_return aProvides() throws RecognitionException {
        colaAst.aProvides_return retval = new colaAst.aProvides_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_PROVIDES44=null;
        colaAst.scoped_name_return scoped_name45 = null;


        CommonTree AT_PROVIDES44_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:107:25: ( ^( AT_PROVIDES ( scoped_name )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:107:27: ^( AT_PROVIDES ( scoped_name )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_PROVIDES44=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_aProvides715); 
            AT_PROVIDES44_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES44);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES44_tree, root_1);


            this.pass.eprCategory(ColaTokensConstants.colaAT_PROVIDES);

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:107:103: ( scoped_name )*
                loop19:
                do {
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==AT_SCOPE) ) {
                        alt19=1;
                    }


                    switch (alt19) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:107:104: scoped_name
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_scoped_name_in_aProvides720);
                	    scoped_name45=scoped_name();

                	    state._fsp--;

                	    adaptor.addChild(root_1, scoped_name45.getTree());
                	    this.pass.eprAdd((scoped_name45!=null?(input.getTokenStream().toString(
                	      input.getTreeAdaptor().getTokenStartIndex(scoped_name45.start),
                	      input.getTreeAdaptor().getTokenStopIndex(scoped_name45.start))):null));

                	    }
                	    break;

                	default :
                	    break loop19;
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
    // $ANTLR end "aProvides"

    public static class aRequires_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "aRequires"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:108:1: aRequires : ^( AT_REQUIRES ( scoped_name )* ) ;
    public final colaAst.aRequires_return aRequires() throws RecognitionException {
        colaAst.aRequires_return retval = new colaAst.aRequires_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_REQUIRES46=null;
        colaAst.scoped_name_return scoped_name47 = null;


        CommonTree AT_REQUIRES46_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:108:25: ( ^( AT_REQUIRES ( scoped_name )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:108:27: ^( AT_REQUIRES ( scoped_name )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_REQUIRES46=(CommonTree)match(input,AT_REQUIRES,FOLLOW_AT_REQUIRES_in_aRequires747); 
            AT_REQUIRES46_tree = (CommonTree)adaptor.dupNode(AT_REQUIRES46);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_REQUIRES46_tree, root_1);


            this.pass.eprCategory(ColaTokensConstants.colaAT_REQUIRES);

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:108:103: ( scoped_name )*
                loop20:
                do {
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==AT_SCOPE) ) {
                        alt20=1;
                    }


                    switch (alt20) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:108:104: scoped_name
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_scoped_name_in_aRequires752);
                	    scoped_name47=scoped_name();

                	    state._fsp--;

                	    adaptor.addChild(root_1, scoped_name47.getTree());
                	    this.pass.eprAdd((scoped_name47!=null?(input.getTokenStream().toString(
                	      input.getTreeAdaptor().getTokenStartIndex(scoped_name47.start),
                	      input.getTreeAdaptor().getTokenStopIndex(scoped_name47.start))):null));

                	    }
                	    break;

                	default :
                	    break loop20;
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
    // $ANTLR end "aRequires"

    public static class atVisibility_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atVisibility"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:110:1: atVisibility : ^( AT_VISIBILITY ^( AT_SPEC atVisibilityData ) ^( AT_RUNTIME atVisibilityData ) ) ;
    public final colaAst.atVisibility_return atVisibility() throws RecognitionException {
        colaAst.atVisibility_return retval = new colaAst.atVisibility_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_VISIBILITY48=null;
        CommonTree AT_SPEC49=null;
        CommonTree AT_RUNTIME51=null;
        colaAst.atVisibilityData_return atVisibilityData50 = null;

        colaAst.atVisibilityData_return atVisibilityData52 = null;


        CommonTree AT_VISIBILITY48_tree=null;
        CommonTree AT_SPEC49_tree=null;
        CommonTree AT_RUNTIME51_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:110:25: ( ^( AT_VISIBILITY ^( AT_SPEC atVisibilityData ) ^( AT_RUNTIME atVisibilityData ) ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:110:27: ^( AT_VISIBILITY ^( AT_SPEC atVisibilityData ) ^( AT_RUNTIME atVisibilityData ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_VISIBILITY48=(CommonTree)match(input,AT_VISIBILITY,FOLLOW_AT_VISIBILITY_in_atVisibility777); 
            AT_VISIBILITY48_tree = (CommonTree)adaptor.dupNode(AT_VISIBILITY48);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_VISIBILITY48_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_SPEC49=(CommonTree)match(input,AT_SPEC,FOLLOW_AT_SPEC_in_atVisibility780); 
            AT_SPEC49_tree = (CommonTree)adaptor.dupNode(AT_SPEC49);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_SPEC49_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_atVisibilityData_in_atVisibility782);
            atVisibilityData50=atVisibilityData();

            state._fsp--;

            adaptor.addChild(root_2, atVisibilityData50.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_RUNTIME51=(CommonTree)match(input,AT_RUNTIME,FOLLOW_AT_RUNTIME_in_atVisibility786); 
            AT_RUNTIME51_tree = (CommonTree)adaptor.dupNode(AT_RUNTIME51);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_RUNTIME51_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_atVisibilityData_in_atVisibility788);
            atVisibilityData52=atVisibilityData();

            state._fsp--;

            adaptor.addChild(root_2, atVisibilityData52.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
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
    // $ANTLR end "atVisibility"

    public static class atVisibilityData_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atVisibilityData"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:111:1: atVisibilityData : '(' ( ( IDENT )? '-' string_value ( ',' string_value )* )? ';' ( COLA_TRUE )? ';' ( ( IDENT )? '+' string_value ( ',' string_value )* )? ')' ;
    public final colaAst.atVisibilityData_return atVisibilityData() throws RecognitionException {
        colaAst.atVisibilityData_return retval = new colaAst.atVisibilityData_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal53=null;
        CommonTree IDENT54=null;
        CommonTree char_literal55=null;
        CommonTree char_literal57=null;
        CommonTree char_literal59=null;
        CommonTree COLA_TRUE60=null;
        CommonTree char_literal61=null;
        CommonTree IDENT62=null;
        CommonTree char_literal63=null;
        CommonTree char_literal65=null;
        CommonTree char_literal67=null;
        colaAst.string_value_return string_value56 = null;

        colaAst.string_value_return string_value58 = null;

        colaAst.string_value_return string_value64 = null;

        colaAst.string_value_return string_value66 = null;


        CommonTree char_literal53_tree=null;
        CommonTree IDENT54_tree=null;
        CommonTree char_literal55_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree char_literal59_tree=null;
        CommonTree COLA_TRUE60_tree=null;
        CommonTree char_literal61_tree=null;
        CommonTree IDENT62_tree=null;
        CommonTree char_literal63_tree=null;
        CommonTree char_literal65_tree=null;
        CommonTree char_literal67_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:111:25: ( '(' ( ( IDENT )? '-' string_value ( ',' string_value )* )? ';' ( COLA_TRUE )? ';' ( ( IDENT )? '+' string_value ( ',' string_value )* )? ')' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:111:27: '(' ( ( IDENT )? '-' string_value ( ',' string_value )* )? ';' ( COLA_TRUE )? ';' ( ( IDENT )? '+' string_value ( ',' string_value )* )? ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal53=(CommonTree)match(input,95,FOLLOW_95_in_atVisibilityData804); 
            char_literal53_tree = (CommonTree)adaptor.dupNode(char_literal53);

            adaptor.addChild(root_0, char_literal53_tree);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:112:27: ( ( IDENT )? '-' string_value ( ',' string_value )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==IDENT||LA23_0==101) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:112:28: ( IDENT )? '-' string_value ( ',' string_value )*
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:112:28: ( IDENT )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==IDENT) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:112:28: IDENT
                            {
                            _last = (CommonTree)input.LT(1);
                            IDENT54=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_atVisibilityData834); 
                            IDENT54_tree = (CommonTree)adaptor.dupNode(IDENT54);

                            adaptor.addChild(root_0, IDENT54_tree);


                            }
                            break;

                    }

                    _last = (CommonTree)input.LT(1);
                    char_literal55=(CommonTree)match(input,101,FOLLOW_101_in_atVisibilityData837); 
                    char_literal55_tree = (CommonTree)adaptor.dupNode(char_literal55);

                    adaptor.addChild(root_0, char_literal55_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_string_value_in_atVisibilityData839);
                    string_value56=string_value();

                    state._fsp--;

                    adaptor.addChild(root_0, string_value56.getTree());
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:112:52: ( ',' string_value )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==100) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:112:53: ',' string_value
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal57=(CommonTree)match(input,100,FOLLOW_100_in_atVisibilityData842); 
                    	    char_literal57_tree = (CommonTree)adaptor.dupNode(char_literal57);

                    	    adaptor.addChild(root_0, char_literal57_tree);

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_string_value_in_atVisibilityData844);
                    	    string_value58=string_value();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, string_value58.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            char_literal59=(CommonTree)match(input,97,FOLLOW_97_in_atVisibilityData850); 
            char_literal59_tree = (CommonTree)adaptor.dupNode(char_literal59);

            adaptor.addChild(root_0, char_literal59_tree);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:113:27: ( COLA_TRUE )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==COLA_TRUE) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:113:27: COLA_TRUE
                    {
                    _last = (CommonTree)input.LT(1);
                    COLA_TRUE60=(CommonTree)match(input,COLA_TRUE,FOLLOW_COLA_TRUE_in_atVisibilityData878); 
                    COLA_TRUE60_tree = (CommonTree)adaptor.dupNode(COLA_TRUE60);

                    adaptor.addChild(root_0, COLA_TRUE60_tree);


                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            char_literal61=(CommonTree)match(input,97,FOLLOW_97_in_atVisibilityData881); 
            char_literal61_tree = (CommonTree)adaptor.dupNode(char_literal61);

            adaptor.addChild(root_0, char_literal61_tree);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:114:27: ( ( IDENT )? '+' string_value ( ',' string_value )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==IDENT||LA27_0==102) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:114:28: ( IDENT )? '+' string_value ( ',' string_value )*
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:114:28: ( IDENT )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==IDENT) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:114:28: IDENT
                            {
                            _last = (CommonTree)input.LT(1);
                            IDENT62=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_atVisibilityData910); 
                            IDENT62_tree = (CommonTree)adaptor.dupNode(IDENT62);

                            adaptor.addChild(root_0, IDENT62_tree);


                            }
                            break;

                    }

                    _last = (CommonTree)input.LT(1);
                    char_literal63=(CommonTree)match(input,102,FOLLOW_102_in_atVisibilityData913); 
                    char_literal63_tree = (CommonTree)adaptor.dupNode(char_literal63);

                    adaptor.addChild(root_0, char_literal63_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_string_value_in_atVisibilityData915);
                    string_value64=string_value();

                    state._fsp--;

                    adaptor.addChild(root_0, string_value64.getTree());
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:114:52: ( ',' string_value )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==100) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:114:53: ',' string_value
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal65=(CommonTree)match(input,100,FOLLOW_100_in_atVisibilityData918); 
                    	    char_literal65_tree = (CommonTree)adaptor.dupNode(char_literal65);

                    	    adaptor.addChild(root_0, char_literal65_tree);

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_string_value_in_atVisibilityData920);
                    	    string_value66=string_value();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, string_value66.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            char_literal67=(CommonTree)match(input,96,FOLLOW_96_in_atVisibilityData952); 
            char_literal67_tree = (CommonTree)adaptor.dupNode(char_literal67);

            adaptor.addChild(root_0, char_literal67_tree);


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
    // $ANTLR end "atVisibilityData"

    public static class atDescription_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atDescription"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:118:1: atDescription : ^( AT_DESCRIPTION string_value ) ;
    public final colaAst.atDescription_return atDescription() throws RecognitionException {
        colaAst.atDescription_return retval = new colaAst.atDescription_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_DESCRIPTION68=null;
        colaAst.string_value_return string_value69 = null;


        CommonTree AT_DESCRIPTION68_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:118:25: ( ^( AT_DESCRIPTION string_value ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:118:27: ^( AT_DESCRIPTION string_value )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_DESCRIPTION68=(CommonTree)match(input,AT_DESCRIPTION,FOLLOW_AT_DESCRIPTION_in_atDescription998); 
            AT_DESCRIPTION68_tree = (CommonTree)adaptor.dupNode(AT_DESCRIPTION68);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_DESCRIPTION68_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_string_value_in_atDescription1000);
            string_value69=string_value();

            state._fsp--;

            adaptor.addChild(root_1, string_value69.getTree());
            this.pass.testPropDeclDescription();

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
    // $ANTLR end "atDescription"

    public static class colaPropertyDef_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaPropertyDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:120:1: colaPropertyDef : ^( PROPERTY IDENT scoped_name ( const_value )* ) ;
    public final colaAst.colaPropertyDef_return colaPropertyDef() throws RecognitionException {
        colaAst.colaPropertyDef_return retval = new colaAst.colaPropertyDef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PROPERTY70=null;
        CommonTree IDENT71=null;
        colaAst.scoped_name_return scoped_name72 = null;

        colaAst.const_value_return const_value73 = null;


        CommonTree PROPERTY70_tree=null;
        CommonTree IDENT71_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:120:25: ( ^( PROPERTY IDENT scoped_name ( const_value )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:120:27: ^( PROPERTY IDENT scoped_name ( const_value )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PROPERTY70=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_colaPropertyDef1020); 
            PROPERTY70_tree = (CommonTree)adaptor.dupNode(PROPERTY70);

            root_1 = (CommonTree)adaptor.becomeRoot(PROPERTY70_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT71=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaPropertyDef1022); 
            IDENT71_tree = (CommonTree)adaptor.dupNode(IDENT71);

            adaptor.addChild(root_1, IDENT71_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scoped_name_in_colaPropertyDef1024);
            scoped_name72=scoped_name();

            state._fsp--;

            adaptor.addChild(root_1, scoped_name72.getTree());
            this.pass.propDef(); this.pass.propDefValueStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:121:27: ( const_value )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==AT_PROVIDES) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:121:28: const_value
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_const_value_in_colaPropertyDef1055);
            	    const_value73=const_value();

            	    state._fsp--;

            	    adaptor.addChild(root_1, const_value73.getTree());
            	    this.pass.propDefValueTest();

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.propDefFinish();

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
    // $ANTLR end "colaPropertyDef"

    public static class colaContractDecl_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaContractDecl"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:123:1: colaContractDecl : ^( CONTRACT s= IDENT ^( AT_SCOPE ( contractScope )* ) ( atVisibility )? atDescription ( contractItem )* ) ;
    public final colaAst.colaContractDecl_return colaContractDecl() throws RecognitionException {
        colaAst.colaContractDecl_return retval = new colaAst.colaContractDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree CONTRACT74=null;
        CommonTree AT_SCOPE75=null;
        colaAst.contractScope_return contractScope76 = null;

        colaAst.atVisibility_return atVisibility77 = null;

        colaAst.atDescription_return atDescription78 = null;

        colaAst.contractItem_return contractItem79 = null;


        CommonTree s_tree=null;
        CommonTree CONTRACT74_tree=null;
        CommonTree AT_SCOPE75_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:123:25: ( ^( CONTRACT s= IDENT ^( AT_SCOPE ( contractScope )* ) ( atVisibility )? atDescription ( contractItem )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:123:27: ^( CONTRACT s= IDENT ^( AT_SCOPE ( contractScope )* ) ( atVisibility )? atDescription ( contractItem )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            CONTRACT74=(CommonTree)match(input,CONTRACT,FOLLOW_CONTRACT_in_colaContractDecl1078); 
            CONTRACT74_tree = (CommonTree)adaptor.dupNode(CONTRACT74);

            root_1 = (CommonTree)adaptor.becomeRoot(CONTRACT74_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaContractDecl1082); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_SCOPE75=(CommonTree)match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_colaContractDecl1087); 
            AT_SCOPE75_tree = (CommonTree)adaptor.dupNode(AT_SCOPE75);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_SCOPE75_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:123:96: ( contractScope )*
                loop29:
                do {
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=ELEMENT && LA29_0<=FACILITY)) ) {
                        alt29=1;
                    }


                    switch (alt29) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:123:96: contractScope
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_contractScope_in_colaContractDecl1089);
                	    contractScope76=contractScope();

                	    state._fsp--;

                	    adaptor.addChild(root_2, contractScope76.getTree());

                	    }
                	    break;

                	default :
                	    break loop29;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:123:112: ( atVisibility )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==AT_VISIBILITY) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:123:112: atVisibility
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atVisibility_in_colaContractDecl1093);
                    atVisibility77=atVisibility();

                    state._fsp--;

                    adaptor.addChild(root_1, atVisibility77.getTree());

                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_atDescription_in_colaContractDecl1096);
            atDescription78=atDescription();

            state._fsp--;

            adaptor.addChild(root_1, atDescription78.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:124:27: ( contractItem )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==ITEM) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:124:27: contractItem
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_contractItem_in_colaContractDecl1124);
            	    contractItem79=contractItem();

            	    state._fsp--;

            	    adaptor.addChild(root_1, contractItem79.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "colaContractDecl"

    public static class contractScope_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractScope"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:125:1: contractScope : contractScopeAtom contractScopeRank ;
    public final colaAst.contractScope_return contractScope() throws RecognitionException {
        colaAst.contractScope_return retval = new colaAst.contractScope_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        colaAst.contractScopeAtom_return contractScopeAtom80 = null;

        colaAst.contractScopeRank_return contractScopeRank81 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:125:25: ( contractScopeAtom contractScopeRank )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:125:27: contractScopeAtom contractScopeRank
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_contractScopeAtom_in_contractScope1145);
            contractScopeAtom80=contractScopeAtom();

            state._fsp--;

            adaptor.addChild(root_0, contractScopeAtom80.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_contractScopeRank_in_contractScope1147);
            contractScopeRank81=contractScopeRank();

            state._fsp--;

            adaptor.addChild(root_0, contractScopeRank81.getTree());

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
    // $ANTLR end "contractScope"

    public static class contractScopeAtom_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractScopeAtom"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:126:1: contractScopeAtom : ( ELEMENT | FACILITY );
    public final colaAst.contractScopeAtom_return contractScopeAtom() throws RecognitionException {
        colaAst.contractScopeAtom_return retval = new colaAst.contractScopeAtom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set82=null;

        CommonTree set82_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:126:25: ( ELEMENT | FACILITY )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set82=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=ELEMENT && input.LA(1)<=FACILITY) ) {
                input.consume();

                set82_tree = (CommonTree)adaptor.dupNode(set82);

                adaptor.addChild(root_0, set82_tree);

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
    // $ANTLR end "contractScopeAtom"

    public static class contractScopeRank_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractScopeRank"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:127:1: contractScopeRank : ( REQUIRED | MANDATORY | OPTIONAL | NOT_DEF );
    public final colaAst.contractScopeRank_return contractScopeRank() throws RecognitionException {
        colaAst.contractScopeRank_return retval = new colaAst.contractScopeRank_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set83=null;

        CommonTree set83_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:127:25: ( REQUIRED | MANDATORY | OPTIONAL | NOT_DEF )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set83=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=REQUIRED && input.LA(1)<=NOT_DEF) ) {
                input.consume();

                set83_tree = (CommonTree)adaptor.dupNode(set83);

                adaptor.addChild(root_0, set83_tree);

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
    // $ANTLR end "contractScopeRank"

    public static class contractItem_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractItem"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:129:1: contractItem : ^( ITEM s= IDENT ( contractItemProp )+ ) ;
    public final colaAst.contractItem_return contractItem() throws RecognitionException {
        colaAst.contractItem_return retval = new colaAst.contractItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree ITEM84=null;
        colaAst.contractItemProp_return contractItemProp85 = null;


        CommonTree s_tree=null;
        CommonTree ITEM84_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:129:25: ( ^( ITEM s= IDENT ( contractItemProp )+ ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:129:27: ^( ITEM s= IDENT ( contractItemProp )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ITEM84=(CommonTree)match(input,ITEM,FOLLOW_ITEM_in_contractItem1209); 
            ITEM84_tree = (CommonTree)adaptor.dupNode(ITEM84);

            root_1 = (CommonTree)adaptor.becomeRoot(ITEM84_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_contractItem1213); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:129:81: ( contractItemProp )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==PROPERTY) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:129:81: contractItemProp
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_contractItemProp_in_contractItem1217);
            	    contractItemProp85=contractItemProp();

            	    state._fsp--;

            	    adaptor.addChild(root_1, contractItemProp85.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "contractItem"

    public static class contractItemProp_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractItemProp"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:130:1: contractItemProp : ^( PROPERTY s= IDENT ^( AT_TYPE base_type const_value ( ARRAY )? ) contractItemPropRank ^( AT_APPLY ( ^( PRE ( scoped_name )* ) )? ( ^( POST ( scoped_name )* ) )? ( ^( INV ( scoped_name )* ) )? ) ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_PRIORITY base_type const_value ) )? ) ;
    public final colaAst.contractItemProp_return contractItemProp() throws RecognitionException {
        colaAst.contractItemProp_return retval = new colaAst.contractItemProp_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree PROPERTY86=null;
        CommonTree AT_TYPE87=null;
        CommonTree ARRAY90=null;
        CommonTree AT_APPLY92=null;
        CommonTree PRE93=null;
        CommonTree POST95=null;
        CommonTree INV97=null;
        CommonTree AT_ALTERABLE99=null;
        CommonTree AT_NEGOTIABLE100=null;
        CommonTree AT_PRIORITY102=null;
        colaAst.base_type_return base_type88 = null;

        colaAst.const_value_return const_value89 = null;

        colaAst.contractItemPropRank_return contractItemPropRank91 = null;

        colaAst.scoped_name_return scoped_name94 = null;

        colaAst.scoped_name_return scoped_name96 = null;

        colaAst.scoped_name_return scoped_name98 = null;

        colaAst.atDescription_return atDescription101 = null;

        colaAst.base_type_return base_type103 = null;

        colaAst.const_value_return const_value104 = null;


        CommonTree s_tree=null;
        CommonTree PROPERTY86_tree=null;
        CommonTree AT_TYPE87_tree=null;
        CommonTree ARRAY90_tree=null;
        CommonTree AT_APPLY92_tree=null;
        CommonTree PRE93_tree=null;
        CommonTree POST95_tree=null;
        CommonTree INV97_tree=null;
        CommonTree AT_ALTERABLE99_tree=null;
        CommonTree AT_NEGOTIABLE100_tree=null;
        CommonTree AT_PRIORITY102_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:130:25: ( ^( PROPERTY s= IDENT ^( AT_TYPE base_type const_value ( ARRAY )? ) contractItemPropRank ^( AT_APPLY ( ^( PRE ( scoped_name )* ) )? ( ^( POST ( scoped_name )* ) )? ( ^( INV ( scoped_name )* ) )? ) ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_PRIORITY base_type const_value ) )? ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:130:27: ^( PROPERTY s= IDENT ^( AT_TYPE base_type const_value ( ARRAY )? ) contractItemPropRank ^( AT_APPLY ( ^( PRE ( scoped_name )* ) )? ( ^( POST ( scoped_name )* ) )? ( ^( INV ( scoped_name )* ) )? ) ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_PRIORITY base_type const_value ) )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PROPERTY86=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_contractItemProp1236); 
            PROPERTY86_tree = (CommonTree)adaptor.dupNode(PROPERTY86);

            root_1 = (CommonTree)adaptor.becomeRoot(PROPERTY86_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_contractItemProp1240); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_TYPE87=(CommonTree)match(input,AT_TYPE,FOLLOW_AT_TYPE_in_contractItemProp1243); 
            AT_TYPE87_tree = (CommonTree)adaptor.dupNode(AT_TYPE87);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_TYPE87_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_base_type_in_contractItemProp1245);
            base_type88=base_type();

            state._fsp--;

            adaptor.addChild(root_2, base_type88.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_value_in_contractItemProp1247);
            const_value89=const_value();

            state._fsp--;

            adaptor.addChild(root_2, const_value89.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:130:78: ( ARRAY )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==ARRAY) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:130:78: ARRAY
                    {
                    _last = (CommonTree)input.LT(1);
                    ARRAY90=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_contractItemProp1249); 
                    ARRAY90_tree = (CommonTree)adaptor.dupNode(ARRAY90);

                    adaptor.addChild(root_2, ARRAY90_tree);


                    }
                    break;

            }


            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            this.pass.atoms.scope.push(s.token);
            this.pass.testBaseTypeWithConstValue(ColaTokensConstants.parserItemProp);
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_contractItemPropRank_in_contractItemProp1342);
            contractItemPropRank91=contractItemPropRank();

            state._fsp--;

            adaptor.addChild(root_1, contractItemPropRank91.getTree());
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_APPLY92=(CommonTree)match(input,AT_APPLY,FOLLOW_AT_APPLY_in_contractItemProp1374); 
            AT_APPLY92_tree = (CommonTree)adaptor.dupNode(AT_APPLY92);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_APPLY92_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:41: ( ^( PRE ( scoped_name )* ) )?
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==PRE) ) {
                    alt35=1;
                }
                switch (alt35) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:42: ^( PRE ( scoped_name )* )
                        {
                        _last = (CommonTree)input.LT(1);
                        {
                        CommonTree _save_last_3 = _last;
                        CommonTree _first_3 = null;
                        CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                        PRE93=(CommonTree)match(input,PRE,FOLLOW_PRE_in_contractItemProp1378); 
                        PRE93_tree = (CommonTree)adaptor.dupNode(PRE93);

                        root_3 = (CommonTree)adaptor.becomeRoot(PRE93_tree, root_3);



                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:48: ( scoped_name )*
                            loop34:
                            do {
                                int alt34=2;
                                int LA34_0 = input.LA(1);

                                if ( (LA34_0==AT_SCOPE) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:49: scoped_name
                            	    {
                            	    _last = (CommonTree)input.LT(1);
                            	    pushFollow(FOLLOW_scoped_name_in_contractItemProp1381);
                            	    scoped_name94=scoped_name();

                            	    state._fsp--;

                            	    adaptor.addChild(root_3, scoped_name94.getTree());
                            	    this.pass.testSN(ColaTokensConstants.colaFUNCTION, null);

                            	    }
                            	    break;

                            	default :
                            	    break loop34;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }adaptor.addChild(root_2, root_3);_last = _save_last_3;
                        }


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:126: ( ^( POST ( scoped_name )* ) )?
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==POST) ) {
                    alt37=1;
                }
                switch (alt37) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:127: ^( POST ( scoped_name )* )
                        {
                        _last = (CommonTree)input.LT(1);
                        {
                        CommonTree _save_last_3 = _last;
                        CommonTree _first_3 = null;
                        CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                        POST95=(CommonTree)match(input,POST,FOLLOW_POST_in_contractItemProp1392); 
                        POST95_tree = (CommonTree)adaptor.dupNode(POST95);

                        root_3 = (CommonTree)adaptor.becomeRoot(POST95_tree, root_3);



                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:134: ( scoped_name )*
                            loop36:
                            do {
                                int alt36=2;
                                int LA36_0 = input.LA(1);

                                if ( (LA36_0==AT_SCOPE) ) {
                                    alt36=1;
                                }


                                switch (alt36) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:135: scoped_name
                            	    {
                            	    _last = (CommonTree)input.LT(1);
                            	    pushFollow(FOLLOW_scoped_name_in_contractItemProp1395);
                            	    scoped_name96=scoped_name();

                            	    state._fsp--;

                            	    adaptor.addChild(root_3, scoped_name96.getTree());
                            	    this.pass.testSN(ColaTokensConstants.colaFUNCTION, null);

                            	    }
                            	    break;

                            	default :
                            	    break loop36;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }adaptor.addChild(root_2, root_3);_last = _save_last_3;
                        }


                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:212: ( ^( INV ( scoped_name )* ) )?
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==INV) ) {
                    alt39=1;
                }
                switch (alt39) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:213: ^( INV ( scoped_name )* )
                        {
                        _last = (CommonTree)input.LT(1);
                        {
                        CommonTree _save_last_3 = _last;
                        CommonTree _first_3 = null;
                        CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                        INV97=(CommonTree)match(input,INV,FOLLOW_INV_in_contractItemProp1406); 
                        INV97_tree = (CommonTree)adaptor.dupNode(INV97);

                        root_3 = (CommonTree)adaptor.becomeRoot(INV97_tree, root_3);



                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:219: ( scoped_name )*
                            loop38:
                            do {
                                int alt38=2;
                                int LA38_0 = input.LA(1);

                                if ( (LA38_0==AT_SCOPE) ) {
                                    alt38=1;
                                }


                                switch (alt38) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:134:220: scoped_name
                            	    {
                            	    _last = (CommonTree)input.LT(1);
                            	    pushFollow(FOLLOW_scoped_name_in_contractItemProp1409);
                            	    scoped_name98=scoped_name();

                            	    state._fsp--;

                            	    adaptor.addChild(root_3, scoped_name98.getTree());
                            	    this.pass.testSN(ColaTokensConstants.colaFUNCTION, null);

                            	    }
                            	    break;

                            	default :
                            	    break loop38;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }adaptor.addChild(root_2, root_3);_last = _save_last_3;
                        }


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:135:30: ( AT_ALTERABLE )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==AT_ALTERABLE) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:135:30: AT_ALTERABLE
                    {
                    _last = (CommonTree)input.LT(1);
                    AT_ALTERABLE99=(CommonTree)match(input,AT_ALTERABLE,FOLLOW_AT_ALTERABLE_in_contractItemProp1449); 
                    AT_ALTERABLE99_tree = (CommonTree)adaptor.dupNode(AT_ALTERABLE99);

                    adaptor.addChild(root_1, AT_ALTERABLE99_tree);


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:135:44: ( AT_NEGOTIABLE )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==AT_NEGOTIABLE) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:135:44: AT_NEGOTIABLE
                    {
                    _last = (CommonTree)input.LT(1);
                    AT_NEGOTIABLE100=(CommonTree)match(input,AT_NEGOTIABLE,FOLLOW_AT_NEGOTIABLE_in_contractItemProp1452); 
                    AT_NEGOTIABLE100_tree = (CommonTree)adaptor.dupNode(AT_NEGOTIABLE100);

                    adaptor.addChild(root_1, AT_NEGOTIABLE100_tree);


                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_atDescription_in_contractItemProp1455);
            atDescription101=atDescription();

            state._fsp--;

            adaptor.addChild(root_1, atDescription101.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:136:29: ( ^( AT_PRIORITY base_type const_value ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==AT_PRIORITY) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:136:30: ^( AT_PRIORITY base_type const_value )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PRIORITY102=(CommonTree)match(input,AT_PRIORITY,FOLLOW_AT_PRIORITY_in_contractItemProp1487); 
                    AT_PRIORITY102_tree = (CommonTree)adaptor.dupNode(AT_PRIORITY102);

                    root_2 = (CommonTree)adaptor.becomeRoot(AT_PRIORITY102_tree, root_2);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_base_type_in_contractItemProp1489);
                    base_type103=base_type();

                    state._fsp--;

                    adaptor.addChild(root_2, base_type103.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_value_in_contractItemProp1491);
                    const_value104=const_value();

                    state._fsp--;

                    adaptor.addChild(root_2, const_value104.getTree());
                    this.pass.testBaseTypeWithConstValue(ColaTokensConstants.parserItemProp);

                    match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
                    }


                    }
                    break;

            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "contractItemProp"

    public static class contractItemPropRank_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractItemPropRank"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:138:1: contractItemPropRank : (s= REQUIRED | s= MANDATORY | s= OPTIONAL ) ;
    public final colaAst.contractItemPropRank_return contractItemPropRank() throws RecognitionException {
        colaAst.contractItemPropRank_return retval = new colaAst.contractItemPropRank_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:138:25: ( (s= REQUIRED | s= MANDATORY | s= OPTIONAL ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:138:27: (s= REQUIRED | s= MANDATORY | s= OPTIONAL )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:138:27: (s= REQUIRED | s= MANDATORY | s= OPTIONAL )
            int alt43=3;
            switch ( input.LA(1) ) {
            case REQUIRED:
                {
                alt43=1;
                }
                break;
            case MANDATORY:
                {
                alt43=2;
                }
                break;
            case OPTIONAL:
                {
                alt43=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:138:28: s= REQUIRED
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,REQUIRED,FOLLOW_REQUIRED_in_contractItemPropRank1538); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:138:41: s= MANDATORY
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,MANDATORY,FOLLOW_MANDATORY_in_contractItemPropRank1544); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:138:55: s= OPTIONAL
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_contractItemPropRank1550); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


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
    // $ANTLR end "contractItemPropRank"

    public static class colaContractDef_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaContractDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:140:1: colaContractDef : ^( CONTRACT id= IDENT scoped_name ( colaContractItemDef )* ) ;
    public final colaAst.colaContractDef_return colaContractDef() throws RecognitionException {
        colaAst.colaContractDef_return retval = new colaAst.colaContractDef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree CONTRACT105=null;
        colaAst.scoped_name_return scoped_name106 = null;

        colaAst.colaContractItemDef_return colaContractItemDef107 = null;


        CommonTree id_tree=null;
        CommonTree CONTRACT105_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:140:25: ( ^( CONTRACT id= IDENT scoped_name ( colaContractItemDef )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:140:27: ^( CONTRACT id= IDENT scoped_name ( colaContractItemDef )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            CONTRACT105=(CommonTree)match(input,CONTRACT,FOLLOW_CONTRACT_in_colaContractDef1568); 
            CONTRACT105_tree = (CommonTree)adaptor.dupNode(CONTRACT105);

            root_1 = (CommonTree)adaptor.becomeRoot(CONTRACT105_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaContractDef1572); 
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scoped_name_in_colaContractDef1574);
            scoped_name106=scoped_name();

            state._fsp--;

            adaptor.addChild(root_1, scoped_name106.getTree());
            this.pass.contDef();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:140:82: ( colaContractItemDef )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==IDENT) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:140:82: colaContractItemDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaContractItemDef_in_colaContractDef1578);
            	    colaContractItemDef107=colaContractItemDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaContractItemDef107.getTree());

            	    }
            	    break;

            	default :
            	    break loop44;
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
    // $ANTLR end "colaContractDef"

    public static class colaContractItemDef_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaContractItemDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:141:1: colaContractItemDef : s= IDENT ( colaItemDef )* ;
    public final colaAst.colaContractItemDef_return colaContractItemDef() throws RecognitionException {
        colaAst.colaContractItemDef_return retval = new colaAst.colaContractItemDef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        colaAst.colaItemDef_return colaItemDef108 = null;


        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:141:25: (s= IDENT ( colaItemDef )* )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:141:27: s= IDENT ( colaItemDef )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaContractItemDef1593); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_0, s_tree);

            this.pass.itemDefListStart(s.token);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:141:73: ( colaItemDef )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==IDENT) ) {
                    int LA45_2 = input.LA(2);

                    if ( (LA45_2==DOWN) ) {
                        alt45=1;
                    }


                }


                switch (alt45) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:141:73: colaItemDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaItemDef_in_colaContractItemDef1596);
            	    colaItemDef108=colaItemDef();

            	    state._fsp--;

            	    adaptor.addChild(root_0, colaItemDef108.getTree());

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            this.pass.itemDefListFinish();

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
    // $ANTLR end "colaContractItemDef"

    public static class colaItemDef_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaItemDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:142:1: colaItemDef : ^(prop= IDENT s= IDENT ( const_value )* ) ;
    public final colaAst.colaItemDef_return colaItemDef() throws RecognitionException {
        colaAst.colaItemDef_return retval = new colaAst.colaItemDef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree prop=null;
        CommonTree s=null;
        colaAst.const_value_return const_value109 = null;


        CommonTree prop_tree=null;
        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:142:25: ( ^(prop= IDENT s= IDENT ( const_value )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:142:27: ^(prop= IDENT s= IDENT ( const_value )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            prop=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaItemDef1621); 
            prop_tree = (CommonTree)adaptor.dupNode(prop);

            root_1 = (CommonTree)adaptor.becomeRoot(prop_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaItemDef1625); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.itemDef(prop.token); this.pass.itemDefValueStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:143:27: ( const_value )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==AT_PROVIDES) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:143:28: const_value
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_const_value_in_colaItemDef1656);
            	    const_value109=const_value();

            	    state._fsp--;

            	    adaptor.addChild(root_1, const_value109.getTree());
            	    this.pass.itemDefValueTest(prop.token);

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.itemDefFinish(prop.token);

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
    // $ANTLR end "colaItemDef"

    public static class colaSpecification_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaSpecification"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:145:1: colaSpecification : ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE IDENT ) ^( AT_SPEC IDENT ) cpp_directive ( colaDefinition )* ) ;
    public final colaAst.colaSpecification_return colaSpecification() throws RecognitionException {
        colaAst.colaSpecification_return retval = new colaAst.colaSpecification_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_SPEC110=null;
        CommonTree AT_LANGUAGE114=null;
        CommonTree IDENT115=null;
        CommonTree AT_SPEC116=null;
        CommonTree IDENT117=null;
        colaAst.a3dsStage_return a3dsStage111 = null;

        colaAst.a3dsEnvironment_return a3dsEnvironment112 = null;

        colaAst.a3dsCLevel_return a3dsCLevel113 = null;

        colaAst.cpp_directive_return cpp_directive118 = null;

        colaAst.colaDefinition_return colaDefinition119 = null;


        CommonTree AT_SPEC110_tree=null;
        CommonTree AT_LANGUAGE114_tree=null;
        CommonTree IDENT115_tree=null;
        CommonTree AT_SPEC116_tree=null;
        CommonTree IDENT117_tree=null;

        this.init();
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:146:25: ( ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE IDENT ) ^( AT_SPEC IDENT ) cpp_directive ( colaDefinition )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:146:27: ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE IDENT ) ^( AT_SPEC IDENT ) cpp_directive ( colaDefinition )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_SPEC110=(CommonTree)match(input,AT_SPEC,FOLLOW_AT_SPEC_in_colaSpecification1700); 
            AT_SPEC110_tree = (CommonTree)adaptor.dupNode(AT_SPEC110);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_SPEC110_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_a3dsStage_in_colaSpecification1702);
            a3dsStage111=a3dsStage();

            state._fsp--;

            adaptor.addChild(root_1, a3dsStage111.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_a3dsEnvironment_in_colaSpecification1704);
            a3dsEnvironment112=a3dsEnvironment();

            state._fsp--;

            adaptor.addChild(root_1, a3dsEnvironment112.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_a3dsCLevel_in_colaSpecification1706);
            a3dsCLevel113=a3dsCLevel();

            state._fsp--;

            adaptor.addChild(root_1, a3dsCLevel113.getTree());
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_LANGUAGE114=(CommonTree)match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_colaSpecification1709); 
            AT_LANGUAGE114_tree = (CommonTree)adaptor.dupNode(AT_LANGUAGE114);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_LANGUAGE114_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT115=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaSpecification1711); 
            IDENT115_tree = (CommonTree)adaptor.dupNode(IDENT115);

            adaptor.addChild(root_2, IDENT115_tree);


            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_SPEC116=(CommonTree)match(input,AT_SPEC,FOLLOW_AT_SPEC_in_colaSpecification1715); 
            AT_SPEC116_tree = (CommonTree)adaptor.dupNode(AT_SPEC116);

            root_2 = (CommonTree)adaptor.becomeRoot(AT_SPEC116_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDENT117=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaSpecification1717); 
            IDENT117_tree = (CommonTree)adaptor.dupNode(IDENT117);

            adaptor.addChild(root_2, IDENT117_tree);


            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cpp_directive_in_colaSpecification1720);
            cpp_directive118=cpp_directive();

            state._fsp--;

            adaptor.addChild(root_1, cpp_directive118.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:146:126: ( colaDefinition )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==FUNCTION||LA47_0==PROPERTY||(LA47_0>=PACKAGE && LA47_0<=FACILITY)||LA47_0==CONTRACT||LA47_0==CPP_DIRECTIVE||(LA47_0>=TYPEDEF && LA47_0<=STRUCT)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:146:126: colaDefinition
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaDefinition_in_colaSpecification1722);
            	    colaDefinition119=colaDefinition();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaDefinition119.getTree());

            	    }
            	    break;

            	default :
            	    break loop47;
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
    // $ANTLR end "colaSpecification"

    public static class colaDefinition_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaDefinition"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:147:1: colaDefinition : ( colaFunction | colaPropertyDecl | colaContractDecl | colaPackage | colaElement | colaFacility | colaTypeDef | colaStruct | cpp_directive );
    public final colaAst.colaDefinition_return colaDefinition() throws RecognitionException {
        colaAst.colaDefinition_return retval = new colaAst.colaDefinition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        colaAst.colaFunction_return colaFunction120 = null;

        colaAst.colaPropertyDecl_return colaPropertyDecl121 = null;

        colaAst.colaContractDecl_return colaContractDecl122 = null;

        colaAst.colaPackage_return colaPackage123 = null;

        colaAst.colaElement_return colaElement124 = null;

        colaAst.colaFacility_return colaFacility125 = null;

        colaAst.colaTypeDef_return colaTypeDef126 = null;

        colaAst.colaStruct_return colaStruct127 = null;

        colaAst.cpp_directive_return cpp_directive128 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:147:25: ( colaFunction | colaPropertyDecl | colaContractDecl | colaPackage | colaElement | colaFacility | colaTypeDef | colaStruct | cpp_directive )
            int alt48=9;
            switch ( input.LA(1) ) {
            case FUNCTION:
                {
                alt48=1;
                }
                break;
            case PROPERTY:
                {
                alt48=2;
                }
                break;
            case CONTRACT:
                {
                alt48=3;
                }
                break;
            case PACKAGE:
                {
                alt48=4;
                }
                break;
            case ELEMENT:
                {
                alt48=5;
                }
                break;
            case FACILITY:
                {
                alt48=6;
                }
                break;
            case TYPEDEF:
                {
                alt48=7;
                }
                break;
            case STRUCT:
                {
                alt48=8;
                }
                break;
            case CPP_DIRECTIVE:
                {
                alt48=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:147:27: colaFunction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaFunction_in_colaDefinition1740);
                    colaFunction120=colaFunction();

                    state._fsp--;

                    adaptor.addChild(root_0, colaFunction120.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:147:42: colaPropertyDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaPropertyDecl_in_colaDefinition1744);
                    colaPropertyDecl121=colaPropertyDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, colaPropertyDecl121.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:147:61: colaContractDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaContractDecl_in_colaDefinition1748);
                    colaContractDecl122=colaContractDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, colaContractDecl122.getTree());

                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:147:80: colaPackage
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaPackage_in_colaDefinition1752);
                    colaPackage123=colaPackage();

                    state._fsp--;

                    adaptor.addChild(root_0, colaPackage123.getTree());

                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:147:94: colaElement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaElement_in_colaDefinition1756);
                    colaElement124=colaElement();

                    state._fsp--;

                    adaptor.addChild(root_0, colaElement124.getTree());

                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:147:108: colaFacility
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaFacility_in_colaDefinition1760);
                    colaFacility125=colaFacility();

                    state._fsp--;

                    adaptor.addChild(root_0, colaFacility125.getTree());

                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:147:123: colaTypeDef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaTypeDef_in_colaDefinition1764);
                    colaTypeDef126=colaTypeDef();

                    state._fsp--;

                    adaptor.addChild(root_0, colaTypeDef126.getTree());

                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:147:137: colaStruct
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaStruct_in_colaDefinition1768);
                    colaStruct127=colaStruct();

                    state._fsp--;

                    adaptor.addChild(root_0, colaStruct127.getTree());

                    }
                    break;
                case 9 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:147:150: cpp_directive
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cpp_directive_in_colaDefinition1772);
                    cpp_directive128=cpp_directive();

                    state._fsp--;

                    adaptor.addChild(root_0, cpp_directive128.getTree());

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
    // $ANTLR end "colaDefinition"

    public static class cpp_directive_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cpp_directive"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:149:1: cpp_directive : s= CPP_DIRECTIVE ;
    public final colaAst.cpp_directive_return cpp_directive() throws RecognitionException {
        colaAst.cpp_directive_return retval = new colaAst.cpp_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:149:25: (s= CPP_DIRECTIVE )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:149:27: s= CPP_DIRECTIVE
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,CPP_DIRECTIVE,FOLLOW_CPP_DIRECTIVE_in_cpp_directive1792); 
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

    public static class colaPackage_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaPackage"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:151:1: colaPackage : ^( PACKAGE s= IDENT ( colaPropertyDef )* ( colaDefinition )* ( inline_code )* ) ;
    public final colaAst.colaPackage_return colaPackage() throws RecognitionException {
        colaAst.colaPackage_return retval = new colaAst.colaPackage_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree PACKAGE129=null;
        colaAst.colaPropertyDef_return colaPropertyDef130 = null;

        colaAst.colaDefinition_return colaDefinition131 = null;

        colaAst.inline_code_return inline_code132 = null;


        CommonTree s_tree=null;
        CommonTree PACKAGE129_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:151:25: ( ^( PACKAGE s= IDENT ( colaPropertyDef )* ( colaDefinition )* ( inline_code )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:151:27: ^( PACKAGE s= IDENT ( colaPropertyDef )* ( colaDefinition )* ( inline_code )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PACKAGE129=(CommonTree)match(input,PACKAGE,FOLLOW_PACKAGE_in_colaPackage1815); 
            PACKAGE129_tree = (CommonTree)adaptor.dupNode(PACKAGE129);

            root_1 = (CommonTree)adaptor.becomeRoot(PACKAGE129_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaPackage1819); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);
            this.pass.propDefListStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:151:116: ( colaPropertyDef )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==PROPERTY) ) {
                    int LA49_2 = input.LA(2);

                    if ( (LA49_2==DOWN) ) {
                        int LA49_3 = input.LA(3);

                        if ( (LA49_3==IDENT) ) {
                            int LA49_4 = input.LA(4);

                            if ( (LA49_4==AT_SCOPE) ) {
                                alt49=1;
                            }


                        }


                    }


                }


                switch (alt49) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:151:116: colaPropertyDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaPropertyDef_in_colaPackage1825);
            	    colaPropertyDef130=colaPropertyDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaPropertyDef130.getTree());

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            this.pass.propDefListFinish();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:151:166: ( colaDefinition )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==FUNCTION||LA50_0==PROPERTY||(LA50_0>=PACKAGE && LA50_0<=FACILITY)||LA50_0==CONTRACT||LA50_0==CPP_DIRECTIVE||(LA50_0>=TYPEDEF && LA50_0<=STRUCT)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:151:166: colaDefinition
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaDefinition_in_colaPackage1830);
            	    colaDefinition131=colaDefinition();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaDefinition131.getTree());

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:151:182: ( inline_code )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==AT_LANGUAGE) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:151:182: inline_code
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_inline_code_in_colaPackage1833);
            	    inline_code132=inline_code();

            	    state._fsp--;

            	    adaptor.addChild(root_1, inline_code132.getTree());

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "colaPackage"

    public static class colaElement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaElement"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:152:1: colaElement : ^( ELEMENT s= IDENT ( colaPropertyDef )* ( colaContractDef )* ( atVisibility )? ( aExtends )? ( aProvides )? ( aRequires )? ( elementBody )* ) ;
    public final colaAst.colaElement_return colaElement() throws RecognitionException {
        colaAst.colaElement_return retval = new colaAst.colaElement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree ELEMENT133=null;
        colaAst.colaPropertyDef_return colaPropertyDef134 = null;

        colaAst.colaContractDef_return colaContractDef135 = null;

        colaAst.atVisibility_return atVisibility136 = null;

        colaAst.aExtends_return aExtends137 = null;

        colaAst.aProvides_return aProvides138 = null;

        colaAst.aRequires_return aRequires139 = null;

        colaAst.elementBody_return elementBody140 = null;


        CommonTree s_tree=null;
        CommonTree ELEMENT133_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:152:25: ( ^( ELEMENT s= IDENT ( colaPropertyDef )* ( colaContractDef )* ( atVisibility )? ( aExtends )? ( aProvides )? ( aRequires )? ( elementBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:152:27: ^( ELEMENT s= IDENT ( colaPropertyDef )* ( colaContractDef )* ( atVisibility )? ( aExtends )? ( aProvides )? ( aRequires )? ( elementBody )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ELEMENT133=(CommonTree)match(input,ELEMENT,FOLLOW_ELEMENT_in_colaElement1857); 
            ELEMENT133_tree = (CommonTree)adaptor.dupNode(ELEMENT133);

            root_1 = (CommonTree)adaptor.becomeRoot(ELEMENT133_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaElement1861); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);
            this.pass.propDefListStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:153:62: ( colaPropertyDef )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==PROPERTY) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:153:62: colaPropertyDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaPropertyDef_in_colaElement1896);
            	    colaPropertyDef134=colaPropertyDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaPropertyDef134.getTree());

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            this.pass.propDefListFinish();
            this.pass.contDefListStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:154:62: ( colaContractDef )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==CONTRACT) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:154:62: colaContractDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaContractDef_in_colaElement1932);
            	    colaContractDef135=colaContractDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaContractDef135.getTree());

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            this.pass.contDefListFinish();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:155:30: ( atVisibility )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==AT_VISIBILITY) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:155:30: atVisibility
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atVisibility_in_colaElement1966);
                    atVisibility136=atVisibility();

                    state._fsp--;

                    adaptor.addChild(root_1, atVisibility136.getTree());

                    }
                    break;

            }

            this.pass.eprStart(ColaTokensConstants.colaELEMENT);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:156:85: ( aExtends )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==AT_EXTENDS) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:156:85: aExtends
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_aExtends_in_colaElement2000);
                    aExtends137=aExtends();

                    state._fsp--;

                    adaptor.addChild(root_1, aExtends137.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:156:95: ( aProvides )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==AT_PROVIDES) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:156:95: aProvides
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_aProvides_in_colaElement2003);
                    aProvides138=aProvides();

                    state._fsp--;

                    adaptor.addChild(root_1, aProvides138.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:156:106: ( aRequires )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==AT_REQUIRES) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:156:106: aRequires
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_aRequires_in_colaElement2006);
                    aRequires139=aRequires();

                    state._fsp--;

                    adaptor.addChild(root_1, aRequires139.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:157:30: ( elementBody )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==AT_LANGUAGE||(LA58_0>=ACTION && LA58_0<=ATTRIBUTE)||LA58_0==AT_CONTAINS) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:157:30: elementBody
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_elementBody_in_colaElement2038);
            	    elementBody140=elementBody();

            	    state._fsp--;

            	    adaptor.addChild(root_1, elementBody140.getTree());

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "colaElement"

    public static class elementBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementBody"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:159:1: elementBody : ( elementContains | colaAttribute | colaAction | inline_code );
    public final colaAst.elementBody_return elementBody() throws RecognitionException {
        colaAst.elementBody_return retval = new colaAst.elementBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        colaAst.elementContains_return elementContains141 = null;

        colaAst.colaAttribute_return colaAttribute142 = null;

        colaAst.colaAction_return colaAction143 = null;

        colaAst.inline_code_return inline_code144 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:159:25: ( elementContains | colaAttribute | colaAction | inline_code )
            int alt59=4;
            switch ( input.LA(1) ) {
            case AT_CONTAINS:
                {
                alt59=1;
                }
                break;
            case ATTRIBUTE:
                {
                alt59=2;
                }
                break;
            case ACTION:
                {
                alt59=3;
                }
                break;
            case AT_LANGUAGE:
                {
                alt59=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:159:27: elementContains
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_elementContains_in_elementBody2088);
                    elementContains141=elementContains();

                    state._fsp--;

                    adaptor.addChild(root_0, elementContains141.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:159:45: colaAttribute
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaAttribute_in_elementBody2092);
                    colaAttribute142=colaAttribute();

                    state._fsp--;

                    adaptor.addChild(root_0, colaAttribute142.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:159:61: colaAction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaAction_in_elementBody2096);
                    colaAction143=colaAction();

                    state._fsp--;

                    adaptor.addChild(root_0, colaAction143.getTree());

                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:159:74: inline_code
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_inline_code_in_elementBody2100);
                    inline_code144=inline_code();

                    state._fsp--;

                    adaptor.addChild(root_0, inline_code144.getTree());

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
    // $ANTLR end "elementBody"

    public static class elementContains_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementContains"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:160:1: elementContains : ^( AT_CONTAINS s= IDENT scoped_name ) ;
    public final colaAst.elementContains_return elementContains() throws RecognitionException {
        colaAst.elementContains_return retval = new colaAst.elementContains_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree AT_CONTAINS145=null;
        colaAst.scoped_name_return scoped_name146 = null;


        CommonTree s_tree=null;
        CommonTree AT_CONTAINS145_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:160:25: ( ^( AT_CONTAINS s= IDENT scoped_name ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:160:27: ^( AT_CONTAINS s= IDENT scoped_name )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_CONTAINS145=(CommonTree)match(input,AT_CONTAINS,FOLLOW_AT_CONTAINS_in_elementContains2116); 
            AT_CONTAINS145_tree = (CommonTree)adaptor.dupNode(AT_CONTAINS145);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_CONTAINS145_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_elementContains2120); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scoped_name_in_elementContains2124);
            scoped_name146=scoped_name();

            state._fsp--;

            adaptor.addChild(root_1, scoped_name146.getTree());
            this.pass.testSN(ColaTokensConstants.colaELEMENT, ColaTokensConstants.colaAT_CONTAINS);
            this.pass.atoms.scope.pop();

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
    // $ANTLR end "elementContains"

    public static class colaFacility_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaFacility"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:162:1: colaFacility : ^( FACILITY s= IDENT ( colaPropertyDef )* ( colaContractDef )* ( atVisibility )? ( aExtends )? ( aRequires )? ( facilityBody )* ) ;
    public final colaAst.colaFacility_return colaFacility() throws RecognitionException {
        colaAst.colaFacility_return retval = new colaAst.colaFacility_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree FACILITY147=null;
        colaAst.colaPropertyDef_return colaPropertyDef148 = null;

        colaAst.colaContractDef_return colaContractDef149 = null;

        colaAst.atVisibility_return atVisibility150 = null;

        colaAst.aExtends_return aExtends151 = null;

        colaAst.aRequires_return aRequires152 = null;

        colaAst.facilityBody_return facilityBody153 = null;


        CommonTree s_tree=null;
        CommonTree FACILITY147_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:162:25: ( ^( FACILITY s= IDENT ( colaPropertyDef )* ( colaContractDef )* ( atVisibility )? ( aExtends )? ( aRequires )? ( facilityBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:162:27: ^( FACILITY s= IDENT ( colaPropertyDef )* ( colaContractDef )* ( atVisibility )? ( aExtends )? ( aRequires )? ( facilityBody )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FACILITY147=(CommonTree)match(input,FACILITY,FOLLOW_FACILITY_in_colaFacility2149); 
            FACILITY147_tree = (CommonTree)adaptor.dupNode(FACILITY147);

            root_1 = (CommonTree)adaptor.becomeRoot(FACILITY147_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaFacility2153); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);
            this.pass.propDefListStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:163:62: ( colaPropertyDef )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==PROPERTY) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:163:62: colaPropertyDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaPropertyDef_in_colaFacility2188);
            	    colaPropertyDef148=colaPropertyDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaPropertyDef148.getTree());

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            this.pass.propDefListFinish();
            this.pass.contDefListStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:164:62: ( colaContractDef )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==CONTRACT) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:164:62: colaContractDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaContractDef_in_colaFacility2224);
            	    colaContractDef149=colaContractDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaContractDef149.getTree());

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            this.pass.contDefListFinish();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:165:30: ( atVisibility )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==AT_VISIBILITY) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:165:30: atVisibility
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atVisibility_in_colaFacility2258);
                    atVisibility150=atVisibility();

                    state._fsp--;

                    adaptor.addChild(root_1, atVisibility150.getTree());

                    }
                    break;

            }

            this.pass.eprStart(ColaTokensConstants.colaFACILITY);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:166:86: ( aExtends )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==AT_EXTENDS) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:166:86: aExtends
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_aExtends_in_colaFacility2292);
                    aExtends151=aExtends();

                    state._fsp--;

                    adaptor.addChild(root_1, aExtends151.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:166:96: ( aRequires )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==AT_REQUIRES) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:166:96: aRequires
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_aRequires_in_colaFacility2295);
                    aRequires152=aRequires();

                    state._fsp--;

                    adaptor.addChild(root_1, aRequires152.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:167:30: ( facilityBody )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( ((LA65_0>=ACTION && LA65_0<=ATTRIBUTE)) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:167:30: facilityBody
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_facilityBody_in_colaFacility2327);
            	    facilityBody153=facilityBody();

            	    state._fsp--;

            	    adaptor.addChild(root_1, facilityBody153.getTree());

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "colaFacility"

    public static class facilityBody_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "facilityBody"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:169:1: facilityBody : ( colaAttribute | colaAction );
    public final colaAst.facilityBody_return facilityBody() throws RecognitionException {
        colaAst.facilityBody_return retval = new colaAst.facilityBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        colaAst.colaAttribute_return colaAttribute154 = null;

        colaAst.colaAction_return colaAction155 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:169:25: ( colaAttribute | colaAction )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==ATTRIBUTE) ) {
                alt66=1;
            }
            else if ( (LA66_0==ACTION) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:169:27: colaAttribute
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaAttribute_in_facilityBody2376);
                    colaAttribute154=colaAttribute();

                    state._fsp--;

                    adaptor.addChild(root_0, colaAttribute154.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:169:43: colaAction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_colaAction_in_facilityBody2380);
                    colaAction155=colaAction();

                    state._fsp--;

                    adaptor.addChild(root_0, colaAction155.getTree());

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
    // $ANTLR end "facilityBody"

    public static class colaAction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaAction"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:1: colaAction : ^( ACTION s= IDENT ( simple_type )? ( void_type )? ( colaPropertyDef )* ( colaParameter )* ( inline_code )* ) ;
    public final colaAst.colaAction_return colaAction() throws RecognitionException {
        colaAst.colaAction_return retval = new colaAst.colaAction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree ACTION156=null;
        colaAst.simple_type_return simple_type157 = null;

        colaAst.void_type_return void_type158 = null;

        colaAst.colaPropertyDef_return colaPropertyDef159 = null;

        colaAst.colaParameter_return colaParameter160 = null;

        colaAst.inline_code_return inline_code161 = null;


        CommonTree s_tree=null;
        CommonTree ACTION156_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:25: ( ^( ACTION s= IDENT ( simple_type )? ( void_type )? ( colaPropertyDef )* ( colaParameter )* ( inline_code )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:27: ^( ACTION s= IDENT ( simple_type )? ( void_type )? ( colaPropertyDef )* ( colaParameter )* ( inline_code )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ACTION156=(CommonTree)match(input,ACTION,FOLLOW_ACTION_in_colaAction2402); 
            ACTION156_tree = (CommonTree)adaptor.dupNode(ACTION156);

            root_1 = (CommonTree)adaptor.becomeRoot(ACTION156_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaAction2409); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);this.pass.sn.clear();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:107: ( simple_type )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==AT_SCOPE||(LA67_0>=SHORT && LA67_0<=BOOLEAN)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:108: simple_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_colaAction2414);
                    simple_type157=simple_type();

                    state._fsp--;

                    adaptor.addChild(root_1, simple_type157.getTree());
                    this.pass.testSN(ColaTokensConstants.colaACTION, null);

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:180: ( void_type )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==VOID) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:180: void_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_void_type_in_colaAction2420);
                    void_type158=void_type();

                    state._fsp--;

                    adaptor.addChild(root_1, void_type158.getTree());

                    }
                    break;

            }

            this.pass.propDefListStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:223: ( colaPropertyDef )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==PROPERTY) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:223: colaPropertyDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaPropertyDef_in_colaAction2425);
            	    colaPropertyDef159=colaPropertyDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaPropertyDef159.getTree());

            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);

            this.pass.propDefListFinish();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:273: ( colaParameter )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==PARAMETER) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:273: colaParameter
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaParameter_in_colaAction2430);
            	    colaParameter160=colaParameter();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaParameter160.getTree());

            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:288: ( inline_code )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==AT_LANGUAGE) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:171:288: inline_code
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_inline_code_in_colaAction2433);
            	    inline_code161=inline_code();

            	    state._fsp--;

            	    adaptor.addChild(root_1, inline_code161.getTree());

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "colaAction"

    public static class colaParameter_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaParameter"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:172:1: colaParameter : ^( PARAMETER s= IDENT simple_type ( colaPropertyDef )* ) ;
    public final colaAst.colaParameter_return colaParameter() throws RecognitionException {
        colaAst.colaParameter_return retval = new colaAst.colaParameter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree PARAMETER162=null;
        colaAst.simple_type_return simple_type163 = null;

        colaAst.colaPropertyDef_return colaPropertyDef164 = null;


        CommonTree s_tree=null;
        CommonTree PARAMETER162_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:172:25: ( ^( PARAMETER s= IDENT simple_type ( colaPropertyDef )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:172:27: ^( PARAMETER s= IDENT simple_type ( colaPropertyDef )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PARAMETER162=(CommonTree)match(input,PARAMETER,FOLLOW_PARAMETER_in_colaParameter2455); 
            PARAMETER162_tree = (CommonTree)adaptor.dupNode(PARAMETER162);

            root_1 = (CommonTree)adaptor.becomeRoot(PARAMETER162_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaParameter2459); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);this.pass.sn.clear();
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_simple_type_in_colaParameter2464);
            simple_type163=simple_type();

            state._fsp--;

            adaptor.addChild(root_1, simple_type163.getTree());
            this.pass.testSN(ColaTokensConstants.colaPARAMETER, null);
            this.pass.propDefListStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:172:223: ( colaPropertyDef )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==PROPERTY) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:172:223: colaPropertyDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaPropertyDef_in_colaParameter2480);
            	    colaPropertyDef164=colaPropertyDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaPropertyDef164.getTree());

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            this.pass.propDefListFinish();

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "colaParameter"

    public static class colaTypeDef_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaTypeDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:173:1: colaTypeDef : ^( TYPEDEF s= IDENT simple_type ( colaPropertyDef )* ( inline_code )* ) ;
    public final colaAst.colaTypeDef_return colaTypeDef() throws RecognitionException {
        colaAst.colaTypeDef_return retval = new colaAst.colaTypeDef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree TYPEDEF165=null;
        colaAst.simple_type_return simple_type166 = null;

        colaAst.colaPropertyDef_return colaPropertyDef167 = null;

        colaAst.inline_code_return inline_code168 = null;


        CommonTree s_tree=null;
        CommonTree TYPEDEF165_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:173:25: ( ^( TYPEDEF s= IDENT simple_type ( colaPropertyDef )* ( inline_code )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:173:27: ^( TYPEDEF s= IDENT simple_type ( colaPropertyDef )* ( inline_code )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TYPEDEF165=(CommonTree)match(input,TYPEDEF,FOLLOW_TYPEDEF_in_colaTypeDef2534); 
            TYPEDEF165_tree = (CommonTree)adaptor.dupNode(TYPEDEF165);

            root_1 = (CommonTree)adaptor.becomeRoot(TYPEDEF165_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaTypeDef2540); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);this.pass.sn.clear();
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_simple_type_in_colaTypeDef2545);
            simple_type166=simple_type();

            state._fsp--;

            adaptor.addChild(root_1, simple_type166.getTree());
            this.pass.testSN(ColaTokensConstants.colaTYPEDEF, null);
            this.pass.propDefListStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:173:223: ( colaPropertyDef )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==PROPERTY) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:173:223: colaPropertyDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaPropertyDef_in_colaTypeDef2563);
            	    colaPropertyDef167=colaPropertyDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaPropertyDef167.getTree());

            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

            this.pass.propDefListFinish();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:173:288: ( inline_code )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==AT_LANGUAGE) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:173:288: inline_code
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_inline_code_in_colaTypeDef2583);
            	    inline_code168=inline_code();

            	    state._fsp--;

            	    adaptor.addChild(root_1, inline_code168.getTree());

            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "colaTypeDef"

    public static class colaAttribute_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaAttribute"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:174:1: colaAttribute : ^( ATTRIBUTE s= IDENT simple_type ( colaPropertyDef )* ( inline_code )* ) ;
    public final colaAst.colaAttribute_return colaAttribute() throws RecognitionException {
        colaAst.colaAttribute_return retval = new colaAst.colaAttribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree ATTRIBUTE169=null;
        colaAst.simple_type_return simple_type170 = null;

        colaAst.colaPropertyDef_return colaPropertyDef171 = null;

        colaAst.inline_code_return inline_code172 = null;


        CommonTree s_tree=null;
        CommonTree ATTRIBUTE169_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:174:25: ( ^( ATTRIBUTE s= IDENT simple_type ( colaPropertyDef )* ( inline_code )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:174:27: ^( ATTRIBUTE s= IDENT simple_type ( colaPropertyDef )* ( inline_code )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ATTRIBUTE169=(CommonTree)match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_colaAttribute2605); 
            ATTRIBUTE169_tree = (CommonTree)adaptor.dupNode(ATTRIBUTE169);

            root_1 = (CommonTree)adaptor.becomeRoot(ATTRIBUTE169_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaAttribute2609); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);this.pass.sn.clear();
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_simple_type_in_colaAttribute2614);
            simple_type170=simple_type();

            state._fsp--;

            adaptor.addChild(root_1, simple_type170.getTree());
            this.pass.testSN(ColaTokensConstants.colaATTRIBUTE, null);
            this.pass.propDefListStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:174:223: ( colaPropertyDef )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==PROPERTY) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:174:223: colaPropertyDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaPropertyDef_in_colaAttribute2630);
            	    colaPropertyDef171=colaPropertyDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaPropertyDef171.getTree());

            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

            this.pass.propDefListFinish();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:174:288: ( inline_code )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==AT_LANGUAGE) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:174:288: inline_code
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_inline_code_in_colaAttribute2650);
            	    inline_code172=inline_code();

            	    state._fsp--;

            	    adaptor.addChild(root_1, inline_code172.getTree());

            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "colaAttribute"

    public static class colaStruct_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaStruct"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:175:1: colaStruct : ^( STRUCT s= IDENT ( colaPropertyDef )* ( colaMember )* ( inline_code )* ) ;
    public final colaAst.colaStruct_return colaStruct() throws RecognitionException {
        colaAst.colaStruct_return retval = new colaAst.colaStruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree STRUCT173=null;
        colaAst.colaPropertyDef_return colaPropertyDef174 = null;

        colaAst.colaMember_return colaMember175 = null;

        colaAst.inline_code_return inline_code176 = null;


        CommonTree s_tree=null;
        CommonTree STRUCT173_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:175:25: ( ^( STRUCT s= IDENT ( colaPropertyDef )* ( colaMember )* ( inline_code )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:175:27: ^( STRUCT s= IDENT ( colaPropertyDef )* ( colaMember )* ( inline_code )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            STRUCT173=(CommonTree)match(input,STRUCT,FOLLOW_STRUCT_in_colaStruct2675); 
            STRUCT173_tree = (CommonTree)adaptor.dupNode(STRUCT173);

            root_1 = (CommonTree)adaptor.becomeRoot(STRUCT173_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaStruct2682); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);
            this.pass.propDefListStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:175:205: ( colaPropertyDef )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==PROPERTY) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:175:205: colaPropertyDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaPropertyDef_in_colaStruct2775);
            	    colaPropertyDef174=colaPropertyDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaPropertyDef174.getTree());

            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            this.pass.propDefListFinish();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:175:255: ( colaMember )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==MEMBER) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:175:255: colaMember
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaMember_in_colaStruct2780);
            	    colaMember175=colaMember();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaMember175.getTree());

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:175:270: ( inline_code )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==AT_LANGUAGE) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:175:270: inline_code
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_inline_code_in_colaStruct2786);
            	    inline_code176=inline_code();

            	    state._fsp--;

            	    adaptor.addChild(root_1, inline_code176.getTree());

            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "colaStruct"

    public static class colaMember_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaMember"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:176:1: colaMember : ^( MEMBER s= IDENT simple_type ( colaPropertyDef )* ) ;
    public final colaAst.colaMember_return colaMember() throws RecognitionException {
        colaAst.colaMember_return retval = new colaAst.colaMember_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree MEMBER177=null;
        colaAst.simple_type_return simple_type178 = null;

        colaAst.colaPropertyDef_return colaPropertyDef179 = null;


        CommonTree s_tree=null;
        CommonTree MEMBER177_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:176:25: ( ^( MEMBER s= IDENT simple_type ( colaPropertyDef )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:176:27: ^( MEMBER s= IDENT simple_type ( colaPropertyDef )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MEMBER177=(CommonTree)match(input,MEMBER,FOLLOW_MEMBER_in_colaMember2811); 
            MEMBER177_tree = (CommonTree)adaptor.dupNode(MEMBER177);

            root_1 = (CommonTree)adaptor.becomeRoot(MEMBER177_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaMember2818); 
            s_tree = (CommonTree)adaptor.dupNode(s);

            adaptor.addChild(root_1, s_tree);

            this.pass.atoms.scope.push(s.token);this.pass.sn.clear();
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_simple_type_in_colaMember2823);
            simple_type178=simple_type();

            state._fsp--;

            adaptor.addChild(root_1, simple_type178.getTree());
            this.pass.testSN(ColaTokensConstants.parserMEMBER, null);
            this.pass.propDefListStart();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:176:223: ( colaPropertyDef )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==PROPERTY) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:176:223: colaPropertyDef
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_colaPropertyDef_in_colaMember2840);
            	    colaPropertyDef179=colaPropertyDef();

            	    state._fsp--;

            	    adaptor.addChild(root_1, colaPropertyDef179.getTree());

            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);

            this.pass.propDefListFinish();

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            this.pass.atoms.scope.pop();

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
    // $ANTLR end "colaMember"

    public static class scoped_name_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scoped_name"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:178:1: scoped_name : ^( AT_SCOPE (s= IDENT )* ) ;
    public final colaAst.scoped_name_return scoped_name() throws RecognitionException {
        colaAst.scoped_name_return retval = new colaAst.scoped_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree AT_SCOPE180=null;

        CommonTree s_tree=null;
        CommonTree AT_SCOPE180_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:178:25: ( ^( AT_SCOPE (s= IDENT )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:178:27: ^( AT_SCOPE (s= IDENT )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_SCOPE180=(CommonTree)match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_scoped_name2895); 
            AT_SCOPE180_tree = (CommonTree)adaptor.dupNode(AT_SCOPE180);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_SCOPE180_tree, root_1);


            this.pass.sn.clear();

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:178:62: (s= IDENT )*
                loop81:
                do {
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==IDENT) ) {
                        alt81=1;
                    }


                    switch (alt81) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:178:63: s= IDENT
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_scoped_name2902); 
                	    s_tree = (CommonTree)adaptor.dupNode(s);

                	    adaptor.addChild(root_1, s_tree);

                	    this.pass.sn.push(s.token);

                	    }
                	    break;

                	default :
                	    break loop81;
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:180:1: void_type : VOID ;
    public final colaAst.void_type_return void_type() throws RecognitionException {
        colaAst.void_type_return retval = new colaAst.void_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree VOID181=null;

        CommonTree VOID181_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:180:25: ( VOID )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:180:27: VOID
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            VOID181=(CommonTree)match(input,VOID,FOLLOW_VOID_in_void_type2929); 
            VOID181_tree = (CommonTree)adaptor.dupNode(VOID181);

            adaptor.addChild(root_0, VOID181_tree);


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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:181:1: simple_type : ( scoped_name | base_type ) ( ARRAY )? ;
    public final colaAst.simple_type_return simple_type() throws RecognitionException {
        colaAst.simple_type_return retval = new colaAst.simple_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARRAY184=null;
        colaAst.scoped_name_return scoped_name182 = null;

        colaAst.base_type_return base_type183 = null;


        CommonTree ARRAY184_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:181:25: ( ( scoped_name | base_type ) ( ARRAY )? )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:181:27: ( scoped_name | base_type ) ( ARRAY )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:181:27: ( scoped_name | base_type )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==AT_SCOPE) ) {
                alt82=1;
            }
            else if ( ((LA82_0>=SHORT && LA82_0<=BOOLEAN)) ) {
                alt82=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:181:28: scoped_name
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scoped_name_in_simple_type2949);
                    scoped_name182=scoped_name();

                    state._fsp--;

                    adaptor.addChild(root_0, scoped_name182.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:181:42: base_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_base_type_in_simple_type2953);
                    base_type183=base_type();

                    state._fsp--;

                    adaptor.addChild(root_0, base_type183.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:181:53: ( ARRAY )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==ARRAY) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:181:53: ARRAY
                    {
                    _last = (CommonTree)input.LT(1);
                    ARRAY184=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_simple_type2956); 
                    ARRAY184_tree = (CommonTree)adaptor.dupNode(ARRAY184);

                    adaptor.addChild(root_0, ARRAY184_tree);


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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:1: base_type : (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN ) ;
    public final colaAst.base_type_return base_type() throws RecognitionException {
        colaAst.base_type_return retval = new colaAst.base_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:25: ( (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:27: (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:27: (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN )
            int alt84=11;
            switch ( input.LA(1) ) {
            case SHORT:
                {
                alt84=1;
                }
                break;
            case INTEGER:
                {
                alt84=2;
                }
                break;
            case LONG:
                {
                alt84=3;
                }
                break;
            case OCTET:
                {
                alt84=4;
                }
                break;
            case HEX:
                {
                alt84=5;
                }
                break;
            case BINARY:
                {
                alt84=6;
                }
                break;
            case FLOAT:
                {
                alt84=7;
                }
                break;
            case DOUBLE:
                {
                alt84=8;
                }
                break;
            case CHAR:
                {
                alt84=9;
                }
                break;
            case STRING:
                {
                alt84=10;
                }
                break;
            case BOOLEAN:
                {
                alt84=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:28: s= SHORT
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,SHORT,FOLLOW_SHORT_in_base_type2981); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:38: s= INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_base_type2987); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:50: s= LONG
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,LONG,FOLLOW_LONG_in_base_type2993); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:59: s= OCTET
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,OCTET,FOLLOW_OCTET_in_base_type2999); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:69: s= HEX
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,HEX,FOLLOW_HEX_in_base_type3005); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:77: s= BINARY
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,BINARY,FOLLOW_BINARY_in_base_type3011); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:88: s= FLOAT
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_base_type3017); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:98: s= DOUBLE
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_base_type3023); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 9 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:109: s= CHAR
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,CHAR,FOLLOW_CHAR_in_base_type3029); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 10 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:118: s= STRING
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,STRING,FOLLOW_STRING_in_base_type3035); 
                    s_tree = (CommonTree)adaptor.dupNode(s);

                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 11 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:182:129: s= BOOLEAN
                    {
                    _last = (CommonTree)input.LT(1);
                    s=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_base_type3041); 
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:185:1: const_value : ( ^( AT_PROVIDES type= INTEGER value= VAL_INTEGER ) | ^( AT_PROVIDES type= OCTET value= VAL_OCT ) | ^( AT_PROVIDES type= HEX value= VAL_HEX ) | ^( AT_PROVIDES type= BINARY value= VAL_BINARY ) | ^( AT_PROVIDES type= FLOAT value= VAL_FLOAT ) | ^( AT_PROVIDES type= CHAR value= VAL_CHAR ) | ^( AT_PROVIDES type= STRING string_value ) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) );
    public final colaAst.const_value_return const_value() throws RecognitionException {
        colaAst.const_value_return retval = new colaAst.const_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree type=null;
        CommonTree value=null;
        CommonTree AT_PROVIDES185=null;
        CommonTree AT_PROVIDES186=null;
        CommonTree AT_PROVIDES187=null;
        CommonTree AT_PROVIDES188=null;
        CommonTree AT_PROVIDES189=null;
        CommonTree AT_PROVIDES190=null;
        CommonTree AT_PROVIDES191=null;
        CommonTree AT_PROVIDES193=null;
        colaAst.string_value_return string_value192 = null;

        colaAst.boolean_value_return boolean_value194 = null;


        CommonTree type_tree=null;
        CommonTree value_tree=null;
        CommonTree AT_PROVIDES185_tree=null;
        CommonTree AT_PROVIDES186_tree=null;
        CommonTree AT_PROVIDES187_tree=null;
        CommonTree AT_PROVIDES188_tree=null;
        CommonTree AT_PROVIDES189_tree=null;
        CommonTree AT_PROVIDES190_tree=null;
        CommonTree AT_PROVIDES191_tree=null;
        CommonTree AT_PROVIDES193_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:185:25: ( ^( AT_PROVIDES type= INTEGER value= VAL_INTEGER ) | ^( AT_PROVIDES type= OCTET value= VAL_OCT ) | ^( AT_PROVIDES type= HEX value= VAL_HEX ) | ^( AT_PROVIDES type= BINARY value= VAL_BINARY ) | ^( AT_PROVIDES type= FLOAT value= VAL_FLOAT ) | ^( AT_PROVIDES type= CHAR value= VAL_CHAR ) | ^( AT_PROVIDES type= STRING string_value ) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) )
            int alt85=8;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:185:27: ^( AT_PROVIDES type= INTEGER value= VAL_INTEGER )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES185=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value3091); 
                    AT_PROVIDES185_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES185);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES185_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_const_value3095); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_INTEGER,FOLLOW_VAL_INTEGER_in_const_value3099); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:186:27: ^( AT_PROVIDES type= OCTET value= VAL_OCT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES186=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value3133); 
                    AT_PROVIDES186_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES186);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES186_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,OCTET,FOLLOW_OCTET_in_const_value3137); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_OCT,FOLLOW_VAL_OCT_in_const_value3143); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:187:27: ^( AT_PROVIDES type= HEX value= VAL_HEX )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES187=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value3181); 
                    AT_PROVIDES187_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES187);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES187_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,HEX,FOLLOW_HEX_in_const_value3185); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_HEX,FOLLOW_VAL_HEX_in_const_value3193); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:188:27: ^( AT_PROVIDES type= BINARY value= VAL_BINARY )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES188=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value3231); 
                    AT_PROVIDES188_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES188);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES188_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,BINARY,FOLLOW_BINARY_in_const_value3235); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_BINARY,FOLLOW_VAL_BINARY_in_const_value3240); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:189:27: ^( AT_PROVIDES type= FLOAT value= VAL_FLOAT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES189=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value3275); 
                    AT_PROVIDES189_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES189);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES189_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_const_value3279); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_FLOAT,FOLLOW_VAL_FLOAT_in_const_value3285); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:190:27: ^( AT_PROVIDES type= CHAR value= VAL_CHAR )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES190=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value3321); 
                    AT_PROVIDES190_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES190);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES190_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,CHAR,FOLLOW_CHAR_in_const_value3325); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_CHAR,FOLLOW_VAL_CHAR_in_const_value3332); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_1, value_tree);

                    this.pass.setLastCommonValuePlusType(value.token,type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:191:27: ^( AT_PROVIDES type= STRING string_value )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES191=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value3369); 
                    AT_PROVIDES191_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES191);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES191_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,STRING,FOLLOW_STRING_in_const_value3373); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_string_value_in_const_value3376);
                    string_value192=string_value();

                    state._fsp--;

                    adaptor.addChild(root_1, string_value192.getTree());
                    this.pass.setLastCommonValueType(type.token);

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:192:27: ^( AT_PROVIDES type= BOOLEAN boolean_value )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    AT_PROVIDES193=(CommonTree)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value3414); 
                    AT_PROVIDES193_tree = (CommonTree)adaptor.dupNode(AT_PROVIDES193);

                    root_1 = (CommonTree)adaptor.becomeRoot(AT_PROVIDES193_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    type=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_const_value3418); 
                    type_tree = (CommonTree)adaptor.dupNode(type);

                    adaptor.addChild(root_1, type_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_boolean_value_in_const_value3420);
                    boolean_value194=boolean_value();

                    state._fsp--;

                    adaptor.addChild(root_1, boolean_value194.getTree());
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:193:1: string_value : (value= VAL_STRING | value= COLA_NULL ) ;
    public final colaAst.string_value_return string_value() throws RecognitionException {
        colaAst.string_value_return retval = new colaAst.string_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree value=null;

        CommonTree value_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:193:25: ( (value= VAL_STRING | value= COLA_NULL ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:193:27: (value= VAL_STRING | value= COLA_NULL )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:193:27: (value= VAL_STRING | value= COLA_NULL )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==VAL_STRING) ) {
                alt86=1;
            }
            else if ( (LA86_0==COLA_NULL) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:193:28: value= VAL_STRING
                    {
                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,VAL_STRING,FOLLOW_VAL_STRING_in_string_value3448); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_0, value_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:193:47: value= COLA_NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,COLA_NULL,FOLLOW_COLA_NULL_in_string_value3454); 
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:194:1: boolean_value : (value= COLA_TRUE | value= COLA_FALSE ) ;
    public final colaAst.boolean_value_return boolean_value() throws RecognitionException {
        colaAst.boolean_value_return retval = new colaAst.boolean_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree value=null;

        CommonTree value_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:194:25: ( (value= COLA_TRUE | value= COLA_FALSE ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:194:27: (value= COLA_TRUE | value= COLA_FALSE )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:194:27: (value= COLA_TRUE | value= COLA_FALSE )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==COLA_TRUE) ) {
                alt87=1;
            }
            else if ( (LA87_0==COLA_FALSE) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:194:28: value= COLA_TRUE
                    {
                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,COLA_TRUE,FOLLOW_COLA_TRUE_in_boolean_value3478); 
                    value_tree = (CommonTree)adaptor.dupNode(value);

                    adaptor.addChild(root_0, value_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:194:47: value= COLA_FALSE
                    {
                    _last = (CommonTree)input.LT(1);
                    value=(CommonTree)match(input,COLA_FALSE,FOLLOW_COLA_FALSE_in_boolean_value3485); 
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

    public static class inline_code_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inline_code"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:196:1: inline_code : ^( AT_LANGUAGE string_value INLINE_CODE ) ;
    public final colaAst.inline_code_return inline_code() throws RecognitionException {
        colaAst.inline_code_return retval = new colaAst.inline_code_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AT_LANGUAGE195=null;
        CommonTree INLINE_CODE197=null;
        colaAst.string_value_return string_value196 = null;


        CommonTree AT_LANGUAGE195_tree=null;
        CommonTree INLINE_CODE197_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:196:25: ( ^( AT_LANGUAGE string_value INLINE_CODE ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaAst.g:196:27: ^( AT_LANGUAGE string_value INLINE_CODE )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            AT_LANGUAGE195=(CommonTree)match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_inline_code3509); 
            AT_LANGUAGE195_tree = (CommonTree)adaptor.dupNode(AT_LANGUAGE195);

            root_1 = (CommonTree)adaptor.becomeRoot(AT_LANGUAGE195_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_string_value_in_inline_code3511);
            string_value196=string_value();

            state._fsp--;

            adaptor.addChild(root_1, string_value196.getTree());
            _last = (CommonTree)input.LT(1);
            INLINE_CODE197=(CommonTree)match(input,INLINE_CODE,FOLLOW_INLINE_CODE_in_inline_code3513); 
            INLINE_CODE197_tree = (CommonTree)adaptor.dupNode(INLINE_CODE197);

            adaptor.addChild(root_1, INLINE_CODE197_tree);


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
    // $ANTLR end "inline_code"

    // Delegated rules


    protected DFA85 dfa85 = new DFA85(this);
    static final String DFA85_eotS =
        "\13\uffff";
    static final String DFA85_eofS =
        "\13\uffff";
    static final String DFA85_minS =
        "\1\52\1\2\1\60\10\uffff";
    static final String DFA85_maxS =
        "\1\52\1\2\1\71\10\uffff";
    static final String DFA85_acceptS =
        "\3\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10";
    static final String DFA85_specialS =
        "\13\uffff}>";
    static final String[] DFA85_transitionS = {
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

    static final short[] DFA85_eot = DFA.unpackEncodedString(DFA85_eotS);
    static final short[] DFA85_eof = DFA.unpackEncodedString(DFA85_eofS);
    static final char[] DFA85_min = DFA.unpackEncodedStringToUnsignedChars(DFA85_minS);
    static final char[] DFA85_max = DFA.unpackEncodedStringToUnsignedChars(DFA85_maxS);
    static final short[] DFA85_accept = DFA.unpackEncodedString(DFA85_acceptS);
    static final short[] DFA85_special = DFA.unpackEncodedString(DFA85_specialS);
    static final short[][] DFA85_transition;

    static {
        int numStates = DFA85_transitionS.length;
        DFA85_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA85_transition[i] = DFA.unpackEncodedString(DFA85_transitionS[i]);
        }
    }

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = DFA85_eot;
            this.eof = DFA85_eof;
            this.min = DFA85_min;
            this.max = DFA85_max;
            this.accept = DFA85_accept;
            this.special = DFA85_special;
            this.transition = DFA85_transition;
        }
        public String getDescription() {
            return "185:1: const_value : ( ^( AT_PROVIDES type= INTEGER value= VAL_INTEGER ) | ^( AT_PROVIDES type= OCTET value= VAL_OCT ) | ^( AT_PROVIDES type= HEX value= VAL_HEX ) | ^( AT_PROVIDES type= BINARY value= VAL_BINARY ) | ^( AT_PROVIDES type= FLOAT value= VAL_FLOAT ) | ^( AT_PROVIDES type= CHAR value= VAL_CHAR ) | ^( AT_PROVIDES type= STRING string_value ) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) );";
        }
    }
 

    public static final BitSet FOLLOW_set_in_a3dsStage0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_a3dsEnvironment0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_a3dsCLevel0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_colaFunction167 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaFunction169 = new BitSet(new long[]{0x03FF800000000080L});
    public static final BitSet FOLLOW_colaFunctionParam_in_colaFunction171 = new BitSet(new long[]{0x03FF800000000080L});
    public static final BitSet FOLLOW_base_type_in_colaFunction174 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ARRAY_in_colaFunction176 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_AT_LANGUAGE_in_colaFunction180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_string_value_in_colaFunction182 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAMETER_in_colaFunctionParam198 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_base_type_in_colaFunctionParam200 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000010L});
    public static final BitSet FOLLOW_ARRAY_in_colaFunctionParam202 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaFunctionParam205 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_in_colaPropertyDecl222 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaPropertyDecl226 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_AT_TYPE_in_colaPropertyDecl229 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_base_type_in_colaPropertyDecl231 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_const_value_in_colaPropertyDecl233 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_ARRAY_in_colaPropertyDecl235 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_SCOPE_in_colaPropertyDecl328 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyScope_in_colaPropertyDecl330 = new BitSet(new long[]{0x00000000003E0088L});
    public static final BitSet FOLLOW_AT_APPLY_in_colaPropertyDecl363 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PRE_in_colaPropertyDecl367 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDecl370 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_POST_in_colaPropertyDecl381 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDecl384 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_INV_in_colaPropertyDecl395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDecl398 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_atVisibility_in_colaPropertyDecl437 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_AT_ALTERABLE_in_colaPropertyDecl440 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_AT_NEGOTIABLE_in_colaPropertyDecl443 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_atDescription_in_colaPropertyDecl446 = new BitSet(new long[]{0x000000000001C008L});
    public static final BitSet FOLLOW_aExtends_in_colaPropertyDecl478 = new BitSet(new long[]{0x0000000000018008L});
    public static final BitSet FOLLOW_aRequires_in_colaPropertyDecl481 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_AT_PRIORITY_in_colaPropertyDecl514 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_base_type_in_colaPropertyDecl516 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_const_value_in_colaPropertyDecl518 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_propertyScopeAtom_in_propertyScope597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyScopeRank_in_propertyScope599 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_propertyScopeAtom0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_propertyScopeRank0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_EXTENDS_in_aExtends681 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_aExtends688 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_aProvides715 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_aProvides720 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_AT_REQUIRES_in_aRequires747 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_aRequires752 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_AT_VISIBILITY_in_atVisibility777 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_AT_SPEC_in_atVisibility780 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atVisibilityData_in_atVisibility782 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_RUNTIME_in_atVisibility786 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atVisibilityData_in_atVisibility788 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_95_in_atVisibilityData804 = new BitSet(new long[]{0x0000000000000020L,0x0000002200000000L});
    public static final BitSet FOLLOW_IDENT_in_atVisibilityData834 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_atVisibilityData837 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData839 = new BitSet(new long[]{0x0000000000000000L,0x0000001200000000L});
    public static final BitSet FOLLOW_100_in_atVisibilityData842 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData844 = new BitSet(new long[]{0x0000000000000000L,0x0000001200000000L});
    public static final BitSet FOLLOW_97_in_atVisibilityData850 = new BitSet(new long[]{0x0000000200000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_COLA_TRUE_in_atVisibilityData878 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_atVisibilityData881 = new BitSet(new long[]{0x0000000000000020L,0x0000004100000000L});
    public static final BitSet FOLLOW_IDENT_in_atVisibilityData910 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_atVisibilityData913 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData915 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_100_in_atVisibilityData918 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData920 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_96_in_atVisibilityData952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_DESCRIPTION_in_atDescription998 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_string_value_in_atDescription1000 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_in_colaPropertyDef1020 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaPropertyDef1022 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDef1024 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_const_value_in_colaPropertyDef1055 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_CONTRACT_in_colaContractDecl1078 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaContractDecl1082 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_AT_SCOPE_in_colaContractDecl1087 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_contractScope_in_colaContractDecl1089 = new BitSet(new long[]{0x00000000000C0008L});
    public static final BitSet FOLLOW_atVisibility_in_colaContractDecl1093 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_atDescription_in_colaContractDecl1096 = new BitSet(new long[]{0x0000001000000008L});
    public static final BitSet FOLLOW_contractItem_in_colaContractDecl1124 = new BitSet(new long[]{0x0000001000000008L});
    public static final BitSet FOLLOW_contractScopeAtom_in_contractScope1145 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_contractScopeRank_in_contractScope1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_contractScopeAtom0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_contractScopeRank0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ITEM_in_contractItem1209 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_contractItem1213 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_contractItemProp_in_contractItem1217 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_PROPERTY_in_contractItemProp1236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_contractItemProp1240 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_AT_TYPE_in_contractItemProp1243 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_base_type_in_contractItemProp1245 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_const_value_in_contractItemProp1247 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_ARRAY_in_contractItemProp1249 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_contractItemPropRank_in_contractItemProp1342 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_AT_APPLY_in_contractItemProp1374 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PRE_in_contractItemProp1378 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_contractItemProp1381 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_POST_in_contractItemProp1392 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_contractItemProp1395 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_INV_in_contractItemProp1406 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_contractItemProp1409 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_AT_ALTERABLE_in_contractItemProp1449 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_AT_NEGOTIABLE_in_contractItemProp1452 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_atDescription_in_contractItemProp1455 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_AT_PRIORITY_in_contractItemProp1487 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_base_type_in_contractItemProp1489 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_const_value_in_contractItemProp1491 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REQUIRED_in_contractItemPropRank1538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MANDATORY_in_contractItemPropRank1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_contractItemPropRank1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTRACT_in_colaContractDef1568 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaContractDef1572 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_scoped_name_in_colaContractDef1574 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_colaContractItemDef_in_colaContractDef1578 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_IDENT_in_colaContractItemDef1593 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_colaItemDef_in_colaContractItemDef1596 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_colaItemDef1621 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaItemDef1625 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_const_value_in_colaItemDef1656 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_AT_SPEC_in_colaSpecification1700 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_a3dsStage_in_colaSpecification1702 = new BitSet(new long[]{0x0000000000000000L,0x0000000007000000L});
    public static final BitSet FOLLOW_a3dsEnvironment_in_colaSpecification1704 = new BitSet(new long[]{0x0000000000040000L,0x0000000018000000L});
    public static final BitSet FOLLOW_a3dsCLevel_in_colaSpecification1706 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_AT_LANGUAGE_in_colaSpecification1709 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaSpecification1711 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_SPEC_in_colaSpecification1715 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaSpecification1717 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cpp_directive_in_colaSpecification1720 = new BitSet(new long[]{0x00003208000E0218L});
    public static final BitSet FOLLOW_colaDefinition_in_colaSpecification1722 = new BitSet(new long[]{0x00003208000E0218L});
    public static final BitSet FOLLOW_colaFunction_in_colaDefinition1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDecl_in_colaDefinition1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaContractDecl_in_colaDefinition1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPackage_in_colaDefinition1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaElement_in_colaDefinition1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaFacility_in_colaDefinition1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaTypeDef_in_colaDefinition1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaStruct_in_colaDefinition1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cpp_directive_in_colaDefinition1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CPP_DIRECTIVE_in_cpp_directive1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACKAGE_in_colaPackage1815 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaPackage1819 = new BitSet(new long[]{0x00003208000E0258L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaPackage1825 = new BitSet(new long[]{0x00003208000E0258L});
    public static final BitSet FOLLOW_colaDefinition_in_colaPackage1830 = new BitSet(new long[]{0x00003208000E0258L});
    public static final BitSet FOLLOW_inline_code_in_colaPackage1833 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_ELEMENT_in_colaElement1857 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaElement1861 = new BitSet(new long[]{0x00000C084030C248L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaElement1896 = new BitSet(new long[]{0x00000C084030C248L});
    public static final BitSet FOLLOW_colaContractDef_in_colaElement1932 = new BitSet(new long[]{0x00000C084030C048L});
    public static final BitSet FOLLOW_atVisibility_in_colaElement1966 = new BitSet(new long[]{0x00000C000030C048L});
    public static final BitSet FOLLOW_aExtends_in_colaElement2000 = new BitSet(new long[]{0x00000C0000308048L});
    public static final BitSet FOLLOW_aProvides_in_colaElement2003 = new BitSet(new long[]{0x0000080000308048L});
    public static final BitSet FOLLOW_aRequires_in_colaElement2006 = new BitSet(new long[]{0x0000080000300048L});
    public static final BitSet FOLLOW_elementBody_in_colaElement2038 = new BitSet(new long[]{0x0000080000300048L});
    public static final BitSet FOLLOW_elementContains_in_elementBody2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaAttribute_in_elementBody2092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaAction_in_elementBody2096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inline_code_in_elementBody2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_CONTAINS_in_elementContains2116 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_elementContains2120 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_scoped_name_in_elementContains2124 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FACILITY_in_colaFacility2149 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaFacility2153 = new BitSet(new long[]{0x000000084030C208L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaFacility2188 = new BitSet(new long[]{0x000000084030C208L});
    public static final BitSet FOLLOW_colaContractDef_in_colaFacility2224 = new BitSet(new long[]{0x000000084030C008L});
    public static final BitSet FOLLOW_atVisibility_in_colaFacility2258 = new BitSet(new long[]{0x000000000030C008L});
    public static final BitSet FOLLOW_aExtends_in_colaFacility2292 = new BitSet(new long[]{0x0000000000308008L});
    public static final BitSet FOLLOW_aRequires_in_colaFacility2295 = new BitSet(new long[]{0x0000000000300008L});
    public static final BitSet FOLLOW_facilityBody_in_colaFacility2327 = new BitSet(new long[]{0x0000000000300008L});
    public static final BitSet FOLLOW_colaAttribute_in_facilityBody2376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaAction_in_facilityBody2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_colaAction2402 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaAction2409 = new BitSet(new long[]{0x03FFC00000000AC8L});
    public static final BitSet FOLLOW_simple_type_in_colaAction2414 = new BitSet(new long[]{0x00004000000002C8L});
    public static final BitSet FOLLOW_void_type_in_colaAction2420 = new BitSet(new long[]{0x00000000000002C8L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaAction2425 = new BitSet(new long[]{0x00000000000002C8L});
    public static final BitSet FOLLOW_colaParameter_in_colaAction2430 = new BitSet(new long[]{0x00000000000000C8L});
    public static final BitSet FOLLOW_inline_code_in_colaAction2433 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_PARAMETER_in_colaParameter2455 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaParameter2459 = new BitSet(new long[]{0x03FF800000000888L});
    public static final BitSet FOLLOW_simple_type_in_colaParameter2464 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaParameter2480 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_TYPEDEF_in_colaTypeDef2534 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaTypeDef2540 = new BitSet(new long[]{0x03FF800000000888L});
    public static final BitSet FOLLOW_simple_type_in_colaTypeDef2545 = new BitSet(new long[]{0x0000000000000248L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaTypeDef2563 = new BitSet(new long[]{0x0000000000000248L});
    public static final BitSet FOLLOW_inline_code_in_colaTypeDef2583 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_colaAttribute2605 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaAttribute2609 = new BitSet(new long[]{0x03FF800000000888L});
    public static final BitSet FOLLOW_simple_type_in_colaAttribute2614 = new BitSet(new long[]{0x0000000000000248L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaAttribute2630 = new BitSet(new long[]{0x0000000000000248L});
    public static final BitSet FOLLOW_inline_code_in_colaAttribute2650 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_STRUCT_in_colaStruct2675 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaStruct2682 = new BitSet(new long[]{0x0000000000000248L,0x0000000000000020L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaStruct2775 = new BitSet(new long[]{0x0000000000000248L,0x0000000000000020L});
    public static final BitSet FOLLOW_colaMember_in_colaStruct2780 = new BitSet(new long[]{0x0000000000000048L,0x0000000000000020L});
    public static final BitSet FOLLOW_inline_code_in_colaStruct2786 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_MEMBER_in_colaMember2811 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaMember2818 = new BitSet(new long[]{0x03FF800000000888L});
    public static final BitSet FOLLOW_simple_type_in_colaMember2823 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaMember2840 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_AT_SCOPE_in_scoped_name2895 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name2902 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_VOID_in_void_type2929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_name_in_simple_type2949 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_base_type_in_simple_type2953 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ARRAY_in_simple_type2956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHORT_in_base_type2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_base_type2987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_base_type2993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTET_in_base_type2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_in_base_type3005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINARY_in_base_type3011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_base_type3017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_base_type3023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_base_type3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_base_type3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_base_type3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value3091 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_const_value3095 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_VAL_INTEGER_in_const_value3099 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value3133 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OCTET_in_const_value3137 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_VAL_OCT_in_const_value3143 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value3181 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_HEX_in_const_value3185 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_VAL_HEX_in_const_value3193 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value3231 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BINARY_in_const_value3235 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_VAL_BINARY_in_const_value3240 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value3275 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FLOAT_in_const_value3279 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_VAL_FLOAT_in_const_value3285 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value3321 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_in_const_value3325 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_VAL_CHAR_in_const_value3332 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value3369 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_const_value3373 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_const_value3376 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value3414 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOLEAN_in_const_value3418 = new BitSet(new long[]{0x0000000200000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_boolean_value_in_const_value3420 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VAL_STRING_in_string_value3448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLA_NULL_in_string_value3454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLA_TRUE_in_boolean_value3478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLA_FALSE_in_boolean_value3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_LANGUAGE_in_inline_code3509 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_string_value_in_inline_code3511 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_INLINE_CODE_in_inline_code3513 = new BitSet(new long[]{0x0000000000000008L});

}