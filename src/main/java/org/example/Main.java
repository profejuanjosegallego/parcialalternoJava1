package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        ArrayList<HashMap<String, Object>> prendasRopas = new ArrayList<>();
        Integer menuOption = null;
        Integer intentos = 0;
        String correoDigitadoUsuario = "";
        String nombreUsuarioDigitadoUsuario = "";
        String contrasenaDigitadaUsuario = "";
        String correoGuardadoBaseDatos = "alejandro@gmail.com";
        String nombreUsuarioGuardadoBaseDatos = "alejandro";
        String contrasenaGuardadaBaseDatos = "12345";
        String redColor = "\u001B[31m";
        String greenColor = "\u001B[32m";
        String yellowColor = "\u001B[33m";
        String blueColor = "\u001B[34m";
        String purpleColor = "\u001B[35m";
        String whiteColor = "\u001B[37m";

        //implementa logica para login con:
        //-nombre usuario
        //-correo
        //-contraseña

        System.out.println(blueColor + "\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");

        //LOGIN

        while (intentos < 3) {
            System.out.print(yellowColor + "Ingrese el correo electronico: ");
            correoDigitadoUsuario = keyEntry.nextLine();

            System.out.print("Ingrese el nombre de usuario: ");
            nombreUsuarioDigitadoUsuario = keyEntry.nextLine();

            System.out.print("Ingrese la contraseña: ");
            contrasenaDigitadaUsuario = keyEntry.nextLine();

            if (correoDigitadoUsuario.equals(correoGuardadoBaseDatos) &&
                    nombreUsuarioDigitadoUsuario.equals(nombreUsuarioGuardadoBaseDatos) &&
                    contrasenaDigitadaUsuario.equals(contrasenaGuardadaBaseDatos)) {

                System.out.println(greenColor + "Acceso permitido");
                break;
            } else {
                intentos++;
                System.out.println(purpleColor + "Acceso no permitido, " + intentos + " de 3");
            }
            if (intentos.equals(3)) {
                System.out.println(redColor + "¡ACCESO DENEGADO!, NO LE QUEDAN MAS INTENTOS");
                return;
            }
        }


        System.out.println(blueColor + "***************************************************************************");
        boolean primeraVez = true;
        do {
            try {
                if (primeraVez) {
                    System.out.println(greenColor + "👕 Bienvenido a gestor de prendas...\n");
                    primeraVez = false;
                }
                System.out.println(greenColor + "¿Qué quieres realizar?\n");
                System.out.println("1) Guardar una prenda en BD 📝");
                System.out.println("2) Mostrar el inventario de prendas 📦");
                System.out.println("3) SALIR ❌\n");

                System.out.print(purpleColor + "Digita una opción: ");
                menuOption = keyEntry.nextInt();
                keyEntry.nextLine();


                if (menuOption == 1) {

                    HashMap<String, Object> prendaRopa = new HashMap<>();
                    System.out.print("¿Que prenda desea guardar?: ");
                    prendaRopa.put("Nombre de la prenda: ", keyEntry.nextLine().trim());

                    System.out.print("¿Cual es la talla de la prenda? (S/M/L/XL): ");
                    prendaRopa.put("Talla de la prenda: ", keyEntry.nextLine().trim());

                    int precio = 0;
                    boolean precioValido = false;
                    do {
                        try {
                            System.out.print("¿Cuál es el precio de la prenda?: ");
                            precio = Integer.parseInt(keyEntry.nextLine().trim());
                            precioValido = true;
                        } catch (NumberFormatException e) {
                            System.out.println(redColor + "¡PRECIO INVALIDO. DEBE INGRESAR UN NUMERO ENTERO!.");
                        }
                    } while (!precioValido);
                    prendaRopa.put("Precio de la prenda: ", precio);

                    prendasRopas.add(prendaRopa);
                    System.out.println(yellowColor + "La prenda de ropa se guardo correctamente");
                    System.out.println(prendasRopas);

                } else if (menuOption == 2) {
                    //implementar algoritmo para recorrer y mostrar la lista en el formato pedido
                    System.out.println(blueColor + "\nINVENTARIO DE PRENDAS");
                    for (HashMap<String, Object> prendaRopa : prendasRopas) {
                        System.out.printf(whiteColor + "- %10s | %-3s | $%s%n",
                                prendaRopa.get("Nombre de la prenda: "),
                                prendaRopa.get("Talla de la prenda: "),
                                prendaRopa.get("Precio de la prenda: ")
                        );
                    }
                    } else if (menuOption == 3) {
                        //implementar algoritmo para cerrar el programa
                    System.out.println(blueColor + "¡HASTA LA PROXIMA! 👋");
                        break;
                    } else {
                        System.out.println(redColor + "¡OPCION NO VALIDA, SELECCIONA LA OPCION DEL 1 AL 3!");
                    }

                    if (menuOption != null && menuOption != 5) {
                        System.out.print("\nPresiona ENTER para continuar...");
                        keyEntry.nextLine();
                        System.out.println();
                    }

                } catch(InputMismatchException ex){
                    System.out.println(redColor + "Entrada inválida. Debes digitar un número (1-5).");
                    keyEntry.nextLine();
                    menuOption = -1;
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
                } catch(Exception ex){
                    // Cualquier otra excepción no prevista
                    System.out.println(redColor + "Ups, algo salió mal: " + ex.getMessage());
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
                }

            } while (menuOption == null || menuOption != 5) ;
        keyEntry.close();
        }
    }