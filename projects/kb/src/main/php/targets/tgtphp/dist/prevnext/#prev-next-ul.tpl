
<ul>
<?php
  if($prev==null&&$next==null){
?>
  <li class="descr"><?php echo $alt; ?></li>
<?php
  }
  else{
  	$mySKB=SKB_Util_Main::get_instance();

  	if($prev==null)
  	  echo ' <li class="text">prev</li> ';
  	else{
      $req=$mySKB->get_request($request->get_key());
      $req->init_plain();
      $req->set_value("request:collection", $coll);
      $req->set_value("request:part", $part);
      $req->set_value("request:entry", $prev);
      $req->activate();
      $href=$req->buildUrl($_SERVER["PHP_SELF"]);
  		echo ' <li class="link"><a href="' . $href . '">prev</a></li> ';
  	}

    if($alt==null)
      echo ' <li>&#124;</li> ';
    else
      echo ' <li class="descr"> &lsaquo;&lsaquo; ' . $alt . ' &rsaquo;&rsaquo; </li> ';

  	if($next==null)
  	  echo ' <li class="text">next</li> ';
  	else{
      $req=$mySKB->get_request($request->get_key());
      $req->init_plain();
      $req->set_value("request:collection", $coll);
      $req->set_value("request:part", $part);
      $req->set_value("request:entry", $next);
      $req->activate();
      $href=$req->buildUrl($_SERVER["PHP_SELF"]);
  		echo ' <li class="link"><a href="' . $href . '">next</a></li> ';
  	}
  }
?>
</ul>
<br />
