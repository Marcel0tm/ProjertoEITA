package com.example.projetoeita2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projertoeita2.R
import com.example.projertoeita2.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

//import com.example.projetoeita2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    teste




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edNome = binding.edUsuario
        val edSenha = binding.edSenha
        val btLogin = binding.btLogin

        btLogin.setOnClickListener {
            if(edNome.text.toString().trim()=="genericUser" && edSenha.text.toString().trim()=="9999") {
                val intent = Intent(this, DescriptionProjectActivity::class.java)
                val texto = edNome.text.toString()
                intent.putExtra("nome", texto)
                startActivity(intent)
                binding.edUsuario.setText("")
                binding.edSenha.setText("")
                // Testando conexão com Firebase
                val database = Firebase.database
                val myRef = database.getReference("message")

                myRef.setValue("Hello, World!")
            }
            else{
                Toast.makeText(this, R.string.msgError, Toast.LENGTH_SHORT).show()
            }
        }
    }
}