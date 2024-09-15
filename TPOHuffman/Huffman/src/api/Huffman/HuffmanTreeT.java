package api.Huffman;

import impl.Huffman.HuffmanTree.NodoABB;
import impl.Huffman.HuffmanPriorityQueue.HuffmanNode;

public interface HuffmanTreeT {
    NodoABB Raiz();
    HuffmanTreeT HijoIzq();
    HuffmanTreeT HijoDer();
    boolean ArbolVacio();
    
    void AgregarElem(HuffmanNode node);

    char ObtenerCaracter();
    double ObtenerProbabilidad();
}
