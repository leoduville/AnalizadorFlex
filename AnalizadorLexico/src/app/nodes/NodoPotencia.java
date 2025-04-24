package app.nodes;

public class NodoPotencia extends NodoExpresionBinaria {
    
    public NodoPotencia(NodoExpresion izquierda, NodoExpresion derecha) {
        super("^", izquierda, derecha);
    }

}
