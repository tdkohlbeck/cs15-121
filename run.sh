#!/bin/sh

when-change "$1.java" "javac $1.java; echo \"----------------\"; java $1;)
