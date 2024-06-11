package api;

public interface CiudadesTDA {	
	public void Inicializar();

	public void CargarProvincia(String nombreProvincia);
	public DiccionarioSimpleStrTDA Provincias(); // devuelve provincias con sus Ids
	public void CargarCiudad(String nombreCiudad, int idProvincia); // cambiamos string por int, sacamos el int a partir de un DiccSimple
	public DiccionarioSimpleStrTDA Ciudades(int idProvincia); // no deberia ir un diccionario de diccionarios que nos devuelva todas las ciudades a partir de una provincia}]?
	public void EliminarCiudades(int idCiudad);
	
	public ConjuntoTDA CiudadesVecinas(int idCiudad);
	public DiccionarioSimpleStrTDA CiudadesPuente(int idOrigen, int idDestino);
	public ConjuntoTDA CiudadesPredecesoras(int idCiudad);
	public DiccionarioSimpleStrTDA CiudadesExtremo();
	public DiccionarioSimpleTDA CiudadesFuertmenteConectadas();

	public void UnirCiudades(int idOrigen, int idDestino, int distancia);
	public int Distancia(int idOrigen, int idDestino);
}
