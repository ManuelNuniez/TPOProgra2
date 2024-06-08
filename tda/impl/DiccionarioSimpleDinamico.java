package impl;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {
    NodoDS first;

    @Override
    public void Agregar(int clave, int valor) {
        NodoDS newNode = new NodoDS();

        newNode.key = clave;
        newNode.value = valor;
        
        if (first != null) {
            newNode.next = first;
        }

        first = newNode;
    }   

    @Override
    public ConjuntoTDA Claves() {
        return null;
    }

    @Override
    public void Eliminar(int clave) {
        if (first == null) return;
        
        NodoDS curr = first;

        while (curr != null) {
            if (curr.key == clave) {
                
            }

            curr = curr.next;
        }
    }

    @Override
    public void ImprimirDiccionario() {
        if (first == null) return;

        NodoDS curr = first;
        while (curr != null) {
            System.out.println("[" + curr.key + ": " + curr.value + "]");

            curr = curr.next;
        }
    }

    @Override
    public void InicializarDiccionario() {
        
    }

    @Override
    public int Recuperar(int clave) {
        return 0;
    }

}
