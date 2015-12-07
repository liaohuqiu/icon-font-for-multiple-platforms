var gulp = require("gulp");
var rename = require("gulp-rename");
var sketch = require("gulp-sketch");
var iconfont = require('gulp-iconfont');
var consolidate = require('gulp-consolidate');
var child_process = require('child_process');
var del = require('del');
var Promise = require('promise');
var Q = require('q');

var font_name = 'cube-icons'; // the name of the font file
var fontCssClassNamePre = 'cubeicon'; // set class name in your CSS

var android_string_name_pre = fontCssClassNamePre;

var sketch_file_name = 'cube-icons-sample.sketch'; // you can also choose 'symbol-font-16px.sketch'
var font_path_relative_to_css = '../fonts/'; // set path to font (from your CSS file if relative)

var web_sample_dir = 'samples/web/';
var dist_dir = 'dist/';
var samples_dir = 'samples/';

gulp.task('clean', function(cb) {
  del.sync(dist_dir);
  del.sync(samples_dir);
  cb();
});

gulp.task('build', function(){

  var create_font_deferred = Q.defer();
  var build_for_template_deferred = Q.defer();

  gulp.src(sketch_file_name)
  .pipe(sketch({
    export: 'artboards',
    formats: 'svg'
  }))
  .pipe(iconfont({
    fontName: font_name,
    formats: ['ttf', 'eot', 'woff', 'svg']
  }))
  .on('glyphs', function(glyphs, options) {
    var template_data = {
      glyphs: glyphs.map(function(glyph) {
        var codepoint = glyph.unicode[0].charCodeAt(0);
        var unicode = codepoint.toString(16).toUpperCase();
        var unicode_cully_braces_for_swift = '{' + unicode + '}';
        var name_no_dash = glyph.name.replace('-', '_');
        return {
          name: glyph.name,
          name_for_android_string_xml: android_string_name_pre + '_' + name_no_dash,
          name_no_dash: name_no_dash,
          codepoint: codepoint,
          unicode: unicode,
          unicode_cully_braces_for_swift: unicode_cully_braces_for_swift
        }
      }),
      font_name: font_name,
      fontPath: font_path_relative_to_css,
      className: fontCssClassNamePre
    };

    var promise_list = [
      // web sample
      new Promise(function(resolve, reject) {
      gulp.src('templates/web/*.*')
      .pipe(consolidate('swig', template_data, { useContents : true }))
      .pipe(gulp.dest(dist_dir + 'web/'))
      .on('end', resolve);
    }),
    new Promise(function(resolve, reject) {
      // fontawesome-style.css
      gulp.src('templates/web/css/fontawesome-style.css')
      .pipe(consolidate('swig', template_data, { useContents : true }))
      .pipe(rename({ basename:'fontawesome-' + font_name }))
      .pipe(gulp.dest(dist_dir + 'web/css/'))
      .on('end', resolve);
    }),
    new Promise(function(resolve, reject) {
      // foundation-style.css
      gulp.src('templates/web/css/foundation-style.css')
      .pipe(consolidate('swig', template_data, { useContents : true }))
      .pipe(rename({ basename:'foundation-' + font_name }))
      .pipe(gulp.dest(dist_dir + 'web/css/'))
      .on('end', resolve);
    }),
    new Promise(function(resolve, reject) {
      // ios
      gulp.src('templates/ios/*/*.*')
      .pipe(consolidate('swig', template_data, { useContents : true }))
      .pipe(gulp.dest(dist_dir + '/ios/'))
      .on('end', resolve);
    }),
    new Promise(function(resolve, reject) {
      // android
      gulp.src('templates/android/**/*.*')
      .pipe(consolidate('swig', template_data, { useContents : true }))
      .pipe(gulp.dest(dist_dir + '/android/'))
      .on('end', resolve);
    })];

    Promise.all(promise_list).then(function() {
      build_for_template_deferred.resolve();
    });
  })
  .pipe(gulp.dest(dist_dir + 'fonts/'))
  .on('end', create_font_deferred.resolve);

  return Q.all([create_font_deferred.promise,build_for_template_deferred.promise])
});

gulp.task('update-sample', ['build'], function(cb) {
  var cmd = 'sh templates/update-sample.sh';
  child_process.execSync(cmd);
  cb();
});

gulp.task('make', ['clean', 'build', 'update-sample']);

gulp.task('open', function(cb) {
  child_process.execSync('open samples/web/index.html');
});

gulp.task('watch', function(){
  gulp.watch('*.sketch/Data', { debounceDelay: 3000 }, ['build']); // wait 3 sec after the last run
});
