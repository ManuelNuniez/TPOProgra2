package api;

public interface CiudadesTDA {	
	public void Inicializar();

	public DiccionarioSimpleStrTDA Provincias();
	public DiccionarioSimpleStrTDA Ciudades(int idProvincia);
	public DiccionarioSimpleStrTDA CargarCiudad(String nombre);
	
	public DiccionarioSimpleStrTDA CiudadesVecinas(int idCiudad);
	public DiccionarioSimpleStrTDA CiudadesPuente(int idOrigen, int idDestino);
	public DiccionarioSimpleStrTDA CiudadesPredecesoras(int idCiudad);
	public DiccionarioSimpleStrTDA CiudadesExtremo();
	public DiccionarioSimpleTDA CiudadesFuertmenteConectadas();

	public void UnirCiudades(int idOrigen, int idDestino, int distancia);
	public int Distancia(int idOrigen, int idDestino);
}
