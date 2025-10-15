package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class ControladorTorneo {

    private VistaTorneo vista;
    private ModeloTorneo modeloTorneo;
    private List<Jugador> jugadores;
    private List<Torneo> torneos;
    private boolean ejecutando;

    public ControladorTorneo(VistaTorneo vista, ModeloTorneo modelo) {
        this.vista = vista;
        this.modeloTorneo = modelo;
        this.jugadores = new ArrayList<>();
        this.torneos = new ArrayList<>();
        this.ejecutando = true;
    }


    public void iniciar() {
        vista.mostrarMensaje("Sistema de Torneos ");

        while (ejecutando) {
            try {
                int opcion = vista.mostrarMenuPrincipal();
                switch (opcion) {
                    case 1 -> menuAdministrador();
                    case 2 -> menuJugador();
                    case 3 -> salir();
                    default -> vista.mostrarMensaje("Opcion no valida.");
                }
            } catch (ExcepcionTorneo e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            } catch (Exception e) {
                vista.mostrarMensaje("Error inesperado: " + e.getMessage());
            }
        }
    }
    private void menuAdministrador() throws ExcepcionTorneo {
        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenuAdministrador();
            switch (opcion) {
                case 1 -> registrarJugador();
                case 2 -> crearTorneo();
                case 3 -> inscribirJugadorEnTorneo();
                case 4 -> generarPrimeraRonda();
                case 5 -> registrarResultado();
                case 6 -> vista.mostrarJugadores(jugadores);
                case 7 -> mostrarTorneos();
                case 8 -> mostrarRankingGlobal();
                case 9 -> continuar = false;
                default -> vista.mostrarMensaje("Opción inválida.");
            }
        }
    }
    private void menuJugador() throws ExcepcionTorneo {
        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenuJugador();
            switch (opcion) {
                case 1 -> vista.mostrarJugadores(jugadores);
                case 2 -> mostrarTorneos();
                case 3 -> continuar = false;
                default -> vista.mostrarMensaje("Opción inválida.");
            }
        }
    }
    private void registrarJugador() {
        try {
            String nombre = vista.leerTexto("Ingrese el nombre del jugador: ");
            String apodo = vista.leerTexto("Ingrese el apodo (unico): ");

            for (Jugador j : jugadores) {
                if (j.getApodo().equalsIgnoreCase(apodo)) {
                    throw new ExcepcionTorneo("Ya existe un jugador con ese apodo.");
                }
            }

            jugadores.add(new Jugador(nombre, apodo));
            vista.mostrarMensaje("Jugador registrado con éxito.");

        } catch (ExcepcionTorneo e) {
            vista.mostrarMensaje("" + e.getMessage());
        }
    }

    private void crearTorneo() {
        try {
            String nombre = vista.leerTexto("Ingrese el nombre del torneo: ");
            int limite = vista.leerEntero("Ingrese el numero maximo de jugadores: ");

            if (nombre.isBlank()) throw new ExcepcionTorneo("El nombre no puede estar vacío.");
            if (limite < 2) throw new ExcepcionTorneo("El torneo debe tener al menos 2 jugadores.");

            torneos.add(new Torneo(nombre, limite));
            vista.mostrarMensaje("Torneo creado correctamente.");

        } catch (ExcepcionTorneo e) {
            vista.mostrarMensaje(" " + e.getMessage());
        }
    }

    private void inscribirJugadorEnTorneo() {
        try {
            if (torneos.isEmpty()) throw new ExcepcionTorneo("No hay torneos disponibles.");
            if (jugadores.isEmpty()) throw new ExcepcionTorneo("No hay jugadores registrados.");

            vista.mostrarTorneos(torneos);
            String nombreTorneo = vista.leerTexto("Ingrese el nombre del torneo: ");
            Torneo torneo = buscarTorneo(nombreTorneo);
            if (torneo == null) throw new ExcepcionTorneo("Torneo no encontrado.");

            vista.mostrarJugadores(jugadores);
            String apodo = vista.leerTexto("Ingrese el apodo del jugador a inscribir: ");
            Jugador jugador = buscarJugador(apodo);
            if (jugador == null) throw new ExcepcionTorneo("Jugador no encontrado.");

            modeloTorneo.inscribirJugador(torneo, jugador);
            vista.mostrarMensaje("Jugador inscrito correctamente.");

        } catch (ExcepcionTorneo e) {
            vista.mostrarMensaje("" + e.getMessage());
        }
    }

    private void generarPrimeraRonda() {
        try {
            if (torneos.isEmpty()) throw new ExcepcionTorneo("No hay torneos registrados.");
            vista.mostrarTorneos(torneos);

            String nombreTorneo = vista.leerTexto("Ingrese el nombre del torneo: ");
            Torneo torneo = buscarTorneo(nombreTorneo);
            if (torneo == null) throw new ExcepcionTorneo("Torneo no encontrado.");

            modeloTorneo.generarPrimeraRonda(torneo);
            vista.mostrarMensaje("Primera ronda generada correctamente.");
            vista.mostrarMensaje(modeloTorneo.obtenerResumen(torneo));

        } catch (ExcepcionTorneo e) {
            vista.mostrarMensaje("" + e.getMessage());
        }
    }

    private void registrarResultado() {
        try {
            if (torneos.isEmpty()) throw new ExcepcionTorneo("No hay torneos registrados.");
            vista.mostrarTorneos(torneos);

            String nombreTorneo = vista.leerTexto("Ingrese el nombre del torneo: ");
            Torneo torneo = buscarTorneo(nombreTorneo);
            if (torneo == null) throw new ExcepcionTorneo("Torneo no encontrado.");

            vista.mostrarMensaje(modeloTorneo.obtenerResumen(torneo));

            int numRonda = vista.leerEntero("Ingrese el número de ronda: ");
            int numPartida = vista.leerEntero("Ingrese el número de partida: ");
            String apodoGanador = vista.leerTexto("Ingrese el apodo del ganador: ");

            modeloTorneo.registrarGanadorPartida(torneo, numRonda, numPartida, apodoGanador);
            vista.mostrarMensaje("Resultado registrado correctamente.");

            Ronda ultima = torneo.getRondas().get(torneo.getRondas().size() - 1);
            if (ultima.estaCompletada()) {
                modeloTorneo.avanzarRonda(torneo);
            }

            vista.mostrarMensaje(modeloTorneo.obtenerResumen(torneo));

        } catch (ExcepcionTorneo e) {
            vista.mostrarMensaje("" + e.getMessage());
        }
    }

    private void mostrarTorneos() {
        if (torneos.isEmpty()) {
            vista.mostrarMensaje("No hay torneos registrados.");
        } else {
            vista.mostrarTorneos(torneos);
        }
    }

    private void mostrarRankingGlobal() {
        if (jugadores.isEmpty()) {
            vista.mostrarMensaje("No hay jugadores registrados.");
            return;
        }

        jugadores.sort((a, b) -> Integer.compare(b.getVictorias(), a.getVictorias()));
        vista.mostrarMensaje("\n=== Ranking Global ===");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            vista.mostrarMensaje((i + 1) + ". " + j.getApodo() + " - " + j.getVictorias() + " victorias");
        }
    }

    private void salir() {
        vista.mostrarMensaje("Saliendo, bye bye");
        vista.cerrarScanner();
        ejecutando = false;
    }

    private Jugador buscarJugador(String apodo) {
        for (Jugador j : jugadores) {
            if (j.getApodo().equalsIgnoreCase(apodo)) {
                return j;
            }
        }
        return null;
    }

    private Torneo buscarTorneo(String nombre) {
        for (Torneo t : torneos) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                return t;
            }
        }
        return null;
    }
}









