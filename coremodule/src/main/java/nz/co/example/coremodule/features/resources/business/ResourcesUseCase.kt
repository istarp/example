package nz.co.example.coremodule.features.resources.business

import androidx.annotation.StringRes
import nz.co.example.coremodule.features.resources.data.ResourcesRepository

internal class ResourcesUseCase(private val repo: ResourcesRepository = ResourcesRepository()) :
    nz.co.example.coremodule.features.resources.ResourcesFeature {
    override fun getString(@StringRes id: Int): String {
        return repo.getString(id)
    }

    override fun getString(@StringRes id: Int, vararg formatArgs: Any): String {
        return repo.getString(id, *formatArgs)
    }
}