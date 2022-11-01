package com.example.nannyapp.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.nannyapp.navigation.Destinations
import com.example.nannyapp.navigation.NavigationHost
import com.example.nannyapp.presentation.components.BottomNavigationBar
import com.example.nannyapp.presentation.screens.login.LoginScreen
import com.example.nannyapp.presentation.screens.login.LoginViewModel
import com.example.nannyapp.ui.theme.NannyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NannyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    NavigationHost(navController)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NannyAppTheme {

    }
}