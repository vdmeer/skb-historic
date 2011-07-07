// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g 2011-07-07 22:24:37

  package org.skb.lang.cola.proto.grammars;

  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.cola.proto.ColaTokensConstants;
  import org.skb.util.ReportManager;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class colaEbnfLexer extends Lexer {
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

    public colaEbnfLexer() {;} 
    public colaEbnfLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public colaEbnfLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g"; }

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:32:7: ( 'architecture' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:32:9: 'architecture'
            {
            match("architecture"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:33:7: ( 'model' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:33:9: 'model'
            {
            match("model"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:34:7: ( 'design' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:34:9: 'design'
            {
            match("design"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:35:7: ( 'development' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:35:9: 'development'
            {
            match("development"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:36:7: ( 'deployment' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:36:9: 'deployment'
            {
            match("deployment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:37:7: ( 'runtime' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:37:9: 'runtime'
            {
            match("runtime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:38:7: ( 'production' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:38:9: 'production'
            {
            match("production"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:39:7: ( 'test' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:39:9: 'test'
            {
            match("test"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:40:7: ( 'demonstrator' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:40:9: 'demonstrator'
            {
            match("demonstrator"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:41:7: ( 'business' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:41:9: 'business'
            {
            match("business"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:42:7: ( 'system' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:42:9: 'system'
            {
            match("system"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:43:7: ( ':' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:43:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:44:7: ( '=' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:44:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:45:7: ( '(' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:45:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:46:7: ( ')' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:46:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:47:7: ( ';' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:47:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:48:7: ( '[' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:48:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:49:7: ( ']' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:49:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:50:8: ( ',' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:50:10: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:51:8: ( '-' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:51:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:52:8: ( '+' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:52:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:53:8: ( '{' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:53:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:54:8: ( '}' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:54:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:55:8: ( '::' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:55:10: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "ARRAY"
    public final void mARRAY() throws RecognitionException {
        try {
            int _type = ARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:308:15: ( '__array' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:308:17: '__array'
            {
            match("__array"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ARRAY"

    // $ANTLR start "MEMBER"
    public final void mMEMBER() throws RecognitionException {
        try {
            int _type = MEMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:309:15: ( '__member' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:309:17: '__member'
            {
            match("__member"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MEMBER"

    // $ANTLR start "ACTION"
    public final void mACTION() throws RecognitionException {
        try {
            int _type = ACTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:312:15: ( 'action' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:312:17: 'action'
            {
            match("action"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ACTION"

    // $ANTLR start "ATTRIBUTE"
    public final void mATTRIBUTE() throws RecognitionException {
        try {
            int _type = ATTRIBUTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:313:15: ( 'attribute' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:313:17: 'attribute'
            {
            match("attribute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ATTRIBUTE"

    // $ANTLR start "CONTRACT"
    public final void mCONTRACT() throws RecognitionException {
        try {
            int _type = CONTRACT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:314:15: ( 'contract' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:314:17: 'contract'
            {
            match("contract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONTRACT"

    // $ANTLR start "ELEMENT"
    public final void mELEMENT() throws RecognitionException {
        try {
            int _type = ELEMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:315:15: ( 'element' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:315:17: 'element'
            {
            match("element"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELEMENT"

    // $ANTLR start "FACILITY"
    public final void mFACILITY() throws RecognitionException {
        try {
            int _type = FACILITY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:316:15: ( 'facility' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:316:17: 'facility'
            {
            match("facility"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FACILITY"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:317:15: ( 'function' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:317:17: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "INV"
    public final void mINV() throws RecognitionException {
        try {
            int _type = INV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:318:15: ( 'inv' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:318:17: 'inv'
            {
            match("inv"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INV"

    // $ANTLR start "ITEM"
    public final void mITEM() throws RecognitionException {
        try {
            int _type = ITEM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:319:15: ( 'item' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:319:17: 'item'
            {
            match("item"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ITEM"

    // $ANTLR start "MANDATORY"
    public final void mMANDATORY() throws RecognitionException {
        try {
            int _type = MANDATORY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:320:15: ( 'mandatory' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:320:17: 'mandatory'
            {
            match("mandatory"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MANDATORY"

    // $ANTLR start "NOT_DEF"
    public final void mNOT_DEF() throws RecognitionException {
        try {
            int _type = NOT_DEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:321:15: ( 'not_def' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:321:17: 'not_def'
            {
            match("not_def"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT_DEF"

    // $ANTLR start "OPTIONAL"
    public final void mOPTIONAL() throws RecognitionException {
        try {
            int _type = OPTIONAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:322:15: ( 'optional' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:322:17: 'optional'
            {
            match("optional"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPTIONAL"

    // $ANTLR start "PACKAGE"
    public final void mPACKAGE() throws RecognitionException {
        try {
            int _type = PACKAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:323:15: ( 'package' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:323:17: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PACKAGE"

    // $ANTLR start "PARAMETER"
    public final void mPARAMETER() throws RecognitionException {
        try {
            int _type = PARAMETER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:324:15: ( 'parameter' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:324:17: 'parameter'
            {
            match("parameter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PARAMETER"

    // $ANTLR start "POST"
    public final void mPOST() throws RecognitionException {
        try {
            int _type = POST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:325:15: ( 'post' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:325:17: 'post'
            {
            match("post"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POST"

    // $ANTLR start "PRE"
    public final void mPRE() throws RecognitionException {
        try {
            int _type = PRE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:326:15: ( 'pre' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:326:17: 'pre'
            {
            match("pre"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRE"

    // $ANTLR start "PROPERTY"
    public final void mPROPERTY() throws RecognitionException {
        try {
            int _type = PROPERTY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:327:15: ( 'property' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:327:17: 'property'
            {
            match("property"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROPERTY"

    // $ANTLR start "REQUIRED"
    public final void mREQUIRED() throws RecognitionException {
        try {
            int _type = REQUIRED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:328:15: ( 'required' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:328:17: 'required'
            {
            match("required"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REQUIRED"

    // $ANTLR start "STRUCT"
    public final void mSTRUCT() throws RecognitionException {
        try {
            int _type = STRUCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:329:15: ( 'struct' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:329:17: 'struct'
            {
            match("struct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRUCT"

    // $ANTLR start "TYPEDEF"
    public final void mTYPEDEF() throws RecognitionException {
        try {
            int _type = TYPEDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:330:15: ( 'typedef' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:330:17: 'typedef'
            {
            match("typedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPEDEF"

    // $ANTLR start "AT_ALTERABLE"
    public final void mAT_ALTERABLE() throws RecognitionException {
        try {
            int _type = AT_ALTERABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:333:20: ( '@alterable' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:333:22: '@alterable'
            {
            match("@alterable"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_ALTERABLE"

    // $ANTLR start "AT_APPLY"
    public final void mAT_APPLY() throws RecognitionException {
        try {
            int _type = AT_APPLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:334:20: ( '@apply' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:334:22: '@apply'
            {
            match("@apply"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_APPLY"

    // $ANTLR start "AT_CLEVEL"
    public final void mAT_CLEVEL() throws RecognitionException {
        try {
            int _type = AT_CLEVEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:335:20: ( '@clevel' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:335:22: '@clevel'
            {
            match("@clevel"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_CLEVEL"

    // $ANTLR start "AT_CONTAINS"
    public final void mAT_CONTAINS() throws RecognitionException {
        try {
            int _type = AT_CONTAINS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:336:20: ( '@contains' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:336:22: '@contains'
            {
            match("@contains"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_CONTAINS"

    // $ANTLR start "AT_DESCRIPTION"
    public final void mAT_DESCRIPTION() throws RecognitionException {
        try {
            int _type = AT_DESCRIPTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:337:20: ( '@description' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:337:22: '@description'
            {
            match("@description"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_DESCRIPTION"

    // $ANTLR start "AT_ENVIRONMENT"
    public final void mAT_ENVIRONMENT() throws RecognitionException {
        try {
            int _type = AT_ENVIRONMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:338:20: ( '@environment' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:338:22: '@environment'
            {
            match("@environment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_ENVIRONMENT"

    // $ANTLR start "AT_EXTENDS"
    public final void mAT_EXTENDS() throws RecognitionException {
        try {
            int _type = AT_EXTENDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:339:20: ( '@extends' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:339:22: '@extends'
            {
            match("@extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_EXTENDS"

    // $ANTLR start "AT_LANGUAGE"
    public final void mAT_LANGUAGE() throws RecognitionException {
        try {
            int _type = AT_LANGUAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:340:20: ( '@language' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:340:22: '@language'
            {
            match("@language"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_LANGUAGE"

    // $ANTLR start "AT_NEGOTIABLE"
    public final void mAT_NEGOTIABLE() throws RecognitionException {
        try {
            int _type = AT_NEGOTIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:341:20: ( '@negotiable' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:341:22: '@negotiable'
            {
            match("@negotiable"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_NEGOTIABLE"

    // $ANTLR start "AT_PRIORITY"
    public final void mAT_PRIORITY() throws RecognitionException {
        try {
            int _type = AT_PRIORITY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:342:20: ( '@priority' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:342:22: '@priority'
            {
            match("@priority"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_PRIORITY"

    // $ANTLR start "AT_PROVIDES"
    public final void mAT_PROVIDES() throws RecognitionException {
        try {
            int _type = AT_PROVIDES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:343:20: ( '@provides' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:343:22: '@provides'
            {
            match("@provides"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_PROVIDES"

    // $ANTLR start "AT_RANK"
    public final void mAT_RANK() throws RecognitionException {
        try {
            int _type = AT_RANK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:344:20: ( '@rank' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:344:22: '@rank'
            {
            match("@rank"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_RANK"

    // $ANTLR start "AT_REQUIRES"
    public final void mAT_REQUIRES() throws RecognitionException {
        try {
            int _type = AT_REQUIRES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:345:20: ( '@requires' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:345:22: '@requires'
            {
            match("@requires"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_REQUIRES"

    // $ANTLR start "AT_RETURN"
    public final void mAT_RETURN() throws RecognitionException {
        try {
            int _type = AT_RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:346:20: ( '@return' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:346:22: '@return'
            {
            match("@return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_RETURN"

    // $ANTLR start "AT_RUNTIME"
    public final void mAT_RUNTIME() throws RecognitionException {
        try {
            int _type = AT_RUNTIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:347:20: ( '@runtime' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:347:22: '@runtime'
            {
            match("@runtime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_RUNTIME"

    // $ANTLR start "AT_SCOPE"
    public final void mAT_SCOPE() throws RecognitionException {
        try {
            int _type = AT_SCOPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:348:20: ( '@scope' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:348:22: '@scope'
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

    // $ANTLR start "AT_SPEC"
    public final void mAT_SPEC() throws RecognitionException {
        try {
            int _type = AT_SPEC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:349:20: ( '@spec' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:349:22: '@spec'
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

    // $ANTLR start "AT_STAGE"
    public final void mAT_STAGE() throws RecognitionException {
        try {
            int _type = AT_STAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:350:20: ( '@stage' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:350:22: '@stage'
            {
            match("@stage"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_STAGE"

    // $ANTLR start "AT_TYPE"
    public final void mAT_TYPE() throws RecognitionException {
        try {
            int _type = AT_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:351:20: ( '@type' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:351:22: '@type'
            {
            match("@type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_TYPE"

    // $ANTLR start "AT_VISIBILITY"
    public final void mAT_VISIBILITY() throws RecognitionException {
        try {
            int _type = AT_VISIBILITY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:352:20: ( '@visibility' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:352:22: '@visibility'
            {
            match("@visibility"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_VISIBILITY"

    // $ANTLR start "BINARY"
    public final void mBINARY() throws RecognitionException {
        try {
            int _type = BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:355:15: ( 'binary' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:355:17: 'binary'
            {
            match("binary"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BINARY"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:356:15: ( 'boolean' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:356:17: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:357:15: ( 'char' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:357:17: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "DOUBLE"
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:358:15: ( 'double' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:358:17: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:359:15: ( 'float' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:359:17: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "HEX"
    public final void mHEX() throws RecognitionException {
        try {
            int _type = HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:360:15: ( 'hex' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:360:17: 'hex'
            {
            match("hex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HEX"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:361:15: ( 'integer' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:361:17: 'integer'
            {
            match("integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "LONG"
    public final void mLONG() throws RecognitionException {
        try {
            int _type = LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:362:15: ( 'long' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:362:17: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LONG"

    // $ANTLR start "OCTET"
    public final void mOCTET() throws RecognitionException {
        try {
            int _type = OCTET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:363:15: ( 'octet' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:363:17: 'octet'
            {
            match("octet"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OCTET"

    // $ANTLR start "SHORT"
    public final void mSHORT() throws RecognitionException {
        try {
            int _type = SHORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:364:15: ( 'short' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:364:17: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHORT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:365:15: ( 'string' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:365:17: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "VOID"
    public final void mVOID() throws RecognitionException {
        try {
            int _type = VOID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:366:15: ( 'void' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:366:17: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VOID"

    // $ANTLR start "COLA_FALSE"
    public final void mCOLA_FALSE() throws RecognitionException {
        try {
            int _type = COLA_FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:369:15: ( 'FALSE' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:369:17: 'FALSE'
            {
            match("FALSE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLA_FALSE"

    // $ANTLR start "COLA_NULL"
    public final void mCOLA_NULL() throws RecognitionException {
        try {
            int _type = COLA_NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:370:15: ( 'NULL' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:370:17: 'NULL'
            {
            match("NULL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLA_NULL"

    // $ANTLR start "COLA_TRUE"
    public final void mCOLA_TRUE() throws RecognitionException {
        try {
            int _type = COLA_TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:371:15: ( 'TRUE' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:371:17: 'TRUE'
            {
            match("TRUE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLA_TRUE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:373:15: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:373:17: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:374:15: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:374:17: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:374:22: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:374:22: ~ ( '\\n' | '\\r' )
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
            	    break loop1;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:374:36: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:374:36: '\\r'
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
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:375:15: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:375:17: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:375:22: ( options {greedy=false; } : . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='*') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='/') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1>='\u0000' && LA3_1<='.')||(LA3_1>='0' && LA3_1<='\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<=')')||(LA3_0>='+' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:375:50: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
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
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:376:15: ( '\\'' ( ESC | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:376:17: '\\'' ( ESC | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:376:22: ( ESC | ~ ( '\\'' | '\\\\' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\\') ) {
                alt4=1;
            }
            else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:376:24: ESC
                    {
                    mESC(); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:376:30: ~ ( '\\'' | '\\\\' )
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
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:377:15: ( '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:377:17: '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:377:21: ( ESC | ~ ( '\\\\' | '\"' ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:377:23: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:377:29: ~ ( '\\\\' | '\"' )
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
            	    break loop5;
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

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:379:15: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEscape | OctalEscape )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\\') ) {
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
                    alt6=1;
                    }
                    break;
                case 'u':
                    {
                    alt6=2;
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
                    alt6=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:379:17: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:379:61: UnicodeEscape
                    {
                    mUnicodeEscape(); 

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:379:77: OctalEscape
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
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:15: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\\') ) {
                int LA7_1 = input.LA(2);

                if ( ((LA7_1>='0' && LA7_1<='3')) ) {
                    int LA7_2 = input.LA(3);

                    if ( ((LA7_2>='0' && LA7_2<='7')) ) {
                        int LA7_4 = input.LA(4);

                        if ( ((LA7_4>='0' && LA7_4<='7')) ) {
                            alt7=1;
                        }
                        else {
                            alt7=2;}
                    }
                    else {
                        alt7=3;}
                }
                else if ( ((LA7_1>='4' && LA7_1<='7')) ) {
                    int LA7_3 = input.LA(3);

                    if ( ((LA7_3>='0' && LA7_3<='7')) ) {
                        alt7=2;
                    }
                    else {
                        alt7=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:17: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:22: ( '0' .. '3' )
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:23: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:33: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:34: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:44: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:45: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:57: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:62: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:63: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:73: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:74: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:86: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:91: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:381:92: '0' .. '7'
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
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:383:15: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:383:17: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
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
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:386:15: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:386:17: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:387:15: ( '0' ( 'x' | 'X' ) ( HexDigit )+ )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:387:17: '0' ( 'x' | 'X' ) ( HexDigit )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:387:31: ( HexDigit )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='F')||(LA8_0>='a' && LA8_0<='f')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:387:31: HexDigit
            	    {
            	    mHexDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAL_HEX"

    // $ANTLR start "VAL_INTEGER"
    public final void mVAL_INTEGER() throws RecognitionException {
        try {
            int _type = VAL_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:389:15: ( ( '+' | '-' )? ( '0' | '1' .. '9' ( '0' .. '9' )* ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:389:17: ( '+' | '-' )? ( '0' | '1' .. '9' ( '0' .. '9' )* )
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:389:17: ( '+' | '-' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='+'||LA9_0=='-') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:389:30: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='0') ) {
                alt11=1;
            }
            else if ( ((LA11_0>='1' && LA11_0<='9')) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:389:31: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:389:37: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:389:46: ( '0' .. '9' )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:389:46: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAL_INTEGER"

    // $ANTLR start "OctDigit"
    public final void mOctDigit() throws RecognitionException {
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:392:15: ( ( '0' .. '7' ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:392:17: ( '0' .. '7' )
            {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:392:17: ( '0' .. '7' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:392:18: '0' .. '7'
            {
            matchRange('0','7'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "OctDigit"

    // $ANTLR start "VAL_OCT"
    public final void mVAL_OCT() throws RecognitionException {
        try {
            int _type = VAL_OCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:393:15: ( '0' OctDigit OctDigit OctDigit )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:393:17: '0' OctDigit OctDigit OctDigit
            {
            match('0'); 
            mOctDigit(); 
            mOctDigit(); 
            mOctDigit(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAL_OCT"

    // $ANTLR start "BinDigit"
    public final void mBinDigit() throws RecognitionException {
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:396:15: ( ( '0' | '1' ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:396:17: ( '0' | '1' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
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
    // $ANTLR end "BinDigit"

    // $ANTLR start "VAL_BINARY"
    public final void mVAL_BINARY() throws RecognitionException {
        try {
            int _type = VAL_BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:397:15: ( ( 'b' | 'B' ) ( BinDigit )+ )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:397:17: ( 'b' | 'B' ) ( BinDigit )+
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:397:29: ( BinDigit )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='1')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:397:30: BinDigit
            	    {
            	    mBinDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAL_BINARY"

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:400:15: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:400:17: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:400:27: ( '+' | '-' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='+'||LA13_0=='-') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:400:38: ( '0' .. '9' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:400:39: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "FloatSuffix"
    public final void mFloatSuffix() throws RecognitionException {
        try {
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:402:15: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:402:17: ( 'f' | 'F' | 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
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
    // $ANTLR end "FloatSuffix"

    // $ANTLR start "VAL_FLOAT"
    public final void mVAL_FLOAT() throws RecognitionException {
        try {
            int _type = VAL_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:403:15: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatSuffix )? | ( '0' .. '9' )+ Exponent ( FloatSuffix )? | ( '0' .. '9' )+ ( Exponent )? FloatSuffix )
            int alt26=4;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:403:19: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatSuffix )?
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:403:19: ( '0' .. '9' )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:403:20: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    match('.'); 
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:403:35: ( '0' .. '9' )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:403:36: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:403:47: ( Exponent )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='E'||LA17_0=='e') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:403:47: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:403:57: ( FloatSuffix )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='D'||LA18_0=='F'||LA18_0=='d'||LA18_0=='f') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:403:57: FloatSuffix
                            {
                            mFloatSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:404:19: '.' ( '0' .. '9' )+ ( Exponent )? ( FloatSuffix )?
                    {
                    match('.'); 
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:404:23: ( '0' .. '9' )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>='0' && LA19_0<='9')) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:404:24: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:404:35: ( Exponent )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='E'||LA20_0=='e') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:404:35: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:404:45: ( FloatSuffix )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='D'||LA21_0=='F'||LA21_0=='d'||LA21_0=='f') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:404:45: FloatSuffix
                            {
                            mFloatSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:405:19: ( '0' .. '9' )+ Exponent ( FloatSuffix )?
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:405:19: ( '0' .. '9' )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( ((LA22_0>='0' && LA22_0<='9')) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:405:20: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    mExponent(); 
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:405:40: ( FloatSuffix )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='D'||LA23_0=='F'||LA23_0=='d'||LA23_0=='f') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:405:40: FloatSuffix
                            {
                            mFloatSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:406:19: ( '0' .. '9' )+ ( Exponent )? FloatSuffix
                    {
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:406:19: ( '0' .. '9' )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>='0' && LA24_0<='9')) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:406:20: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);

                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:406:31: ( Exponent )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0=='E'||LA25_0=='e') ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:406:31: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    mFloatSuffix(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAL_FLOAT"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:409:15: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:409:17: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:409:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='0' && LA27_0<='9')||(LA27_0>='A' && LA27_0<='Z')||LA27_0=='_'||(LA27_0>='a' && LA27_0<='z')) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:
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
            	    break loop27;
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

    // $ANTLR start "INLINE_CODE"
    public final void mINLINE_CODE() throws RecognitionException {
        try {
            int _type = INLINE_CODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:411:15: ( '<<?' ( options {greedy=false; } : . )* '?>>' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:411:17: '<<?' ( options {greedy=false; } : . )* '?>>'
            {
            match("<<?"); 

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:411:23: ( options {greedy=false; } : . )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0=='?') ) {
                    int LA28_1 = input.LA(2);

                    if ( (LA28_1=='>') ) {
                        int LA28_3 = input.LA(3);

                        if ( (LA28_3=='>') ) {
                            alt28=2;
                        }
                        else if ( ((LA28_3>='\u0000' && LA28_3<='=')||(LA28_3>='?' && LA28_3<='\uFFFF')) ) {
                            alt28=1;
                        }


                    }
                    else if ( ((LA28_1>='\u0000' && LA28_1<='=')||(LA28_1>='?' && LA28_1<='\uFFFF')) ) {
                        alt28=1;
                    }


                }
                else if ( ((LA28_0>='\u0000' && LA28_0<='>')||(LA28_0>='@' && LA28_0<='\uFFFF')) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:411:51: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            match("?>>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INLINE_CODE"

    // $ANTLR start "CPP_DIRECTIVE"
    public final void mCPP_DIRECTIVE() throws RecognitionException {
        try {
            int _type = CPP_DIRECTIVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken CPP_FILENAME1=null;

            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:414:15: ( '#' 'file' ' ' CPP_FILENAME ( '\\r' )? '\\n' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:414:17: '#' 'file' ' ' CPP_FILENAME ( '\\r' )? '\\n'
            {
            match('#'); 
            match("file"); 

            match(' '); 
            int CPP_FILENAME1Start1790 = getCharIndex();
            int CPP_FILENAME1StartLine1790 = getLine();
            int CPP_FILENAME1StartCharPos1790 = getCharPositionInLine();
            mCPP_FILENAME(); 
            CPP_FILENAME1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, CPP_FILENAME1Start1790, getCharIndex()-1);
            CPP_FILENAME1.setLine(CPP_FILENAME1StartLine1790);
            CPP_FILENAME1.setCharPositionInLine(CPP_FILENAME1StartCharPos1790);
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:414:45: ( '\\r' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0=='\r') ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:414:45: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            this.setCppFileandLine(CPP_FILENAME1.getText());

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CPP_DIRECTIVE"

    // $ANTLR start "CPP_FILENAME"
    public final void mCPP_FILENAME() throws RecognitionException {
        try {
            int _type = CPP_FILENAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:415:15: ( '\"' (~ '\"' )* '\"' )
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:415:17: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:415:21: (~ '\"' )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>='\u0000' && LA30_0<='!')||(LA30_0>='#' && LA30_0<='\uFFFF')) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:415:22: ~ '\"'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // $ANTLR end "CPP_FILENAME"

    public void mTokens() throws RecognitionException {
        // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:8: ( T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | ARRAY | MEMBER | ACTION | ATTRIBUTE | CONTRACT | ELEMENT | FACILITY | FUNCTION | INV | ITEM | MANDATORY | NOT_DEF | OPTIONAL | PACKAGE | PARAMETER | POST | PRE | PROPERTY | REQUIRED | STRUCT | TYPEDEF | AT_ALTERABLE | AT_APPLY | AT_CLEVEL | AT_CONTAINS | AT_DESCRIPTION | AT_ENVIRONMENT | AT_EXTENDS | AT_LANGUAGE | AT_NEGOTIABLE | AT_PRIORITY | AT_PROVIDES | AT_RANK | AT_REQUIRES | AT_RETURN | AT_RUNTIME | AT_SCOPE | AT_SPEC | AT_STAGE | AT_TYPE | AT_VISIBILITY | BINARY | BOOLEAN | CHAR | DOUBLE | FLOAT | HEX | INTEGER | LONG | OCTET | SHORT | STRING | VOID | COLA_FALSE | COLA_NULL | COLA_TRUE | WS | SL_COMMENT | ML_COMMENT | VAL_CHAR | VAL_STRING | VAL_HEX | VAL_INTEGER | VAL_OCT | VAL_BINARY | VAL_FLOAT | IDENT | INLINE_CODE | CPP_DIRECTIVE | CPP_FILENAME )
        int alt31=94;
        alt31 = dfa31.predict(input);
        switch (alt31) {
            case 1 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:10: T__82
                {
                mT__82(); 

                }
                break;
            case 2 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:16: T__83
                {
                mT__83(); 

                }
                break;
            case 3 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:22: T__84
                {
                mT__84(); 

                }
                break;
            case 4 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:28: T__85
                {
                mT__85(); 

                }
                break;
            case 5 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:34: T__86
                {
                mT__86(); 

                }
                break;
            case 6 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:40: T__87
                {
                mT__87(); 

                }
                break;
            case 7 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:46: T__88
                {
                mT__88(); 

                }
                break;
            case 8 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:52: T__89
                {
                mT__89(); 

                }
                break;
            case 9 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:58: T__90
                {
                mT__90(); 

                }
                break;
            case 10 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:64: T__91
                {
                mT__91(); 

                }
                break;
            case 11 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:70: T__92
                {
                mT__92(); 

                }
                break;
            case 12 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:76: T__93
                {
                mT__93(); 

                }
                break;
            case 13 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:82: T__94
                {
                mT__94(); 

                }
                break;
            case 14 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:88: T__95
                {
                mT__95(); 

                }
                break;
            case 15 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:94: T__96
                {
                mT__96(); 

                }
                break;
            case 16 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:100: T__97
                {
                mT__97(); 

                }
                break;
            case 17 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:106: T__98
                {
                mT__98(); 

                }
                break;
            case 18 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:112: T__99
                {
                mT__99(); 

                }
                break;
            case 19 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:118: T__100
                {
                mT__100(); 

                }
                break;
            case 20 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:125: T__101
                {
                mT__101(); 

                }
                break;
            case 21 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:132: T__102
                {
                mT__102(); 

                }
                break;
            case 22 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:139: T__103
                {
                mT__103(); 

                }
                break;
            case 23 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:146: T__104
                {
                mT__104(); 

                }
                break;
            case 24 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:153: T__105
                {
                mT__105(); 

                }
                break;
            case 25 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:160: ARRAY
                {
                mARRAY(); 

                }
                break;
            case 26 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:166: MEMBER
                {
                mMEMBER(); 

                }
                break;
            case 27 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:173: ACTION
                {
                mACTION(); 

                }
                break;
            case 28 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:180: ATTRIBUTE
                {
                mATTRIBUTE(); 

                }
                break;
            case 29 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:190: CONTRACT
                {
                mCONTRACT(); 

                }
                break;
            case 30 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:199: ELEMENT
                {
                mELEMENT(); 

                }
                break;
            case 31 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:207: FACILITY
                {
                mFACILITY(); 

                }
                break;
            case 32 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:216: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 33 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:225: INV
                {
                mINV(); 

                }
                break;
            case 34 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:229: ITEM
                {
                mITEM(); 

                }
                break;
            case 35 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:234: MANDATORY
                {
                mMANDATORY(); 

                }
                break;
            case 36 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:244: NOT_DEF
                {
                mNOT_DEF(); 

                }
                break;
            case 37 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:252: OPTIONAL
                {
                mOPTIONAL(); 

                }
                break;
            case 38 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:261: PACKAGE
                {
                mPACKAGE(); 

                }
                break;
            case 39 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:269: PARAMETER
                {
                mPARAMETER(); 

                }
                break;
            case 40 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:279: POST
                {
                mPOST(); 

                }
                break;
            case 41 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:284: PRE
                {
                mPRE(); 

                }
                break;
            case 42 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:288: PROPERTY
                {
                mPROPERTY(); 

                }
                break;
            case 43 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:297: REQUIRED
                {
                mREQUIRED(); 

                }
                break;
            case 44 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:306: STRUCT
                {
                mSTRUCT(); 

                }
                break;
            case 45 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:313: TYPEDEF
                {
                mTYPEDEF(); 

                }
                break;
            case 46 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:321: AT_ALTERABLE
                {
                mAT_ALTERABLE(); 

                }
                break;
            case 47 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:334: AT_APPLY
                {
                mAT_APPLY(); 

                }
                break;
            case 48 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:343: AT_CLEVEL
                {
                mAT_CLEVEL(); 

                }
                break;
            case 49 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:353: AT_CONTAINS
                {
                mAT_CONTAINS(); 

                }
                break;
            case 50 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:365: AT_DESCRIPTION
                {
                mAT_DESCRIPTION(); 

                }
                break;
            case 51 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:380: AT_ENVIRONMENT
                {
                mAT_ENVIRONMENT(); 

                }
                break;
            case 52 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:395: AT_EXTENDS
                {
                mAT_EXTENDS(); 

                }
                break;
            case 53 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:406: AT_LANGUAGE
                {
                mAT_LANGUAGE(); 

                }
                break;
            case 54 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:418: AT_NEGOTIABLE
                {
                mAT_NEGOTIABLE(); 

                }
                break;
            case 55 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:432: AT_PRIORITY
                {
                mAT_PRIORITY(); 

                }
                break;
            case 56 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:444: AT_PROVIDES
                {
                mAT_PROVIDES(); 

                }
                break;
            case 57 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:456: AT_RANK
                {
                mAT_RANK(); 

                }
                break;
            case 58 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:464: AT_REQUIRES
                {
                mAT_REQUIRES(); 

                }
                break;
            case 59 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:476: AT_RETURN
                {
                mAT_RETURN(); 

                }
                break;
            case 60 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:486: AT_RUNTIME
                {
                mAT_RUNTIME(); 

                }
                break;
            case 61 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:497: AT_SCOPE
                {
                mAT_SCOPE(); 

                }
                break;
            case 62 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:506: AT_SPEC
                {
                mAT_SPEC(); 

                }
                break;
            case 63 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:514: AT_STAGE
                {
                mAT_STAGE(); 

                }
                break;
            case 64 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:523: AT_TYPE
                {
                mAT_TYPE(); 

                }
                break;
            case 65 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:531: AT_VISIBILITY
                {
                mAT_VISIBILITY(); 

                }
                break;
            case 66 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:545: BINARY
                {
                mBINARY(); 

                }
                break;
            case 67 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:552: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 68 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:560: CHAR
                {
                mCHAR(); 

                }
                break;
            case 69 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:565: DOUBLE
                {
                mDOUBLE(); 

                }
                break;
            case 70 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:572: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 71 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:578: HEX
                {
                mHEX(); 

                }
                break;
            case 72 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:582: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 73 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:590: LONG
                {
                mLONG(); 

                }
                break;
            case 74 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:595: OCTET
                {
                mOCTET(); 

                }
                break;
            case 75 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:601: SHORT
                {
                mSHORT(); 

                }
                break;
            case 76 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:607: STRING
                {
                mSTRING(); 

                }
                break;
            case 77 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:614: VOID
                {
                mVOID(); 

                }
                break;
            case 78 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:619: COLA_FALSE
                {
                mCOLA_FALSE(); 

                }
                break;
            case 79 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:630: COLA_NULL
                {
                mCOLA_NULL(); 

                }
                break;
            case 80 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:640: COLA_TRUE
                {
                mCOLA_TRUE(); 

                }
                break;
            case 81 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:650: WS
                {
                mWS(); 

                }
                break;
            case 82 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:653: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 83 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:664: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 84 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:675: VAL_CHAR
                {
                mVAL_CHAR(); 

                }
                break;
            case 85 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:684: VAL_STRING
                {
                mVAL_STRING(); 

                }
                break;
            case 86 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:695: VAL_HEX
                {
                mVAL_HEX(); 

                }
                break;
            case 87 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:703: VAL_INTEGER
                {
                mVAL_INTEGER(); 

                }
                break;
            case 88 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:715: VAL_OCT
                {
                mVAL_OCT(); 

                }
                break;
            case 89 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:723: VAL_BINARY
                {
                mVAL_BINARY(); 

                }
                break;
            case 90 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:734: VAL_FLOAT
                {
                mVAL_FLOAT(); 

                }
                break;
            case 91 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:744: IDENT
                {
                mIDENT(); 

                }
                break;
            case 92 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:750: INLINE_CODE
                {
                mINLINE_CODE(); 

                }
                break;
            case 93 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:762: CPP_DIRECTIVE
                {
                mCPP_DIRECTIVE(); 

                }
                break;
            case 94 :
                // V:\\dev\\skb\\projects\\lang\\cola\\proto\\src\\main\\java\\org\\skb\\lang\\cola\\proto\\grammars\\colaEbnf.g:1:776: CPP_FILENAME
                {
                mCPP_FILENAME(); 

                }
                break;

        }

    }


    protected DFA26 dfa26 = new DFA26(this);
    protected DFA31 dfa31 = new DFA31(this);
    static final String DFA26_eotS =
        "\7\uffff\1\10\2\uffff";
    static final String DFA26_eofS =
        "\12\uffff";
    static final String DFA26_minS =
        "\2\56\2\uffff\1\53\1\uffff\2\60\2\uffff";
    static final String DFA26_maxS =
        "\1\71\1\146\2\uffff\1\71\1\uffff\1\71\1\146\2\uffff";
    static final String DFA26_acceptS =
        "\2\uffff\1\2\1\1\1\uffff\1\4\2\uffff\2\3";
    static final String DFA26_specialS =
        "\12\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\12\uffff\1\5\1\4\1\5\35\uffff\1\5\1\4\1"+
            "\5",
            "",
            "",
            "\1\6\1\uffff\1\6\2\uffff\12\7",
            "",
            "\12\7",
            "\12\7\12\uffff\1\11\1\uffff\1\11\35\uffff\1\11\1\uffff\1\11",
            "",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "403:1: VAL_FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatSuffix )? | ( '0' .. '9' )+ Exponent ( FloatSuffix )? | ( '0' .. '9' )+ ( Exponent )? FloatSuffix );";
        }
    }
    static final String DFA31_eotS =
        "\1\uffff\10\53\1\104\7\uffff\1\105\1\107\2\uffff\7\53\1\uffff\6"+
        "\53\4\uffff\2\106\1\53\4\uffff\21\53\1\u0083\3\53\5\uffff\14\53"+
        "\13\uffff\6\53\7\uffff\1\106\15\53\1\u00be\10\53\1\uffff\13\53\1"+
        "\u00d3\5\53\15\uffff\1\u00dd\5\53\1\u00ad\7\uffff\16\53\1\uffff"+
        "\2\53\1\u00f7\1\u00f8\13\53\1\u0104\4\53\1\uffff\1\53\1\u010a\3"+
        "\53\5\uffff\1\u010e\1\u010f\1\53\1\u0111\1\u0112\3\uffff\1\u0115"+
        "\3\53\1\u0119\14\53\2\uffff\7\53\1\u012d\3\53\1\uffff\3\53\1\u0134"+
        "\1\53\1\uffff\2\53\1\u0138\2\uffff\1\u0139\5\uffff\1\53\1\u013c"+
        "\1\53\1\uffff\1\53\1\u013f\3\53\1\u0143\10\53\1\u014c\1\53\1\u014e"+
        "\1\u014f\1\u0150\1\uffff\6\53\1\uffff\3\53\3\uffff\1\53\1\uffff"+
        "\2\53\1\uffff\3\53\1\uffff\1\u0161\3\53\1\u0165\1\53\1\u0167\1\53"+
        "\1\uffff\1\u0169\3\uffff\1\u016a\2\53\1\u016d\2\53\1\u0170\1\u0171"+
        "\1\53\1\uffff\6\53\1\uffff\1\u0179\1\53\1\u017b\1\uffff\1\53\1\uffff"+
        "\1\u017d\2\uffff\1\u017e\1\u017f\1\uffff\1\u0180\1\u0181\2\uffff"+
        "\1\u0182\1\53\1\u0184\1\u0185\3\53\1\uffff\1\53\1\uffff\1\u018a"+
        "\6\uffff\1\53\2\uffff\1\53\1\u018d\1\53\1\u018f\1\uffff\1\53\1\u0191"+
        "\1\uffff\1\53\1\uffff\1\u0193\1\uffff\1\u0194\2\uffff";
    static final String DFA31_eofS =
        "\u0195\uffff";
    static final String DFA31_minS =
        "\1\11\1\143\1\141\2\145\1\141\1\145\1\60\1\150\1\72\7\uffff\2\60"+
        "\2\uffff\1\137\1\150\1\154\1\141\1\156\1\157\1\143\1\141\1\145\2"+
        "\157\1\101\1\125\1\122\1\uffff\1\52\1\uffff\1\0\2\56\1\60\4\uffff"+
        "\1\143\2\164\1\144\1\156\1\155\1\165\1\156\1\161\1\145\1\143\2\163"+
        "\1\160\1\163\1\156\1\157\1\60\1\163\1\162\1\157\5\uffff\1\141\1"+
        "\156\1\141\1\145\1\143\1\156\1\157\1\164\1\145\3\164\2\154\1\uffff"+
        "\1\156\2\uffff\1\162\1\141\1\143\2\uffff\1\170\1\156\1\151\2\114"+
        "\1\125\2\uffff\2\0\2\uffff\2\56\1\150\1\151\1\162\1\145\1\144\1"+
        "\151\1\145\1\154\1\157\1\142\1\164\1\165\1\144\1\60\1\153\1\141"+
        "\2\164\1\145\1\151\1\141\1\154\1\uffff\1\164\1\151\2\162\1\145\1"+
        "\164\1\162\1\155\1\151\1\143\1\141\1\60\1\145\1\155\1\137\1\151"+
        "\1\145\6\uffff\1\151\1\uffff\1\161\4\uffff\1\60\1\147\1\144\1\123"+
        "\1\114\1\105\5\0\2\uffff\1\56\1\151\1\157\1\151\1\154\1\141\1\147"+
        "\1\154\1\157\1\156\1\154\2\151\1\165\1\145\1\uffff\1\141\1\155\2"+
        "\60\1\144\1\156\1\162\2\145\1\143\1\156\1\164\1\162\1\155\1\162"+
        "\1\60\1\145\1\154\2\164\1\uffff\1\147\1\60\1\144\1\157\1\164\5\uffff"+
        "\2\60\1\105\2\60\3\0\1\56\1\164\1\156\1\142\1\60\1\164\1\156\1\157"+
        "\1\171\1\163\1\145\1\155\1\162\1\143\1\162\1\147\1\145\2\uffff\2"+
        "\145\1\171\1\141\1\155\1\164\1\147\1\60\1\141\1\142\1\141\1\uffff"+
        "\1\156\2\151\1\60\1\145\1\uffff\1\145\1\156\1\60\2\uffff\1\60\2"+
        "\uffff\2\0\1\uffff\1\145\1\60\1\165\1\uffff\1\157\1\60\1\160\1\155"+
        "\1\164\1\60\2\145\2\164\1\145\1\164\1\146\1\163\1\60\1\156\3\60"+
        "\1\uffff\1\171\1\145\1\143\2\164\1\157\1\uffff\1\162\1\146\1\141"+
        "\2\uffff\1\0\1\143\1\uffff\1\164\1\162\1\uffff\1\155\1\145\1\162"+
        "\1\uffff\1\60\1\144\1\151\1\171\1\60\1\145\1\60\1\163\1\uffff\1"+
        "\60\3\uffff\1\60\1\162\1\164\1\60\1\171\1\156\2\60\1\154\1\0\1\164"+
        "\1\145\1\171\1\145\1\156\1\141\1\uffff\1\60\1\157\1\60\1\uffff\1"+
        "\162\1\uffff\1\60\2\uffff\2\60\1\uffff\2\60\2\uffff\1\60\1\165\2"+
        "\60\1\156\2\164\1\uffff\1\156\1\uffff\1\60\6\uffff\1\162\2\uffff"+
        "\1\164\1\60\1\157\1\60\1\uffff\1\145\1\60\1\uffff\1\162\1\uffff"+
        "\1\60\1\uffff\1\60\2\uffff";
    static final String DFA31_maxS =
        "\1\175\1\164\2\157\1\165\1\162\1\171\1\165\1\171\1\72\7\uffff\2"+
        "\71\2\uffff\1\137\1\157\1\154\1\165\1\164\1\157\1\160\1\166\1\145"+
        "\2\157\1\101\1\125\1\122\1\uffff\1\57\1\uffff\1\uffff\1\170\1\146"+
        "\1\61\4\uffff\1\143\2\164\1\144\1\156\1\166\1\165\1\156\1\161\1"+
        "\157\1\162\2\163\1\160\1\163\1\156\1\157\1\172\1\163\1\162\1\157"+
        "\5\uffff\1\155\1\156\1\141\1\145\1\143\1\156\1\157\1\166\1\145\3"+
        "\164\1\160\1\157\1\uffff\1\170\2\uffff\1\162\1\165\1\164\2\uffff"+
        "\1\170\1\156\1\151\2\114\1\125\2\uffff\2\uffff\2\uffff\2\146\1\150"+
        "\1\151\1\162\1\145\1\144\1\151\1\145\1\154\1\157\1\142\1\164\1\165"+
        "\1\160\1\172\1\153\1\141\2\164\1\145\1\151\1\141\1\154\1\uffff\1"+
        "\164\1\165\2\162\1\145\1\164\1\162\1\155\1\151\1\143\1\141\1\172"+
        "\1\145\1\155\1\137\1\151\1\145\6\uffff\1\157\1\uffff\1\164\4\uffff"+
        "\1\172\1\147\1\144\1\123\1\114\1\105\5\uffff\2\uffff\1\146\1\151"+
        "\1\157\1\151\1\154\1\141\1\147\1\154\1\157\1\156\1\154\2\151\1\165"+
        "\1\145\1\uffff\1\141\1\155\2\172\1\144\1\156\1\162\2\145\1\143\1"+
        "\156\1\164\1\162\1\155\1\162\1\172\1\145\1\154\2\164\1\uffff\1\147"+
        "\1\172\1\144\1\157\1\164\5\uffff\2\172\1\105\2\172\3\uffff\1\146"+
        "\1\164\1\156\1\142\1\172\1\164\1\156\1\157\1\171\1\163\1\145\1\155"+
        "\1\162\1\143\1\162\1\147\1\145\2\uffff\2\145\1\171\1\141\1\155\1"+
        "\164\1\147\1\172\1\141\1\142\1\141\1\uffff\1\156\2\151\1\172\1\145"+
        "\1\uffff\1\145\1\156\1\172\2\uffff\1\172\2\uffff\2\uffff\1\uffff"+
        "\1\145\1\172\1\165\1\uffff\1\157\1\172\1\160\1\155\1\164\1\172\2"+
        "\145\2\164\1\145\1\164\1\146\1\163\1\172\1\156\3\172\1\uffff\1\171"+
        "\1\145\1\143\2\164\1\157\1\uffff\1\162\1\146\1\141\2\uffff\1\uffff"+
        "\1\143\1\uffff\1\164\1\162\1\uffff\1\155\1\145\1\162\1\uffff\1\172"+
        "\1\144\1\151\1\171\1\172\1\145\1\172\1\163\1\uffff\1\172\3\uffff"+
        "\1\172\1\162\1\164\1\172\1\171\1\156\2\172\1\154\1\uffff\1\164\1"+
        "\145\1\171\1\145\1\156\1\141\1\uffff\1\172\1\157\1\172\1\uffff\1"+
        "\162\1\uffff\1\172\2\uffff\2\172\1\uffff\2\172\2\uffff\1\172\1\165"+
        "\2\172\1\156\2\164\1\uffff\1\156\1\uffff\1\172\6\uffff\1\162\2\uffff"+
        "\1\164\1\172\1\157\1\172\1\uffff\1\145\1\172\1\uffff\1\162\1\uffff"+
        "\1\172\1\uffff\1\172\2\uffff";
    static final String DFA31_acceptS =
        "\12\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\23\2\uffff\1\26\1\27"+
        "\16\uffff\1\121\1\uffff\1\124\4\uffff\1\132\1\133\1\134\1\135\25"+
        "\uffff\1\30\1\14\1\24\1\127\1\25\16\uffff\1\62\1\uffff\1\65\1\66"+
        "\3\uffff\1\100\1\101\6\uffff\1\122\1\123\2\uffff\1\125\1\126\30"+
        "\uffff\1\131\21\uffff\1\56\1\57\1\60\1\61\1\63\1\64\1\uffff\1\71"+
        "\1\uffff\1\74\1\75\1\76\1\77\13\uffff\1\136\1\125\17\uffff\1\51"+
        "\24\uffff\1\41\5\uffff\1\67\1\70\1\72\1\73\1\107\31\uffff\1\50\1"+
        "\10\13\uffff\1\104\5\uffff\1\42\3\uffff\1\111\1\115\1\uffff\1\117"+
        "\1\120\2\uffff\1\130\3\uffff\1\2\23\uffff\1\113\6\uffff\1\106\3"+
        "\uffff\1\112\1\116\2\uffff\1\33\2\uffff\1\3\3\uffff\1\105\10\uffff"+
        "\1\102\1\uffff\1\13\1\54\1\114\20\uffff\1\6\3\uffff\1\46\1\uffff"+
        "\1\55\1\uffff\1\103\1\31\2\uffff\1\36\2\uffff\1\110\1\44\7\uffff"+
        "\1\53\1\uffff\1\52\1\uffff\1\12\1\32\1\35\1\37\1\40\1\45\1\uffff"+
        "\1\34\1\43\4\uffff\1\47\2\uffff\1\5\1\uffff\1\7\1\uffff\1\4\1\uffff"+
        "\1\1\1\11";
    static final String DFA31_specialS =
        "\46\uffff\1\14\100\uffff\1\15\1\4\77\uffff\1\7\1\16\1\6\1\12\1"+
        "\0\66\uffff\1\1\1\5\1\11\55\uffff\1\2\1\10\45\uffff\1\3\37\uffff"+
        "\1\13\72\uffff}>";
    static final String[] DFA31_transitionS = {
            "\2\43\1\uffff\2\43\22\uffff\1\43\1\uffff\1\46\1\55\3\uffff"+
            "\1\45\1\13\1\14\1\uffff\1\22\1\20\1\21\1\52\1\44\1\47\11\50"+
            "\1\11\1\15\1\54\1\12\2\uffff\1\34\1\53\1\51\3\53\1\40\7\53\1"+
            "\41\5\53\1\42\6\53\1\16\1\uffff\1\17\1\uffff\1\25\1\uffff\1"+
            "\1\1\7\1\26\1\3\1\27\1\30\1\53\1\35\1\31\2\53\1\36\1\2\1\32"+
            "\1\33\1\5\1\53\1\4\1\10\1\6\1\53\1\37\4\53\1\23\1\uffff\1\24",
            "\1\57\16\uffff\1\56\1\uffff\1\60",
            "\1\62\15\uffff\1\61",
            "\1\63\11\uffff\1\64",
            "\1\66\17\uffff\1\65",
            "\1\70\15\uffff\1\71\2\uffff\1\67",
            "\1\72\23\uffff\1\73",
            "\2\77\67\uffff\1\75\5\uffff\1\76\5\uffff\1\74",
            "\1\102\13\uffff\1\101\4\uffff\1\100",
            "\1\103",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\106",
            "\12\106",
            "",
            "",
            "\1\110",
            "\1\112\6\uffff\1\111",
            "\1\113",
            "\1\114\12\uffff\1\116\10\uffff\1\115",
            "\1\117\5\uffff\1\120",
            "\1\121",
            "\1\123\14\uffff\1\122",
            "\1\124\1\uffff\1\125\1\126\1\127\6\uffff\1\130\1\uffff\1\131"+
            "\1\uffff\1\132\1\uffff\1\133\1\134\1\135\1\uffff\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "",
            "\1\146\4\uffff\1\145",
            "",
            "\42\150\1\151\71\150\1\147\uffa3\150",
            "\1\52\1\uffff\10\153\2\52\12\uffff\3\52\21\uffff\1\152\13"+
            "\uffff\3\52\21\uffff\1\152",
            "\1\52\1\uffff\12\154\12\uffff\3\52\35\uffff\3\52",
            "\2\77",
            "",
            "",
            "",
            "",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\165\2\uffff\1\164\2\uffff\1\162\2\uffff\1\163",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\172\11\uffff\1\171",
            "\1\173\16\uffff\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\2\77\10\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "",
            "",
            "",
            "",
            "",
            "\1\u0087\13\uffff\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u0090\1\uffff\1\u008f",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095\3\uffff\1\u0096",
            "\1\u0097\2\uffff\1\u0098",
            "",
            "\1\u0099\11\uffff\1\u009a",
            "",
            "",
            "\1\u009b",
            "\1\u009c\3\uffff\1\u009d\17\uffff\1\u009e",
            "\1\u009f\14\uffff\1\u00a0\3\uffff\1\u00a1",
            "",
            "",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "",
            "",
            "\42\u00ad\1\u00a8\4\u00ad\1\u00ac\10\u00ad\4\u00aa\4\u00ab"+
            "\44\u00ad\1\u00ac\5\u00ad\1\u00ac\3\u00ad\1\u00ac\7\u00ad\1"+
            "\u00ac\3\u00ad\1\u00ac\1\u00ad\1\u00ac\1\u00a9\uff8a\u00ad",
            "\42\150\1\151\71\150\1\147\uffa3\150",
            "",
            "",
            "\1\52\1\uffff\10\u00af\2\52\12\uffff\3\52\35\uffff\3\52",
            "\1\52\1\uffff\12\154\12\uffff\3\52\35\uffff\3\52",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc\13\uffff\1\u00bd",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "",
            "\1\u00c7",
            "\1\u00c9\13\uffff\1\u00c8",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00d9\5\uffff\1\u00da",
            "",
            "\1\u00db\2\uffff\1\u00dc",
            "",
            "",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\0\u00ae",
            "\60\u00ad\12\u00e3\7\u00ad\6\u00e3\32\u00ad\6\u00e3\uff99"+
            "\u00ad",
            "\42\150\1\151\15\150\10\u00e4\44\150\1\147\uffa3\150",
            "\42\150\1\151\15\150\10\u00e5\44\150\1\147\uffa3\150",
            "\42\150\1\151\71\150\1\147\uffa3\150",
            "",
            "",
            "\1\52\1\uffff\10\u00e6\2\52\12\uffff\3\52\35\uffff\3\52",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "",
            "\1\u00f5",
            "\1\u00f6",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "",
            "\1\u0109",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "",
            "",
            "",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0110",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\60\u00ad\12\u0113\7\u00ad\6\u0113\32\u00ad\6\u0113\uff99"+
            "\u00ad",
            "\42\150\1\151\15\150\10\u0114\44\150\1\147\uffa3\150",
            "\42\150\1\151\71\150\1\147\uffa3\150",
            "\1\52\1\uffff\12\52\12\uffff\3\52\35\uffff\3\52",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "",
            "",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0135",
            "",
            "\1\u0136",
            "\1\u0137",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "\60\u00ad\12\u013a\7\u00ad\6\u013a\32\u00ad\6\u013a\uff99"+
            "\u00ad",
            "\42\150\1\151\71\150\1\147\uffa3\150",
            "",
            "\1\u013b",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u013d",
            "",
            "\1\u013e",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u014d",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "",
            "",
            "\60\u00ad\12\u015a\7\u00ad\6\u015a\32\u00ad\6\u015a\uff99"+
            "\u00ad",
            "\1\u015b",
            "",
            "\1\u015c",
            "\1\u015d",
            "",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0166",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0168",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u016b",
            "\1\u016c",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u016e",
            "\1\u016f",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0172",
            "\42\150\1\151\71\150\1\147\uffa3\150",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u017a",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u017c",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0183",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188",
            "",
            "\1\u0189",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u018b",
            "",
            "",
            "\1\u018c",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u018e",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u0190",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u0192",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | ARRAY | MEMBER | ACTION | ATTRIBUTE | CONTRACT | ELEMENT | FACILITY | FUNCTION | INV | ITEM | MANDATORY | NOT_DEF | OPTIONAL | PACKAGE | PARAMETER | POST | PRE | PROPERTY | REQUIRED | STRUCT | TYPEDEF | AT_ALTERABLE | AT_APPLY | AT_CLEVEL | AT_CONTAINS | AT_DESCRIPTION | AT_ENVIRONMENT | AT_EXTENDS | AT_LANGUAGE | AT_NEGOTIABLE | AT_PRIORITY | AT_PROVIDES | AT_RANK | AT_REQUIRES | AT_RETURN | AT_RUNTIME | AT_SCOPE | AT_SPEC | AT_STAGE | AT_TYPE | AT_VISIBILITY | BINARY | BOOLEAN | CHAR | DOUBLE | FLOAT | HEX | INTEGER | LONG | OCTET | SHORT | STRING | VOID | COLA_FALSE | COLA_NULL | COLA_TRUE | WS | SL_COMMENT | ML_COMMENT | VAL_CHAR | VAL_STRING | VAL_HEX | VAL_INTEGER | VAL_OCT | VAL_BINARY | VAL_FLOAT | IDENT | INLINE_CODE | CPP_DIRECTIVE | CPP_FILENAME );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_172 = input.LA(1);

                        s = -1;
                        if ( (LA31_172=='\"') ) {s = 105;}

                        else if ( (LA31_172=='\\') ) {s = 103;}

                        else if ( ((LA31_172>='\u0000' && LA31_172<='!')||(LA31_172>='#' && LA31_172<='[')||(LA31_172>=']' && LA31_172<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_227 = input.LA(1);

                        s = -1;
                        if ( ((LA31_227>='0' && LA31_227<='9')||(LA31_227>='A' && LA31_227<='F')||(LA31_227>='a' && LA31_227<='f')) ) {s = 275;}

                        else if ( ((LA31_227>='\u0000' && LA31_227<='/')||(LA31_227>=':' && LA31_227<='@')||(LA31_227>='G' && LA31_227<='`')||(LA31_227>='g' && LA31_227<='\uFFFF')) ) {s = 173;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_275 = input.LA(1);

                        s = -1;
                        if ( ((LA31_275>='0' && LA31_275<='9')||(LA31_275>='A' && LA31_275<='F')||(LA31_275>='a' && LA31_275<='f')) ) {s = 314;}

                        else if ( ((LA31_275>='\u0000' && LA31_275<='/')||(LA31_275>=':' && LA31_275<='@')||(LA31_275>='G' && LA31_275<='`')||(LA31_275>='g' && LA31_275<='\uFFFF')) ) {s = 173;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA31_314 = input.LA(1);

                        s = -1;
                        if ( ((LA31_314>='0' && LA31_314<='9')||(LA31_314>='A' && LA31_314<='F')||(LA31_314>='a' && LA31_314<='f')) ) {s = 346;}

                        else if ( ((LA31_314>='\u0000' && LA31_314<='/')||(LA31_314>=':' && LA31_314<='@')||(LA31_314>='G' && LA31_314<='`')||(LA31_314>='g' && LA31_314<='\uFFFF')) ) {s = 173;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA31_104 = input.LA(1);

                        s = -1;
                        if ( (LA31_104=='\"') ) {s = 105;}

                        else if ( (LA31_104=='\\') ) {s = 103;}

                        else if ( ((LA31_104>='\u0000' && LA31_104<='!')||(LA31_104>='#' && LA31_104<='[')||(LA31_104>=']' && LA31_104<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA31_228 = input.LA(1);

                        s = -1;
                        if ( ((LA31_228>='0' && LA31_228<='7')) ) {s = 276;}

                        else if ( (LA31_228=='\"') ) {s = 105;}

                        else if ( (LA31_228=='\\') ) {s = 103;}

                        else if ( ((LA31_228>='\u0000' && LA31_228<='!')||(LA31_228>='#' && LA31_228<='/')||(LA31_228>='8' && LA31_228<='[')||(LA31_228>=']' && LA31_228<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA31_170 = input.LA(1);

                        s = -1;
                        if ( ((LA31_170>='0' && LA31_170<='7')) ) {s = 228;}

                        else if ( (LA31_170=='\"') ) {s = 105;}

                        else if ( (LA31_170=='\\') ) {s = 103;}

                        else if ( ((LA31_170>='\u0000' && LA31_170<='!')||(LA31_170>='#' && LA31_170<='/')||(LA31_170>='8' && LA31_170<='[')||(LA31_170>=']' && LA31_170<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA31_168 = input.LA(1);

                        s = -1;
                        if ( ((LA31_168>='\u0000' && LA31_168<='\uFFFF')) ) {s = 174;}

                        else s = 173;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA31_276 = input.LA(1);

                        s = -1;
                        if ( (LA31_276=='\"') ) {s = 105;}

                        else if ( (LA31_276=='\\') ) {s = 103;}

                        else if ( ((LA31_276>='\u0000' && LA31_276<='!')||(LA31_276>='#' && LA31_276<='[')||(LA31_276>=']' && LA31_276<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA31_229 = input.LA(1);

                        s = -1;
                        if ( (LA31_229=='\"') ) {s = 105;}

                        else if ( (LA31_229=='\\') ) {s = 103;}

                        else if ( ((LA31_229>='\u0000' && LA31_229<='!')||(LA31_229>='#' && LA31_229<='[')||(LA31_229>=']' && LA31_229<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA31_171 = input.LA(1);

                        s = -1;
                        if ( ((LA31_171>='0' && LA31_171<='7')) ) {s = 229;}

                        else if ( (LA31_171=='\"') ) {s = 105;}

                        else if ( (LA31_171=='\\') ) {s = 103;}

                        else if ( ((LA31_171>='\u0000' && LA31_171<='!')||(LA31_171>='#' && LA31_171<='/')||(LA31_171>='8' && LA31_171<='[')||(LA31_171>=']' && LA31_171<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA31_346 = input.LA(1);

                        s = -1;
                        if ( (LA31_346=='\"') ) {s = 105;}

                        else if ( (LA31_346=='\\') ) {s = 103;}

                        else if ( ((LA31_346>='\u0000' && LA31_346<='!')||(LA31_346>='#' && LA31_346<='[')||(LA31_346>=']' && LA31_346<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA31_38 = input.LA(1);

                        s = -1;
                        if ( (LA31_38=='\\') ) {s = 103;}

                        else if ( ((LA31_38>='\u0000' && LA31_38<='!')||(LA31_38>='#' && LA31_38<='[')||(LA31_38>=']' && LA31_38<='\uFFFF')) ) {s = 104;}

                        else if ( (LA31_38=='\"') ) {s = 105;}

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA31_103 = input.LA(1);

                        s = -1;
                        if ( (LA31_103=='\"') ) {s = 168;}

                        else if ( (LA31_103=='u') ) {s = 169;}

                        else if ( ((LA31_103>='0' && LA31_103<='3')) ) {s = 170;}

                        else if ( ((LA31_103>='4' && LA31_103<='7')) ) {s = 171;}

                        else if ( (LA31_103=='\''||LA31_103=='\\'||LA31_103=='b'||LA31_103=='f'||LA31_103=='n'||LA31_103=='r'||LA31_103=='t') ) {s = 172;}

                        else if ( ((LA31_103>='\u0000' && LA31_103<='!')||(LA31_103>='#' && LA31_103<='&')||(LA31_103>='(' && LA31_103<='/')||(LA31_103>='8' && LA31_103<='[')||(LA31_103>=']' && LA31_103<='a')||(LA31_103>='c' && LA31_103<='e')||(LA31_103>='g' && LA31_103<='m')||(LA31_103>='o' && LA31_103<='q')||LA31_103=='s'||(LA31_103>='v' && LA31_103<='\uFFFF')) ) {s = 173;}

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA31_169 = input.LA(1);

                        s = -1;
                        if ( ((LA31_169>='0' && LA31_169<='9')||(LA31_169>='A' && LA31_169<='F')||(LA31_169>='a' && LA31_169<='f')) ) {s = 227;}

                        else if ( ((LA31_169>='\u0000' && LA31_169<='/')||(LA31_169>=':' && LA31_169<='@')||(LA31_169>='G' && LA31_169<='`')||(LA31_169>='g' && LA31_169<='\uFFFF')) ) {s = 173;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}