package nz.co.example.app.features.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import nz.co.example.app.features.navigation.BottomNavigation
import nz.co.example.app.features.navigation.NavigationScreen
import nz.co.example.app.features.navigation.models.CharactersRoute

@Composable
internal fun MainScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigation(
                currentDestination = currentDestination?.route,
                onItemClicked = {
                    navController.navigate(it) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    ) { innerPadding ->
        MainLayout(
            startDestination = CharactersRoute.route,
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun MainLayout(
    startDestination: String,
    navController: NavHostController,
    modifier: Modifier
) {
    NavigationScreen(
        startDestination = startDestination,
        navController = navController,
        modifier = modifier
    )
}