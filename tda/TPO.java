
import algoritmos.MetodosConjunto;
import api.CiudadesTDA;
import impl.Ciudades;

import api.*;
import impl.*;

public class TPO {
    private static void CargarDatos(CiudadesTDA ciudades) {
        ciudades.CargarProvincia("Bs. As.");
        ciudades.CargarProvincia("Córdoba");
        ciudades.CargarProvincia("Rio Negro");

        ciudades.CargarCiudad("Ciudad de Bs. As.", 1);
        ciudades.CargarCiudad("Ciudad de Córdoba", 2);
        ciudades.CargarCiudad("Bariloche", 3);

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
