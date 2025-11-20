package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption=null;
        String greenColor="\u001B[32m";
        String redColor="\u001B[31m";
        String yellowColor="\u001B[33m";
        String reset = "\u001B[0m";


        //implementa logica para login con:
        //-nombre usuario
        //-correo
        //-contraseña

        //Implementación del Login


        String usuarioIngresado;
        String contrasenaIngresada;
        String correoCorrecto;
        Scanner DatosIngresados = new Scanner(System.in);

// Contador de intentos
        int intentos = 0;

        while (true) {

            System.out.print("Ingrese el usuario: ");
            usuarioIngresado = DatosIngresados.nextLine();

            System.out.print("Ingrese la contraseña: ");
            contrasenaIngresada = DatosIngresados.nextLine();

            System.out.print("Ingrese el correo: ");
            correoCorrecto = DatosIngresados.nextLine();



            if (usuarioIngresado.equals(usuarioIngresado) &&  correoCorrecto.equals(correoCorrecto) &&
                    contrasenaIngresada.equals(contrasenaIngresada)) {

                System.out.println("Acceso correcto");
                break; // Sale del ciclo si es correcto

            } else {
                intentos++;
                System.out.println("Acceso incorrecto. Intento " + intentos + " de 4");

                if (intentos == 3 ) {
                    System.out.println("ACCESO DENEGADO");
                    break; // Se acaban los intentos
        }
    }
        }




        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");

        ArrayList<HashMap<String,Object>> inventarios = new ArrayList<>();

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

                        HashMap<String,Object>inventario=new HashMap<>();

                        System.out.print("Nombre de la prenda: ");
                        String nombre = keyEntry.nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = keyEntry.nextLine();

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(keyEntry.nextLine().trim());
                        System.out.println(greenColor + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);

                        inventario.put("nombre", nombre);
                        inventario.put("talla", talla);
                        inventario.put("precio", precio);
                        inventarios.add(inventario);

                    } catch (NumberFormatException e) {
                        System.out.println(redColor + "Precio inválido. Debe ser un número entero." );
                    }
                } else if (menuOption == 2) {

                    //implementar algoritmo para recorrer y mostrar la lista en el formato pedido

                    System.out.println(yellowColor + "📋 Inventario (demo):");
                    System.out.println("- Camiseta | M | $45000");
                    System.out.println("- Jean     | L | $120000");

                    // Algoritmo de lista implementado con un ciclo for

                    for (HashMap<String,Object> item : inventarios) {
                        System.out.println("- " + item.get("nombre") + " | "
                                + item.get("talla") + " | $"
                                + item.get("precio"));
                    }


                } else if (menuOption == 3) {
                    //implementar algoritmo para cerrar el programa

                    break;

                } else {
                    System.out.println(redColor + "Opción no válida. Prueba con un número del 1 al 5." + reset);
                }


                if (menuOption != null && menuOption != 5) {
                    System.out.print("\nPresiona ENTER para continuar..." + reset);
                    keyEntry.nextLine();
                    System.out.println();
                }

            } catch (InputMismatchException ex) {
                System.out.println(redColor + "Entrada inválida. Debes digitar un número (1-5).");
                keyEntry.nextLine();
                menuOption = -1;
                System.out.print("\nPresiona ENTER para continuar..." + reset);
                keyEntry.nextLine();
                System.out.println();
            } catch (Exception ex) {
                // Cualquier otra excepción no prevista
                System.out.println(redColor + "Ups, algo salió mal: " + ex.getMessage());
                System.out.print("\nPresiona ENTER para continuar..." + reset);
                keyEntry.nextLine();
                System.out.println();
            }

        } while (menuOption == null || menuOption != 5);

    }
}