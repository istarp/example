package nz.co.example.app.features.characterdetail.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import nz.co.example.app.features.characterdetail.CharacterDetailViewModel

val characterDetailModule = module {
    viewModelOf(::CharacterDetailViewModel)
}