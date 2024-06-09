package impl;

import api.ConjuntoTDA;
import api.GrafoTDA;

public class Vertice {
	int nodo;
	Arista arista;
	Vertice sigNodo;
}

public class Arista {
	int peso;
	Vertice nodoDestino;
	Arista sigArista;
}

public class GrafoDinamico implements GrafoTDA {


	Vertice origen;
	
	public void InicializarGrafo() {
		origen = null;
	}

	public void AgregarVertice(int x) {
		Vertice nuevo = new Vertice();
		nuevo.nodo = x;
		nuevo.arista = null;
		nuevo.sigNodo = origen;
		origen = nuevo;
	}
	

	public void EliminarVertice(int x) {
		if (origen.nodo == x) origen = origen.sigNodo;
		Vertice aux = origen;

		while (aux != null) {
			this.EliminarAristaEnNodo(aux, x);
			if (aux.sigNodo != null && aux.sigNodo.nodo == x) {
				aux.sigNodo = aux.sigNodo.sigNodo;
			}
			aux = aux.sigNodo;
		}
	}

	private void EliminarAristaEnNodo(Vertice nodo, int v) {
		Arista aux = nodo.arista;
		if (aux != null) {
			if (aux.nodoDestino.nodo == v) {
				nodo.arista = aux.sigArista;
			} else {
				while(aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v)
					aux = aux.sigArista;
				if (aux.sigArista != null)
					aux.sigArista = aux.sigArista.sigArista;
			}
		}
	}
	
	private Vertice Vertice2Nodo(int x) {
		Vertice aux = origen;
		while(aux !=null && aux.nodo != x)
			aux = aux.sigNodo;

		return aux;
	}
	
	public void AgregarArista(int x, int y, int w) {
		Vertice n1 = Vertice2Nodo(x);
		Vertice n2 = Vertice2Nodo(y);
		Arista nuevo = new Arista();

		nuevo.peso = w;
		nuevo.nodoDestino = n2;
		nuevo.sigArista = n1.arista;
		n1.arista = nuevo;
	}


	public void EliminarArista(int x, int y) {
		Vertice n1 = Vertice2Nodo(x);
		EliminarAristaEnNodo(n1,y);
	}

	public int PesoArista(int x, int y) {
		Vertice nodo = Vertice2Nodo(x);

		Arista aux = nodo.arista;
		while (aux.nodoDestino.nodo != y)
			aux = aux.sigArista;

		return aux.peso;
	}

	public boolean ExisteArista(int x, int y) {
		Vertice nodo = Vertice2Nodo(x);
		
		Arista aux = nodo.arista;
		while (aux != null && aux.nodoDestino.nodo != y) {
			aux = aux.sigArista;
		}

		return (aux != null);
	}

	public ConjuntoTDA Vertices() {
		ConjuntoTDA CNodos = new ConjuntoDinamico();
		CNodos.InicializarConjunto();

		Vertice aux = origen;
		while (aux != null) {
			CNodos.Agregar(aux.nodo);
			aux = aux.sigNodo;
		}

		return CNodos;
	}
}
