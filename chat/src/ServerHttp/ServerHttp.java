package ServerHttp;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jboss.com.sun.net.httpserver.Headers;
import org.jboss.com.sun.net.httpserver.HttpContext;
import org.jboss.com.sun.net.httpserver.HttpExchange;
import org.jboss.com.sun.net.httpserver.HttpPrincipal;
import org.jboss.com.sun.net.httpserver.HttpServer;
import org.json.JSONObject;

import Config.Config;
import Manejador.Manejador;
import util.console;

public class ServerHttp {

    public static void Start(int puerto) {
        HttpServer server;
        try {
            console.log(console.ANSI_YELLOW, "** Iniciando HTTP-SERVER " + Config.getJSON().getString("nombre")
                    + " en el puerto " + puerto + " **");
            server = HttpServer.create(new InetSocketAddress(puerto), 0);
            HttpContext context = server.createContext("/");
            context.setHandler(ServerHttp::handleRequest);
            server.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        Map<String, String> parametros = splitQuery(requestURI.getQuery());

        String component = parametros.get("component");
        String type = parametros.get("type");
        JSONObject response = new JSONObject();

        if (component != null) {
            response.put("component", component);
            if (type != null) {
                response.put("type", type);
                response = Manejador.start(response);
            } else {
                response.put("estado", "error");
                response.put("error", "no existe type");
            }
        } else {
            response.put("estado", "error");
            response.put("component", "no existe component");
        }

        exchange.sendResponseHeaders(200, response.toString().length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.toString().getBytes());
        os.close();
    }

    public static Map<String, String> splitQuery(String query) throws UnsupportedEncodingException {
        Map<String, String> query_pairs = new LinkedHashMap<String, String>();
        try {

            String[] pairs = query.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
                        URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            }
        } catch (Exception e) {
            System.out.println("No hay parametros");
        }

        return query_pairs;
    }


}