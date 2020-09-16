package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Result(
    val data: List<Data>,
    val included: List<Included>,
    val meta: Meta
) : Parcelable