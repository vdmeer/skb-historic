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
 * JPEG File functions.
 *
 * @package    Classes.File
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class File_JPEG extends File_Base{
	public function __construct($fn, $type){
		parent::__construct($fn, $type);
	}


	protected function _get_content(){
		return new Util_ArBase();
	}

	protected function _get_meta_data(){
		$ret=new Util_ArBase();
		if(file_exists($this->fn)){
			$exifAr=exif_read_data($this->fn);
			if(isset($exifAr["Model"]))
				$ret->ar['Model']=$exifAr["Model"];
			if(isset($exifAr["DateTimeOriginal"]))
				$ret->ar['DateTimeOriginal']=$exifAr["DateTimeOriginal"];
			if(isset($exifAr["ExposureTime"]))
				$ret->ar['ExposureTime']=$exifAr["ExposureTime"];
			if(isset($exifAr["FNumber"]))
				$ret->ar['FNumber']=$exifAr["FNumber"];
			if(isset($exifAr["FocalLength"]))
				$ret->ar['FocalLength']=$exifAr["FocalLength"];
			if(isset($exifAr["ExposureProgram"]))
				$ret->ar['ExposureProgram']=$exifAr["ExposureProgram"];
			if(isset($exifAr["ISOSpeedRatings"]))
				$ret->ar['ISOSpeedRatings']=$exifAr["ISOSpeedRatings"];

			if(isset($exifAr["COMPUTED"]["Height"]))
				$ret->ar['Height']=$exifAr["COMPUTED"]["Height"];
			if(isset($exifAr["COMPUTED"]["Width"]))
				$ret->ar['Width']=$exifAr["COMPUTED"]["Width"];
			if(isset($exifAr["COMPUTED"]["CCDWidth"]))
				$ret->ar['CCDWidth']=$exifAr["COMPUTED"]["CCDWidth"];
			if(isset($exifAr["COMPUTED"]["ApertureFNumber"]))
				$ret->ar['ApertureFNumber']=$exifAr["COMPUTED"]["ApertureFNumber"];
		}
		return $ret;
  }
}
?>