package act1;

public class Pedido {
    private String nombreplato;

    public Pedido(String nombreplato) {
        this.nombreplato = nombreplato;
    }

    public String getnombreplato() {
        return nombreplato;
    }

    public void setnombreplato(String nombreplato) {
        this.nombreplato = nombreplato;
    }
}
