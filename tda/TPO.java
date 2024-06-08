
import api.*;
import impl.*;

public class TPO {
    private void CargarDatos() {
        
    }

    public static void main(String[] args) {
        DiccionarioSimpleStrTDA d = new DiccionarioSimpleStr();

        d.Agregar(0, "hola");
        d.Agregar(1, "chau");

        System.out.println(d.Recuperar(0));
        System.out.println(d.Recuperar(1));
    }
}
