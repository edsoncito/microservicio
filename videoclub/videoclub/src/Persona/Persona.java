package Persona;

import java.util.HashMap;
import java.util.Map;

import Utils.Utils;

public class Persona {

    public static HashMap<String, Persona> DATA = new HashMap<>();

    public static String DATAtoString() {
        String texto = "PERSONAS";
        for (Map.Entry me : Persona.DATA.entrySet()) {
            texto += "\n ---------- \n";
            texto +=  DATA.get(me.getKey()).toString();
            texto += "\n ---------- \n";
        }
        return texto;
    }

    private String key;
    private String Nombres;
    private String Apellidos;

    public Persona( String Nombres, String Apellidos) {
        this.key = Utils.getKEY();
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        Persona.DATA.put(this.getKey(), this);

    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getKey() {
        return key;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    @Override
    public String toString() {
        String texto = "";
        texto += " key: " + this.key;
        texto += "\n Nombres: " + this.Nombres;
        texto += "\n Apellidos: " + this.Apellidos;
        return texto;
    }
}
