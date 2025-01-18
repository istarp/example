package nz.co.example.coremodule.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

interface CoroutineScopes {
    fun app(): CoroutineScope
    fun userSession(): CoroutineScope
    fun recreateUserSession()
}

internal class CoroutineScopesImpl : nz.co.example.coremodule.common.CoroutineScopes {
    override fun app(): CoroutineScope {
        return nz.co.example.coremodule.common.CoroutineScopesImpl.Companion.app
    }

    override fun userSession(): CoroutineScope {
        return nz.co.example.coremodule.common.CoroutineScopesImpl.Companion.userSession.value
    }

    override fun recreateUserSession() {
        nz.co.example.coremodule.common.CoroutineScopesImpl.Companion.userSession = lazy { nz.co.example.coremodule.common.CoroutineScopesImpl.Companion.createScope() }
    }

    private companion object {
        private val app: CoroutineScope by lazy { nz.co.example.coremodule.common.CoroutineScopesImpl.Companion.createScope() }
        private var userSession = lazy { nz.co.example.coremodule.common.CoroutineScopesImpl.Companion.createScope() }

        private fun createScope() = CoroutineScope(Dispatchers.IO + SupervisorJob())
    }
}

class CoroutineScopesProvider private constructor(private val scopes: nz.co.example.coremodule.common.CoroutineScopes = nz.co.example.coremodule.common.CoroutineScopesImpl()) :
    nz.co.example.coremodule.common.CoroutineScopes by scopes {
    companion object {
        fun getInstance() = nz.co.example.coremodule.common.CoroutineScopesProvider()
    }
}