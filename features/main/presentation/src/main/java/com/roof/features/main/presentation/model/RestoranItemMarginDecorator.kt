package com.roof.features.main.presentation.model

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.roof.core.ui_kit.ext.dpToPx

class RestoranItemMarginDecorator(private val listSize: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0)
                return@with

            top = dpToPx(16, view.context)
            if (parent.getChildAdapterPosition(view) == listSize - 1) {
                bottom = dpToPx(16, view.context)
            }
        }

    }
}