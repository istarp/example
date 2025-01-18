package nz.co.example.app.features.navigation.models

import java.util.UUID

internal sealed class UIONavigationState {

    data object Idle : UIONavigationState()

    data class Navigate(val action: UIOGenericNavigation, val id: String = UUID.randomUUID().toString()) :
        UIONavigationState()

}