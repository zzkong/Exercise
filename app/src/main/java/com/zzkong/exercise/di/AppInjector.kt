package com.zzkong.exercise.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.zzkong.exercise.EApp
import com.zzkong.exercise.di.component.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

/**
 * Created by lico on 2017/11/21.
 */
object AppInjector{

    fun init(eapp : EApp){
        DaggerAppComponent.builder().application(eapp)
                .build().inject(eapp)
        eapp
                .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle) {
                        handleActivity(activity)
                    }

                    override fun onActivityStarted(activity: Activity) {

                    }

                    override fun onActivityResumed(activity: Activity) {

                    }

                    override fun onActivityPaused(activity: Activity) {

                    }

                    override fun onActivityStopped(activity: Activity) {

                    }

                    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

                    }

                    override fun onActivityDestroyed(activity: Activity) {

                    }
                })
    }

    fun handleActivity(activity: Activity){
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity){
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks(){
                override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?, savedInstanceState: Bundle?) {
                    if (f is Injectable){
                        AndroidSupportInjection.inject(f)
                    }
                }
            }, true)
        }
    }
}