package nz.co.example.rickandmortymodule.features.characters.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import nz.co.example.rickandmortymodule.features.characters.data.models.DOCharactersResponse

internal interface CharactersService {
    suspend fun getList(url: String): DOCharactersResponse

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/character"
    }
}

internal class CharactersServiceImpl(
    private val client: HttpClient
) : CharactersService {

    override suspend fun getList(url: String): DOCharactersResponse {
        return client.get(url).body()
    }


}