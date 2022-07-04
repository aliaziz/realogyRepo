package templates

import dependencies.module.ModuleDependency
import dependencies.test.TestDependency
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.dependencies
import flavor.FlavorDimensions
import flavor.ProductFlavorWire
import flavor.ProductFlavorSimpson

plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    compileSdk = ProjectConfigs.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectConfigs.MIN_SDK
        targetSdk = ProjectConfigs.TARGET_SDK

        testInstrumentationRunner = ProjectConfigs.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11" //Using string here, failing to compile with java version variable.
    }

    flavorDimensions += FlavorDimensions.CHARACTERS

    productFlavors {
        ProductFlavorSimpson.libraryCreate(this)
        ProductFlavorWire.libraryCreate(this)
    }
}

dependencies {
    implementation(ModuleDependency.GOOGLE_MATERIAL)
    implementation(ModuleDependency.CORE_KTX)
    implementation(ModuleDependency.APP_COMPAT)
    implementation(ModuleDependency.RXANDROID)
    implementation(ModuleDependency.RXJAVA)

    kapt(ModuleDependency.DAGGER_HILT)
    implementation(ModuleDependency.HILT)
    implementation(ModuleDependency.KOTLIN_X)

    testImplementation(TestDependency.JUNIT)
    testImplementation(TestDependency.TRUTH)
    testImplementation(TestDependency.MOCK_K)
}
