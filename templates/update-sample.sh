# copy file for web
mkdir -p samples/web
cp -rf dist/web samples/
cp -rf dist/fonts samples/web/

# copy file for ios
mkdir -p samples/ios
cp -rf templates/samples/ios samples/
cp -rf dist/ios/* samples/ios/
if [ ! -f dist/ios/icon-font-for-ios-example/ViewController.swift ]; then
    echo bad > 1.log
fi
cp dist/fonts/*.ttf samples/ios/icon-font-for-ios-example/
