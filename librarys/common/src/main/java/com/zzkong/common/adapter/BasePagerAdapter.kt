package com.zzkong.common.adapter


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.zzkong.common.utils.CommonUtil
import java.util.*

/**
 * Created by zzkong on 2017/11/22.
 */
class BasePagerAdapter : FragmentPagerAdapter {

    private var mFragmentList: List<Fragment> = ArrayList()
    private lateinit var mTitles: List<String>

    constructor(fm: FragmentManager, fragmentList: List<Fragment>) : super(fm) {
        this.mFragmentList = fragmentList
    }

    constructor(fm: FragmentManager, fragmentList: List<Fragment>, titles : ArrayList<String>) : super(fm) {
        this.mFragmentList = fragmentList
        this.mTitles = titles
    }

    override fun getPageTitle(position: Int): CharSequence {
        return if (!CommonUtil.isNullOrEmpty(mTitles)) mTitles.get(position) else ""
    }

    override fun getItem(position: Int): Fragment? {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }
}