package nz.co.example.coremodule.features.storage

import nz.co.example.coremodule.features.storage.business.StorageUseCase

interface StorageFeature {
    val userSharedPref: PrimitiveStorage
    suspend fun clearUserStorage()
    suspend fun clearAll()
}

class StorageFacade private constructor(
    private val storageFeature: StorageFeature = StorageUseCase()
) : StorageFeature by storageFeature {

    companion object {
        fun newInstance() = nz.co.example.coremodule.features.storage.StorageFacade()
    }

}