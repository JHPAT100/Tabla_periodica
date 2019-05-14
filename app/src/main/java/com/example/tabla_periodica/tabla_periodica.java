package com.example.tabla_periodica;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class tabla_periodica extends AppCompatActivity {
    public Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_periodica);

        for (int i=1; i<15; i++){
            int buttonId = this.getResources().getIdentifier("b_"+i, "id", this.getPackageName());
            Button btn = (Button)findViewById(buttonId);

        }

    }

}

