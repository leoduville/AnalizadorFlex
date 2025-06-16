package app.nodes;

  
public class NodoNot extends NodoExpresionBooleana {
private final NodoExpresionBooleana izquierda;



public NodoNot (NodoExpresionBooleana izquierda) {
        super("NOT");
        this.izquierda = izquierda;
        
      
    }

@Override
    protected String graficar(String idPadre) {
        final String miId = this.getIdNodo();
        return super.graficar(idPadre) +
                izquierda.graficar(miId) ;
    }

@Override
public String generarSaltoSiFalso(String etiqueta) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'generarSaltoSiFalso'");
}
    

}

