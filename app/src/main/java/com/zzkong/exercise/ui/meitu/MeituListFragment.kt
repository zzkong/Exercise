package com.zzkong.exercise.ui.meitu

import android.os.Bundle
import com.zzkong.exercise.R
import com.zzkong.exercise.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_meitu_list.*

/**
 * Created by zzkong on 2017/11/22.
 */
class MeituListFragment : BaseFragment(){

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