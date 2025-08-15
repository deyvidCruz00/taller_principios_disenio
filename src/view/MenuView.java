package view;

import java.util.Scanner;

/**
 * Vista del menú principal
 */
public class MenuView {
    private final Scanner scanner;
    
    public MenuView() {
        this.scanner = new Scanner(System.in);
    }
    
    public int mostrarMenuPrincipal() {
        System.out.println("\nMENÚ PRINCIPAL");
        System.out.println("1️ Ingresar candidatos manualmente");
        System.out.println("2️ Usar datos de prueba");
        System.out.println("3️ Mostrar tabla de candidatos");
        System.out.println("4 Ver estadísticas");
        System.out.println("5 Ver principios de diseño aplicados");
        System.out.println("6️ Salir");
        
        System.out.print("\nSeleccione una opción (1-6): ");
        return scanner.nextInt();
    }
}