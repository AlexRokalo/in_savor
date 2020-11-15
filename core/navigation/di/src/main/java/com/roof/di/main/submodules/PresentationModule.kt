package com.roof.di.main.submodules

import com.roof.navigation.activities.app.AppViewModel
import com.roof.navigation.activities.app.BaseAppViewModel
import com.roof.navigation.activities.splash.BaseSplashViewModel
import com.roof.navigation.activities.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val presentationModule = module {
    viewModel<BaseAppViewModel> { AppViewModel(router = get()) }

    viewModel<BaseSplashViewModel> {
        SplashViewModel(router = get())
    }
}