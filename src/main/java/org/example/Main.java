package org.example;

//---Se añade extension---//
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner pedirDato = new Scanner(System.in);

        String greenColor="\u001B[32m";

        //---CREO COLOR ROJO---//
        String reedColor ="\u001B[31m";

        //---COLOR AMARILLO---//
        String YellowColor ="\u001B[33m";

        //-----DEFINIR-----//

        //-----VARIABLES LOGIN-----//
        String usuario;
        String usuarioBaseDatos= "usuario123";

        String correo;
        String correoBaseDatos="correo@ejemplo.com";

        String contraseña;
        String contraseñaBaseDatos="123";

        Integer numeroIntentos=1;
        Integer intentosRestantes=4;


        //-----LOGIN------//
        System.out.println("==================");
        System.out.println("Iniciando programa");
        System.out.println("==================");

        System.out.println("↓↓↓ LOGIN ↓↓↓");

        while(numeroIntentos<=4) {

            System.out.print("Digita tu usuario: ");
            usuario = pedirDato.nextLine();

            System.out.print("Digita tu correo: ");
            correo = pedirDato.nextLine();

            System.out.print("Digita tu contraseña: ");
            contraseña = pedirDato.nextLine();

            //---Se verifica que sen iguales a los datos quemados---///
            if (correo.equals(correoBaseDatos) && contraseña.equals(contraseñaBaseDatos) && usuario.equals(usuarioBaseDatos)) {

                System.out.println("Bienvenido!");
                System.out.println("\n******************");
                System.out.println("***** APP *****");
                System.out.println("******************");


                //----- MENU PRINCIPAL -----//
                Integer menuOption = 0;

                //----- LISTA PARA GUARDAR PRENDAS -----//
                ArrayList<HashMap<String, Object>> prendas = new ArrayList<>(); //Inicio lista


                do {
                    try {

                        System.out.println("👕 Bienvenido a gestor de prendas...\n¿Qué quieres realizar?\n");
                        System.out.println(reedColor + "1) Guardar una prenda en BD 📝");
                        System.out.println("2) Mostrar el inventario de prendas 📦");
                        System.out.println("3) SALIR ❌\n");

                        System.out.print("Digita una opción: ");
                        menuOption = pedirDato.nextInt();
                        pedirDato.nextLine();

                        if (menuOption == 1) {
                            try {
                                System.out.print("Nombre de la prenda: ");
                                String nombre = pedirDato.nextLine();

                                System.out.print("Talla (S/M/L/XL): ");
                                String talla = pedirDato.nextLine();

                                System.out.print("Precio (entero): ");
                                int precio = Integer.parseInt(pedirDato.nextLine().trim());

                                //CREO DICCIONARIO PARA LA PRENDA
                                HashMap<String, Object> prenda = new HashMap<>(); //Inicio diccionario
                                prenda.put("nombre", nombre);
                                prenda.put("talla", talla);
                                prenda.put("precio", precio);

                                prendas.add(prenda); //Añado el diccionario a la lista

                                System.out.println(greenColor + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);

                            } catch (NumberFormatException e) {
                                System.out.println(reedColor + "Precio inválido. Debe ser un número entero." );
                            }
                        }

                        else if (menuOption == 2) {

                            System.out.println(YellowColor + "📋 INVENTARIO:");

                            if (prendas.isEmpty()) {
                                System.out.println("Aún no hay prendas registradas.");
                            } else {
                                for (HashMap<String, Object> prenda : prendas) {
                                    System.out.println("- " + prenda.get("nombre") + " | " +
                                            prenda.get("talla") + " | $" +
                                            prenda.get("precio"));
                                }
                            }
                        }

                        else if (menuOption == 3) {
                            System.out.println("Cerrando programa...");
                            break;
                        }

                        else {
                            System.out.println(reedColor + "❌ Opción inválida. Digita 1, 2 o 3.");
                        }


                        if (menuOption != null && menuOption !=3) {
                            System.out.print("\nPresiona ENTER para continuar...");
                            pedirDato.nextLine();
                            System.out.println();
                        }

                    }

                    catch (InputMismatchException ex) {
                        System.out.println(reedColor + "Entrada inválida. Debes digitar un número (1-3).");
                        pedirDato.nextLine();
                        menuOption = -1;
                        System.out.print("\nPresiona ENTER para continuar...");
                        pedirDato.nextLine();
                        System.out.println();
                    }

                    catch (Exception ex) {
                        System.out.println(reedColor + "Ups, algo salió mal: " + ex.getMessage());
                        System.out.print("\nPresiona ENTER para continuar...");
                        pedirDato.nextLine();
                        System.out.println();
                    }

                } while (menuOption == null || menuOption != 3);

                break;
            }

            else {

                if (intentosRestantes >= 2) {intentosRestantes = intentosRestantes - 1;
                    System.out.println("Inténtalo de nuevo! Te quedan " + intentosRestantes + " intentos");
                } else {
                    System.out.println("---CUENTA BLOQUEADA---");
                }

                numeroIntentos++;
            }
        }
    }
}
