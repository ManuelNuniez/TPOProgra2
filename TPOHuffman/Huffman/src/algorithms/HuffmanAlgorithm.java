package algorithms;

import api.Huffman.HuffmanTreeT;
import impl.Huffman.HuffmanPriorityQueue.HuffmanNode;


import impl.Huffman.HuffmanPriorityQueue;


public class HuffmanAlgorithm {
    HuffmanPriorityQueue inputQueue;
    HuffmanTreeT outputTree;

    // Constructor
    public HuffmanAlgorithm(char[] alphabet, double[] probabilities) throws Exception {
        if (alphabet.length != probabilities.length) {
            throw new Exception("Los simbolos y las probabilidades tiene que tener el mismo largo");
        }

        for (int i = 0; i < alphabet.length; i++) {
            inputQueue.AddValue(alphabet[i], probabilities[i]);
        }
        
        for (int i = 1; i <= alphabet.length; i++){
            HuffmanNode x = inputQueue.Pop();
            HuffmanNode y = inputQueue.Pop();

            // outputTree.AgregarElem(x.getWeight() + y.getWeight());
            // outputTree.AgregarElem(x.getWeight());
            // outputTree.AgregarElem(y.getWeight());

            
        }
    }

    /*
     * [a, b, c, d, e]
     * [a-b, c, d, e]
     * [a-b-c, d, e]
     * [a-b-c-d, e]
     * [a-b-c-d-e]
    */



    public String GetCode(char character){
        // Necesito recorrer el heap y devolver en codigo binario, va a recorrer InOrder
        // Una forma de obtener los hijos del heap
        
        

        String code = "00";

        return code;
    }
}
