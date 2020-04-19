import kotlin.reflect.KClass

external fun require(module: String): dynamic
external val exports: dynamic

fun main(args: Array<String>) {
    val functions = require("firebase-functions")
    val admin = require("firebase-admin")
    admin.initializeApp(functions.config().firebase)

    exports.hello = functions.https.onRequest { req, res ->
        firstKotlinFunction<String>()
        console.log("Starting first function 'hello'")
        res.status(200).send("Hello World!")
    }
}

inline fun <reified T : Any> firstKotlinFunction(): KClass<T> = T::class