package com.example.nannyapp.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.nannyapp.R
import com.example.nannyapp.navigation.Destinations
import com.example.nannyapp.presentation.components.BottomNavigationBar
import com.example.nannyapp.ui.theme.*


class HomeScreen: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NannyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = amarillito
                ) {
                    vistaHome()
                }
            }
        }
    }
}
@Composable
fun vistaHome(){

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        topBarHome()
        Divider(color = Color.Transparent, thickness = 1.dp)
        opcionHome()
        Divider(color = Color.Transparent, thickness = 1.dp)
        back()
    }
}

@Composable
fun topBarHome(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = amarillito)
            .fillMaxWidth()
            .padding(20.dp)) {
        Card(
            elevation = 8.dp,
        ) {
            Image(modifier = Modifier
                .fillMaxWidth(),
                painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "background")
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Mariana",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MeriendaOne,
                    fontSize = 30.sp
                )
                Text(
                    "1 mes y 2 dias",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MeriendaOne,
                    fontSize = 15.sp
                )
                Text(
                    "22:00",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.End,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MeriendaOne,
                    fontSize = 30.sp
                )
            }
        }
    }
}

@Composable
fun opcionHome(){
    Row(modifier = Modifier
        .background(Color.White)
        .padding(20.dp)
        .fillMaxWidth()
    ){
        Column(modifier = Modifier.background(Color.LightGray)){
            Row(modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
                Arrangement.SpaceAround){
                MyImage()
                Column{
                    Text("Comida",
                        textAlign = TextAlign.Center,
                        color = letra,
                        fontWeight = FontWeight.Bold,
                        fontFamily = SpaceMono,
                        fontSize = 15.sp)
                    Text("22:00",
                        modifier = Modifier,
                        textAlign = TextAlign.Center,
                        color = letra,
                        fontWeight = FontWeight.Bold,
                        fontFamily = MeriendaOne,
                        fontSize = 15.sp)
                }
                MyImage()
            }
            Row(modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
                Arrangement.SpaceAround){
                MyImage()
                Column{
                    Text("Comida",
                        textAlign = TextAlign.Center,
                        color = letra,
                        fontWeight = FontWeight.Bold,
                        fontFamily = SpaceMono,
                        fontSize = 15.sp)
                    Text("22:00",
                        textAlign = TextAlign.Center,
                        color = letra,
                        fontWeight = FontWeight.Bold,
                        fontFamily = MeriendaOne,
                        fontSize = 15.sp)
                }
                MyImage()
            }
            Row(modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
                Arrangement.SpaceAround){
                MyImage()
                Column{
                    Text("Comida",
                        textAlign = TextAlign.Center,
                        color = letra,
                        fontWeight = FontWeight.Bold,
                        fontFamily = SpaceMono,
                        fontSize = 15.sp)
                    Text("22:00",
                        textAlign = TextAlign.Center,
                        color = letra,
                        fontWeight = FontWeight.Bold,
                        fontFamily = MeriendaOne,
                        fontSize = 15.sp)
                }
                MyImage()
            }
            Row(modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
                Arrangement.SpaceAround){
                MyImage()
                Column{
                    Text("Comida",
                        textAlign = TextAlign.Center,
                        color = letra,
                        fontWeight = FontWeight.Bold,
                        fontFamily = SpaceMono,
                        fontSize = 15.sp)
                    Text("22:00",
                        textAlign = TextAlign.Center,
                        color = letra,
                        fontWeight = FontWeight.Bold,
                        fontFamily = MeriendaOne,
                        fontSize = 15.sp)
                }
                MyImage()
            }
        }
    }
}

@Composable
fun back(){
    Card(modifier = Modifier
        .size(60.dp, 40.dp)
        .background(color = amarillito)
        .padding(9.dp)
        .clip(RoundedCornerShape(25))
    ){
        Text("Salir",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center)
    }
}

@Composable
fun MyImage(){
    Image(painterResource(R.drawable.biberon),
        "Imagen de prueba",
        Modifier
            .width(50.dp)
            .height(50.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    NannyAppTheme {
        vistaHome()
    }
}