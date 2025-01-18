package nz.co.example.config

import org.gradle.api.JavaVersion

object ModuleConfig {
    const val compileSdkVersion = 35 // Should match whatever is in ProjectConfig.kt
    const val minSdkVersion = 26 // Should match whatever is in ProjectConfig.kt
    const val targetSdkVersion = 35 // Should match whatever is in ProjectConfig.kt

    val jvmTarget = JavaVersion.VERSION_17
    const val kotlinJvmTarget = "17"
}