package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc  = new Scanner (System.in);
        Integer menuOption = null;

        // Colores
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        // Datos correctos del login
        String userBD = "david123";
        String correoBD = "davidhenao";
        String passBD = "12345";

        // Variables donde se guarda lo que digita el usuario
        String userIngresado;
        String correoIngresado;
        String passIngresada;

        // Intentos del login
        int intentos = 1;
        int intentosRestantes = 4;

       ;
        System.out.println("Arrancando sistema");


        // PROCESO DE LOGIN
        while (intentos <= 4) {

            System.out.print("Nombre de usuario: ");
            userIngresado = sc.nextLine();

            System.out.print("Correo: ");
            correoIngresado = sc.nextLine();

            System.out.print("Contraseña: ");
            passIngresada = sc.nextLine();

            if (userIngresado.equals(userBD) &&
                    correoIngresado.equals(correoBD) &&
                    passIngresada.equals(passBD)) {

                System.out.println(GREEN + "Acceso concedido" + RESET);
                break;

            } else {

                intentosRestantes--;
                System.out.println(RED + "Datos incorrectos Te quedan " + intentosRestantes + " intentos." + RESET);

                if (intentosRestantes == 0) {
                    System.out.println(RED + "--- CUENTA BLOQUEADA ---" + RESET);
                    return; // Cierra el programa
                }

                intentos++;
            }
        }

        // LISTA DE PRENDAS
        ArrayList<HashMap<String, Object>> listaPrendas = new ArrayList<>();



        do {
            try {
                System.out.println("\n👕 Bienvenido a gestor de prendas...");
                System.out.println("¿Qué quieres realizar?\n");
                System.out.println(GREEN + "1) Guardar una prenda en BD 📝" + RESET);
                System.out.println("2) Mostrar el inventario de prendas 📦");
                System.out.println("3) SALIR ❌\n");

                System.out.print("Digita una opción: ");
                menuOption = sc.nextInt();
                sc.nextLine(); // Limpia buffer

                if (menuOption == 1) {

                    System.out.print("Nombre de la prenda: ");
                    String nombre = sc.nextLine();

                    System.out.print("Talla (S/M/L/XL): ");
                    String talla = sc.nextLine();

                    System.out.print("Precio (entero): ");
                    int precio = Integer.parseInt(sc.nextLine().trim());

                    HashMap<String, Object> prenda = new HashMap<>();
                    prenda.put("nombre", nombre);
                    prenda.put("talla", talla);
                    prenda.put("precio", precio);

                    listaPrendas.add(prenda);

                    System.out.println(GREEN + "✅ Prenda guardada: " +
                            nombre + " - " + talla + " - $" + precio + RESET);

                } else if (menuOption == 2) {

                    System.out.println(YELLOW + "\n📋 Inventario de prendas:" + RESET);

                    if (listaPrendas.isEmpty()) {
                        System.out.println("No hay prendas registradas.");
                    } else {
                        for (HashMap<String, Object> p : listaPrendas) {
                            System.out.println("- " + p.get("nombre") + " | " +
                                    p.get("talla") + " | $" + p.get("precio"));
                        }
                    }

                } else if (menuOption == 3) {
                    System.out.println("Saliendo del sistema...");
                } else {
                    System.out.println(RED + "Opción inválida (1-3)" + RESET);
                }

                if (menuOption != 3) {
                    System.out.print("\nPresiona ENTER para continuar...");
                    sc.nextLine();
                }

            } catch (InputMismatchException ex) {
                System.out.println(RED + "Error: Digita un número válido." + RESET);
                sc.nextLine();
                menuOption = -1;

                System.out.print("\nPresiona ENTER para continuar...");
                sc.nextLine();
            }

        } while (menuOption != 3);
    }
}
;


