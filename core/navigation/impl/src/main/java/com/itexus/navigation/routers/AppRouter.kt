package com.itexus.navigation.routers

import com.itexus.core.ui_kit.widget.BottomNavigationWidget.Companion.isBottomNavigationVisible
import com.itexus.core.ui_kit.widget.ToolbarWidget.Companion.toolbarTitleRes
import com.itexus.features.profile.presentation.ui.ProfileFragment
import com.itexus.navigation.activities.app.IAppRouter
import com.itexus.navigation.utils.withArguments
import com.itexus.payhammer.navigation.R
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

class AppRouter(private val router: Router) : IAppRouter {

    override fun navigateGeneralList() {
    }

    override fun navigateCategory() {}

    override fun navigateProfile() {
        router.newRootScreen(object : SupportAppScreen() {
            override fun getFragment() = ProfileFragment().withArguments {
                it.toolbarTitleRes = R.string.toolbar_profile
                it.isBottomNavigationVisible = true
            }
        })
    }

    override fun navigateFilter() {}

}