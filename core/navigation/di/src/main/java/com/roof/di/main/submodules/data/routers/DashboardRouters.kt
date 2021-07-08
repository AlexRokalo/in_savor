package com.roof.di.main.submodules.data.routers

import com.roof.di.main.submodules.data.appQualifier
import com.roof.di.main.submodules.data.restoranDetailsQualifier
import com.roof.features.main.presentation.IMainRouter
import com.roof.features.profile.presentation.ui.IProfileRouter
import com.roof.navigation.activities.app.IAppRouter
import com.roof.navigation.activities.app.restoran_details.IRestoranDetailsRouter
import com.roof.navigation.routers.AppRouter
import com.roof.navigation.routers.RestoranDetailsRouter
import com.roof.navigation.routers.main_list.MainListRouter
import com.roof.navigation.routers.profile.ProfileRouter
import org.koin.dsl.module

internal val dashboardRouters = module {

    single<IRestoranDetailsRouter> { RestoranDetailsRouter(router = get(restoranDetailsQualifier)) }
    single<IMainRouter> { MainListRouter(router = get(appQualifier)) }

    single<IProfileRouter> { ProfileRouter(router = get(appQualifier)) }
    single<IAppRouter> { AppRouter(router = get(appQualifier)) }

}