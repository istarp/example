package nz.co.example.rickandmortymodule.features.characters

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import nz.co.example.rickandmortymodule.features.characters.business.models.Character

interface CharactersFeature {
    suspend fun getCharacters(): Flow<PagingData<Character>>
}