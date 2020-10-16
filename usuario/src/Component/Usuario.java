package Component;

import java.util.UUID;

import org.json.JSONObject;

import Config.Config;
import util.jsonManager;

public class Usuario {

    public static JSONObject start(JSONObject data) {
        switch (data.getString("type")) {
            case "registro":
                data = registro(data);
                break;
            case "getAll":
                data = getAll(data);
                break;
            case "getByKey":
                data = getByKey(data);
                break;

        }
        return data;
    }

    private static JSONObject getAll(JSONObject data) {
        data.put("estado", "exito");
        data.put("data", jsonManager.getJSON("Usuario").getJSONObject("data"));
        return data;
    }

    private static JSONObject getByKey(JSONObject action) {
        JSONObject data = action.getJSONObject("data");
        String key = data.getString("key");
        data.put("estado", "exito");
        data.put("data", jsonManager.getJSON("Usuario").getJSONObject("data").getJSONObject(key));
        return data;
    }
    private static JSONObject registro(JSONObject action) {
        JSONObject data = action.getJSONObject("data");
        JSONObject nuevoUsuario = data;
        // nuevoUsuario.put("key", UUID.randomUUID().toString());
        // nuevoUsuario.put("nombres", "ricky2222");
        // nuevoUsuario.put("apellidos", "asda asda");
        // nuevoUsuario.put("telefono", "3000300300");
        nuevoUsuario.put("key", UUID.randomUUID().toString());
        JSONObject reducerUsuario = jsonManager.getJSON("Usuario");
        reducerUsuario.getJSONObject("data").put(nuevoUsuario.getString("key"), nuevoUsuario);
        jsonManager.sobreEscribirJson("Usuario", reducerUsuario);
        data.put("estado", "exito");
        data.put("data", jsonManager.getJSON("Usuario").getJSONObject("data"));
        return data;
    }

}
