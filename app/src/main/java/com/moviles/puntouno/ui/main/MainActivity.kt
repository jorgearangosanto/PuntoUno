package com.moviles.puntouno.ui.main


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moviles.puntouno.R
import com.moviles.puntouno.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val view = binding.root
        setContentView(view)

        val observer = Observer<String> {
            binding.resultadoTextView.text = buildString {
                append(getString(R.string.resultado))
                append(it)
            }
        }

        mainViewModel.result.observe(this,observer)

        binding.button.setOnClickListener {
            if (!validarCalculate()) {
                mainViewModel.calcularNota(
                    binding.primeraNotaTextInputEditText.text.toString().toDouble(),
                    binding.segundaNotaTextInputEdittext.text.toString().toDouble(),
                    binding.tercerNotaTextInputEditText.text.toString().toDouble(),
                    binding.finalTextInputEdit.text.toString().toDouble())
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