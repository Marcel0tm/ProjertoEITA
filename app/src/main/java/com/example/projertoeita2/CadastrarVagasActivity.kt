package com.example.projertoeita2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projertoeita2.databinding.ActivityCadastrarVagasBinding
import com.example.projetoeita2.empresaModelo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadastrarVagasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarVagasBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarVagasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var edEmpresa = binding.edEmpresa
        var edCargo = binding.edCargo
        var edSalario = binding.edSalario
        var edCadastrar = binding.edCadastrar

        dbRef = FirebaseDatabase.getInstance().getReference("Empregador")

        edCadastrar.setOnClickListener {
            val empName = edEmpresa.text.toString()
            val empCargo = edCargo.text.toString()
            val empSalario = edSalario.text.toString()

            if(empName.isEmpty()) {
                edEmpresa.error = "Insira um nome, por favor"
            }
            if(empCargo.isEmpty()) {
                edCargo.error = "Insira um cargo, por favor"
            }
            if(empSalario.isEmpty()) {
                edSalario.error = "Insira um salário, por favor"
            }

            val empId = dbRef.push().key!!

            val empregador = empresaModelo(empId, empName, empCargo, empSalario)

            dbRef.child(empId).setValue(empregador)
                .addOnCompleteListener{
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                    edEmpresa.text.clear()
                    edCargo.text.clear()
                    edSalario.text.clear()

                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
        }
        //setContentView(R.layout.activity_cadastrar_vagas)
    }
}