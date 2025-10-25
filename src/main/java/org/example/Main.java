package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption;
        String greenColor="\u001B[32m";

        //implementa logica para login con:
        //-nombre usuario
        //-correo
        //-contraseña

        String nombreGuardado = "Julian";
        String correoGuardado = "julian@gmail.com";
        String contraseñaGuardada = "julian123@";
        String correoDigitado;
        String contraseñaDigitada;
        String nombreDigitado;

        System.out.println("Ingresa tu correo");
        correoDigitado = keyEntry.nextLine();
        System.out.println("Ingresa tu contraseña");
        contraseñaDigitada = keyEntry.nextLine();

        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");

        ArrayList<HashMap<String,Object>> prendas = new ArrayList<>();

        if (correoDigitado.equals(correoGuardado) && contraseñaDigitada.equals(contraseñaGuardada)){

            System.out.println("👕 Bienvenido " +nombreGuardado +  " a gestor de prendas...\n¿Qué quieres realizar?\n");

            do {
                try {

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
                            Integer precio = keyEntry.nextInt();

                            HashMap<String, Object> prenda = new HashMap<>();

                            prenda.put("nombre", nombre);
                            prenda.put("talla", talla);
                            prenda.put("precio", precio);

                            prendas.add(prenda);

                            System.out.println(greenColor+ "✅ Prenda guardada: " + prendas);

                        } catch (NumberFormatException e) {
                            System.out.println(" ❌ Precio inválido. Debe ser un número entero." );
                        }
                    } else if (menuOption == 2) {

                        System.out.println(greenColor + "📋 Inventario :");

                        for(HashMap<String,Object>listaPrendas:prendas){

                            System.out.println( listaPrendas.get("nombre") + "|" + listaPrendas.get("talla") + "|" + listaPrendas.get("precio") );

                        }

                    } else if (menuOption == 3) {
                        System.out.println("CHAO");
                        break;
                    } else {
                        System.out.println(greenColor + "Opción no válida. Prueba con un número del 1 al 5.");
                    }

                } catch (InputMismatchException ex) {
                    System.out.println(greenColor + "Entrada inválida.");
                    keyEntry.nextLine();
                    menuOption = -1;
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
                } catch (Exception ex) {
                    // Cualquier otra excepción no prevista
                    System.out.println(greenColor + "Ups, algo salió mal: " + ex.getMessage());
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
                }

            } while (true);

        } else {
            System.out.println("ERROR: Datos incorrectos");
        }

    }
}