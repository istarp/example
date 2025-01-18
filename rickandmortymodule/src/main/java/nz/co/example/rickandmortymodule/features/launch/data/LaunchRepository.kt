package nz.co.example.rickandmortymodule.features.launch.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import nz.co.example.coremodule.CoreFacade
import nz.co.example.coremodule.features.storage.PrimitiveStorage

private const val WELCOME_FLOW_FINISHED_KEY = "welcomeFlowFinishedKey"
private const val APP_LAUNCH_FINISHED_KEY = "appLaunchFinishedKey"

internal class LaunchRepository(
    private val userSharedPref: nz.co.example.coremodule.features.storage.PrimitiveStorage = nz.co.example.coremodule.CoreFacade.storage.userSharedPref
) {

    suspend fun saveAppLaunchFinishedFlag(flag: Boolean) {
      //  appInMemoryFlow.save(APP_LAUNCH_FINISHED_KEY, flag, TTL.forever())
    }

    suspend fun getAppLaunchFinishedFlag(): Flow<Boolean?> {
      //  return appInMemoryFlow.get(APP_LAUNCH_FINISHED_KEY)
        return flow {  }
    }

    suspend fun saveWelcomeFlowFinishedFlag(flag: Boolean) {
        userSharedPref.saveBoolean(WELCOME_FLOW_FINISHED_KEY, flag)
    }

    suspend fun getWelcomeFlowFinishedFlag(): Boolean {
        return userSharedPref.getBoolean(WELCOME_FLOW_FINISHED_KEY)
    }

}