package api;

public interface CiudadesTDA {	

	public void Inicializar();

	public void CargarProvincia(String nombreProvincia);
	public DiccionarioSimpleStrTDA Provincias();
	public DiccionarioSimpleStrTDA nombresCiudades(); 
	public void CargarCiudad(String nombreCiudad, int idProvincia);
	public DiccionarioSimpleStrTDA CiudadesPorProvincia(int idProvincia);
	public void EliminarCiudades(int idCiudad);
	
	public ConjuntoTDA CiudadesVecinas(int idCiudad); // conectada por un sola ruta
	public DiccionarioSimpleTDA CiudadesPuente(int idOrigen, int idDestino); // ruta ab bc
	public ConjuntoTDA CiudadesPredecesoras(int idCiudad); // ciudades desde las que podemos llegar
	public ConjuntoTDA CiudadesExtremo(); // no parta ninguna ruta de ellas, solo le lleguen
	public DiccionarioMultipleTDA CiudadesFuertmenteConectadas(); // rutas ida y vuelta entre

	public void UnirCiudades(int idOrigen, int idDestino, int distancia);

	public int Distancia(int idOrigen, int idDestino);
	
}
