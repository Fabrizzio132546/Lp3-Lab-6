package Ejercicio4;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo; // arma o pocion
    private String descripcion;
    private int poder; // poder base (ataque o curacion)

    public Item(String nombre, int cantidad, String tipo, String descripcion, int poder) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.poder = poder;
    }

    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public int getPoder() { return poder; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public void usarItem() {
        if (cantidad > 0) {
            cantidad--;
            System.out.println("has usado el item: " + nombre + ". quedan " + cantidad + " unidades.");
        } else {
            System.out.println("no quedan unidades de " + nombre + ".");
        }
    }
}
