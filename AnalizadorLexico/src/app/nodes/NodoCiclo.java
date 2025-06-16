package app.nodes;

import java.util.List;

public class NodoCiclo extends NodoSentencia {
    private final NodoExpresionBooleana condicion;
    private final List<NodoSentencia> cuerpo;
  
    static int contadorEtiquetas = 0;

    public NodoCiclo(NodoExpresionBooleana condicion, List<NodoSentencia> cuerpo) {
        super("WHILE");
        this.condicion = condicion;
        this.cuerpo = cuerpo;
       
    }

    @Override
    protected String graficar(String idPadre) {
        final String miId = this.getIdNodo();
        StringBuilder resultado = new StringBuilder();

        // Grafica el nodo IF
        resultado.append(super.graficar(idPadre));

        // Grafica la condición colgando directamente del nodo CUERPO
        resultado.append(condicion.graficar(miId));

        // Agrega un nodo ficticio CUERPO colgando del nodo WHILE
        Nodo nodoThen = new Nodo("Cuerpo");
        resultado.append(nodoThen.graficar(miId));

        // Grafica las sentencias asociadas al "then" colgando del nodo ficticio THEN
        String idNodoThen = nodoThen.getIdNodo();
        for (NodoSentencia sentencia: cuerpo) {
            resultado.append(sentencia.graficar(idNodoThen));
        }

        /* Si hay sentencias asociadas al "else"...
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
*/
        return resultado.toString();
    }

    @Override
    public String generarAssembler() {
        StringBuilder sb = new StringBuilder();

        String etiqInicio = EtiquetaUtil.nuevaEtiqueta();
        String etiqFin = EtiquetaUtil.nuevaEtiqueta();

        sb.append(etiqInicio).append(":\n");
        sb.append(condicion.generarAssembler()); // Esto debe generar el FXCH, FCOM, etc.
        //sb.append("    JNA ").append(etiqFin).append("\n");
        sb.append(condicion.generarSaltoSiFalso(etiqFin));

        for (NodoSentencia sentencia : cuerpo) {
            sb.append(sentencia.generarAssembler());
        }

        sb.append("    JMP ").append(etiqInicio).append("\n");
        sb.append(etiqFin).append(":\n");

        return sb.toString();
    }
    
}


