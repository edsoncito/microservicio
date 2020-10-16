package Manejador;

import org.json.JSONObject;

import Component.Chat;

public class Manejador {
        
    public static JSONObject start(JSONObject data){
        switch(data.getString("component")){
            case "chat":
                data = Chat.start(data);
                break;
        }
        return data;
    }
}
