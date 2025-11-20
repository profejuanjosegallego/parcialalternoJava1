package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption=null;

        String GREEN="\u001B[32m";
        String RED="\u001B[31m";
        String YELLOW = "\u001B[33m";

        ArrayList<HashMap<String, Object>>prendas = new ArrayList<>();
        ArrayList<HashMap<String,Object>>usuarios = new ArrayList<>();
        HashMap<String, Object>usuario = new HashMap<>();

        System.out.println("\n******************");
        System.out.println("***** REGISTRO *****");
        System.out.println("******************");

        System.out.print("Digita tu nombre: ");
        String nombreUsuario =keyEntry.nextLine();

        System.out.print("Digita el correo: ");
        String correoUsuario = keyEntry.nextLine();

        System.out.print("Digita la contraseña: ");
        String contraseñaUsuario = keyEntry.nextLine();

        usuario.put("Nombre",nombreUsuario);
        usuario.put("Correo",correoUsuario);
        usuario.put("Contraseña",contraseñaUsuario);

        usuarios.add(usuario);

        boolean acceso = false;

        System.out.println("\n******************");
        System.out.println("***** LOGIN *****");
        System.out.println("******************");

        while (!acceso) {
            System.out.print("Correo electronico: ");
            String correoLogin = keyEntry.nextLine();

            System.out.print("Contraseña: ");
            String contraseñaLogin = keyEntry.nextLine();

            if (correoLogin.equals(correoUsuario) && contraseñaLogin.equals(contraseñaUsuario)) {
                System.out.println(GREEN + " Acceso permitido. Bienvenido SR."+nombreUsuario);
                acceso = true;

            } else {
                System.out.println(RED + "Acceso denegado, usuario no reconocido. ");
            }
        }


        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");

        do {
            try {

                System.out.println("👕 Bienvenido a gestor de prendas...\n¿Qué quieres realizar?\n");
                System.out.println(GREEN + "1) Guardar una prenda en BD 📝");
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

                        HashMap<String, Object> prenda = new HashMap<>();
                        prenda.put("nombre",nombre);
                        prenda.put("talla",talla);
                        prenda.put("precio", precio);

                        prendas.add(prenda);
                        System.out.println(GREEN + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);

                    } catch (NumberFormatException e) {
                        System.out.println(RED + "Precio inválido. Debe ser un número entero." );
                    }
                } else if (menuOption == 2) {
                    System.out.println(YELLOW + "🖋️ Inventario");

                    if (prendas.isEmpty()){
                        System.out.println(RED + "❌ No hay prendas registradas.");
                    } else {
                        for (HashMap<String, Object> item : prendas) {
                            String nombrePrenda = (String) item.get("nombre");
                            String tallaPrenda = (String) item.get("talla");
                            int precioPrenda = (int) item.get("precio");

                            System.out.println("-" + nombrePrenda + " || Talla: " + tallaPrenda + " || Precio: " + precioPrenda);

                        }
                    }

                } else if (menuOption == 3) {
                    System.out.println(GREEN + "🛫 Saliendo...");
                    break;
                } else {
                    System.out.println(RED + "Opción no válida. Prueba con un número del 1 al 3.");
                }



            } catch (InputMismatchException ex) {
                System.out.println(RED + "Entrada inválida. Debes digitar un número (1-3).");
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

        } while(true);

    }
}