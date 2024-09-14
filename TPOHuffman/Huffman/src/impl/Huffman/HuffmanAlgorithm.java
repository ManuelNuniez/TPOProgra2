package impl.Huffman;
import api.ArbolBBTDA;
import api.HuffmanHeap;

public class HuffmanAlgorithm {

    HuffmanHeap inputQueue;
    ArbolBBTDA outputTree;

    // Constructor
    public HuffmanAlgorithm(Symbol[] alphabet){
        for (Symbol symbol : alphabet) {
            inputQueue.AddValue(symbol);
        }
        
        for(int i = 1; i < alphabet.length; i++){
            Symbol x = inputQueue.ExtractValue();
            Symbol y = inputQueue.ExtractValue();
            outputTree.AgregarElem(x.probability + y.probability);
            outputTree.AgregarElem(x.probability);
            outputTree.AgregarElem(y.probability);
        }
    }

    // public void ImprimirArbol()

    public String GetCode(char character){
        // Necesito recorrer el heap y devolver en codigo binario, va a recorrer InOrder
        // Una forma de obtener los hijos del heap
        
        

        String code = "00";

        return code;
    }
}
