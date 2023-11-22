package com.example.check_api

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Data(
    val index: String,
    val name: String,
    val url: String,
)
data class ActionSurge1Use(
    val index: String,
    @SerializedName("class")
    val classData: ClassData,
    val name: String,
    val level: Int,
    val prerequisites: List<String>,
    val description: List<String>,
    val url: String,
)
data class ClassData(
    val index: String,
    val name: String,
    val url: String,
)

val BASE_URL = "https://www.dnd5eapi.co"
interface ApiService {
    @GET("api/features")
    fun getData(): Call<List<Data>>
    companion object {
        operator fun invoke(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}

class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    private lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var data by mutableStateOf<List<Data>>(emptyList())
        apiService = ApiService()
//        getAll { data = it }
        setContent {
            navHostController = rememberNavController()
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                SetupNavGraph(
                    navController = navHostController,
                    data,
                )
            }
        }
    }

    private fun getAll(callback: (List<Data>) -> Unit) {
        val call = apiService.getData()
        call.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (response.isSuccessful) {
                    val data = response.body() ?: emptyList()
                    Log.e("retrieverDatalist", data.toString())
                    callback(data)
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
