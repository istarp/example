package nz.co.example.rickandmortymodule.features.authentication.business

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.withContext
import nz.co.example.coremodule.CoreFacade
import nz.co.example.coremodule.common.CoroutineDispatchers
import nz.co.example.coremodule.common.CoroutineDispatchersProvider
import nz.co.example.coremodule.common.CoroutineScopes
import nz.co.example.coremodule.common.CoroutineScopesProvider
import nz.co.example.coremodule.features.storage.StorageFeature
import nz.co.example.rickandmortymodule.features.authentication.LogoutFeature

internal class LogoutUseCase(
    private val storage: StorageFeature = CoreFacade.storage,
    private val scopes: CoroutineScopes = CoroutineScopesProvider.getInstance(),
    private val dispatcher: CoroutineDispatchers = CoroutineDispatchersProvider.dispatcher(),
) : LogoutFeature {

    override suspend fun logout() {
        withContext(dispatcher.io()) {
            cancelAndRecreateUserSessionScope()
            //call logout api
            cleanupUserRelatedData()
        }
    }

    private fun cancelAndRecreateUserSessionScope() {
        scopes.userSession().cancel(CancellationException("User session has changed"))
        scopes.recreateUserSession()
    }

    private suspend fun cleanupUserRelatedData() {
     //   runSafely(logger) { storage.clearUserStorage() }
    }

}