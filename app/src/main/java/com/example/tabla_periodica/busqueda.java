package com.example.tabla_periodica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.security.Provider;
import java.util.ArrayList;

public class busqueda extends AppCompatActivity {
    public static int posi;
    public static CharSequence indetificador_1;
    String[] nombres={"Hidrógeno","Helio","Litio","Berilio","Boro","Carbono","Nitrógeno","Oxígeno","Fluor","Neón","Sodio","Magnesio","Aluminio","Sílice","Fósforo","Azufre","Cloro","Argón","Potasio","Calcio",
            "Escandio","Titanio","Vanadio","Cromo","Manganeso","Hierro","Cobalto","Níquel","Cobre","Zinc","Galio","Germanio","Arsénico","Selenio","Bromo","Kryptón","Rubidio","Estroncio",
            "Itrio","Zirconio","Niobio","Molibdeno","Tecnecio","Rutenio","Rodio","Paladio","Plata","Cadmio","Indio","Estaño","Antimonio","Teluro","Iodo","Xenón","Cesio","Bario","Lantano","Cerio",
            "Praseodimio","Neodimio","Promecio","Samario","Europio","Gadolinio","Terbio","Disprosio","Holmio","Erbio","Tulio","Iterbio","Lutecio","Hafnio","Tantalio","Wolframio","Renio","Osmio",
            "Iridio","Platino","Oro","Mercurio","Talio","Plomo","Bismuto","Polonio","Ástato","Radón","Francio","Radio","Actinio","Torio","Protactinio","Uranio","Neptunio","Plutonio","Americio",
            "Curio","Berkelio","Californio","Einstenio","Fermio","Mendelevio","Nobelio","Lawrencio","Rutherfordio","Dubnio","Seaborgio","Bohrio","Hassio",	"Meitnerio","Darmstadio",
            "Roentgenium","Copernicium","Nihonium","Flerovium","Moscovium","livermorium","Tennessine","Organesson"
    };
    private ListView lista;
    private EditText filter;
    ArrayAdapter<String> adapter,adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        lista = (ListView) findViewById(R.id.lista_1);
        filter=findViewById(R.id.busqueda);
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombres);
        lista.setAdapter(adapter);
        //
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visor1=new Intent(view.getContext(),prueba.class);
                posi=position;
                indetificador_1="hola";
                startActivity(visor1);
            }
        });
        //
        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    }


