package dependencies.module

object ModuleDependency {
    //Androidx dependencies
    const val CORE_KTX = "androidx.core:core-ktx:${ModuleDependencyVersions.CORE_KTX_VERSION}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${ModuleDependencyVersions.APP_COMPAT_VERSION}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${ModuleDependencyVersions.RECYCLER_VIEW_VERSION}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${ModuleDependencyVersions.CONSTRAINT_LAYOUT_VERSION}"
    const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${ModuleDependencyVersions.LIVE_DATA_VERSION}"
    const val LIFECYCLE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${ModuleDependencyVersions.LIFECYCLE_VIEW_MODEL_VERSION}"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${ModuleDependencyVersions.NAVIGATION_FRAGMENT_VERSION}"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${ModuleDependencyVersions.NAVIGATION_UI_KTX_VERSION}"

    //Data layer dependencies
    const val OKHTTP = "com.squareup.okhttp3:okhttp"
    const val LOGGING =  "com.squareup.okhttp3:logging-interceptor:${ModuleDependencyVersions.LOGGING}"
    const val KOTLIN_X = "org.jetbrains.kotlinx:kotlinx-serialization-json:${ModuleDependencyVersions.JSON_SERIALIZER}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${ModuleDependencyVersions.RETROFIT}"
    const val RETROFIT_RX = "com.squareup.retrofit2:adapter-rxjava3:${ModuleDependencyVersions.RETROFIT}"
    const val RETROFIT_KOTLINX = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${ModuleDependencyVersions.RETROFIT_KOTLINX}"

    //Presentation layer dependencies
    const val GLIDE = "com.github.bumptech.glide:glide:${ModuleDependencyVersions.GLIDE}"

    //Global dependencies
    const val DAGGER_HILT = "com.google.dagger:hilt-compiler:${ModuleDependencyVersions.DAGGER_HILT}"
    const val HILT = "com.google.dagger:hilt-android:${ModuleDependencyVersions.DAGGER_HILT}"
    const val RXANDROID = "io.reactivex.rxjava3:rxandroid:${ModuleDependencyVersions.RXANDROID}"
    const val RXJAVA = "io.reactivex.rxjava3:rxjava:${ModuleDependencyVersions.RXJAVA}"

    //material dependencies
    const val GOOGLE_MATERIAL = "com.google.android.material:material:${ModuleDependencyVersions.MATERIAL_VERSION}"
}
