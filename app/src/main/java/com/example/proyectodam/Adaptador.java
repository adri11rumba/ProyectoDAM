package com.example.proyectodam;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Adaptador extends FirestoreRecyclerAdapter<Empleado,Adaptador.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adaptador(@NonNull FirestoreRecyclerOptions<Empleado> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Empleado empleado) {
        holder.textViewTipo.setText(empleado.getTIPO());
        holder.textViewHora.setText(empleado.getHORA());
        holder.textViewDia.setText(empleado.getDIA());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vista_fichajes, viewGroup, false);
        return new ViewHolder(view);

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewDia;
        TextView textViewHora;
        TextView textViewTipo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            textViewDia = itemView.findViewById(R.id.textViewDia);
            textViewHora = itemView.findViewById(R.id.textViewHora);
            textViewTipo = itemView.findViewById(R.id.textViewTipo);



            }


        }

        }





