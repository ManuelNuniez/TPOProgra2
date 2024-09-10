package algoritmos;

import api.PilaTDA;
import impl.PilaDinamica;
import impl.PilaEstatica;

public class metodosPila {

    public static void copiarPila (PilaTDA origen, PilaTDA destino) {
        PilaTDA aux = new PilaEstatica();
        aux.InicializarPila();


        while (!origen.PilaVacia()) {
            aux.Apilar(origen.Tope());
            destino.Apilar(origen.Tope());
            origen.Desapilar();
        }

        while (!aux.PilaVacia()) {
            origen.Apilar(aux.Tope());
            aux.Desapilar();
        }
    }

    public static void imprimirPila (PilaTDA pila) {
        PilaTDA aux = new PilaEstatica();
        aux.InicializarPila();

        copiarPila(pila, aux);

        while (!pila.PilaVacia()) {
            System.out.println(pila.Tope());
            pila.Desapilar();
        }

        copiarPila(aux, pila);
    }

    public static void pasarPila (PilaTDA origen, PilaTDA destino) {
        PilaTDA aux = new PilaEstatica();
        aux.InicializarPila();

        copiarPila(origen, aux);
        copiarPila(aux, destino);
    }

    public static void invertirPila (PilaTDA pila) {
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();

        pasarPila(pila, aux);
        copiarPila(aux, pila);
    }

    public static int contarElementosPila (PilaTDA pila) {
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
        // Elegimos usar 'copiarPila' y no 'pasarPila' ya que realiza menos operaciones 
        copiarPila(pila, aux);

        int elementos = 0;

        while (!pila.PilaVacia()) {
            elementos++;
            pila.Desapilar();
        }

        copiarPila(aux, pila);

        return(elementos);
    }

    public static int sumarElementosPila (PilaTDA pila) {
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
        // Elegimos usar 'copiarPila' y no 'pasarPila' ya que realiza menos operaciones 
        copiarPila(pila, aux);

        int suma = 0;

        while (!pila.PilaVacia()) {
            suma = suma + pila.Tope();
            pila.Desapilar();
        }

        copiarPila(aux, pila);

        return(suma);
    }

    public static float promedioElementosPila (PilaTDA pila) {
        int suma = sumarElementosPila(pila);
        int cantidad = contarElementosPila(pila);

        if (cantidad == 0) return(0);

        return((float)suma / cantidad);
    }
}
