package com.zzkong.exercise.repository

import android.arch.lifecycle.MediatorLiveData
import android.util.Log
import com.zzkong.exercise.api.MeituService
import com.zzkong.ktpro.bean.ImageListBean
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by zzkong on 2017/11/30.
 */

class MeituRepository @Inject constructor(val meituService: MeituService){

    fun getImageList(title : String?, page : Int?) : MediatorLiveData<ImageListBean> {
        val mImageList = MediatorLiveData<ImageListBean>()
        Log.e("zzkong", "请求了: " + title)
        meituService.getImageList(title!!, "全部", page!! * 20, 20, 1).enqueue(object : Callback<ImageListBean> {
            override fun onResponse(call: Call<ImageListBean>, response: Response<ImageListBean>) {
                Log.e("zzkong", "成功了: " + response.body())
                mImageList.setValue(response.body())
            }

            override fun onFailure(call: Call<ImageListBean>, t: Throwable) {
                Log.e("zzkong", "失败了: " + t.message)
            }
        })
        return mImageList
    }
}