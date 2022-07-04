import dependencies.module.ModuleDependency
import dependencies.test.TestDependency
import flavor.ProductFlavorSimpson
import flavor.ProductFlavorWire
import flavor.buildConfigStringField

plugins {
    id("templates.android-library")
}

android {
    productFlavors.forEach {  flavor ->
        flavor.buildConfigStringField("BASE_URL", "http://api.duckduckgo.com/")

        when(flavor.name) {
            ProductFlavorSimpson.name -> {
                flavor.buildConfigStringField(
                    "QUERY_URL",
                    "?q=simpsons+characters&format=json"
                )
            }
            ProductFlavorWire.name -> {
                flavor.buildConfigStringField(
                    "QUERY_URL",
                    "?q=the+wire+characters&format=json"
                )
            }
        }
    }
}

dependencies {
    implementation(project(library.Library.DOMAIN_LIB))

    implementation(ModuleDependency.RETROFIT_RX)
    implementation(ModuleDependency.RETROFIT_KOTLINX)
    implementation(ModuleDependency.OKHTTP)
    implementation(ModuleDependency.LOGGING)
}
