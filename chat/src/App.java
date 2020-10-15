import Config.Config;
import SocketServer.SocketServer;
import util.console;

public class App {
    public static void main(String[] args) throws Exception {
        console.error("Iniciando server taller de software");
        if (!Config.validate()) {
            console.error("Server closed.");
            return;
        }      

        SocketServer.Start(Config.getJSON("serverSocket").getInt("puerto"));
        /* System.out.println(SSL.getPem(SSL.getCert(Config.getJSON().getString("nombre"))));
        SocketCliete.enableReconect(true);
        SocketCliete.Start(Config.getJSON("socket_client").getJSONObject("servicio"));
        Conexion.setConexion(Config.getJSON("data_base")); */
    }
}
