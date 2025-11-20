# Cambios realizados al código

```diff
+ import java.util.InputMismatchException;
+ import java.util.Scanner;

- Scanner keyEntry
+ Scanner entradaTeclado

- Integer menuOption
+ Integer opcionMenu

+ String VERDE = "\u001B[32m";
+ String ROJO = "\u001B[31m";
+ String AMARILLO = "\u001B[33m";
+ String RESET = "\u001B[0m";

+ String usuarioCorrecto = "Lyon-777";
+ String correoCorrecto = "elevenpt3@gmail.com";
+ String contrasenaCorrecta = "1234";
+ String usuarioIngresado, contrasenaIngresada, correoIngresado;

+ System.out.println("\n===== LOGIN =====");
+ System.out.print("Ingresa tu usuario: ");
+ usuarioIngresado = entradaTeclado.nextLine();
+ System.out.println("Ingresa tu correo: ");
+ correoIngresado = entradaTeclado.nextLine();
+ System.out.print("Ingresa tu contraseña: ");
+ contrasenaIngresada = entradaTeclado.nextLine();

+ if (!usuarioIngresado.equals(usuarioCorrecto) ||
+     !contrasenaIngresada.equals(contrasenaCorrecta) ||
+     !correoIngresado.equals(correoCorrecto)) {
+     System.out.println(ROJO + "❌ Usuario o contraseña incorrectos." + RESET);
+     return;
+ }
+ System.out.println(VERDE + "✔ Acceso permitido. ¡Bienvenido!" + RESET);

- System.out.println(GREEN + "1) Guardar una prenda en BD 📝");
+ System.out.println(VERDE + "1) Guardar una prenda 📝");
+ System.out.println("2) Mostrar inventario 📦");
+ System.out.println("3) Salir ❌" + RESET);

+ entradaTeclado.nextLine(); // Limpia el buffer

+ System.out.println(VERDE + "✔ Prenda guardada: " + nombrePrenda + " - " + talla + " - $" + precio + RESET);
+ System.out.println(ROJO + "❌ Error: El precio debe ser un número entero." + RESET);
+ System.out.println(ROJO + "⚠ Opción no válida. Ingresa un número del 1 al 3." + RESET);
+ System.out.println(VERDE + "👋 Saliendo del programa..." + RESET);
+ System.out.print("\nPresiona ENTER para continuar...");

- while (menuOption == null || menuOption != 5);
+ while (opcionMenu == null || opcionMenu != 3);
