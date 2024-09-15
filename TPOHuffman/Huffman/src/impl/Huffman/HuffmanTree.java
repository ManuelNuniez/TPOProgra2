package impl.Huffman;

import api.Huffman.HuffmanTreeT;

public class HuffmanTree implements HuffmanTreeT {
    public class NodoABB{
		HuffmanTreeT hijoIzq;
		HuffmanTreeT hijoDer;

        char caracter;
        double peso;
	}

    NodoABB raiz;

    @Override
    public HuffmanTreeT Raiz() {
        return raiz;
    }

    @Override
    public HuffmanTreeT HijoIzq() {
        return raiz.HijoIzq;
    }

    @Override
    public HuffmanTreeT HijoDer() {
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
            raiz.HijoIzq = new HuffmanTree();
            raiz.HijoIzq.InicializarArbol();
            raiz.HijoDer = new HuffmanTree();
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

    private int mayor(HuffmanTreeT a){
        if (a.HijoDer().ArbolVacio())
            return a.Raiz();
        else
            return mayor(a.HijoDer());
    
    }

    private int menor(HuffmanTreeT a){
        if (a.HijoIzq().ArbolVacio())
            return a.Raiz();
        else
            return menor(a.HijoIzq());
    }
}
