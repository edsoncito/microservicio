import Config.Config;
import util.console;

public class App {
    public static void main(String[] args) throws Exception {
        console.error("Iniciando server Taller de Software");
        if (!Config.validate()) {
            console.error("Server closed.");
            return;
        }
    }
}
