package com.roof.di.main.submodules.data

import com.roof.core.navigation.INavigator
import com.roof.navigation.activities.app.AppActivity
import com.roof.navigation.activities.splash.SplashActivity
import com.roof.navigation.navigators.AppNavigator
import com.roof.navigation.navigators.SplashNavigator
import org.koin.dsl.module

internal val navigators = module {

    single<INavigator<AppActivity>>(appQualifier) {
        AppNavigator(navigatorHolder = get(appQualifier))
    }

    single<INavigator<SplashActivity>>(splashQualifier) {
        SplashNavigator(navigatorHolder = get(splashQualifier))
    }
}