package app.nodes;

public class NodoImpresion extends NodoSentencia {
    private final String impresion;

    public NodoImpresion(String impresion) {
        super("WRITE");
        this.impresion = impresion;
    }

    @Override
    public String getDescripcionNodo() {
        return "WRITE: " + impresion;
    }
}
