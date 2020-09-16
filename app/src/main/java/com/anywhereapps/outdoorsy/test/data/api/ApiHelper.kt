package com.anywhereapps.outdoorsy.test.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getResults(key: String, limit : Int) = apiService.getResults(key, limit)
}