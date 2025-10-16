package act2;

public class Pedido {
    private String nombreplato;
    private String tipo;

    public Pedido(String nombreplato, String tipo) {
        this.nombreplato = nombreplato;
        this.tipo = tipo;
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
}
