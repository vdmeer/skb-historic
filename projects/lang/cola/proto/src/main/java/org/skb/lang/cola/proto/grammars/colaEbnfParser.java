// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g 2011-07-07 22:24:36

  package org.skb.lang.cola.proto.grammars;

  import java.util.LinkedHashMap;

  import org.skb.lang.cola.proto.ColaPass1_Ebnf;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.cola.proto.ColaTokensConstants;
  import org.skb.util.ReportManager;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class colaEbnfParser extends Parser {
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


        public colaEbnfParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public colaEbnfParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return colaEbnfParser.tokenNames; }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g"; }


      private LanguageTokens myTokens;
      private ColaPass1_Ebnf pass;
      private Token base_type;
      private boolean isArray=false;

      public void init() {
        this.pass=new ColaPass1_Ebnf();
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:115:1: a3dsStage : ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' );
    public final colaEbnfParser.a3dsStage_return a3dsStage() throws RecognitionException {
        colaEbnfParser.a3dsStage_return retval = new colaEbnfParser.a3dsStage_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set1=null;

        CommonTree set1_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:115:25: ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set1=(Token)input.LT(1);
            if ( (input.LA(1)>=82 && input.LA(1)<=87) ) {
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:116:1: a3dsEnvironment : ( 'production' | 'test' | 'demonstrator' );
    public final colaEbnfParser.a3dsEnvironment_return a3dsEnvironment() throws RecognitionException {
        colaEbnfParser.a3dsEnvironment_return retval = new colaEbnfParser.a3dsEnvironment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set2=null;

        CommonTree set2_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:116:25: ( 'production' | 'test' | 'demonstrator' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set2=(Token)input.LT(1);
            if ( (input.LA(1)>=88 && input.LA(1)<=90) ) {
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:117:1: a3dsCLevel : ( 'business' | 'system' | 'element' );
    public final colaEbnfParser.a3dsCLevel_return a3dsCLevel() throws RecognitionException {
        colaEbnfParser.a3dsCLevel_return retval = new colaEbnfParser.a3dsCLevel_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set3=null;

        CommonTree set3_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:117:25: ( 'business' | 'system' | 'element' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set3=(Token)input.LT(1);
            if ( input.LA(1)==ELEMENT||(input.LA(1)>=91 && input.LA(1)<=92) ) {
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

    public static class colaFunction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaFunction"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:119:1: colaFunction : FUNCTION s= IDENT ':' AT_LANGUAGE '=' string_value PARAMETER '(' ( colaFunctionParam )* ')' AT_RETURN '(' base_type ( array )? ')' ';' -> ^( FUNCTION IDENT ( colaFunctionParam )* base_type ( array )? ^( AT_LANGUAGE string_value ) ) ;
    public final colaEbnfParser.colaFunction_return colaFunction() throws RecognitionException {
        colaEbnfParser.colaFunction_return retval = new colaEbnfParser.colaFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token FUNCTION4=null;
        Token char_literal5=null;
        Token AT_LANGUAGE6=null;
        Token char_literal7=null;
        Token PARAMETER9=null;
        Token char_literal10=null;
        Token char_literal12=null;
        Token AT_RETURN13=null;
        Token char_literal14=null;
        Token char_literal17=null;
        Token char_literal18=null;
        colaEbnfParser.string_value_return string_value8 = null;

        colaEbnfParser.colaFunctionParam_return colaFunctionParam11 = null;

        colaEbnfParser.base_type_return base_type15 = null;

        colaEbnfParser.array_return array16 = null;


        CommonTree s_tree=null;
        CommonTree FUNCTION4_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree AT_LANGUAGE6_tree=null;
        CommonTree char_literal7_tree=null;
        CommonTree PARAMETER9_tree=null;
        CommonTree char_literal10_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree AT_RETURN13_tree=null;
        CommonTree char_literal14_tree=null;
        CommonTree char_literal17_tree=null;
        CommonTree char_literal18_tree=null;
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_AT_RETURN=new RewriteRuleTokenStream(adaptor,"token AT_RETURN");
        RewriteRuleTokenStream stream_AT_LANGUAGE=new RewriteRuleTokenStream(adaptor,"token AT_LANGUAGE");
        RewriteRuleTokenStream stream_PARAMETER=new RewriteRuleTokenStream(adaptor,"token PARAMETER");
        RewriteRuleSubtreeStream stream_colaFunctionParam=new RewriteRuleSubtreeStream(adaptor,"rule colaFunctionParam");
        RewriteRuleSubtreeStream stream_base_type=new RewriteRuleSubtreeStream(adaptor,"rule base_type");
        RewriteRuleSubtreeStream stream_string_value=new RewriteRuleSubtreeStream(adaptor,"rule string_value");
        RewriteRuleSubtreeStream stream_array=new RewriteRuleSubtreeStream(adaptor,"rule array");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:119:25: ( FUNCTION s= IDENT ':' AT_LANGUAGE '=' string_value PARAMETER '(' ( colaFunctionParam )* ')' AT_RETURN '(' base_type ( array )? ')' ';' -> ^( FUNCTION IDENT ( colaFunctionParam )* base_type ( array )? ^( AT_LANGUAGE string_value ) ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:119:27: FUNCTION s= IDENT ':' AT_LANGUAGE '=' string_value PARAMETER '(' ( colaFunctionParam )* ')' AT_RETURN '(' base_type ( array )? ')' ';'
            {
            FUNCTION4=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_colaFunction174);  
            stream_FUNCTION.add(FUNCTION4);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaFunction178);  
            stream_IDENT.add(s);

            char_literal5=(Token)match(input,93,FOLLOW_93_in_colaFunction180);  
            stream_93.add(char_literal5);

            AT_LANGUAGE6=(Token)match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_colaFunction182);  
            stream_AT_LANGUAGE.add(AT_LANGUAGE6);

            char_literal7=(Token)match(input,94,FOLLOW_94_in_colaFunction184);  
            stream_94.add(char_literal7);

            pushFollow(FOLLOW_string_value_in_colaFunction186);
            string_value8=string_value();

            state._fsp--;

            stream_string_value.add(string_value8.getTree());
            PARAMETER9=(Token)match(input,PARAMETER,FOLLOW_PARAMETER_in_colaFunction188);  
            stream_PARAMETER.add(PARAMETER9);

            char_literal10=(Token)match(input,95,FOLLOW_95_in_colaFunction190);  
            stream_95.add(char_literal10);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:119:91: ( colaFunctionParam )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==98) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:119:91: colaFunctionParam
            	    {
            	    pushFollow(FOLLOW_colaFunctionParam_in_colaFunction192);
            	    colaFunctionParam11=colaFunctionParam();

            	    state._fsp--;

            	    stream_colaFunctionParam.add(colaFunctionParam11.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            char_literal12=(Token)match(input,96,FOLLOW_96_in_colaFunction195);  
            stream_96.add(char_literal12);

            AT_RETURN13=(Token)match(input,AT_RETURN,FOLLOW_AT_RETURN_in_colaFunction197);  
            stream_AT_RETURN.add(AT_RETURN13);

            char_literal14=(Token)match(input,95,FOLLOW_95_in_colaFunction199);  
            stream_95.add(char_literal14);

            pushFollow(FOLLOW_base_type_in_colaFunction201);
            base_type15=base_type();

            state._fsp--;

            stream_base_type.add(base_type15.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:119:138: ( array )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==98) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:119:138: array
                    {
                    pushFollow(FOLLOW_array_in_colaFunction203);
                    array16=array();

                    state._fsp--;

                    stream_array.add(array16.getTree());

                    }
                    break;

            }

            char_literal17=(Token)match(input,96,FOLLOW_96_in_colaFunction206);  
            stream_96.add(char_literal17);

            char_literal18=(Token)match(input,97,FOLLOW_97_in_colaFunction208);  
            stream_97.add(char_literal18);

            this.pass.putAtom(s,ColaTokensConstants.colaFUNCTION, this.base_type, this.isArray);
            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: string_value, FUNCTION, base_type, colaFunctionParam, IDENT, AT_LANGUAGE, array
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 122:27: -> ^( FUNCTION IDENT ( colaFunctionParam )* base_type ( array )? ^( AT_LANGUAGE string_value ) )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:122:30: ^( FUNCTION IDENT ( colaFunctionParam )* base_type ( array )? ^( AT_LANGUAGE string_value ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_FUNCTION.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:122:47: ( colaFunctionParam )*
                while ( stream_colaFunctionParam.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaFunctionParam.nextTree());

                }
                stream_colaFunctionParam.reset();
                adaptor.addChild(root_1, stream_base_type.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:122:76: ( array )?
                if ( stream_array.hasNext() ) {
                    adaptor.addChild(root_1, stream_array.nextTree());

                }
                stream_array.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:122:83: ^( AT_LANGUAGE string_value )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_LANGUAGE.nextNode(), root_2);

                adaptor.addChild(root_2, stream_string_value.nextTree());

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
    // $ANTLR end "colaFunction"

    public static class colaFunctionParam_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaFunctionParam"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:124:1: colaFunctionParam : '[' base_type ( array )? IDENT ']' -> ^( PARAMETER base_type ( array )? IDENT ) ;
    public final colaEbnfParser.colaFunctionParam_return colaFunctionParam() throws RecognitionException {
        colaEbnfParser.colaFunctionParam_return retval = new colaEbnfParser.colaFunctionParam_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal19=null;
        Token IDENT22=null;
        Token char_literal23=null;
        colaEbnfParser.base_type_return base_type20 = null;

        colaEbnfParser.array_return array21 = null;


        CommonTree char_literal19_tree=null;
        CommonTree IDENT22_tree=null;
        CommonTree char_literal23_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleSubtreeStream stream_base_type=new RewriteRuleSubtreeStream(adaptor,"rule base_type");
        RewriteRuleSubtreeStream stream_array=new RewriteRuleSubtreeStream(adaptor,"rule array");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:124:25: ( '[' base_type ( array )? IDENT ']' -> ^( PARAMETER base_type ( array )? IDENT ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:124:27: '[' base_type ( array )? IDENT ']'
            {
            char_literal19=(Token)match(input,98,FOLLOW_98_in_colaFunctionParam352);  
            stream_98.add(char_literal19);

            pushFollow(FOLLOW_base_type_in_colaFunctionParam354);
            base_type20=base_type();

            state._fsp--;

            stream_base_type.add(base_type20.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:124:41: ( array )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==98) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:124:41: array
                    {
                    pushFollow(FOLLOW_array_in_colaFunctionParam356);
                    array21=array();

                    state._fsp--;

                    stream_array.add(array21.getTree());

                    }
                    break;

            }

            IDENT22=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaFunctionParam359);  
            stream_IDENT.add(IDENT22);

            char_literal23=(Token)match(input,99,FOLLOW_99_in_colaFunctionParam361);  
            stream_99.add(char_literal23);



            // AST REWRITE
            // elements: array, base_type, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 125:27: -> ^( PARAMETER base_type ( array )? IDENT )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:125:30: ^( PARAMETER base_type ( array )? IDENT )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMETER, "PARAMETER"), root_1);

                adaptor.addChild(root_1, stream_base_type.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:125:52: ( array )?
                if ( stream_array.hasNext() ) {
                    adaptor.addChild(root_1, stream_array.nextTree());

                }
                stream_array.reset();
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
    // $ANTLR end "colaFunctionParam"

    public static class colaPropertyDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaPropertyDecl"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:127:1: colaPropertyDecl : PROPERTY s= IDENT ':' AT_TYPE '(' base_type ( array )? '=' const_value ')' AT_SCOPE '(' ( propertyScope )+ ')' propertyApply ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( AT_EXTENDS '(' (ext+= scoped_name )+ ')' )? ( AT_REQUIRES '(' (req+= scoped_name )+ ')' )? ( AT_PRIORITY '(' base_type '=' const_value ')' )? ';' -> ^( PROPERTY IDENT ^( AT_TYPE base_type const_value ( array )? ) ^( AT_SCOPE ( propertyScope )+ ) propertyApply ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_EXTENDS ( $ext)+ ) )? ( ^( AT_REQUIRES ( $req)+ ) )? ( ^( AT_PRIORITY base_type const_value ) )? ) ;
    public final colaEbnfParser.colaPropertyDecl_return colaPropertyDecl() throws RecognitionException {
        colaEbnfParser.colaPropertyDecl_return retval = new colaEbnfParser.colaPropertyDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token PROPERTY24=null;
        Token char_literal25=null;
        Token AT_TYPE26=null;
        Token char_literal27=null;
        Token char_literal30=null;
        Token char_literal32=null;
        Token AT_SCOPE33=null;
        Token char_literal34=null;
        Token char_literal36=null;
        Token AT_ALTERABLE39=null;
        Token AT_NEGOTIABLE40=null;
        Token AT_EXTENDS42=null;
        Token char_literal43=null;
        Token char_literal44=null;
        Token AT_REQUIRES45=null;
        Token char_literal46=null;
        Token char_literal47=null;
        Token AT_PRIORITY48=null;
        Token char_literal49=null;
        Token char_literal51=null;
        Token char_literal53=null;
        Token char_literal54=null;
        List list_ext=null;
        List list_req=null;
        colaEbnfParser.base_type_return base_type28 = null;

        colaEbnfParser.array_return array29 = null;

        colaEbnfParser.const_value_return const_value31 = null;

        colaEbnfParser.propertyScope_return propertyScope35 = null;

        colaEbnfParser.propertyApply_return propertyApply37 = null;

        colaEbnfParser.atVisibility_return atVisibility38 = null;

        colaEbnfParser.atDescription_return atDescription41 = null;

        colaEbnfParser.base_type_return base_type50 = null;

        colaEbnfParser.const_value_return const_value52 = null;

        RuleReturnScope ext = null;
        RuleReturnScope req = null;
        CommonTree s_tree=null;
        CommonTree PROPERTY24_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree AT_TYPE26_tree=null;
        CommonTree char_literal27_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree AT_SCOPE33_tree=null;
        CommonTree char_literal34_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree AT_ALTERABLE39_tree=null;
        CommonTree AT_NEGOTIABLE40_tree=null;
        CommonTree AT_EXTENDS42_tree=null;
        CommonTree char_literal43_tree=null;
        CommonTree char_literal44_tree=null;
        CommonTree AT_REQUIRES45_tree=null;
        CommonTree char_literal46_tree=null;
        CommonTree char_literal47_tree=null;
        CommonTree AT_PRIORITY48_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree char_literal51_tree=null;
        CommonTree char_literal53_tree=null;
        CommonTree char_literal54_tree=null;
        RewriteRuleTokenStream stream_AT_SCOPE=new RewriteRuleTokenStream(adaptor,"token AT_SCOPE");
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_AT_ALTERABLE=new RewriteRuleTokenStream(adaptor,"token AT_ALTERABLE");
        RewriteRuleTokenStream stream_PROPERTY=new RewriteRuleTokenStream(adaptor,"token PROPERTY");
        RewriteRuleTokenStream stream_AT_REQUIRES=new RewriteRuleTokenStream(adaptor,"token AT_REQUIRES");
        RewriteRuleTokenStream stream_AT_NEGOTIABLE=new RewriteRuleTokenStream(adaptor,"token AT_NEGOTIABLE");
        RewriteRuleTokenStream stream_AT_PRIORITY=new RewriteRuleTokenStream(adaptor,"token AT_PRIORITY");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_AT_TYPE=new RewriteRuleTokenStream(adaptor,"token AT_TYPE");
        RewriteRuleTokenStream stream_AT_EXTENDS=new RewriteRuleTokenStream(adaptor,"token AT_EXTENDS");
        RewriteRuleSubtreeStream stream_propertyScope=new RewriteRuleSubtreeStream(adaptor,"rule propertyScope");
        RewriteRuleSubtreeStream stream_propertyApply=new RewriteRuleSubtreeStream(adaptor,"rule propertyApply");
        RewriteRuleSubtreeStream stream_const_value=new RewriteRuleSubtreeStream(adaptor,"rule const_value");
        RewriteRuleSubtreeStream stream_base_type=new RewriteRuleSubtreeStream(adaptor,"rule base_type");
        RewriteRuleSubtreeStream stream_atVisibility=new RewriteRuleSubtreeStream(adaptor,"rule atVisibility");
        RewriteRuleSubtreeStream stream_atDescription=new RewriteRuleSubtreeStream(adaptor,"rule atDescription");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        RewriteRuleSubtreeStream stream_array=new RewriteRuleSubtreeStream(adaptor,"rule array");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:127:25: ( PROPERTY s= IDENT ':' AT_TYPE '(' base_type ( array )? '=' const_value ')' AT_SCOPE '(' ( propertyScope )+ ')' propertyApply ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( AT_EXTENDS '(' (ext+= scoped_name )+ ')' )? ( AT_REQUIRES '(' (req+= scoped_name )+ ')' )? ( AT_PRIORITY '(' base_type '=' const_value ')' )? ';' -> ^( PROPERTY IDENT ^( AT_TYPE base_type const_value ( array )? ) ^( AT_SCOPE ( propertyScope )+ ) propertyApply ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_EXTENDS ( $ext)+ ) )? ( ^( AT_REQUIRES ( $req)+ ) )? ( ^( AT_PRIORITY base_type const_value ) )? ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:127:27: PROPERTY s= IDENT ':' AT_TYPE '(' base_type ( array )? '=' const_value ')' AT_SCOPE '(' ( propertyScope )+ ')' propertyApply ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( AT_EXTENDS '(' (ext+= scoped_name )+ ')' )? ( AT_REQUIRES '(' (req+= scoped_name )+ ')' )? ( AT_PRIORITY '(' base_type '=' const_value ')' )? ';'
            {
            PROPERTY24=(Token)match(input,PROPERTY,FOLLOW_PROPERTY_in_colaPropertyDecl415);  
            stream_PROPERTY.add(PROPERTY24);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaPropertyDecl419);  
            stream_IDENT.add(s);

            char_literal25=(Token)match(input,93,FOLLOW_93_in_colaPropertyDecl421);  
            stream_93.add(char_literal25);

            AT_TYPE26=(Token)match(input,AT_TYPE,FOLLOW_AT_TYPE_in_colaPropertyDecl449);  
            stream_AT_TYPE.add(AT_TYPE26);

            char_literal27=(Token)match(input,95,FOLLOW_95_in_colaPropertyDecl451);  
            stream_95.add(char_literal27);

            pushFollow(FOLLOW_base_type_in_colaPropertyDecl453);
            base_type28=base_type();

            state._fsp--;

            stream_base_type.add(base_type28.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:128:49: ( array )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==98) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:128:49: array
                    {
                    pushFollow(FOLLOW_array_in_colaPropertyDecl455);
                    array29=array();

                    state._fsp--;

                    stream_array.add(array29.getTree());

                    }
                    break;

            }

            char_literal30=(Token)match(input,94,FOLLOW_94_in_colaPropertyDecl458);  
            stream_94.add(char_literal30);

            pushFollow(FOLLOW_const_value_in_colaPropertyDecl460);
            const_value31=const_value();

            state._fsp--;

            stream_const_value.add(const_value31.getTree());
            char_literal32=(Token)match(input,96,FOLLOW_96_in_colaPropertyDecl462);  
            stream_96.add(char_literal32);

            this.pass.putAtom(s,ColaTokensConstants.colaPROPERTY, this.base_type, this.isArray);
            this.isArray=false;
            AT_SCOPE33=(Token)match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_colaPropertyDecl546);  
            stream_AT_SCOPE.add(AT_SCOPE33);

            char_literal34=(Token)match(input,95,FOLLOW_95_in_colaPropertyDecl548);  
            stream_95.add(char_literal34);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:131:40: ( propertyScope )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==98) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:131:40: propertyScope
            	    {
            	    pushFollow(FOLLOW_propertyScope_in_colaPropertyDecl550);
            	    propertyScope35=propertyScope();

            	    state._fsp--;

            	    stream_propertyScope.add(propertyScope35.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            char_literal36=(Token)match(input,96,FOLLOW_96_in_colaPropertyDecl553);  
            stream_96.add(char_literal36);

            this.pass.propertyDeclScopeFinish();
            pushFollow(FOLLOW_propertyApply_in_colaPropertyDecl609);
            propertyApply37=propertyApply();

            state._fsp--;

            stream_propertyApply.add(propertyApply37.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:133:41: ( atVisibility )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==AT_VISIBILITY) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:133:41: atVisibility
                    {
                    pushFollow(FOLLOW_atVisibility_in_colaPropertyDecl611);
                    atVisibility38=atVisibility();

                    state._fsp--;

                    stream_atVisibility.add(atVisibility38.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:133:55: ( AT_ALTERABLE )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==AT_ALTERABLE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:133:55: AT_ALTERABLE
                    {
                    AT_ALTERABLE39=(Token)match(input,AT_ALTERABLE,FOLLOW_AT_ALTERABLE_in_colaPropertyDecl614);  
                    stream_AT_ALTERABLE.add(AT_ALTERABLE39);


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:133:69: ( AT_NEGOTIABLE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==AT_NEGOTIABLE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:133:69: AT_NEGOTIABLE
                    {
                    AT_NEGOTIABLE40=(Token)match(input,AT_NEGOTIABLE,FOLLOW_AT_NEGOTIABLE_in_colaPropertyDecl617);  
                    stream_AT_NEGOTIABLE.add(AT_NEGOTIABLE40);


                    }
                    break;

            }

            pushFollow(FOLLOW_atDescription_in_colaPropertyDecl620);
            atDescription41=atDescription();

            state._fsp--;

            stream_atDescription.add(atDescription41.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:134:27: ( AT_EXTENDS '(' (ext+= scoped_name )+ ')' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==AT_EXTENDS) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:134:28: AT_EXTENDS '(' (ext+= scoped_name )+ ')'
                    {
                    AT_EXTENDS42=(Token)match(input,AT_EXTENDS,FOLLOW_AT_EXTENDS_in_colaPropertyDecl649);  
                    stream_AT_EXTENDS.add(AT_EXTENDS42);

                    char_literal43=(Token)match(input,95,FOLLOW_95_in_colaPropertyDecl652);  
                    stream_95.add(char_literal43);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:134:47: (ext+= scoped_name )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==IDENT) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:134:47: ext+= scoped_name
                    	    {
                    	    pushFollow(FOLLOW_scoped_name_in_colaPropertyDecl656);
                    	    ext=scoped_name();

                    	    state._fsp--;

                    	    stream_scoped_name.add(ext.getTree());
                    	    if (list_ext==null) list_ext=new ArrayList();
                    	    list_ext.add(ext.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    char_literal44=(Token)match(input,96,FOLLOW_96_in_colaPropertyDecl659);  
                    stream_96.add(char_literal44);


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:135:27: ( AT_REQUIRES '(' (req+= scoped_name )+ ')' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==AT_REQUIRES) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:135:28: AT_REQUIRES '(' (req+= scoped_name )+ ')'
                    {
                    AT_REQUIRES45=(Token)match(input,AT_REQUIRES,FOLLOW_AT_REQUIRES_in_colaPropertyDecl690);  
                    stream_AT_REQUIRES.add(AT_REQUIRES45);

                    char_literal46=(Token)match(input,95,FOLLOW_95_in_colaPropertyDecl692);  
                    stream_95.add(char_literal46);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:135:47: (req+= scoped_name )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==IDENT) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:135:47: req+= scoped_name
                    	    {
                    	    pushFollow(FOLLOW_scoped_name_in_colaPropertyDecl696);
                    	    req=scoped_name();

                    	    state._fsp--;

                    	    stream_scoped_name.add(req.getTree());
                    	    if (list_req==null) list_req=new ArrayList();
                    	    list_req.add(req.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    char_literal47=(Token)match(input,96,FOLLOW_96_in_colaPropertyDecl699);  
                    stream_96.add(char_literal47);


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:136:27: ( AT_PRIORITY '(' base_type '=' const_value ')' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==AT_PRIORITY) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:136:28: AT_PRIORITY '(' base_type '=' const_value ')'
                    {
                    AT_PRIORITY48=(Token)match(input,AT_PRIORITY,FOLLOW_AT_PRIORITY_in_colaPropertyDecl730);  
                    stream_AT_PRIORITY.add(AT_PRIORITY48);

                    char_literal49=(Token)match(input,95,FOLLOW_95_in_colaPropertyDecl732);  
                    stream_95.add(char_literal49);

                    pushFollow(FOLLOW_base_type_in_colaPropertyDecl734);
                    base_type50=base_type();

                    state._fsp--;

                    stream_base_type.add(base_type50.getTree());
                    char_literal51=(Token)match(input,94,FOLLOW_94_in_colaPropertyDecl736);  
                    stream_94.add(char_literal51);

                    pushFollow(FOLLOW_const_value_in_colaPropertyDecl738);
                    const_value52=const_value();

                    state._fsp--;

                    stream_const_value.add(const_value52.getTree());
                    char_literal53=(Token)match(input,96,FOLLOW_96_in_colaPropertyDecl740);  
                    stream_96.add(char_literal53);


                    }
                    break;

            }

            char_literal54=(Token)match(input,97,FOLLOW_97_in_colaPropertyDecl770);  
            stream_97.add(char_literal54);

            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: AT_REQUIRES, AT_ALTERABLE, PROPERTY, const_value, AT_EXTENDS, array, AT_TYPE, AT_SCOPE, propertyScope, base_type, req, atDescription, atVisibility, base_type, propertyApply, AT_NEGOTIABLE, const_value, ext, AT_PRIORITY, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: req, ext
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_req=new RewriteRuleSubtreeStream(adaptor,"token req",list_req);
            RewriteRuleSubtreeStream stream_ext=new RewriteRuleSubtreeStream(adaptor,"token ext",list_ext);
            root_0 = (CommonTree)adaptor.nil();
            // 139:27: -> ^( PROPERTY IDENT ^( AT_TYPE base_type const_value ( array )? ) ^( AT_SCOPE ( propertyScope )+ ) propertyApply ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_EXTENDS ( $ext)+ ) )? ( ^( AT_REQUIRES ( $req)+ ) )? ( ^( AT_PRIORITY base_type const_value ) )? )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:139:30: ^( PROPERTY IDENT ^( AT_TYPE base_type const_value ( array )? ) ^( AT_SCOPE ( propertyScope )+ ) propertyApply ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_EXTENDS ( $ext)+ ) )? ( ^( AT_REQUIRES ( $req)+ ) )? ( ^( AT_PRIORITY base_type const_value ) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_PROPERTY.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:139:47: ^( AT_TYPE base_type const_value ( array )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_TYPE.nextNode(), root_2);

                adaptor.addChild(root_2, stream_base_type.nextTree());
                adaptor.addChild(root_2, stream_const_value.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:139:79: ( array )?
                if ( stream_array.hasNext() ) {
                    adaptor.addChild(root_2, stream_array.nextTree());

                }
                stream_array.reset();

                adaptor.addChild(root_1, root_2);
                }
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:140:32: ^( AT_SCOPE ( propertyScope )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_SCOPE.nextNode(), root_2);

                if ( !(stream_propertyScope.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_propertyScope.hasNext() ) {
                    adaptor.addChild(root_2, stream_propertyScope.nextTree());

                }
                stream_propertyScope.reset();

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_propertyApply.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:141:46: ( atVisibility )?
                if ( stream_atVisibility.hasNext() ) {
                    adaptor.addChild(root_1, stream_atVisibility.nextTree());

                }
                stream_atVisibility.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:141:60: ( AT_ALTERABLE )?
                if ( stream_AT_ALTERABLE.hasNext() ) {
                    adaptor.addChild(root_1, stream_AT_ALTERABLE.nextNode());

                }
                stream_AT_ALTERABLE.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:141:74: ( AT_NEGOTIABLE )?
                if ( stream_AT_NEGOTIABLE.hasNext() ) {
                    adaptor.addChild(root_1, stream_AT_NEGOTIABLE.nextNode());

                }
                stream_AT_NEGOTIABLE.reset();
                adaptor.addChild(root_1, stream_atDescription.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:142:32: ( ^( AT_EXTENDS ( $ext)+ ) )?
                if ( stream_ext.hasNext()||stream_AT_EXTENDS.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:142:32: ^( AT_EXTENDS ( $ext)+ )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_EXTENDS.nextNode(), root_2);

                    if ( !(stream_ext.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_ext.hasNext() ) {
                        adaptor.addChild(root_2, stream_ext.nextTree());

                    }
                    stream_ext.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_ext.reset();
                stream_AT_EXTENDS.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:142:53: ( ^( AT_REQUIRES ( $req)+ ) )?
                if ( stream_AT_REQUIRES.hasNext()||stream_req.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:142:53: ^( AT_REQUIRES ( $req)+ )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_REQUIRES.nextNode(), root_2);

                    if ( !(stream_req.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_req.hasNext() ) {
                        adaptor.addChild(root_2, stream_req.nextTree());

                    }
                    stream_req.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_AT_REQUIRES.reset();
                stream_req.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:143:32: ( ^( AT_PRIORITY base_type const_value ) )?
                if ( stream_const_value.hasNext()||stream_AT_PRIORITY.hasNext()||stream_base_type.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:143:32: ^( AT_PRIORITY base_type const_value )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_PRIORITY.nextNode(), root_2);

                    adaptor.addChild(root_2, stream_base_type.nextTree());
                    adaptor.addChild(root_2, stream_const_value.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_const_value.reset();
                stream_AT_PRIORITY.reset();
                stream_base_type.reset();

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
    // $ANTLR end "colaPropertyDecl"

    public static class propertyScope_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyScope"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:146:1: propertyScope : '[' propertyScopeAtom ':' propertyScopeRank ']' -> ^( propertyScopeAtom propertyScopeRank ) ;
    public final colaEbnfParser.propertyScope_return propertyScope() throws RecognitionException {
        colaEbnfParser.propertyScope_return retval = new colaEbnfParser.propertyScope_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal55=null;
        Token char_literal57=null;
        Token char_literal59=null;
        colaEbnfParser.propertyScopeAtom_return propertyScopeAtom56 = null;

        colaEbnfParser.propertyScopeRank_return propertyScopeRank58 = null;


        CommonTree char_literal55_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree char_literal59_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleSubtreeStream stream_propertyScopeRank=new RewriteRuleSubtreeStream(adaptor,"rule propertyScopeRank");
        RewriteRuleSubtreeStream stream_propertyScopeAtom=new RewriteRuleSubtreeStream(adaptor,"rule propertyScopeAtom");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:146:25: ( '[' propertyScopeAtom ':' propertyScopeRank ']' -> ^( propertyScopeAtom propertyScopeRank ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:146:27: '[' propertyScopeAtom ':' propertyScopeRank ']'
            {
            char_literal55=(Token)match(input,98,FOLLOW_98_in_propertyScope1089);  
            stream_98.add(char_literal55);

            pushFollow(FOLLOW_propertyScopeAtom_in_propertyScope1091);
            propertyScopeAtom56=propertyScopeAtom();

            state._fsp--;

            stream_propertyScopeAtom.add(propertyScopeAtom56.getTree());
            char_literal57=(Token)match(input,93,FOLLOW_93_in_propertyScope1093);  
            stream_93.add(char_literal57);

            pushFollow(FOLLOW_propertyScopeRank_in_propertyScope1095);
            propertyScopeRank58=propertyScopeRank();

            state._fsp--;

            stream_propertyScopeRank.add(propertyScopeRank58.getTree());
            char_literal59=(Token)match(input,99,FOLLOW_99_in_propertyScope1097);  
            stream_99.add(char_literal59);



            // AST REWRITE
            // elements: propertyScopeAtom, propertyScopeRank
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 146:75: -> ^( propertyScopeAtom propertyScopeRank )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:146:78: ^( propertyScopeAtom propertyScopeRank )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_propertyScopeAtom.nextNode(), root_1);

                adaptor.addChild(root_1, stream_propertyScopeRank.nextTree());

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
    // $ANTLR end "propertyScope"

    public static class propertyScopeAtom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyScopeAtom"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:147:1: propertyScopeAtom : (s= PACKAGE | s= ELEMENT | s= FACILITY | s= ACTION | s= ATTRIBUTE | s= PARAMETER ) ;
    public final colaEbnfParser.propertyScopeAtom_return propertyScopeAtom() throws RecognitionException {
        colaEbnfParser.propertyScopeAtom_return retval = new colaEbnfParser.propertyScopeAtom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:147:25: ( (s= PACKAGE | s= ELEMENT | s= FACILITY | s= ACTION | s= ATTRIBUTE | s= PARAMETER ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:147:27: (s= PACKAGE | s= ELEMENT | s= FACILITY | s= ACTION | s= ATTRIBUTE | s= PARAMETER )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:147:27: (s= PACKAGE | s= ELEMENT | s= FACILITY | s= ACTION | s= ATTRIBUTE | s= PARAMETER )
            int alt14=6;
            switch ( input.LA(1) ) {
            case PACKAGE:
                {
                alt14=1;
                }
                break;
            case ELEMENT:
                {
                alt14=2;
                }
                break;
            case FACILITY:
                {
                alt14=3;
                }
                break;
            case ACTION:
                {
                alt14=4;
                }
                break;
            case ATTRIBUTE:
                {
                alt14=5;
                }
                break;
            case PARAMETER:
                {
                alt14=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:147:28: s= PACKAGE
                    {
                    s=(Token)match(input,PACKAGE,FOLLOW_PACKAGE_in_propertyScopeAtom1121); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:147:40: s= ELEMENT
                    {
                    s=(Token)match(input,ELEMENT,FOLLOW_ELEMENT_in_propertyScopeAtom1127); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:147:52: s= FACILITY
                    {
                    s=(Token)match(input,FACILITY,FOLLOW_FACILITY_in_propertyScopeAtom1133); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:147:65: s= ACTION
                    {
                    s=(Token)match(input,ACTION,FOLLOW_ACTION_in_propertyScopeAtom1139); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:147:76: s= ATTRIBUTE
                    {
                    s=(Token)match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_propertyScopeAtom1145); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:147:90: s= PARAMETER
                    {
                    s=(Token)match(input,PARAMETER,FOLLOW_PARAMETER_in_propertyScopeAtom1151); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;

            }

            this.pass.addPropertyDeclScopeAtom(s);

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
    // $ANTLR end "propertyScopeAtom"

    public static class propertyScopeRank_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyScopeRank"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:149:1: propertyScopeRank : (s= REQUIRED | s= MANDATORY | s= OPTIONAL | s= NOT_DEF ) ;
    public final colaEbnfParser.propertyScopeRank_return propertyScopeRank() throws RecognitionException {
        colaEbnfParser.propertyScopeRank_return retval = new colaEbnfParser.propertyScopeRank_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:149:25: ( (s= REQUIRED | s= MANDATORY | s= OPTIONAL | s= NOT_DEF ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:149:27: (s= REQUIRED | s= MANDATORY | s= OPTIONAL | s= NOT_DEF )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:149:27: (s= REQUIRED | s= MANDATORY | s= OPTIONAL | s= NOT_DEF )
            int alt15=4;
            switch ( input.LA(1) ) {
            case REQUIRED:
                {
                alt15=1;
                }
                break;
            case MANDATORY:
                {
                alt15=2;
                }
                break;
            case OPTIONAL:
                {
                alt15=3;
                }
                break;
            case NOT_DEF:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:149:28: s= REQUIRED
                    {
                    s=(Token)match(input,REQUIRED,FOLLOW_REQUIRED_in_propertyScopeRank1196); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:149:41: s= MANDATORY
                    {
                    s=(Token)match(input,MANDATORY,FOLLOW_MANDATORY_in_propertyScopeRank1202); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:149:55: s= OPTIONAL
                    {
                    s=(Token)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_propertyScopeRank1208); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:149:68: s= NOT_DEF
                    {
                    s=(Token)match(input,NOT_DEF,FOLLOW_NOT_DEF_in_propertyScopeRank1214); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;

            }

            this.pass.addPropertyDeclScopeRank(s);

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
    // $ANTLR end "propertyScopeRank"

    public static class propertyApply_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyApply"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:151:1: propertyApply : AT_APPLY '(' ( ( PRE ( '=' idpre+= scoped_name ( ',' idpre+= scoped_name )* )? ) | ( POST ( '=' idpost+= scoped_name ( ',' idpost+= scoped_name )* )? ) | ( INV ( '=' idinvt+= scoped_name ( ',' idinvt+= scoped_name )* )? ) )? ')' -> ^( AT_APPLY ( ^( PRE ( $idpre)* ) )? ( ^( POST ( $idpost)* ) )? ( ^( INV ( $idinvt)* ) )? ) ;
    public final colaEbnfParser.propertyApply_return propertyApply() throws RecognitionException {
        colaEbnfParser.propertyApply_return retval = new colaEbnfParser.propertyApply_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AT_APPLY60=null;
        Token char_literal61=null;
        Token PRE62=null;
        Token char_literal63=null;
        Token char_literal64=null;
        Token POST65=null;
        Token char_literal66=null;
        Token char_literal67=null;
        Token INV68=null;
        Token char_literal69=null;
        Token char_literal70=null;
        Token char_literal71=null;
        List list_idpre=null;
        List list_idpost=null;
        List list_idinvt=null;
        RuleReturnScope idpre = null;
        RuleReturnScope idpost = null;
        RuleReturnScope idinvt = null;
        CommonTree AT_APPLY60_tree=null;
        CommonTree char_literal61_tree=null;
        CommonTree PRE62_tree=null;
        CommonTree char_literal63_tree=null;
        CommonTree char_literal64_tree=null;
        CommonTree POST65_tree=null;
        CommonTree char_literal66_tree=null;
        CommonTree char_literal67_tree=null;
        CommonTree INV68_tree=null;
        CommonTree char_literal69_tree=null;
        CommonTree char_literal70_tree=null;
        CommonTree char_literal71_tree=null;
        RewriteRuleTokenStream stream_POST=new RewriteRuleTokenStream(adaptor,"token POST");
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_PRE=new RewriteRuleTokenStream(adaptor,"token PRE");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_AT_APPLY=new RewriteRuleTokenStream(adaptor,"token AT_APPLY");
        RewriteRuleTokenStream stream_INV=new RewriteRuleTokenStream(adaptor,"token INV");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:151:25: ( AT_APPLY '(' ( ( PRE ( '=' idpre+= scoped_name ( ',' idpre+= scoped_name )* )? ) | ( POST ( '=' idpost+= scoped_name ( ',' idpost+= scoped_name )* )? ) | ( INV ( '=' idinvt+= scoped_name ( ',' idinvt+= scoped_name )* )? ) )? ')' -> ^( AT_APPLY ( ^( PRE ( $idpre)* ) )? ( ^( POST ( $idpost)* ) )? ( ^( INV ( $idinvt)* ) )? ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:151:27: AT_APPLY '(' ( ( PRE ( '=' idpre+= scoped_name ( ',' idpre+= scoped_name )* )? ) | ( POST ( '=' idpost+= scoped_name ( ',' idpost+= scoped_name )* )? ) | ( INV ( '=' idinvt+= scoped_name ( ',' idinvt+= scoped_name )* )? ) )? ')'
            {
            AT_APPLY60=(Token)match(input,AT_APPLY,FOLLOW_AT_APPLY_in_propertyApply1260);  
            stream_AT_APPLY.add(AT_APPLY60);

            char_literal61=(Token)match(input,95,FOLLOW_95_in_propertyApply1262);  
            stream_95.add(char_literal61);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:151:40: ( ( PRE ( '=' idpre+= scoped_name ( ',' idpre+= scoped_name )* )? ) | ( POST ( '=' idpost+= scoped_name ( ',' idpost+= scoped_name )* )? ) | ( INV ( '=' idinvt+= scoped_name ( ',' idinvt+= scoped_name )* )? ) )?
            int alt22=4;
            switch ( input.LA(1) ) {
                case PRE:
                    {
                    alt22=1;
                    }
                    break;
                case POST:
                    {
                    alt22=2;
                    }
                    break;
                case INV:
                    {
                    alt22=3;
                    }
                    break;
            }

            switch (alt22) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:151:41: ( PRE ( '=' idpre+= scoped_name ( ',' idpre+= scoped_name )* )? )
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:151:41: ( PRE ( '=' idpre+= scoped_name ( ',' idpre+= scoped_name )* )? )
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:151:42: PRE ( '=' idpre+= scoped_name ( ',' idpre+= scoped_name )* )?
                    {
                    PRE62=(Token)match(input,PRE,FOLLOW_PRE_in_propertyApply1266);  
                    stream_PRE.add(PRE62);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:151:46: ( '=' idpre+= scoped_name ( ',' idpre+= scoped_name )* )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==94) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:151:47: '=' idpre+= scoped_name ( ',' idpre+= scoped_name )*
                            {
                            char_literal63=(Token)match(input,94,FOLLOW_94_in_propertyApply1269);  
                            stream_94.add(char_literal63);

                            pushFollow(FOLLOW_scoped_name_in_propertyApply1273);
                            idpre=scoped_name();

                            state._fsp--;

                            stream_scoped_name.add(idpre.getTree());
                            if (list_idpre==null) list_idpre=new ArrayList();
                            list_idpre.add(idpre.getTree());

                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:151:70: ( ',' idpre+= scoped_name )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==100) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:151:71: ',' idpre+= scoped_name
                            	    {
                            	    char_literal64=(Token)match(input,100,FOLLOW_100_in_propertyApply1276);  
                            	    stream_100.add(char_literal64);

                            	    pushFollow(FOLLOW_scoped_name_in_propertyApply1280);
                            	    idpre=scoped_name();

                            	    state._fsp--;

                            	    stream_scoped_name.add(idpre.getTree());
                            	    if (list_idpre==null) list_idpre=new ArrayList();
                            	    list_idpre.add(idpre.getTree());


                            	    }
                            	    break;

                            	default :
                            	    break loop16;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:152:41: ( POST ( '=' idpost+= scoped_name ( ',' idpost+= scoped_name )* )? )
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:152:41: ( POST ( '=' idpost+= scoped_name ( ',' idpost+= scoped_name )* )? )
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:152:42: POST ( '=' idpost+= scoped_name ( ',' idpost+= scoped_name )* )?
                    {
                    POST65=(Token)match(input,POST,FOLLOW_POST_in_propertyApply1330);  
                    stream_POST.add(POST65);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:152:47: ( '=' idpost+= scoped_name ( ',' idpost+= scoped_name )* )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==94) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:152:48: '=' idpost+= scoped_name ( ',' idpost+= scoped_name )*
                            {
                            char_literal66=(Token)match(input,94,FOLLOW_94_in_propertyApply1333);  
                            stream_94.add(char_literal66);

                            pushFollow(FOLLOW_scoped_name_in_propertyApply1337);
                            idpost=scoped_name();

                            state._fsp--;

                            stream_scoped_name.add(idpost.getTree());
                            if (list_idpost==null) list_idpost=new ArrayList();
                            list_idpost.add(idpost.getTree());

                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:152:72: ( ',' idpost+= scoped_name )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==100) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:152:73: ',' idpost+= scoped_name
                            	    {
                            	    char_literal67=(Token)match(input,100,FOLLOW_100_in_propertyApply1340);  
                            	    stream_100.add(char_literal67);

                            	    pushFollow(FOLLOW_scoped_name_in_propertyApply1344);
                            	    idpost=scoped_name();

                            	    state._fsp--;

                            	    stream_scoped_name.add(idpost.getTree());
                            	    if (list_idpost==null) list_idpost=new ArrayList();
                            	    list_idpost.add(idpost.getTree());


                            	    }
                            	    break;

                            	default :
                            	    break loop18;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:153:41: ( INV ( '=' idinvt+= scoped_name ( ',' idinvt+= scoped_name )* )? )
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:153:41: ( INV ( '=' idinvt+= scoped_name ( ',' idinvt+= scoped_name )* )? )
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:153:42: INV ( '=' idinvt+= scoped_name ( ',' idinvt+= scoped_name )* )?
                    {
                    INV68=(Token)match(input,INV,FOLLOW_INV_in_propertyApply1394);  
                    stream_INV.add(INV68);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:153:46: ( '=' idinvt+= scoped_name ( ',' idinvt+= scoped_name )* )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==94) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:153:47: '=' idinvt+= scoped_name ( ',' idinvt+= scoped_name )*
                            {
                            char_literal69=(Token)match(input,94,FOLLOW_94_in_propertyApply1397);  
                            stream_94.add(char_literal69);

                            pushFollow(FOLLOW_scoped_name_in_propertyApply1401);
                            idinvt=scoped_name();

                            state._fsp--;

                            stream_scoped_name.add(idinvt.getTree());
                            if (list_idinvt==null) list_idinvt=new ArrayList();
                            list_idinvt.add(idinvt.getTree());

                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:153:71: ( ',' idinvt+= scoped_name )*
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);

                                if ( (LA20_0==100) ) {
                                    alt20=1;
                                }


                                switch (alt20) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:153:72: ',' idinvt+= scoped_name
                            	    {
                            	    char_literal70=(Token)match(input,100,FOLLOW_100_in_propertyApply1404);  
                            	    stream_100.add(char_literal70);

                            	    pushFollow(FOLLOW_scoped_name_in_propertyApply1408);
                            	    idinvt=scoped_name();

                            	    state._fsp--;

                            	    stream_scoped_name.add(idinvt.getTree());
                            	    if (list_idinvt==null) list_idinvt=new ArrayList();
                            	    list_idinvt.add(idinvt.getTree());


                            	    }
                            	    break;

                            	default :
                            	    break loop20;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            char_literal71=(Token)match(input,96,FOLLOW_96_in_propertyApply1417);  
            stream_96.add(char_literal71);



            // AST REWRITE
            // elements: POST, idpre, idinvt, INV, idpost, PRE, AT_APPLY
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: idinvt, idpre, idpost
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_idinvt=new RewriteRuleSubtreeStream(adaptor,"token idinvt",list_idinvt);
            RewriteRuleSubtreeStream stream_idpre=new RewriteRuleSubtreeStream(adaptor,"token idpre",list_idpre);
            RewriteRuleSubtreeStream stream_idpost=new RewriteRuleSubtreeStream(adaptor,"token idpost",list_idpost);
            root_0 = (CommonTree)adaptor.nil();
            // 154:27: -> ^( AT_APPLY ( ^( PRE ( $idpre)* ) )? ( ^( POST ( $idpost)* ) )? ( ^( INV ( $idinvt)* ) )? )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:154:30: ^( AT_APPLY ( ^( PRE ( $idpre)* ) )? ( ^( POST ( $idpost)* ) )? ( ^( INV ( $idinvt)* ) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_AT_APPLY.nextNode(), root_1);

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:154:41: ( ^( PRE ( $idpre)* ) )?
                if ( stream_idpre.hasNext()||stream_PRE.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:154:42: ^( PRE ( $idpre)* )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_PRE.nextNode(), root_2);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:154:48: ( $idpre)*
                    while ( stream_idpre.hasNext() ) {
                        adaptor.addChild(root_2, stream_idpre.nextTree());

                    }
                    stream_idpre.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_idpre.reset();
                stream_PRE.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:154:59: ( ^( POST ( $idpost)* ) )?
                if ( stream_POST.hasNext()||stream_idpost.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:154:60: ^( POST ( $idpost)* )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_POST.nextNode(), root_2);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:154:67: ( $idpost)*
                    while ( stream_idpost.hasNext() ) {
                        adaptor.addChild(root_2, stream_idpost.nextTree());

                    }
                    stream_idpost.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_POST.reset();
                stream_idpost.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:154:79: ( ^( INV ( $idinvt)* ) )?
                if ( stream_idinvt.hasNext()||stream_INV.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:154:80: ^( INV ( $idinvt)* )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_INV.nextNode(), root_2);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:154:86: ( $idinvt)*
                    while ( stream_idinvt.hasNext() ) {
                        adaptor.addChild(root_2, stream_idinvt.nextTree());

                    }
                    stream_idinvt.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_idinvt.reset();
                stream_INV.reset();

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
    // $ANTLR end "propertyApply"

    public static class atVisibility_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atVisibility"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:156:1: atVisibility : AT_VISIBILITY '[' AT_SPEC atVisibilityData ',' AT_RUNTIME atVisibilityData ']' -> ^( AT_VISIBILITY ^( AT_SPEC atVisibilityData ) ^( AT_RUNTIME atVisibilityData ) ) ;
    public final colaEbnfParser.atVisibility_return atVisibility() throws RecognitionException {
        colaEbnfParser.atVisibility_return retval = new colaEbnfParser.atVisibility_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AT_VISIBILITY72=null;
        Token char_literal73=null;
        Token AT_SPEC74=null;
        Token char_literal76=null;
        Token AT_RUNTIME77=null;
        Token char_literal79=null;
        colaEbnfParser.atVisibilityData_return atVisibilityData75 = null;

        colaEbnfParser.atVisibilityData_return atVisibilityData78 = null;


        CommonTree AT_VISIBILITY72_tree=null;
        CommonTree char_literal73_tree=null;
        CommonTree AT_SPEC74_tree=null;
        CommonTree char_literal76_tree=null;
        CommonTree AT_RUNTIME77_tree=null;
        CommonTree char_literal79_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_AT_VISIBILITY=new RewriteRuleTokenStream(adaptor,"token AT_VISIBILITY");
        RewriteRuleTokenStream stream_AT_SPEC=new RewriteRuleTokenStream(adaptor,"token AT_SPEC");
        RewriteRuleTokenStream stream_AT_RUNTIME=new RewriteRuleTokenStream(adaptor,"token AT_RUNTIME");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_atVisibilityData=new RewriteRuleSubtreeStream(adaptor,"rule atVisibilityData");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:156:25: ( AT_VISIBILITY '[' AT_SPEC atVisibilityData ',' AT_RUNTIME atVisibilityData ']' -> ^( AT_VISIBILITY ^( AT_SPEC atVisibilityData ) ^( AT_RUNTIME atVisibilityData ) ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:156:27: AT_VISIBILITY '[' AT_SPEC atVisibilityData ',' AT_RUNTIME atVisibilityData ']'
            {
            AT_VISIBILITY72=(Token)match(input,AT_VISIBILITY,FOLLOW_AT_VISIBILITY_in_atVisibility1502);  
            stream_AT_VISIBILITY.add(AT_VISIBILITY72);

            char_literal73=(Token)match(input,98,FOLLOW_98_in_atVisibility1504);  
            stream_98.add(char_literal73);

            AT_SPEC74=(Token)match(input,AT_SPEC,FOLLOW_AT_SPEC_in_atVisibility1506);  
            stream_AT_SPEC.add(AT_SPEC74);

            pushFollow(FOLLOW_atVisibilityData_in_atVisibility1508);
            atVisibilityData75=atVisibilityData();

            state._fsp--;

            stream_atVisibilityData.add(atVisibilityData75.getTree());
            char_literal76=(Token)match(input,100,FOLLOW_100_in_atVisibility1510);  
            stream_100.add(char_literal76);

            AT_RUNTIME77=(Token)match(input,AT_RUNTIME,FOLLOW_AT_RUNTIME_in_atVisibility1512);  
            stream_AT_RUNTIME.add(AT_RUNTIME77);

            pushFollow(FOLLOW_atVisibilityData_in_atVisibility1514);
            atVisibilityData78=atVisibilityData();

            state._fsp--;

            stream_atVisibilityData.add(atVisibilityData78.getTree());
            char_literal79=(Token)match(input,99,FOLLOW_99_in_atVisibility1516);  
            stream_99.add(char_literal79);



            // AST REWRITE
            // elements: AT_RUNTIME, AT_VISIBILITY, AT_SPEC, atVisibilityData, atVisibilityData
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 157:27: -> ^( AT_VISIBILITY ^( AT_SPEC atVisibilityData ) ^( AT_RUNTIME atVisibilityData ) )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:157:30: ^( AT_VISIBILITY ^( AT_SPEC atVisibilityData ) ^( AT_RUNTIME atVisibilityData ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_AT_VISIBILITY.nextNode(), root_1);

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:157:46: ^( AT_SPEC atVisibilityData )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_SPEC.nextNode(), root_2);

                adaptor.addChild(root_2, stream_atVisibilityData.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:157:74: ^( AT_RUNTIME atVisibilityData )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_RUNTIME.nextNode(), root_2);

                adaptor.addChild(root_2, stream_atVisibilityData.nextTree());

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
    // $ANTLR end "atVisibility"

    public static class atVisibilityData_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atVisibilityData"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:158:1: atVisibilityData : '(' ( ( IDENT )? '-' string_value ( ',' string_value )* )? ';' ( COLA_TRUE )? ';' ( ( IDENT )? '+' string_value ( ',' string_value )* )? ')' ;
    public final colaEbnfParser.atVisibilityData_return atVisibilityData() throws RecognitionException {
        colaEbnfParser.atVisibilityData_return retval = new colaEbnfParser.atVisibilityData_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal80=null;
        Token IDENT81=null;
        Token char_literal82=null;
        Token char_literal84=null;
        Token char_literal86=null;
        Token COLA_TRUE87=null;
        Token char_literal88=null;
        Token IDENT89=null;
        Token char_literal90=null;
        Token char_literal92=null;
        Token char_literal94=null;
        colaEbnfParser.string_value_return string_value83 = null;

        colaEbnfParser.string_value_return string_value85 = null;

        colaEbnfParser.string_value_return string_value91 = null;

        colaEbnfParser.string_value_return string_value93 = null;


        CommonTree char_literal80_tree=null;
        CommonTree IDENT81_tree=null;
        CommonTree char_literal82_tree=null;
        CommonTree char_literal84_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree COLA_TRUE87_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree IDENT89_tree=null;
        CommonTree char_literal90_tree=null;
        CommonTree char_literal92_tree=null;
        CommonTree char_literal94_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:158:25: ( '(' ( ( IDENT )? '-' string_value ( ',' string_value )* )? ';' ( COLA_TRUE )? ';' ( ( IDENT )? '+' string_value ( ',' string_value )* )? ')' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:158:27: '(' ( ( IDENT )? '-' string_value ( ',' string_value )* )? ';' ( COLA_TRUE )? ';' ( ( IDENT )? '+' string_value ( ',' string_value )* )? ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal80=(Token)match(input,95,FOLLOW_95_in_atVisibilityData1574); 
            char_literal80_tree = (CommonTree)adaptor.create(char_literal80);
            adaptor.addChild(root_0, char_literal80_tree);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:159:27: ( ( IDENT )? '-' string_value ( ',' string_value )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==IDENT||LA25_0==101) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:159:28: ( IDENT )? '-' string_value ( ',' string_value )*
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:159:28: ( IDENT )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==IDENT) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:159:28: IDENT
                            {
                            IDENT81=(Token)match(input,IDENT,FOLLOW_IDENT_in_atVisibilityData1603); 
                            IDENT81_tree = (CommonTree)adaptor.create(IDENT81);
                            adaptor.addChild(root_0, IDENT81_tree);


                            }
                            break;

                    }

                    char_literal82=(Token)match(input,101,FOLLOW_101_in_atVisibilityData1606); 
                    char_literal82_tree = (CommonTree)adaptor.create(char_literal82);
                    adaptor.addChild(root_0, char_literal82_tree);

                    pushFollow(FOLLOW_string_value_in_atVisibilityData1608);
                    string_value83=string_value();

                    state._fsp--;

                    adaptor.addChild(root_0, string_value83.getTree());
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:159:52: ( ',' string_value )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==100) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:159:53: ',' string_value
                    	    {
                    	    char_literal84=(Token)match(input,100,FOLLOW_100_in_atVisibilityData1611); 
                    	    char_literal84_tree = (CommonTree)adaptor.create(char_literal84);
                    	    adaptor.addChild(root_0, char_literal84_tree);

                    	    pushFollow(FOLLOW_string_value_in_atVisibilityData1613);
                    	    string_value85=string_value();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, string_value85.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal86=(Token)match(input,97,FOLLOW_97_in_atVisibilityData1619); 
            char_literal86_tree = (CommonTree)adaptor.create(char_literal86);
            adaptor.addChild(root_0, char_literal86_tree);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:160:27: ( COLA_TRUE )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==COLA_TRUE) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:160:27: COLA_TRUE
                    {
                    COLA_TRUE87=(Token)match(input,COLA_TRUE,FOLLOW_COLA_TRUE_in_atVisibilityData1647); 
                    COLA_TRUE87_tree = (CommonTree)adaptor.create(COLA_TRUE87);
                    adaptor.addChild(root_0, COLA_TRUE87_tree);


                    }
                    break;

            }

            char_literal88=(Token)match(input,97,FOLLOW_97_in_atVisibilityData1650); 
            char_literal88_tree = (CommonTree)adaptor.create(char_literal88);
            adaptor.addChild(root_0, char_literal88_tree);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:161:27: ( ( IDENT )? '+' string_value ( ',' string_value )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==IDENT||LA29_0==102) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:161:28: ( IDENT )? '+' string_value ( ',' string_value )*
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:161:28: ( IDENT )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==IDENT) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:161:28: IDENT
                            {
                            IDENT89=(Token)match(input,IDENT,FOLLOW_IDENT_in_atVisibilityData1679); 
                            IDENT89_tree = (CommonTree)adaptor.create(IDENT89);
                            adaptor.addChild(root_0, IDENT89_tree);


                            }
                            break;

                    }

                    char_literal90=(Token)match(input,102,FOLLOW_102_in_atVisibilityData1682); 
                    char_literal90_tree = (CommonTree)adaptor.create(char_literal90);
                    adaptor.addChild(root_0, char_literal90_tree);

                    pushFollow(FOLLOW_string_value_in_atVisibilityData1684);
                    string_value91=string_value();

                    state._fsp--;

                    adaptor.addChild(root_0, string_value91.getTree());
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:161:52: ( ',' string_value )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==100) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:161:53: ',' string_value
                    	    {
                    	    char_literal92=(Token)match(input,100,FOLLOW_100_in_atVisibilityData1687); 
                    	    char_literal92_tree = (CommonTree)adaptor.create(char_literal92);
                    	    adaptor.addChild(root_0, char_literal92_tree);

                    	    pushFollow(FOLLOW_string_value_in_atVisibilityData1689);
                    	    string_value93=string_value();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, string_value93.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal94=(Token)match(input,96,FOLLOW_96_in_atVisibilityData1721); 
            char_literal94_tree = (CommonTree)adaptor.create(char_literal94);
            adaptor.addChild(root_0, char_literal94_tree);


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
    // $ANTLR end "atVisibilityData"

    public static class atDescription_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atDescription"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:165:1: atDescription : AT_DESCRIPTION '(' string_value ')' -> ^( AT_DESCRIPTION string_value ) ;
    public final colaEbnfParser.atDescription_return atDescription() throws RecognitionException {
        colaEbnfParser.atDescription_return retval = new colaEbnfParser.atDescription_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AT_DESCRIPTION95=null;
        Token char_literal96=null;
        Token char_literal98=null;
        colaEbnfParser.string_value_return string_value97 = null;


        CommonTree AT_DESCRIPTION95_tree=null;
        CommonTree char_literal96_tree=null;
        CommonTree char_literal98_tree=null;
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_AT_DESCRIPTION=new RewriteRuleTokenStream(adaptor,"token AT_DESCRIPTION");
        RewriteRuleSubtreeStream stream_string_value=new RewriteRuleSubtreeStream(adaptor,"rule string_value");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:165:25: ( AT_DESCRIPTION '(' string_value ')' -> ^( AT_DESCRIPTION string_value ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:165:27: AT_DESCRIPTION '(' string_value ')'
            {
            AT_DESCRIPTION95=(Token)match(input,AT_DESCRIPTION,FOLLOW_AT_DESCRIPTION_in_atDescription1766);  
            stream_AT_DESCRIPTION.add(AT_DESCRIPTION95);

            char_literal96=(Token)match(input,95,FOLLOW_95_in_atDescription1768);  
            stream_95.add(char_literal96);

            pushFollow(FOLLOW_string_value_in_atDescription1770);
            string_value97=string_value();

            state._fsp--;

            stream_string_value.add(string_value97.getTree());
            char_literal98=(Token)match(input,96,FOLLOW_96_in_atDescription1772);  
            stream_96.add(char_literal98);



            // AST REWRITE
            // elements: string_value, AT_DESCRIPTION
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 165:63: -> ^( AT_DESCRIPTION string_value )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:165:66: ^( AT_DESCRIPTION string_value )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_AT_DESCRIPTION.nextNode(), root_1);

                adaptor.addChild(root_1, stream_string_value.nextTree());

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
    // $ANTLR end "atDescription"

    public static class colaPropertyDefList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaPropertyDefList"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:167:1: colaPropertyDefList : '[' colaPropertyDef ( ',' colaPropertyDef )* ']' -> ( colaPropertyDef )* ;
    public final colaEbnfParser.colaPropertyDefList_return colaPropertyDefList() throws RecognitionException {
        colaEbnfParser.colaPropertyDefList_return retval = new colaEbnfParser.colaPropertyDefList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal99=null;
        Token char_literal101=null;
        Token char_literal103=null;
        colaEbnfParser.colaPropertyDef_return colaPropertyDef100 = null;

        colaEbnfParser.colaPropertyDef_return colaPropertyDef102 = null;


        CommonTree char_literal99_tree=null;
        CommonTree char_literal101_tree=null;
        CommonTree char_literal103_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_colaPropertyDef=new RewriteRuleSubtreeStream(adaptor,"rule colaPropertyDef");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:167:25: ( '[' colaPropertyDef ( ',' colaPropertyDef )* ']' -> ( colaPropertyDef )* )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:167:27: '[' colaPropertyDef ( ',' colaPropertyDef )* ']'
            {
            this.pass.identsStart();
            char_literal99=(Token)match(input,98,FOLLOW_98_in_colaPropertyDefList1794);  
            stream_98.add(char_literal99);

            pushFollow(FOLLOW_colaPropertyDef_in_colaPropertyDefList1796);
            colaPropertyDef100=colaPropertyDef();

            state._fsp--;

            stream_colaPropertyDef.add(colaPropertyDef100.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:167:74: ( ',' colaPropertyDef )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==100) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:167:75: ',' colaPropertyDef
            	    {
            	    char_literal101=(Token)match(input,100,FOLLOW_100_in_colaPropertyDefList1799);  
            	    stream_100.add(char_literal101);

            	    pushFollow(FOLLOW_colaPropertyDef_in_colaPropertyDefList1801);
            	    colaPropertyDef102=colaPropertyDef();

            	    state._fsp--;

            	    stream_colaPropertyDef.add(colaPropertyDef102.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            char_literal103=(Token)match(input,99,FOLLOW_99_in_colaPropertyDefList1805);  
            stream_99.add(char_literal103);



            // AST REWRITE
            // elements: colaPropertyDef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 167:101: -> ( colaPropertyDef )*
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:167:104: ( colaPropertyDef )*
                while ( stream_colaPropertyDef.hasNext() ) {
                    adaptor.addChild(root_0, stream_colaPropertyDef.nextTree());

                }
                stream_colaPropertyDef.reset();

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
    // $ANTLR end "colaPropertyDefList"

    public static class colaPropertyDef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaPropertyDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:168:1: colaPropertyDef : scoped_name s= IDENT ( '(' const_value ( ',' const_value )* ')' )? -> ^( PROPERTY IDENT scoped_name ( const_value )* ) ;
    public final colaEbnfParser.colaPropertyDef_return colaPropertyDef() throws RecognitionException {
        colaEbnfParser.colaPropertyDef_return retval = new colaEbnfParser.colaPropertyDef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token char_literal105=null;
        Token char_literal107=null;
        Token char_literal109=null;
        colaEbnfParser.scoped_name_return scoped_name104 = null;

        colaEbnfParser.const_value_return const_value106 = null;

        colaEbnfParser.const_value_return const_value108 = null;


        CommonTree s_tree=null;
        CommonTree char_literal105_tree=null;
        CommonTree char_literal107_tree=null;
        CommonTree char_literal109_tree=null;
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_const_value=new RewriteRuleSubtreeStream(adaptor,"rule const_value");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:168:25: ( scoped_name s= IDENT ( '(' const_value ( ',' const_value )* ')' )? -> ^( PROPERTY IDENT scoped_name ( const_value )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:168:27: scoped_name s= IDENT ( '(' const_value ( ',' const_value )* ')' )?
            {
            pushFollow(FOLLOW_scoped_name_in_colaPropertyDef1825);
            scoped_name104=scoped_name();

            state._fsp--;

            stream_scoped_name.add(scoped_name104.getTree());
            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaPropertyDef1829);  
            stream_IDENT.add(s);

            this.pass.identsAddPropDef(s);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:168:80: ( '(' const_value ( ',' const_value )* ')' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==95) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:168:81: '(' const_value ( ',' const_value )* ')'
                    {
                    char_literal105=(Token)match(input,95,FOLLOW_95_in_colaPropertyDef1834);  
                    stream_95.add(char_literal105);

                    pushFollow(FOLLOW_const_value_in_colaPropertyDef1836);
                    const_value106=const_value();

                    state._fsp--;

                    stream_const_value.add(const_value106.getTree());
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:168:97: ( ',' const_value )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==100) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:168:98: ',' const_value
                    	    {
                    	    char_literal107=(Token)match(input,100,FOLLOW_100_in_colaPropertyDef1839);  
                    	    stream_100.add(char_literal107);

                    	    pushFollow(FOLLOW_const_value_in_colaPropertyDef1841);
                    	    const_value108=const_value();

                    	    state._fsp--;

                    	    stream_const_value.add(const_value108.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    char_literal109=(Token)match(input,96,FOLLOW_96_in_colaPropertyDef1845);  
                    stream_96.add(char_literal109);


                    }
                    break;

            }



            // AST REWRITE
            // elements: const_value, scoped_name, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 170:27: -> ^( PROPERTY IDENT scoped_name ( const_value )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:170:30: ^( PROPERTY IDENT scoped_name ( const_value )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROPERTY, "PROPERTY"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_scoped_name.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:170:59: ( const_value )*
                while ( stream_const_value.hasNext() ) {
                    adaptor.addChild(root_1, stream_const_value.nextTree());

                }
                stream_const_value.reset();

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
    // $ANTLR end "colaPropertyDef"

    public static class colaContractDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaContractDecl"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:172:1: colaContractDecl : CONTRACT s= IDENT ':' AT_SCOPE '(' ( contractScope )+ ')' ( atVisibility )? atDescription ( contractItem )* ';' -> ^( CONTRACT IDENT ^( AT_SCOPE ( contractScope )* ) ( atVisibility )? atDescription ( contractItem )* ) ;
    public final colaEbnfParser.colaContractDecl_return colaContractDecl() throws RecognitionException {
        colaEbnfParser.colaContractDecl_return retval = new colaEbnfParser.colaContractDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token CONTRACT110=null;
        Token char_literal111=null;
        Token AT_SCOPE112=null;
        Token char_literal113=null;
        Token char_literal115=null;
        Token char_literal119=null;
        colaEbnfParser.contractScope_return contractScope114 = null;

        colaEbnfParser.atVisibility_return atVisibility116 = null;

        colaEbnfParser.atDescription_return atDescription117 = null;

        colaEbnfParser.contractItem_return contractItem118 = null;


        CommonTree s_tree=null;
        CommonTree CONTRACT110_tree=null;
        CommonTree char_literal111_tree=null;
        CommonTree AT_SCOPE112_tree=null;
        CommonTree char_literal113_tree=null;
        CommonTree char_literal115_tree=null;
        CommonTree char_literal119_tree=null;
        RewriteRuleTokenStream stream_AT_SCOPE=new RewriteRuleTokenStream(adaptor,"token AT_SCOPE");
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_CONTRACT=new RewriteRuleTokenStream(adaptor,"token CONTRACT");
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleSubtreeStream stream_contractScope=new RewriteRuleSubtreeStream(adaptor,"rule contractScope");
        RewriteRuleSubtreeStream stream_atVisibility=new RewriteRuleSubtreeStream(adaptor,"rule atVisibility");
        RewriteRuleSubtreeStream stream_atDescription=new RewriteRuleSubtreeStream(adaptor,"rule atDescription");
        RewriteRuleSubtreeStream stream_contractItem=new RewriteRuleSubtreeStream(adaptor,"rule contractItem");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:172:25: ( CONTRACT s= IDENT ':' AT_SCOPE '(' ( contractScope )+ ')' ( atVisibility )? atDescription ( contractItem )* ';' -> ^( CONTRACT IDENT ^( AT_SCOPE ( contractScope )* ) ( atVisibility )? atDescription ( contractItem )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:172:27: CONTRACT s= IDENT ':' AT_SCOPE '(' ( contractScope )+ ')' ( atVisibility )? atDescription ( contractItem )* ';'
            {
            CONTRACT110=(Token)match(input,CONTRACT,FOLLOW_CONTRACT_in_colaContractDecl1928);  
            stream_CONTRACT.add(CONTRACT110);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaContractDecl1932);  
            stream_IDENT.add(s);

            char_literal111=(Token)match(input,93,FOLLOW_93_in_colaContractDecl1934);  
            stream_93.add(char_literal111);

            this.pass.putAtom(s,ColaTokensConstants.colaCONTRACT);
            this.pass.lastContract();
            AT_SCOPE112=(Token)match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_colaContractDecl1992);  
            stream_AT_SCOPE.add(AT_SCOPE112);

            char_literal113=(Token)match(input,95,FOLLOW_95_in_colaContractDecl1994);  
            stream_95.add(char_literal113);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:174:40: ( contractScope )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==98) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:174:40: contractScope
            	    {
            	    pushFollow(FOLLOW_contractScope_in_colaContractDecl1996);
            	    contractScope114=contractScope();

            	    state._fsp--;

            	    stream_contractScope.add(contractScope114.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);

            char_literal115=(Token)match(input,96,FOLLOW_96_in_colaContractDecl1999);  
            stream_96.add(char_literal115);

            this.pass.contractDeclScopeFinish();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:176:27: ( atVisibility )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==AT_VISIBILITY) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:176:27: atVisibility
                    {
                    pushFollow(FOLLOW_atVisibility_in_colaContractDecl2055);
                    atVisibility116=atVisibility();

                    state._fsp--;

                    stream_atVisibility.add(atVisibility116.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_atDescription_in_colaContractDecl2058);
            atDescription117=atDescription();

            state._fsp--;

            stream_atDescription.add(atDescription117.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:176:55: ( contractItem )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==ITEM) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:176:56: contractItem
            	    {
            	    pushFollow(FOLLOW_contractItem_in_colaContractDecl2061);
            	    contractItem118=contractItem();

            	    state._fsp--;

            	    stream_contractItem.add(contractItem118.getTree());

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            this.pass.atoms.scope.pop();
            char_literal119=(Token)match(input,97,FOLLOW_97_in_colaContractDecl2119);  
            stream_97.add(char_literal119);



            // AST REWRITE
            // elements: CONTRACT, IDENT, atVisibility, contractItem, contractScope, atDescription, AT_SCOPE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 179:27: -> ^( CONTRACT IDENT ^( AT_SCOPE ( contractScope )* ) ( atVisibility )? atDescription ( contractItem )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:179:30: ^( CONTRACT IDENT ^( AT_SCOPE ( contractScope )* ) ( atVisibility )? atDescription ( contractItem )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_CONTRACT.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:179:47: ^( AT_SCOPE ( contractScope )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_SCOPE.nextNode(), root_2);

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:179:58: ( contractScope )*
                while ( stream_contractScope.hasNext() ) {
                    adaptor.addChild(root_2, stream_contractScope.nextTree());

                }
                stream_contractScope.reset();

                adaptor.addChild(root_1, root_2);
                }
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:179:74: ( atVisibility )?
                if ( stream_atVisibility.hasNext() ) {
                    adaptor.addChild(root_1, stream_atVisibility.nextTree());

                }
                stream_atVisibility.reset();
                adaptor.addChild(root_1, stream_atDescription.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:179:102: ( contractItem )*
                while ( stream_contractItem.hasNext() ) {
                    adaptor.addChild(root_1, stream_contractItem.nextTree());

                }
                stream_contractItem.reset();

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
    // $ANTLR end "colaContractDecl"

    public static class contractScope_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractScope"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:180:1: contractScope : '[' contractScopeAtom ':' contractScopeRank ']' -> contractScopeAtom contractScopeRank ;
    public final colaEbnfParser.contractScope_return contractScope() throws RecognitionException {
        colaEbnfParser.contractScope_return retval = new colaEbnfParser.contractScope_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal120=null;
        Token char_literal122=null;
        Token char_literal124=null;
        colaEbnfParser.contractScopeAtom_return contractScopeAtom121 = null;

        colaEbnfParser.contractScopeRank_return contractScopeRank123 = null;


        CommonTree char_literal120_tree=null;
        CommonTree char_literal122_tree=null;
        CommonTree char_literal124_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleSubtreeStream stream_contractScopeRank=new RewriteRuleSubtreeStream(adaptor,"rule contractScopeRank");
        RewriteRuleSubtreeStream stream_contractScopeAtom=new RewriteRuleSubtreeStream(adaptor,"rule contractScopeAtom");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:180:25: ( '[' contractScopeAtom ':' contractScopeRank ']' -> contractScopeAtom contractScopeRank )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:180:27: '[' contractScopeAtom ':' contractScopeRank ']'
            {
            char_literal120=(Token)match(input,98,FOLLOW_98_in_contractScope2185);  
            stream_98.add(char_literal120);

            pushFollow(FOLLOW_contractScopeAtom_in_contractScope2187);
            contractScopeAtom121=contractScopeAtom();

            state._fsp--;

            stream_contractScopeAtom.add(contractScopeAtom121.getTree());
            char_literal122=(Token)match(input,93,FOLLOW_93_in_contractScope2189);  
            stream_93.add(char_literal122);

            pushFollow(FOLLOW_contractScopeRank_in_contractScope2191);
            contractScopeRank123=contractScopeRank();

            state._fsp--;

            stream_contractScopeRank.add(contractScopeRank123.getTree());
            char_literal124=(Token)match(input,99,FOLLOW_99_in_contractScope2193);  
            stream_99.add(char_literal124);



            // AST REWRITE
            // elements: contractScopeAtom, contractScopeRank
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 180:75: -> contractScopeAtom contractScopeRank
            {
                adaptor.addChild(root_0, stream_contractScopeAtom.nextTree());
                adaptor.addChild(root_0, stream_contractScopeRank.nextTree());

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
    // $ANTLR end "contractScope"

    public static class contractScopeAtom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractScopeAtom"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:181:1: contractScopeAtom : (s= ELEMENT | s= FACILITY ) ;
    public final colaEbnfParser.contractScopeAtom_return contractScopeAtom() throws RecognitionException {
        colaEbnfParser.contractScopeAtom_return retval = new colaEbnfParser.contractScopeAtom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:181:25: ( (s= ELEMENT | s= FACILITY ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:181:27: (s= ELEMENT | s= FACILITY )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:181:27: (s= ELEMENT | s= FACILITY )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==ELEMENT) ) {
                alt36=1;
            }
            else if ( (LA36_0==FACILITY) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:181:28: s= ELEMENT
                    {
                    s=(Token)match(input,ELEMENT,FOLLOW_ELEMENT_in_contractScopeAtom2215); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:181:40: s= FACILITY
                    {
                    s=(Token)match(input,FACILITY,FOLLOW_FACILITY_in_contractScopeAtom2221); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;

            }

            this.pass.addContractDeclScopeAtom(s);

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
    // $ANTLR end "contractScopeAtom"

    public static class contractScopeRank_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractScopeRank"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:183:1: contractScopeRank : (s= REQUIRED | s= MANDATORY | s= OPTIONAL | s= NOT_DEF ) ;
    public final colaEbnfParser.contractScopeRank_return contractScopeRank() throws RecognitionException {
        colaEbnfParser.contractScopeRank_return retval = new colaEbnfParser.contractScopeRank_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:183:25: ( (s= REQUIRED | s= MANDATORY | s= OPTIONAL | s= NOT_DEF ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:183:27: (s= REQUIRED | s= MANDATORY | s= OPTIONAL | s= NOT_DEF )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:183:27: (s= REQUIRED | s= MANDATORY | s= OPTIONAL | s= NOT_DEF )
            int alt37=4;
            switch ( input.LA(1) ) {
            case REQUIRED:
                {
                alt37=1;
                }
                break;
            case MANDATORY:
                {
                alt37=2;
                }
                break;
            case OPTIONAL:
                {
                alt37=3;
                }
                break;
            case NOT_DEF:
                {
                alt37=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:183:28: s= REQUIRED
                    {
                    s=(Token)match(input,REQUIRED,FOLLOW_REQUIRED_in_contractScopeRank2266); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:183:41: s= MANDATORY
                    {
                    s=(Token)match(input,MANDATORY,FOLLOW_MANDATORY_in_contractScopeRank2272); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:183:55: s= OPTIONAL
                    {
                    s=(Token)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_contractScopeRank2278); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:183:68: s= NOT_DEF
                    {
                    s=(Token)match(input,NOT_DEF,FOLLOW_NOT_DEF_in_contractScopeRank2284); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;

            }

            this.pass.addContractDeclScopeRank(s);

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
    // $ANTLR end "contractScopeRank"

    public static class contractItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractItem"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:186:1: contractItem : ITEM s= IDENT '{' contractItemProp ( ',' contractItemProp )* '}' -> ^( ITEM IDENT ( contractItemProp )+ ) ;
    public final colaEbnfParser.contractItem_return contractItem() throws RecognitionException {
        colaEbnfParser.contractItem_return retval = new colaEbnfParser.contractItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token ITEM125=null;
        Token char_literal126=null;
        Token char_literal128=null;
        Token char_literal130=null;
        colaEbnfParser.contractItemProp_return contractItemProp127 = null;

        colaEbnfParser.contractItemProp_return contractItemProp129 = null;


        CommonTree s_tree=null;
        CommonTree ITEM125_tree=null;
        CommonTree char_literal126_tree=null;
        CommonTree char_literal128_tree=null;
        CommonTree char_literal130_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_ITEM=new RewriteRuleTokenStream(adaptor,"token ITEM");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_contractItemProp=new RewriteRuleSubtreeStream(adaptor,"rule contractItemProp");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:186:25: ( ITEM s= IDENT '{' contractItemProp ( ',' contractItemProp )* '}' -> ^( ITEM IDENT ( contractItemProp )+ ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:186:27: ITEM s= IDENT '{' contractItemProp ( ',' contractItemProp )* '}'
            {
            ITEM125=(Token)match(input,ITEM,FOLLOW_ITEM_in_contractItem2332);  
            stream_ITEM.add(ITEM125);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_contractItem2336);  
            stream_IDENT.add(s);

            this.pass.putAtom(s,ColaTokensConstants.colaITEM);
            this.pass.identsStart();
            this.pass.lastItem();
            char_literal126=(Token)match(input,103,FOLLOW_103_in_contractItem2422);  
            stream_103.add(char_literal126);

            pushFollow(FOLLOW_contractItemProp_in_contractItem2424);
            contractItemProp127=contractItemProp();

            state._fsp--;

            stream_contractItemProp.add(contractItemProp127.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:189:48: ( ',' contractItemProp )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==100) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:189:49: ',' contractItemProp
            	    {
            	    char_literal128=(Token)match(input,100,FOLLOW_100_in_contractItem2427);  
            	    stream_100.add(char_literal128);

            	    pushFollow(FOLLOW_contractItemProp_in_contractItem2429);
            	    contractItemProp129=contractItemProp();

            	    state._fsp--;

            	    stream_contractItemProp.add(contractItemProp129.getTree());

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            char_literal130=(Token)match(input,104,FOLLOW_104_in_contractItem2433);  
            stream_104.add(char_literal130);

            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: ITEM, IDENT, contractItemProp
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 191:27: -> ^( ITEM IDENT ( contractItemProp )+ )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:191:30: ^( ITEM IDENT ( contractItemProp )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_ITEM.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                if ( !(stream_contractItemProp.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_contractItemProp.hasNext() ) {
                    adaptor.addChild(root_1, stream_contractItemProp.nextTree());

                }
                stream_contractItemProp.reset();

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
    // $ANTLR end "contractItem"

    public static class contractItemProp_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractItemProp"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:192:1: contractItemProp : '[' s= IDENT ':' AT_TYPE '(' base_type ( array )? '=' const_value ')' AT_RANK '(' contractItemPropRank ')' propertyApply ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( AT_PRIORITY '(' base_type '=' const_value ')' )? ']' -> ^( PROPERTY IDENT ^( AT_TYPE base_type const_value ( array )? ) contractItemPropRank propertyApply ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_PRIORITY base_type const_value ) )? ) ;
    public final colaEbnfParser.contractItemProp_return contractItemProp() throws RecognitionException {
        colaEbnfParser.contractItemProp_return retval = new colaEbnfParser.contractItemProp_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token char_literal131=null;
        Token char_literal132=null;
        Token AT_TYPE133=null;
        Token char_literal134=null;
        Token char_literal137=null;
        Token char_literal139=null;
        Token AT_RANK140=null;
        Token char_literal141=null;
        Token char_literal143=null;
        Token AT_ALTERABLE145=null;
        Token AT_NEGOTIABLE146=null;
        Token AT_PRIORITY148=null;
        Token char_literal149=null;
        Token char_literal151=null;
        Token char_literal153=null;
        Token char_literal154=null;
        colaEbnfParser.base_type_return base_type135 = null;

        colaEbnfParser.array_return array136 = null;

        colaEbnfParser.const_value_return const_value138 = null;

        colaEbnfParser.contractItemPropRank_return contractItemPropRank142 = null;

        colaEbnfParser.propertyApply_return propertyApply144 = null;

        colaEbnfParser.atDescription_return atDescription147 = null;

        colaEbnfParser.base_type_return base_type150 = null;

        colaEbnfParser.const_value_return const_value152 = null;


        CommonTree s_tree=null;
        CommonTree char_literal131_tree=null;
        CommonTree char_literal132_tree=null;
        CommonTree AT_TYPE133_tree=null;
        CommonTree char_literal134_tree=null;
        CommonTree char_literal137_tree=null;
        CommonTree char_literal139_tree=null;
        CommonTree AT_RANK140_tree=null;
        CommonTree char_literal141_tree=null;
        CommonTree char_literal143_tree=null;
        CommonTree AT_ALTERABLE145_tree=null;
        CommonTree AT_NEGOTIABLE146_tree=null;
        CommonTree AT_PRIORITY148_tree=null;
        CommonTree char_literal149_tree=null;
        CommonTree char_literal151_tree=null;
        CommonTree char_literal153_tree=null;
        CommonTree char_literal154_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_AT_NEGOTIABLE=new RewriteRuleTokenStream(adaptor,"token AT_NEGOTIABLE");
        RewriteRuleTokenStream stream_AT_PRIORITY=new RewriteRuleTokenStream(adaptor,"token AT_PRIORITY");
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_AT_RANK=new RewriteRuleTokenStream(adaptor,"token AT_RANK");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_AT_ALTERABLE=new RewriteRuleTokenStream(adaptor,"token AT_ALTERABLE");
        RewriteRuleTokenStream stream_AT_TYPE=new RewriteRuleTokenStream(adaptor,"token AT_TYPE");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleSubtreeStream stream_propertyApply=new RewriteRuleSubtreeStream(adaptor,"rule propertyApply");
        RewriteRuleSubtreeStream stream_const_value=new RewriteRuleSubtreeStream(adaptor,"rule const_value");
        RewriteRuleSubtreeStream stream_base_type=new RewriteRuleSubtreeStream(adaptor,"rule base_type");
        RewriteRuleSubtreeStream stream_atDescription=new RewriteRuleSubtreeStream(adaptor,"rule atDescription");
        RewriteRuleSubtreeStream stream_contractItemPropRank=new RewriteRuleSubtreeStream(adaptor,"rule contractItemPropRank");
        RewriteRuleSubtreeStream stream_array=new RewriteRuleSubtreeStream(adaptor,"rule array");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:192:25: ( '[' s= IDENT ':' AT_TYPE '(' base_type ( array )? '=' const_value ')' AT_RANK '(' contractItemPropRank ')' propertyApply ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( AT_PRIORITY '(' base_type '=' const_value ')' )? ']' -> ^( PROPERTY IDENT ^( AT_TYPE base_type const_value ( array )? ) contractItemPropRank propertyApply ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_PRIORITY base_type const_value ) )? ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:192:27: '[' s= IDENT ':' AT_TYPE '(' base_type ( array )? '=' const_value ')' AT_RANK '(' contractItemPropRank ')' propertyApply ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( AT_PRIORITY '(' base_type '=' const_value ')' )? ']'
            {
            char_literal131=(Token)match(input,98,FOLLOW_98_in_contractItemProp2512);  
            stream_98.add(char_literal131);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_contractItemProp2516);  
            stream_IDENT.add(s);

            char_literal132=(Token)match(input,93,FOLLOW_93_in_contractItemProp2518);  
            stream_93.add(char_literal132);

            AT_TYPE133=(Token)match(input,AT_TYPE,FOLLOW_AT_TYPE_in_contractItemProp2550);  
            stream_AT_TYPE.add(AT_TYPE133);

            char_literal134=(Token)match(input,95,FOLLOW_95_in_contractItemProp2552);  
            stream_95.add(char_literal134);

            pushFollow(FOLLOW_base_type_in_contractItemProp2554);
            base_type135=base_type();

            state._fsp--;

            stream_base_type.add(base_type135.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:193:53: ( array )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==98) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:193:53: array
                    {
                    pushFollow(FOLLOW_array_in_contractItemProp2556);
                    array136=array();

                    state._fsp--;

                    stream_array.add(array136.getTree());

                    }
                    break;

            }

            char_literal137=(Token)match(input,94,FOLLOW_94_in_contractItemProp2559);  
            stream_94.add(char_literal137);

            pushFollow(FOLLOW_const_value_in_contractItemProp2561);
            const_value138=const_value();

            state._fsp--;

            stream_const_value.add(const_value138.getTree());
            char_literal139=(Token)match(input,96,FOLLOW_96_in_contractItemProp2563);  
            stream_96.add(char_literal139);

            this.pass.putAtom(s,ColaTokensConstants.parserItemProp, this.base_type, this.isArray);
            this.isArray=false;
            AT_RANK140=(Token)match(input,AT_RANK,FOLLOW_AT_RANK_in_contractItemProp2659);  
            stream_AT_RANK.add(AT_RANK140);

            char_literal141=(Token)match(input,95,FOLLOW_95_in_contractItemProp2661);  
            stream_95.add(char_literal141);

            pushFollow(FOLLOW_contractItemPropRank_in_contractItemProp2663);
            contractItemPropRank142=contractItemPropRank();

            state._fsp--;

            stream_contractItemPropRank.add(contractItemPropRank142.getTree());
            char_literal143=(Token)match(input,96,FOLLOW_96_in_contractItemProp2665);  
            stream_96.add(char_literal143);

            pushFollow(FOLLOW_propertyApply_in_contractItemProp2697);
            propertyApply144=propertyApply();

            state._fsp--;

            stream_propertyApply.add(propertyApply144.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:197:45: ( AT_ALTERABLE )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==AT_ALTERABLE) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:197:45: AT_ALTERABLE
                    {
                    AT_ALTERABLE145=(Token)match(input,AT_ALTERABLE,FOLLOW_AT_ALTERABLE_in_contractItemProp2699);  
                    stream_AT_ALTERABLE.add(AT_ALTERABLE145);


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:197:59: ( AT_NEGOTIABLE )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==AT_NEGOTIABLE) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:197:59: AT_NEGOTIABLE
                    {
                    AT_NEGOTIABLE146=(Token)match(input,AT_NEGOTIABLE,FOLLOW_AT_NEGOTIABLE_in_contractItemProp2702);  
                    stream_AT_NEGOTIABLE.add(AT_NEGOTIABLE146);


                    }
                    break;

            }

            pushFollow(FOLLOW_atDescription_in_contractItemProp2705);
            atDescription147=atDescription();

            state._fsp--;

            stream_atDescription.add(atDescription147.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:198:31: ( AT_PRIORITY '(' base_type '=' const_value ')' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==AT_PRIORITY) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:198:32: AT_PRIORITY '(' base_type '=' const_value ')'
                    {
                    AT_PRIORITY148=(Token)match(input,AT_PRIORITY,FOLLOW_AT_PRIORITY_in_contractItemProp2738);  
                    stream_AT_PRIORITY.add(AT_PRIORITY148);

                    char_literal149=(Token)match(input,95,FOLLOW_95_in_contractItemProp2740);  
                    stream_95.add(char_literal149);

                    pushFollow(FOLLOW_base_type_in_contractItemProp2742);
                    base_type150=base_type();

                    state._fsp--;

                    stream_base_type.add(base_type150.getTree());
                    char_literal151=(Token)match(input,94,FOLLOW_94_in_contractItemProp2744);  
                    stream_94.add(char_literal151);

                    pushFollow(FOLLOW_const_value_in_contractItemProp2746);
                    const_value152=const_value();

                    state._fsp--;

                    stream_const_value.add(const_value152.getTree());
                    char_literal153=(Token)match(input,96,FOLLOW_96_in_contractItemProp2748);  
                    stream_96.add(char_literal153);


                    }
                    break;

            }

            this.pass.contractItemDeclAdd(s.getText());
            this.pass.atoms.scope.pop();
            char_literal154=(Token)match(input,99,FOLLOW_99_in_contractItemProp2842);  
            stream_99.add(char_literal154);



            // AST REWRITE
            // elements: base_type, array, propertyApply, AT_PRIORITY, const_value, AT_TYPE, contractItemPropRank, atDescription, const_value, base_type, AT_ALTERABLE, AT_NEGOTIABLE, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 202:27: -> ^( PROPERTY IDENT ^( AT_TYPE base_type const_value ( array )? ) contractItemPropRank propertyApply ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_PRIORITY base_type const_value ) )? )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:202:30: ^( PROPERTY IDENT ^( AT_TYPE base_type const_value ( array )? ) contractItemPropRank propertyApply ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_PRIORITY base_type const_value ) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROPERTY, "PROPERTY"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:202:47: ^( AT_TYPE base_type const_value ( array )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_TYPE.nextNode(), root_2);

                adaptor.addChild(root_2, stream_base_type.nextTree());
                adaptor.addChild(root_2, stream_const_value.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:202:79: ( array )?
                if ( stream_array.hasNext() ) {
                    adaptor.addChild(root_2, stream_array.nextTree());

                }
                stream_array.reset();

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_contractItemPropRank.nextTree());
                adaptor.addChild(root_1, stream_propertyApply.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:203:65: ( AT_ALTERABLE )?
                if ( stream_AT_ALTERABLE.hasNext() ) {
                    adaptor.addChild(root_1, stream_AT_ALTERABLE.nextNode());

                }
                stream_AT_ALTERABLE.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:203:79: ( AT_NEGOTIABLE )?
                if ( stream_AT_NEGOTIABLE.hasNext() ) {
                    adaptor.addChild(root_1, stream_AT_NEGOTIABLE.nextNode());

                }
                stream_AT_NEGOTIABLE.reset();
                adaptor.addChild(root_1, stream_atDescription.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:204:30: ( ^( AT_PRIORITY base_type const_value ) )?
                if ( stream_base_type.hasNext()||stream_AT_PRIORITY.hasNext()||stream_const_value.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:204:30: ^( AT_PRIORITY base_type const_value )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_PRIORITY.nextNode(), root_2);

                    adaptor.addChild(root_2, stream_base_type.nextTree());
                    adaptor.addChild(root_2, stream_const_value.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_base_type.reset();
                stream_AT_PRIORITY.reset();
                stream_const_value.reset();

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
    // $ANTLR end "contractItemProp"

    public static class contractItemPropRank_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contractItemPropRank"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:205:1: contractItemPropRank : (s= REQUIRED | s= MANDATORY | s= OPTIONAL ) ;
    public final colaEbnfParser.contractItemPropRank_return contractItemPropRank() throws RecognitionException {
        colaEbnfParser.contractItemPropRank_return retval = new colaEbnfParser.contractItemPropRank_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:205:25: ( (s= REQUIRED | s= MANDATORY | s= OPTIONAL ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:205:27: (s= REQUIRED | s= MANDATORY | s= OPTIONAL )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:205:27: (s= REQUIRED | s= MANDATORY | s= OPTIONAL )
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
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:205:28: s= REQUIRED
                    {
                    s=(Token)match(input,REQUIRED,FOLLOW_REQUIRED_in_contractItemPropRank2979); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:205:41: s= MANDATORY
                    {
                    s=(Token)match(input,MANDATORY,FOLLOW_MANDATORY_in_contractItemPropRank2985); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:205:55: s= OPTIONAL
                    {
                    s=(Token)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_contractItemPropRank2991); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;

            }

            this.pass.lastItemPropRank(s);

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
    // $ANTLR end "contractItemPropRank"

    public static class colaContractDefList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaContractDefList"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:208:1: colaContractDefList : '[' '[' colaContractDef ( ',' colaContractDef )* ']' ']' -> ( colaContractDef )* ;
    public final colaEbnfParser.colaContractDefList_return colaContractDefList() throws RecognitionException {
        colaEbnfParser.colaContractDefList_return retval = new colaEbnfParser.colaContractDefList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal155=null;
        Token char_literal156=null;
        Token char_literal158=null;
        Token char_literal160=null;
        Token char_literal161=null;
        colaEbnfParser.colaContractDef_return colaContractDef157 = null;

        colaEbnfParser.colaContractDef_return colaContractDef159 = null;


        CommonTree char_literal155_tree=null;
        CommonTree char_literal156_tree=null;
        CommonTree char_literal158_tree=null;
        CommonTree char_literal160_tree=null;
        CommonTree char_literal161_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_colaContractDef=new RewriteRuleSubtreeStream(adaptor,"rule colaContractDef");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:208:25: ( '[' '[' colaContractDef ( ',' colaContractDef )* ']' ']' -> ( colaContractDef )* )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:208:27: '[' '[' colaContractDef ( ',' colaContractDef )* ']' ']'
            {
            this.pass.contIdentsStart();
            char_literal155=(Token)match(input,98,FOLLOW_98_in_colaContractDefList3034);  
            stream_98.add(char_literal155);

            char_literal156=(Token)match(input,98,FOLLOW_98_in_colaContractDefList3036);  
            stream_98.add(char_literal156);

            pushFollow(FOLLOW_colaContractDef_in_colaContractDefList3038);
            colaContractDef157=colaContractDef();

            state._fsp--;

            stream_colaContractDef.add(colaContractDef157.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:208:82: ( ',' colaContractDef )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==100) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:208:83: ',' colaContractDef
            	    {
            	    char_literal158=(Token)match(input,100,FOLLOW_100_in_colaContractDefList3041);  
            	    stream_100.add(char_literal158);

            	    pushFollow(FOLLOW_colaContractDef_in_colaContractDefList3043);
            	    colaContractDef159=colaContractDef();

            	    state._fsp--;

            	    stream_colaContractDef.add(colaContractDef159.getTree());

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            char_literal160=(Token)match(input,99,FOLLOW_99_in_colaContractDefList3047);  
            stream_99.add(char_literal160);

            char_literal161=(Token)match(input,99,FOLLOW_99_in_colaContractDefList3049);  
            stream_99.add(char_literal161);



            // AST REWRITE
            // elements: colaContractDef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 208:113: -> ( colaContractDef )*
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:208:116: ( colaContractDef )*
                while ( stream_colaContractDef.hasNext() ) {
                    adaptor.addChild(root_0, stream_colaContractDef.nextTree());

                }
                stream_colaContractDef.reset();

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
    // $ANTLR end "colaContractDefList"

    public static class colaContractDef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaContractDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:209:1: colaContractDef : '{' scoped_name s= IDENT '=' colaContractItemDef ( ',' colaContractItemDef )* '}' -> ^( CONTRACT IDENT scoped_name ( colaContractItemDef )* ) ;
    public final colaEbnfParser.colaContractDef_return colaContractDef() throws RecognitionException {
        colaEbnfParser.colaContractDef_return retval = new colaEbnfParser.colaContractDef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token char_literal162=null;
        Token char_literal164=null;
        Token char_literal166=null;
        Token char_literal168=null;
        colaEbnfParser.scoped_name_return scoped_name163 = null;

        colaEbnfParser.colaContractItemDef_return colaContractItemDef165 = null;

        colaEbnfParser.colaContractItemDef_return colaContractItemDef167 = null;


        CommonTree s_tree=null;
        CommonTree char_literal162_tree=null;
        CommonTree char_literal164_tree=null;
        CommonTree char_literal166_tree=null;
        CommonTree char_literal168_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_colaContractItemDef=new RewriteRuleSubtreeStream(adaptor,"rule colaContractItemDef");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:209:25: ( '{' scoped_name s= IDENT '=' colaContractItemDef ( ',' colaContractItemDef )* '}' -> ^( CONTRACT IDENT scoped_name ( colaContractItemDef )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:209:27: '{' scoped_name s= IDENT '=' colaContractItemDef ( ',' colaContractItemDef )* '}'
            {
            char_literal162=(Token)match(input,103,FOLLOW_103_in_colaContractDef3069);  
            stream_103.add(char_literal162);

            pushFollow(FOLLOW_scoped_name_in_colaContractDef3071);
            scoped_name163=scoped_name();

            state._fsp--;

            stream_scoped_name.add(scoped_name163.getTree());
            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaContractDef3075);  
            stream_IDENT.add(s);

            this.pass.contIdentsAdd(s);
            char_literal164=(Token)match(input,94,FOLLOW_94_in_colaContractDef3079);  
            stream_94.add(char_literal164);

            pushFollow(FOLLOW_colaContractItemDef_in_colaContractDef3081);
            colaContractItemDef165=colaContractItemDef();

            state._fsp--;

            stream_colaContractItemDef.add(colaContractItemDef165.getTree());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:209:105: ( ',' colaContractItemDef )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==100) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:209:106: ',' colaContractItemDef
            	    {
            	    char_literal166=(Token)match(input,100,FOLLOW_100_in_colaContractDef3084);  
            	    stream_100.add(char_literal166);

            	    pushFollow(FOLLOW_colaContractItemDef_in_colaContractDef3086);
            	    colaContractItemDef167=colaContractItemDef();

            	    state._fsp--;

            	    stream_colaContractItemDef.add(colaContractItemDef167.getTree());

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            char_literal168=(Token)match(input,104,FOLLOW_104_in_colaContractDef3090);  
            stream_104.add(char_literal168);



            // AST REWRITE
            // elements: IDENT, colaContractItemDef, scoped_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 209:136: -> ^( CONTRACT IDENT scoped_name ( colaContractItemDef )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:209:139: ^( CONTRACT IDENT scoped_name ( colaContractItemDef )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONTRACT, "CONTRACT"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_scoped_name.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:209:168: ( colaContractItemDef )*
                while ( stream_colaContractItemDef.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaContractItemDef.nextTree());

                }
                stream_colaContractItemDef.reset();

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
    // $ANTLR end "colaContractDef"

    public static class colaContractItemDef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaContractItemDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:210:1: colaContractItemDef : IDENT colaItemDefList ;
    public final colaEbnfParser.colaContractItemDef_return colaContractItemDef() throws RecognitionException {
        colaEbnfParser.colaContractItemDef_return retval = new colaEbnfParser.colaContractItemDef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT169=null;
        colaEbnfParser.colaItemDefList_return colaItemDefList170 = null;


        CommonTree IDENT169_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:210:25: ( IDENT colaItemDefList )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:210:27: IDENT colaItemDefList
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT169=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaContractItemDef3114); 
            IDENT169_tree = (CommonTree)adaptor.create(IDENT169);
            adaptor.addChild(root_0, IDENT169_tree);

            pushFollow(FOLLOW_colaItemDefList_in_colaContractItemDef3116);
            colaItemDefList170=colaItemDefList();

            state._fsp--;

            adaptor.addChild(root_0, colaItemDefList170.getTree());

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
    // $ANTLR end "colaContractItemDef"

    public static class colaItemDefList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaItemDefList"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:211:1: colaItemDefList : '[' ( colaItemDef ( ',' colaItemDef )* )? ']' -> ( colaItemDef )* ;
    public final colaEbnfParser.colaItemDefList_return colaItemDefList() throws RecognitionException {
        colaEbnfParser.colaItemDefList_return retval = new colaEbnfParser.colaItemDefList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal171=null;
        Token char_literal173=null;
        Token char_literal175=null;
        colaEbnfParser.colaItemDef_return colaItemDef172 = null;

        colaEbnfParser.colaItemDef_return colaItemDef174 = null;


        CommonTree char_literal171_tree=null;
        CommonTree char_literal173_tree=null;
        CommonTree char_literal175_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_colaItemDef=new RewriteRuleSubtreeStream(adaptor,"rule colaItemDef");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:211:25: ( '[' ( colaItemDef ( ',' colaItemDef )* )? ']' -> ( colaItemDef )* )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:211:27: '[' ( colaItemDef ( ',' colaItemDef )* )? ']'
            {
            this.pass.identsStart();
            char_literal171=(Token)match(input,98,FOLLOW_98_in_colaItemDefList3133);  
            stream_98.add(char_literal171);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:211:58: ( colaItemDef ( ',' colaItemDef )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==IDENT) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:211:59: colaItemDef ( ',' colaItemDef )*
                    {
                    pushFollow(FOLLOW_colaItemDef_in_colaItemDefList3136);
                    colaItemDef172=colaItemDef();

                    state._fsp--;

                    stream_colaItemDef.add(colaItemDef172.getTree());
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:211:71: ( ',' colaItemDef )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==100) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:211:72: ',' colaItemDef
                    	    {
                    	    char_literal173=(Token)match(input,100,FOLLOW_100_in_colaItemDefList3139);  
                    	    stream_100.add(char_literal173);

                    	    pushFollow(FOLLOW_colaItemDef_in_colaItemDefList3141);
                    	    colaItemDef174=colaItemDef();

                    	    state._fsp--;

                    	    stream_colaItemDef.add(colaItemDef174.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal175=(Token)match(input,99,FOLLOW_99_in_colaItemDefList3147);  
            stream_99.add(char_literal175);



            // AST REWRITE
            // elements: colaItemDef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 211:96: -> ( colaItemDef )*
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:211:99: ( colaItemDef )*
                while ( stream_colaItemDef.hasNext() ) {
                    adaptor.addChild(root_0, stream_colaItemDef.nextTree());

                }
                stream_colaItemDef.reset();

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
    // $ANTLR end "colaItemDefList"

    public static class colaItemDef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaItemDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:212:1: colaItemDef : IDENT s= IDENT ( '(' const_value ( ',' const_value )* ')' )? -> ^( IDENT IDENT ( const_value )* ) ;
    public final colaEbnfParser.colaItemDef_return colaItemDef() throws RecognitionException {
        colaEbnfParser.colaItemDef_return retval = new colaEbnfParser.colaItemDef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token IDENT176=null;
        Token char_literal177=null;
        Token char_literal179=null;
        Token char_literal181=null;
        colaEbnfParser.const_value_return const_value178 = null;

        colaEbnfParser.const_value_return const_value180 = null;


        CommonTree s_tree=null;
        CommonTree IDENT176_tree=null;
        CommonTree char_literal177_tree=null;
        CommonTree char_literal179_tree=null;
        CommonTree char_literal181_tree=null;
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_const_value=new RewriteRuleSubtreeStream(adaptor,"rule const_value");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:212:25: ( IDENT s= IDENT ( '(' const_value ( ',' const_value )* ')' )? -> ^( IDENT IDENT ( const_value )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:212:27: IDENT s= IDENT ( '(' const_value ( ',' const_value )* ')' )?
            {
            IDENT176=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaItemDef3171);  
            stream_IDENT.add(IDENT176);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaItemDef3175);  
            stream_IDENT.add(s);

            this.pass.identsAddItemDef(s);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:212:74: ( '(' const_value ( ',' const_value )* ')' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==95) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:212:75: '(' const_value ( ',' const_value )* ')'
                    {
                    char_literal177=(Token)match(input,95,FOLLOW_95_in_colaItemDef3180);  
                    stream_95.add(char_literal177);

                    pushFollow(FOLLOW_const_value_in_colaItemDef3182);
                    const_value178=const_value();

                    state._fsp--;

                    stream_const_value.add(const_value178.getTree());
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:212:91: ( ',' const_value )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==100) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:212:92: ',' const_value
                    	    {
                    	    char_literal179=(Token)match(input,100,FOLLOW_100_in_colaItemDef3185);  
                    	    stream_100.add(char_literal179);

                    	    pushFollow(FOLLOW_const_value_in_colaItemDef3187);
                    	    const_value180=const_value();

                    	    state._fsp--;

                    	    stream_const_value.add(const_value180.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    char_literal181=(Token)match(input,96,FOLLOW_96_in_colaItemDef3191);  
                    stream_96.add(char_literal181);


                    }
                    break;

            }



            // AST REWRITE
            // elements: IDENT, IDENT, const_value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 213:27: -> ^( IDENT IDENT ( const_value )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:213:30: ^( IDENT IDENT ( const_value )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_IDENT.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:213:44: ( const_value )*
                while ( stream_const_value.hasNext() ) {
                    adaptor.addChild(root_1, stream_const_value.nextTree());

                }
                stream_const_value.reset();

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
    // $ANTLR end "colaItemDef"

    public static class colaSpecification_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaSpecification"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:215:1: colaSpecification : cpp_directive AT_STAGE a3dsStage ';' AT_ENVIRONMENT a3dsEnvironment ';' AT_CLEVEL a3dsCLevel ';' AT_LANGUAGE l= IDENT ';' AT_SPEC s= IDENT ';' ( colaDefinition )* EOF -> ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE $l) ^( AT_SPEC $s) cpp_directive ( colaDefinition )* ) ;
    public final colaEbnfParser.colaSpecification_return colaSpecification() throws RecognitionException {
        colaEbnfParser.colaSpecification_return retval = new colaEbnfParser.colaSpecification_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token l=null;
        Token s=null;
        Token AT_STAGE183=null;
        Token char_literal185=null;
        Token AT_ENVIRONMENT186=null;
        Token char_literal188=null;
        Token AT_CLEVEL189=null;
        Token char_literal191=null;
        Token AT_LANGUAGE192=null;
        Token char_literal193=null;
        Token AT_SPEC194=null;
        Token char_literal195=null;
        Token EOF197=null;
        colaEbnfParser.cpp_directive_return cpp_directive182 = null;

        colaEbnfParser.a3dsStage_return a3dsStage184 = null;

        colaEbnfParser.a3dsEnvironment_return a3dsEnvironment187 = null;

        colaEbnfParser.a3dsCLevel_return a3dsCLevel190 = null;

        colaEbnfParser.colaDefinition_return colaDefinition196 = null;


        CommonTree l_tree=null;
        CommonTree s_tree=null;
        CommonTree AT_STAGE183_tree=null;
        CommonTree char_literal185_tree=null;
        CommonTree AT_ENVIRONMENT186_tree=null;
        CommonTree char_literal188_tree=null;
        CommonTree AT_CLEVEL189_tree=null;
        CommonTree char_literal191_tree=null;
        CommonTree AT_LANGUAGE192_tree=null;
        CommonTree char_literal193_tree=null;
        CommonTree AT_SPEC194_tree=null;
        CommonTree char_literal195_tree=null;
        CommonTree EOF197_tree=null;
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_AT_STAGE=new RewriteRuleTokenStream(adaptor,"token AT_STAGE");
        RewriteRuleTokenStream stream_AT_CLEVEL=new RewriteRuleTokenStream(adaptor,"token AT_CLEVEL");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_AT_SPEC=new RewriteRuleTokenStream(adaptor,"token AT_SPEC");
        RewriteRuleTokenStream stream_AT_LANGUAGE=new RewriteRuleTokenStream(adaptor,"token AT_LANGUAGE");
        RewriteRuleTokenStream stream_AT_ENVIRONMENT=new RewriteRuleTokenStream(adaptor,"token AT_ENVIRONMENT");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_a3dsCLevel=new RewriteRuleSubtreeStream(adaptor,"rule a3dsCLevel");
        RewriteRuleSubtreeStream stream_cpp_directive=new RewriteRuleSubtreeStream(adaptor,"rule cpp_directive");
        RewriteRuleSubtreeStream stream_colaDefinition=new RewriteRuleSubtreeStream(adaptor,"rule colaDefinition");
        RewriteRuleSubtreeStream stream_a3dsStage=new RewriteRuleSubtreeStream(adaptor,"rule a3dsStage");
        RewriteRuleSubtreeStream stream_a3dsEnvironment=new RewriteRuleSubtreeStream(adaptor,"rule a3dsEnvironment");
        this.init();
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:216:25: ( cpp_directive AT_STAGE a3dsStage ';' AT_ENVIRONMENT a3dsEnvironment ';' AT_CLEVEL a3dsCLevel ';' AT_LANGUAGE l= IDENT ';' AT_SPEC s= IDENT ';' ( colaDefinition )* EOF -> ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE $l) ^( AT_SPEC $s) cpp_directive ( colaDefinition )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:216:27: cpp_directive AT_STAGE a3dsStage ';' AT_ENVIRONMENT a3dsEnvironment ';' AT_CLEVEL a3dsCLevel ';' AT_LANGUAGE l= IDENT ';' AT_SPEC s= IDENT ';' ( colaDefinition )* EOF
            {
            pushFollow(FOLLOW_cpp_directive_in_colaSpecification3274);
            cpp_directive182=cpp_directive();

            state._fsp--;

            stream_cpp_directive.add(cpp_directive182.getTree());
            AT_STAGE183=(Token)match(input,AT_STAGE,FOLLOW_AT_STAGE_in_colaSpecification3276);  
            stream_AT_STAGE.add(AT_STAGE183);

            pushFollow(FOLLOW_a3dsStage_in_colaSpecification3278);
            a3dsStage184=a3dsStage();

            state._fsp--;

            stream_a3dsStage.add(a3dsStage184.getTree());
            char_literal185=(Token)match(input,97,FOLLOW_97_in_colaSpecification3280);  
            stream_97.add(char_literal185);

            AT_ENVIRONMENT186=(Token)match(input,AT_ENVIRONMENT,FOLLOW_AT_ENVIRONMENT_in_colaSpecification3282);  
            stream_AT_ENVIRONMENT.add(AT_ENVIRONMENT186);

            pushFollow(FOLLOW_a3dsEnvironment_in_colaSpecification3284);
            a3dsEnvironment187=a3dsEnvironment();

            state._fsp--;

            stream_a3dsEnvironment.add(a3dsEnvironment187.getTree());
            char_literal188=(Token)match(input,97,FOLLOW_97_in_colaSpecification3286);  
            stream_97.add(char_literal188);

            AT_CLEVEL189=(Token)match(input,AT_CLEVEL,FOLLOW_AT_CLEVEL_in_colaSpecification3288);  
            stream_AT_CLEVEL.add(AT_CLEVEL189);

            pushFollow(FOLLOW_a3dsCLevel_in_colaSpecification3290);
            a3dsCLevel190=a3dsCLevel();

            state._fsp--;

            stream_a3dsCLevel.add(a3dsCLevel190.getTree());
            char_literal191=(Token)match(input,97,FOLLOW_97_in_colaSpecification3292);  
            stream_97.add(char_literal191);

            AT_LANGUAGE192=(Token)match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_colaSpecification3294);  
            stream_AT_LANGUAGE.add(AT_LANGUAGE192);

            l=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaSpecification3298);  
            stream_IDENT.add(l);

            char_literal193=(Token)match(input,97,FOLLOW_97_in_colaSpecification3300);  
            stream_97.add(char_literal193);

            AT_SPEC194=(Token)match(input,AT_SPEC,FOLLOW_AT_SPEC_in_colaSpecification3302);  
            stream_AT_SPEC.add(AT_SPEC194);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaSpecification3306);  
            stream_IDENT.add(s);

            char_literal195=(Token)match(input,97,FOLLOW_97_in_colaSpecification3308);  
            stream_97.add(char_literal195);

            this.pass.atoms.specificationName(s);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:216:208: ( colaDefinition )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==FUNCTION||LA50_0==PROPERTY||(LA50_0>=PACKAGE && LA50_0<=FACILITY)||LA50_0==AT_VISIBILITY||LA50_0==CONTRACT||LA50_0==CPP_DIRECTIVE||(LA50_0>=TYPEDEF && LA50_0<=STRUCT)||LA50_0==98) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:216:208: colaDefinition
            	    {
            	    pushFollow(FOLLOW_colaDefinition_in_colaSpecification3312);
            	    colaDefinition196=colaDefinition();

            	    state._fsp--;

            	    stream_colaDefinition.add(colaDefinition196.getTree());

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            EOF197=(Token)match(input,EOF,FOLLOW_EOF_in_colaSpecification3315);  
            stream_EOF.add(EOF197);



            // AST REWRITE
            // elements: cpp_directive, l, AT_SPEC, AT_LANGUAGE, a3dsEnvironment, a3dsStage, a3dsCLevel, colaDefinition, AT_SPEC, s
            // token labels: s, l
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            RewriteRuleTokenStream stream_l=new RewriteRuleTokenStream(adaptor,"token l",l);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 217:27: -> ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE $l) ^( AT_SPEC $s) cpp_directive ( colaDefinition )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:217:30: ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE $l) ^( AT_SPEC $s) cpp_directive ( colaDefinition )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_AT_SPEC.nextNode(), root_1);

                adaptor.addChild(root_1, stream_a3dsStage.nextTree());
                adaptor.addChild(root_1, stream_a3dsEnvironment.nextTree());
                adaptor.addChild(root_1, stream_a3dsCLevel.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:217:77: ^( AT_LANGUAGE $l)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_LANGUAGE.nextNode(), root_2);

                adaptor.addChild(root_2, stream_l.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:217:95: ^( AT_SPEC $s)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_SPEC.nextNode(), root_2);

                adaptor.addChild(root_2, stream_s.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_cpp_directive.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:217:123: ( colaDefinition )*
                while ( stream_colaDefinition.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaDefinition.nextTree());

                }
                stream_colaDefinition.reset();

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
    // $ANTLR end "colaSpecification"

    public static class colaDefinition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaDefinition"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:218:1: colaDefinition : ( colaFunction | colaPropertyDecl | colaContractDecl | colaPackage | colaElement | colaFacility | colaTypeDef | colaStruct | cpp_directive );
    public final colaEbnfParser.colaDefinition_return colaDefinition() throws RecognitionException {
        colaEbnfParser.colaDefinition_return retval = new colaEbnfParser.colaDefinition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        colaEbnfParser.colaFunction_return colaFunction198 = null;

        colaEbnfParser.colaPropertyDecl_return colaPropertyDecl199 = null;

        colaEbnfParser.colaContractDecl_return colaContractDecl200 = null;

        colaEbnfParser.colaPackage_return colaPackage201 = null;

        colaEbnfParser.colaElement_return colaElement202 = null;

        colaEbnfParser.colaFacility_return colaFacility203 = null;

        colaEbnfParser.colaTypeDef_return colaTypeDef204 = null;

        colaEbnfParser.colaStruct_return colaStruct205 = null;

        colaEbnfParser.cpp_directive_return cpp_directive206 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:218:25: ( colaFunction | colaPropertyDecl | colaContractDecl | colaPackage | colaElement | colaFacility | colaTypeDef | colaStruct | cpp_directive )
            int alt51=9;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:218:27: colaFunction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaFunction_in_colaDefinition3388);
                    colaFunction198=colaFunction();

                    state._fsp--;

                    adaptor.addChild(root_0, colaFunction198.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:218:42: colaPropertyDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaPropertyDecl_in_colaDefinition3392);
                    colaPropertyDecl199=colaPropertyDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, colaPropertyDecl199.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:218:61: colaContractDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaContractDecl_in_colaDefinition3396);
                    colaContractDecl200=colaContractDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, colaContractDecl200.getTree());

                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:218:80: colaPackage
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaPackage_in_colaDefinition3400);
                    colaPackage201=colaPackage();

                    state._fsp--;

                    adaptor.addChild(root_0, colaPackage201.getTree());

                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:218:94: colaElement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaElement_in_colaDefinition3404);
                    colaElement202=colaElement();

                    state._fsp--;

                    adaptor.addChild(root_0, colaElement202.getTree());

                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:218:108: colaFacility
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaFacility_in_colaDefinition3408);
                    colaFacility203=colaFacility();

                    state._fsp--;

                    adaptor.addChild(root_0, colaFacility203.getTree());

                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:218:123: colaTypeDef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaTypeDef_in_colaDefinition3412);
                    colaTypeDef204=colaTypeDef();

                    state._fsp--;

                    adaptor.addChild(root_0, colaTypeDef204.getTree());

                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:218:137: colaStruct
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaStruct_in_colaDefinition3416);
                    colaStruct205=colaStruct();

                    state._fsp--;

                    adaptor.addChild(root_0, colaStruct205.getTree());

                    }
                    break;
                case 9 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:218:150: cpp_directive
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_cpp_directive_in_colaDefinition3420);
                    cpp_directive206=cpp_directive();

                    state._fsp--;

                    adaptor.addChild(root_0, cpp_directive206.getTree());

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
    // $ANTLR end "colaDefinition"

    public static class cpp_directive_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cpp_directive"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:220:1: cpp_directive : s= CPP_DIRECTIVE ;
    public final colaEbnfParser.cpp_directive_return cpp_directive() throws RecognitionException {
        colaEbnfParser.cpp_directive_return retval = new colaEbnfParser.cpp_directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:220:25: (s= CPP_DIRECTIVE )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:220:27: s= CPP_DIRECTIVE
            {
            root_0 = (CommonTree)adaptor.nil();

            s=(Token)match(input,CPP_DIRECTIVE,FOLLOW_CPP_DIRECTIVE_in_cpp_directive3440); 
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

    public static class colaPackage_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaPackage"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:222:1: colaPackage : ( colaPropertyDefList )? PACKAGE s= IDENT '{' ( colaDefinition | inline_code )* '}' -> ^( PACKAGE IDENT ( colaPropertyDefList )? ( colaDefinition )* ( inline_code )* ) ;
    public final colaEbnfParser.colaPackage_return colaPackage() throws RecognitionException {
        colaEbnfParser.colaPackage_return retval = new colaEbnfParser.colaPackage_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token PACKAGE208=null;
        Token char_literal209=null;
        Token char_literal212=null;
        colaEbnfParser.colaPropertyDefList_return colaPropertyDefList207 = null;

        colaEbnfParser.colaDefinition_return colaDefinition210 = null;

        colaEbnfParser.inline_code_return inline_code211 = null;


        CommonTree s_tree=null;
        CommonTree PACKAGE208_tree=null;
        CommonTree char_literal209_tree=null;
        CommonTree char_literal212_tree=null;
        RewriteRuleTokenStream stream_PACKAGE=new RewriteRuleTokenStream(adaptor,"token PACKAGE");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleSubtreeStream stream_colaDefinition=new RewriteRuleSubtreeStream(adaptor,"rule colaDefinition");
        RewriteRuleSubtreeStream stream_inline_code=new RewriteRuleSubtreeStream(adaptor,"rule inline_code");
        RewriteRuleSubtreeStream stream_colaPropertyDefList=new RewriteRuleSubtreeStream(adaptor,"rule colaPropertyDefList");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:222:25: ( ( colaPropertyDefList )? PACKAGE s= IDENT '{' ( colaDefinition | inline_code )* '}' -> ^( PACKAGE IDENT ( colaPropertyDefList )? ( colaDefinition )* ( inline_code )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:222:27: ( colaPropertyDefList )? PACKAGE s= IDENT '{' ( colaDefinition | inline_code )* '}'
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:222:27: ( colaPropertyDefList )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==98) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:222:27: colaPropertyDefList
                    {
                    pushFollow(FOLLOW_colaPropertyDefList_in_colaPackage3462);
                    colaPropertyDefList207=colaPropertyDefList();

                    state._fsp--;

                    stream_colaPropertyDefList.add(colaPropertyDefList207.getTree());

                    }
                    break;

            }

            PACKAGE208=(Token)match(input,PACKAGE,FOLLOW_PACKAGE_in_colaPackage3465);  
            stream_PACKAGE.add(PACKAGE208);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaPackage3469);  
            stream_IDENT.add(s);

            this.pass.putAtom(s,ColaTokensConstants.colaPACKAGE);
            char_literal209=(Token)match(input,103,FOLLOW_103_in_colaPackage3499);  
            stream_103.add(char_literal209);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:223:31: ( colaDefinition | inline_code )*
            loop53:
            do {
                int alt53=3;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==FUNCTION||LA53_0==PROPERTY||(LA53_0>=PACKAGE && LA53_0<=FACILITY)||LA53_0==AT_VISIBILITY||LA53_0==CONTRACT||LA53_0==CPP_DIRECTIVE||(LA53_0>=TYPEDEF && LA53_0<=STRUCT)||LA53_0==98) ) {
                    alt53=1;
                }
                else if ( (LA53_0==103) ) {
                    alt53=2;
                }


                switch (alt53) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:223:32: colaDefinition
            	    {
            	    pushFollow(FOLLOW_colaDefinition_in_colaPackage3502);
            	    colaDefinition210=colaDefinition();

            	    state._fsp--;

            	    stream_colaDefinition.add(colaDefinition210.getTree());

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:223:49: inline_code
            	    {
            	    pushFollow(FOLLOW_inline_code_in_colaPackage3506);
            	    inline_code211=inline_code();

            	    state._fsp--;

            	    stream_inline_code.add(inline_code211.getTree());

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            char_literal212=(Token)match(input,104,FOLLOW_104_in_colaPackage3510);  
            stream_104.add(char_literal212);

            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: PACKAGE, inline_code, IDENT, colaDefinition, colaPropertyDefList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 225:27: -> ^( PACKAGE IDENT ( colaPropertyDefList )? ( colaDefinition )* ( inline_code )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:225:30: ^( PACKAGE IDENT ( colaPropertyDefList )? ( colaDefinition )* ( inline_code )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_PACKAGE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:225:46: ( colaPropertyDefList )?
                if ( stream_colaPropertyDefList.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaPropertyDefList.nextTree());

                }
                stream_colaPropertyDefList.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:225:67: ( colaDefinition )*
                while ( stream_colaDefinition.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaDefinition.nextTree());

                }
                stream_colaDefinition.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:225:83: ( inline_code )*
                while ( stream_inline_code.hasNext() ) {
                    adaptor.addChild(root_1, stream_inline_code.nextTree());

                }
                stream_inline_code.reset();

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
    // $ANTLR end "colaPackage"

    public static class colaElement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaElement"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:227:1: colaElement : ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? ELEMENT s= IDENT ( AT_EXTENDS elemExt= scoped_name )? ( AT_PROVIDES elemPro+= scoped_name ( ',' elemPro+= scoped_name )* )? ( AT_REQUIRES elemReq+= scoped_name ( ',' elemReq+= scoped_name )* )? '{' ( elementBody )* '}' -> ^( ELEMENT IDENT ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? ( ^( AT_EXTENDS $elemExt) )? ( ^( AT_PROVIDES ( $elemPro)+ ) )? ( ^( AT_REQUIRES ( $elemReq)+ ) )? ( elementBody )* ) ;
    public final colaEbnfParser.colaElement_return colaElement() throws RecognitionException {
        colaEbnfParser.colaElement_return retval = new colaEbnfParser.colaElement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token ELEMENT216=null;
        Token AT_EXTENDS217=null;
        Token AT_PROVIDES218=null;
        Token char_literal219=null;
        Token AT_REQUIRES220=null;
        Token char_literal221=null;
        Token char_literal222=null;
        Token char_literal224=null;
        List list_elemPro=null;
        List list_elemReq=null;
        colaEbnfParser.scoped_name_return elemExt = null;

        colaEbnfParser.colaPropertyDefList_return colaPropertyDefList213 = null;

        colaEbnfParser.colaContractDefList_return colaContractDefList214 = null;

        colaEbnfParser.atVisibility_return atVisibility215 = null;

        colaEbnfParser.elementBody_return elementBody223 = null;

        RuleReturnScope elemPro = null;
        RuleReturnScope elemReq = null;
        CommonTree s_tree=null;
        CommonTree ELEMENT216_tree=null;
        CommonTree AT_EXTENDS217_tree=null;
        CommonTree AT_PROVIDES218_tree=null;
        CommonTree char_literal219_tree=null;
        CommonTree AT_REQUIRES220_tree=null;
        CommonTree char_literal221_tree=null;
        CommonTree char_literal222_tree=null;
        CommonTree char_literal224_tree=null;
        RewriteRuleTokenStream stream_ELEMENT=new RewriteRuleTokenStream(adaptor,"token ELEMENT");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_AT_PROVIDES=new RewriteRuleTokenStream(adaptor,"token AT_PROVIDES");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_AT_REQUIRES=new RewriteRuleTokenStream(adaptor,"token AT_REQUIRES");
        RewriteRuleTokenStream stream_AT_EXTENDS=new RewriteRuleTokenStream(adaptor,"token AT_EXTENDS");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_colaContractDefList=new RewriteRuleSubtreeStream(adaptor,"rule colaContractDefList");
        RewriteRuleSubtreeStream stream_atVisibility=new RewriteRuleSubtreeStream(adaptor,"rule atVisibility");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        RewriteRuleSubtreeStream stream_colaPropertyDefList=new RewriteRuleSubtreeStream(adaptor,"rule colaPropertyDefList");
        RewriteRuleSubtreeStream stream_elementBody=new RewriteRuleSubtreeStream(adaptor,"rule elementBody");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:227:25: ( ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? ELEMENT s= IDENT ( AT_EXTENDS elemExt= scoped_name )? ( AT_PROVIDES elemPro+= scoped_name ( ',' elemPro+= scoped_name )* )? ( AT_REQUIRES elemReq+= scoped_name ( ',' elemReq+= scoped_name )* )? '{' ( elementBody )* '}' -> ^( ELEMENT IDENT ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? ( ^( AT_EXTENDS $elemExt) )? ( ^( AT_PROVIDES ( $elemPro)+ ) )? ( ^( AT_REQUIRES ( $elemReq)+ ) )? ( elementBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:227:27: ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? ELEMENT s= IDENT ( AT_EXTENDS elemExt= scoped_name )? ( AT_PROVIDES elemPro+= scoped_name ( ',' elemPro+= scoped_name )* )? ( AT_REQUIRES elemReq+= scoped_name ( ',' elemReq+= scoped_name )* )? '{' ( elementBody )* '}'
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:227:27: ( colaPropertyDefList )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==98) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==IDENT) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:227:27: colaPropertyDefList
                    {
                    pushFollow(FOLLOW_colaPropertyDefList_in_colaElement3627);
                    colaPropertyDefList213=colaPropertyDefList();

                    state._fsp--;

                    stream_colaPropertyDefList.add(colaPropertyDefList213.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:227:48: ( colaContractDefList )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==98) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:227:48: colaContractDefList
                    {
                    pushFollow(FOLLOW_colaContractDefList_in_colaElement3630);
                    colaContractDefList214=colaContractDefList();

                    state._fsp--;

                    stream_colaContractDefList.add(colaContractDefList214.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:227:69: ( atVisibility )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==AT_VISIBILITY) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:227:69: atVisibility
                    {
                    pushFollow(FOLLOW_atVisibility_in_colaElement3633);
                    atVisibility215=atVisibility();

                    state._fsp--;

                    stream_atVisibility.add(atVisibility215.getTree());

                    }
                    break;

            }

            ELEMENT216=(Token)match(input,ELEMENT,FOLLOW_ELEMENT_in_colaElement3662);  
            stream_ELEMENT.add(ELEMENT216);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaElement3666);  
            stream_IDENT.add(s);

            this.pass.putAtom(s,ColaTokensConstants.colaELEMENT);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:230:27: ( AT_EXTENDS elemExt= scoped_name )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==AT_EXTENDS) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:230:28: AT_EXTENDS elemExt= scoped_name
                    {
                    AT_EXTENDS217=(Token)match(input,AT_EXTENDS,FOLLOW_AT_EXTENDS_in_colaElement3723);  
                    stream_AT_EXTENDS.add(AT_EXTENDS217);

                    pushFollow(FOLLOW_scoped_name_in_colaElement3727);
                    elemExt=scoped_name();

                    state._fsp--;

                    stream_scoped_name.add(elemExt.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:231:27: ( AT_PROVIDES elemPro+= scoped_name ( ',' elemPro+= scoped_name )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==AT_PROVIDES) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:231:28: AT_PROVIDES elemPro+= scoped_name ( ',' elemPro+= scoped_name )*
                    {
                    AT_PROVIDES218=(Token)match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_colaElement3758);  
                    stream_AT_PROVIDES.add(AT_PROVIDES218);

                    pushFollow(FOLLOW_scoped_name_in_colaElement3762);
                    elemPro=scoped_name();

                    state._fsp--;

                    stream_scoped_name.add(elemPro.getTree());
                    if (list_elemPro==null) list_elemPro=new ArrayList();
                    list_elemPro.add(elemPro.getTree());

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:231:61: ( ',' elemPro+= scoped_name )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==100) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:231:62: ',' elemPro+= scoped_name
                    	    {
                    	    char_literal219=(Token)match(input,100,FOLLOW_100_in_colaElement3765);  
                    	    stream_100.add(char_literal219);

                    	    pushFollow(FOLLOW_scoped_name_in_colaElement3769);
                    	    elemPro=scoped_name();

                    	    state._fsp--;

                    	    stream_scoped_name.add(elemPro.getTree());
                    	    if (list_elemPro==null) list_elemPro=new ArrayList();
                    	    list_elemPro.add(elemPro.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:232:27: ( AT_REQUIRES elemReq+= scoped_name ( ',' elemReq+= scoped_name )* )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==AT_REQUIRES) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:232:28: AT_REQUIRES elemReq+= scoped_name ( ',' elemReq+= scoped_name )*
                    {
                    AT_REQUIRES220=(Token)match(input,AT_REQUIRES,FOLLOW_AT_REQUIRES_in_colaElement3802);  
                    stream_AT_REQUIRES.add(AT_REQUIRES220);

                    pushFollow(FOLLOW_scoped_name_in_colaElement3806);
                    elemReq=scoped_name();

                    state._fsp--;

                    stream_scoped_name.add(elemReq.getTree());
                    if (list_elemReq==null) list_elemReq=new ArrayList();
                    list_elemReq.add(elemReq.getTree());

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:232:61: ( ',' elemReq+= scoped_name )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==100) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:232:62: ',' elemReq+= scoped_name
                    	    {
                    	    char_literal221=(Token)match(input,100,FOLLOW_100_in_colaElement3809);  
                    	    stream_100.add(char_literal221);

                    	    pushFollow(FOLLOW_scoped_name_in_colaElement3813);
                    	    elemReq=scoped_name();

                    	    state._fsp--;

                    	    stream_scoped_name.add(elemReq.getTree());
                    	    if (list_elemReq==null) list_elemReq=new ArrayList();
                    	    list_elemReq.add(elemReq.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal222=(Token)match(input,103,FOLLOW_103_in_colaElement3845);  
            stream_103.add(char_literal222);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:233:31: ( elementBody )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( ((LA62_0>=ACTION && LA62_0<=ATTRIBUTE)||LA62_0==AT_CONTAINS||LA62_0==98||LA62_0==103) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:233:31: elementBody
            	    {
            	    pushFollow(FOLLOW_elementBody_in_colaElement3847);
            	    elementBody223=elementBody();

            	    state._fsp--;

            	    stream_elementBody.add(elementBody223.getTree());

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            char_literal224=(Token)match(input,104,FOLLOW_104_in_colaElement3850);  
            stream_104.add(char_literal224);

            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: IDENT, elemExt, colaPropertyDefList, AT_EXTENDS, ELEMENT, AT_PROVIDES, AT_REQUIRES, elemPro, elemReq, colaContractDefList, atVisibility, elementBody
            // token labels: 
            // rule labels: retval, elemExt
            // token list labels: 
            // rule list labels: elemPro, elemReq
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_elemExt=new RewriteRuleSubtreeStream(adaptor,"rule elemExt",elemExt!=null?elemExt.tree:null);
            RewriteRuleSubtreeStream stream_elemPro=new RewriteRuleSubtreeStream(adaptor,"token elemPro",list_elemPro);
            RewriteRuleSubtreeStream stream_elemReq=new RewriteRuleSubtreeStream(adaptor,"token elemReq",list_elemReq);
            root_0 = (CommonTree)adaptor.nil();
            // 235:27: -> ^( ELEMENT IDENT ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? ( ^( AT_EXTENDS $elemExt) )? ( ^( AT_PROVIDES ( $elemPro)+ ) )? ( ^( AT_REQUIRES ( $elemReq)+ ) )? ( elementBody )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:235:30: ^( ELEMENT IDENT ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? ( ^( AT_EXTENDS $elemExt) )? ( ^( AT_PROVIDES ( $elemPro)+ ) )? ( ^( AT_REQUIRES ( $elemReq)+ ) )? ( elementBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_ELEMENT.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:235:46: ( colaPropertyDefList )?
                if ( stream_colaPropertyDefList.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaPropertyDefList.nextTree());

                }
                stream_colaPropertyDefList.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:235:67: ( colaContractDefList )?
                if ( stream_colaContractDefList.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaContractDefList.nextTree());

                }
                stream_colaContractDefList.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:235:88: ( atVisibility )?
                if ( stream_atVisibility.hasNext() ) {
                    adaptor.addChild(root_1, stream_atVisibility.nextTree());

                }
                stream_atVisibility.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:236:33: ( ^( AT_EXTENDS $elemExt) )?
                if ( stream_elemExt.hasNext()||stream_AT_EXTENDS.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:236:33: ^( AT_EXTENDS $elemExt)
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_EXTENDS.nextNode(), root_2);

                    adaptor.addChild(root_2, stream_elemExt.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_elemExt.reset();
                stream_AT_EXTENDS.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:236:57: ( ^( AT_PROVIDES ( $elemPro)+ ) )?
                if ( stream_AT_PROVIDES.hasNext()||stream_elemPro.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:236:57: ^( AT_PROVIDES ( $elemPro)+ )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_PROVIDES.nextNode(), root_2);

                    if ( !(stream_elemPro.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_elemPro.hasNext() ) {
                        adaptor.addChild(root_2, stream_elemPro.nextTree());

                    }
                    stream_elemPro.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_AT_PROVIDES.reset();
                stream_elemPro.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:236:83: ( ^( AT_REQUIRES ( $elemReq)+ ) )?
                if ( stream_AT_REQUIRES.hasNext()||stream_elemReq.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:236:83: ^( AT_REQUIRES ( $elemReq)+ )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_REQUIRES.nextNode(), root_2);

                    if ( !(stream_elemReq.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_elemReq.hasNext() ) {
                        adaptor.addChild(root_2, stream_elemReq.nextTree());

                    }
                    stream_elemReq.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_AT_REQUIRES.reset();
                stream_elemReq.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:237:33: ( elementBody )*
                while ( stream_elementBody.hasNext() ) {
                    adaptor.addChild(root_1, stream_elementBody.nextTree());

                }
                stream_elementBody.reset();

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
    // $ANTLR end "colaElement"

    public static class elementBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementBody"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:240:1: elementBody : ( elementContains | colaAttribute | colaAction | inline_code );
    public final colaEbnfParser.elementBody_return elementBody() throws RecognitionException {
        colaEbnfParser.elementBody_return retval = new colaEbnfParser.elementBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        colaEbnfParser.elementContains_return elementContains225 = null;

        colaEbnfParser.colaAttribute_return colaAttribute226 = null;

        colaEbnfParser.colaAction_return colaAction227 = null;

        colaEbnfParser.inline_code_return inline_code228 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:240:25: ( elementContains | colaAttribute | colaAction | inline_code )
            int alt63=4;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:240:27: elementContains
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_elementContains_in_elementBody4090);
                    elementContains225=elementContains();

                    state._fsp--;

                    adaptor.addChild(root_0, elementContains225.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:240:45: colaAttribute
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaAttribute_in_elementBody4094);
                    colaAttribute226=colaAttribute();

                    state._fsp--;

                    adaptor.addChild(root_0, colaAttribute226.getTree());

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:240:61: colaAction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaAction_in_elementBody4098);
                    colaAction227=colaAction();

                    state._fsp--;

                    adaptor.addChild(root_0, colaAction227.getTree());

                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:240:74: inline_code
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_inline_code_in_elementBody4102);
                    inline_code228=inline_code();

                    state._fsp--;

                    adaptor.addChild(root_0, inline_code228.getTree());

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
    // $ANTLR end "elementBody"

    public static class elementContains_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementContains"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:241:1: elementContains : AT_CONTAINS s= IDENT elemCont+= scoped_name ';' -> ^( AT_CONTAINS IDENT $elemCont) ;
    public final colaEbnfParser.elementContains_return elementContains() throws RecognitionException {
        colaEbnfParser.elementContains_return retval = new colaEbnfParser.elementContains_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token AT_CONTAINS229=null;
        Token char_literal230=null;
        List list_elemCont=null;
        RuleReturnScope elemCont = null;
        CommonTree s_tree=null;
        CommonTree AT_CONTAINS229_tree=null;
        CommonTree char_literal230_tree=null;
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_AT_CONTAINS=new RewriteRuleTokenStream(adaptor,"token AT_CONTAINS");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:241:25: ( AT_CONTAINS s= IDENT elemCont+= scoped_name ';' -> ^( AT_CONTAINS IDENT $elemCont) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:241:27: AT_CONTAINS s= IDENT elemCont+= scoped_name ';'
            {
            AT_CONTAINS229=(Token)match(input,AT_CONTAINS,FOLLOW_AT_CONTAINS_in_elementContains4117);  
            stream_AT_CONTAINS.add(AT_CONTAINS229);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_elementContains4121);  
            stream_IDENT.add(s);

            this.pass.putAtom(s,ColaTokensConstants.colaAT_CONTAINS);
            pushFollow(FOLLOW_scoped_name_in_elementContains4127);
            elemCont=scoped_name();

            state._fsp--;

            stream_scoped_name.add(elemCont.getTree());
            if (list_elemCont==null) list_elemCont=new ArrayList();
            list_elemCont.add(elemCont.getTree());

            char_literal230=(Token)match(input,97,FOLLOW_97_in_elementContains4129);  
            stream_97.add(char_literal230);

            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: IDENT, AT_CONTAINS, elemCont
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: elemCont
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_elemCont=new RewriteRuleSubtreeStream(adaptor,"token elemCont",list_elemCont);
            root_0 = (CommonTree)adaptor.nil();
            // 242:27: -> ^( AT_CONTAINS IDENT $elemCont)
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:242:30: ^( AT_CONTAINS IDENT $elemCont)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_AT_CONTAINS.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_elemCont.nextTree());

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
    // $ANTLR end "elementContains"

    public static class colaFacility_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaFacility"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:243:1: colaFacility : ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? FACILITY s= IDENT ( AT_EXTENDS ext+= scoped_name ( ',' ext+= scoped_name )* )? ( AT_REQUIRES req+= scoped_name ( ',' req+= scoped_name )* )? '{' ( facilityBody )* '}' -> ^( FACILITY IDENT ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? ( ^( AT_EXTENDS ( $ext)+ ) )? ( ^( AT_REQUIRES ( $req)+ ) )? ( facilityBody )* ) ;
    public final colaEbnfParser.colaFacility_return colaFacility() throws RecognitionException {
        colaEbnfParser.colaFacility_return retval = new colaEbnfParser.colaFacility_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token FACILITY234=null;
        Token AT_EXTENDS235=null;
        Token char_literal236=null;
        Token AT_REQUIRES237=null;
        Token char_literal238=null;
        Token char_literal239=null;
        Token char_literal241=null;
        List list_ext=null;
        List list_req=null;
        colaEbnfParser.colaPropertyDefList_return colaPropertyDefList231 = null;

        colaEbnfParser.colaContractDefList_return colaContractDefList232 = null;

        colaEbnfParser.atVisibility_return atVisibility233 = null;

        colaEbnfParser.facilityBody_return facilityBody240 = null;

        RuleReturnScope ext = null;
        RuleReturnScope req = null;
        CommonTree s_tree=null;
        CommonTree FACILITY234_tree=null;
        CommonTree AT_EXTENDS235_tree=null;
        CommonTree char_literal236_tree=null;
        CommonTree AT_REQUIRES237_tree=null;
        CommonTree char_literal238_tree=null;
        CommonTree char_literal239_tree=null;
        CommonTree char_literal241_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_FACILITY=new RewriteRuleTokenStream(adaptor,"token FACILITY");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_AT_REQUIRES=new RewriteRuleTokenStream(adaptor,"token AT_REQUIRES");
        RewriteRuleTokenStream stream_AT_EXTENDS=new RewriteRuleTokenStream(adaptor,"token AT_EXTENDS");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_facilityBody=new RewriteRuleSubtreeStream(adaptor,"rule facilityBody");
        RewriteRuleSubtreeStream stream_colaContractDefList=new RewriteRuleSubtreeStream(adaptor,"rule colaContractDefList");
        RewriteRuleSubtreeStream stream_atVisibility=new RewriteRuleSubtreeStream(adaptor,"rule atVisibility");
        RewriteRuleSubtreeStream stream_scoped_name=new RewriteRuleSubtreeStream(adaptor,"rule scoped_name");
        RewriteRuleSubtreeStream stream_colaPropertyDefList=new RewriteRuleSubtreeStream(adaptor,"rule colaPropertyDefList");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:243:25: ( ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? FACILITY s= IDENT ( AT_EXTENDS ext+= scoped_name ( ',' ext+= scoped_name )* )? ( AT_REQUIRES req+= scoped_name ( ',' req+= scoped_name )* )? '{' ( facilityBody )* '}' -> ^( FACILITY IDENT ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? ( ^( AT_EXTENDS ( $ext)+ ) )? ( ^( AT_REQUIRES ( $req)+ ) )? ( facilityBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:243:27: ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? FACILITY s= IDENT ( AT_EXTENDS ext+= scoped_name ( ',' ext+= scoped_name )* )? ( AT_REQUIRES req+= scoped_name ( ',' req+= scoped_name )* )? '{' ( facilityBody )* '}'
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:243:27: ( colaPropertyDefList )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==98) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==IDENT) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:243:27: colaPropertyDefList
                    {
                    pushFollow(FOLLOW_colaPropertyDefList_in_colaFacility4186);
                    colaPropertyDefList231=colaPropertyDefList();

                    state._fsp--;

                    stream_colaPropertyDefList.add(colaPropertyDefList231.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:243:48: ( colaContractDefList )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==98) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:243:48: colaContractDefList
                    {
                    pushFollow(FOLLOW_colaContractDefList_in_colaFacility4189);
                    colaContractDefList232=colaContractDefList();

                    state._fsp--;

                    stream_colaContractDefList.add(colaContractDefList232.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:243:69: ( atVisibility )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==AT_VISIBILITY) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:243:69: atVisibility
                    {
                    pushFollow(FOLLOW_atVisibility_in_colaFacility4192);
                    atVisibility233=atVisibility();

                    state._fsp--;

                    stream_atVisibility.add(atVisibility233.getTree());

                    }
                    break;

            }

            FACILITY234=(Token)match(input,FACILITY,FOLLOW_FACILITY_in_colaFacility4221);  
            stream_FACILITY.add(FACILITY234);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaFacility4225);  
            stream_IDENT.add(s);

            this.pass.putAtom(s,ColaTokensConstants.colaFACILITY);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:246:27: ( AT_EXTENDS ext+= scoped_name ( ',' ext+= scoped_name )* )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==AT_EXTENDS) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:246:28: AT_EXTENDS ext+= scoped_name ( ',' ext+= scoped_name )*
                    {
                    AT_EXTENDS235=(Token)match(input,AT_EXTENDS,FOLLOW_AT_EXTENDS_in_colaFacility4282);  
                    stream_AT_EXTENDS.add(AT_EXTENDS235);

                    pushFollow(FOLLOW_scoped_name_in_colaFacility4286);
                    ext=scoped_name();

                    state._fsp--;

                    stream_scoped_name.add(ext.getTree());
                    if (list_ext==null) list_ext=new ArrayList();
                    list_ext.add(ext.getTree());

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:246:56: ( ',' ext+= scoped_name )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==100) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:246:57: ',' ext+= scoped_name
                    	    {
                    	    char_literal236=(Token)match(input,100,FOLLOW_100_in_colaFacility4289);  
                    	    stream_100.add(char_literal236);

                    	    pushFollow(FOLLOW_scoped_name_in_colaFacility4293);
                    	    ext=scoped_name();

                    	    state._fsp--;

                    	    stream_scoped_name.add(ext.getTree());
                    	    if (list_ext==null) list_ext=new ArrayList();
                    	    list_ext.add(ext.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:247:27: ( AT_REQUIRES req+= scoped_name ( ',' req+= scoped_name )* )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==AT_REQUIRES) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:247:28: AT_REQUIRES req+= scoped_name ( ',' req+= scoped_name )*
                    {
                    AT_REQUIRES237=(Token)match(input,AT_REQUIRES,FOLLOW_AT_REQUIRES_in_colaFacility4326);  
                    stream_AT_REQUIRES.add(AT_REQUIRES237);

                    pushFollow(FOLLOW_scoped_name_in_colaFacility4330);
                    req=scoped_name();

                    state._fsp--;

                    stream_scoped_name.add(req.getTree());
                    if (list_req==null) list_req=new ArrayList();
                    list_req.add(req.getTree());

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:247:57: ( ',' req+= scoped_name )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==100) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:247:58: ',' req+= scoped_name
                    	    {
                    	    char_literal238=(Token)match(input,100,FOLLOW_100_in_colaFacility4333);  
                    	    stream_100.add(char_literal238);

                    	    pushFollow(FOLLOW_scoped_name_in_colaFacility4337);
                    	    req=scoped_name();

                    	    state._fsp--;

                    	    stream_scoped_name.add(req.getTree());
                    	    if (list_req==null) list_req=new ArrayList();
                    	    list_req.add(req.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal239=(Token)match(input,103,FOLLOW_103_in_colaFacility4369);  
            stream_103.add(char_literal239);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:248:31: ( facilityBody )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( ((LA71_0>=ACTION && LA71_0<=ATTRIBUTE)||LA71_0==98) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:248:31: facilityBody
            	    {
            	    pushFollow(FOLLOW_facilityBody_in_colaFacility4371);
            	    facilityBody240=facilityBody();

            	    state._fsp--;

            	    stream_facilityBody.add(facilityBody240.getTree());

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            char_literal241=(Token)match(input,104,FOLLOW_104_in_colaFacility4374);  
            stream_104.add(char_literal241);

            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: ext, IDENT, facilityBody, req, AT_REQUIRES, atVisibility, colaPropertyDefList, FACILITY, colaContractDefList, AT_EXTENDS
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: req, ext
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_req=new RewriteRuleSubtreeStream(adaptor,"token req",list_req);
            RewriteRuleSubtreeStream stream_ext=new RewriteRuleSubtreeStream(adaptor,"token ext",list_ext);
            root_0 = (CommonTree)adaptor.nil();
            // 250:27: -> ^( FACILITY IDENT ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? ( ^( AT_EXTENDS ( $ext)+ ) )? ( ^( AT_REQUIRES ( $req)+ ) )? ( facilityBody )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:250:30: ^( FACILITY IDENT ( colaPropertyDefList )? ( colaContractDefList )? ( atVisibility )? ( ^( AT_EXTENDS ( $ext)+ ) )? ( ^( AT_REQUIRES ( $req)+ ) )? ( facilityBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_FACILITY.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:250:47: ( colaPropertyDefList )?
                if ( stream_colaPropertyDefList.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaPropertyDefList.nextTree());

                }
                stream_colaPropertyDefList.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:250:68: ( colaContractDefList )?
                if ( stream_colaContractDefList.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaContractDefList.nextTree());

                }
                stream_colaContractDefList.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:250:89: ( atVisibility )?
                if ( stream_atVisibility.hasNext() ) {
                    adaptor.addChild(root_1, stream_atVisibility.nextTree());

                }
                stream_atVisibility.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:251:33: ( ^( AT_EXTENDS ( $ext)+ ) )?
                if ( stream_ext.hasNext()||stream_AT_EXTENDS.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:251:33: ^( AT_EXTENDS ( $ext)+ )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_EXTENDS.nextNode(), root_2);

                    if ( !(stream_ext.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_ext.hasNext() ) {
                        adaptor.addChild(root_2, stream_ext.nextTree());

                    }
                    stream_ext.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_ext.reset();
                stream_AT_EXTENDS.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:251:54: ( ^( AT_REQUIRES ( $req)+ ) )?
                if ( stream_req.hasNext()||stream_AT_REQUIRES.hasNext() ) {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:251:54: ^( AT_REQUIRES ( $req)+ )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_AT_REQUIRES.nextNode(), root_2);

                    if ( !(stream_req.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_req.hasNext() ) {
                        adaptor.addChild(root_2, stream_req.nextTree());

                    }
                    stream_req.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_req.reset();
                stream_AT_REQUIRES.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:251:76: ( facilityBody )*
                while ( stream_facilityBody.hasNext() ) {
                    adaptor.addChild(root_1, stream_facilityBody.nextTree());

                }
                stream_facilityBody.reset();

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
    // $ANTLR end "colaFacility"

    public static class facilityBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "facilityBody"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:254:1: facilityBody : ( colaAttribute | colaAction );
    public final colaEbnfParser.facilityBody_return facilityBody() throws RecognitionException {
        colaEbnfParser.facilityBody_return retval = new colaEbnfParser.facilityBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        colaEbnfParser.colaAttribute_return colaAttribute242 = null;

        colaEbnfParser.colaAction_return colaAction243 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:254:25: ( colaAttribute | colaAction )
            int alt72=2;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:254:27: colaAttribute
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaAttribute_in_facilityBody4573);
                    colaAttribute242=colaAttribute();

                    state._fsp--;

                    adaptor.addChild(root_0, colaAttribute242.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:254:43: colaAction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_colaAction_in_facilityBody4577);
                    colaAction243=colaAction();

                    state._fsp--;

                    adaptor.addChild(root_0, colaAction243.getTree());

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
    // $ANTLR end "facilityBody"

    public static class colaAction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaAction"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:255:1: colaAction : ( colaPropertyDefList )? ACTION ( simple_type | void_type ) s= IDENT '(' ( colaParameter ( ',' colaParameter )* )? ')' ( '{' ( inline_code )* '}' )? ';' -> ^( ACTION IDENT ( simple_type )? ( void_type )? ( colaPropertyDefList )? ( colaParameter )* ( inline_code )* ) ;
    public final colaEbnfParser.colaAction_return colaAction() throws RecognitionException {
        colaEbnfParser.colaAction_return retval = new colaEbnfParser.colaAction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token ACTION245=null;
        Token char_literal248=null;
        Token char_literal250=null;
        Token char_literal252=null;
        Token char_literal253=null;
        Token char_literal255=null;
        Token char_literal256=null;
        colaEbnfParser.colaPropertyDefList_return colaPropertyDefList244 = null;

        colaEbnfParser.simple_type_return simple_type246 = null;

        colaEbnfParser.void_type_return void_type247 = null;

        colaEbnfParser.colaParameter_return colaParameter249 = null;

        colaEbnfParser.colaParameter_return colaParameter251 = null;

        colaEbnfParser.inline_code_return inline_code254 = null;


        CommonTree s_tree=null;
        CommonTree ACTION245_tree=null;
        CommonTree char_literal248_tree=null;
        CommonTree char_literal250_tree=null;
        CommonTree char_literal252_tree=null;
        CommonTree char_literal253_tree=null;
        CommonTree char_literal255_tree=null;
        CommonTree char_literal256_tree=null;
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleSubtreeStream stream_colaParameter=new RewriteRuleSubtreeStream(adaptor,"rule colaParameter");
        RewriteRuleSubtreeStream stream_simple_type=new RewriteRuleSubtreeStream(adaptor,"rule simple_type");
        RewriteRuleSubtreeStream stream_inline_code=new RewriteRuleSubtreeStream(adaptor,"rule inline_code");
        RewriteRuleSubtreeStream stream_colaPropertyDefList=new RewriteRuleSubtreeStream(adaptor,"rule colaPropertyDefList");
        RewriteRuleSubtreeStream stream_void_type=new RewriteRuleSubtreeStream(adaptor,"rule void_type");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:255:25: ( ( colaPropertyDefList )? ACTION ( simple_type | void_type ) s= IDENT '(' ( colaParameter ( ',' colaParameter )* )? ')' ( '{' ( inline_code )* '}' )? ';' -> ^( ACTION IDENT ( simple_type )? ( void_type )? ( colaPropertyDefList )? ( colaParameter )* ( inline_code )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:255:27: ( colaPropertyDefList )? ACTION ( simple_type | void_type ) s= IDENT '(' ( colaParameter ( ',' colaParameter )* )? ')' ( '{' ( inline_code )* '}' )? ';'
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:255:27: ( colaPropertyDefList )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==98) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:255:27: colaPropertyDefList
                    {
                    pushFollow(FOLLOW_colaPropertyDefList_in_colaAction4597);
                    colaPropertyDefList244=colaPropertyDefList();

                    state._fsp--;

                    stream_colaPropertyDefList.add(colaPropertyDefList244.getTree());

                    }
                    break;

            }

            ACTION245=(Token)match(input,ACTION,FOLLOW_ACTION_in_colaAction4600);  
            stream_ACTION.add(ACTION245);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:255:55: ( simple_type | void_type )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==IDENT||(LA74_0>=SHORT && LA74_0<=BOOLEAN)) ) {
                alt74=1;
            }
            else if ( (LA74_0==VOID) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:255:56: simple_type
                    {
                    pushFollow(FOLLOW_simple_type_in_colaAction4603);
                    simple_type246=simple_type();

                    state._fsp--;

                    stream_simple_type.add(simple_type246.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:255:68: void_type
                    {
                    pushFollow(FOLLOW_void_type_in_colaAction4605);
                    void_type247=void_type();

                    state._fsp--;

                    stream_void_type.add(void_type247.getTree());

                    }
                    break;

            }

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaAction4610);  
            stream_IDENT.add(s);

            this.pass.putAtom(s,ColaTokensConstants.colaACTION);
            char_literal248=(Token)match(input,95,FOLLOW_95_in_colaAction4640);  
            stream_95.add(char_literal248);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:256:31: ( colaParameter ( ',' colaParameter )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==IDENT||(LA76_0>=SHORT && LA76_0<=BOOLEAN)||LA76_0==98) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:256:32: colaParameter ( ',' colaParameter )*
                    {
                    pushFollow(FOLLOW_colaParameter_in_colaAction4643);
                    colaParameter249=colaParameter();

                    state._fsp--;

                    stream_colaParameter.add(colaParameter249.getTree());
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:256:45: ( ',' colaParameter )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==100) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:256:46: ',' colaParameter
                    	    {
                    	    char_literal250=(Token)match(input,100,FOLLOW_100_in_colaAction4645);  
                    	    stream_100.add(char_literal250);

                    	    pushFollow(FOLLOW_colaParameter_in_colaAction4647);
                    	    colaParameter251=colaParameter();

                    	    state._fsp--;

                    	    stream_colaParameter.add(colaParameter251.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal252=(Token)match(input,96,FOLLOW_96_in_colaAction4653);  
            stream_96.add(char_literal252);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:257:27: ( '{' ( inline_code )* '}' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==103) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:257:28: '{' ( inline_code )* '}'
                    {
                    char_literal253=(Token)match(input,103,FOLLOW_103_in_colaAction4682);  
                    stream_103.add(char_literal253);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:257:32: ( inline_code )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==103) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:257:32: inline_code
                    	    {
                    	    pushFollow(FOLLOW_inline_code_in_colaAction4684);
                    	    inline_code254=inline_code();

                    	    state._fsp--;

                    	    stream_inline_code.add(inline_code254.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);

                    char_literal255=(Token)match(input,104,FOLLOW_104_in_colaAction4687);  
                    stream_104.add(char_literal255);


                    }
                    break;

            }

            char_literal256=(Token)match(input,97,FOLLOW_97_in_colaAction4691);  
            stream_97.add(char_literal256);

            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: IDENT, colaPropertyDefList, inline_code, simple_type, void_type, colaParameter, ACTION
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 259:27: -> ^( ACTION IDENT ( simple_type )? ( void_type )? ( colaPropertyDefList )? ( colaParameter )* ( inline_code )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:259:30: ^( ACTION IDENT ( simple_type )? ( void_type )? ( colaPropertyDefList )? ( colaParameter )* ( inline_code )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_ACTION.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:259:45: ( simple_type )?
                if ( stream_simple_type.hasNext() ) {
                    adaptor.addChild(root_1, stream_simple_type.nextTree());

                }
                stream_simple_type.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:259:58: ( void_type )?
                if ( stream_void_type.hasNext() ) {
                    adaptor.addChild(root_1, stream_void_type.nextTree());

                }
                stream_void_type.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:259:69: ( colaPropertyDefList )?
                if ( stream_colaPropertyDefList.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaPropertyDefList.nextTree());

                }
                stream_colaPropertyDefList.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:259:90: ( colaParameter )*
                while ( stream_colaParameter.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaParameter.nextTree());

                }
                stream_colaParameter.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:259:105: ( inline_code )*
                while ( stream_inline_code.hasNext() ) {
                    adaptor.addChild(root_1, stream_inline_code.nextTree());

                }
                stream_inline_code.reset();

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
    // $ANTLR end "colaAction"

    public static class colaParameter_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaParameter"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:261:1: colaParameter : ( colaPropertyDefList )? simple_type s= IDENT -> ^( PARAMETER IDENT simple_type ( colaPropertyDefList )? ) ;
    public final colaEbnfParser.colaParameter_return colaParameter() throws RecognitionException {
        colaEbnfParser.colaParameter_return retval = new colaEbnfParser.colaParameter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        colaEbnfParser.colaPropertyDefList_return colaPropertyDefList257 = null;

        colaEbnfParser.simple_type_return simple_type258 = null;


        CommonTree s_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_simple_type=new RewriteRuleSubtreeStream(adaptor,"rule simple_type");
        RewriteRuleSubtreeStream stream_colaPropertyDefList=new RewriteRuleSubtreeStream(adaptor,"rule colaPropertyDefList");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:261:25: ( ( colaPropertyDefList )? simple_type s= IDENT -> ^( PARAMETER IDENT simple_type ( colaPropertyDefList )? ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:261:27: ( colaPropertyDefList )? simple_type s= IDENT
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:261:27: ( colaPropertyDefList )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==98) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:261:27: colaPropertyDefList
                    {
                    pushFollow(FOLLOW_colaPropertyDefList_in_colaParameter4812);
                    colaPropertyDefList257=colaPropertyDefList();

                    state._fsp--;

                    stream_colaPropertyDefList.add(colaPropertyDefList257.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_simple_type_in_colaParameter4815);
            simple_type258=simple_type();

            state._fsp--;

            stream_simple_type.add(simple_type258.getTree());
            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaParameter4819);  
            stream_IDENT.add(s);

            this.pass.putAtom(s,ColaTokensConstants.colaPARAMETER);
            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: IDENT, simple_type, colaPropertyDefList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 262:27: -> ^( PARAMETER IDENT simple_type ( colaPropertyDefList )? )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:262:30: ^( PARAMETER IDENT simple_type ( colaPropertyDefList )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMETER, "PARAMETER"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_simple_type.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:262:60: ( colaPropertyDefList )?
                if ( stream_colaPropertyDefList.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaPropertyDefList.nextTree());

                }
                stream_colaPropertyDefList.reset();

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
    // $ANTLR end "colaParameter"

    public static class colaTypeDef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaTypeDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:263:1: colaTypeDef : ( colaPropertyDefList )? TYPEDEF simple_type s= IDENT ( '{' ( inline_code )* '}' )? ';' -> ^( TYPEDEF IDENT simple_type ( colaPropertyDefList )? ( inline_code )* ) ;
    public final colaEbnfParser.colaTypeDef_return colaTypeDef() throws RecognitionException {
        colaEbnfParser.colaTypeDef_return retval = new colaEbnfParser.colaTypeDef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token TYPEDEF260=null;
        Token char_literal262=null;
        Token char_literal264=null;
        Token char_literal265=null;
        colaEbnfParser.colaPropertyDefList_return colaPropertyDefList259 = null;

        colaEbnfParser.simple_type_return simple_type261 = null;

        colaEbnfParser.inline_code_return inline_code263 = null;


        CommonTree s_tree=null;
        CommonTree TYPEDEF260_tree=null;
        CommonTree char_literal262_tree=null;
        CommonTree char_literal264_tree=null;
        CommonTree char_literal265_tree=null;
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_TYPEDEF=new RewriteRuleTokenStream(adaptor,"token TYPEDEF");
        RewriteRuleSubtreeStream stream_simple_type=new RewriteRuleSubtreeStream(adaptor,"rule simple_type");
        RewriteRuleSubtreeStream stream_inline_code=new RewriteRuleSubtreeStream(adaptor,"rule inline_code");
        RewriteRuleSubtreeStream stream_colaPropertyDefList=new RewriteRuleSubtreeStream(adaptor,"rule colaPropertyDefList");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:263:25: ( ( colaPropertyDefList )? TYPEDEF simple_type s= IDENT ( '{' ( inline_code )* '}' )? ';' -> ^( TYPEDEF IDENT simple_type ( colaPropertyDefList )? ( inline_code )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:263:27: ( colaPropertyDefList )? TYPEDEF simple_type s= IDENT ( '{' ( inline_code )* '}' )? ';'
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:263:27: ( colaPropertyDefList )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==98) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:263:27: colaPropertyDefList
                    {
                    pushFollow(FOLLOW_colaPropertyDefList_in_colaTypeDef4881);
                    colaPropertyDefList259=colaPropertyDefList();

                    state._fsp--;

                    stream_colaPropertyDefList.add(colaPropertyDefList259.getTree());

                    }
                    break;

            }

            TYPEDEF260=(Token)match(input,TYPEDEF,FOLLOW_TYPEDEF_in_colaTypeDef4910);  
            stream_TYPEDEF.add(TYPEDEF260);

            pushFollow(FOLLOW_simple_type_in_colaTypeDef4912);
            simple_type261=simple_type();

            state._fsp--;

            stream_simple_type.add(simple_type261.getTree());
            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaTypeDef4916);  
            stream_IDENT.add(s);

            this.pass.putAtom(s,ColaTokensConstants.colaTYPEDEF);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:265:27: ( '{' ( inline_code )* '}' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==103) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:265:28: '{' ( inline_code )* '}'
                    {
                    char_literal262=(Token)match(input,103,FOLLOW_103_in_colaTypeDef4947);  
                    stream_103.add(char_literal262);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:265:32: ( inline_code )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==103) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:265:32: inline_code
                    	    {
                    	    pushFollow(FOLLOW_inline_code_in_colaTypeDef4949);
                    	    inline_code263=inline_code();

                    	    state._fsp--;

                    	    stream_inline_code.add(inline_code263.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop81;
                        }
                    } while (true);

                    char_literal264=(Token)match(input,104,FOLLOW_104_in_colaTypeDef4952);  
                    stream_104.add(char_literal264);


                    }
                    break;

            }

            char_literal265=(Token)match(input,97,FOLLOW_97_in_colaTypeDef4956);  
            stream_97.add(char_literal265);

            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: simple_type, TYPEDEF, IDENT, inline_code, colaPropertyDefList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 267:27: -> ^( TYPEDEF IDENT simple_type ( colaPropertyDefList )? ( inline_code )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:267:30: ^( TYPEDEF IDENT simple_type ( colaPropertyDefList )? ( inline_code )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_TYPEDEF.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_simple_type.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:267:58: ( colaPropertyDefList )?
                if ( stream_colaPropertyDefList.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaPropertyDefList.nextTree());

                }
                stream_colaPropertyDefList.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:267:79: ( inline_code )*
                while ( stream_inline_code.hasNext() ) {
                    adaptor.addChild(root_1, stream_inline_code.nextTree());

                }
                stream_inline_code.reset();

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
    // $ANTLR end "colaTypeDef"

    public static class colaAttribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaAttribute"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:269:1: colaAttribute : ( colaPropertyDefList )? ATTRIBUTE simple_type s= IDENT ( '{' ( inline_code )* '}' )? ';' -> ^( ATTRIBUTE IDENT simple_type ( colaPropertyDefList )? ( inline_code )* ) ;
    public final colaEbnfParser.colaAttribute_return colaAttribute() throws RecognitionException {
        colaEbnfParser.colaAttribute_return retval = new colaEbnfParser.colaAttribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token ATTRIBUTE267=null;
        Token char_literal269=null;
        Token char_literal271=null;
        Token char_literal272=null;
        colaEbnfParser.colaPropertyDefList_return colaPropertyDefList266 = null;

        colaEbnfParser.simple_type_return simple_type268 = null;

        colaEbnfParser.inline_code_return inline_code270 = null;


        CommonTree s_tree=null;
        CommonTree ATTRIBUTE267_tree=null;
        CommonTree char_literal269_tree=null;
        CommonTree char_literal271_tree=null;
        CommonTree char_literal272_tree=null;
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_ATTRIBUTE=new RewriteRuleTokenStream(adaptor,"token ATTRIBUTE");
        RewriteRuleSubtreeStream stream_simple_type=new RewriteRuleSubtreeStream(adaptor,"rule simple_type");
        RewriteRuleSubtreeStream stream_inline_code=new RewriteRuleSubtreeStream(adaptor,"rule inline_code");
        RewriteRuleSubtreeStream stream_colaPropertyDefList=new RewriteRuleSubtreeStream(adaptor,"rule colaPropertyDefList");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:269:25: ( ( colaPropertyDefList )? ATTRIBUTE simple_type s= IDENT ( '{' ( inline_code )* '}' )? ';' -> ^( ATTRIBUTE IDENT simple_type ( colaPropertyDefList )? ( inline_code )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:269:27: ( colaPropertyDefList )? ATTRIBUTE simple_type s= IDENT ( '{' ( inline_code )* '}' )? ';'
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:269:27: ( colaPropertyDefList )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==98) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:269:27: colaPropertyDefList
                    {
                    pushFollow(FOLLOW_colaPropertyDefList_in_colaAttribute5070);
                    colaPropertyDefList266=colaPropertyDefList();

                    state._fsp--;

                    stream_colaPropertyDefList.add(colaPropertyDefList266.getTree());

                    }
                    break;

            }

            ATTRIBUTE267=(Token)match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_colaAttribute5073);  
            stream_ATTRIBUTE.add(ATTRIBUTE267);

            pushFollow(FOLLOW_simple_type_in_colaAttribute5075);
            simple_type268=simple_type();

            state._fsp--;

            stream_simple_type.add(simple_type268.getTree());
            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaAttribute5079);  
            stream_IDENT.add(s);

            this.pass.putAtom(s,ColaTokensConstants.colaATTRIBUTE);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:270:27: ( '{' ( inline_code )* '}' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==103) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:270:28: '{' ( inline_code )* '}'
                    {
                    char_literal269=(Token)match(input,103,FOLLOW_103_in_colaAttribute5110);  
                    stream_103.add(char_literal269);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:270:32: ( inline_code )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==103) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:270:32: inline_code
                    	    {
                    	    pushFollow(FOLLOW_inline_code_in_colaAttribute5112);
                    	    inline_code270=inline_code();

                    	    state._fsp--;

                    	    stream_inline_code.add(inline_code270.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop84;
                        }
                    } while (true);

                    char_literal271=(Token)match(input,104,FOLLOW_104_in_colaAttribute5115);  
                    stream_104.add(char_literal271);


                    }
                    break;

            }

            char_literal272=(Token)match(input,97,FOLLOW_97_in_colaAttribute5119);  
            stream_97.add(char_literal272);

            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: colaPropertyDefList, IDENT, inline_code, ATTRIBUTE, simple_type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 272:27: -> ^( ATTRIBUTE IDENT simple_type ( colaPropertyDefList )? ( inline_code )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:272:30: ^( ATTRIBUTE IDENT simple_type ( colaPropertyDefList )? ( inline_code )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_ATTRIBUTE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_simple_type.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:272:60: ( colaPropertyDefList )?
                if ( stream_colaPropertyDefList.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaPropertyDefList.nextTree());

                }
                stream_colaPropertyDefList.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:272:81: ( inline_code )*
                while ( stream_inline_code.hasNext() ) {
                    adaptor.addChild(root_1, stream_inline_code.nextTree());

                }
                stream_inline_code.reset();

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
    // $ANTLR end "colaAttribute"

    public static class colaStruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaStruct"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:274:1: colaStruct : ( colaPropertyDefList )? STRUCT s= IDENT '{' ( colaMember | inline_code )* '}' -> ^( STRUCT IDENT ( colaPropertyDefList )? ( colaMember )* ( inline_code )* ) ;
    public final colaEbnfParser.colaStruct_return colaStruct() throws RecognitionException {
        colaEbnfParser.colaStruct_return retval = new colaEbnfParser.colaStruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token STRUCT274=null;
        Token char_literal275=null;
        Token char_literal278=null;
        colaEbnfParser.colaPropertyDefList_return colaPropertyDefList273 = null;

        colaEbnfParser.colaMember_return colaMember276 = null;

        colaEbnfParser.inline_code_return inline_code277 = null;


        CommonTree s_tree=null;
        CommonTree STRUCT274_tree=null;
        CommonTree char_literal275_tree=null;
        CommonTree char_literal278_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_STRUCT=new RewriteRuleTokenStream(adaptor,"token STRUCT");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleSubtreeStream stream_inline_code=new RewriteRuleSubtreeStream(adaptor,"rule inline_code");
        RewriteRuleSubtreeStream stream_colaMember=new RewriteRuleSubtreeStream(adaptor,"rule colaMember");
        RewriteRuleSubtreeStream stream_colaPropertyDefList=new RewriteRuleSubtreeStream(adaptor,"rule colaPropertyDefList");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:274:25: ( ( colaPropertyDefList )? STRUCT s= IDENT '{' ( colaMember | inline_code )* '}' -> ^( STRUCT IDENT ( colaPropertyDefList )? ( colaMember )* ( inline_code )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:274:27: ( colaPropertyDefList )? STRUCT s= IDENT '{' ( colaMember | inline_code )* '}'
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:274:27: ( colaPropertyDefList )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==98) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:274:27: colaPropertyDefList
                    {
                    pushFollow(FOLLOW_colaPropertyDefList_in_colaStruct5236);
                    colaPropertyDefList273=colaPropertyDefList();

                    state._fsp--;

                    stream_colaPropertyDefList.add(colaPropertyDefList273.getTree());

                    }
                    break;

            }

            STRUCT274=(Token)match(input,STRUCT,FOLLOW_STRUCT_in_colaStruct5239);  
            stream_STRUCT.add(STRUCT274);

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaStruct5243);  
            stream_IDENT.add(s);

            this.pass.putAtom(s,ColaTokensConstants.colaSTRUCT);
            char_literal275=(Token)match(input,103,FOLLOW_103_in_colaStruct5273);  
            stream_103.add(char_literal275);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:275:31: ( colaMember | inline_code )*
            loop87:
            do {
                int alt87=3;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==IDENT||(LA87_0>=SHORT && LA87_0<=BOOLEAN)||LA87_0==98) ) {
                    alt87=1;
                }
                else if ( (LA87_0==103) ) {
                    alt87=2;
                }


                switch (alt87) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:275:32: colaMember
            	    {
            	    pushFollow(FOLLOW_colaMember_in_colaStruct5276);
            	    colaMember276=colaMember();

            	    state._fsp--;

            	    stream_colaMember.add(colaMember276.getTree());

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:275:45: inline_code
            	    {
            	    pushFollow(FOLLOW_inline_code_in_colaStruct5280);
            	    inline_code277=inline_code();

            	    state._fsp--;

            	    stream_inline_code.add(inline_code277.getTree());

            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);

            char_literal278=(Token)match(input,104,FOLLOW_104_in_colaStruct5284);  
            stream_104.add(char_literal278);

            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: colaPropertyDefList, inline_code, STRUCT, colaMember, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 277:27: -> ^( STRUCT IDENT ( colaPropertyDefList )? ( colaMember )* ( inline_code )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:277:30: ^( STRUCT IDENT ( colaPropertyDefList )? ( colaMember )* ( inline_code )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_STRUCT.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:277:45: ( colaPropertyDefList )?
                if ( stream_colaPropertyDefList.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaPropertyDefList.nextTree());

                }
                stream_colaPropertyDefList.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:277:66: ( colaMember )*
                while ( stream_colaMember.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaMember.nextTree());

                }
                stream_colaMember.reset();
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:277:78: ( inline_code )*
                while ( stream_inline_code.hasNext() ) {
                    adaptor.addChild(root_1, stream_inline_code.nextTree());

                }
                stream_inline_code.reset();

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
    // $ANTLR end "colaStruct"

    public static class colaMember_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colaMember"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:279:1: colaMember : ( colaPropertyDefList )? simple_type s= IDENT ';' -> ^( MEMBER IDENT simple_type ( colaPropertyDefList )? ) ;
    public final colaEbnfParser.colaMember_return colaMember() throws RecognitionException {
        colaEbnfParser.colaMember_return retval = new colaEbnfParser.colaMember_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token char_literal281=null;
        colaEbnfParser.colaPropertyDefList_return colaPropertyDefList279 = null;

        colaEbnfParser.simple_type_return simple_type280 = null;


        CommonTree s_tree=null;
        CommonTree char_literal281_tree=null;
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_simple_type=new RewriteRuleSubtreeStream(adaptor,"rule simple_type");
        RewriteRuleSubtreeStream stream_colaPropertyDefList=new RewriteRuleSubtreeStream(adaptor,"rule colaPropertyDefList");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:279:25: ( ( colaPropertyDefList )? simple_type s= IDENT ';' -> ^( MEMBER IDENT simple_type ( colaPropertyDefList )? ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:279:27: ( colaPropertyDefList )? simple_type s= IDENT ';'
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:279:27: ( colaPropertyDefList )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==98) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:279:27: colaPropertyDefList
                    {
                    pushFollow(FOLLOW_colaPropertyDefList_in_colaMember5402);
                    colaPropertyDefList279=colaPropertyDefList();

                    state._fsp--;

                    stream_colaPropertyDefList.add(colaPropertyDefList279.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_simple_type_in_colaMember5405);
            simple_type280=simple_type();

            state._fsp--;

            stream_simple_type.add(simple_type280.getTree());
            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_colaMember5409);  
            stream_IDENT.add(s);

            char_literal281=(Token)match(input,97,FOLLOW_97_in_colaMember5411);  
            stream_97.add(char_literal281);

            this.pass.putAtom(s,ColaTokensConstants.parserMEMBER);
            this.pass.atoms.scope.pop();


            // AST REWRITE
            // elements: IDENT, colaPropertyDefList, simple_type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 280:27: -> ^( MEMBER IDENT simple_type ( colaPropertyDefList )? )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:280:30: ^( MEMBER IDENT simple_type ( colaPropertyDefList )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MEMBER, "MEMBER"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_simple_type.nextTree());
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:280:57: ( colaPropertyDefList )?
                if ( stream_colaPropertyDefList.hasNext() ) {
                    adaptor.addChild(root_1, stream_colaPropertyDefList.nextTree());

                }
                stream_colaPropertyDefList.reset();

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
    // $ANTLR end "colaMember"

    public static class scoped_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scoped_name"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:282:1: scoped_name : (s= IDENT ( '::' s= IDENT )* '::' )? s= IDENT -> ^( AT_SCOPE ( IDENT )* ) ;
    public final colaEbnfParser.scoped_name_return scoped_name() throws RecognitionException {
        colaEbnfParser.scoped_name_return retval = new colaEbnfParser.scoped_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;
        Token string_literal282=null;
        Token string_literal283=null;

        CommonTree s_tree=null;
        CommonTree string_literal282_tree=null;
        CommonTree string_literal283_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_105=new RewriteRuleTokenStream(adaptor,"token 105");

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:282:25: ( (s= IDENT ( '::' s= IDENT )* '::' )? s= IDENT -> ^( AT_SCOPE ( IDENT )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:282:27: (s= IDENT ( '::' s= IDENT )* '::' )? s= IDENT
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:282:27: (s= IDENT ( '::' s= IDENT )* '::' )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==IDENT) ) {
                int LA90_1 = input.LA(2);

                if ( (LA90_1==105) ) {
                    alt90=1;
                }
            }
            switch (alt90) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:282:28: s= IDENT ( '::' s= IDENT )* '::'
                    {
                    s=(Token)match(input,IDENT,FOLLOW_IDENT_in_scoped_name5477);  
                    stream_IDENT.add(s);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:282:36: ( '::' s= IDENT )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==105) ) {
                            int LA89_1 = input.LA(2);

                            if ( (LA89_1==IDENT) ) {
                                int LA89_2 = input.LA(3);

                                if ( (LA89_2==105) ) {
                                    alt89=1;
                                }


                            }


                        }


                        switch (alt89) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:282:37: '::' s= IDENT
                    	    {
                    	    string_literal282=(Token)match(input,105,FOLLOW_105_in_scoped_name5480);  
                    	    stream_105.add(string_literal282);

                    	    s=(Token)match(input,IDENT,FOLLOW_IDENT_in_scoped_name5484);  
                    	    stream_IDENT.add(s);


                    	    }
                    	    break;

                    	default :
                    	    break loop89;
                        }
                    } while (true);

                    string_literal283=(Token)match(input,105,FOLLOW_105_in_scoped_name5488);  
                    stream_105.add(string_literal283);


                    }
                    break;

            }

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_scoped_name5494);  
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
            // 282:67: -> ^( AT_SCOPE ( IDENT )* )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:282:70: ^( AT_SCOPE ( IDENT )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AT_SCOPE, "AT_SCOPE"), root_1);

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:282:81: ( IDENT )*
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:284:1: void_type : VOID ;
    public final colaEbnfParser.void_type_return void_type() throws RecognitionException {
        colaEbnfParser.void_type_return retval = new colaEbnfParser.void_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VOID284=null;

        CommonTree VOID284_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:284:25: ( VOID )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:284:27: VOID
            {
            root_0 = (CommonTree)adaptor.nil();

            VOID284=(Token)match(input,VOID,FOLLOW_VOID_in_void_type5525); 
            VOID284_tree = (CommonTree)adaptor.create(VOID284);
            adaptor.addChild(root_0, VOID284_tree);


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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:285:1: simple_type : ( scoped_name | base_type ) ( array )? ;
    public final colaEbnfParser.simple_type_return simple_type() throws RecognitionException {
        colaEbnfParser.simple_type_return retval = new colaEbnfParser.simple_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        colaEbnfParser.scoped_name_return scoped_name285 = null;

        colaEbnfParser.base_type_return base_type286 = null;

        colaEbnfParser.array_return array287 = null;



        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:285:25: ( ( scoped_name | base_type ) ( array )? )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:285:27: ( scoped_name | base_type ) ( array )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:285:27: ( scoped_name | base_type )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==IDENT) ) {
                alt91=1;
            }
            else if ( ((LA91_0>=SHORT && LA91_0<=BOOLEAN)) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:285:28: scoped_name
                    {
                    pushFollow(FOLLOW_scoped_name_in_simple_type5545);
                    scoped_name285=scoped_name();

                    state._fsp--;

                    adaptor.addChild(root_0, scoped_name285.getTree());

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:285:42: base_type
                    {
                    pushFollow(FOLLOW_base_type_in_simple_type5549);
                    base_type286=base_type();

                    state._fsp--;

                    adaptor.addChild(root_0, base_type286.getTree());

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:285:53: ( array )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==98) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:285:53: array
                    {
                    pushFollow(FOLLOW_array_in_simple_type5552);
                    array287=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array287.getTree());

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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:1: base_type : (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN ) ;
    public final colaEbnfParser.base_type_return base_type() throws RecognitionException {
        colaEbnfParser.base_type_return retval = new colaEbnfParser.base_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token s=null;

        CommonTree s_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:25: ( (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:27: (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN )
            {
            root_0 = (CommonTree)adaptor.nil();

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:27: (s= SHORT | s= INTEGER | s= LONG | s= OCTET | s= HEX | s= BINARY | s= FLOAT | s= DOUBLE | s= CHAR | s= STRING | s= BOOLEAN )
            int alt93=11;
            switch ( input.LA(1) ) {
            case SHORT:
                {
                alt93=1;
                }
                break;
            case INTEGER:
                {
                alt93=2;
                }
                break;
            case LONG:
                {
                alt93=3;
                }
                break;
            case OCTET:
                {
                alt93=4;
                }
                break;
            case HEX:
                {
                alt93=5;
                }
                break;
            case BINARY:
                {
                alt93=6;
                }
                break;
            case FLOAT:
                {
                alt93=7;
                }
                break;
            case DOUBLE:
                {
                alt93=8;
                }
                break;
            case CHAR:
                {
                alt93=9;
                }
                break;
            case STRING:
                {
                alt93=10;
                }
                break;
            case BOOLEAN:
                {
                alt93=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:28: s= SHORT
                    {
                    s=(Token)match(input,SHORT,FOLLOW_SHORT_in_base_type5604); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:38: s= INTEGER
                    {
                    s=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_base_type5610); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:50: s= LONG
                    {
                    s=(Token)match(input,LONG,FOLLOW_LONG_in_base_type5616); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:59: s= OCTET
                    {
                    s=(Token)match(input,OCTET,FOLLOW_OCTET_in_base_type5622); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:69: s= HEX
                    {
                    s=(Token)match(input,HEX,FOLLOW_HEX_in_base_type5628); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:77: s= BINARY
                    {
                    s=(Token)match(input,BINARY,FOLLOW_BINARY_in_base_type5634); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:88: s= FLOAT
                    {
                    s=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_base_type5640); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:98: s= DOUBLE
                    {
                    s=(Token)match(input,DOUBLE,FOLLOW_DOUBLE_in_base_type5646); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 9 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:109: s= CHAR
                    {
                    s=(Token)match(input,CHAR,FOLLOW_CHAR_in_base_type5652); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 10 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:118: s= STRING
                    {
                    s=(Token)match(input,STRING,FOLLOW_STRING_in_base_type5658); 
                    s_tree = (CommonTree)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);


                    }
                    break;
                case 11 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:287:129: s= BOOLEAN
                    {
                    s=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_base_type5664); 
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:290:1: array : '[' ']' -> ARRAY ;
    public final colaEbnfParser.array_return array() throws RecognitionException {
        colaEbnfParser.array_return retval = new colaEbnfParser.array_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal288=null;
        Token char_literal289=null;

        CommonTree char_literal288_tree=null;
        CommonTree char_literal289_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:290:25: ( '[' ']' -> ARRAY )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:290:27: '[' ']'
            {
            char_literal288=(Token)match(input,98,FOLLOW_98_in_array5745);  
            stream_98.add(char_literal288);

            char_literal289=(Token)match(input,99,FOLLOW_99_in_array5747);  
            stream_99.add(char_literal289);

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
            // 290:56: -> ARRAY
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:292:1: const_value : ( VAL_INTEGER -> ^( AT_PROVIDES INTEGER VAL_INTEGER ) | VAL_OCT -> ^( AT_PROVIDES OCTET VAL_OCT ) | VAL_HEX -> ^( AT_PROVIDES HEX VAL_HEX ) | VAL_BINARY -> ^( AT_PROVIDES BINARY VAL_BINARY ) | VAL_FLOAT -> ^( AT_PROVIDES FLOAT VAL_FLOAT ) | VAL_CHAR -> ^( AT_PROVIDES CHAR VAL_CHAR ) | string_value -> ^( AT_PROVIDES STRING string_value ) | boolean_value -> ^( AT_PROVIDES BOOLEAN boolean_value ) );
    public final colaEbnfParser.const_value_return const_value() throws RecognitionException {
        colaEbnfParser.const_value_return retval = new colaEbnfParser.const_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VAL_INTEGER290=null;
        Token VAL_OCT291=null;
        Token VAL_HEX292=null;
        Token VAL_BINARY293=null;
        Token VAL_FLOAT294=null;
        Token VAL_CHAR295=null;
        colaEbnfParser.string_value_return string_value296 = null;

        colaEbnfParser.boolean_value_return boolean_value297 = null;


        CommonTree VAL_INTEGER290_tree=null;
        CommonTree VAL_OCT291_tree=null;
        CommonTree VAL_HEX292_tree=null;
        CommonTree VAL_BINARY293_tree=null;
        CommonTree VAL_FLOAT294_tree=null;
        CommonTree VAL_CHAR295_tree=null;
        RewriteRuleTokenStream stream_VAL_BINARY=new RewriteRuleTokenStream(adaptor,"token VAL_BINARY");
        RewriteRuleTokenStream stream_VAL_INTEGER=new RewriteRuleTokenStream(adaptor,"token VAL_INTEGER");
        RewriteRuleTokenStream stream_VAL_CHAR=new RewriteRuleTokenStream(adaptor,"token VAL_CHAR");
        RewriteRuleTokenStream stream_VAL_OCT=new RewriteRuleTokenStream(adaptor,"token VAL_OCT");
        RewriteRuleTokenStream stream_VAL_FLOAT=new RewriteRuleTokenStream(adaptor,"token VAL_FLOAT");
        RewriteRuleTokenStream stream_VAL_HEX=new RewriteRuleTokenStream(adaptor,"token VAL_HEX");
        RewriteRuleSubtreeStream stream_string_value=new RewriteRuleSubtreeStream(adaptor,"rule string_value");
        RewriteRuleSubtreeStream stream_boolean_value=new RewriteRuleSubtreeStream(adaptor,"rule boolean_value");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:292:25: ( VAL_INTEGER -> ^( AT_PROVIDES INTEGER VAL_INTEGER ) | VAL_OCT -> ^( AT_PROVIDES OCTET VAL_OCT ) | VAL_HEX -> ^( AT_PROVIDES HEX VAL_HEX ) | VAL_BINARY -> ^( AT_PROVIDES BINARY VAL_BINARY ) | VAL_FLOAT -> ^( AT_PROVIDES FLOAT VAL_FLOAT ) | VAL_CHAR -> ^( AT_PROVIDES CHAR VAL_CHAR ) | string_value -> ^( AT_PROVIDES STRING string_value ) | boolean_value -> ^( AT_PROVIDES BOOLEAN boolean_value ) )
            int alt94=8;
            switch ( input.LA(1) ) {
            case VAL_INTEGER:
                {
                alt94=1;
                }
                break;
            case VAL_OCT:
                {
                alt94=2;
                }
                break;
            case VAL_HEX:
                {
                alt94=3;
                }
                break;
            case VAL_BINARY:
                {
                alt94=4;
                }
                break;
            case VAL_FLOAT:
                {
                alt94=5;
                }
                break;
            case VAL_CHAR:
                {
                alt94=6;
                }
                break;
            case VAL_STRING:
            case COLA_NULL:
                {
                alt94=7;
                }
                break;
            case COLA_TRUE:
            case COLA_FALSE:
                {
                alt94=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:292:27: VAL_INTEGER
                    {
                    VAL_INTEGER290=(Token)match(input,VAL_INTEGER,FOLLOW_VAL_INTEGER_in_const_value5773);  
                    stream_VAL_INTEGER.add(VAL_INTEGER290);



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
                    // 292:41: -> ^( AT_PROVIDES INTEGER VAL_INTEGER )
                    {
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:292:44: ^( AT_PROVIDES INTEGER VAL_INTEGER )
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
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:293:27: VAL_OCT
                    {
                    VAL_OCT291=(Token)match(input,VAL_OCT,FOLLOW_VAL_OCT_in_const_value5814);  
                    stream_VAL_OCT.add(VAL_OCT291);



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
                    // 293:41: -> ^( AT_PROVIDES OCTET VAL_OCT )
                    {
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:293:44: ^( AT_PROVIDES OCTET VAL_OCT )
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
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:294:27: VAL_HEX
                    {
                    VAL_HEX292=(Token)match(input,VAL_HEX,FOLLOW_VAL_HEX_in_const_value5859);  
                    stream_VAL_HEX.add(VAL_HEX292);



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
                    // 294:41: -> ^( AT_PROVIDES HEX VAL_HEX )
                    {
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:294:44: ^( AT_PROVIDES HEX VAL_HEX )
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
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:295:27: VAL_BINARY
                    {
                    VAL_BINARY293=(Token)match(input,VAL_BINARY,FOLLOW_VAL_BINARY_in_const_value5904);  
                    stream_VAL_BINARY.add(VAL_BINARY293);



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
                    // 295:41: -> ^( AT_PROVIDES BINARY VAL_BINARY )
                    {
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:295:44: ^( AT_PROVIDES BINARY VAL_BINARY )
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
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:296:27: VAL_FLOAT
                    {
                    VAL_FLOAT294=(Token)match(input,VAL_FLOAT,FOLLOW_VAL_FLOAT_in_const_value5946);  
                    stream_VAL_FLOAT.add(VAL_FLOAT294);



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
                    // 296:41: -> ^( AT_PROVIDES FLOAT VAL_FLOAT )
                    {
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:296:44: ^( AT_PROVIDES FLOAT VAL_FLOAT )
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
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:297:27: VAL_CHAR
                    {
                    VAL_CHAR295=(Token)match(input,VAL_CHAR,FOLLOW_VAL_CHAR_in_const_value5989);  
                    stream_VAL_CHAR.add(VAL_CHAR295);



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
                    // 297:41: -> ^( AT_PROVIDES CHAR VAL_CHAR )
                    {
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:297:44: ^( AT_PROVIDES CHAR VAL_CHAR )
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
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:298:27: string_value
                    {
                    pushFollow(FOLLOW_string_value_in_const_value6033);
                    string_value296=string_value();

                    state._fsp--;

                    stream_string_value.add(string_value296.getTree());


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
                    // 298:41: -> ^( AT_PROVIDES STRING string_value )
                    {
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:298:44: ^( AT_PROVIDES STRING string_value )
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
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:299:27: boolean_value
                    {
                    pushFollow(FOLLOW_boolean_value_in_const_value6073);
                    boolean_value297=boolean_value();

                    state._fsp--;

                    stream_boolean_value.add(boolean_value297.getTree());


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
                    // 299:41: -> ^( AT_PROVIDES BOOLEAN boolean_value )
                    {
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:299:44: ^( AT_PROVIDES BOOLEAN boolean_value )
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:300:1: string_value : ( VAL_STRING | COLA_NULL );
    public final colaEbnfParser.string_value_return string_value() throws RecognitionException {
        colaEbnfParser.string_value_return retval = new colaEbnfParser.string_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set298=null;

        CommonTree set298_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:300:25: ( VAL_STRING | COLA_NULL )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set298=(Token)input.LT(1);
            if ( (input.LA(1)>=VAL_STRING && input.LA(1)<=COLA_NULL) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set298));
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
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:301:1: boolean_value : ( COLA_TRUE | COLA_FALSE );
    public final colaEbnfParser.boolean_value_return boolean_value() throws RecognitionException {
        colaEbnfParser.boolean_value_return retval = new colaEbnfParser.boolean_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set299=null;

        CommonTree set299_tree=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:301:25: ( COLA_TRUE | COLA_FALSE )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set299=(Token)input.LT(1);
            if ( input.LA(1)==COLA_TRUE||input.LA(1)==COLA_FALSE ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set299));
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

    public static class inline_code_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inline_code"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:303:1: inline_code : '{' AT_LANGUAGE '=' string_value INLINE_CODE '}' -> ^( AT_LANGUAGE string_value INLINE_CODE ) ;
    public final colaEbnfParser.inline_code_return inline_code() throws RecognitionException {
        colaEbnfParser.inline_code_return retval = new colaEbnfParser.inline_code_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal300=null;
        Token AT_LANGUAGE301=null;
        Token char_literal302=null;
        Token INLINE_CODE304=null;
        Token char_literal305=null;
        colaEbnfParser.string_value_return string_value303 = null;


        CommonTree char_literal300_tree=null;
        CommonTree AT_LANGUAGE301_tree=null;
        CommonTree char_literal302_tree=null;
        CommonTree INLINE_CODE304_tree=null;
        CommonTree char_literal305_tree=null;
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_AT_LANGUAGE=new RewriteRuleTokenStream(adaptor,"token AT_LANGUAGE");
        RewriteRuleTokenStream stream_INLINE_CODE=new RewriteRuleTokenStream(adaptor,"token INLINE_CODE");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleSubtreeStream stream_string_value=new RewriteRuleSubtreeStream(adaptor,"rule string_value");
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:303:25: ( '{' AT_LANGUAGE '=' string_value INLINE_CODE '}' -> ^( AT_LANGUAGE string_value INLINE_CODE ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:303:27: '{' AT_LANGUAGE '=' string_value INLINE_CODE '}'
            {
            char_literal300=(Token)match(input,103,FOLLOW_103_in_inline_code6146);  
            stream_103.add(char_literal300);

            AT_LANGUAGE301=(Token)match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_inline_code6148);  
            stream_AT_LANGUAGE.add(AT_LANGUAGE301);

            char_literal302=(Token)match(input,94,FOLLOW_94_in_inline_code6150);  
            stream_94.add(char_literal302);

            pushFollow(FOLLOW_string_value_in_inline_code6152);
            string_value303=string_value();

            state._fsp--;

            stream_string_value.add(string_value303.getTree());
            INLINE_CODE304=(Token)match(input,INLINE_CODE,FOLLOW_INLINE_CODE_in_inline_code6154);  
            stream_INLINE_CODE.add(INLINE_CODE304);

            char_literal305=(Token)match(input,104,FOLLOW_104_in_inline_code6156);  
            stream_104.add(char_literal305);



            // AST REWRITE
            // elements: AT_LANGUAGE, INLINE_CODE, string_value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 304:27: -> ^( AT_LANGUAGE string_value INLINE_CODE )
            {
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:304:30: ^( AT_LANGUAGE string_value INLINE_CODE )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_AT_LANGUAGE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_string_value.nextTree());
                adaptor.addChild(root_1, stream_INLINE_CODE.nextNode());

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
    // $ANTLR end "inline_code"

    // Delegated rules


    protected DFA51 dfa51 = new DFA51(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA72 dfa72 = new DFA72(this);
    static final String DFA51_eotS =
        "\u012c\uffff";
    static final String DFA51_eofS =
        "\u012c\uffff";
    static final String DFA51_minS =
        "\1\4\3\uffff\1\5\1\uffff\1\142\5\uffff\1\147\1\5\1\37\2\5\2\137"+
        "\2\5\1\41\1\5\1\21\2\5\1\136\10\140\1\5\1\142\1\145\1\100\1\41\2"+
        "\5\1\41\1\143\1\5\1\137\2\141\1\5\1\142\10\140\1\5\1\41\1\100\1"+
        "\146\1\100\1\144\1\5\10\140\1\141\1\140\1\40\1\5\1\144\1\41\1\143"+
        "\1\100\2\137\1\5\1\143\11\140\1\5\1\41\1\5\1\142\1\147\1\143\1\145"+
        "\1\100\1\41\10\140\3\5\1\22\2\141\1\5\1\41\1\143\1\137\1\5\1\144"+
        "\1\5\1\100\1\146\1\100\1\143\10\140\1\41\1\137\1\5\1\136\1\141\1"+
        "\140\1\22\10\140\1\41\3\5\1\100\1\41\1\143\10\140\1\5\1\142\11\140"+
        "\1\41\1\143\1\137\1\5\10\140\1\41\1\5\1\144\10\140\1\137\1\5\1\143"+
        "\1\41\1\143\1\41\1\5\1\142\20\140\2\5\1\41\1\143\1\137\1\5\1\144"+
        "\10\140\1\41\1\137\10\140\1\41\1\5\1\41\1\143\10\140\1\5\10\140"+
        "\1\41\1\143\1\137\10\140\1\41\10\140\1\41\1\143\10\140";
    static final String DFA51_maxS =
        "\1\142\3\uffff\1\142\1\uffff\1\142\5\uffff\1\147\1\151\1\37\2\5"+
        "\1\144\1\137\2\151\1\102\1\5\1\142\1\145\1\5\1\136\10\144\1\151"+
        "\1\142\1\145\1\101\1\141\1\151\1\5\1\102\1\144\1\5\2\144\1\141\1"+
        "\146\1\142\10\144\1\151\1\102\1\101\1\146\1\101\1\144\1\143\12\144"+
        "\1\40\1\5\1\150\1\102\1\144\1\101\1\137\1\144\1\5\12\144\1\145\1"+
        "\102\1\5\1\142\1\147\1\143\1\145\1\101\1\141\10\144\1\5\1\143\1"+
        "\5\1\36\1\144\1\141\1\146\1\102\2\144\1\5\1\150\1\151\1\101\1\146"+
        "\1\101\1\143\10\144\1\102\1\144\1\5\1\136\2\144\1\23\10\144\1\102"+
        "\1\5\1\151\1\5\1\101\1\102\11\144\1\5\1\142\11\144\1\102\2\144\1"+
        "\143\10\144\1\102\1\5\1\150\11\144\1\5\1\144\1\102\1\144\1\102\1"+
        "\5\1\142\20\144\1\5\1\143\1\102\2\144\1\5\1\150\10\144\1\102\11"+
        "\144\1\102\1\5\1\102\11\144\1\5\10\144\1\102\12\144\1\102\10\144"+
        "\1\102\11\144";
    static final String DFA51_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\4\1\uffff\1\5\1\6\1\7\1\10\1\11"+
        "\u0120\uffff";
    static final String DFA51_specialS =
        "\u012c\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\1\4\uffff\1\2\7\uffff\1\5\1\7\1\10\12\uffff\1\6\4\uffff"+
            "\1\3\5\uffff\1\13\2\uffff\1\11\1\12\64\uffff\1\4",
            "",
            "",
            "",
            "\1\15\134\uffff\1\14",
            "",
            "\1\16",
            "",
            "",
            "",
            "",
            "",
            "\1\17",
            "\1\21\143\uffff\1\20",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25\3\uffff\1\27\1\26",
            "\1\30",
            "\1\32\143\uffff\1\31",
            "\1\21\143\uffff\1\20",
            "\1\42\30\uffff\1\33\1\34\1\35\1\36\1\37\1\40\2\41\1\42",
            "\1\43",
            "\1\5\1\7\1\10\12\uffff\1\6\15\uffff\1\11\1\12\64\uffff\1\44",
            "\1\45\133\uffff\1\47\3\uffff\1\46",
            "\1\50",
            "\1\51",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\55\143\uffff\1\54",
            "\1\14",
            "\1\46",
            "\2\56",
            "\1\57\77\uffff\1\60",
            "\1\32\143\uffff\1\31",
            "\1\61",
            "\1\71\30\uffff\1\62\1\63\1\64\1\65\1\66\1\67\2\70\1\71",
            "\1\27\1\26",
            "\1\72",
            "\1\73\3\uffff\1\27\1\26",
            "\1\47\2\uffff\1\74",
            "\1\60",
            "\1\75\132\uffff\1\77\5\uffff\1\76",
            "\1\100",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\55\143\uffff\1\54",
            "\1\110\30\uffff\1\101\1\102\1\103\1\104\1\105\1\106\2\107"+
            "\1\110",
            "\2\111",
            "\1\76",
            "\2\112",
            "\1\113",
            "\1\114\135\uffff\1\115",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\47\2\uffff\1\74",
            "\1\77\3\uffff\1\120",
            "\1\121",
            "\1\122",
            "\1\123\3\uffff\1\124",
            "\1\134\30\uffff\1\125\1\126\1\127\1\130\1\131\1\132\2\133"+
            "\1\134",
            "\1\27\1\26",
            "\2\135",
            "\1\136",
            "\1\137\3\uffff\1\115\1\140",
            "\1\141",
            "\1\143\1\142",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\117\3\uffff\1\116",
            "\1\77\3\uffff\1\120",
            "\1\144\133\uffff\1\146\3\uffff\1\145",
            "\1\156\30\uffff\1\147\1\150\1\151\1\152\1\153\1\154\2\155"+
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\145",
            "\2\163",
            "\1\164\77\uffff\1\165",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\170",
            "\1\171\135\uffff\1\172",
            "\1\173",
            "\1\7\1\10\12\uffff\1\6",
            "\1\146\2\uffff\1\174",
            "\1\165",
            "\1\175\132\uffff\1\177\5\uffff\1\176",
            "\1\u0087\30\uffff\1\u0080\1\u0081\1\u0082\1\u0083\1\u0084"+
            "\1\u0085\2\u0086\1\u0087",
            "\1\115\1\140",
            "\1\u0088\3\uffff\1\115\1\140",
            "\1\u0089",
            "\1\123\3\uffff\1\124",
            "\1\u008b\143\uffff\1\u008a",
            "\2\u008c",
            "\1\176",
            "\2\u008d",
            "\1\u008e",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\167\3\uffff\1\166",
            "\1\u0096\30\uffff\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093"+
            "\1\u0094\2\u0095\1\u0096",
            "\1\u0097\3\uffff\1\172\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\146\2\uffff\1\174",
            "\1\177\3\uffff\1\u009b",
            "\1\7\1\10",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u00a5\30\uffff\1\u009e\1\u009f\1\u00a0\1\u00a1\1\u00a2"+
            "\1\u00a3\2\u00a4\1\u00a5",
            "\1\u00a6",
            "\1\u008b\143\uffff\1\u008a",
            "\1\u00a7",
            "\2\u00a8",
            "\1\u00b0\30\uffff\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad"+
            "\1\u00ae\2\u00af\1\u00b0",
            "\1\115\1\140",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b3",
            "\1\u00b4",
            "\1\177\3\uffff\1\u009b",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009c",
            "\1\u00bc\30\uffff\1\u00b5\1\u00b6\1\u00b7\1\u00b8\1\u00b9"+
            "\1\u00ba\2\u00bb\1\u00bc",
            "\1\172\1\u0098",
            "\1\u00bd\3\uffff\1\172\1\u0098",
            "\1\u00be\135\uffff\1\u00bf",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b1",
            "\1\u00c7\30\uffff\1\u00c0\1\u00c1\1\u00c2\1\u00c3\1\u00c4"+
            "\1\u00c5\2\u00c6\1\u00c7",
            "\1\u00c8",
            "\1\u00c9\3\uffff\1\u00ca",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cd\3\uffff\1\u00bf\1\u00ce",
            "\1\u00cf",
            "\1\143\1\142",
            "\1\u00d7\30\uffff\1\u00d0\1\u00d1\1\u00d2\1\u00d3\1\u00d4"+
            "\1\u00d5\2\u00d6\1\u00d7",
            "\1\172\1\u0098",
            "\1\u00df\30\uffff\1\u00d8\1\u00d9\1\u00da\1\u00db\1\u00dc"+
            "\1\u00dd\2\u00de\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00cc\3\uffff\1\u00cb",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e4",
            "\1\u00e5\135\uffff\1\u00e6",
            "\1\u00ee\30\uffff\1\u00e7\1\u00e8\1\u00e9\1\u00ea\1\u00eb"+
            "\1\u00ec\2\u00ed\1\u00ee",
            "\1\u00bf\1\u00ce",
            "\1\u00ef\3\uffff\1\u00bf\1\u00ce",
            "\1\u00f0",
            "\1\u00c9\3\uffff\1\u00ca",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00e3\3\uffff\1\u00e2",
            "\1\u00f8\30\uffff\1\u00f1\1\u00f2\1\u00f3\1\u00f4\1\u00f5"+
            "\1\u00f6\2\u00f7\1\u00f8",
            "\1\u00f9\3\uffff\1\u00e6\1\u00fa",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u0104\30\uffff\1\u00fd\1\u00fe\1\u00ff\1\u0100\1\u0101"+
            "\1\u0102\2\u0103\1\u0104",
            "\1\u0105",
            "\1\u010d\30\uffff\1\u0106\1\u0107\1\u0108\1\u0109\1\u010a"+
            "\1\u010b\2\u010c\1\u010d",
            "\1\u00bf\1\u00ce",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u0110",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u00fc\3\uffff\1\u00fb",
            "\1\u0118\30\uffff\1\u0111\1\u0112\1\u0113\1\u0114\1\u0115"+
            "\1\u0116\2\u0117\1\u0118",
            "\1\u00e6\1\u00fa",
            "\1\u0119\3\uffff\1\u00e6\1\u00fa",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u010f\3\uffff\1\u010e",
            "\1\u0121\30\uffff\1\u011a\1\u011b\1\u011c\1\u011d\1\u011e"+
            "\1\u011f\2\u0120\1\u0121",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u012b\30\uffff\1\u0124\1\u0125\1\u0126\1\u0127\1\u0128"+
            "\1\u0129\2\u012a\1\u012b",
            "\1\u00e6\1\u00fa",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122",
            "\1\u0123\3\uffff\1\u0122"
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "218:1: colaDefinition : ( colaFunction | colaPropertyDecl | colaContractDecl | colaPackage | colaElement | colaFacility | colaTypeDef | colaStruct | cpp_directive );";
        }
    }
    static final String DFA63_eotS =
        "\66\uffff";
    static final String DFA63_eofS =
        "\66\uffff";
    static final String DFA63_minS =
        "\1\24\1\uffff\1\5\3\uffff\2\5\1\137\1\5\1\41\1\5\1\24\10\140\1"+
        "\5\1\41\1\143\1\5\1\137\10\140\1\5\1\41\10\140\1\41\1\143\10\140";
    static final String DFA63_maxS =
        "\1\147\1\uffff\1\5\3\uffff\1\151\1\5\1\144\1\151\1\102\1\5\1\25"+
        "\10\144\1\151\1\102\1\144\1\5\11\144\1\151\1\102\10\144\1\102\11"+
        "\144";
    static final String DFA63_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\60\uffff";
    static final String DFA63_specialS =
        "\66\uffff}>";
    static final String[] DFA63_transitionS = {
            "\1\4\1\3\25\uffff\1\1\66\uffff\1\2\4\uffff\1\5",
            "",
            "\1\6",
            "",
            "",
            "",
            "\1\10\143\uffff\1\7",
            "\1\11",
            "\1\12\3\uffff\1\14\1\13",
            "\1\10\143\uffff\1\7",
            "\1\24\30\uffff\1\15\1\16\1\17\1\20\1\21\1\22\2\23\1\24",
            "\1\25",
            "\1\4\1\3",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\31\143\uffff\1\30",
            "\1\41\30\uffff\1\32\1\33\1\34\1\35\1\36\1\37\2\40\1\41",
            "\1\14\1\13",
            "\1\42",
            "\1\43\3\uffff\1\14\1\13",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\31\143\uffff\1\30",
            "\1\53\30\uffff\1\44\1\45\1\46\1\47\1\50\1\51\2\52\1\53",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\65\30\uffff\1\56\1\57\1\60\1\61\1\62\1\63\2\64\1\65",
            "\1\14\1\13",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54",
            "\1\55\3\uffff\1\54"
    };

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "240:1: elementBody : ( elementContains | colaAttribute | colaAction | inline_code );";
        }
    }
    static final String DFA72_eotS =
        "\64\uffff";
    static final String DFA72_eofS =
        "\64\uffff";
    static final String DFA72_minS =
        "\1\24\1\5\2\uffff\2\5\1\137\1\5\1\41\1\5\1\24\10\140\1\5\1\41\1"+
        "\143\1\5\1\137\10\140\1\5\1\41\10\140\1\41\1\143\10\140";
    static final String DFA72_maxS =
        "\1\142\1\5\2\uffff\1\151\1\5\1\144\1\151\1\102\1\5\1\25\10\144"+
        "\1\151\1\102\1\144\1\5\11\144\1\151\1\102\10\144\1\102\11\144";
    static final String DFA72_acceptS =
        "\2\uffff\1\1\1\2\60\uffff";
    static final String DFA72_specialS =
        "\64\uffff}>";
    static final String[] DFA72_transitionS = {
            "\1\3\1\2\114\uffff\1\1",
            "\1\4",
            "",
            "",
            "\1\6\143\uffff\1\5",
            "\1\7",
            "\1\10\3\uffff\1\12\1\11",
            "\1\6\143\uffff\1\5",
            "\1\22\30\uffff\1\13\1\14\1\15\1\16\1\17\1\20\2\21\1\22",
            "\1\23",
            "\1\3\1\2",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\27\143\uffff\1\26",
            "\1\37\30\uffff\1\30\1\31\1\32\1\33\1\34\1\35\2\36\1\37",
            "\1\12\1\11",
            "\1\40",
            "\1\41\3\uffff\1\12\1\11",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\27\143\uffff\1\26",
            "\1\51\30\uffff\1\42\1\43\1\44\1\45\1\46\1\47\2\50\1\51",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\63\30\uffff\1\54\1\55\1\56\1\57\1\60\1\61\2\62\1\63",
            "\1\12\1\11",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52",
            "\1\53\3\uffff\1\52"
    };

    static final short[] DFA72_eot = DFA.unpackEncodedString(DFA72_eotS);
    static final short[] DFA72_eof = DFA.unpackEncodedString(DFA72_eofS);
    static final char[] DFA72_min = DFA.unpackEncodedStringToUnsignedChars(DFA72_minS);
    static final char[] DFA72_max = DFA.unpackEncodedStringToUnsignedChars(DFA72_maxS);
    static final short[] DFA72_accept = DFA.unpackEncodedString(DFA72_acceptS);
    static final short[] DFA72_special = DFA.unpackEncodedString(DFA72_specialS);
    static final short[][] DFA72_transition;

    static {
        int numStates = DFA72_transitionS.length;
        DFA72_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA72_transition[i] = DFA.unpackEncodedString(DFA72_transitionS[i]);
        }
    }

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = DFA72_eot;
            this.eof = DFA72_eof;
            this.min = DFA72_min;
            this.max = DFA72_max;
            this.accept = DFA72_accept;
            this.special = DFA72_special;
            this.transition = DFA72_transition;
        }
        public String getDescription() {
            return "254:1: facilityBody : ( colaAttribute | colaAction );";
        }
    }
 

    public static final BitSet FOLLOW_set_in_a3dsStage0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_a3dsEnvironment0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_a3dsCLevel0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_colaFunction174 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaFunction178 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_colaFunction180 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_AT_LANGUAGE_in_colaFunction182 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_colaFunction184 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_colaFunction186 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARAMETER_in_colaFunction188 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_colaFunction190 = new BitSet(new long[]{0x0000000000000000L,0x0000000500000000L});
    public static final BitSet FOLLOW_colaFunctionParam_in_colaFunction192 = new BitSet(new long[]{0x0000000000000000L,0x0000000500000000L});
    public static final BitSet FOLLOW_96_in_colaFunction195 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_AT_RETURN_in_colaFunction197 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_colaFunction199 = new BitSet(new long[]{0x03FF800000000000L});
    public static final BitSet FOLLOW_base_type_in_colaFunction201 = new BitSet(new long[]{0x0000000000000000L,0x0000000500000000L});
    public static final BitSet FOLLOW_array_in_colaFunction203 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_colaFunction206 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaFunction208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_colaFunctionParam352 = new BitSet(new long[]{0x03FF800000000000L});
    public static final BitSet FOLLOW_base_type_in_colaFunctionParam354 = new BitSet(new long[]{0x0000000000000020L,0x0000000400000000L});
    public static final BitSet FOLLOW_array_in_colaFunctionParam356 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaFunctionParam359 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_colaFunctionParam361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROPERTY_in_colaPropertyDecl415 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaPropertyDecl419 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_colaPropertyDecl421 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_AT_TYPE_in_colaPropertyDecl449 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_colaPropertyDecl451 = new BitSet(new long[]{0x03FF800000000000L});
    public static final BitSet FOLLOW_base_type_in_colaPropertyDecl453 = new BitSet(new long[]{0x0000000000000000L,0x0000000440000000L});
    public static final BitSet FOLLOW_array_in_colaPropertyDecl455 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_colaPropertyDecl458 = new BitSet(new long[]{0xFC00000200000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_const_value_in_colaPropertyDecl460 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_colaPropertyDecl462 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_AT_SCOPE_in_colaPropertyDecl546 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_colaPropertyDecl548 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_propertyScope_in_colaPropertyDecl550 = new BitSet(new long[]{0x0000000000000000L,0x0000000500000000L});
    public static final BitSet FOLLOW_96_in_colaPropertyDecl553 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_propertyApply_in_colaPropertyDecl609 = new BitSet(new long[]{0x0000000440003000L});
    public static final BitSet FOLLOW_atVisibility_in_colaPropertyDecl611 = new BitSet(new long[]{0x0000000440003000L});
    public static final BitSet FOLLOW_AT_ALTERABLE_in_colaPropertyDecl614 = new BitSet(new long[]{0x0000000440003000L});
    public static final BitSet FOLLOW_AT_NEGOTIABLE_in_colaPropertyDecl617 = new BitSet(new long[]{0x0000000440003000L});
    public static final BitSet FOLLOW_atDescription_in_colaPropertyDecl620 = new BitSet(new long[]{0x000000000001C000L,0x0000000200000000L});
    public static final BitSet FOLLOW_AT_EXTENDS_in_colaPropertyDecl649 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_colaPropertyDecl652 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDecl656 = new BitSet(new long[]{0x0000000000000020L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_colaPropertyDecl659 = new BitSet(new long[]{0x0000000000018000L,0x0000000200000000L});
    public static final BitSet FOLLOW_AT_REQUIRES_in_colaPropertyDecl690 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_colaPropertyDecl692 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDecl696 = new BitSet(new long[]{0x0000000000000020L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_colaPropertyDecl699 = new BitSet(new long[]{0x0000000000010000L,0x0000000200000000L});
    public static final BitSet FOLLOW_AT_PRIORITY_in_colaPropertyDecl730 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_colaPropertyDecl732 = new BitSet(new long[]{0x03FF800000000000L});
    public static final BitSet FOLLOW_base_type_in_colaPropertyDecl734 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_colaPropertyDecl736 = new BitSet(new long[]{0xFC00000200000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_const_value_in_colaPropertyDecl738 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_colaPropertyDecl740 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaPropertyDecl770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_propertyScope1089 = new BitSet(new long[]{0x00000000003E0080L});
    public static final BitSet FOLLOW_propertyScopeAtom_in_propertyScope1091 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_propertyScope1093 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_propertyScopeRank_in_propertyScope1095 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_propertyScope1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACKAGE_in_propertyScopeAtom1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELEMENT_in_propertyScopeAtom1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FACILITY_in_propertyScopeAtom1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_propertyScopeAtom1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_propertyScopeAtom1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARAMETER_in_propertyScopeAtom1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REQUIRED_in_propertyScopeRank1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MANDATORY_in_propertyScopeRank1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_propertyScopeRank1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_DEF_in_propertyScopeRank1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_APPLY_in_propertyApply1260 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_propertyApply1262 = new BitSet(new long[]{0x0000000038000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_PRE_in_propertyApply1266 = new BitSet(new long[]{0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_94_in_propertyApply1269 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_propertyApply1273 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_100_in_propertyApply1276 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_propertyApply1280 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_POST_in_propertyApply1330 = new BitSet(new long[]{0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_94_in_propertyApply1333 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_propertyApply1337 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_100_in_propertyApply1340 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_propertyApply1344 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_INV_in_propertyApply1394 = new BitSet(new long[]{0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_94_in_propertyApply1397 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_propertyApply1401 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_100_in_propertyApply1404 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_propertyApply1408 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_96_in_propertyApply1417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_VISIBILITY_in_atVisibility1502 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_atVisibility1504 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_AT_SPEC_in_atVisibility1506 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_atVisibilityData_in_atVisibility1508 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_atVisibility1510 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_AT_RUNTIME_in_atVisibility1512 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_atVisibilityData_in_atVisibility1514 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_atVisibility1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_atVisibilityData1574 = new BitSet(new long[]{0x0000000000000020L,0x0000002200000000L});
    public static final BitSet FOLLOW_IDENT_in_atVisibilityData1603 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_atVisibilityData1606 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData1608 = new BitSet(new long[]{0x0000000000000000L,0x0000001200000000L});
    public static final BitSet FOLLOW_100_in_atVisibilityData1611 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData1613 = new BitSet(new long[]{0x0000000000000000L,0x0000001200000000L});
    public static final BitSet FOLLOW_97_in_atVisibilityData1619 = new BitSet(new long[]{0x0000000200000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_COLA_TRUE_in_atVisibilityData1647 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_atVisibilityData1650 = new BitSet(new long[]{0x0000000000000020L,0x0000004100000000L});
    public static final BitSet FOLLOW_IDENT_in_atVisibilityData1679 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_atVisibilityData1682 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData1684 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_100_in_atVisibilityData1687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData1689 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_96_in_atVisibilityData1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_DESCRIPTION_in_atDescription1766 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_atDescription1768 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atDescription1770 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_atDescription1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_colaPropertyDefList1794 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaPropertyDefList1796 = new BitSet(new long[]{0x0000000000000000L,0x0000001800000000L});
    public static final BitSet FOLLOW_100_in_colaPropertyDefList1799 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaPropertyDefList1801 = new BitSet(new long[]{0x0000000000000000L,0x0000001800000000L});
    public static final BitSet FOLLOW_99_in_colaPropertyDefList1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDef1825 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaPropertyDef1829 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_colaPropertyDef1834 = new BitSet(new long[]{0xFC00000200000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_const_value_in_colaPropertyDef1836 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_100_in_colaPropertyDef1839 = new BitSet(new long[]{0xFC00000200000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_const_value_in_colaPropertyDef1841 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_96_in_colaPropertyDef1845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTRACT_in_colaContractDecl1928 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaContractDecl1932 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_colaContractDecl1934 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_AT_SCOPE_in_colaContractDecl1992 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_colaContractDecl1994 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_contractScope_in_colaContractDecl1996 = new BitSet(new long[]{0x0000000000000000L,0x0000000500000000L});
    public static final BitSet FOLLOW_96_in_colaContractDecl1999 = new BitSet(new long[]{0x0000000440003000L});
    public static final BitSet FOLLOW_atVisibility_in_colaContractDecl2055 = new BitSet(new long[]{0x0000000440003000L});
    public static final BitSet FOLLOW_atDescription_in_colaContractDecl2058 = new BitSet(new long[]{0x0000001000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_contractItem_in_colaContractDecl2061 = new BitSet(new long[]{0x0000001000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaContractDecl2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_contractScope2185 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_contractScopeAtom_in_contractScope2187 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_contractScope2189 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_contractScopeRank_in_contractScope2191 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_contractScope2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELEMENT_in_contractScopeAtom2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FACILITY_in_contractScopeAtom2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REQUIRED_in_contractScopeRank2266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MANDATORY_in_contractScopeRank2272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_contractScopeRank2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_DEF_in_contractScopeRank2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ITEM_in_contractItem2332 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_contractItem2336 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_contractItem2422 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_contractItemProp_in_contractItem2424 = new BitSet(new long[]{0x0000000000000000L,0x0000011000000000L});
    public static final BitSet FOLLOW_100_in_contractItem2427 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_contractItemProp_in_contractItem2429 = new BitSet(new long[]{0x0000000000000000L,0x0000011000000000L});
    public static final BitSet FOLLOW_104_in_contractItem2433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_contractItemProp2512 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_contractItemProp2516 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_contractItemProp2518 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_AT_TYPE_in_contractItemProp2550 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_contractItemProp2552 = new BitSet(new long[]{0x03FF800000000000L});
    public static final BitSet FOLLOW_base_type_in_contractItemProp2554 = new BitSet(new long[]{0x0000000000000000L,0x0000000440000000L});
    public static final BitSet FOLLOW_array_in_contractItemProp2556 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_contractItemProp2559 = new BitSet(new long[]{0xFC00000200000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_const_value_in_contractItemProp2561 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_contractItemProp2563 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_AT_RANK_in_contractItemProp2659 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_contractItemProp2661 = new BitSet(new long[]{0x0000000001C00000L});
    public static final BitSet FOLLOW_contractItemPropRank_in_contractItemProp2663 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_contractItemProp2665 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_propertyApply_in_contractItemProp2697 = new BitSet(new long[]{0x0000000440003000L});
    public static final BitSet FOLLOW_AT_ALTERABLE_in_contractItemProp2699 = new BitSet(new long[]{0x0000000440003000L});
    public static final BitSet FOLLOW_AT_NEGOTIABLE_in_contractItemProp2702 = new BitSet(new long[]{0x0000000440003000L});
    public static final BitSet FOLLOW_atDescription_in_contractItemProp2705 = new BitSet(new long[]{0x0000000000010000L,0x0000000800000000L});
    public static final BitSet FOLLOW_AT_PRIORITY_in_contractItemProp2738 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_contractItemProp2740 = new BitSet(new long[]{0x03FF800000000000L});
    public static final BitSet FOLLOW_base_type_in_contractItemProp2742 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_contractItemProp2744 = new BitSet(new long[]{0xFC00000200000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_const_value_in_contractItemProp2746 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_contractItemProp2748 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_contractItemProp2842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REQUIRED_in_contractItemPropRank2979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MANDATORY_in_contractItemPropRank2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_contractItemPropRank2991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_colaContractDefList3034 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_colaContractDefList3036 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_colaContractDef_in_colaContractDefList3038 = new BitSet(new long[]{0x0000000000000000L,0x0000001800000000L});
    public static final BitSet FOLLOW_100_in_colaContractDefList3041 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_colaContractDef_in_colaContractDefList3043 = new BitSet(new long[]{0x0000000000000000L,0x0000001800000000L});
    public static final BitSet FOLLOW_99_in_colaContractDefList3047 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_colaContractDefList3049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_colaContractDef3069 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaContractDef3071 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaContractDef3075 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_colaContractDef3079 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_colaContractItemDef_in_colaContractDef3081 = new BitSet(new long[]{0x0000000000000000L,0x0000011000000000L});
    public static final BitSet FOLLOW_100_in_colaContractDef3084 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_colaContractItemDef_in_colaContractDef3086 = new BitSet(new long[]{0x0000000000000000L,0x0000011000000000L});
    public static final BitSet FOLLOW_104_in_colaContractDef3090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_colaContractItemDef3114 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_colaItemDefList_in_colaContractItemDef3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_colaItemDefList3133 = new BitSet(new long[]{0x0000000000000020L,0x0000000800000000L});
    public static final BitSet FOLLOW_colaItemDef_in_colaItemDefList3136 = new BitSet(new long[]{0x0000000000000000L,0x0000001800000000L});
    public static final BitSet FOLLOW_100_in_colaItemDefList3139 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_colaItemDef_in_colaItemDefList3141 = new BitSet(new long[]{0x0000000000000000L,0x0000001800000000L});
    public static final BitSet FOLLOW_99_in_colaItemDefList3147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_colaItemDef3171 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaItemDef3175 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_colaItemDef3180 = new BitSet(new long[]{0xFC00000200000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_const_value_in_colaItemDef3182 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_100_in_colaItemDef3185 = new BitSet(new long[]{0xFC00000200000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_const_value_in_colaItemDef3187 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_96_in_colaItemDef3191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cpp_directive_in_colaSpecification3274 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_AT_STAGE_in_colaSpecification3276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000FC0000L});
    public static final BitSet FOLLOW_a3dsStage_in_colaSpecification3278 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaSpecification3280 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_AT_ENVIRONMENT_in_colaSpecification3282 = new BitSet(new long[]{0x0000000000000000L,0x0000000007000000L});
    public static final BitSet FOLLOW_a3dsEnvironment_in_colaSpecification3284 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaSpecification3286 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_AT_CLEVEL_in_colaSpecification3288 = new BitSet(new long[]{0x0000000000040000L,0x0000000018000000L});
    public static final BitSet FOLLOW_a3dsCLevel_in_colaSpecification3290 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaSpecification3292 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_AT_LANGUAGE_in_colaSpecification3294 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaSpecification3298 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaSpecification3300 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_AT_SPEC_in_colaSpecification3302 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaSpecification3306 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaSpecification3308 = new BitSet(new long[]{0x00003208400E0210L,0x0000000400000000L});
    public static final BitSet FOLLOW_colaDefinition_in_colaSpecification3312 = new BitSet(new long[]{0x00003208400E0210L,0x0000000400000000L});
    public static final BitSet FOLLOW_EOF_in_colaSpecification3315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaFunction_in_colaDefinition3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDecl_in_colaDefinition3392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaContractDecl_in_colaDefinition3396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPackage_in_colaDefinition3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaElement_in_colaDefinition3404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaFacility_in_colaDefinition3408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaTypeDef_in_colaDefinition3412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaStruct_in_colaDefinition3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cpp_directive_in_colaDefinition3420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CPP_DIRECTIVE_in_cpp_directive3440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaPackage3462 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_PACKAGE_in_colaPackage3465 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaPackage3469 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_colaPackage3499 = new BitSet(new long[]{0x00003208400E0210L,0x0000018400000000L});
    public static final BitSet FOLLOW_colaDefinition_in_colaPackage3502 = new BitSet(new long[]{0x00003208400E0210L,0x0000018400000000L});
    public static final BitSet FOLLOW_inline_code_in_colaPackage3506 = new BitSet(new long[]{0x00003208400E0210L,0x0000018400000000L});
    public static final BitSet FOLLOW_104_in_colaPackage3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaElement3627 = new BitSet(new long[]{0x0000000040040000L,0x0000000400000000L});
    public static final BitSet FOLLOW_colaContractDefList_in_colaElement3630 = new BitSet(new long[]{0x0000000040040000L});
    public static final BitSet FOLLOW_atVisibility_in_colaElement3633 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ELEMENT_in_colaElement3662 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaElement3666 = new BitSet(new long[]{0x000004000000C000L,0x0000008000000000L});
    public static final BitSet FOLLOW_AT_EXTENDS_in_colaElement3723 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaElement3727 = new BitSet(new long[]{0x0000040000008000L,0x0000008000000000L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_colaElement3758 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaElement3762 = new BitSet(new long[]{0x0000000000008000L,0x0000009000000000L});
    public static final BitSet FOLLOW_100_in_colaElement3765 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaElement3769 = new BitSet(new long[]{0x0000000000008000L,0x0000009000000000L});
    public static final BitSet FOLLOW_AT_REQUIRES_in_colaElement3802 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaElement3806 = new BitSet(new long[]{0x0000000000000000L,0x0000009000000000L});
    public static final BitSet FOLLOW_100_in_colaElement3809 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaElement3813 = new BitSet(new long[]{0x0000000000000000L,0x0000009000000000L});
    public static final BitSet FOLLOW_103_in_colaElement3845 = new BitSet(new long[]{0x00003A08403E0210L,0x0000018400000000L});
    public static final BitSet FOLLOW_elementBody_in_colaElement3847 = new BitSet(new long[]{0x00003A08403E0210L,0x0000018400000000L});
    public static final BitSet FOLLOW_104_in_colaElement3850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementContains_in_elementBody4090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaAttribute_in_elementBody4094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaAction_in_elementBody4098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inline_code_in_elementBody4102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_CONTAINS_in_elementContains4117 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_elementContains4121 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_elementContains4127 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_elementContains4129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaFacility4186 = new BitSet(new long[]{0x0000000040080000L,0x0000000400000000L});
    public static final BitSet FOLLOW_colaContractDefList_in_colaFacility4189 = new BitSet(new long[]{0x0000000040080000L});
    public static final BitSet FOLLOW_atVisibility_in_colaFacility4192 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_FACILITY_in_colaFacility4221 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaFacility4225 = new BitSet(new long[]{0x000000000000C000L,0x0000008000000000L});
    public static final BitSet FOLLOW_AT_EXTENDS_in_colaFacility4282 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaFacility4286 = new BitSet(new long[]{0x0000000000008000L,0x0000009000000000L});
    public static final BitSet FOLLOW_100_in_colaFacility4289 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaFacility4293 = new BitSet(new long[]{0x0000000000008000L,0x0000009000000000L});
    public static final BitSet FOLLOW_AT_REQUIRES_in_colaFacility4326 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaFacility4330 = new BitSet(new long[]{0x0000000000000000L,0x0000009000000000L});
    public static final BitSet FOLLOW_100_in_colaFacility4333 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_scoped_name_in_colaFacility4337 = new BitSet(new long[]{0x0000000000000000L,0x0000009000000000L});
    public static final BitSet FOLLOW_103_in_colaFacility4369 = new BitSet(new long[]{0x0000000000300000L,0x0000010400000000L});
    public static final BitSet FOLLOW_facilityBody_in_colaFacility4371 = new BitSet(new long[]{0x0000000000300000L,0x0000010400000000L});
    public static final BitSet FOLLOW_104_in_colaFacility4374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaAttribute_in_facilityBody4573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaAction_in_facilityBody4577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaAction4597 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ACTION_in_colaAction4600 = new BitSet(new long[]{0x03FFC00000000020L});
    public static final BitSet FOLLOW_simple_type_in_colaAction4603 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_void_type_in_colaAction4605 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaAction4610 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_colaAction4640 = new BitSet(new long[]{0x03FF800000000020L,0x0000000500000000L});
    public static final BitSet FOLLOW_colaParameter_in_colaAction4643 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_100_in_colaAction4645 = new BitSet(new long[]{0x03FF800000000020L,0x0000000400000000L});
    public static final BitSet FOLLOW_colaParameter_in_colaAction4647 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_96_in_colaAction4653 = new BitSet(new long[]{0x0000000000000000L,0x0000008200000000L});
    public static final BitSet FOLLOW_103_in_colaAction4682 = new BitSet(new long[]{0x00003208400E0210L,0x0000018400000000L});
    public static final BitSet FOLLOW_inline_code_in_colaAction4684 = new BitSet(new long[]{0x00003208400E0210L,0x0000018400000000L});
    public static final BitSet FOLLOW_104_in_colaAction4687 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaAction4691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaParameter4812 = new BitSet(new long[]{0x03FF800000000020L});
    public static final BitSet FOLLOW_simple_type_in_colaParameter4815 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaParameter4819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaTypeDef4881 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_TYPEDEF_in_colaTypeDef4910 = new BitSet(new long[]{0x03FF800000000020L});
    public static final BitSet FOLLOW_simple_type_in_colaTypeDef4912 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaTypeDef4916 = new BitSet(new long[]{0x0000000000000000L,0x0000008200000000L});
    public static final BitSet FOLLOW_103_in_colaTypeDef4947 = new BitSet(new long[]{0x00003208400E0210L,0x0000018400000000L});
    public static final BitSet FOLLOW_inline_code_in_colaTypeDef4949 = new BitSet(new long[]{0x00003208400E0210L,0x0000018400000000L});
    public static final BitSet FOLLOW_104_in_colaTypeDef4952 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaTypeDef4956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaAttribute5070 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_colaAttribute5073 = new BitSet(new long[]{0x03FF800000000020L});
    public static final BitSet FOLLOW_simple_type_in_colaAttribute5075 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaAttribute5079 = new BitSet(new long[]{0x0000000000000000L,0x0000008200000000L});
    public static final BitSet FOLLOW_103_in_colaAttribute5110 = new BitSet(new long[]{0x00003208400E0210L,0x0000018400000000L});
    public static final BitSet FOLLOW_inline_code_in_colaAttribute5112 = new BitSet(new long[]{0x00003208400E0210L,0x0000018400000000L});
    public static final BitSet FOLLOW_104_in_colaAttribute5115 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaAttribute5119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaStruct5236 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_STRUCT_in_colaStruct5239 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaStruct5243 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_colaStruct5273 = new BitSet(new long[]{0x03FFB208400E0230L,0x0000018400000000L});
    public static final BitSet FOLLOW_colaMember_in_colaStruct5276 = new BitSet(new long[]{0x03FFB208400E0230L,0x0000018400000000L});
    public static final BitSet FOLLOW_inline_code_in_colaStruct5280 = new BitSet(new long[]{0x03FFB208400E0230L,0x0000018400000000L});
    public static final BitSet FOLLOW_104_in_colaStruct5284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaMember5402 = new BitSet(new long[]{0x03FF800000000020L});
    public static final BitSet FOLLOW_simple_type_in_colaMember5405 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaMember5409 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_colaMember5411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name5477 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_scoped_name5480 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name5484 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_scoped_name5488 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name5494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_void_type5525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_name_in_simple_type5545 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_base_type_in_simple_type5549 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_array_in_simple_type5552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHORT_in_base_type5604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_base_type5610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_base_type5616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTET_in_base_type5622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_in_base_type5628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINARY_in_base_type5634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_base_type5640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_base_type5646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_base_type5652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_base_type5658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_base_type5664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_array5745 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_array5747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_INTEGER_in_const_value5773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_OCT_in_const_value5814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_HEX_in_const_value5859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_BINARY_in_const_value5904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_FLOAT_in_const_value5946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_CHAR_in_const_value5989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_value_in_const_value6033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_value_in_const_value6073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_string_value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_boolean_value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_inline_code6146 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_AT_LANGUAGE_in_inline_code6148 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_inline_code6150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_inline_code6152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_INLINE_CODE_in_inline_code6154 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_inline_code6156 = new BitSet(new long[]{0x0000000000000002L});

}