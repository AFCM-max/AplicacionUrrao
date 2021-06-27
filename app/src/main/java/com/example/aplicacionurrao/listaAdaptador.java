package com.example.aplicacionurrao;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class listaAdaptador extends RecyclerView.Adapter<listaAdaptador.viewHolder> {

    ArrayList<Iglesia> listadedatos;

    public listaAdaptador(ArrayList<Iglesia> listadedatos) {
        this.listadedatos = listadedatos;
    }

    @NonNull
    @Override
    public listaAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaLista= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.irem, null,false);
        return new viewHolder(vistaLista);
    }

    @Override
    public void onBindViewHolder(@NonNull listaAdaptador.viewHolder holder, int position) {
        holder.actualizar(listadedatos.get(position));

    }

    @Override
    public int getItemCount() {
        return listadedatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView nombreIglesia;
        ImageView fotoIglesia;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombreIglesia=itemView.findViewById(R.id.nombreiglesia);
            fotoIglesia=itemView.findViewById(R.id.fotoIglesia1);

        }

        public void actualizar(Iglesia iglesia) {
            nombreIglesia.setText(iglesia.getNombreIglesia());
            fotoIglesia.setImageResource(iglesia.getFotoIglesia());



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MainActivity.class);
                    intent.putExtra("datosTuristico",iglesia);
                    itemView.getContext().startActivity(intent);
                }


            });
        }
    }
}
