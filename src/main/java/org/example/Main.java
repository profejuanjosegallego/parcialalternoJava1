package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner tecladoDigitadoUsuario = new Scanner(System.in);

        // Colores
        String blackColor = "\u001B[30m";
        String redColor = "\u001B[31m";
        String greenColor = "\u001B[32m";
        String yellowColor = "\u001B[33m";

        Integer intentos = 1;

        // Variables del login
        String nombreDeUsuarioInsertada;
        String correoDeUsuarioInsertada;
        String contraseniaUsuarioInsertada;

        String confirmacionNombreDeUsuario = "";
        String confirmacionCorreoDeUsuario = "";
        String confirmacionContraseniaDeUsuario = "";


        System.out.println(greenColor + "\n******************");
        System.out.println("***** CLOTHING STORE *****");
        System.out.println("******************");

        // --- Registro inicial ---
        System.out.print(redColor + "Inserte por favor su nombre de usuario: ");
        nombreDeUsuarioInsertada = tecladoDigitadoUsuario.nextLine();

        System.out.print(redColor + "Inserte por favor su correo electrónico: ");
        correoDeUsuarioInsertada = tecladoDigitadoUsuario.nextLine();

        System.out.print(redColor + "Inserte por favor su contraseña (Recuérdala para más tarde): ");
        contraseniaUsuarioInsertada = tecladoDigitadoUsuario.nextLine();

        System.out.println("\n¡Ahora verifica tus credenciales para poder ingresar!\n");

        // --- LOGIN ---
        while (intentos < 4) {

            // Validar usuario
            System.out.print("Ingresa tu nombre de usuario: ");
            confirmacionNombreDeUsuario = tecladoDigitadoUsuario.nextLine();

            if (!nombreDeUsuarioInsertada.equalsIgnoreCase(confirmacionNombreDeUsuario)) {
                System.out.println(redColor + "Usuario incorrecto. Intenta nuevamente.\n" + " Intentos Restantes: " + intentos);
                intentos++;
                continue;
            }

            // Validar correo
            System.out.print("Ingresa tu correo nuevamente: ");
            confirmacionCorreoDeUsuario = tecladoDigitadoUsuario.nextLine();

            if (!correoDeUsuarioInsertada.equalsIgnoreCase(confirmacionCorreoDeUsuario)) {
                System.out.println(redColor + "Correo incorrecto. Intenta nuevamente.\n" + " Intentos Restantes : " + intentos);
                intentos++;
                continue;
            }

            // Validar contraseña
            System.out.print("Ingresa tu contraseña nuevamente: ");
            confirmacionContraseniaDeUsuario = tecladoDigitadoUsuario.nextLine();

            if (!contraseniaUsuarioInsertada.equalsIgnoreCase(confirmacionContraseniaDeUsuario)) {
                System.out.println(redColor + "Contraseña incorrecta. Intenta nuevamente.\n" + " Intentos Restantes: "  + intentos);
                intentos++;
                continue;
            }

            System.out.println(greenColor + "\n¡Perfecto! Acceso permitido.\n");
            break;
        }

        if (intentos >= 3) {
            System.out.println(redColor + "Demasiados intentos fallidos. Programa finalizado.");
            return;
        }

        // LISTA PARA GUARDAR PRENDAS
        ArrayList<HashMap<String, Object>> prendasRopas = new ArrayList<>();

        // --- MENÚ PRINCIPAL ---
        Integer menuOption = 0;

        do {
            try {
                System.out.println(greenColor + "👕 Bienvenido al gestor de prendas");
                System.out.println("1) Guardar una prenda 📝");
                System.out.println("2) Mostrar inventario 📦");
                System.out.println("3) Salir ❌");
                System.out.print(blackColor + "Digita una opción: ");

                menuOption = tecladoDigitadoUsuario.nextInt();
                tecladoDigitadoUsuario.nextLine(); // limpiar buffer

                // --- Opción 1: Guardar prenda ---
                if (menuOption == 1) {

                    HashMap<String, Object> prenda = new HashMap<>();

                    System.out.print("Nombre de la prenda: ");
                    prenda.put("Nombre", tecladoDigitadoUsuario.nextLine().trim());

                    System.out.print("Talla (S/M/L/XL): ");
                    prenda.put("Talla", tecladoDigitadoUsuario.nextLine().trim());

                    int precio;
                    while (true) {
                        try {
                            System.out.print("Precio (entero): ");
                            precio = Integer.parseInt(tecladoDigitadoUsuario.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(redColor + "❌ Precio inválido. Debe ser un número entero.");
                        }
                    }
                    prenda.put("Precio", precio);

                    prendasRopas.add(prenda);

                    System.out.println(greenColor + "✅ Prenda guardada correctamente.\n");
                }

                // --- Opción 2: Mostrar inventario ---
                else if (menuOption == 2) {

                    if (prendasRopas.isEmpty()) {
                        System.out.println(yellowColor + "📭 No hay prendas registradas aún.\n");
                    } else {
                        System.out.println(yellowColor + "\n📋 INVENTARIO DE PRENDAS");
                        for (HashMap<String, Object> p : prendasRopas) {
                            System.out.printf("- %-12s | %-3s | $%s%n",
                                    p.get("Nombre"),
                                    p.get("Talla"),
                                    p.get("Precio"));
                        }
                        System.out.println();
                    }
                }

                // --- Opción 3: Salir  del aplicativo ---
                else if (menuOption == 3) {
                    System.out.println(greenColor + "👋 ¡Hasta la próxima!");
                }

                else {
                    System.out.println(redColor + "❌ Opción no válida. Debe ser 1, 2 o 3.\n");
                }

            } catch (InputMismatchException ex) {
                System.out.println(redColor + "Entrada inválida. Debes digitar un número (1–3).");
                tecladoDigitadoUsuario.nextLine();
            }

        } while (menuOption != 3);

        tecladoDigitadoUsuario.close();
    }
}