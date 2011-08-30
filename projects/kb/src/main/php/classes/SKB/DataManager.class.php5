<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2009-2011, Sven van der Meer <sven@vandermeer.de>
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
 * The SKB Data Manager, handling access to all registered data
 *
 * @package    Classes.SKB
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2009-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class SKB_DataManager{
    /**
     * Pointer to the singleton instance of the SKB
     * @var object
     */
     private static $instance=null;


	/**
	 * Registered data objects
	 * @var array
	 */
	private $registered_dos;


	/**
	 * String internally being used  for initial construction.
	 * @var string
	 */
	private static $cKey="beef";


	/**
	 * Object implementing a stack for detecing loops while interpreting data
	 * @var SKB_DBScope
	 */
	private $interpret_scope;


	/**
	 * Return the instance of SKB_DataManager (Singleton).
	 */
	public static function get_instance(){
		if(self::$instance===null)
			self::$instance=new SKB_DataManager(self::$cKey);
		return self::$instance;
	}


	/**
	 * Cloning is not allowed, since SKB_DataManager is a Singleton.
	 */
	public function __clone(){
		trigger_error('SKB_DataManager: Clone is not allowed.', E_USER_ERROR);
	}


	/**
	 * The class constructor, which cannot be called directly since SKB_Main is a singleton.
	 */
	private function __construct($_c){
		if($_c!=self::$cKey)
			trigger_error('SKB_Main: Direct creation of object is not allowed, please use get_instance().', E_USER_ERROR);
		else{
			$this->registered_dos=array();
			$this->interpret_scope=SKB_DBScope::get_instance();
		}
	}


	/**
	 * Return current set of data objects.
	 *
	 */
	public function get_data_objects(){
		return $this->registered_dos;
	}
                     
                     
	/**
	 * Load and register a new data object (i.e. database tables, data file)
	 * 
	 * This method loads a data object (i.e. SQLite database with tables) and registeres it in the local
	 * DO registry.
	 *
	 * @param string sema_tag the semantic tag to be used to access the data object
	 * @param string type the type of the data object, i.e. sqlite
	 * @param string handle a handle to access the data object, i.e. a file name for sqlite
	 * @param string tables tables the data object maintains (currently for databases only), will be exploded
	 * @param string filter_id a specific filter attached to the data object, can be used in queuering methods
	 * @param string package the package that registeres the data object
	 */
	public function load_data_object($sema_tag, $type, $handle, $tables, $filter_id, $package){
		$do_reg=true;
		$dos=array();

		switch($type){
			case "sqlite":
					if(!is_array($tables))
						$tables=Util_Interpreter::interpret("array:explode", $tables);

					$sqlite_file=null;
					if(strpos($handle,"config://")!==false){
						$sqlite_file=str_replace("config://", "", $handle);
					}
					else if(strpos($handle,"repo://")!==false){
						$sqlite_file=SKB_Main::get_instance()->configuration->get_group("path", "repository").str_replace("repo://", "", $handle).".db";
					}
					else if(strpos($handle,"data://")!==false){
						$sqlite_file=SKB_Main::get_instance()->configuration->get_group("path", "database").str_replace("data://", "", $handle).".db";
					}

					if(!file_exists($sqlite_file)){
						trigger_error("SKB_DataManager: SQLite database {$sqlite_file} not found for sema tag {$sema_tag} in package {$package}", E_USER_WARNING);
						$do_reg=false;
					}
					else{
						try{
							$sqlite_pdo=new PDO("sqlite:{$sqlite_file}");
							if($sqlite_pdo==null){
								trigger_error("SKB_DataManager: could not create PDO for SQLite database {$sqlite_file} not found for sema tag {$sema_tag} in package {$package}", E_USER_ERROR);
								$do_reg=false;
							}
							else{
								//check if tables exist
								$_keys=array_keys($tables);
								$_size=count($_keys);
								for($i=0;$i<$_size;$i++){
									$sth=$sqlite_pdo->prepare("SELECT * FROM " . $tables[$_keys[$i]]);
									if(!is_object($sth)){
										trigger_error("SKB_DataManager: table {$tables[$_keys[$i]]} does not exist in SQLite database {$sqlite_file} for sema tag {$sema_tag} in package {$package}", E_USER_ERROR);
										$do_reg=false;
									}
									if(!$sth->execute()){
										trigger_error("SKB_DataManager: problems reading from table {$tables[$_keys[$i]]} in SQLite database {$sqlite_file} for sema tag {$sema_tag} in package {$package}", E_USER_ERROR);
										$do_reg=false;
									}
									else{
										$dos['sqlite_pdo']=$sqlite_pdo;
									}
								}
							}
						} catch(PDOException $e){
							trigger_error("SKB_DataManager: exception creating PDO for SQLite database {$sqlite_file} not found for sema tag {$sema_tag} in package {$package}", E_USER_ERROR);
							$do_reg=false;
						} catch(Exception $e){
							trigger_error("SKB_DataManager: catched exception while loading SQLite database {$sqlite_file} for sema tag {$sema_tag} in package {$package} \n--< {$e}", E_USER_ERROR);
						}
					}
				break;
			default:
				trigger_error("SKB_DataManager: unknown type {$type} for sema tag {$sema_tag} in package {$package}", E_USER_ERROR);
				$do_reg=false;
				break;
		}

		if($do_reg==true){
			$dos['type']=$type;
			$dos['handle']=$handle;
			$dos['tables']=$tables;
			$dos['filter_id']=$filter_id;
			$dos['package']=$package;
			if(!isset($this->registered_dos[$sema_tag]))
				$this->registered_dos[$sema_tag]=array();
			$this->registered_dos[$sema_tag][]=$dos;
		}
	}


	/**
	 * Prepares a query object that query_data_object can process
	 *
	 */
	public function prepare_query($sema_tag, $find=null, $equals=null, $sort=null, $filter_id=null, $package=null, $interpret=false, $clean=false){
		$ret=array();
		$ret['sema_tag']=$sema_tag;
		$ret['find']=$find;
		$ret['equals']=$equals;
		$ret['sort']=$sort;
		$ret['filter_id']=$filter_id;
		$ret['package']=$package;
		$ret['interpret']=$interpret;
		$ret['clean']=$clean;
		return $ret;
	}
                         
                         
	public function test_query($query){
		if(!isset($query['sema_tag']))
			trigger_error("SKB_DataManager: no sema tag set in query request", E_USER_ERROR);
		if(!isset($this->registered_dos[$query['sema_tag']]))
			trigger_error("SKB_DataManager: unknown sema tag {$query['sema_tag']} in query request", E_USER_ERROR);
		if(!isset($query['find']))
			$query['find']="*";
		elseif(is_array($query['find'])&&count($query['find'])==0)
			$query['find']="*";
		elseif(is_string($query['find'])&&($query['find']==null||strlen($query['find'])==0))
			$query['find']="*";
		if(!isset($query['equals'])||!is_array($query['equals']))
			$query['equals']=array();
		if(!isset($query['sort'])||$query['sort']==null)
			$query['sort']="";
		if(!isset($query['filter_id'])||$query['filter_id']==null)
			$query['filter_id']="";
		if(!isset($query['package'])||$query['package']==null)
			$query['package']="";
		if(!isset($query['interpret']))
			$query['interpret']=false;
		if(!isset($query['clean']))
			$query['clean']=false;
		return $query;
	}


	public function query_data_object($query){
		$ret=array();
		$query=$this->test_query($query);
		if(!isset($this->registered_dos[$query['sema_tag']])){
			trigger_error("SKB_DataManager: unknown sema tag {$query['sema_tag']} in query request", E_USER_ERROR);
			return new Util_ArBase($ret);
		}

		$todo=$this->registered_dos[$query['sema_tag']];
		$_keys=array_keys($todo);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			if($query['filter_id']!=""&&isset($todo[$_keys[$i]]['filter_id'])&&strcmp($query['filter_id'], $todo[$_keys[$i]]['filter_id'])!=0)
				continue;
			if($query['package']!=""&&isset($todo[$_keys[$i]]['package'])&&strcmp($query['package'], $todo[$_keys[$i]]['package'])!=0)
				continue;

			switch($todo[$_keys[$i]]['type']){
				case "sqlite":
						if(is_array($query['find'])&&count($query['find'])>0)
							$query['find']=implode(',',$query['find']);
						if(!strlen($query['find'])>0)
							$query['find']="*";
						$sql_statement="SELECT " . $query['find'];

						$tables=$todo[$_keys[$i]]['tables'];
						if(is_array($tables)&&count($tables)>0)
							$tables=implode(',',$tables);
						$sql_statement.=" FROM " . $tables;

						if(count($query['equals'])>0){
							$sql_statement.=" WHERE";
							$k=0;
							foreach($query['equals'] as $key=>$val){
								if($k++>0)
									$sql_statement.=" AND ";
								$sql_statement.=" \"" . $key . "\" = \"" . $val . "\"";
							}
						}
						if($query['sort']!=""){
							$sql_statement.=" ORDER BY \"" . $query['sort'] . "\"";
						}

						$sth=$todo[$_keys[$i]]['sqlite_pdo']->prepare($sql_statement);

						if($sth->execute()){
							while($row=$sth->fetch(PDO::FETCH_ASSOC)){
								if($query['interpret']==false)
									$ret[]=$row;
								else
									$ret[]=$this->interpret_do(new Util_ArBase($row), null, 'acronyms')->ar;
							}
						}
						break;
				default:
						break;
			}
		}
		//check for cleaning
		if($query['clean']==true)
			$ret=Util_Interpreter::interpret("array:clean", $ret);
		//if the array has only one entry named '0', then we only read 1 row, so return that row
		if(count($ret)==1&&isset($ret[0]))
			$ret=$ret[0];
		return new Util_ArBase($ret);
	}


	/**
	 * Interpret data, i.e. resolve all internal links, do i18n translations
	 *
	 * @param Util_ArBase entries the data array to be interpreted
	 * @param string sema_tag sema tag to be used as starting point for interpretation
	 * @param string table table to be used as starting point for interpretation
	 */
	public function interpret_do(Util_ArBase $entries, $sema_tag, $table){
		$this->interpret_scope->reset();
		if(isset($entries->ar['key']))
			$this->interpret_scope->push($table,$entries->ar['key']);
		return $this->interpret_loop($entries);
	}


	/**
	 * Loop for interpreting data
	 * 
	 * @param Util_ArBase entries the data array to be interpreted
	 */
	public function interpret_loop(Util_ArBase $entries){
		$mySKB=SKB_Main::get_instance();
		$registered_fields=$mySKB->get_registered__fields();

		$table=null;
		$test_ar=Util_Interpreter::interpret("array:clean", $entries->ar);
		if(count($test_ar)==0) // empty array, nothing to be done
			return $entries;
		elseif(!is_array($test_ar)) // no array, nothing to be done
			return $entries;
		elseif(count($test_ar)==1){ // array with 1 member, main process initiated
			$key=array_keys($test_ar);
			$key=$key[0];
			$val=array_values($test_ar);
			$val=$val[0];

			// we only process if the key is known and meta data (an entry in the fields table) for it exist
			if(array_key_exists($key, $registered_fields)){
				$testAr=$registered_fields[$key];

				// check for entity or value, if neither of them do not process entry
				if($testAr['core:type']=="entity"){
					// we have an entity, so test for links to other tables or interpreters to be called
					if($table==null&&isset($testAr['core:default_db']))
						$table=$testAr['core:default_db'];
					if($table!=null&&!isset($testAr['core:interpreter'])){
						if($testAr['core:explode']==true){
							$ar=Util_Interpreter::interpret("array:explode", $val);
							$_Lkeys=array_keys($ar);
							$_Lsize=count($_Lkeys);
							for($l=0;$l<$_Lsize;$l++){
								$entries->ar[$testAr['core:entries_name']][]=$this->interpret_loop(new Util_ArBase(array($testAr['core:entries_name']."_key"=>$ar[$_Lkeys[$l]])))->ar[$testAr['core:entries_name']];
							}
							unset($entries->ar[$key]);
						}
						else{
							$entries->ar=array();
							if($this->interpret_scope->push($table,$val)==true){
								$ret=Util_Interpreter::interpret("array:clean", $this->query_data_object($this->prepare_query($table, "*", array("key"=>$val), null, null, null, false))->ar);
								$entries->ar[$testAr['core:entries_name']]=$this->interpret_loop(new Util_ArBase($ret))->ar;
								//echo "+++ ";$this->interpret_scope->print_r();
								$this->interpret_scope->pop();
							}
							else{
								$entries->ar[$testAr['core:entries_name']]=array();
								//echo "### ";$this->interpret_scope->print_r();
							}
						}
					}
					else{
						$entries->ar[$testAr['core:entries_name']]=$this->interpret_data($testAr['core:interpreter'], $val)->ar;
						unset($entries->ar[$key]);
					}
				}
				elseif($testAr['core:type']=="value"){
					// we have a value, which can be localised or exploded (create an array from a list)
					// first the locale, identified by ending on "_locale"
					if(substr_compare($key, "_locale", -strlen("_locale"), strlen("_locale"))===0){
						//old test was on test field localised: if($testAr['core:localised']==true){
						$lang=$mySKB->get_lang();

						//new i18n method, using gettext: domain%%text
						if(strpos($val,"%%")!==false){
							$domain=strtok($val,"%%");
							$text=strtok("%%");
							$entries->ar[$testAr['core:entries_name']]=dgettext($domain, $text);
						}
						//old i18n method: de%Deutsch,en%English
						elseif(strpos($val,"%")!==false){
							$ar=Util_Interpreter::interpret("array:explode", $val);
							$entries->ar=array();
							if(isset($ar[$lang]))
								$entries->ar[$testAr['core:entries_name']]=$ar[$lang];
							elseif(isset($ar[""]))
								$entries->ar[$testAr['core:entries_name']]=$ar[""];
							else
								$entries->ar[$testAr['core:entries_name']]=-1;
						}
						else
							$entries->ar[$testAr['core:entries_name']]=-1;
					}
					elseif($testAr['core:explode']==true){
						$entries->ar=array();
						$entries->ar[$testAr['core:entries_name']]=Util_Interpreter::interpret("array:explode", $val);
					}
				}
			}
		}
		else{ // array with more than one member, loop through the array
			$newAr=array();
			$_keys=array_keys($entries->ar);
			$_size=count($_keys);
			for($i=0;$i<$_size;$i++){
				$reAr=new Util_ArBase(array($_keys[$i]=>$entries->ar[$_keys[$i]]));
				$newAr=array_merge($newAr, $this->interpret_loop($reAr)->ar);
			}
			unset($entries->ar);
			$entries->ar=$newAr;
		}
		return $entries;
	}


	/**
	 * Interpret data using registered interpreters.
	 * 
	 * This function supports all types of registered interpreters (core, entity, value and entries).
	 * Each of them requires a slightly different set of parameters.
	 *
	 * @param string id identifier for the interpreter
	 * @param val value to be interpreted
	 * @param table database table to be used during interpretation
	 * @param SKB_Request request object for parametrisation
	 */
	public function interpret_data($id, $val=null, $table=null, SKB_Request $request=null){
		$mySKB=SKB_Main::get_instance();
		$registered_interpreters=$mySKB->get_registered_interpreters();
		$target=$mySKB->configuration->get_group("skb", "target");

		if(array_key_exists($id, $registered_interpreters)){
			$class=$registered_interpreters[$id]['core:rabit:target:class'][$target];
			switch($registered_interpreters[$id]['core:rabit:type']){
				case "interpreter:core":    $c=new $class; return $c->interpret($val, $request);
				case "interpreter:entity":  $c=new $class; return $c->interpret($val, $table);
				case "interpreter:value":   $c=new $class; return $c->interpret($val);
				case "interpreter:entries": $c=new $class; return $c->interpret($val, $table);
			}
			return;
		}
		trigger_error("SKB_Main: interpreter not found: {$id} for target {$target}", E_USER_ERROR);
	}
}
?>