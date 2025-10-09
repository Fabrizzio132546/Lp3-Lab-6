package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String username;
    private String password;
    private List<Reseña> reseñas = new ArrayList<>();

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public List<Reseña> getReseñas() { return reseñas; }

    public void agregarReseña(Reseña r) {
        reseñas.add(r);
    }
}

