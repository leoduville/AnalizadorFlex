package app.nodes;

import java.util.ArrayList;
import java.util.List;

public class NodoMiddle extends NodoExpresion {

    private final List<NodoIf> ifs = new ArrayList<>();
    private final NodoExpresion limInf, limSup;
    private final List<NodoExpresion> valores;

    public NodoMiddle(NodoExpresion limInf,
                      NodoExpresion limSup,
                      List<NodoExpresion> valores) {
        super("MIDDLE");
        this.limInf   = limInf;
        this.limSup   = limSup;
        this.valores  = valores;
        construirIfs();
    }

    public void addIf(NodoIf ifNode) {
        ifs.add(ifNode);
    }

    private void construirIfs() {

        if (!(limInf instanceof NodoConstante) || !(limSup instanceof NodoConstante)) {
            System.err.println("Error: Los límites del MIDDLE deben ser constantes.");
            return;
        }

        for (NodoExpresion v : valores) {
            // cada constante la duplicamos para no reciclarla
            NodoConstante c1 = new NodoConstante(Integer.parseInt(v.getValor()));
            NodoConstante c2 = new NodoConstante(Integer.parseInt(v.getValor()));
            NodoConstante c3 = new NodoConstante(Integer.parseInt(v.getValor()));

            NodoConstante lInf = new NodoConstante(Integer.parseInt(limInf.getValor()));
            NodoConstante lSup = new NodoConstante(Integer.parseInt(limSup.getValor()));

            NodoExpresionBooleana gt = new NodoMayor(c1, lInf);
            NodoExpresionBooleana lt = new NodoMenor(c2, lSup);
            NodoExpresionBooleana cond = new NodoAnd(gt, lt);

            NodoIdentificador res     = new NodoIdentificador("resultado");
            NodoIdentificador res2     = new NodoIdentificador("resultado");

            NodoExpresion suma         = new NodoSuma(res, c3);
            NodoAsignacion asignacion  = new NodoAsignacion(res2, suma);

            this.addIf(new NodoIf(cond, List.of(asignacion), null));
        }
    }

    @Override
    protected String graficar(String idPadre) {
        final String miId = getIdNodo();
        StringBuilder resultado = new StringBuilder();

        // Nodo MIDDLE principal
        resultado.append(super.graficar(idPadre));

        // Graficar cada if como hijo del nodo middle
        for (NodoIf nodoIf : ifs) {
            resultado.append(nodoIf.graficar(miId));
        }

        return resultado.toString();
    }
}
