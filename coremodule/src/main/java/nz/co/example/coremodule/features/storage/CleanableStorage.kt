package nz.co.example.coremodule.features.storage

interface CleanableStorage {
    suspend fun delete(key: String)
    suspend fun clear()
}