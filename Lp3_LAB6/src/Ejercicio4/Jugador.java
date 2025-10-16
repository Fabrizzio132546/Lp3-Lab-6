package Ejercicio4;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private Item armaEquipada;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.salud = 100;
        this.nivel = 1;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }

    public void recibirDanio(int danio) {
        salud -= danio;
        if (salud < 0) salud = 0;
        System.out.println(nombre + " recibio " + danio + " de danio. salud actual: " + salud);
    }

    public void curar(int cantidad) {
        salud += cantidad;
        if (salud > 100) salud = 100;
        System.out.println(nombre + " recupero " + cantidad + " de salud. salud actual: " + salud);
    }

    public boolean estaVivo() { return salud > 0; }

    public void equiparArma(Item arma) {
        this.armaEquipada = arma;
    }

    public int atacar() {
        int base = 10;
        int extra = armaEquipada != null ? armaEquipada.getPoder() : 0;
        return base + extra;
    }
}
