# 🧵 Sistema de Login y Gestión de Prendas

Este proyecto contiene una versión corregida y mejorada de un sistema que incluye:

- Implementación de un **login** utilizando un bucle `while` y condicionales.  
- Corrección de diversos **errores de sintaxis** encontrados en la versión original.  
- Creación de un **diccionario de prendas** usando `ArrayList` y `HashMap` para una mejor organización de datos.  
- Incorporación de una **salida del programa con confirmación** para evitar cierres accidentales.  

---

## 🚀 Características principales

### 🔐 Inicio de sesión
- Uso de un bucle `while` para validar credenciales.
- Comparación de usuario y contraseña con respuesta adecuada.
- Reintentos hasta que se ingrese la información correcta.

### 🧺 Gestión de prendas
- Implementación de un **HashMap** donde cada categoría contiene un `ArrayList` de prendas.
- Permite agregar, listar y organizar las prendas de forma más estructurada.

**Ejemplo de estructura en Java:**

```java
HashMap<String, ArrayList<String>> prendas = new HashMap<>();



