package com.zzkong.exercise.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by lico on 2017/11/15.
 */
abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector{

    @Inject
    lateinit var fragmentAndroidInjector : DispatchingAndroidInjector<Fragment>


    protected abstract fun getLayoutRes() : Int
    protected abstract fun create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutRes())
        create()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentAndroidInjector
    }


}