package com.zzkong.exercise.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.zzkong.exercise.repository.MeituRepository
import com.zzkong.ktpro.bean.ImageListBean
import javax.inject.Inject



/**
 * Created by zzkong on 2017/11/15.
 */
class MeituVM : ViewModel(){


    var title = MutableLiveData<String>()
    var page = MutableLiveData<String>()

    lateinit var imageList : LiveData<ImageListBean>

    @Inject
    fun MeituVM(repository: MeituRepository){
//        imageList = Transformations.switchMap(title, object : Function<String, LiveData<ImageListBean>>() {
//            fun apply(s: String): LiveData<ImageListBean> {
//                return repository.getImageList(title.value, page.value)
//            }
//        })
    }

}