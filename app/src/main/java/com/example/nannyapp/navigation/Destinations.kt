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
    val arguments: List<NamedNavArgument>
) {
    object Alimentos : Destinations("alimentos", "Alimentos", R.drawable.biberon, emptyList())
    object Otros : Destinations("otros", "Otros", R.drawable.otros, emptyList()) {
        fun createRoute(newText: String) = "otros/?newText={newText}=$newText"
    }

    object Panales : Destinations("panales", "Panales", R.drawable.panal, emptyList())
    object Siestas : Destinations("siestas", "Siestas", R.drawable.siesta, emptyList())
    object Home : Destinations(
        route = "home",
        arguments = listOf(
            navArgument("email") { type = NavType.StringType },
            navArgument("password") { type = NavType.StringType }
        ),
        title = "Menú",
        icon = R.drawable.home
    )

    object Login : Destinations(
        route = "login",
        arguments = emptyList(),
        icon = R.drawable.home,
        title = "Iniciar sesión"
    )

    object Register : Destinations(
        route = "register",
        arguments = emptyList(),
        icon = R.drawable.home,
        title = "Crear cuenta"
    )
}