package com.zzkong.exercise.api

import com.zzkong.ktpro.bean.ImageListBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by zzkong on 2017/11/15.
 */
interface MeituService{

    @GET("/data/imgs")
    abstract fun getImageList(@Query("col") col: String, @Query("tag") tag: String, @Query("pn") pn: Int, @Query("rn") rn: Int, @Query("from") from: Int): Call<ImageListBean>

}