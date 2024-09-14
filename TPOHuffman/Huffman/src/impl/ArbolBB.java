package impl;

import api.ArbolBBTDA;

public class ArbolBB implements ArbolBBTDA<T> {
    NodoABB raiz;

    @Override
    public int Raiz() {
        return raiz.Info;
    }

    @Override
    public ArbolBBTDA HijoIzq() {
        return raiz.HijoIzq;
    }

    @Override
    public ArbolBBTDA HijoDer() {
        return raiz.HijoDer;
    }

    @Override
    public boolean ArbolVacio() {
        return (raiz == null);
    }

    @Override
    public void InicializarArbol() {
        raiz = null;
    }

    @Override
    public void AgregarElem(int x) {
        if (raiz == null){
            raiz = new NodoABB();
            raiz.Info = x;
            raiz.HijoIzq = new ArbolBB();
            raiz.HijoIzq.InicializarArbol();
            raiz.HijoDer = new ArbolBB();
            raiz.HijoDer.InicializarArbol();
        }
        else if (raiz.Info > x )
            raiz.HijoIzq.AgregarElem(x);
        else if (raiz.Info < x)
            raiz.HijoDer.AgregarElem(x);
    }

    @Override
    public void EliminarElem(int x) {
        if (raiz != null) {
            if (raiz.Info == x && raiz.HijoIzq.ArbolVacio() &&
                raiz.HijoDer.ArbolVacio()) {
                    raiz = null;
        }
        else if (raiz.Info == x && !raiz.HijoIzq.ArbolVacio()
            ) {
                raiz.Info = this.mayor(raiz.HijoIzq);//this marca la funcion que esta dentro de ArbolBB
                raiz.HijoIzq.EliminarElem(raiz.Info);
        }
        else if (raiz.Info == x && raiz.HijoIzq.ArbolVacio())
            {
            raiz.Info = this.menor(raiz.HijoDer);
            raiz.HijoDer.EliminarElem(raiz.Info);
        }
        else if (raiz.Info < x){
            raiz.HijoDer.EliminarElem(x);
        }
        else{
            raiz.HijoIzq.EliminarElem(x);
        }
        }
    }

    private int mayor(ArbolBBTDA a){
        if (a.HijoDer().ArbolVacio())
            return a.Raiz();
        else
            return mayor(a.HijoDer());
    
    }

    private int menor(ArbolBBTDA a){
        if (a.HijoIzq().ArbolVacio())
            return a.Raiz();
        else
            return menor(a.HijoIzq());
    }



}
