package app.nodes;


public class NodoOr extends NodoExpresionBooleana {
private final NodoExpresionBooleana izquierda;
private final NodoExpresionBooleana derecha;

    public NodoOr (NodoExpresionBooleana izquierda, NodoExpresionBooleana derecha) {
        super("OR");
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
        return izquierda.generarAssembler() + derecha.generarAssembler();
    }

    @Override
    public String generarSaltoSiFalso(String etiqueta) {
        String labelTrue = "Etiq" + NodoCiclo.contadorEtiquetas++;
        return izquierda.generarSaltoSiFalso(labelTrue) + // si izq es falsa, evalúa der
               derecha.generarSaltoSiFalso(etiqueta) +  // si der también es falsa, salta
               labelTrue + ":\n";
    }

}

