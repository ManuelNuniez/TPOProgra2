package impl;

import api.PrioHeapTDA;

public class MaxHeapPrio implements PrioHeapTDA{
    int i;
    ValPrio[] vector;
    int capacidad = 10;

    @Override
    public void InicializarHeap() {
        vector= new ValPrio[capacidad];
        i=0;
    }

    private void ResetVector(){
        ValPrio[] vectorNuevo = new ValPrio[capacidad*10];
        for(int j = 0; j < i; j++){
            vectorNuevo[j]= vector[j];
        }

        vector = vectorNuevo;
        capacidad=capacidad*10;
    }

    @Override
    public void AgregarH(ValPrio x) {
        if (i == capacidad) {
            ResetVector();
        }

        vector[i] = x;
        i++;

        int newPos=i-1;
        int padrePos= (newPos - 1)/2;

        while (vector[padrePos].prioridad < vector[newPos].prioridad) {
            ValPrio aux = vector[padrePos];
            vector[padrePos] = vector[newPos];
            vector[newPos] = aux;

            newPos=padrePos;
            padrePos=(newPos - 1)/2;
        }


    }

    @Override
    public void SacarH() {
        i--;
        vector[0]=vector[i];
        int p=0;
        int hd= 2;
        int hi= 1;

        while (hd <= i && (vector[p].prioridad < vector[hi].prioridad || vector[p].prioridad < vector[hd].prioridad)) {
            if (vector[hi].prioridad > vector[hd].prioridad) {
                ValPrio aux= vector[p];
                vector[p]=vector[hi];
                vector[hi]= aux;

                p=hi;
                hi=2*p+1;
                hd=2*p+2;

            }else{
                ValPrio aux = vector[p];
                vector[p]=vector[hd];
                vector[hd]=aux;
                
                p=hd;
                hi=2*p+1;
                hd=2*p+2;
            }
            
        }
    }

    @Override
    public boolean HeapVacio() {
        return (i==0);
    }

    @Override
    public int PrimerValor() {
        return vector[0].valor;
    }

    @Override
    public int Prioridad() {
        return vector[0].prioridad;
    }

}
