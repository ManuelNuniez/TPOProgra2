package algoritmos;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import impl.ConjuntoDinamico;
import impl.DiccionarioMultipleDinamico;

public class MetodosDiccMultiple {
    public static void ImprimirMultipleDiccionario(DiccionarioMultipleTDA Original){

        
        DiccionarioMultipleTDA d = new DiccionarioMultipleDinamico();
        d.InicializarDiccionario();
        d=Original;
        ConjuntoTDA claves=d.Claves();

        ConjuntoTDA aux= new ConjuntoDinamico();// existe para hacer de auxiliar y no perder los datos de los valores cuando los imprimimos
        
        while (!claves.ConjuntoVacio()) {
            int x=claves.Elegir();
            ConjuntoTDA valores= d.Recuperar(x);
            System.out.print(x + ":");

            while (!valores.ConjuntoVacio()) {
                int y=valores.Elegir();
                System.out.print(" " + y);
                aux.Agregar(y);
                valores.Sacar(y);
            }
            System.out.println();
            claves.Sacar(x);
        }
    }

}
