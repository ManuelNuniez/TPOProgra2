package tda.diccionarios;
import tda.conjuntos.ConjuntoTDA;

public interface DiccionarioSimpleTDA {
	void InicializarDiccionario();
	void Agregar(int clave, int valor);
	void Eliminar(int clave);
	int Recuperar(int clave);
	ConjuntoTDA Claves();

		
}
