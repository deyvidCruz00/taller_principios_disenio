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
        System.out.println("2 Mostrar tabla de candidatos");
        System.out.println("3 Salir");
        
        System.out.print("\nSeleccione una opción (1-3): ");
        return scanner.nextInt();
    }
}