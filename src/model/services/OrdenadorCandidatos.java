package model.services;

import model.Candidato;
import model.criteria.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Servicio para ordenamiento de candidatos
 * Cumple con DIP: Depende de abstracciones, no de implementaciones concretas
 */
public class OrdenadorCandidatos {
    private final List<CriterioOrdenamiento> criterios;

    public OrdenadorCandidatos() {
        this.criterios = Arrays.asList(
                new CriterioEtniaMinoritaria(),
                new CriterioICFES(),
                new CriterioMatematicas(),
                new CriterioIngles()
        );
    }

    public List<Candidato> ordenar(List<Candidato> candidatos) {
        return candidatos.stream()
                .sorted(this::compararCandidatos)
                .collect(Collectors.toList());
    }

    private int compararCandidatos(Candidato c1, Candidato c2) {
        for (CriterioOrdenamiento criterio : criterios) {
            int resultado = criterio.comparar(c1, c2);
            if (resultado != 0) {
                return resultado;
            }
        }
        return 0;
    }
}
