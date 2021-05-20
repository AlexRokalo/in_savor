package com.roof.features.main.presentation.mapper

import com.roof.features.main.domain.model.restoran.kitchen_type.KitchenType
import com.roof.features.main.presentation.R

fun KitchenType.toStringRes(): Int {
    return when (this) {
        KitchenType.TRADITIONAL -> R.string.traditional_type
        KitchenType.AUTHOR -> R.string.author_type
        KitchenType.JAPAN -> R.string.japan_type
    }
}