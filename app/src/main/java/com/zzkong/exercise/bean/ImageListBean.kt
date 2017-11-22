package com.zzkong.ktpro.bean

import android.os.Parcel
import android.os.Parcelable



/**
 * Created by zzkong on 2017/10/12.
 */
class ImageListBean : Parcelable {
    lateinit var col: String
    lateinit var tag: String
    lateinit var tag3: String
    lateinit var sort: String
    var totalNum: Int = 0
    var startIndex: Int = 0
    var returnNumber: Int = 0
    lateinit var imgs: List<ImageBean>


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.col)
        dest.writeString(this.tag)
        dest.writeString(this.tag3)
        dest.writeString(this.sort)
        dest.writeInt(this.totalNum)
        dest.writeInt(this.startIndex)
        dest.writeInt(this.returnNumber)
        dest.writeTypedList(this.imgs)
    }

    constructor() {}

    protected constructor(`in`: Parcel) {
        this.col = `in`.readString()
        this.tag = `in`.readString()
        this.tag3 = `in`.readString()
        this.sort = `in`.readString()
        this.totalNum = `in`.readInt()
        this.startIndex = `in`.readInt()
        this.returnNumber = `in`.readInt()
        this.imgs = `in`.createTypedArrayList(ImageBean.CREATOR)
    }

    companion object CREATOR : Parcelable.Creator<ImageListBean> {
        override fun createFromParcel(parcel: Parcel): ImageListBean {
            return ImageListBean(parcel)
        }

        override fun newArray(size: Int): Array<ImageListBean?> {
            return arrayOfNulls(size)
        }
    }


}
