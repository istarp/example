package nz.co.example.coremodule.extensions

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun CoroutineScope.launchSafely(
    context: CoroutineContext = EmptyCoroutineContext,
    handler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    },
    block: suspend CoroutineScope.() -> Unit
): Job = launch(handler + context) { block() }

suspend fun <T> runSafely(
    onErrorAction: ((throwable: Throwable) -> Unit)? = null,
    action: suspend () -> T
): T? {
    return try {
        action.invoke()
    } catch (throwable: Throwable) {
        onErrorAction?.invoke(throwable)
        null
    }
}