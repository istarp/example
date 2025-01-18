package nz.co.example.app

import android.app.Application
import nz.co.example.coremodule.CoreFacade
import nz.co.example.rickandmortymodule.RickAndMortyFacade

@Suppress("unused")
class ExampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CoreFacade.init(this)
        RickAndMortyFacade.init()
    }

}