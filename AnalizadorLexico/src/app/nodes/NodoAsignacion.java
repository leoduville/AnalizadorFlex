package app.nodes;

public class NodoAsignacion extends NodoSentencia {
    private final NodoIdentificador identificador;
    private final NodoExpresion expresion;

    public NodoAsignacion(NodoIdentificador identificador, NodoExpresion expresion) {
        super(":=");
        this.identificador = identificador;
        this.expresion = expresion;
    }

    @Override
    protected String graficar(String idPadre) {
        final String miId = this.getIdNodo();
        return super.graficar(idPadre) +
                identificador.graficar(miId) +
                expresion.graficar(miId);
    }

    @Override
    public String generarAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append(expresion.generarAssembler());
        
        // Solo hace FSTP si queda el resultado en la pila
        if (expresion.terminaConResultadoEnPila()) {
            sb.append("    FSTP _").append(identificador.getDescripcionNodo()).append("\n");
        }

        return sb.toString();
    }
}
