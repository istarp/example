package nz.co.example.app.features.navigation

import nz.co.example.coremodule.common.InstanceProvider

internal class SolarNavigatorProvider : nz.co.example.coremodule.common.InstanceProvider<SolarNavigator> {

    companion object {
        private val instance: SolarNavigator by lazy { SolarNavigator.newInstance() }
    }

    override fun instance(): SolarNavigator = instance

}