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
        else if (raiz.peso < node.getWeight()) {
            raiz.hijoIzq.AgregarElem(node);
        }
        else if (raiz.peso >= node.getWeight()) {
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

    public void ImprimirArbol(HuffmanTreeT root, String prepend){
        if (!root.ArbolVacio()) {

            //System.out.println(root.HijoIzq().ObtenerCaracter());

            ImprimirArbol(root.HijoIzq(), prepend + "0");

            char character = root.Raiz().caracter;
            String weight = String.format("%.2f", root.Raiz().peso);
            System.out.println((character == '\0' ? ' ' : character) + "-" + weight);

            ImprimirArbol(root.HijoDer(), prepend + "1");
        }
    }
}
