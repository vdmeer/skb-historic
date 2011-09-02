<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2007-2011, Sven van der Meer <sven@vandermeer.de>
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
 * File Factory.
 *
 * @package    Classes.File
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class File_Factory{
	/**
	 * Factory operation that will create a specific File object.
	 *
	 * Currently implemented are JPEG (JPG), PNG and SVG file objects. This operation gets a file 
	 * name (if null, then "default" will be used), extracts the file extension and selects the appropriate 
	 * implementation. For instance, the a filename with the extensions "svg" and "svgz" will result in the 
	 * creation of an SVG specific file object. Equially "jpg" and "jpeg" for JPEG and "png" for PNG. In case 
	 * of an unknown file extension, this function will trigger an E_USER_ERROR.
	 */
	public static function get_file($file=null){
		if($file==null)
			$select="default";
		else{
			$select=strtok(basename($file),".");
			$select=strtok(".");
		}
	
		switch($select){
			case "svg":
			case "svgz":
				return new File_SVG($file, $select); break;
			case "jpg":
			case "jpeg":
				return new File_JPEG($file, $select); break;
			case "png":
				return new File_PNG($file, $select); break;
			default:
				trigger_error("File_Factory: unknown file type requested -> {$select} for {$file}", E_USER_ERROR); break;
		}
	}
}
?>