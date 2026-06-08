# 🌳 Tree-Stock — Sistema de Inventario con Árbol Binario de Búsqueda

**Materia:** Estructuras de Datos  
**Actividad:** EA3 – Actividad Final  
**Estudiante:** María Fernanda Álvarez Ríos  
**Institución:** Institución Universitaria Digital de Antioquia (IU Digital)

---

## 📌 Objetivo

Desarrollar una aplicación de consola en Java que gestione un inventario de productos mediante un **Árbol Binario de Búsqueda (BST)**, implementando manualmente la estructura sin usar colecciones de Java.

---

## 🗂️ Estructura del Proyecto

```
TreeStock/
├── Producto.java         → Clase Nodo (datos + punteros izquierdo/derecho)
├── ArbolInventario.java  → Lógica del BST (insertar, inorden, buscar)
└── Main.java             → Interfaz de usuario (menú switch-case)
```

---

## ⚙️ Instrucciones de Ejecución

### Requisitos
- JDK 17+ (Eclipse Temurin recomendado)
- VS Code con extensión "Extension Pack for Java"

### Pasos

1. Clona el repositorio:
```bash
git clone https://github.com/TU_USUARIO/TreeStock.git
cd TreeStock
```

2. Compila los tres archivos:
```bash
javac Producto.java ArbolInventario.java Main.java
```

3. Ejecuta el programa:
```bash
java Main
```

---

## 🖥️ Capturas de Pantalla de la Ejecución

### Menú principal
```
╔══════════════════════════════════════╗
║     BIENVENIDO A TREE-STOCK v1.0     ║
║   Sistema de Inventario con BST      ║
╚══════════════════════════════════════╝

┌─────────────────────────────────────┐
│           MENÚ PRINCIPAL            │
├─────────────────────────────────────┤
│  1. Registrar Producto              │
│  2. Mostrar Inventario (Inorden)    │
│  3. Buscar Producto                 │
│  0. Salir                           │
└─────────────────────────────────────┘
  Elige una opción:
```

### Inserción de productos
```
  Elige una opción: 1
--- REGISTRAR PRODUCTO ---
  Ingresa el ID del producto: 50
  Ingresa el nombre del producto: Café Premium
  ✔ Producto [ID:50 | Café Premium] registrado con éxito.
```

### Recorrido Inorden (inventario ordenado)
```
  Elige una opción: 2
--- INVENTARIO ORDENADO (Recorrido Inorden) ---
  ID    | Nombre del Producto
  ------+--------------------
  10    | Azúcar Morena
  30    | Cacao en Polvo
  50    | Café Premium
  70    | Panela Redonda
  90    | Sal Marina
```

### Búsqueda de producto
```
  Elige una opción: 3
--- BUSCAR PRODUCTO ---
  Ingresa el ID a buscar: 30
  ✔ Producto ENCONTRADO:
    ID: 30 | Nombre: Cacao en Polvo

  Ingresa el ID a buscar: 99
  ✘ Producto con ID 99 NO existe en el inventario.
```

---

## 🧠 Lógica de los Punteros en el Árbol

El BST ubica cada producto según su ID:
- ID **menor** al nodo actual → puntero **izquierdo**
- ID **mayor** al nodo actual → puntero **derecho**

Esto garantiza que el recorrido **inorden** siempre devuelva los productos **en orden ascendente** por ID.

---

## 🎥 Video de Sustentación

> https://drive.google.com/file/d/1u9tmzEOSYXOZUQADXXRnjFSWhsJ2YJ-r/view?usp=sharing

---

## 📁 Entrega

- Repositorio público en GitHub con mínimo 3 commits
- Archivo comprimido `.zip` con la carpeta del proyecto
- Este archivo `README.md`
