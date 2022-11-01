package com.example.nannyapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nannyapp.presentation.screens.Alimentos
import com.example.nannyapp.presentation.screens.Otros
import com.example.nannyapp.presentation.screens.Panales
import com.example.nannyapp.presentation.screens.Siestas

@Composable
fun NavigationHost(
    navController: NavHostController
){

    NavHost(navController = navController, startDestination = Destinations.Alimentos.route){
        composable(Destinations.Alimentos.route){
            Alimentos()
        }
        composable(Destinations.Otros.route){
            Otros()
        }
        composable(Destinations.Panales.route){
            Panales()
        }
        composable(Destinations.Siestas.route){
            Siestas()
        }

        //composable(Panales.route){

    }
}