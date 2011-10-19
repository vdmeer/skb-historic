/* Copyright (c) 2005-2011 Sven van der Meer
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
 *     + Neither the name of the the author nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS  IS"
 * AND ANY EXPRESS  OR IMPLIED WARRANTIES,  INCLUDING, BUT NOT  LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY  AND FITNESS FOR A  PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN  NO EVENT SHALL  THE COPYRIGHT HOLDER  OR CONTRIBUTORS BE
 * LIABLE  FOR  ANY  DIRECT,  INDIRECT,  INCIDENTAL,  SPECIAL,  EXEMPLARY,   OR
 * CONSEQUENTIAL  DAMAGES  (INCLUDING,  BUT  NOT  LIMITED  TO,  PROCUREMENT  OF
 * SUBSTITUTE GOODS  OR SERVICES;  LOSS OF  USE, DATA,  OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER  CAUSED AND  ON ANY  THEORY OF  LIABILITY, WHETHER  IN
 * CONTRACT,  STRICT LIABILITY,  OR TORT  (INCLUDING NEGLIGENCE  OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE  USE OF THIS SOFTWARE, EVEN IF ADVISED  OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 */

package org.skb.base.utils;

import org.antlr.runtime.Token;
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.TSRepository.TEnum;
import org.skb.base.composite.antlr.TSToken;

/**
 * Utilities that help processing ANTLR Tokens and Trees.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TokenUtils {

	/**
	 * Returns the string version of the Token.
	 * @param tk token to transform to string
	 * @return string version of token, or "" if input is null
	 */
	public static String getTokenString(Token tk){
		if(tk==null)
			return "";
		return tk.getText();
	}

	/**
	 * Returns the string version of the Token as lower case string.
	 * @param tk token to transform to string
	 * @return string version of token, or "" if input is null
	 */
	public static String getTokenString2Lower(Token tk){
		return TokenUtils.getTokenString(tk).toLowerCase();
	}

	/**
	 * Returns the string version of the child of a tree.
	 * @param tree tree tree to process
	 * @param child child index
	 * @return string version of the child requested, of child index 0 if child is null or "" of tree is null
	 */
	public static String getTreeString(org.antlr.runtime.tree.Tree tree, Integer child){
		if(tree==null)
			return "";
		if(child==null)
			return tree.getChild(0).toString();
		return tree.getChild(child).toString();
	}

	/**
	 * Returns the string version of the child of a tree as lower case string.
	 * @param tree tree tree to process
	 * @param child child index
	 * @return string version of the child requested, of child index 0 if child is null or "" of tree is nulls
	 */
	public static String getTreeString2Lower(org.antlr.runtime.tree.Tree tree, Integer child){
		return TokenUtils.getTreeString(tree, child).toLowerCase();
	}

	/**
	 * Returns the string version of all direct children of the tree using the given separator.
	 * @param tree tree to process
	 * @param separator separator to be used to concatenate the children
	 * @return string version of the tree
	 */
	public static String getTreeString(org.antlr.runtime.tree.Tree tree, String separator){
		String ret=new String();
		for(int i=0;i<tree.getChildCount();i++){
			if(ret.length()>0)
				ret+=separator;
			ret+=tree.getChild(i);
		}
		return ret;
	}

	/**
	 * Returns the string version of all direct children of the tree using the given separator.
	 * @param tree tree to process
	 * @return string version of the tree
	 */
	public static String getTreeString(org.antlr.runtime.tree.Tree tree){
		return TokenUtils.getTreeString(tree, "");
	}

	/**
	 * Returns the string version of all direct children of the tree using the given separator.
	 * @param tree tree to process
	 * @param separator separator to be used to concatenate the children
	 * @return string version of the tree
	 */
	public static String getTreeString2Lower(org.antlr.runtime.tree.Tree tree, String separator){
		return TokenUtils.getTreeString(tree, separator).toLowerCase();
	}

	/**
	 * Returns the string version of all direct children of the tree using the given separator.
	 * @param tree tree to process
	 * @return string version of the tree
	 */
	public static String getTreeString2Lower(org.antlr.runtime.tree.Tree tree){
		return TokenUtils.getTreeString2Lower(tree, "");
	}

	/**
	 * Returns the line the token was recognised in.
	 * @param tk token
	 * @return line it was recognised in
	 */
	public static int getLine(Token tk){
		if(tk==null)
			return 0;
		return tk.getLine();
	}

	/**
	 * Returns the line the token was recognised in.
	 * @param tk token
	 * @return line it was recognised in
	 */
	public static int getLine(TSToken tk){
		if(tk==null)
			return 0;
		return tk.getLine();
	}

	/**
	 * Returns the line the token was recognised in.
	 * @param tk token
	 * @return line it was recognised in
	 */
	public static int getLine(TSBaseAPI tk){
		if(tk==null)
			return 0;
		if(tk.tsIsType(TEnum.TS_ATOMIC_ANTLR_TOKEN))
			return ((TSToken)tk).getLine();
		return 0;
	}

	/**
	 * Returns the line of a child of the tree.
	 * @param tree
	 * @param child
	 * @return 0 if the tree is null, the line of child 0 if child is null, the line of the requested child otherwise
	 */
	public static int getLine(org.antlr.runtime.tree.Tree tree, Integer child){
		if(tree==null)
			return 0;
		if(child==null)
			return tree.getChild(0).getLine();
		return tree.getChild(child).getLine();
	}

	/**
	 * Returns the line of the given tree
	 * @param tree
	 * @return 0 if the tree is null, the line of the requested child otherwise
	 */
	public static int getLine(org.antlr.runtime.tree.Tree tree){
		if(tree==null)
			return 0;
		return tree.getLine();
	}

	/**
	 * Returns the column the token was recognised in.
	 * @param tk token
	 * @return column it was recognised in
	 */
	public static int getColumn(Token tk){
		if(tk==null)
			return 0;
		return tk.getCharPositionInLine();
	}

	/**
	 * Returns the column the token was recognised in.
	 * @param tk token
	 * @return column it was recognised in
	 */
	public static int getColumn(TSToken tk){
		if(tk==null)
			return 0;
		return tk.getCharPositionInLine();
	}

	/**
	 * Returns the column the token was recognised in.
	 * @param tk token
	 * @return column it was recognised in, 0 if token was null
	 */
	public static int getColumn(TSBaseAPI tk){
		if(tk==null)
			return 0;
		if(tk.tsIsType(TEnum.TS_ATOMIC_ANTLR_TOKEN))
			return ((TSToken)tk).getCharPositionInLine();
		return 0;
	}

	/**
	 * Returns the column of a child of the tree.
	 * @param tree
	 * @param child
	 * @return 0 if the tree is null, the column of child 0 if child is null, the column of the requested child otherwise
	 */
	public static int getColumn(org.antlr.runtime.tree.Tree tree, Integer child){
		if(tree==null)
			return 0;
		if(child==null)
			return tree.getChild(0).getCharPositionInLine();
		return tree.getChild(child).getCharPositionInLine();
	}

	/**
	 * Returns the column of the given tree
	 * @param tree
	 * @return 0 if the tree is null, the column of the requested child otherwise
	 */
	public static int getColumn(org.antlr.runtime.tree.Tree tree){
		if(tree==null)
			return 0;
		return tree.getCharPositionInLine();
	}
}
