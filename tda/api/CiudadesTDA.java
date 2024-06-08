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


/*  
 * 
 * Grafo: 1 -> 2 
 *         2 -> 4
 *          4 -> 3 
 * 
 * dict: 
 *        1: BsAs
 *        2: Mar del plata
 *        3: etc...
 *        4: ...
 * 
*/