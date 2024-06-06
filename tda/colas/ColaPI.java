package tda.colas;

public class ColaPI implements ColaTDA{
	int[] arr;
	int inx;
	
	public void InicializarCola() {
		arr = new int[100];
		inx = 0;
	}
	
	public void Acolar(int x) {
		arr[inx]=x;
		inx++;
	}
	
	public void Desacolar() {
		for(int i=0;i<inx-1;i++) {
			arr[i]=arr[i+1];
		}
		inx--;
	}
	
	public boolean ColaVacia() {
		return (inx==0);
	}
	
	public int Primero() {
		return arr[0];
	}

}


