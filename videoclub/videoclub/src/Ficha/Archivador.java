package Ficha;

import java.util.HashMap;
import java.util.Map;

public class Archivador {

    public static HashMap<String, Ficha> PRESTADAS = new HashMap<>();

    public static HashMap<String, Ficha> DEVUELTAS = new HashMap<>();

    public static HashMap<String, Ficha> ESPERA = new HashMap<>();

    public static String PRESTADAStoString() {
        String texto = "FICHAS PRESTADAS ";
        for (Map.Entry me : Archivador.PRESTADAS.entrySet()) {
            texto += "\n ---------- \n";
            texto += Archivador.PRESTADAS.get(me.getKey()).toString();
            texto += "\n ---------- \n";
        }
        return texto;
    }

    public static String DEVUELTAStoString() {
        String texto = "FICHAS DEVUELTAS ";
        for (Map.Entry me : Archivador.DEVUELTAS.entrySet()) {
            texto += "\n ---------- \n";
            texto += Archivador.DEVUELTAS.get(me.getKey()).toString();
            texto += "\n ---------- \n";
        }
        return texto;
    }

    public static String ESPERAtoString() {
        String texto = "FICHAS ESPERA ";
        for (Map.Entry me : Archivador.ESPERA.entrySet()) {
            texto += "\n ---------- \n";
            texto += Archivador.ESPERA.get(me.getKey()).toString();
            texto += "\n ---------- \n";
        }
        return texto;
    }
}
