package Ejercicio4;

public class JuegoMain {
    public static void main(String[] args) {
        Jugador heroe = new Jugador("heroe");
        Enemigo goblin = new Enemigo("goblin", 60, 1, "bestia");
        CombateVista vista = new CombateVista();
        CombateControlador combate = new CombateControlador(heroe, goblin, vista);
        combate.iniciarCombate();
    }
}
