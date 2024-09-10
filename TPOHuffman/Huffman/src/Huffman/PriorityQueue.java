package impl.Huffman;

public class PriorityQueue implements PriorityQueueTDA {

    HuffmanHeapTDA queue;

    public PriorityQueue(){
        queue = new HuffmanHeap();
    }

    @Override
    public void AddValue(Symbol x) {
        queue.AddH(x);
    }

    @Override
    public Symbol ExtractValue() {
        return queue.GetValue();
    }

}
