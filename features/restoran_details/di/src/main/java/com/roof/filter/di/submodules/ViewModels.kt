package com.roof.filter.di.submodules

import com.roof.filter.domain.entity.RestoranDetails
import com.roof.restore_details.presentation.BaseRestoranDetailsViewModel
import com.roof.restore_details.presentation.RestoranDetailsViewModel
import io.reactivex.rxjava3.core.Observable
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModels = module {

    viewModel<BaseRestoranDetailsViewModel> {
        RestoranDetailsViewModel(
            restoranDetails = Observable.just(
                RestoranDetails(
                    id = "1",
                    name = "Test",
                    mainPhoto = "https://i.pinimg.com/originals/5b/fc/59/5bfc59fbb36f095e1f524ead563a8a36.jpg",
                    kitchenType = "test",
                    averageBill = "37 - 84 BYN",
                    rate = 4.9,
                    like = true,
                    dislike = false,
                    photos = listOf(
                        "https://i.pinimg.com/originals/5b/fc/59/5bfc59fbb36f095e1f524ead563a8a36.jpg",
                        "https://i.pinimg.com/originals/5b/fc/59/5bfc59fbb36f095e1f524ead563a8a36.jpg",
                        "https://i.pinimg.com/originals/5b/fc/59/5bfc59fbb36f095e1f524ead563a8a36.jpg"
                    )
                )
            )
        )
    }
}