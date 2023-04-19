#!/bin/bash

rm -rf bin
rm -rf result
rm src/*/*.class
rm DevTools.jar

javac ./src/*/*.java -d bin

if [ $? -eq 0 ]; then
	cd bin
	jar cfmv ../DevTools.jar ../META-INF/MANIFEST.MF inject/Mockup.class
	cd ..
fi;

if [ $? -eq 0 ]; then
	echo ""; jar tf DevTools.jar
	# echo ""; java -jar DevTools.jar test

	rm -rf ../Marketplace/lib/ ; mkdir ../Marketplace/lib/
	mv DevTools.jar ../Marketplace/lib/DevTools.jar
	echo ""; bash ../Marketplace/run.sh ../Marketplace
fi;

