import algoritmos.MetodosConjunto;
import algoritmos.MetodosDiccMultiple;
import algoritmos.MetodosDiccSimple;
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
        System.out.println("Ciudades:");
        MetodosDiccSimple.imprimirDiccionarioSimpleString(argentina.nombresCiudades());
        
        System.out.println();
        System.out.println("Ciudades vecinas a " + argentina.nombresCiudades().Recuperar(3) + ":");
        ConjuntoTDA ciudadesVecinas = argentina.CiudadesVecinas(3);

        while (!ciudadesVecinas.ConjuntoVacio()) {
            int aux = ciudadesVecinas.Elegir();
            ciudadesVecinas.Sacar(aux);

            System.out.println(argentina.nombresCiudades().Recuperar(aux));
        }

        System.out.println();
        System.out.println("Ciudades extremo:");
        ConjuntoTDA ciudadesExtremo = argentina.CiudadesExtremo();

        while (!ciudadesExtremo.ConjuntoVacio()) {
            int aux = ciudadesExtremo.Elegir();
            ciudadesExtremo.Sacar(aux);

            System.out.println(argentina.nombresCiudades().Recuperar(aux));
        }

        System.out.println();
        System.out.println("Ciudades predecesoras a " + argentina.nombresCiudades().Recuperar(3) + ":");
        ConjuntoTDA ciudadesPredecesoras = argentina.CiudadesPredecesoras(3);

        while (!ciudadesPredecesoras.ConjuntoVacio()) {
            int aux = ciudadesPredecesoras.Elegir();
            ciudadesPredecesoras.Sacar(aux);

            System.out.println(argentina.nombresCiudades().Recuperar(aux));
        }

        System.out.println();
        System.out.print("Ciudades fuertemente conectadas:");
        ConjuntoTDA clavesFuertementeConectadas = argentina.CiudadesFuertmenteConectadas().Claves();

        while (!clavesFuertementeConectadas.ConjuntoVacio()) {
            int aux = clavesFuertementeConectadas.Elegir();
            clavesFuertementeConectadas.Sacar(aux);
            ConjuntoTDA valores = argentina.CiudadesFuertmenteConectadas().Recuperar(aux);

            System.out.print("\n" + argentina.nombresCiudades().Recuperar(aux) + ": ");

            while (!valores.ConjuntoVacio()) {
                int aux2 = valores.Elegir();
                valores.Sacar(aux2);

                System.out.print(argentina.nombresCiudades().Recuperar(aux2) + " ");
            }
        }

        System.out.println();

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
        System.out.printf("Ciudades puente entre %s y %s:\n", argentina.nombresCiudades().Recuperar(9), argentina.nombresCiudades().Recuperar(5));
        DiccionarioSimpleTDA ciudadesPuente = argentina.CiudadesPuente(9, 5);
        ConjuntoTDA clavesPuente = argentina.CiudadesPuente(9, 5).Claves();

        while (!clavesPuente.ConjuntoVacio()) {
            int aux = clavesPuente.Elegir();
            clavesPuente.Sacar(aux);

            System.out.println(argentina.nombresCiudades().Recuperar(aux) + ": " + ciudadesPuente.Recuperar(aux) + " km");
        }

    }

}