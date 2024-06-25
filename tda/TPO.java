import algoritmos.MetodosConjunto;
import algoritmos.MetodosDiccMultiple;
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
        ciudades.CargarCiudad("C.A.B.A.", 1); // id 3
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

    }

    public static void main(String[] args) {

        CiudadesTDA argentina = new Ciudades();
        argentina.Inicializar();
        
        CargarDatos(argentina);

        System.out.println();
        System.out.println("Ciudades en " + argentina.Provincias().Recuperar(1) + ":");
        MetodosDiccSimple.imprimirDiccionarioSimpleString(argentina.CiudadesPorProvincia(1));
        
        System.out.println();
        System.out.println("Ciudades vecinas a " + argentina.CiudadesPorProvincia(1).Recuperar(3) + ":");
        MetodosConjunto.ImprimirConjunto(argentina.CiudadesVecinas(3));

        System.out.println();
        System.out.println("Ciudades extremo:");
        MetodosConjunto.ImprimirConjunto(argentina.CiudadesExtremo());

        System.out.println();
        System.out.println("Ciudades predecesoras a " + argentina.CiudadesPorProvincia(1).Recuperar(3) + ":");
        MetodosConjunto.ImprimirConjunto(argentina.CiudadesPredecesoras(3));

        System.out.println();
        System.out.println("Ciudades fuertemente conectadas:");
        MetodosDiccMultiple.ImprimirMultipleDiccionario(argentina.CiudadesFuertmenteConectadas());

        argentina.EliminarCiudades(3);
        argentina.CargarProvincia("Río Negro");
        argentina.CargarCiudad("Bariloche", 5);

        System.out.println();
        System.out.println("Provincias:");
        MetodosDiccSimple.imprimirDiccionarioSimpleString(argentina.Provincias());

        System.out.println();
        System.out.printf("Distancia entre %s y %s:\n", argentina.CiudadesPorProvincia(1).Recuperar(2), argentina.CiudadesPorProvincia(4).Recuperar(10));
        int distancia= argentina.Distancia(2, 10);
        System.out.println(distancia + " km");
        
        System.out.println();
        System.out.printf("Ciudades puente entre %s y %s:\n", argentina.CiudadesPorProvincia(4).Recuperar(9), argentina.CiudadesPorProvincia(2).Recuperar(5));
        MetodosDiccSimple.ImprimirSimpleDiccionario(argentina.CiudadesPuente(9, 5));



    }

}