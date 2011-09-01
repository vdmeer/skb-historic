<?php
$site_id="demo";
$site_path="/www/demo";
require_once "../../../../htdocs/skb/classes/main.inc.php5";

$todo=array(
	"dist.publications.entrytypes" => array("skb:publications:entrytypes"),
	"dist.geo"                     => array("skb:geo:cities", "skb:geo:continents", "skb:geo:countries"),
	"dist.date"                    => array("skb:date:dom", "skb:date:dow", "skb:date:month"),
	"dist.acronyms"                => array("skb:acronyms"),
	"dist.affiliations"            => array("skb:affiliations", "skb:affiliations:type"),
	"dist.currencies"              => array("skb:currencies"),
//	"dist.units"                   => array(),
//	"dist.modelrailway"            => array()
);

$entries=array();
$myDM=SKB_DataManager::get_instance();
foreach($todo as $pkg => $sema_tag){
	$handle=fopen("pkg.".$pkg.".php5", "wb");
	fwrite($handle,"<?php\n");
	fwrite($handle,"class GetTextDummy{\n");
	fwrite($handle,"  function dummy(){\n");

	$skb_main->require_package($pkg);
	foreach($sema_tag as $tag){
		echo "skb: create gettext for {$pkg} // {$tag}\n";
		$entries=$myDM->query_data_object($myDM->prepare_query($tag,null,null,null,$pkg,null,false,true))->ar;

		foreach($entries as $entry){
			foreach($entry as $col){
				if(strpos($col,"pkg.".$pkg."%%")!==false){
					$domain=strtok($col,"%%");
					$text=strtok("%%");
					fwrite($handle,'    _("'.$text.'");'."\n");
					//echo $col."\n";
				}
//				else
//					echo $pkg." == ".$col."\n";
			}
		}
	}

	fwrite($handle,"  }\n");
	fwrite($handle,"}\n");
	fclose($handle);
}
?>
