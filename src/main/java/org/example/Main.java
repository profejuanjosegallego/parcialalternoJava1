package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Clase principal
public class Main {

    // Clase interna para representar una prenda
    static class Prenda {
        String nombre;
        String talla;
        int precio;

        Prenda(String nombre, String talla, int precio) {
            this.nombre = nombre;
            this.talla = talla;
            this.precio = precio;
        }
    }

    

    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption = null;

        // Colores para consola
        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";

        // Login simple
        System.out.println("===== LOGIN =====");
        System.out.print("Nombre de usuario: ");
        String usuario = keyEntry.nextLine();

        System.out.print("Correo: ");
        String correo = keyEntry.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = keyEntry.nextLine();

        if (usuario.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            System.out.println(RED + "⚠️  Todos los campos son obligatorios." + RESET);
            return;
        }

        System.out.println(GREEN + "✅ Bienvenido, " + usuario + "!" + RESET);
        System.out.println();

        // Lista para guardar prendas
        ArrayList<Prenda> inventario = new ArrayList<>();

        // Bucle del menú
        do {
            try {
                System.out.println("👕 Bienvenido al gestor de prendas...\n¿Qué quieres realizar?\n");
                System.out.println(GREEN + "1) Guardar una prenda en BD 📝" + RESET);
                System.out.println(YELLOW + "2) Mostrar el inventario de prendas 📦" + RESET);
                System.out.println(RED + "3) SALIR ❌" + RESET);
                System.out.print("\nDigita una opción: ");

                menuOption = keyEntry.nextInt();
                keyEntry.nextLine(); // limpiar buffer

                if (menuOption == 1) {
                    // Agregar prenda
                    System.out.print("Nombre de la prenda: ");
                    String nombre = keyEntry.nextLine();

                    System.out.print("Talla (S/M/L/XL): ");
                    String talla = keyEntry.nextLine();

                    System.out.print("Precio (entero): ");
                    int precio = Integer.parseInt(keyEntry.nextLine().trim());

                    inventario.add(new Prenda(nombre, talla, precio));
                    System.out.println(GREEN + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio + RESET);

                } else if (menuOption == 2) {
                    // Mostrar inventario
                    if (inventario.isEmpty()) {
                        System.out.println(YELLOW + "📋 Inventario vacío. No hay prendas registradas." + RESET);
                    } else {
                        System.out.println(YELLOW + "📋 Inventario actual:" + RESET);
                        for (Prenda p : inventario) {
                            System.out.println("- " + p.nombre + " | " + p.talla + " | $" + p.precio);
                        }
                    }

                } else if (menuOption == 3) {
                    System.out.println(RED + "👋 Cerrando programa... ¡Hasta pronto!" + RESET);
                    break;

                } else {
                    System.out.println(RED + "❌ Opción no válida. Ingresa un número del 1 al 3." + RESET);
                }

                // Esperar ENTER antes de continuar
                if (menuOption != 3) {
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
                }

            } catch (InputMismatchException ex) {
                System.out.println(RED + "⚠️ Entrada inválida. Debes digitar un número (1-3)." + RESET);
                keyEntry.nextLine(); // limpiar entrada incorrecta
                menuOption = -1;

                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();

            } catch (NumberFormatException e) {
                System.out.println(RED + "⚠️ Precio inválido. Debe ser un número entero." + RESET);
            } catch (Exception ex) {
                System.out.println(RED + "Ups, algo salió mal: " + ex.getMessage() + RESET);
            }

        } while (menuOption == null || menuOption != 3);

        keyEntry.close();
    }
}
