package com.example.nannyapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.nannyapp.R

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: Int,
) {
    object Alimentos : Destinations("alimentos", "Alimentos", R.drawable.biberon, emptyList())
    object Otros : Destinations("otros", "Otros", R.drawable.otros) {
        fun createRoute(newText: String) = "otros/?newText={newText}=$newText"
    }

    object Panales : Destinations("panales", "Panales", R.drawable.panal)
    object Siestas : Destinations("siestas", "Siestas", R.drawable.siesta)
    object Home : Destinations("Menú", "Menú", R.drawable.home)
    object Login : Destinations("login", "Iniciar sesión", R.drawable.home)
    object Register : Destinations("register", "Crear cuenta", R.drawable.home)
}