package com.iamageo.brazilian_toolkit

import com.iamageo.brazilian_toolkit_library.isCpf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iamageo.brazilian_toolkit.databinding.ActivityMainBinding
import com.iamageo.brazilian_toolkit_library.BrazilianUtilsMask
import com.iamageo.brazilian_toolkit_library.isCnpj

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupValidateCpf()
    }

    private fun setupValidateCpf() {

        binding.textFieldCpf.editText?.addTextChangedListener(BrazilianUtilsMask.cpfAndCnpjMask(binding.textFieldCpf.editText!!))

        binding.btnVerify.setOnClickListener {
            when(binding.textFieldCpf.editText?.text?.length!!) {
                14 -> {
                    if(!binding.textFieldCpf.editText?.text.toString().isCpf()) {
                        binding.textFieldCpf.error = "Cpf inválido!"
                    } else {
                        binding.textFieldCpf.error = ""
                        Toast.makeText(this, "Cpf válido!", Toast.LENGTH_SHORT).show()
                    }
                }
                18 -> {
                    if(!binding.textFieldCpf.editText?.text.toString().isCnpj()) {
                        binding.textFieldCpf.error = "Cnpj inválido!"
                    } else {
                        binding.textFieldCpf.error = ""
                        Toast.makeText(this, "Cnpj válido!", Toast.LENGTH_SHORT).show()
                    }
                }
                else -> {
                    Toast.makeText(this, "Não é um CPF nem CNPJ válido", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}