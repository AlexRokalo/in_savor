package com.itexus.core.network.domain

interface TokenRepository {
    var authToken: String?
    var refreshToken: String?

    fun clean()
}