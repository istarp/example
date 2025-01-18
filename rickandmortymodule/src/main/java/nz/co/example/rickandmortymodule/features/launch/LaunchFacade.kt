package nz.co.example.rickandmortymodule.features.launch

import kotlinx.coroutines.flow.Flow
import nz.co.example.rickandmortymodule.features.launch.business.LaunchUseCase
import nz.co.example.rickandmortymodule.features.launch.business.models.LaunchPage

interface LaunchFeature {
    suspend fun performLaunch()
    suspend fun recordLaunchFinished()
    suspend fun launchFinished(): Flow<Boolean>
    suspend fun getLaunchPage(): LaunchPage
}

class LaunchFacade private constructor(
    private val launchFeature: LaunchFeature = LaunchUseCase()
) : LaunchFeature by launchFeature {

    companion object {
        fun newInstance() = LaunchFacade()
    }

}