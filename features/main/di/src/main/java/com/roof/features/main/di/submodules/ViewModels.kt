package com.roof.features.main.di.submodules

import com.roof.features.main.domain.model.DailyProposal
import com.roof.features.main.presentation.BaseMainViewModel
import com.roof.features.main.presentation.MainViewModel
import io.reactivex.rxjava3.core.Observable
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModels = module {

    val proposals = listOf(
        DailyProposal(
            "https://colorscheme.ru/img/color-harmony-pastels/5/2.png",
            "Вечеринки"
        ),
        DailyProposal(
            "https://colorscheme.ru/img/color-harmony-pastels/5/2.png",
            "Смех"
        ),
        DailyProposal(
            "https://colorscheme.ru/img/color-harmony-pastels/5/2.png",
            "Инста"
        ),
        DailyProposal(
            "https://colorscheme.ru/img/color-harmony-pastels/5/2.png",
            "Твой пряник"
        ),
        DailyProposal(
            "https://colorscheme.ru/img/color-harmony-pastels/5/2.png",
            "Жопки"
        )
    )

    viewModel<BaseMainViewModel> {
        MainViewModel(proposals = Observable.just(proposals))
    }
}