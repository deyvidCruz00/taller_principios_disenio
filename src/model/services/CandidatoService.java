package model.services;

import model.Candidato;
import java.time.LocalDate;
import java.util.*;

/**
 * Servicio que maneja la lógica de negocio de candidatos
 * Cumple con SRP: Solo maneja operaciones CRUD y validaciones
 */
public class CandidatoService {
    private final List<Candidato> candidatos;
    private final OrdenadorCandidatos ordenador;

    public CandidatoService() {
        this.candidatos = new ArrayList<>();
        this.ordenador = new OrdenadorCandidatos();
    }

    public void agregarCandidato(Candidato candidato) {
        if (validarCandidato(candidato)) {
            candidatos.add(candidato);
        } else {
            throw new IllegalArgumentException("Candidato inválido");
        }
    }

    public List<Candidato> obtenerCandidatosOrdenados() {
        return ordenador.ordenar(new ArrayList<>(candidatos));
    }

    public List<Candidato> obtenerTodosCandidatos() {
        return new ArrayList<>(candidatos);
    }

    public int contarCandidatos() {
        return candidatos.size();
    }

    public int contarEtniasMinoritarias() {
        return (int) candidatos.stream()
                .filter(Candidato::esEtniaMinoritaria)
                .count();
    }

    public double obtenerPromedioICFES() {
        return candidatos.stream()
                .mapToInt(Candidato::getResultadoGlobalICFES)
                .average()
                .orElse(0.0);
    }

    public void cargarDatosPrueba() {
        candidatos.clear();
        candidatos.addAll(Arrays.asList(
                new Candidato("Juan Carlos", "Pérez García", "Mestizo",
                        450, LocalDate.of(2024, 8, 15), 85, 75),
                new Candidato("María Elena", "González López", "Indígena",
                        400, LocalDate.of(2024, 8, 10), 80, 70),
                new Candidato("Carlos Andrés", "Rodríguez Silva", "Afrodescendiente",
                        450, LocalDate.of(2024, 8, 20), 85, 80),
                new Candidato("Ana Sofía", "Martínez Torres", "Mestizo",
                        480, LocalDate.of(2024, 8, 25), 90, 85),
                new Candidato("Luis Fernando", "Herrera Vásquez", "Mestizo",
                        450, LocalDate.of(2024, 8, 12), 88, 75),
                new Candidato("Sofía Isabel", "Jiménez Ruiz", "Raizal",
                        420, LocalDate.of(2024, 8, 18), 82, 78)
        ));
    }

    private boolean validarCandidato(Candidato candidato) {
        return candidato != null &&
                candidato.getNombre() != null && !candidato.getNombre().trim().isEmpty() &&
                candidato.getApellidos() != null && !candidato.getApellidos().trim().isEmpty() &&
                candidato.getResultadoGlobalICFES() >= 0 && candidato.getResultadoGlobalICFES() <= 500 &&
                candidato.getResultadoMatematicas() >= 0 && candidato.getResultadoMatematicas() <= 100 &&
                candidato.getResultadoIngles() >= 0 && candidato.getResultadoIngles() <= 100;
    }
}