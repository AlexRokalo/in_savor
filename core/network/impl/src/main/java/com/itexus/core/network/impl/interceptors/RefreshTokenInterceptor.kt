package com.itexus.core.network.impl.interceptors

import com.itexus.core.network.domain.TokenRepository
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RefreshTokenInterceptor(private val tokenRepository: TokenRepository) : Interceptor {

    companion object {
        const val HEADER_NO_AUTHENTICATION = "No-Authentication"
    }

    private val token: String? get() = tokenRepository.refreshToken

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val noAuthHeader = request.header(HEADER_NO_AUTHENTICATION)
        if (noAuthHeader == null || noAuthHeader != "true") {
            token?.let { request = request.addAuthorizationHeader(it) }
        }
        request = request.removeCustomHeaders()

        return chain.proceed(request)
    }

    private fun Request.removeCustomHeaders(): Request {
        return newBuilder()
            .removeHeader(HEADER_NO_AUTHENTICATION)
            .build()
    }

    private fun Request.addAuthorizationHeader(token: String): Request {
        return this.newBuilder()
            .addHeader("X-Authorization", token)
            .build()
    }
}