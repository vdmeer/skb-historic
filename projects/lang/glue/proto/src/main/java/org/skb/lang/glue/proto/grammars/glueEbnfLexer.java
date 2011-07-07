// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g 2011-07-07 22:24:59

  package org.skb.lang.glue.proto.grammars;

  import org.skb.lang.glue.proto.GlueTokensConstants;
  import org.skb.util.ReportManager;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class glueEbnfLexer extends Lexer {
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

      public void setFilename(String f){ReportManager.getInstance().setFileName(f);}
      public String getFilename(){return ReportManager.getInstance().getFileName();}

      private void setCppFile(String cpp){
        String fn=cpp.substring(1,cpp.lastIndexOf(':'));
        this.setFilename(fn);
      }
      private void setCppLine(String cpp){
        Integer i=new Integer(cpp.substring(cpp.lastIndexOf(':')+1, cpp.length()-1));
        this.input.setLine(i.intValue());
      }
      private void setCppFileandLine(String cpp){
        setCppFile(cpp);
        setCppLine(cpp);
      }


    // delegates
    // delegators

    public glueEbnfLexer() {;} 
    public glueEbnfLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public glueEbnfLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g"; }

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:31:7: ( ';' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:31:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:32:7: ( '[' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:32:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:33:7: ( ']' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:33:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:34:7: ( '{' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:34:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:35:7: ( '}' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:35:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:36:7: ( '=' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:36:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:37:7: ( '::' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:37:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:38:7: ( '@' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:38:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "TOPOLOGY"
    public final void mTOPOLOGY() throws RecognitionException {
        try {
            int _type = TOPOLOGY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:160:15: ( 'topology' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:160:17: 'topology'
            {
            match("topology"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TOPOLOGY"

    // $ANTLR start "NODE"
    public final void mNODE() throws RecognitionException {
        try {
            int _type = NODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:161:15: ( 'node' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:161:17: 'node'
            {
            match("node"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NODE"

    // $ANTLR start "CONNECTION"
    public final void mCONNECTION() throws RecognitionException {
        try {
            int _type = CONNECTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:162:15: ( 'connection' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:162:17: 'connection'
            {
            match("connection"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONNECTION"

    // $ANTLR start "INTERFACE"
    public final void mINTERFACE() throws RecognitionException {
        try {
            int _type = INTERFACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:163:15: ( 'interface' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:163:17: 'interface'
            {
            match("interface"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTERFACE"

    // $ANTLR start "COMPONENT"
    public final void mCOMPONENT() throws RecognitionException {
        try {
            int _type = COMPONENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:164:15: ( 'component' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:164:17: 'component'
            {
            match("component"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMPONENT"

    // $ANTLR start "DIRECTED"
    public final void mDIRECTED() throws RecognitionException {
        try {
            int _type = DIRECTED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:165:15: ( 'directed' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:165:17: 'directed'
            {
            match("directed"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIRECTED"

    // $ANTLR start "SOURCE"
    public final void mSOURCE() throws RecognitionException {
        try {
            int _type = SOURCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:166:15: ( 'source' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:166:17: 'source'
            {
            match("source"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SOURCE"

    // $ANTLR start "TARGET"
    public final void mTARGET() throws RecognitionException {
        try {
            int _type = TARGET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:167:15: ( 'target' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:167:17: 'target'
            {
            match("target"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TARGET"

    // $ANTLR start "PORT"
    public final void mPORT() throws RecognitionException {
        try {
            int _type = PORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:168:15: ( 'port' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:168:17: 'port'
            {
            match("port"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PORT"

    // $ANTLR start "SOURCEPORT"
    public final void mSOURCEPORT() throws RecognitionException {
        try {
            int _type = SOURCEPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:169:15: ( 'sourceport' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:169:17: 'sourceport'
            {
            match("sourceport"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SOURCEPORT"

    // $ANTLR start "TARGETPORT"
    public final void mTARGETPORT() throws RecognitionException {
        try {
            int _type = TARGETPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:170:15: ( 'targetport' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:170:17: 'targetport'
            {
            match("targetport"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TARGETPORT"

    // $ANTLR start "DOMAIN"
    public final void mDOMAIN() throws RecognitionException {
        try {
            int _type = DOMAIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:171:15: ( 'domain' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:171:17: 'domain'
            {
            match("domain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOMAIN"

    // $ANTLR start "CONTRACTS"
    public final void mCONTRACTS() throws RecognitionException {
        try {
            int _type = CONTRACTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:172:15: ( 'contracts' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:172:17: 'contracts'
            {
            match("contracts"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONTRACTS"

    // $ANTLR start "POLICIES"
    public final void mPOLICIES() throws RecognitionException {
        try {
            int _type = POLICIES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:173:15: ( 'policies' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:173:17: 'policies'
            {
            match("policies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLICIES"

    // $ANTLR start "AT_SPEC"
    public final void mAT_SPEC() throws RecognitionException {
        try {
            int _type = AT_SPEC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:175:15: ( '@spec' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:175:17: '@spec'
            {
            match("@spec"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_SPEC"

    // $ANTLR start "AT_SCOPE"
    public final void mAT_SCOPE() throws RecognitionException {
        try {
            int _type = AT_SCOPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:176:15: ( '@scope' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:176:17: '@scope'
            {
            match("@scope"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_SCOPE"

    // $ANTLR start "AT_LANG"
    public final void mAT_LANG() throws RecognitionException {
        try {
            int _type = AT_LANG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:177:15: ( '@lang' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:177:17: '@lang'
            {
            match("@lang"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_LANG"

    // $ANTLR start "AT_KVL"
    public final void mAT_KVL() throws RecognitionException {
        try {
            int _type = AT_KVL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:178:15: ( '@kvl' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:178:17: '@kvl'
            {
            match("@kvl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_KVL"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:180:15: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:180:17: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:180:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:182:15: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:182:17: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:183:15: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:183:17: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:183:22: (~ ( '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:183:22: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:183:36: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:183:36: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:184:15: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:184:17: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:184:22: ( options {greedy=false; } : . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='*') ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1=='/') ) {
                        alt4=2;
                    }
                    else if ( ((LA4_1>='\u0000' && LA4_1<='.')||(LA4_1>='0' && LA4_1<='\uFFFF')) ) {
                        alt4=1;
                    }


                }
                else if ( ((LA4_0>='\u0000' && LA4_0<=')')||(LA4_0>='+' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:184:50: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match("*/"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "VAL_CHAR"
    public final void mVAL_CHAR() throws RecognitionException {
        try {
            int _type = VAL_CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:185:15: ( '\\'' ( ESC | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:185:17: '\\'' ( ESC | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:185:22: ( ESC | ~ ( '\\'' | '\\\\' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\\') ) {
                alt5=1;
            }
            else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:185:24: ESC
                    {
                    mESC(); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:185:30: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAL_CHAR"

    // $ANTLR start "VAL_STRING"
    public final void mVAL_STRING() throws RecognitionException {
        try {
            int _type = VAL_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:186:15: ( '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:186:17: '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:186:21: ( ESC | ~ ( '\\\\' | '\"' ) )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\\') ) {
                    alt6=1;
                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:186:23: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:186:29: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAL_STRING"

    // $ANTLR start "VAL_XSTRING"
    public final void mVAL_XSTRING() throws RecognitionException {
        try {
            int _type = VAL_XSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:189:15: ( '<![' ( 'CDATA' )? '[' ( options {greedy=false; } : . )* ']]>' )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:189:17: '<![' ( 'CDATA' )? '[' ( options {greedy=false; } : . )* ']]>'
            {
            match("<!["); 

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:189:23: ( 'CDATA' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='C') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:189:23: 'CDATA'
                    {
                    match("CDATA"); 


                    }
                    break;

            }

            match('['); 
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:189:36: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==']') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1==']') ) {
                        int LA8_3 = input.LA(3);

                        if ( (LA8_3=='>') ) {
                            alt8=2;
                        }
                        else if ( ((LA8_3>='\u0000' && LA8_3<='=')||(LA8_3>='?' && LA8_3<='\uFFFF')) ) {
                            alt8=1;
                        }


                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='\\')||(LA8_1>='^' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<='\\')||(LA8_0>='^' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:189:64: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("]]>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAL_XSTRING"

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:191:15: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEscape | OctalEscape )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt9=1;
                    }
                    break;
                case 'u':
                    {
                    alt9=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt9=3;
                    }
                    break;
                default:
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
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:191:17: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:191:61: UnicodeEscape
                    {
                    mUnicodeEscape(); 

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:191:77: OctalEscape
                    {
                    mOctalEscape(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESC"

    // $ANTLR start "OctalEscape"
    public final void mOctalEscape() throws RecognitionException {
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:15: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\\') ) {
                int LA10_1 = input.LA(2);

                if ( ((LA10_1>='0' && LA10_1<='3')) ) {
                    int LA10_2 = input.LA(3);

                    if ( ((LA10_2>='0' && LA10_2<='7')) ) {
                        int LA10_4 = input.LA(4);

                        if ( ((LA10_4>='0' && LA10_4<='7')) ) {
                            alt10=1;
                        }
                        else {
                            alt10=2;}
                    }
                    else {
                        alt10=3;}
                }
                else if ( ((LA10_1>='4' && LA10_1<='7')) ) {
                    int LA10_3 = input.LA(3);

                    if ( ((LA10_3>='0' && LA10_3<='7')) ) {
                        alt10=2;
                    }
                    else {
                        alt10=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:17: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:22: ( '0' .. '3' )
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:23: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:33: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:34: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:44: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:45: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:57: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:62: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:63: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:73: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:74: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:86: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:91: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:194:92: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OctalEscape"

    // $ANTLR start "UnicodeEscape"
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:196:15: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:196:17: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('\\'); 
            match('u'); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UnicodeEscape"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:199:15: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:199:17: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "VAL_HEX"
    public final void mVAL_HEX() throws RecognitionException {
        try {
            int _type = VAL_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:200:15: ( '0' ( 'x' | 'X' ) ( HexDigit )+ )
            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:200:17: '0' ( 'x' | 'X' ) ( HexDigit )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:200:31: ( HexDigit )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='F')||(LA11_0>='a' && LA11_0<='f')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:200:31: HexDigit
            	    {
            	    mHexDigit(); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAL_HEX"

    public void mTokens() throws RecognitionException {
        // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:8: ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | TOPOLOGY | NODE | CONNECTION | INTERFACE | COMPONENT | DIRECTED | SOURCE | TARGET | PORT | SOURCEPORT | TARGETPORT | DOMAIN | CONTRACTS | POLICIES | AT_SPEC | AT_SCOPE | AT_LANG | AT_KVL | IDENT | WS | SL_COMMENT | ML_COMMENT | VAL_CHAR | VAL_STRING | VAL_XSTRING | VAL_HEX )
        int alt12=34;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:10: T__34
                {
                mT__34(); 

                }
                break;
            case 2 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:16: T__35
                {
                mT__35(); 

                }
                break;
            case 3 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:22: T__36
                {
                mT__36(); 

                }
                break;
            case 4 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:28: T__37
                {
                mT__37(); 

                }
                break;
            case 5 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:34: T__38
                {
                mT__38(); 

                }
                break;
            case 6 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:40: T__39
                {
                mT__39(); 

                }
                break;
            case 7 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:46: T__40
                {
                mT__40(); 

                }
                break;
            case 8 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:52: T__41
                {
                mT__41(); 

                }
                break;
            case 9 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:58: TOPOLOGY
                {
                mTOPOLOGY(); 

                }
                break;
            case 10 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:67: NODE
                {
                mNODE(); 

                }
                break;
            case 11 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:72: CONNECTION
                {
                mCONNECTION(); 

                }
                break;
            case 12 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:83: INTERFACE
                {
                mINTERFACE(); 

                }
                break;
            case 13 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:93: COMPONENT
                {
                mCOMPONENT(); 

                }
                break;
            case 14 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:103: DIRECTED
                {
                mDIRECTED(); 

                }
                break;
            case 15 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:112: SOURCE
                {
                mSOURCE(); 

                }
                break;
            case 16 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:119: TARGET
                {
                mTARGET(); 

                }
                break;
            case 17 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:126: PORT
                {
                mPORT(); 

                }
                break;
            case 18 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:131: SOURCEPORT
                {
                mSOURCEPORT(); 

                }
                break;
            case 19 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:142: TARGETPORT
                {
                mTARGETPORT(); 

                }
                break;
            case 20 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:153: DOMAIN
                {
                mDOMAIN(); 

                }
                break;
            case 21 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:160: CONTRACTS
                {
                mCONTRACTS(); 

                }
                break;
            case 22 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:170: POLICIES
                {
                mPOLICIES(); 

                }
                break;
            case 23 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:179: AT_SPEC
                {
                mAT_SPEC(); 

                }
                break;
            case 24 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:187: AT_SCOPE
                {
                mAT_SCOPE(); 

                }
                break;
            case 25 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:196: AT_LANG
                {
                mAT_LANG(); 

                }
                break;
            case 26 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:204: AT_KVL
                {
                mAT_KVL(); 

                }
                break;
            case 27 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:211: IDENT
                {
                mIDENT(); 

                }
                break;
            case 28 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:217: WS
                {
                mWS(); 

                }
                break;
            case 29 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:220: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 30 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:231: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 31 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:242: VAL_CHAR
                {
                mVAL_CHAR(); 

                }
                break;
            case 32 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:251: VAL_STRING
                {
                mVAL_STRING(); 

                }
                break;
            case 33 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:262: VAL_XSTRING
                {
                mVAL_XSTRING(); 

                }
                break;
            case 34 :
                // V:\\dev\\skb\\projects\\lang\\glue\\proto\\src\\main\\java\\org\\skb\\lang\\glue\\proto\\grammars\\glueEbnf.g:1:274: VAL_HEX
                {
                mVAL_HEX(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\10\uffff\1\32\7\20\13\uffff\11\20\4\uffff\15\20\1\101\7\20\1\111"+
        "\3\20\1\uffff\7\20\1\uffff\2\20\1\127\5\20\1\135\1\137\3\20\1\uffff"+
        "\5\20\1\uffff\1\20\1\uffff\1\20\1\152\5\20\1\160\1\20\1\162\1\uffff"+
        "\2\20\1\165\1\166\1\167\1\uffff\1\20\1\uffff\1\171\1\172\3\uffff"+
        "\1\173\3\uffff";
    static final String DFA12_eofS =
        "\174\uffff";
    static final String DFA12_minS =
        "\1\11\7\uffff\1\153\1\141\2\157\1\156\1\151\2\157\2\uffff\1\52"+
        "\4\uffff\1\143\3\uffff\1\160\1\162\1\144\1\155\1\164\1\162\1\155"+
        "\1\165\1\154\4\uffff\1\157\1\147\1\145\1\156\1\160\2\145\1\141\1"+
        "\162\1\164\1\151\1\154\1\145\1\60\1\145\1\162\1\157\1\162\1\143"+
        "\1\151\1\143\1\60\1\143\1\157\1\164\1\uffff\1\143\1\141\1\156\1"+
        "\146\1\164\1\156\1\145\1\uffff\1\151\1\147\1\60\1\164\1\143\1\145"+
        "\1\141\1\145\2\60\1\145\1\171\1\157\1\uffff\1\151\1\164\1\156\1"+
        "\143\1\144\1\uffff\1\157\1\uffff\1\163\1\60\1\162\1\157\1\163\1"+
        "\164\1\145\1\60\1\162\1\60\1\uffff\1\164\1\156\3\60\1\uffff\1\164"+
        "\1\uffff\2\60\3\uffff\1\60\3\uffff";
    static final String DFA12_maxS =
        "\1\175\7\uffff\1\163\3\157\1\156\3\157\2\uffff\1\57\4\uffff\1\160"+
        "\3\uffff\1\160\1\162\1\144\1\156\1\164\1\162\1\155\1\165\1\162\4"+
        "\uffff\1\157\1\147\1\145\1\164\1\160\2\145\1\141\1\162\1\164\1\151"+
        "\1\154\1\145\1\172\1\145\1\162\1\157\1\162\1\143\1\151\1\143\1\172"+
        "\1\143\1\157\1\164\1\uffff\1\143\1\141\1\156\1\146\1\164\1\156\1"+
        "\145\1\uffff\1\151\1\147\1\172\1\164\1\143\1\145\1\141\1\145\2\172"+
        "\1\145\1\171\1\157\1\uffff\1\151\1\164\1\156\1\143\1\144\1\uffff"+
        "\1\157\1\uffff\1\163\1\172\1\162\1\157\1\163\1\164\1\145\1\172\1"+
        "\162\1\172\1\uffff\1\164\1\156\3\172\1\uffff\1\164\1\uffff\2\172"+
        "\3\uffff\1\172\3\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\10\uffff\1\33\1\34\1\uffff"+
        "\1\37\1\40\1\41\1\42\1\uffff\1\31\1\32\1\10\11\uffff\1\35\1\36\1"+
        "\27\1\30\31\uffff\1\12\7\uffff\1\21\15\uffff\1\20\5\uffff\1\24\1"+
        "\uffff\1\17\12\uffff\1\11\5\uffff\1\16\1\uffff\1\26\2\uffff\1\25"+
        "\1\15\1\14\1\uffff\1\23\1\13\1\22";
    static final String DFA12_specialS =
        "\174\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\21\1\uffff\2\21\22\uffff\1\21\1\uffff\1\24\4\uffff\1\23"+
            "\7\uffff\1\22\1\26\11\uffff\1\7\1\1\1\25\1\6\2\uffff\1\10\32"+
            "\20\1\2\1\uffff\1\3\1\uffff\1\20\1\uffff\2\20\1\13\1\15\4\20"+
            "\1\14\4\20\1\12\1\20\1\17\2\20\1\16\1\11\6\20\1\4\1\uffff\1"+
            "\5",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\31\1\30\6\uffff\1\27",
            "\1\34\15\uffff\1\33",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40\5\uffff\1\41",
            "\1\42",
            "\1\43",
            "",
            "",
            "\1\45\4\uffff\1\44",
            "",
            "",
            "",
            "",
            "\1\47\14\uffff\1\46",
            "",
            "",
            "",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\54\1\53",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\62\5\uffff\1\61",
            "",
            "",
            "",
            "",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66\5\uffff\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\112",
            "\1\113",
            "\1\114",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "",
            "\1\124",
            "\1\125",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\17\20\1\126\12\20",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\17\20\1\136\12\20",
            "\1\140",
            "\1\141",
            "\1\142",
            "",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "",
            "\1\150",
            "",
            "\1\151",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\161",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\1\163",
            "\1\164",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\1\170",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | TOPOLOGY | NODE | CONNECTION | INTERFACE | COMPONENT | DIRECTED | SOURCE | TARGET | PORT | SOURCEPORT | TARGETPORT | DOMAIN | CONTRACTS | POLICIES | AT_SPEC | AT_SCOPE | AT_LANG | AT_KVL | IDENT | WS | SL_COMMENT | ML_COMMENT | VAL_CHAR | VAL_STRING | VAL_XSTRING | VAL_HEX );";
        }
    }
 

}