package nz.co.example.rickandmortymodule.features.authentication

import nz.co.example.rickandmortymodule.features.authentication.business.LoginUseCase
import nz.co.example.rickandmortymodule.features.authentication.business.LogoutUseCase

interface LoginFeature {
    suspend fun login(username: String, password: String)
}

interface LogoutFeature {
    suspend fun logout()
}

class AuthenticationFacade private constructor(
    private val loginFeature: LoginFeature = LoginUseCase(),
    private val logoutFeature: LogoutFeature = LogoutUseCase(),
) : LoginFeature by loginFeature, LogoutFeature by logoutFeature {

    companion object {
        fun newInstance() = AuthenticationFacade()
    }

}