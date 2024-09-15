package api.Huffman;

import impl.Huffman.HuffmanPriorityQueue.HuffmanNode;

public interface HuffmanHeap {
    void AddValue(char character, double peso);
    void AddValue(double peso);
    boolean IsEmpty();

    HuffmanNode Pop();
    String GetCode(char character);
}
