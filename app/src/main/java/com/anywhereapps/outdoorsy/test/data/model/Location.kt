package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Location(
    val city: String,
    val country: String,
    val county: String,
    val lat: Double,
    val lng: Double,
    val state: String,
    val zip: String
) : Parcelable