package nz.co.example.rickandmortymodule

import nz.co.example.rickandmortymodule.features.authentication.AuthenticationFacade
import nz.co.example.rickandmortymodule.features.launch.LaunchFacade

interface RickAndMortyFacade {

    companion object {
        fun init() {

        }

        val launch: LaunchFacade by lazy { LaunchFacade.newInstance() }

        val authentication: AuthenticationFacade by lazy { AuthenticationFacade.newInstance() }
    }

}