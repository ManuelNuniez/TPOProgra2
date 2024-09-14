package api.Huffman;

public interface HuffmanHeap {
    void AddValue(Symbol value);
    boolean IsEmpty();

    Symbol Pop();
    String GetCode(char character);
}
