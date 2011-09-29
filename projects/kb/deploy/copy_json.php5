<?php

	$source_dir="target/base/";
	$target_dir="target/htdocs/";

	$target_dir_skb=$target_dir."skb";
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

	//get all ".json" files from the source dir
	$json_files=array();
	$dir=$source_dir."json";
	if(is_dir($dir)){
		if($dh=opendir($dir)){
			while(($file=readdir($dh))!==false){
				if($file!=".."&&$file!="."&&$file[0]!="#"){
					if(strpos($file, ".json")!==false)
						$json_files[]=$file;
				}
			}
			closedir($dh);
		}
		else{
			echo "cannot read from JSON directory <{$dir}>, please use 'ant build-sqlite' to create\n";
			return;
		}
	}
	else{
		echo "did not find JSON directory <{$dir}>, please use 'ant build-sqlite' to create\n";
		return;
	}

	if(!is_dir($target_dir_skb))
		mkdir($target_dir_skb, 0755, true);
	if(!is_dir($target_dir_skb/repository))
		mkdir($target_dir_skb/repository, 0755, true);

	foreach ($json_files as &$file){
		$file_target=$file;
		$dir_target=$target_dir_repository."/".str_replace(".", "/", str_replace(".json", "", $file_target))."/";

		if(!is_dir($dir_target))
			mkdir($dir_target, 0755, true);
		copy($source_dir."json/".$file, $dir_target.$file_target);
	}

//print_r($json_files);
	echo "done...\n";
?>