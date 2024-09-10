package impl.Huffman;

import api.ArbolBBTDA;

public class HuffmanAlgoritm {

    PriorityQueueTDA huffmanQueue;
    ArbolBBTDA huffmanTree;

    //Constructor
    public HuffmanAlgoritm(Symbol[] alphabet){
        for (Symbol symbol : alphabet) {
            huffmanQueue.AddValue(symbol);
        }
        
        for(int i = 1; i< alphabet.length; i++){
            Symbol x = huffmanQueue.ExtractValue();
            Symbol y = huffmanQueue.ExtractValue();
            huffmanTree.AgregarElem(x.probabilty + y.probabilty);
            huffmanTree.AgregarElem(x.probabilty);
            huffmanTree.AgregarElem(y.probabilty);
        }
    }

    public String GetCode(char character){
        //necesito recorrer el heap y devolver en codigo binario
        //Una forma de obtener los hijos del heap

        String code = "00";

        return code;
    }



}
