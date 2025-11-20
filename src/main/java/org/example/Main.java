package org.example;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption=null;
        String greenColor="\u001B[32m";
        String redColor="\u001B[31m";
        String yellowColor="\u001B[33m";



        String nombreUsuario;
        String nombreUsuarioBaseDatos= "Usuario123";

        String correo;
        String correoBaseDatos= "correo@example.com";

        String contraseña;
        String contraseñaBaseDatos= "123";

        boolean loginExitoso = false;

        while(!loginExitoso){
            System.out.print("Ingresa tu nombre de usuario: ");
            nombreUsuario= keyEntry.nextLine();

            System.out.print("Ingresa tu correo: ");
            correo= keyEntry.nextLine();

            System.out.print("Ingresa tu contraseña: ");
            contraseña= keyEntry.nextLine();

            if (nombreUsuario.equals(nombreUsuarioBaseDatos) && correo.equals(correoBaseDatos) && contraseña.equals(contraseñaBaseDatos)) {
                System.out.println("Bienvenido! 🤩");
                loginExitoso = true;
            } else {
                System.out.println("Los datos ingresados son incorrectos. Inténtalo de nuevo!\n");
            }
        }

        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");

        ArrayList<HashMap<String, Object>>prendas= new ArrayList<>();

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
                        System.out.print("Nombre de la prenda: ");
                        String nombre = keyEntry.nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = keyEntry.nextLine();

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(keyEntry.nextLine().trim());
                        System.out.println(greenColor + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);

                        HashMap<String,Object>prenda= new HashMap<>();
                        prenda.put("nombre", nombre);
                        prenda.put("talla", talla);
                        prenda.put("precio", precio);

                        prendas.add(prenda);

                    } catch (NumberFormatException e) {
                        System.out.println(redColor + "Precio inválido. Debe ser un número entero." );
                    }
                } else if (menuOption == 2) {

                    //implementar algoritmo para recorrer y mostrar la lista en el formato pedido
                    System.out.println(yellowColor + "📋 Inventario:");
                    if (prendas.isEmpty()){
                        System.out.println("Aún no hay prendas registradas.");
                    } else {
                        for (HashMap<String,Object>prenda : prendas){
                            System.out.println("- " + prenda.get("nombre") + " | " + prenda.get("talla") + " | $" + prenda.get("precio"));
                        }
                    }


                } else if (menuOption == 3) {
                    System.out.println("👋 Saliendo del programa...");
                    break;
                } else {
                    System.out.println(redColor + "Opción no válida. Prueba con un número del 1 al 3.");
                }


                if (menuOption != null && menuOption != 3) {
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
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