package app.nodes;

public class NodoResta extends NodoExpresionBinaria {

    public NodoResta(NodoExpresion izquierda, NodoExpresion derecha) {
        super("-", izquierda, derecha);
    }

    @Override
    public String generarAssembler() {
        return izquierda.generarAssembler() + 
               derecha.generarAssembler() +
               "    FSUB\n";
    }
}