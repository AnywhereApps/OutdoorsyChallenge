package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Data(
    val attributes: Attributes,
    val id: String,
    val relationships: Relationships,
    val type: String
) : Parcelable