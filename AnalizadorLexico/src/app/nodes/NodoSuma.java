package app.nodes;

public class NodoSuma extends NodoExpresionBinaria {
    private NodoExpresion izq;
    private NodoExpresion der;

    public NodoSuma(NodoExpresion izquierda, NodoExpresion derecha) {
        super("+", izquierda, derecha);
        this.izq = izquierda;
        this.der = derecha;
    }

    @Override
    public String generarAssembler() {
        return izq.generarAssembler() + "\n" +
            der.generarAssembler() + "\n" +
            "    FADD\n";
    }
}