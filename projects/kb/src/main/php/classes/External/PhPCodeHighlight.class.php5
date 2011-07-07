<?php 
/**
 * A function producing highlighted PHP code
 *
 * @package    Classes.External
 * @link       www.allsyntax.com/code/PHP/63/view-php-source/index.php
 *
 */
class External_PhPCodeHighlight{

  public static function php_code_highlight($fn){
    $font=array();
    $span=array();
    $class=array();

    $config=array();
    $config["bg"]=ini_get('highlight.bg');
    $config["comment"]=ini_get('highlight.comment');
    $config["default"]=ini_get('highlight.default');
    $config["html"]=ini_get('highlight.html');
    $config["keyword"]=ini_get('highlight.keyword');
    $config["string"]=ini_get('highlight.string');
    foreach($config as $type => $color) {
      $font[] =  "<font color=\"{$color}\">";         // php4 uses font tags
      $span[] =  "<span style=\"color: {$color}\">";  // php5 uses span tags with css
      $class[] = "<span class=\"{$type}\">";          // we will be replacing specific color settings with a classname that can have the color controlled by an external css file
    }

    $delimPhp=0;      // should be either 1 or 0:  1 when we opened a php and didn't close it, 0 otherwise
    $delimComment=0;  // should be either 1 or 0:  1 when we opened a comment and didn't close it, 0 otherwise

    $file="";
    if(!file_exists($fn))
      $file=explode("\n",$fn);
    else
      $file=file($fn, FILE_IGNORE_NEW_LINES );

    $ol=Html4_Element::factory("ol", array("inline-br"=>true));
    $ret=Html4_Element::factory("div", array("class"=>"source"),$ol);

    $GLOBALS['__php_functions'] = get_defined_functions();
    $GLOBALS['__php_functions_internal'] = $GLOBALS['__php_functions']['internal'];

    $_size=count($file);
    for($i=0;$i<$_size;$i++){
      $line=$file[$i];

      // if the line starts with one space, save it as a non-breaking space and trim it off
      if(substr($line, 0, 1) == ' ' && substr($line, 1, 1) != ' ') {
        $space = '&nbsp;';
        $line = substr($line, 1);
      }
      else
        $space = '';

      // add a comment start to the beginning of the line if we are in a comment
      if($delimComment)
        $line = "/*{$line}";
      // add a php start to the beginning of the line if we are in php code
      if($delimPhp)
        $line = "<?{$line}";

      // remember to remove the php start and comment start if we added them
      $rmphp = $delimPhp;
      $rmcmt = $delimComment;

      // figure out if we start the next line in php code
      $delimPhp = substr_count($line, '<?') - substr_count($line, '?>');
      // figure out if we start the next line in a comment
      $delimComment = substr_count($line, '/*') - substr_count($line, '*/');
      // end the comment on this line to avoid unended comment errors
      if($delimComment)
        $line .= '*/';

      $line = str_replace(array("\n", "\r", '<br />'), '', highlight_string($line, true));

      $line=preg_replace_callback('@([\w_]+)(\s*</span>\s*<span style="color: '.$config["keyword"].'">\s*\()@',
            create_function('$a',
            'if(in_array($a[1],$GLOBALS[\'__php_functions_internal\'])){
               return \'<a href="http://php.net/\'.$a[1].\'">\'.$a[1].\'</a>\'.$a[2];
            } else {
              return $a[0];
            }')
            ,$line);

      // change font color tags into span class tags (php4)
      $line = str_replace($font, $class, $line);
      // change span color tags into span class tags (php5)
      $line = str_replace($span, $class, $line);
      // change font closing tags into span closing tags (php4)
      $line = str_replace('</font>', '</span>', $line);

      // remove php start if we added it
      if($rmphp) {
        $pos = strpos($line, '&lt;?');
        if($pos !== false)
          $line = substr($line, 0, $pos) . substr($line, $pos + 5);
      }

      // remove comment start if we added it
      if($rmcmt) {
        $pos = strpos($line, '/*');
        if($pos !== false)
          $line = substr($line, 0, $pos) . substr($line, $pos + 2);
      }

      // remove comment end if we added it
      if($delimComment) {
        $pos = strrpos($line, '*/');  //strrpos searches backward for '*' here, but */ should be the last thing on the line anyway
        if($pos !== false)
          $line = substr($line, 0, $pos) . substr($line, $pos + 2);
      }

      // get rid of any empty span tags, 2 levels deep
      $line = preg_replace('/<span class="(bg|comment|default|html|keyword|string)"><\/span>/', '', $line);
      $line = preg_replace('/<span class="(bg|comment|default|html|keyword|string)"><\/span>/', '', $line);

      // put a non-breaking space on any blank lines so that firefox/mozilla/netscape don't overlap the line numbers
      if(strlen($line) < 1)
        $line = '&nbsp;';

      $ol->add_child(Html4_Element::factory("li", "",array($space,$line,"&nbsp;")));
    }

    return $ret;
  }
}

?>