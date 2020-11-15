package com.roof.core.ui_kit.ext

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.widget.TextView
import com.roof.core.ui_kit.utils.SpanClickHandler
import io.github.inflationx.calligraphy3.CalligraphyTypefaceSpan
import io.github.inflationx.calligraphy3.TypefaceUtils


fun TextView.setClickableTextView(
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

fun TextView.setClickableCalligraphyTextView(
    clickableContent: String,
    handler: () -> Unit,
    drawUnderline: Boolean = false,
    colorText: Int = Color.BLUE,
    fontPath: String
) {
    val text = this.text
    val start = text.indexOf(clickableContent)
    val end = start + clickableContent.length

    val typefaceSpan =
        CalligraphyTypefaceSpan(
            TypefaceUtils.load(
                this.context.assets,
                fontPath
            )
        )
    val span = SpannableString(text)
    span.setSpan(
        typefaceSpan,
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
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

fun TextView.setSpannableTextView(
    content: String,
    spannable: Any
) {
    val text = this.text
    val start = text.indexOf(content)
    val end = start + content.length

    val span = SpannableString(text)
    span.setSpan(
        spannable,
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    this.text = span
}