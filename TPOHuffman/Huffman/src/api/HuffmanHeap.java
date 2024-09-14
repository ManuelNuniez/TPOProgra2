package api;
import impl.Huffman.Symbol;

public interface HuffmanHeap {
    void AddValue(Symbol value);
    
    Symbol Pop();
}
