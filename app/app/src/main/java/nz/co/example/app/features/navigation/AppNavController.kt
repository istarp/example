package nz.co.example.app.features.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.CoroutineScope
import nz.co.example.app.features.navigation.models.UIONavArgs
import nz.co.example.app.features.navigation.models.UIONavOperation
import nz.co.example.app.features.navigation.models.UIONavigationRoute
import nz.co.example.app.features.navigation.models.UIONavigationState
import nz.co.example.coremodule.extensions.launchSafely

internal class AppNavController(
    val mainNavController: NavHostController,
    private val navigator: SolarNavigator,
    scope: CoroutineScope
) {

    init {
        scope.launchSafely {
            navigator.navigationState.collect {
                when (it) {
                    UIONavigationState.Idle -> {}
                    is UIONavigationState.Navigate -> navigate(it)
                }
            }
        }
    }

    private fun navigate(navigate: UIONavigationState.Navigate) {
        when (navigate.action) {
            is UIONavigationRoute -> navigateToRoute(navigate.action)
        }
    }

    private fun navigateToRoute(route: UIONavigationRoute) {
        mainNavController.navigate(route.value) { handleNavArgs(route.navArgs) }
        navigationHandled()
    }

    private fun navigationHandled() {
        navigator.onNavigated(UIONavigationState.Idle)
    }

}

private fun NavOptionsBuilder.handleNavArgs(navArgs: UIONavArgs? = null) {
    when (val operation = navArgs?.operation) {
        is UIONavOperation.PopAll -> popUpTo(0)
        is UIONavOperation.PopTo -> popUpTo(operation.route.value) {
            inclusive = operation.inclusive
        }

        null -> Unit
    }
}

@Composable
internal fun rememberSolarNavController(
    mainNavController: NavHostController,
    navigator: SolarNavigator,
    scope: CoroutineScope
): AppNavController {
    val context = LocalContext.current
    return remember(mainNavController) {
        AppNavController(
            mainNavController = mainNavController,
            navigator = navigator,
            scope = scope
        )
    }
}