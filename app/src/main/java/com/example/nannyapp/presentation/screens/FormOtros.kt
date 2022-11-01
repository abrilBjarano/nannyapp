package com.example.nannyapp.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import com.example.nannyapp.R
import com.example.nannyapp.ui.theme.*

class FormOtros : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NannyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    vistaFormOtros()
                }
            }
        }
    }
}
@Composable
fun vistaFormOtros() {
    val scrollState = rememberScrollState()//scroll en toda la pantalla
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(scrollState),//scroll en la pantalla
    ) {
        topBarFormOtros()
        Spacer(Modifier.padding(5.dp))
        titleFormOtros()
        Spacer(Modifier.padding(5.dp))
        title2_()
        Spacer(Modifier.padding(15.dp))
        formularioOtros()
        Spacer(Modifier.padding(25.dp))
        BotonGuardarR()
    }

}

@Composable
fun topBarFormOtros()
{
    TopAppBar()
    {
        Text("Mariana",
            textAlign = TextAlign.Center,
            color = nombre,
            fontWeight = FontWeight.Bold,
            fontFamily = MeriendaOne,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun titleFormOtros(modifier: Modifier = Modifier)
{
    Card(
        modifier = Modifier
            .size(250.dp, 65.dp)
            .padding(9.dp)
            .clip(RoundedCornerShape(25))
    )
    {
        Row(horizontalArrangement = Arrangement.Center){
            Image(painter = painterResource(id = R.drawable.otros),
                contentDescription = null,
                modifier = Modifier
                    .paddingFromBaseline(7.dp, 0.dp)
                    .size(35.dp))
            Spacer(Modifier.width(10.dp))
            Text("Otros",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = ConcertOne,
                color = letra,
                modifier = modifier.paddingFromBaseline(32.dp,0.dp),
            )
        }
    }
}

@Composable
fun title2_(){
    Text(
        text = "Recordatorios",
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontFamily = ConcertOne,
        color = letra,
        fontSize = 24.sp,
        //color = Color.letra
    )
}

@Composable
fun formularioOtros(){
    var txRepeticion by remember{ mutableStateOf(value= "") }
    Text(
        text="Nombre del Recordatorio",
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontFamily = ConcertOne,
        color = letra,
        fontSize=16.sp,
    )
    OutlinedTextField(
        value = txRepeticion,
        label={Text("Ingrese el Nombre del Recordatorio",
            fontWeight = FontWeight.Bold,
            fontFamily = ConcertOne)},
        onValueChange = {
            txRepeticion=it
        }
    )
    Spacer(Modifier.padding(10.dp))
    Text(
        text="Hora del Recordatorio 00:00",
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontFamily = ConcertOne,
        color = letra,
        fontSize=16.sp,
    )
    OutlinedTextField(
        value = txRepeticion,
        label={Text("Ingrese Hora del Recordatorio 00:00",
            fontWeight = FontWeight.Bold,
            fontFamily = ConcertOne)},
        onValueChange = {
            txRepeticion=it
        }
    )
    Spacer(Modifier.padding(10.dp))
    Text(
        text="Repeticion Cada 00:00",
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontFamily = ConcertOne,
        color = letra,
        fontSize=16.sp,
    )
    OutlinedTextField(
        value = txRepeticion,
        label={Text("Ingrese tiempo de repeticion 00:00",
            fontWeight = FontWeight.Bold,
            fontFamily = ConcertOne)},
        onValueChange = {
            txRepeticion=it
        }
    )
}

@Composable
fun BotonGuardarR(){
    Row(horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        //.padding(end = 15.dp, top = 5.dp, bottom = 5.dp, start = 15.dp)
    ){
        Button(
            modifier = Modifier.padding(end = 35.dp, top = 10.dp, bottom = 10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
            onClick = { /*TODO*/ }) {
            Text("Guardar Recordatorio")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFormOtros() {
    NannyAppTheme {
        vistaFormOtros()
    }
}