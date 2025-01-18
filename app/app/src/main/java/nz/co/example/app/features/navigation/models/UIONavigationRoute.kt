package nz.co.example.app.features.navigation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import nz.co.example.app.features.navigation.models.UIOGenericNavigation
import nz.co.example.app.features.navigation.models.UIONavArgs

@Parcelize
internal data class UIONavigationRoute(val value: String, val navArgs: UIONavArgs? = null) : UIOGenericNavigation,
    Parcelable