package com.roof.navigation.routers

import com.roof.core.ui_kit.widget.BottomNavigationWidget.Companion.isBottomNavigationVisible
import com.roof.core.ui_kit.widget.ToolbarWidget.Companion.toolbarTitleRes
import com.roof.features.profile.presentation.ui.ProfileFragment
import com.roof.navigation.activities.app.IAppRouter
import com.roof.navigation.utils.withArguments
import com.roof.payhammer.navigation.R
import com.roof.presentation.ui.FilterFragment
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

    override fun navigateFilter() {
        router.newRootScreen(object : SupportAppScreen() {
            override fun getFragment() = FilterFragment().withArguments {
                it.toolbarTitleRes = R.string.toolbar_filter
                it.isBottomNavigationVisible = true
            }
        })
    }

}