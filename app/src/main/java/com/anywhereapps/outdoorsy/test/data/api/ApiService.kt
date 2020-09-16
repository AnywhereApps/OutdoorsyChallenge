package com.anywhereapps.outdoorsy.test.data.api

import com.anywhereapps.outdoorsy.test.data.model.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("rentals")
    suspend fun getResults(@Query("filter[keywords]") searchKey: String, @Query("page[limit]") limit: Int): Result

}