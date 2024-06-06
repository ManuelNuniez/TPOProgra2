package tda.DiccionariosMultiples;
import tda.conjuntos.ConjuntoTDA;

public interface DiccionarioMultipleTDA {
	void InicializarDiccionario();
	void Agregar(int clave, int valor);
	void Eliminar(int clave);
	void EliminarValor(int clave,int valor);
	ConjuntoTDA Recuperar(int clave);
	ConjuntoTDA Claves();
}
