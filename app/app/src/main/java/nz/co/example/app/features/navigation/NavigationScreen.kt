package nz.co.example.app.features.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import nz.co.example.app.features.dashboard.DashboardScreen
import nz.co.example.app.features.navigation.models.UIOAppNavigation
import nz.co.example.app.features.navigation.models.UIONavigationRoute
import nz.co.example.app.features.tutorial.TutorialScreen
import nz.co.example.app.features.welcome.WelcomeScreen

@Composable
internal fun NavigationScreen(
    modifier: Modifier,
    startDestination: UIONavigationRoute,
    navController: AppNavController
) {
    NavHost(
        navController.mainNavController,
        startDestination = startDestination.value,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        composable(UIOAppNavigation.Tutorial.route.value) {
            TutorialScreen(
                modifier = modifier,
                navController = navController
            )
        }
        composable(UIOAppNavigation.Welcome.route.value) {
            WelcomeScreen(
                modifier = modifier,
                navController = navController
            )
        }
        composable(UIOAppNavigation.Dashboard.route.value) {
            DashboardScreen(
                modifier = modifier,
                navController = navController
            )
        }
    }
}