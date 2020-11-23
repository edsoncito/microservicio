import java.util.HashMap;
import java.util.UUID;

import Ficha.Archivador;
import Ficha.Ficha;
import Pelicula.Cinta;
import Pelicula.Genero;
import Pelicula.Pelicula;
import Persona.Actor;
import Persona.Director;
import Persona.Persona;
import Persona.Socio;
import Utils.Console;
import Utils.Utils;

public class App {
    public static void main(String[] args) throws Exception {
        // SOCIOS
        Socio socio1 = new Socio("Ricky", "Paz", "B/ convifag norte", "75395848");
        Socio socio2 = new Socio("Edson", "Cito", "B/ norte", "tt821212");
        Socio socio3 = new Socio("Xavier", "Florez", "B/ norte", "tt821212212");
        // Console.log(Console.ANSI_BLUE, Socio.DATAtoString());
        // ACTORES
        Actor actor1 = new Actor("Leonardo", "Dicaprio");
        Actor actor2 = new Actor("Criss", "Evans");
        Actor actor3 = new Actor("Robert", "Darwin  jr");
        Actor actor4 = new Actor("Scarlett ", "Johansson");
        // Console.log(Console.ANSI_CYAN, Actor.DATAtoString());
        // DIRECTORES
        Director director1 = new Director("Koki ", "Banzer");
        // Console.log(Console.ANSI_GREEN, Director.DATAtoString());
        // MOSTRAR TTODAD LAS PERSONA
        // Console.log(Console.ANSI_RED, Persona.DATAtoString());
        
        // GENEROS
        Genero gnr_comedia = new Genero("comedia", "comedia es de chiste");
        Genero gnr_terror = new Genero("terror", "terror es de terror");
        Genero gnr_suspenso = new Genero("suspenso", "suspenso es de suspenso");
        Genero gnr_drama = new Genero("drama", "drama es de drama");

        // Console.log(Console.ANSI_BLUE, Genero.DATAtoString());
        // PELICULAS

        Pelicula pelicula1 = new Pelicula("Titanic",director1, gnr_drama);
        pelicula1.setActor(actor1);
        pelicula1.setActor(actor2);
        pelicula1.setActor(actor3);

        pelicula1.agregarCintas(2);

        Pelicula pelicula2 = new Pelicula("Tonto y retonto",director1, gnr_comedia);
        pelicula2.setActor(actor4);
        pelicula2.setActor(actor2);


        Pelicula pelicula3 = new Pelicula("Avenger",director1, gnr_suspenso);
        pelicula3.setActor(actor2);
        pelicula3.setActor(actor1);
      
        // pelicula3.agregarCintas(2);
        
        Console.log(Console.ANSI_YELLOW, Pelicula.DATAtoString());
        
        

        Ficha ficha = pelicula1.prestarCinta(socio1);
        Ficha ficha1 = pelicula1.prestarCinta(socio2);
        Ficha ficha2 = pelicula1.prestarCinta(socio2);
        Ficha ficha3 = pelicula1.prestarCinta(socio3);
        
        ficha.devolver();
        Ficha ficha4 = pelicula1.prestarCinta(socio2);
        // Console.log(Console.ANSI_PURPLE, Ficha.DATAtoString());


        Console.log(Console.ANSI_CYAN, Archivador.PRESTADAStoString());
        Console.log(Console.ANSI_GREEN, Archivador.DEVUELTAStoString());
        
    }

}
