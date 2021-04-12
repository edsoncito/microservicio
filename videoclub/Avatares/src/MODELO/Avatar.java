package MODELO;

import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;

import Logica.Estilo;
import Logica.ParteDelCuerpo;
import Logica.ParteDelCuerpoFactory;
import Logica.ParteDelCuerpo;

public class Avatar {

    private String nombre;
    private Usuario usuarioCreador;

    private HashMap<String, ParteDelCuerpoFactory> partes;

    public Avatar(Usuario usuarioCreador, String nombre) {
        this.nombre = nombre;
        this.usuarioCreador = usuarioCreador;
        partes = new HashMap<>();
        // INSTACIAMOS NUESTRO AVATAR POR DEFECTO
        setParte(ParteDelCuerpo.TIPO_POLERA, "default");
        setParte(ParteDelCuerpo.TIPO_CABELLO, "default");
        setParte(ParteDelCuerpo.TIPO_OJOS, "default");
        setParte(ParteDelCuerpo.TIPO_BOCA, "default");
        setParte(ParteDelCuerpo.TIPO_PANTALON, "default");
    }

    public void setParte(String categoria, String estilo) {
        Estilo estilo1 = ParteDelCuerpo.getEstilos(categoria).get(estilo);
        ParteDelCuerpoFactory polera = ParteDelCuerpo.get(estilo1);
        partes.put(estilo1.getCategoria(), polera);
    }

    public String getParte(String categoria) {
        ParteDelCuerpoFactory parte = partes.get(categoria);
        if (parte == null) {
            return "";
        }
        return parte.getEstilo().getNombre();
    }

    public void paint(Graphics g) {
        for (Map.Entry me : partes.entrySet()) {
            partes.get(me.getKey()).paint(g);
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        // usuarioCreador.getUsuario();
        return "NombreAvatar: " + this.getNombre() + " Usario Creador: " + usuarioCreador.getUsuario();
    }

}
