🧵 🎂🎂🎂🎂🎂🌹🌹🌹🌹🌹🌹🐱‍👤🐱‍👤🐱‍👤🐱‍👤🐱‍👤🤳🤳🤳🤳🤳

Sistema de Login y Gestor de Prendas

Proyecto desarrollado en Java utilizando IntelliJ IDEA como entorno de trabajo.
Hace parte de un examen práctico donde se evalúan conceptos fundamentales como manejo de estructuras de datos, control de flujo, validación de entradas, manejo de excepciones y creación de un menú interactivo.

Descripción del Proyecto

Este programa combina dos funcionalidades principales:

1. Sistema de Login

El sistema contiene un pequeño arreglo de usuarios construido mediante una ArrayList de HashMaps, donde cada usuario tiene:

nombre

correo

contraseña

El programa solicita los datos al usuario y valida si coinciden con alguno de los registros almacenados.

Si las credenciales no son correctas → acceso denegado.
Si el login es correcto → se habilita el acceso al menú principal.

2. Gestor de Prendas (mini inventario)

Después del login se muestra un menú con tres opciones:

Guardar una prenda

Solicita nombre, talla y precio.

Valida que el precio sea un número entero.

Simula el guardado mostrando la prenda registrada.

Mostrar inventario

Muestra dos prendas de ejemplo como demostración.

Salir

Finaliza el programa correctamente.

El menú utiliza manejo de excepciones con:

InputMismatchException para capturar errores cuando el usuario digita letras en vez de números.

Validaciones personalizadas para evitar fallos en tiempo de ejecución.

Conceptos Aplicados

Este proyecto integra conocimientos clave de Java:

Declaración de clases y métodos (public static void main)

🎇 Estructuras de datos:

ArrayList

HashMap

Validación de datos

Condicionales (if, else, else if)

Ciclos repetitivos (do-while)

Manejo de excepciones (try-catch)

Uso de Scanner para entrada desde consola

Control del flujo del programa con retornos y menús interactivos
 
🤷‍♂️ Estructura General del Código

Creación de una lista de usuarios predefinidos

Validación de login

Construcción del menú interactivo

Registro de prendas

Inventario de demostración

Salida controlada del sistema

▶ Cómo ejecutar el programa

Abrir el proyecto en IntelliJ IDEA

Asegurarse de tener instalado un JDK 17 o superior

Ejecutar la clase Main

Ingresar credenciales válidas, por ejemplo:

Nombre: Carlos

Correo: carlos@zoo.com

Contraseña: 1234

Navegar por el menú con las opciones 1, 2 y 3.

Requisitos del Entorno

Java JDK (versión 17 recomendada, aunque está instalada en mi pc la 25)

IntelliJ IDEA es el entorno de desarrollo

Consola interactiva habilitada

Al final podría

👏👏👏💌 Conceptos aplicados:

Validación de usuarios

Captura de entrada

Menús interactivos

Organización modular del código
