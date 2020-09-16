package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Tag(
    val count: String,
    val slug: String,
    val tag: String
) : Parcelable