package com.example.cuentas_alejandro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class crearcuentaActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crearcuenta)
        val txtnombre_nuevo: TextView = findViewById(R.id.edtnombre)
        val txtemail_nuevo: TextView = findViewById(R.id.editTextText2)
        val txtpassword1: TextView = findViewById(R.id.edtpassword)
        val txtpassword2: TextView = findViewById(R.id.edtPassword2)
        val bntCrear: Button = findViewById(R.id.btncrearcuentanueva)
        bntCrear.setOnClickListener() {
            var pass1 = txtpassword1.text.toString()
            var pass2 = txtpassword2.text.toString()
            if (pass2.equals(pass2))
            {
createAccount(txtemail_nuevo.text.toString(),txtpassword1.text.toString())
            } else {
                Toast.makeText(baseContext, "Error:los passwords no coinciden", Toast.LENGTH_SHORT)
                    .show()
                txtpassword1.requestFocus()
            }
        }

        firebaseAuth = Firebase.auth

    }

    private fun createAccount(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "cuenta creada correctamente", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(
                        baseContext,
                        "algo salio mal" + task.exception,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
    }
}
