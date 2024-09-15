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

    
    public HuffmanTree() {
        raiz = null;
    }

    @Override
    public NodoABB Raiz() {
        return raiz;
    }

    @Override
    public HuffmanTreeT HijoIzq() {
        return raiz.hijoIzq;
    }

    @Override
    public HuffmanTreeT HijoDer() {
        return raiz.hijoDer;
    }

    @Override
    public boolean ArbolVacio() {
        return (raiz == null);
    }

    @Override
    public void AgregarElem(char caracter, double peso) {
        NodoABB aux = new NodoABB();
        aux.caracter = caracter;
        aux.peso = peso;
        aux.hijoDer = new HuffmanTree();
        aux.hijoIzq = new HuffmanTree();

        if (raiz == null){
            raiz = aux;
            raiz.caracter = caracter;
            raiz.peso = peso;
            raiz.hijoDer = new HuffmanTree();
            raiz.hijoIzq = new HuffmanTree();
        }
        else if (raiz.peso > peso){
            raiz.hijoIzq.AgregarElem(caracter, peso);
        }
        else if (raiz.peso < peso){
            raiz.hijoDer.AgregarElem(caracter, peso);
        }
    }

    @Override
    public char ObtenerCaracter() {
        return raiz.caracter;
    }

    @Override
    public double ObtenerProbabilidad() {
        return raiz.peso;
    }

}
