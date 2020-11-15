package com.itexus.core.ui_kit.ext

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Picasso

fun ImageView.load(imgUrl: String?) {
    if (!imgUrl.isNullOrEmpty())
        Picasso.get()
            .load(imgUrl)
            .into(this)
}

fun ImageView.load(
    imgUrl: String?,
    @DrawableRes placeholder: Int
) {
    if (!imgUrl.isNullOrEmpty())
        Picasso.get()
            .load(imgUrl)
            .placeholder(placeholder)
            .into(this)
}
