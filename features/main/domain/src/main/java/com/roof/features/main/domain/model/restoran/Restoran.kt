package com.roof.features.main.domain.model.restoran

import com.roof.features.main.domain.model.restoran.kitchen_type.KitchenType

data class Restoran(
    val id: String,
    val photo: String,
    val title: String,
    val kitchenType: KitchenType,
    val workTime: String?,
    val isFavorite: Boolean,
    val rate: Double,
    val distance: String?
)