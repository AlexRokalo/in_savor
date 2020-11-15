package com.itexus.navigation.activities.app

class AppViewModel(private val router: IAppRouter) : BaseAppViewModel() {

    /* TODO Rename */
    override fun onGeneralListClick() = router.navigateGeneralList()
    override fun onCategoryClick() = router.navigateCategory()
    override fun onProfileClick() = router.navigateProfile()
    override fun onFilterClick() = router.navigateFilter()
}