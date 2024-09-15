package impl.Huffman;

import api.Huffman.HuffmanHeap;

public class HuffmanPriorityQueue implements HuffmanHeap {
    public static class HuffmanNode {
		HuffmanNode left;
		HuffmanNode right;

        char character;
        double weight;

        HuffmanNode(char character, double weight) {
            this.character = character;
            this.weight = weight;
        }

        HuffmanNode(double peso) {
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
    int capacity = 127;
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

    public void SubtractH() {
        size--;
        chars[0] = chars[size];

        int father=0;
        int rightSon= 2;
        int leftSon= 1;

        while (chars[father].weight > chars[leftSon].weight || chars[father].weight > chars[rightSon].weight) {
            if (chars[leftSon].weight > chars[rightSon].weight) {
                HuffmanNode aux = chars[father];
                chars[father] = chars[leftSon];
                chars[leftSon] = aux;

                father = leftSon;
                leftSon = 2*father +1;
                rightSon = 2*father +2;

            } else {
                HuffmanNode aux = chars[father];
                chars[father] = chars[rightSon];
                chars[rightSon] = aux;
                
                father = rightSon;
                leftSon = 2*father + 1;
                rightSon = 2*father + 2;
            }
        }
    }
    
    @Override
    public boolean IsEmpty() {
        return (size == 0);
    }

    @Override
    public String GetCode(char character) {
        // TODO: 
        return "00000";
    }

    @Override
    public HuffmanNode Pop() {
        // TODO:
        HuffmanNode aux = new HuffmanNode('a', 3);         
        return aux;
    }
}


