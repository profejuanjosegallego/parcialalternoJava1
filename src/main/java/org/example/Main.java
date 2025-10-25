package org.example;

import java.util.*;
import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) {

        //implementa logica para login con:
        //-nombre usuario
        //-correo
        //-contraseña

        String usuarioBD= "Ad";
        String usuario;
        String correoBD = "ad@gmail.com";
        String correo;
        String contraseñaBD = "123A";
        String contraseña;

        Scanner keyEntry = new Scanner(System.in);

        System.out.println("Ingrese el Usuario: ");
        usuario = keyEntry.next();
        System.out.println("Ingrese el Correo: ");
        correo = keyEntry.next();
        System.out.println("Ingrese la Contraseña: ");
        contraseña = keyEntry.next();

        Integer menuOption = 0;

        String greenColor="\u001B[32m";
        String redColor="\u001B[31m";
        String yellowColor="\u001B[33m";

        ArrayList<HashMap<String, Object>> prendas = new ArrayList<>();


        if (usuario.equals(usuarioBD) && correo.equals(correoBD) && contraseña.equals(contraseñaBD)){

            System.out.println("\n******************");
            System.out.println("***** APP *****");
            System.out.println("******************");

            do {
                try {

                    System.out.println("👕 Bienvenido a gestor de prendas...\n¿Qué quieres realizar?\n");
                    System.out.println("1) Guardar una prenda en BD 📝");
                    System.out.println("2) Mostrar el inventario de prendas 📦");
                    System.out.println("3) SALIR ❌\n");
                    {
                    }

                    System.out.print("Digita una opción: ");
                    menuOption = keyEntry.nextInt();
                    keyEntry.nextLine();


                    if (menuOption == 1) {
                        HashMap<String, Object> prenda = new HashMap<>();
                        try {
                            System.out.print("Nombre de la prenda: ");
                            String nombre = keyEntry.nextLine();

                            System.out.print("\nTalla (S/M/L/XL): ");
                            String talla = keyEntry.nextLine();

                            System.out.print("\nPrecio (entero): ");
                            Integer precio = keyEntry.nextInt();

                            prenda.put("nombre", nombre);
                            prenda.put("talla", talla);
                            prenda.put("precio", precio);

                            prendas.add(prenda);

                            System.out.println(greenColor + "✅ Prenda guardada: " + nombre + "|" + talla + " | $" + precio);

                        } catch (NumberFormatException e) {
                            System.out.println(redColor + "Precio inválido. Debe ser un número entero.");
                        }

                    }else if (menuOption == 2) {

                            //implementar algoritmo para recorrer y mostrar la lista en el formato pedido
                            System.out.println(yellowColor + "📋 Inventario:");
                            if (prendas.isEmpty()) {

                            }else {
                                for (HashMap<String,Object>prenda : prendas) {

                                    String nombre = (String) prenda.get("nombre");
                                    String talla = (String) prenda.get("talla");
                                    Integer precio = (Integer) prenda.get("precio");
                                    System.out.println("* " +"Prenda: " + nombre + " | Talla: " + talla + " | Precio: $" + precio);

                                }
                            }


                    }else if (menuOption == 3) {
                        //implementar algoritmo para cerrar el programa
                        System.out.println("Hasta pronto");
                        break;

                    } else {
                        System.out.println(redColor + "Opción no válida.");
                    }

                } catch (InputMismatchException ex) {
                    System.out.println(redColor + "Entrada inválida.");
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

            }while (true) ;

        }else{
            System.out.println("Intente nuevamente ❌");

            }
        }
    }