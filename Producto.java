/**
 * Clase Producto - Representa un nodo del Árbol Binario de Búsqueda.
 * Contiene los datos del producto y los punteros izquierdo y derecho.
 * 
 * @author María Fernanda Álvarez Ríos
 * Institución Universitaria Digital de Antioquia
 * Estructuras de Datos - EA3
 */
public class Producto {

    // Datos del producto
    int id;
    String nombre;

    // Punteros al hijo izquierdo y al hijo derecho
    Producto izquierdo;
    Producto derecho;

    /**
     * Constructor: crea un nuevo producto con ID y nombre.
     * Los punteros izquierdo y derecho inician en null (sin hijos).
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }
}
