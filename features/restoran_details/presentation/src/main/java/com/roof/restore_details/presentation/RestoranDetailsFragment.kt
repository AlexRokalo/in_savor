package com.roof.restore_details.presentation

import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RestoranDetailsFragment : Fragment(R.layout.fragment_restoran_details) {

    private val viewModel by viewModel<BaseRestoranDetailsViewModel>()


}