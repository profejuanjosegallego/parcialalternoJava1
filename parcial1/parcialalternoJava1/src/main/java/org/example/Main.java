package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menudeopcion = null;


        // Implementa lógica para login con:
        // - nombre usuario
        // - correo
        // - contraseña

        ArrayList<HashMap<String,Object>>prendas = new ArrayList<>();

        HashMap<String,Object> prendas1 = new HashMap();

        prendas1.put("nombre","saco");
        prendas1.put("talla","M");
        prendas1.put("precio",1000);
        prendas.add(prendas1);



        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = keyEntry.nextLine();
        System.out.print("ingrese su contraseña de usuario");
        String contraseña = keyEntry.nextLine();
        System.out.print("Ingrese su email: ");
        String email = keyEntry.nextLine();
        System.out.print(prendas);
        System.out.println("Su nombre es: " + nombreUsuario);
        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");

        do {
            try {
                System.out.println("👕 Bienvenido a gestor de prendas...\n¿Qué quieres realizar?\n");
                System.out.println("1) Guardar una prenda en BD 📝");
                System.out.println("2) Mostrar el inventario de prendas 📦");
                System.out.println("3) SALIR ❌\n");

                System.out.print("Digita una opción: ");
                menudeopcion = keyEntry.nextInt();
                keyEntry.nextLine();

                if (menudeopcion == 1) {
                    try {
                        System.out.print("Nombre de la prenda: ");
                        String nombre = keyEntry.nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = keyEntry.nextLine();

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(keyEntry.nextLine().trim());

                        System.out.println("colorverde" + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);
                    } catch (NumberFormatException e) {
                        System.out.println("colorrojjo" + "Precio inválido. Debe ser un número entero.");
                    }
                } else if (menudeopcion == 2) {
                    // Implementar algoritmo para recorrer y mostrar la lista en el formato pedido
                    System.out.println("coloramarillo" + "📋 Inventario (demo):");
                    System.out.println("- Camiseta | M | $45000");
                    System.out.println("- Jean     | L | $120000");
                    System.out.println(prendas);

                } else if (menudeopcion == 3) {
                    System.out.println("colorgris" + "Saliendo del programa... Hasta luego!");
                    break;
                } else {
                    System.out.println("colorrojo" + "Opción no válida. Prueba con un número del 1 al 3.");
                }

                if (menudeopcion != null && menudeopcion != 3) {
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
                }

            } catch (InputMismatchException ex) {
                System.out.println("colorrojo" + "Entrada inválida. Debes digitar un número (1-3).");
                keyEntry.nextLine();
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            } catch (Exception ex) {
                // Cualquier otra excepción no prevista
                System.out.println("colorrojo" + "Ups, algo salió mal: " + ex.getMessage());
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            }

        } while (true);
        keyEntry.close();

    }
}

