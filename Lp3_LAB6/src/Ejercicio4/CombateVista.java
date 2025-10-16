package Ejercicio4;

public class CombateVista {
    public void mostrarEstado(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n=== estado del combate ===");
        System.out.println("jugador: " + jugador.getNombre() + " | salud: " + jugador.getSalud());
        System.out.println("enemigo: " + enemigo.getNombre() + " | salud: " + enemigo.getSalud());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarGanador(String ganador) {
        System.out.println("\n*** " + ganador + " ha ganado el combate! ***");
    }
}
