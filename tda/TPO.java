
import algoritmos.MetodosConjunto;
import algoritmos.MetodosDiccSimple;
import api.CiudadesTDA;
import impl.Ciudades;

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

        ciudades.CargarCiudad("Ciudad de Cordoba", 2); // id 5
        ciudades.CargarCiudad("Rio Cuarto", 2); // id 6
        ciudades.CargarCiudad("Villa Carlos Paz", 2); // id 7

        ciudades.CargarCiudad("Cafayate", 3); // id 8

        ciudades.CargarCiudad("Rawson", 4); // id 9
        ciudades.CargarCiudad("Trelew", 4); // id 10
        ciudades.CargarCiudad("Puerto Madryn", 4); // id 11


        ciudades.UnirCiudades(3, 2, 400);
        ciudades.UnirCiudades(3, 1, 60);
        ciudades.UnirCiudades(3, 4, 350);
        ciudades.UnirCiudades(3, 5, 1300);

        ciudades.UnirCiudades(2, 3, 500);
        ciudades.UnirCiudades(2, 5, 1800);

        ciudades.UnirCiudades(1, 5, 1500);
        ciudades.UnirCiudades(1, 9, 2700);

        ciudades.UnirCiudades(4, 3, 480);

        ciudades.UnirCiudades(5, 9, 2800);
        ciudades.UnirCiudades(5, 6, 200);

        ciudades.UnirCiudades(6, 11, 1150);

        ciudades.UnirCiudades(7, 5, 40);
        ciudades.UnirCiudades(7, 6, 250);
        ciudades.UnirCiudades(7, 10, 1400);

        ciudades.UnirCiudades(9, 7, 1200);
        ciudades.UnirCiudades(9, 8, 2200);
        ciudades.UnirCiudades(9, 10, 20);

        // ciudades.UnirCiudades(1, 2, 722);
        // ciudades.UnirCiudades(2, 3, 1530);
        // ciudades.UnirCiudades(3, 1, 1578);
        // ciudades.UnirCiudades(1, 3, 1578);
    }

    public static void main(String[] args) {
        CiudadesTDA argentina = new Ciudades();
        argentina.Inicializar();
        
        CargarDatos(argentina);
        //MetodosDiccSimple.ImprimirSimpleDiccionario(argentina.CiudadesFuertmenteConectadas());
        //MetodosConjunto.ImprimirConjunto()

        GrafoTDA g = new GrafoDinamico();

        g.AgregarVertice(1);
        // g.AgregarVertice(2);
        // g.AgregarVertice(3);

        argentina.Provincias();
        //argentina.Ciudades(1); // falla
        //MetodosConjunto.ImprimirConjunto(argentina.CiudadesVecinas(3)); // funciona :)
        //MetodosConjunto.ImprimirConjunto(argentina.CiudadesExtremo()); // funciona :)
        //MetodosConjunto.ImprimirConjunto(argentina.CiudadesPredecesoras(3)); // funciona :)
        //MetodosConjunto.ImprimirConjunto(argentina.CiudadesFuertmenteConectadas()); // funciona :)
    }
}
