package com.roof.core.network.di

import com.google.gson.GsonBuilder
import com.roof.core.network.impl.interceptors.RefreshTokenInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal val authServerModule = module {
    single(ServerQualifier.auth) {
        val tokenInterceptor = RefreshTokenInterceptor(tokenRepository = get())
        provideRetrofit(client = provideOkHttpClient(tokenInterceptor = tokenInterceptor))
    }
}

private const val TIMEOUT = 20L
private fun provideOkHttpClient(tokenInterceptor: RefreshTokenInterceptor): OkHttpClient {
    return with(OkHttpClient.Builder()) {
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        addInterceptor(tokenInterceptor)
        retryOnConnectionFailure(true)
        build()
    }
}

private fun provideRetrofit(client: OkHttpClient): Retrofit {
    val gsonFactory = GsonConverterFactory.create(GsonBuilder().create())
    return Retrofit.Builder()
        .baseUrl(BuildConfig.AUTH_SERVER_URL)
        .client(client)
        .addConverterFactory(gsonFactory)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
}