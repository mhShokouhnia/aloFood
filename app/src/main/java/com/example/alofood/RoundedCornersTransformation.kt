package com.example.alofood

import android.content.Context
import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.Resource
import java.security.MessageDigest

class RoundedCornersTransformation() :
    Transformation<Bitmap>, Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RoundedCornersTransformation> {
        override fun createFromParcel(parcel: Parcel): RoundedCornersTransformation {
            return RoundedCornersTransformation(parcel)
        }

        override fun newArray(size: Int): Array<RoundedCornersTransformation?> {
            return arrayOfNulls(size)
        }
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        TODO("Not yet implemented")
    }

    override fun transform(
        context: Context,
        resource: Resource<Bitmap>,
        outWidth: Int,
        outHeight: Int
    ): Resource<Bitmap> {
        TODO("Not yet implemented")
    }

}
