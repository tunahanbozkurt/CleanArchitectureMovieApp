package com.example.findsavemovies.feature.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.findsavemovies.feature.presentation.home_screen.HomeScreen
import com.example.findsavemovies.feature.presentation.detail_screen.DetailScreen
import com.example.findsavemovies.feature.presentation.find_screen.FindScreen

@Composable
fun NavigationProvider() {

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val items = listOf(
        BottomBarScreen.FindScreen,
        BottomBarScreen.HomeScreen
    )

    Scaffold(
        bottomBar = {
            if(currentDestination?.route != Screen.DetailScreen.route){
                BottomNavigation{

                    items.forEach { screen ->
                        BottomNavigationItem(
                            icon = { Icon(screen.icon, contentDescription = null) },
                            label = { Text(screen.title) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }

                                    launchSingleTop = true

                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->

        NavHost(navController, startDestination = BottomBarScreen.FindScreen.route, Modifier.padding(innerPadding)) {

            composable(BottomBarScreen.FindScreen.route) {
                FindScreen(navController)
            }

            composable(BottomBarScreen.HomeScreen.route) {
                HomeScreen(navController = navController)
            }

            composable(
                Screen.DetailScreen.route + "?title={title}",
                arguments = listOf(navArgument(name = "title"){defaultValue = ""})
            ) {
                DetailScreen(navController = navController, arg = it.arguments?.getString("title"))
            }

        }
    }

}