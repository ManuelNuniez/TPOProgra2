
import algoritmos.MetodosConjunto;
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
        ciudades.CargarCiudad("Rio Cuartos", 2); // id 6
        ciudades.CargarCiudad("Villa Carlos Paz", 2); // id 7

        ciudades.CargarCiudad("Cafayate", 3); // id 8

        ciudades.CargarCiudad("Rawson", 4); // id 9
        ciudades.CargarCiudad("Trelew", 4); // id 10
        ciudades.CargarCiudad("Puerto Madryn", 4); // id 11

        ciudades.UnirCiudades(0, 0, 0);


        // ciudades.UnirCiudades(1, 2, 722);
        // ciudades.UnirCiudades(2, 3, 1530);
        // ciudades.UnirCiudades(3, 1, 1578);
        // ciudades.UnirCiudades(1, 3, 1578);
    }

    public static void main(String[] args) {
        CiudadesTDA argentina = new Ciudades();
        argentina.Inicializar();
        
        // CargarDatos(argentina);
        //MetodosDiccSimple.ImprimirSimpleDiccionario(argentina.CiudadesFuertmenteConectadas());
        //MetodosConjunto.ImprimirConjunto()

        GrafoTDA g = new GrafoDinamico();

        g.AgregarVertice(1);
        // g.AgregarVertice(2);
        // g.AgregarVertice(3);

        argentina.Provincias();
        argentina.CiudadesVecinas(3);
    }
}
