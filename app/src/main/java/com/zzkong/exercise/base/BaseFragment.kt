package com.zzkong.exercise.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zzkong.exercise.di.Injectable

/**
 * Created by zzkong on 2017/11/22.
 */
abstract class BaseFragment : Fragment(), Injectable{
    val STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN"

    abstract fun getLayoutRes() : Int
    abstract fun bindViewModel()
    abstract fun initData()
    abstract fun lazyLoadData()

    protected lateinit var mActivity : Context
    var hasVisible : Boolean = false
    var hasPrepared : Boolean = false
    var hasFirstLoad : Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(getLayoutRes(), container, false)

        hasFirstLoad = true
        hasPrepared = true
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        initData()
        lazyLoadData()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden)
    }

    override fun onAttach(context: Context) {
        this.mActivity = context
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        try {
            val childFragmentManager = android.support.v4.app.Fragment::class.java.getDeclaredField("mChildFragmentManager")
            childFragmentManager.isAccessible = true
            childFragmentManager.set(this, null)
        } catch (e: NoSuchFieldException) {
            throw RuntimeException(e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException(e)
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (userVisibleHint){
            hasVisible = true
            onVisible()
        }else{
            hasVisible = false
            onInvisible()
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden){
            hasVisible = true
            onVisible()
        }else{
            hasVisible = false
            onInvisible()
        }
    }

    fun onVisible(){
        lazyLoad()
    }

    fun onInvisible(){}

    fun lazyLoad(){
        if (!hasPrepared || !isVisible || !hasFirstLoad) return
        hasFirstLoad = false
        lazyLoadData()
    }
}