#In a folder with apk file

#build jar to replace dependencies and run it
git clone https://github.com/kschernopiatova/update-packages.git
cd update-packages; mvn clean compile assembly:single; cd ..

apktool d open.apk
git clone https://github.com/kschernopiatova/mock-camera.git
cp update-packages/target/test-jar-with-dependencies.jar open/smali/net
cd open/smali/net; java -jar test-jar-with-dependencies.jar; cd ../../..

#copy mock module smali files and commons-io package
cp -r mock-camera/app/src/main/java/com/solvd/mockcamera/solvd open/smali/com
cp -r mock-camera/app/src/main/java/com/solvd/mockcamera/apache open/smali/org

#build edited apk and sign it
apktool b open
cd open/dist
source ~/.bash_profile
zipalign -f -v 4 open.apk camera-aligned.apk
apksigner sign --ks ~/my-release-key.keystore camera-aligned.apk

#then install this apk on device
#adb install camera-aligned.apk

#change to parent dir and clean it
cd ../..
cp open/dist/camera-aligned.apk .

rm -rf update-packages
rm -rf mock-camera
rm -rf open