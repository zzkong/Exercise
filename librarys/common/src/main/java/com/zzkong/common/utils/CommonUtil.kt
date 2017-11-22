package com.zzkong.common.utils

/**
 * Created by zzkong on 2017/11/22.
 */
object CommonUtil{

    /**
     * 判断集合是否为null或者0个元素
     *
     * @param c
     * @return
     */
    fun isNullOrEmpty(c: Collection<*>?): Boolean {
        return if (null == c || c.isEmpty()) {
            true
        } else false
    }
}