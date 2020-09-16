package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class InsurancePlan(
    val id: String,
    val label: String,
    val renter_body: String,
    val renter_headline: String
) : Parcelable