package Actividad3;

import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarpedido(String nombre, String tipo) {
        if (!nombre.isEmpty() && !tipo.isEmpty()) {
            modelo.agregarpedido(new Pedido(nombre, tipo));
            vista.mostrarmensaje("pedido agregado: " + nombre + ", " + tipo);
        } else {
            vista.mostrarmensaje("el nombre y tipo no pueden estar vacios");
        }
    }

    public void mostrarpedidos() {
        List<Pedido> lista = modelo.getpedidos();
        vista.mostrarpedidos(lista);
    }

    public void eliminarpedido(String nombre) {
        if (modelo.eliminarpedido(nombre)) {
            vista.mostrarmensaje("pedido eliminado: " + nombre);
        } else {
            vista.mostrarmensaje("no se encontro el pedido");
        }
    }

    public void actualizarpedido(String viejo, String nuevo) {
        if (modelo.actualizarpedido(viejo, nuevo)) {
            vista.mostrarmensaje("pedido actualizado: " + viejo + " -> " + nuevo);
        } else {
            vista.mostrarmensaje("no se encontro el pedido");
        }
    }

    public void buscarpedido(String c) {
        List<Pedido> r = modelo.buscarpedido(c);
        if (r.isEmpty()) vista.mostrarmensaje("no se encontraron pedidos");
        else vista.mostrarpedidos(r);
    }

    public void contarpedidos(String tipo) {
        int total = modelo.contarpedidos();
        long por = modelo.contarpedidosportipo(tipo);
        vista.mostrarmensaje("pedidos totales: " + total);
        vista.mostrarmensaje("pedidos del tipo " + tipo + ": " + por);
    }

    public void iniciar() {
        String o;
        do {
            vista.mostrarmenu();
            o = vista.solicitaropcion();
            switch (o) {
                case "1":
                    agregarpedido(vista.solicitarnombreplato(), vista.solicitartipoplato());
                    break;
                case "2":
                    mostrarpedidos();
                    break;
                case "3":
                    eliminarpedido(vista.solicitarnombreeliminar());
                    break;
                case "4":
                    actualizarpedido(vista.solicitarnombreactualizar(), vista.solicitarnuevonombre());
                    break;
                case "5":
                    buscarpedido(vista.solicitarcriterio());
                    break;
                case "6":
                    contarpedidos(vista.solicitartipocontar());
                    break;
                case "7":
                    vista.mostrarmensaje("saliendo...");
                    break;
                default:
                    vista.mostrarmensaje("opcion no valida");
            }
        } while (!o.equals("7"));
        vista.cerrarscanner();
    }
}

