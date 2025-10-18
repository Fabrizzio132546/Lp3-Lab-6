package Actividad3;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;
    private List<Pedido> historial;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    public void agregarpedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getpedidos() {
        return pedidos;
    }

    public boolean eliminarpedido(String nombre) {
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido p = pedidos.get(i);
            if (p.getnombreplato().equalsIgnoreCase(nombre)) {
                p.setestado("eliminado");
                historial.add(p);
                pedidos.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarpedido(String viejo, String nuevo) {
        for (Pedido p : pedidos) {
            if (p.getnombreplato().equalsIgnoreCase(viejo)) {
                p.setnombreplato(nuevo);
                return true;
            }
        }
        return false;
    }

    public List<Pedido> buscarpedido(String criterio) {
        List<Pedido> r = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getnombreplato().equalsIgnoreCase(criterio) || p.gettipo().equalsIgnoreCase(criterio)) {
                r.add(p);
            }
        }
        return r;
    }

    public int contarpedidos() {
        return pedidos.size();
    }

    public long contarpedidosportipo(String tipo) {
        long c = 0;
        for (Pedido p : pedidos) {
            if (p.gettipo().equalsIgnoreCase(tipo)) {
                c++;
            }
        }
        return c;
    }

    public boolean marcarcompleto(String nombre) {
        for (Pedido p : pedidos) {
            if (p.getnombreplato().equalsIgnoreCase(nombre)) {
                p.setestado("completado");
                historial.add(p);
                return true;
            }
        }
        return false;
    }

    public List<Pedido> getpedidosporestado(String estado) {
        List<Pedido> r = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getestado().equalsIgnoreCase(estado)) {
                r.add(p);
            }
        }
        return r;
    }

    public long contarpedientes() {
        long c = 0;
        for (Pedido p : pedidos) {
            if (p.getestado().equalsIgnoreCase("pendiente")) {
                c++;
            }
        }
        return c;
    }

    public List<Pedido> gethistorial() {
        return historial;
    }
}

