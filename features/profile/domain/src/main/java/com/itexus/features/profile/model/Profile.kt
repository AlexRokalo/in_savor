package com.itexus.features.profile.model

data class Profile(
    val id: String,
    val firstName: String,
    val lastName: String,
    val status: Status,
    val avatar: String,
    val phone: String
) {

    enum class Status {
        PENDING,
        ACTIVE,
        BLOCKED
    }
}