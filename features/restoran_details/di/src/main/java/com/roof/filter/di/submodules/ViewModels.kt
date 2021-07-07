package com.roof.filter.di.submodules

import com.roof.restore_details.presentation.BaseRestoranDetailsViewModel
import com.roof.restore_details.presentation.RestoranDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModels = module {

    viewModel<BaseRestoranDetailsViewModel> { RestoranDetailsViewModel() }
}