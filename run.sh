#!/bin/bash

libDir="Marketplace/libs"
package="DevTools.jar"
sourcePath="$(find "src" -type f -name "*.java")"
sourcePath="${sourcePath//[$'\t\r\n']/' '}"

rm -rf bin ; mkdir bin
rm -rf result
# rm DevTools.jar

# echo $sourcePath
javac $sourcePath -d bin

if [ $? -eq 0 ]; then
	classPath="$(find "bin" -type f -name "*.class")"
	classPath="${classPath//[$'\t\r\n']/' '}"
	classPath="${classPath//'bin/'/' '}"
	echo "class Path: $classPath"

	cd ./bin
		jar cfmv ../$package ../META-INF/MANIFEST.MF $classPath
	cd ..

	if [ $? -eq 0 ]; then
		echo ""; jar tf $package
		# echo ""; java -jar $package

		rm -rf ../$libDir/ ; mkdir ../$libDir/
		mv $package ../$libDir/$package
		cd ../Marketplace
		echo "$(pwd)"
		echo ""; bash ./run.sh
		cd ../Marketplace-DevTools
	fi;

fi;
