package com.itexus.core.network.domain.errors

data class TokenAuthenticatorException(
    override val message: String?,
    override val cause: Throwable?
) : Throwable(message, cause)