package nz.co.example.rickandmortymodule.features.di

import nz.co.example.rickandmortymodule.RickAndMortyFacade
import nz.co.example.rickandmortymodule.features.characters.di.charactersModule
import nz.co.example.rickandmortymodule.features.database.di.databaseModule
import org.koin.dsl.module

val rickAndMortyModule = module {
    includes(charactersModule, databaseModule)
    factory { RickAndMortyFacade(get()) }
}