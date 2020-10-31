package com.itexus.navigation.activities.app

import com.itexus.core.mvvm.rx.view_model.RxViewModel

abstract class BaseAppViewModel : RxViewModel() {

    /* TODO Rename */
    abstract fun onCategoryClick()
    abstract fun onGeneralListClick()
    abstract fun onFilterClick()
    abstract fun onProfileClick()
}
