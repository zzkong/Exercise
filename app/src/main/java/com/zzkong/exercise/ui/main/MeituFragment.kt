package com.zzkong.exercise.ui.main

import android.support.v4.app.Fragment
import com.zzkong.common.adapter.BasePagerAdapter
import com.zzkong.exercise.R
import com.zzkong.exercise.base.BaseFragment
import com.zzkong.exercise.ui.meitu.MeituListFragment
import kotlinx.android.synthetic.main.fragment_meitu.*

/**
 * Created by zzkong on 2017/11/22.
 */
class MeituFragment : BaseFragment(){

    var mFragments = ArrayList<Fragment>()
    lateinit var mPagerAdapter : BasePagerAdapter


    override fun getLayoutRes(): Int {
        return R.layout.fragment_meitu
    }

    override fun initData() {
        var contentList : ArrayList<String> = arrayListOf<String>()
        val contents = resources.getStringArray(R.array.images_category_list)
        contentList.addAll(contents)
        contentList.forEach {
            mFragments.add(MeituListFragment().newInstance(it))
        }
        mPagerAdapter = BasePagerAdapter(childFragmentManager, mFragments, contentList)
        viewpager.adapter = mPagerAdapter
        tablayout.setupWithViewPager(viewpager)
    }

    override fun lazyLoadData() {
    }

}