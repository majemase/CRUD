package com.example.crud;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AlertDialog alertborrar, alertsalir;
    RecyclerView vistatareas;
    List<Tarea> listatareas = new ArrayList<Tarea>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addTarea();
        init();
    }

    public void init(){
        setSupportActionBar(findViewById(R.id.menuprincipal));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false)
                .setTitle(R.string.str_tituloborrar)
                .setMessage(R.string.str_textoborrar)
                .setNegativeButton(R.string.str_no, null)
                .setPositiveButton(R.string.str_si, (dialog, which) -> {});
        alertborrar = builder.create();

        builder.setCancelable(false)
                .setTitle(R.string.str_salir)
                .setMessage(R.string.str_textosalir)
                .setNegativeButton(R.string.str_no, null)
                .setPositiveButton(R.string.str_si, (dialog, which) -> finish());
        alertsalir = builder.create();

        vistatareas = findViewById(R.id.vistatareas);

        LinearLayoutManager disposicion = new LinearLayoutManager(getApplicationContext());
        vistatareas.setLayoutManager(disposicion);
        AdaptadorTarea adapter = new AdaptadorTarea(listatareas);
        vistatareas.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuadd){

        } else if (item.getItemId() == R.id.menusalir) {
            alertsalir.show();
        } else if (item.getItemId() == R.id.menucategoria) {

        } else if (item.getItemId() == R.id.menufecha) {

        }
        return false;
    }

    private void addTarea(){
        Tarea t;

        t = new Tarea("Limpiar la cocina", new Date(), 1);
        listatareas.add(t);
        t = new Tarea("Comprar pan", new Date(), 2);
        listatareas.add(t);
        t = new Tarea("Estudiar PMDM", new Date(), 3);
        listatareas.add(t);
        t = new Tarea("Estudiar AD", new Date(), 3);
        listatareas.add(t);
        t = new Tarea("Limpiar el baño", new Date(), 1);
        listatareas.add(t);
        t = new Tarea("Echar gasolina", new Date(), 2);
        listatareas.add(t);
        t = new Tarea("Comprar Cafe", new Date(), 2);
        listatareas.add(t);
        t = new Tarea("Estudiar PSP", new Date(), 3);
        listatareas.add(t);
    }
}

