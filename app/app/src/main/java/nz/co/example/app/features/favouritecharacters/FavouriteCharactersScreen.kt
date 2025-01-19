@file:OptIn(ExperimentalMaterial3Api::class)

package nz.co.example.app.features.favouritecharacters

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import nz.co.example.app.R
import nz.co.example.app.ui.components.charactercard.model.UIOCharacterCard
import nz.co.example.app.features.navigation.models.AppNavigationRoute
import nz.co.example.app.features.navigation.models.GenericNavigation
import nz.co.example.app.features.navigation.models.RouteNavigation
import nz.co.example.app.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun FavouriteCharactersScreen(
    modifier: Modifier = Modifier,
    onNavigate: (GenericNavigation) -> Unit,
    viewModel: FavouriteCharactersViewModel = koinViewModel()
) {
    val data by viewModel.data.collectAsStateWithLifecycle()

    Box(modifier = modifier.fillMaxSize()) {
        Layout(data = data, onNavigate = onNavigate)
    }
}

@Composable
private fun Layout(
    data: List<UIOCharacterCard>,
    onNavigate: (GenericNavigation) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        TopAppBar(
            modifier = Modifier,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                //      titleContentColor = SolarTheme.colors.backgroundPrimary,
                scrolledContainerColor = Color.Transparent
            ),
            expandedHeight = 44.dp,
            title = {
                Text(
                    text = stringResource(R.string.favourites_title),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        )
        if (data.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = stringResource(R.string.favourites_no_data)
                )
            }
        }
        LazyColumn(modifier = modifier) {
            items(data) {
                Text(it.name + it.isFavourite, modifier = Modifier.clickable {
                    onNavigate(RouteNavigation(AppNavigationRoute.CharacterDetail.createRoute(it.id.toString())))
                })
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    AppTheme {
        Surface {
            Layout(data = UIOCharacterCard.forPreviewList(), onNavigate = {})
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewWithoutData() {
    AppTheme {
        Surface {
            Layout(data = emptyList(), onNavigate = {})
        }
    }
}
