package app.nodes;


public class NodoMenor extends NodoComparacion {
        
        public NodoMenor (NodoExpresion izquierda, NodoExpresion derecha) {
        super("<", izquierda, derecha);
    }
}
