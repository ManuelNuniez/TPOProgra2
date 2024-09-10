package api;

import impl.ValPrio;

public interface PrioHeapTDA {
    public void InicializarHeap();
    public void AgregarH(ValPrio x);
    public void SacarH();
    boolean HeapVacio();
    int PrimerValor();
    int Prioridad();
}
