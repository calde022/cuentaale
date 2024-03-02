package com.example.cuentas_alejandro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btingresar : Button = findViewById(R.id.btningresar)
        val txtemail : TextView = findViewById(R.id.edtEmail)
        val txtpass : TextView = findViewById(R.id.edtPassword)
        val btnCrear_CuentaNueva :TextView = findViewById(R.id.btncrearcuenta)
        firebaseAuth = Firebase.auth
        btingresar.setOnClickListener()
        {
signIn(txtemail.text.toString(),txtpass.toString())
        }
        btnCrear_CuentaNueva.setOnClickListener(){
            val i = Intent (this,crearcuentaActivity::class.java)
                startActivity(i)
        }
    }
    private fun signIn(email: String, password: String)
    {
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    Toast.makeText(baseContext,"Atenticacion exitosa",Toast.LENGTH_SHORT).show()
                    //aqui veremos si ira ala segunda activity//
val i = Intent(this,MainActivity2::class.java)
                    startActivity(i)
                } else
                {
                    Toast.makeText(baseContext,"error de email o contraseña", Toast.LENGTH_SHORT).show()
                }

                }

        }
    }
