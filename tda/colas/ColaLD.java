package tda.colas;

public class ColaLD {
	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	Nodo ultimo;
	
	public void InicializarCola() {
		primero=null;
		ultimo=null;
	}
	
	public void Acolar(int x) {
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig  = null;
		if (ultimo != null) {
			ultimo.sig=nuevo;
		}
		ultimo = nuevo;
		if (primero==null) {
			primero=ultimo;
		}
	}
	
	public void Desacolar() {
		primero = primero.sig;
		if (primero == null) {
			ultimo = null;
		}
	}
	public boolean ColaVacia() {
		return (ultimo==null);
	}
	
	public int Primero() {
		return primero.info;
	}

}
