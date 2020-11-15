package com.roof.di.main.submodules.data

import com.roof.navigation.activities.app.AppActivity
import com.roof.navigation.activities.splash.SplashActivity
import org.koin.core.qualifier.named

internal val appQualifier = named(AppActivity::class.java.name)
internal val splashQualifier = named(SplashActivity::class.java.name)