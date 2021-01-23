package com.roof.features.main.presentation.model

import androidx.recyclerview.widget.DiffUtil
import com.roof.features.main.domain.model.DailyProposal


internal val proposalDiffUtil = object : DiffUtil.ItemCallback<DailyProposal>() {
    override fun areItemsTheSame(oldItem: DailyProposal, newItem: DailyProposal): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(
        oldItem: DailyProposal,
        newItem: DailyProposal
    ): Boolean = oldItem == newItem

}