package nz.co.example.coremodule.features.resources

import androidx.annotation.StringRes
import nz.co.example.coremodule.features.resources.business.ResourcesUseCase

interface ResourcesFeature {
    fun getString(@StringRes id: Int): String

    fun getString(@StringRes id: Int, vararg formatArgs: Any): String
}

class ResourcesFacade private constructor(
    private val resourcesFeature: ResourcesFeature = ResourcesUseCase()
) : ResourcesFeature by resourcesFeature {
    companion object {
        fun newInstance() = ResourcesFacade()
    }
}