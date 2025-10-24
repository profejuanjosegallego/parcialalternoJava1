package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption=null;
        String greenColor="\u001B[32m";

        //implementa logica para login con:
        //-nombre usuario
        //-correo
        //-contraseña

        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");


        System.out.println("Digita una opcion: ");
        menuOption=keyEntry.nextInt();

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
                        String nombre = nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = sc.nextLine();

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(sc.nextLine().trim());
                        System.out.println(GREEN + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "Precio inválido. Debe ser un número entero." );
                    }
                } else if (menuOption == 2) {

                    //implementar algoritmo para recorrer y mostrar la lista en el formato pedido
                    System.out.println(YELLOW + "📋 Inventario (demo):");
                    System.out.println("- Camiseta | M | $45000");
                    System.out.println("- Jean     | L | $120000");


                } else if (menuOption == 3) {
                    //implementar algoritmo para cerrar el programa
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