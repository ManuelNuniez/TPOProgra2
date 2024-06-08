package impl;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DiccionarioSimpleEstatico implements DiccionarioSimpleTDA {
    int[][] matrix;
    int lastIndex;

    @Override
    public void Agregar(int clave, int valor) {
        Eliminar(clave);

        matrix[lastIndex][0] = clave;
        matrix[lastIndex][1] = valor;

        lastIndex++;
    }

    @Override
    public ConjuntoTDA Claves() {
        return null;
    }

    @Override
    public void Eliminar(int clave) {
        for (int i = 0; i < lastIndex; i++) {
            if (matrix[i][0] == clave) {
                matrix[i][0] = matrix[lastIndex-1][0];
                matrix[i][1] = matrix[lastIndex-1][1];

                lastIndex--;
            }
        }
    }

    @Override
    public void InicializarDiccionario() {
        matrix = new int[50][2];
        lastIndex = 0;
    }

    @Override
    public int Recuperar(int clave) {
        int value = 0;
        
        for (int i = 0; i < lastIndex; i++) {
            if (matrix[i][0] == clave) {
                value = matrix[i][0];
            }
        }

        return(value);
    }


    public void ImprimirDiccionario() {
        for (int i = 0; i < lastIndex; i++) {
            int key = matrix[i][0];
            int value = matrix[i][1];

            System.out.print("[" + key + ", " + value + "] ");
        }

        System.out.println();
    }
}
