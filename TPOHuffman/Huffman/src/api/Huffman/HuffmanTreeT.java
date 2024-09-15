package api.Huffman;

public interface HuffmanTreeT {
    HuffmanTreeT Raiz();
    HuffmanTreeT HijoIzq();
    HuffmanTreeT HijoDer();
    boolean ArbolVacio();
    void InicializarArbol();
    void AgregarElem(char caracter, double peso);

    char ObtenerCaracter();
    double ObtenerProbabilidad();
}
