package Utils;

import java.util.UUID;

public class Utils {
 
    public static String getKEY(){
        return UUID.randomUUID().toString();
    }
}
