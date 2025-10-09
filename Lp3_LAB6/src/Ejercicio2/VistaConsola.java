package Ejercicio2;

import java.util.Scanner;

public class VistaConsola {
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenuPrincipal() {
        System.out.println("\n===== SISTEMA DE CARRITO MVC =====");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Salir");
        System.out.print("Opción: ");
    }

    public void mostrarMenuCarrito() {
        System.out.println("\n===== MENÚ DE CARRITO =====");
        System.out.println("1. Listar productos");
        System.out.println("2. Agregar producto al carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Eliminar producto del carrito");
        System.out.println("5. Realizar compra");
        System.out.println("6. Ver historial de compras");
        System.out.println("7. Agregar reseña");
        System.out.println("8. Cerrar sesión");
        System.out.print("Opción: ");
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(sc.nextLine());
    }
}

