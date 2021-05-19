package com.roof.features.main.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.roof.core.databinding.listAdapter
import com.roof.core.ui_kit.ext.load
import com.roof.core.ui_kit.utils.gone
import com.roof.core.ui_kit.utils.visible
import com.roof.features.main.presentation.databinding.FragmentMainBinding
import com.roof.features.main.presentation.databinding.ItemProposalBinding
import com.roof.features.main.presentation.databinding.ItemRestoranBinding
import com.roof.features.main.presentation.mapper.toStringRes
import com.roof.features.main.presentation.model.ProposalItemMarginDecorator
import com.roof.features.main.presentation.model.RestoranItemMarginDecorator
import com.roof.features.main.presentation.model.proposalDiffUtil
import com.roof.features.main.presentation.model.restoranDiffUtil
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel by viewModel<BaseMainViewModel>()

    /* Binding */
    private val binding by viewBinding(FragmentMainBinding::bind, R.id.parent)
    private lateinit var proposalBinding: ItemProposalBinding
    private lateinit var restoranBinding: ItemRestoranBinding

    /* Adapters */
    private val proposalAdapter =
        listAdapter(R.layout.item_proposal, proposalDiffUtil)
        { item, view, _ ->
            proposalBinding = ItemProposalBinding.bind(view)
            with(proposalBinding) {
                imgAvatar.load(item.image)
                tvTitle.text = item.title
            }
        }

    private val restoranAdapter =
        listAdapter(R.layout.item_restoran, restoranDiffUtil)
        { item, view, _ ->
            restoranBinding = ItemRestoranBinding.bind(view)

            with(restoranBinding) {
                imgRestoran.load(item.photo)
                with(includeItemRestoranInfo) {
                    tvRate.text = item.rate.toString()
                    tvName.text = item.title
                    tvKitchenType.text = getString(item.kitchenType.toStringRes())

                    item.workTime?.let {
                        tvWorkTime.text = item.workTime
                        imgHaveTime.visible()
                    } ?: imgHaveTime.gone()

                    item.distance?.let {
                        containerDirection.visible()
                        tvDirectionDistance.text = item.distance
                    } ?: containerDirection.gone()

                    chbFavorite.isChecked = item.isFavorite
                }

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

            rvRestaurants.adapter = restoranAdapter
            restorans.observeOn(AndroidSchedulers.mainThread())
                .subscribeByViewModel {
                    rvRestaurants.addItemDecoration(RestoranItemMarginDecorator(it.size))
                    restoranAdapter.submitList(it)
                }
        }
    }
}