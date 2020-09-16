package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class VehicleType(
    val label: String,
    val style: String,
    val type: String
) : Parcelable