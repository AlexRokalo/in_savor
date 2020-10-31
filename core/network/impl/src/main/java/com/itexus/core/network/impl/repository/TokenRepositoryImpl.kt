package com.itexus.core.network.impl.repository

import com.chibatching.kotpref.KotprefModel
import com.itexus.core.network.domain.TokenRepository

class TokenRepositoryImpl : TokenRepository, KotprefModel() {
    override var authToken by nullableStringPref()
    override var refreshToken by nullableStringPref()

    override fun clean() {
        authToken = null
        refreshToken = null
    }
}