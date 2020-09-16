package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class PriceHistogram(
    val `data`: List<String>,
    val max_value: String
) : Parcelable