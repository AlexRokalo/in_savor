package com.roof.core.network.di

import com.roof.core.network.domain.TokenRepository
import com.roof.core.network.impl.repository.TokenRepositoryImpl
import org.koin.dsl.module


val networkModule = module { single<TokenRepository> { TokenRepositoryImpl() } } +
        authServerModule +
        appServerModule

