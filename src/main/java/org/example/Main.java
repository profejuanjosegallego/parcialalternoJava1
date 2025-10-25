package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Integer menuOption = null;
        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";

        Scanner keyEntry = new Scanner(System.in);

        // Datos de login almacenados
        String usuarioAlmacenado = "jose24";
        String correoAlmacenado = "jose@gmail.com";
        String contraseñaAlmacenada = "123";

        // Login
        System.out.println("Digite su usuario ☠️");
        String usuarioDigitado = keyEntry.nextLine();

        System.out.println("Digite su correo 😎");
        String correoDigitado = keyEntry.nextLine();

        System.out.println("Digite la contraseña 🫡");
        String contraseñaDigitada = keyEntry.nextLine();

        if (!usuarioDigitado.equals(usuarioAlmacenado) ||
                !correoDigitado.equals(correoAlmacenado) ||
                !contraseñaDigitada.equals(contraseñaAlmacenada)) {
            System.out.println(RED + "❌ Credenciales incorrectas. Acceso denegado.");
            return;
        }

        // Listas para almacenar prendas
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> tallas = new ArrayList<>();
        ArrayList<Integer> precios = new ArrayList<>();

        do {
            try {
                System.out.println("\n👕 Bienvenido al gestor de prendas...\n¿Qué quieres realizar?\n");
                System.out.println(GREEN + "1) Guardar una prenda en BD 📝");
                System.out.println("2) Mostrar el inventario de prendas 📦");
                System.out.println("3) SALIR ❌\n");

                System.out.print("Digita una opción: ");
                menuOption = keyEntry.nextInt();
                keyEntry.nextLine(); // limpiar buffer

                if (menuOption == 1) {
                    try {
                        System.out.print("Nombre de la prenda: ");
                        String nombre = keyEntry.nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = keyEntry.nextLine();

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(keyEntry.nextLine().trim());

                        nombres.add(nombre);
                        tallas.add(talla);
                        precios.add(precio);

                        System.out.println(GREEN + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "❌ Precio inválido. Debe ser un número entero.");
                    }
                } else if (menuOption == 2) {
                    System.out.println(YELLOW + "📋 Inventario:");
                    if (nombres.isEmpty()) {
                        System.out.println("No hay prendas registradas.");
                    } else {
                        for (int i = 0; i < nombres.size(); i++) {
                            System.out.println("- " + nombres.get(i) + " | " + tallas.get(i) + " | $" + precios.get(i));
                        }
                    }
                } else if (menuOption == 3) {
                    System.out.println(GREEN + "👋 ¡Gracias por usar el gestor de prendas!");
                    break;
                } else {
                    System.out.println(RED + "❌ Opción no válida. Prueba con un número del 1 al 3.");
                }

                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();

            } catch (InputMismatchException ex) {
                System.out.println(RED + "❌ Entrada inválida. Debes digitar un número (1-3).");
                keyEntry.nextLine(); // limpiar buffer
                menuOption = -1;
            } catch (Exception ex) {
                System.out.println(RED + "❌ Ups, algo salió mal: " + ex.getMessage());
                keyEntry.nextLine();
            }

        } while (menuOption != null && menuOption != 3);
    }
}

