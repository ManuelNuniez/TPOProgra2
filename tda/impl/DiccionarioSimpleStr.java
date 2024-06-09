package impl;

import api.ConjuntoTDA;
import api.DiccionarioSimpleStrTDA;

public class DiccionarioSimpleStr implements DiccionarioSimpleStrTDA {
    private class NodoDString {
        int key;
        String value;
        NodoDString next;
    }
    
    NodoDString first;

    @Override
    public void Agregar(int clave, String valor) {
        NodoDString newNode = new NodoDString();

        ConjuntoTDA claves = Claves();

        newNode.key = clave;
        newNode.value = valor;
        
        if (first != null) {
            first = newNode;

        }else if(claves.Pertenece(clave)){
            NodoDString aux = first;
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

        NodoDString aux= first;

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

        NodoDString last = null;
        NodoDString curr = first;
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
        NodoDString curr = first;
		while (curr != null && curr.key != clave) {
			curr = curr.next;
		}

		return curr.value;
    }

}
