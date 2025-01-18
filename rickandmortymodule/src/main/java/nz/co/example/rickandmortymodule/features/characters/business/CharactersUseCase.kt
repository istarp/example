package nz.co.example.rickandmortymodule.features.characters.business

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import nz.co.example.coremodule.features.coroutinedispatchers.CoroutineDispatchersFeature
import nz.co.example.rickandmortymodule.features.characters.CharactersFeature
import nz.co.example.rickandmortymodule.features.characters.business.models.Character

internal class CharactersUseCase(
    private val repository: CharactersRepository,
    private val dispatchers: CoroutineDispatchersFeature
) : CharactersFeature {

    override suspend fun getCharacters(): Flow<PagingData<Character>> {
        return withContext(dispatchers.default()) {
            repository.getCharacters()
        }
    }

}