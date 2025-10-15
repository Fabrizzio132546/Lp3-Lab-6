package Ejercicio5;

import java.util.List;
import java.util.Scanner;

public class VistaTorneo {
    private Scanner scanner;
    public VistaTorneo() {
        this.scanner = new Scanner(System.in);
    }
    public int mostrarMenuPrincipal() {
        System.out.println("\n==============================");
        System.out.println("   MENÚ PRINCIPAL DEL TORNEO");
        System.out.println("1. Modo Administrador");
        System.out.println("2. Modo Jugador");
        System.out.println("3. Salir");
        return leerEntero("Seleccione una opción: ");
    }
    public int mostrarMenuAdministrador() {
        System.out.println("\n==============================");
        System.out.println("     MENÚ ADMINISTRADOR");
        System.out.println("1. Registrar jugador");
        System.out.println("2. Crear torneo");
        System.out.println("3. Inscribir jugador en torneo");
        System.out.println("4. Generar primera ronda");
        System.out.println("5. Registrar resultado");
        System.out.println("6. Mostrar jugadores");
        System.out.println("7. Mostrar torneos");
        System.out.println("8. Mostrar ranking global");
        System.out.println("9. Volver al menú principal");
        return leerEntero("Seleccione una opción: ");
    }

    public int mostrarMenuJugador() {
        System.out.println("\n==============================");
        System.out.println("      MENÚ JUGADOR");
        System.out.println("1. Ver jugadores");
        System.out.println("2. Ver torneos");
        System.out.println("3. Volver al menú principal");
        return leerEntero("Seleccione una opción: ");
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public int leerEntero(String mensaje) {
        int valor = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(scanner.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Ingrese un número válido.");
            }
        }
        return valor;
    }


    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarJugadores(List<Jugador> jugadores) {
        System.out.println("\n=== LISTA DE JUGADORES ===");
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }

        for (int i = 0; i < jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            System.out.println((i + 1) + ". " + j.getNombre() + " (" + j.getApodo() + ") - Victorias: " + j.getVictorias());
        }
    }

    public void mostrarTorneos(List<Torneo> torneos) {
        System.out.println("\n=== LISTA DE TORNEOS ===");
        if (torneos.isEmpty()) {
            System.out.println("No hay torneos creados.");
            return;
        }

        for (int i = 0; i < torneos.size(); i++) {
            Torneo t = torneos.get(i);
            System.out.println((i + 1) + ". " + t.getNombre() 
                + " - Jugadores inscritos: " + t.getInscritos().size());
        }
    }

    public void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
