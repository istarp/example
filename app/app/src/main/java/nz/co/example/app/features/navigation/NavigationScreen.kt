package nz.co.example.app.features.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import nz.co.example.app.features.characterdetail.CharacterDetailScreen
import nz.co.example.app.features.characters.CharactersScreen
import nz.co.example.app.features.favouritecharacters.FavouriteCharactersScreen
import nz.co.example.app.features.navigation.models.AppNavigationRoute
import nz.co.example.app.features.navigation.models.GenericNavigation
import nz.co.example.app.features.navigation.models.NavigationUp
import nz.co.example.app.features.navigation.models.RouteNavigation
import nz.co.example.app.features.navigation.models.topLevelRoutes

@Composable
internal fun NavigationScreen(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(
            AppNavigationRoute.Characters.route,
            exitTransition = exitTransition(),
            popEnterTransition = popEnterTransition()
        ) {
            CharactersScreen(
                modifier = modifier,
                onNavigate = { handleNavigation(it, navController) }
            )
        }
        composable(AppNavigationRoute.CharacterDetail().route,
            enterTransition = { slideInFromLeft() },
            exitTransition = { slideOutToRight() })
        { entry ->
            CharacterDetailScreen(
                modifier = modifier,
                characterId = AppNavigationRoute.CharacterDetail.getArg(entry),
                onNavigate = { handleNavigation(it, navController) })
        }
        composable(
            AppNavigationRoute.Favourites.route,
            exitTransition = exitTransition(),
            popEnterTransition = popEnterTransition()
        ) {
            FavouriteCharactersScreen(
                modifier = modifier
            )
        }
    }
}

private fun exitTransition(): AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition? =
    {
        if (topLevelRoutes.map { it.route }.contains(targetState.destination.route)) {
            fadeOut()
        } else {
            slideOutToLeft()
        }
    }

private fun popEnterTransition(): AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition? =
    {
        if (topLevelRoutes.map { it.route }.contains(initialState.destination.route)) {
            fadeIn()
        } else {
            slideInFromRight()
        }
    }

private fun handleNavigation(navigation: GenericNavigation, navController: NavHostController) {
    when (navigation) {
        NavigationUp -> navController.navigateUp()
        is RouteNavigation -> navController.navigate(navigation.value)
    }
}