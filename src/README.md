# README – Correcciones y Mejoras del Código

Este documento describe las correcciones, mejoras y cambios aplicados al código original entregado por el profesor para que funcione correctamente.

---

## ✔️ Principales problemas del código original

El código original presentaba varios errores:

- Uso de variables no declaradas (`GREEN`, `RED`, `YELLOW`, `sc`).
- Problemas con `nextLine()` y `nextInt()` (no se limpiaba el buffer).
- Falta de importaciones (`Scanner`, `InputMismatchException`).
- Lógica incompleta en el login.
- Lista de prendas inexistente (solo mostraba datos fijos).
- El menú usaba la opción 5 para salir, pero solo había 3 opciones.
- Estructuras incompletas dentro de los `try` y errores de sintaxis.
- Falta de un sistema real para almacenar prendas.

---

## 🚀 Cambios aplicados al código

### 1. Colores ANSI agregados correctamente

```java
String GREEN = "\u001B[32m";
String YELLOW = "\u001B[33m";
String RED = "\u001B[31m";
String RESET = "\u001B[0m";
