package nz.co.example.coremodule.features.storage.common

import kotlinx.coroutines.flow.Flow
import nz.co.example.coremodule.features.storage.ObjectStorage

suspend inline fun <reified T: Any> nz.co.example.coremodule.features.storage.ObjectStorage.get(key: String): Flow<T?> = get(key, T::class)

suspend inline fun <reified T: Any> nz.co.example.coremodule.features.storage.ObjectStorage.peek(key: String): Flow<T?> = peek(key, T::class)

suspend inline fun <reified T: Any> nz.co.example.coremodule.features.storage.ObjectStorage.getCurrent(key: String): T? = getCurrent(key, T::class)

suspend inline fun <reified T: Any> nz.co.example.coremodule.features.storage.ObjectStorage.peekCurrent(key: String): T? = peekCurrent(key, T::class)