package impl.Huffman;
import api.HuffmanHeapTDA;


public class HuffmanHeap implements HuffmanHeapTDA {

    int i;
    Symbol[] chars;
    int capacity;

    public HuffmanHeap(){
        capacity = 10;
        chars = new Symbol[capacity];
        i = 0;
    }

    private void VectorReset(){
        Symbol[] aux = new Symbol[capacity *10];
        for (int j = 0; j < chars.length; j++) {
            aux[j] = chars[j];
        }
        chars = aux;
        capacity = capacity *10;
    }

    @Override
    public void AddH(Symbol value) {

        if (capacity == i) {
            VectorReset();
        }
        
        chars[i] = value;
        i++;

        int newPos=i-1;
        int padrePos= (newPos - 1)/2;

        while (chars[padrePos].probability > chars[newPos].probability) {
            Symbol aux = chars[padrePos];
            chars[padrePos] = chars[newPos];
            chars[newPos] = aux;

            newPos=padrePos;
            padrePos=(newPos - 1)/2;
        }
    }

    

    @Override
    public void SubtractH() {
        i--;
        chars[0] = chars[i];

        int father=0;
        int rightSon= 2;
        int leftSon= 1;

        while (chars[father].probability > chars[leftSon].probability || chars[father].probability > chars[rightSon].probability) {
            if (chars[leftSon].probability > chars[rightSon].probability) {
                Symbol aux = chars[father];
                chars[father] = chars[leftSon];
                chars[leftSon] = aux;

                father = leftSon;
                leftSon = 2*father +1;
                rightSon = 2*father +2;

            }else{
                Symbol aux = chars[father];
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
        return (i == 0);
    }

    @Override
    public char GetCode() {
        return chars[0].character;
    }
}


