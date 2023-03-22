package com.example.proyectodam

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*






class MainActivity2 : AppCompatActivity()
{
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val db = FirebaseFirestore.getInstance()
        val botonCerrar = findViewById<Button>(R.id.botonCerrarSesion)
        val botonMostrarListado = findViewById<Button>(R.id.botonListado)
        val botonFicharEntrada = findViewById<Button>(R.id.ficharEntrada)




        botonCerrar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        botonFicharEntrada.setOnClickListener {

            val bundle = intent.extras
            val DNI_1= bundle?.getString("DNI")

            val dia = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now())
            val hora = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now())
            val nombre_documento ="$dia $hora"
            val registro = hashMapOf(

                "DNI" to DNI_1,
                "DIA" to dia,
                "HORA" to hora,
                "TIPO" to "ENTRADA")
            if (DNI_1 != null) {
                db.collection("REGISTROS DE LOS EMPLEADOS").document(nombre_documento).set(registro)
                Toast.makeText(this, "ENTRADA REGISTRADA CORRECTAMENTE", Toast.LENGTH_SHORT)
                    .show()
            }



        }



        val botonFicharSalida = findViewById<Button>(R.id.ficharSalida)
        botonFicharSalida.setOnClickListener {

            val bundle = intent.extras
            val DNI_1= bundle?.getString("DNI")


            var dia = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now())
            var hora = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now())
            val nombre_documento = "$dia $hora"

            val registro = hashMapOf(

                "DNI" to DNI_1,
                "DIA" to dia,
                "HORA" to hora,
                "TIPO" to "SALIDA")
            if (DNI_1 != null) {
                db.collection("REGISTROS DE LOS EMPLEADOS").document(nombre_documento).set(registro)
                Toast.makeText(this, "SALIDA REGISTRADA CORRECTAMENTE", Toast.LENGTH_SHORT)
                    .show()

            }


        }





        botonMostrarListado.setOnClickListener {

            val bundle = intent.extras
            val DNI_1= bundle?.getString("DNI")



            var i = Intent(this,MostrarFichajesControlador::class.java)
            i.putExtra("DNI_recogido", DNI_1)
            startActivity(i)



        }






    }



    }



