package view;

import model.Candidato;
import java.util.List;
import java.util.Scanner;

/**
 * Vista principal del sistema
 * Cumple con SRP: Solo maneja la presentación de datos
 */
public class CandidatoView {
    private final Scanner scanner;

    public CandidatoView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarEncabezado() {
        System.out.println("UNIVERSIDAD PEDAGÓGICA Y TECNOLÓGICA DE COLOMBIA");
        System.out.println("FACULTAD DE INGENIERÍA - ESCUELA DE INGENIERÍA DE SISTEMAS");
        System.out.println("SISTEMA DE SELECCIÓN DE CANDIDATOS 2025-1");
        System.out.println("=" .repeat(70));
    }

    public void mostrarTablaCandidatos(List<Candidato> candidatos) {
        System.out.println("=== 📊 TABLA DE CANDIDATOS ORDENADOS ===");


        System.out.println("\n📋 Criterios de selección aplicados:");
        System.out.println("   1.  Etnia minoritaria (máxima prioridad)");
        System.out.println("   2. Resultado global ICFES (orden descendente)");
        System.out.println("   3. Resultado en matemáticas (criterio de desempate)");
        System.out.println("   4. Resultado en inglés (segundo criterio de desempate)");
        System.out.println();

        System.out.printf("%-5s %-20s %-20s %-6s %-15s%n",
                         "Pos.", "Nombre", "Apellidos", "ICFES", "Etnia Minoritaria");
        System.out.println("─".repeat(75));

        int posicion = 1;
        for (Candidato candidato : candidatos) {
            System.out.printf("%-5d %s%n", posicion++, candidato.toString());
        }
        System.out.println("─".repeat(75));
    }

    public void mostrarEstadisticas(int total, int etnias, double promedio) {
        System.out.println("Total de candidatos: " + total);
        System.out.println("Candidatos de etnias minoritarias: {etnias}" + etnias);
        System.out.println("Promedio resultado ICFES: {promedio:.1f}" + promedio);
    }

    public Candidato capturarDatosCandidato(int numero) {
        System.out.println("\n--- 👤 Candidato "+ numero + " ---");
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine().trim();

        System.out.print("Etnia: ");
        String etnia = scanner.nextLine().trim();

        System.out.print("Resultado global ICFES (0-500): ");
        int resultadoICFES = scanner.nextInt();

        System.out.print("Resultado en matemáticas (0-100): ");
        int resultadoMat = scanner.nextInt();

        System.out.print("Resultado en inglés (0-100): ");
        int resultadoIng = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        return new Candidato(nombre, apellidos, etnia, resultadoICFES,
                           java.time.LocalDate.now(), resultadoMat, resultadoIng);
    }

    public int solicitarNumeroCandidatos() {
        System.out.print("¿Cuántos candidatos desea ingresar? ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String error) {
        System.err.println("Error: " + error);
    }

    public void mostrarExito(String mensaje) {
        System.out.println(mensaje);
    }
}