package flavor

import  com.android.build.gradle.internal.dsl.ProductFlavor

object FlavorDimensions {
    const val CHARACTERS = "characters"
}
fun ProductFlavor.buildConfigStringField(
    name: String, value: String
) {
    this.buildConfigField("String", name, "\"$value\"")
}
