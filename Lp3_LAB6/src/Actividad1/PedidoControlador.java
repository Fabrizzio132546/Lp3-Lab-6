package Actividad1;

import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarpedido(String nombre) {
        if (!nombre.isEmpty()) {
            modelo.agregarpedido(new Pedido(nombre));
            vista.mostrarmensaje("pedido agregado: " + nombre);
        } else {
            vista.mostrarmensaje("el nombre no puede estar vacio");
        }
    }

    public void mostrarpedidos() {
        List<Pedido> lista = modelo.getpedidos();
        vista.mostrarpedidos(lista);
    }

    public void iniciar() {
        String o;
        do {
            vista.mostrarmenu();
            o = vista.solicitaropcion();
            switch (o) {
                case "1":
                    agregarpedido(vista.solicitarnombreplato());
                    break;
                case "2":
                    mostrarpedidos();
                    break;
                case "3":
                    vista.mostrarmensaje("saliendo...");
                    break;
                default:
                    vista.mostrarmensaje("opcion no valida");
            }
        } while (!o.equals("3"));
        vista.cerrarscanner();
    }
}

