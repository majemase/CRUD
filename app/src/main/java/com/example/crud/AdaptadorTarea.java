package com.example.crud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdaptadorTarea extends RecyclerView.Adapter<AdaptadorTarea.HolderTarea> {
    List<Tarea> dataset;

    public AdaptadorTarea(List<Tarea> listTareas){
        dataset = listTareas;
    }

    @NonNull
    @Override
    public AdaptadorTarea.HolderTarea onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new HolderTarea(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorTarea.HolderTarea holder, int position) {
        Tarea t = dataset.get(position);
        holder.titulotarea.setText(t.getTitulo());

        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm");

        holder.fecha.setText(formatofecha.format(t.getFecha_hora()));
        holder.hora.setText(formatohora.format(t.getFecha_hora()));

        switch (t.getCategoria()){
            case 1:
                holder.categoriatarea.setImageResource(R.drawable.categoria1);
                break;
            case 2:
                holder.categoriatarea.setImageResource(R.drawable.categoria2);
                break;
            case 3:
                holder.categoriatarea.setImageResource(R.drawable.categoria3);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class HolderTarea extends RecyclerView.ViewHolder{
        TextView titulotarea, fecha, hora;
        ImageView categoriatarea;

        public HolderTarea(@NonNull View itemView) {
            super(itemView);
            titulotarea = itemView.findViewById(R.id.titulotarea);
            fecha = itemView.findViewById(R.id.fechatarea);
            hora = itemView.findViewById(R.id.horatarea);
            categoriatarea = itemView.findViewById(R.id.categoriatarea);
        }
    }
}
