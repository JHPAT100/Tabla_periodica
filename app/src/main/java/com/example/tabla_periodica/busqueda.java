package com.example.tabla_periodica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class busqueda extends AppCompatActivity {
    private ListView lista;
    private adaptador Adaptador;
    private EditText buscar;


    String elementos[][] = {
//Nombre,descripción,simbolo,grupo,bloque,masa,protones,electrones,neutrones,valencia,
            {"Paladio", "Hola este elemento esta vacio", "46", "Pd", "VIIIB", "d", "106.42(g/mol)", "46", "46", "60", "+2, +4, +6"},
            {"Plata", "Hola este elemento esta vacio","47", "Ag", "IB", "d", "107.868(g/mol)", "47", "47", "61", "+1, +2"},

    };
    int[] datosImg = {R.drawable.icono_b, R.drawable.logo,};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        lista = (ListView) findViewById(R.id.lista_1);
        Adaptador = new adaptador(this, elementos, datosImg);
        lista.setAdapter(Adaptador);
        buscar = findViewById(R.id.busqueda);


    }
}

