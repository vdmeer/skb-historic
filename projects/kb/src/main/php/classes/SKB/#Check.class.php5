<?php 

class SKB_Check {
  private $skb_main;

  public function __construct($lang="en"){
    $this->skb_main=SKB_Main::get_instance();
  }

  public function check(){
    echo "starting consistency check --> ref_references\n<br />";
      $this->_checkKeys("ref_references", "skb_type", array("ref_entrytypes"), false, true);
      $this->_checkKeys("ref_references", "skb_key", array("ref_references", "ref_conferences", "ref_journals", "ref_events"));
      $this->_checkKeys("ref_references", "month_key", array("date_month"));
      $this->_checkKeys("ref_references", "month_start_key", array("date_month"));
      $this->_checkKeys("ref_references", "month_end_key", array("date_month"));
      $this->_checkKeys("ref_references", "publisher_key", array("ref_publishers"));
      $this->_checkKeys("ref_references", "url_month_key", array("date_month"));
      //$this->_checkKeys("ref_references", "language_key", "");
      $this->_checkKeys("ref_references", "institution_keys", array("affiliations"), true);
      $this->_checkKeys("ref_references", "organization_keys", array("affiliations"));

      $this->_checkPeopleInRef("author_keys");
      $this->_checkPeopleInRef("editor_keys");
    echo "finished consistency check --> ref_references\n<br />";

    echo "starting consistency check --> ref_publishers\n<br />";
      $this->_checkKeys("ref_publishers", "acronym_key", array("acronyms"));
      $this->_checkKeys("ref_publishers", "country_key", array("geo_countries"));
      $this->_checkKeys("ref_publishers", "city_key", array("geo_cities"));
    echo "finished consistency check --> ref_publishers\n<br />";

    echo "starting consistency check --> ref_journals\n<br />";
      $this->_checkKeys("ref_journals", "acronym_key", array("acronyms"));
      $this->_checkKeys("ref_journals", "publisher_key", array("ref_publishers"));
    echo "finished consistency check --> ref_journals\n<br />";

    echo "starting consistency check --> ref_events\n<br />";
      $this->_checkKeys("ref_events", "organization_keys", array("affiliations"), true);
      $this->_checkKeys("ref_events", "sponsor_keys", array("affiliations"), true);
      $this->_checkKeys("ref_events", "city_key", array("geo_cities"));
      $this->_checkKeys("ref_events", "month_key", array("date_month"));
      $this->_checkKeys("ref_events", "month_start_key", array("date_month"));
      $this->_checkKeys("ref_events", "month_end_key", array("date_month"));
      $this->_checkKeys("ref_events", "institution_key", array("affiliations"));
      $this->_checkKeys("ref_events", "publisher_key", array("ref_publishers"));
      $this->_checkKeys("ref_events", "publishedin_key", array("ref_references"));
      $this->_checkKeys("ref_events", "url_month_key", array("date_month"));
      $this->_checkKeys("ref_events", "part_of_key", array("ref_conferences", "ref_events"));
    echo "finished consistency check --> ref_events\n<br />";

    echo "starting consistency check --> ref_conferences\n<br />";
      $this->_checkKeys("ref_conferences", "acronym_key", array("acronyms"));
      $this->_checkKeys("ref_conferences", "city_key", array("geo_cities"));
      $this->_checkKeys("ref_conferences", "institution_key", array("affiliations"));
      $this->_checkKeys("ref_conferences", "month_key", array("date_month"));
      $this->_checkKeys("ref_conferences", "month_start_key", array("date_month"));
      $this->_checkKeys("ref_conferences", "month_end_key", array("date_month"));
      $this->_checkKeys("ref_conferences", "url_month_key", array("date_month"));
      $this->_checkKeys("ref_conferences", "publisher_key", array("ref_publishers"));
      $this->_checkKeys("ref_conferences", "publishedin_key", array("ref_references"));
      $this->_checkKeys("ref_conferences", "part_of_key", array("ref_conferences", "ref_events"));
      $this->_checkKeys("ref_conferences", "organization_keys", array("affiliations"), true);
      $this->_checkKeys("ref_conferences", "sponsor_keys", array("affiliations"), true);
    echo "finished consistency check --> ref_conferences\n<br />";

    echo "starting consistency check --> people\n<br />";
      $this->_checkKeys("people", "aff1", array("affiliations"));
      $this->_checkKeys("people", "aff2", array("affiliations"));
      $this->_checkKeys("people", "aff3", array("affiliations"));
      $this->_checkKeys("people", "aff4", array("affiliations"));
      $this->_checkKeys("people", "aff5", array("affiliations"));
      $this->_checkKeys("people", "aff6", array("affiliations"));
    echo "finished consistency check --> people\n<br />";

    echo "starting consistency check --> geo_countries\n<br />";
      $this->_checkKeys("geo_countries", "continent_key", array("geo_continents"));
    echo "finished consistency check --> geo_countries\n<br />";

    echo "starting consistency check --> geo_cities\n<br />";
      $this->_checkKeys("geo_cities", "country_key", array("geo_countries"));
    echo "finished consistency check --> geo_cities\n<br />";

    echo "starting consistency check --> affiliations\n<br />";
      $this->_checkKeys("affiliations", "acronym_key", array("acronyms"));
      $this->_checkKeys("affiliations", "country_key", array("geo_countries"));
      $this->_checkKeys("affiliations", "city_key", array("geo_cities"));
      $this->_checkKeys("affiliations", "type_key", array("affiliation_type"));
    echo "finished consistency check --> affiliations\n<br />";

/*
    echo "starting consistency check --> art_paintings\n<br />";
      $this->_checkKeys("art_paintings", "museum_key", array("affiliations"));
      $this->_checkKeys("art_paintings", "artist_key", array("people"));
      $this->_checkKeys("art_paintings", "material_key", array("art_material"));
      $this->_checkKeys("art_paintings", "item_keys", array("art_items"), true);
      $this->_checkKeys("art_paintings", "item_special_keys", array("art_items"), true);
    echo "finished consistency check --> art_paintings\n<br />";
*/
  }

