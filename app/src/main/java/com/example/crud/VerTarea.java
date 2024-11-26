package com.example.crud;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VerTarea extends AppCompatActivity {

    TextView titulotarea, fecha, hora, descripcion, nombrecat;
    ImageView categoria;
    Button btnvolver, btneditar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ver_tarea);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        Intent intent = getIntent();
        int id_tarea = intent.getIntExtra("id", -1);

        Tarea t = buscarTarea(id_tarea);
        cargarDatos(t);

        btnvolver.setOnClickListener(v -> {
            finish();
        });

        btneditar.setOnClickListener(v -> {
            Intent intentaccion = new Intent(this, AccionTarea.class);
            intentaccion.putExtra("id", id_tarea);
            startActivity(intentaccion);
        });
    }

    public void init(){
        titulotarea = findViewById(R.id.titulotarea);
        fecha = findViewById(R.id.fecha);
        hora = findViewById(R.id.hora);
        descripcion = findViewById(R.id.descripcion);
        categoria = findViewById(R.id.categoria);
        nombrecat = findViewById(R.id.nombrecat);
        btnvolver = findViewById(R.id.btnvolver);
        btneditar = findViewById(R.id.btneditar);
    }

    public void cargarDatos(Tarea t){
        titulotarea.setText(t.getTitulo());
        Date fechahora = t.getFecha_hora();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm");
        fecha.setText(formatofecha.format(fechahora));
        hora.setText(formatohora.format(fechahora));
        descripcion.setText(t.getDescripcion());
        switch (t.getCategoria()) {
            case 1:
                categoria.setImageResource(R.drawable.categoria1);
                nombrecat.setText(R.string.str_categoria1);
                break;
            case 2:
                categoria.setImageResource(R.drawable.categoria2);
                nombrecat.setText(R.string.str_categoria2);
                break;
            case 3:
                categoria.setImageResource(R.drawable.categoria3);
                nombrecat.setText(R.string.str_categoria3);
                break;
        }
    }

    public Tarea buscarTarea(int id){
        for(Tarea t : MainActivity.listatareas){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }
}
