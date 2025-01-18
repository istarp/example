package nz.co.example.app.features.tutorial

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
internal fun TutorialScreen(
    modifier: Modifier = Modifier,

    viewModel: TutorialViewModel = viewModel(),
) {

    Text("Tutorial")

}