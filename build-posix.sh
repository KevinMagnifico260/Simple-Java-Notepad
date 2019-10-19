
#	Author : Kevin C. Magnifico

clear
set echo off
echo "javac -d bin src/Form.java src/JavaFileExtension.java src/MainProgram.java"
javac -d bin src/Form.java src/JavaFileExtension.java src/MainProgram.java
echo "Build successfully..."
echo "Press enter to exit..."
read -p ""
