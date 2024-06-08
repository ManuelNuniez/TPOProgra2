package algoritmos;

import api.ColaTDA;
import impl.ColaEstatica;

public class metodosCola {
    public boolean copiarCola (ColaTDA origen, ColaTDA destino) {
        ColaTDA aux = new ColaEstatica();
        aux.InicializarCola();

        while (!origen.ColaVacia()) {
            destino.Acolar(origen.Tope());
            aux.Acolar(origen.Tope());

            origen.Desacolar();
        }

        while (!aux.ColaVacia()) {
            origen.Acolar(aux.Tope());

            aux.Desacolar();
        }
        // TODO: 
        return(true);
    }


    public boolean imprimirCola (ColaTDA cola) {
        ColaTDA aux = new ColaEstatica();
        aux.InicializarCola();

        copiarCola(cola, aux);

        while (!aux.ColaVacia()) {
            System.out.println(aux.Tope());

            aux.Desacolar();
        }
        
        // TODO: 
        return(true);
    }
}
