package build_type

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false

    const val applicationIdSuffix = ".debug"
}
