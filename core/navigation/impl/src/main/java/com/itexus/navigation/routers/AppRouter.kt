package com.itexus.navigation.routers

import android.util.Log
import com.itexus.navigation.activities.app.IAppRouter
import ru.terrakok.cicerone.Router

class AppRouter(private val router: Router) : IAppRouter {

    override fun navigateGeneralList() {
        Log.e("General list", "clicks")
    }

    override fun navigateCategory() {}

    override fun navigateProfile() {}

    override fun navigateFilter() {}

}