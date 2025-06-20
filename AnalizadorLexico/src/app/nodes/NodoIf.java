package app.nodes;

import java.util.List;

public class NodoIf extends NodoSentencia {
    private final NodoExpresionBooleana condicion;
    private final List<NodoSentencia> sentenciasThen;
    private final List<NodoSentencia> sentenciasElse;

    public NodoIf(NodoExpresionBooleana condicion, List<NodoSentencia> sentenciasThen, List<NodoSentencia> sentenciasElse) {
        super("IF");
        this.condicion = condicion;
        this.sentenciasThen = sentenciasThen;
        this.sentenciasElse = sentenciasElse;
    }

    @Override
    protected String graficar(String idPadre) {
        final String miId = this.getIdNodo();
        StringBuilder resultado = new StringBuilder();

        // Grafica el nodo IF
        resultado.append(super.graficar(idPadre));

        // Grafica la condición colgando directamente del nodo IF
        resultado.append(condicion.graficar(miId));

        // Agrega un nodo ficticio THEN colgando del nodo IF
        Nodo nodoThen = new Nodo("Then");
        resultado.append(nodoThen.graficar(miId));

        // Grafica las sentencias asociadas al "then" colgando del nodo ficticio THEN
        String idNodoThen = nodoThen.getIdNodo();
        for (NodoSentencia sentencia: sentenciasThen) {
            resultado.append(sentencia.graficar(idNodoThen));
        }

        // Si hay sentencias asociadas al "else"...
        if (sentenciasElse != null) {
            // Agrega un nodo ficticio "ELSE" colgando del nodo IF
            Nodo nodoElse = new Nodo("Else");
            resultado.append(nodoElse.graficar(miId));

            // Grafica las sentencias asociadas al "else" colgando del nodo ficticio ELSE
            String idNodoElse = nodoElse.getIdNodo();
            for (NodoSentencia sentencia: sentenciasElse) {
                resultado.append(sentencia.graficar(idNodoElse));
            }
        }

        return resultado.toString();
    }

    @Override
    public String generarAssembler() {
        StringBuilder sb = new StringBuilder();

        String etiqFin = EtiquetaUtil.nuevaEtiqueta();
        String etiqElse = sentenciasElse != null ? EtiquetaUtil.nuevaEtiqueta() : null;

        sb.append(condicion.generarAssembler());

        if (condicion instanceof NodoComparacion) {
            if (etiqElse != null)
                sb.append(condicion.generarSaltoSiFalso(etiqElse));
            else {
                sb.append(condicion.generarSaltoSiFalso(etiqFin));
            }
        }

        // El NodoAnd ya genera los saltos internos
        for (NodoSentencia sentencia : sentenciasThen) {
            sb.append(sentencia.generarAssembler());
        }
        
        if (sentenciasElse != null) {
            sb.append("    JMP ").append(etiqFin).append("\n");
            sb.append(etiqElse).append(":\n");

            for (NodoSentencia sentencia : sentenciasElse) {
                sb.append(sentencia.generarAssembler());
            }
        }

        sb.append(etiqFin).append(":\n");

        return sb.toString();
    }

}
