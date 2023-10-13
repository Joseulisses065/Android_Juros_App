package com.example.juros_app.juros

import java.text.NumberFormat

fun formattedJuros(
    inicial: Double?,
    anual: Double?,
    periodo: Double?,

    ): String {
    if (inicial == null || anual == null || periodo == null){
        return "Digite valores válidos"
    }
    val peri = periodo;
    val juros = (inicial*Math.pow((1+(anual/100)),peri)) - inicial
    val textJuros = NumberFormat.getNumberInstance().format(juros);
    val anos = periodo;
    return "Seu Juros composto é  $textJuros no periodo de $anos ano(s)"
}