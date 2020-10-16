package Component;

import org.json.JSONObject;

import Config.Config;

public class Chat {

    public static JSONObject start(JSONObject data){
        switch(data.getString("type")){
            case "getAll":
                data = getAll(data);
                break;
        }
        return data;
    }

    private static JSONObject getAll(JSONObject data){
        data.put("estado", "exito");
        data.put("data", Config.getJSON());
        return data;
    }

}
