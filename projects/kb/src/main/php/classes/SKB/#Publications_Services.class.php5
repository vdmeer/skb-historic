<?php

class Publications_Services{
  public $version="vdm-1.0";
  public $versionBC=array();

  private $_lang;

  public function __construct($lang="en"){
    $this->_lang=$lang;
  }

  public function getChairArray($key){(isset($this->_publServices[$key]["chair"])&&(count($this->_publServices[$key]["chair"])>0))?$ret=$this->_publServices[$key]["chair"]:$ret=-1;return $ret;}

  public function keys(){return array_keys($this->_publServices);}

  private function _getField($index, $field){(isset($this->_publServices[$index][$field])&&($this->_publServices[$index][$field]!=""))?$ret=$this->_publServices[$index][$field]:$ret=-1;return $ret;}
  public function getField($index, $field) {return $this->_getField($index, $field);}
  public function getFieldYear($index)  {return $this->_getField($index, "year");}
  public function getFieldOrg($index)  {return $this->_getField($index, "organization");}
  public function getFieldConference($index)  {return $this->_getField($index, "conference");}
  public function getFieldMember($index)  {return $this->_getField($index, "member");}
  public function getFieldTPCMember($index)  {return $this->_getField($index, "tpcmember");}
  public function getFieldLink($index) {return $this->_getField($index, "link");}

  // צהü ײִÜ ß
  /*
    ""     => array("year" => "",
                    "member" => true,
                    "chair"  => array("", ""),
                    "tpcmember" => true,
                    "paper-rev" => true,
                    "conference" => $_publConferences[""], "organization" => ""),
  */
  private $_publServices = array(
    //""     => array("year" => "", "priority" => "1", "role" => array("", ""), "conference" => $_publConferences[""], "organization" => ""),
    "mem-acf"   => array("year" => "", "member" => true, "organization" => "ACF Architecture Expert's Group", "link" => "http://autonomic-communication-forum.org/?q=node/18"),
    "mem-ieee"  => array("year" => "", "member" => true, "organization" => "IEEE ComSoc", "link" => "http://www.comsoc.org"),
    "mem-scc41" => array("year" => "", "member" => true, "organization" => "IEEE SCC41, WG 1900.5", "link" => "http://www.scc41.org/"),
    "mem-ifip"  => array("year" => "", "member" => true, "organization" => "IFIP TC6 WG 6.7", "link" => "http://www.ifip.tu-graz.ac.at/TC6/handbook.htm#AS67"),
    "mem-tmf"   => array("year" => "", "member" => true, "organization" => "TM Forum NGOSS &amp; SID", "link" => "http://www.tmforum.org"),
    "mem-tua"   => array("year" => "", "member" => true, "organization" => "TU Alumni", "link" => "https://www.alumni.tu-berlin.de/"),
    "mem-fokus" => array("year" => "", "member" => true, "organization" => "FOKUS friends", "link" => "http://www.fokus.fraunhofer.de/fokus/fokus/fokusfriends/fokusfriends.php?lang=en&amp;seite=1"),

//manfi2010
//mucs2010
//cnms2010

adamus2010


//    "icac09"    => array("year" => "2009", "tpcmember"   => true,                                                         "conference" => "icac09"),
//    "im09"      => array("year" => "2009", "tpcmember"   => true,                                                         "conference" => "im09"),
//    "adamus09"  => array("year" => "2009", "tpcmember"   => true,                                                         "conference" => "adamus09"),
//    "mddas08"   => array("year" => "2008", "tpcmember"   => true, "chair" => array("tpc-co-chair"),                       "conference" => "mddas08"),
//    "wcci08"    => array("year" => "2008", "tpcmember"   => true,                                                         "conference" => "wcci08"),
//    "manweek08" => array("year" => "2008",                        "chair" => array("web-chair", "regist-chair"),          "conference" => "manweek08"),
//    "mace08"    => array("year" => "2008", "tpcmember"   => true, "chair" => array("tpc-co-chair"),                       "conference" => "mace08"),
//    "evgm08"    => array("year" => "2008", "tpcmember"   => true,                                                         "conference" => "evgm08"),
//    "dsom08"    => array("year" => "2008", "tpcmember"   => true,                                                         "conference" => "dsom08"),
//    "mmns08"    => array("year" => "2008", "tpcmember"   => true,                                                         "conference" => "mmns08"),
//    "icas08"    => array("year" => "2008", "tpcmember"   => true,                                                         "conference" => "icas08"),
//    "adamus08"  => array("year" => "2008", "tpcmember"   => true,                                                         "conference" => "adamus08"),
//    "bcn08"     => array("year" => "2008", "tpcmember"   => true,                                                         "conference" => "bcn08"),
//    "mucs08"    => array("year" => "2008", "tpcmember"   => true, "chair" => array("steering-com"),                       "conference" => "mucs08"),
//    "noms08"    => array("year" => "2008", "tpcmember"   => true,                                                         "conference" => "noms08"),
//    "manweek07" => array("year" => "2007",                        "chair" => array("web-chair", "regist-chair"),          "conference" => "manweek07"),
//    "evgm07"    => array("year" => "2007", "tpcmember"   => true,                                                         "conference" => "evgm07"),
//    "dsom07"    => array("year" => "2007", "tpcmember"   => true,                                                         "conference" => "dsom07"),
//    "mmns07"    => array("year" => "2007", "tpcmember"   => true,                                                         "conference" => "mmns07"),
//    "mace07"    => array("year" => "2007", "tpcmember"   => true, "chair" => array("steering-com"),                       "conference" => "mace07"),
//    "laacs07"   => array("year" => "2007", "tpcmember"   => true,                                                         "conference" => "laacs07"),
//    "cods07"    => array("year" => "2007", "tpcmember"   => true,                                                         "conference" => "cods07", "organization" => ""),
//    "icas07"    => array("year" => "2007", "tpcmember"   => true, "chair"  => array("tpc-co-chair"),                      "conference" => "icas07"),
//    "giis07"    => array("year" => "2007", "tpcmember"   => true, "chair" => array("panel-chair"),                        "conference" => "giis07"),
//    "adamus07"  => array("year" => "2007", "tpcmember"   => true,                                                         "conference" => "adamus07"),
//    "mucs07"    => array("year" => "2007", "tpcmember"   => true, "chair" => array("steering-com"),                       "conference" => "mucs07"),
//    "bcn07"     => array("year" => "2007", "tpcmember"   => true,                                                         "conference" => "bcn07"),
//    "manweek06" => array("year" => "2006",                        "chair" => array("org-co-chair"),                       "conference" => "manweek06"),
//    "dsom06"    => array("year" => "2006", "tpcmember"   => true, "chair" => array("tpc-co-chair"),                       "conference" => "dsom06"),
//    "mmns06"    => array("year" => "2006", "tpcmember"   => true,                                                         "conference" => "mmns06"),
//    "ipom06"    => array("year" => "2006", "paper-rev"   => true,                                                         "conference" => "ipom06"),
//    "mace06"    => array("year" => "2006", "tpcmember"   => true,                                                         "conference" => "mace06"),
//    "itt06"     => array("year" => "2006", "tpcmember"   => true,                                                         "conference" => "itt06"),
//    "laacs06"   => array("year" => "2006", "tpcmember"   => true,                                                         "conference" => "laacs06"),
//    "mucs06"    => array("year" => "2006", "tpcmember"   => true, "chair" => array("steering-com"),                       "conference" => "mucs06"),
//    "bcn06"     => array("year" => "2006", "tpcmember"   => true,                                                         "conference" => "bcn06"),
//    "itt05"     => array("year" => "2005", "tpcmember"   => true,                                                         "conference" => "itt05"),
//    "mucs04"    => array("year" => "2004", "tpcmember"   => true, "chair" => array("steering-com"),                       "conference" => "mucs04"),
//    "mucs03"    => array("year" => "2003", "tpcmember"   => true, "chair" => array("chair", "steering-com"),              "conference" => "mucs03"),
  
//    "lcn05"     => array("year" => "2005", "paper-rev" => true, "conference" => "lcn05"),
//    "wmcs05"    => array("year" => "2005", "paper-rev" => true, "conference" => "wmcs05"),
//    "im05"      => array("year" => "2005", "paper-rev" => true, "conference" => "im05"),
//    "lcn04"     => array("year" => "2004", "paper-rev" => true, "conference" => "lcn04"),
//    "icsoc04"   => array("year" => "2004", "paper-rev" => true, "conference" => "icsoc04"),
//    "proms00"   => array("year" => "2000", "paper-rev" => true, "conference" => "proms00"),
//    "ma00"      => array("year" => "2000", "paper-rev" => true, "conference" => "ma00"),
//    "asa00"     => array("year" => "2000", "paper-rev" => true, "conference" => "asa00"),
//    "idms98"    => array("year" => "1998", "paper-rev" => true, "conference" => "idms98"),
  );