  private function _checkKeys($table1, $field, $table2, $explodeFields=false, $testEmtpy=false){
    echo "--> testing keys--> {$table1}[{$field}]\n<br />";
    $sth=$this->skb_main->queryPDO(array('key',$field), array($table1), "{$field} <> ''");

    $res=$sth->fetchAll(PDO::FETCH_ASSOC);
    if(count($res)>0){
      foreach ($res as $row){
        $valid=false;
        foreach($table2 as $tab){
          if($explodeFields==false&&$this->skb_main->hasKey($row[$field], $tab))
            $valid=true;
          elseif($explodeFields==true){
            $exp=SKB_Interpreter::interpret("core:fields:explode", $row[$field]);
            $_size=count($exp);
            for($i=0;$i<$_size;$i++)
              if($this->skb_main->hasKey($exp[$i], $tab))
                $valid=true;
          }
        }
        if($valid==false)
          trigger_error("==> invalid reference to {$tab} from {$table1}[{$field}][{$row['key']}]", E_USER_WARNING);
      }
    }
    else
      echo "----> no row matched result --> {$table1}\n<br />";

    if($testEmtpy==true){
      $sth=$this->skb_main->queryPDO(array('key',$field), array($table1), "{$field} isnull OR {$field}='' OR {$field}=null");
      $res=$sth->fetchAll(PDO::FETCH_ASSOC);
      if(count($res)>0){
        foreach ($res as $row)
          trigger_error("==> found empty row in {$table1}[{$field}] for {$row['key']}", E_USER_WARNING);
      }
    }
  }


  private function _checkPeopleInRef($field){
    $res=$this->_getPeopleAr($field);
    if(count($res)>0){
      $_size=count($res);
      for($i=0;$i<$_size;$i++){
        $ar=SKB_Interpreter::interpret("core:fields:explode", $res[$i][$field]);
        reset($ar);
        while (list($key, $val) = each($ar)){
          if(!$this->skb_main->hasKey($key, "people"))
            trigger_error("==> invalid reference to {$key} from ref_references[{$res[$i]['key']}][{$field}]", E_USER_WARNING);
          if($val!=""){
            $aff="aff".$val;
            $sth=$this->skb_main->queryPDO(array('key',$aff), array('people'), "key = '{$key}'");
            $ret=$sth->fetchAll(PDO::FETCH_ASSOC);
            if($ret[0][$aff]=="")
              trigger_error("==> link to empty affiliation in ref_references[{$res[$i]['key']}] for field [{$field}][{$key}]", E_USER_WARNING);
          }
        }
      }
    }
  }

  private function _getPeopleAr($field){
    $ret=array();
    $sth=$this->skb_main->queryPDO(array('key',$field), array('ref_references'), "{$field} <> ''");
    $ret=$sth->fetchAll(PDO::FETCH_ASSOC);
    return $ret;
  }
}
?>