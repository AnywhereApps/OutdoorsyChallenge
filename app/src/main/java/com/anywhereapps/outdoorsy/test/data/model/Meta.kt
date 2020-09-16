package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Meta(
    val city: String,
    val country: String,
    val country_code: String,
    val country_name: String,
    val lat: Double,
    val lng: Double,
    val locale: String,
    val price_average: Int,
    val price_histogram: PriceHistogram,
    val price_max: Int,
    val price_min: Int,
    val radius: Int,
    val start_position: Int,
    val state: String,
    val stop_position: Int,
    val total: Int,
    val vehicle_types: List<VehicleType>
) : Parcelable