  public function getRoleName($key){(isset($this->_publServiceRoles[$key]["name"][$this->_lang])&&($this->_publServiceRoles[$key]["name"][$this->_lang]!=""))?$ret=$this->_publServiceRoles[$key]["name"][$this->_lang]:$ret=-1;return $ret;}

  // צהü ײִÜ ß
  private $_publServiceRoles = array(
    "member"    => array("name" => array("dt" => "Mitglied", "en" => "member")),
    "tpcmember" => array("name" => array("dt" => "Technisches Programm Kommittee", "en" => "Technical Programme Committee")),
    "paper-rev" => array("name" => array("dt" => "Paper Review", "en" => "Paper Review")),
  
    "tpc-co-chair" => array("name" => array("dt" => "TPC Co-Chair", "en" => "TPC Co-Chair")),
    "steering-com" => array("name" => array("dt" => "Steering Kommittee", "en" => "Steering Committee")),
    "panel-chair"  => array("name" => array("dt" => "Panel Chair", "en" => "Panel Chair")),
    "regist-chair" => array("name" => array("dt" => "Registration Chair", "en" => "Registration Chair")),
    "web-chair"    => array("name" => array("dt" => "Web Chair", "en" => "Web Chair")),
    "org-co-chair" => array("name" => array("dt" => "Organisations Co-Chair", "en" => "Organisation Co-Chair")),
    "chair"        => array("name" => array("dt" => "Chair", "en" => "Chair")),

    "of"           => array("name" => array("dt" => "", "en" => "of")),
    "for"          => array("name" => array("dt" => "für", "en" => "for"))
  );
}
?>