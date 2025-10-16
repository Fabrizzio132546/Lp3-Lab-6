package act1;

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

    public void mostrarpedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("no hay pedidos en la lista");
        } else {
            System.out.println("lista de pedidos:");
            for (Pedido p : pedidos) {
                System.out.println("- " + p.getnombreplato());
            }
        }
    }

    public void mostrarmenu() {
        System.out.println("\nopciones:");
        System.out.println("1. agregar pedido");
        System.out.println("2. mostrar pedidos");
        System.out.println("3. salir");
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
}
