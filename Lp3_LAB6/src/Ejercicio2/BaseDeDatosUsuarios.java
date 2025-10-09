package model;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatosUsuarios {
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void registrar(String username, String password) {
        usuarios.add(new Usuario(username, password));
    }

    public static Usuario autenticar(String username, String password) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
