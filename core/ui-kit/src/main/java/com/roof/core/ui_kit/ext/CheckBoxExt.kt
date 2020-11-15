package com.roof.core.ui_kit.ext

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.widget.CheckBox
import com.roof.core.ui_kit.utils.SpanClickHandler

fun CheckBox.setClickableText(
    clickableContent: String,
    handler: () -> Unit,
    drawUnderline: Boolean = false,
    colorText: Int = Color.BLUE
) {
    val text = this.text
    val start = text.indexOf(clickableContent)
    val end = start + clickableContent.length

    val span = SpannableString(text)
    span.setSpan(
        SpanClickHandler(handler, drawUnderline, colorText),
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    this.linksClickable = true
    this.isClickable = true
    this.movementMethod = LinkMovementMethod.getInstance()

    this.text = span
}
