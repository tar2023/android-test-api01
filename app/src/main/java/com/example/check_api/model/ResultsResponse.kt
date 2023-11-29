package com.example.check_api.model

import com.google.gson.annotations.SerializedName

data class ResultsResponse(
    @SerializedName("results")
    val results: List<ResultList>?,
)

data class ResultList(
    @SerializedName("index")
    val index: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
)
