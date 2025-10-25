package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer Menuopcion=null;
        String GreenColor="\u001B[32m";
        String RedColor = "\u001B[31m";
        String YellowColor = "\u001B[33m";



        //implementa logica para login con:
        //-nombre usuario
        //-correo
        //-contraseña

        String Nombreusuario = "juan";
        String Correo = "j123@gmail.com";
        String Contrasena = "123";


        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");



                        while (true) {


                            System.out.println("Ingrese Nombre de usuario:");
                            String Usuarioingresado = keyEntry.nextLine();

                            System.out.println("Ingrese su correo electrónico:");
                            String Correoingresado = keyEntry.nextLine();

                            System.out.println("Ingrese contraseña:");
                            String Contrasenaingresada = keyEntry.nextLine();



                            if (Usuarioingresado.equals(Nombreusuario) && Correoingresado.equals(Correo) && Contrasenaingresada.equals(Contrasena)) {
                                do {
                                    try {

                                        System.out.println("👕 Bienvenido a gestor de prendas...\n¿Qué quieres realizar?\n");
                                        System.out.println(GreenColor + "1) Guardar una prenda en BD 📝");
                                        System.out.println("2) Mostrar el inventario de prendas 📦");
                                        System.out.println("3) SALIR ❌\n");

                                        System.out.print("Digita una opción: ");
                                        Menuopcion = keyEntry.nextInt();
                                        keyEntry.nextLine();


                                        if (Menuopcion == 1) {
                                            try {
                                                System.out.print("Nombre de la prenda: ");
                                                String nombre = keyEntry.nextLine();

                                                System.out.print("Talla (S/M/L/XL): ");
                                                String talla = keyEntry.nextLine();


                                                System.out.print("Precio (entero): ");
                                                int precio = keyEntry.nextInt();


                                                System.out.println(GreenColor + "✅ Prenda guardada: " + nombre + "\n" + " Talla : "
                                                        + talla + "\n" + " Precio $" + precio +"\n");
                                            } catch (NumberFormatException e) {
                                                System.out.println(RedColor + "Precio inválido. Debe ser un número entero.");
                                            }
                                        } else if (Menuopcion == 2) {


                                            List<Map<String, Object>> inventario = new ArrayList<>();

                                            Map<String, Object> prenda1 = new HashMap<>();
                                            prenda1.put("nombre", "Camiseta");
                                            prenda1.put("talla", "M");
                                            prenda1.put("precio", 45000);
                                            inventario.add(prenda1);

                                            Map<String, Object> prenda2 = new HashMap<>();
                                            prenda2.put("nombre", "Jean");
                                            prenda2.put("talla", "L");
                                            prenda2.put("precio", 120000);
                                            inventario.add(prenda2);

                                            System.out.println(YellowColor + "📋 Inventario REAL:" );
                                            for (Map<String, Object> prenda : inventario) {
                                                System.out.println(prenda.get("nombre"));
                                                System.out.println("Talla : " + prenda.get("talla"));
                                                System.out.println("Precio : $" + prenda.get("precio"));
                                                System.out.println();
                                            }


                                        } else if (Menuopcion == 3) {

                                            break;
                                        } else {
                                            System.out.println(RedColor + "Opción no válida. Prueba con un número del 1 al 3.");
                                        }
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }

                                } while (Menuopcion == null || Menuopcion != 4);

                            }



                        }



           

    }
}