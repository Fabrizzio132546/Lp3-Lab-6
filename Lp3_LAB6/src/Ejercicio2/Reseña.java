package Ejercicio2;

public class Reseña {
    private Producto producto;
    private String comentario;
    private int calificacion;

    public Reseña(Producto producto, String comentario, int calificacion) {
        this.producto = producto;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public Producto getProducto() { return producto; }
    public String getComentario() { return comentario; }
    public int getCalificacion() { return calificacion; }
}


