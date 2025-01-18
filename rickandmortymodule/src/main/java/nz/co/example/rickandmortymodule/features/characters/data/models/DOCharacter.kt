package nz.co.example.rickandmortymodule.features.characters.data.models

import kotlinx.serialization.Serializable
import nz.co.example.rickandmortymodule.features.characters.business.models.Character

@Serializable
internal data class DOCharacter(val id: String, val name: String, val image: String)

internal fun mapFrom(data: DOCharacter): Character {
    return Character(id = data.id, name = data.name, imageUrl = data.image)
}