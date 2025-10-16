package act3;

public class Pedido {
    private String nombreplato;
    private String tipo;
    private String estado;

    public Pedido(String nombreplato, String tipo) {
        this.nombreplato = nombreplato;
        this.tipo = tipo;
        this.estado = "pendiente";
    }

    public String getnombreplato() {
        return nombreplato;
    }

    public void setnombreplato(String nombreplato) {
        this.nombreplato = nombreplato;
    }

    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

    public String getestado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }
}
