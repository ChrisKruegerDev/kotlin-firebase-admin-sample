external fun require(module: String): dynamic
external val exports: dynamic

fun main(args: Array<String>) {
    println("Hello world!")
    val functions = require("firebase-functions")
    val admin = require("firebase-admin")
    admin.initializeApp(functions.config().firebase)

    exports.saveString = functions.https.onRequest { req, res ->
        console.log("Starting first function 'saveString'")
        res.status(200).send("Hello!")
    }
}