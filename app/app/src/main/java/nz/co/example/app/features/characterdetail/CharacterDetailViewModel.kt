package nz.co.example.app.features.characterdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import nz.co.example.app.features.characters.models.UIOCharacter
import nz.co.example.app.features.characters.models.mapFrom
import nz.co.example.rickandmortymodule.RickAndMortyFacade

internal class CharacterDetailViewModel(private val rickAndMortyFacade: RickAndMortyFacade) : ViewModel() {


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