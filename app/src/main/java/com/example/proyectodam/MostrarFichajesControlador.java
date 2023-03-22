package com.example.proyectodam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MostrarFichajesControlador extends AppCompatActivity {
    RecyclerView recyclerViewEmpleado;
    Adaptador empleadosAdaptador;
    FirebaseFirestore bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrat_fichajes_controlador);
        recyclerViewEmpleado = findViewById(R.id.recyclerEmpleados);
        recyclerViewEmpleado.setLayoutManager(new LinearLayoutManager(this));
        bd = FirebaseFirestore.getInstance();
        String DNI = getIntent().getExtras().getString("DNI_recogido");

        Query query = bd.collection("REGISTROS DE LOS EMPLEADOS").whereEqualTo("DNI", DNI);

        FirestoreRecyclerOptions<Empleado> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Empleado>().setQuery(query,Empleado.class).build();

            empleadosAdaptador = new Adaptador(firestoreRecyclerOptions);
            empleadosAdaptador.notifyDataSetChanged();
            recyclerViewEmpleado.setAdapter(empleadosAdaptador);


    }

    @Override
    protected void onStart() {
        super.onStart();
        empleadosAdaptador.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        empleadosAdaptador.stopListening();
    }
}