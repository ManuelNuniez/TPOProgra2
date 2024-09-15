package impl.Huffman;

import api.Huffman.HuffmanHeap;

public class HuffmanPriorityQueue implements HuffmanHeap {
    public static class HuffmanNode {
        char character;
        double weight;

        public HuffmanNode(char character, double weight) {
            this.character = character;
            this.weight = weight;
        }

        public HuffmanNode(double peso) {
            this.weight = peso;
        }

        public char getCharacter() {
            return this.character;
        }

        public double getWeight() {
            return this.weight;
        }     
	}

    int size;
    int capacity = 127; //127
    HuffmanNode[] chars;

    public HuffmanPriorityQueue() {
        chars = new HuffmanNode[capacity];
        size = 0;
    }

    private void resizeVector() {
        if (size != capacity) return;
        
        capacity = capacity*2 - 1;
        HuffmanNode[] aux = new HuffmanNode[capacity];
        for (int i = 0; i < size; i++) {
            aux[i] = chars[i];
        }
        chars = aux;
    }

    private void addNode(HuffmanNode node) {
        chars[size] = node;
        size++;

        int newPos = size-1;
        int padrePos = (newPos - 1)/2;

        while (chars[padrePos].weight > chars[newPos].weight) {
            HuffmanNode aux = chars[padrePos];
            chars[padrePos] = chars[newPos];
            chars[newPos] = aux;

            newPos = padrePos;
            padrePos = (newPos - 1)/2;
        }
    }

    @Override
    public void AddValue(char character, double weight) {
        resizeVector();
        
        HuffmanNode newNode = new HuffmanNode(character, weight);
        addNode(newNode);
    }

    @Override
    public void AddValue(double weight) {
        resizeVector();
        
        HuffmanNode newNode = new HuffmanNode(weight);
        addNode(newNode);
    }

    @Override
    public boolean IsEmpty() {
        return (chars[0] == null);
    }

    @Override
    public String GetCode(char character) {
        // TODO: 
        return "00000";
    }

    @Override
    public HuffmanNode Pop() {
        // for (HuffmanNode n : chars) {
        //     if (n == null) {
        //         System.out.print("_");
        //         continue;
        //     }
        //     System.out.print(n.character);
        // }
        // System.out.println();
        // System.out.println("=====================");

        if (IsEmpty()) {
            throw new IllegalStateException("El heap está vacio");
        }
    
        HuffmanNode root = chars[0];
    
        chars[0] = chars[size - 1];
        chars[size - 1] = null;
        size--;
    
        heapify(0);
    
        return root;
    }
    
    private void heapify(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && chars[left].weight < chars[smallest].weight) {
            smallest = left;
        }
        if (right < size && chars[right].weight < chars[smallest].weight) {
            smallest = right;
        }
    
        if (smallest != index) {
            HuffmanNode temp = chars[index];
            chars[index] = chars[smallest];
            chars[smallest] = temp;
            
            heapify(smallest);
        }
    }
}
