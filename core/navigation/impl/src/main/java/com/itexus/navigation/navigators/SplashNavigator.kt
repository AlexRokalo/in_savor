package com.itexus.navigation.navigators

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.itexus.core.navigation.INavigator
import com.itexus.navigation.activities.splash.SplashActivity
import com.itexus.payhammer.navigation.R
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class SplashNavigator(private val navigatorHolder: NavigatorHolder) : INavigator<SplashActivity> {

    override fun attach(subject: SplashActivity) = with(subject) {
        lifecycle.addObserver(object : LifecycleObserver {

            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate() {
                val navigator = SupportAppNavigator(subject, R.id.nav_host_container)
                navigatorHolder.setNavigator(navigator)
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                navigatorHolder.removeNavigator()
            }
        })
    }
}