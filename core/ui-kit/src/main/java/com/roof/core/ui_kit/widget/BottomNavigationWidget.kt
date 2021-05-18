package com.roof.core.ui_kit.widget

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.annotation.MenuRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode.LABEL_VISIBILITY_LABELED
import com.roof.core.ui_kit.R
import com.roof.core.ui_kit.ext.onCurrentFragmentChanged
import com.roof.core.ui_kit.utils.gone
import com.roof.core.ui_kit.utils.visible

class BottomNavigationWidget(
    private val fragmentActivity: FragmentActivity,
    @MenuRes private val menuRes: Int,
    private val listener: BottomNavigationView.OnNavigationItemSelectedListener
) : Widget() {

    override fun build(parent: ViewGroup, lifecycleOwner: LifecycleOwner): View {
        return BottomNavigationView(parent.context).also {
            it.layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getHeight())

            configureNavigationUI(it)
        }
    }

    private fun getHeight(): Int {
        val tv = TypedValue()

        return if (fragmentActivity.theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)
        ) {
            TypedValue.complexToDimensionPixelSize(
                tv.data,
                fragmentActivity.resources.displayMetrics
            )
        } else {
            ViewGroup.LayoutParams.WRAP_CONTENT
        }

    }

    private fun configureNavigationUI(
        bottomNavigation: BottomNavigationView
    ) = with(bottomNavigation) {
        inflateMenu(menuRes)
        setOnNavigationItemSelectedListener(listener)
        labelVisibilityMode = LABEL_VISIBILITY_LABELED
        setBackgroundColor(ContextCompat.getColor(context, R.color.main_background))
        with(resources.getColorStateList(R.color.bottom_navigation_item_selector, null)) {
            itemIconTintList = this
            itemTextColor = this
        }

        fragmentActivity.onCurrentFragmentChanged {
            arguments?.isBottomNavigationVisible?.let { isVisible ->
                if (isVisible) visible()
                else gone()
            } ?: gone()
        }
    }

    companion object {
        var Bundle.isBottomNavigationVisible: Boolean
            get() = this.getBoolean("isBottomNavigationVisible")
            set(value) = this.putBoolean("isBottomNavigationVisible", value)
    }

}