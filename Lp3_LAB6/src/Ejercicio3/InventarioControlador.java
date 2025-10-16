package Ejercicio3;

import java.util.List;
import java.util.Scanner;

public class InventarioControlador {
    private InventarioModelo modelo;
    private InventarioVista vista;
    private Scanner entrada = new Scanner(System.in);

    public InventarioControlador(InventarioModelo modelo, InventarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n===== menu de inventario =====");
            System.out.println("1. agregar item");
            System.out.println("2. eliminar item");
            System.out.println("3. ver inventario");
            System.out.println("4. ver detalles de item");
            System.out.println("5. buscar item");
            System.out.println("6. usar item");
            System.out.println("7. salir");
            System.out.print("opcion: ");
            int opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1 -> agregarItem();
                case 2 -> eliminarItem();
                case 3 -> verInventario();
                case 4 -> mostrarDetalles();
                case 5 -> buscarItem();
                case 6 -> usarItem();
                case 7 -> salir = true;
                default -> vista.mostrarMensaje("opcion no valida.");
            }
        }
    }

    private void agregarItem() {
        System.out.print("nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("cantidad: ");
        int cantidad = Integer.parseInt(entrada.nextLine());
        System.out.print("tipo (arma/pocion): ");
        String tipo = entrada.nextLine();
        System.out.print("descripcion: ");
        String descripcion = entrada.nextLine();
        modelo.agregarItem(new Item(nombre, cantidad, tipo, descripcion));
        vista.mostrarMensaje("item agregado al inventario.");
    }

    private void eliminarItem() {
        System.out.print("nombre del item a eliminar: ");
        String nombre = entrada.nextLine();
        modelo.eliminarItem(nombre);
        vista.mostrarMensaje("item eliminado si existia.");
    }

    private void verInventario() {
        List<Item> lista = modelo.obtenerItems();
        vista.mostrarInventario(lista);
    }

    private void mostrarDetalles() {
        System.out.print("nombre del item: ");
        String nombre = entrada.nextLine();
        vista.mostrarDetallesItem(modelo.buscarItem(nombre));
    }

    private void buscarItem() {
        System.out.print("nombre del item: ");
        String nombre = entrada.nextLine();
        Item item = modelo.buscarItem(nombre);
        if (item != null)
            vista.mostrarDetallesItem(item);
        else
            vista.mostrarMensaje("item no encontrado.");
    }

    private void usarItem() {
        System.out.print("nombre del item a usar: ");
        String nombre = entrada.nextLine();
        Item item = modelo.buscarItem(nombre);
        if (item != null) item.usarItem();
        else vista.mostrarMensaje("item no encontrado.");
    }
}
