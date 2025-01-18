package nz.co.example.coremodule.features.resources.data

import androidx.annotation.StringRes
import nz.co.example.coremodule.CoreFacade
import nz.co.example.coremodule.utils.ApplicationContext

internal class ResourcesRepository(private val applicationContext: ApplicationContext = CoreFacade.applicationContext) {
    fun getString(@StringRes id: Int): String {
        return applicationContext.getString(id)
    }

    fun getString(@StringRes id: Int, vararg formatArgs: Any): String {
        return applicationContext.getString(id, *formatArgs)
    }
}