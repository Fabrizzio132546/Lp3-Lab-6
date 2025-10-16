package Ejercicio4;

import java.util.Random;
import java.util.Scanner;

public class CombateControlador {
    private Jugador jugador;
    private Enemigo enemigo;
    private CombateVista vista;
    private Scanner entrada = new Scanner(System.in);
    private Random random = new Random();

    public CombateControlador(Jugador jugador, Enemigo enemigo, CombateVista vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
    }

    public void iniciarCombate() {
        vista.mostrarMensaje("el combate comienza!");
        while (jugador.estaVivo() && enemigo.estaVivo()) {
            vista.mostrarEstado(jugador, enemigo);
            System.out.println("\n1. atacar");
            System.out.println("2. usar pocion");
            System.out.println("3. salir");
            System.out.print("elige una opcion: ");
            int opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1 -> realizarAtaque();
                case 2 -> usarPocion();
                case 3 -> { return; }
                default -> vista.mostrarMensaje("opcion no valida.");
            }

            if (!jugador.estaVivo() || !enemigo.estaVivo()) break;
        }

        if (jugador.estaVivo()) vista.mostrarGanador(jugador.getNombre());
        else vista.mostrarGanador(enemigo.getNombre());
    }

    private void realizarAtaque() {
        System.out.println("\nquien atacara?");
        System.out.println("1. " + jugador.getNombre());
        System.out.println("2. " + enemigo.getNombre());
        System.out.print("elige una opcion: ");
        int atacante = Integer.parseInt(entrada.nextLine());

        if (atacante == 1) {
            int danio = 5 + random.nextInt(15);
            vista.mostrarMensaje(jugador.getNombre() + " ataca a " + enemigo.getNombre() + " causando " + danio + " de danio.");
            enemigo.recibirDanio(danio);
        } else if (atacante == 2) {
            int danio = enemigo.atacar();
            vista.mostrarMensaje(enemigo.getNombre() + " ataca a " + jugador.getNombre() + " causando " + danio + " de danio.");
            jugador.recibirDanio(danio);
        } else {
            vista.mostrarMensaje("opcion no valida.");
        }
    }

    private void usarPocion() {
        System.out.println("\na quien quieres curar?");
        System.out.println("1. " + jugador.getNombre());
        System.out.println("2. " + enemigo.getNombre());
        System.out.print("elige una opcion: ");
        int opcion = Integer.parseInt(entrada.nextLine());

        int curacion = 10 + random.nextInt(20); // curacion aleatoria entre 10 y 30

        if (opcion == 1) jugador.curar(curacion);
        else if (opcion == 2) enemigo.curar(curacion);
        else vista.mostrarMensaje("opcion no valida.");
    }
}
