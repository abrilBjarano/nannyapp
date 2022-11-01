package com.example.nannyapp.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.nannyapp.navigation.Destinations
import com.example.nannyapp.navigation.NavigationHost
import com.example.nannyapp.presentation.components.BottomNavigationBar
import com.example.nannyapp.ui.theme.NannyAppTheme

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
fun MainScreen(){
    val navController = rememberNavController()

    val navigationItems = listOf(
        Destinations.Alimentos,
        Destinations.Panales,
        Destinations.Siestas,
        Destinations.Otros,
        Destinations.Home

    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, items = navigationItems)
        }
    ) {
        NavigationHost(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NannyAppTheme {

    }
}