import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}
object PluginsVersions {
    const val GRADLE_ANDROID = "7.2.0"
    const val KOTLIN = "1.6.21"
    const val NAVIGATION = "2.4.2"
    const val HILT = "2.42"
}

dependencies {
    implementation(kotlin("serialization", version = PluginsVersions.KOTLIN))
    implementation("com.android.tools.build:gradle:${PluginsVersions.GRADLE_ANDROID}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.KOTLIN}")
    implementation("com.google.dagger:hilt-android-gradle-plugin:${PluginsVersions.HILT}")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${PluginsVersions.NAVIGATION}")
}

