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

            outputTree.AgregarElem(x);
            outputTree.AgregarElem(y);

            double newWeight = x.getWeight() + y.getWeight();
            inputQueue.AddValue(newWeight);
        }
    }

    public void PrintCodes() {
        
    }
}