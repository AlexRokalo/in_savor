package com.itexus.di.main.submodules.data

import com.itexus.navigation.activities.app.AppActivity
import com.itexus.navigation.activities.splash.SplashActivity
import org.koin.core.qualifier.named

internal val appQualifier = named(AppActivity::class.java.name)
internal val splashQualifier = named(SplashActivity::class.java.name)