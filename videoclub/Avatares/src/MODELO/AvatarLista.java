package MODELO;

import java.util.HashMap;

public class AvatarLista {

    public static final HashMap<String, Avatar> avatares = new HashMap<>();

    public static void setAvatar( Avatar avatar) {
        avatares.put(avatar.getNombre(),avatar);
    }

}
