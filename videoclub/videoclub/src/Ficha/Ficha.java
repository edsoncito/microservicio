package Ficha;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Pelicula.Cinta;
import Persona.Socio;
import Utils.Utils;

public class Ficha {

    public static HashMap<String, Ficha> DATA = new HashMap<>();

    public static String DATAtoString() {
        String texto = "FICHAS ";
        for (Map.Entry me :Ficha.DATA.entrySet()) {
            texto += "\n ---------- \n";
            texto += DATA.get(me.getKey()).toString();
            texto += "\n ---------- \n";
        }
        return texto;
    }

    private String key;
    private Cinta Cinta;
    private Socio Socio;
    private Date FechaPrestamo;
    private Date FechaDevolucion;

    public Ficha( Cinta Cinta, Socio Socio) {
        this.key = Utils.getKEY();
        this.Cinta = Cinta;
        this.Socio = Socio;
        this.FechaPrestamo = new Date();
        Ficha.DATA.put(key,this);
        Archivador.PRESTADAS.put(key,this);
    }

    public void devolver(){
        System.out.println("SE DEVOLVIO LA FICHA");
        Archivador.PRESTADAS.remove(key);
        Archivador.DEVUELTAS.put(key,this);
        setFechaDevolucion(new Date());
        this.getCinta().devolver(this);
    }
    public void setCinta(Cinta cinta) {
        Cinta = cinta;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        FechaPrestamo = fechaPrestamo;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setSocio(Socio socio) {
        Socio = socio;
    }

    public Cinta getCinta() {
        return Cinta;
    }

    public Date getFechaPrestamo() {
        return FechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return FechaDevolucion;
    }
    public void setFechaDevolucion(Date fechaDevolucion) {
        FechaDevolucion = fechaDevolucion;
    }
    public String getKey() {
        return key;
    }

    public Socio getSocio() {
        return Socio;
    }

    @Override
    public String toString() {
        String texto = "";
        texto += " key: " + this.key;
        texto += "\n\n Cinta: \n" + this.getCinta().toString();
        texto += "\n\n Socio: \n" + this.getSocio().toString();
        texto += "\n\n FECHA:" + this.getFechaPrestamo().toGMTString();
        if(this.getFechaDevolucion()!=null){
            texto += "\n\n FECHA_Devolucion:" + this.getFechaDevolucion().toGMTString();
        }
        return texto;
    }
}
