package flavor

import org.gradle.api.NamedDomainObjectContainer
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.LibraryProductFlavor

object ProductFlavorSimpson : BuildProductFlavor {
    override val name = "simpson_viewer"

    override fun appCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor =
        namedDomainObjectContainer.create(name) {
            applicationId = "com.sample.simpsonviewer"
            dimension = FlavorDimensions.CHARACTERS
        }

    override fun libraryCreate(namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor =
        namedDomainObjectContainer.create(name) {
            dimension = FlavorDimensions.CHARACTERS
        }
}
