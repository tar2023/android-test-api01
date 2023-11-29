package com.example.check_api.ui.Results

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.check_api.model.FeaturesResponse

class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController

    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navHostController = rememberNavController()
            val viewModel: ResultsViewModel = viewModel()
            var features = remember { mutableStateOf<FeaturesResponse?>(null) }
            SetupNavGraph(
                navController = navHostController,
                onclick = {
                    viewModel.getByIndex04(it) { response ->
                        var featuresApi = response
                        features.value = featuresApi
                    }
                },
                features = features.value,
            )
        }
    }
}