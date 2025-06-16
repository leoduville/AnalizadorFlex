package app.nodes;

public class EtiquetaUtil {
    private static int contador = 0;
    private static String etiqueta;

    public static String nuevaEtiqueta() {
        etiqueta = "Etiq" + contador++;
        return etiqueta;
    }

    public static String getEtiqueta() {
        // TODO Auto-generated method stub
        return etiqueta;
    }
}

