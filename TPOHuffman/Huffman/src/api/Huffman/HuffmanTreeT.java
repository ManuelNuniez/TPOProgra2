package api.Huffman;

import impl.Huffman.HuffmanTree.NodoABB;

public interface HuffmanTreeT {
    NodoABB Raiz();
    HuffmanTreeT HijoIzq();
    HuffmanTreeT HijoDer();
    boolean ArbolVacio();
    void AgregarElem(char caracter, double peso);

    char ObtenerCaracter();
    double ObtenerProbabilidad();
}
