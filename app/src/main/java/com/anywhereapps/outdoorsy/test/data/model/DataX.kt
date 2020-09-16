package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class DataX(
    val id: String,
    val type: String
) : Parcelable