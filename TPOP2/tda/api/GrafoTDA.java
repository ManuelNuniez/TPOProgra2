package api;

public interface GrafoTDA {
    void inicializarGrafo();
    void AgregarVertice(int v);
    void EliminarVertice(int v);
    ConjuntoTDA Vertices();
    void AgregarArista(int origen, int destino, int peso);
    void EliminarArista(int origen, int destino);
    boolean ExisteArista(int origen, int destino);
    int PesoArista(int origen, int destino);
    DiccionarioSimpleTDA CaminosMenorPeso(int origen);
}
