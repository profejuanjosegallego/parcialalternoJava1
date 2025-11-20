# 👕 Gestor de Prendas en Java

Proyecto desarrollado en **Java** que implementa un pequeño sistema de gestión de prendas con **autenticación**, manejo de estructuras de datos dinámicas y una interfaz de consola amigable con el usuario mediante el uso de **colores ANSI** 🎨.

---

## 🚀 Descripción General

Este programa permite gestionar un inventario de prendas de vestir desde la consola, ofreciendo funcionalidades de **registro**, **visualización** y **validación** de datos.

Se mejoró el código original aplicando buenas prácticas de programación y estructuras de datos eficientes.  
El sistema cuenta con un **inicio de sesión seguro** (con tres intentos permitidos) y un **menú interactivo** que guía al usuario durante toda la ejecución.

---

## 🧠 Mejoras realizadas

Durante la corrección y refactorización del código, se implementaron las siguientes mejoras:

### 🧩 Estructura y Lógica
- ✅ Se incorporó un **`ArrayList`** para almacenar múltiples prendas dinámicamente.
- ✅ Se utilizó un **`HashMap<String, Object>`** (diccionario) para guardar la información de cada prenda (nombre, talla, precio).
- ✅ Se implementó un ciclo **`for-each`** para recorrer la lista de prendas y mostrar los datos en **formato tabular**:
  - Columnas: **Nombre**, **Talla**, **Precio**.
  - Ejemplo:
    ```
    -  Camiseta | M   | $45000
    -      Jean | L   | $120000
    ```

### 🎨 Interfaz de Consola
- Se añadieron **colores ANSI** para resaltar los mensajes y mejorar la experiencia visual:
  - 🟩 Verde → Éxito / Acceso permitido.
  - 🟨 Amarillo → Mensajes informativos.
  - 🟥 Rojo → Errores o validaciones fallidas.
  - 🟪 Morado → Solicitud de opciones o advertencias.
  - 🟦 Azul → Encabezados y separación visual.

### ⚙️ Validaciones y control de errores
- Se corrigieron errores de **sintaxis** y **nombres de variables** mal definidos.
- Se manejaron excepciones como:
  - `InputMismatchException` → cuando el usuario ingresa letras en lugar de números.
  - `NumberFormatException` → al ingresar texto en el campo de precio.
- Se implementaron mensajes personalizados para guiar al usuario durante la interacción.

### 🔐 Sistema de Login
- Se agregó un **inicio de sesión** con validación de:
  - Correo electrónico
  - Nombre de usuario
  - Contraseña
- Se permite un máximo de **3 intentos**, tras los cuales el sistema bloquea el acceso.

---

## 🧮 Funcionalidades principales

| Opción | Descripción |
|--------|--------------|
| **1️⃣ Guardar una prenda** | Permite ingresar el nombre, talla y precio (validando que sea numérico). |
| **2️⃣ Mostrar inventario** | Muestra todas las prendas registradas usando un formato tabular legible. |
| **3️⃣ Salir** | Finaliza la ejecución mostrando un mensaje de despedida. |

---

## 💻 Tecnologías utilizadas

- ☕ **Java SE 17+**
- 🧰 **Colecciones de Java** (`ArrayList`, `HashMap`)
- 🧠 **Control de excepciones**
- 🎨 **ANSI Escape Codes** (para colores en consola)

---

## 🧩 Ejemplo de ejecución

```text
******************
***** APP *****
******************
Ingrese el correo electrónico: alejandro@gmail.com
Ingrese el nombre de usuario: alejandro
Ingrese la contraseña: 12345
Acceso permitido

👕 Bienvenido a gestor de prendas...

¿Qué quieres realizar?

1) Guardar una prenda en BD 📝
2) Mostrar el inventario de prendas 📦
3) SALIR ❌

Digita una opción: 1
¿Que prenda desea guardar?: Camiseta
¿Cual es la talla de la prenda? (S/M/L/XL): M
¿Cuál es el precio de la prenda?: 45000
✅ La prenda de ropa se guardó correctamente

---

## 👨‍💻 Autor

**Desarrollado por:** [Alejandro Meneses García](https://github.com/AmGa373)  
📍 *Medellín, Antioquia - Colombia 🇨🇴*  
💬 *“Cada error es una oportunidad de aprender algo nuevo. ¡NO RENDIRSE!”*
