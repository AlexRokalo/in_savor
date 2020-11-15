package com.itexus.di.profile.submodules

import androidx.lifecycle.MutableLiveData
import com.itexus.features.profile.model.Profile
import com.itexus.features.profile.presentation.ui.BaseProfileViewModel
import com.itexus.features.profile.presentation.ui.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModels = module {

    viewModel<BaseProfileViewModel> {
        ProfileViewModel(
            router = get(),
            profile = MutableLiveData(
                Profile(
                    "1",
                    "Alexey",
                    "Rokalo",
                    Profile.Status.ACTIVE,
                    "",
                    "+ 375 29 730 89 66"
                )
            ),
        )
    }
}