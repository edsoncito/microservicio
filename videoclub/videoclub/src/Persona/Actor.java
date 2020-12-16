package Persona;

import java.util.HashMap;
import java.util.Map;

public class Actor extends Persona {
    public static HashMap<String, Actor> DATA = new HashMap<>();

    public static String DATAtoString() {
        String texto = "ACTORES";
        for (Map.Entry me : Actor.DATA.entrySet()) {
            texto += "\n ---------- \n";
            texto +=  DATA.get(me.getKey()).toString();
            texto += "\n ---------- \n";
        }
        return texto;
    }
    
    public Actor( String Nombres, String Apellidos) {
        super( Nombres, Apellidos);
        Actor.DATA.put(this.getKey(), this);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        String texto = "ACTOR";
        texto+=" key: "+this.getKey();
        texto+="\n Nombres: "+this.getNombres();
        texto+="\n Apellidos: "+this.getApellidos();
        return texto;
    }
}
