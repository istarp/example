package nz.co.example.rickandmortymodule.features.di

import nz.co.example.rickandmortymodule.RickAndMortyFacade
import nz.co.example.rickandmortymodule.features.characters.di.charactersModule
import org.koin.dsl.module

val rickAndMortyModule = module {
    includes(charactersModule)
    factory { RickAndMortyFacade(get()) }
}