
import algoritmos.MetodosConjunto;
import algoritmos.MetodosDiccMultiple;
import algoritmos.MetodosDiccSimple;
import api.CiudadesTDA;
import impl.Ciudades;

import algoritmos.*;
import api.*;
import impl.*;

public class TPO {
    private static void CargarDatos(CiudadesTDA ciudades) {
        ciudades.CargarProvincia("Buenos Aires"); // id 1
        ciudades.CargarProvincia("Cordoba"); // id 2
        ciudades.CargarProvincia("Salta"); // id 3
        ciudades.CargarProvincia("Chubut"); //id 4


        ciudades.CargarCiudad("La Plata", 1); // id 1
        ciudades.CargarCiudad("Mar del Plata", 1); // id 2
        ciudades.CargarCiudad("Caba", 1); // id 3
        ciudades.CargarCiudad("Tandil", 1); // id 4

        ciudades.UnirCiudades(1, 2, 10);
    }

    public static void main(String[] args) {
        // CiudadesTDA argentina = new Ciudades();
        // argentina.Inicializar();
        
        // CargarDatos(argentina);
        // int asd = argentina.Distancia(1, 2);
        // System.out.println(asd);

        DiccionarioSimpleStrTDA dicc = new DiccionarioSimpleStr();
        dicc.InicializarDiccionario();

        dicc.Agregar(1, "sdd");
        dicc.Agregar(2, "asdddd");

        ConjuntoTDA conj = dicc.Claves();
        algoritmos.MetodosConjunto.ImprimirConjunto(conj);


        // System.out.println(dicc.Recuperar(1));
        // System.out.println(dicc.Recuperar(2));
    }
}
