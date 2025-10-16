package act1;

public class Main {
    public static void main(String[] args) {
        PedidoModelo modelo = new PedidoModelo();
        PedidoVista vista = new PedidoVista();
        PedidoControlador c = new PedidoControlador(modelo, vista);
        c.iniciar();
    }
}
