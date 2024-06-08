package api;

public interface ColaPrioridadTDA {
    void InicializarCola();
    void AcolarPrioridad(int x, int prioridad);
    void Desacolar();
    int Primero();
    boolean ColaVacia();
    int Prioridad();
}
