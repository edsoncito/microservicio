package Persona;

import java.util.HashMap;
import java.util.Map;

public class Director extends Persona {
    public static HashMap<String, Director> DATA = new HashMap<>();

    public static String DATAtoString() {
        String texto = "DIRECTOR";
        for (Map.Entry me : Director.DATA.entrySet()) {
            texto += "\n ---------- \n";
            texto += " key: " + DATA.get(me.getKey()).getKey();
            texto += "\n Nombres: " + DATA.get(me.getKey()).getNombres();
            texto += "\n Apellidos: " + DATA.get(me.getKey()).getApellidos();
            texto += "\n ---------- \n";
        }
        return texto;
    }
    public Director( String Nombres, String Apellidos) {
        super( Nombres, Apellidos);
        Director.DATA.put(this.getKey(), this);
    }

    @Override
    public String toString() {
        String texto = "DIRECTOR";
        texto+=" key: "+this.getKey();
        texto+="\n Nombres: "+this.getNombres();
        texto+="\n Apellidos: "+this.getApellidos();
        return texto;
    }
}
