package nz.co.example.app.features.favouritecharacters

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun FavouriteCharactersScreen(
    modifier: Modifier = Modifier,

    viewModel: FavouriteCharactersViewModel = koinViewModel()
) {
    Text("favourites")
}