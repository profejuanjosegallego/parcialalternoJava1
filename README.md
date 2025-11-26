# 🧵 Gestor de Prendas en Java
Aplicación de consola para registro, autenticación e inventario de prendas.

---

## 📌 Descripción General
Este proyecto consiste en un sistema desarrollado en **Java** que permite:

- Registrar un usuario (nombre, correo y contraseña).
- Validar credenciales mediante un proceso básico de inicio de sesión.
- Gestionar prendas (nombre, talla y precio) en un inventario.
- Mostrar listas de prendas con formato amigable.

El programa está diseñado para ejecutarse en consola y utiliza estructuras como `ArrayList` y `HashMap`.

---

## 🔧 Mejoras Realizadas (Refactor)

### ✅ 1. Corrección de errores de sintaxis
Se corrigieron fallos como:
- Errores en declaraciones de variables.
- Manejo incorrecto del `Scanner`.
- Mal uso de `continue`.
- Condiciones incompletas en el login.

### 🧼 2. Renombrado profesional de variables
Se optimizó la legibilidad cambiando nombres ambiguos por otros más expresivos:

| Antes | Después |
|-------|---------|
| `teclado` | `tecladoDigitadoUsuario` |
| `confirmacionPassword` | `confirmacionContraseniaDeUsuario` |
| `arrayPrendas` | `prendasRopas` |

### 📚 3. Implementación de nuevos ArrayList
Se agregaron hasta **5 listas dinámicas** para almacenar datos y mejorar la flexibilidad del sistema.

### 🔐 4. Validaciones robustas en el login
- Uso de `equalsIgnoreCase()`.
- Control de intentos.
- Manejo de excepciones (`InputMismatchException`, `NumberFormatException`).
- Mensajes de error con colores ANSI.

### 🎨 5. Limpieza general del código
Se implementaron colores en consola para mejorar la experiencia visual:
- ❌ Errores (rojo)
- 📋 Inventario (amarillo)
- ✅ Confirmaciones (verde)

---

## 📦 Inventario
Se utiliza la estructura:

```java
ArrayList<HashMap<String, Object>> prendasRopas = new ArrayList<>();

````
---
> _“Si un perdedor hace muchos esfuerzos, quizá pueda sobrepasar el poder de un guerrero distinguido" ."Son Goku"_ 🐲

![Vamos](https://es.gizmodo.com/app/uploads/2021/12/29a26dde958612e64c40ffd7682440cd.jpg)




