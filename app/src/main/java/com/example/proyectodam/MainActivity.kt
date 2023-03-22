package com.example.proyectodam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        FirebaseApp.initializeApp(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonIniciarSesion = findViewById<Button>(R.id.botonIniciarSesion)
        val db = FirebaseFirestore.getInstance()


        var DNI_real: String
        var password_real: String
        val context = applicationContext
        fun limpiarVariables() {
            DNI_real = ""
           password_real= ""

        }

        fun comprobar() {
            val DNI = findViewById<EditText>(R.id.etDNI)
            val DNI_1 = DNI.text.toString()
            val password = findViewById<EditText>(R.id.etPassword)
            val password_1 = password.text.toString()
            if (DNI.text.isEmpty()) {
                Toast.makeText(context, "Introduzca su DNI.", Toast.LENGTH_SHORT).show()

            } else if (password.text.isEmpty()) {
                Toast.makeText(context, "Introduzca su contraseña.", Toast.LENGTH_SHORT).show()

            } else {

                db.collection("INFORMACIÓN DE EMPLEADOS").document(DNI_1).get()
                    .addOnSuccessListener { document ->



                            if (document.exists()) {
                                DNI_real = document.get("DNI") as String
                                password_real = document.get("CONTRASEÑA") as String
                                println(DNI_real)
                                println(DNI_1)
                                println("---------------------")
                                println(password_real)
                                println(password_1)
                                if (DNI_1 == DNI_real && password_1 == password_real) {
                                    Toast.makeText(context, "Datos correctos.", Toast.LENGTH_SHORT)
                                        .show()
                                    val intent = Intent(this, MainActivity2::class.java)
                                    intent.putExtra("DNI", DNI_1)
                                    startActivity(intent)

                                } else {
                                    Toast.makeText(context, "Datos erroneos.", Toast.LENGTH_SHORT)
                                        .show()
                                    println(DNI_1)
                                    println(password_1)

                                    println("-------")
                                    println(DNI_real)
                                    println(password_real)
                                }
                            } else {
                                Toast.makeText(context, "Datos erroneos.", Toast.LENGTH_SHORT)
                                    .show()


                            }


                        }

                    }
            }
            botonIniciarSesion.setOnClickListener {
                comprobar()
                limpiarVariables()

            }


        }


    }

