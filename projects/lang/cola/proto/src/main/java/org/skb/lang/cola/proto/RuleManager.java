package org.skb.lang.cola.proto;

import java.util.ArrayList;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.skb.base.composite.TSBaseAPI;

public class RuleManager {

	public static StringTemplate contract02(StringTemplateGroup rules, String ident, String category){
		StringTemplate ret=rules.getInstanceOf("contract02");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		ret.setAttribute("category", category);
		return ret;
	}

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

	public static StringTemplate identifier02(StringTemplateGroup rules, String ident){
		StringTemplate ret=rules.getInstanceOf("identifier02");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		return ret;
	}

	public static StringTemplate identifier03(StringTemplateGroup rules, String ident){
		StringTemplate ret=rules.getInstanceOf("identifier03");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		return ret;
	}

	public static StringTemplate property01(StringTemplateGroup rules, String property, String category, String atom){
		StringTemplate ret=rules.getInstanceOf("property01");
		ret.setAttribute("do_error", true);
		ret.setAttribute("property", property);
		ret.setAttribute("category", category);
		ret.setAttribute("atom", atom);
		return ret;
	}

	public static StringTemplate property02(StringTemplateGroup rules, String property, String category, String atom){
		StringTemplate ret=rules.getInstanceOf("property02");
		ret.setAttribute("do_error", true);
		ret.setAttribute("property", property);
		ret.setAttribute("category", category);
		ret.setAttribute("atom", atom);
		return ret;
	}

	public static StringTemplate property03(StringTemplateGroup rules, String ident){
		StringTemplate ret=rules.getInstanceOf("property03");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		return ret;
	}

	public static StringTemplate property04(StringTemplateGroup rules, String ident){
		StringTemplate ret=rules.getInstanceOf("property04");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		return ret;
	}

	public static StringTemplate property05(StringTemplateGroup rules, String ident, int values){
		StringTemplate ret=rules.getInstanceOf("property05");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		ret.setAttribute("values", values);
		return ret;
	}

	public static StringTemplate property06(StringTemplateGroup rules, String ident, int values){
		StringTemplate ret=rules.getInstanceOf("property06");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		ret.setAttribute("values", values);
		return ret;
	}

	public static StringTemplate property09(StringTemplateGroup rules, String ident, String category){
		StringTemplate ret=rules.getInstanceOf("property09");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		ret.setAttribute("category", category);
		return ret;
	}

	public static StringTemplate property15(StringTemplateGroup rules, String ident, ArrayList<String> properties){
		StringTemplate ret=rules.getInstanceOf("property15");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		ret.setAttribute("properties", properties);
		return ret;
	}

	public static StringTemplate property11(StringTemplateGroup rules, String ident, String category){
		StringTemplate ret=rules.getInstanceOf("property11");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		ret.setAttribute("category", category);
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

	public static StringTemplate scopename01(StringTemplateGroup rules, String scoped_name){
		StringTemplate ret=rules.getInstanceOf("scopename01");
		ret.setAttribute("do_error", true);
		ret.setAttribute("scoped_name", scoped_name);
		return ret;
	}

	public static StringTemplate scopename02(StringTemplateGroup rules, String scoped_name, String leaf_category){
		StringTemplate ret=rules.getInstanceOf("scopename02");
		ret.setAttribute("do_error", true);
		ret.setAttribute("scoped_name", scoped_name);
		ret.setAttribute("leaf_category", leaf_category);
		return ret;
	}

	public static StringTemplate scopename03(StringTemplateGroup rules, String scoped_name, String current_atom, String reason){
		StringTemplate ret=rules.getInstanceOf("scopename03");
		ret.setAttribute("do_error", true);
		ret.setAttribute("scoped_name", scoped_name);
		ret.setAttribute("current_atom", current_atom);
		ret.setAttribute("reason", reason);
		return ret;
	}

	public static StringTemplate scopename04(StringTemplateGroup rules, String scoped_name, String category){
		StringTemplate ret=rules.getInstanceOf("scopename04");
		ret.setAttribute("do_error", true);
		ret.setAttribute("scoped_name", scoped_name);
		ret.setAttribute("category", category);
		return ret;
	}

	public static StringTemplate scopename05(StringTemplateGroup rules, String scoped_name, String category){
		StringTemplate ret=rules.getInstanceOf("scopename05");
		ret.setAttribute("do_error", true);
		ret.setAttribute("scoped_name", scoped_name);
		ret.setAttribute("category", category);
		return ret;
	}

	public static StringTemplate scopename06(StringTemplateGroup rules, String scoped_name, String current_atom_category, String scoped_name_category){
		StringTemplate ret=rules.getInstanceOf("scopename06");
		ret.setAttribute("do_error", true);
		ret.setAttribute("scoped_name", scoped_name);
		ret.setAttribute("current_atom_category", current_atom_category);
		ret.setAttribute("scoped_name_category", scoped_name_category);
		return ret;
	}


	public static StringTemplate contract03(StringTemplateGroup rules, String contract, String category, String atom){
		StringTemplate ret=rules.getInstanceOf("contract03");
		ret.setAttribute("do_error", true);
		ret.setAttribute("contract", contract);
		ret.setAttribute("category", category);
		ret.setAttribute("atom", atom);
		return ret;
	}

	public static StringTemplate contract04(StringTemplateGroup rules, String contract, String category, String atom){
		StringTemplate ret=rules.getInstanceOf("contract04");
		ret.setAttribute("do_error", true);
		ret.setAttribute("contract", contract);
		ret.setAttribute("category", category);
		ret.setAttribute("atom", atom);
		return ret;
	}

	public static StringTemplate contract06(StringTemplateGroup rules, String ident, ArrayList<String> contracts){
		StringTemplate ret=rules.getInstanceOf("contract06");
		ret.setAttribute("do_error", true);
		ret.setAttribute("ident", ident);
		ret.setAttribute("contracts", contracts);
		return ret;
	}

}
