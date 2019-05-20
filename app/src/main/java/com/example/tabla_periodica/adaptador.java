package com.example.tabla_periodica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptador extends BaseAdapter {

    
    private static LayoutInflater inflater = null;
    Context contexto;
    String[][] elemento;
    int[] datosImg;

    public adaptador(Context conexto, String[][] elementos, int[] datosImg) {
        this.contexto = conexto;
        this.elemento = elementos;
        this.datosImg =  datosImg;
        inflater = (LayoutInflater) conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.contenedor, null);
        ImageView Foto=(ImageView)vista.findViewById(R.id.img);
        TextView Elemento=(TextView) vista.findViewById(R.id.t_1);
        TextView contenido=(TextView) vista.findViewById(R.id.t_2);
        Elemento.setText(elemento[position][0]);
        contenido.setText(elemento[position][1]);
        Foto.setImageResource(datosImg[position]);


        return vista;
    }

}
