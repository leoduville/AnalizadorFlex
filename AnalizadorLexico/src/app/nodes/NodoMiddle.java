package app.nodes;

import java.util.List;

public class NodoMiddle extends Nodo{
    
    public NodoExpresion limiteInferior;
    public NodoExpresion limiteSuperior;
    public List<NodoExpresion> lista;

    public NodoMiddle(NodoExpresion limiteInferior, NodoExpresion limiteSuperior, List<NodoExpresion> lista) {
        super("MIDDLE");
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.lista = lista;
    }

    @Override
    protected String graficar(String idPadre) {
        final String miId = "middle_" + getIdNodo();  // Crear un ID único para el nodo
    
        StringBuilder resultado = new StringBuilder();
    
        // Crear el nodo Middle
        resultado.append(miId + " [label=\"Middle\"]\n");
    
        // Agregar relaciones con los elementos de la condición
        resultado.append(idPadre + " -- " + miId + "\n");  // Relación con el nodo padre
    
        // Relación con los límites
        if (limiteInferior != null) {
            resultado.append(miId + " -- " + limiteInferior.graficar(miId) + "\n");
        }
    
        if (limiteSuperior != null) {
            resultado.append(miId + " -- " + limiteSuperior.graficar(miId) + "\n");
        }
    
        // Agregar relaciones con los elementos de la lista (si existen)
        if (lista != null) {
            for (NodoExpresion expr : lista) {
                resultado.append(miId + " -- " + expr.graficar(miId) + "\n");
            }
        }
    
        return resultado.toString();
    }
    

}
