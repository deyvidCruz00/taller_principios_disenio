package model;

public class CriterioICFES implements CriterioOrdenamiento {
    @Override
    public int comparar(Candidato c1, Candidato c2) {
        return Integer.compare(c2.getResultadoGlobalICFES(), c1.getResultadoGlobalICFES());
    }
}
