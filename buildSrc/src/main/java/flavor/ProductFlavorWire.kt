package flavor

import org.gradle.api.NamedDomainObjectContainer
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.LibraryProductFlavor

object ProductFlavorWire : BuildProductFlavor {
    override val name = "the_character_wire"

    override fun appCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor =
        namedDomainObjectContainer.create(name) {
            applicationId = "com.sample.wireviewer"
            dimension = FlavorDimensions.CHARACTERS
        }

    override fun libraryCreate(namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor =
        namedDomainObjectContainer.create(name) {
            dimension = FlavorDimensions.CHARACTERS
        }
}

