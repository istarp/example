package nz.co.example.app.features.characters

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import kotlinx.coroutines.flow.MutableStateFlow
import nz.co.example.app.R
import nz.co.example.app.features.characters.models.UIOCharacter
import nz.co.example.app.features.navigation.models.AppNavigationRoute
import nz.co.example.app.features.navigation.models.GenericNavigation
import nz.co.example.app.features.navigation.models.RouteNavigation
import nz.co.example.app.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun CharactersScreen(
    modifier: Modifier = Modifier,
    viewModel: CharactersViewModel = koinViewModel(),
    onNavigate: (GenericNavigation) -> Unit
) {
    val characters = viewModel.data.collectAsLazyPagingItems()

    Box(modifier = modifier.fillMaxSize()) {
        Characters(characters = characters, onNavigate = onNavigate)
    }
}

@Composable
private fun Characters(
    characters: LazyPagingItems<UIOCharacter>,
    onNavigate: (GenericNavigation) -> Unit,
    modifier: Modifier = Modifier
) = when (characters.loadState.refresh) {
    LoadState.Loading -> {
        Loading(modifier = Modifier.fillMaxSize())
    }

    is LoadState.Error -> {
        Error(modifier = Modifier.fillMaxSize())
    }

    else -> {
        LazyColumn(modifier = modifier) {
            items(count = characters.itemCount, key = characters.itemKey { it.id }) { index ->
                characters[index]?.let {
                    Text(
                        it.name,
                        modifier = Modifier.clickable {
                            onNavigate(
                                RouteNavigation(
                                    AppNavigationRoute.CharacterDetail.createRoute(it.id)
                                )
                            )
                        })
                }
            }
        }
    }
}

@Composable
private fun Loading(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(stringResource(R.string.loading_data), textAlign = TextAlign.Center)
    }
}

@Composable
private fun Error(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(stringResource(R.string.error), textAlign = TextAlign.Center)
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewData() {
    AppTheme {
        Surface {
            Characters(
                characters = MutableStateFlow(PagingData.from(UIOCharacter.forPreview())).collectAsLazyPagingItems(),
                onNavigate = {}
            )
        }
    }
}

