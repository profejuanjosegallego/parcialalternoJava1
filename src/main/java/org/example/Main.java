package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entradaTeclado = new Scanner(System.in);
        Integer opcionMenu = null;

        // Colores
        String VERDE = "\u001B[32m";
        String ROJO = "\u001B[31m";
        String AMARILLO = "\u001B[33m";
        String RESET = "\u001B[0m";

        // Variables simulación de login//
        String usuarioCorrecto = "Lyon-777";
        String correoCorrecto = "elevenpt3@gmail.com";
        String contrasenaCorrecta = "1234";
        String usuarioIngresado, contrasenaIngresada, correoIngresado;



                      // LOGIN//
        System.out.println("\n===== LOGIN =====");

        System.out.print("Ingresa tu usuario: ");
        usuarioIngresado = entradaTeclado.nextLine();

        System.out.println("Ingresa tu correo: ");
        correoIngresado = entradaTeclado.nextLine();

        System.out.print("Ingresa tu contraseña: ");
        contrasenaIngresada = entradaTeclado.nextLine();

        if (!usuarioIngresado.equals(usuarioCorrecto) || !contrasenaIngresada.equals(contrasenaCorrecta)|| correoIngresado.equals(correoCorrecto)) {
            System.out.println(ROJO + "❌ Usuario o contraseña incorrectos. Cerraremos el programa." + RESET);
            return; // Termina la ejecución
        }

        System.out.println(VERDE + "✔ Acceso permitido. ¡Bienvenido!" + RESET);


        // ============================
        // MENÚ PRINCIPAL
        // ============================
        do {
            try {
                System.out.println("\n👕 Bienvenido al sistema de prendas");
                System.out.println(VERDE + "1) Guardar una prenda 📝");
                System.out.println("2) Mostrar inventario 📦");
                System.out.println("3) Salir ❌" + RESET);

                System.out.print("Elige una opción: ");
                opcionMenu = entradaTeclado.nextInt();
                entradaTeclado.nextLine(); // Limpia el buffer

                if (opcionMenu == 1) {
                    try {
                        System.out.print("Nombre de la prenda: ");
                        String nombrePrenda = entradaTeclado.nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String tallaPrenda = entradaTeclado.nextLine();

                        System.out.print("Precio (entero): ");
                        int precioPrenda = Integer.parseInt(entradaTeclado.nextLine().trim());

                        System.out.println(VERDE + "✔ Prenda guardada: " + nombrePrenda + " - " + tallaPrenda + " - $" + precioPrenda + RESET);
                    } catch (NumberFormatException e) {
                        System.out.println(ROJO + "❌ Error: El precio debe ser un número entero." + RESET);
                    }
                } else if (opcionMenu == 2) {

                    System.out.println(AMARILLO + "📋 Inventario (demo):");
                    System.out.println("- Camiseta | M | $45000");
                    System.out.println("- Jean     | L | $120000" + RESET);

                } else if (opcionMenu == 3) {
                    System.out.println(VERDE + "👋 Saliendo del programa..." + RESET);
                } else {
                    System.out.println(ROJO + "⚠ Opción no válida. Ingresa un número del 1 al 3." + RESET);
                }

                if (opcionMenu != 3) {
                    System.out.print("\nPresiona ENTER para continuar...");
                    entradaTeclado.nextLine();
                }

            } catch (InputMismatchException ex) {
                System.out.println(ROJO + "⚠ Entrada incorrecta. Debes ingresar un número (1-3)." + RESET);
                entradaTeclado.nextLine(); // Limpiar buffer
                opcionMenu = -1; // Reinicia
            } catch (Exception ex) {
                System.out.println(ROJO + "⚠ Ocurrió un error: " + ex.getMessage() + RESET);
            }

        } while (opcionMenu == null || opcionMenu != 3);

    }
}


