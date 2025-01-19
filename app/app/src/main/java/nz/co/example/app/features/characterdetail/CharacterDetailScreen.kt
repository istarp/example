@file:OptIn(ExperimentalMaterial3Api::class)

package nz.co.example.app.features.characterdetail

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import nz.co.example.app.R
import nz.co.example.app.ui.components.charactercard.model.UIOCharacterCard
import nz.co.example.app.features.navigation.models.GenericNavigation
import nz.co.example.app.features.navigation.models.NavigationUp
import nz.co.example.app.ui.components.BackButton
import nz.co.example.app.ui.lce.LCEState
import nz.co.example.app.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
internal fun CharacterDetailScreen(
    modifier: Modifier = Modifier,
    characterId: String?,
    viewModel: CharacterDetailViewModel = koinViewModel(parameters = { parametersOf(characterId) }),
    onNavigate: (GenericNavigation) -> Unit
) {
    val data by viewModel.data.collectAsStateWithLifecycle()

    Box(modifier = modifier.fillMaxSize()) {
        Layout(data = data, onNavigate = onNavigate, onToggleFavourite = viewModel::onToggleFavourite)
    }
}

@Composable
private fun Layout(
    data: LCEState<UIOCharacterCard>,
    onNavigate: (GenericNavigation) -> Unit,
    onToggleFavourite: () -> Unit,
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
                    text = (data as? LCEState.Content)?.value?.name ?: "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }, navigationIcon = {
                BackButton(onClick = { onNavigate(NavigationUp) })
            },
            actions = {
                when (data) {
                    is LCEState.Content -> {
                        IconButton(modifier = modifier, onClick = { onToggleFavourite() }) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(R.drawable.ic_not_favourite),
                                contentDescription = stringResource(if (data.value.isFavourite) R.string.content_desc_set_as_not_favourite else R.string.content_desc_set_as_favourite),
                                tint = if (data.value.isFavourite) Color.Red else Color.Gray
                            )
                        }
                    }

                    is LCEState.Loading, is LCEState.Error -> {}
                }

            }
        )
        when (data) {
            is LCEState.Content -> Character(character = data.value)
            is LCEState.Error -> Error(modifier = Modifier.fillMaxSize())
            is LCEState.Loading -> Loading(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
private fun Character(character: UIOCharacterCard, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(character.name)
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
private fun Preview() {
    AppTheme {
        Surface {
            Layout(data = LCEState.Content(UIOCharacterCard.forPreview()), onToggleFavourite = {}, onNavigate = {})
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewFavourite() {
    AppTheme {
        Surface {
            Layout(data = LCEState.Content(UIOCharacterCard.forPreviewFavourite()), onToggleFavourite = {}, onNavigate = {})
        }
    }
}

