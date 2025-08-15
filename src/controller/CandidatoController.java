package controller;

import model.Candidato;
import model.services.CandidatoService;
import view.CandidatoView;
import view.MenuView;
import java.util.List;

/**
 * Cumple con SRP: Solo coordina entre Model y View
 */
public class CandidatoController {
    private final CandidatoService candidatoService;
    private final CandidatoView candidatoView;
    private final MenuView menuView;

    public CandidatoController() {
        this.candidatoService = new CandidatoService();
        this.candidatoView = new CandidatoView();
        this.menuView = new MenuView();
    }

    public void iniciar() {
        candidatoView.mostrarEncabezado();

        boolean continuar = true;
        cargarDatosPrueba();
        while (continuar) {
            try {
                int opcion = menuView.mostrarMenuPrincipal();
                continuar = procesarOpcion(opcion);
            } catch (Exception e) {
                candidatoView.mostrarError("Opción inválida: " + e.getMessage());
            }
        }

        candidatoView.mostrarMensaje("\n👋 ¡Gracias por usar el Sistema de Selección!");
    }

    private boolean procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                capturarCandidatos();
                return true;
            case 2:
                mostrarTablaCandidatos();
                return true;
            case 3:
                return false;
            default:
                candidatoView.mostrarError("Opción no válida");
                return true;
        }
    }

    private void capturarCandidatos() {
        try {
            int numCandidatos = candidatoView.solicitarNumeroCandidatos();

            for (int i = 1; i <= numCandidatos; i++) {
                Candidato candidato = candidatoView.capturarDatosCandidato(i);
                candidatoService.agregarCandidato(candidato);
                candidatoView.mostrarExito("Candidato "+candidato.getNombre()+ " registrado");
            }
        } catch (Exception e) {
            candidatoView.mostrarError("Error al capturar candidatos: " + e.getMessage());
        }
    }

    private void cargarDatosPrueba() {
        candidatoService.cargarDatosPrueba();
        candidatoView.mostrarExito("Datos de prueba cargados exitosamente");
    }

    private void mostrarTablaCandidatos() {
        List<Candidato> candidatos = candidatoService.obtenerCandidatosOrdenados();
        if (candidatos.isEmpty()) {
            candidatoView.mostrarMensaje("No hay candidatos registrados");
        } else {
            candidatoView.mostrarTablaCandidatos(candidatos);
        }
    }

}