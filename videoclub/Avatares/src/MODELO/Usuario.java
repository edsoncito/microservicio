package MODELO;

import java.util.HashMap;

public class Usuario {

    public static HashMap<String, Usuario> DATA = new HashMap<>();
    public static Usuario Usuariolog;

    private String nombre;
    private String usuario;
    private String pass;

    public Usuario(String nombre, String usuario, String pass) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.pass = pass;
        DATA.put(this.usuario, this);
    }


    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " Usuario: " + getUsuario();
    }
}
