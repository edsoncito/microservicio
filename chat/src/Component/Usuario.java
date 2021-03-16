package Component;

import java.util.UUID;

import org.json.JSONObject;

import Config.Config;
import Http.Http;

public class Usuario {

    public static JSONObject start(JSONObject data) {
        switch (data.getString("type")) {
            case "getAll":
                data = getAll(data);
                break;

        }
        return data;
    }

    private static JSONObject getAll(JSONObject data) {
        data.put("estado", "exito");
        String urls = "https://"+Config.getJSON("servicios").getJSONObject("usuario").getString("ip")+":"+Config.getJSON("servicios").getJSONObject("usuario").getString("puerto")+"?component=usuario&type=getAll";
        JSONObject obj = new JSONObject(Http.send(urls));
        data.put("data", obj.getJSONObject("data"));
        return data;
    }
}
