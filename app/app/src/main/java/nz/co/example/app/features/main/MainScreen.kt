package nz.co.example.app.features.main

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import nz.co.example.app.features.navigation.NavigationScreen
import nz.co.example.app.features.navigation.AppNavController
import nz.co.example.app.features.navigation.models.UIONavigationRoute

@Composable
internal fun MainScreen(
    modifier: Modifier = Modifier,
    startDestination: UIONavigationRoute,
    navController: AppNavController,
) {
    MainLayout(
        modifier = modifier,
        startDestination = startDestination,
        navController = navController
    )
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
private fun MainLayout(
    modifier: Modifier,
    startDestination: UIONavigationRoute,
    navController: AppNavController,
) {
    NavigationScreen(
        modifier = modifier,
        startDestination = startDestination,
        navController = navController,
    )

}