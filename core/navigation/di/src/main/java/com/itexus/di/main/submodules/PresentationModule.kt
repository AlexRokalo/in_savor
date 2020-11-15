package com.itexus.di.main.submodules

import com.itexus.navigation.activities.app.AppViewModel
import com.itexus.navigation.activities.app.BaseAppViewModel
import com.itexus.navigation.activities.splash.BaseSplashViewModel
import com.itexus.navigation.activities.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val presentationModule = module {
    viewModel<BaseAppViewModel> { AppViewModel(router = get()) }

    viewModel<BaseSplashViewModel> {
        SplashViewModel(router = get())
    }
}