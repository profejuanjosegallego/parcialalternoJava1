package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption=null;
        ArrayList<HashMap<String, Object>> Prendas = new ArrayList<>();

        String GREEN="\u001B[32m";
        String YELLOW = "\u001B[33m";
        String RED = "\u001B[31m";


        //implementa logica para login con:
        //-nombre usuario
        //-correo
        //-contraseña

        String CorreoUsuario ="";
        String contraseñaUsuario ="";
        String correoGuardadoBaseDatos ="jason@gmail.com";
        String contrasenaGuardadaBaseDatos ="5555";
        String UsuarioDigitado ="";
        String UsuarioGuardadoBaseDeDatos ="Jason";

        Integer intentos = 0;

        System.out.println("\n*******************************");
        System.out.println("***** INICIO DE SESION🔐 ******");
        System.out.println("********************************");



        while (intentos <3) {

            System.out.print("\nIngrese su nombre de usuario👤: ");
            UsuarioDigitado=keyEntry.nextLine();

            System.out.print("\nIngrese su correo📨: ");
            CorreoUsuario=keyEntry.nextLine();

            System.out.print("\nIngrese su contraseña🔐: ");
            contraseñaUsuario=keyEntry.nextLine();

            if (CorreoUsuario.equals(correoGuardadoBaseDatos) &&
                    contraseñaUsuario.equals(contrasenaGuardadaBaseDatos) && (UsuarioDigitado.equals(UsuarioGuardadoBaseDeDatos))) {

                System.out.println("\nAcceso Concedido✅");
                break;

            }else{
                intentos++;
                System.out.println("Acceso denegado, " + intentos + " de 3");
            }
            if (intentos.equals(3)) {
                System.out.println("Acceso Denegado Por Maximo De Intentos❌");
                return;

            }
        }



        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");

        do {
            try {

                System.out.println("\n👕 Bienvenido a gestor de prendas...\n¿Qué quieres realizar?\n");
                System.out.println(GREEN + "1) Guardar una prenda en BD 📝");
                System.out.println("2) Mostrar el inventario de prendas 📦");
                System.out.println("3) SALIR ❌\n");

                System.out.print("Digita una opción: ");
                menuOption = keyEntry.nextInt();
                keyEntry.nextLine();

                if (menuOption == 1) {
                    try {
                        HashMap<String, Object> Prenda = new HashMap<>();

                        System.out.print("Nombre de la prenda: ");
                        String nombre = keyEntry.nextLine();
                        Prenda.put("Nombre Prenda: ", nombre);

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = keyEntry.nextLine();
                        Prenda.put("Talla Prenda:", talla);

                        System.out.print("Precio (entero): ");
                        int precio = keyEntry.nextInt();
                        Prenda.put("Precio Prenda: ", precio);
                        Prendas.add(Prenda);

                        System.out.println(GREEN + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "Precio inválido. Debe ser un número entero." );
                    }
                } else if (menuOption == 2) {

                    for (HashMap<String,Object> Prenda : Prendas ) {
                        System.out.printf("- %10s | %-3s | $%s%n",
                        Prenda.get("Nombre Prenda: "),
                        Prenda.get("Talla Prenda:"),
                        Prenda.get("Precio Prenda: ")
                        );

                    }

                } else if (menuOption == 3) {
                    break;
                } else {
                    System.out.println(RED + "Opción no válida. Prueba con un número del 1 al 5.");
                }


                if (menuOption != null && menuOption != 5) {
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
                }

            } catch (InputMismatchException ex) {
                System.out.println(RED + "Entrada inválida. Debes digitar un número (1-5).");
                keyEntry.nextLine();
                menuOption = -1;
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            } catch (Exception ex) {
                // Cualquier otra excepción no prevista
                System.out.println(RED + "Ups, algo salió mal: " + ex.getMessage());
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            }

        } while (menuOption == null || menuOption != 5);

    }
}