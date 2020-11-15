package com.itexus.features.profile.presentation.ui

import androidx.lifecycle.LiveData
import com.itexus.features.profile.model.Profile

class ProfileViewModel(
    private val router: IProfileRouter,
    override val profile: LiveData<Profile>,
) : BaseProfileViewModel() {


    /* override fun clickLogOut() {
        logOutUseCase()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribeByViewModel { router.logOut() }
     }*/
}