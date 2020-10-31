package com.itexus.di.main.submodules.data

import com.itexus.core.navigation.INavigator
import com.itexus.navigation.activities.app.AppActivity
import com.itexus.navigation.activities.splash.SplashActivity
import com.itexus.navigation.navigators.AppNavigator
import com.itexus.navigation.navigators.SplashNavigator
import org.koin.dsl.module

internal val navigators = module {

    single<INavigator<AppActivity>>(appQualifier) {
        AppNavigator(navigatorHolder = get(appQualifier))
    }

    single<INavigator<SplashActivity>>(splashQualifier) {
        SplashNavigator(navigatorHolder = get(splashQualifier))
    }
}