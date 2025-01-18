package nz.co.example.rickandmortymodule.features.characters.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import nz.co.example.rickandmortymodule.features.characters.data.models.DOCharacter

internal class CharactersPagingSource(
    private val service: CharactersService
) : PagingSource<String, DOCharacter>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, DOCharacter> {
        return try {
            val key = params.key ?: CharactersService.BASE_URL
            val response = service.getList(key)
            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = response.info.next
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<String, DOCharacter>): String? {
        return null
    }

}