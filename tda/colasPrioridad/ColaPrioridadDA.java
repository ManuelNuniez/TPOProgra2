package tda.colasPrioridad;

public class ColaPrioridadDA implements ColaPrioridadTDA {
	int[] elementos;
	int[] prioridades;
	int indice;
	
	public void InicializarCola() {
		elementos = new int[100];
		prioridades = new int[100];
		indice = 0;
	}
	
	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;
		while(j>0 && prioridades[j-1]>prioridad) {
			elementos[j]=elementos[j-1];
			prioridades[j]=prioridades[j-1];
			j--;
		}
		elementos[j]=x;
		prioridades[j]=prioridad;
		indice++;
	}
	
	public void Desacolar() {
		indice--;
	}
	
	public boolean ColaVacia() {
		return(indice==0);
	}
	
	public int Primero() {
		return elementos[indice-1];
	}
	
	public int Prioridad() {
		return prioridades[indice-1];
	}
	
	

}
