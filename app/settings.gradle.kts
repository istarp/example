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

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

include(":app")

val rickAndMortyModule = ":modules:rickandmortymodule"
include(rickAndMortyModule)
project(rickAndMortyModule).projectDir = File(settingsDir, "../rickandmortymodule")

val coreModule = ":modules:coremodule"
include(coreModule)
project(coreModule).projectDir = File(settingsDir, "../coremodule")
