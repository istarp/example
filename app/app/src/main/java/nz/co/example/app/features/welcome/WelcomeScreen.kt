package nz.co.example.app.features.welcome

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import nz.co.example.app.features.navigation.AppNavController

@Composable
internal fun WelcomeScreen(
    modifier: Modifier = Modifier,
    navController: AppNavController,
    viewModel: WelcomeViewModel = viewModel()
) {
    Text("welcome")
}