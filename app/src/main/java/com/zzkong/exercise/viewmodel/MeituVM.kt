package com.zzkong.exercise.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.zzkong.exercise.di.PerViewModel
import com.zzkong.ktpro.bean.ImageListBean
import javax.inject.Inject



/**
 * Created by zzkong on 2017/11/15.
 */
@PerViewModel
class MeituVM : ViewModel(){

    var title = MutableLiveData<String>()
    var page = MutableLiveData<String>()

    lateinit var imageList : LiveData<ImageListBean>

    @Inject
    fun MeituVM(){
    }

}