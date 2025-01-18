package nz.co.example.app.features.navigation.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import nz.co.example.app.R

data class TopLevelRoute(@StringRes val title: Int, val route: String, @DrawableRes val icon: Int)

val CharactersRoute =
    TopLevelRoute(
        title = R.string.nav_characters,
        route = AppNavigationRoute.Characters.route,
        icon = R.drawable.icon_characters
    )
val FavouritesRoute = TopLevelRoute(
    title = R.string.nav_favourites,
    route = AppNavigationRoute.Favourites.route,
    icon = R.drawable.icon_favourites
)

val topLevelRoutes = listOf(
    CharactersRoute, FavouritesRoute
)