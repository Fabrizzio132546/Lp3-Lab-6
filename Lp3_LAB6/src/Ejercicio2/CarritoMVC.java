package carromain;
import controller.ControladorPrincipal;
import view.VistaConsola;

public class CarritoMVC {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorPrincipal controlador = new ControladorPrincipal(vista);
        controlador.iniciar();
    }
}

