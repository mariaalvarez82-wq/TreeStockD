// EA3 - Estructuras de Datos - IU Digital
/**
 * Clase ArbolInventario - Contiene la lógica del Árbol Binario de Búsqueda.
 * Implementa los métodos: insertar (recursivo), recorrido inorden y buscar.
 *
 * Regla del BST:
 *   - Si el ID es MENOR al nodo actual → va al subárbol IZQUIERDO.
 *   - Si el ID es MAYOR al nodo actual → va al subárbol DERECHO.
 *   - Si el ID ya existe → no se inserta (IDs únicos).
 *
 * @author María Fernanda Álvarez Ríos
 * Institución Universitaria Digital de Antioquia
 * Estructuras de Datos - EA3
 */
public class ArbolInventario {

    // Raíz del árbol (primer producto insertado)
    private Producto raiz;

    /**
     * Constructor: el árbol inicia vacío (raíz = null).
     */
    public ArbolInventario() {
        this.raiz = null;
    }

    // ─────────────────────────────────────────────
    // INSERTAR
    // ─────────────────────────────────────────────

    /**
     * Método público para insertar un producto.
     * Llama al método recursivo privado.
     */
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    /**
     * Método recursivo privado que ubica la posición correcta en el árbol.
     * @param nodoActual  el nodo que se está evaluando en esta llamada
     * @param id          ID del nuevo producto
     * @param nombre      nombre del nuevo producto
     * @return            el nodo con el nuevo producto ya insertado
     */
    private Producto insertarRecursivo(Producto nodoActual, int id, String nombre) {

        // Caso base: posición vacía → aquí va el nuevo nodo
        if (nodoActual == null) {
            return new Producto(id, nombre);
        }

        // El ID ya existe → no se permite duplicado
        if (id == nodoActual.id) {
            System.out.println("  [!] El ID " + id + " ya existe en el inventario. No se insertó.");
            return nodoActual;
        }

        // ID menor → baja por la izquierda
        if (id < nodoActual.id) {
            nodoActual.izquierdo = insertarRecursivo(nodoActual.izquierdo, id, nombre);
        }
        // ID mayor → baja por la derecha
        else {
            nodoActual.derecho = insertarRecursivo(nodoActual.derecho, id, nombre);
        }

        return nodoActual;
    }

    // ─────────────────────────────────────────────
    // RECORRIDO INORDEN (izquierda → raíz → derecha)
    // ─────────────────────────────────────────────

    /**
     * Método público para mostrar el inventario ordenado por ID.
     */
    public void recorridoInorden() {
        if (raiz == null) {
            System.out.println("  El inventario está vacío.");
            return;
        }
        System.out.println("  ID    | Nombre del Producto");
        System.out.println("  ------+--------------------");
        inordenRecursivo(raiz);
    }

    /**
     * Recorre el árbol en inorden de forma recursiva.
     * El inorden de un BST siempre produce los elementos en orden ascendente.
     */
    private void inordenRecursivo(Producto nodoActual) {
        if (nodoActual == null) return;

        // 1. Recorre subárbol izquierdo
        inordenRecursivo(nodoActual.izquierdo);

        // 2. Visita el nodo actual
        System.out.printf("  %-5d | %s%n", nodoActual.id, nodoActual.nombre);

        // 3. Recorre subárbol derecho
        inordenRecursivo(nodoActual.derecho);
    }

    // ─────────────────────────────────────────────
    // BUSCAR
    // ─────────────────────────────────────────────

    /**
     * Método público para buscar un producto por ID.
     */
    public void buscar(int id) {
        Producto resultado = buscarRecursivo(raiz, id);
        if (resultado != null) {
            System.out.println("  ✔ Producto ENCONTRADO:");
            System.out.println("    ID: " + resultado.id + " | Nombre: " + resultado.nombre);
        } else {
            System.out.println("  ✘ Producto con ID " + id + " NO existe en el inventario.");
        }
    }

    /**
     * Recorre el árbol buscando el ID.
     * Aprovecha la propiedad del BST para descartar ramas enteras.
     */
    private Producto buscarRecursivo(Producto nodoActual, int id) {

        // Caso base: llegamos a null → no existe
        if (nodoActual == null) return null;

        // Encontrado
        if (id == nodoActual.id) return nodoActual;

        // Busca en la rama correcta según la comparación
        if (id < nodoActual.id) {
            return buscarRecursivo(nodoActual.izquierdo, id);
        } else {
            return buscarRecursivo(nodoActual.derecho, id);
        }
    }
}
