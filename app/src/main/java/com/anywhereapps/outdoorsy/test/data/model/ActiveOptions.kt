package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class ActiveOptions(
    val cancel_policy: String,
    val date: String,
    val instant_book: Boolean,
    val minimum_days: String,
    val price_per_day: String,
    val price_per_month: String,
    val price_per_week: String,
    val tax: String,
    val use_day_pricing: Boolean,
    val use_tax_inclusive_pricing: Boolean
) : Parcelable