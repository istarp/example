package nz.co.example.coremodule

import nz.co.example.coremodule.utils.ApplicationContext

interface CoreFacade {

    companion object {
        lateinit var applicationContext: ApplicationContext
            private set

        fun init(
            context: ApplicationContext,
        ) {
            applicationContext = context
        }

        val resources: nz.co.example.coremodule.features.resources.ResourcesFacade by lazy { nz.co.example.coremodule.features.resources.ResourcesFacade.newInstance() }

        val storage: nz.co.example.coremodule.features.storage.StorageFacade by lazy { nz.co.example.coremodule.features.storage.StorageFacade.newInstance() }

    }
}