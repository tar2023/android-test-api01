package com.example.check_api.api

import com.example.check_api.model.FeaturesResponse
import com.example.check_api.model.ResultsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class ResultWebService {
    private var api: ResultApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.dnd5eapi.co/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ResultApi::class.java)
    }

    fun getResult01(): Call<ResultsResponse> {
        return api.getResult02()
    }

    fun getByIndex01(index: String): Call<FeaturesResponse> {
        return api.getByIndex02(index)
    }

    interface ResultApi {
        @GET("features")
        fun getResult02(): Call<ResultsResponse>

        @GET("features/{index}")
        fun getByIndex02(@Path("index") index: String): Call<FeaturesResponse>
    }
}
