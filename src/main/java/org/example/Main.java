package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.awt.Color.RED;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption=null;
        String greenColor="\u001B[32m";

        //implementa logica para login con:
        //-nombre usuario
        //-correo
        //-contraseña


        String usuarioIngresado;
        String contrasenaIngresada;


        String Usuario = "nekros";
        String contrasenaCorrecta = "warframe";

        Scanner DatosIngresados = new Scanner(System.in);

        // Contador de intentos
        int intentos = 0;

        while (true) {

            System.out.print("Ingrese el usuario: ");
            usuarioIngresado = DatosIngresados.nextLine();

            System.out.print("Ingrese la contraseña: ");
            contrasenaIngresada = DatosIngresados.nextLine();

            if (usuarioIngresado.equals(Usuario) &&
                    contrasenaIngresada.equals(contrasenaCorrecta)) {

                System.out.println("Acceso correcto");
                break;

            } else {
                intentos++;
                System.out.println("Acceso incorrecto. Intento " + intentos + " de 4");

                if (intentos == 4) {
                    System.out.println("ACCESO DENEGADO");
                    break;
                }
            }
        }






        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");


        System.out.println("Digita 0 para abrir el menu: ");
        menuOption=keyEntry.nextInt();

        ArrayList<HashMap<String, Object>> inventario = new ArrayList<>();

        do {
            try {

                Scanner sc = new Scanner(System.in);

                String GREEN = "";
                String RED = "";

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
                        String nombre = sc.nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = sc.nextLine();

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(sc.nextLine().trim());


                        HashMap<String, Object> prenda = new HashMap<>();
                        prenda.put("nombre", nombre);
                        prenda.put("talla", talla);
                        prenda.put("precio", precio);
                        inventario.add(prenda);


                        System.out.println(GREEN + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "Precio inválido. Debe ser un número entero." );
                    }

                } else if (menuOption == 2) {

                    String YELLOW = "Inventario demo";

                    // prendas de demostración que ya tienes+

                    System.out.println(YELLOW + "📋 Inventario (demo):");
                    System.out.println("- Camiseta | M | $45000");
                    System.out.println("- Jean     | L | $120000");

                    // recorrer el inventario REAL con un for
                    for (int i = 0; i < inventario.size(); i++) {
                        HashMap<String, Object> p = inventario.get(i);
                        System.out.println("- " + p.get("nombre") + " | " + p.get("talla") + " | $" + p.get("precio"));

                    }
                }else if (menuOption ==3){
                    return;
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