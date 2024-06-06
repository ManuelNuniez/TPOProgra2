package tda.colasPrioridad;

public class ColaPrioridadAO {
	Elemento[] elementos;
	int indice;
	
	public void InicializarCola() {
		elementos = new Elemento[100];
		indice = 0;
	}
	
	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;
		while(j>0 && elementos[j-1].prioridad>prioridad) {
			elementos[j]=elementos[j-1];
			j--;
		}
		elementos[j]=new Elemento();
		elementos[j].valor=x;
		elementos[j].prioridad=prioridad;
		indice++;
	}
	
	public void Desacolar() {
		indice--;
	}
	
	public boolean ColaVacia() {
		return(indice==0);
	}
	
	public int Primero() {
		return elementos[indice-1].valor;
	}
	
	public int Prioridad() {
		return elementos[indice-1].prioridad;
	}

}
