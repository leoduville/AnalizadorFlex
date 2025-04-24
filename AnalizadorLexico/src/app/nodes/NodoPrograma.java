    package app.nodes;

    import java.util.List;

    public class NodoPrograma extends Nodo {
        private final List<NodoSentencia> sentencias;

        public NodoPrograma(List<NodoSentencia> sentencias) {
            super("PGM");
            this.sentencias = sentencias;
        }

        public String graficar() {
            // Acá se dispara la invocación a los métodos graficar() de los nodos.
            // Como un NodoPrograma no tiene padre, se inicia pasando null.
            return this.graficar(null);
        }

        @Override
        protected String graficar(String idPadre) {
            final String miId = "nodo_programa";

            StringBuilder resultado = new StringBuilder();
            resultado.append("graph G {\n");
            resultado.append("  rankdir=TB;\n"); // Dirección de arriba hacia abajo
            resultado.append("  node [shape=ellipse, fontsize=10];\n");
            resultado.append("  edge [arrowhead=vee];\n\n");

            resultado.append(miId + " [label=\"Programa\"]\n");
            for (int i = 0; i < sentencias.size(); i++) {
                NodoSentencia sentencia = sentencias.get(i);
                
                // Agrupamos IFs y sus hijos con un subgraph si es necesario
                if (sentencia instanceof NodoIf) {
                    resultado.append("  subgraph cluster_if" + i + " {\n");
                    resultado.append("    label=\"IF Block\";\n");
                    resultado.append("    style=dashed;\n");
                    resultado.append(sentencia.graficar(miId));
                    resultado.append("  }\n");
                } else {
                    resultado.append(sentencia.graficar(miId));
                }
            }
            
            resultado.append("}");

            return resultado.toString();
        }
    }
        

