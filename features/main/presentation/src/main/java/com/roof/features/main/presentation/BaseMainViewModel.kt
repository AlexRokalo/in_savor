package com.roof.features.main.presentation

import com.roof.core.mvvm.rx.view_model.RxViewModel
import com.roof.features.main.domain.model.DailyProposal
import com.roof.features.main.domain.model.restoran.Restoran
import io.reactivex.rxjava3.core.Observable

abstract class BaseMainViewModel : RxViewModel() {

    abstract val proposals: Observable<List<DailyProposal>>
    abstract val restorans: Observable<List<Restoran>>

}