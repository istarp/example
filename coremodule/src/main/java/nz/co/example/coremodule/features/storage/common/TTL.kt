package nz.co.example.coremodule.features.storage.common

import kotlinx.serialization.Serializable
import nz.co.example.coremodule.common.TimeUtils
import java.util.concurrent.TimeUnit

@Serializable
sealed class TTL(val millis: Long, private val expiryMillis: Long) {

    @Serializable
    data object Forever : TTL(FOREVER_MILLIS, nz.co.example.coremodule.common.TimeUtils.currentTimeMillis() + FOREVER_MILLIS)

    @Serializable
    data class Value(val milliSeconds: Long) : TTL(milliSeconds, nz.co.example.coremodule.common.TimeUtils.currentTimeMillis() + milliSeconds)

    fun hasExpired() = nz.co.example.coremodule.common.TimeUtils.currentTimeMillis() >= expiryMillis

    companion object {
        private val FOREVER_MILLIS = TimeUnit.DAYS.toMillis(365) * 10 // 10 years

        fun now(): TTL = Value(0)
        fun forever(): TTL = Value(FOREVER_MILLIS)
    }

}