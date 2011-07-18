#!/bin/bash

# External Libs
export RUN_DIR=`pwd`

export EXTERN_LIB_DIR=$RUN_DIR/external
#export INTERN_LIB_DIR=$RUN_DIR/internal
export INTERN_LIB_DIR=$RUN_DIR/../projects/build-distro/target/package-expanded/SKB-ALL-1.0.0/dist

export EXTERN_CLASSPATH=
for i in `ls $EXTERN_LIB_DIR/*.jar`
do
	EXTERN_CLASSPATH=$EXTERN_CLASSPATH:$i
done

export INTERN_CLASSPATH=
for i in `ls $INTERN_LIB_DIR/*.jar`
do
	INTERN_CLASSPATH=$INTERN_CLASSPATH:$i
done

export JAVA_CLASSPATH=$INTERN_CLASSPATH:$EXTERN_CLASSPATH
echo "Internal & External Classpath constructed"

alias cola="java -classpath \"$JAVA_CLASSPATH\" org.a3ds.languages.cola.proto.Cola"
alias pola="java -classpath \"$JAVA_CLASSPATH\" org.a3ds.languages.pola.proto.Pola"
alias glue="java -classpath \"$JAVA_CLASSPATH\" org.a3ds.languages.glue.proto.Glue"

alias runcola="cola -s cola -t sql  -f mama.cola --no-warnings --gc --tgt-dir ./gc/"


