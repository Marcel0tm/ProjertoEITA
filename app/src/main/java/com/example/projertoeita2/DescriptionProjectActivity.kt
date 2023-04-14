package com.example.projetoeita2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projertoeita2.databinding.ActivityDescriptionProjectBinding
//import com.example.projetoeita2.databinding.ActivityDescriptionProjectBinding

class DescriptionProjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDescriptionProjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = binding.tvUsuarioNome
        val nome = intent.getStringExtra("nome")
        userName.text = nome

        val buttonAvancar = binding.buttonNext

        buttonAvancar.setOnClickListener {
            startActivity(Intent(this, ApresentationProjectActivity::class.java))
        }

    }
}