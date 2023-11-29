package com.example.check_api.ui.Results
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.check_api.model.FeaturesResponse
import com.example.check_api.model.ResultList

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_Screen")
    object Detail : Screen(route = "detail_Screen")
}

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    onclick: (String) -> Unit,
    features: FeaturesResponse?,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        route = "root",
    ) {
        composable(
            route = Screen.Home.route,
        ) {
            Home(navController = navController, onclick)
        }

        composable(
            route = Screen.Detail.route,
        ) {
            Detail(navController = navController, features)
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun Detail(
    navController: NavHostController,
    features: FeaturesResponse?,
) {
    val index = features?.index.toString()
    val url = features?.url ?: "empty"
    val name = features?.name ?: "empty"
    val desc = features?.desc ?: "empty"
    val level = features?.level ?: "empty"
    val prerequisites = features?.prerequisites ?: "empty"
    val classIndex = features?.classX?.index ?: "empty"
    val className = features?.classX?.name ?: "empty"
    val classUrl = features?.classX?.url ?: "empty"
    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = "Back",
            modifier = Modifier.clickable { navController.navigate(route = Screen.Home.route) },
        )
        Text(
            text = "Detail",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .wrapContentSize(Alignment.TopCenter),
        )
    }
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

@Composable
fun Home(navController: NavHostController, onclick: (String) -> Unit) {
    val viewModel: ResultsViewModel = viewModel()
    val rememberResultList = remember { mutableStateOf(emptyList<ResultList>()) }
    viewModel.getResult04 { response ->
        val resultListApi = response?.results
        rememberResultList.value = resultListApi.orEmpty()
    }
    val dataIndex = rememberResultList.value
    LazyColumn {
        items(rememberResultList.value) { res ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        navController.navigate(route = Screen.Detail.route)
                        onclick(res?.index ?: "")
                    },
            ) {
                Column(
                    modifier = Modifier.padding(8.dp).background(Color.LightGray),
                ) {
                    Text(text = res.index ?: "")
                    Text(text = res.url ?: "")
                    Text(text = res.name ?: "")
                }
            }
        }
    }
}
