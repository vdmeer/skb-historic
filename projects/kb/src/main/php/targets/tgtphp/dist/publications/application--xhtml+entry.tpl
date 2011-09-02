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
 * Template for the SKB Package Dist.Publications, creates HTML code for a single reference.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Publications
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */

	if(count($request->get_value("publications:show_abstract"))==0)
		unset($entry['publications:abstract']);

	$hBR="<br />\n";

	$mySKB=SKB_Main::get_instance();

	//author is either first organisation (standards), or author-list or editor-list
	if($entry['publications:entry_type']['key']=='standard'){
		if(isset($entry['default:organization'][0]['default:name']))
			$entry["publications:author"]=$entry['default:organization'][0]['default:name'];
		else
			$entry["publications:author"]=$entry['default:organization'][0]['default:acronym']['acronyms:long'];
	}
	elseif(isset($entry['publications:author']))
		$entry["publications:author"]=$mySKB->interpret_data("Dist.People.Interpreter.String", $entry["publications:author"]);
	elseif(isset($entry['publications:editor'])){
		$entry["publications:author"]=$mySKB->interpret_data("Dist.People.Interpreter.String", $entry["publications:editor"]);
		if(count($entry["publications:editor"])==1)
			$entry["publications:author"].=" (Ed.)";
		else
			$entry["publications:author"].=" (Eds.)";
	}
	elseif(isset($entry['default:organization'])){
		if(isset($entry['default:organization'][0]['default:name']))
			$entry["publications:author"]=$entry['default:organization'][0]['default:name'];
		else
			$entry["publications:author"]=$entry['default:organization'][0]['default:acronym']['acronyms:long'];
	}
	elseif(isset($entry['default:institution'])){
		if(isset($entry['default:institution'][0]['default:name']))
			$entry["publications:author"]=$entry['default:institution'][0]['default:name'];
		else
			$entry["publications:author"]=$entry['default:institution'][0]['default:acronym']['acronyms:long'];
	}

	//editor is always editor
	$editors_sup="";
	if(isset($entry['publications:editor'])){
		if(count($entry["publications:editor"])==1)
			$_sup=" (Ed.)";
		else
			$_sup=" (Eds.)";
		$entry["publications:editor"]=$mySKB->interpret_data("Dist.People.Interpreter.String", $entry["publications:editor"]).$_sup;
	}

	if(isset($entry["publications:conference"]["publications:published_in"])){
		$entry["publications:published_in"]=$entry["publications:conference"]["publications:published_in"];
		unset($entry["publications:conference"]["publications:published_in"]);
	}
	if(isset($entry["publications:event"]["publications:published_in"])){
		$entry["publications:published_in"]=$entry["publications:event"]["publications:published_in"];
		unset($entry["publications:event"]["publications:published_in"]);
	}

	if(isset($entry["publications:published_in"]["publications:editor"])){
		(count($entry["publications:published_in"]["publications:editor"])>0)?$_sup=" (Ed.)":$_sup=" (Eds.)";
		$entry["publications:published_in"]["publications:editor"]=$mySKB->interpret_data("Dist.People.Interpreter.String", $entry["publications:published_in"]["publications:editor"]).$_sup;
	}

	$date=$mySKB->interpret_data("Dist.Publication.Interpreter.EntryDateString", $entry);

?>
	<span class="author">
		<?php
			$mySKB=SKB_Main::get_instance();
			if(isset($entry["publications:author"]))
				echo $entry["publications:author"];
			else
				echo $entry["publications:editor"];

			switch($entry['publications:entry_type']['key']){
				case "thesis":
				case "phdthesis":
				case "mastersthesis":
					echo ": ";
					break;
				default:
					echo "<br />";
					break;
			}
		?>
	</span>
	<span class="title">
		<?php
			if(isset($entry['publications:title'])){
				echo $entry['publications:title'];
				if(isset($entry['publications:subtitle']))
					echo " - <span class=\"subtitle\">{$entry['publications:subtitle']}</span>";
			}
		?>
	</span><br />

