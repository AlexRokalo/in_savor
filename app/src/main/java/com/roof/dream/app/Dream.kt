package com.roof.dream.app

import android.app.Application
import com.roof.dream.di.app
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class Dream : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            /*
            * We need to add logger Level
            * because it's koin problem, and it fix only in 2.2.0-beta-1, but it's unstable version
            * */
            androidLogger(Level.ERROR)
            androidContext(this@Dream)
            modules(app)
        }
    }

}