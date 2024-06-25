package api;

public interface ColaPrioridadTDA {
    void InicializarCola(boolean mayorAmenor);
    void Acolar(int n, int prioridad);//cola previamente inicializada
    void Desacolar();//cola inicializada y no vacia
    int PrimerElemento();//cola inicializada y no vacia
    boolean ColaVacia();//cola inicializada
    int Prioridad();//inicializada y no vacia


}
