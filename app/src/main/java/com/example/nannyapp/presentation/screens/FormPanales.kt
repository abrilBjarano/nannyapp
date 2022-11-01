package com.example.nannyapp.presentation.screens

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nannyapp.R
import com.example.nannyapp.ui.theme.NannyAppTheme
import com.example.nannyapp.ui.theme.fondo
import com.example.nannyapp.ui.theme.letra
import com.example.nannyapp.ui.theme.rojito


class FormularioPanales : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NannyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    vistaCambioPanal()
                }
            }
        }
    }
}

@Composable
fun vistaCambioPanal() {
    val scrollState = rememberScrollState()//scroll en toda la pantalla
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(scrollState),//scroll en la pantalla
    ) {
        topBar()
        Spacer(Modifier.padding(5.dp))
        title()
        Spacer(Modifier.padding(5.dp))
        title2()
        Spacer(Modifier.padding(5.dp))
        PipiPopo()
        Spacer(Modifier.padding(5.dp))
        ColorHeces()
        Spacer(Modifier.padding(5.dp))
        BotonGuardar()
    }
}

@Composable
fun topBar()
{
    TopAppBar()
    {
    }
}

@Composable
fun title(modifier: Modifier = Modifier)
{
    Card(
        modifier = Modifier
            .size(250.dp, 65.dp)
            .padding(9.dp)
            .clip(RoundedCornerShape(25))
    )
    {
        Row(horizontalArrangement = Arrangement.Center){
            Image(painter = painterResource(id = R.drawable.panal),
                contentDescription = null,
                modifier = Modifier
                    .paddingFromBaseline(7.dp, 0.dp)
                    .padding(end = 15.dp)
                    .size(35.dp))
            Text(text = "CAMBIO PAÑAL",
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = letra,
                modifier = modifier.paddingFromBaseline(30.dp),
            )
        }
    }
}

@Composable
fun title2(){
    Text(
        text = "Detalles importantes",
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
        color = letra
    )
}

@Composable
fun PipiPopo(){
    val Opciones = listOf("Pipi", "Popo", "Ambos")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(Opciones[0]) }
    Column{
        Text(
            "¿A que necesidad se debio el cambio de pañal?",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly, //espaciado uniformemente
        verticalAlignment = Alignment.CenterVertically,
    )
    {
        Opciones.forEach{ text ->
            Row (
                modifier = Modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    ),
                verticalAlignment = CenterVertically
            ){
                val context = LocalContext.current
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = {
                        onOptionSelected(text)
                        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
                    },
                    colors = RadioButtonDefaults.colors(selectedColor = rojito,
                        unselectedColor = letra,
                    )
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 5.dp),//16

                )
            }
        }
    }
    Column{
        Divider(color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )
    }
}


@Composable
fun ColorHeces(){
    val radioOptions = listOf("Negro-Verdoso", "Cafe-Verdoso", "Amarillo mostaza", "Verde-Brillante", "Blanco",
        "Cafe-Claro", "Rojo-Rosaceo", "Cafe", "Verde-Oscuro", "Negro")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    //Otra lista
    val radioOptions2 = listOf("Pegajoso", "Grueso","Seco","Blanda","Granuloso","Acuoso","Con manchas rojas")
    val (selectedOption2, onOptionSelected2) = remember { mutableStateOf(radioOptions2[0]) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "Color de las heces fecales",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Column {
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) }
                        ),
                    verticalAlignment = CenterVertically
                ) {
                    val context = LocalContext.current
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                            Toast.makeText(context, text, Toast.LENGTH_LONG).show()
                        },
                        colors = RadioButtonDefaults.colors(selectedColor = rojito,
                            unselectedColor = letra,
                        )
                    )
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 5.dp)//16
                    )
                }
            }
        }
        //Aqui va la otra lista 2
        Divider(color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )
        Text(
            "Consistencia de las heces fecales",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Column {
            radioOptions2.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selectedOption2),
                            onClick = { onOptionSelected2(text) }
                        ),
                    //.padding(horizontal = 16.dp)//16
                    verticalAlignment = CenterVertically
                ) {
                    val context = LocalContext.current
                    RadioButton(
                        selected = (text == selectedOption2),
                        onClick = {
                            onOptionSelected2(text)
                            Toast.makeText(context, text, Toast.LENGTH_LONG).show()
                        },
                        colors = RadioButtonDefaults.colors(selectedColor = rojito,
                            unselectedColor = letra,
                        )
                    )
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun BotonGuardar(){
    Row(horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){
        Button(
            modifier = Modifier.padding(end = 35.dp, top = 10.dp, bottom = 10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = fondo),
            onClick = { /*TODO*/ }) {
            Text(text = "Guardar",
                color = Color.Black
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    NannyAppTheme {
        vistaCambioPanal()
    }
}