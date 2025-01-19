package nz.co.example.app.ui.lce

import androidx.compose.runtime.Immutable

@Immutable
sealed interface LCEState<out T> {
    @Immutable
    class Loading<T> : LCEState<T>

    @Immutable
    data class Content<T>(val value: T) : LCEState<T>

    @Immutable
    data class Error<T>(val error: String) : LCEState<T>
}

