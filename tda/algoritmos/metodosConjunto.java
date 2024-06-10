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
}
