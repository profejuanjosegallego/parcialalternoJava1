package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption = null;
        String greenColor = "\u001B[32m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        ArrayList<String> inventario = new ArrayList<>();

        // Implementa lógica para login con:
        // -nombre usuario
        // -correo
        // -contraseña
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = keyEntry.nextLine();
        System.out.print("Correo: ");
        String correo = keyEntry.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = keyEntry.nextLine();

        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");

        do {
            try {
                System.out.println("👕 Bienvenido a gestor de prendas...\n¿Qué quieres realizar?\n");
                System.out.println(greenColor + "1) Guardar una prenda en BD 📝");
                System.out.println("2) Mostrar el inventario de prendas 📦");
                System.out.println("3) SALIR ❌\n");

                System.out.print("Digita una opción: ");
                menuOption = keyEntry.nextInt();
                keyEntry.nextLine();

                if (menuOption == 1) {
                    try {
                        System.out.print("Nombre de la prenda: ");
                        String nombre = keyEntry.nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = keyEntry.nextLine();

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(keyEntry.nextLine().trim());
                        String prenda = nombre + " | " + talla + " | $" + precio;
                        inventario.add(prenda);
                        System.out.println(greenColor + "✅ Prenda guardada: " + prenda);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "Precio inválido. Debe ser un número entero.");
                    }
                } else if (menuOption == 2) {
                    // Implementar algoritmo para recorrer y mostrar la lista en el formato pedido
                    System.out.println(YELLOW + "📋 Inventario:");
                    if (inventario.isEmpty()) {
                        System.out.println("No hay prendas en el inventario.");
                    } else {
                        for (String prenda : inventario) {
                            System.out.println("- " + prenda);
                        }
                    }
                } else if (menuOption == 3) {
                    // Implementar algoritmo para cerrar el programa
                    menuOption = 3;
                } else {
                    System.out.println(RED + "Opción no válida. Prueba con un número del 1 al 3.");
                }

                if (menuOption != null && menuOption != 3) {
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
                }

            } catch (InputMismatchException ex) {
                System.out.println(RED + "Entrada inválida. Debes digitar un número (1-3).");
                keyEntry.nextLine();
                menuOption = -1;
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            } catch (Exception ex) {
                // Cualquier otra excepción no prevista
                System.out.println(RED + "Ups, algo salió mal: " + ex.getMessage());
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            }

        } while (menuOption == null || menuOption != 3);
    }
}
