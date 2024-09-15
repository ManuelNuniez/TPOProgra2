package impl.Huffman;

import api.Huffman.HuffmanTreeT;
import impl.Huffman.HuffmanPriorityQueue.HuffmanNode;

public class HuffmanTree implements HuffmanTreeT {
    public class NodoABB {
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
        if (this.ArbolVacio()) {
            raiz = new NodoABB();
            raiz.caracter = node.getCharacter();
            raiz.peso = node.getWeight();

            raiz.hijoIzq = new HuffmanTree();
            raiz.hijoDer = new HuffmanTree();
        }
        else if (raiz.peso >= node.getWeight()) {
            raiz.hijoIzq.AgregarElem(node);
        }
        else if (raiz.peso < node.getWeight()) {
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

    public void ImprimirArbol(HuffmanTreeT root){
        if (!ArbolVacio()) {
            System.out.println(Raiz().caracter + "-" + Double.toString(Raiz().peso));
            ImprimirArbol(HijoIzq());
            ImprimirArbol(HijoDer());
        }
    }
}
