package Ejercicio5;

public class Jugador implements IParticipante {
    private String nombre;
    private String apodo;
    private int victorias;

    public Jugador(String nombre, String apodo) throws ExcepcionDatosInvalidos {
        if (nombre == null || nombre.isBlank() || apodo == null || apodo.isBlank()) {
            throw new ExcepcionDatosInvalidos("Nombre y apodo no pueden estar vacíos.");
        }
        this.nombre = nombre.trim();
        this.apodo = apodo.trim();
        this.victorias = 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getApodo() {
        return apodo;
    }

    @Override
    public int getVictorias() {
        return victorias;
    }

    @Override
    public void sumarVictoria() {
        victorias++;
    }

    @Override
    public String toString() {
        return apodo + " - " + nombre + " (Victorias: " + victorias + ")";
    }
}
