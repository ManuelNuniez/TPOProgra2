
import algoritmos.MetodosConjunto;
import api.CiudadesTDA;
import impl.Ciudades;

import api.*;
import impl.*;

public class TPO {
    private static void CargarDatos(CiudadesTDA ciudades) {
        ciudades.CargarProvincia("Buenos Aires");
        ciudades.CargarProvincia("Cordoba");
        ciudades.CargarProvincia("Salta");
        ciudades.CargarProvincia("Chubut");


        ciudades.CargarCiudad("La Plata", 1);
        ciudades.CargarCiudad("Mar del Plata", 1);
        ciudades.CargarCiudad("Caba", 1);
        ciudades.CargarCiudad("Tandil", 1);

        ciudades.CargarCiudad("Ciudad de Cordoba", 2);
        ciudades.CargarCiudad("Rio Cuartos", 2);
        ciudades.CargarCiudad("Villa Carlos Paz", 2);

        ciudades.CargarCiudad("Cafayate", 3);

        ciudades.CargarCiudad("Rawson", 4);
        ciudades.CargarCiudad("Trelew", 4);
        ciudades.CargarCiudad("Puerto Madryn", 4);

        


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
    }
}
