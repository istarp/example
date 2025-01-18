package nz.co.example.rickandmortymodule.features.launch.business

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import nz.co.example.coremodule.common.CoroutineDispatchers
import nz.co.example.coremodule.common.CoroutineDispatchersProvider
import nz.co.example.rickandmortymodule.features.launch.LaunchFeature
import nz.co.example.rickandmortymodule.features.launch.business.models.LaunchPage
import nz.co.example.rickandmortymodule.features.launch.data.LaunchRepository

internal class LaunchUseCase(
    private val repository: LaunchRepository = LaunchRepository(),
    private val dispatcher: CoroutineDispatchers = CoroutineDispatchersProvider.dispatcher()
) : LaunchFeature {

    override suspend fun performLaunch() {
        withContext(dispatcher.default()) {
            //todo missing logic
            delay(3000)
        }
    }

    override suspend fun recordLaunchFinished() {
        withContext(dispatcher.default()) {
            repository.saveAppLaunchFinishedFlag(true)
        }
    }

    override suspend fun launchFinished(): Flow<Boolean> {
        return withContext(dispatcher.default()) {
            repository.getAppLaunchFinishedFlag().map {
                it ?: false
            }
        }
    }

    override suspend fun getLaunchPage(): LaunchPage {
        return withContext(dispatcher.default()) {
            LaunchPage.Dashboard
        }
    }

}