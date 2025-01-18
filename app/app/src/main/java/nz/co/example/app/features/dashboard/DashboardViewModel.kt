package nz.co.example.app.features.dashboard

import android.view.View
import androidx.lifecycle.ViewModel

internal class DashboardViewModel : ViewModel() {

//    val data: LiveData<LCEState<Unit>> get() = _data
//    private val _data = MutableLiveData<LCEState<Unit>>(LCEState.Loading())

//    init {
//        performLaunch()
//    }
//
//    private fun performLaunch() {
//        viewModelScope.launchSafely(launchExceptionHandler()) {
//            _data.value = LCEState.Loading()
//            launchFeature.performLaunch()
//            val boData = launchFeature.getLaunchPage()
//            emitShowNavBarEventsIfFlightsPage(boData)
//            recordLaunchFinished()
//            navigateToLaunchPage(boData)
//        }
//    }
//
//    private fun launchExceptionHandler() = viewModelExceptionHandler(
//        viewModelScope,
//        fullScreenErrorHandler = fullScreenErrorHandler()
//    )
//
//    private fun recordLaunchFinished() {
//        scopes.app().launchSafely {
//            launchFeature.recordLaunchFinished()
//        }
//    }
//
//    private fun emitShowNavBarEventsIfFlightsPage(boData: LaunchPage) {
//        when (boData) {
//            LaunchPage.Flights -> navBarEvents.emitShow()
//            LaunchPage.Tutorial, LaunchPage.Welcome -> {
//                //do nothing
//            }
//        }
//    }
//
//    private suspend fun navigateToLaunchPage(boData: LaunchPage) {
//        transitionController.overrideForNextTransition(UIOTransitionType.NONE)
//        navigationEvents.emit(
//            UIONavigationRoute(
//                UIOLaunchPage.toUIO(boData).navigation.route.value,
//                UIONavArgs(NavOperation.PopAll)
//            )
//        )
//    }
//
//    private fun fullScreenErrorHandler() = FullScreenErrorHandler {
//        _data.value = LCEState.Error(it) { performLaunch() }
//        viewModelScope.launchSafely {
//            launchFeature.recordLaunchFinished()
//        }
//    }
//
//    fun onLongPress() {
//        viewModelScope.launchSafely {
//            navigationEvents.emit(UIOInAppNavigation.DevSettings.route)
//        }
//    }
}