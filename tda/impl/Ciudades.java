package impl;

import api.DiccionarioSimpleTDA;
import algoritmos.MetodosDiccSimple;
import api.CiudadesTDA;
import api.ConjuntoTDA;
import api.DiccionarioSimpleStrTDA;
import api.GrafoTDA;
import impl.Grafos.Grafo;
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
    DiccionarioSimpleStrTDA nombresCiudades; // claves: id ciudades / valores: nombres ciudades
    DiccionarioSimpleStrTDA nombresProvincias; // claves: id provincias / valroes: nombres provincias
    DiccionarioMultipleTDA ciudadesProvincias; // claves: id provincias / valores: id ciudades
    
    @Override
    public void Inicializar() {
        ultimaCiudad = 1;
        ultimaProvincia = 1;

        ciudades = new Grafo();
        ciudades.inicializarGrafo();

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
        ConjuntoTDA idCiudades = ciudadesProvincias.Recuperar(idProvincia);
        
        while(!idCiudades.ConjuntoVacio()){
            int idCiudad = idCiudades.Elegir();
            idCiudades.Sacar(idCiudad);
            ciudadesPorProvincia.Agregar(idCiudad, nombresCiudades.Recuperar(idCiudad));
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
    public DiccionarioSimpleTDA CiudadesPuente(int idOrigen, int idDestino) {
        DiccionarioSimpleDinamico ciudadesPuente = new DiccionarioSimpleDinamico();
        ConjuntoTDA ciudadesComparar = ciudades.Vertices();

        ciudadesPuente.InicializarDiccionario();

        while (!ciudadesComparar.ConjuntoVacio()) {
            int ciudadPuente = ciudadesComparar.Elegir();
            ciudadesComparar.Sacar(ciudadPuente);

            if (ciudades.ExisteArista(idOrigen, ciudadPuente) && ciudades.ExisteArista(ciudadPuente, idDestino)) {
                ciudadesPuente.Agregar(ciudadPuente, ciudades.PesoArista(idOrigen, ciudadPuente) + ciudades.PesoArista(ciudadPuente, idDestino));
            }
        }

        return ciudadesPuente;
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
    public DiccionarioSimpleStrTDA Provincias() {
        return nombresProvincias;
    }

    @Override
    public void UnirCiudades(int idOrigen, int idDestino, int distancia) {
        ciudades.AgregarArista(idOrigen, idDestino, distancia);
    }


    @Override
    public void EliminarCiudades(int idCiudad) {
        ConjuntoTDA aux = new ConjuntoDinamico();
        aux = ciudades.Vertices();

        ciudades.EliminarVertice(idCiudad);
        nombresCiudades.Eliminar(idCiudad);

        while (!aux.ConjuntoVacio()) {
            int provincia = aux.Elegir();
            aux.Sacar(provincia);

            if (ciudadesProvincias.Claves().Pertenece(provincia)) {
                ciudadesProvincias.EliminarValor(provincia, idCiudad);
            }
        }
    }

    public int Distancia(int origen, int destino){

        DiccionarioSimpleTDA caminosMasCortos = ciudades.CaminosMenorPeso(origen);
        //MetodosDiccSimple.ImprimirSimpleDiccionario(caminosMasCortos);
        //return 1;
        return caminosMasCortos.Recuperar(destino);


    }
}

