package tda.grafos;
import tda.conjuntos.*;

public interface GrafoTDA {
	public void InicializarGrafo();
	public void AgregarVertice(int v);//cargar provincia
	public void EliminarVertice(int v);//eliminar provincia
	public void AgregarArista(int v1, int v2, int p);//cargar provincia
	public void EliminarArista(int v1, int v2);//eliminar provincia
	public int PesoArista(int v1, int v2);
	public boolean ExisteArista (int v1, int v2);
	public ConjuntoTDA Vertices();//listar provincias
	//public ConjuntoTDA CiudadesVecinas(v);
	//public ConjuntoTDA CiudadesPuente(v1,v2)
	//Ciudades predecesoras no es lo mismo que ciudades vecinas?
	//public void FuertmenteConectadas();
	//public void CiudadesExtremo();
	//public void Distancia(v1,v2)
}
