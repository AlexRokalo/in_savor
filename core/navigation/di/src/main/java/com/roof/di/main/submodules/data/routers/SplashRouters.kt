package com.roof.di.main.submodules.data.routers

import com.roof.di.main.submodules.data.splashQualifier
import com.roof.navigation.activities.splash.ISplashRouter
import com.roof.navigation.routers.SplashRouter
import org.koin.dsl.module

internal val splashRouters = module {
    single<ISplashRouter> { SplashRouter(router = get(splashQualifier)) }
}