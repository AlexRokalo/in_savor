package com.roof.navigation.activities.app

class AppViewModel(private val router: IAppRouter) : BaseAppViewModel() {

    /* TODO Rename */
    override fun onGeneralListClick() = router.navigateMainPage()
    override fun onCategoryClick() = router.navigateCategoryPage()
    override fun onProfileClick() = router.navigateProfilePage()
    override fun onMapsClick() = router.navigateMapPage()
    override fun onFavoritesClick() = router.navigateFavoritesPage()
}