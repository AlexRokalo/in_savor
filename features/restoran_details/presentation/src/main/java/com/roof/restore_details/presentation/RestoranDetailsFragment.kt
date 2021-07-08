package com.roof.restore_details.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.roof.core.ui_kit.ext.load
import com.roof.restore_details.presentation.adapters.InstaSliderAdapter
import com.roof.restore_details.presentation.databinding.FragmentRestoranDetailsBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.androidx.viewmodel.ext.android.viewModel

class RestoranDetailsFragment : Fragment(R.layout.fragment_restoran_details) {

    private val viewModel by viewModel<BaseRestoranDetailsViewModel>()
    private val viewBinding by viewBinding(FragmentRestoranDetailsBinding::bind, R.id.parent)

    private val sliderAdapter = InstaSliderAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindView()

    }

    private fun bindView() = with(viewBinding) {
        imageSlider.setSliderAdapter(sliderAdapter)

        with(viewModel) {
            restoranDetails.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeByViewModel { details ->

                    imgRestoranCard.load(details.mainPhoto)
                    with(includeRestoranItemMainInfo) {
                        tvTitle.text = details.name
                        tvPrice.text = details.averageBill
                        tvSubtitle.text = details.kitchenType
                        tvTimeAndPlace.text = ""
                    }

                    with(includeRateAction) {
                        imgbtnLike.isEnabled = details.like
                        imgbtnDislike.isEnabled = details.dislike
                        tvRating.text = details.rate.toString()
                    }

                    sliderAdapter.updateList(details.photos)

                }
        }
    }
}