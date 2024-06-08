package impl;

import api.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {
    int[] vector;
    int lastIndex;

    @Override
    public void InicializarConjunto() {
        vector = new int[100];
        lastIndex = 0;
    }

    @Override
    public boolean ConjuntoVacio() {
        return(lastIndex == 0);
    }

    @Override
    public void Agregar(int x) {
        if (!Pertenece(x)) {
            vector[lastIndex] = x;
            lastIndex++;
        }
    }

    @Override
    public int Elegir() {
        int randomIndex = Math.abs((int) System.nanoTime() % lastIndex);

        return(vector[randomIndex]);
    }

    @Override
    public void Sacar(int x) {        
        Integer xIndex = null;

        int i = 0;
        while (i <= lastIndex && xIndex == null) {
            if (x == vector[i]) xIndex = x;
            i++;
        }

        System.out.println(xIndex);

        for (int j=0; j < lastIndex-1; j++) {
            vector[j] = vector[j+1];
        };

        i--;
    }

    @Override
    public boolean Pertenece(int x) {
        boolean found = false;

        int i = 0;
        while(i < vector.length && !found) {
            System.out.println(vector[i]);
            System.out.println(x);
            System.out.println(vector[i] == x);

            if (vector[i] == x) {
                found = true;
            }
            i++;
        }

        return(found);
    }
}


