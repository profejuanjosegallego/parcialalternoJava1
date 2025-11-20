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
        String redColor="\u001B[33m";
        String yellowColor="\u001B[33m";
        String correoUsusarioBaseDatos, contraseñaUsuarioBaseDatos, nombreUsuario, correoUsuario,
                contraseñaUsuario, nombreUsuarioBaseDatos, confirmarSalida;
        ArrayList<HashMap<String,Object>> prendas = new ArrayList<>();

        //implementa logica para login con:
        //-nombre usuario
        //-correo
        //-contraseña

        nombreUsuarioBaseDatos="Dilan";
        correoUsusarioBaseDatos="dilan@gmail.com";
        contraseñaUsuarioBaseDatos="1234";

        Integer intentos=1;
        while (intentos <=3) {
            System.out.print("Ingrese el nombre de usuario: ");
            nombreUsuario = keyEntry.next();
            System.out.print("Ingrese el correo electronico: ");
            correoUsuario = keyEntry.next();
            System.out.print("Ingrese la contraseña: ");
            contraseñaUsuario = keyEntry.next();
            keyEntry.nextLine();
            if (nombreUsuario.equals(nombreUsuarioBaseDatos) && correoUsuario.equals(correoUsusarioBaseDatos) && contraseñaUsuario.equals(contraseñaUsuarioBaseDatos)) {
                System.out.println("Felicidades entraste existosamente");
                break;
            }else {
                System.out.println(" Fallaste intentalo de nuevo");
                intentos++;
                if (intentos==3){
                    return;

                }
            }
        }






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
                        HashMap<String,Object> prenda = new HashMap<>();
                        System.out.print("Nombre de la prenda: ");
                        String nombre = keyEntry.nextLine();
                        prenda.put("Nombre", nombre);

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = keyEntry.nextLine();
                        prenda.put("Talla", talla);

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(keyEntry.nextLine().trim());
                        prenda.put("Precio", precio);
                        prendas.add(prenda);
                        System.out.println(greenColor + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);
                    } catch (NumberFormatException e) {
                        System.out.println(redColor + "Precio inválido. Debe ser un número entero." );
                    }
                } else if (menuOption == 2) {

                    System.out.println(prendas);

                    System.out.println("📋 Inventario:");

                    for (HashMap<String, Object> prenda : prendas) {
                        System.out.printf("- %-10s | %-3s | $%s%n",
                                prenda.get("Nombre"),
                                prenda.get("Talla"),
                                prenda.get("Precio")
                        );
                    }



                } else if (menuOption == 3) {
                    //implementar algoritmo para cerrar el programa
                    System.out.print("¿Estas seguro que deseas salir?(ingresa si)");
                    confirmarSalida = keyEntry.next();
                    if (confirmarSalida.equals("si")){
                        System.out.println("Hasta pronto");
                        return;

                    }
                } else {
                    System.out.println(redColor + "Opción no válida. Prueba con un número del 1 al 5.");
                }


                if (menuOption != null && menuOption != 5) {
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
                }

            } catch (InputMismatchException ex) {
                System.out.println(redColor + "Entrada inválida. Debes digitar un número (1-5).");
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

        } while (menuOption == null || menuOption != 5);

    }
}