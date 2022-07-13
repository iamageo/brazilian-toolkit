package com.iamageo.brazilian_toolkit

import com.iamageo.brazilian_toolkit_library.isCpf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.iamageo.brazilian_toolkit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupValidateCpf()
    }

    private fun setupValidateCpf() {
        binding.btnVerify.setOnClickListener {
            if(!binding.textFieldCpf.editText?.text.toString().isCpf()) {
                binding.textFieldCpf.error = "Cpf inválido!"
            } else {
                Toast.makeText(this, "Cpf válido!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}