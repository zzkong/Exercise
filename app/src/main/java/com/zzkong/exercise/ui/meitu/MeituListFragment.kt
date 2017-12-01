package com.zzkong.exercise.ui.meitu

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.zzkong.exercise.R
import com.zzkong.exercise.base.BaseFragment
import com.zzkong.exercise.viewmodel.MeituVM
import kotlinx.android.synthetic.main.fragment_meitu_list.*
import javax.inject.Inject

/**
 * Created by zzkong on 2017/11/22.
 */
class MeituListFragment : BaseFragment(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var meituVm : MeituVM

    fun newInstance(title: String) : MeituListFragment{
        var meituListFragment = MeituListFragment()
        var bundle = Bundle()
        bundle.putString("keyword", title)
        meituListFragment.arguments = bundle
        return meituListFragment
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_meitu_list
    }

    override fun bindViewModel() {
        meituVm = ViewModelProviders.of(this, viewModelFactory)[MeituVM::class.java]
    }

    override fun initData() {
    }

    override fun lazyLoadData() {

    }

    fun setSmartRefresh(){
        smartrefresh.setOnRefreshListener {
            smartrefresh.finishRefresh(2000)
        }
    }
}