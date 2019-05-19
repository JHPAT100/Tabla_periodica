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

             //46-91
                      {"Paladio","Es un raro y brillante metal de color plateado, fue nombrado así por el asteroide Pallas.","46","Pd","VIIIB","d","106.42(g/mol)","46","46","60","+2, +4, +6"},

                      {"Plata","Es un metal de transición suave, de color blanco y brillante, posee la mas alta conductividad eléctrica, térmica y reflectiva entre los metales.","47","Ag","IB","d","107.868(g/mol)","47","47","61","+1, +2"},

                      {"Cadmio","Es un metal suave, de color blanco-azulado, químicamente es similar al Zinc y al Mercurio, tiene un  bajo punto de fusión a comparación con otros metales.","48","Cd","IIB","d","112.411(g/mol)","48","48","64","+1, +2"},

                      {"Indio","Es un metal de transición suave, maleable y con un bajo punto de fusión, el cual es más alto que el del Sodio pero más bajo que el del Litio o el Estaño.","49", "In","P","IIIA","114.818(g/mol)","49","49","66","+1, +2, +3"},

                      {"Estaño","Muestra un similitud química con el Germanio y el Plomo, forma parte de grupo principal en el grupo 14 de la tabla periódica.","50","Sn","p","IVA","118.710(g/mol)","50","50","69","+2, +4"},

                      {"Antimonio","Es un metaloide gris brillante, se encuentra principalmente en la naturaleza como el mineral sulfuro de estibina, sus compuestos se conocen desde la antiguedad y eran usados en cosméticos.","51","Sb","P","VA","121.760(g/mol)","51","51","71","-3, +3, +4, +5"},

                      {"Telurio","Es un metaloide de color blanco-plateado, frágil, levemente tóxico y raro, químicamente esta relacionado con el Selenio y el Azufre.","52","Te","p","VIA","127.60(g/mol)","52","52","75","-2, +2, +4, +6"},

                      {"Yodo","El yodo y sus compuestos se utilizan en nutrición, en la producción de ácido acético y ciertos polimeros, su nombre proviene del griego y significa violeta o purpura, debido al color del vapor del Yodo","53","I","p","VIIA","126.904(g/mol)","53","53","74","-1, +1, +3, +4, +5, +7"},

                      {"Xenón","Es un gas noble incoloro, denso e inodoro, se produce en la atmósfera de la tierra  en cantidades mínimas","54","Xe","p","VIIA","131.293(g/mol)", "54","54","77","0"},

                      {"Cesio","Es un metal alcalino suave de color dorado-plateado, su punto de fusión es de 28c°, es uno de los 5 metales que se encuentran en estado líquido en o cerca de la temperatura ambiente.","55","Cs","s","IA","132.905(g/mol)","55","55","78","+1"},

                      {"Bario","Es un metal alcalinotérreo de color plateado métalico, debido a su alta reactividad química nunca se encuentra como un elemento libre en la naturaleza.","56","Ba","s","IIA","137.327(g/mol)","56","56","81","+2"},

                      {"Lantano","Es un metal  blando, dúctil, de color blanco-plateado, se lustra rapidamente cuando se expone al aire y es lo suficientemente suave para cortarlo con un cuchillo.","57","La","d","IIB","138.905(g/mol)", "57","57","82","+3"},

                      {"Cerio","Es un metal blando, plateado y dúctil el cual se oxida fácilmente al exponerlo al aire.","58","Ce","f","-","140.116(g/mol)", "58","58","82","+3, +4"},

                      {"Praseodimio","Es un metal blando, plateado, dúctil y maleable, es valorado por sus propiedades magnéticas, eléctricas, químicas y ópticas.","59","Pr","f","-","140.904(g/mol)","59","59","82","+3"},

                      {"Neodimio","Es un metal de color plateado, suave que se deslustra con el aire.","60","Nd","f","-","144.242(g/mol)","60","60","84","+3, +4"},

                      {"Prometio","Químicamente es un lantanido que forma sales cuando se combina con otros elementos, todos sus isótopos son radioactivos.","61","Pm","f","-","146.915(g/mol)","61","61","85","+3"},

                      {"Samario","Es un metal plateado moderadamente duro que se oxida fácilmente con el aire.","62","Sm","f","-","150.36(g/mol)","62","62","88","+2, +3"},

                      {"Europio","Es un metal moderadamente duro que se oxida fácilmente con el aire y el agua, lleva el nombre de el continente de Europa.","63","Eu","f","-","151.964(g/mol)","63","63","89","+2, +3"},

                      {"Gadolinio","Es un metal de tierra rara, de color blanco-plateado, maleable y dúctil, en la naturaleza solo se encuentra de forma combinada.","64","Gd","f","-","157.25(g/mol)","64","64","93","+3"},

                      {"Terbio","Es un metal de tierra rara de color blanco-plateado,maleable, dúctil y lo suficientemente suave para cortarlo con un cuchillo, nunca se encuentra en la naturaleza como un elemento libre.","65","Tb","f","-","158.925(g/mol)","65","65","93","+3, +4"},

                      {"Disprosio","Es un elemento de tierra rara con un brillo metálico plateado, nunca se encuentra en la naturaleza como un elemento libre.","66","Dy","f","-","162.500(g/mol)","66","66","96","+3"},

                      {"Holmio","Elemento de tierra rara, forma parte de el grupo de los lantanidos","67","Ho","f","-","164.93(g/mol)","67","67","97","+3"},

                      {"Erbio","Metal solido de color blanco-plateado cuando se encuentra aislado artificialmente, es un elemento de tierra rara que se asocia con otros minerales de raros en el mineral gadolinita de Ytterby","68","Er","f","-","167.259(g/mol)","68","68","99","+3"},

                      {"Tulio","Es el antepenultimo de la serie de los lantanidos y aligual que los otros lantanidos su estado de oxidación mas común es +3","69","Tm","f","-","168.934(g/mol)","69","69","99","+2, +3"},

                      {"Iterbio","Es el penúltimo de la serie de los lantánidos, al igual que los otros lantánidos su estado de oxidación mas común es +3, visto en su óxido, haluros y otros compuestos.","70","Yb","f","-","173.04(g/mol)","70","70","103","+2, +3"},

                      {"Lutecio","Es uno de los elementos del bloque d pero con freciencia se le suele incluir en los lantánidos debido a que comparte muchas propiedades con estos, de todos ellos es el mas difícil de aislar.","71","Lu","f","-","174.967(g/mol)","71","71","103","+3"},

                      {"Hafnio","Es un metal de transición tetravalente, brillante, plateado y de color gris, se asemeja químicamente al Circonio y se encuentra en minerales de circonio.","72","Hf","d","IVB","178.49(g/mol)","72","72","106","+4"},

                      {"Tantalo","Su nombre proviene de Tántalo, un antiheroe de la mitología griega, es un metal de transición lustroso, raro, duro, de color gris_azulado que es altamente resistente a la corrosión. ","73","Ta","d","VB","180.947(g/mol)","73","73","108","+3, +4, +5"},

                      {"Wolframio","Tambien conocido como tungsteno, palabra que proviene de la lengua sueca tung sten que significa piedra pesada.","74","W","d","VIB","183.84(g/mol)","74","74","109","+2, +3, +4, +5, +6"},

                      {"Renio","Es un metal de transición de la tercera fila, grueso y de color plateado, es uno de los elementos más raros en la corteza terrestre.","75","Re","d","VIIB","186.207(g/mol)","75","75","111","-1, +2, +3, +4, +5, +6, +7"},

                      {"Osmio","Es un metal de transición de color blanco_azulado, duro y frágil en el grupo del platino que se encuentra como un elemento traza en las aleaciones. Es el elemento natural más denso.","76","Os","d","VIIIB","190.23(g/mol)","76","76","115","+2, +3, +4, +6, +8"},

                      {"Iridio","Es unmetal de transición duro, frágil, de color platino-blanco, generalmente se le atribuye como el segundo elemento  más denso  basado en la densidad medida.","77","Ir","d","VIIIB","192.217(g/mol)","77","77","115","+1, +2, +3, +4, +6"},

                      {"Platino","Es unmmetal de transición denso, maleable, dúctil, altamente no reactivo, precioso y de color gris-blanco, su nombre deriva del termino español platina, que se traduce como poca plata.  ","78","Pt","d","VIIIB","195.084(g/mol)","78","78","117","+1, +2, +3, +4, +6"},

                      {"Oro","En su forma más pura, es un metal brillante, ligeramente rojizo, denso, suave, maleable y dúctil, químicamente es un metal de transición.","79","Au","d","IB","196.966(g/mol)","79","79","118","+1, +2, +3"},

                      {"Mercurio","Es un elemento del bloque d pesado y de color plateado, es el único elemento metálico que es líquido en condiciones estándar de temperatura y presión.","80","Hg","d","IIB","200.59(g/mol)","80","80","120","+1, +2"},

                      {"Talio","Es un metal de transición suave y de color gris, no se encuentra libre en la naturaleza, cuando se encuentra aislado, se parece al estaño pero se decolora al exponerlo al aire.","81","Tl","p","IIIB","204.383(g/mol)","81","81","123","+1, +2, +3"},

                      {"Plomo","Es u metal blando, maleable y pesado despues de la transición, al exponerlo al aire se torna de un color gris o opaco.","82","Pb","p","IVA","207.2(g/mol)", "82","82","125","+2, +4"},

                      {"Bismuto","Es unmetal de transición posterior pentavalente, químicamente se asemeja al arsénico y el antimonio, los cristales de bismuto  suelen adoptar formas geométricas y poseen una amplia grama de colores.","83","Bi","p","VA","208.9804(g/mol)","83","83","126","-3, +2, +3, +4, +5"},

                      {"Polonio","Es un elemento raro y altamente radioactivo sin isótopos estables, es químicamente similar al bismuto y al telurio, sus aplicaciones son pocas.","84","Po","p","VIB","208.9824(g/mol)","84","84","126","-2, +2, +4, +6"},

                      {"Ástato","Ocurre en la Tierra como el producto de desintegración de varios elementos más pesados. Todos sus isótopos son de corta duración.","85","At","p","VIIA","209.9871(g/mol)","85","85","125","-"},

                      {"Radón","Es un gas noble radioactivo, incoloro, inodoro e insípido, que se produce naturalmente como producto de la desintegración del radio.","86","Rn","p","VIIIB","222.0176(g/mol)","86","86","136","0"},

                      {"Francio","Es el segundo elemento menos electronegativo, solo detras del cesio, es un metal altamente radioactivo que se descompone en astatino, radio y radón.","87","Fr","s","IA","223.0197(g/mol)","87","87","136","-"},

                      {"Radio","El radio puro es casi incoloro, pero se combina fácilmente con nitrógeno en la exposición al aire, formando una capa negra de nitruro de radio.","88","Ra","s","IIA","226.0254(g/mol)","88","88","138","+2"},

                      {"Actinio","Fue el primer elemento radioactivo no primordial en aislarse, due descubierto en 1899.","89","Ac","d","IIIB","227.0278(g/mol)","89","89","138","+3"},

                      {"Torio","Es uno de los 2 elementos significativamente radioactivos que aún ocurren naturalmente en grandes cantidades como elemento primordial, el otro es el Uranio.","90","Th","f","-","232.0380(g/mol)","90","90","142","+4"},

                      {"Protactinio","Es un metal denso de color gris-plateado que reacciona fácilmente con el oxígeno, el vapor de agua y los ácidos inorgánicos.","91","Pa","f","-","231.0358(g/mol)","91","91","140","+5"},


                    //92-118


                    {"Uranio","El uranio tiene el mayor peso atómico de entre todos los elementos que se encuentran en la naturaleza.","U","7","f","238.03g/mol","92","143","3,4,5,6"},

                    {"Neptunio","Su nombre proviene del planeta Neptuno.","Np","7","f","237g/mol","93","--","144","3,4,5,6"},

                    {"Plutonio","s un metal radiactivo, de color plateado, muy tóxico debido a su alta radiactividad, que se encuentra en cantidades muy pequeñas en las menas de uranio","Pu","7","f","242g/mol","94","--","145","3,4,5,6"},

                    {"Amerecio","El amerecio es un catión poliatómico cargado positivamente","Am","7","f","243g/mol","95","--","146","3,4,5,6"},

                    {"Curio","Se produce bombardeando plutonio con partículas alfa.El curio no existe en el ambiente terrestre, pero puede producirse en forma artificial.","Cm","7","f","247g/mol","96","--","147","3"},

                    {"Berkelio","Pertenece a la serie de los actínidos y elementos transuránicos","Bk","7","f","247g/mol","97","--","148","3,4"},

                    {"Californio","Este elemento fue obtenido por primera vez en la Universidad de California en Berkeley en 1950 bombardeando curio con partículas alfa","Cf","7","f","251g/mol","98","--","149","3"},

                    {"Einstenio","El elemento químico einstenio fue descubierto por Albert Ghiorso junto con un grupo de investigadores quienes trabajaban en la Universidad de California","Es","7","f","254g/mol","99","--","150","--"},

                    {"Fermio","El fermio es un elemento químico radiactivo creado artificialmente","Fm","7","f","257g/mol","100","--","151","--"},

                    {"Mendelevio","El nombre de este elemento proviene del creador de la Tabla periódica de los Elementos: Dmitri Mendeleyev","Md","7","f","258g/mol","101","--","152","--"},

                    {"Nobelio","Hasta la fecha sólo se han producido cantidades atómicas del elemento. El nobelio es el décimo elemento más pesado","No","7","d","259g/mol","102","--","153","--"},

                    {"Lawrencio","El lawrencio, nombrado así en honor de E. O. Lawrence, es el undécimo elemento transuránico","Lr","7","d","262g/mol","103","--","154","--"},

                    {"Rutherfordio","Su nombre fue elegido en honor del Barón Ernest Rutherford, científico colaborador del modelo atómico y física nuclear.","Rf","7","d","261g/mol","104","--","155","--"},

                    {"Dubnio","El elemento fue nombrado en honor a la ciudad de Dubna, Rusia, donde fue producido por primera vez","Db","7","d","262g/mol","105","--","156","--"},

                    {"Seaborgio","Es un elemento sintético cuyo isótopo más estable y que tiene una vida media de 2,4 minutos. ","Sg","7","d","263g/mol","106","--","157","--"},

                    {"Bohrio","Su nombre le fue dado en honor al científico danés Niels Bohr. Elemento químico que se espera que tenga propiedades químicas semejantes a las del elemento renio.","Bh","7","d","262g/mol","107","--","158","--"},

                    {"Hasio","El hasio, ​ anteriormente conocido provisionalmente como unniloctio, ​​, es un elemento sintético de la tabla periódica","Hs","7","d","262g/mol","108","--","159","--"},

                    {"Meitnerio","El meitnerio (anteriormente llamado unnilenio con símbolo provisional Une o Wolschakio con símbolo Wl al no ser oficial)​​ es un elemento químico","Mt","7","d","266g/mol","109","--","160","--"},

                    {"Darmstadtio","El darmstatio​ (anteriormente llamado ununnilio con símbolo provisional Uun o madveded, madvedevio o medvedio​ con símbolo Mv al no ser oficial)​​ es un elemento químico","Ds","7","d","281g/mol","110","--","161","2,4"},

                    {"Roentgenio","También tenía asignado el nombre de plutirio con el símbolo Pl al no ser oficial​. Fue descubierto en 1994 por científicos alemanes en Darmstadt.","Rg","7","d","272g/mol","111","--","162","3,2"},

                    {"Copernico","El ununbio (Uub) es un nombre temporal para referirse al elemento químico","Cn","7","p","269g/mol","112","--","163","4,5,4,3"},

                    {"Nohonio","El tusfrano es un elemento químico radiactivo","Nh","13","p","272g/mol","113","--","164","3"},

                    {"Erristeneo"," Elemento químico relativamente nuevo, cuyo descubrimiento se atribuye a los rusos. ","Eo","7","p","276g/mol","114","--","165","4,6,4,2"},

                    {"Merchel","es un combustible magnifico ya que no es de este planeta, ya que fue encontrado en naves extraterrestre","Me","7","p","279g/mol","115","--","166","5,4,5,1"},

                    {"Nectarten","El Nectarien es un elemento químico que no está aprobado oficialmente por la IUPAC y que no tiene una fecha determinada de su descubrimiento.","Nc","7","p","282g/mol","116","--","167","5,4,5,3"},

                    {"Efelio","Este nuevo elemento químico fue creado al hacer colisionar isótopos de calcio","El","7","p","285g/mol","117","--","168","2,3,2,1"},

                    {"Oberón","El oberón o ununoctio (conocido anteriormente como eka-radón); nombre sistemático temporal dado por la Unión Internacional de Química Pura y Aplicada al elemento sintético transactínido","On","7","p","288g/mol","118","--","169","4,7"}
    };

    //Se agregaron todas las imagenes
    int[] datosImg = {R.drawable.icono_b, R.drawable.logo,R.drawable.e_46,R.drawable.e_47,R.drawable.e_48,

            R.drawable.e_49,R.drawable.e_50,R.drawable.e_51,R.drawable.e_52,R.drawable.e_53,R.drawable.e_54,

            R.drawable.e_55,R.drawable.e_56,R.drawable.e_57,R.drawable.e_58,R.drawable.e_59,R.drawable.e_60,

            R.drawable.e_61,R.drawable.e_62,R.drawable.e_63,R.drawable.e_64,R.drawable.e_65,R.drawable.e_66,

            R.drawable.e_67,R.drawable.e_68,R.drawable.e_69,R.drawable.e_70,R.drawable.e_71,R.drawable.e_72,

            R.drawable.e_73,R.drawable.e_74,R.drawable.e_75,R.drawable.e_76,R.drawable.e_77,R.drawable.e_78,

            R.drawable.e_79,R.drawable.e_80,R.drawable.e_81,R.drawable.e_82,R.drawable.e_83,R.drawable.e_84,

            R.drawable.e_85,R.drawable.e_86,R.drawable.e_87,R.drawable.e_88,R.drawable.e_89,R.drawable.e_90,

            R.drawable.e_91,R.drawable.uranio,R.drawable.neptunio,R.drawable.plutonio,R.drawable.amonio,R.drawable.curio,R.drawable.berkelio,

            R.drawable.californio,R.drawable.einstenio,R.drawable.fermio,R.drawable.mendelevio,R.drawable.nobelio,

            R.drawable.laurencio,R.drawable.ruthefordio,R.drawable.dubnio,R.drawable.seaborgio,R.drawable.bohrio,R.drawable.hassio,

            R.drawable.meitnerio,R.drawable.darmstadtio,R.drawable.roentgenio,R.drawable.darwanizo,R.drawable.tustrano,R.drawable.erristeneo,

            R.drawable.merchel,R.drawable.nectarten,R.drawable.efelio,R.drawable.oberon
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        lista = (ListView) findViewById(R.id.lista_1);
        Adaptador = new adaptador(this, elementos, datosImg);
        lista.setAdapter(Adaptador);
        buscar = findViewById(R.id.busqueda);


    }
}

