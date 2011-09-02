<?php
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2010-2011, Sven van der Meer <sven@vandermeer.de>
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
 *       documentation and/or other materials provided with the distribution.
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
 */

/**
 * SKB Value Interpreter for Dist.Publications, creates a time string based on the date array of the reference.
 *
 * @package    Packages.Dist.Publications
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class pkg_dist__publications___entry_date_mktime___interpreter implements SKB_InterpreterValue{
	public function __construct(){
	}

	static public function interpret($entry){
		$mySKB=SKB_Main::get_instance();
		$date="";
		
		switch($entry['publications:entry_type']['key']){
			case "article":
			case "book":
			case "collection":
			case "mastersthesis":
			case "phdthesis":
			case "proceedings":
			case "report":
			case "standard":
			case "techreport":
			case "thesis":
				$date=$mySKB->interpret_data("Dist.Date.Interpreter.Mktime", $entry);
				break;

			case "inbook":
			case "incollection":
				$date=$mySKB->interpret_data("Dist.Date.Interpreter.Mktime", $entry['publications:published_in']);
				break;

			case "conference":
			case "inproceedings":
			case "poster":
			case "tutorial":
			case "presentation":
				if(isset($entry['publications:conference']))
					$date=$mySKB->interpret_data("Dist.Date.Interpreter.Mktime", $entry['publications:conference']);
				elseif(isset($entry['publications:event']))
					$date=$mySKB->interpret_data("Dist.Date.Interpreter.Mktime", $entry['publications:event']);
				break;
		}
		return $date;
	}
}
?>