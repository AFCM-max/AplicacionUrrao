package com.example.aplicacionurrao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Home extends AppCompatActivity {
    ArrayList<Iglesia> listadedatos= new ArrayList<>();
    RecyclerView listaGrafica;
    Map<String, Object> user = new HashMap<>();

    FirebaseFirestore baseDatos=FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listaGrafica=findViewById(R.id.listado);
        listaGrafica.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        creacionlista();


    }

    public void cambiarIdioma(String lenguaje){
        Locale idioma=new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration configurationtelefono=getResources().getConfiguration();
        configurationtelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configurationtelefono,getBaseContext().getResources().getDisplayMetrics());
    }




    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        switch (id){
            case(R.id.opcion1):
                Intent intent1=new Intent(Home.this,Acerca.class);
                startActivity(intent1);
            break;
            case(R.id.opcion2):
                cambiarIdioma("en");
                Intent intent2=new Intent(Home.this,Home.class);
                startActivity(intent2);
                break;
            case(R.id.opcion3):
                cambiarIdioma("es");
                Intent intent3=new Intent(Home.this,Home.class);
                startActivity(intent3);
                break;
        }

        return super.onOptionsItemSelected(item);



    }

    private void creacionlista(){
        baseDatos.collection("urrao")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String nombre=document.get("nombre").toString();
                                String descripcion=document.get("descripcion").toString();
                                String foto=document.get("foto").toString();

                                listadedatos.add(new Iglesia(nombre,foto,descripcion));
                            }
                            listaAdaptador adaptador=new listaAdaptador(listadedatos);
                            listaGrafica.setAdapter(adaptador);
                    }else{
                            Toast.makeText(Home.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}