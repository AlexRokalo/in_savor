package com.roof.restore_details.presentation

import com.roof.core.mvvm.rx.view_model.RxViewModel
import com.roof.filter.domain.entity.RestoranDetails
import io.reactivex.rxjava3.core.Observable

abstract class BaseRestoranDetailsViewModel : RxViewModel() {

    abstract val restoranDetails: Observable<RestoranDetails>

}