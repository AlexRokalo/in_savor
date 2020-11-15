package com.itexus.features.profile.presentation.ui

import androidx.lifecycle.LiveData
import com.itexus.core.mvvm.rx.view_model.RxViewModel
import com.itexus.features.profile.model.Profile

abstract class BaseProfileViewModel : RxViewModel() {

    abstract val profile: LiveData<Profile>

}