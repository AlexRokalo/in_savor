package com.roof.di.main.submodules.data.routers

import com.roof.di.main.submodules.data.appQualifier
import com.roof.features.profile.presentation.ui.IProfileRouter
import com.roof.navigation.activities.app.IAppRouter
import com.roof.navigation.routers.AppRouter
import com.roof.navigation.routers.profile.ProfileRouter
import org.koin.dsl.module

internal val dashboardRouters = module {

    single<IProfileRouter> { ProfileRouter(router = get(appQualifier)) }
    single<IAppRouter> { AppRouter(router = get(appQualifier)) }

}