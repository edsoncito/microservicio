package Persona;

import java.util.HashMap;
import java.util.Map;

public class Socio extends Persona {

    public static HashMap<String, Socio> DATA = new HashMap<>();

    public static String DATAtoString() {
        String texto = "SOCIOS";
        for (Map.Entry me : Socio.DATA.entrySet()) {
            texto += "\n ---------- \n";
            texto +=  DATA.get(me.getKey()).toString();
            texto += "\n ---------- \n";
        }
        return texto;
    }
    //---------------------------------------------------------------------------------//

    private String CodigoSocio;
    private String Direccion;
    private String Telefono;

    public Socio(String Nombres, String Apellidos, String Direccion, String Telefono) {
        super(Nombres, Apellidos);
        this.CodigoSocio = "VCS-" + Socio.DATA.size();
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        Socio.DATA.put(this.getKey(), this);
        // TODO Auto-generated constructor stub
    }

    public String getCodigoSocio() {
        return CodigoSocio;
    }

    public void setCodigoSocio(String codigoSocio) {
        CodigoSocio = codigoSocio;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    @Override
    public String toString() {
        String texto = "SOCIO";
        texto += " key: " + this.getKey();
        texto += "\n Nombres: " + this.getNombres();
        texto += "\n Apellidos: " + this.getApellidos();
        texto += "\n CodigoSocio: " + this.getCodigoSocio();
        texto += "\n Direccion: " + this.getDireccion();
        texto += "\n Telefono: " + this.getTelefono();
        return texto;
    }
}
