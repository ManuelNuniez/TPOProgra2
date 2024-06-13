package algoritmos;

import api.ConjuntoTDA;
import impl.ConjuntoDinamico;

public class MetodosConjunto {
    
    public static void ImprimirConjunto(ConjuntoTDA original){
        ConjuntoTDA c = new ConjuntoDinamico();
        c.InicializarConjunto();
        c=original;
        while (!c.ConjuntoVacio()) {
            int x=c.Elegir();
            System.out.print(" " + x);
            c.Sacar(x);
        }
    }

    public static ConjuntoTDA CopiarConjunto(ConjuntoTDA original) {
        ConjuntoTDA copia = new ConjuntoDinamico();
        copia.InicializarConjunto();
        
        ConjuntoTDA temp = new ConjuntoDinamico();
        temp.InicializarConjunto();
        
        while (!original.ConjuntoVacio()) {
            int elemento = original.Elegir();
            copia.Agregar(elemento);
            temp.Agregar(elemento);
            original.Sacar(elemento);
        }
    
        while (!temp.ConjuntoVacio()) {
            int elemento = temp.Elegir();
            original.Agregar(elemento);
            temp.Sacar(elemento);
        }
    
        return copia;
    }
}
