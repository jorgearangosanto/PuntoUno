package com.moviles.puntouno


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.moviles.puntouno.databinding.ActivityMainBinding
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val df = DecimalFormat("#.##")

        binding.button.setOnClickListener {
            if (!validarCalculate()) {
                val nota1 = binding.primeraNotaTextInputEditText.text.toString().toDouble()
                val nota2 = binding.segundaNotaTextInputEdittext.text.toString().toDouble()
                val nota3 = binding.tercerNotaTextInputEditText.text.toString().toDouble()
                val nota4 = binding.finalTextInputEdit.text.toString().toDouble()
                val final = df.format(nota1*0.60 + nota2*0.07 + nota3*0.08 + nota4*0.25)
                binding.resultadoTextView.text = buildString {
                    append(getString(R.string.resultado))
                    append(final)
                }
            } else {
                binding.resultadoTextView.text = ""
                Toast.makeText(this, "existen campos vacios", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validarCalculate() = (binding.primeraNotaTextInputEditText.text.toString().isEmpty()
            || binding.segundaNotaTextInputEdittext.text.toString().isEmpty()
            || binding.tercerNotaTextInputEditText.text.toString().isEmpty()
            || binding.finalTextInputEdit.text.toString().isEmpty())
}