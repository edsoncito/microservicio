package Manejador;

import javax.sql.rowset.serial.SerialArray;

import org.json.JSONObject;

import Component.Chat;
import Component.Servicio;
import Component.Usuario;

public class Manejador {
        
    public static JSONObject start(JSONObject data){
        switch(data.getString("component")){
            case "chat":
                data = Chat.start(data);
                break;
            case "usuario":
                data = Usuario.start(data);
                break;
            case "servicio":
                data = Servicio.start(data);
                break;
        }
        return data;
    }
}
