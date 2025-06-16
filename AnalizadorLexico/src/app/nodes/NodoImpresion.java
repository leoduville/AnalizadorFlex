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

    private String etiquetaNormalizada() {
        return "_" + impresion.replace("'", "").replaceAll("\\s+", "_");
    }

    public String generarAssembler() {
        return
            "    mov dx, OFFSET " + etiquetaNormalizada() + "\n" +
            "    mov ah, 9\n" +
            "    int 21h\n";
    }

    public String generarDefinicionString() {
        return etiquetaNormalizada() + " db \"" + impresion + "$\"\n";
    }

}
