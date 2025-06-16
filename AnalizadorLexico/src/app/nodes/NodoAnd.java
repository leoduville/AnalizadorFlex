package app.nodes;


public class NodoAnd extends NodoExpresionBooleana {
        
    private final NodoExpresionBooleana izquierda;
    private final NodoExpresionBooleana derecha;
    private String etiq;

    public NodoAnd (NodoExpresionBooleana izquierda, NodoExpresionBooleana derecha) {
            super("AND");
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
        this.etiq = EtiquetaUtil.getEtiqueta();

        sb.append(izquierda.generarAssembler());
        sb.append(izquierda.generarSaltoSiFalso(etiq));

        sb.append(derecha.generarAssembler());
        sb.append(derecha.generarSaltoSiFalso(etiq));

        return sb.toString();
    }
    
    @Override
    public String generarSaltoSiFalso(String etiqueta) {
        return "    JMP " + etiqueta + "\n";
    }

}

