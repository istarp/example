package nz.co.example.coremodule.features.storage.data.providers

import nz.co.example.coremodule.common.InstanceProvider
import nz.co.example.coremodule.features.storage.PrimitiveStorage
import nz.co.example.coremodule.features.storage.data.SharedPrefScope
import nz.co.example.coremodule.features.storage.data.storages.SharedPreferenceStorage

internal class UserSharedPrefStorageProvider :
    nz.co.example.coremodule.common.InstanceProvider<nz.co.example.coremodule.features.storage.PrimitiveStorage> {

    companion object {
        private val storage: nz.co.example.coremodule.features.storage.PrimitiveStorage by lazy { nz.co.example.coremodule.features.storage.data.storages.SharedPreferenceStorage.instance(
            nz.co.example.coremodule.features.storage.data.SharedPrefScope.USER) }
    }

    override fun instance(): nz.co.example.coremodule.features.storage.PrimitiveStorage =
        nz.co.example.coremodule.features.storage.data.providers.UserSharedPrefStorageProvider.Companion.storage

}