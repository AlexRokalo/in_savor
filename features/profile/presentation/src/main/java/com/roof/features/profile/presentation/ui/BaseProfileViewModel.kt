package com.roof.features.profile.presentation.ui

import androidx.lifecycle.LiveData
import com.roof.core.mvvm.rx.view_model.RxViewModel
import com.roof.features.profile.model.Profile

abstract class BaseProfileViewModel : RxViewModel() {

    abstract val profile: LiveData<Profile>

}