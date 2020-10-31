package com.itexus.core.network.di

import com.itexus.core.network.domain.TokenRepository
import com.itexus.core.network.impl.repository.TokenRepositoryImpl
import org.koin.dsl.module


val networkModule = module { single<TokenRepository> { TokenRepositoryImpl() } } +
        authServerModule +
        appServerModule

