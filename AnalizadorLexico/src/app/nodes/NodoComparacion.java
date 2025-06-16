package app.nodes;


public class NodoComparacion extends NodoExpresionBooleana {
private final NodoExpresion  izquierda;
private final NodoExpresion  derecha;

    public NodoComparacion (String nombre,NodoExpresion izquierda, NodoExpresion derecha) {
        super(nombre);
        this.izquierda = izquierda;
        this.derecha = derecha;

    }
    
    @Override
    protected String graficar(String idPadre) {
        final String miId = this.getIdNodo();
        return super.graficar(idPadre) +
                izquierda.graficar(miId) +
                derecha.graficar(miId);
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
        String salto;

        switch (this.getDescripcionNodo().toLowerCase()) {
            case "<":  salto = "JNB"; break; // si no es menor, salta
            case "<=": salto = "JA"; break;
            case ">":  salto = "JNA"; break;
            case ">=": salto = "JB"; break;
            case "==": salto = "JNE"; break;
            case "!=": salto = "JE"; break;
            default:   salto = "JMP"; // fallback
        }

        return "    " + salto + " " + etiqueta + "\n";
    }



}
