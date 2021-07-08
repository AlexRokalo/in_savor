package com.roof.navigation.routers

import com.roof.navigation.activities.app.restoran_details.IRestoranDetailsRouter
import com.roof.restore_details.presentation.RestoranDetailsFragment
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

class RestoranDetailsRouter(private val router: Router) : IRestoranDetailsRouter {

    override fun navigateToRestoranDetails() {
        router.newRootScreen(object : SupportAppScreen() {
            override fun getFragment() = RestoranDetailsFragment()
        })
    }

}