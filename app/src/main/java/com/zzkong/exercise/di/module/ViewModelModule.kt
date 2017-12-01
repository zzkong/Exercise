package com.zzkong.exercise.di.module

import android.arch.lifecycle.ViewModelProvider
import com.zzkong.exercise.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by zzkong on 2017/11/30.
 */
@Module
abstract class ViewModelModule{


    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory) : ViewModelProvider.Factory
}