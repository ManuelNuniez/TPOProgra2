package tda.pilas;

public class PilaTI implements PilaTDA {
	int[] arr;
	int inx;
	
	public void InicializarPila() {
		arr = new int[100];
		inx = 0;
	}
	public void Apilar(int x) {
		for(int i=inx-1;i>=0;i--) {
			arr[i+1]=arr[i];
		}
		arr[0]=x;
		inx++;
	}
	public void Desapilar() {
		for(int i = 0;i<inx;i++) {
			arr[i]=arr[i+1];
		}
		inx--;
	}
	public boolean PilaVacia() {
		return(inx==0);
	}
	public int Tope() {
		return arr[0];
	}

}
