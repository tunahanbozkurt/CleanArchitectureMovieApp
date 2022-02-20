package com.example.findsavemovies.feature.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector,
    val title: String
    )
{
    object FindScreen: BottomBarScreen(route = "find_screen",Icons.Filled.Search,"Find")
    object HomeScreen: BottomBarScreen(route = "home_screen",Icons.Filled.Home,"Home")
}

sealed class Screen(
    val route: String
){
    object DetailScreen: Screen(route = "detail_screen")
}
