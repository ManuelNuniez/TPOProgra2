package api;

public interface CiudadesTDA {	

	public void Inicializar();

	public void CargarProvincia(String nombreProvincia);
	public DiccionarioSimpleStrTDA Provincias(); 
	public void CargarCiudad(String nombreCiudad, int idProvincia);
	public DiccionarioSimpleStrTDA CiudadesPorProvincia(int idProvincia);
	public void EliminarCiudades(int idCiudad);
	
	public ConjuntoTDA CiudadesVecinas(int idCiudad); 
	public DiccionarioSimpleTDA CiudadesPuente(int idOrigen, int idDestino);
	public ConjuntoTDA CiudadesPredecesoras(int idCiudad); 
	public ConjuntoTDA CiudadesExtremo(); 
	public DiccionarioMultipleTDA CiudadesFuertmenteConectadas(); 

	public void UnirCiudades(int idOrigen, int idDestino, int distancia);

	public int Distancia(int idOrigen, int idDestino);
	
}
