package com.zzkong.exercise.di.module

import com.zzkong.exercise.ui.main.MeituFragment
import com.zzkong.exercise.ui.meitu.MeituListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by zzkong on 2017/12/6.
 */
@Module
abstract class FragmentModule{


    @ContributesAndroidInjector
    abstract fun meituFragment() : MeituFragment

    @ContributesAndroidInjector
    abstract fun meituListFragment() : MeituListFragment
}