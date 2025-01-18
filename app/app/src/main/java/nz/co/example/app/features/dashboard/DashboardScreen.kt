package nz.co.example.app.features.dashboard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import nz.co.example.app.features.navigation.AppNavController

@Composable
internal fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: AppNavController,
    viewModel: DashboardViewModel = viewModel()
) {
    Text("dashboard")
}