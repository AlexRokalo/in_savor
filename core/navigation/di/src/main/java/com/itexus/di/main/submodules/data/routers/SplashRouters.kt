package com.itexus.di.main.submodules.data.routers

import com.itexus.di.main.submodules.data.splashQualifier
import com.itexus.navigation.activities.splash.ISplashRouter
import com.itexus.navigation.routers.SplashRouter
import org.koin.dsl.module

internal val splashRouters = module {
    single<ISplashRouter> { SplashRouter(router = get(splashQualifier)) }
}