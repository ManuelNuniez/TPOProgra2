package impl;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {
    NodoDiccionario Primero;
    
    @Override
    public void InicializarDiccionario() {
        Primero=null;
    }

    @Override
    public void Agregar(int clave, int valor) {
        NodoDiccionario aux= new NodoDiccionario();
        aux.ValorN=valor;
        aux.ClaveN=clave;

        if (Primero==null) {
            Primero=aux;
            
        }else if(!Claves().Pertenece(clave)){
            
            aux.sig=Primero;
            Primero=aux;
        }else if (Claves().Pertenece(clave)) {
            aux=Primero;

            while (aux.ClaveN!=clave) {
                aux=aux.sig;
            }
            aux.ValorN=valor;
            
        }
    }

    @Override
    public void Eliminar(int clave) {

        if (Claves().Pertenece(clave)) {
            if (Primero.ClaveN==clave) {
                Primero=Primero.sig;
            }else{
                NodoDiccionario actual = Primero.sig;
                NodoDiccionario anterior =Primero;
                while (actual.ClaveN!=clave) {
                    anterior=actual;
                    actual=actual.sig;
                }
                anterior.sig=actual.sig;
            }

        }
    }

    @Override
    public int Recuperar(int clave) {
        NodoDiccionario aux =Primero;
        while (aux.ClaveN!=clave && aux!=null) {
            aux=aux.sig;    
        }
        if (aux==null) {
            return -1;
        }

        return aux.ValorN;
    }

    @Override
    public ConjuntoTDA Claves() { 
        ConjuntoTDA claves= new ConjuntoDinamico();
        claves.InicializarConjunto();
        NodoDiccionario aux=Primero;

        while(aux!=null){
            claves.Agregar(aux.ClaveN);
            aux=aux.sig;
        }
        return claves;
    }


}
