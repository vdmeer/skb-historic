<?php

	$source_dir="target/base/sqlite/";
	$target_dir="target/base/i18n/php/";

	//check if source dir is available
	if(!is_dir($source_dir)){
		echo "source directory <{$source_dir}> does not exist, please use 'ant prepare-htdocs' to create\n";
		return;
	}

	//check if target dir exists
	if(!is_dir($target_dir)){
		echo "target directory <{$target_dir}> does not exist, please use 'ant prepare-htdocs' to create\n";
		return;
	}

	//get all ".db" files with data from the source dir
	$db_files=array();
	if($dh=opendir($source_dir)){
		while(($file=readdir($dh))!==false){
			if($file!=".."&&$file!="."&&$file[0]!="#"){
				if(strpos($file, ".db")!==false){
					if(strpos($file, "config-")===false&&strpos($file, "-repo")==false)
						$db_files[]=$file;
				}
			}
		}
		closedir($dh);
	}

	//process each ".db" file to create a PHP file with pseudo gettext calls
	$db_file;
	$_keys=array_keys($db_files);
	$_size=count($_keys);
	for($i=0;$i<$_size;$i++){
		//create file names
		$db_file=$db_files[$_keys[$i]];
		$pkg=str_replace(".db","",$db_file);
		$php_file=$target_dir."pkg.".str_replace(".db",".php5",$db_file);
		$db_file=$source_dir.$db_file;

		try{
			//get a new SQLite PDO and retrieve all tables from it
			$tables=array();
			$sqlite_pdo=new PDO("sqlite:{$db_file}");
			$sql_statement="SELECT name FROM sqlite_master WHERE type='table' ORDER BY name;";
			$sth=$sqlite_pdo->prepare($sql_statement);
			if(!is_object($sth)){
				echo "\n ====> SQL statement: {$sql_statement}\n";
			}
			else{
				$sth->execute();
				while($row=$sth->fetch(PDO::FETCH_ASSOC)){
					$tables[]=$row['name'];
				}
			}

			$to_write=array();
			foreach($tables as $table){
				echo "processing package {$pkg} with table {$table}\n";
				$sql_statement="SELECT * FROM {$table};";
				$sth=$sqlite_pdo->prepare($sql_statement);
				if(!is_object($sth)){
					echo "\n ====> SQL statement: {$sql_statement}\n";
				}
				else{
					$sth->execute();
					while($row=$sth->fetch(PDO::FETCH_ASSOC)){
						foreach($row as $entry){
							if(strpos($entry, "pkg.")==0&&strpos($entry, "%%")!==false)
								$to_write[]='		_("'.substr($entry, strpos($entry, "%%")+2, strlen($entry)).'");'."\n";
						}
					}
				}
			}
		} catch(PDOException $e){
			trigger_error("exception creating PDO for SQLite database {$db_file} \n--< {$e}", E_USER_ERROR);
			return;
		} catch(Exception $e){
			trigger_error("catched exception while loading SQLite database {$db_file} \n--< {$e}", E_USER_ERROR);
			return;
		}

		if(count($to_write)>0){
			$fp=fopen($php_file, "w");
			fwrite($fp, "<?php\n");
			fwrite($fp, "class GetTextDummy{\n");
			fwrite($fp, "	function dummy(){\n");
			foreach($to_write as $ln){
				fwrite($fp, $ln);
			}
			fwrite($fp, "	}\n");
			fwrite($fp, "}\n");
			fwrite($fp, "?>\n");
			fclose($fp);
		}
	}
	echo "done...\n\n";
?>
