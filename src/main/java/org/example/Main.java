package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption = null;
        String redColor = "\u001B[31m";
        String greenColor = "\u001B[32m";
        String yellowColor = "\u001B[33m";

        // 🔧 Lista para guardar prendas
        ArrayList<HashMap<String, Object>> inventario = new ArrayList<>();

        // Datos registrados (como si estuvieran en la base de datos)
        String usuarioBaseDatos = "jordan";
        String correoBaseDatos = "jordan@gmail.com";
        String contraseñaBaseDatos = "12345";

        // Login
        System.out.print("Ingresa tu nombre de usuario: ");
        String usuarioIngresado = keyEntry.nextLine();

        System.out.print("Ingresa tu correo: ");
        String correoIngresado = keyEntry.nextLine();

        System.out.print("Ingresa tu contraseña: ");
        String contraseñaIngresada = keyEntry.nextLine();

        if (usuarioIngresado.equals(usuarioBaseDatos) &&
                correoIngresado.equals(correoBaseDatos) &&
                contraseñaIngresada.equals(contraseñaBaseDatos)) {
            System.out.println("¡Bienvenido!");
        } else {
            System.out.println("❌ Datos incorrectos. Intenta nuevamente.");
            return; // 🔧 Salir si el login falla
        }

        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");

        do {
            try {
                System.out.println("👕 Bienvenido a gestor de prendas...\n¿Qué quieres realizar?\n");
                System.out.println(greenColor + "1) Guardar una prenda en BD 📝");
                System.out.println(greenColor + "2) Mostrar el inventario de prendas 📦");
                System.out.println(greenColor + "3) SALIR ❌\n");

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

                        // 🔧 Guardar en inventario
                        HashMap<String, Object> prenda = new HashMap<>();
                        prenda.put("nombre", nombre);
                        prenda.put("talla", talla);
                        prenda.put("precio", precio);
                        inventario.add(prenda);

                        System.out.println(greenColor + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);

                    } catch (NumberFormatException e) {
                        System.out.println(redColor + "Precio inválido. Debe ser un número entero.");
                    }

                } else if (menuOption == 2) {
                    System.out.println(yellowColor + "\n📋 Inventario actual:");

                    for (HashMap<String, Object> prenda : inventario) { // esto es un bloque for- each
                        String nombre = prenda.get("nombre").toString(); // el toString asegura que el valor se convierta a texto.
                        String talla = prenda.get("talla").toString();
                        int precio = Integer.parseInt(prenda.get("precio").toString()); //convierte el precio a número entero (porque viene como Object

                        while (nombre.length() < 10) { //cantidad de caracteres que tiene la cadena de texto
                            nombre += " "; // “Agrega un espacio al final del texto que ya está en la variable NOMBRE
                        }

                        System.out.println("- " + nombre + "| " + talla + " | $" + precio);
                    }

                } else if (menuOption == 3) {
                    System.out.println("Saliendo del sistema...");
                    break;

                } else {
                    System.out.println(redColor + "Opción no válida. Prueba con un número del 1 al 3.");
                }

                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();

            } catch (InputMismatchException ex) {
                System.out.println(redColor + "Entrada inválida. Debes digitar un número (1-3).");
                keyEntry.nextLine();
                menuOption = -1;
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();

            } catch (Exception ex) {
                System.out.println(redColor + "Ups, algo salió mal: " + ex.getMessage());
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            }

        } while (menuOption == null || menuOption != 3);
    }
}