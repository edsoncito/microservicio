package Pelicula;

import java.util.HashMap;
import java.util.Map;

import Ficha.Ficha;
import Persona.Actor;
import Persona.Director;
import Persona.Socio;
import Utils.Utils;

public class Pelicula {
    public static HashMap<String, Pelicula> DATA = new HashMap<>();

    public static String DATAtoString() {
        String texto = "PELICULAS";
        for (Map.Entry me : Pelicula.DATA.entrySet()) {
            texto += "\n ---------- \n";
            texto += "\n key: " + DATA.get(me.getKey()).getKey();
            texto += "\n Titulo: " + DATA.get(me.getKey()).getTitulo();
            texto += "\n ";
            texto += "\n Genero: ";
            texto += "\n " + DATA.get(me.getKey()).getGenero().toString();
            texto += "\n ";
            texto += "\n Director: ";
            texto += "\n " + DATA.get(me.getKey()).getDirector().toString();
            texto += "\n ";
            texto += "\n Actores: ";
            texto += "\n " + DATA.get(me.getKey()).getActores().size();
            texto += "\n ";
            texto += "\n Cintas: ";
            texto += "\n " + DATA.get(me.getKey()).getCintas().size();
            texto += "\n ";
            texto += "\n ---------- \n";
        }
        return texto;
    }

    private String key;
    private String Titulo;
    private Director Director;
    private HashMap<String, Actor> Actores;
    private HashMap<String, Cinta> Cintas;
    private Genero Genero;

    public Pelicula(String Titulo, Director Director, Genero Genero) {
        this.key = Utils.getKEY();
        this.Titulo = Titulo;
        this.Director = Director;
        this.Genero = Genero;
        this.Actores = new HashMap<>();
        this.Cintas = new HashMap<>();
        System.out.println("SE REGISTRO UNA PELICULA");
        Pelicula.DATA.put(this.getKey(), this);

    }

    public Ficha prestarCinta(Socio socio) {
        System.out.println("SOCIO INTENTA PRESTAR CINTA -- "+socio.getNombres());
        if (getCintas().size() <= 0) {
            System.out.println("NO SE REGISTRARON COPIAS DE LA PELICULA - "+this.getTitulo());
            return null;
        }
        String texto = "PELICULAS";
        Cinta cintaTemp ;
        for (Map.Entry me : getCintas().entrySet()) {
            cintaTemp=getCintas().get(me.getKey());
            if(!cintaTemp.isPrestada()){
                System.out.println("SE PRESTO LA CINTA "+cintaTemp.getKey());
                return cintaTemp.prestar(socio);
            }
        }
        
        System.out.println("YA NO QUEDAN COPIAS DE LA PELICULA - "+this.getTitulo());
        return null;
    }

    public void agregarCintas(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            new Cinta(this);
        }
    }

    public HashMap<String, Cinta> getCintas() {
        return Cintas;
    }

    public void setCintas(HashMap<String, Cinta> cintas) {
        Cintas = cintas;
    }

    public HashMap<String, Actor> getActores() {
        return Actores;
    }

    public Director getDirector() {
        return Director;
    }

    public Genero getGenero() {
        return Genero;
    }

    public String getKey() {
        return key;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setActores(HashMap<String, Actor> actores) {
        Actores = actores;
    }

    public void setActor(Actor actor) {
        this.Actores.put(actor.getKey(), actor);
    }

    public void setDirector(Director director) {
        Director = director;
    }

    public void setGenero(Genero genero) {
        Genero = genero;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    @Override
    public String toString() {
        String texto = "";
        texto += "\n key: " + this.getKey();
        texto += "\n Titulo: " + this.getTitulo();
        return texto;
    }

}
