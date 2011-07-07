// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g 2011-07-07 22:24:44

  package org.skb.lang.cola.proto.grammars;

  import java.util.ArrayList;
  import java.util.LinkedHashMap;

  import org.skb.lang.cola.proto.ColaPass3_Gen;
  import org.skb.lang.cola.proto.ColaTokensConstants;
  import org.skb.util.ReportManager;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
public class colaGen extends TreeParser {
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


        public colaGen(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public colaGen(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected StringTemplateGroup templateLib =
      new StringTemplateGroup("colaGenTemplates", AngleBracketTemplateLexer.class);

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

    public String[] getTokenNames() { return colaGen.tokenNames; }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g"; }


      private ColaPass3_Gen pass;

      public void init() {
        this.pass=new ColaPass3_Gen();
      }


    public static class a3dsStage_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "a3dsStage"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:71:1: a3dsStage : ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' );
    public final colaGen.a3dsStage_return a3dsStage() throws RecognitionException {
        colaGen.a3dsStage_return retval = new colaGen.a3dsStage_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:71:25: ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:
            {
            if ( (input.LA(1)>=82 && input.LA(1)<=87) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "a3dsStage"

    public static class a3dsEnvironment_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "a3dsEnvironment"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:72:1: a3dsEnvironment : ( 'production' | 'test' | 'demonstrator' );
    public final colaGen.a3dsEnvironment_return a3dsEnvironment() throws RecognitionException {
        colaGen.a3dsEnvironment_return retval = new colaGen.a3dsEnvironment_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:72:25: ( 'production' | 'test' | 'demonstrator' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:
            {
            if ( (input.LA(1)>=88 && input.LA(1)<=90) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "a3dsEnvironment"

    public static class a3dsCLevel_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "a3dsCLevel"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:73:1: a3dsCLevel : ( 'business' | 'system' | 'element' );
    public final colaGen.a3dsCLevel_return a3dsCLevel() throws RecognitionException {
        colaGen.a3dsCLevel_return retval = new colaGen.a3dsCLevel_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:73:25: ( 'business' | 'system' | 'element' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:
            {
            if ( input.LA(1)==ELEMENT||(input.LA(1)>=91 && input.LA(1)<=92) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "a3dsCLevel"

    public static class colaFunction_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaFunction"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:75:1: colaFunction : ^( FUNCTION id= IDENT (par+= colaFunctionParam )* bt= base_type ( ARRAY )? ^( AT_LANGUAGE string_value ) ) -> colaFunction(id=$idparameter=$parret_type=$bt.textret_array=$ARRAY.text);
    public final colaGen.colaFunction_return colaFunction() throws RecognitionException {
        colaGen.colaFunction_return retval = new colaGen.colaFunction_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        CommonTree ARRAY1=null;
        List list_par=null;
        colaGen.base_type_return bt = null;

        RuleReturnScope par = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:75:25: ( ^( FUNCTION id= IDENT (par+= colaFunctionParam )* bt= base_type ( ARRAY )? ^( AT_LANGUAGE string_value ) ) -> colaFunction(id=$idparameter=$parret_type=$bt.textret_array=$ARRAY.text))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:75:27: ^( FUNCTION id= IDENT (par+= colaFunctionParam )* bt= base_type ( ARRAY )? ^( AT_LANGUAGE string_value ) )
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_colaFunction167); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaFunction171); 
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:75:50: (par+= colaFunctionParam )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PARAMETER) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:75:50: par+= colaFunctionParam
            	    {
            	    pushFollow(FOLLOW_colaFunctionParam_in_colaFunction175);
            	    par=colaFunctionParam();

            	    state._fsp--;

            	    if (list_par==null) list_par=new ArrayList();
            	    list_par.add(par.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            pushFollow(FOLLOW_base_type_in_colaFunction180);
            bt=base_type();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:75:84: ( ARRAY )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ARRAY) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:75:84: ARRAY
                    {
                    ARRAY1=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_colaFunction182); 

                    }
                    break;

            }

            match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_colaFunction186); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_string_value_in_colaFunction188);
            string_value();

            state._fsp--;


            match(input, Token.UP, null); 

            match(input, Token.UP, null); 
            this.pass.atoms.scope.push(id.token);


            // TEMPLATE REWRITE
            // 76:27: -> colaFunction(id=$idparameter=$parret_type=$bt.textret_array=$ARRAY.text)
            {
                retval.st = templateLib.getInstanceOf("colaFunction",
              new STAttrMap().put("id", id).put("parameter", list_par).put("ret_type", (bt!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(bt.start),
              input.getTreeAdaptor().getTokenStopIndex(bt.start))):null)).put("ret_array", (ARRAY1!=null?ARRAY1.getText():null)));
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
    // $ANTLR end "colaFunction"

    public static class colaFunctionParam_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaFunctionParam"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:77:1: colaFunctionParam : ^( PARAMETER bt= base_type ( ARRAY )? id= IDENT ) -> colaFunctionParam(type=$bt.textarray=$ARRAY.textid=$id);
    public final colaGen.colaFunctionParam_return colaFunctionParam() throws RecognitionException {
        colaGen.colaFunctionParam_return retval = new colaGen.colaFunctionParam_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        CommonTree ARRAY2=null;
        colaGen.base_type_return bt = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:77:25: ( ^( PARAMETER bt= base_type ( ARRAY )? id= IDENT ) -> colaFunctionParam(type=$bt.textarray=$ARRAY.textid=$id))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:77:27: ^( PARAMETER bt= base_type ( ARRAY )? id= IDENT )
            {
            match(input,PARAMETER,FOLLOW_PARAMETER_in_colaFunctionParam256); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_base_type_in_colaFunctionParam260);
            bt=base_type();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:77:52: ( ARRAY )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ARRAY) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:77:52: ARRAY
                    {
                    ARRAY2=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_colaFunctionParam262); 

                    }
                    break;

            }

            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaFunctionParam267); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 78:27: -> colaFunctionParam(type=$bt.textarray=$ARRAY.textid=$id)
            {
                retval.st = templateLib.getInstanceOf("colaFunctionParam",
              new STAttrMap().put("type", (bt!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(bt.start),
              input.getTreeAdaptor().getTokenStopIndex(bt.start))):null)).put("array", (ARRAY2!=null?ARRAY2.getText():null)).put("id", id));
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
    // $ANTLR end "colaFunctionParam"

    public static class colaPropertyDecl_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaPropertyDecl"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:80:1: colaPropertyDecl : ^( PROPERTY id= IDENT ^( AT_TYPE bt= base_type cv= const_value ( ARRAY )? ) ^( AT_SCOPE ( propertyScope )* ) ^( AT_APPLY ( ^( PRE (pre= scoped_name )* ) )? ( ^( POST (post= scoped_name )* ) )? ( ^( INV (inv= scoped_name )* ) )? ) ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_EXTENDS (ext+= scoped_name )* ) )? ( ^( AT_REQUIRES (req+= scoped_name )* ) )? ( ^( AT_PRIORITY pbt= base_type pcv= const_value ) )? ) -> colaPropertyDecl(id=$idtype=$bt.textval=$cv.starray=$ARRAY.textpropertyScope=this.pass.propertyScope()apply=applyaExtends=$extaRequires=$reqalterable=$AT_ALTERABLE.textnegotiable=$AT_NEGOTIABLE.textpriorityBT=$pbt.textpriorityCV=$pcv.stdescription=$atDescription.stmisc=this.pass.misc());
    public final colaGen.colaPropertyDecl_return colaPropertyDecl() throws RecognitionException {
        colaGen.colaPropertyDecl_return retval = new colaGen.colaPropertyDecl_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        CommonTree ARRAY3=null;
        CommonTree AT_ALTERABLE4=null;
        CommonTree AT_NEGOTIABLE5=null;
        List list_ext=null;
        List list_req=null;
        colaGen.base_type_return bt = null;

        colaGen.const_value_return cv = null;

        colaGen.scoped_name_return pre = null;

        colaGen.scoped_name_return post = null;

        colaGen.scoped_name_return inv = null;

        colaGen.base_type_return pbt = null;

        colaGen.const_value_return pcv = null;

        colaGen.atDescription_return atDescription6 = null;

        RuleReturnScope ext = null;
        RuleReturnScope req = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:80:25: ( ^( PROPERTY id= IDENT ^( AT_TYPE bt= base_type cv= const_value ( ARRAY )? ) ^( AT_SCOPE ( propertyScope )* ) ^( AT_APPLY ( ^( PRE (pre= scoped_name )* ) )? ( ^( POST (post= scoped_name )* ) )? ( ^( INV (inv= scoped_name )* ) )? ) ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_EXTENDS (ext+= scoped_name )* ) )? ( ^( AT_REQUIRES (req+= scoped_name )* ) )? ( ^( AT_PRIORITY pbt= base_type pcv= const_value ) )? ) -> colaPropertyDecl(id=$idtype=$bt.textval=$cv.starray=$ARRAY.textpropertyScope=this.pass.propertyScope()apply=applyaExtends=$extaRequires=$reqalterable=$AT_ALTERABLE.textnegotiable=$AT_NEGOTIABLE.textpriorityBT=$pbt.textpriorityCV=$pcv.stdescription=$atDescription.stmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:80:27: ^( PROPERTY id= IDENT ^( AT_TYPE bt= base_type cv= const_value ( ARRAY )? ) ^( AT_SCOPE ( propertyScope )* ) ^( AT_APPLY ( ^( PRE (pre= scoped_name )* ) )? ( ^( POST (post= scoped_name )* ) )? ( ^( INV (inv= scoped_name )* ) )? ) ( atVisibility )? ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_EXTENDS (ext+= scoped_name )* ) )? ( ^( AT_REQUIRES (req+= scoped_name )* ) )? ( ^( AT_PRIORITY pbt= base_type pcv= const_value ) )? )
            {
            match(input,PROPERTY,FOLLOW_PROPERTY_in_colaPropertyDecl329); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaPropertyDecl333); 
            match(input,AT_TYPE,FOLLOW_AT_TYPE_in_colaPropertyDecl336); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_base_type_in_colaPropertyDecl340);
            bt=base_type();

            state._fsp--;

            pushFollow(FOLLOW_const_value_in_colaPropertyDecl344);
            cv=const_value();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:80:85: ( ARRAY )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ARRAY) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:80:85: ARRAY
                    {
                    ARRAY3=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_colaPropertyDecl346); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            this.pass.atoms.scope.push(id.token);
            this.pass.clearPropertyScope();
            match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_colaPropertyDecl439); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:83:40: ( propertyScope )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==PARAMETER||(LA5_0>=PACKAGE && LA5_0<=ATTRIBUTE)) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:83:40: propertyScope
                	    {
                	    pushFollow(FOLLOW_propertyScope_in_colaPropertyDecl441);
                	    propertyScope();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop5;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }
            LinkedHashMap<String, ArrayList<String>> apply=new LinkedHashMap<String, ArrayList<String>>();
            match(input,AT_APPLY,FOLLOW_AT_APPLY_in_colaPropertyDecl504); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:85:40: ( ^( PRE (pre= scoped_name )* ) )?
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==PRE) ) {
                    alt7=1;
                }
                switch (alt7) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:85:41: ^( PRE (pre= scoped_name )* )
                        {
                        match(input,PRE,FOLLOW_PRE_in_colaPropertyDecl508); 

                        apply.put("pre",new ArrayList<String>());apply.get("pre").add("pre");
                        apply.put("preList",new ArrayList<String>());

                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:85:167: (pre= scoped_name )*
                            loop6:
                            do {
                                int alt6=2;
                                int LA6_0 = input.LA(1);

                                if ( (LA6_0==AT_SCOPE) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:85:168: pre= scoped_name
                            	    {
                            	    pushFollow(FOLLOW_scoped_name_in_colaPropertyDecl517);
                            	    pre=scoped_name();

                            	    state._fsp--;

                            	    apply.get("preList").add(this.pass.atoms.getST((pre!=null?(input.getTokenStream().toString(
                            	      input.getTreeAdaptor().getTokenStartIndex(pre.start),
                            	      input.getTreeAdaptor().getTokenStopIndex(pre.start))):null)).toString());

                            	    }
                            	    break;

                            	default :
                            	    break loop6;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:86:40: ( ^( POST (post= scoped_name )* ) )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==POST) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:86:41: ^( POST (post= scoped_name )* )
                        {
                        match(input,POST,FOLLOW_POST_in_colaPropertyDecl567); 

                        apply.put("post",new ArrayList<String>());apply.get("post").add("post");
                        apply.put("postList",new ArrayList<String>());

                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:86:172: (post= scoped_name )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==AT_SCOPE) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:86:173: post= scoped_name
                            	    {
                            	    pushFollow(FOLLOW_scoped_name_in_colaPropertyDecl576);
                            	    post=scoped_name();

                            	    state._fsp--;

                            	    apply.get("postList").add(this.pass.atoms.getST((post!=null?(input.getTokenStream().toString(
                            	      input.getTreeAdaptor().getTokenStartIndex(post.start),
                            	      input.getTreeAdaptor().getTokenStopIndex(post.start))):null)).toString());

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:87:40: ( ^( INV (inv= scoped_name )* ) )?
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==INV) ) {
                    alt11=1;
                }
                switch (alt11) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:87:41: ^( INV (inv= scoped_name )* )
                        {
                        match(input,INV,FOLLOW_INV_in_colaPropertyDecl626); 

                        apply.put("inv",new ArrayList<String>());apply.get("inv").add("inv");
                        apply.put("invList",new ArrayList<String>());

                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:87:167: (inv= scoped_name )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==AT_SCOPE) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:87:168: inv= scoped_name
                            	    {
                            	    pushFollow(FOLLOW_scoped_name_in_colaPropertyDecl635);
                            	    inv=scoped_name();

                            	    state._fsp--;

                            	    apply.get("invList").add(this.pass.atoms.getST((inv!=null?(input.getTokenStream().toString(
                            	      input.getTreeAdaptor().getTokenStartIndex(inv.start),
                            	      input.getTreeAdaptor().getTokenStopIndex(inv.start))):null)).toString());

                            	    }
                            	    break;

                            	default :
                            	    break loop10;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:88:29: ( atVisibility )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==AT_VISIBILITY) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:88:29: atVisibility
                    {
                    pushFollow(FOLLOW_atVisibility_in_colaPropertyDecl674);
                    atVisibility();

                    state._fsp--;


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:88:43: ( AT_ALTERABLE )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==AT_ALTERABLE) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:88:43: AT_ALTERABLE
                    {
                    AT_ALTERABLE4=(CommonTree)match(input,AT_ALTERABLE,FOLLOW_AT_ALTERABLE_in_colaPropertyDecl677); 

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:88:57: ( AT_NEGOTIABLE )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==AT_NEGOTIABLE) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:88:57: AT_NEGOTIABLE
                    {
                    AT_NEGOTIABLE5=(CommonTree)match(input,AT_NEGOTIABLE,FOLLOW_AT_NEGOTIABLE_in_colaPropertyDecl680); 

                    }
                    break;

            }

            pushFollow(FOLLOW_atDescription_in_colaPropertyDecl683);
            atDescription6=atDescription();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:89:29: ( ^( AT_EXTENDS (ext+= scoped_name )* ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==AT_EXTENDS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:89:30: ^( AT_EXTENDS (ext+= scoped_name )* )
                    {
                    match(input,AT_EXTENDS,FOLLOW_AT_EXTENDS_in_colaPropertyDecl715); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:89:43: (ext+= scoped_name )*
                        loop15:
                        do {
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==AT_SCOPE) ) {
                                alt15=1;
                            }


                            switch (alt15) {
                        	case 1 :
                        	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:89:44: ext+= scoped_name
                        	    {
                        	    pushFollow(FOLLOW_scoped_name_in_colaPropertyDecl720);
                        	    ext=scoped_name();

                        	    state._fsp--;

                        	    if (list_ext==null) list_ext=new ArrayList();
                        	    list_ext.add(ext.getTemplate());

                        	    this.pass.atoms.addImport(this.pass.sn.toString());

                        	    }
                        	    break;

                        	default :
                        	    break loop15;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:89:120: ( ^( AT_REQUIRES (req+= scoped_name )* ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==AT_REQUIRES) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:89:121: ^( AT_REQUIRES (req+= scoped_name )* )
                    {
                    match(input,AT_REQUIRES,FOLLOW_AT_REQUIRES_in_colaPropertyDecl731); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:89:135: (req+= scoped_name )*
                        loop17:
                        do {
                            int alt17=2;
                            int LA17_0 = input.LA(1);

                            if ( (LA17_0==AT_SCOPE) ) {
                                alt17=1;
                            }


                            switch (alt17) {
                        	case 1 :
                        	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:89:136: req+= scoped_name
                        	    {
                        	    pushFollow(FOLLOW_scoped_name_in_colaPropertyDecl736);
                        	    req=scoped_name();

                        	    state._fsp--;

                        	    if (list_req==null) list_req=new ArrayList();
                        	    list_req.add(req.getTemplate());

                        	    this.pass.atoms.addImport(this.pass.sn.toString());

                        	    }
                        	    break;

                        	default :
                        	    break loop17;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:90:29: ( ^( AT_PRIORITY pbt= base_type pcv= const_value ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AT_PRIORITY) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:90:30: ^( AT_PRIORITY pbt= base_type pcv= const_value )
                    {
                    match(input,AT_PRIORITY,FOLLOW_AT_PRIORITY_in_colaPropertyDecl775); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_base_type_in_colaPropertyDecl779);
                    pbt=base_type();

                    state._fsp--;

                    pushFollow(FOLLOW_const_value_in_colaPropertyDecl783);
                    pcv=const_value();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;

            }


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 92:27: -> colaPropertyDecl(id=$idtype=$bt.textval=$cv.starray=$ARRAY.textpropertyScope=this.pass.propertyScope()apply=applyaExtends=$extaRequires=$reqalterable=$AT_ALTERABLE.textnegotiable=$AT_NEGOTIABLE.textpriorityBT=$pbt.textpriorityCV=$pcv.stdescription=$atDescription.stmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaPropertyDecl",
              new STAttrMap().put("id", id).put("type", (bt!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(bt.start),
              input.getTreeAdaptor().getTokenStopIndex(bt.start))):null)).put("val", (cv!=null?cv.st:null)).put("array", (ARRAY3!=null?ARRAY3.getText():null)).put("propertyScope", this.pass.propertyScope()).put("apply", apply).put("aExtends", list_ext).put("aRequires", list_req).put("alterable", (AT_ALTERABLE4!=null?AT_ALTERABLE4.getText():null)).put("negotiable", (AT_NEGOTIABLE5!=null?AT_NEGOTIABLE5.getText():null)).put("priorityBT", (pbt!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(pbt.start),
              input.getTreeAdaptor().getTokenStopIndex(pbt.start))):null)).put("priorityCV", (pcv!=null?pcv.st:null)).put("description", (atDescription6!=null?atDescription6.st:null)).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaPropertyDecl"

    public static class propertyScope_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "propertyScope"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:100:1: propertyScope : ^(a= propertyScopeAtom r= propertyScopeRank ) ;
    public final colaGen.propertyScope_return propertyScope() throws RecognitionException {
        colaGen.propertyScope_return retval = new colaGen.propertyScope_return();
        retval.start = input.LT(1);

        colaGen.propertyScopeAtom_return a = null;

        colaGen.propertyScopeRank_return r = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:100:25: ( ^(a= propertyScopeAtom r= propertyScopeRank ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:100:27: ^(a= propertyScopeAtom r= propertyScopeRank )
            {
            pushFollow(FOLLOW_propertyScopeAtom_in_propertyScope1256);
            a=propertyScopeAtom();

            state._fsp--;


            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_propertyScopeRank_in_propertyScope1260);
            r=propertyScopeRank();

            state._fsp--;


            match(input, Token.UP, null); 
            this.pass.addPropertyScope((a!=null?a.st:null),(r!=null?r.st:null));

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
    // $ANTLR end "propertyScope"

    public static class propertyScopeAtom_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "propertyScopeAtom"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:103:1: propertyScopeAtom : (t= PACKAGE | t= ELEMENT | t= FACILITY | t= ACTION | t= ATTRIBUTE | t= PARAMETER ) -> template(token=$t) \"<token>\";
    public final colaGen.propertyScopeAtom_return propertyScopeAtom() throws RecognitionException {
        colaGen.propertyScopeAtom_return retval = new colaGen.propertyScopeAtom_return();
        retval.start = input.LT(1);

        CommonTree t=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:103:25: ( (t= PACKAGE | t= ELEMENT | t= FACILITY | t= ACTION | t= ATTRIBUTE | t= PARAMETER ) -> template(token=$t) \"<token>\")
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:103:27: (t= PACKAGE | t= ELEMENT | t= FACILITY | t= ACTION | t= ATTRIBUTE | t= PARAMETER )
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:103:27: (t= PACKAGE | t= ELEMENT | t= FACILITY | t= ACTION | t= ATTRIBUTE | t= PARAMETER )
            int alt20=6;
            switch ( input.LA(1) ) {
            case PACKAGE:
                {
                alt20=1;
                }
                break;
            case ELEMENT:
                {
                alt20=2;
                }
                break;
            case FACILITY:
                {
                alt20=3;
                }
                break;
            case ACTION:
                {
                alt20=4;
                }
                break;
            case ATTRIBUTE:
                {
                alt20=5;
                }
                break;
            case PARAMETER:
                {
                alt20=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:103:28: t= PACKAGE
                    {
                    t=(CommonTree)match(input,PACKAGE,FOLLOW_PACKAGE_in_propertyScopeAtom1306); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:103:40: t= ELEMENT
                    {
                    t=(CommonTree)match(input,ELEMENT,FOLLOW_ELEMENT_in_propertyScopeAtom1312); 

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:103:52: t= FACILITY
                    {
                    t=(CommonTree)match(input,FACILITY,FOLLOW_FACILITY_in_propertyScopeAtom1318); 

                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:103:65: t= ACTION
                    {
                    t=(CommonTree)match(input,ACTION,FOLLOW_ACTION_in_propertyScopeAtom1324); 

                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:103:76: t= ATTRIBUTE
                    {
                    t=(CommonTree)match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_propertyScopeAtom1330); 

                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:103:90: t= PARAMETER
                    {
                    t=(CommonTree)match(input,PARAMETER,FOLLOW_PARAMETER_in_propertyScopeAtom1336); 

                    }
                    break;

            }



            // TEMPLATE REWRITE
            // 103:103: -> template(token=$t) \"<token>\"
            {
                retval.st = new StringTemplate(templateLib, "<token>",
              new STAttrMap().put("token", t));
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
    // $ANTLR end "propertyScopeAtom"

    public static class propertyScopeRank_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "propertyScopeRank"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:104:1: propertyScopeRank : (t= REQUIRED | t= MANDATORY | t= OPTIONAL | t= NOT_DEF ) -> template(token=$t) \"<token>\";
    public final colaGen.propertyScopeRank_return propertyScopeRank() throws RecognitionException {
        colaGen.propertyScopeRank_return retval = new colaGen.propertyScopeRank_return();
        retval.start = input.LT(1);

        CommonTree t=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:104:25: ( (t= REQUIRED | t= MANDATORY | t= OPTIONAL | t= NOT_DEF ) -> template(token=$t) \"<token>\")
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:104:27: (t= REQUIRED | t= MANDATORY | t= OPTIONAL | t= NOT_DEF )
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:104:27: (t= REQUIRED | t= MANDATORY | t= OPTIONAL | t= NOT_DEF )
            int alt21=4;
            switch ( input.LA(1) ) {
            case REQUIRED:
                {
                alt21=1;
                }
                break;
            case MANDATORY:
                {
                alt21=2;
                }
                break;
            case OPTIONAL:
                {
                alt21=3;
                }
                break;
            case NOT_DEF:
                {
                alt21=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:104:28: t= REQUIRED
                    {
                    t=(CommonTree)match(input,REQUIRED,FOLLOW_REQUIRED_in_propertyScopeRank1364); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:104:41: t= MANDATORY
                    {
                    t=(CommonTree)match(input,MANDATORY,FOLLOW_MANDATORY_in_propertyScopeRank1370); 

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:104:55: t= OPTIONAL
                    {
                    t=(CommonTree)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_propertyScopeRank1376); 

                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:104:68: t= NOT_DEF
                    {
                    t=(CommonTree)match(input,NOT_DEF,FOLLOW_NOT_DEF_in_propertyScopeRank1382); 

                    }
                    break;

            }



            // TEMPLATE REWRITE
            // 104:79: -> template(token=$t) \"<token>\"
            {
                retval.st = new StringTemplate(templateLib, "<token>",
              new STAttrMap().put("token", t));
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
    // $ANTLR end "propertyScopeRank"

    public static class atVisibility_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "atVisibility"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:106:1: atVisibility : ^( AT_VISIBILITY ^( AT_SPEC atVisibilityData ) ^( AT_RUNTIME atVisibilityData ) ) ;
    public final colaGen.atVisibility_return atVisibility() throws RecognitionException {
        colaGen.atVisibility_return retval = new colaGen.atVisibility_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:106:25: ( ^( AT_VISIBILITY ^( AT_SPEC atVisibilityData ) ^( AT_RUNTIME atVisibilityData ) ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:106:27: ^( AT_VISIBILITY ^( AT_SPEC atVisibilityData ) ^( AT_RUNTIME atVisibilityData ) )
            {
            match(input,AT_VISIBILITY,FOLLOW_AT_VISIBILITY_in_atVisibility1414); 

            match(input, Token.DOWN, null); 
            match(input,AT_SPEC,FOLLOW_AT_SPEC_in_atVisibility1417); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_atVisibilityData_in_atVisibility1419);
            atVisibilityData();

            state._fsp--;


            match(input, Token.UP, null); 
            match(input,AT_RUNTIME,FOLLOW_AT_RUNTIME_in_atVisibility1423); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_atVisibilityData_in_atVisibility1425);
            atVisibilityData();

            state._fsp--;


            match(input, Token.UP, null); 

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
    // $ANTLR end "atVisibility"

    public static class atVisibilityData_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "atVisibilityData"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:107:1: atVisibilityData : '(' ( ( IDENT )? '-' string_value ( ',' string_value )* )? ';' ( COLA_TRUE )? ';' ( ( IDENT )? '+' string_value ( ',' string_value )* )? ')' ;
    public final colaGen.atVisibilityData_return atVisibilityData() throws RecognitionException {
        colaGen.atVisibilityData_return retval = new colaGen.atVisibilityData_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:107:25: ( '(' ( ( IDENT )? '-' string_value ( ',' string_value )* )? ';' ( COLA_TRUE )? ';' ( ( IDENT )? '+' string_value ( ',' string_value )* )? ')' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:107:27: '(' ( ( IDENT )? '-' string_value ( ',' string_value )* )? ';' ( COLA_TRUE )? ';' ( ( IDENT )? '+' string_value ( ',' string_value )* )? ')'
            {
            match(input,95,FOLLOW_95_in_atVisibilityData1441); 
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:108:27: ( ( IDENT )? '-' string_value ( ',' string_value )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==IDENT||LA24_0==101) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:108:28: ( IDENT )? '-' string_value ( ',' string_value )*
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:108:28: ( IDENT )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==IDENT) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:108:28: IDENT
                            {
                            match(input,IDENT,FOLLOW_IDENT_in_atVisibilityData1471); 

                            }
                            break;

                    }

                    match(input,101,FOLLOW_101_in_atVisibilityData1474); 
                    pushFollow(FOLLOW_string_value_in_atVisibilityData1476);
                    string_value();

                    state._fsp--;

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:108:52: ( ',' string_value )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==100) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:108:53: ',' string_value
                    	    {
                    	    match(input,100,FOLLOW_100_in_atVisibilityData1479); 
                    	    pushFollow(FOLLOW_string_value_in_atVisibilityData1481);
                    	    string_value();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,97,FOLLOW_97_in_atVisibilityData1487); 
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:109:27: ( COLA_TRUE )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==COLA_TRUE) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:109:27: COLA_TRUE
                    {
                    match(input,COLA_TRUE,FOLLOW_COLA_TRUE_in_atVisibilityData1515); 

                    }
                    break;

            }

            match(input,97,FOLLOW_97_in_atVisibilityData1518); 
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:110:27: ( ( IDENT )? '+' string_value ( ',' string_value )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==IDENT||LA28_0==102) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:110:28: ( IDENT )? '+' string_value ( ',' string_value )*
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:110:28: ( IDENT )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==IDENT) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:110:28: IDENT
                            {
                            match(input,IDENT,FOLLOW_IDENT_in_atVisibilityData1547); 

                            }
                            break;

                    }

                    match(input,102,FOLLOW_102_in_atVisibilityData1550); 
                    pushFollow(FOLLOW_string_value_in_atVisibilityData1552);
                    string_value();

                    state._fsp--;

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:110:52: ( ',' string_value )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==100) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:110:53: ',' string_value
                    	    {
                    	    match(input,100,FOLLOW_100_in_atVisibilityData1555); 
                    	    pushFollow(FOLLOW_string_value_in_atVisibilityData1557);
                    	    string_value();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,96,FOLLOW_96_in_atVisibilityData1589); 

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
    // $ANTLR end "atVisibilityData"

    public static class atDescription_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "atDescription"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:113:1: atDescription : ^( AT_DESCRIPTION string_value ) -> template(token=$string_value.text) \"<token>\";
    public final colaGen.atDescription_return atDescription() throws RecognitionException {
        colaGen.atDescription_return retval = new colaGen.atDescription_return();
        retval.start = input.LT(1);

        colaGen.string_value_return string_value7 = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:113:25: ( ^( AT_DESCRIPTION string_value ) -> template(token=$string_value.text) \"<token>\")
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:113:27: ^( AT_DESCRIPTION string_value )
            {
            match(input,AT_DESCRIPTION,FOLLOW_AT_DESCRIPTION_in_atDescription1608); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_string_value_in_atDescription1610);
            string_value7=string_value();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 113:57: -> template(token=$string_value.text) \"<token>\"
            {
                retval.st = new StringTemplate(templateLib, "<token>",
              new STAttrMap().put("token", (string_value7!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(string_value7.start),
              input.getTreeAdaptor().getTokenStopIndex(string_value7.start))):null)));
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
    // $ANTLR end "atDescription"

    public static class colaPropertyDefList_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaPropertyDefList"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:115:1: colaPropertyDefList : (lpd+= colaPropertyDef )* -> colaPropertyDefList(property=$lpd);
    public final colaGen.colaPropertyDefList_return colaPropertyDefList() throws RecognitionException {
        colaGen.colaPropertyDefList_return retval = new colaGen.colaPropertyDefList_return();
        retval.start = input.LT(1);

        List list_lpd=null;
        RuleReturnScope lpd = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:115:25: ( (lpd+= colaPropertyDef )* -> colaPropertyDefList(property=$lpd))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:115:27: (lpd+= colaPropertyDef )*
            {
            this.pass.clearPropDefList();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:115:59: (lpd+= colaPropertyDef )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==PROPERTY) ) {
                    int LA29_2 = input.LA(2);

                    if ( (LA29_2==DOWN) ) {
                        int LA29_3 = input.LA(3);

                        if ( (LA29_3==IDENT) ) {
                            int LA29_4 = input.LA(4);

                            if ( (LA29_4==AT_SCOPE) ) {
                                alt29=1;
                            }


                        }


                    }


                }


                switch (alt29) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:115:60: lpd+= colaPropertyDef
            	    {
            	    pushFollow(FOLLOW_colaPropertyDef_in_colaPropertyDefList1638);
            	    lpd=colaPropertyDef();

            	    state._fsp--;

            	    if (list_lpd==null) list_lpd=new ArrayList();
            	    list_lpd.add(lpd.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);



            // TEMPLATE REWRITE
            // 116:27: -> colaPropertyDefList(property=$lpd)
            {
                retval.st = templateLib.getInstanceOf("colaPropertyDefList",
              new STAttrMap().put("property", list_lpd));
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
    // $ANTLR end "colaPropertyDefList"

    public static class colaPropertyDef_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaPropertyDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:117:1: colaPropertyDef : ^( PROPERTY id= IDENT sn= scoped_name (cv+= const_value )* ) -> colaPropertyDef(sn=$sn.textarray=this.pass.propertyDefIsArray($cv)id=$id.texttype=this.pass.getPropDefBaseType(this.pass.sn.toString())val=$cvmisc=this.pass.misc());
    public final colaGen.colaPropertyDef_return colaPropertyDef() throws RecognitionException {
        colaGen.colaPropertyDef_return retval = new colaGen.colaPropertyDef_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_cv=null;
        colaGen.scoped_name_return sn = null;

        RuleReturnScope cv = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:117:25: ( ^( PROPERTY id= IDENT sn= scoped_name (cv+= const_value )* ) -> colaPropertyDef(sn=$sn.textarray=this.pass.propertyDefIsArray($cv)id=$id.texttype=this.pass.getPropDefBaseType(this.pass.sn.toString())val=$cvmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:117:27: ^( PROPERTY id= IDENT sn= scoped_name (cv+= const_value )* )
            {
            match(input,PROPERTY,FOLLOW_PROPERTY_in_colaPropertyDef1691); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaPropertyDef1695); 
            pushFollow(FOLLOW_scoped_name_in_colaPropertyDef1699);
            sn=scoped_name();

            state._fsp--;

            this.pass.atoms.addImport(this.pass.sn.toString());
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:117:116: (cv+= const_value )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==AT_PROVIDES) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:117:117: cv+= const_value
            	    {
            	    pushFollow(FOLLOW_const_value_in_colaPropertyDef1706);
            	    cv=const_value();

            	    state._fsp--;

            	    if (list_cv==null) list_cv=new ArrayList();
            	    list_cv.add(cv.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            match(input, Token.UP, null); 
            this.pass.addPropDefList((id!=null?id.getText():null));


            // TEMPLATE REWRITE
            // 119:27: -> colaPropertyDef(sn=$sn.textarray=this.pass.propertyDefIsArray($cv)id=$id.texttype=this.pass.getPropDefBaseType(this.pass.sn.toString())val=$cvmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaPropertyDef",
              new STAttrMap().put("sn", (sn!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(sn.start),
              input.getTreeAdaptor().getTokenStopIndex(sn.start))):null)).put("array", this.pass.propertyDefIsArray(list_cv)).put("id", (id!=null?id.getText():null)).put("type", this.pass.getPropDefBaseType(this.pass.sn.toString())).put("val", list_cv).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaPropertyDef"

    public static class colaContractDecl_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaContractDecl"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:121:1: colaContractDecl : ^( CONTRACT id= IDENT ^( AT_SCOPE ( contractScope )* ) ( atVisibility )? atDescription (items+= contractItem )+ ) -> colaContractDecl(id=$idcontractScope=this.pass.propertyScope()description=$atDescription.stitems=$itemsmisc=this.pass.misc());
    public final colaGen.colaContractDecl_return colaContractDecl() throws RecognitionException {
        colaGen.colaContractDecl_return retval = new colaGen.colaContractDecl_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_items=null;
        colaGen.atDescription_return atDescription8 = null;

        RuleReturnScope items = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:121:25: ( ^( CONTRACT id= IDENT ^( AT_SCOPE ( contractScope )* ) ( atVisibility )? atDescription (items+= contractItem )+ ) -> colaContractDecl(id=$idcontractScope=this.pass.propertyScope()description=$atDescription.stitems=$itemsmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:121:27: ^( CONTRACT id= IDENT ^( AT_SCOPE ( contractScope )* ) ( atVisibility )? atDescription (items+= contractItem )+ )
            {
            match(input,CONTRACT,FOLLOW_CONTRACT_in_colaContractDecl1813); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaContractDecl1817); 
            this.pass.atoms.scope.push(id.token);
            this.pass.clearPropertyScope();
            match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_colaContractDecl1908); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:124:40: ( contractScope )*
                loop31:
                do {
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0>=ELEMENT && LA31_0<=FACILITY)) ) {
                        alt31=1;
                    }


                    switch (alt31) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:124:40: contractScope
                	    {
                	    pushFollow(FOLLOW_contractScope_in_colaContractDecl1910);
                	    contractScope();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop31;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:124:56: ( atVisibility )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==AT_VISIBILITY) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:124:56: atVisibility
                    {
                    pushFollow(FOLLOW_atVisibility_in_colaContractDecl1914);
                    atVisibility();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_atDescription_in_colaContractDecl1917);
            atDescription8=atDescription();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:125:29: (items+= contractItem )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==ITEM) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:125:30: items+= contractItem
            	    {
            	    pushFollow(FOLLOW_contractItem_in_colaContractDecl1950);
            	    items=contractItem();

            	    state._fsp--;

            	    if (list_items==null) list_items=new ArrayList();
            	    list_items.add(items.getTemplate());

            	    this.pass.atoms.scope.pop();

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


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 127:27: -> colaContractDecl(id=$idcontractScope=this.pass.propertyScope()description=$atDescription.stitems=$itemsmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaContractDecl",
              new STAttrMap().put("id", id).put("contractScope", this.pass.propertyScope()).put("description", (atDescription8!=null?atDescription8.st:null)).put("items", list_items).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaContractDecl"

    public static class contractScope_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "contractScope"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:128:1: contractScope : a= contractScopeAtom r= contractScopeRank ;
    public final colaGen.contractScope_return contractScope() throws RecognitionException {
        colaGen.contractScope_return retval = new colaGen.contractScope_return();
        retval.start = input.LT(1);

        colaGen.contractScopeAtom_return a = null;

        colaGen.contractScopeRank_return r = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:128:25: (a= contractScopeAtom r= contractScopeRank )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:128:27: a= contractScopeAtom r= contractScopeRank
            {
            pushFollow(FOLLOW_contractScopeAtom_in_contractScope2056);
            a=contractScopeAtom();

            state._fsp--;

            pushFollow(FOLLOW_contractScopeRank_in_contractScope2060);
            r=contractScopeRank();

            state._fsp--;

            this.pass.addPropertyScope((a!=null?a.st:null),(r!=null?r.st:null));

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
    // $ANTLR end "contractScope"

    public static class contractScopeAtom_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "contractScopeAtom"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:130:1: contractScopeAtom : (t= ELEMENT | t= FACILITY ) -> template(token=$t) \"<token>\";
    public final colaGen.contractScopeAtom_return contractScopeAtom() throws RecognitionException {
        colaGen.contractScopeAtom_return retval = new colaGen.contractScopeAtom_return();
        retval.start = input.LT(1);

        CommonTree t=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:130:25: ( (t= ELEMENT | t= FACILITY ) -> template(token=$t) \"<token>\")
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:130:27: (t= ELEMENT | t= FACILITY )
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:130:27: (t= ELEMENT | t= FACILITY )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==ELEMENT) ) {
                alt34=1;
            }
            else if ( (LA34_0==FACILITY) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:130:28: t= ELEMENT
                    {
                    t=(CommonTree)match(input,ELEMENT,FOLLOW_ELEMENT_in_contractScopeAtom2104); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:130:40: t= FACILITY
                    {
                    t=(CommonTree)match(input,FACILITY,FOLLOW_FACILITY_in_contractScopeAtom2110); 

                    }
                    break;

            }



            // TEMPLATE REWRITE
            // 130:52: -> template(token=$t) \"<token>\"
            {
                retval.st = new StringTemplate(templateLib, "<token>",
              new STAttrMap().put("token", t));
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
    // $ANTLR end "contractScopeAtom"

    public static class contractScopeRank_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "contractScopeRank"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:131:1: contractScopeRank : (t= REQUIRED | t= MANDATORY | t= OPTIONAL | t= NOT_DEF ) -> template(token=$t) \"<token>\";
    public final colaGen.contractScopeRank_return contractScopeRank() throws RecognitionException {
        colaGen.contractScopeRank_return retval = new colaGen.contractScopeRank_return();
        retval.start = input.LT(1);

        CommonTree t=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:131:25: ( (t= REQUIRED | t= MANDATORY | t= OPTIONAL | t= NOT_DEF ) -> template(token=$t) \"<token>\")
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:131:27: (t= REQUIRED | t= MANDATORY | t= OPTIONAL | t= NOT_DEF )
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:131:27: (t= REQUIRED | t= MANDATORY | t= OPTIONAL | t= NOT_DEF )
            int alt35=4;
            switch ( input.LA(1) ) {
            case REQUIRED:
                {
                alt35=1;
                }
                break;
            case MANDATORY:
                {
                alt35=2;
                }
                break;
            case OPTIONAL:
                {
                alt35=3;
                }
                break;
            case NOT_DEF:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:131:28: t= REQUIRED
                    {
                    t=(CommonTree)match(input,REQUIRED,FOLLOW_REQUIRED_in_contractScopeRank2138); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:131:41: t= MANDATORY
                    {
                    t=(CommonTree)match(input,MANDATORY,FOLLOW_MANDATORY_in_contractScopeRank2144); 

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:131:55: t= OPTIONAL
                    {
                    t=(CommonTree)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_contractScopeRank2150); 

                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:131:68: t= NOT_DEF
                    {
                    t=(CommonTree)match(input,NOT_DEF,FOLLOW_NOT_DEF_in_contractScopeRank2156); 

                    }
                    break;

            }



            // TEMPLATE REWRITE
            // 131:79: -> template(token=$t) \"<token>\"
            {
                retval.st = new StringTemplate(templateLib, "<token>",
              new STAttrMap().put("token", t));
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
    // $ANTLR end "contractScopeRank"

    public static class contractItem_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "contractItem"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:133:1: contractItem : ^( ITEM id= IDENT (single+= contractItemProp )+ ) -> contractItem(id=$idproperty=$singlemisc=this.pass.misc());
    public final colaGen.contractItem_return contractItem() throws RecognitionException {
        colaGen.contractItem_return retval = new colaGen.contractItem_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_single=null;
        RuleReturnScope single = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:133:25: ( ^( ITEM id= IDENT (single+= contractItemProp )+ ) -> contractItem(id=$idproperty=$singlemisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:133:27: ^( ITEM id= IDENT (single+= contractItemProp )+ )
            {
            match(input,ITEM,FOLLOW_ITEM_in_contractItem2188); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_contractItem2192); 
            this.pass.atoms.scope.push(id.token);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:135:28: (single+= contractItemProp )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==PROPERTY) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:135:29: single+= contractItemProp
            	    {
            	    pushFollow(FOLLOW_contractItemProp_in_contractItem2253);
            	    single=contractItemProp();

            	    state._fsp--;

            	    if (list_single==null) list_single=new ArrayList();
            	    list_single.add(single.getTemplate());

            	    this.pass.atoms.scope.pop();

            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 136:27: -> contractItem(id=$idproperty=$singlemisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("contractItem",
              new STAttrMap().put("id", id).put("property", list_single).put("misc", this.pass.misc()));
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
    // $ANTLR end "contractItem"

    public static class contractItemProp_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "contractItemProp"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:137:1: contractItemProp : ^( PROPERTY id= IDENT ^( AT_TYPE bt= base_type cv= const_value ( ARRAY )? ) ipr= contractItemPropRank ^( AT_APPLY ( ^( PRE (pre= scoped_name )* ) )? ( ^( POST (post= scoped_name )* ) )? ( ^( INV (inv= scoped_name )* ) )? ) ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_PRIORITY pbt= base_type pcv= const_value ) )? ) -> contractItemProp(id=$idtype=$bt.textval=$cv.starray=$ARRAY.textrank=$ipr.textapply=applyalterable=$AT_ALTERABLE.textnegotiable=$AT_NEGOTIABLE.textdescription=$atDescription.stpriorityBT=$pbt.textpriorityCV=$pcv.stmisc=this.pass.misc());
    public final colaGen.contractItemProp_return contractItemProp() throws RecognitionException {
        colaGen.contractItemProp_return retval = new colaGen.contractItemProp_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        CommonTree ARRAY9=null;
        CommonTree AT_ALTERABLE10=null;
        CommonTree AT_NEGOTIABLE11=null;
        colaGen.base_type_return bt = null;

        colaGen.const_value_return cv = null;

        colaGen.contractItemPropRank_return ipr = null;

        colaGen.scoped_name_return pre = null;

        colaGen.scoped_name_return post = null;

        colaGen.scoped_name_return inv = null;

        colaGen.base_type_return pbt = null;

        colaGen.const_value_return pcv = null;

        colaGen.atDescription_return atDescription12 = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:137:25: ( ^( PROPERTY id= IDENT ^( AT_TYPE bt= base_type cv= const_value ( ARRAY )? ) ipr= contractItemPropRank ^( AT_APPLY ( ^( PRE (pre= scoped_name )* ) )? ( ^( POST (post= scoped_name )* ) )? ( ^( INV (inv= scoped_name )* ) )? ) ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_PRIORITY pbt= base_type pcv= const_value ) )? ) -> contractItemProp(id=$idtype=$bt.textval=$cv.starray=$ARRAY.textrank=$ipr.textapply=applyalterable=$AT_ALTERABLE.textnegotiable=$AT_NEGOTIABLE.textdescription=$atDescription.stpriorityBT=$pbt.textpriorityCV=$pcv.stmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:137:27: ^( PROPERTY id= IDENT ^( AT_TYPE bt= base_type cv= const_value ( ARRAY )? ) ipr= contractItemPropRank ^( AT_APPLY ( ^( PRE (pre= scoped_name )* ) )? ( ^( POST (post= scoped_name )* ) )? ( ^( INV (inv= scoped_name )* ) )? ) ( AT_ALTERABLE )? ( AT_NEGOTIABLE )? atDescription ( ^( AT_PRIORITY pbt= base_type pcv= const_value ) )? )
            {
            match(input,PROPERTY,FOLLOW_PROPERTY_in_contractItemProp2318); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_contractItemProp2322); 
            this.pass.atoms.scope.push(id.token);
            match(input,AT_TYPE,FOLLOW_AT_TYPE_in_contractItemProp2383); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_base_type_in_contractItemProp2387);
            bt=base_type();

            state._fsp--;

            pushFollow(FOLLOW_const_value_in_contractItemProp2391);
            cv=const_value();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:139:67: ( ARRAY )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==ARRAY) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:139:67: ARRAY
                    {
                    ARRAY9=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_contractItemProp2393); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            pushFollow(FOLLOW_contractItemPropRank_in_contractItemProp2428);
            ipr=contractItemPropRank();

            state._fsp--;

            LinkedHashMap<String, ArrayList<String>> apply=new LinkedHashMap<String, ArrayList<String>>();
            match(input,AT_APPLY,FOLLOW_AT_APPLY_in_contractItemProp2489); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:142:40: ( ^( PRE (pre= scoped_name )* ) )?
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==PRE) ) {
                    alt39=1;
                }
                switch (alt39) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:142:41: ^( PRE (pre= scoped_name )* )
                        {
                        match(input,PRE,FOLLOW_PRE_in_contractItemProp2493); 

                        apply.put("pre",new ArrayList<String>());apply.get("pre").add("pre");
                        apply.put("preList",new ArrayList<String>());

                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:142:167: (pre= scoped_name )*
                            loop38:
                            do {
                                int alt38=2;
                                int LA38_0 = input.LA(1);

                                if ( (LA38_0==AT_SCOPE) ) {
                                    alt38=1;
                                }


                                switch (alt38) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:142:168: pre= scoped_name
                            	    {
                            	    pushFollow(FOLLOW_scoped_name_in_contractItemProp2502);
                            	    pre=scoped_name();

                            	    state._fsp--;

                            	    apply.get("preList").add(this.pass.atoms.getST((pre!=null?(input.getTokenStream().toString(
                            	      input.getTreeAdaptor().getTokenStartIndex(pre.start),
                            	      input.getTreeAdaptor().getTokenStopIndex(pre.start))):null)).toString());

                            	    }
                            	    break;

                            	default :
                            	    break loop38;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:143:40: ( ^( POST (post= scoped_name )* ) )?
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==POST) ) {
                    alt41=1;
                }
                switch (alt41) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:143:41: ^( POST (post= scoped_name )* )
                        {
                        match(input,POST,FOLLOW_POST_in_contractItemProp2552); 

                        apply.put("post",new ArrayList<String>());apply.get("post").add("post");
                        apply.put("postList",new ArrayList<String>());

                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:143:172: (post= scoped_name )*
                            loop40:
                            do {
                                int alt40=2;
                                int LA40_0 = input.LA(1);

                                if ( (LA40_0==AT_SCOPE) ) {
                                    alt40=1;
                                }


                                switch (alt40) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:143:173: post= scoped_name
                            	    {
                            	    pushFollow(FOLLOW_scoped_name_in_contractItemProp2561);
                            	    post=scoped_name();

                            	    state._fsp--;

                            	    apply.get("postList").add(this.pass.atoms.getST((post!=null?(input.getTokenStream().toString(
                            	      input.getTreeAdaptor().getTokenStartIndex(post.start),
                            	      input.getTreeAdaptor().getTokenStopIndex(post.start))):null)).toString());

                            	    }
                            	    break;

                            	default :
                            	    break loop40;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }

                        }
                        break;

                }

                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:144:40: ( ^( INV (inv= scoped_name )* ) )?
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==INV) ) {
                    alt43=1;
                }
                switch (alt43) {
                    case 1 :
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:144:41: ^( INV (inv= scoped_name )* )
                        {
                        match(input,INV,FOLLOW_INV_in_contractItemProp2611); 

                        apply.put("inv",new ArrayList<String>());apply.get("inv").add("inv");
                        apply.put("invList",new ArrayList<String>());

                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:144:167: (inv= scoped_name )*
                            loop42:
                            do {
                                int alt42=2;
                                int LA42_0 = input.LA(1);

                                if ( (LA42_0==AT_SCOPE) ) {
                                    alt42=1;
                                }


                                switch (alt42) {
                            	case 1 :
                            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:144:168: inv= scoped_name
                            	    {
                            	    pushFollow(FOLLOW_scoped_name_in_contractItemProp2620);
                            	    inv=scoped_name();

                            	    state._fsp--;

                            	    apply.get("invList").add(this.pass.atoms.getST((inv!=null?(input.getTokenStream().toString(
                            	      input.getTreeAdaptor().getTokenStartIndex(inv.start),
                            	      input.getTreeAdaptor().getTokenStopIndex(inv.start))):null)).toString());

                            	    }
                            	    break;

                            	default :
                            	    break loop42;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:145:30: ( AT_ALTERABLE )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==AT_ALTERABLE) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:145:30: AT_ALTERABLE
                    {
                    AT_ALTERABLE10=(CommonTree)match(input,AT_ALTERABLE,FOLLOW_AT_ALTERABLE_in_contractItemProp2660); 

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:145:44: ( AT_NEGOTIABLE )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==AT_NEGOTIABLE) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:145:44: AT_NEGOTIABLE
                    {
                    AT_NEGOTIABLE11=(CommonTree)match(input,AT_NEGOTIABLE,FOLLOW_AT_NEGOTIABLE_in_contractItemProp2663); 

                    }
                    break;

            }

            pushFollow(FOLLOW_atDescription_in_contractItemProp2666);
            atDescription12=atDescription();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:146:29: ( ^( AT_PRIORITY pbt= base_type pcv= const_value ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==AT_PRIORITY) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:146:30: ^( AT_PRIORITY pbt= base_type pcv= const_value )
                    {
                    match(input,AT_PRIORITY,FOLLOW_AT_PRIORITY_in_contractItemProp2698); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_base_type_in_contractItemProp2702);
                    pbt=base_type();

                    state._fsp--;

                    pushFollow(FOLLOW_const_value_in_contractItemProp2706);
                    pcv=const_value();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;

            }


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 147:27: -> contractItemProp(id=$idtype=$bt.textval=$cv.starray=$ARRAY.textrank=$ipr.textapply=applyalterable=$AT_ALTERABLE.textnegotiable=$AT_NEGOTIABLE.textdescription=$atDescription.stpriorityBT=$pbt.textpriorityCV=$pcv.stmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("contractItemProp",
              new STAttrMap().put("id", id).put("type", (bt!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(bt.start),
              input.getTreeAdaptor().getTokenStopIndex(bt.start))):null)).put("val", (cv!=null?cv.st:null)).put("array", (ARRAY9!=null?ARRAY9.getText():null)).put("rank", (ipr!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(ipr.start),
              input.getTreeAdaptor().getTokenStopIndex(ipr.start))):null)).put("apply", apply).put("alterable", (AT_ALTERABLE10!=null?AT_ALTERABLE10.getText():null)).put("negotiable", (AT_NEGOTIABLE11!=null?AT_NEGOTIABLE11.getText():null)).put("description", (atDescription12!=null?atDescription12.st:null)).put("priorityBT", (pbt!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(pbt.start),
              input.getTreeAdaptor().getTokenStopIndex(pbt.start))):null)).put("priorityCV", (pcv!=null?pcv.st:null)).put("misc", this.pass.misc()));
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
    // $ANTLR end "contractItemProp"

    public static class contractItemPropRank_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "contractItemPropRank"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:152:1: contractItemPropRank : (s= REQUIRED | s= MANDATORY | s= OPTIONAL ) ;
    public final colaGen.contractItemPropRank_return contractItemPropRank() throws RecognitionException {
        colaGen.contractItemPropRank_return retval = new colaGen.contractItemPropRank_return();
        retval.start = input.LT(1);

        CommonTree s=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:152:25: ( (s= REQUIRED | s= MANDATORY | s= OPTIONAL ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:152:27: (s= REQUIRED | s= MANDATORY | s= OPTIONAL )
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:152:27: (s= REQUIRED | s= MANDATORY | s= OPTIONAL )
            int alt47=3;
            switch ( input.LA(1) ) {
            case REQUIRED:
                {
                alt47=1;
                }
                break;
            case MANDATORY:
                {
                alt47=2;
                }
                break;
            case OPTIONAL:
                {
                alt47=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:152:28: s= REQUIRED
                    {
                    s=(CommonTree)match(input,REQUIRED,FOLLOW_REQUIRED_in_contractItemPropRank2936); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:152:41: s= MANDATORY
                    {
                    s=(CommonTree)match(input,MANDATORY,FOLLOW_MANDATORY_in_contractItemPropRank2942); 

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:152:55: s= OPTIONAL
                    {
                    s=(CommonTree)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_contractItemPropRank2948); 

                    }
                    break;

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
    // $ANTLR end "contractItemPropRank"

    public static class colaContractDefList_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaContractDefList"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:154:1: colaContractDefList : (lcd+= colaContractDef )* -> colaContractDefList(contract=$lcdmisc=this.pass.misc());
    public final colaGen.colaContractDefList_return colaContractDefList() throws RecognitionException {
        colaGen.colaContractDefList_return retval = new colaGen.colaContractDefList_return();
        retval.start = input.LT(1);

        List list_lcd=null;
        RuleReturnScope lcd = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:154:25: ( (lcd+= colaContractDef )* -> colaContractDefList(contract=$lcdmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:154:27: (lcd+= colaContractDef )*
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:154:27: (lcd+= colaContractDef )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==CONTRACT) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:154:28: lcd+= colaContractDef
            	    {
            	    pushFollow(FOLLOW_colaContractDef_in_colaContractDefList2964);
            	    lcd=colaContractDef();

            	    state._fsp--;

            	    if (list_lcd==null) list_lcd=new ArrayList();
            	    list_lcd.add(lcd.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);



            // TEMPLATE REWRITE
            // 155:27: -> colaContractDefList(contract=$lcdmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaContractDefList",
              new STAttrMap().put("contract", list_lcd).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaContractDefList"

    public static class colaContractDef_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaContractDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:156:1: colaContractDef : ^( CONTRACT id= IDENT scoped_name (items+= colaContractItemDef )* ) -> colaContractDef(id=$id.textscoped_name=$scoped_name.stitems=$itemsmisc=this.pass.misc());
    public final colaGen.colaContractDef_return colaContractDef() throws RecognitionException {
        colaGen.colaContractDef_return retval = new colaGen.colaContractDef_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_items=null;
        colaGen.scoped_name_return scoped_name13 = null;

        RuleReturnScope items = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:156:25: ( ^( CONTRACT id= IDENT scoped_name (items+= colaContractItemDef )* ) -> colaContractDef(id=$id.textscoped_name=$scoped_name.stitems=$itemsmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:156:27: ^( CONTRACT id= IDENT scoped_name (items+= colaContractItemDef )* )
            {
            match(input,CONTRACT,FOLLOW_CONTRACT_in_colaContractDef3022); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaContractDef3026); 
            pushFollow(FOLLOW_scoped_name_in_colaContractDef3028);
            scoped_name13=scoped_name();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:156:64: (items+= colaContractItemDef )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==IDENT) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:156:64: items+= colaContractItemDef
            	    {
            	    pushFollow(FOLLOW_colaContractItemDef_in_colaContractDef3032);
            	    items=colaContractItemDef();

            	    state._fsp--;

            	    if (list_items==null) list_items=new ArrayList();
            	    list_items.add(items.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 157:27: -> colaContractDef(id=$id.textscoped_name=$scoped_name.stitems=$itemsmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaContractDef",
              new STAttrMap().put("id", (id!=null?id.getText():null)).put("scoped_name", (scoped_name13!=null?scoped_name13.st:null)).put("items", list_items).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaContractDef"

    public static class colaContractItemDef_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaContractItemDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:158:1: colaContractItemDef : id= IDENT (def+= colaItemDef )* -> colaContractItemDef(id=$id.textproperties=$defmisc=this.pass.misc());
    public final colaGen.colaContractItemDef_return colaContractItemDef() throws RecognitionException {
        colaGen.colaContractItemDef_return retval = new colaGen.colaContractItemDef_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_def=null;
        RuleReturnScope def = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:158:25: (id= IDENT (def+= colaItemDef )* -> colaContractItemDef(id=$id.textproperties=$defmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:158:27: id= IDENT (def+= colaItemDef )*
            {
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaContractItemDef3097); 
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:158:39: (def+= colaItemDef )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==IDENT) ) {
                    int LA50_2 = input.LA(2);

                    if ( (LA50_2==DOWN) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:158:39: def+= colaItemDef
            	    {
            	    pushFollow(FOLLOW_colaItemDef_in_colaContractItemDef3101);
            	    def=colaItemDef();

            	    state._fsp--;

            	    if (list_def==null) list_def=new ArrayList();
            	    list_def.add(def.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);



            // TEMPLATE REWRITE
            // 159:27: -> colaContractItemDef(id=$id.textproperties=$defmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaContractItemDef",
              new STAttrMap().put("id", (id!=null?id.getText():null)).put("properties", list_def).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaContractItemDef"

    public static class colaItemDef_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaItemDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:160:1: colaItemDef : ^( IDENT id= IDENT (val+= const_value )* ) -> colaItemDef(id=$id.textval=$valmisc=this.pass.misc());
    public final colaGen.colaItemDef_return colaItemDef() throws RecognitionException {
        colaGen.colaItemDef_return retval = new colaGen.colaItemDef_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_val=null;
        RuleReturnScope val = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:160:25: ( ^( IDENT id= IDENT (val+= const_value )* ) -> colaItemDef(id=$id.textval=$valmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:160:27: ^( IDENT id= IDENT (val+= const_value )* )
            {
            match(input,IDENT,FOLLOW_IDENT_in_colaItemDef3167); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaItemDef3171); 
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:160:47: (val+= const_value )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==AT_PROVIDES) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:160:47: val+= const_value
            	    {
            	    pushFollow(FOLLOW_const_value_in_colaItemDef3175);
            	    val=const_value();

            	    state._fsp--;

            	    if (list_val==null) list_val=new ArrayList();
            	    list_val.add(val.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 161:27: -> colaItemDef(id=$id.textval=$valmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaItemDef",
              new STAttrMap().put("id", (id!=null?id.getText():null)).put("val", list_val).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaItemDef"

    public static class colaSpecification_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaSpecification"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:163:1: colaSpecification : ^( AT_SPEC stage= a3dsStage env= a3dsEnvironment clevel= a3dsCLevel ^( AT_LANGUAGE lang= IDENT ) ^( AT_SPEC s= IDENT ) cpp_directive (def+= colaDefinition )* ) -> template(specification=spectoken=$def) \"<specification>\\n\\n<token>\";
    public final colaGen.colaSpecification_return colaSpecification() throws RecognitionException {
        colaGen.colaSpecification_return retval = new colaGen.colaSpecification_return();
        retval.start = input.LT(1);

        CommonTree lang=null;
        CommonTree s=null;
        List list_def=null;
        colaGen.a3dsStage_return stage = null;

        colaGen.a3dsEnvironment_return env = null;

        colaGen.a3dsCLevel_return clevel = null;

        RuleReturnScope def = null;
        this.init();
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:164:25: ( ^( AT_SPEC stage= a3dsStage env= a3dsEnvironment clevel= a3dsCLevel ^( AT_LANGUAGE lang= IDENT ) ^( AT_SPEC s= IDENT ) cpp_directive (def+= colaDefinition )* ) -> template(specification=spectoken=$def) \"<specification>\\n\\n<token>\")
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:164:27: ^( AT_SPEC stage= a3dsStage env= a3dsEnvironment clevel= a3dsCLevel ^( AT_LANGUAGE lang= IDENT ) ^( AT_SPEC s= IDENT ) cpp_directive (def+= colaDefinition )* )
            {
            match(input,AT_SPEC,FOLLOW_AT_SPEC_in_colaSpecification3259); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_a3dsStage_in_colaSpecification3263);
            stage=a3dsStage();

            state._fsp--;

            pushFollow(FOLLOW_a3dsEnvironment_in_colaSpecification3267);
            env=a3dsEnvironment();

            state._fsp--;

            pushFollow(FOLLOW_a3dsCLevel_in_colaSpecification3271);
            clevel=a3dsCLevel();

            state._fsp--;

            match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_colaSpecification3274); 

            match(input, Token.DOWN, null); 
            lang=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaSpecification3278); 

            match(input, Token.UP, null); 
            match(input,AT_SPEC,FOLLOW_AT_SPEC_in_colaSpecification3308); 

            match(input, Token.DOWN, null); 
            s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaSpecification3312); 
            StringTemplate spec=templateLib.getInstanceOf("colaSpecification");
                                        spec.setAttribute("stage", (stage!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(stage.start),
              input.getTreeAdaptor().getTokenStopIndex(stage.start))):null));
                                        spec.setAttribute("environment", (env!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(env.start),
              input.getTreeAdaptor().getTokenStopIndex(env.start))):null));
                                        spec.setAttribute("clevel", (clevel!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(clevel.start),
              input.getTreeAdaptor().getTokenStopIndex(clevel.start))):null));
                                        spec.setAttribute("language", (lang!=null?lang.getText():null));
                                        spec.setAttribute("spec", s);
                                        this.pass.atoms.addST(ColaTokensConstants.colaSPECIFICATION,spec);
                                       

            match(input, Token.UP, null); 
            pushFollow(FOLLOW_cpp_directive_in_colaSpecification3371);
            cpp_directive();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:174:42: (def+= colaDefinition )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==FUNCTION||LA52_0==PROPERTY||(LA52_0>=PACKAGE && LA52_0<=FACILITY)||LA52_0==CONTRACT||LA52_0==CPP_DIRECTIVE||(LA52_0>=TYPEDEF && LA52_0<=STRUCT)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:174:43: def+= colaDefinition
            	    {
            	    pushFollow(FOLLOW_colaDefinition_in_colaSpecification3376);
            	    def=colaDefinition();

            	    state._fsp--;

            	    if (list_def==null) list_def=new ArrayList();
            	    list_def.add(def.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 176:27: -> template(specification=spectoken=$def) \"<specification>\\n\\n<token>\"
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
    // $ANTLR end "colaSpecification"

    public static class colaDefinition_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaDefinition"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:177:1: colaDefinition : ( colaFunction -> template(token=$colaFunction.st) \"<token>\" | colaPropertyDecl -> template(token=$colaPropertyDecl.st) \"<token>\" | colaContractDecl -> template(token=$colaContractDecl.st) \"<token>\" | colaPackage -> template(token=$colaPackage.st) \"<token>\" | colaElement -> template(token=$colaElement.st) \"<token>\" | colaFacility -> template(token=$colaFacility.st) \"<token>\" | colaTypeDef -> template(token=$colaTypeDef.st) \"<token>\" | colaStruct -> template(token=$colaStruct.st) \"<token>\" | cpp_directive );
    public final colaGen.colaDefinition_return colaDefinition() throws RecognitionException {
        colaGen.colaDefinition_return retval = new colaGen.colaDefinition_return();
        retval.start = input.LT(1);

        colaGen.colaFunction_return colaFunction14 = null;

        colaGen.colaPropertyDecl_return colaPropertyDecl15 = null;

        colaGen.colaContractDecl_return colaContractDecl16 = null;

        colaGen.colaPackage_return colaPackage17 = null;

        colaGen.colaElement_return colaElement18 = null;

        colaGen.colaFacility_return colaFacility19 = null;

        colaGen.colaTypeDef_return colaTypeDef20 = null;

        colaGen.colaStruct_return colaStruct21 = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:177:25: ( colaFunction -> template(token=$colaFunction.st) \"<token>\" | colaPropertyDecl -> template(token=$colaPropertyDecl.st) \"<token>\" | colaContractDecl -> template(token=$colaContractDecl.st) \"<token>\" | colaPackage -> template(token=$colaPackage.st) \"<token>\" | colaElement -> template(token=$colaElement.st) \"<token>\" | colaFacility -> template(token=$colaFacility.st) \"<token>\" | colaTypeDef -> template(token=$colaTypeDef.st) \"<token>\" | colaStruct -> template(token=$colaStruct.st) \"<token>\" | cpp_directive )
            int alt53=9;
            switch ( input.LA(1) ) {
            case FUNCTION:
                {
                alt53=1;
                }
                break;
            case PROPERTY:
                {
                alt53=2;
                }
                break;
            case CONTRACT:
                {
                alt53=3;
                }
                break;
            case PACKAGE:
                {
                alt53=4;
                }
                break;
            case ELEMENT:
                {
                alt53=5;
                }
                break;
            case FACILITY:
                {
                alt53=6;
                }
                break;
            case TYPEDEF:
                {
                alt53=7;
                }
                break;
            case STRUCT:
                {
                alt53=8;
                }
                break;
            case CPP_DIRECTIVE:
                {
                alt53=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:177:27: colaFunction
                    {
                    pushFollow(FOLLOW_colaFunction_in_colaDefinition3464);
                    colaFunction14=colaFunction();

                    state._fsp--;

                    this.pass.addST((colaFunction14!=null?colaFunction14.st:null));


                    // TEMPLATE REWRITE
                    // 177:77: -> template(token=$colaFunction.st) \"<token>\"
                    {
                        retval.st = new StringTemplate(templateLib, "<token>",
                      new STAttrMap().put("token", (colaFunction14!=null?colaFunction14.st:null)));
                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:178:27: colaPropertyDecl
                    {
                    pushFollow(FOLLOW_colaPropertyDecl_in_colaDefinition3507);
                    colaPropertyDecl15=colaPropertyDecl();

                    state._fsp--;

                    this.pass.addST((colaPropertyDecl15!=null?colaPropertyDecl15.st:null));


                    // TEMPLATE REWRITE
                    // 178:85: -> template(token=$colaPropertyDecl.st) \"<token>\"
                    {
                        retval.st = new StringTemplate(templateLib, "<token>",
                      new STAttrMap().put("token", (colaPropertyDecl15!=null?colaPropertyDecl15.st:null)));
                    }


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:179:27: colaContractDecl
                    {
                    pushFollow(FOLLOW_colaContractDecl_in_colaDefinition3550);
                    colaContractDecl16=colaContractDecl();

                    state._fsp--;

                    this.pass.addST((colaContractDecl16!=null?colaContractDecl16.st:null));


                    // TEMPLATE REWRITE
                    // 179:85: -> template(token=$colaContractDecl.st) \"<token>\"
                    {
                        retval.st = new StringTemplate(templateLib, "<token>",
                      new STAttrMap().put("token", (colaContractDecl16!=null?colaContractDecl16.st:null)));
                    }


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:180:27: colaPackage
                    {
                    pushFollow(FOLLOW_colaPackage_in_colaDefinition3593);
                    colaPackage17=colaPackage();

                    state._fsp--;

                    this.pass.addST((colaPackage17!=null?colaPackage17.st:null));


                    // TEMPLATE REWRITE
                    // 180:75: -> template(token=$colaPackage.st) \"<token>\"
                    {
                        retval.st = new StringTemplate(templateLib, "<token>",
                      new STAttrMap().put("token", (colaPackage17!=null?colaPackage17.st:null)));
                    }


                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:181:27: colaElement
                    {
                    pushFollow(FOLLOW_colaElement_in_colaDefinition3636);
                    colaElement18=colaElement();

                    state._fsp--;

                    this.pass.addST((colaElement18!=null?colaElement18.st:null));


                    // TEMPLATE REWRITE
                    // 181:75: -> template(token=$colaElement.st) \"<token>\"
                    {
                        retval.st = new StringTemplate(templateLib, "<token>",
                      new STAttrMap().put("token", (colaElement18!=null?colaElement18.st:null)));
                    }


                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:182:27: colaFacility
                    {
                    pushFollow(FOLLOW_colaFacility_in_colaDefinition3679);
                    colaFacility19=colaFacility();

                    state._fsp--;

                    this.pass.addST((colaFacility19!=null?colaFacility19.st:null));


                    // TEMPLATE REWRITE
                    // 182:77: -> template(token=$colaFacility.st) \"<token>\"
                    {
                        retval.st = new StringTemplate(templateLib, "<token>",
                      new STAttrMap().put("token", (colaFacility19!=null?colaFacility19.st:null)));
                    }


                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:183:27: colaTypeDef
                    {
                    pushFollow(FOLLOW_colaTypeDef_in_colaDefinition3722);
                    colaTypeDef20=colaTypeDef();

                    state._fsp--;

                    this.pass.addST((colaTypeDef20!=null?colaTypeDef20.st:null));


                    // TEMPLATE REWRITE
                    // 183:75: -> template(token=$colaTypeDef.st) \"<token>\"
                    {
                        retval.st = new StringTemplate(templateLib, "<token>",
                      new STAttrMap().put("token", (colaTypeDef20!=null?colaTypeDef20.st:null)));
                    }


                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:184:27: colaStruct
                    {
                    pushFollow(FOLLOW_colaStruct_in_colaDefinition3765);
                    colaStruct21=colaStruct();

                    state._fsp--;

                    this.pass.addST((colaStruct21!=null?colaStruct21.st:null));


                    // TEMPLATE REWRITE
                    // 184:73: -> template(token=$colaStruct.st) \"<token>\"
                    {
                        retval.st = new StringTemplate(templateLib, "<token>",
                      new STAttrMap().put("token", (colaStruct21!=null?colaStruct21.st:null)));
                    }


                    }
                    break;
                case 9 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:185:27: cpp_directive
                    {
                    pushFollow(FOLLOW_cpp_directive_in_colaDefinition3808);
                    cpp_directive();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "colaDefinition"

    public static class cpp_directive_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "cpp_directive"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:187:1: cpp_directive : CPP_DIRECTIVE ;
    public final colaGen.cpp_directive_return cpp_directive() throws RecognitionException {
        colaGen.cpp_directive_return retval = new colaGen.cpp_directive_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:187:25: ( CPP_DIRECTIVE )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:187:27: CPP_DIRECTIVE
            {
            match(input,CPP_DIRECTIVE,FOLLOW_CPP_DIRECTIVE_in_cpp_directive3826); 

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
    // $ANTLR end "cpp_directive"

    public static class colaPackage_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaPackage"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:189:1: colaPackage : ^( PACKAGE id= IDENT lpd= colaPropertyDefList (def+= colaDefinition )* (ic+= inline_code )* ) -> colaPackage(id=$idproperties=$lpd.stinline_code=$icmisc=this.pass.misc());
    public final colaGen.colaPackage_return colaPackage() throws RecognitionException {
        colaGen.colaPackage_return retval = new colaGen.colaPackage_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_def=null;
        List list_ic=null;
        colaGen.colaPropertyDefList_return lpd = null;

        RuleReturnScope def = null;
        RuleReturnScope ic = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:189:25: ( ^( PACKAGE id= IDENT lpd= colaPropertyDefList (def+= colaDefinition )* (ic+= inline_code )* ) -> colaPackage(id=$idproperties=$lpd.stinline_code=$icmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:189:27: ^( PACKAGE id= IDENT lpd= colaPropertyDefList (def+= colaDefinition )* (ic+= inline_code )* )
            {
            match(input,PACKAGE,FOLLOW_PACKAGE_in_colaPackage3847); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaPackage3851); 
            this.pass.atoms.scope.push(id.token);
            pushFollow(FOLLOW_colaPropertyDefList_in_colaPackage3857);
            lpd=colaPropertyDefList();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:189:111: (def+= colaDefinition )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==FUNCTION||LA54_0==PROPERTY||(LA54_0>=PACKAGE && LA54_0<=FACILITY)||LA54_0==CONTRACT||LA54_0==CPP_DIRECTIVE||(LA54_0>=TYPEDEF && LA54_0<=STRUCT)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:189:112: def+= colaDefinition
            	    {
            	    pushFollow(FOLLOW_colaDefinition_in_colaPackage3862);
            	    def=colaDefinition();

            	    state._fsp--;

            	    if (list_def==null) list_def=new ArrayList();
            	    list_def.add(def.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:189:134: (ic+= inline_code )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==AT_LANGUAGE) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:189:135: ic+= inline_code
            	    {
            	    pushFollow(FOLLOW_inline_code_in_colaPackage3869);
            	    ic=inline_code();

            	    state._fsp--;

            	    if (list_ic==null) list_ic=new ArrayList();
            	    list_ic.add(ic.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 190:27: -> colaPackage(id=$idproperties=$lpd.stinline_code=$icmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaPackage",
              new STAttrMap().put("id", id).put("properties", (lpd!=null?lpd.st:null)).put("inline_code", list_ic).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaPackage"

    public static class colaElement_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaElement"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:192:1: colaElement : ^( ELEMENT id= IDENT lpd= colaPropertyDefList lcd= colaContractDefList ( atVisibility )? ( ^( AT_EXTENDS (ext+= scoped_name )* ) )? ( ^( AT_PROVIDES (pro+= scoped_name )* ) )? ( ^( AT_REQUIRES (req+= scoped_name )* ) )? ( elementBody )* ) -> colaElement(id=$idproperties=$lpd.stcontracts=$lcd.staExtends=$extaProvides=$proaRequires=$reqmisc=this.pass.misc());
    public final colaGen.colaElement_return colaElement() throws RecognitionException {
        colaGen.colaElement_return retval = new colaGen.colaElement_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_ext=null;
        List list_pro=null;
        List list_req=null;
        colaGen.colaPropertyDefList_return lpd = null;

        colaGen.colaContractDefList_return lcd = null;

        RuleReturnScope ext = null;
        RuleReturnScope pro = null;
        RuleReturnScope req = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:192:25: ( ^( ELEMENT id= IDENT lpd= colaPropertyDefList lcd= colaContractDefList ( atVisibility )? ( ^( AT_EXTENDS (ext+= scoped_name )* ) )? ( ^( AT_PROVIDES (pro+= scoped_name )* ) )? ( ^( AT_REQUIRES (req+= scoped_name )* ) )? ( elementBody )* ) -> colaElement(id=$idproperties=$lpd.stcontracts=$lcd.staExtends=$extaProvides=$proaRequires=$reqmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:192:27: ^( ELEMENT id= IDENT lpd= colaPropertyDefList lcd= colaContractDefList ( atVisibility )? ( ^( AT_EXTENDS (ext+= scoped_name )* ) )? ( ^( AT_PROVIDES (pro+= scoped_name )* ) )? ( ^( AT_REQUIRES (req+= scoped_name )* ) )? ( elementBody )* )
            {
            match(input,ELEMENT,FOLLOW_ELEMENT_in_colaElement3943); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaElement3947); 
            this.pass.atoms.scope.push(id.token);
            pushFollow(FOLLOW_colaPropertyDefList_in_colaElement3953);
            lpd=colaPropertyDefList();

            state._fsp--;

            pushFollow(FOLLOW_colaContractDefList_in_colaElement3957);
            lcd=colaContractDefList();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:192:135: ( atVisibility )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==AT_VISIBILITY) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:192:135: atVisibility
                    {
                    pushFollow(FOLLOW_atVisibility_in_colaElement3959);
                    atVisibility();

                    state._fsp--;


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:193:30: ( ^( AT_EXTENDS (ext+= scoped_name )* ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==AT_EXTENDS) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:193:31: ^( AT_EXTENDS (ext+= scoped_name )* )
                    {
                    match(input,AT_EXTENDS,FOLLOW_AT_EXTENDS_in_colaElement3993); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:193:45: (ext+= scoped_name )*
                        loop57:
                        do {
                            int alt57=2;
                            int LA57_0 = input.LA(1);

                            if ( (LA57_0==AT_SCOPE) ) {
                                alt57=1;
                            }


                            switch (alt57) {
                        	case 1 :
                        	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:193:46: ext+= scoped_name
                        	    {
                        	    pushFollow(FOLLOW_scoped_name_in_colaElement3999);
                        	    ext=scoped_name();

                        	    state._fsp--;

                        	    if (list_ext==null) list_ext=new ArrayList();
                        	    list_ext.add(ext.getTemplate());

                        	    this.pass.atoms.addImport(this.pass.sn.toString());

                        	    }
                        	    break;

                        	default :
                        	    break loop57;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:194:30: ( ^( AT_PROVIDES (pro+= scoped_name )* ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==AT_PROVIDES) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:194:31: ^( AT_PROVIDES (pro+= scoped_name )* )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_colaElement4039); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:194:45: (pro+= scoped_name )*
                        loop59:
                        do {
                            int alt59=2;
                            int LA59_0 = input.LA(1);

                            if ( (LA59_0==AT_SCOPE) ) {
                                alt59=1;
                            }


                            switch (alt59) {
                        	case 1 :
                        	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:194:46: pro+= scoped_name
                        	    {
                        	    pushFollow(FOLLOW_scoped_name_in_colaElement4044);
                        	    pro=scoped_name();

                        	    state._fsp--;

                        	    if (list_pro==null) list_pro=new ArrayList();
                        	    list_pro.add(pro.getTemplate());

                        	    this.pass.atoms.addImport(this.pass.sn.toString());

                        	    }
                        	    break;

                        	default :
                        	    break loop59;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:195:30: ( ^( AT_REQUIRES (req+= scoped_name )* ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==AT_REQUIRES) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:195:31: ^( AT_REQUIRES (req+= scoped_name )* )
                    {
                    match(input,AT_REQUIRES,FOLLOW_AT_REQUIRES_in_colaElement4084); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:195:45: (req+= scoped_name )*
                        loop61:
                        do {
                            int alt61=2;
                            int LA61_0 = input.LA(1);

                            if ( (LA61_0==AT_SCOPE) ) {
                                alt61=1;
                            }


                            switch (alt61) {
                        	case 1 :
                        	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:195:46: req+= scoped_name
                        	    {
                        	    pushFollow(FOLLOW_scoped_name_in_colaElement4089);
                        	    req=scoped_name();

                        	    state._fsp--;

                        	    if (list_req==null) list_req=new ArrayList();
                        	    list_req.add(req.getTemplate());

                        	    this.pass.atoms.addImport(this.pass.sn.toString());

                        	    }
                        	    break;

                        	default :
                        	    break loop61;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:196:30: ( elementBody )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==AT_LANGUAGE||(LA63_0>=ACTION && LA63_0<=ATTRIBUTE)||LA63_0==AT_CONTAINS) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:196:30: elementBody
            	    {
            	    pushFollow(FOLLOW_elementBody_in_colaElement4127);
            	    elementBody();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 198:27: -> colaElement(id=$idproperties=$lpd.stcontracts=$lcd.staExtends=$extaProvides=$proaRequires=$reqmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaElement",
              new STAttrMap().put("id", id).put("properties", (lpd!=null?lpd.st:null)).put("contracts", (lcd!=null?lcd.st:null)).put("aExtends", list_ext).put("aProvides", list_pro).put("aRequires", list_req).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaElement"

    public static class elementBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "elementBody"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:199:1: elementBody : ( elementContains | colaAttribute | colaAction | inline_code );
    public final colaGen.elementBody_return elementBody() throws RecognitionException {
        colaGen.elementBody_return retval = new colaGen.elementBody_return();
        retval.start = input.LT(1);

        colaGen.colaAttribute_return colaAttribute22 = null;

        colaGen.colaAction_return colaAction23 = null;

        colaGen.inline_code_return inline_code24 = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:199:25: ( elementContains | colaAttribute | colaAction | inline_code )
            int alt64=4;
            switch ( input.LA(1) ) {
            case AT_CONTAINS:
                {
                alt64=1;
                }
                break;
            case ATTRIBUTE:
                {
                alt64=2;
                }
                break;
            case ACTION:
                {
                alt64=3;
                }
                break;
            case AT_LANGUAGE:
                {
                alt64=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:199:27: elementContains
                    {
                    pushFollow(FOLLOW_elementContains_in_elementBody4240);
                    elementContains();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:199:45: colaAttribute
                    {
                    pushFollow(FOLLOW_colaAttribute_in_elementBody4244);
                    colaAttribute22=colaAttribute();

                    state._fsp--;

                    this.pass.addST((colaAttribute22!=null?colaAttribute22.st:null));

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:199:99: colaAction
                    {
                    pushFollow(FOLLOW_colaAction_in_elementBody4250);
                    colaAction23=colaAction();

                    state._fsp--;

                    this.pass.addST((colaAction23!=null?colaAction23.st:null));

                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:199:148: inline_code
                    {
                    pushFollow(FOLLOW_inline_code_in_elementBody4257);
                    inline_code24=inline_code();

                    state._fsp--;

                    this.pass.addST((inline_code24!=null?inline_code24.st:null));

                    }
                    break;

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
    // $ANTLR end "elementBody"

    public static class elementContains_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "elementContains"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:200:1: elementContains : ^( AT_CONTAINS IDENT scoped_name ) ;
    public final colaGen.elementContains_return elementContains() throws RecognitionException {
        colaGen.elementContains_return retval = new colaGen.elementContains_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:200:25: ( ^( AT_CONTAINS IDENT scoped_name ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:200:27: ^( AT_CONTAINS IDENT scoped_name )
            {
            match(input,AT_CONTAINS,FOLLOW_AT_CONTAINS_in_elementContains4275); 

            match(input, Token.DOWN, null); 
            match(input,IDENT,FOLLOW_IDENT_in_elementContains4277); 
            pushFollow(FOLLOW_scoped_name_in_elementContains4279);
            scoped_name();

            state._fsp--;


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
    // $ANTLR end "elementContains"

    public static class colaFacility_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaFacility"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:202:1: colaFacility : ^( FACILITY id= IDENT lpd= colaPropertyDefList lcd= colaContractDefList ( atVisibility )? ( ^( AT_EXTENDS (ext+= scoped_name )* ) )? ( ^( AT_REQUIRES (req+= scoped_name )* ) )? ( facilityBody )* ) -> colaFacility(id=$idproperties=$lpd.stcontracts=$lcd.staExtends=$extaRequires=$reqmisc=this.pass.misc());
    public final colaGen.colaFacility_return colaFacility() throws RecognitionException {
        colaGen.colaFacility_return retval = new colaGen.colaFacility_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_ext=null;
        List list_req=null;
        colaGen.colaPropertyDefList_return lpd = null;

        colaGen.colaContractDefList_return lcd = null;

        RuleReturnScope ext = null;
        RuleReturnScope req = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:202:25: ( ^( FACILITY id= IDENT lpd= colaPropertyDefList lcd= colaContractDefList ( atVisibility )? ( ^( AT_EXTENDS (ext+= scoped_name )* ) )? ( ^( AT_REQUIRES (req+= scoped_name )* ) )? ( facilityBody )* ) -> colaFacility(id=$idproperties=$lpd.stcontracts=$lcd.staExtends=$extaRequires=$reqmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:202:27: ^( FACILITY id= IDENT lpd= colaPropertyDefList lcd= colaContractDefList ( atVisibility )? ( ^( AT_EXTENDS (ext+= scoped_name )* ) )? ( ^( AT_REQUIRES (req+= scoped_name )* ) )? ( facilityBody )* )
            {
            match(input,FACILITY,FOLLOW_FACILITY_in_colaFacility4300); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaFacility4304); 
            this.pass.atoms.scope.push(id.token);
            pushFollow(FOLLOW_colaPropertyDefList_in_colaFacility4310);
            lpd=colaPropertyDefList();

            state._fsp--;

            pushFollow(FOLLOW_colaContractDefList_in_colaFacility4314);
            lcd=colaContractDefList();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:202:136: ( atVisibility )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==AT_VISIBILITY) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:202:136: atVisibility
                    {
                    pushFollow(FOLLOW_atVisibility_in_colaFacility4316);
                    atVisibility();

                    state._fsp--;


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:203:30: ( ^( AT_EXTENDS (ext+= scoped_name )* ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==AT_EXTENDS) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:203:31: ^( AT_EXTENDS (ext+= scoped_name )* )
                    {
                    match(input,AT_EXTENDS,FOLLOW_AT_EXTENDS_in_colaFacility4350); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:203:45: (ext+= scoped_name )*
                        loop66:
                        do {
                            int alt66=2;
                            int LA66_0 = input.LA(1);

                            if ( (LA66_0==AT_SCOPE) ) {
                                alt66=1;
                            }


                            switch (alt66) {
                        	case 1 :
                        	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:203:46: ext+= scoped_name
                        	    {
                        	    pushFollow(FOLLOW_scoped_name_in_colaFacility4356);
                        	    ext=scoped_name();

                        	    state._fsp--;

                        	    if (list_ext==null) list_ext=new ArrayList();
                        	    list_ext.add(ext.getTemplate());

                        	    this.pass.atoms.addImport(this.pass.sn.toString());

                        	    }
                        	    break;

                        	default :
                        	    break loop66;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:204:30: ( ^( AT_REQUIRES (req+= scoped_name )* ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==AT_REQUIRES) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:204:31: ^( AT_REQUIRES (req+= scoped_name )* )
                    {
                    match(input,AT_REQUIRES,FOLLOW_AT_REQUIRES_in_colaFacility4396); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:204:45: (req+= scoped_name )*
                        loop68:
                        do {
                            int alt68=2;
                            int LA68_0 = input.LA(1);

                            if ( (LA68_0==AT_SCOPE) ) {
                                alt68=1;
                            }


                            switch (alt68) {
                        	case 1 :
                        	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:204:46: req+= scoped_name
                        	    {
                        	    pushFollow(FOLLOW_scoped_name_in_colaFacility4401);
                        	    req=scoped_name();

                        	    state._fsp--;

                        	    if (list_req==null) list_req=new ArrayList();
                        	    list_req.add(req.getTemplate());

                        	    this.pass.atoms.addImport(this.pass.sn.toString());

                        	    }
                        	    break;

                        	default :
                        	    break loop68;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:205:30: ( facilityBody )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( ((LA70_0>=ACTION && LA70_0<=ATTRIBUTE)) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:205:30: facilityBody
            	    {
            	    pushFollow(FOLLOW_facilityBody_in_colaFacility4439);
            	    facilityBody();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 207:27: -> colaFacility(id=$idproperties=$lpd.stcontracts=$lcd.staExtends=$extaRequires=$reqmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaFacility",
              new STAttrMap().put("id", id).put("properties", (lpd!=null?lpd.st:null)).put("contracts", (lcd!=null?lcd.st:null)).put("aExtends", list_ext).put("aRequires", list_req).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaFacility"

    public static class facilityBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "facilityBody"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:208:1: facilityBody : ( colaAttribute | colaAction );
    public final colaGen.facilityBody_return facilityBody() throws RecognitionException {
        colaGen.facilityBody_return retval = new colaGen.facilityBody_return();
        retval.start = input.LT(1);

        colaGen.colaAttribute_return colaAttribute25 = null;

        colaGen.colaAction_return colaAction26 = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:208:25: ( colaAttribute | colaAction )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==ATTRIBUTE) ) {
                alt71=1;
            }
            else if ( (LA71_0==ACTION) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:208:27: colaAttribute
                    {
                    pushFollow(FOLLOW_colaAttribute_in_facilityBody4546);
                    colaAttribute25=colaAttribute();

                    state._fsp--;

                    this.pass.addST((colaAttribute25!=null?colaAttribute25.st:null));

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:208:81: colaAction
                    {
                    pushFollow(FOLLOW_colaAction_in_facilityBody4552);
                    colaAction26=colaAction();

                    state._fsp--;

                    this.pass.addST((colaAction26!=null?colaAction26.st:null));

                    }
                    break;

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
    // $ANTLR end "facilityBody"

    public static class colaAction_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaAction"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:210:1: colaAction : ^( ACTION id= IDENT ( simple_type )? ( void_type )? lpd= colaPropertyDefList ( colaParameter )* (ic+= inline_code )* ) -> colaAction(id=$idtype=this.pass.simple_type()properties=$lpd.stmisc=this.pass.misc()inline_code=$ic);
    public final colaGen.colaAction_return colaAction() throws RecognitionException {
        colaGen.colaAction_return retval = new colaGen.colaAction_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_ic=null;
        colaGen.colaPropertyDefList_return lpd = null;

        colaGen.colaParameter_return colaParameter27 = null;

        RuleReturnScope ic = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:210:25: ( ^( ACTION id= IDENT ( simple_type )? ( void_type )? lpd= colaPropertyDefList ( colaParameter )* (ic+= inline_code )* ) -> colaAction(id=$idtype=this.pass.simple_type()properties=$lpd.stmisc=this.pass.misc()inline_code=$ic))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:210:27: ^( ACTION id= IDENT ( simple_type )? ( void_type )? lpd= colaPropertyDefList ( colaParameter )* (ic+= inline_code )* )
            {
            match(input,ACTION,FOLLOW_ACTION_in_colaAction4576); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaAction4580); 
            this.pass.atoms.scope.push(id.token);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:210:86: ( simple_type )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==AT_SCOPE||(LA72_0>=SHORT && LA72_0<=BOOLEAN)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:210:86: simple_type
                    {
                    pushFollow(FOLLOW_simple_type_in_colaAction4584);
                    simple_type();

                    state._fsp--;


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:210:99: ( void_type )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==VOID) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:210:100: void_type
                    {
                    pushFollow(FOLLOW_void_type_in_colaAction4588);
                    void_type();

                    state._fsp--;

                    this.pass.simple_typeVoid();

                    }
                    break;

            }

            pushFollow(FOLLOW_colaPropertyDefList_in_colaAction4596);
            lpd=colaPropertyDefList();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:210:167: ( colaParameter )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==PARAMETER) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:210:168: colaParameter
            	    {
            	    pushFollow(FOLLOW_colaParameter_in_colaAction4599);
            	    colaParameter27=colaParameter();

            	    state._fsp--;

            	    this.pass.addST((colaParameter27!=null?colaParameter27.st:null));

            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:210:222: (ic+= inline_code )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==AT_LANGUAGE) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:210:223: ic+= inline_code
            	    {
            	    pushFollow(FOLLOW_inline_code_in_colaAction4608);
            	    ic=inline_code();

            	    state._fsp--;

            	    if (list_ic==null) list_ic=new ArrayList();
            	    list_ic.add(ic.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 211:27: -> colaAction(id=$idtype=this.pass.simple_type()properties=$lpd.stmisc=this.pass.misc()inline_code=$ic)
            {
                retval.st = templateLib.getInstanceOf("colaAction",
              new STAttrMap().put("id", id).put("type", this.pass.simple_type()).put("properties", (lpd!=null?lpd.st:null)).put("misc", this.pass.misc()).put("inline_code", list_ic));
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
    // $ANTLR end "colaAction"

    public static class colaParameter_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaParameter"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:212:1: colaParameter : ^( PARAMETER id= IDENT simple_type lpd= colaPropertyDefList ) -> colaParameter(id=$idtype=this.pass.simple_type()properties=$lpd.stmisc=this.pass.misc());
    public final colaGen.colaParameter_return colaParameter() throws RecognitionException {
        colaGen.colaParameter_return retval = new colaGen.colaParameter_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        colaGen.colaPropertyDefList_return lpd = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:212:25: ( ^( PARAMETER id= IDENT simple_type lpd= colaPropertyDefList ) -> colaParameter(id=$idtype=this.pass.simple_type()properties=$lpd.stmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:212:27: ^( PARAMETER id= IDENT simple_type lpd= colaPropertyDefList )
            {
            match(input,PARAMETER,FOLLOW_PARAMETER_in_colaParameter4684); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaParameter4688); 
            this.pass.atoms.scope.push(id.token);
            pushFollow(FOLLOW_simple_type_in_colaParameter4692);
            simple_type();

            state._fsp--;

            pushFollow(FOLLOW_colaPropertyDefList_in_colaParameter4696);
            lpd=colaPropertyDefList();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 213:27: -> colaParameter(id=$idtype=this.pass.simple_type()properties=$lpd.stmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaParameter",
              new STAttrMap().put("id", id).put("type", this.pass.simple_type()).put("properties", (lpd!=null?lpd.st:null)).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaParameter"

    public static class colaTypeDef_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaTypeDef"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:219:1: colaTypeDef : ^( TYPEDEF id= IDENT simple_type lpd= colaPropertyDefList (ic+= inline_code )* ) -> colaTypeDef(id=$idtype=this.pass.simple_type()properties=$lpd.stinline_code=$icpropertiesInstances=this.pass.getPropDefList()misc=this.pass.misc());
    public final colaGen.colaTypeDef_return colaTypeDef() throws RecognitionException {
        colaGen.colaTypeDef_return retval = new colaGen.colaTypeDef_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_ic=null;
        colaGen.colaPropertyDefList_return lpd = null;

        RuleReturnScope ic = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:219:25: ( ^( TYPEDEF id= IDENT simple_type lpd= colaPropertyDefList (ic+= inline_code )* ) -> colaTypeDef(id=$idtype=this.pass.simple_type()properties=$lpd.stinline_code=$icpropertiesInstances=this.pass.getPropDefList()misc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:219:27: ^( TYPEDEF id= IDENT simple_type lpd= colaPropertyDefList (ic+= inline_code )* )
            {
            match(input,TYPEDEF,FOLLOW_TYPEDEF_in_colaTypeDef4772); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaTypeDef4776); 
            this.pass.atoms.scope.push(id.token);
            pushFollow(FOLLOW_simple_type_in_colaTypeDef4780);
            simple_type();

            state._fsp--;

            pushFollow(FOLLOW_colaPropertyDefList_in_colaTypeDef4784);
            lpd=colaPropertyDefList();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:219:123: (ic+= inline_code )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==AT_LANGUAGE) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:219:124: ic+= inline_code
            	    {
            	    pushFollow(FOLLOW_inline_code_in_colaTypeDef4789);
            	    ic=inline_code();

            	    state._fsp--;

            	    if (list_ic==null) list_ic=new ArrayList();
            	    list_ic.add(ic.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 220:27: -> colaTypeDef(id=$idtype=this.pass.simple_type()properties=$lpd.stinline_code=$icpropertiesInstances=this.pass.getPropDefList()misc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaTypeDef",
              new STAttrMap().put("id", id).put("type", this.pass.simple_type()).put("properties", (lpd!=null?lpd.st:null)).put("inline_code", list_ic).put("propertiesInstances", this.pass.getPropDefList()).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaTypeDef"

    public static class colaAttribute_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaAttribute"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:221:1: colaAttribute : ^( ATTRIBUTE id= IDENT simple_type lpd= colaPropertyDefList (ic+= inline_code )* ) -> colaAttribute(id=$idtype=this.pass.simple_type()properties=$lpd.stinline_code=$icmisc=this.pass.misc());
    public final colaGen.colaAttribute_return colaAttribute() throws RecognitionException {
        colaGen.colaAttribute_return retval = new colaGen.colaAttribute_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_ic=null;
        colaGen.colaPropertyDefList_return lpd = null;

        RuleReturnScope ic = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:221:25: ( ^( ATTRIBUTE id= IDENT simple_type lpd= colaPropertyDefList (ic+= inline_code )* ) -> colaAttribute(id=$idtype=this.pass.simple_type()properties=$lpd.stinline_code=$icmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:221:27: ^( ATTRIBUTE id= IDENT simple_type lpd= colaPropertyDefList (ic+= inline_code )* )
            {
            match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_colaAttribute4870); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaAttribute4874); 
            this.pass.atoms.scope.push(id.token);
            pushFollow(FOLLOW_simple_type_in_colaAttribute4878);
            simple_type();

            state._fsp--;

            pushFollow(FOLLOW_colaPropertyDefList_in_colaAttribute4882);
            lpd=colaPropertyDefList();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:221:125: (ic+= inline_code )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==AT_LANGUAGE) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:221:126: ic+= inline_code
            	    {
            	    pushFollow(FOLLOW_inline_code_in_colaAttribute4887);
            	    ic=inline_code();

            	    state._fsp--;

            	    if (list_ic==null) list_ic=new ArrayList();
            	    list_ic.add(ic.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 222:27: -> colaAttribute(id=$idtype=this.pass.simple_type()properties=$lpd.stinline_code=$icmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaAttribute",
              new STAttrMap().put("id", id).put("type", this.pass.simple_type()).put("properties", (lpd!=null?lpd.st:null)).put("inline_code", list_ic).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaAttribute"

    public static class colaStruct_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaStruct"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:224:1: colaStruct : ^( STRUCT id= IDENT lpd= colaPropertyDefList ( colaMember )* (ic+= inline_code )* ) -> colaStruct(id=$idproperties=$lpd.stinline_code=$icmisc=this.pass.misc());
    public final colaGen.colaStruct_return colaStruct() throws RecognitionException {
        colaGen.colaStruct_return retval = new colaGen.colaStruct_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_ic=null;
        colaGen.colaPropertyDefList_return lpd = null;

        colaGen.colaMember_return colaMember28 = null;

        RuleReturnScope ic = null;
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:224:25: ( ^( STRUCT id= IDENT lpd= colaPropertyDefList ( colaMember )* (ic+= inline_code )* ) -> colaStruct(id=$idproperties=$lpd.stinline_code=$icmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:224:27: ^( STRUCT id= IDENT lpd= colaPropertyDefList ( colaMember )* (ic+= inline_code )* )
            {
            match(input,STRUCT,FOLLOW_STRUCT_in_colaStruct4967); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaStruct4971); 
            this.pass.atoms.scope.push(id.token);
            pushFollow(FOLLOW_colaPropertyDefList_in_colaStruct4977);
            lpd=colaPropertyDefList();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:224:110: ( colaMember )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==MEMBER) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:224:111: colaMember
            	    {
            	    pushFollow(FOLLOW_colaMember_in_colaStruct4980);
            	    colaMember28=colaMember();

            	    state._fsp--;

            	    this.pass.addST((colaMember28!=null?colaMember28.st:null));

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:224:159: (ic+= inline_code )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==AT_LANGUAGE) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:224:160: ic+= inline_code
            	    {
            	    pushFollow(FOLLOW_inline_code_in_colaStruct4989);
            	    ic=inline_code();

            	    state._fsp--;

            	    if (list_ic==null) list_ic=new ArrayList();
            	    list_ic.add(ic.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 225:27: -> colaStruct(id=$idproperties=$lpd.stinline_code=$icmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaStruct",
              new STAttrMap().put("id", id).put("properties", (lpd!=null?lpd.st:null)).put("inline_code", list_ic).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaStruct"

    public static class colaMember_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "colaMember"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:226:1: colaMember : ^( MEMBER id= IDENT simple_type lpd= colaPropertyDefList ) -> colaMember(id=$idtype=this.pass.simple_type()properties=$lpd.stmisc=this.pass.misc());
    public final colaGen.colaMember_return colaMember() throws RecognitionException {
        colaGen.colaMember_return retval = new colaGen.colaMember_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        colaGen.colaPropertyDefList_return lpd = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:226:25: ( ^( MEMBER id= IDENT simple_type lpd= colaPropertyDefList ) -> colaMember(id=$idtype=this.pass.simple_type()properties=$lpd.stmisc=this.pass.misc()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:226:27: ^( MEMBER id= IDENT simple_type lpd= colaPropertyDefList )
            {
            match(input,MEMBER,FOLLOW_MEMBER_in_colaMember5063); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_colaMember5067); 
            this.pass.atoms.scope.push(id.token);
            pushFollow(FOLLOW_simple_type_in_colaMember5071);
            simple_type();

            state._fsp--;

            pushFollow(FOLLOW_colaPropertyDefList_in_colaMember5075);
            lpd=colaPropertyDefList();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 227:27: -> colaMember(id=$idtype=this.pass.simple_type()properties=$lpd.stmisc=this.pass.misc())
            {
                retval.st = templateLib.getInstanceOf("colaMember",
              new STAttrMap().put("id", id).put("type", this.pass.simple_type()).put("properties", (lpd!=null?lpd.st:null)).put("misc", this.pass.misc()));
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
    // $ANTLR end "colaMember"

    public static class scoped_name_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "scoped_name"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:234:1: scoped_name : ^( AT_SCOPE (id+= IDENT )* ) -> scoped_name(id=$idadd=this.pass.scopeTgtLangAdd());
    public final colaGen.scoped_name_return scoped_name() throws RecognitionException {
        colaGen.scoped_name_return retval = new colaGen.scoped_name_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_id=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:234:25: ( ^( AT_SCOPE (id+= IDENT )* ) -> scoped_name(id=$idadd=this.pass.scopeTgtLangAdd()))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:234:27: ^( AT_SCOPE (id+= IDENT )* )
            {
            this.pass.sn.clear();
            match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_scoped_name5180); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:235:38: (id+= IDENT )*
                loop80:
                do {
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==IDENT) ) {
                        alt80=1;
                    }


                    switch (alt80) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:235:39: id+= IDENT
                	    {
                	    id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_scoped_name5185); 
                	    if (list_id==null) list_id=new ArrayList();
                	    list_id.add(id);

                	    this.pass.sn.push(id.token);

                	    }
                	    break;

                	default :
                	    break loop80;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            // TEMPLATE REWRITE
            // 235:83: -> scoped_name(id=$idadd=this.pass.scopeTgtLangAdd())
            {
                retval.st = templateLib.getInstanceOf("scoped_name",
              new STAttrMap().put("id", list_id).put("add", this.pass.scopeTgtLangAdd()));
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

    public static class void_type_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "void_type"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:237:1: void_type : t= VOID -> template(token=$t) \"<token>\";
    public final colaGen.void_type_return void_type() throws RecognitionException {
        colaGen.void_type_return retval = new colaGen.void_type_return();
        retval.start = input.LT(1);

        CommonTree t=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:237:25: (t= VOID -> template(token=$t) \"<token>\")
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:237:27: t= VOID
            {
            t=(CommonTree)match(input,VOID,FOLLOW_VOID_in_void_type5228); 


            // TEMPLATE REWRITE
            // 237:34: -> template(token=$t) \"<token>\"
            {
                retval.st = new StringTemplate(templateLib, "<token>",
              new STAttrMap().put("token", t));
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
    // $ANTLR end "void_type"

    public static class simple_type_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "simple_type"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:238:1: simple_type : ( (sc= scoped_name ) | bt= base_type ) ( ARRAY )? ;
    public final colaGen.simple_type_return simple_type() throws RecognitionException {
        colaGen.simple_type_return retval = new colaGen.simple_type_return();
        retval.start = input.LT(1);

        CommonTree ARRAY29=null;
        colaGen.scoped_name_return sc = null;

        colaGen.base_type_return bt = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:238:25: ( ( (sc= scoped_name ) | bt= base_type ) ( ARRAY )? )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:238:27: ( (sc= scoped_name ) | bt= base_type ) ( ARRAY )?
            {
            this.pass.simple_typeClear();
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:239:27: ( (sc= scoped_name ) | bt= base_type )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==AT_SCOPE) ) {
                alt81=1;
            }
            else if ( ((LA81_0>=SHORT && LA81_0<=BOOLEAN)) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:239:28: (sc= scoped_name )
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:239:28: (sc= scoped_name )
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:239:29: sc= scoped_name
                    {
                    pushFollow(FOLLOW_scoped_name_in_simple_type5290);
                    sc=scoped_name();

                    state._fsp--;

                    this.pass.atoms.addImport(this.pass.sn.toString());

                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:239:101: bt= base_type
                    {
                    pushFollow(FOLLOW_base_type_in_simple_type5299);
                    bt=base_type();

                    state._fsp--;


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:239:115: ( ARRAY )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==ARRAY) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:239:115: ARRAY
                    {
                    ARRAY29=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_simple_type5302); 

                    }
                    break;

            }

            this.pass.simple_type((sc!=null?sc.st:null),(bt!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(bt.start),
              input.getTreeAdaptor().getTokenStopIndex(bt.start))):null),(ARRAY29!=null?ARRAY29.getText():null));

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
    // $ANTLR end "simple_type"

    public static class base_type_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "base_type"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:241:1: base_type : ( SHORT | INTEGER | LONG | OCTET | HEX | BINARY | FLOAT | DOUBLE | CHAR | STRING | BOOLEAN );
    public final colaGen.base_type_return base_type() throws RecognitionException {
        colaGen.base_type_return retval = new colaGen.base_type_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:241:25: ( SHORT | INTEGER | LONG | OCTET | HEX | BINARY | FLOAT | DOUBLE | CHAR | STRING | BOOLEAN )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:
            {
            if ( (input.LA(1)>=SHORT && input.LA(1)<=BOOLEAN) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "base_type"

    public static class const_value_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "const_value"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:243:1: const_value : ( ^( AT_PROVIDES type= INTEGER cv= VAL_INTEGER ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= OCTET cv= VAL_OCT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= HEX cv= VAL_HEX ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= BINARY cv= VAL_BINARY ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= FLOAT cv= VAL_FLOAT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= CHAR cv= VAL_CHAR ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= STRING string_value ) -> const_value(type=$type.textval=$string_value.text) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) -> const_value(type=$type.textval=$boolean_value.text));
    public final colaGen.const_value_return const_value() throws RecognitionException {
        colaGen.const_value_return retval = new colaGen.const_value_return();
        retval.start = input.LT(1);

        CommonTree type=null;
        CommonTree cv=null;
        colaGen.string_value_return string_value30 = null;

        colaGen.boolean_value_return boolean_value31 = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:243:25: ( ^( AT_PROVIDES type= INTEGER cv= VAL_INTEGER ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= OCTET cv= VAL_OCT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= HEX cv= VAL_HEX ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= BINARY cv= VAL_BINARY ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= FLOAT cv= VAL_FLOAT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= CHAR cv= VAL_CHAR ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= STRING string_value ) -> const_value(type=$type.textval=$string_value.text) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) -> const_value(type=$type.textval=$boolean_value.text))
            int alt83=8;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:243:27: ^( AT_PROVIDES type= INTEGER cv= VAL_INTEGER )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value5413); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_const_value5417); 
                    cv=(CommonTree)match(input,VAL_INTEGER,FOLLOW_VAL_INTEGER_in_const_value5421); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 243:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:244:27: ^( AT_PROVIDES type= OCTET cv= VAL_OCT )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value5467); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,OCTET,FOLLOW_OCTET_in_const_value5471); 
                    cv=(CommonTree)match(input,VAL_OCT,FOLLOW_VAL_OCT_in_const_value5477); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 244:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:245:27: ^( AT_PROVIDES type= HEX cv= VAL_HEX )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value5527); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,HEX,FOLLOW_HEX_in_const_value5531); 
                    cv=(CommonTree)match(input,VAL_HEX,FOLLOW_VAL_HEX_in_const_value5539); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 245:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:246:27: ^( AT_PROVIDES type= BINARY cv= VAL_BINARY )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value5589); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,BINARY,FOLLOW_BINARY_in_const_value5593); 
                    cv=(CommonTree)match(input,VAL_BINARY,FOLLOW_VAL_BINARY_in_const_value5598); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 246:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:247:27: ^( AT_PROVIDES type= FLOAT cv= VAL_FLOAT )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value5645); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_const_value5649); 
                    cv=(CommonTree)match(input,VAL_FLOAT,FOLLOW_VAL_FLOAT_in_const_value5655); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 247:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:248:27: ^( AT_PROVIDES type= CHAR cv= VAL_CHAR )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value5703); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,CHAR,FOLLOW_CHAR_in_const_value5707); 
                    cv=(CommonTree)match(input,VAL_CHAR,FOLLOW_VAL_CHAR_in_const_value5714); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 248:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:249:27: ^( AT_PROVIDES type= STRING string_value )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value5763); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,STRING,FOLLOW_STRING_in_const_value5767); 
                    pushFollow(FOLLOW_string_value_in_const_value5770);
                    string_value30=string_value();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 249:70: -> const_value(type=$type.textval=$string_value.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (string_value30!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(string_value30.start),
                      input.getTreeAdaptor().getTokenStopIndex(string_value30.start))):null)));
                    }


                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:250:27: ^( AT_PROVIDES type= BOOLEAN boolean_value )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value5818); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_const_value5822); 
                    pushFollow(FOLLOW_boolean_value_in_const_value5824);
                    boolean_value31=boolean_value();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 250:70: -> const_value(type=$type.textval=$boolean_value.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (boolean_value31!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(boolean_value31.start),
                      input.getTreeAdaptor().getTokenStopIndex(boolean_value31.start))):null)));
                    }


                    }
                    break;

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
    // $ANTLR end "const_value"

    public static class string_value_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "string_value"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:251:1: string_value : ( VAL_STRING | COLA_NULL ) ;
    public final colaGen.string_value_return string_value() throws RecognitionException {
        colaGen.string_value_return retval = new colaGen.string_value_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:251:25: ( ( VAL_STRING | COLA_NULL ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:251:27: ( VAL_STRING | COLA_NULL )
            {
            if ( (input.LA(1)>=VAL_STRING && input.LA(1)<=COLA_NULL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "string_value"

    public static class boolean_value_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "boolean_value"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:252:1: boolean_value : ( COLA_TRUE | COLA_FALSE ) ;
    public final colaGen.boolean_value_return boolean_value() throws RecognitionException {
        colaGen.boolean_value_return retval = new colaGen.boolean_value_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:252:25: ( ( COLA_TRUE | COLA_FALSE ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:252:27: ( COLA_TRUE | COLA_FALSE )
            {
            if ( input.LA(1)==COLA_TRUE||input.LA(1)==COLA_FALSE ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "boolean_value"

    public static class inline_code_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "inline_code"
    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:254:1: inline_code : ^( AT_LANGUAGE string_value ic= INLINE_CODE ) -> inline_code(language=this.pass.inline_codeLanguage($string_value.text)code=this.pass.inline_code($ic.text));
    public final colaGen.inline_code_return inline_code() throws RecognitionException {
        colaGen.inline_code_return retval = new colaGen.inline_code_return();
        retval.start = input.LT(1);

        CommonTree ic=null;
        colaGen.string_value_return string_value32 = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:254:25: ( ^( AT_LANGUAGE string_value ic= INLINE_CODE ) -> inline_code(language=this.pass.inline_codeLanguage($string_value.text)code=this.pass.inline_code($ic.text)))
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaGen.g:254:27: ^( AT_LANGUAGE string_value ic= INLINE_CODE )
            {
            match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_inline_code5908); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_string_value_in_inline_code5910);
            string_value32=string_value();

            state._fsp--;

            ic=(CommonTree)match(input,INLINE_CODE,FOLLOW_INLINE_CODE_in_inline_code5914); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 255:27: -> inline_code(language=this.pass.inline_codeLanguage($string_value.text)code=this.pass.inline_code($ic.text))
            {
                retval.st = templateLib.getInstanceOf("inline_code",
              new STAttrMap().put("language", this.pass.inline_codeLanguage((string_value32!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(string_value32.start),
              input.getTreeAdaptor().getTokenStopIndex(string_value32.start))):null))).put("code", this.pass.inline_code((ic!=null?ic.getText():null))));
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
    // $ANTLR end "inline_code"

    // Delegated rules


    protected DFA83 dfa83 = new DFA83(this);
    static final String DFA83_eotS =
        "\13\uffff";
    static final String DFA83_eofS =
        "\13\uffff";
    static final String DFA83_minS =
        "\1\52\1\2\1\60\10\uffff";
    static final String DFA83_maxS =
        "\1\52\1\2\1\71\10\uffff";
    static final String DFA83_acceptS =
        "\3\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10";
    static final String DFA83_specialS =
        "\13\uffff}>";
    static final String[] DFA83_transitionS = {
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

    static final short[] DFA83_eot = DFA.unpackEncodedString(DFA83_eotS);
    static final short[] DFA83_eof = DFA.unpackEncodedString(DFA83_eofS);
    static final char[] DFA83_min = DFA.unpackEncodedStringToUnsignedChars(DFA83_minS);
    static final char[] DFA83_max = DFA.unpackEncodedStringToUnsignedChars(DFA83_maxS);
    static final short[] DFA83_accept = DFA.unpackEncodedString(DFA83_acceptS);
    static final short[] DFA83_special = DFA.unpackEncodedString(DFA83_specialS);
    static final short[][] DFA83_transition;

    static {
        int numStates = DFA83_transitionS.length;
        DFA83_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA83_transition[i] = DFA.unpackEncodedString(DFA83_transitionS[i]);
        }
    }

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = DFA83_eot;
            this.eof = DFA83_eof;
            this.min = DFA83_min;
            this.max = DFA83_max;
            this.accept = DFA83_accept;
            this.special = DFA83_special;
            this.transition = DFA83_transition;
        }
        public String getDescription() {
            return "243:1: const_value : ( ^( AT_PROVIDES type= INTEGER cv= VAL_INTEGER ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= OCTET cv= VAL_OCT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= HEX cv= VAL_HEX ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= BINARY cv= VAL_BINARY ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= FLOAT cv= VAL_FLOAT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= CHAR cv= VAL_CHAR ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= STRING string_value ) -> const_value(type=$type.textval=$string_value.text) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) -> const_value(type=$type.textval=$boolean_value.text));";
        }
    }
 

    public static final BitSet FOLLOW_set_in_a3dsStage0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_a3dsEnvironment0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_a3dsCLevel0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_colaFunction167 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaFunction171 = new BitSet(new long[]{0x03FF800000000080L});
    public static final BitSet FOLLOW_colaFunctionParam_in_colaFunction175 = new BitSet(new long[]{0x03FF800000000080L});
    public static final BitSet FOLLOW_base_type_in_colaFunction180 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000010L});
    public static final BitSet FOLLOW_ARRAY_in_colaFunction182 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_AT_LANGUAGE_in_colaFunction186 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_string_value_in_colaFunction188 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAMETER_in_colaFunctionParam256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_base_type_in_colaFunctionParam260 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000010L});
    public static final BitSet FOLLOW_ARRAY_in_colaFunctionParam262 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_colaFunctionParam267 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_in_colaPropertyDecl329 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaPropertyDecl333 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_AT_TYPE_in_colaPropertyDecl336 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_base_type_in_colaPropertyDecl340 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_const_value_in_colaPropertyDecl344 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_ARRAY_in_colaPropertyDecl346 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_SCOPE_in_colaPropertyDecl439 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyScope_in_colaPropertyDecl441 = new BitSet(new long[]{0x00000000003E0088L});
    public static final BitSet FOLLOW_AT_APPLY_in_colaPropertyDecl504 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PRE_in_colaPropertyDecl508 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDecl517 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_POST_in_colaPropertyDecl567 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDecl576 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_INV_in_colaPropertyDecl626 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDecl635 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_atVisibility_in_colaPropertyDecl674 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_AT_ALTERABLE_in_colaPropertyDecl677 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_AT_NEGOTIABLE_in_colaPropertyDecl680 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_atDescription_in_colaPropertyDecl683 = new BitSet(new long[]{0x000000000001C008L});
    public static final BitSet FOLLOW_AT_EXTENDS_in_colaPropertyDecl715 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDecl720 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_AT_REQUIRES_in_colaPropertyDecl731 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDecl736 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_AT_PRIORITY_in_colaPropertyDecl775 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_base_type_in_colaPropertyDecl779 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_const_value_in_colaPropertyDecl783 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_propertyScopeAtom_in_propertyScope1256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyScopeRank_in_propertyScope1260 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PACKAGE_in_propertyScopeAtom1306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELEMENT_in_propertyScopeAtom1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FACILITY_in_propertyScopeAtom1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_propertyScopeAtom1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_propertyScopeAtom1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARAMETER_in_propertyScopeAtom1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REQUIRED_in_propertyScopeRank1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MANDATORY_in_propertyScopeRank1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_propertyScopeRank1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_DEF_in_propertyScopeRank1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_VISIBILITY_in_atVisibility1414 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_AT_SPEC_in_atVisibility1417 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atVisibilityData_in_atVisibility1419 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_RUNTIME_in_atVisibility1423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atVisibilityData_in_atVisibility1425 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_95_in_atVisibilityData1441 = new BitSet(new long[]{0x0000000000000020L,0x0000002200000000L});
    public static final BitSet FOLLOW_IDENT_in_atVisibilityData1471 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_atVisibilityData1474 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData1476 = new BitSet(new long[]{0x0000000000000000L,0x0000001200000000L});
    public static final BitSet FOLLOW_100_in_atVisibilityData1479 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData1481 = new BitSet(new long[]{0x0000000000000000L,0x0000001200000000L});
    public static final BitSet FOLLOW_97_in_atVisibilityData1487 = new BitSet(new long[]{0x0000000200000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_COLA_TRUE_in_atVisibilityData1515 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_atVisibilityData1518 = new BitSet(new long[]{0x0000000000000020L,0x0000004100000000L});
    public static final BitSet FOLLOW_IDENT_in_atVisibilityData1547 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_atVisibilityData1550 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData1552 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_100_in_atVisibilityData1555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_atVisibilityData1557 = new BitSet(new long[]{0x0000000000000000L,0x0000001100000000L});
    public static final BitSet FOLLOW_96_in_atVisibilityData1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_DESCRIPTION_in_atDescription1608 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_string_value_in_atDescription1610 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_colaPropertyDef_in_colaPropertyDefList1638 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_PROPERTY_in_colaPropertyDef1691 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaPropertyDef1695 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_scoped_name_in_colaPropertyDef1699 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_const_value_in_colaPropertyDef1706 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_CONTRACT_in_colaContractDecl1813 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaContractDecl1817 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_AT_SCOPE_in_colaContractDecl1908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_contractScope_in_colaContractDecl1910 = new BitSet(new long[]{0x00000000000C0008L});
    public static final BitSet FOLLOW_atVisibility_in_colaContractDecl1914 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_atDescription_in_colaContractDecl1917 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_contractItem_in_colaContractDecl1950 = new BitSet(new long[]{0x0000001000000008L});
    public static final BitSet FOLLOW_contractScopeAtom_in_contractScope2056 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_contractScopeRank_in_contractScope2060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELEMENT_in_contractScopeAtom2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FACILITY_in_contractScopeAtom2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REQUIRED_in_contractScopeRank2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MANDATORY_in_contractScopeRank2144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_contractScopeRank2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_DEF_in_contractScopeRank2156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ITEM_in_contractItem2188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_contractItem2192 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_contractItemProp_in_contractItem2253 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_PROPERTY_in_contractItemProp2318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_contractItemProp2322 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_AT_TYPE_in_contractItemProp2383 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_base_type_in_contractItemProp2387 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_const_value_in_contractItemProp2391 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_ARRAY_in_contractItemProp2393 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_contractItemPropRank_in_contractItemProp2428 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_AT_APPLY_in_contractItemProp2489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PRE_in_contractItemProp2493 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_contractItemProp2502 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_POST_in_contractItemProp2552 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_contractItemProp2561 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_INV_in_contractItemProp2611 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_contractItemProp2620 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_AT_ALTERABLE_in_contractItemProp2660 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_AT_NEGOTIABLE_in_contractItemProp2663 = new BitSet(new long[]{0x0000000400003000L});
    public static final BitSet FOLLOW_atDescription_in_contractItemProp2666 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_AT_PRIORITY_in_contractItemProp2698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_base_type_in_contractItemProp2702 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_const_value_in_contractItemProp2706 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REQUIRED_in_contractItemPropRank2936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MANDATORY_in_contractItemPropRank2942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_contractItemPropRank2948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaContractDef_in_colaContractDefList2964 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_CONTRACT_in_colaContractDef3022 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaContractDef3026 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_scoped_name_in_colaContractDef3028 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_colaContractItemDef_in_colaContractDef3032 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_IDENT_in_colaContractItemDef3097 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_colaItemDef_in_colaContractItemDef3101 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_colaItemDef3167 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaItemDef3171 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_const_value_in_colaItemDef3175 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_AT_SPEC_in_colaSpecification3259 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_a3dsStage_in_colaSpecification3263 = new BitSet(new long[]{0x0000000000000000L,0x0000000007000000L});
    public static final BitSet FOLLOW_a3dsEnvironment_in_colaSpecification3267 = new BitSet(new long[]{0x0000000000040000L,0x0000000018000000L});
    public static final BitSet FOLLOW_a3dsCLevel_in_colaSpecification3271 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_AT_LANGUAGE_in_colaSpecification3274 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaSpecification3278 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_SPEC_in_colaSpecification3308 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaSpecification3312 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cpp_directive_in_colaSpecification3371 = new BitSet(new long[]{0x00003208000E0218L});
    public static final BitSet FOLLOW_colaDefinition_in_colaSpecification3376 = new BitSet(new long[]{0x00003208000E0218L});
    public static final BitSet FOLLOW_colaFunction_in_colaDefinition3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPropertyDecl_in_colaDefinition3507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaContractDecl_in_colaDefinition3550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaPackage_in_colaDefinition3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaElement_in_colaDefinition3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaFacility_in_colaDefinition3679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaTypeDef_in_colaDefinition3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaStruct_in_colaDefinition3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cpp_directive_in_colaDefinition3808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CPP_DIRECTIVE_in_cpp_directive3826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACKAGE_in_colaPackage3847 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaPackage3851 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaPackage3857 = new BitSet(new long[]{0x00003208000E0258L});
    public static final BitSet FOLLOW_colaDefinition_in_colaPackage3862 = new BitSet(new long[]{0x00003208000E0258L});
    public static final BitSet FOLLOW_inline_code_in_colaPackage3869 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_ELEMENT_in_colaElement3943 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaElement3947 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaElement3953 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_colaContractDefList_in_colaElement3957 = new BitSet(new long[]{0x00000C004030C048L});
    public static final BitSet FOLLOW_atVisibility_in_colaElement3959 = new BitSet(new long[]{0x00000C000030C048L});
    public static final BitSet FOLLOW_AT_EXTENDS_in_colaElement3993 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaElement3999 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_colaElement4039 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaElement4044 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_AT_REQUIRES_in_colaElement4084 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaElement4089 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_elementBody_in_colaElement4127 = new BitSet(new long[]{0x0000080000300048L});
    public static final BitSet FOLLOW_elementContains_in_elementBody4240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaAttribute_in_elementBody4244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaAction_in_elementBody4250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inline_code_in_elementBody4257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_CONTAINS_in_elementContains4275 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_elementContains4277 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_scoped_name_in_elementContains4279 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FACILITY_in_colaFacility4300 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaFacility4304 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaFacility4310 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_colaContractDefList_in_colaFacility4314 = new BitSet(new long[]{0x000000004030C008L});
    public static final BitSet FOLLOW_atVisibility_in_colaFacility4316 = new BitSet(new long[]{0x000000000030C008L});
    public static final BitSet FOLLOW_AT_EXTENDS_in_colaFacility4350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaFacility4356 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_AT_REQUIRES_in_colaFacility4396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_scoped_name_in_colaFacility4401 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_facilityBody_in_colaFacility4439 = new BitSet(new long[]{0x0000000000300008L});
    public static final BitSet FOLLOW_colaAttribute_in_facilityBody4546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colaAction_in_facilityBody4552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_colaAction4576 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaAction4580 = new BitSet(new long[]{0x03FFC00000000A88L});
    public static final BitSet FOLLOW_simple_type_in_colaAction4584 = new BitSet(new long[]{0x0000400000000200L});
    public static final BitSet FOLLOW_void_type_in_colaAction4588 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaAction4596 = new BitSet(new long[]{0x00000000000000C8L});
    public static final BitSet FOLLOW_colaParameter_in_colaAction4599 = new BitSet(new long[]{0x00000000000000C8L});
    public static final BitSet FOLLOW_inline_code_in_colaAction4608 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_PARAMETER_in_colaParameter4684 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaParameter4688 = new BitSet(new long[]{0x03FF800000000888L});
    public static final BitSet FOLLOW_simple_type_in_colaParameter4692 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaParameter4696 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPEDEF_in_colaTypeDef4772 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaTypeDef4776 = new BitSet(new long[]{0x03FF800000000888L});
    public static final BitSet FOLLOW_simple_type_in_colaTypeDef4780 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaTypeDef4784 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_inline_code_in_colaTypeDef4789 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_colaAttribute4870 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaAttribute4874 = new BitSet(new long[]{0x03FF800000000888L});
    public static final BitSet FOLLOW_simple_type_in_colaAttribute4878 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaAttribute4882 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_inline_code_in_colaAttribute4887 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_STRUCT_in_colaStruct4967 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaStruct4971 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaStruct4977 = new BitSet(new long[]{0x0000000000000048L,0x0000000000000020L});
    public static final BitSet FOLLOW_colaMember_in_colaStruct4980 = new BitSet(new long[]{0x0000000000000048L,0x0000000000000020L});
    public static final BitSet FOLLOW_inline_code_in_colaStruct4989 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_MEMBER_in_colaMember5063 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_colaMember5067 = new BitSet(new long[]{0x03FF800000000888L});
    public static final BitSet FOLLOW_simple_type_in_colaMember5071 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_colaPropertyDefList_in_colaMember5075 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_SCOPE_in_scoped_name5180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name5185 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_VOID_in_void_type5228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_name_in_simple_type5290 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_base_type_in_simple_type5299 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ARRAY_in_simple_type5302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_base_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value5413 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_const_value5417 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_VAL_INTEGER_in_const_value5421 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value5467 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OCTET_in_const_value5471 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_VAL_OCT_in_const_value5477 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value5527 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_HEX_in_const_value5531 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_VAL_HEX_in_const_value5539 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value5589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BINARY_in_const_value5593 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_VAL_BINARY_in_const_value5598 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value5645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FLOAT_in_const_value5649 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_VAL_FLOAT_in_const_value5655 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value5703 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_in_const_value5707 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_VAL_CHAR_in_const_value5714 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value5763 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_const_value5767 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_string_value_in_const_value5770 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value5818 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOLEAN_in_const_value5822 = new BitSet(new long[]{0x0000000200000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_boolean_value_in_const_value5824 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_string_value5858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_boolean_value5881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_LANGUAGE_in_inline_code5908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_string_value_in_inline_code5910 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_INLINE_CODE_in_inline_code5914 = new BitSet(new long[]{0x0000000000000008L});

}