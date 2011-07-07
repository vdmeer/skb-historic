<?php
$site_id="demo";
$site_path="/www/demo";
require_once "/dev/projects/skb-php/skb/classes/main.inc.php5";

$todo=array(
  "pkg.demo.gallery" => array("db" => "demo/gallery/gallery.db", "tables" => array("gallery_fotos","gallery_fotos_collections")),
  "pkg.demo.menu" => array("db" => "demo/menu/menu.db", "tables" => array("menu")),
);

$_keys=array_keys($todo);
$_size=count($_keys);
for($i=0;$i<$_size;$i++){
echo "php-skb: create gettext dummies for {$_keys[$i]}\n";

	$handle=fopen($_keys[$i].".php5", "wb");

  $db_file=$skb_main->configuration->get_group("path", "database").$todo[$_keys[$i]]['db'];
  $o=new Util_PDOConnect($db_file);
  $pdo=$o->pdo;

  fwrite($handle,"<?php\n");
  fwrite($handle,"class GetTextDummy{\n");
  fwrite($handle,"  function dummy(){\n");

  $ar=$todo[$_keys[$i]]['tables'];
  foreach ($ar as &$tab) {
    $sth=$pdo->prepare("SELECT * from {$tab}");
    $sth->execute();

    while($row=$sth->fetch(PDO::FETCH_ASSOC)){
    	$_keysRow=array_keys($row);
      $_sizeRow=count($_keysRow);
      for($r=0;$r<$_sizeRow;$r++){
        if(strpos($row[$_keysRow[$r]],$_keys[$i]."%%")!==false){
          $domain=strtok($row[$_keysRow[$r]],"%%");
          $text=strtok("%%");
          fwrite($handle,'    _("'.$text.'");'."\n");
        }
      }
    }
  }

  fwrite($handle,"  }\n");
  fwrite($handle,"}\n");
	fclose($handle);
}
?>