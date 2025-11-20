# 👕 Sistema de Inventario de Prendas – Proyecto Mejorado

Este proyecto incluye mejoras importantes en la estructura del programa, nuevas funciones y correcciones generales para lograr un funcionamiento más estable y completo.

---

## 🔐 Login Implementado

Se añadió un sistema básico de **inicio de sesión** para controlar el acceso antes de ingresar al menú principal.

Características:
- Solicitud de usuario y contraseña  
- Validación de credenciales  
- Mensajes claros en caso de error  
- Reintentos permitidos  
- Acceso denegado si la autenticación falla

---

## 🛠️ Corrección de Errores de Sintaxis

Durante la actualización del proyecto, se corrigieron varios errores que impedían su ejecución correcta:

- Llaves mal organizadas  
- Sentencias sin cerrar  
- Tipos de datos incorrectos  
- Variables sin inicializar  
- Problemas en la lectura de datos con Scanner  

✔ El programa ahora compila y corre sin fallos inesperados.

---

## 🔄 Restauración de Clases No Utilizadas

Había clases creadas en el proyecto pero sin funcionalidad o conexión con el flujo principal.  
Se realizó lo siguiente:

- Se revisaron las clases existentes  
- Se restableció su funcionalidad  
- Se conectaron de nuevo al programa principal  
- Se eliminaron elementos duplicados o innecesarios  

🏗️ Ahora todas las clases cumplen un propósito dentro del sistema.

---

## 📋 Lista Funcional de Prendas

Se creó y mejoró una lista dinámica (`ArrayList<HashMap<String, Object>>`) que permite:

- Agregar prendas ingresadas por el usuario  
- Guardar nombre, talla y precio  
- Validar entradas numéricas  
- Evitar errores cuando el usuario ingresa letras en vez de números  
- Mostrar el inventario en formato organizado  

### 🔎 Búsqueda por Preferencias del Usuario

El sistema ahora permite filtrar prendas dependiendo de lo que el usuario quiera ver:

- Por nombre  
- Por talla  
- Por rango de precio  
- O visualizar todas  

🧵 Esto hace el inventario mucho más útil y flexible.

---

## 🚀 Estado Actual del Proyecto

El sistema es completamente funcional y permite:
- Iniciar sesión  
- Registrar prendas  
- Mostrar el inventario  
- Listar prendas según preferencia del usuario  
- Manejar errores de entrada  
- Salir del programa correctamente  

---

## 👨‍💻 Autor

Proyecto creado y mejorado por: **Jeisson Yela**  
💼 Tecnología usada: Java + IntelliJ IDEA  

---
