import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlin_version: String by extra
val coroutines_version: String by extra

plugins {
    kotlin("multiplatform") version "1.3.72"
}

repositories {
    mavenCentral()
    jcenter()
}


kotlin {

    jvm()

    js {
        nodejs {
            testTask {
                useKarma()
            }

            val main by compilations.getting {
                compileKotlinTask.kotlinOptions {
                    moduleKind = "commonjs"
                    sourceMap = true
                    metaInfo = true
                    outputFile = "functions/src/main/index.js"
                }
            }

            val test by compilations.getting {
                compileKotlinTask.kotlinOptions {
                    moduleKind = "commonjs"
                    sourceMap = true
                    metaInfo = true
                }
            }

        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutines_version")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jvmMain by getting {
            dependencies {
                // kotlin
                implementation(kotlin("stdlib-jdk8"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit5"))
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$coroutines_version")
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }

}


tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    build {
        doLast {
            configurations.getByName("jsDefault").forEach {
                println("Copy: " + it.path.toString())

                copy {
                    includeEmptyDirs = false
                    from(zipTree(it.absolutePath))
                    into("${projectDir}/functions/node_modules")
                    include {
                        val path = it.path
                        path.endsWith(".js") && (path.startsWith("META-INF/resources/") || !path.startsWith("META-INF/"))
                    }
                }
            }
        }
    }
}

