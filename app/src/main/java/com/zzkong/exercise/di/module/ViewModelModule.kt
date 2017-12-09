package com.zzkong.exercise.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.zzkong.exercise.di.ViewModelKey
import com.zzkong.exercise.viewmodel.MeituVM
import com.zzkong.exercise.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by zzkong on 2017/11/30.
 */
@Module
abstract class ViewModelModule{

    @Binds
    @IntoMap
    @ViewModelKey(MeituVM::class)
    abstract fun bindMeituVM(mewituVm : MeituVM) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory) : ViewModelProvider.Factory
}