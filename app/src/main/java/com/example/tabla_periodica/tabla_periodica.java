package com.example.tabla_periodica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class tabla_periodica extends AppCompatActivity {
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_periodica);


    }

    public void onClick(View view){
        btn=findViewById(view.getId());
        Intent onClick=new Intent(this,prueba.class);
        startActivity(onClick);

    }
    public void onClick_1(View view){
        btn=findViewById(view.getId());
        Intent onClick_1=new Intent(this,busqueda.class);
        startActivity(onClick_1);

    }

}


