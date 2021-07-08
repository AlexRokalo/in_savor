package com.roof.navigation.routers.main_list

import android.content.Context
import android.content.Intent
import com.roof.features.main.presentation.IMainRouter
import com.roof.navigation.activities.app.restoran_details.RestoranDetailsActivity
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

class MainListRouter(private val router: Router) : IMainRouter {

    override fun navigateRestoranDetails() {
        router.navigateTo(object : SupportAppScreen() {
            override fun getActivityIntent(context: Context): Intent {
                return Intent(context, RestoranDetailsActivity::class.java)
            }
        })
    }

}