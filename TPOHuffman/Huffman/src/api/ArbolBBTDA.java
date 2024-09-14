package api;

import api.Huffman.HasValue;

public interface ArbolBBTDA<T extends HasValue<U>, U> {
    T Raiz();
    ArbolBBTDA<T, U> HijoIzq();
    ArbolBBTDA<T, U> HijoDer();
    boolean ArbolVacio();
    void InicializarArbol();
    void AgregarElem(T x);
    void EliminarElem(U x);
}
