package com.example.nannyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nannyapp.presentation.screens.Alimentos
import com.example.nannyapp.presentation.screens.Otros
import com.example.nannyapp.presentation.screens.Panales
import com.example.nannyapp.presentation.screens.Siestas
import com.example.nannyapp.presentation.screens.login.LoginScreen
import com.example.nannyapp.presentation.screens.login.LoginViewModel

@Composable
fun NavigationHost(
    navController: NavHostController
){

    NavHost(navController = navController, startDestination = Destinations.Login.route){
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
        composable(Destinations.Login.route){
            val viewModel: LoginViewModel = hiltViewModel()
            val email = viewModel.state.value.email
            val password = viewModel.state.value.password

            if (viewModel.state.value.successLogin) {
                LaunchedEffect(key1 = Unit) {
                    navController.navigate(
                        Destinations.Home.route + "/$email" + "/$password"
                    ) {
                        popUpTo(Destinations.Login.route) {
                            inclusive = true
                        }
                    }
                }
            } else {
                LoginScreen(
                    state = viewModel.state.value,
                    onLogin = viewModel::login,
                    onNavigateToRegister = {
                        navController.navigate(Destinations.Register.route)
                    },
                    onDismissDialog = viewModel::hideErrorDialog
                )
            }
        }

        //composable(Panales.route){

    }
}