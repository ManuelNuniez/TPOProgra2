package tda.pilas;

public class PilaTF2 implements PilaTDA{
	int[] arr;
	
	public void InicializarPila() {
		arr=new int[100];
		arr[0] = 0;
	}
	public void Apilar(int x) {
		arr[arr[0]+1]=x;
		arr[0]++;
	}
	public void Desapilar() {
		arr[0]--;
	}
	public boolean PilaVacia() {
		return (arr[0]==0);
	}
	public int Tope() {
		return arr[arr[0]];
	}

}
