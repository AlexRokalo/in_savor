package com.itexus.di.main.submodules.data

import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router


internal val cicerone = module {

    //Main
    single(appQualifier) { Cicerone.create(Router()) }
    single(appQualifier) {
        val cicerone = get<Cicerone<Router>>(appQualifier)
        cicerone.router
    }
    single(appQualifier) {
        val cicerone = get<Cicerone<Router>>(appQualifier)
        cicerone.navigatorHolder
    }

    //Splash
    single(splashQualifier) { Cicerone.create(Router()) }
    single(splashQualifier) {
        val cicerone = get<Cicerone<Router>>(splashQualifier)
        cicerone.router
    }
    single(splashQualifier) {
        val cicerone = get<Cicerone<Router>>(splashQualifier)
        cicerone.navigatorHolder
    }

}