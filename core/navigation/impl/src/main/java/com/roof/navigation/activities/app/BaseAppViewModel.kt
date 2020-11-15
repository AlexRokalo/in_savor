package com.roof.navigation.activities.app

import com.roof.core.mvvm.rx.view_model.RxViewModel

abstract class BaseAppViewModel : RxViewModel() {

    /* TODO Rename */
    abstract fun onCategoryClick()
    abstract fun onGeneralListClick()
    abstract fun onFavoritesClick()
    abstract fun onProfileClick()
    abstract fun onMapsClick()
}
