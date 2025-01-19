package nz.co.example.rickandmortymodule.features.characters.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import nz.co.example.rickandmortymodule.features.characters.business.models.Character

//TODO ideally should be another entity class so it is not mixed with Api Data Object
@Serializable
@Entity(tableName = "characters")
internal data class DOCharacter(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val image: String,
    val isFavourite: Boolean = false
)

internal fun mapFrom(data: DOCharacter): Character {
    return Character(
        id = data.id,
        name = data.name,
        imageUrl = data.image,
        status = data.status,
        isFavourite = data.isFavourite
    )
}