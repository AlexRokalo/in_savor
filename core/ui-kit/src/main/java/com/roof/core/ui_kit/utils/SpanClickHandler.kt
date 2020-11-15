package com.roof.core.ui_kit.utils

import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

class SpanClickHandler(
    private val handler: () -> Unit,
    private val drawUnderline: Boolean,
    private val colorText: Int
) : ClickableSpan() {

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.color = colorText
        if (!drawUnderline) ds.isUnderlineText = false
    }

    override fun onClick(p0: View) {
        handler()
    }
}