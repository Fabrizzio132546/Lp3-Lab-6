package Ejercicio2;
import java.util.*;

public class ControladorPrincipal {
    private VistaConsola vista;
    private Usuario usuarioActual;
    private List<Orden> historial = new ArrayList<>();
    private Carrito carrito = new Carrito();

    public ControladorPrincipal(VistaConsola vista) {
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenuPrincipal();
            int op = vista.leerEntero("");
            switch (op) {
                case 1 -> registrar();
                case 2 -> iniciarSesion();
                case 3 -> salir = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void registrar() {
        String user = vista.leerTexto("Nombre de usuario: ");
        String pass = vista.leerTexto("Contraseña: ");
        BaseDeDatosUsuarios.registrar(user, pass);
        System.out.println("Usuario registrado con éxito.");
    }

    private void iniciarSesion() {
        String user = vista.leerTexto("Usuario: ");
        String pass = vista.leerTexto("Contraseña: ");
        Usuario u = BaseDeDatosUsuarios.autenticar(user, pass);
        if (u != null) {
            usuarioActual = u;
            menuCarrito();
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private void menuCarrito() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenuCarrito();
            int op = vista.leerEntero("");
            switch (op) {
                case 1 -> listarProductos();
                case 2 -> agregarAlCarrito();
                case 3 -> verCarrito();
                case 4 -> eliminarDelCarrito();
                case 5 -> realizarCompra();
                case 6 -> verHistorial();
                case 7 -> agregarReseña();
                case 8 -> salir = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void listarProductos() {
        for (Producto p : RepositorioProductos.obtenerProductos()) {
            System.out.println(p.getId() + ". " + p.getNombre() + " - S/" + p.getPrecio());
        }
    }

    private void agregarAlCarrito() {
        int id = vista.leerEntero("ID del producto: ");
        int cantidad = vista.leerEntero("Cantidad: ");
        Producto p = RepositorioProductos.buscarPorId(id);
        if (p != null) {
            carrito.agregarItem(p, cantidad);
            System.out.println("Producto agregado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void verCarrito() {
        for (ItemCarrito i : carrito.getItems()) {
            System.out.println(i.getProducto().getNombre() + " x" + i.getCantidad() + " = S/" + i.getSubtotal());
        }
        System.out.println("Total: S/" + carrito.getTotal());
    }

    private void eliminarDelCarrito() {
        int id = vista.leerEntero("ID del producto a eliminar: ");
        carrito.eliminarItem(id);
        System.out.println("Producto eliminado.");
    }

    private void realizarCompra() {
        double total = carrito.getTotal();
        historial.add(new Orden(usuarioActual, carrito.getItems(), total));
        carrito = new Carrito();
        System.out.println("Compra realizada por S/" + total);
    }

    private void verHistorial() {
        for (Orden o : historial) {
            System.out.println("Orden de " + o.getUsuario().getUsername() + " - Total: S/" + o.getTotal());
        }
    }

    private void agregarReseña() {
        int id = vista.leerEntero("ID del producto a reseñar: ");
        Producto p = RepositorioProductos.buscarPorId(id);
        if (p != null) {
            String comentario = vista.leerTexto("Comentario: ");
            int calif = vista.leerEntero("Calificación (1-5): ");
            usuarioActual.agregarReseña(new Reseña(p, comentario, calif));
            System.out.println("Reseña agregada.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}

