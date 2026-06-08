import java.util.Scanner;

/**
 * Clase Main - Interfaz de usuario del sistema Tree-Stock.
 * Contiene el menú interactivo con switch-case.
 *
 * Opciones del menú:
 *   1. Registrar Producto  → solicita ID y nombre
 *   2. Mostrar Inventario  → recorrido inorden (ordenado)
 *   3. Buscar Producto     → solicita ID y muestra resultado
 *   0. Salir
 *
 * @author María Fernanda Álvarez Ríos
 * Institución Universitaria Digital de Antioquia
 * Estructuras de Datos - EA3
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();
        int opcion;

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     BIENVENIDO A TREE-STOCK v1.0     ║");
        System.out.println("║   Sistema de Inventario con BST      ║");
        System.out.println("╚══════════════════════════════════════╝");

        do {
            // ── Mostrar menú ──
            System.out.println("\n┌─────────────────────────────────────┐");
            System.out.println("│           MENÚ PRINCIPAL            │");
            System.out.println("├─────────────────────────────────────┤");
            System.out.println("│  1. Registrar Producto              │");
            System.out.println("│  2. Mostrar Inventario (Inorden)    │");
            System.out.println("│  3. Buscar Producto                 │");
            System.out.println("│  0. Salir                           │");
            System.out.println("└─────────────────────────────────────┘");
            System.out.print("  Elige una opción: ");

            // Validar que la entrada sea un número
            while (!scanner.hasNextInt()) {
                System.out.print("  Entrada inválida. Elige una opción (0-3): ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {

                // ── Opción 1: Registrar producto ──
                case 1:
                    System.out.println("\n--- REGISTRAR PRODUCTO ---");

                    System.out.print("  Ingresa el ID del producto (número entero): ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("  ID inválido. Ingresa un número entero: ");
                        scanner.next();
                    }
                    int nuevoId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("  Ingresa el nombre del producto: ");
                    String nuevoNombre = scanner.nextLine().trim();

                    if (nuevoNombre.isEmpty()) {
                        System.out.println("  [!] El nombre no puede estar vacío.");
                    } else {
                        inventario.insertar(nuevoId, nuevoNombre);
                        System.out.println("  ✔ Producto [ID:" + nuevoId + " | " + nuevoNombre + "] registrado con éxito.");
                    }
                    break;

                // ── Opción 2: Mostrar inventario inorden ──
                case 2:
                    System.out.println("\n--- INVENTARIO ORDENADO (Recorrido Inorden) ---");
                    inventario.recorridoInorden();
                    break;

                // ── Opción 3: Buscar producto ──
                case 3:
                    System.out.println("\n--- BUSCAR PRODUCTO ---");
                    System.out.print("  Ingresa el ID a buscar: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("  ID inválido. Ingresa un número entero: ");
                        scanner.next();
                    }
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine();
                    inventario.buscar(idBuscar);
                    break;

                // ── Opción 0: Salir ──
                case 0:
                    System.out.println("\n  ¡Hasta luego! Sistema Tree-Stock cerrado.");
                    break;

                // ── Opción inválida ──
                default:
                    System.out.println("  [!] Opción no válida. Elige entre 0 y 3.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}
