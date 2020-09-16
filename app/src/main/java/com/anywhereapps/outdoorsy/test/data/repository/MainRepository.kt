package com.anywhereapps.outdoorsy.test.data.repository

import com.anywhereapps.outdoorsy.test.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getResults(key: String, limit : Int) = apiHelper.getResults(key, limit)
}