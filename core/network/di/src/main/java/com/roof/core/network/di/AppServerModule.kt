package com.roof.core.network.di

import com.google.gson.GsonBuilder
import com.roof.core.network.domain.TokenAuthenticator
import com.roof.core.network.domain.formats.XA5_BACKEND_FORMAT
import com.roof.core.network.impl.interceptors.TokenInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

internal val appServerModule = module {
    single(ServerQualifier.app) {
        val tokenInterceptor = TokenInterceptor(tokenRepository = get())
        provideRetrofit(
            client = provideOkHttpClient(
                tokenInterceptor = tokenInterceptor,
                authenticator = get(),
                loggingInterceptor = provideLoggingInterceptor()
            )
        )
    }
}

private const val TIMEOUT = 20L
private fun provideOkHttpClient(
    tokenInterceptor: TokenInterceptor,
    authenticator: TokenAuthenticator,
    loggingInterceptor: Interceptor
): OkHttpClient {
    return with(OkHttpClient.Builder()) {
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
        addInterceptor(tokenInterceptor)
        authenticator(authenticator)
        addInterceptor(loggingInterceptor)
        build()
    }
}

private fun provideRetrofit(client: OkHttpClient): Retrofit {
    val gsonFactory = GsonConverterFactory.create(
        GsonBuilder()
            .setDateFormat(XA5_BACKEND_FORMAT)
            .create()
    )

    return Retrofit.Builder()
        .baseUrl(BuildConfig.APP_SERVER_URL)
        .client(client)
        .addConverterFactory(gsonFactory)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
}

private fun provideLoggingInterceptor(): Interceptor {
    val logger = object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Timber.d("OkHttp -> $message ")
        }

    }
    val interceptor = HttpLoggingInterceptor(logger)
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}