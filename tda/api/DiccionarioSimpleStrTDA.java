package api;

public interface DiccionarioSimpleStrTDA {
    void InicializarDiccionario();
    void Agregar(int clave, String valor);
    void Eliminar(int clave);
    String Recuperar(int clave);

    ConjuntoTDA Claves();
}
