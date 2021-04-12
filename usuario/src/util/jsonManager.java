package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class jsonManager {

    public static JSONObject getJSON(String name) {
        JSONObject config = new JSONObject();
        try {
            FileReader file = new FileReader(name + ".json");
            int valor = file.read();
            String configJson = "";
            while (valor != -1) {
                configJson = configJson + String.valueOf(((char) valor));
                valor = file.read();
            }
            config = new JSONObject(configJson);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }

    public static JSONObject sobreEscribirJson(String name, JSONObject nuevo) {
        FileWriter file;
        try {
            file = new FileWriter(name + ".json");
            file.write(nuevo.toString());
            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println("error actualizar config  " + e);
        }
        return nuevo;
    }
}
