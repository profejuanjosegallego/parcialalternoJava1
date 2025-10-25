package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption = null;



        // Definición de colores ANSI
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String YELLOW = "\u001B[33m";
        final String RESET = "\u001B[0m";

        // ArrayList para almacenar las prendas
        ArrayList<String> inventario = new ArrayList<>();

        // ===== IMPLEMENTACIÓN DEL LOGIN =====
        System.out.println("\n******************");
        System.out.println("***** LOGIN *****");
        System.out.println("******************");

        System.out.print("Nombre de usuario: ");
        String nombreUsuario = keyEntry.nextLine();

        System.out.print("Correo: ");
        String correo = keyEntry.nextLine();

        System.out.print("Contraseña: ");
        String paswer = keyEntry.nextLine();

        System.out.println(GREEN + "✅ Bienvenido, " + nombreUsuario + "!" + RESET);



        do {
            try {
                System.out.println("\n******************");
                System.out.println("***** APP *****");
                System.out.println("******************");
                System.out.println("👕 Bienvenido al gestor de prendas...\n¿Qué quieres realizar?\n");
                System.out.println(GREEN + "1) Guardar una prenda en BD 📝");
                System.out.println("2) Mostrar el inventario de prendas 📦");
                System.out.println("3) SALIR ❌\n" + RESET);

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

                        // Guardar en el inventario
                        String prenda = nombre + " | " + talla + " | $" + precio;
                        inventario.add(prenda);

                        System.out.println(GREEN + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio + RESET);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "❌ Precio inválido. Debe ser un número entero." + RESET);
                    }

                } else if (menuOption == 2) {
                    // ===== IMPLEMENTACIÓN MOSTRAR INVENTARIO =====
                    System.out.println(YELLOW + "📋 Inventario de prendas:" + RESET);

                    if (inventario.isEmpty()) {
                        System.out.println("No hay prendas en el inventario.");
                    } else {
                        for (int i = 0; i < inventario.size(); i++) {
                            System.out.println((i + 1) + ". " + inventario.get(i));
                        }
                    }

                } else if (menuOption == 3) {
                    // ===== IMPLEMENTACIÓN SALIR DEL PROGRAMA =====
                    System.out.println(GREEN + "👋 ¡Gracias por usar la app! Hasta pronto." + RESET);
                    break; // Sale del do-while

                } else {
                    System.out.println(RED + "❌ Opción no válida. Prueba con un número del 1 al 3." + RESET);
                }


                if (menuOption != null && menuOption != 3) {
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
                }

            } catch (InputMismatchException ex) {
                System.out.println(RED + "❌ Entrada inválida. Debes digitar un número (1-3)." + RESET);
                keyEntry.nextLine();
                menuOption = -1;
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            } catch (Exception ex) {
                System.out.println(RED + "❌ Ups, algo salió mal: " + ex.getMessage() + RESET);
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            }

        } while (menuOption == null || menuOption != 3);
        keyEntry.close();
    }
}