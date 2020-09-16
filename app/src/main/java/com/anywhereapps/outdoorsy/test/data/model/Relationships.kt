package com.anywhereapps.outdoorsy.test.data.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Relationships(
    val generator_usage_item: GeneratorUsageItem,
    val images: Images,
    val mileage_usage_item: MileageUsageItem,
    val owner: Owner,
    val primary_image: PrimaryImage
) : Parcelable