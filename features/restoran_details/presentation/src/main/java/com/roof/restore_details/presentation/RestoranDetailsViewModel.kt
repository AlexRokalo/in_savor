package com.roof.restore_details.presentation

import com.roof.filter.domain.entity.RestoranDetails
import io.reactivex.rxjava3.core.Observable

class RestoranDetailsViewModel(override val restoranDetails: Observable<RestoranDetails>) :
    BaseRestoranDetailsViewModel() {
}