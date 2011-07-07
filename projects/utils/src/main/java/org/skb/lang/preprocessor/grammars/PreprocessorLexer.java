// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g 2011-07-07 22:24:19

  package org.skb.lang.preprocessor.grammars;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PreprocessorLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int WS=4;
    public static final int CPP_INCLUDE=5;
    public static final int CPP_DEFINE=6;
    public static final int CPP_UNDEF=7;
    public static final int CPP_IFDEF=8;
    public static final int CPP_IFNDEF=9;
    public static final int CPP_ELSIF=10;
    public static final int STRING=11;
    public static final int CPP_ELSE=12;
    public static final int CPP_ENDIF=13;

    // delegates
    // delegators

    public PreprocessorLexer() {;} 
    public PreprocessorLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PreprocessorLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:11:7: ( '#' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:11:9: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:12:7: ( '\\r' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:12:9: '\\r'
            {
            match('\r'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:13:7: ( '\\n' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:13:9: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "CPP_INCLUDE"
    public final void mCPP_INCLUDE() throws RecognitionException {
        try {
            int _type = CPP_INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:65:12: ( 'include' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:65:14: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CPP_INCLUDE"

    // $ANTLR start "CPP_DEFINE"
    public final void mCPP_DEFINE() throws RecognitionException {
        try {
            int _type = CPP_DEFINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:66:12: ( 'define' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:66:14: 'define'
            {
            match("define"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CPP_DEFINE"

    // $ANTLR start "CPP_UNDEF"
    public final void mCPP_UNDEF() throws RecognitionException {
        try {
            int _type = CPP_UNDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:67:12: ( 'undef' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:67:14: 'undef'
            {
            match("undef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CPP_UNDEF"

    // $ANTLR start "CPP_IFDEF"
    public final void mCPP_IFDEF() throws RecognitionException {
        try {
            int _type = CPP_IFDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:68:12: ( 'ifdef' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:68:14: 'ifdef'
            {
            match("ifdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CPP_IFDEF"

    // $ANTLR start "CPP_IFNDEF"
    public final void mCPP_IFNDEF() throws RecognitionException {
        try {
            int _type = CPP_IFNDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:69:12: ( 'ifndef' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:69:14: 'ifndef'
            {
            match("ifndef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CPP_IFNDEF"

    // $ANTLR start "CPP_ELSE"
    public final void mCPP_ELSE() throws RecognitionException {
        try {
            int _type = CPP_ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:70:12: ( 'else' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:70:14: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CPP_ELSE"

    // $ANTLR start "CPP_ELSIF"
    public final void mCPP_ELSIF() throws RecognitionException {
        try {
            int _type = CPP_ELSIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:71:12: ( 'elsif' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:71:14: 'elsif'
            {
            match("elsif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CPP_ELSIF"

    // $ANTLR start "CPP_ENDIF"
    public final void mCPP_ENDIF() throws RecognitionException {
        try {
            int _type = CPP_ENDIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:72:12: ( 'endif' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:72:14: 'endif'
            {
            match("endif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CPP_ENDIF"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:74:12: ( ( ' ' | '\\t' ) )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:74:14: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
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

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:75:12: ( '\"' ( '\\\\' . | ~ ( '\"' ) )* '\"' )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:75:14: '\"' ( '\\\\' . | ~ ( '\"' ) )* '\"'
            {
            match('\"'); 
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:75:18: ( '\\\\' . | ~ ( '\"' ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2=='\"') ) {
                        int LA1_4 = input.LA(3);

                        if ( ((LA1_4>='\u0000' && LA1_4<='\uFFFF')) ) {
                            alt1=1;
                        }

                        else {
                            alt1=2;
                        }

                    }
                    else if ( (LA1_2=='\\') ) {
                        alt1=1;
                    }
                    else if ( ((LA1_2>='\u0000' && LA1_2<='!')||(LA1_2>='#' && LA1_2<='[')||(LA1_2>=']' && LA1_2<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFF')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:75:20: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:75:29: ~ ( '\"' )
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
            	    break loop1;
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
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:8: ( T__14 | T__15 | T__16 | CPP_INCLUDE | CPP_DEFINE | CPP_UNDEF | CPP_IFDEF | CPP_IFNDEF | CPP_ELSE | CPP_ELSIF | CPP_ENDIF | WS | STRING )
        int alt2=13;
        alt2 = dfa2.predict(input);
        switch (alt2) {
            case 1 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:28: CPP_INCLUDE
                {
                mCPP_INCLUDE(); 

                }
                break;
            case 5 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:40: CPP_DEFINE
                {
                mCPP_DEFINE(); 

                }
                break;
            case 6 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:51: CPP_UNDEF
                {
                mCPP_UNDEF(); 

                }
                break;
            case 7 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:61: CPP_IFDEF
                {
                mCPP_IFDEF(); 

                }
                break;
            case 8 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:71: CPP_IFNDEF
                {
                mCPP_IFNDEF(); 

                }
                break;
            case 9 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:82: CPP_ELSE
                {
                mCPP_ELSE(); 

                }
                break;
            case 10 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:91: CPP_ELSIF
                {
                mCPP_ELSIF(); 

                }
                break;
            case 11 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:101: CPP_ENDIF
                {
                mCPP_ENDIF(); 

                }
                break;
            case 12 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:111: WS
                {
                mWS(); 

                }
                break;
            case 13 :
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:1:114: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\23\uffff";
    static final String DFA2_eofS =
        "\23\uffff";
    static final String DFA2_minS =
        "\1\11\3\uffff\1\146\2\uffff\1\154\3\uffff\1\144\1\163\3\uffff\1"+
        "\145\2\uffff";
    static final String DFA2_maxS =
        "\1\165\3\uffff\1\156\2\uffff\1\156\3\uffff\1\156\1\163\3\uffff"+
        "\1\151\2\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\6\1\uffff\1\14\1\15\1\4\2\uffff"+
        "\1\13\1\7\1\10\1\uffff\1\11\1\12";
    static final String DFA2_specialS =
        "\23\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\10\1\3\2\uffff\1\2\22\uffff\1\10\1\uffff\1\11\1\1\100\uffff"+
            "\1\5\1\7\3\uffff\1\4\13\uffff\1\6",
            "",
            "",
            "",
            "\1\13\7\uffff\1\12",
            "",
            "",
            "\1\14\1\uffff\1\15",
            "",
            "",
            "",
            "\1\16\11\uffff\1\17",
            "\1\20",
            "",
            "",
            "",
            "\1\21\3\uffff\1\22",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | CPP_INCLUDE | CPP_DEFINE | CPP_UNDEF | CPP_IFDEF | CPP_IFNDEF | CPP_ELSE | CPP_ELSIF | CPP_ENDIF | WS | STRING );";
        }
    }
 

}