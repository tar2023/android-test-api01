package com.example.check_api

import com.example.check_api.api.ResultWebService
import com.example.check_api.model.FeaturesResponse
import com.example.check_api.model.ResultsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultsRepository(
    private val webService: ResultWebService = ResultWebService(),
) {
    fun getResult03(successCallback: (response: ResultsResponse?) -> Unit) {
        return webService.getResult01().enqueue(
            object : Callback<ResultsResponse> {
                override fun onResponse(
                    call: Call<ResultsResponse>,
                    response: Response<ResultsResponse>,
                ) {
                    if (response.isSuccessful) {
                        successCallback(response.body())
                    }
                }

                override fun onFailure(call: Call<ResultsResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            },
        )
        return
    }

    fun getByIndex03(index: String, successCallback: (response: FeaturesResponse?) -> Unit) {
        return webService.getByIndex01(index).enqueue(
            object : Callback<FeaturesResponse> {
                override fun onResponse(
                    call: Call<FeaturesResponse>,
                    response: Response<FeaturesResponse>,
                ) {
                    if (response.isSuccessful) {
                        successCallback(response.body())
                    }
                }

                override fun onFailure(call: Call<FeaturesResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            },
        )
    }
}
