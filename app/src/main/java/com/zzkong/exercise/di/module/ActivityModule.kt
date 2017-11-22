package com.zzkong.exercise.di.module

import com.zzkong.exercise.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by zzkong on 2017/11/15.
 */
@Module
abstract class ActivityModule{

    @ContributesAndroidInjector
    abstract fun mainActivity() : MainActivity
}