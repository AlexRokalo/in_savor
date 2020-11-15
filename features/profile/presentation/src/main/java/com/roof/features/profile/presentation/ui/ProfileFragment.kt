package com.roof.features.profile.presentation.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.roof.core.ui_kit.ext.load
import com.roof.features.dashboard.presentation.R
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment : Fragment() {

    private val viewModel by viewModel<BaseProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.profile.observe(viewLifecycleOwner, Observer { profile ->
            with(profile) {
                ivAvatar.load(avatar)
                tvProfileName.text = "$firstName $lastName"
            }
        })

        btnPersonalInfo.setOnClickListener {}

        btnChangePassword.setOnClickListener {}

        btnLogOut.setOnClickListener {
            AlertDialog.Builder(context)
                .setTitle(R.string.profile_log_out_dialog_title)
                .setMessage(R.string.msg_log_out_dialog)
                .setPositiveButton(android.R.string.yes)
                { dialog, which -> dialog.dismiss() }
                .setNegativeButton(android.R.string.no)
                { dialog, which -> dialog.dismiss() }
                .show()
        }

    }
}