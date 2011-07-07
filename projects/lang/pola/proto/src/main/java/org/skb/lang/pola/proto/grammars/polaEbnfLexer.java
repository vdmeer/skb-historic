// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g 2011-07-07 22:24:50

  package org.skb.lang.pola.proto.grammars;

  import org.skb.util.ReportManager;
  import org.skb.lang.pola.proto.PolaTokensConstants;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class polaEbnfLexer extends Lexer {
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

    public polaEbnfLexer() {;} 
    public polaEbnfLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public polaEbnfLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g"; }

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:31:7: ( 'architecture' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:31:9: 'architecture'
            {
            match("architecture"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:32:7: ( 'model' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:32:9: 'model'
            {
            match("model"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:33:7: ( 'design' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:33:9: 'design'
            {
            match("design"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:34:7: ( 'development' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:34:9: 'development'
            {
            match("development"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:35:7: ( 'deployment' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:35:9: 'deployment'
            {
            match("deployment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:36:7: ( 'runtime' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:36:9: 'runtime'
            {
            match("runtime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:37:7: ( 'production' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:37:9: 'production'
            {
            match("production"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:38:7: ( 'test' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:38:9: 'test'
            {
            match("test"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:39:7: ( 'demonstrator' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:39:9: 'demonstrator'
            {
            match("demonstrator"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:40:7: ( 'business' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:40:9: 'business'
            {
            match("business"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:41:7: ( 'system' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:41:9: 'system'
            {
            match("system"); 


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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:42:7: ( 'element' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:42:9: 'element'
            {
            match("element"); 


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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:43:7: ( ';' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:43:9: ';'
            {
            match(';'); 

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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:44:7: ( '{' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:44:9: '{'
            {
            match('{'); 

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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:45:7: ( '}' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:45:9: '}'
            {
            match('}'); 

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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:46:7: ( '=' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:46:9: '='
            {
            match('='); 

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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:47:7: ( 'administration' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:47:9: 'administration'
            {
            match("administration"); 


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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:48:7: ( 'device' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:48:9: 'device'
            {
            match("device"); 


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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:49:7: ( 'instance' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:49:9: 'instance'
            {
            match("instance"); 


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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:50:7: ( '::=' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:50:9: '::='
            {
            match("::="); 


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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:51:7: ( ':' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:51:9: ':'
            {
            match(':'); 

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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:52:7: ( '::' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:52:9: '::'
            {
            match("::"); 


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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:53:7: ( '[' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:53:9: '['
            {
            match('['); 

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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:54:7: ( ']' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:54:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "ARRAY"
    public final void mARRAY() throws RecognitionException {
        try {
            int _type = ARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:221:15: ( '__array' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:221:17: '__array'
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

    // $ANTLR start "BODY"
    public final void mBODY() throws RecognitionException {
        try {
            int _type = BODY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:222:15: ( '__body' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:222:17: '__body'
            {
            match("__body"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BODY"

    // $ANTLR start "STRUCT"
    public final void mSTRUCT() throws RecognitionException {
        try {
            int _type = STRUCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:242:15: ( 'struct' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:242:17: 'struct'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:243:15: ( 'typedef' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:243:17: 'typedef'
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

    // $ANTLR start "POLA_PC_LEVEL"
    public final void mPOLA_PC_LEVEL() throws RecognitionException {
        try {
            int _type = POLA_PC_LEVEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:246:26: ( 'continuum-level' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:246:28: 'continuum-level'
            {
            match("continuum-level"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_PC_LEVEL"

    // $ANTLR start "POLA_COMPOSITE"
    public final void mPOLA_COMPOSITE() throws RecognitionException {
        try {
            int _type = POLA_COMPOSITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:248:26: ( 'composite' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:248:28: 'composite'
            {
            match("composite"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_COMPOSITE"

    // $ANTLR start "POLA_ATOMIC"
    public final void mPOLA_ATOMIC() throws RecognitionException {
        try {
            int _type = POLA_ATOMIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:249:26: ( 'atomic' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:249:28: 'atomic'
            {
            match("atomic"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_ATOMIC"

    // $ANTLR start "POLA_GROUP"
    public final void mPOLA_GROUP() throws RecognitionException {
        try {
            int _type = POLA_GROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:250:26: ( 'group' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:250:28: 'group'
            {
            match("group"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_GROUP"

    // $ANTLR start "POLA_NONSTD"
    public final void mPOLA_NONSTD() throws RecognitionException {
        try {
            int _type = POLA_NONSTD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:251:26: ( 'nonstd' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:251:28: 'nonstd'
            {
            match("nonstd"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_NONSTD"

    // $ANTLR start "POLA_RULE_STRUCT_ECA"
    public final void mPOLA_RULE_STRUCT_ECA() throws RecognitionException {
        try {
            int _type = POLA_RULE_STRUCT_ECA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:253:26: ( 'eca' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:253:28: 'eca'
            {
            match("eca"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_RULE_STRUCT_ECA"

    // $ANTLR start "POLA_RULE_STRUCT_GOAL"
    public final void mPOLA_RULE_STRUCT_GOAL() throws RecognitionException {
        try {
            int _type = POLA_RULE_STRUCT_GOAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:254:26: ( 'goal' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:254:28: 'goal'
            {
            match("goal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_RULE_STRUCT_GOAL"

    // $ANTLR start "POLA_RULE_STRUCT_UTIL"
    public final void mPOLA_RULE_STRUCT_UTIL() throws RecognitionException {
        try {
            int _type = POLA_RULE_STRUCT_UTIL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:255:26: ( 'util' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:255:28: 'util'
            {
            match("util"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_RULE_STRUCT_UTIL"

    // $ANTLR start "POLA_ACTION"
    public final void mPOLA_ACTION() throws RecognitionException {
        try {
            int _type = POLA_ACTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:257:26: ( 'action' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:257:28: 'action'
            {
            match("action"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_ACTION"

    // $ANTLR start "POLA_CONDITION"
    public final void mPOLA_CONDITION() throws RecognitionException {
        try {
            int _type = POLA_CONDITION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:258:26: ( 'condition' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:258:28: 'condition'
            {
            match("condition"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_CONDITION"

    // $ANTLR start "POLA_EVENT"
    public final void mPOLA_EVENT() throws RecognitionException {
        try {
            int _type = POLA_EVENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:259:26: ( 'event' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:259:28: 'event'
            {
            match("event"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_EVENT"

    // $ANTLR start "POLA_POLICY"
    public final void mPOLA_POLICY() throws RecognitionException {
        try {
            int _type = POLA_POLICY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:260:26: ( 'policy' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:260:28: 'policy'
            {
            match("policy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_POLICY"

    // $ANTLR start "POLA_SEQ_NUMER"
    public final void mPOLA_SEQ_NUMER() throws RecognitionException {
        try {
            int _type = POLA_SEQ_NUMER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:262:26: ( 'seq-number' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:262:28: 'seq-number'
            {
            match("seq-number"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_SEQ_NUMER"

    // $ANTLR start "POLA_HASBEEN_EVALED"
    public final void mPOLA_HASBEEN_EVALED() throws RecognitionException {
        try {
            int _type = POLA_HASBEEN_EVALED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:263:26: ( 'evaluated' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:263:28: 'evaluated'
            {
            match("evaluated"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_HASBEEN_EVALED"

    // $ANTLR start "POLA_DEONT_AUTH"
    public final void mPOLA_DEONT_AUTH() throws RecognitionException {
        try {
            int _type = POLA_DEONT_AUTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:265:26: ( 'authorization' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:265:28: 'authorization'
            {
            match("authorization"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_DEONT_AUTH"

    // $ANTLR start "POLA_DEONT_EXEM"
    public final void mPOLA_DEONT_EXEM() throws RecognitionException {
        try {
            int _type = POLA_DEONT_EXEM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:266:26: ( 'exemption' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:266:28: 'exemption'
            {
            match("exemption"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_DEONT_EXEM"

    // $ANTLR start "POLA_DEONT_OBLG"
    public final void mPOLA_DEONT_OBLG() throws RecognitionException {
        try {
            int _type = POLA_DEONT_OBLG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:267:26: ( 'obligation' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:267:28: 'obligation'
            {
            match("obligation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_DEONT_OBLG"

    // $ANTLR start "POLA_DEONT_PROH"
    public final void mPOLA_DEONT_PROH() throws RecognitionException {
        try {
            int _type = POLA_DEONT_PROH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:268:26: ( 'prohibition' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:268:28: 'prohibition'
            {
            match("prohibition"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_DEONT_PROH"

    // $ANTLR start "POLA_MEPO_DELE"
    public final void mPOLA_MEPO_DELE() throws RecognitionException {
        try {
            int _type = POLA_MEPO_DELE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:270:26: ( 'delegation' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:270:28: 'delegation'
            {
            match("delegation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_MEPO_DELE"

    // $ANTLR start "POLA_MEPO_REVO"
    public final void mPOLA_MEPO_REVO() throws RecognitionException {
        try {
            int _type = POLA_MEPO_REVO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:271:26: ( 'revocation' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:271:28: 'revocation'
            {
            match("revocation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_MEPO_REVO"

    // $ANTLR start "AT_CLEVEL"
    public final void mAT_CLEVEL() throws RecognitionException {
        try {
            int _type = AT_CLEVEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:277:20: ( '@clevel' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:277:22: '@clevel'
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

    // $ANTLR start "AT_ENVIRONMENT"
    public final void mAT_ENVIRONMENT() throws RecognitionException {
        try {
            int _type = AT_ENVIRONMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:280:20: ( '@environment' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:280:22: '@environment'
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

    // $ANTLR start "AT_LANGUAGE"
    public final void mAT_LANGUAGE() throws RecognitionException {
        try {
            int _type = AT_LANGUAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:282:20: ( '@language' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:282:22: '@language'
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

    // $ANTLR start "AT_PROVIDES"
    public final void mAT_PROVIDES() throws RecognitionException {
        try {
            int _type = AT_PROVIDES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:285:20: ( '@provides' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:285:22: '@provides'
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

    // $ANTLR start "AT_SCOPE"
    public final void mAT_SCOPE() throws RecognitionException {
        try {
            int _type = AT_SCOPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:290:20: ( '@scope' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:290:22: '@scope'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:291:20: ( '@spec' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:291:22: '@spec'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:292:20: ( '@stage' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:292:22: '@stage'
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

    // $ANTLR start "BINARY"
    public final void mBINARY() throws RecognitionException {
        try {
            int _type = BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:297:15: ( 'binary' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:297:17: 'binary'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:298:15: ( 'boolean' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:298:17: 'boolean'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:299:15: ( 'char' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:299:17: 'char'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:300:15: ( 'double' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:300:17: 'double'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:301:15: ( 'float' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:301:17: 'float'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:302:15: ( 'hex' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:302:17: 'hex'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:303:15: ( 'integer' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:303:17: 'integer'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:304:15: ( 'long' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:304:17: 'long'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:305:15: ( 'octet' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:305:17: 'octet'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:306:15: ( 'short' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:306:17: 'short'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:307:15: ( 'string' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:307:17: 'string'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:308:15: ( 'void' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:308:17: 'void'
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

    // $ANTLR start "POLA_FALSE"
    public final void mPOLA_FALSE() throws RecognitionException {
        try {
            int _type = POLA_FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:311:15: ( 'FALSE' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:311:17: 'FALSE'
            {
            match("FALSE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_FALSE"

    // $ANTLR start "POLA_NULL"
    public final void mPOLA_NULL() throws RecognitionException {
        try {
            int _type = POLA_NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:312:15: ( 'NULL' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:312:17: 'NULL'
            {
            match("NULL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_NULL"

    // $ANTLR start "POLA_TRUE"
    public final void mPOLA_TRUE() throws RecognitionException {
        try {
            int _type = POLA_TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:313:15: ( 'TRUE' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:313:17: 'TRUE'
            {
            match("TRUE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POLA_TRUE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:315:15: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:315:17: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:316:15: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:316:17: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:316:22: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:316:22: ~ ( '\\n' | '\\r' )
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

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:316:36: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:316:36: '\\r'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:317:15: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:317:17: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:317:22: ( options {greedy=false; } : . )*
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
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:317:50: .
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:318:15: ( '\\'' ( ESC | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:318:17: '\\'' ( ESC | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:318:22: ( ESC | ~ ( '\\'' | '\\\\' ) )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:318:24: ESC
                    {
                    mESC(); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:318:30: ~ ( '\\'' | '\\\\' )
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:319:15: ( '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:319:17: '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:319:21: ( ESC | ~ ( '\\\\' | '\"' ) )*
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
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:319:23: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:319:29: ~ ( '\\\\' | '\"' )
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:321:15: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEscape | OctalEscape )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:321:17: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:321:61: UnicodeEscape
                    {
                    mUnicodeEscape(); 

                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:321:77: OctalEscape
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:15: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:17: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:22: ( '0' .. '3' )
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:23: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:33: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:34: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:44: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:45: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:57: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:62: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:63: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:73: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:74: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:86: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:91: ( '0' .. '7' )
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:323:92: '0' .. '7'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:325:15: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:325:17: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:328:15: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:328:17: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:329:15: ( '0' ( 'x' | 'X' ) ( HexDigit )+ )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:329:17: '0' ( 'x' | 'X' ) ( HexDigit )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:329:31: ( HexDigit )+
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
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:329:31: HexDigit
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:331:15: ( ( '+' | '-' )? ( '0' | '1' .. '9' ( '0' .. '9' )* ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:331:17: ( '+' | '-' )? ( '0' | '1' .. '9' ( '0' .. '9' )* )
            {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:331:17: ( '+' | '-' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='+'||LA9_0=='-') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:
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

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:331:30: ( '0' | '1' .. '9' ( '0' .. '9' )* )
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:331:31: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:331:37: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:331:46: ( '0' .. '9' )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:331:46: '0' .. '9'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:334:15: ( ( '0' .. '7' ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:334:17: ( '0' .. '7' )
            {
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:334:17: ( '0' .. '7' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:334:18: '0' .. '7'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:335:15: ( '0' OctDigit OctDigit OctDigit )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:335:17: '0' OctDigit OctDigit OctDigit
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:338:15: ( ( '0' | '1' ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:338:17: ( '0' | '1' )
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:339:15: ( ( 'b' | 'B' ) ( BinDigit )+ )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:339:17: ( 'b' | 'B' ) ( BinDigit )+
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:339:29: ( BinDigit )+
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
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:339:30: BinDigit
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:342:15: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:342:17: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:342:27: ( '+' | '-' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='+'||LA13_0=='-') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:
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

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:342:38: ( '0' .. '9' )+
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
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:342:39: '0' .. '9'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:344:15: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:344:17: ( 'f' | 'F' | 'd' | 'D' )
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:345:15: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatSuffix )? | ( '0' .. '9' )+ Exponent ( FloatSuffix )? | ( '0' .. '9' )+ ( Exponent )? FloatSuffix )
            int alt26=4;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:345:19: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatSuffix )?
                    {
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:345:19: ( '0' .. '9' )+
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
                    	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:345:20: '0' .. '9'
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:345:35: ( '0' .. '9' )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:345:36: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:345:47: ( Exponent )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='E'||LA17_0=='e') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:345:47: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:345:57: ( FloatSuffix )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='D'||LA18_0=='F'||LA18_0=='d'||LA18_0=='f') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:345:57: FloatSuffix
                            {
                            mFloatSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:346:19: '.' ( '0' .. '9' )+ ( Exponent )? ( FloatSuffix )?
                    {
                    match('.'); 
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:346:23: ( '0' .. '9' )+
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
                    	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:346:24: '0' .. '9'
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

                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:346:35: ( Exponent )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='E'||LA20_0=='e') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:346:35: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:346:45: ( FloatSuffix )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='D'||LA21_0=='F'||LA21_0=='d'||LA21_0=='f') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:346:45: FloatSuffix
                            {
                            mFloatSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:347:19: ( '0' .. '9' )+ Exponent ( FloatSuffix )?
                    {
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:347:19: ( '0' .. '9' )+
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
                    	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:347:20: '0' .. '9'
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
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:347:40: ( FloatSuffix )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='D'||LA23_0=='F'||LA23_0=='d'||LA23_0=='f') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:347:40: FloatSuffix
                            {
                            mFloatSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:348:19: ( '0' .. '9' )+ ( Exponent )? FloatSuffix
                    {
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:348:19: ( '0' .. '9' )+
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
                    	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:348:20: '0' .. '9'
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

                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:348:31: ( Exponent )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0=='E'||LA25_0=='e') ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:348:31: Exponent
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:351:15: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:351:17: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:351:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='0' && LA27_0<='9')||(LA27_0>='A' && LA27_0<='Z')||LA27_0=='_'||(LA27_0>='a' && LA27_0<='z')) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:
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

    // $ANTLR start "CPP_DIRECTIVE"
    public final void mCPP_DIRECTIVE() throws RecognitionException {
        try {
            int _type = CPP_DIRECTIVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken CPP_FILENAME1=null;

            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:354:15: ( '#' 'file' ' ' CPP_FILENAME ( '\\r' )? '\\n' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:354:17: '#' 'file' ' ' CPP_FILENAME ( '\\r' )? '\\n'
            {
            match('#'); 
            match("file"); 

            match(' '); 
            int CPP_FILENAME1Start1711 = getCharIndex();
            int CPP_FILENAME1StartLine1711 = getLine();
            int CPP_FILENAME1StartCharPos1711 = getCharPositionInLine();
            mCPP_FILENAME(); 
            CPP_FILENAME1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, CPP_FILENAME1Start1711, getCharIndex()-1);
            CPP_FILENAME1.setLine(CPP_FILENAME1StartLine1711);
            CPP_FILENAME1.setCharPositionInLine(CPP_FILENAME1StartCharPos1711);
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:354:45: ( '\\r' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0=='\r') ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:354:45: '\\r'
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
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:355:15: ( '\"' (~ '\"' )* '\"' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:355:17: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:355:21: (~ '\"' )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>='\u0000' && LA29_0<='!')||(LA29_0>='#' && LA29_0<='\uFFFF')) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:355:22: ~ '\"'
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
            	    break loop29;
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

    // $ANTLR start "VAL_DSTRING"
    public final void mVAL_DSTRING() throws RecognitionException {
        try {
            int _type = VAL_DSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:357:15: ( '<' ( ESC | ~ ( '\\\\' | '>' ) )* '>' )
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:357:17: '<' ( ESC | ~ ( '\\\\' | '>' ) )* '>'
            {
            match('<'); 
            // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:357:21: ( ESC | ~ ( '\\\\' | '>' ) )*
            loop30:
            do {
                int alt30=3;
                int LA30_0 = input.LA(1);

                if ( (LA30_0=='\\') ) {
                    alt30=1;
                }
                else if ( ((LA30_0>='\u0000' && LA30_0<='=')||(LA30_0>='?' && LA30_0<='[')||(LA30_0>=']' && LA30_0<='\uFFFF')) ) {
                    alt30=2;
                }


                switch (alt30) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:357:23: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:357:29: ~ ( '\\\\' | '>' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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

            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAL_DSTRING"

    public void mTokens() throws RecognitionException {
        // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:8: ( T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | ARRAY | BODY | STRUCT | TYPEDEF | POLA_PC_LEVEL | POLA_COMPOSITE | POLA_ATOMIC | POLA_GROUP | POLA_NONSTD | POLA_RULE_STRUCT_ECA | POLA_RULE_STRUCT_GOAL | POLA_RULE_STRUCT_UTIL | POLA_ACTION | POLA_CONDITION | POLA_EVENT | POLA_POLICY | POLA_SEQ_NUMER | POLA_HASBEEN_EVALED | POLA_DEONT_AUTH | POLA_DEONT_EXEM | POLA_DEONT_OBLG | POLA_DEONT_PROH | POLA_MEPO_DELE | POLA_MEPO_REVO | AT_CLEVEL | AT_ENVIRONMENT | AT_LANGUAGE | AT_PROVIDES | AT_SCOPE | AT_SPEC | AT_STAGE | BINARY | BOOLEAN | CHAR | DOUBLE | FLOAT | HEX | INTEGER | LONG | OCTET | SHORT | STRING | VOID | POLA_FALSE | POLA_NULL | POLA_TRUE | WS | SL_COMMENT | ML_COMMENT | VAL_CHAR | VAL_STRING | VAL_HEX | VAL_INTEGER | VAL_OCT | VAL_BINARY | VAL_FLOAT | IDENT | CPP_DIRECTIVE | CPP_FILENAME | VAL_DSTRING )
        int alt31=84;
        alt31 = dfa31.predict(input);
        switch (alt31) {
            case 1 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:10: T__72
                {
                mT__72(); 

                }
                break;
            case 2 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:16: T__73
                {
                mT__73(); 

                }
                break;
            case 3 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:22: T__74
                {
                mT__74(); 

                }
                break;
            case 4 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:28: T__75
                {
                mT__75(); 

                }
                break;
            case 5 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:34: T__76
                {
                mT__76(); 

                }
                break;
            case 6 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:40: T__77
                {
                mT__77(); 

                }
                break;
            case 7 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:46: T__78
                {
                mT__78(); 

                }
                break;
            case 8 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:52: T__79
                {
                mT__79(); 

                }
                break;
            case 9 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:58: T__80
                {
                mT__80(); 

                }
                break;
            case 10 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:64: T__81
                {
                mT__81(); 

                }
                break;
            case 11 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:70: T__82
                {
                mT__82(); 

                }
                break;
            case 12 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:76: T__83
                {
                mT__83(); 

                }
                break;
            case 13 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:82: T__84
                {
                mT__84(); 

                }
                break;
            case 14 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:88: T__85
                {
                mT__85(); 

                }
                break;
            case 15 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:94: T__86
                {
                mT__86(); 

                }
                break;
            case 16 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:100: T__87
                {
                mT__87(); 

                }
                break;
            case 17 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:106: T__88
                {
                mT__88(); 

                }
                break;
            case 18 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:112: T__89
                {
                mT__89(); 

                }
                break;
            case 19 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:118: T__90
                {
                mT__90(); 

                }
                break;
            case 20 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:124: T__91
                {
                mT__91(); 

                }
                break;
            case 21 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:130: T__92
                {
                mT__92(); 

                }
                break;
            case 22 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:136: T__93
                {
                mT__93(); 

                }
                break;
            case 23 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:142: T__94
                {
                mT__94(); 

                }
                break;
            case 24 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:148: T__95
                {
                mT__95(); 

                }
                break;
            case 25 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:154: ARRAY
                {
                mARRAY(); 

                }
                break;
            case 26 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:160: BODY
                {
                mBODY(); 

                }
                break;
            case 27 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:165: STRUCT
                {
                mSTRUCT(); 

                }
                break;
            case 28 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:172: TYPEDEF
                {
                mTYPEDEF(); 

                }
                break;
            case 29 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:180: POLA_PC_LEVEL
                {
                mPOLA_PC_LEVEL(); 

                }
                break;
            case 30 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:194: POLA_COMPOSITE
                {
                mPOLA_COMPOSITE(); 

                }
                break;
            case 31 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:209: POLA_ATOMIC
                {
                mPOLA_ATOMIC(); 

                }
                break;
            case 32 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:221: POLA_GROUP
                {
                mPOLA_GROUP(); 

                }
                break;
            case 33 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:232: POLA_NONSTD
                {
                mPOLA_NONSTD(); 

                }
                break;
            case 34 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:244: POLA_RULE_STRUCT_ECA
                {
                mPOLA_RULE_STRUCT_ECA(); 

                }
                break;
            case 35 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:265: POLA_RULE_STRUCT_GOAL
                {
                mPOLA_RULE_STRUCT_GOAL(); 

                }
                break;
            case 36 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:287: POLA_RULE_STRUCT_UTIL
                {
                mPOLA_RULE_STRUCT_UTIL(); 

                }
                break;
            case 37 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:309: POLA_ACTION
                {
                mPOLA_ACTION(); 

                }
                break;
            case 38 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:321: POLA_CONDITION
                {
                mPOLA_CONDITION(); 

                }
                break;
            case 39 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:336: POLA_EVENT
                {
                mPOLA_EVENT(); 

                }
                break;
            case 40 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:347: POLA_POLICY
                {
                mPOLA_POLICY(); 

                }
                break;
            case 41 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:359: POLA_SEQ_NUMER
                {
                mPOLA_SEQ_NUMER(); 

                }
                break;
            case 42 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:374: POLA_HASBEEN_EVALED
                {
                mPOLA_HASBEEN_EVALED(); 

                }
                break;
            case 43 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:394: POLA_DEONT_AUTH
                {
                mPOLA_DEONT_AUTH(); 

                }
                break;
            case 44 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:410: POLA_DEONT_EXEM
                {
                mPOLA_DEONT_EXEM(); 

                }
                break;
            case 45 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:426: POLA_DEONT_OBLG
                {
                mPOLA_DEONT_OBLG(); 

                }
                break;
            case 46 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:442: POLA_DEONT_PROH
                {
                mPOLA_DEONT_PROH(); 

                }
                break;
            case 47 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:458: POLA_MEPO_DELE
                {
                mPOLA_MEPO_DELE(); 

                }
                break;
            case 48 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:473: POLA_MEPO_REVO
                {
                mPOLA_MEPO_REVO(); 

                }
                break;
            case 49 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:488: AT_CLEVEL
                {
                mAT_CLEVEL(); 

                }
                break;
            case 50 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:498: AT_ENVIRONMENT
                {
                mAT_ENVIRONMENT(); 

                }
                break;
            case 51 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:513: AT_LANGUAGE
                {
                mAT_LANGUAGE(); 

                }
                break;
            case 52 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:525: AT_PROVIDES
                {
                mAT_PROVIDES(); 

                }
                break;
            case 53 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:537: AT_SCOPE
                {
                mAT_SCOPE(); 

                }
                break;
            case 54 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:546: AT_SPEC
                {
                mAT_SPEC(); 

                }
                break;
            case 55 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:554: AT_STAGE
                {
                mAT_STAGE(); 

                }
                break;
            case 56 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:563: BINARY
                {
                mBINARY(); 

                }
                break;
            case 57 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:570: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 58 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:578: CHAR
                {
                mCHAR(); 

                }
                break;
            case 59 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:583: DOUBLE
                {
                mDOUBLE(); 

                }
                break;
            case 60 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:590: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 61 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:596: HEX
                {
                mHEX(); 

                }
                break;
            case 62 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:600: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 63 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:608: LONG
                {
                mLONG(); 

                }
                break;
            case 64 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:613: OCTET
                {
                mOCTET(); 

                }
                break;
            case 65 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:619: SHORT
                {
                mSHORT(); 

                }
                break;
            case 66 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:625: STRING
                {
                mSTRING(); 

                }
                break;
            case 67 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:632: VOID
                {
                mVOID(); 

                }
                break;
            case 68 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:637: POLA_FALSE
                {
                mPOLA_FALSE(); 

                }
                break;
            case 69 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:648: POLA_NULL
                {
                mPOLA_NULL(); 

                }
                break;
            case 70 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:658: POLA_TRUE
                {
                mPOLA_TRUE(); 

                }
                break;
            case 71 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:668: WS
                {
                mWS(); 

                }
                break;
            case 72 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:671: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 73 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:682: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 74 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:693: VAL_CHAR
                {
                mVAL_CHAR(); 

                }
                break;
            case 75 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:702: VAL_STRING
                {
                mVAL_STRING(); 

                }
                break;
            case 76 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:713: VAL_HEX
                {
                mVAL_HEX(); 

                }
                break;
            case 77 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:721: VAL_INTEGER
                {
                mVAL_INTEGER(); 

                }
                break;
            case 78 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:733: VAL_OCT
                {
                mVAL_OCT(); 

                }
                break;
            case 79 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:741: VAL_BINARY
                {
                mVAL_BINARY(); 

                }
                break;
            case 80 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:752: VAL_FLOAT
                {
                mVAL_FLOAT(); 

                }
                break;
            case 81 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:762: IDENT
                {
                mIDENT(); 

                }
                break;
            case 82 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:768: CPP_DIRECTIVE
                {
                mCPP_DIRECTIVE(); 

                }
                break;
            case 83 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:782: CPP_FILENAME
                {
                mCPP_FILENAME(); 

                }
                break;
            case 84 :
                // V:\\dev\\skb\\projects\\lang\\pola\\proto\\src\\main\\java\\org\\skb\\lang\\pola\\proto\\grammars\\polaEbnf.g:1:795: VAL_DSTRING
                {
                mVAL_DSTRING(); 

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
            return "345:1: VAL_FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatSuffix )? | ( '0' .. '9' )+ Exponent ( FloatSuffix )? | ( '0' .. '9' )+ ( Exponent )? FloatSuffix );";
        }
    }
    static final String DFA31_eotS =
        "\1\uffff\11\51\4\uffff\1\51\1\110\2\uffff\6\51\1\uffff\7\51\4\uffff"+
        "\1\45\1\uffff\1\45\1\51\4\uffff\21\51\1\173\11\51\1\u0088\1\uffff"+
        "\11\51\5\uffff\7\51\7\uffff\1\45\25\51\1\uffff\5\51\1\u00c3\5\51"+
        "\2\uffff\13\51\3\uffff\1\51\1\u00d6\5\51\1\u00a3\7\uffff\22\51\1"+
        "\u00f2\7\51\1\uffff\2\51\1\uffff\12\51\1\u0106\1\51\1\u0108\1\51"+
        "\1\u010a\3\51\1\uffff\1\u010e\1\u010f\1\51\1\u0111\1\u0112\3\uffff"+
        "\1\u0115\5\51\1\u011b\14\51\1\uffff\7\51\1\u012f\1\51\1\u0131\11"+
        "\51\1\uffff\1\u013b\1\uffff\1\51\1\uffff\1\51\1\u013e\1\u013f\2"+
        "\uffff\1\u0140\5\uffff\2\51\1\u0144\1\u0145\1\51\1\uffff\1\u0147"+
        "\1\51\1\u0149\3\51\1\u014d\4\51\1\u0152\2\51\1\u0155\1\51\1\u0157"+
        "\1\u0158\1\u0159\1\uffff\1\51\1\uffff\5\51\1\u0160\3\51\1\uffff"+
        "\1\u0164\1\51\4\uffff\2\51\2\uffff\1\51\1\uffff\1\51\1\uffff\3\51"+
        "\1\uffff\1\u016e\3\51\1\uffff\1\u0172\1\51\1\uffff\1\u0174\3\uffff"+
        "\1\u0175\3\51\1\u0179\1\u017a\1\uffff\3\51\1\uffff\1\51\1\uffff"+
        "\7\51\1\uffff\3\51\1\uffff\1\u0189\2\uffff\2\51\1\u018c\2\uffff"+
        "\16\51\1\uffff\1\u019b\1\u019c\1\uffff\1\51\1\u019e\1\u019f\5\51"+
        "\1\u01a5\1\51\1\u01a7\1\u01a8\1\u01a9\1\51\5\uffff\1\u01ab\3\51"+
        "\1\u01af\1\uffff\1\51\3\uffff\1\u01b1\1\uffff\1\u01b2\2\51\1\uffff"+
        "\1\u01b5\2\uffff\1\51\1\u01b7\1\uffff\1\u01b8\2\uffff";
    static final String DFA31_eofS =
        "\u01b9\uffff";
    static final String DFA31_minS =
        "\1\11\1\143\1\157\2\145\1\157\1\145\1\60\1\145\1\143\4\uffff\1"+
        "\156\1\72\2\uffff\1\137\1\150\2\157\1\164\1\142\1\143\1\154\1\145"+
        "\2\157\1\101\1\125\1\122\1\uffff\1\52\1\uffff\1\0\1\56\1\uffff\1"+
        "\56\1\60\4\uffff\1\143\1\155\1\157\2\164\1\144\1\154\1\165\1\156"+
        "\1\166\1\157\1\154\1\163\1\160\1\163\1\156\1\157\1\60\1\163\1\162"+
        "\1\161\1\157\1\145\2\141\1\145\1\163\1\75\1\uffff\1\141\1\155\1"+
        "\141\1\157\1\141\1\156\1\151\1\154\1\164\4\uffff\1\143\1\157\1\170"+
        "\1\156\1\151\2\114\1\125\2\uffff\2\0\2\uffff\2\56\1\150\1\151\1"+
        "\155\1\151\1\150\1\145\1\151\1\145\1\154\1\157\1\145\1\142\1\164"+
        "\1\157\1\144\1\151\1\164\1\145\1\151\1\141\1\154\1\uffff\1\164\1"+
        "\151\1\55\1\162\1\155\1\60\1\156\1\154\1\155\1\164\1\145\2\uffff"+
        "\1\162\1\157\1\144\1\160\1\162\1\165\1\154\1\163\1\154\1\151\1\145"+
        "\3\uffff\1\141\1\60\1\147\1\144\1\123\1\114\1\105\5\0\2\uffff\1"+
        "\56\1\151\1\156\1\151\2\157\1\154\1\147\1\154\1\143\1\157\1\156"+
        "\1\147\1\154\1\151\1\143\1\165\1\151\1\143\1\60\1\144\1\156\1\162"+
        "\2\145\1\143\1\156\1\uffff\1\164\1\145\1\uffff\1\164\1\165\1\160"+
        "\1\141\1\147\1\162\1\144\2\151\1\157\1\60\1\160\1\60\1\164\1\60"+
        "\1\147\2\164\1\uffff\2\60\1\105\2\60\3\0\1\56\1\164\1\151\1\143"+
        "\1\156\1\162\1\60\1\156\1\157\1\145\1\171\1\163\1\141\1\145\1\155"+
        "\1\141\1\143\1\142\1\171\1\uffff\2\145\1\171\1\141\1\155\1\164\1"+
        "\147\1\60\1\156\1\60\1\141\1\164\1\156\1\145\1\141\1\171\1\156\1"+
        "\164\1\163\1\uffff\1\60\1\uffff\1\144\1\uffff\1\141\2\60\2\uffff"+
        "\1\60\2\uffff\2\0\1\uffff\1\145\1\163\2\60\1\151\1\uffff\1\60\1"+
        "\160\1\60\1\155\2\164\1\60\1\145\2\164\1\151\1\60\1\146\1\163\1"+
        "\60\1\156\3\60\1\uffff\1\164\1\uffff\1\164\1\151\1\143\1\162\1\171"+
        "\1\60\1\165\2\151\1\uffff\1\60\1\164\3\uffff\1\0\1\143\1\164\2\uffff"+
        "\1\172\1\uffff\1\155\1\uffff\1\145\1\162\1\151\1\uffff\1\60\2\151"+
        "\1\164\1\uffff\1\60\1\163\1\uffff\1\60\3\uffff\1\60\1\145\1\157"+
        "\1\145\2\60\1\uffff\1\165\1\157\1\164\1\uffff\1\151\1\0\1\164\1"+
        "\162\1\141\1\145\1\156\1\141\1\157\1\uffff\2\157\1\151\1\uffff\1"+
        "\60\2\uffff\1\144\1\156\1\60\2\uffff\1\155\1\156\1\145\1\157\1\165"+
        "\1\141\1\164\1\156\2\164\3\156\1\157\1\uffff\2\60\1\uffff\1\55\2"+
        "\60\1\156\1\162\1\164\1\151\1\164\1\60\1\157\3\60\1\156\5\uffff"+
        "\1\60\1\145\1\151\1\157\1\60\1\uffff\1\162\3\uffff\1\60\1\uffff"+
        "\1\60\1\157\1\156\1\uffff\1\60\2\uffff\1\156\1\60\1\uffff\1\60\2"+
        "\uffff";
    static final String DFA31_maxS =
        "\1\175\1\165\2\157\1\165\1\162\1\171\1\165\1\171\1\170\4\uffff"+
        "\1\156\1\72\2\uffff\1\137\1\157\1\162\1\157\1\164\1\143\1\163\1"+
        "\154\1\145\2\157\1\101\1\125\1\122\1\uffff\1\57\1\uffff\1\uffff"+
        "\1\170\1\uffff\1\146\1\61\4\uffff\1\143\1\155\1\157\2\164\1\144"+
        "\1\166\1\165\1\156\1\166\1\157\1\154\1\163\1\160\1\163\1\156\1\157"+
        "\1\172\1\163\1\162\1\161\1\157\1\145\1\141\2\145\1\164\1\75\1\uffff"+
        "\1\142\1\156\1\141\1\157\1\141\1\156\1\151\1\154\1\164\4\uffff\1"+
        "\164\1\157\1\170\1\156\1\151\2\114\1\125\2\uffff\2\uffff\2\uffff"+
        "\2\146\1\150\1\151\1\155\1\151\1\150\1\145\2\151\1\154\1\157\1\145"+
        "\1\142\1\164\1\157\1\150\1\151\1\164\1\145\1\151\1\141\1\154\1\uffff"+
        "\1\164\1\165\1\55\1\162\1\155\1\172\1\156\1\154\1\155\1\164\1\145"+
        "\2\uffff\1\162\1\157\1\164\1\160\1\162\1\165\1\154\1\163\1\154\1"+
        "\151\1\145\3\uffff\1\141\1\172\1\147\1\144\1\123\1\114\1\105\5\uffff"+
        "\2\uffff\1\146\1\151\1\156\1\151\2\157\1\154\1\147\1\154\1\143\1"+
        "\157\1\156\1\147\1\154\1\151\1\143\1\165\1\151\1\143\1\172\1\144"+
        "\1\156\1\162\2\145\1\143\1\156\1\uffff\1\164\1\145\1\uffff\1\164"+
        "\1\165\1\160\1\141\1\147\1\162\1\144\2\151\1\157\1\172\1\160\1\172"+
        "\1\164\1\172\1\147\2\164\1\uffff\2\172\1\105\2\172\3\uffff\1\146"+
        "\1\164\1\151\1\143\1\156\1\162\1\172\1\156\1\157\1\145\1\171\1\163"+
        "\1\141\1\145\1\155\1\141\1\143\1\142\1\171\1\uffff\2\145\1\171\1"+
        "\141\1\155\1\164\1\147\1\172\1\156\1\172\1\141\1\164\1\156\1\145"+
        "\1\141\1\171\1\156\1\164\1\163\1\uffff\1\172\1\uffff\1\144\1\uffff"+
        "\1\141\2\172\2\uffff\1\172\2\uffff\2\uffff\1\uffff\1\145\1\163\2"+
        "\172\1\151\1\uffff\1\172\1\160\1\172\1\155\2\164\1\172\1\145\2\164"+
        "\1\151\1\172\1\146\1\163\1\172\1\156\3\172\1\uffff\1\164\1\uffff"+
        "\1\164\1\151\1\143\1\162\1\171\1\172\1\165\2\151\1\uffff\1\172\1"+
        "\164\3\uffff\1\uffff\1\143\1\164\2\uffff\1\172\1\uffff\1\155\1\uffff"+
        "\1\145\1\162\1\151\1\uffff\1\172\2\151\1\164\1\uffff\1\172\1\163"+
        "\1\uffff\1\172\3\uffff\1\172\1\145\1\157\1\145\2\172\1\uffff\1\165"+
        "\1\157\1\164\1\uffff\1\151\1\uffff\1\164\1\162\1\141\1\145\1\156"+
        "\1\141\1\157\1\uffff\2\157\1\151\1\uffff\1\172\2\uffff\1\144\1\156"+
        "\1\172\2\uffff\1\155\1\156\1\145\1\157\1\165\1\141\1\164\1\156\2"+
        "\164\3\156\1\157\1\uffff\2\172\1\uffff\1\55\2\172\1\156\1\162\1"+
        "\164\1\151\1\164\1\172\1\157\3\172\1\156\5\uffff\1\172\1\145\1\151"+
        "\1\157\1\172\1\uffff\1\162\3\uffff\1\172\1\uffff\1\172\1\157\1\156"+
        "\1\uffff\1\172\2\uffff\1\156\1\172\1\uffff\1\172\2\uffff";
    static final String DFA31_acceptS =
        "\12\uffff\1\15\1\16\1\17\1\20\2\uffff\1\27\1\30\16\uffff\1\107"+
        "\1\uffff\1\112\2\uffff\1\115\2\uffff\1\120\1\121\1\122\1\124\34"+
        "\uffff\1\25\11\uffff\1\61\1\62\1\63\1\64\10\uffff\1\110\1\111\2"+
        "\uffff\1\113\1\114\27\uffff\1\117\13\uffff\1\24\1\26\13\uffff\1"+
        "\65\1\66\1\67\14\uffff\1\123\1\113\33\uffff\1\51\2\uffff\1\42\22"+
        "\uffff\1\75\33\uffff\1\10\23\uffff\1\72\1\uffff\1\43\1\uffff\1\44"+
        "\3\uffff\1\77\1\103\1\uffff\1\105\1\106\2\uffff\1\116\5\uffff\1"+
        "\2\23\uffff\1\101\1\uffff\1\47\11\uffff\1\40\2\uffff\1\100\1\74"+
        "\1\104\3\uffff\1\37\1\45\1\uffff\1\3\1\uffff\1\22\3\uffff\1\73\4"+
        "\uffff\1\50\2\uffff\1\70\1\uffff\1\13\1\33\1\102\6\uffff\1\32\3"+
        "\uffff\1\41\11\uffff\1\6\3\uffff\1\34\1\uffff\1\71\1\14\3\uffff"+
        "\1\76\1\31\16\uffff\1\12\2\uffff\1\23\16\uffff\1\52\1\54\1\35\1"+
        "\46\1\36\5\uffff\1\5\1\uffff\1\57\1\60\1\7\1\uffff\1\55\3\uffff"+
        "\1\4\1\uffff\1\56\1\1\2\uffff\1\11\1\uffff\1\53\1\21";
    static final String DFA31_specialS =
        "\43\uffff\1\1\74\uffff\1\6\1\15\74\uffff\1\13\1\14\1\0\1\12\1\16"+
        "\71\uffff\1\5\1\7\1\11\64\uffff\1\3\1\10\54\uffff\1\4\44\uffff\1"+
        "\2\122\uffff}>";
    static final String[] DFA31_transitionS = {
            "\2\40\1\uffff\2\40\22\uffff\1\40\1\uffff\1\43\1\52\3\uffff"+
            "\1\42\3\uffff\1\45\1\uffff\1\45\1\50\1\41\1\44\11\46\1\17\1"+
            "\12\1\53\1\15\2\uffff\1\30\1\51\1\47\3\51\1\35\7\51\1\36\5\51"+
            "\1\37\6\51\1\20\1\uffff\1\21\1\uffff\1\22\1\uffff\1\1\1\7\1"+
            "\23\1\3\1\11\1\31\1\24\1\32\1\16\2\51\1\33\1\2\1\25\1\27\1\5"+
            "\1\51\1\4\1\10\1\6\1\26\1\34\4\51\1\13\1\uffff\1\14",
            "\1\57\1\55\15\uffff\1\54\1\uffff\1\56\1\60",
            "\1\61",
            "\1\62\11\uffff\1\63",
            "\1\65\17\uffff\1\64",
            "\1\67\2\uffff\1\66",
            "\1\70\23\uffff\1\71",
            "\2\75\67\uffff\1\73\5\uffff\1\74\5\uffff\1\72",
            "\1\100\2\uffff\1\101\13\uffff\1\77\4\uffff\1\76",
            "\1\103\10\uffff\1\102\11\uffff\1\104\1\uffff\1\105",
            "",
            "",
            "",
            "",
            "\1\106",
            "\1\107",
            "",
            "",
            "\1\111",
            "\1\113\6\uffff\1\112",
            "\1\115\2\uffff\1\114",
            "\1\116",
            "\1\117",
            "\1\120\1\121",
            "\1\122\1\uffff\1\123\6\uffff\1\124\3\uffff\1\125\2\uffff\1"+
            "\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "",
            "\1\137\4\uffff\1\136",
            "",
            "\42\141\1\142\71\141\1\140\uffa3\141",
            "\1\50\1\uffff\10\144\2\50\12\uffff\3\50\21\uffff\1\143\13"+
            "\uffff\3\50\21\uffff\1\143",
            "",
            "\1\50\1\uffff\12\145\12\uffff\3\50\35\uffff\3\50",
            "\2\75",
            "",
            "",
            "",
            "",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\160\1\157\2\uffff\1\156\2\uffff\1\154\2\uffff\1\155",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\2\75\10\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0083\3\uffff\1\u0082",
            "\1\u0084",
            "\1\u0085\1\u0086",
            "\1\u0087",
            "",
            "\1\u0089\1\u008a",
            "\1\u008c\1\u008b",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "",
            "",
            "",
            "",
            "\1\u0094\14\uffff\1\u0095\3\uffff\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "",
            "",
            "\42\u00a3\1\u009e\4\u00a3\1\u00a2\10\u00a3\4\u00a0\4\u00a1"+
            "\44\u00a3\1\u00a2\5\u00a3\1\u00a2\3\u00a3\1\u00a2\7\u00a3\1"+
            "\u00a2\3\u00a3\1\u00a2\1\u00a3\1\u00a2\1\u009f\uff8a\u00a3",
            "\42\141\1\142\71\141\1\140\uffa3\141",
            "",
            "",
            "\1\50\1\uffff\10\u00a5\2\50\12\uffff\3\50\35\uffff\3\50",
            "\1\50\1\uffff\12\145\12\uffff\3\50\35\uffff\3\50",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad\3\uffff\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5\3\uffff\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "",
            "\1\u00bd",
            "\1\u00bf\13\uffff\1\u00be",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cc\17\uffff\1\u00cb",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "",
            "",
            "",
            "\1\u00d5",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\0\u00a4",
            "\60\u00a3\12\u00dc\7\u00a3\6\u00dc\32\u00a3\6\u00dc\uff99"+
            "\u00a3",
            "\42\141\1\142\15\141\10\u00dd\44\141\1\140\uffa3\141",
            "\42\141\1\142\15\141\10\u00de\44\141\1\140\uffa3\141",
            "\42\141\1\142\71\141\1\140\uffa3\141",
            "",
            "",
            "\1\50\1\uffff\10\u00df\2\50\12\uffff\3\50\35\uffff\3\50",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
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
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "",
            "\1\u00fa",
            "\1\u00fb",
            "",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0107",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0109",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0110",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\60\u00a3\12\u0113\7\u00a3\6\u0113\32\u00a3\6\u0113\uff99"+
            "\u00a3",
            "\42\141\1\142\15\141\10\u0114\44\141\1\140\uffa3\141",
            "\42\141\1\142\71\141\1\140\uffa3\141",
            "\1\50\1\uffff\12\50\12\uffff\3\50\35\uffff\3\50",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
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
            "\1\u0126",
            "\1\u0127",
            "",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0130",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u013c",
            "",
            "\1\u013d",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\60\u00a3\12\u0141\7\u00a3\6\u0141\32\u00a3\6\u0141\uff99"+
            "\u00a3",
            "\42\141\1\142\71\141\1\140\uffa3\141",
            "",
            "\1\u0142",
            "\1\u0143",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0146",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0148",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0153",
            "\1\u0154",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0156",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u015a",
            "",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "\1\u015f",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0165",
            "",
            "",
            "",
            "\60\u00a3\12\u0166\7\u00a3\6\u0166\32\u00a3\6\u0166\uff99"+
            "\u00a3",
            "\1\u0167",
            "\1\u0168",
            "",
            "",
            "\1\u0169",
            "",
            "\1\u016a",
            "",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u016f",
            "\1\u0170",
            "\1\u0171",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0173",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u017b",
            "\1\u017c",
            "\1\u017d",
            "",
            "\1\u017e",
            "\42\141\1\142\71\141\1\140\uffa3\141",
            "\1\u017f",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\1\u018a",
            "\1\u018b",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "\1\u0191",
            "\1\u0192",
            "\1\u0193",
            "\1\u0194",
            "\1\u0195",
            "\1\u0196",
            "\1\u0197",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u019d",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u01a0",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u01a6",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u01aa",
            "",
            "",
            "",
            "",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u01ac",
            "\1\u01ad",
            "\1\u01ae",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u01b0",
            "",
            "",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u01b3",
            "\1\u01b4",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\1\u01b6",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
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
            return "1:1: Tokens : ( T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | ARRAY | BODY | STRUCT | TYPEDEF | POLA_PC_LEVEL | POLA_COMPOSITE | POLA_ATOMIC | POLA_GROUP | POLA_NONSTD | POLA_RULE_STRUCT_ECA | POLA_RULE_STRUCT_GOAL | POLA_RULE_STRUCT_UTIL | POLA_ACTION | POLA_CONDITION | POLA_EVENT | POLA_POLICY | POLA_SEQ_NUMER | POLA_HASBEEN_EVALED | POLA_DEONT_AUTH | POLA_DEONT_EXEM | POLA_DEONT_OBLG | POLA_DEONT_PROH | POLA_MEPO_DELE | POLA_MEPO_REVO | AT_CLEVEL | AT_ENVIRONMENT | AT_LANGUAGE | AT_PROVIDES | AT_SCOPE | AT_SPEC | AT_STAGE | BINARY | BOOLEAN | CHAR | DOUBLE | FLOAT | HEX | INTEGER | LONG | OCTET | SHORT | STRING | VOID | POLA_FALSE | POLA_NULL | POLA_TRUE | WS | SL_COMMENT | ML_COMMENT | VAL_CHAR | VAL_STRING | VAL_HEX | VAL_INTEGER | VAL_OCT | VAL_BINARY | VAL_FLOAT | IDENT | CPP_DIRECTIVE | CPP_FILENAME | VAL_DSTRING );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_160 = input.LA(1);

                        s = -1;
                        if ( ((LA31_160>='0' && LA31_160<='7')) ) {s = 221;}

                        else if ( (LA31_160=='\"') ) {s = 98;}

                        else if ( (LA31_160=='\\') ) {s = 96;}

                        else if ( ((LA31_160>='\u0000' && LA31_160<='!')||(LA31_160>='#' && LA31_160<='/')||(LA31_160>='8' && LA31_160<='[')||(LA31_160>=']' && LA31_160<='\uFFFF')) ) {s = 97;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_35 = input.LA(1);

                        s = -1;
                        if ( (LA31_35=='\\') ) {s = 96;}

                        else if ( ((LA31_35>='\u0000' && LA31_35<='!')||(LA31_35>='#' && LA31_35<='[')||(LA31_35>=']' && LA31_35<='\uFFFF')) ) {s = 97;}

                        else if ( (LA31_35=='\"') ) {s = 98;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_358 = input.LA(1);

                        s = -1;
                        if ( (LA31_358=='\"') ) {s = 98;}

                        else if ( (LA31_358=='\\') ) {s = 96;}

                        else if ( ((LA31_358>='\u0000' && LA31_358<='!')||(LA31_358>='#' && LA31_358<='[')||(LA31_358>=']' && LA31_358<='\uFFFF')) ) {s = 97;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA31_275 = input.LA(1);

                        s = -1;
                        if ( ((LA31_275>='0' && LA31_275<='9')||(LA31_275>='A' && LA31_275<='F')||(LA31_275>='a' && LA31_275<='f')) ) {s = 321;}

                        else if ( ((LA31_275>='\u0000' && LA31_275<='/')||(LA31_275>=':' && LA31_275<='@')||(LA31_275>='G' && LA31_275<='`')||(LA31_275>='g' && LA31_275<='\uFFFF')) ) {s = 163;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA31_321 = input.LA(1);

                        s = -1;
                        if ( ((LA31_321>='0' && LA31_321<='9')||(LA31_321>='A' && LA31_321<='F')||(LA31_321>='a' && LA31_321<='f')) ) {s = 358;}

                        else if ( ((LA31_321>='\u0000' && LA31_321<='/')||(LA31_321>=':' && LA31_321<='@')||(LA31_321>='G' && LA31_321<='`')||(LA31_321>='g' && LA31_321<='\uFFFF')) ) {s = 163;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA31_220 = input.LA(1);

                        s = -1;
                        if ( ((LA31_220>='0' && LA31_220<='9')||(LA31_220>='A' && LA31_220<='F')||(LA31_220>='a' && LA31_220<='f')) ) {s = 275;}

                        else if ( ((LA31_220>='\u0000' && LA31_220<='/')||(LA31_220>=':' && LA31_220<='@')||(LA31_220>='G' && LA31_220<='`')||(LA31_220>='g' && LA31_220<='\uFFFF')) ) {s = 163;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA31_96 = input.LA(1);

                        s = -1;
                        if ( (LA31_96=='\"') ) {s = 158;}

                        else if ( (LA31_96=='u') ) {s = 159;}

                        else if ( ((LA31_96>='0' && LA31_96<='3')) ) {s = 160;}

                        else if ( ((LA31_96>='4' && LA31_96<='7')) ) {s = 161;}

                        else if ( (LA31_96=='\''||LA31_96=='\\'||LA31_96=='b'||LA31_96=='f'||LA31_96=='n'||LA31_96=='r'||LA31_96=='t') ) {s = 162;}

                        else if ( ((LA31_96>='\u0000' && LA31_96<='!')||(LA31_96>='#' && LA31_96<='&')||(LA31_96>='(' && LA31_96<='/')||(LA31_96>='8' && LA31_96<='[')||(LA31_96>=']' && LA31_96<='a')||(LA31_96>='c' && LA31_96<='e')||(LA31_96>='g' && LA31_96<='m')||(LA31_96>='o' && LA31_96<='q')||LA31_96=='s'||(LA31_96>='v' && LA31_96<='\uFFFF')) ) {s = 163;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA31_221 = input.LA(1);

                        s = -1;
                        if ( ((LA31_221>='0' && LA31_221<='7')) ) {s = 276;}

                        else if ( (LA31_221=='\"') ) {s = 98;}

                        else if ( (LA31_221=='\\') ) {s = 96;}

                        else if ( ((LA31_221>='\u0000' && LA31_221<='!')||(LA31_221>='#' && LA31_221<='/')||(LA31_221>='8' && LA31_221<='[')||(LA31_221>=']' && LA31_221<='\uFFFF')) ) {s = 97;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA31_276 = input.LA(1);

                        s = -1;
                        if ( (LA31_276=='\"') ) {s = 98;}

                        else if ( (LA31_276=='\\') ) {s = 96;}

                        else if ( ((LA31_276>='\u0000' && LA31_276<='!')||(LA31_276>='#' && LA31_276<='[')||(LA31_276>=']' && LA31_276<='\uFFFF')) ) {s = 97;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA31_222 = input.LA(1);

                        s = -1;
                        if ( (LA31_222=='\"') ) {s = 98;}

                        else if ( (LA31_222=='\\') ) {s = 96;}

                        else if ( ((LA31_222>='\u0000' && LA31_222<='!')||(LA31_222>='#' && LA31_222<='[')||(LA31_222>=']' && LA31_222<='\uFFFF')) ) {s = 97;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA31_161 = input.LA(1);

                        s = -1;
                        if ( ((LA31_161>='0' && LA31_161<='7')) ) {s = 222;}

                        else if ( (LA31_161=='\"') ) {s = 98;}

                        else if ( (LA31_161=='\\') ) {s = 96;}

                        else if ( ((LA31_161>='\u0000' && LA31_161<='!')||(LA31_161>='#' && LA31_161<='/')||(LA31_161>='8' && LA31_161<='[')||(LA31_161>=']' && LA31_161<='\uFFFF')) ) {s = 97;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA31_158 = input.LA(1);

                        s = -1;
                        if ( ((LA31_158>='\u0000' && LA31_158<='\uFFFF')) ) {s = 164;}

                        else s = 163;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA31_159 = input.LA(1);

                        s = -1;
                        if ( ((LA31_159>='0' && LA31_159<='9')||(LA31_159>='A' && LA31_159<='F')||(LA31_159>='a' && LA31_159<='f')) ) {s = 220;}

                        else if ( ((LA31_159>='\u0000' && LA31_159<='/')||(LA31_159>=':' && LA31_159<='@')||(LA31_159>='G' && LA31_159<='`')||(LA31_159>='g' && LA31_159<='\uFFFF')) ) {s = 163;}

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA31_97 = input.LA(1);

                        s = -1;
                        if ( (LA31_97=='\"') ) {s = 98;}

                        else if ( (LA31_97=='\\') ) {s = 96;}

                        else if ( ((LA31_97>='\u0000' && LA31_97<='!')||(LA31_97>='#' && LA31_97<='[')||(LA31_97>=']' && LA31_97<='\uFFFF')) ) {s = 97;}

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA31_162 = input.LA(1);

                        s = -1;
                        if ( (LA31_162=='\"') ) {s = 98;}

                        else if ( (LA31_162=='\\') ) {s = 96;}

                        else if ( ((LA31_162>='\u0000' && LA31_162<='!')||(LA31_162>='#' && LA31_162<='[')||(LA31_162>=']' && LA31_162<='\uFFFF')) ) {s = 97;}

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