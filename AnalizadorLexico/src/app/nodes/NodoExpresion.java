package app.nodes;

public class NodoExpresion extends Nodo {

    public NodoExpresion(String nombre) {
        super(nombre);
    }

    public String getValor() {
        return this.getDescripcionNodo();
    }

    public String generarAssembler() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generarAssembler'");
    }

    public boolean terminaConResultadoEnPila() {
        return true; // comportamiento normal: sí deja algo en la pila
    }
}
