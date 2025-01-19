package nz.co.example.rickandmortymodule.features.database

import androidx.room.Database
import androidx.room.RoomDatabase
import nz.co.example.rickandmortymodule.features.characters.data.CharacterDao
import nz.co.example.rickandmortymodule.features.characters.data.CharacterRemoteKeysDao
import nz.co.example.rickandmortymodule.features.characters.data.models.DOCharacter
import nz.co.example.rickandmortymodule.features.characters.data.models.DOCharacterRemoteKeys

@Database(entities = [DOCharacter::class, DOCharacterRemoteKeys::class], version = 1, exportSchema = false)
internal abstract class Database : RoomDatabase() {
    abstract val charactersDao: CharacterDao
    abstract val charactersRemoteKeysDao: CharacterRemoteKeysDao
}