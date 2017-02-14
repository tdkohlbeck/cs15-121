#!/bin/sh

/usr/local/bin/when-changed "$1.java" "javac $1.java; echo '---------- start'; java $1; echo '------------ end';"
