package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        ArrayList<HashMap<String, Object>> prendas = new ArrayList<>();
        Integer menuOption = null;
        Integer intentos = 0;

        //implementa logica para login con:
        //-nombre usuario
        //-correo
        //-contraseña
        String nombreUsuario;
        String correoUsuario;
        String contraseñaUsuario;
        String nombreBaseDatos = "examenjava";
        String correoBaseDatos = "examen@gmail.com";
        String contraseñaBaseDatos = "1234";
        String greenColor = "\u001B[32m";
        String redColor = "\u001B[31m";
        String yellowColor = "\u001B[33m";


        System.out.println("\n******************");
        System.out.println("*****🍀🍀🍀APP🍀🍀🍀*****");
        System.out.println("******************");

        while (intentos < 3) {
            System.out.println("ingrese nombre de usuario");
            nombreUsuario = keyEntry.nextLine();

            System.out.println("ingrese correo electronico");
            correoUsuario = keyEntry.nextLine();

            System.out.println("ingrese contraseña");
            contraseñaUsuario = keyEntry.nextLine();

            if (nombreUsuario.equals(nombreBaseDatos) && correoUsuario.equals(correoBaseDatos) && contraseñaUsuario.equals(contraseñaBaseDatos)) {
                System.out.println("bienvenido 👍👍👍");
                break;
            } else {
                intentos++;
                System.out.println("ERROR te equivocaste " + intentos + " de 3");
            }
            if (intentos == 3) {
                System.out.println("se te acabaron los intentos NO puedes ingresar 👎👎👎");
                break;
            }
        }


        System.out.println("Digita una opcion: ");
        menuOption = keyEntry.nextInt();

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

                        HashMap<String, Object> prenda = new HashMap<>();

                        System.out.print("Nombre de la prenda: ");
                        String nombre = keyEntry.nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = keyEntry.nextLine();

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(keyEntry.nextLine().trim());

                        prenda.put("nombre", nombre);
                        prenda.put("talla", talla);
                        prenda.put("precio", precio);
                        prendas.add(prenda);
                        System.out.println(greenColor + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);
                    } catch (NumberFormatException e) {
                        System.out.println(redColor + "Precio inválido. Debe ser un número entero.");
                    }
                } else if (menuOption == 2) {

                    //implementar algoritmo para recorrer y mostrar la lista en el formato pedido
                    System.out.println(yellowColor + "📋 Inventario (demo):");
                    for(HashMap<String, Object> item: prendas){
                        System.out.println("-" + item.get("nombre") + " | " + item.get("talla") + " | $" + item.get("precio"));
                    }

                } else if (menuOption == 3) {
                    break;
                    //implementar algoritmo para cerrar el programa
                } else {
                    System.out.println(redColor + "Opción no válida. Prueba con un número del 1 al 3.");
                }


            } catch (InputMismatchException ex) {
                System.out.println(redColor + "Entrada inválida. Debes digitar un número (1-3).");
                keyEntry.nextLine();
                menuOption = -1;
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            } catch (Exception ex) {
                // Cualquier otra excepción no prevista
                System.out.println(redColor + "Ups, algo salió mal: " + ex.getMessage());
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            }

        } while (menuOption == null || menuOption != 3);

    }
}