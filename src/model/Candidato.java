package model;

import java.time.LocalDate;
// Principio 1: Single Responsibility Principle (SRP)
// Cada clase tiene una única responsabilidad
public class Candidato {
    private String nombre;
    private String apellidos;
    private String etnia;
    private int resultadoGlobalICFES;
    private LocalDate fechaInscripcion;
    private int resultadoMatematicas;
    private int resultadoIngles;

    public Candidato(String nombre, String apellidos, String etnia,
                     int resultadoGlobalICFES, LocalDate fechaInscripcion,
                     int resultadoMatematicas, int resultadoIngles) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.etnia = etnia;
        this.resultadoGlobalICFES = resultadoGlobalICFES;
        this.fechaInscripcion = fechaInscripcion;
        this.resultadoMatematicas = resultadoMatematicas;
        this.resultadoIngles = resultadoIngles;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getEtnia() { return etnia; }
    public int getResultadoGlobalICFES() { return resultadoGlobalICFES; }
    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public int getResultadoMatematicas() { return resultadoMatematicas; }
    public int getResultadoIngles() { return resultadoIngles; }

    public boolean esEtniaMinoritaria() {
        return etnia.toLowerCase().contains("indígena") ||
                etnia.toLowerCase().contains("minoritaria") ||
                etnia.toLowerCase().contains("afro") ||
                etnia.toLowerCase().contains("raizal");
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20s %5d %15s",
                nombre, apellidos, resultadoGlobalICFES,
                esEtniaMinoritaria() ? "Sí" : "No");
    }
}