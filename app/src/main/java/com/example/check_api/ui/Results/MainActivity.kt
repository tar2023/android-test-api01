package com.example.check_api.ui.Results

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.check_api.model.FeaturesResponse
import com.example.check_api.model.ResultList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyIndex()
//            Features()
        }
    }
}

@Composable
fun Features() {
    val viewModel: ResultsViewModel = viewModel()
    val rememberResultList = remember { mutableStateOf(emptyList<ResultList>()) }
    viewModel.getResult04 { response ->
        val resultListApi = response?.results
        rememberResultList.value = resultListApi.orEmpty()
    }
    LazyColumn {
        items(rememberResultList.value) { res ->

            Text(text = res.index ?: "")
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun MyIndex() {
    val viewModel: ResultsViewModel = viewModel()
    var features: MutableState<FeaturesResponse?> = remember {
        mutableStateOf(null)
    }
    viewModel.getByIndex04(index = "additional-magical-secrets") { response ->
        var featuresApi = response
        features.value = featuresApi
        Log.d("rtreterr", features.value.toString())
    }
    val index = features.value?.index.toString()
    val url = features.value?.url ?: "empty"
    val name = features.value?.name ?: "empty"
    val desc = features.value?.desc ?: "empty"
    val level = features.value?.level ?: "empty"
    val prerequisites = features.value?.prerequisites ?: "empty"
    val classIndex = features.value?.classX?.index ?: "empty"
    val className = features.value?.classX?.name ?: "empty"
    val classUrl = features.value?.classX?.url ?: "empty"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(text = "Index: $index", fontWeight = FontWeight.Bold)
        Text(text = "URL: $url")
        Text(text = "Name: $name")
        Text(text = "Desc: $desc")
        Text(text = "Level: $level")
        Text(text = "Prerequisites: $prerequisites")
        Text(text = "ClassIndex: $classIndex")
        Text(text = "ClassName: $className")
        Text(text = "ClassUrl: $classUrl")
    }
}
