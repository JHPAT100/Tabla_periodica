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

            //1-45
            //otro intento
                      {"Hidrógeno","El hidrógeno es el elemento químico más simple (formado solamente por un protón y un electrón) y más abundante del universo.","H","IA","S","1.0079(g/mol)"," 1"," 1","0"," (-1), +1"},

                      {"Helio","El helio es una sustancia de la naturaleza, concretamente un gas noble cuyo símbolo es He y que debe su nombre al Sol, que en griego se denomina helios.","He","VIIIA","S","4.0026(g/mol)"," 2","2","2","0"},

                      {"Litio","es un metal alcalino blanco plateado, blando, dúctil y muy ligero, se corroe rápidamente al contacto con el aire y no existe en estado libre en la naturaleza, sino solamente en compuestos; se utiliza en la fabricación de acero, en esmaltes y lubricantes, y el carbonato de litio, en medicina.","Li","IA","S","6.941(g/mol)","3","3","4","+1"},

                      {"Berilio","es un metal de color gris, muy ligero, que se obtiene del berilo y se usa en la fabricación de aviones y tubos de rayos X, en los reactores nucleares y en computadoras, láser, televisión, etc.","Be","IIA","S","9.0121(g/mol)","4","4","5","+2"},

                      {"Boro","El compuesto de boro de mayor importancia económica es el bórax que se emplea en grandes cantidades en la fabricación de fibra de vidrio aislante y perborato de sodio","B","IIIA","P","10.811(g/mol)"," 5","5","6"," -3, +3"},

                      {"Carbono","es un no metal sólido que es el componente fundamental de los compuestos orgánicos y tiene la propiedad de enlazarse con otros átomos de carbono y otras sustancias para formar un número casi infinito de compuestos","C","IVA","P","12.0107(g/mol)","6","6","(+2),+4"},

                      {"Nitrógeno"," es un gas incoloro, inodoro e inerte, compone cuatro quintos del volumen del aire de la atmósfera y se usa para sintetizar amoníaco y otros productos, para fabricar explosivos, como refrigerante y como atmósfera inerte para conservar ciertos productos.","N","VA","P","14.0067(g/mol)","7","7","7","-3,-2,-1,(+1),+2,+3,+4,+5"},

                      {"Oxígeno"," es un gas incoloro e inodoro que se encuentra en el aire, en el agua, en los seres vivos y en la mayor parte de los compuestos orgánicos e inorgánicos; es esencial en la respiración y en la combustión","O","VIA","P","15.9994(g/mol)","8","8","8","-2"},

                      {"Flúor","Es un gas a temperatura ambiente, de color verde pálido, formado por moléculas diatómicas F₂. Es el más electronegativo y reactivo de todos los elementos.","F","VIIA","P","18.9984(g/mol)","9","9","10","-1,+1"},

                      {"Neón","Es un gas noble, incoloro, prácticamente inerte, presente en trazas en el aire, pero muy abundante en el universo, que proporciona un tono rojizo (no es un color) característico a la luz de las lámparas fluorescentes en las que se emplea.","Ne","VIIA","P","20.1797(g/mol)","10","10","10","0"},

                      {"Sodio"," Es un metal alcalino blando, untuoso, de color plateado, muy abundante en la naturaleza, encontrándose en la sal marina y el mineral halita","Na","IA","S","22.9897(g/mol)","11","11","12","+1"},

                      {"Magnesio","es un metal alcalino de color blanco plateado, maleable y ligero, que existe en la naturaleza solamente en combinación química con otros elementos y es un componente esencial del tejido animal y vegetal; se usa en flashes fotográficos, señales luminosas, etc.","Mg","IIA","S","24.305(g/mol)","12","12","12","+2"},

                      {"Aluminio","Se trata de un metal no ferromagnético. Es el tercer elemento más común encontrado en la corteza terrestre.","Al","IIIA","P","26.9815(g/mol)","13","13","14","+3"},

                      {"Silicio","s un no metal sólido, de color amarillento, que se extrae del cuarzo y otros minerales y es el segundo elemento más abundante en la Tierra después del oxígeno; se utiliza en la industria del acero como componente de las aleaciones de silicio y acero, en la fabricación de transistores y circuitos integrados","Si","IVA","P","28.0855(g/mol)","14","14","14","-4,(+2),+4"},

                      {"Fósforo","La principal función del fósforo es la formación de huesos y dientes. Este cumple un papel importante en la forma como el cuerpo usa los carbohidratos y las grasas. También es necesario para que el cuerpo produzca proteína para el crecimiento, conservación y reparación de células y tejidos","P","VA","P","30.9737(g/mol)","15","15","16","-3,+1,+3,+5"},

                      {"Azufre","es un no metal de color amarillo pálido y olor desagradable, que se encuentra en la naturaleza tanto en forma libre como combinado con otros elementos; se usa para la obtención de ácido sulfúrico, para fabricar fósforos, caucho vulcanizado, tintes, pólvora, fungicidas, en fotografía para el fijado de negativos y positivos, y, en medicina para la elaboración de sulfamidas y pomadas tópicas.","S","VIA","P","32.065(g/mol)","16","16","16","-2,+2,+4,+6"},

                      {"Cloro"," El cloro existe como un gas amarillo-verdoso a temperaturas y presiones ordinarias. ... El cloro es uno de los cuatro elementos químicos estrechamente relacionados que han sido llamados halógenos.","Cl","VIIA","P","35.453(g/mol)","17","17","18","-1,+1,(+2),+3,(+4),+5,+7"},

                      {"Argón","El argón es el tercer miembro del grupo 0 en la tabla periódica. Los elementos gaseosos de este grupo se llaman gases nobles, inertes o raros, aunque en realidad el argón no es raro.","Ar","VIIIA","P","39.948(g/mol)","18","18","22","0"},

                      {"Potasio","Ocupa un lugar intermedio dentro de la familia de los metales alcalinos después del sodio y antes del rubidio. Este metal reactivo es ligero y blando. ... El carbonato de potasio es también un material de partida importante en la industria del vidrio.","K","IA","S","39.0983(g/mol)","19","19","20","+1"},

                      {"Calcio"," Los compuestos de calcio constituyen 3.64% de la corteza terrestre. ... Al igual que el berilio y el aluminio, pero a diferencia de los metales alcalinos, no causa quemaduras sobre la piel.","Ca","IIA","S","40.078(g/mol)","20","20","20","+2"},

                      {"Escandio","Es un metal de transición que se encuentra en minerales de Escandinavia y que se clasifica con frecuencia entre los lantánidos por sus similitudes con ellos.","21","Sc","IIIB","D","44.9559(g/mol)","21","24","+3"},

                      {"Titanio"," Es un metal de transición de color gris, baja densidad y gran dureza. Es muy resistente a la corrosión por agua del mar, agua regia y cloro.","Ti","IVB","D","47.867(g/mol)","22","22","26"," +2,+3,+4"},

                      {"Vanadio"," Es un metal dúctil, blando y poco abundante. Se encuentra en distintos minerales y se emplea principalmente en algunas aleaciones.","V","VB","D","50.9415(g/mol)","23","23","28","+2,+3,+4,+5"},

                      {"Cromo"," Es un metal que se emplea especialmente en metalurgia. Su nombre cromo se debe a los distintos colores que presentan sus compuestos.","Cr","VIB","D","51.9961(g/mol)","24","24","28","+2,+3,+6"},

                      {"Manganeso","Se encuentra como elemento libre en la naturaleza, a menudo en combinación con el hierro y en muchos minerales.","Mn","VIIB","D","54.938(g/mol)","25","25","30","+2,(+3),+4,(+6),+7"},

                      {"Hierro","El hierro es el cuarto elemento más abundante en la corteza terrestre (5%). Es un metal maleable, tenaz, de color gres plateado y magnético","Fe","VIIIB","D","55.845(g/mol)","26","26","30","+2,+3,(+4),(+6)"},

                      {"Cobalto","El cobalto aparece en la tabla periódica con el símbolo Co. Su número atómico es el 27 y fue reconocido como elemento básico entre 1730 y 1735, por el químico y minerólogo sueco Georg Brandt. Una cualidad de este mineral, es que es buen conductor del calor y la electricidad.","Co","VIIIB","D","58.9331(g/mol)","27","27","32","+2,+3,(+4)"},

                      {"Níquel","En forma comercial, el níquel se usa para forma aleaciones con el acero inoxidable y algunos otros metales que son resistentes a la corrosión.","Ni","VIIIB","D","58.6934(g/mol)","28","28","31","(+1),+2,(+3),+(4)"},

                      {"Cobre","uno de los metales de transición e importante metal no ferroso.","Cu","IB","D","63.546(g/mol)","29","29","35","+1,+2,(+3)"},

                      {"Zinc","Es un metal maleable, dúctil y de color gris. Se conocen 15 isótopos, cinco de los cuales son estables y tienen masas atómicas de 64, 66, 67, 68 y 70.","Zn","IIB","D","65.409(g/mol)","30","30","35","+2"},

                      {"Galio","Tiene un gran intervalo de temperatura en el estado líquido, y se ha recomendado su uso en termómetros de alta temperatura y manómetros. ... El galio es semejante químicamente al aluminio.","Ga","IIIA","P","69.723(g/mol)","31","31","39","(+2),+3"},

                      {"Germanio","l mundo que rodea al ser humano se encuentra conformado por elementos tangibles e intangibles, es decir, por cosas que se pueden ver y viceversa. La matemática conforma a todo lo cuantificable, la física se encarga de todo lo que se toca y se mueve, mientras que la química se encuentra en la composición de absolutamente todo lo que es visible.","Ge","IVA","P","72.64(g/mol)","32","32","41","-4,+2,+4"},

                      {"Arsénico","es un elemento químico de la tabla periódica cuyo símbolo es As y el número atómico es 33. En la tabla periódica de los elementos se encuentra en el quinto grupo principal","As","VA","P","74.9216(g/mol)","33","33","42","-3,(+2),+3,+5"},

                      {"Selenio","Selenio. El selenio es un elemento químico, cuyo símbolo es Se, con un número atómico de 34. ... El seleniuro de cadmio es un compuesto semiconductor que se usa en las fotoceldas pues su conductividad eléctrica cambia según la intensidad de la luz a la que se expone.","Se","VIA","P","78.96(g/mol)","34","34","45","-2,(+2),+4,+6"},

                      {"Bromo","El bromo a temperatura ambiente es un líquido rojo, volátil y denso. Su reactividad es intermedia entre el cloro y el yodo","Br","VIIA","P","79.904(g/mol)","35","35","45","-1,+1,(+3),(+4),+5"},

                      {"Kriptón"," El kriptón es uno de los gases nobles. Es un gas incoloro, inodoro e insípido. Su principal aplicación es el llenado de lámparas eléctricas y aparatos electrónicos de varios tipos.","Kr","VIIIA","P","83.798(g/mol)","36","36","48","0"},

                      {"Rubidio","El rubidio es un elemento químico de la tabla periódica, su símbolo es el Rb y su número atómico es de 37. Es un metal con características altamente reactivas, su color es blanco plateado y es muy blando. Se encuentra en la naturaleza en estado extremadamente disperso. Usualmente se obtiene de la producción de litio. El rubidio se usa en células fotoeléctricas y para ciertos tipos de catalizadores","Rb","IA","S","85.467(g/mol)","37","37","48","+1"},

                      {"Estroncio","El estroncio es el menos abundante de los metales alcalinotérreos. La corteza de la Tierra contiene el 0.042% de estroncio, y este elemento es tan abundante como el cloro y el azufre.","Sr","IIA","S","87.62(g/mol)","38","38","50","+2"},

                      {"Itrio","Es un metal plateado de transición, común en los minerales de tierras raras.","Y","IIIB","D","88.905(g/mol)","39","39","50","+3"},

                      {"Circonio"," El zirconio es uno de los elementos más abundantes y está ampliamente distribuido en la corteza terrestre. Es muy reactivo químicamente y sólo se halla combinado.","Zr","IVB","D","91.224(g/mol)","40","40","51","(+2),(+3),+4"},

                      {"Niobio","Es un metal de transición dúctil, gris, blando y poco abundante. Se encuentra en el mineral niobita, también llamado columbita, y se utiliza en aleaciones","Nb","VB","D","92.906(g/mol)","41","41","52","(+2),+3,(+4),+5"},

                      {"Molibdeno","El molibdeno es un metal esencial desde el punto de vista biológico y se utiliza sobre todo en aceros aleados.","42","Mo","VIB","D","95.94(g/mol)","42","54","(+2),+3,(+4),(+5),+6"},

                      {"Tecnecio","El tecnecio es el más ligero de los elementos químicos que no cuentan con isótopos estables y el primer elemento sintético que se encuentra en la tabla periódica. Su número atómico es el 43 y su símbolo es Tc.","Tc","VIIIB","D","98.906(g/mol)","43","43","55","+6"},

                      {"Rutenio","Es un metal de transición, poco abundante, del grupo del platino. Se encuentra normalmente en minas de platino y se emplea como catalizador en algunas aleaciones de platino","44","Ru","VIIIB","D","101.07(g/mol)","44","58","(+2),+3,+4,(+6),(+7),+8"},

                      {"Rodio"," Es un metal de transición, poco abundante, del grupo del platino. Se encuentra normalmente en minas de platino y se emplea como catalizador en algunas aleaciones de platino.","45","Rh","VIIIB","D","102.905(g/mol)","45","57","(+2),(+3),+4,(+6)"},

             //46-91
                      {"Paladio","Es un raro y brillante metal de color plateado, fue nombrado así por el asteroide Pallas.","Pd","VIIIB","d","106.42(g/mol)","46","46","60","+2, +4, +6"},

                      {"Plata","Es un metal de transición suave, de color blanco y brillante, posee la mas alta conductividad eléctrica, térmica y reflectiva entre los metales.","Ag","IB","d","107.868(g/mol)","47","47","61","+1, +2"},

                      {"Cadmio","Es un metal suave, de color blanco-azulado, químicamente es similar al Zinc y al Mercurio, tiene un  bajo punto de fusión a comparación con otros metales.","Cd","IIB","d","112.411(g/mol)","48","48","64","+1, +2"},

                      {"Indio","Es un metal de transición suave, maleable y con un bajo punto de fusión, el cual es más alto que el del Sodio pero más bajo que el del Litio o el Estaño.", "In","IIIA","P","114.818(g/mol)","49","49","66","+1, +2, +3"},

                      {"Estaño","Muestra un similitud química con el Germanio y el Plomo, forma parte de grupo principal en el grupo 14 de la tabla periódica.","Sn","IVA","P","118.710(g/mol)","50","50","69","+2, +4"},

                      {"Antimonio","Es un metaloide gris brillante, se encuentra principalmente en la naturaleza como el mineral sulfuro de estibina, sus compuestos se conocen desde la antiguedad y eran usados en cosméticos.","Sb","VA","p","121.760(g/mol)","51","51","71","-3, +3, +4, +5"},

                      {"Telurio","Es un metaloide de color blanco-plateado, frágil, levemente tóxico y raro, químicamente esta relacionado con el Selenio y el Azufre.","Te","VIA","P","127.60(g/mol)","52","52","75","-2, +2, +4, +6"},

                      {"Yodo","El yodo y sus compuestos se utilizan en nutrición, en la producción de ácido acético y ciertos polimeros, su nombre proviene del griego y significa violeta o purpura, debido al color del vapor del Yodo","I","VIIA","P","126.904(g/mol)","53","53","74","-1, +1, +3, +4, +5, +7"},

                      {"Xenón","Es un gas noble incoloro, denso e inodoro, se produce en la atmósfera de la tierra  en cantidades mínimas","Xe","VIIA","P","131.293(g/mol)", "54","54","77","0"},

                      {"Cesio","Es un metal alcalino suave de color dorado-plateado, su punto de fusión es de 28c°, es uno de los 5 metales que se encuentran en estado líquido en o cerca de la temperatura ambiente.","Cs","IA","S","132.905(g/mol)","55","55","78","+1"},

                      {"Bario","Es un metal alcalinotérreo de color plateado métalico, debido a su alta reactividad química nunca se encuentra como un elemento libre en la naturaleza.","Ba","IIA","S","137.327(g/mol)","56","56","81","+2"},

                      {"Lantano","Es un metal  blando, dúctil, de color blanco-plateado, se lustra rapidamente cuando se expone al aire y es lo suficientemente suave para cortarlo con un cuchillo.","La","IIB","D","138.905(g/mol)", "57","57","82","+3"},

                      {"Cerio","Es un metal blando, plateado y dúctil el cual se oxida fácilmente al exponerlo al aire.","Ce","-","F","140.116(g/mol)", "58","58","82","+3, +4"},

                      {"Praseodimio","Es un metal blando, plateado, dúctil y maleable, es valorado por sus propiedades magnéticas, eléctricas, químicas y ópticas.","Pr","-","F","140.904(g/mol)","59","59","82","+3"},

                      {"Neodimio","Es un metal de color plateado, suave que se deslustra con el aire.","Nd","-","f","144.242(g/mol)","60","60","84","+3, +4"},

                      {"Prometio","Químicamente es un lantanido que forma sales cuando se combina con otros elementos, todos sus isótopos son radioactivos.","Pm","-","F","146.915(g/mol)","61","61","85","+3"},

                      {"Samario","Es un metal plateado moderadamente duro que se oxida fácilmente con el aire.","Sm","-","F","150.36(g/mol)","62","62","88","+2, +3"},

                      {"Europio","Es un metal moderadamente duro que se oxida fácilmente con el aire y el agua, lleva el nombre de el continente de Europa.","Eu","-","F","151.964(g/mol)","63","63","89","+2, +3"},

                      {"Gadolinio","Es un metal de tierra rara, de color blanco-plateado, maleable y dúctil, en la naturaleza solo se encuentra de forma combinada.","Gd","-","f","157.25(g/mol)","64","64","93","+3"},

                      {"Terbio","Es un metal de tierra rara de color blanco-plateado,maleable, dúctil y lo suficientemente suave para cortarlo con un cuchillo, nunca se encuentra en la naturaleza como un elemento libre.","Tb","-","F","158.925(g/mol)","65","65","93","+3, +4"},

                      {"Disprosio","Es un elemento de tierra rara con un brillo metálico plateado, nunca se encuentra en la naturaleza como un elemento libre.","Dy","-","F","162.500(g/mol)","66","66","96","+3"},

                      {"Holmio","Elemento de tierra rara, forma parte de el grupo de los lantanidos","Ho","-","F","164.93(g/mol)","67","67","97","+3"},

                      {"Erbio","Metal solido de color blanco-plateado cuando se encuentra aislado artificialmente, es un elemento de tierra rara que se asocia con otros minerales de raros en el mineral gadolinita de Ytterby","Er","-","F","167.259(g/mol)","68","68","99","+3"},

                      {"Tulio","Es el antepenultimo de la serie de los lantanidos y aligual que los otros lantanidos su estado de oxidación mas común es +3","Tm","-","F","168.934(g/mol)","69","69","99","+2, +3"},

                      {"Iterbio","Es el penúltimo de la serie de los lantánidos, al igual que los otros lantánidos su estado de oxidación mas común es +3, visto en su óxido, haluros y otros compuestos.","Yb","-","F","173.04(g/mol)","70","70","103","+2, +3"},

                      {"Lutecio","Es uno de los elementos del bloque d pero con freciencia se le suele incluir en los lantánidos debido a que comparte muchas propiedades con estos, de todos ellos es el mas difícil de aislar.","Lu","-","F","174.967(g/mol)","71","71","103","+3"},

                      {"Hafnio","Es un metal de transición tetravalente, brillante, plateado y de color gris, se asemeja químicamente al Circonio y se encuentra en minerales de circonio.","Hf","IVB","D","178.49(g/mol)","72","72","106","+4"},

                      {"Tantalo","Su nombre proviene de Tántalo, un antiheroe de la mitología griega, es un metal de transición lustroso, raro, duro, de color gris_azulado que es altamente resistente a la corrosión. ","Ta","VB","D","180.947(g/mol)","73","73","108","+3, +4, +5"},

                      {"Wolframio","Tambien conocido como tungsteno, palabra que proviene de la lengua sueca tung sten que significa piedra pesada.","W","VIB","D","183.84(g/mol)","74","74","109","+2, +3, +4, +5, +6"},

                      {"Renio","Es un metal de transición de la tercera fila, grueso y de color plateado, es uno de los elementos más raros en la corteza terrestre.","Re","VIIB","D","186.207(g/mol)","75","75","111","-1, +2, +3, +4, +5, +6, +7"},

                      {"Osmio","Es un metal de transición de color blanco_azulado, duro y frágil en el grupo del platino que se encuentra como un elemento traza en las aleaciones. Es el elemento natural más denso.","Os","VIIIB","D","190.23(g/mol)","76","76","115","+2, +3, +4, +6, +8"},

                      {"Iridio","Es unmetal de transición duro, frágil, de color platino-blanco, generalmente se le atribuye como el segundo elemento  más denso  basado en la densidad medida.","Ir","VIIIB","D","192.217(g/mol)","77","77","115","+1, +2, +3, +4, +6"},

                      {"Platino","Es unmmetal de transición denso, maleable, dúctil, altamente no reactivo, precioso y de color gris-blanco, su nombre deriva del termino español platina, que se traduce como poca plata.  ","Pt","VIIIB","D","195.084(g/mol)","78","78","117","+1, +2, +3, +4, +6"},

                      {"Oro","En su forma más pura, es un metal brillante, ligeramente rojizo, denso, suave, maleable y dúctil, químicamente es un metal de transición.","Au","IB","D","196.966(g/mol)","79","79","118","+1, +2, +3"},

                      {"Mercurio","Es un elemento del bloque d pesado y de color plateado, es el único elemento metálico que es líquido en condiciones estándar de temperatura y presión.","Hg","IIB","D","200.59(g/mol)","80","80","120","+1, +2"},

                      {"Talio","Es un metal de transición suave y de color gris, no se encuentra libre en la naturaleza, cuando se encuentra aislado, se parece al estaño pero se decolora al exponerlo al aire.","Tl","IIIB","D","204.383(g/mol)","81","81","123","+1, +2, +3"},

                      {"Plomo","Es u metal blando, maleable y pesado despues de la transición, al exponerlo al aire se torna de un color gris o opaco.","Pb","IVA","D","207.2(g/mol)", "82","82","125","+2, +4"},

                      {"Bismuto","Es unmetal de transición posterior pentavalente, químicamente se asemeja al arsénico y el antimonio, los cristales de bismuto  suelen adoptar formas geométricas y poseen una amplia grama de colores.","Bi","VA","P","208.9804(g/mol)","83","83","126","-3, +2, +3, +4, +5"},

                      {"Polonio","Es un elemento raro y altamente radioactivo sin isótopos estables, es químicamente similar al bismuto y al telurio, sus aplicaciones son pocas.","Po","VIB","P","208.9824(g/mol)","84","84","126","-2, +2, +4, +6"},

                      {"Ástato","Ocurre en la Tierra como el producto de desintegración de varios elementos más pesados. Todos sus isótopos son de corta duración.","At","VIIIA","P","209.9871(g/mol)","85","85","125","-"},

                      {"Radón","Es un gas noble radioactivo, incoloro, inodoro e insípido, que se produce naturalmente como producto de la desintegración del radio.","Rn","VIIIB","P","222.0176(g/mol)","86","86","136","0"},

                      {"Francio","Es el segundo elemento menos electronegativo, solo detras del cesio, es un metal altamente radioactivo que se descompone en astatino, radio y radón.","Fr","IA","S","223.0197(g/mol)","87","87","136","-"},

                      {"Radio","El radio puro es casi incoloro, pero se combina fácilmente con nitrógeno en la exposición al aire, formando una capa negra de nitruro de radio.","Ra","IIA","S","226.0254(g/mol)","88","88","138","+2"},

                      {"Actinio","Fue el primer elemento radioactivo no primordial en aislarse, due descubierto en 1899.","Ac","IIIB","D","227.0278(g/mol)","89","89","138","+3"},

                      {"Torio","Es uno de los 2 elementos significativamente radioactivos que aún ocurren naturalmente en grandes cantidades como elemento primordial, el otro es el Uranio.","Th","-","F","232.0380(g/mol)","90","90","142","+4"},

                      {"Protactinio","Es un metal denso de color gris-plateado que reacciona fácilmente con el oxígeno, el vapor de agua y los ácidos inorgánicos.","Pa","-","f","231.0358(g/mol)","91","91","140","+5"},


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
    int[] datosImg = {R.drawable.icono_b, R.drawable.logo, R.drawable.e_1, R.drawable.e_2, R.drawable.e_3,

            R.drawable.e_4, R.drawable.e_5, R.drawable.e_6, R.drawable.e_7, R.drawable.e_8, R.drawable.e_9,

            R.drawable.e_10, R.drawable.e_11, R.drawable.e_12, R.drawable.e_13, R.drawable.e_14, R.drawable.e_15,

            R.drawable.e_16, R.drawable.e_17, R.drawable.e_18, R.drawable.e_19, R.drawable.e_20, R.drawable.e_21,

            R.drawable.e_22, R.drawable.e_23, R.drawable.e_24, R.drawable.e_25, R.drawable.e_26, R.drawable.e_27,

            R.drawable.e_28,

            R.drawable.e_29, R.drawable.e_30, R.drawable.e_31, R.drawable.e_32, R.drawable.e_33, R.drawable.e_34,

            R.drawable.e_35, R.drawable.e_36, R.drawable.e_37, R.drawable.e_38, R.drawable.e_39, R.drawable.e_40,

            R.drawable.e_41, R.drawable.e_42, R.drawable.e_43, R.drawable.e_44, R.drawable.e_45,

            R.drawable.e_46, R.drawable.e_47,R.drawable.e_48,

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

