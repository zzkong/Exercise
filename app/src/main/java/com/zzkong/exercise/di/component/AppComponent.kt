package com.zzkong.exercise.di.component

import android.app.Application
import com.zzkong.exercise.EApp
import com.zzkong.exercise.di.PerViewModel
import com.zzkong.exercise.di.module.ActivityModule
import com.zzkong.exercise.di.module.ApiModule
import com.zzkong.exercise.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by zzkong on 2017/11/15.
 */
@Singleton
@PerViewModel
@Component(modules = arrayOf(
        AppModule::class,
        ApiModule::class,
        AndroidInjectionModule::class,
        ActivityModule::class
))
interface AppComponent{

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent
    }

    fun inject(app : EApp)
}