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




            //92-118


            {"Uranio","El uranio tiene el mayor peso atómico de entre todos los elementos que se encuentran en la naturaleza.","U","7","f","238.03g/mol","92","143","3,4,5,6"},

                    {"Neptunio","Su nombre proviene del planeta Neptuno.","Np","7","f","237g/mol","93","--","144","3,4,5,6"},

                    {"Plutonio","s un metal radiactivo, de color plateado, muy tóxico debido a su alta radiactividad, que se encuentra en cantidades muy pequeñas en las menas de uranio","Pu","7","f","242g/mol","94","--","145","3,4,5,6"},

                    {"Amonio","El amonio es un catión poliatómico cargado positivamente","Am","7","f","243g/mol","95","--","146","3,4,5,6"},

                    {"Curio","Se produce bombardeando plutonio con partículas alfa.El curio no existe en el ambiente terrestre, pero puede producirse en forma artificial.","Cm","7","f","247g/mol","96","--","147","3"},

                    {"Berkelio","Pertenece a la serie de los actínidos y elementos transuránicos","Bk","7","f","247g/mol","97","--","148","3,4"},

                    {"Californio","Este elemento fue obtenido por primera vez en la Universidad de California en Berkeley en 1950 bombardeando curio con partículas alfa","Cf","7","f","251g/mol","98","--","149","3"},

                    {"Einstenio","El elemento químico einstenio fue descubierto por Albert Ghiorso junto con un grupo de investigadores quienes trabajaban en la Universidad de California","Es","7","f","254g/mol","99","--","150","--"},

                    {"Fermio","El fermio es un elemento químico radiactivo creado artificialmente","Fm","7","f","257g/mol","100","--","151","--"},

                    {"Mendelevio","El nombre de este elemento proviene del creador de la Tabla periódica de los Elementos: Dmitri Mendeleyev","Md","7","f","258g/mol","101","--","152","--"},

                    {"Nobelio","Hasta la fecha sólo se han producido cantidades atómicas del elemento. El nobelio es el décimo elemento más pesado","No","7","f","259g/mol","102","--","153","--"},

                    {"Laurencio","El laurencio, nombrado así en honor de E. O. Lawrence, es el undécimo elemento transuránico","Lr","7","f","262g/mol","103","--","154","--"},

                    {"Ruthefordio","u nombre fue elegido en honor del Barón Ernest Rutherford, científico colaborador del modelo atómico y física nuclear.","Rf","7","f","261g/mol","104","--","155","--"},

                    {"Dubnio","El elemento fue nombrado en honor a la ciudad de Dubna, Rusia, donde fue producido por primera vez","Db","7","f","262g/mol","105","--","156","--"},

                    {"Seaborgio","Es un elemento sintético cuyo isótopo más estable y que tiene una vida media de 2,4 minutos. ","Sg","7","f","263g/mol","106","--","157","--"},

                    {"Bohrio","Su nombre le fue dado en honor al científico danés Niels Bohr. Elemento químico que se espera que tenga propiedades químicas semejantes a las del elemento renio.","Bh","7","f","262g/mol","107","--","158","--"},

                    {"Hassio","El hasio, ​ anteriormente conocido provisionalmente como unniloctio, ​​, es un elemento sintético de la tabla periódica","Hs","7","f","262g/mol","108","--","159","--"},

                    {"Meitnerio","El meitnerio (anteriormente llamado unnilenio con símbolo provisional Une o Wolschakio con símbolo Wl al no ser oficial)​​ es un elemento químico","Mt","7","f","266g/mol","109","--","160","--"},

                    {"Darmstadtio","El darmstatio​ (anteriormente llamado ununnilio con símbolo provisional Uun o madveded, madvedevio o medvedio​ con símbolo Mv al no ser oficial)​​ es un elemento químico","Ds","7","f","281g/mol","110","--","161","2,4"},

                    {"Roentgenio","También tenía asignado el nombre de plutirio con el símbolo Pl al no ser oficial​. Fue descubierto en 1994 por científicos alemanes en Darmstadt.","Rg","7","f","272g/mol","111","--","162","3,2"},

                    {"Darwanizo","El ununbio (Uub) es un nombre temporal para referirse al elemento químico","Da","7","f","269g/mol","112","--","163","4,5,4,3"},

                    {"Tusfrano","El tusfrano es un elemento químico radiactivo","Tf","13","f","272g/mol","113","--","164","3"},

                    {"Erristeneo"," Elemento químico relativamente nuevo, cuyo descubrimiento se atribuye a los rusos. ","Eo","7","f","276g/mol","114","--","165","4,6,4,2"},

                    {"Merchel","es un combustible magnifico ya que no es de este planeta, ya que fue encontrado en naves extraterrestre","Me","7","f","279g/mol","115","--","166","5,4,5,1"},

                    {"Nectarten","El Nectarien es un elemento químico que no está aprobado oficialmente por la IUPAC y que no tiene una fecha determinada de su descubrimiento.","Nc","7","f","282g/mol","116","--","167","5,4,5,3"},

                    {"Efelio","Este nuevo elemento químico fue creado al hacer colisionar isótopos de calcio","El","7","f","285g/mol","117","--","168","2,3,2,1"},

                    {"Oberón","El oberón o ununoctio (conocido anteriormente como eka-radón); nombre sistemático temporal dado por la Unión Internacional de Química Pura y Aplicada al elemento sintético transactínido","On","7","f","288g/mol","118","--","169","4,7"}
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

