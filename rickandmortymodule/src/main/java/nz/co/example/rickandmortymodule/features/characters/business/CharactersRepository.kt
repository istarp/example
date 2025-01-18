package nz.co.example.rickandmortymodule.features.characters.business

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import nz.co.example.rickandmortymodule.features.characters.business.models.Character

internal interface CharactersRepository {
    suspend fun getCharacters(): Flow<PagingData<Character>>
}