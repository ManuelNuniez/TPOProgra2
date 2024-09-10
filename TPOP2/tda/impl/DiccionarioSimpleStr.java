package impl;

import api.ConjuntoTDA;
import api.DiccionarioSimpleStrTDA;

public class DiccionarioSimpleStr implements DiccionarioSimpleStrTDA {
    private class NodoClave {
        int clave;
        String valor;
        NodoClave sigClave;
    }

    private NodoClave origen;

    public void InicializarDiccionario() {
        origen = null;
    }
    
    public void Agregar(int clave, String valor) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc == null) {
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }
        nc.valor = valor;
    }

    private NodoClave Clave2NodoClave(int clave) {
        NodoClave aux = origen;
        while (aux!= null && aux.clave!=clave) {
            aux=aux.sigClave;
        }
        return aux;
    }
    
    public void Eliminar(int clave) {
        if(origen!=null) {
            if (origen.clave == clave) {
                origen = origen.sigClave;
            } else {
                NodoClave aux = origen;
                while (aux.sigClave!=null && aux.sigClave.clave != clave) {
                    aux=aux.sigClave;
                }
                if (aux.sigClave!=null) {
                    aux.sigClave=aux.sigClave.sigClave;
                }
            }
        }
    }
    
    public String Recuperar(int clave) {
        NodoClave nc = Clave2NodoClave(clave);
        return nc.valor;
    }
    
    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoDinamico();
        c.InicializarConjunto();
        NodoClave aux = origen;
        while (aux!=null) {
            c.Agregar(aux.clave);
            aux=aux.sigClave;
        }
        return c;
    }
}
