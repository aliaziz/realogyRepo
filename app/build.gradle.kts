import dependencies.module.ModuleDependency
import dependencies.test.TestDependency
import flavor.FlavorDimensions
import flavor.ProductFlavorSimpson
import flavor.ProductFlavorWire
import library.Library.DATA_LIB
import library.Library.DOMAIN_LIB

plugins {
    id(plugin.BuildPlugins.ANDROID_APPLICATION)
    id(plugin.BuildPlugins.KOTLIN_ANDROID)
    id(plugin.BuildPlugins.HILT_PLUGIN)
    id(plugin.BuildPlugins.KOTLIN_KAPT)
    kotlin(plugin.BuildPlugins.SERIALIZER)
}

android {
    compileSdk = ProjectConfigs.COMPILE_SDK
    buildToolsVersion = ProjectConfigs.BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId = ProjectConfigs.APPLICATION_ID
        minSdk = ProjectConfigs.MIN_SDK
        targetSdk = ProjectConfigs.TARGET_SDK
        versionCode = ProjectConfigs.VERSION_CODE
        versionName = ProjectConfigs.VERSION_NAME

        testInstrumentationRunner = ProjectConfigs.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(build_type.BuildType.RELEASE) {
            isMinifyEnabled = build_type.BuildTypeRelease.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName(build_type.BuildType.DEBUG) {
            isMinifyEnabled = build_type.BuildTypeDebug.isMinifyEnabled
            applicationIdSuffix = build_type.BuildTypeDebug.applicationIdSuffix
        }
    }

    flavorDimensions+=FlavorDimensions.CHARACTERS

    productFlavors {
        ProductFlavorSimpson.appCreate(this)
        ProductFlavorWire.appCreate(this)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        viewBinding = ProjectConfigs.VIEW_BINDING
    }
}

dependencies {
    implementation(project(DATA_LIB))
    implementation(project(DOMAIN_LIB))

    implementation(ModuleDependency.GOOGLE_MATERIAL)
    implementation(ModuleDependency.CORE_KTX)
    implementation(ModuleDependency.APP_COMPAT)
    implementation(ModuleDependency.RECYCLER_VIEW)
    implementation(ModuleDependency.CONSTRAINT_LAYOUT)
    implementation(ModuleDependency.LIVE_DATA)
    implementation(ModuleDependency.HILT)
    kapt(ModuleDependency.DAGGER_HILT)
    implementation(ModuleDependency.LIFECYCLE_VIEW_MODEL)
    implementation(ModuleDependency.NAVIGATION_FRAGMENT)
    implementation(ModuleDependency.NAVIGATION_UI_KTX)
    implementation(ModuleDependency.KOTLIN_X)
    implementation(ModuleDependency.GLIDE)

    implementation(ModuleDependency.RXANDROID)
    implementation(ModuleDependency.RXJAVA)

    testImplementation(TestDependency.JUNIT)
    testImplementation(TestDependency.TRUTH)
    testImplementation(TestDependency.MOCK_K)
    testImplementation(TestDependency.ANDROID_ARCH_X_CORE)

    androidTestImplementation(TestDependency.ANDROIDX_JUNIT)
    androidTestImplementation(TestDependency.ESPRESSO)
}
