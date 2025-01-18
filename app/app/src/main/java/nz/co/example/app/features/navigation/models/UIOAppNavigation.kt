package nz.co.example.app.features.navigation.models

internal sealed class UIOAppNavigation(open val route: UIONavigationRoute) {

    data object Tutorial : UIOAppNavigation(UIONavigationRoute("tutorial"))
    data object Welcome : UIOAppNavigation(UIONavigationRoute("welcome"))
    data object Dashboard : UIOAppNavigation(UIONavigationRoute("dashboard"))

}