package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Locale(
    val base_currency: String,
    val distance_unit: String,
    val length_unit: String,
    val liquid_unit: String,
    val weight_unit: String
) : Parcelable