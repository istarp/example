package nz.co.example.coremodule.features.resources.business

import androidx.annotation.StringRes
import nz.co.example.coremodule.features.resources.data.ResourcesRepository

internal class ResourcesUseCase() :
    nz.co.example.coremodule.features.resources.ResourcesFeature {
    override fun getString(@StringRes id: Int): String {
        return ""
    }

    override fun getString(@StringRes id: Int, vararg formatArgs: Any): String {
        return ""
    }
}