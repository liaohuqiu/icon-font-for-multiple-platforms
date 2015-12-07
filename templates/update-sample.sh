# copy file for web
mkdir -p samples/web
cp -rf dist/web samples/
cp -rf dist/fonts samples/web/

# copy file for ios
mkdir -p samples/ios
cp -rf templates/samples/ios samples/
cp -rf dist/ios/* samples/ios/
cp dist/fonts/*.ttf samples/ios/icon-font-for-ios-example/

# copy file for android
mkdir -p samples/android
cp -rf templates/samples/android samples/
cp -rf dist/android/* samples/android/
mkdir -p samples/android/app/src/main/assets/
cp dist/fonts/*.ttf samples/android/app/src/main/assets/
