package com.roof.navigation.routers

import com.roof.core.ui_kit.widget.BottomNavigationWidget.Companion.isBottomNavigationVisible
import com.roof.core.ui_kit.widget.ToolbarWidget.Companion.toolbarTitleRes
import com.roof.features.favorites.presentation.FavoritesFragment
import com.roof.features.profile.presentation.ui.ProfileFragment
import com.roof.navigation.activities.app.IAppRouter
import com.roof.navigation.utils.withArguments
import com.roof.payhammer.navigation.R
import com.roof.presentation.ui.FilterFragment
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

class AppRouter(private val router: Router) : IAppRouter {

    override fun navigateMainPage() {}

    override fun navigateFavoritesPage() {
        router.newRootScreen(object : SupportAppScreen() {
            override fun getFragment() = FavoritesFragment().withArguments {
                it.toolbarTitleRes = R.string.tab_favorites
                it.isBottomNavigationVisible = true
            }
        })
    }

    override fun navigateMapPage() {}

    override fun navigateProfilePage() {
        router.newRootScreen(object : SupportAppScreen() {
            override fun getFragment() = ProfileFragment().withArguments {
                it.toolbarTitleRes = R.string.toolbar_profile
                it.isBottomNavigationVisible = true
            }
        })
    }

    override fun navigateCategoryPage() {
        router.newRootScreen(object : SupportAppScreen() {
            override fun getFragment() = FilterFragment().withArguments {
                it.toolbarTitleRes = R.string.toolbar_filter
                it.isBottomNavigationVisible = true
            }
        })
    }

}