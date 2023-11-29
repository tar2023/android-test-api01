package com.example.check_api.model


import com.google.gson.annotations.SerializedName

data class FeaturesResponse(
    @SerializedName("class")
    val classX: ClassResponse?,
    @SerializedName("desc")
    val desc: List<String?>?,
    @SerializedName("index")
    var index: String?,
    @SerializedName("level")
    val level: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("prerequisites")
    val prerequisites: List<Any?>?,
    @SerializedName("url")
    val url: String?
)
data class ClassResponse(
    @SerializedName("index")
    val index: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)