package nz.co.example.rickandmortymodule.features.launch.business.models

sealed interface LaunchPage {
    data object Tutorial : LaunchPage
    data object Welcome : LaunchPage
    data object Dashboard : LaunchPage
}