package com.example.nannyapp.navigation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nannyapp.presentation.components.BottomNavigationBar
import com.example.nannyapp.presentation.screens.*
import com.example.nannyapp.presentation.screens.login.LoginScreen
import com.example.nannyapp.presentation.screens.login.LoginViewModel
import com.example.nannyapp.presentation.screens.registration.RegisterViewModel
import com.example.nannyapp.presentation.screens.registration.RegistrationScreen

@Composable
fun NavigationHost(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = Destinations.Login.route){
        val navigationItems = listOf(
            Destinations.Alimentos,
            Destinations.Panales,
            Destinations.Siestas,
            Destinations.Otros,
            Destinations.Home
        )

        composable(Destinations.Alimentos.route){
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        navController = navController, items = navigationItems
                    )
                }
            ) {
                Alimentos()
            }
        }

        composable(Destinations.Otros.route){
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        navController = navController, items = navigationItems
                    )
                }
            ) {
                Otros()
            }
        }

        composable(Destinations.Panales.route){
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        navController = navController, items = navigationItems
                    )
                }
            ) {
                Panales()
            }
        }

        composable(Destinations.Siestas.route){
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        navController = navController, items = navigationItems
                    )
                }
            ) {
                Siestas()
            }
        }

        composable(Destinations.Login.route) {
            val viewModel: LoginViewModel = hiltViewModel()

            if (viewModel.state.value.successLogin) {
                LaunchedEffect(key1 = Unit) {
                    navController.navigate(
                        Destinations.Home.route
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

        composable(Destinations.Register.route){
            val viewModel: RegisterViewModel = hiltViewModel()

            RegistrationScreen(
                state = viewModel.state.value,
                onRegister = viewModel::register,
                onBack = {
                    navController.popBackStack()
                },
                onDismissDialog = viewModel::hideErrorDialog
            )
        }

        composable(Destinations.Home.route){
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        navController = navController, items = navigationItems
                    )
                }
            ) {
                HomeScreen()
            }
        }
    }
}