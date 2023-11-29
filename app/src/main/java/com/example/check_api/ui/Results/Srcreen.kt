package com.example.check_api.ui.Results

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_Screen")
    object Detail : Screen(route = "detail_Screen")
}
//
// @Composable
// fun SetupNavGraph(
//    navController: NavHostController,
//    dataList: List<Data>,
// //    data: Data?,
// //    onclick: (String) -> Unit,
// ) {
//    NavHost(
//        navController = navController,
//        startDestination = Screen.Home.route,
//        route = "root",
//    ) {
//        composable(
//            route = Screen.Home.route,
//        ) {
//            Home(navController = navController, dataList)
//        }
//
//        composable(
//            route = Screen.Detail.route,
//        ) {
//            Detail(navController = navController)
//        }
//    }
// }
//
// @Composable
// fun Detail(
//    navController: NavHostController,
// //    data: Data?,
// ) {
//    Box(
//        modifier = Modifier.fillMaxWidth()
//            .clickable {
//                navController.navigate(route = Screen.Home.route)
//            },
//        contentAlignment = Alignment.TopCenter,
//    ) {
//        Text(text = "Detail")
//    }
//
//    Column(
//        modifier = Modifier.padding(8.dp),
//    ) {
//        //
//    }
// }
//
// @Composable
// fun Home(
//    navController: NavHostController,
//    data: List<Data>,
// //    onclick: (String) -> Unit,
// ) {
//    Text(text = "Home")
//    LazyColumn {
//        items(data) { dataIndex ->
//            AlbumItem(navController, dataIndex)
//        }
//    }
// }
//
// @Composable
// fun AlbumItem(
//    navController: NavHostController,
//    dataIndex: Data,
// //    onclick: (String) -> Unit,
// ) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .clickable {
//                navController.navigate(route = Screen.Detail.route)
// //                onclick(dataIndex.index)
//            },
//    ) {
//        Column(
//            modifier = Modifier.padding(8.dp).background(Color.LightGray),
//        ) {
//            Text(text = dataIndex.index)
//            Text(text = dataIndex.name)
//            Text(text = dataIndex.url)
//        }
//    }
// }
