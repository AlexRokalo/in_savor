package com.roof.features.main.presentation

import com.roof.features.main.domain.model.DailyProposal
import io.reactivex.rxjava3.core.Observable

class MainViewModel(override val proposals: Observable<List<DailyProposal>>) : BaseMainViewModel() {

}