dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("sharedLibs") {
            from(files("../dependencymodule/gradle/shared-libs.versions.toml"))
        }
    }
}

//Due gradle kts issues, we are not able to refer this value from buildSrc in top level gradle files.
//Kotlin serialization plugin fails to load in multimodule project if we dont specify resolution strategy.
pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlinx-serialization") {
                useModule("org.jetbrains.kotlin:kotlin-serialization:1.9.10") //version needs to match in shared-libs.versions.toml.
            }
        }
    }

    repositories {
        gradlePluginPortal()
        maven("https://kotlin.bintray.com/kotlinx")
    }
}

val coreModule = ":modules:coremodule"
include(coreModule)
project(coreModule).projectDir = File(settingsDir, "../coremodule")