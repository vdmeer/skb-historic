// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g 2011-07-07 22:24:55

  package org.skb.lang.pola.proto.grammars;

  import java.util.ArrayList;
  import java.util.LinkedHashMap;

  import org.skb.util.languages.AtomList;
  import org.skb.lang.pola.proto.PolaPass3_Gen;
  import org.skb.lang.pola.proto.PolaTokensConstants;
  import org.skb.util.ReportManager;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
public class polaGen extends TreeParser {
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


        public polaGen(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public polaGen(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected StringTemplateGroup templateLib =
      new StringTemplateGroup("polaGenTemplates", AngleBracketTemplateLexer.class);

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

    public String[] getTokenNames() { return polaGen.tokenNames; }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g"; }


      private AtomList atoms;
      private PolaPass3_Gen pass;

      public void init() {
        this.atoms=AtomList.getInstance();
        this.pass=new PolaPass3_Gen();
      }


    public static class a3dsStage_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "a3dsStage"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:74:1: a3dsStage : ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' );
    public final polaGen.a3dsStage_return a3dsStage() throws RecognitionException {
        polaGen.a3dsStage_return retval = new polaGen.a3dsStage_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:74:25: ( 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:
            {
            if ( (input.LA(1)>=72 && input.LA(1)<=77) ) {
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
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:75:1: a3dsEnvironment : ( 'production' | 'test' | 'demonstrator' );
    public final polaGen.a3dsEnvironment_return a3dsEnvironment() throws RecognitionException {
        polaGen.a3dsEnvironment_return retval = new polaGen.a3dsEnvironment_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:75:25: ( 'production' | 'test' | 'demonstrator' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:
            {
            if ( (input.LA(1)>=78 && input.LA(1)<=80) ) {
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
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:76:1: a3dsCLevel : ( 'business' | 'system' | 'element' );
    public final polaGen.a3dsCLevel_return a3dsCLevel() throws RecognitionException {
        polaGen.a3dsCLevel_return retval = new polaGen.a3dsCLevel_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:76:25: ( 'business' | 'system' | 'element' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:
            {
            if ( (input.LA(1)>=81 && input.LA(1)<=83) ) {
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

    public static class polaSpecification_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "polaSpecification"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:78:1: polaSpecification : ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE IDENT ) ^( AT_SPEC id= IDENT ) cpp_directive (def+= polaDefinition )* ) -> template(specification=spectoken=$def) \"<specification>\\n\\n<token>\";
    public final polaGen.polaSpecification_return polaSpecification() throws RecognitionException {
        polaGen.polaSpecification_return retval = new polaGen.polaSpecification_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_def=null;
        RuleReturnScope def = null;
        this.init();
        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:79:25: ( ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE IDENT ) ^( AT_SPEC id= IDENT ) cpp_directive (def+= polaDefinition )* ) -> template(specification=spectoken=$def) \"<specification>\\n\\n<token>\")
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:79:27: ^( AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^( AT_LANGUAGE IDENT ) ^( AT_SPEC id= IDENT ) cpp_directive (def+= polaDefinition )* )
            {
            match(input,AT_SPEC,FOLLOW_AT_SPEC_in_polaSpecification184); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_a3dsStage_in_polaSpecification186);
            a3dsStage();

            state._fsp--;

            pushFollow(FOLLOW_a3dsEnvironment_in_polaSpecification188);
            a3dsEnvironment();

            state._fsp--;

            pushFollow(FOLLOW_a3dsCLevel_in_polaSpecification190);
            a3dsCLevel();

            state._fsp--;

            match(input,AT_LANGUAGE,FOLLOW_AT_LANGUAGE_in_polaSpecification193); 

            match(input, Token.DOWN, null); 
            match(input,IDENT,FOLLOW_IDENT_in_polaSpecification195); 

            match(input, Token.UP, null); 
            match(input,AT_SPEC,FOLLOW_AT_SPEC_in_polaSpecification225); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_polaSpecification229); 
            StringTemplate spec=templateLib.getInstanceOf("polaSpecification");
                                        spec.setAttribute("id", id);
                                        this.atoms.addST(PolaTokensConstants.polaSPECIFICATION,spec);
                                       

            match(input, Token.UP, null); 
            pushFollow(FOLLOW_cpp_directive_in_polaSpecification288);
            cpp_directive();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:85:42: (def+= polaDefinition )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=CPP_DIRECTIVE && LA1_0<=POLA_POLICY)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:85:43: def+= polaDefinition
            	    {
            	    pushFollow(FOLLOW_polaDefinition_in_polaSpecification293);
            	    def=polaDefinition();

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


            // TEMPLATE REWRITE
            // 87:27: -> template(specification=spectoken=$def) \"<specification>\\n\\n<token>\"
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
    // $ANTLR end "polaSpecification"

    public static class polaDefinition_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "polaDefinition"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:88:1: polaDefinition : ( managementPolicy -> template(token=$managementPolicy.st) \"<token>\" | cpp_directive );
    public final polaGen.polaDefinition_return polaDefinition() throws RecognitionException {
        polaGen.polaDefinition_return retval = new polaGen.polaDefinition_return();
        retval.start = input.LT(1);

        polaGen.managementPolicy_return managementPolicy1 = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:88:25: ( managementPolicy -> template(token=$managementPolicy.st) \"<token>\" | cpp_directive )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:88:27: managementPolicy
                    {
                    pushFollow(FOLLOW_managementPolicy_in_polaDefinition381);
                    managementPolicy1=managementPolicy();

                    state._fsp--;

                    this.pass.addST((managementPolicy1!=null?managementPolicy1.st:null));


                    // TEMPLATE REWRITE
                    // 88:85: -> template(token=$managementPolicy.st) \"<token>\"
                    {
                        retval.st = new StringTemplate(templateLib, "<token>",
                      new STAttrMap().put("token", (managementPolicy1!=null?managementPolicy1.st:null)));
                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:89:27: cpp_directive
                    {
                    pushFollow(FOLLOW_cpp_directive_in_polaDefinition424);
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
    // $ANTLR end "polaDefinition"

    public static class cpp_directive_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "cpp_directive"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:92:1: cpp_directive : CPP_DIRECTIVE ;
    public final polaGen.cpp_directive_return cpp_directive() throws RecognitionException {
        polaGen.cpp_directive_return retval = new polaGen.cpp_directive_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:92:25: ( CPP_DIRECTIVE )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:92:27: CPP_DIRECTIVE
            {
            match(input,CPP_DIRECTIVE,FOLLOW_CPP_DIRECTIVE_in_cpp_directive469); 

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

    public static class managementPolicy_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "managementPolicy"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:94:1: managementPolicy : ^( POLA_POLICY id= IDENT type= managementPolicyType prs= policyRuleStructure ) -> managementPolicy(id=$idtype=$type.stprs=prs.st);
    public final polaGen.managementPolicy_return managementPolicy() throws RecognitionException {
        polaGen.managementPolicy_return retval = new polaGen.managementPolicy_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        polaGen.managementPolicyType_return type = null;

        polaGen.policyRuleStructure_return prs = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:94:25: ( ^( POLA_POLICY id= IDENT type= managementPolicyType prs= policyRuleStructure ) -> managementPolicy(id=$idtype=$type.stprs=prs.st))
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:94:27: ^( POLA_POLICY id= IDENT type= managementPolicyType prs= policyRuleStructure )
            {
            match(input,POLA_POLICY,FOLLOW_POLA_POLICY_in_managementPolicy485); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_managementPolicy489); 
            this.atoms.scope.push(id.token);
            pushFollow(FOLLOW_managementPolicyType_in_managementPolicy495);
            type=managementPolicyType();

            state._fsp--;

            pushFollow(FOLLOW_policyRuleStructure_in_managementPolicy499);
            prs=policyRuleStructure();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 95:27: -> managementPolicy(id=$idtype=$type.stprs=prs.st)
            {
                retval.st = templateLib.getInstanceOf("managementPolicy",
              new STAttrMap().put("id", id).put("type", (type!=null?type.st:null)).put("prs", prs.st));
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
    // $ANTLR end "managementPolicy"

    public static class managementPolicyType_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "managementPolicyType"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:96:1: managementPolicyType : (d= deonticPolicy -> template(token=$d.text) \"<token>\" | m= managementMetaPolicy -> template(token=$m.text) \"<token>\");
    public final polaGen.managementPolicyType_return managementPolicyType() throws RecognitionException {
        polaGen.managementPolicyType_return retval = new polaGen.managementPolicyType_return();
        retval.start = input.LT(1);

        polaGen.deonticPolicy_return d = null;

        polaGen.managementMetaPolicy_return m = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:96:25: (d= deonticPolicy -> template(token=$d.text) \"<token>\" | m= managementMetaPolicy -> template(token=$m.text) \"<token>\")
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:96:27: d= deonticPolicy
                    {
                    pushFollow(FOLLOW_deonticPolicy_in_managementPolicyType557);
                    d=deonticPolicy();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 96:43: -> template(token=$d.text) \"<token>\"
                    {
                        retval.st = new StringTemplate(templateLib, "<token>",
                      new STAttrMap().put("token", (d!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(d.start),
                      input.getTreeAdaptor().getTokenStopIndex(d.start))):null)));
                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:97:27: m= managementMetaPolicy
                    {
                    pushFollow(FOLLOW_managementMetaPolicy_in_managementPolicyType600);
                    m=managementMetaPolicy();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 97:50: -> template(token=$m.text) \"<token>\"
                    {
                        retval.st = new StringTemplate(templateLib, "<token>",
                      new STAttrMap().put("token", (m!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(m.start),
                      input.getTreeAdaptor().getTokenStopIndex(m.start))):null)));
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
    // $ANTLR end "managementPolicyType"

    public static class deonticPolicy_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "deonticPolicy"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:98:1: deonticPolicy : (t= POLA_DEONT_AUTH | t= POLA_DEONT_EXEM | t= POLA_DEONT_OBLG | t= POLA_DEONT_PROH ) -> deonticPolicy(type=$t);
    public final polaGen.deonticPolicy_return deonticPolicy() throws RecognitionException {
        polaGen.deonticPolicy_return retval = new polaGen.deonticPolicy_return();
        retval.start = input.LT(1);

        CommonTree t=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:98:25: ( (t= POLA_DEONT_AUTH | t= POLA_DEONT_EXEM | t= POLA_DEONT_OBLG | t= POLA_DEONT_PROH ) -> deonticPolicy(type=$t))
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:98:27: (t= POLA_DEONT_AUTH | t= POLA_DEONT_EXEM | t= POLA_DEONT_OBLG | t= POLA_DEONT_PROH )
            {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:98:27: (t= POLA_DEONT_AUTH | t= POLA_DEONT_EXEM | t= POLA_DEONT_OBLG | t= POLA_DEONT_PROH )
            int alt4=4;
            switch ( input.LA(1) ) {
            case POLA_DEONT_AUTH:
                {
                alt4=1;
                }
                break;
            case POLA_DEONT_EXEM:
                {
                alt4=2;
                }
                break;
            case POLA_DEONT_OBLG:
                {
                alt4=3;
                }
                break;
            case POLA_DEONT_PROH:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:98:28: t= POLA_DEONT_AUTH
                    {
                    t=(CommonTree)match(input,POLA_DEONT_AUTH,FOLLOW_POLA_DEONT_AUTH_in_deonticPolicy631); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:98:48: t= POLA_DEONT_EXEM
                    {
                    t=(CommonTree)match(input,POLA_DEONT_EXEM,FOLLOW_POLA_DEONT_EXEM_in_deonticPolicy637); 

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:98:68: t= POLA_DEONT_OBLG
                    {
                    t=(CommonTree)match(input,POLA_DEONT_OBLG,FOLLOW_POLA_DEONT_OBLG_in_deonticPolicy643); 

                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:98:88: t= POLA_DEONT_PROH
                    {
                    t=(CommonTree)match(input,POLA_DEONT_PROH,FOLLOW_POLA_DEONT_PROH_in_deonticPolicy649); 

                    }
                    break;

            }



            // TEMPLATE REWRITE
            // 99:27: -> deonticPolicy(type=$t)
            {
                retval.st = templateLib.getInstanceOf("deonticPolicy",
              new STAttrMap().put("type", t));
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
    // $ANTLR end "deonticPolicy"

    public static class managementMetaPolicy_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "managementMetaPolicy"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:100:1: managementMetaPolicy : (t= POLA_MEPO_DELE | t= POLA_MEPO_REVO ) -> managementMetaPolicy(type=$t);
    public final polaGen.managementMetaPolicy_return managementMetaPolicy() throws RecognitionException {
        polaGen.managementMetaPolicy_return retval = new polaGen.managementMetaPolicy_return();
        retval.start = input.LT(1);

        CommonTree t=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:100:25: ( (t= POLA_MEPO_DELE | t= POLA_MEPO_REVO ) -> managementMetaPolicy(type=$t))
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:100:27: (t= POLA_MEPO_DELE | t= POLA_MEPO_REVO )
            {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:100:27: (t= POLA_MEPO_DELE | t= POLA_MEPO_REVO )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==POLA_MEPO_DELE) ) {
                alt5=1;
            }
            else if ( (LA5_0==POLA_MEPO_REVO) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:100:28: t= POLA_MEPO_DELE
                    {
                    t=(CommonTree)match(input,POLA_MEPO_DELE,FOLLOW_POLA_MEPO_DELE_in_managementMetaPolicy698); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:100:47: t= POLA_MEPO_REVO
                    {
                    t=(CommonTree)match(input,POLA_MEPO_REVO,FOLLOW_POLA_MEPO_REVO_in_managementMetaPolicy704); 

                    }
                    break;

            }



            // TEMPLATE REWRITE
            // 101:27: -> managementMetaPolicy(type=$t)
            {
                retval.st = templateLib.getInstanceOf("managementMetaPolicy",
              new STAttrMap().put("type", t));
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
    // $ANTLR end "managementMetaPolicy"

    public static class policyRuleStructure_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyRuleStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:105:1: policyRuleStructure : ( ( policyContinuumLevel )? ecaPolicyRule | goalPolicyRule | utilityFunctionPolicyRule );
    public final polaGen.policyRuleStructure_return policyRuleStructure() throws RecognitionException {
        polaGen.policyRuleStructure_return retval = new polaGen.policyRuleStructure_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:105:26: ( ( policyContinuumLevel )? ecaPolicyRule | goalPolicyRule | utilityFunctionPolicyRule )
            int alt7=3;
            switch ( input.LA(1) ) {
            case POLA_PC_LEVEL:
            case POLA_RULE_STRUCT_ECA:
                {
                alt7=1;
                }
                break;
            case POLA_RULE_STRUCT_GOAL:
                {
                alt7=2;
                }
                break;
            case POLA_RULE_STRUCT_UTIL:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:105:28: ( policyContinuumLevel )? ecaPolicyRule
                    {
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:105:28: ( policyContinuumLevel )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==POLA_PC_LEVEL) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:105:29: policyContinuumLevel
                            {
                            pushFollow(FOLLOW_policyContinuumLevel_in_policyRuleStructure756);
                            policyContinuumLevel();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_ecaPolicyRule_in_policyRuleStructure760);
                    ecaPolicyRule();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:105:68: goalPolicyRule
                    {
                    pushFollow(FOLLOW_goalPolicyRule_in_policyRuleStructure764);
                    goalPolicyRule();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:105:85: utilityFunctionPolicyRule
                    {
                    pushFollow(FOLLOW_utilityFunctionPolicyRule_in_policyRuleStructure768);
                    utilityFunctionPolicyRule();

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
    // $ANTLR end "policyRuleStructure"

    public static class policyContinuumLevel_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyContinuumLevel"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:106:1: policyContinuumLevel : POLA_PC_LEVEL '=' ( 'business' | 'system' | 'administration' | 'device' 'instance' ) ';' ;
    public final polaGen.policyContinuumLevel_return policyContinuumLevel() throws RecognitionException {
        polaGen.policyContinuumLevel_return retval = new polaGen.policyContinuumLevel_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:106:26: ( POLA_PC_LEVEL '=' ( 'business' | 'system' | 'administration' | 'device' 'instance' ) ';' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:106:28: POLA_PC_LEVEL '=' ( 'business' | 'system' | 'administration' | 'device' 'instance' ) ';'
            {
            match(input,POLA_PC_LEVEL,FOLLOW_POLA_PC_LEVEL_in_policyContinuumLevel779); 
            match(input,87,FOLLOW_87_in_policyContinuumLevel781); 
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:106:46: ( 'business' | 'system' | 'administration' | 'device' 'instance' )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt8=1;
                }
                break;
            case 82:
                {
                alt8=2;
                }
                break;
            case 88:
                {
                alt8=3;
                }
                break;
            case 89:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:106:47: 'business'
                    {
                    match(input,81,FOLLOW_81_in_policyContinuumLevel784); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:106:60: 'system'
                    {
                    match(input,82,FOLLOW_82_in_policyContinuumLevel788); 

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:106:71: 'administration'
                    {
                    match(input,88,FOLLOW_88_in_policyContinuumLevel792); 

                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:106:90: 'device' 'instance'
                    {
                    match(input,89,FOLLOW_89_in_policyContinuumLevel796); 
                    match(input,90,FOLLOW_90_in_policyContinuumLevel798); 

                    }
                    break;

            }

            match(input,84,FOLLOW_84_in_policyContinuumLevel801); 

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
    // $ANTLR end "policyContinuumLevel"

    public static class ecaPolicyRule_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "ecaPolicyRule"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:108:1: ecaPolicyRule : ^( POLA_RULE_STRUCT_ECA ecaPolicyRuleBody ) ;
    public final polaGen.ecaPolicyRule_return ecaPolicyRule() throws RecognitionException {
        polaGen.ecaPolicyRule_return retval = new polaGen.ecaPolicyRule_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:108:26: ( ^( POLA_RULE_STRUCT_ECA ecaPolicyRuleBody ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:108:28: ^( POLA_RULE_STRUCT_ECA ecaPolicyRuleBody )
            {
            match(input,POLA_RULE_STRUCT_ECA,FOLLOW_POLA_RULE_STRUCT_ECA_in_ecaPolicyRule821); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                pushFollow(FOLLOW_ecaPolicyRuleBody_in_ecaPolicyRule823);
                ecaPolicyRuleBody();

                state._fsp--;


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
    // $ANTLR end "ecaPolicyRule"

    public static class ecaPolicyRuleBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "ecaPolicyRuleBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:109:1: ecaPolicyRuleBody : ( policyEventStructure )* ( policyConditionStructure )* ( policyActionStructure )* ;
    public final polaGen.ecaPolicyRuleBody_return ecaPolicyRuleBody() throws RecognitionException {
        polaGen.ecaPolicyRuleBody_return retval = new polaGen.ecaPolicyRuleBody_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:109:26: ( ( policyEventStructure )* ( policyConditionStructure )* ( policyActionStructure )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:109:28: ( policyEventStructure )* ( policyConditionStructure )* ( policyActionStructure )*
            {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:109:28: ( policyEventStructure )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==POLA_EVENT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:109:28: policyEventStructure
            	    {
            	    pushFollow(FOLLOW_policyEventStructure_in_ecaPolicyRuleBody838);
            	    policyEventStructure();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:109:50: ( policyConditionStructure )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==POLA_CONDITION) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:109:50: policyConditionStructure
            	    {
            	    pushFollow(FOLLOW_policyConditionStructure_in_ecaPolicyRuleBody841);
            	    policyConditionStructure();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:109:76: ( policyActionStructure )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==POLA_ACTION) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:109:76: policyActionStructure
            	    {
            	    pushFollow(FOLLOW_policyActionStructure_in_ecaPolicyRuleBody844);
            	    policyActionStructure();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


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
    // $ANTLR end "ecaPolicyRuleBody"

    public static class goalPolicyRule_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "goalPolicyRule"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:110:1: goalPolicyRule : POLA_RULE_STRUCT_GOAL ;
    public final polaGen.goalPolicyRule_return goalPolicyRule() throws RecognitionException {
        polaGen.goalPolicyRule_return retval = new polaGen.goalPolicyRule_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:110:26: ( POLA_RULE_STRUCT_GOAL )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:110:28: POLA_RULE_STRUCT_GOAL
            {
            match(input,POLA_RULE_STRUCT_GOAL,FOLLOW_POLA_RULE_STRUCT_GOAL_in_goalPolicyRule862); 

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
    // $ANTLR end "goalPolicyRule"

    public static class utilityFunctionPolicyRule_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "utilityFunctionPolicyRule"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:111:1: utilityFunctionPolicyRule : POLA_RULE_STRUCT_UTIL ;
    public final polaGen.utilityFunctionPolicyRule_return utilityFunctionPolicyRule() throws RecognitionException {
        polaGen.utilityFunctionPolicyRule_return retval = new polaGen.utilityFunctionPolicyRule_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:111:26: ( POLA_RULE_STRUCT_UTIL )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:111:28: POLA_RULE_STRUCT_UTIL
            {
            match(input,POLA_RULE_STRUCT_UTIL,FOLLOW_POLA_RULE_STRUCT_UTIL_in_utilityFunctionPolicyRule868); 

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
    // $ANTLR end "utilityFunctionPolicyRule"

    public static class policyRuleComponentStructure_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyRuleComponentStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:115:1: policyRuleComponentStructure : ( policyEventStructure | policyConditionStructure | policyActionStructure );
    public final polaGen.policyRuleComponentStructure_return policyRuleComponentStructure() throws RecognitionException {
        polaGen.policyRuleComponentStructure_return retval = new polaGen.policyRuleComponentStructure_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:115:29: ( policyEventStructure | policyConditionStructure | policyActionStructure )
            int alt12=3;
            switch ( input.LA(1) ) {
            case POLA_EVENT:
                {
                alt12=1;
                }
                break;
            case POLA_CONDITION:
                {
                alt12=2;
                }
                break;
            case POLA_ACTION:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:115:31: policyEventStructure
                    {
                    pushFollow(FOLLOW_policyEventStructure_in_policyRuleComponentStructure877);
                    policyEventStructure();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:115:54: policyConditionStructure
                    {
                    pushFollow(FOLLOW_policyConditionStructure_in_policyRuleComponentStructure881);
                    policyConditionStructure();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:115:81: policyActionStructure
                    {
                    pushFollow(FOLLOW_policyActionStructure_in_policyRuleComponentStructure885);
                    policyActionStructure();

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
    // $ANTLR end "policyRuleComponentStructure"

    public static class policyEventStructure_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyEventStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:117:1: policyEventStructure : POLA_EVENT ( policyEventStructureBody )* ;
    public final polaGen.policyEventStructure_return policyEventStructure() throws RecognitionException {
        polaGen.policyEventStructure_return retval = new polaGen.policyEventStructure_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:117:25: ( POLA_EVENT ( policyEventStructureBody )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:117:27: POLA_EVENT ( policyEventStructureBody )*
            {
            match(input,POLA_EVENT,FOLLOW_POLA_EVENT_in_policyEventStructure896); 
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:117:38: ( policyEventStructureBody )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==POLA_GROUP||LA13_0==BODY) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:117:38: policyEventStructureBody
            	    {
            	    pushFollow(FOLLOW_policyEventStructureBody_in_policyEventStructure898);
            	    policyEventStructureBody();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


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
    // $ANTLR end "policyEventStructure"

    public static class policyEventStructureBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyEventStructureBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:118:1: policyEventStructureBody : ( policyEventGroup | policyEvent );
    public final polaGen.policyEventStructureBody_return policyEventStructureBody() throws RecognitionException {
        polaGen.policyEventStructureBody_return retval = new polaGen.policyEventStructureBody_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:118:25: ( policyEventGroup | policyEvent )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:118:27: policyEventGroup
                    {
                    pushFollow(FOLLOW_policyEventGroup_in_policyEventStructureBody905);
                    policyEventGroup();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:118:46: policyEvent
                    {
                    pushFollow(FOLLOW_policyEvent_in_policyEventStructureBody909);
                    policyEvent();

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
    // $ANTLR end "policyEventStructureBody"

    public static class policyEventGroup_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyEventGroup"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:119:1: policyEventGroup : ^( POLA_GROUP IDENT ( policyEventGroupBody )* ) ;
    public final polaGen.policyEventGroup_return policyEventGroup() throws RecognitionException {
        polaGen.policyEventGroup_return retval = new polaGen.policyEventGroup_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:119:25: ( ^( POLA_GROUP IDENT ( policyEventGroupBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:119:27: ^( POLA_GROUP IDENT ( policyEventGroupBody )* )
            {
            match(input,POLA_GROUP,FOLLOW_POLA_GROUP_in_policyEventGroup924); 

            match(input, Token.DOWN, null); 
            match(input,IDENT,FOLLOW_IDENT_in_policyEventGroup926); 
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:119:46: ( policyEventGroupBody )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==POLA_GROUP||LA15_0==BODY) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:119:46: policyEventGroupBody
            	    {
            	    pushFollow(FOLLOW_policyEventGroupBody_in_policyEventGroup928);
            	    policyEventGroupBody();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


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
    // $ANTLR end "policyEventGroup"

    public static class policyEventGroupBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyEventGroupBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:120:1: policyEventGroupBody : ( policyEventGroup | policyEvent );
    public final polaGen.policyEventGroupBody_return policyEventGroupBody() throws RecognitionException {
        polaGen.policyEventGroupBody_return retval = new polaGen.policyEventGroupBody_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:120:25: ( policyEventGroup | policyEvent )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==POLA_GROUP) ) {
                alt16=1;
            }
            else if ( (LA16_0==BODY) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:120:27: policyEventGroup
                    {
                    pushFollow(FOLLOW_policyEventGroup_in_policyEventGroupBody940);
                    policyEventGroup();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:120:46: policyEvent
                    {
                    pushFollow(FOLLOW_policyEvent_in_policyEventGroupBody944);
                    policyEvent();

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
    // $ANTLR end "policyEventGroupBody"

    public static class policyEvent_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyEvent"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:121:1: policyEvent : ^( BODY ( policyEventBody )* ) ;
    public final polaGen.policyEvent_return policyEvent() throws RecognitionException {
        polaGen.policyEvent_return retval = new polaGen.policyEvent_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:121:25: ( ^( BODY ( policyEventBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:121:27: ^( BODY ( policyEventBody )* )
            {
            match(input,BODY,FOLLOW_BODY_in_policyEvent964); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:121:34: ( policyEventBody )*
                loop17:
                do {
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( ((LA17_0>=POLA_COMPOSITE && LA17_0<=POLA_NONSTD)) ) {
                        alt17=1;
                    }


                    switch (alt17) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:121:34: policyEventBody
                	    {
                	    pushFollow(FOLLOW_policyEventBody_in_policyEvent966);
                	    policyEventBody();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop17;
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
    // $ANTLR end "policyEvent"

    public static class policyEventBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyEventBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:122:1: policyEventBody : ( policyEventComposite | policyEventAtomic | policyEventNonStd );
    public final polaGen.policyEventBody_return policyEventBody() throws RecognitionException {
        polaGen.policyEventBody_return retval = new polaGen.policyEventBody_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:122:25: ( policyEventComposite | policyEventAtomic | policyEventNonStd )
            int alt18=3;
            switch ( input.LA(1) ) {
            case POLA_COMPOSITE:
                {
                alt18=1;
                }
                break;
            case POLA_ATOMIC:
                {
                alt18=2;
                }
                break;
            case POLA_NONSTD:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:122:27: policyEventComposite
                    {
                    pushFollow(FOLLOW_policyEventComposite_in_policyEventBody983);
                    policyEventComposite();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:122:50: policyEventAtomic
                    {
                    pushFollow(FOLLOW_policyEventAtomic_in_policyEventBody987);
                    policyEventAtomic();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:122:70: policyEventNonStd
                    {
                    pushFollow(FOLLOW_policyEventNonStd_in_policyEventBody991);
                    policyEventNonStd();

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
    // $ANTLR end "policyEventBody"

    public static class policyEventComposite_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyEventComposite"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:123:1: policyEventComposite : ^( POLA_COMPOSITE policyECAInherited ( policyEvent )* ) ;
    public final polaGen.policyEventComposite_return policyEventComposite() throws RecognitionException {
        polaGen.policyEventComposite_return retval = new polaGen.policyEventComposite_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:123:25: ( ^( POLA_COMPOSITE policyECAInherited ( policyEvent )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:123:27: ^( POLA_COMPOSITE policyECAInherited ( policyEvent )* )
            {
            match(input,POLA_COMPOSITE,FOLLOW_POLA_COMPOSITE_in_policyEventComposite1002); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_policyECAInherited_in_policyEventComposite1004);
            policyECAInherited();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:123:63: ( policyEvent )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==BODY) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:123:63: policyEvent
            	    {
            	    pushFollow(FOLLOW_policyEvent_in_policyEventComposite1006);
            	    policyEvent();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


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
    // $ANTLR end "policyEventComposite"

    public static class policyEventAtomic_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyEventAtomic"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:124:1: policyEventAtomic : POLA_ATOMIC policyECAInherited pola_string ;
    public final polaGen.policyEventAtomic_return policyEventAtomic() throws RecognitionException {
        polaGen.policyEventAtomic_return retval = new polaGen.policyEventAtomic_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:124:25: ( POLA_ATOMIC policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:124:27: POLA_ATOMIC policyECAInherited pola_string
            {
            match(input,POLA_ATOMIC,FOLLOW_POLA_ATOMIC_in_policyEventAtomic1021); 
            pushFollow(FOLLOW_policyECAInherited_in_policyEventAtomic1023);
            policyECAInherited();

            state._fsp--;

            pushFollow(FOLLOW_pola_string_in_policyEventAtomic1025);
            pola_string();

            state._fsp--;


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
    // $ANTLR end "policyEventAtomic"

    public static class policyEventNonStd_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyEventNonStd"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:125:1: policyEventNonStd : POLA_NONSTD policyECAInherited pola_string ;
    public final polaGen.policyEventNonStd_return policyEventNonStd() throws RecognitionException {
        polaGen.policyEventNonStd_return retval = new polaGen.policyEventNonStd_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:125:25: ( POLA_NONSTD policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:125:27: POLA_NONSTD policyECAInherited pola_string
            {
            match(input,POLA_NONSTD,FOLLOW_POLA_NONSTD_in_policyEventNonStd1038); 
            pushFollow(FOLLOW_policyECAInherited_in_policyEventNonStd1040);
            policyECAInherited();

            state._fsp--;

            pushFollow(FOLLOW_pola_string_in_policyEventNonStd1042);
            pola_string();

            state._fsp--;


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
    // $ANTLR end "policyEventNonStd"

    public static class policyConditionStructure_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyConditionStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:127:1: policyConditionStructure : POLA_CONDITION ( policyConditionStructureBody )* ;
    public final polaGen.policyConditionStructure_return policyConditionStructure() throws RecognitionException {
        polaGen.policyConditionStructure_return retval = new polaGen.policyConditionStructure_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:127:29: ( POLA_CONDITION ( policyConditionStructureBody )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:127:31: POLA_CONDITION ( policyConditionStructureBody )*
            {
            match(input,POLA_CONDITION,FOLLOW_POLA_CONDITION_in_policyConditionStructure1053); 
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:127:46: ( policyConditionStructureBody )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==POLA_GROUP||LA20_0==BODY) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:127:46: policyConditionStructureBody
            	    {
            	    pushFollow(FOLLOW_policyConditionStructureBody_in_policyConditionStructure1055);
            	    policyConditionStructureBody();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


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
    // $ANTLR end "policyConditionStructure"

    public static class policyConditionStructureBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyConditionStructureBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:128:1: policyConditionStructureBody : ( policyConditionGroup | policyCondition );
    public final polaGen.policyConditionStructureBody_return policyConditionStructureBody() throws RecognitionException {
        polaGen.policyConditionStructureBody_return retval = new polaGen.policyConditionStructureBody_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:128:29: ( policyConditionGroup | policyCondition )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:128:31: policyConditionGroup
                    {
                    pushFollow(FOLLOW_policyConditionGroup_in_policyConditionStructureBody1062);
                    policyConditionGroup();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:128:54: policyCondition
                    {
                    pushFollow(FOLLOW_policyCondition_in_policyConditionStructureBody1066);
                    policyCondition();

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
    // $ANTLR end "policyConditionStructureBody"

    public static class policyConditionGroup_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyConditionGroup"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:129:1: policyConditionGroup : ^( POLA_GROUP IDENT ( policyConditionGroupBody )* ) ;
    public final polaGen.policyConditionGroup_return policyConditionGroup() throws RecognitionException {
        polaGen.policyConditionGroup_return retval = new polaGen.policyConditionGroup_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:129:29: ( ^( POLA_GROUP IDENT ( policyConditionGroupBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:129:31: ^( POLA_GROUP IDENT ( policyConditionGroupBody )* )
            {
            match(input,POLA_GROUP,FOLLOW_POLA_GROUP_in_policyConditionGroup1081); 

            match(input, Token.DOWN, null); 
            match(input,IDENT,FOLLOW_IDENT_in_policyConditionGroup1083); 
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:129:50: ( policyConditionGroupBody )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==POLA_GROUP||LA22_0==BODY) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:129:50: policyConditionGroupBody
            	    {
            	    pushFollow(FOLLOW_policyConditionGroupBody_in_policyConditionGroup1085);
            	    policyConditionGroupBody();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


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
    // $ANTLR end "policyConditionGroup"

    public static class policyConditionGroupBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyConditionGroupBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:130:1: policyConditionGroupBody : ( policyConditionGroup | policyCondition );
    public final polaGen.policyConditionGroupBody_return policyConditionGroupBody() throws RecognitionException {
        polaGen.policyConditionGroupBody_return retval = new polaGen.policyConditionGroupBody_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:130:29: ( policyConditionGroup | policyCondition )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==POLA_GROUP) ) {
                alt23=1;
            }
            else if ( (LA23_0==BODY) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:130:31: policyConditionGroup
                    {
                    pushFollow(FOLLOW_policyConditionGroup_in_policyConditionGroupBody1097);
                    policyConditionGroup();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:130:54: policyCondition
                    {
                    pushFollow(FOLLOW_policyCondition_in_policyConditionGroupBody1101);
                    policyCondition();

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
    // $ANTLR end "policyConditionGroupBody"

    public static class policyCondition_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyCondition"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:131:1: policyCondition : ^( BODY ( policyConditionBody )* ) ;
    public final polaGen.policyCondition_return policyCondition() throws RecognitionException {
        polaGen.policyCondition_return retval = new polaGen.policyCondition_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:131:29: ( ^( BODY ( policyConditionBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:131:31: ^( BODY ( policyConditionBody )* )
            {
            match(input,BODY,FOLLOW_BODY_in_policyCondition1121); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:131:38: ( policyConditionBody )*
                loop24:
                do {
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( ((LA24_0>=POLA_COMPOSITE && LA24_0<=POLA_NONSTD)) ) {
                        alt24=1;
                    }


                    switch (alt24) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:131:38: policyConditionBody
                	    {
                	    pushFollow(FOLLOW_policyConditionBody_in_policyCondition1123);
                	    policyConditionBody();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop24;
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
    // $ANTLR end "policyCondition"

    public static class policyConditionBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyConditionBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:132:1: policyConditionBody : ( policyConditionComposite | policyConditionAtomic | policyConditionNonStd );
    public final polaGen.policyConditionBody_return policyConditionBody() throws RecognitionException {
        polaGen.policyConditionBody_return retval = new polaGen.policyConditionBody_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:132:29: ( policyConditionComposite | policyConditionAtomic | policyConditionNonStd )
            int alt25=3;
            switch ( input.LA(1) ) {
            case POLA_COMPOSITE:
                {
                alt25=1;
                }
                break;
            case POLA_ATOMIC:
                {
                alt25=2;
                }
                break;
            case POLA_NONSTD:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:132:31: policyConditionComposite
                    {
                    pushFollow(FOLLOW_policyConditionComposite_in_policyConditionBody1140);
                    policyConditionComposite();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:132:58: policyConditionAtomic
                    {
                    pushFollow(FOLLOW_policyConditionAtomic_in_policyConditionBody1144);
                    policyConditionAtomic();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:132:82: policyConditionNonStd
                    {
                    pushFollow(FOLLOW_policyConditionNonStd_in_policyConditionBody1148);
                    policyConditionNonStd();

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
    // $ANTLR end "policyConditionBody"

    public static class policyConditionComposite_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyConditionComposite"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:133:1: policyConditionComposite : ^( POLA_COMPOSITE policyECAInherited ( policyCondition )* ) ;
    public final polaGen.policyConditionComposite_return policyConditionComposite() throws RecognitionException {
        polaGen.policyConditionComposite_return retval = new polaGen.policyConditionComposite_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:133:29: ( ^( POLA_COMPOSITE policyECAInherited ( policyCondition )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:133:31: ^( POLA_COMPOSITE policyECAInherited ( policyCondition )* )
            {
            match(input,POLA_COMPOSITE,FOLLOW_POLA_COMPOSITE_in_policyConditionComposite1159); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_policyECAInherited_in_policyConditionComposite1161);
            policyECAInherited();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:133:67: ( policyCondition )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==BODY) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:133:67: policyCondition
            	    {
            	    pushFollow(FOLLOW_policyCondition_in_policyConditionComposite1163);
            	    policyCondition();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


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
    // $ANTLR end "policyConditionComposite"

    public static class policyConditionAtomic_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyConditionAtomic"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:134:1: policyConditionAtomic : POLA_ATOMIC policyECAInherited pola_string ;
    public final polaGen.policyConditionAtomic_return policyConditionAtomic() throws RecognitionException {
        polaGen.policyConditionAtomic_return retval = new polaGen.policyConditionAtomic_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:134:29: ( POLA_ATOMIC policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:134:31: POLA_ATOMIC policyECAInherited pola_string
            {
            match(input,POLA_ATOMIC,FOLLOW_POLA_ATOMIC_in_policyConditionAtomic1178); 
            pushFollow(FOLLOW_policyECAInherited_in_policyConditionAtomic1180);
            policyECAInherited();

            state._fsp--;

            pushFollow(FOLLOW_pola_string_in_policyConditionAtomic1182);
            pola_string();

            state._fsp--;


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
    // $ANTLR end "policyConditionAtomic"

    public static class policyConditionNonStd_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyConditionNonStd"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:135:1: policyConditionNonStd : POLA_NONSTD policyECAInherited pola_string ;
    public final polaGen.policyConditionNonStd_return policyConditionNonStd() throws RecognitionException {
        polaGen.policyConditionNonStd_return retval = new polaGen.policyConditionNonStd_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:135:29: ( POLA_NONSTD policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:135:31: POLA_NONSTD policyECAInherited pola_string
            {
            match(input,POLA_NONSTD,FOLLOW_POLA_NONSTD_in_policyConditionNonStd1195); 
            pushFollow(FOLLOW_policyECAInherited_in_policyConditionNonStd1197);
            policyECAInherited();

            state._fsp--;

            pushFollow(FOLLOW_pola_string_in_policyConditionNonStd1199);
            pola_string();

            state._fsp--;


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
    // $ANTLR end "policyConditionNonStd"

    public static class policyActionStructure_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyActionStructure"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:137:1: policyActionStructure : POLA_ACTION ( policyActionStructureBody )* ;
    public final polaGen.policyActionStructure_return policyActionStructure() throws RecognitionException {
        polaGen.policyActionStructure_return retval = new polaGen.policyActionStructure_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:137:26: ( POLA_ACTION ( policyActionStructureBody )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:137:28: POLA_ACTION ( policyActionStructureBody )*
            {
            match(input,POLA_ACTION,FOLLOW_POLA_ACTION_in_policyActionStructure1210); 
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:137:40: ( policyActionStructureBody )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==POLA_GROUP||LA27_0==BODY) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:137:40: policyActionStructureBody
            	    {
            	    pushFollow(FOLLOW_policyActionStructureBody_in_policyActionStructure1212);
            	    policyActionStructureBody();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


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
    // $ANTLR end "policyActionStructure"

    public static class policyActionStructureBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyActionStructureBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:138:1: policyActionStructureBody : ( policyActionGroup | policyAction );
    public final polaGen.policyActionStructureBody_return policyActionStructureBody() throws RecognitionException {
        polaGen.policyActionStructureBody_return retval = new polaGen.policyActionStructureBody_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:138:26: ( policyActionGroup | policyAction )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:138:28: policyActionGroup
                    {
                    pushFollow(FOLLOW_policyActionGroup_in_policyActionStructureBody1219);
                    policyActionGroup();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:138:48: policyAction
                    {
                    pushFollow(FOLLOW_policyAction_in_policyActionStructureBody1223);
                    policyAction();

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
    // $ANTLR end "policyActionStructureBody"

    public static class policyActionGroup_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyActionGroup"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:139:1: policyActionGroup : ^( POLA_GROUP IDENT ( policyActionGroupBody )* ) ;
    public final polaGen.policyActionGroup_return policyActionGroup() throws RecognitionException {
        polaGen.policyActionGroup_return retval = new polaGen.policyActionGroup_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:139:26: ( ^( POLA_GROUP IDENT ( policyActionGroupBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:139:28: ^( POLA_GROUP IDENT ( policyActionGroupBody )* )
            {
            match(input,POLA_GROUP,FOLLOW_POLA_GROUP_in_policyActionGroup1238); 

            match(input, Token.DOWN, null); 
            match(input,IDENT,FOLLOW_IDENT_in_policyActionGroup1240); 
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:139:47: ( policyActionGroupBody )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==POLA_GROUP||LA29_0==BODY) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:139:47: policyActionGroupBody
            	    {
            	    pushFollow(FOLLOW_policyActionGroupBody_in_policyActionGroup1242);
            	    policyActionGroupBody();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


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
    // $ANTLR end "policyActionGroup"

    public static class policyActionGroupBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyActionGroupBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:140:1: policyActionGroupBody : ( policyActionGroup | policyAction );
    public final polaGen.policyActionGroupBody_return policyActionGroupBody() throws RecognitionException {
        polaGen.policyActionGroupBody_return retval = new polaGen.policyActionGroupBody_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:140:26: ( policyActionGroup | policyAction )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==POLA_GROUP) ) {
                alt30=1;
            }
            else if ( (LA30_0==BODY) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:140:28: policyActionGroup
                    {
                    pushFollow(FOLLOW_policyActionGroup_in_policyActionGroupBody1254);
                    policyActionGroup();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:140:48: policyAction
                    {
                    pushFollow(FOLLOW_policyAction_in_policyActionGroupBody1258);
                    policyAction();

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
    // $ANTLR end "policyActionGroupBody"

    public static class policyAction_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyAction"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:141:1: policyAction : ^( BODY ( policyActionBody )* ) ;
    public final polaGen.policyAction_return policyAction() throws RecognitionException {
        polaGen.policyAction_return retval = new polaGen.policyAction_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:141:26: ( ^( BODY ( policyActionBody )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:141:28: ^( BODY ( policyActionBody )* )
            {
            match(input,BODY,FOLLOW_BODY_in_policyAction1278); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:141:35: ( policyActionBody )*
                loop31:
                do {
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0>=POLA_COMPOSITE && LA31_0<=POLA_NONSTD)) ) {
                        alt31=1;
                    }


                    switch (alt31) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:141:35: policyActionBody
                	    {
                	    pushFollow(FOLLOW_policyActionBody_in_policyAction1280);
                	    policyActionBody();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop31;
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
    // $ANTLR end "policyAction"

    public static class policyActionBody_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyActionBody"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:142:1: policyActionBody : ( policyActionComposite | policyActionAtomic | policyActionNonStd );
    public final polaGen.policyActionBody_return policyActionBody() throws RecognitionException {
        polaGen.policyActionBody_return retval = new polaGen.policyActionBody_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:142:26: ( policyActionComposite | policyActionAtomic | policyActionNonStd )
            int alt32=3;
            switch ( input.LA(1) ) {
            case POLA_COMPOSITE:
                {
                alt32=1;
                }
                break;
            case POLA_ATOMIC:
                {
                alt32=2;
                }
                break;
            case POLA_NONSTD:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:142:28: policyActionComposite
                    {
                    pushFollow(FOLLOW_policyActionComposite_in_policyActionBody1297);
                    policyActionComposite();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:142:52: policyActionAtomic
                    {
                    pushFollow(FOLLOW_policyActionAtomic_in_policyActionBody1301);
                    policyActionAtomic();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:142:73: policyActionNonStd
                    {
                    pushFollow(FOLLOW_policyActionNonStd_in_policyActionBody1305);
                    policyActionNonStd();

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
    // $ANTLR end "policyActionBody"

    public static class policyActionComposite_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyActionComposite"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:143:1: policyActionComposite : ^( POLA_COMPOSITE policyECAInherited ( policyAction )* ) ;
    public final polaGen.policyActionComposite_return policyActionComposite() throws RecognitionException {
        polaGen.policyActionComposite_return retval = new polaGen.policyActionComposite_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:143:26: ( ^( POLA_COMPOSITE policyECAInherited ( policyAction )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:143:28: ^( POLA_COMPOSITE policyECAInherited ( policyAction )* )
            {
            match(input,POLA_COMPOSITE,FOLLOW_POLA_COMPOSITE_in_policyActionComposite1316); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_policyECAInherited_in_policyActionComposite1318);
            policyECAInherited();

            state._fsp--;

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:143:64: ( policyAction )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==BODY) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:143:64: policyAction
            	    {
            	    pushFollow(FOLLOW_policyAction_in_policyActionComposite1320);
            	    policyAction();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


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
    // $ANTLR end "policyActionComposite"

    public static class policyActionAtomic_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyActionAtomic"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:144:1: policyActionAtomic : POLA_ATOMIC policyECAInherited pola_string ;
    public final polaGen.policyActionAtomic_return policyActionAtomic() throws RecognitionException {
        polaGen.policyActionAtomic_return retval = new polaGen.policyActionAtomic_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:144:26: ( POLA_ATOMIC policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:144:28: POLA_ATOMIC policyECAInherited pola_string
            {
            match(input,POLA_ATOMIC,FOLLOW_POLA_ATOMIC_in_policyActionAtomic1335); 
            pushFollow(FOLLOW_policyECAInherited_in_policyActionAtomic1337);
            policyECAInherited();

            state._fsp--;

            pushFollow(FOLLOW_pola_string_in_policyActionAtomic1339);
            pola_string();

            state._fsp--;


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
    // $ANTLR end "policyActionAtomic"

    public static class policyActionNonStd_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyActionNonStd"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:145:1: policyActionNonStd : POLA_NONSTD policyECAInherited pola_string ;
    public final polaGen.policyActionNonStd_return policyActionNonStd() throws RecognitionException {
        polaGen.policyActionNonStd_return retval = new polaGen.policyActionNonStd_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:145:26: ( POLA_NONSTD policyECAInherited pola_string )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:145:28: POLA_NONSTD policyECAInherited pola_string
            {
            match(input,POLA_NONSTD,FOLLOW_POLA_NONSTD_in_policyActionNonStd1352); 
            pushFollow(FOLLOW_policyECAInherited_in_policyActionNonStd1354);
            policyECAInherited();

            state._fsp--;

            pushFollow(FOLLOW_pola_string_in_policyActionNonStd1356);
            pola_string();

            state._fsp--;


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
    // $ANTLR end "policyActionNonStd"

    public static class policyECAInherited_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "policyECAInherited"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:147:1: policyECAInherited : ^( POLA_SEQ_NUMER VAL_INTEGER ) ^( POLA_HASBEEN_EVALED boolean_value ) ;
    public final polaGen.policyECAInherited_return policyECAInherited() throws RecognitionException {
        polaGen.policyECAInherited_return retval = new polaGen.policyECAInherited_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:147:23: ( ^( POLA_SEQ_NUMER VAL_INTEGER ) ^( POLA_HASBEEN_EVALED boolean_value ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:147:25: ^( POLA_SEQ_NUMER VAL_INTEGER ) ^( POLA_HASBEEN_EVALED boolean_value )
            {
            match(input,POLA_SEQ_NUMER,FOLLOW_POLA_SEQ_NUMER_in_policyECAInherited1368); 

            match(input, Token.DOWN, null); 
            match(input,VAL_INTEGER,FOLLOW_VAL_INTEGER_in_policyECAInherited1370); 

            match(input, Token.UP, null); 
            match(input,POLA_HASBEEN_EVALED,FOLLOW_POLA_HASBEEN_EVALED_in_policyECAInherited1374); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_boolean_value_in_policyECAInherited1376);
            boolean_value();

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
    // $ANTLR end "policyECAInherited"

    public static class pola_string_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "pola_string"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:149:1: pola_string : VAL_DSTRING ;
    public final polaGen.pola_string_return pola_string() throws RecognitionException {
        polaGen.pola_string_return retval = new polaGen.pola_string_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:149:25: ( VAL_DSTRING )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:149:27: VAL_DSTRING
            {
            match(input,VAL_DSTRING,FOLLOW_VAL_DSTRING_in_pola_string1397); 

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
    // $ANTLR end "pola_string"

    public static class scoped_name_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "scoped_name"
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:151:1: scoped_name : ^( AT_SCOPE (id+= IDENT )* ) -> scoped_name(id=$idadd=this.pass.scopeTgtLangAdd());
    public final polaGen.scoped_name_return scoped_name() throws RecognitionException {
        polaGen.scoped_name_return retval = new polaGen.scoped_name_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List list_id=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:151:25: ( ^( AT_SCOPE (id+= IDENT )* ) -> scoped_name(id=$idadd=this.pass.scopeTgtLangAdd()))
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:151:27: ^( AT_SCOPE (id+= IDENT )* )
            {
            this.pass.sn.clear();
            match(input,AT_SCOPE,FOLLOW_AT_SCOPE_in_scoped_name1446); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:152:38: (id+= IDENT )*
                loop34:
                do {
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==IDENT) ) {
                        alt34=1;
                    }


                    switch (alt34) {
                	case 1 :
                	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:152:39: id+= IDENT
                	    {
                	    id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_scoped_name1451); 
                	    if (list_id==null) list_id=new ArrayList();
                	    list_id.add(id);

                	    this.pass.sn.push(id.token);

                	    }
                	    break;

                	default :
                	    break loop34;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            // TEMPLATE REWRITE
            // 152:83: -> scoped_name(id=$idadd=this.pass.scopeTgtLangAdd())
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
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:154:1: void_type : t= VOID -> template(token=$t) \"<token>\";
    public final polaGen.void_type_return void_type() throws RecognitionException {
        polaGen.void_type_return retval = new polaGen.void_type_return();
        retval.start = input.LT(1);

        CommonTree t=null;

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:154:25: (t= VOID -> template(token=$t) \"<token>\")
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:154:27: t= VOID
            {
            t=(CommonTree)match(input,VOID,FOLLOW_VOID_in_void_type1494); 


            // TEMPLATE REWRITE
            // 154:34: -> template(token=$t) \"<token>\"
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
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:155:1: simple_type : (sc= scoped_name | bt= base_type ) ( ARRAY )? ;
    public final polaGen.simple_type_return simple_type() throws RecognitionException {
        polaGen.simple_type_return retval = new polaGen.simple_type_return();
        retval.start = input.LT(1);

        CommonTree ARRAY2=null;
        polaGen.scoped_name_return sc = null;

        polaGen.base_type_return bt = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:155:25: ( (sc= scoped_name | bt= base_type ) ( ARRAY )? )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:155:27: (sc= scoped_name | bt= base_type ) ( ARRAY )?
            {
            this.pass.simple_typeClear();
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:156:27: (sc= scoped_name | bt= base_type )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==AT_SCOPE) ) {
                alt35=1;
            }
            else if ( ((LA35_0>=SHORT && LA35_0<=BOOLEAN)) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:156:28: sc= scoped_name
                    {
                    pushFollow(FOLLOW_scoped_name_in_simple_type1555);
                    sc=scoped_name();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:156:45: bt= base_type
                    {
                    pushFollow(FOLLOW_base_type_in_simple_type1561);
                    bt=base_type();

                    state._fsp--;


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:156:59: ( ARRAY )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==ARRAY) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:156:59: ARRAY
                    {
                    ARRAY2=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_simple_type1564); 

                    }
                    break;

            }

            this.pass.simple_type((sc!=null?sc.st:null),(bt!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(bt.start),
              input.getTreeAdaptor().getTokenStopIndex(bt.start))):null),(ARRAY2!=null?ARRAY2.getText():null));

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
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:158:1: base_type : ( SHORT | INTEGER | LONG | OCTET | HEX | BINARY | FLOAT | DOUBLE | CHAR | STRING | BOOLEAN );
    public final polaGen.base_type_return base_type() throws RecognitionException {
        polaGen.base_type_return retval = new polaGen.base_type_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:158:25: ( SHORT | INTEGER | LONG | OCTET | HEX | BINARY | FLOAT | DOUBLE | CHAR | STRING | BOOLEAN )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:
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
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:160:1: const_value : ( ^( AT_PROVIDES type= INTEGER cv= VAL_INTEGER ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= OCTET cv= VAL_OCT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= HEX cv= VAL_HEX ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= BINARY cv= VAL_BINARY ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= FLOAT cv= VAL_FLOAT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= CHAR cv= VAL_CHAR ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= STRING string_value ) -> const_value(type=$type.textval=$string_value.text) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) -> const_value(type=$type.textval=$boolean_value.text));
    public final polaGen.const_value_return const_value() throws RecognitionException {
        polaGen.const_value_return retval = new polaGen.const_value_return();
        retval.start = input.LT(1);

        CommonTree type=null;
        CommonTree cv=null;
        polaGen.string_value_return string_value3 = null;

        polaGen.boolean_value_return boolean_value4 = null;


        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:160:25: ( ^( AT_PROVIDES type= INTEGER cv= VAL_INTEGER ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= OCTET cv= VAL_OCT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= HEX cv= VAL_HEX ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= BINARY cv= VAL_BINARY ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= FLOAT cv= VAL_FLOAT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= CHAR cv= VAL_CHAR ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= STRING string_value ) -> const_value(type=$type.textval=$string_value.text) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) -> const_value(type=$type.textval=$boolean_value.text))
            int alt37=8;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:160:27: ^( AT_PROVIDES type= INTEGER cv= VAL_INTEGER )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1675); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_const_value1679); 
                    cv=(CommonTree)match(input,VAL_INTEGER,FOLLOW_VAL_INTEGER_in_const_value1683); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 160:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:161:27: ^( AT_PROVIDES type= OCTET cv= VAL_OCT )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1729); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,OCTET,FOLLOW_OCTET_in_const_value1733); 
                    cv=(CommonTree)match(input,VAL_OCT,FOLLOW_VAL_OCT_in_const_value1739); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 161:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:162:27: ^( AT_PROVIDES type= HEX cv= VAL_HEX )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1789); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,HEX,FOLLOW_HEX_in_const_value1793); 
                    cv=(CommonTree)match(input,VAL_HEX,FOLLOW_VAL_HEX_in_const_value1801); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 162:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:163:27: ^( AT_PROVIDES type= BINARY cv= VAL_BINARY )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1851); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,BINARY,FOLLOW_BINARY_in_const_value1855); 
                    cv=(CommonTree)match(input,VAL_BINARY,FOLLOW_VAL_BINARY_in_const_value1860); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 163:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:164:27: ^( AT_PROVIDES type= FLOAT cv= VAL_FLOAT )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1907); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_const_value1911); 
                    cv=(CommonTree)match(input,VAL_FLOAT,FOLLOW_VAL_FLOAT_in_const_value1917); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 164:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:165:27: ^( AT_PROVIDES type= CHAR cv= VAL_CHAR )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value1965); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,CHAR,FOLLOW_CHAR_in_const_value1969); 
                    cv=(CommonTree)match(input,VAL_CHAR,FOLLOW_VAL_CHAR_in_const_value1976); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 165:70: -> const_value(type=$type.textval=$cv.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (cv!=null?cv.getText():null)));
                    }


                    }
                    break;
                case 7 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:166:27: ^( AT_PROVIDES type= STRING string_value )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value2025); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,STRING,FOLLOW_STRING_in_const_value2029); 
                    pushFollow(FOLLOW_string_value_in_const_value2032);
                    string_value3=string_value();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 166:70: -> const_value(type=$type.textval=$string_value.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (string_value3!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(string_value3.start),
                      input.getTreeAdaptor().getTokenStopIndex(string_value3.start))):null)));
                    }


                    }
                    break;
                case 8 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:167:27: ^( AT_PROVIDES type= BOOLEAN boolean_value )
                    {
                    match(input,AT_PROVIDES,FOLLOW_AT_PROVIDES_in_const_value2080); 

                    match(input, Token.DOWN, null); 
                    type=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_const_value2084); 
                    pushFollow(FOLLOW_boolean_value_in_const_value2086);
                    boolean_value4=boolean_value();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 167:70: -> const_value(type=$type.textval=$boolean_value.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_value",
                      new STAttrMap().put("type", (type!=null?type.getText():null)).put("val", (boolean_value4!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(boolean_value4.start),
                      input.getTreeAdaptor().getTokenStopIndex(boolean_value4.start))):null)));
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
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:168:1: string_value : ( VAL_STRING | POLA_NULL ) ;
    public final polaGen.string_value_return string_value() throws RecognitionException {
        polaGen.string_value_return retval = new polaGen.string_value_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:168:25: ( ( VAL_STRING | POLA_NULL ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:168:27: ( VAL_STRING | POLA_NULL )
            {
            if ( (input.LA(1)>=VAL_STRING && input.LA(1)<=POLA_NULL) ) {
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
    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:169:1: boolean_value : ( POLA_TRUE | POLA_FALSE ) ;
    public final polaGen.boolean_value_return boolean_value() throws RecognitionException {
        polaGen.boolean_value_return retval = new polaGen.boolean_value_return();
        retval.start = input.LT(1);

        try {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:169:25: ( ( POLA_TRUE | POLA_FALSE ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaGen.g:169:27: ( POLA_TRUE | POLA_FALSE )
            {
            if ( (input.LA(1)>=POLA_TRUE && input.LA(1)<=POLA_FALSE) ) {
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

    // Delegated rules


    protected DFA37 dfa37 = new DFA37(this);
    static final String DFA37_eotS =
        "\13\uffff";
    static final String DFA37_eofS =
        "\13\uffff";
    static final String DFA37_minS =
        "\1\72\1\2\1\43\10\uffff";
    static final String DFA37_maxS =
        "\1\72\1\2\1\54\10\uffff";
    static final String DFA37_acceptS =
        "\3\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10";
    static final String DFA37_specialS =
        "\13\uffff}>";
    static final String[] DFA37_transitionS = {
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

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "160:1: const_value : ( ^( AT_PROVIDES type= INTEGER cv= VAL_INTEGER ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= OCTET cv= VAL_OCT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= HEX cv= VAL_HEX ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= BINARY cv= VAL_BINARY ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= FLOAT cv= VAL_FLOAT ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= CHAR cv= VAL_CHAR ) -> const_value(type=$type.textval=$cv.text) | ^( AT_PROVIDES type= STRING string_value ) -> const_value(type=$type.textval=$string_value.text) | ^( AT_PROVIDES type= BOOLEAN boolean_value ) -> const_value(type=$type.textval=$boolean_value.text));";
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
    public static final BitSet FOLLOW_AT_SPEC_in_polaSpecification225 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_polaSpecification229 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cpp_directive_in_polaSpecification288 = new BitSet(new long[]{0x0000000000000C08L});
    public static final BitSet FOLLOW_polaDefinition_in_polaSpecification293 = new BitSet(new long[]{0x0000000000000C08L});
    public static final BitSet FOLLOW_managementPolicy_in_polaDefinition381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cpp_directive_in_polaDefinition424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CPP_DIRECTIVE_in_cpp_directive469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_POLICY_in_managementPolicy485 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_managementPolicy489 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_managementPolicyType_in_managementPolicy495 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_policyRuleStructure_in_managementPolicy499 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_deonticPolicy_in_managementPolicyType557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_managementMetaPolicy_in_managementPolicyType600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_DEONT_AUTH_in_deonticPolicy631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_DEONT_EXEM_in_deonticPolicy637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_DEONT_OBLG_in_deonticPolicy643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_DEONT_PROH_in_deonticPolicy649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_MEPO_DELE_in_managementMetaPolicy698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_MEPO_REVO_in_managementMetaPolicy704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyContinuumLevel_in_policyRuleStructure756 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_ecaPolicyRule_in_policyRuleStructure760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalPolicyRule_in_policyRuleStructure764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_utilityFunctionPolicyRule_in_policyRuleStructure768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_PC_LEVEL_in_policyContinuumLevel779 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_policyContinuumLevel781 = new BitSet(new long[]{0x0000000000000000L,0x0000000003060000L});
    public static final BitSet FOLLOW_81_in_policyContinuumLevel784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_82_in_policyContinuumLevel788 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_88_in_policyContinuumLevel792 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_89_in_policyContinuumLevel796 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_policyContinuumLevel798 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_policyContinuumLevel801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_RULE_STRUCT_ECA_in_ecaPolicyRule821 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ecaPolicyRuleBody_in_ecaPolicyRule823 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_policyEventStructure_in_ecaPolicyRuleBody838 = new BitSet(new long[]{0x0000000018400002L});
    public static final BitSet FOLLOW_policyConditionStructure_in_ecaPolicyRuleBody841 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_policyActionStructure_in_ecaPolicyRuleBody844 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_POLA_RULE_STRUCT_GOAL_in_goalPolicyRule862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_RULE_STRUCT_UTIL_in_utilityFunctionPolicyRule868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventStructure_in_policyRuleComponentStructure877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionStructure_in_policyRuleComponentStructure881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionStructure_in_policyRuleComponentStructure885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_EVENT_in_policyEventStructure896 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyEventStructureBody_in_policyEventStructure898 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyEventGroup_in_policyEventStructureBody905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEvent_in_policyEventStructureBody909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_GROUP_in_policyEventGroup924 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_policyEventGroup926 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyEventGroupBody_in_policyEventGroup928 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyEventGroup_in_policyEventGroupBody940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEvent_in_policyEventGroupBody944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_in_policyEvent964 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyEventBody_in_policyEvent966 = new BitSet(new long[]{0x0000000007000008L});
    public static final BitSet FOLLOW_policyEventComposite_in_policyEventBody983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventAtomic_in_policyEventBody987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyEventNonStd_in_policyEventBody991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_COMPOSITE_in_policyEventComposite1002 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyEventComposite1004 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyEvent_in_policyEventComposite1006 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_POLA_ATOMIC_in_policyEventAtomic1021 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyEventAtomic1023 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyEventAtomic1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_NONSTD_in_policyEventNonStd1038 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyEventNonStd1040 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyEventNonStd1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_CONDITION_in_policyConditionStructure1053 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyConditionStructureBody_in_policyConditionStructure1055 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyConditionGroup_in_policyConditionStructureBody1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyCondition_in_policyConditionStructureBody1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_GROUP_in_policyConditionGroup1081 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_policyConditionGroup1083 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyConditionGroupBody_in_policyConditionGroup1085 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyConditionGroup_in_policyConditionGroupBody1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyCondition_in_policyConditionGroupBody1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_in_policyCondition1121 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyConditionBody_in_policyCondition1123 = new BitSet(new long[]{0x0000000007000008L});
    public static final BitSet FOLLOW_policyConditionComposite_in_policyConditionBody1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionAtomic_in_policyConditionBody1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyConditionNonStd_in_policyConditionBody1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_COMPOSITE_in_policyConditionComposite1159 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyConditionComposite1161 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyCondition_in_policyConditionComposite1163 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_POLA_ATOMIC_in_policyConditionAtomic1178 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyConditionAtomic1180 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyConditionAtomic1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_NONSTD_in_policyConditionNonStd1195 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyConditionNonStd1197 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyConditionNonStd1199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_ACTION_in_policyActionStructure1210 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyActionStructureBody_in_policyActionStructure1212 = new BitSet(new long[]{0x0080000000800002L});
    public static final BitSet FOLLOW_policyActionGroup_in_policyActionStructureBody1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyAction_in_policyActionStructureBody1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_GROUP_in_policyActionGroup1238 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_policyActionGroup1240 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyActionGroupBody_in_policyActionGroup1242 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyActionGroup_in_policyActionGroupBody1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyAction_in_policyActionGroupBody1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_in_policyAction1278 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyActionBody_in_policyAction1280 = new BitSet(new long[]{0x0000000007000008L});
    public static final BitSet FOLLOW_policyActionComposite_in_policyActionBody1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionAtomic_in_policyActionBody1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_policyActionNonStd_in_policyActionBody1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_COMPOSITE_in_policyActionComposite1316 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyActionComposite1318 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_policyAction_in_policyActionComposite1320 = new BitSet(new long[]{0x0080000000800008L});
    public static final BitSet FOLLOW_POLA_ATOMIC_in_policyActionAtomic1335 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyActionAtomic1337 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyActionAtomic1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_NONSTD_in_policyActionNonStd1352 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_policyECAInherited_in_policyActionNonStd1354 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pola_string_in_policyActionNonStd1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POLA_SEQ_NUMER_in_policyECAInherited1368 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VAL_INTEGER_in_policyECAInherited1370 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POLA_HASBEEN_EVALED_in_policyECAInherited1374 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolean_value_in_policyECAInherited1376 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VAL_DSTRING_in_pola_string1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_SCOPE_in_scoped_name1446 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_scoped_name1451 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_VOID_in_void_type1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_name_in_simple_type1555 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_base_type_in_simple_type1561 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_simple_type1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_base_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1675 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_const_value1679 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_VAL_INTEGER_in_const_value1683 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1729 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OCTET_in_const_value1733 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_VAL_OCT_in_const_value1739 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1789 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_HEX_in_const_value1793 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_VAL_HEX_in_const_value1801 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1851 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BINARY_in_const_value1855 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_VAL_BINARY_in_const_value1860 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1907 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FLOAT_in_const_value1911 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_VAL_FLOAT_in_const_value1917 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value1965 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_in_const_value1969 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_VAL_CHAR_in_const_value1976 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value2025 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_const_value2029 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_string_value_in_const_value2032 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_PROVIDES_in_const_value2080 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOLEAN_in_const_value2084 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_boolean_value_in_const_value2086 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_string_value2120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_boolean_value2143 = new BitSet(new long[]{0x0000000000000002L});

}