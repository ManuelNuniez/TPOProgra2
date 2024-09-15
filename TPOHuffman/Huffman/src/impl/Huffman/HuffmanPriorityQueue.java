package impl.Huffman;

import api.Huffman.HuffmanHeap;

public class HuffmanPriorityQueue implements HuffmanHeap {
    public class HuffmanNode {
		HuffmanNode left;
		HuffmanNode right;

        char caracter;
        double peso;

        HuffmanNode(char caracter, double peso) {
            this.caracter = caracter;
            this.peso = peso;
        }

        public char getCharacter() {
            return this.caracter;
        }     

        public double getWeight() {
            return this.peso;
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

    @Override
    public void AddValue(char character, double peso) {
        resizeVector();
        
        chars[size] = new HuffmanNode(character, peso);
        size++;

        int newPos = size-1;
        int padrePos = (newPos - 1)/2;

        while (chars[padrePos].peso > chars[newPos].peso) {
            HuffmanNode aux = chars[padrePos];
            chars[padrePos] = chars[newPos];
            chars[newPos] = aux;

            newPos = padrePos;
            padrePos = (newPos - 1)/2;
        }
    }

    public void SubtractH() {
        size--;
        chars[0] = chars[size];

        int father=0;
        int rightSon= 2;
        int leftSon= 1;

        while (chars[father].peso > chars[leftSon].peso || chars[father].peso > chars[rightSon].peso) {
            if (chars[leftSon].peso > chars[rightSon].peso) {
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


