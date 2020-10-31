package com.itexus.core.ui_kit.widget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.itexus.core.ui_kit.R
import com.itexus.core.ui_kit.ext.onCurrentFragmentChanged
import com.itexus.core.ui_kit.utils.gone
import com.itexus.core.ui_kit.utils.visible
import kotlinx.android.synthetic.main.include_toolbar.view.*

class ToolbarWidget(
    private val fragmentActivity: FragmentActivity,
    private val onBackPressed: () -> Unit
) : Widget() {

    override fun build(parent: ViewGroup, lifecycleOwner: LifecycleOwner): View {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.include_toolbar, parent, false).also {
                it.toolbarBackButton.setOnClickListener { onBackPressed() }
                fragmentActivity.onCurrentFragmentChanged {
                    refreshToolbarUI(this, it)
                }
            }
    }

    private fun refreshToolbarUI(currentlyVisibleFragment: Fragment, view: View) {
        if (fragmentActivity.supportFragmentManager.backStackEntryCount > 0) view.toolbarBackButton.visible()
        else view.toolbarBackButton.gone()

        currentlyVisibleFragment.arguments?.toolbarTitleRes?.let {
            view.visible()
            view.toolbarTitle.text = view.context.getString(it)
        } ?: view.gone()
    }

    companion object {
        var Bundle.toolbarTitleRes: Int?
            get() {
                val value = this.getInt("toolbarTitleRes")
                return if (value == 0) null else value
            }
            set(value) = this.putInt("toolbarTitleRes", value ?: 0)
    }

}