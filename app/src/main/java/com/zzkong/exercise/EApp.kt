package com.zzkong.exercise

import android.app.Activity
import android.app.Application
import com.zzkong.exercise.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by zzkong on 2017/11/15.
 */
class EApp : Application(), HasActivityInjector{

    @Inject
    lateinit var dispatchingAndroidInjector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

}