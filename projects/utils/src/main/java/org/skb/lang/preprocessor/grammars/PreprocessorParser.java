// $ANTLR 3.3 Nov 30, 2010 12:50:56 V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g 2011-07-07 22:24:18

  package org.skb.lang.preprocessor.grammars;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class PreprocessorParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WS", "CPP_INCLUDE", "CPP_DEFINE", "CPP_UNDEF", "CPP_IFDEF", "CPP_IFNDEF", "CPP_ELSIF", "STRING", "CPP_ELSE", "CPP_ENDIF", "'#'", "'\\r'", "'\\n'"
    };
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


        public PreprocessorParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PreprocessorParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return PreprocessorParser.tokenNames; }
    public String getGrammarFileName() { return "V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g"; }


      Boolean error=false;
      public void displayRecognitionError(String[] tokenNames, RecognitionException re){this.error=true;}


    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "start"
    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:1: start : '#' WS ( WS )* ( rule -> ^( rule ) | empty_rule -> ^( empty_rule ) ) ( ( ( '\\r' )? '\\n' ) | EOF ) ;
    public final PreprocessorParser.start_return start() throws RecognitionException {
        PreprocessorParser.start_return retval = new PreprocessorParser.start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal1=null;
        Token WS2=null;
        Token WS3=null;
        Token char_literal6=null;
        Token char_literal7=null;
        Token EOF8=null;
        PreprocessorParser.rule_return rule4 = null;

        PreprocessorParser.empty_rule_return empty_rule5 = null;


        CommonTree char_literal1_tree=null;
        CommonTree WS2_tree=null;
        CommonTree WS3_tree=null;
        CommonTree char_literal6_tree=null;
        CommonTree char_literal7_tree=null;
        CommonTree EOF8_tree=null;
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_15=new RewriteRuleTokenStream(adaptor,"token 15");
        RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleSubtreeStream stream_empty_rule=new RewriteRuleSubtreeStream(adaptor,"rule empty_rule");
        RewriteRuleSubtreeStream stream_rule=new RewriteRuleSubtreeStream(adaptor,"rule rule");
        try {
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:12: ( '#' WS ( WS )* ( rule -> ^( rule ) | empty_rule -> ^( empty_rule ) ) ( ( ( '\\r' )? '\\n' ) | EOF ) )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:14: '#' WS ( WS )* ( rule -> ^( rule ) | empty_rule -> ^( empty_rule ) ) ( ( ( '\\r' )? '\\n' ) | EOF )
            {
            char_literal1=(Token)match(input,14,FOLLOW_14_in_start65);  
            stream_14.add(char_literal1);

            WS2=(Token)match(input,WS,FOLLOW_WS_in_start67);  
            stream_WS.add(WS2);

            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:21: ( WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:21: WS
            	    {
            	    WS3=(Token)match(input,WS,FOLLOW_WS_in_start69);  
            	    stream_WS.add(WS3);


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:25: ( rule -> ^( rule ) | empty_rule -> ^( empty_rule ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=CPP_INCLUDE && LA2_0<=CPP_ELSIF)) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=CPP_ELSE && LA2_0<=CPP_ENDIF)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:26: rule
                    {
                    pushFollow(FOLLOW_rule_in_start73);
                    rule4=rule();

                    state._fsp--;

                    stream_rule.add(rule4.getTree());


                    // AST REWRITE
                    // elements: rule
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 62:31: -> ^( rule )
                    {
                        // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:33: ^( rule )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_rule.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:43: empty_rule
                    {
                    pushFollow(FOLLOW_empty_rule_in_start82);
                    empty_rule5=empty_rule();

                    state._fsp--;

                    stream_empty_rule.add(empty_rule5.getTree());


                    // AST REWRITE
                    // elements: empty_rule
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 62:54: -> ^( empty_rule )
                    {
                        // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:56: ^( empty_rule )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_empty_rule.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }

            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:71: ( ( ( '\\r' )? '\\n' ) | EOF )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=15 && LA4_0<=16)) ) {
                alt4=1;
            }
            else if ( (LA4_0==EOF) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:72: ( ( '\\r' )? '\\n' )
                    {
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:72: ( ( '\\r' )? '\\n' )
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:73: ( '\\r' )? '\\n'
                    {
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:73: ( '\\r' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==15) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:73: '\\r'
                            {
                            char_literal6=(Token)match(input,15,FOLLOW_15_in_start92);  
                            stream_15.add(char_literal6);


                            }
                            break;

                    }

                    char_literal7=(Token)match(input,16,FOLLOW_16_in_start95);  
                    stream_16.add(char_literal7);


                    }


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:62:87: EOF
                    {
                    EOF8=(Token)match(input,EOF,FOLLOW_EOF_in_start100);  
                    stream_EOF.add(EOF8);


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
    // $ANTLR end "start"

    public static class rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rule"
    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:63:1: rule : (c= CPP_INCLUDE | c= CPP_DEFINE | c= CPP_UNDEF | c= CPP_IFDEF | c= CPP_IFNDEF | c= CPP_ELSIF ) WS STRING -> ^( $c STRING ) ;
    public final PreprocessorParser.rule_return rule() throws RecognitionException {
        PreprocessorParser.rule_return retval = new PreprocessorParser.rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token WS9=null;
        Token STRING10=null;

        CommonTree c_tree=null;
        CommonTree WS9_tree=null;
        CommonTree STRING10_tree=null;
        RewriteRuleTokenStream stream_CPP_UNDEF=new RewriteRuleTokenStream(adaptor,"token CPP_UNDEF");
        RewriteRuleTokenStream stream_CPP_IFNDEF=new RewriteRuleTokenStream(adaptor,"token CPP_IFNDEF");
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_CPP_INCLUDE=new RewriteRuleTokenStream(adaptor,"token CPP_INCLUDE");
        RewriteRuleTokenStream stream_CPP_DEFINE=new RewriteRuleTokenStream(adaptor,"token CPP_DEFINE");
        RewriteRuleTokenStream stream_CPP_IFDEF=new RewriteRuleTokenStream(adaptor,"token CPP_IFDEF");
        RewriteRuleTokenStream stream_CPP_ELSIF=new RewriteRuleTokenStream(adaptor,"token CPP_ELSIF");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:63:12: ( (c= CPP_INCLUDE | c= CPP_DEFINE | c= CPP_UNDEF | c= CPP_IFDEF | c= CPP_IFNDEF | c= CPP_ELSIF ) WS STRING -> ^( $c STRING ) )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:63:14: (c= CPP_INCLUDE | c= CPP_DEFINE | c= CPP_UNDEF | c= CPP_IFDEF | c= CPP_IFNDEF | c= CPP_ELSIF ) WS STRING
            {
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:63:14: (c= CPP_INCLUDE | c= CPP_DEFINE | c= CPP_UNDEF | c= CPP_IFDEF | c= CPP_IFNDEF | c= CPP_ELSIF )
            int alt5=6;
            switch ( input.LA(1) ) {
            case CPP_INCLUDE:
                {
                alt5=1;
                }
                break;
            case CPP_DEFINE:
                {
                alt5=2;
                }
                break;
            case CPP_UNDEF:
                {
                alt5=3;
                }
                break;
            case CPP_IFDEF:
                {
                alt5=4;
                }
                break;
            case CPP_IFNDEF:
                {
                alt5=5;
                }
                break;
            case CPP_ELSIF:
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:63:15: c= CPP_INCLUDE
                    {
                    c=(Token)match(input,CPP_INCLUDE,FOLLOW_CPP_INCLUDE_in_rule119);  
                    stream_CPP_INCLUDE.add(c);


                    }
                    break;
                case 2 :
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:63:31: c= CPP_DEFINE
                    {
                    c=(Token)match(input,CPP_DEFINE,FOLLOW_CPP_DEFINE_in_rule125);  
                    stream_CPP_DEFINE.add(c);


                    }
                    break;
                case 3 :
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:63:46: c= CPP_UNDEF
                    {
                    c=(Token)match(input,CPP_UNDEF,FOLLOW_CPP_UNDEF_in_rule131);  
                    stream_CPP_UNDEF.add(c);


                    }
                    break;
                case 4 :
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:63:60: c= CPP_IFDEF
                    {
                    c=(Token)match(input,CPP_IFDEF,FOLLOW_CPP_IFDEF_in_rule137);  
                    stream_CPP_IFDEF.add(c);


                    }
                    break;
                case 5 :
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:63:74: c= CPP_IFNDEF
                    {
                    c=(Token)match(input,CPP_IFNDEF,FOLLOW_CPP_IFNDEF_in_rule143);  
                    stream_CPP_IFNDEF.add(c);


                    }
                    break;
                case 6 :
                    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:63:89: c= CPP_ELSIF
                    {
                    c=(Token)match(input,CPP_ELSIF,FOLLOW_CPP_ELSIF_in_rule149);  
                    stream_CPP_ELSIF.add(c);


                    }
                    break;

            }

            WS9=(Token)match(input,WS,FOLLOW_WS_in_rule152);  
            stream_WS.add(WS9);

            STRING10=(Token)match(input,STRING,FOLLOW_STRING_in_rule154);  
            stream_STRING.add(STRING10);



            // AST REWRITE
            // elements: c, STRING
            // token labels: c
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_c=new RewriteRuleTokenStream(adaptor,"token c",c);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 63:112: -> ^( $c STRING )
            {
                // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:63:115: ^( $c STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_c.nextNode(), root_1);

                adaptor.addChild(root_1, stream_STRING.nextNode());

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
    // $ANTLR end "rule"

    public static class empty_rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "empty_rule"
    // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:64:1: empty_rule : ( CPP_ELSE | CPP_ENDIF );
    public final PreprocessorParser.empty_rule_return empty_rule() throws RecognitionException {
        PreprocessorParser.empty_rule_return retval = new PreprocessorParser.empty_rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set11=null;

        CommonTree set11_tree=null;

        try {
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:64:12: ( CPP_ELSE | CPP_ENDIF )
            // V:\\dev\\skb\\projects\\utils\\src\\main\\java\\org\\skb\\lang\\preprocessor\\grammars\\Preprocessor.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set11=(Token)input.LT(1);
            if ( (input.LA(1)>=CPP_ELSE && input.LA(1)<=CPP_ENDIF) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set11));
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
    // $ANTLR end "empty_rule"

    // Delegated rules


 

    public static final BitSet FOLLOW_14_in_start65 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_start67 = new BitSet(new long[]{0x00000000000037F0L});
    public static final BitSet FOLLOW_WS_in_start69 = new BitSet(new long[]{0x00000000000037F0L});
    public static final BitSet FOLLOW_rule_in_start73 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_empty_rule_in_start82 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_start92 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_start95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOF_in_start100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CPP_INCLUDE_in_rule119 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CPP_DEFINE_in_rule125 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CPP_UNDEF_in_rule131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CPP_IFDEF_in_rule137 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CPP_IFNDEF_in_rule143 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CPP_ELSIF_in_rule149 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_rule152 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_STRING_in_rule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_empty_rule0 = new BitSet(new long[]{0x0000000000000002L});

}