package nz.co.example.coremodule.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface CoroutineDispatchers {
    fun main(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
}

object CoroutineDispatchersProvider {
    private val dispatcher by lazy {
        object : CoroutineDispatchers {
            override fun main() = Dispatchers.Main
            override fun io() = Dispatchers.IO
            override fun default() = Dispatchers.Default
        }
    }

    fun dispatcher() = dispatcher
}