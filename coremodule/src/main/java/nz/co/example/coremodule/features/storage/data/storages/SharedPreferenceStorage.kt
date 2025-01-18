package nz.co.example.coremodule.features.storage.data.storages

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.coroutines.withContext
import nz.co.example.coremodule.common.CoroutineDispatchers
import nz.co.example.coremodule.common.CoroutineDispatchersProvider
import nz.co.example.coremodule.features.storage.PrimitiveStorage

internal class SharedPreferenceStorage internal constructor(
    private val sharedPrefs: SharedPreferences,
    private val dispatchers: CoroutineDispatchers = CoroutineDispatchersProvider.dispatcher(),
) : PrimitiveStorage {

    override suspend fun saveBoolean(key: String, value: Boolean) {
        withContext(dispatchers.io()) {
            sharedPrefs.edit(commit = true) { putBoolean(key, value) }
        }
    }

    override suspend fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return withContext(dispatchers.io()) { sharedPrefs.getBoolean(key, defaultValue) }
    }

    override suspend fun saveString(key: String, value: String) {
        withContext(dispatchers.io()) {
            sharedPrefs.edit(commit = true) { putString(key, value) }
        }
    }

    override suspend fun getString(key: String): String? {
        return withContext(dispatchers.io()) { sharedPrefs.getString(key, null) }
    }

    override suspend fun saveInt(key: String, value: Int) {
        withContext(dispatchers.io()) {
            sharedPrefs.edit(commit = true) { putInt(key, value) }
        }
    }

    override suspend fun getInt(key: String): Int? {
        return withContext(dispatchers.io()) {
            val value = sharedPrefs.getInt(key, Int.MIN_VALUE)
            if (value == Int.MIN_VALUE) null else value
        }

    }

    override suspend fun delete(key: String) {
        withContext(dispatchers.io()) {
            sharedPrefs.edit(commit = true) { remove(key) }
        }
    }

    override suspend fun clear() {
        withContext(dispatchers.io()) {
            sharedPrefs.edit(commit = true) { clear() }
        }
    }

    companion object {
        internal fun instance(
            scope: nz.co.example.coremodule.features.storage.data.SharedPrefScope,
            context: Context = nz.co.example.coremodule.CoreFacade.applicationContext
        ): nz.co.example.coremodule.features.storage.data.storages.SharedPreferenceStorage {
            return nz.co.example.coremodule.features.storage.data.storages.SharedPreferenceStorage(
                context.getSharedPreferences(
                    scope.groupName,
                    Context.MODE_PRIVATE
                )
            )
        }
    }

}