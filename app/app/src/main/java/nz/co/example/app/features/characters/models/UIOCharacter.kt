package nz.co.example.app.features.characters.models

import nz.co.example.rickandmortymodule.features.characters.business.models.Character

internal data class UIOCharacter(val id: String, val name: String) {

    companion object {
        fun forPreview(): List<UIOCharacter> {
            return listOf(
                UIOCharacter(id = "1", name = "Rick Sanchez"),
                UIOCharacter(id = "2", name = "Rick Sanchez 2"),
                UIOCharacter(id = "3", name = "Rick Sanchez 3"),
                UIOCharacter(id = "4", name = "Rick Sanchez 4"),
                UIOCharacter(id = "5", name = "Rick Sanchez 5"),
                UIOCharacter(id = "6", name = "Rick Sanchez 6")
            )
        }
    }
}

internal fun mapFrom(data: Character): UIOCharacter {
    return UIOCharacter(id = data.id, name = data.name)
}