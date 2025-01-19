package nz.co.example.rickandmortymodule.features.characters.business

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import nz.co.example.coremodule.common.Result
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

    override suspend fun getFavouriteCharacters(): Flow<List<Character>> {
        return withContext(dispatchers.default()) {
            repository.getFavouriteCharacters()
        }
    }

    override suspend fun getCharacter(id: String): Flow<Result<Character>> {
        return withContext(dispatchers.default()) {
            repository.getCharacter(id)
        }
    }

    override suspend fun searchCharacters(name: String): Flow<PagingData<Character>> {
        return withContext(dispatchers.default()) {
            repository.getCharacters(name)
        }
    }

    override suspend fun setFavouriteCharacter(id: String, isFavourite: Boolean) {
        return withContext(dispatchers.default()) {
            repository.updateCharacter(id, isFavourite)
        }
    }
}