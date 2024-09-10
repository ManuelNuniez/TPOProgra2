package algoritmos;

import api.GrafoTDA;
import api.ConjuntoTDA;

public class metodosGrafos {
    public static void ImprimirGrafo(GrafoTDA grafo) {
        ConjuntoTDA vertices = grafo.Vertices();
        ConjuntoTDA verticesCopia = grafo.Vertices();

        while (!vertices.ConjuntoVacio()) {
            int vertice = vertices.Elegir();
            vertices.Sacar(vertice);

            while (!verticesCopia.ConjuntoVacio()) {
                int verticeCopia = verticesCopia.Elegir();
                verticesCopia.Sacar(verticeCopia);

                if (grafo.ExisteArista(vertice, verticeCopia)) {
                    System.out.println("Arista: " + vertice + " -> " + verticeCopia);
                }
            }

            verticesCopia = grafo.Vertices();
        }
    }
}
