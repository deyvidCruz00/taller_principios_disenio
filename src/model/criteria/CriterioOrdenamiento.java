package model.criteria;

import model.Candidato;

public interface CriterioOrdenamiento {
    int comparar(Candidato c1, Candidato c2);
}

