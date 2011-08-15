#!/usr/bin/bash

TINOS_HOME=~/dev/projects/skb/skb-git
IVY_HOME=v:/dev/projects/skb/skb-git

base_dir=${TINOS_HOME}/projects/kb/src/main/base
dal_sh=${TINOS_HOME}/bin/dal.sh
target_dir=${IVY_HOME}/projects/kb/target/base

if [ ! -d target ]; then
    echo "no target directory, build SKB first"
    exit
fi

if [ -d ${target_dir} ]; then
    rm -fr ${target_dir}/*
else
    mkdir ${target_dir}
fi

build_sql_from_dal(){
    if [ ! -d ${target_dir}/sql ]; then
        mkdir ${target_dir}/sql
    fi
    if [ ! -d ${target_dir}/json ]; then
        mkdir ${target_dir}/json
    fi

    if [ -d ${base_dir}/${pkg}/dal ]; then
        echo ""
        echo "building SQL for package ${pkg}"

        files=`ls ${base_dir}/${pkg}/dal`
        for fn in $files
        do
            echo "--> ${fn}"
            (cd ${base_dir}/${pkg}/dal;${dal_sh} -s dal -t sql -f ${fn} --tgt-dir ${target_dir}/sql -gc>/dev/null)
        done
    fi

    if [ -d ${base_dir}/${pkg}/json ]; then
        echo ""
        echo "copying JSON files for package ${pkg}"
        cp ${base_dir}/${pkg}/json/* ${target_dir}/json
    fi

}

build_sqlite_from_sql(){
    echo ""
    echo "building SQLite databases from SQL source"

    mkdir ${target_dir}/db-sqlite

    if [ ! -d ${target_dir}/skb ]; then
        mkdir ${target_dir}/skb
    else
        rm -fr ${target_dir}/skb/*
    fi

    php ${target_dir}/../../src/main/php/sbin/build-sqlite-from-source.php5
}

copy_json(){
    echo ""
    echo "copying JSON files for repository"
    php ${target_dir}/../../src/main/php/sbin/copy-json.php5
}

pkg=core
build_sql_from_dal

pkg=dist
build_sql_from_dal

pkg=demo
build_sql_from_dal

pkg="site-configurations"
build_sql_from_dal

build_sqlite_from_sql
copy_json