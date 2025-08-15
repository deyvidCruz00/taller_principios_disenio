package model.criteria;

import model.Candidato;

public class CriterioMatematicas implements CriterioOrdenamiento {
    @Override
    public int comparar(Candidato c1, Candidato c2) {
        return Integer.compare(c2.getResultadoMatematicas(), c1.getResultadoMatematicas());
    }
}
