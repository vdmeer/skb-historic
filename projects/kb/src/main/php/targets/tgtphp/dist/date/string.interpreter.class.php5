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
 * SKB Value Interpreter in the SKB Package Dist.Content, converting a date array into a string.
 *
 * @package    Packages.Dist.Date
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class pkg_dist__date___string___interpreter implements SKB_InterpreterValue{
	public function __construct(){
	}

	static public function interpret($ar){
		$ret="";

		if(isset($ar["default:month"]))
			$ret.=$ar["default:month"]['default:name'];
		else if(isset($ar["default:month_start"]))
			$ret.=$ar["default:month_start"]['default:name'];

		if(isset($ar["default:day"]))
		  $ret.=Util_Interpreter::interpret("add:char:blank", $ret) . $ar["default:day"];
		else{
			if(!isset($ar["default:month_end"])){
				if(isset($ar["default:day_start"]))
					$ret.=Util_Interpreter::interpret("add:char:blank", $ret) . $ar["default:day_start"];
				if(isset($ar["default:day_end"]))
					$ret.=Util_Interpreter::interpret("add:char:hyphen", $ret) . $ar["default:day_end"];
			}
			else{
				if(isset($ar["default:day_start"]))
					$ret.=Util_Interpreter::interpret("add:char:blank", $ret) . $ar["default:day_start"];
				$ret.=Util_Interpreter::interpret("add:char:blank", $ret) . Util_Interpreter::interpret("add:char:hyphen-blank", $ret) . $ar["default:month_end"]['default:name'];
				if(isset($ar["default:day_end"]))
					$ret.=Util_Interpreter::interpret("add:char:blank", $ret) . $ar["default:day_end"];
			}
		}
		if(isset($ar["default:year"]))
			$ret.=Util_Interpreter::interpret("add:char:comma-blank", $ret) . $ar["default:year"];
		return $ret;
	}
}
?>