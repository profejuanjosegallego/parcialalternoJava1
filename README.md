# 👕 Gestor de Prendas – App en Java

¡Bienvenido!  
Este es un proyecto sencillo desarrollado para **gestionar un inventario de prendas de ropa** desde la consola. Está hecho en **Java puro**, pensado para practicar conceptos básicos sin complicaciones.

---

## 📝 Descripción

La aplicación **Gestor de Prendas** funciona desde la terminal y permite:

- Realizar un **login simulado** (usuario, correo y contraseña).  
- **Guardar prendas** en una lista interna (simulando una base de datos).  
- **Mostrar el inventario** de prendas.  
- Utilizar **colores ANSI** para hacer la experiencia más visual (verde = OK, rojo = error, amarillo = listado).

Es una excelente práctica para manejo de inputs, control de errores, listas, ciclos y excepciones en Java.

---

## ✨ Funcionalidades

### 🔐 Login inicial  
Al iniciar, la app solicita:  
- Nombre de usuario  
- Correo  
- Contraseña  

(No valida datos, solo simula autenticación.)

### 📌 Menú principal  
Incluye 3 opciones:

1. **Guardar una prenda**  
   - Pide nombre, talla (S/M/L/XL) y precio (número entero).  
   - Se agrega a un `ArrayList`.  

2. **Mostrar inventario**  
   - Muestra cada prenda en formato:  
     **Nombre | Talla | $Precio**  
   - Si no hay prendas, lo indica.

3. **Salir**  
   - Cierra el programa.

### ⚠️ Manejo de errores  
- Si el usuario ingresa un precio inválido o una opción inexistente, la app muestra un mensaje rojo y permite intentar de nuevo.

### 🎨 Interfaz amigable  
- Colores ANSI para una consola más clara.  
- Pausas con ENTER para no saturar la terminal.

---

## 🛠️ Correcciones Realizadas

Al revisar la versión inicial del código, se corrigieron varios puntos para que funcionara adecuadamente:

### ✔ Imports faltantes  
- Se agregó `InputMismatchException`.  
- Se eliminó `Color.GREEN` ya que generaba errores y se reemplazó por códigos ANSI.

### ✔ Variables mal usadas  
- `nextLine()` sin objeto → reemplazado por `keyEntry.nextLine()`.  
- Uso de `sc` cuando no existía → corregido por `keyEntry`.

### ✔ Colores no definidos  
- Se definieron `RED` y `YELLOW` con códigos ANSI.  
- `GREEN` se manejó como `String` para evitar errores.

### ✔ Manejo de excepciones  
- Ajustado para evitar bloqueos.  
- Se corrigió la condición del ciclo: las opciones iban hasta 3, no hasta 5.

### ✔ Implementación exacta de los comentarios  
- Se añadió:  
  - Lógica de login  
  - Lista de inventario (`ArrayList`)  
  - Lógica de salida  

### ✔ Limpieza general  
- Código ordenado  
- Eliminación de duplicados  
- Correcciones de sintaxis  
- Se mantuvo la estructura original

**Resultado:** ahora el programa compila perfectamente y cumple con lo solicitado.

---

## 🚀 Cómo Ejecutar

1. Asegúrate de tener **Java 8 o superior** instalado.  
2. Ubica el archivo en la siguiente ruta:  
   ```
   org/example/Main.java
   ```
3. Compila:  
   ```
   javac org/example/Main.java
   ```
4. Ejecuta:  
   ```
   java org.example.Main
   ```
5. ¡Listo! Sigue las instrucciones del programa.

### 💡 Si usas un IDE (IntelliJ, Eclipse, VS Code):
- Crea un nuevo proyecto  
- Copia el archivo `Main.java`  
- Ejecuta desde el botón "Run"

---

## 📘 Explicación del Código

- El programa inicia en `main`, donde se crea el `Scanner` para leer la entrada del usuario y una lista para guardar prendas.  
- Primero realiza el **login** solicitando tres datos simples.  
- Luego entra en un **bucle con menú**, que se repite hasta que el usuario elige salir.  
- Cada opción tiene su propia lógica:
  - **Agregar prenda:** solicita datos y los guarda.  
  - **Mostrar inventario:** recorre la lista con un `for-each`.  
  - **Salir:** rompe el ciclo.  
- Los `try/catch` evitan que el programa reviente por entradas inválidas.  
- Los colores ANSI hacen que la consola sea más legible.

Todo es 100% Java estándar, ideal para aprendizaje.

---
