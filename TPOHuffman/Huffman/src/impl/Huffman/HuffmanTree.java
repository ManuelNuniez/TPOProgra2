package impl.Huffman;

import api.Huffman.HuffmanTreeT;
import impl.Huffman.HuffmanPriorityQueue.HuffmanNode;

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
    public void AgregarElem(HuffmanNode node) {
        NodoABB aux = new NodoABB();
        aux.caracter = node.getCharacter();
        aux.peso = node.getWeight();

    

        if (raiz == null){
            raiz = aux;
        }
        else if (raiz.peso > node.getWeight()){
            raiz.hijoIzq.AgregarElem(node);
        }
        else if (raiz.peso < node.getWeight()){
            raiz.hijoDer.AgregarElem(node);
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

    public void ImprimirArbol(HuffmanTreeT arbol){
        if (ArbolVacio()) {
            ImprimirArbol(HijoIzq());
            System.out.println(Raiz());
            ImprimirArbol(HijoDer());
        }
    }


}
