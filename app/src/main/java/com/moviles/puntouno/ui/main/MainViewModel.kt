package com.moviles.puntouno.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class MainViewModel : ViewModel() {

    val df = DecimalFormat("#.##")

    val result : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun calcularNota(nota1: Double, nota2: Double, nota3: Double, nota4: Double) {
        result.value = df.format(nota1*0.60 + nota2*0.07 + nota3*0.08 + nota4*0.25)
    }



}