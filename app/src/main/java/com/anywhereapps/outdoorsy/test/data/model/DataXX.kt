package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class DataXX(
    val id: String,
    val type: String
) : Parcelable