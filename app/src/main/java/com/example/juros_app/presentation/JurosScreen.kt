package com.example.juros_app.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.juros_app.juros.formattedJuros

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JurosScreen(modifier: Modifier = Modifier) {
    var inputValInicial by remember { mutableStateOf("") }
    var inputValTaxaAnual by remember {  mutableStateOf("") }
    var inputPeriodo by remember {  mutableStateOf("") }

    var juros by remember { mutableStateOf("") }


    val valInicial = inputValInicial.toDoubleOrNull()
    val taxaAnual = inputValTaxaAnual.toDoubleOrNull()
    val periodo = inputPeriodo.toDoubleOrNull()

    val onclick =  { juros = formattedJuros(valInicial,taxaAnual,periodo) }

    Column (
        modifier = Modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Calculadora de juros composto",
            fontSize = 28.sp,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(10.dp))

        Edit(
            value = inputValInicial,
            onValueChange = { inputValInicial = it},
            label = "Digite seu valor inicial",
        )

        Edit(
            value = inputValTaxaAnual,
            onValueChange = { inputValTaxaAnual = it},
            label = "Digite a taxa de juros anual",
        )

        Edit(
            value = inputPeriodo,
            onValueChange = { inputPeriodo = it},
            label = "Digite o periodo em anos",
        )
        Button(onClick = onclick) {
            Text( "Calcular")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = juros,
            fontSize = 25.sp,
            modifier = modifier
        )
    }
}