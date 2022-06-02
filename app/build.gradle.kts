plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.amlavati.digikraft"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "0.0.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true

        }
    }

//    flavorDimensions += "version"
//    productFlavors {
//        create("dev") {
//            //applicationIdSuffix = ".dev"
//            buildConfigField("String", "PROTOCOL", "\"http\"")
//            buildConfigField("String", "DOMAIN", "\"www.poznan.pl\"")
//            buildConfigField("String", "ENDPOINT", "\"mim/plan/map_service.html\"")
//        }
//
//    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    // approach for multi module projects
    implementation(libs.appcompat)
    implementation(libs.core)
    implementation(libs.material)
    implementation(libs.bundles.retrofit.bundle)
    implementation(libs.constraintlayout)
    implementation(libs.recyclerview)
//    implementation(libs.cardview)
    implementation(libs.livedata)

    // approach for single  module project
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.2")
    implementation("com.google.android.gms:play-services-maps:18.0.2")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}