package app.nodes;

public class NodoIdentificador extends NodoExpresion {
    private final String identificador;

    public NodoIdentificador(String identificador) {
        super("ID");
        this.identificador = identificador;
    }

    @Override
    public String getDescripcionNodo() {
        return identificador;
    }

    @Override
    public String generarAssembler() {
        return "    FLD _" + identificador + "\n";
    }
}
