package impl;

import api.ColaTDA;

public class ColaEstatica implements ColaTDA {
    int[] vector;
    int lastIndex;

    @Override
    public void InicializarCola() {
        vector = new int[100];
        lastIndex = 0;
    }

    @Override
    public void Acolar(int x) {
        vector[lastIndex] = x;
        lastIndex++;
    }

    @Override
    public void Desacolar() {
        lastIndex--;

        for (int i = 1; i < vector.length; i++) {
            vector[i-1] = vector[i];
        }
    }

    @Override
    public int Tope() {
        return(vector[0]);
    }

    @Override
    public boolean ColaVacia() {
        return(lastIndex == 0);
    }
}
