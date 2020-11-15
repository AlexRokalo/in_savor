package com.roof.navigation.activities.app

class AppViewModel(private val router: IAppRouter) : BaseAppViewModel() {

    /* TODO Rename */
    override fun onGeneralListClick() = router.navigateMainPage()
    override fun onCategoryClick() = router.navigateFavoritesPage()
    override fun onProfileClick() = router.navigateProfilePage()
    override fun onFilterClick() = router.navigateCategoryPage()
}