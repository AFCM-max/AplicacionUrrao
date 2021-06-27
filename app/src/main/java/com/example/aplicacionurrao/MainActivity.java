package com.example.aplicacionurrao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Iglesia iglesia;
    ImageView fotoIglesia;
    TextView descripcion;
    TextView nombreIglesia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fotoIglesia=findViewById(R.id.fotoIglesia);
        descripcion=findViewById(R.id.descripcion);
        nombreIglesia =findViewById(R.id.nombreiglesia);

        iglesia =(Iglesia) getIntent().getSerializableExtra("datosTuristico");
        fotoIglesia.setImageResource(iglesia.getFotoIglesia());
        descripcion.setText(iglesia.getDescripcion());
        nombreIglesia.setText(iglesia.getNombreIglesia());



    }
}