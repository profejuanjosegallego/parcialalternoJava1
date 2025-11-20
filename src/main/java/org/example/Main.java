package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ArrayList<HashMap<String, String>> usuarios = new ArrayList<>();

        HashMap<String, String> u1 = new HashMap<>();
        u1.put("nombre", "Carlos");
        u1.put("correo", "carlos@zoo.com");
        u1.put("password", "1234");

        HashMap<String, String> u2 = new HashMap<>();
        u2.put("nombre", "Maritza");
        u2.put("correo", "maritza@zoo.com");
        u2.put("password", "abcd");

        HashMap<String, String> u3 = new HashMap<>();
        u3.put("nombre", "Sofia");
        u3.put("correo", "sofia@zoo.com");
        u3.put("password", "pass123");

        HashMap<String, String> u4 = new HashMap<>();
        u4.put("nombre", "Luis");
        u4.put("correo", "luis@zoo.com");
        u4.put("password", "zoo2024");

        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        usuarios.add(u4);

        System.out.println("===== SISTEMA DE LOGIN =====");

        System.out.print("Nombre: ");
        String nombreIngresado = entrada.nextLine();

        System.out.print("Correo: ");
        String correoIngresado = entrada.nextLine();

        System.out.print("Contraseña: ");
        String passIngresado = entrada.nextLine();

        boolean loginExitoso = false;

        for (HashMap<String, String> u : usuarios) {
            if (u.get("nombre").equalsIgnoreCase(nombreIngresado)
                    && u.get("correo").equalsIgnoreCase(correoIngresado)
                    && u.get("password").equals(passIngresado)) {

                loginExitoso = true;
                break;
            }
        }

        if (!loginExitoso) {
            System.out.println("Datos incorrectos. Acceso denegado.");
            return;
        }

        System.out.println("Login exitoso. Bienvenido(a).");

        Integer menuOption = null;

        do {
            try {
                System.out.println("\n******************");
                System.out.println("*****  APP  *****");
                System.out.println("******************");

                System.out.println("Bienvenido al gestor de prendas");
                System.out.println("Seleccione una opción:\n");
                System.out.println("1) Guardar una prenda");
                System.out.println("2) Mostrar inventario");
                System.out.println("3) Salir\n");

                System.out.print("Digite una opción: ");
                menuOption = entrada.nextInt();
                entrada.nextLine();

                if (menuOption == 1) {

                    try {
                        System.out.print("Nombre de la prenda: ");
                        String nombre = entrada.nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = entrada.nextLine();

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(entrada.nextLine().trim());

                        System.out.println("Prenda guardada: "
                                + nombre + " - " + talla + " - $" + precio);

                    } catch (NumberFormatException e) {
                        System.out.println("Error: el precio debe ser un número entero.");
                    }

                } else if (menuOption == 2) {

                    System.out.println("Inventario (demo):");
                    System.out.println("- Camiseta | M | $45000");
                    System.out.println("- Jean     | L | $120000");

                } else if (menuOption == 3) {

                    System.out.println("Saliendo del sistema...");

                } else {
                    System.out.println("Opción no válida. Debe ser un número entre 1 y 3.");
                }

                if (menuOption != 3) {
                    System.out.print("\nPresione ENTER para continuar...");
                    entrada.nextLine();
                }

            } catch (InputMismatchException ex) {
                System.out.println("Error: Debe digitar un número (1-3).");
                entrada.nextLine();
                menuOption = -1;

                System.out.print("\nPresione ENTER para continuar...");
                entrada.nextLine();

            } catch (Exception ex) {
                System.out.println("Ocurrió un error: " + ex.getMessage());
                System.out.print("\nPresione ENTER para continuar...");
                entrada.nextLine();
            }

        } while (menuOption != 3);

        entrada.close();
    }
}