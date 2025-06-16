package app.nodes;

public abstract class NodoExpresionBooleana extends NodoExpresion {
     
     public NodoExpresionBooleana(String nombre) {
        super(nombre);
    }
      
    // Método que toda expresión booleana debe implementar
    public abstract String generarSaltoSiFalso(String etiqueta);

}

    
    
    
