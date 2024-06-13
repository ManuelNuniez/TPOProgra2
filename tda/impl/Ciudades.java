package impl;

import api.DiccionarioSimpleTDA;
import api.CiudadesTDA;
import api.ConjuntoTDA;
import api.DiccionarioSimpleStrTDA;
import api.GrafoTDA;
import api.DiccionarioMultipleTDA;

import algoritmos.*;

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
        ciudades.InicializarGrafo();

        nombresCiudades = new DiccionarioSimpleStr();
        nombresCiudades.InicializarDiccionario();

        nombresProvincias = new DiccionarioSimpleStr();
        nombresProvincias.InicializarDiccionario();

        ciudadesProvincias = new DiccionarioMultipleDinamico();
        ciudadesProvincias.InicializarDiccionario();
    }
    
    @Override
    public void CargarProvincia(String nombreProvincia) {
        nombresProvincias.Agregar(ultimaProvincia, nombreProvincia);
        

        ultimaProvincia++;
    }

    @Override
    public void CargarCiudad(String nombreCiudad, int idProvincia) {
        ciudades.AgregarVertice(ultimaCiudad);
        nombresCiudades.Agregar(ultimaCiudad, nombreCiudad);
        ciudadesProvincias.Agregar(idProvincia, ultimaCiudad);

        ultimaCiudad++;
    }

    @Override
    public DiccionarioSimpleStrTDA CiudadesPorProvincia(int idProvincia) {
        
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
    public ConjuntoTDA CiudadesExtremo() {
        ConjuntoTDA conjuntoCiudades = new ConjuntoDinamico();
        ConjuntoTDA conjuntoCiudadesComparar = new ConjuntoDinamico();
        ConjuntoTDA ciudadesExtremo = new ConjuntoDinamico();
        

        conjuntoCiudades = ciudades.Vertices();

        while (!conjuntoCiudades.ConjuntoVacio()) {
            boolean esExtremo = true;
            int ciudadElegida = conjuntoCiudades.Elegir();
            conjuntoCiudades.Sacar(ciudadElegida);

            conjuntoCiudadesComparar = ciudades.Vertices();
            conjuntoCiudadesComparar.Sacar(ciudadElegida);

            while (!conjuntoCiudadesComparar.ConjuntoVacio() && esExtremo) {
                int ciudadComparar = conjuntoCiudadesComparar.Elegir();
                conjuntoCiudadesComparar.Sacar(ciudadComparar);

                if (ciudades.ExisteArista(ciudadElegida, ciudadComparar)) {
                    esExtremo = false;
                }
            }

            if (esExtremo) {
                ciudadesExtremo.Agregar(ciudadElegida);
            }
        }

        return ciudadesExtremo;

    }

    @Override
    public DiccionarioMultipleTDA CiudadesFuertmenteConectadas() {
        ConjuntoTDA conjuntoCiudades = new ConjuntoDinamico();
        ConjuntoTDA conjuntoCiudadesComparar = new ConjuntoDinamico();
        DiccionarioMultipleTDA ciudadesFuertementeConectadas = new DiccionarioMultipleDinamico();

        conjuntoCiudades = ciudades.Vertices();

        while (!conjuntoCiudades.ConjuntoVacio()) {
            int ciudadElegida = conjuntoCiudades.Elegir();
            conjuntoCiudades.Sacar(ciudadElegida);

            conjuntoCiudadesComparar = ciudades.Vertices();
            conjuntoCiudadesComparar.Sacar(ciudadElegida);

            while (!conjuntoCiudadesComparar.ConjuntoVacio()) {
                int ciudadComparar = conjuntoCiudadesComparar.Elegir();
                conjuntoCiudadesComparar.Sacar(ciudadComparar);

                if (ciudades.ExisteArista(ciudadElegida, ciudadComparar) && ciudades.ExisteArista(ciudadComparar, ciudadElegida)) {
                    ciudadesFuertementeConectadas.Agregar(ciudadElegida, ciudadComparar);
                }
            }
        }

        return ciudadesFuertementeConectadas;
    }

    @Override
    public ConjuntoTDA CiudadesPredecesoras(int idCiudad) {
        ConjuntoTDA ciudadesPredecesoras = new ConjuntoDinamico();
        ConjuntoTDA ciudadesComparar = ciudades.Vertices();

        ciudadesPredecesoras.InicializarConjunto();
        ciudadesComparar.Sacar(idCiudad);

        while (!ciudadesComparar.ConjuntoVacio()) {
            int ciudad = ciudadesComparar.Elegir();

            if (ciudades.ExisteArista(ciudad, idCiudad)) {
                ciudadesPredecesoras.Agregar(ciudad);
            }

            ciudadesComparar.Sacar(ciudad);            
        } 

        return ciudadesPredecesoras;
    }

    @Override
    public DiccionarioSimpleStrTDA CiudadesPuente(int idOrigen, int idDestino) {
        // TODO Auto-generated method stu
        return null;
    }
    

    @Override
    public ConjuntoTDA CiudadesVecinas(int idCiudad) {
        ConjuntoTDA ciudadesVecinas = new ConjuntoDinamico();
        ConjuntoTDA ciudadesComparar = new ConjuntoDinamico();

        ciudadesComparar = ciudades.Vertices();
        ciudadesComparar.Sacar(idCiudad);

        while (!ciudadesComparar.ConjuntoVacio()) {
            int ciudadVecina = ciudadesComparar.Elegir();

            if (ciudades.ExisteArista(idCiudad, ciudadVecina) != ciudades.ExisteArista(ciudadVecina, idCiudad)) {
                ciudadesVecinas.Agregar(ciudadVecina);
            }

            ciudadesComparar.Sacar(ciudadVecina);            
        } 

        return ciudadesVecinas;
    }

    @Override
    public int Distancia(int idOrigen, int idDestino) {
        return ciudades.PesoEntre(idOrigen, idDestino);
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
        ciudades.EliminarVertice(idCiudad); // No estoy seguro si acá sería algo más que esto, Santi F.
    }
}