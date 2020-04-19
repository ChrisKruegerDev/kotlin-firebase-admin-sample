(function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main$lambda(req, res) {
    console.log("Starting first function 'saveString'");
    return res.status(200).send('Hello!');
  }
  function main(args) {
    println('Hello world!');
    var functions = require('firebase-functions');
    var admin = require('firebase-admin');
    admin.initializeApp(functions.config().firebase);
    exports.saveString = functions.https.onRequest(main$lambda);
  }
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('index', _);
  return _;
}(module.exports, require('kotlin')));

//# sourceMappingURL=index.js.map
