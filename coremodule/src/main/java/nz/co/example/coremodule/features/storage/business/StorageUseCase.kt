package nz.co.example.coremodule.features.storage.business

import kotlinx.coroutines.withContext
import nz.co.example.coremodule.common.CoroutineDispatchers
import nz.co.example.coremodule.common.CoroutineDispatchersProvider
import nz.co.example.coremodule.features.storage.PrimitiveStorage
import nz.co.example.coremodule.features.storage.StorageFeature
import nz.co.example.coremodule.features.storage.data.providers.UserSharedPrefStorageProvider

internal class StorageUseCase(
    override val userSharedPref: PrimitiveStorage = UserSharedPrefStorageProvider()
        .instance(),
    private val dispatcher: CoroutineDispatchers = CoroutineDispatchersProvider.dispatcher(),
) : StorageFeature {

    override suspend fun clearUserStorage() {
        withContext(dispatcher.io()) {
        }
    }

    override suspend fun clearAll() {
        withContext(dispatcher.io()) {
            clearUserStorage()
        }
    }
}