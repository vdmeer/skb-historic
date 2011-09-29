<?php

	$source_dir="target/base/sql/";
	$target_dir="target/base/sqlite/";
	$empty_db=$target_dir."empty.sqlite3.db";

	//check if source dir is available
	if(!is_dir($source_dir)){
		echo "source directory <{$source_dir}> does not exist, please use 'ant build-sqlite' to create\n";
		return;
	}

	//check if target dir exists
	if(!is_dir($target_dir)){
		echo "target directory <{$target_dir}> does not exist, please use 'ant build-sqlite' to create\n";
		return;
	}

	//check if we have an empty sqlite3 file as template
	if(!is_file($empty_db)){
		echo "empty db file does not exist, please use 'ant build-sqlite' to create\n";
		return;
	}

	//get all ".sql" files from the source dir
	$sql_files=array();
	if($dh=opendir($source_dir)){
		while(($file=readdir($dh))!==false){
			if($file!=".."&&$file!="."&&$file[0]!="#"){
				if(strpos($file, ".sql")!==false)
					$sql_files[]=$file;
			}
		}
		closedir($dh);
	}

	//process each ".sql" file to create an SQLite db file
	$db_file;
	$_keys=array_keys($sql_files);
	$_size=count($_keys);
	for($i=0;$i<$_size;$i++){
		//create file names
		$sql_file=$sql_files[$_keys[$i]];
		$base_fn=str_replace(".sql","",$sql_file);
		$db_file=$base_fn.".db";

		//add directories to file names
		$sql_file=$source_dir.$sql_file;
		$db_file=$target_dir.$db_file;
		echo "processing --> ".$base_fn."\n";

		//read the SQL source file, ignore all CPP directives (lines starting with '#' or with '*/' | '*/')
		$sql_contents=file($sql_file);
		foreach($sql_contents as $ln=>$line){
			if(strlen($line)==0)
				unset($sql_contents[$ln]);
			elseif(strlen($line)>0&&$line[0]=='#')
				unset($sql_contents[$ln]);
			elseif(strlen($line)>0&&$line[0]=='/')
				unset($sql_contents[$ln]);
			elseif(strlen($line)>0&&$line[1]=='*')
				unset($sql_contents[$ln]);
		}

		if(!copy($empty_db, $db_file)) {
			echo "failed to copy {$empty_db} to {$db_file}\n";
			return;
		}
		try{
			//get a new SQLite PDO
			$sqlite_pdo=new PDO("sqlite:{$db_file}");

			//now, take each line from the SQL source and execute it on the PDO
			$_sqlKeys=array_keys($sql_contents);
			$_sqlSize=count($_sqlKeys);
			for($k=0;$k<$_sqlSize;$k++){
				$sql_statement=$sql_contents[$_sqlKeys[$k]];
				$sth=$sqlite_pdo->prepare($sql_statement);
				if(!is_object($sth))
					echo "\n ====> SQL statement error in <{$sql_file}>: {$sql_statement}\n";
				else
					$sth->execute();
			}
		} catch(PDOException $e){
			trigger_error("exception creating PDO for SQLite database {$db_file} \n--< {$e}", E_USER_ERROR);
			return;
		} catch(Exception $e){
			trigger_error("catched exception while loading SQLite database {$db_file} \n--< {$e}", E_USER_ERROR);
			return;
		}
	}
	echo "done...\n\n";
?>