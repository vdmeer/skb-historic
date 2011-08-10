#!/bin/bash

# External Libs
#run_dir=`pwd`
run_dir="./"

ext_lib_dir=${run_dir}/external
int_lib_dir=${run_dir}/../projects/build-distro/target/package-expanded/SKB-ALL-1.0.0/dist

ext_clp=
for i in `ls ${ext_lib_dir}/*.jar`
do
  ext_clp="${ext_clp};${i}"
done

int_clp=
for i in `ls ${int_lib_dir}/*.jar`
do
  int_clp="${int_clp};${i}"
done

java_clp="${ext_clp};${int_clp}"
echo "Internal & External Classpath constructed"

cola="java -classpath \"${java_clp}\" org.skb.lang.cola.proto.Cola"
pola="java -classpath \"${java_clp}\" org.skb.lang.pola.proto.Pola"
glue="java -classpath \"${java_clp}\" org.skb.lang.glue.proto.Glue"

echo "${cola} -s cola -t sql -f mama.cola --no-warnings --gc --tgt-dir ./gc/" > cola.sh
chmod 755 cola.sh
