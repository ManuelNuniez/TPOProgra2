package api.Huffman;

public interface ArbolBBHuffman {
    Symbol Raiz();
    ArbolBBHuffman HijoIzq();
    ArbolBBHuffman HijoDer();
    boolean ArbolVacio();
    void InicializarArbol();
    void AgregarElem(Symbol x);
    void EliminarElem(char x);
}
