

import controller.CandidatoController;

/**
 * Clase principal del sistema
 * Punto de entrada de la aplicación
 */
public class SistemaSeleccionCandidatos {
    public static void main(String[] args) {
        CandidatoController controller = new CandidatoController();
        controller.iniciar();
    }
}