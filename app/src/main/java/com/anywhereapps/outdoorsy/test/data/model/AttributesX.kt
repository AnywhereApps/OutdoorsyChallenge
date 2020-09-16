package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class AttributesX(
    val best: Boolean,
    val description: String,
    val position: String,
    val primary: Boolean,
    val rental_id: String,
    val skip_enhance: Boolean,
    val tags: String,
    val url: String,
    val video: Boolean
) : Parcelable