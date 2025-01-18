package nz.co.example.app.features.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import nz.co.example.app.features.navigation.models.UIOGenericNavigation
import nz.co.example.app.features.navigation.models.UIONavigationState

internal class SolarNavigator private constructor() {

    val navigationState: MutableStateFlow<UIONavigationState> =
        MutableStateFlow(UIONavigationState.Idle)

    fun onNavigated(state: UIONavigationState) {
        navigationState.compareAndSet(state, UIONavigationState.Idle)
    }

    fun navigate(navigation: UIOGenericNavigation) {
        navigationState.value = UIONavigationState.Navigate(navigation)
    }

    companion object {
        fun newInstance() = SolarNavigator()
    }

}