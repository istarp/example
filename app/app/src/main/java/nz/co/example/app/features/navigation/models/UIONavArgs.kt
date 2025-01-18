package nz.co.example.app.features.navigation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class UIONavArgs(val operation: UIONavOperation) : Parcelable

internal sealed class UIONavOperation : Parcelable {

    @Parcelize
    data object PopAll : UIONavOperation()

    @Parcelize
    data class PopTo(val route: UIONavigationRoute, val inclusive: Boolean = true) : UIONavOperation()

}