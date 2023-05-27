package com.example.projetoeita2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.projertoeita2.CadastrarPerguntaActivity
import com.example.projertoeita2.R
import com.example.projertoeita2.databinding.ActivityApresentationProjectBinding
//import com.example.projetoeita2.databinding.ActivityApresentationProjectBinding

class ApresentationProjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApresentationProjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApresentationProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonNext = binding.buttonSendSolutionPresentation

        buttonNext.setOnClickListener {
            Toast.makeText(this, R.string.msgSucess, Toast.LENGTH_SHORT).show()
            finish()
        }

        val buttonSendQuestion = binding.buttonSendQuestions

        buttonSendQuestion.setOnClickListener {
            startActivity(Intent(this, CadastrarPerguntaActivity::class.java))
        }
    }
}