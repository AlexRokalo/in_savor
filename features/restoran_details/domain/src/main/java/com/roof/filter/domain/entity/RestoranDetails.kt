package com.roof.filter.domain.entity

data class RestoranDetails(
    val id: String,
    val name: String,
    val mainPhoto: String,
    // TODO[FUNCTIONAL] ADD KITCHEN TYPE
    val kitchenType: String,
    val averageBill: String,
    val rate: Double,
    val like: Boolean,
    val dislike: Boolean,
    val photos: List<String>
)