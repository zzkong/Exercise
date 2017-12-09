package com.zzkong.exercise.viewmodel

import android.arch.core.util.Function
import android.arch.lifecycle.*
import android.util.Log
import com.zzkong.exercise.repository.MeituRepository
import com.zzkong.ktpro.bean.ImageListBean
import javax.inject.Inject



/**
 * Created by zzkong on 2017/11/15.
 */
class MeituVM @Inject constructor(val repository: MeituRepository) : ViewModel(){

    var title = MutableLiveData<String>()
    var page = MutableLiveData<Int>()
    var imageList = MediatorLiveData<ImageListBean>()

    init {
        if (title.value != null) {
                imageList = Transformations.switchMap(title, Function<String, LiveData<ImageListBean>> {
                    repository.getImageList(title.value, page.value)
                }) as MediatorLiveData<ImageListBean>
        }


        //imageList = repository.getImageList(title.value, page.value)
    }

//    fun init(){
//        imageList = repository.getImageList(title.value, page.value)
//    }

    fun getImage() = imageList

    fun setTitleAndPage(title : String, page : Int){

        this.title.value = title
        this.page.value = page

        Log.e("zzkong", "请求了: " + this.title.value)
    }
}