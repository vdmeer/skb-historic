<?php

	$source_dir="target/base/";
	$target_dir="target/htdocs/";

	$target_dir_database=$target_dir."database";
	$target_dir_skb=$target_dir."skb";
	$target_dir_config=$target_dir."skb/config";
	$target_dir_repository=$target_dir."skb/repository";

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

	//get all ".sql" files from the source dir
	$db_files=array();
	$dir=$source_dir."sqlite";
	if(is_dir($dir)){
		if($dh=opendir($dir)){
			while(($file=readdir($dh))!==false){
				if($file!=".."&&$file!="."&&$file[0]!="#"){
					if(strpos($file, ".db")!==false)
						$db_files[]=$file;
				}
			}
			closedir($dh);
		}
		else{
			echo "cannot read from SQLite directory <{$dir}>, please use 'ant build-sqlite' to create\n";
			return;
		}
	}
	else{
		echo "did not find SQLite directory <{$dir}>, please use 'ant build-sqlite' to create\n";
		return;
	}

	if(!is_dir($target_dir_database))
		mkdir($target_dir_database, 0755, true);
	if(!is_dir($target_dir_skb))
		mkdir($target_dir_skb, 0755, true);
	if(!is_dir($target_dir_skb/repository))
		mkdir($target_dir_skb/repository, 0755, true);
	if(!is_dir($target_dir_skb/config))
		mkdir($target_dir_skb/config, 0755, true);

	foreach ($db_files as &$file){
		if(strpos($file,"-repo.db")!==false){
			$file_target=str_replace("-repo.db", ".db", $file);
			$dir_target=$target_dir_repository."/".str_replace(".", "/", str_replace(".db", "", $file_target))."/";
		}
		elseif(strpos($file,"config-")!==false){
			$file_target=str_replace("config-", "", $file);
			$dir_target=$target_dir_config."/";
		}
		else{
			$dir_target=$target_dir_database."/".str_replace(".", "/", str_replace(".db", "", $file))."/";
			$file_target=str_replace(".db", "", $file);
			$file_target=substr($file_target, strrpos($file_target,".")+1, strlen($file_target));
			$file_target=$file_target.".db";
		}

		if(!is_dir($dir_target))
			mkdir($dir_target, 0755, true);
		copy($source_dir."sqlite/".$file, $dir_target.$file_target);
	}

//print_r($db_files);
	echo "done...\n";
?>