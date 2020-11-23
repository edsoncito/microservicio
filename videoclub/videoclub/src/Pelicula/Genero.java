package Pelicula;

import java.util.HashMap;
import java.util.Map;

public class Genero {
    public static HashMap<String, Genero> DATA = new HashMap<>();

    public static String DATAtoString() {
        String texto = "GENEROS";
        for (Map.Entry me : Genero.DATA.entrySet()) {
            texto += "\n ---------- \n";
            texto +=  DATA.get(me.getKey()).toString();
            texto += "\n ---------- \n";
        }
        return texto;
    }
    //---------------------------------------------------------------------------------//

    private String Nombre;
    private String Descripcion;

    public Genero(String Nombre,String Descripcion) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        Genero.DATA.put(this.getNombre(), this);
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        String texto = "GENERO";
        texto += "\n Nombre: " + this.getNombre();
        texto += "\n Descripcion: " + this.getDescripcion();
        return texto;
    }
}