<?php
	switch($entry['publications:entry_type']['key']){
		case "thesis":
		case "phdthesis":
		case "mastersthesis":
			$s="";
			if(isset($entry['publications:type']))
				$s.=$entry['publications:type'] . ": ";
			if(isset($entry['default:institution'][0]['default:acronym']['acronyms:long']))
				$s.=$entry['default:institution'][0]['default:acronym']['acronyms:long'];
			elseif(isset($entry['default:institution'][0]['default:name']))
				$s.=$entry['default:institution'][0]['default:name'];
			$s.=", " . $entry['default:institution'][0]['default:city']['default:name'];
			$s.=", " . $entry['default:institution'][0]['default:city']['default:country']['default:name'];
			$s.=", " . $date;
			echo $s;
			break; 

		case "report":
		case "techreport":
			$s="";
			if(isset($entry['default:organization'])){
				$_keys=array_keys($entry['default:organization']);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if($i>0)
						$s.="/";
					if(isset($entry['default:organization'][$i]['default:name']))
						$s.=$entry['default:organization'][$i]['default:name'];
					else
						$s.=$entry['default:organization'][$i]['default:acronym']['acronyms:long'];
				}
				$s.=", " . $entry['default:organization'][0]['default:city']['default:name'];
				$s.=", " . $entry['default:organization'][0]['default:city']['default:country']['default:name'];
			}
			elseif(isset($entry['default:institution'])){
				$_keys=array_keys($entry['default:institution']);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if($i>0)
						$s.="/";
					if(isset($entry['default:institution'][$i]['default:name']))
						$s.=$entry['default:institution'][$i]['default:name'];
					else
						$s.=$entry['default:institution'][$i]['default:acronym']['acronyms:long'];
				}
				$s.=", " . $entry['default:institution'][0]['default:city']['default:name'];
				$s.=", " . $entry['default:institution'][0]['default:city']['default:country']['default:name'];
			}
			$s.=", " . $date;
			echo $s;
			break;

		case "poster":
		case "standard":
			$s="";
			if(isset($entry['publications:series']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:series'];
			if(isset($entry['publications:number']))
				$s.=Util_Interpreter::interpret("add:char:blank", $s) . $entry['publications:number'];
			if(isset($entry['publications:edition']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:edition'];
			if(isset($entry['publications:type']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:type'];
			if(isset($entry['publications:howpublished']))
				$s.=" " . $entry['publications:howpublished'];
				//$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['howpublished'];

			if(isset($entry['default:organization'][0]['default:name']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:organization'][0]['default:name'];
			else
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:organization'][0]['default:acronym']['acronyms:long'];

			$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:organization'][0]['default:city']['default:name'];
			$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:organization'][0]['default:country']['default:name'];

			$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $date;
			echo $s;
			if(isset($entry['publications:note']))
				echo "<br />note: <i>" . $entry['publications:note'] . "</i>";
			break;

		case "inbook":
		case "incollection":
			echo $hBR;
			echo "published in: <i>";

			echo $entry["publications:published_in"]["publications:editor"];
			echo ": <b>". $entry["publications:published_in"]['publications:title'] . "</b></i>";
			if(isset($entry['publications:subtitle']))
				echo " - <b><i>{$entry['publications:subtitle']}</i></b>";

			$s=", ";
			if(isset($entry["publications:published_in"]['publications:series']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]['publications:series'];
			if(isset($entry["publications:published_in"]['publications:edition']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]['publications:edition'] . "<sup>" . Util_Interpreter::interpret("integer:ordinal_text", $entry["publications:published_in"]['publications:edition']) . "</sup>" . " Edition";
			if(isset($entry["publications:published_in"]['publications:version']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]['publications:version'];
			if(isset($entry["publications:published_in"]['publications:isbn']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN: " . $entry["publications:published_in"]['publications:isbn'];
			if(isset($entry["publications:published_in"]['publications:isbn_10']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN-10: " . $entry["publications:published_in"]['publications:isbn_10'];
			if(isset($entry["publications:published_in"]['publications:isbn_13']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN-13: " . $entry["publications:published_in"]['publications:isbn_13'];
			if(isset($entry["publications:published_in"]["pagetotal"]))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "pages: " . $entry["publications:published_in"]["pagetotal"];

			if(isset($entry["publications:published_in"]["default:publisher"])){
				if(isset($entry["publications:published_in"]["default:publisher"]['default:name']))
					$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['default:name'];
				else
					$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['default:acronym']['acronyms:short'];
				if(isset($entry["publications:published_in"]["default:publisher"]['affiliations:address']))
					$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['affiliations:address'];
				elseif(isset($entry["publications:published_in"]["default:publisher"]['default:city']))
					$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['default:city']['default:name'] . Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['default:city']['default:country']['default:name'];
				elseif(isset($entry["publications:published_in"]["default:publisher"]['default:country']))
					$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['default:country']['default:name'];
			}
			$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $date;
			echo $s;
			break;

		case "proceedings":
			$s="";
			if(isset($entry['publications:conference'])){
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "Proceedings of the ";
				if(isset($entry['publications:conference']['publications:iteration']))
					$s.=$entry['publications:conference']['publications:iteration'].Util_Interpreter::interpret("integer:ordinal:text", $entry['publications:conference']['publications:iteration']).' ';
				if(isset($entry['publications:conference']['default:sponsor'])){
					$_keys=array_keys($entry['publications:conference']['default:sponsor']);
					$_size=count($_keys);
					for($i=0;$i<$_size;$i++){
						if($i>0)
							$s.="/";
						$s.=$entry['publications:conference']['default:sponsor'][$i]['default:acronym']['acronyms:short'];
					}
					$s.=" ";
				}
				$s.=$entry['publications:conference']['default:acronym']['acronyms:long'];
				$s.=" (" . $entry['publications:conference']['default:acronym']['acronyms:short'] . " " . $entry['publications:conference']['default:year'] . ")";
			}

			if(isset($entry['publications:series']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:series'];
			if(isset($entry['publications:volume']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "vol. " . $entry['publications:volume'];
			if(isset($entry['publications:number']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "no. " . $entry['publications:number'];
			if(isset($entry['default:publisher'])){
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:publisher']['default:name'];
				if(isset($entry['default:publisher']['affiliations:address']))
					$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:publisher']['affiliations:address'];;
			}
			if(isset($entry['publications:isbn']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN: " . $entry['publications:isbn'];
			$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $date;
			echo $s;
			break;

		case "conference":
		case "inproceedings":
			echo "in Proc. of the ";
			if(isset($entry['publications:conference']['publications:iteration']))
				echo $entry['publications:conference']['publications:iteration'].Util_Interpreter::interpret("integer:ordinal:text", $entry['publications:conference']['publications:iteration']).' ';
			if(isset($entry['publications:conference']['default:sponsor'])){
				$_keys=array_keys($entry['publications:conference']['default:sponsor']);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if($i>0)
						echo "/";
					echo $entry['publications:conference']['default:sponsor'][$i]['default:acronym']['acronyms:short'];
				}
				echo " ";
			}
			echo $entry['publications:conference']['default:acronym']['acronyms:long'];
			echo " (" . $entry['publications:conference']['default:acronym']['acronyms:short'] . " " . $entry['publications:conference']['default:year'] . ")";
			echo ", " . $entry['publications:conference']['default:city']['default:name'];
			echo ", " . $entry['publications:conference']['default:city']['default:country']['default:name'];
			echo ", " . $date;
			if(isset($entry["publications:published_in"])){
				echo $hBR;
				echo $hBR;
				echo "published in: <i>";
				echo $entry["publications:published_in"]["publications:editor"];
				echo ": <b>". $entry["publications:published_in"]['publications:title'] . "</b></i>";
				if(isset($entry["publications:published_in"]['publications:subtitle']))
					echo " - <b><i>{$entry["publications:published_in"]['publications:subtitle']}</i></b>";
				if(isset($entry["publications:published_in"]['publications:series']))
					echo ", " . $entry["publications:published_in"]['publications:series'];
				if(isset($entry["publications:published_in"]['publications:volume']))
					echo ", vol. " . $entry["publications:published_in"]['publications:volume'];
				if(isset($entry["publications:published_in"]['publications:number']))
					echo ", no. " . $entry["publications:published_in"]['publications:number'];
				if(isset($entry["publications:published_in"]['default:publisher'])){
					echo ", " . $entry["publications:published_in"]['default:publisher']['default:name'];
					if(isset($entry["publications:published_in"]['default:publisher']['affiliations:address']))
						echo ", " . $entry["publications:published_in"]['default:publisher']['affiliations:address'];
				}
				if(isset($entry["publications:published_in"]['publications:isbn']))
					echo ", ISBN: " . $entry["publications:published_in"]['publications:isbn'];
				if(isset($entry['publications:pages']))
					echo ", pp. " . $entry['publications:pages'];
				echo ", " . $date;
			}
			break;

		case "tutorial":
		case "presentation":
			$s="";
			if(isset($entry['publications:note']))
				$s.=$entry['publications:note'] . ": ";

			if(isset($entry['publications:conference'])){
				if(isset($entry['publications:conference']['publications:iteration']))
					$s.=$entry['publications:conference']['publications:iteration'].Util_Interpreter::interpret("integer:ordinal:text", $entry['publications:conference']['publications:iteration']).' ';
				if(isset($entry['publications:conference']['default:sponsor'])){
					$_keys=array_keys($entry['publications:conference']['default:sponsor']);
					$_size=count($_keys);
					for($i=0;$i<$_size;$i++){
						if($i>0)
							$s.="/";
						$s.=$entry['publications:conference']['default:sponsor'][$i]['default:acronym']['acronyms:short'];
					}
					$s.=" ";
				}
				$s.=$entry['publications:conference']['default:acronym']['acronyms:long'];
				$s.=" (" . $entry['publications:conference']['default:acronym']['acronyms:short'] . " " . $entry['publications:conference']['default:year'] . ")";
				$s.=", " . $entry['publications:conference']['default:city']['default:name'];
				$s.=", " . $entry['publications:conference']['default:city']['default:country']['default:name'];
				$s.=", " . $date;
			}
			elseif(isset($entry['publications:event'])){
				if(isset($entry['publications:event']['publications:iteration']))
					$s.=$entry['publications:event']['publications:iteration'].Util_Interpreter::interpret("integer:ordinal:text", $entry['publications:event']['publications:iteration']).' ';
				if(isset($entry['publications:event']['default:organization'])){
					$_keys=array_keys($entry['publications:event']['default:organization']);
					$_size=count($_keys);
					for($i=0;$i<$_size;$i++){
						if($i>0)
							$s.="/";
						$s.=$entry['publications:event']['default:organization'][$i]['default:acronym']['acronyms:short'];
					}
					$s.=" ";
				}
				$s.=$entry['publications:event']['default:name'];
				$s.=", " . $entry['publications:event']['default:city']['default:name'];
				$s.=", " . $entry['publications:event']['default:city']['default:country']['default:name'];
				$s.=", " . $date;
			}
			echo $s;
			break;

		case "article":
			echo $entry['publications:journal']['default:acronym']["acronyms:long"];
			echo " (" . $entry['publications:journal']['default:acronym']["acronyms:short"] . ")";
			if(isset($entry['publications:journal']["default:publisher"]['default:name']))
				echo ", " . $entry['publications:journal']["default:publisher"]['default:name'];
			else
				echo ", " . $entry['publications:journal']["default:publisher"]['default:acronym']['acronyms:short'];
			if(isset($entry['publications:journal']["default:publisher"]['affiliations:address']))
				echo ", " . $entry['publications:journal']["default:publisher"]['affiliations:address'];
			else
				echo ", " . $entry['publications:journal']["default:publisher"]['default:city']['default:name'];
			if(isset($entry['publications:journal']["default:publisher"]['default:country']))
				echo ", " . $entry['publications:journal']["default:publisher"]['default:country']['default:name'];
			if(isset($entry['publications:journal']["publications:issn_print"]))
				echo ", ISSN: " . $entry['publications:journal']["publications:issn_print"];
			if(isset($entry['publications:journal']["publications:issn_online"]))
				echo ", ISSN (online): " . $entry['publications:journal']["publications:issn_online"];
			if(isset($entry["publications:number"]))
				echo ", no. " . $entry["publications:number"];
			if(isset($entry["publications:volume"]))
				echo ", vol. " . $entry["publications:volume"];
			if(isset($entry["publications:issue"]))
				echo ", issue " . $entry["publications:issue"];
			echo ", " . $date;
			break;

		case "collection":
		case "book":
			$s="";
			if(isset($entry['publications:series']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:series'];
			if(isset($entry['publications:edition']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:edition'] . "<sup>" . Util_Interpreter::interpret("integer:ordinal:text", $entry['publications:edition']) . "</sup>" . " Edition";
			if(isset($entry['publications:version']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:version'];
			if(isset($entry['publications:isbn']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN: " . $entry['publications:isbn'];
			if(isset($entry['publications:isbn_10']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN-10: " . $entry['publications:isbn_10'];
			if(isset($entry['publications:isbn_13']))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN-13: " . $entry['publications:isbn_13'];
			if(isset($entry["publications:pagetotal"]))
				$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "pages: " . $entry["publications:pagetotal"];

			if(isset($entry["default:publisher"])){
				if(isset($entry["default:publisher"]['default:name']))
					$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["default:publisher"]['default:name'];
				else
					$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["default:publisher"]['default:acronym']['acronyms:short'];
				if(isset($entry["default:publisher"]['affiliationsaddress']))
					$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["default:publisher"]['affiliations:address'];
				elseif(isset($entry["default:publisher"]['default:city']))
					$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["default:publisher"]['default:city']['default:name'];
				if(isset($entry["default:publisher"]['default:country']))
					$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["default:publisher"]['default:country']['default:name'];
			}
			$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $date;
			echo $s;
			break;
	}

	if(isset($entry["publications:abstract"]))
		echo '<br /><br /><span class="abstract">' . $entry["publications:abstract"] . '</span>';

	if(isset($entry["publications:keywords"]))
		echo '<br /><br /><span class="keywords">' . implode(",",$entry["publications:keywords"]) . '</span>';

	$links="";

	$ref_request=$mySKB->get_request("Dist.Publications");
	$ref_request->set_value("publications:publications_key", $entry['key']);
	$a='<a href="' . $ref_request->build_url($_SERVER["PHP_SELF"]) . '">' . "details" . "</a>";
	$links.=Util_Interpreter::interpret("add:char:comma-blank", $links) . $a;

	if(isset($entry["default:url"])){
		$a='<a href="' . $entry["default:url"] . '">' . "document" . "</a>";
		$links.=Util_Interpreter::interpret("add:char:comma-blank", $links) . $a;
	}
	if(isset($entry["conference"]["default:url"])){
		$a='<a href="' . $entry["conference"]["default:url"] . '">' . "conference" . "</a>";
		$links.=Util_Interpreter::interpret("add:char:comma-blank", $links) . $a;
	}
	if(isset($entry["proceedings"]["default:url"])){
		$a='<a href="' . $entry["proceedings"]["default:url"] . '">' . "proceedings" . "</a>";
		$links.=Util_Interpreter::interpret("add:char:comma-blank", $links) . $a;
	}
	if(isset($entry["event"]["default:url"])){
		$a='<a href="' . $entry["event"]["default:url"] . '">' . "event" . "</a>";
		$links.=Util_Interpreter::interpret("add:char:comma-blank", $links) . $a;
	}
	if(isset($entry['publications:journal']["default:url"])){
		$a='<a href="' . $entry['publications:journal']["default:url"] . '">' . "journal" . "</a>";
		$links.=Util_Interpreter::interpret("add:char:comma-blank", $links) . $a;
	}
	if($links!="")
		echo '<br /><br /><span class="links">' . $links . '</span>';

	$skb_links="";
	if(isset($entry["core:urn"])){
		$mySKB=SKB_Main::get_instance();
		$lib_dir=$mySKB->configuration->get_group("path","library-abs");
		$urn=str_replace(":","/",$entry["core:urn"]);
		$fn=$lib_dir . $urn;

		$types=$mySKB->configuration->get_group("skb","file-extensions");
		$_keys=array_keys($types);
		$_size=count($types);
		for($i=0;$i<$_size;$i++){
			if(file_exists($fn.".".$types[$i])){
				$a='<a href="' . $mySKB->configuration->get_group("path","library-rel").$urn.".".$types[$i] . '">' . $types[$i] . "</a>";
				$skb_links.=Util_Interpreter::interpret("add:char:comma-blank", $skb_links) . $a;
			}
		}
	}
	if($skb_links!=""){
		if($links==null)
			echo "<br /><br />";
		echo '<span class="skb_links">' . $skb_links . '</span>';
	}

	if(isset($entry["publications:tags"]))
		echo ' <span class="skb_tags">' . implode(", ",$entry["publications:tags"]) . '</span>';
?>