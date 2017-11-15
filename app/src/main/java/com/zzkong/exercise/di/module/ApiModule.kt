package com.zzkong.exercise.di.module

import com.zzkong.exercise.api.MeituService
import com.zzkong.exercise.constants.ApiConstant
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by zzkong on 2017/11/15.
 */
@Module
class ApiModule{

    @Provides @Singleton
    fun provideMeituService(@Named("api")okHttpClient: OkHttpClient) : MeituService{
        var retrofit = Retrofit.Builder()
                .baseUrl(ApiConstant.MEITU_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var meituService = retrofit.create(MeituService::class.java)
        return meituService
    }
}