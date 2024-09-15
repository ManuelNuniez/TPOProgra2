package api.Huffman;

import impl.Huffman.HuffmanTree.NodoABB;
import impl.Huffman.HuffmanPriorityQueue.HuffmanNode;

public interface HuffmanTreeT {
    NodoABB Raiz();
    HuffmanTreeT HijoIzq();
    HuffmanTreeT HijoDer();
    boolean ArbolVacio();
    
    void AgregarElem(HuffmanNode node1, HuffmanNode node2);

    char ObtenerCaracter();
    double ObtenerProbabilidad();

    void ImprimirArbol(HuffmanTreeT root, String prepend);
}
