package api;

public interface PilaTDA {
    void InicializarPila(); /** Sin pre condición */
    void Apilar(int x);
    void Desapilar();
    int Tope();
    boolean PilaVacia();
}
