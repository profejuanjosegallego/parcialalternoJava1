# 🧵 Gestor de Prendas

### **Correcciones y mejoras realizadas al código original**

Este documento describe los **errores encontrados en el código original**, las **correcciones aplicadas**, y las **funcionalidades nuevas implementadas** en la versión final del programa.

---

## ✅ **1. Correcciones de errores del código original**

### 🔹 **1.1. Variables inexistentes o mal escritas**

En el código del profesor aparecían variables que **no estaban declaradas**:

* `GREEN`, `RED`, `YELLOW` → No existían como variables.
  ✔️ Solución: Se crearon variables `greenColor`, `redColor` y `yellowColor`.

* `sc` y `next.Line()` → No existían.
  ✔️ Solución: Se reemplazaron por `keyEntry.nextLine()`.

---

### 🔹 **1.2. Excepciones no importadas**

El código usaba `InputMismatchException` sin importarlo.
✔️ Solución: Se agregó el import correspondiente.

---

### 🔹 **1.3. Menú inconsistente**

El código pedía opciones del **1 al 5**, pero solo existían las opciones **1, 2 y 3**.
✔️ Solución: Mensaje corregido para permitir únicamente **1 a 3**.

---

### 🔹 **1.4. Do-while mal configurado**

El ciclo terminaba en `menuOption != 5`, pero la opción **5 no existía**.
✔️ Solución: Se cambió la condición para finalizar correctamente con la opción **3**.

---

### 🔹 **1.5. Código incompleto**

El profesor dejó partes sin implementar:

* Login
* Guardar prenda
* Mostrar inventario
* Salida del programa

✔️ En esta versión, todas fueron implementadas correctamente.

---

## ✨ **2. Funcionalidades nuevas implementadas**

### 🔹 **2.1. Sistema de login funcional**

El programa solicita:

* Nombre de usuario
* Correo
* Contraseña

y compara con valores simulados de una base de datos:

```java
String nombreUsuarioBaseDatos = "Usuario123";
String correoBaseDatos = "correo@example.com";
String contraseñaBaseDatos = "123";
```

✔️ Se agregó un ciclo `while` para repetir el proceso hasta ingresar los datos correctos.

---

### 🔹 **2.2. Sistema para almacenar prendas**

Se creó una estructura dinámica para guardar los elementos:

```java
ArrayList<HashMap<String, Object>> prendas = new ArrayList<>();
```

Cada prenda se almacena con:

* Nombre
* Talla
* Precio

✔️ Ahora el usuario puede guardar múltiples prendas correctamente.

---

### 🔹 **2.3. Mostrar el inventario**

Se implementó la lógica para recorrer la lista y mostrarla:

✔️ Si la lista está vacía → mensaje de aviso
✔️ Si hay prendas → se muestran en formato:

```
- Camiseta | M | $45000
```

---

### 🔹 **2.4. Opción de salida funcional**

La opción **3** finaliza correctamente el programa con:

```
👋 Saliendo del programa...
```

---

## 🛠️ **3. Limpieza y mejoras generales**

* Se añadieron colores para mejorar la interfaz visual.
* Se eliminó código redundante o incompleto.
* Se reorganizó el menú para mayor claridad.

---

## 📌 **4. Resumen de mejoras**

| Aspecto | Estado original | Estado final |
| ---- | ---- | ---- |
| Login | Inexistente | Completamente implementado |
| Guardado de prendas | Parcial, con errores | Funcional y validado |
| Inventario | Estático | Dinámico y ordenado |
| Variables inexistentes | Sí   | Arregladas |
| Flujo del menú | Inconsistente | Estructurado y funcional |
| Colores en consola | Mal implementados | Variables correctas |

---

## 🎉 **Conclusión**

El programa pasó de ser un código incompleto y con múltiples errores, a una aplicación totalmente funcional con:

✔️ Inicio de sesión
✔️ Menú interactivo
✔️ Registro de prendas
✔️ Visualización de inventario
✔️ Flujo adecuado y salida controlada

---
