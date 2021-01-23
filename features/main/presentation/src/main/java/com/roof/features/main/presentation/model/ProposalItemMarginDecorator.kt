package com.roof.features.main.presentation.model

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.roof.core.ui_kit.ext.dpToPx

class ProposalItemMarginDecorator(private val listSize: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            left = if (parent.getChildAdapterPosition(view) == 0) {
                dpToPx(16, view.context)
            } else {
                dpToPx(8, view.context)
            }
            if (parent.getChildAdapterPosition(view) == listSize - 1) {
                right = dpToPx(16, view.context)
            }
        }

    }
}