package nz.co.example.coremodule.features.storage

interface PrimitiveStorage : nz.co.example.coremodule.features.storage.CleanableStorage {
    suspend fun saveString(key: String, value: String)
    suspend fun getString(key: String): String?
    suspend fun saveInt(key: String, value: Int)
    suspend fun getInt(key: String): Int?
    suspend fun saveBoolean(key: String, value: Boolean)
    suspend fun getBoolean(key: String, defaultValue: Boolean = false): Boolean
}