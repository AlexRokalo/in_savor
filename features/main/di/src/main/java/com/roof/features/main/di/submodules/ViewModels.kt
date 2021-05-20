package com.roof.features.main.di.submodules

import com.roof.features.main.domain.model.DailyProposal
import com.roof.features.main.domain.model.restoran.Restoran
import com.roof.features.main.domain.model.restoran.kitchen_type.KitchenType
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

    val restorans = listOf(
        Restoran(
            id = "1",
            photo = "https://i.pinimg.com/originals/5b/fc/59/5bfc59fbb36f095e1f524ead563a8a36.jpg",
            title = "Друзья",
            kitchenType = KitchenType.TRADITIONAL,
            workTime = "с 12.00 - 23:00",
            isFavorite = false,
            rate = 4.9,
            distance = "2,5 км "
        ),
        Restoran(
            id = "2",
            photo = "https://i.pinimg.com/originals/5b/fc/59/5bfc59fbb36f095e1f524ead563a8a36.jpg",
            title = "The Dickens",
            kitchenType = KitchenType.AUTHOR,
            workTime = "с 12.00 - 23:00",
            isFavorite = false,
            rate = 5.0,
            distance = null
        ),
        Restoran(
            id = "3",
            photo = "https://i.pinimg.com/originals/5b/fc/59/5bfc59fbb36f095e1f524ead563a8a36.jpg",
            title = "Друзья",
            kitchenType = KitchenType.JAPAN,
            workTime = null,
            isFavorite = true,
            rate = 4.5,
            distance = "2,5 км "
        )
    )

    viewModel<BaseMainViewModel> {
        MainViewModel(
            proposals = Observable.just(proposals),
            restorans = Observable.just(restorans)
        )
    }
}