package app.nodes;


public class NodoMayor extends NodoComparacion {
    
    private NodoExpresion izquierda;
    private NodoExpresion derecha;

    public NodoMayor (NodoExpresion izquierda, NodoExpresion derecha) {
        super(">", izquierda, derecha);
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    @Override
    public String generarAssembler() {
        StringBuilder sb = new StringBuilder();
        sb.append("    FLD ").append("_" + izquierda.getValor()).append("\n");
        sb.append("    FLD ").append("_" + derecha.getValor()).append("\n");
        sb.append("    FXCH\n");
        sb.append("    FCOM\n");
        sb.append("    FSTSW AX\n");
        sb.append("    SAHF\n");
        sb.append("    FSTP ST(0)\n");  // limpia uno de los valores
        return sb.toString();
    }

    @Override
    public String generarSaltoSiFalso(String etiqueta) {
        return "    JNA " + etiqueta + "\n";  // si no es mayor
    }

}
