#!/bin/sh

file=$1

# when-change java files only
if [ ${file#*.} == "java" ]
then
	name=$( basename $1 .java )
	printf "$1:\n\n"
	#printf "javac $1\n"
	#printf "java -classpath ${file%/*}/ $name\n"
	javac $1
	java -classpath "${file%/*}/" $name
fi
