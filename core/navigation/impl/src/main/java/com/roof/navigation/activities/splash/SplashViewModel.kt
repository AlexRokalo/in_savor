package com.roof.navigation.activities.splash

import io.reactivex.rxjava3.core.Completable

class SplashViewModel(private val router: ISplashRouter) : BaseSplashViewModel() {

    init {
        Completable.fromAction { router.navigateForward() }
            .subscribeByViewModel()
    }
}