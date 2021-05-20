package com.roof.features.main.presentation.model

import androidx.recyclerview.widget.DiffUtil
import com.roof.features.main.domain.model.DailyProposal
import com.roof.features.main.domain.model.restoran.Restoran


internal val proposalDiffUtil = object : DiffUtil.ItemCallback<DailyProposal>() {
    override fun areItemsTheSame(oldItem: DailyProposal, newItem: DailyProposal): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(
        oldItem: DailyProposal,
        newItem: DailyProposal
    ): Boolean = oldItem == newItem

}


internal val restoranDiffUtil = object : DiffUtil.ItemCallback<Restoran>() {
    override fun areItemsTheSame(oldItem: Restoran, newItem: Restoran): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(
        oldItem: Restoran,
        newItem: Restoran
    ): Boolean = oldItem.id == newItem.id

}