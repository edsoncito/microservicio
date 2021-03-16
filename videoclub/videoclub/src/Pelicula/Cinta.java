package Pelicula;

import java.util.HashMap;
import java.util.Map;

import Ficha.Ficha;
import Persona.Socio;
import Utils.Utils;

public class Cinta {
    public static HashMap<String, Cinta> DATA = new HashMap<>();
    

    public static String DATAtoString() {
        String texto = "CINTAS ";
        for (Map.Entry me : Cinta.DATA.entrySet()) {
            texto += "\n ---------- \n";
            texto +=  DATA.get(me.getKey()).toString();
            
            texto += "\n ---------- \n";
        }
        return texto;
    }
    //---------------------------------------------------------------------------------//

    private String key;
    private Pelicula Pelicula;
    private boolean isPrestada;
    private HashMap<String, Ficha> Fichas;
    public Cinta(Pelicula Pelicula) {
        this.key = Utils.getKEY();
        this.Pelicula= Pelicula;
        this.isPrestada =false;
        this.Fichas= new HashMap<>();
        Pelicula.getCintas().put(this.key,this);
        Cinta.DATA.put(this.getKey(), this);
    }

    public Ficha prestar(Socio socio){
        if(isPrestada()){
            return null;
        }
        Ficha ficha = new Ficha(this, socio);
        this.getFichas().put(ficha.getKey(), ficha);
        setPrestada(true);
        return ficha;        
    }

    public void devolver(Ficha ficha){
        setPrestada(false);
    }
    public String getKey() {
        return key;
    }
    public Pelicula getPelicula() {
        return Pelicula;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public void setPelicula(Pelicula pelicula) {
        Pelicula = pelicula;
    }
    public void setPrestada(boolean isPrestada) {
        this.isPrestada = isPrestada;
    }
    public boolean isPrestada() {
        return isPrestada;
    }
    public HashMap<String, Ficha> getFichas() {
        return Fichas;
    }
    public void setFichas(HashMap<String, Ficha> fichas) {
        Fichas = fichas;
    }

    @Override
    public String toString() {
        String texto = "Cinta";
        texto += "\n key: " + this.getKey();
        texto += "\n pelicula: " + this.getPelicula().toString();
        return texto;
    }
}
