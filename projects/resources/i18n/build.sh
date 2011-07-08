#!/usr/bin/bash

##skb_directory=~/doc/skb
##lc_directory=${skb_directory}/share/locale
##src_directory=~/dev/projects/skb-php

#php_target_directory=${skb_directory}/targets/tgtphp
php_target_directory=../../kb/src/main/php/targets/tgtphp
htdoc_directory=../../htdocs

autogen_directory=src/autogen
pot_directory=src/pot
po_directory=src/po

locale_directory=target

if [ -d ${locale_directory} ]; then
    rm -fr ${locale_directory}
fi


help()
{
  echo
  usage
  cat << eof

-locale     build locale
-h          this message

eof
}

usage()
{
  echo usage: $0 [-locale] [-h]
}


do_gettext(){
    echo > files.txt
    if [ -d ${dir} ]; then
        find ${dir} ${maxdepth} -type f -print |grep .php5 > files.txt
        find ${dir} ${maxdepth} -type f -print |grep .tpl >> files.txt
    fi
    if [ -f ${autogen_directory}/${domain}.php5 ]; then
        ls ${autogen_directory}/${domain}.php5 >> files.txt
    fi

    xgettext -d $domain -s -o ${pot_directory}/$pot --files-from=files.txt -L php

    if [ ! -d ${locale_directory} ]; then
        mkdir ${locale_directory}
    fi
    if [ ! -d ${locale_directory}/mo ]; then
        mkdir ${locale_directory}/mo
    fi
    if [ ! -d ${locale_directory}/properties ]; then
        mkdir ${locale_directory}/properties
    fi

    languages=`(cd ${po_directory};find -type d -print | sed "s/^\.\///" | sed "s/^\.//")`
    for lang in $languages
    do
        if [ ! -z "$lang" ]; then
            echo -n "$lang -- " 

            #first to the MO part
            if [ ! -d ${locale_directory}/mo/${lang} ]; then
                mkdir ${locale_directory}/mo/${lang}
            fi
            if [ ! -d ${locale_directory}/mo/${lang}/LC_MESSAGES/ ]; then
                mkdir ${locale_directory}/mo/${lang}/LC_MESSAGES/
            fi

            msgmerge -s -U ${po_directory}/${lang}/${domain}.po ${pot_directory}/${pot}
            msgfmt -c -v -o ${locale_directory}/mo/${lang}/LC_MESSAGES/${domain}.mo ${po_directory}/${lang}/${domain}.po

##            if [ ! -d ${lc_directory}/mo/${lang} ]; then
##                mkdir ${lc_directory}/mo/${lang}
##            fi
##            if [ ! -d ${lc_directory}/mo/${lang}/LC_MESSAGES/ ]; then
##                mkdir ${lc_directory}/mo/${lang}/LC_MESSAGES/
##            fi
##            cp -r -u  ${locale_directory}/mo/${lang}/LC_MESSAGES/${domain}.mo ${lc_directory}/mo/${lang}/LC_MESSAGES/

            #second the properties
            prop_file=`echo ${domain} | sed "s/\./\//" | sed "s/\./\//" | sed "s/\./\//"`_${lang}.properties
            prop_dir=`echo ${domain} | sed "s/.[^.]*$//" | sed "s/\./\//" | sed "s/\./\//" | sed "s/\./\//"`
            #echo ${prop_file} : ${prop_dir}
            mkdir -p ${locale_directory}/properties/${prop_dir}
            msgmerge -s -p ${po_directory}/${lang}/${domain}.po ${pot_directory}/${pot} -o ${locale_directory}/properties/${prop_file}
        fi
    done
    echo
}


build_locale()
{
#    (cd ${autogen_directory};php create-dist.php5)
#    (cd ${autogen_directory};php create-demo.php5)
#    (cd ${autogen_directory};php create-vdm.php5)

    pot_pkg_files=`(cd ${pot_directory};ls pkg.*.pot)`
    pot_site_files=`(cd ${pot_directory};ls site.*.pot)`

    echo PACKAGES
    echo
    for pot in $pot_pkg_files
    do
        domain=`echo $pot | sed "s/.pot//"`
        maxdepth=' -maxdepth 1 '
        dir=${php_target_directory}/`echo $pot | sed "s/.pot//" | sed "s/pkg.//" | sed "s/\./\//" | sed "s/\./\//" | sed "s/\./\//"`
        echo `echo $pot | sed "s/.pot//" | sed "s/pkg.//"`
        do_gettext
    done

    echo
    echo SITES
    echo
    for pot in $pot_site_files
    do
        domain=`echo $pot | sed "s/.pot//"`
        maxdepth=
        s_dir=`echo $pot | sed "s/.pot//" | sed "s/site.//"`
        dir=${htdoc_directory}/${s_dir}
        echo ${s_dir}
        do_gettext
    done

    if [ -f files.txt ]; then
        rm files.txt
    fi
}

build_all(){
  build_locale
}

while :
do
    case "$1" in
        -locale)     build_locale ; exit 0 ;;
        -h)          help ; exit 0 ;;
        *)           break ;;
    esac
    shift
done

help
