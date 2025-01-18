package nz.co.example.rickandmortymodule.features.characters.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import nz.co.example.rickandmortymodule.features.characters.business.CharactersRepository
import nz.co.example.rickandmortymodule.features.characters.business.models.Character
import nz.co.example.rickandmortymodule.features.characters.data.models.mapFrom

internal class CharactersRepositoryImpl(private val pagingSource: CharactersPagingSource) : CharactersRepository {

    override suspend fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(pageSize = 100),
            pagingSourceFactory = { pagingSource }
        ).flow.map { pagingData ->
            pagingData.map { page ->
                mapFrom(page)
            }
        }
    }

}