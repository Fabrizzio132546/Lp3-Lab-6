package Actividad2;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner sc;

    public PedidoVista() {
        sc = new Scanner(System.in);
    }

    public String solicitarnombreplato() {
        System.out.print("introduce el nombre del plato: ");
        return sc.nextLine();
    }

    public String solicitartipoplato() {
        System.out.print("introduce el tipo del plato: ");
        return sc.nextLine();
    }

    public void mostrarpedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("no hay pedidos en la lista");
        } else {
            System.out.println("lista de pedidos:");
            for (Pedido p : pedidos) {
                System.out.println("- " + p.getnombreplato() + ", " + p.gettipo());
            }
        }
    }

    public void mostrarmenu() {
        System.out.println("\nopciones:");
        System.out.println("1. agregar pedido");
        System.out.println("2. mostrar pedidos");
        System.out.println("3. eliminar pedido");
        System.out.println("4. actualizar pedido");
        System.out.println("5. buscar pedido");
        System.out.println("6. contar pedidos");
        System.out.println("7. salir");
    }

    public String solicitaropcion() {
        System.out.print("selecciona una opcion: ");
        return sc.nextLine();
    }

    public void mostrarmensaje(String m) {
        System.out.println(m);
    }

    public void cerrarscanner() {
        sc.close();
    }

    public String solicitarnombreeliminar() {
        System.out.print("introduce el nombre del plato a eliminar: ");
        return sc.nextLine();
    }

    public String solicitarnombreactualizar() {
        System.out.print("introduce el nombre del plato a actualizar: ");
        return sc.nextLine();
    }

    public String solicitarnuevonombre() {
        System.out.print("introduce el nuevo nombre del plato: ");
        return sc.nextLine();
    }

    public String solicitarcriterio() {
        System.out.print("introduce el nombre o tipo a buscar: ");
        return sc.nextLine();
    }

    public String solicitartipocontar() {
        System.out.print("introduce el tipo de plato para contar: ");
        return sc.nextLine();
    }
}

