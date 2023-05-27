package com.example.projertoeita2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projertoeita2.databinding.ActivityCadastrarPerguntaBinding
import com.example.projetoeita2.ApresentationProjectActivity
import com.example.projetoeita2.empresaModelo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadastrarPerguntaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarPerguntaBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarPerguntaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var edTitulo = binding.edTitlulo
        var edDescricao = binding.edDescricao
        var edExplicacao = binding.edExplicacao
        var edCadastrar = binding.edCadastrar


        dbRef = FirebaseDatabase.getInstance().getReference("Pergunta")

        edCadastrar.setOnClickListener {
            val empTitulo = edTitulo.text.toString()
            val empDescricao = edDescricao.text.toString()
            val empJustificativa = edExplicacao.text.toString()

            if(empTitulo.isEmpty()) {
                edTitulo.error = "Insira um título para a pergunta, por favor"
            }
            if(empDescricao.isEmpty()) {
                edDescricao.error = "Insira uma descrição, por favor"
            }
            if(empJustificativa.isEmpty()) {
                edExplicacao.error = "Insira uma justificativa, por favor"
            }

            val empId = dbRef.push().key!!

            val pergunta = empresaModelo(empId, empTitulo, empDescricao, empJustificativa)

            dbRef.child(empId).setValue(pergunta)
                .addOnCompleteListener{
                    Toast.makeText(this, "Cadastro de pergunta realizado com sucesso!", Toast.LENGTH_SHORT).show()

                    edTitulo.text.clear()
                    edDescricao.text.clear()
                    edExplicacao.text.clear()

                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
        }

        val buttonBack = binding.buttonBack

        buttonBack.setOnClickListener {
            startActivity(Intent(this, ApresentationProjectActivity::class.java))
        }
    }
}