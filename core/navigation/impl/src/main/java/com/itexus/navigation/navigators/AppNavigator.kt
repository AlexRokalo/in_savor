package com.itexus.navigation.navigators

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.itexus.core.navigation.INavigator
import com.itexus.navigation.activities.app.AppActivity
import com.itexus.payhammer.navigation.R
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class AppNavigator(private val navigatorHolder: NavigatorHolder) : INavigator<AppActivity> {

    override fun attach(subject: AppActivity) = with(subject) {
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