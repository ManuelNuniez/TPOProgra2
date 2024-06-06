package tda.colasPrioridad;

public interface ColaPrioridadTDA {
	void InicializarCola();
	void AcolarPrioridad(int x, int prioridad);
	void Desacolar();
	boolean ColaVacia();
	int Primero();
	int Prioridad();
}
