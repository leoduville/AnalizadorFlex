package app.nodes;


public class NodoMayor extends NodoComparacion {
        
        public NodoMayor (NodoExpresion izquierda, NodoExpresion derecha) {
        super(">", izquierda, derecha);
    }
}
