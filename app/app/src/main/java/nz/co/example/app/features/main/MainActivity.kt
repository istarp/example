package nz.co.example.app.features.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import nz.co.example.app.features.navigation.SolarNavigator
import nz.co.example.app.features.navigation.SolarNavigatorProvider
import nz.co.example.app.features.navigation.models.UIOAppNavigation
import nz.co.example.app.features.navigation.rememberSolarNavController
import nz.co.example.app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent { Content() }
    }

    @Composable
    private fun Content() {
        val navigator: SolarNavigator = SolarNavigatorProvider().instance()
        val scope = rememberCoroutineScope()
        val mainNavController = rememberNavController()
        val navController = rememberSolarNavController(
            mainNavController = mainNavController,
            navigator = navigator,
            scope = scope
        )
        AppTheme {
            MainScreen(
                modifier = Modifier,
                navController = navController,
                startDestination = UIOAppNavigation.Welcome.route
            )
        }
    }

}