package Ejercicio4;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public String getTipo() { return tipo; }

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

    public int atacar() {
        return 8 + (int)(Math.random() * 12); // daño aleatorio
    }
}
