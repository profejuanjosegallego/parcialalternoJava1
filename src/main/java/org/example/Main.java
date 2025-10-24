import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption = null;
        String greenColor = "\u001B[32m";
        String redColor = "\u001B[31m";
        String yellowColor = "\u001B[33m";

        do {
            try {
                System.out.println("👕 Bienvenido a gestor de prendas...\n¿Qué quieres realizar?\n");
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
                        int precio = Integer.parseInt(keyEntry.nextLine().trim());

                        System.out.println(greenColor + "✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);
                    } catch (NumberFormatException e) {
                        System.out.println(redColor + "Precio inválido. Debe ser un número entero.");
                    }
                } else if (menuOption == 2) {
                    System.out.println(yellowColor + "📋 Inventario (demo):");
                    System.out.println("- Camiseta | M | $45000");
                    System.out.println("- Jean     | L | $120000");
                } else if (menuOption == 3) {
                    System.out.println("Gracias por usar el sistema. Cerrando...");
                    break;
                } else {
                    System.out.println(redColor + "Opción no válida. Prueba con un número del 1 al 3.");
                }

                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();

            } catch (InputMismatchException ex) {
                System.out.println(redColor + "Entrada inválida. Debes digitar un número (1-3).");
                keyEntry.nextLine();
                menuOption = -1;
            } catch (Exception ex) {
                System.out.println(redColor + "Ups, algo salió mal: " + ex.getMessage());
                keyEntry.nextLine();
            }

        } while (menuOption == null || menuOption != 3);
    }
}
