rootProject.name = "DigiKraft Demo"
include(":app")
enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {

            //appcompat
            version("version", "1.4.1")
            alias("appcompat").to("androidx.appcompat", "appcompat")
                .versionRef("version")
            //core
            version("core", "1.7.0")
            alias("core").to("androidx.core", "core-ktx")
                .versionRef("core")

            //material
            alias("material").to("com.google.android.material:material:1.6.0")

            //live data
            version("livedata", "2.3.1")
            alias("livedata").to("androidx.lifecycle", "lifecycle-livedata-ktx")
                .versionRef("livedata")

            //viewmodel
            version("viewmodel", "2.3.1")
            alias("livedata").to("androidx.lifecycle", "lifecycle-viewmodel-ktx")
                .versionRef("viewmodel")

            //constraintlayout
            version("constraintlayout", "2.1.3")
            alias("constraintlayout").to("androidx.constraintlayout", "constraintlayout")
                .versionRef("constraintlayout")

            //recyclerview
            version("recyclerview", "1.2.1")
            alias("recyclerview").to("androidx.recyclerview", "recyclerview")
                .versionRef("recyclerview")

            //cardview
            version("cardview", "1.0.0")
            alias("cardview").to("androidx.cardview", "cardview")
                .versionRef("cardview")

            //retrofit with bundle
            version("retrofit", "2.9.0")
            alias("retrofit").to("com.squareup.retrofit2", "retrofit").versionRef("retrofit")
            alias("converter-gson").to("com.squareup.retrofit2", "converter-gson")
                .versionRef("retrofit")
            bundle("retrofit-bundle", listOf("retrofit", "converter-gson"))
        }

    }
}

include(":Logger")
