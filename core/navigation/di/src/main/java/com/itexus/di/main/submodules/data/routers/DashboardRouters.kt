package com.itexus.di.main.submodules.data.routers

import com.itexus.di.main.submodules.data.appQualifier
import com.itexus.features.profile.presentation.ui.IProfileRouter
import com.itexus.navigation.activities.app.IAppRouter
import com.itexus.navigation.routers.AppRouter
import com.itexus.navigation.routers.profile.ProfileRouter
import org.koin.dsl.module

internal val dashboardRouters = module {

    single<IProfileRouter> { ProfileRouter(router = get(appQualifier)) }
    single<IAppRouter> { AppRouter(router = get(appQualifier)) }

}