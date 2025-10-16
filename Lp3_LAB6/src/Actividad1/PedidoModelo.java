package act1;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarpedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getpedidos() {
        return pedidos;
    }
}
