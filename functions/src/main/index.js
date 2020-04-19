(function (_, Kotlin) {
  'use strict';
  var $$importsForInline$$ = _.$$importsForInline$$ || (_.$$importsForInline$$ = {});
  var PrimitiveClasses$stringClass = Kotlin.kotlin.reflect.js.internal.PrimitiveClasses.stringClass;
  var defineInlineFunction = Kotlin.defineInlineFunction;
  var wrapFunction = Kotlin.wrapFunction;
  function main$lambda(req, res) {
    PrimitiveClasses$stringClass;
    console.log("Starting first function 'hello'");
    return res.status(200).send('Hello World!');
  }
  function main(args) {
    var functions = require('firebase-functions');
    var admin = require('firebase-admin');
    admin.initializeApp(functions.config().firebase);
    exports.hello = functions.https.onRequest(main$lambda);
  }
  var firstKotlinFunction = defineInlineFunction('index.firstKotlinFunction_30y1fr$', wrapFunction(function () {
    var getKClass = Kotlin.getKClass;
    return function (T_0, isT) {
      return getKClass(T_0);
    };
  }));
  $$importsForInline$$.index = _;
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('index', _);
  return _;
}(module.exports, require('kotlin')));

//# sourceMappingURL=index.js.map
