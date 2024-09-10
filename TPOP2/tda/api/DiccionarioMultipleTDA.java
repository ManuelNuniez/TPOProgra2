package api;

public interface DiccionarioMultipleTDA {
    void InicializarDiccionario();
    //siempre que el diccionario este incializado
    void Agregar(int clave, int valor);
    //siempre que el diccionario este incializado
    void Eliminar(int clave);
    //siempre que el diccionario este incializado
    void EliminarValor(int clave,int valor);
    //siempre que el diccionario este incializado
    ConjuntoTDA Recuperar(int clave);// el recuperar nos tiene que devolver el conjunto de valores asociados a una clave
    //siempre que el diccionario este incializado
    ConjuntoTDA Claves();

}
