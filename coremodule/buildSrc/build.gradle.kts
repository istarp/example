apply (from = "../../dependencymodule/top_level_dependency.gradle")

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

buildscript {
    repositories {
        mavenCentral()
        google()
    }
}

repositories {
    mavenCentral()
    google()
}

val kotlinGradlePluginDependency = extra.get("kotlinGradlePluginDependency")!!
val gradleBuildToolsDependency = extra.get("gradleBuildToolsDependency")!!

dependencies {
    // in order to be able to use "kotlin-android" in the common script
    implementation(kotlinGradlePluginDependency)

    // in order to recognize the "plugins" block in the common script
    implementation(gradleBuildToolsDependency)
}

kotlin {
    // to be able to refer shared dependencies and versions defined in kotlin files in buildSrc, we need to update sourceSets for each project that consumes this.
    sourceSets.getByName("main").kotlin.srcDir(project.projectDir.absolutePath + "/../../dependencymodule/buildSrc/src/main/kotlin")
}
