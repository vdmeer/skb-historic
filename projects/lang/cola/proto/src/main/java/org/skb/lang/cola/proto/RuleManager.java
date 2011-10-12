package org.skb.lang.cola.proto;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.skb.base.composite.TSBaseAPI;

public class RuleManager {

	public static StringTemplate contract05(StringTemplateGroup rules, String scope, String ident){
		StringTemplate ret=rules.getInstanceOf("contract05");
		ret.setAttribute("do_error", true);
		ret.setAttribute("scope", scope);
		ret.setAttribute("ident", ident);
		return ret;
	}

	public static StringTemplate identifier01(StringTemplateGroup rules, TSBaseAPI ident, String category, TSBaseAPI categoryOrig, TSBaseAPI fileOrig, TSBaseAPI lineOrig, TSBaseAPI colOrig){
		StringTemplate ret=rules.getInstanceOf("identifier01");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		ret.setAttribute("category", category);
		ret.setAttribute("categoryOrig", categoryOrig);
		ret.setAttribute("fileOrig", fileOrig);
		ret.setAttribute("lineOrig", lineOrig);
		ret.setAttribute("colOrig", colOrig);
		return ret;
	}

	public static StringTemplate property12(StringTemplateGroup rules, String ident, String base_type, String const_type, String base_type_file,  int base_type_line, int base_type_col){
		StringTemplate ret=rules.getInstanceOf("property12");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		ret.setAttribute("base_type", base_type);
		ret.setAttribute("base_type_file", base_type_file);
		ret.setAttribute("base_type_line", base_type_line);
		ret.setAttribute("base_type_col", base_type_col);
		ret.setAttribute("const_type", const_type);
		return ret;
	}

	public static StringTemplate property13(StringTemplateGroup rules, String ident, String base_type, String const_type, String base_type_file,  int base_type_line, int base_type_col){
		StringTemplate ret=rules.getInstanceOf("property13");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		ret.setAttribute("base_type", base_type);
		ret.setAttribute("base_type_file", base_type_file);
		ret.setAttribute("base_type_line", base_type_line);
		ret.setAttribute("base_type_col", base_type_col);
		ret.setAttribute("const_type", const_type);
		return ret;
	}

	public static StringTemplate property14(StringTemplateGroup rules, String scope, String ident){
		StringTemplate ret=rules.getInstanceOf("property14");
		ret.setAttribute("do_error", true);
		ret.setAttribute("scope", scope);
		ret.setAttribute("ident", ident);
		return ret;
	}
}
