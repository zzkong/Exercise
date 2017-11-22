package com.zzkong.ktpro.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by zzkong on 2017/10/12.
 */
class ImageBean : Parcelable {
    lateinit var id: String
    lateinit var desc: String
    lateinit var tags: List<String>
    lateinit var fromPageTitle: String
    lateinit var column: String
    lateinit var date: String
    lateinit var downloadUrl: String
    lateinit var imageUrl: String
    var imageWidth: Int = 0
    var imageHeight: Int = 0
    lateinit var thumbnailUrl: String
    var thumbnailWidth: Int = 0
    var thumbnailHeight: Int = 0
    lateinit var thumbnailLargeUrl: String
    var thumbnailLargeWidth: Int = 0
    var thumbnailLargeHeight: Int = 0
    lateinit var thumbnailLargeTnUrl: String
    var thumbnailLargeTnWidth: Int = 0
    var thumbnailLargeTnHeight: Int = 0
    lateinit var siteName: String
    lateinit var siteLogo: String
    lateinit var siteUrl: String
    lateinit var fromUrl: String
    lateinit var objUrl: String
    lateinit var shareUrl: String
    lateinit var albumId: String
    var isAlbum: Int = 0
    lateinit var albumName: String
    var albumNum: Int = 0
    lateinit var title: String


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.id)
        dest.writeString(this.desc)
        dest.writeStringList(this.tags)
        dest.writeString(this.fromPageTitle)
        dest.writeString(this.column)
        dest.writeString(this.date)
        dest.writeString(this.downloadUrl)
        dest.writeString(this.imageUrl)
        dest.writeInt(this.imageWidth)
        dest.writeInt(this.imageHeight)
        dest.writeString(this.thumbnailUrl)
        dest.writeInt(this.thumbnailWidth)
        dest.writeInt(this.thumbnailHeight)
        dest.writeString(this.thumbnailLargeUrl)
        dest.writeInt(this.thumbnailLargeWidth)
        dest.writeInt(this.thumbnailLargeHeight)
        dest.writeString(this.thumbnailLargeTnUrl)
        dest.writeInt(this.thumbnailLargeTnWidth)
        dest.writeInt(this.thumbnailLargeTnHeight)
        dest.writeString(this.siteName)
        dest.writeString(this.siteLogo)
        dest.writeString(this.siteUrl)
        dest.writeString(this.fromUrl)
        dest.writeString(this.objUrl)
        dest.writeString(this.shareUrl)
        dest.writeString(this.albumId)
        dest.writeInt(this.isAlbum)
        dest.writeString(this.albumName)
        dest.writeInt(this.albumNum)
        dest.writeString(this.title)
    }

    constructor() {}

    protected constructor(`in`: Parcel) {
        this.id = `in`.readString()
        this.desc = `in`.readString()
        this.tags = `in`.createStringArrayList()
        this.fromPageTitle = `in`.readString()
        this.column = `in`.readString()
        this.date = `in`.readString()
        this.downloadUrl = `in`.readString()
        this.imageUrl = `in`.readString()
        this.imageWidth = `in`.readInt()
        this.imageHeight = `in`.readInt()
        this.thumbnailUrl = `in`.readString()
        this.thumbnailWidth = `in`.readInt()
        this.thumbnailHeight = `in`.readInt()
        this.thumbnailLargeUrl = `in`.readString()
        this.thumbnailLargeWidth = `in`.readInt()
        this.thumbnailLargeHeight = `in`.readInt()
        this.thumbnailLargeTnUrl = `in`.readString()
        this.thumbnailLargeTnWidth = `in`.readInt()
        this.thumbnailLargeTnHeight = `in`.readInt()
        this.siteName = `in`.readString()
        this.siteLogo = `in`.readString()
        this.siteUrl = `in`.readString()
        this.fromUrl = `in`.readString()
        this.objUrl = `in`.readString()
        this.shareUrl = `in`.readString()
        this.albumId = `in`.readString()
        this.isAlbum = `in`.readInt()
        this.albumName = `in`.readString()
        this.albumNum = `in`.readInt()
        this.title = `in`.readString()
    }

    companion object CREATOR : Parcelable.Creator<ImageBean> {
        override fun createFromParcel(parcel: Parcel): ImageBean {
            return ImageBean(parcel)
        }

        override fun newArray(size: Int): Array<ImageBean?> {
            return arrayOfNulls(size)
        }
    }
}