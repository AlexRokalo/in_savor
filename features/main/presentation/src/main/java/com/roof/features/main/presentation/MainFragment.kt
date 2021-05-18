package com.roof.features.main.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.roof.core.databinding.listAdapter
import com.roof.core.ui_kit.ext.load
import com.roof.features.main.presentation.databinding.FragmentMainBinding
import com.roof.features.main.presentation.databinding.ItemProposalBinding
import com.roof.features.main.presentation.model.ProposalItemMarginDecorator
import com.roof.features.main.presentation.model.proposalDiffUtil
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel by viewModel<BaseMainViewModel>()

    /* Binding */
    private val binding by viewBinding(FragmentMainBinding::bind, R.id.parent)
    private lateinit var proposalBinding: ItemProposalBinding

    private val proposalAdapter =
        listAdapter(R.layout.item_proposal, proposalDiffUtil)
        { item, view, _ ->
            proposalBinding = ItemProposalBinding.bind(view)
            with(proposalBinding) {
                imgAvatar.load(item.image)
                tvTitle.text = item.title
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            rvProposal.adapter = proposalAdapter
            proposals
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeByViewModel {
                    rvProposal.addItemDecoration(ProposalItemMarginDecorator(it.size))
                    proposalAdapter.submitList(it)
                }
        }
    }
}