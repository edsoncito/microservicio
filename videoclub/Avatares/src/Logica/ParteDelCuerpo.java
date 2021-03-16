package Logica;

import java.util.HashMap;

public class ParteDelCuerpo {

    public static HashMap<String, Estilo> ESTILO_OJOS = new HashMap<>();
    public static HashMap<String, Estilo> ESTILO_BOCA = new HashMap<>();
    public static HashMap<String, Estilo> ESTILO_POLERA = new HashMap<>();
    public static HashMap<String, Estilo> ESTILO_CABELLO = new HashMap<>();
    public static HashMap<String, Estilo> ESTILO_PANTALON = new HashMap<>();

    public static final String TIPO_OJOS = "ojos";
    public static final String TIPO_BOCA = "boca";
    public static final String TIPO_POLERA = "polera";
    public static final String TIPO_CABELLO = "cabello";
    public static final String TIPO_PANTALON = "pantalon";

    public static final String[] TIPOS = { TIPO_OJOS, TIPO_BOCA, TIPO_POLERA, TIPO_CABELLO, TIPO_PANTALON };

    public static ParteDelCuerpoFactory get(Estilo estilo) {
        switch (estilo.getCategoria()) {
            case TIPO_OJOS:
                return new PC_Ojos(estilo);
            case TIPO_BOCA:
                return new PC_Boca(estilo);
            case TIPO_POLERA:
                return new PC_Polera(estilo);
            case TIPO_CABELLO:
                return new PC_Polera(estilo);
            case TIPO_PANTALON:
                return new PC_Pantalon(estilo);
        }
        return null;
    }

    public static Estilo setEstilo(Estilo estilo) {
        switch (estilo.getCategoria()) {
            case ParteDelCuerpo.TIPO_BOCA:
                ParteDelCuerpo.ESTILO_BOCA.put(estilo.getNombre(), estilo);
                break;
            case ParteDelCuerpo.TIPO_OJOS:
                ParteDelCuerpo.ESTILO_OJOS.put(estilo.getNombre(), estilo);
                break;
            case ParteDelCuerpo.TIPO_POLERA:
                ParteDelCuerpo.ESTILO_POLERA.put(estilo.getNombre(), estilo);
                break;
            case ParteDelCuerpo.TIPO_CABELLO:
                ParteDelCuerpo.ESTILO_CABELLO.put(estilo.getNombre(), estilo);
                break;
            case ParteDelCuerpo.TIPO_PANTALON:
                ParteDelCuerpo.ESTILO_PANTALON.put(estilo.getNombre(), estilo);
                break;
        }
        return null;
    }

    public static HashMap<String, Estilo> getEstilos(String categoria) {
        switch (categoria) {
            case ParteDelCuerpo.TIPO_BOCA:
                return ParteDelCuerpo.ESTILO_BOCA;
            case ParteDelCuerpo.TIPO_OJOS:
                return ParteDelCuerpo.ESTILO_OJOS;
            case ParteDelCuerpo.TIPO_POLERA:
                return ParteDelCuerpo.ESTILO_POLERA;
            case ParteDelCuerpo.TIPO_CABELLO:
                return ParteDelCuerpo.ESTILO_CABELLO;
            case ParteDelCuerpo.TIPO_PANTALON:
                return ParteDelCuerpo.ESTILO_PANTALON;
        }
        return null;
    }
}
