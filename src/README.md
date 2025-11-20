# Gestor de Prendas — Informe de Correcciones

Este documento describe **todas las correcciones, mejoras y refactorizaciones** realizadas sobre el código original entregado por el profesor. El objetivo es dejar constancia detallada de los errores detectados y las soluciones implementadas.

---

## 📌 1. Descripción del proyecto
Aplicación en Java que permite:

- Realizar un **login** con usuario, correo y contraseña.
- Gestionar un inventario real de prendas.
- Registrar nuevas prendas (nombre, talla y precio).
- Visualizar el inventario dinámicamente.
- Controlar intentos fallidos de inicio de sesión.

---

## 📌 2. Errores encontrados en el código original

### 🔴 2.1 Errores de compilación
- Uso de constantes inexistentes (`GREEN`, `RED`, `YELLOW`).
- Variables no declaradas (`sc`, `nextLine()` sin objeto Scanner).
- Falta de importaciones necesarias (`Scanner`, `InputMismatchException`).
- Código incompleto en varias partes (login ausente, menú incompleto).
- Uso incorrecto de `nextInt()` sin limpieza del buffer.

### 🔴 2.2 Errores de lógica
- El menú comparaba `menuOption != 5` aun cuando la opción “5” no existía.
- No existía estructura para almacenar prendas.
- El inventario mostrado era estático y no dependía de datos reales.
- La opción de salir no cerraba realmente el programa.

### 🔴 2.3 Problemas de interacción
- No había sistema de intentos en el login.
- Flujo inconsistente en el menú.
- No había confirmación de acciones ni pausas entre pantallas.

### 🔴 2.4 Malas prácticas
- Nombres incorrectos (`reed` en vez de `red`, colores sin convención).
- Constantes ANSI mal aplicadas.
- Falta de indentación consistente.
- Manejo deficiente de excepciones.

---

## 📌 3. Correcciones aplicadas

### 🟢 3.1 Sintaxis y estructura
- Declaración apropiada de variables y colores ANSI.
- Inclusión de importaciones necesarias.
- Limpieza de código redundante o incorrecto.

### 🟢 3.2 Login completo
- Implementación de login con usuario, correo y contraseña.
- Control de intentos (máximo 4).
- Mensajes claros de error y bienvenida.
- Validación correcta contra datos almacenados.

### 🟢 3.3 Manejo de excepciones
- Manejo adecuado de `InputMismatchException`.
- Limpieza del buffer tras leer enteros.
- Control centralizado de excepciones generales.

### 🟢 3.4 Inventario funcional
- Implementada lista `ArrayList<HashMap<String, Object>>`.
- Registro real de prendas desde consola.
- Formato solicitado para mostrar inventario.
- Validación del precio como número entero.

### 🟢 3.5 Mejoras en la experiencia del usuario
- Uso correcto de colores ANSI.
- Mensajes explicativos y amigables.
- Pausas con ENTER entre acciones.
- Flujo del menú corregido.

---

