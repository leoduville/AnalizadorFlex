package app.nodes;

public class NodoConstante extends NodoExpresion {
    private final int valor;
    private static int contador = 0;
    private final int idUnico;

    public NodoConstante(int valor) {
        super("CTE");
        this.valor = valor;
        this.idUnico = contador++;
    }

    @Override   
    public String getDescripcionNodo() {
        return "CTE: " + Integer.toString(valor);
    }

    @Override
    public String getValor(){
        return String.valueOf(this.valor);
    }

    @Override
    protected String graficar(String idPadre) {
        String miId = "nodo_" + idUnico;

        StringBuilder sb = new StringBuilder();
        sb.append(miId + " [label=\"" + getDescripcionNodo() + "\"]\n");

        if (idPadre != null) {
            sb.append(idPadre + " -- " + miId + "\n");
        }

        return sb.toString();
    }

}
