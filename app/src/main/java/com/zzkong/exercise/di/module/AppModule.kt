package com.zzkong.exercise.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by zzkong on 2017/11/15.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    @Named("api")
    fun provideApiOkHttpClient(): OkHttpClient {
        var builder = OkHttpClient.Builder()
        builder.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
        var logging = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.addInterceptor(logging)
        return builder.build()
    }

    @Provides @Singleton
    fun provideOkHttpClient(@Named("api") okHttpClient: OkHttpClient): OkHttpClient {
        var builder = okHttpClient.newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
        builder.interceptors().clear()
        return builder.build()
    }
}