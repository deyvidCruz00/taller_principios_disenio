package model.criteria;

import model.Candidato;

public class CriterioIngles implements CriterioOrdenamiento {
    @Override
    public int comparar(Candidato c1, Candidato c2) {
        return Integer.compare(c2.getResultadoIngles(), c1.getResultadoIngles());
    }
}