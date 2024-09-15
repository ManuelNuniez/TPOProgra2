import algorithms.HuffmanAlgorithm;
import api.Huffman.HuffmanTreeT;
import impl.Huffman.HuffmanTree;
import impl.Huffman.HuffmanPriorityQueue.HuffmanNode;

public class App {
    public static void main(String[] args) throws Exception {
        char[] alph = {'a', 'b', 'c', 'd', 'e', 'f'};
        double[] prob = {.45, .13, .12, .16, .09, .05};

        //HuffmanAlgorithm algo = new HuffmanAlgorithm(alph, prob);

        //algo.PrintCodes();
        
        
        HuffmanNode n1 = new HuffmanNode('a', 4);
        HuffmanNode n2 = new HuffmanNode('b', 1);
        
        HuffmanTreeT arbol = new HuffmanTree();

        arbol.AgregarElem(n1);
        arbol.AgregarElem(n2);

        arbol.ImprimirArbol(arbol);
    }
}
