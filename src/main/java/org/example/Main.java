package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption = null;

        do {
            try {
                System.out.println("\n******************");
                System.out.println("*****  APP  *****");
                System.out.println("******************");

                System.out.println("Bienvenido al gestor de prendas");
                System.out.println("Seleccione una opción:\n");
                System.out.println("1) Guardar una prenda");
                System.out.println("2) Mostrar inventario");
                System.out.println("3) Salir\n");

                System.out.print("Digite una opción: ");
                menuOption = keyEntry.nextInt();
                keyEntry.nextLine(); // Limpiar buffer

                if (menuOption == 1) {
                    try {
                        System.out.print("Nombre de la prenda: ");
                        String nombre = keyEntry.nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = keyEntry.nextLine();

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(keyEntry.nextLine().trim());

                        System.out.println("Prenda guardada: "
                                + nombre + " - " + talla + " - $" + precio);

                    } catch (NumberFormatException e) {
                        System.out.println("Error: el precio debe ser un número entero.");
                    }

                } else if (menuOption == 2) {

                    System.out.println("Inventario (demo):");
                    System.out.println("- Camiseta | M | $45000");
                    System.out.println("- Jean     | L | $120000");

                } else if (menuOption == 3) {
                    System.out.println("Saliendo del sistema...");

                } else {
                    System.out.println("Opción no válida. Debe ser un número entre 1 y 3.");
                }

                if (menuOption != 3) {
                    System.out.print("\nPresione ENTER para continuar...");
                    keyEntry.nextLine();
                }

            } catch (InputMismatchException ex) {
                System.out.println("Error: Debe digitar un número (1-3).");
                keyEntry.nextLine();
                menuOption = -1;

                System.out.print("\nPresione ENTER para continuar...");
                keyEntry.nextLine();

            } catch (Exception ex) {
                System.out.println("Ocurrió un error: " + ex.getMessage());
                System.out.print("\nPresione ENTER para continuar...");
                keyEntry.nextLine();
            }

        } while (menuOption != 3);

        keyEntry.close();
    }
}