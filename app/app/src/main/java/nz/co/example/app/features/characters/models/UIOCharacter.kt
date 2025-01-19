package nz.co.example.app.features.characters.models

import nz.co.example.rickandmortymodule.features.characters.business.models.Character

internal data class UIOCharacter(val id: Int, val name: String, val isFavourite: Boolean) {

    companion object {
        fun forPreviewFavourite(): UIOCharacter {
            return UIOCharacter(id = 1, name = "Rick Sanchez", isFavourite = true)
        }

        fun forPreview(): UIOCharacter {
            return UIOCharacter(id = 1, name = "Rick Sanchez", isFavourite = false)
        }

        fun forPreviewList(): List<UIOCharacter> {
            return listOf(
                UIOCharacter(id = 1, name = "Rick Sanchez", isFavourite = true),
                UIOCharacter(id = 2, name = "Rick Sanchez 2", isFavourite = false),
                UIOCharacter(id = 3, name = "Rick Sanchez 3", isFavourite = true),
                UIOCharacter(id = 4, name = "Rick Sanchez 4", isFavourite = false),
                UIOCharacter(id = 5, name = "Rick Sanchez 5", isFavourite = false),
                UIOCharacter(id = 6, name = "Rick Sanchez 6", isFavourite = true)
            )
        }
    }
}

internal fun mapFrom(data: Character): UIOCharacter {
    return UIOCharacter(id = data.id, name = data.name, isFavourite = data.isFavourite)
}