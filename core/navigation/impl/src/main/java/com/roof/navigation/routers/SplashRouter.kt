package com.roof.navigation.routers

import android.content.Context
import android.content.Intent
import com.roof.navigation.activities.app.AppActivity
import com.roof.navigation.activities.splash.ISplashRouter
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

class SplashRouter(
    private val router: Router
) : ISplashRouter {
    override fun navigateForward() {
        router.replaceScreen(object : SupportAppScreen() {
            override fun getActivityIntent(context: Context): Intent? {
                return Intent(context, AppActivity::class.java)
            }
        })
    }
}