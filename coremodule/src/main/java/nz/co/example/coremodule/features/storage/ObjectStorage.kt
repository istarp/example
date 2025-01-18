package nz.co.example.coremodule.features.storage

import kotlinx.coroutines.flow.Flow
import nz.co.example.coremodule.features.storage.common.TTL
import kotlin.reflect.KClass

interface ObjectStorage : nz.co.example.coremodule.features.storage.CleanableStorage {
    suspend fun <T: Any> get(key: String, kClass: KClass<T>): Flow<T?>
    suspend fun <T: Any> peek(key: String, kClass: KClass<T>): Flow<T?>
    suspend fun <T: Any> getCurrent(key: String, kClass: KClass<T>): T?
    suspend fun <T: Any> peekCurrent(key: String, kClass: KClass<T>): T?
    suspend fun <T: Any> save(key: String, value: T, ttl: TTL)
    suspend fun peekTtl(key: String): TTL?
}