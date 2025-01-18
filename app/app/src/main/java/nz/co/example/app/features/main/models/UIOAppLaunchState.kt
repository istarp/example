package nz.co.example.app.features.main.models

internal sealed class UIOAppLaunchState {
    data object Loading : UIOAppLaunchState()
    data object Finished : UIOAppLaunchState()
}