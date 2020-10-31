package com.itexus.navigation.activities.splash

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import java.util.concurrent.TimeUnit

class SplashViewModel(private val router: ISplashRouter) : BaseSplashViewModel() {

    init {
        Completable.complete()
            .observeOn(AndroidSchedulers.mainThread())
            .delaySubscription(2, TimeUnit.SECONDS)
            .subscribeByViewModel { router.navigateForward() }
    }
}