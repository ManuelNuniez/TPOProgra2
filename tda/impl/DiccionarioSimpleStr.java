package impl;

import api.ConjuntoTDA;
import api.DiccionarioSimpleStrTDA;

public class DiccionarioSimpleStr implements DiccionarioSimpleStrTDA {
    private class NodoDS {
        int key;
        String value;
        NodoDS next;
    }
    
    NodoDS first;

    @Override
    public void Agregar(int clave, String valor) {
        NodoDS newNode = new NodoDS();

        ConjuntoTDA claves = Claves();

        newNode.key = clave;
        newNode.value = valor;
        
        if (first != null) {
            first = newNode;

        }else if(claves.Pertenece(clave)){
            NodoDS aux = first;
            while (aux.key!=clave) {
                aux = aux.next;
            }
            aux.value=valor;

        }else{
            newNode.next= first;
            first=newNode;
        }
    }   

    @Override
    public ConjuntoTDA Claves() {
        ConjuntoTDA claves = new ConjuntoDinamico();
        claves.InicializarConjunto();

        NodoDS aux= first;

        while (aux != null) {
            claves.Agregar(aux.key);
            aux = aux.next;
        }
        
        return claves;
    }

    @Override
    public void Eliminar(int clave) {
        if (first == null) return;
        
        if (first.key == clave) {
            first = null;
            return;
        }

        NodoDS last = null;
        NodoDS curr = first;
        while (curr != null && curr.key != clave) {
            last = curr;
            curr = curr.next;
        }

        if (curr != null) {
            last.next = curr.next;
        }
    }

    @Override
    public void InicializarDiccionario() {
        first = null;
    }

    @Override
    public String Recuperar(int clave) {
        NodoDS curr = first;
		while (curr != null && curr.key != clave) {
			curr = curr.next;
		}

		return curr.value;
    }

}
