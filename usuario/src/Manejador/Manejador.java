package Manejador;

import java.security.Provider.Service;

import org.json.JSONObject;

import Component.Servicio;
import Component.Usuario;

public class Manejador {

    public static JSONObject start(JSONObject data) {
        switch (data.getString("component")) {
            case "usuario":
                data = Usuario.start(data);
                break;
            case "servicio":
                data = Servicio.start(data);
                break;
            default: 
                data.put("estado", "error");
                data.put("error", "no se encontro component");
        }
        return data;
    }
}
