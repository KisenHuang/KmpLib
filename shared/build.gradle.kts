plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

version = "1.0"

kotlin {
    android()

    iosX64()
    iosArm64()
//    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "10"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = project.name
        }
    }

    js(IR) {
        moduleName = project.name
        browser {
            distribution {
                directory = rootProject.file("repo/js/${project.name}-$version")
            }
        }
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //添加Kotlin 协程库，处理异步操作
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
            }
        }

        val androidMain by getting

        val iosX64Main by getting
        val iosArm64Main by getting
//        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
//            iosSimulatorArm64Main.dependsOn(this)
        }

        val jsMain by getting
    }
}

android {
    namespace = "com.tal.kmplib"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}