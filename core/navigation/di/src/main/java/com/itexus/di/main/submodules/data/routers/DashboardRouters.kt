package com.itexus.di.main.submodules.data.routers

import com.itexus.di.main.submodules.data.appQualifier
import com.itexus.navigation.activities.app.IAppRouter
import com.itexus.navigation.routers.AppRouter
import org.koin.dsl.module

internal val dashboardRouters = module {

    single<IAppRouter> { AppRouter(router = get(appQualifier)) }


}