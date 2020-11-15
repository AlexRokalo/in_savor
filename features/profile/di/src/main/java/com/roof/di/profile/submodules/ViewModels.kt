package com.roof.di.profile.submodules

import androidx.lifecycle.MutableLiveData
import com.roof.features.profile.model.Profile
import com.roof.features.profile.presentation.ui.BaseProfileViewModel
import com.roof.features.profile.presentation.ui.ProfileViewModel
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