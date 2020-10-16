package Http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Http {

    public static String send(String urls) {
            try {
                URL url = new URL(urls);
                CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String resp = "";
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    resp+=inputLine;
                }
                br.close();
                return resp;
            } catch (MalformedURLException e) {
                System.out.println(e.getLocalizedMessage());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "";
        }
    
}