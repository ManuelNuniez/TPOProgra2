package impl;

import api.DiccionarioSimpleTDA;
import api.CiudadesTDA;
import api.ConjuntoTDA;
import api.DiccionarioSimpleStrTDA;
import api.GrafoTDA;
import api.DiccionarioMultipleTDA;

/*

    ciudades
    idProvincia -> idProvincia
    0 -> 1 -> 2 -> 3 -> 4

    nombreCiudades
    idCiudad -> nombreCiudad
    {
        0: "CABA"
        1: "La Plata"
        2: "Ciudad de Cordoba"
    }

    nombreProvincias
    idProvincia -> nombreProvincia
    {
        0: "Buenos Aires"
        1: "Cordoba"   
    }

    ciudadesProvincia
    idProvincia -> conjunto idCiudad
    {
        0: [0, 1]
        1: [2]
    }

*/

public class Ciudades implements CiudadesTDA {
    int ultimaProvincia;
    int ultimaCiudad;

    GrafoTDA ciudades;
    DiccionarioSimpleStrTDA nombresCiudades;
    DiccionarioSimpleStrTDA nombresProvincias;
    DiccionarioMultipleTDA ciudadesProvincias;
    
    @Override
    public void Inicializar() {
        ultimaCiudad = 1;
        ultimaProvincia = 1;

        ciudades = new GrafoDinamico();
        nombresCiudades = new DiccionarioSimpleStr();
        nombresProvincias = new DiccionarioSimpleStr();
        ciudadesProvincias = new DiccionarioMultipleDinamico();
    }
    
    @Override
    public void CargarProvincia(String nombreProvincia) {
        nombresProvincias.Agregar(ultimaProvincia, nombreProvincia);

        ultimaProvincia++;
    }

    @Override
    public void CargarCiudad(String nombreCiudad, int idProvincia) {
        ciudades.AgregarVertice(ultimaCiudad);
        // nombresCiudades.Agregar(ultimaCiudad, nombreCiudad);
        // ciudadesProvincias.Agregar(idProvincia, ultimaCiudad);

        ultimaCiudad++;
    }

    @Override
    public DiccionarioSimpleStrTDA Ciudades(int idProvincia) {
        
        DiccionarioSimpleStrTDA ciudadesPorProvincia = new DiccionarioSimpleStr();
        ciudadesPorProvincia.InicializarDiccionario();
        ConjuntoTDA idciudades = ciudadesProvincias.Recuperar(idProvincia);
        
        while(!idciudades.ConjuntoVacio()){
            int aux=idciudades.Elegir();
            ciudadesPorProvincia.Agregar(aux, nombresCiudades.Recuperar(aux));
            idciudades.Sacar(aux);
        }
        
        return ciudadesPorProvincia;
    }

    @Override
    public DiccionarioSimpleStrTDA CiudadesExtremo() {
        ConjuntoTDA aux = new ConjuntoDinamico();
        ConjuntoTDA aux2 = new ConjuntoDinamico();
        ConjuntoTDA ciudadesExtremo = new ConjuntoDinamico();
        int cont = 0;

        aux = ciudades.Vertices();

        while (!aux.ConjuntoVacio()) {
            int ciudad = aux.Elegir();
            aux.Sacar(ciudad);

            aux2 = ciudades.Vertices();
            aux2.Sacar(ciudad);

            while (!aux2.ConjuntoVacio() && cont == 0) {
                int ciudadAComparar = aux2.Elegir();
                aux2.Sacar(ciudadAComparar);

                if (ciudades.ExisteArista())
                
            }
        }

    }

    @Override
    public DiccionarioSimpleTDA CiudadesFuertmenteConectadas() {
        DiccionarioSimpleTDA fuertementeConectadas = new DiccionarioSimpleDinamico();
        ConjuntoTDA ciudadesSinRevisar= ciudades.Vertices();
        ConjuntoTDA auxCiudades = ciudades.Vertices();
        
        while (!ciudadesSinRevisar.ConjuntoVacio()) {
            int ciudad1= ciudadesSinRevisar.Elegir();
            ciudadesSinRevisar.Sacar(ciudad1);
            auxCiudades.Sacar(ciudad1);
    
            int ciudad2= auxCiudades.Elegir();
            auxCiudades.Sacar(ciudad2);
            if (ciudades.ExisteArista(ciudad1, ciudad2) && ciudades.ExisteArista(ciudad2, ciudad1)) {
                fuertementeConectadas.Agregar(ciudad1, ciudad2);
            }
        }        
        
        return fuertementeConectadas;
    }

    @Override
    public ConjuntoTDA CiudadesPredecesoras(int idCiudad) {
        ConjuntoTDA ciudadesPredecesoras = new ConjuntoDinamico();
        GrafoTDA aux = new GrafoDinamico();
        aux = ciudades;

        ciudadesPredecesoras.InicializarConjunto();
        aux.Vertices().Sacar(idCiudad);

        while (aux.Vertices() != null) {
            int ciudad = aux.Vertices().Elegir();

            if (aux.ExisteArista(idCiudad, ciudad)) {
                ciudadesPredecesoras.Agregar(ciudad);
            }

            aux.Vertices().Sacar(ciudad);            
        } 

        return ciudadesPredecesoras;
    }

    @Override
    public DiccionarioSimpleStrTDA CiudadesPuente(int idOrigen, int idDestino) {
        // TODO Auto-generated method stub
        return null;
    }
    

    @Override
    public ConjuntoTDA CiudadesVecinas(int idCiudad) {
        ConjuntoTDA ciudadesVecinas = new ConjuntoDinamico();
        GrafoTDA aux = new GrafoDinamico();
        aux = ciudades;        ciudadesVecinas.InicializarConjunto();
        aux.Vertices().Sacar(idCiudad);

        while (aux.Vertices() != null) {
            int ciudad = aux.Vertices().Elegir();

            if (aux.ExisteArista(idCiudad, ciudad)) {
                ciudadesVecinas.Agregar(ciudad);
            }

            aux.Vertices().Sacar(ciudad);            
        } 

        return ciudadesVecinas;
    }

    @Override
    public int Distancia(int idOrigen, int idDestino) {
        return 0;
    }


    @Override
    public DiccionarioSimpleStrTDA Provincias() {
        return nombresProvincias;
    }

    @Override
    public void UnirCiudades(int idOrigen, int idDestino, int distancia) {
        ciudades.AgregarArista(idOrigen, idDestino, distancia);
    }

    @Override
    public void EliminarCiudades(int idCiudad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'EliminarCiudades'");
    }        
}

