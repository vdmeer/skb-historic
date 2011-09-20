package org.skb.tribe;

public enum TribeExitOptions {
	/** show-help, show a help text for the parser with all options and exit */
	HELP,

	/** show-version, show the version (number, build) of the parser and exit */
	VERSION,

	/** show-languages, show all possible combination of source/target languages of the parser and exit */
	LANGUAGES,

	/** default-options, show the default value for all available options and exit */
	DEF_OPTIONS,

	/** pr-stg-reportmgr, print the source of the StringTemplate for the Report Manager and exit */
	PRINT_STG_REPORTMGR
}
