package com.example.nannyapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.nannyapp.navigation.Destinations

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<Destinations>
){
    val currentRoute = currentRoute(navController)

    BottomNavigation {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Image(painter = painterResource(screen.icon), contentDescription = null)},
                label = {Text(screen.title)},
                selected = currentRoute == screen.route,
                onClick = {
                          navController.navigate(screen.route){
                              popUpTo(navController.graph.findStartDestination().id) {
                                  saveState = true
                              }

                              launchSingleTop = true
                          }
                },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavController): String?{
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}