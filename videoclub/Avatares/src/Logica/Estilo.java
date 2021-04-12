package Logica;

import java.util.HashMap;

public class Estilo {
    private String nombre;
    private String Categoria;
    private int x;
    private int y;
    private int width;
    private int height;
    private String url;

    public Estilo(String nombre, String Categoria, int x, int y, int width, int height, String url) {
        this.nombre = nombre;
        this.Categoria = Categoria;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.url = url;
        ParteDelCuerpo.setEstilo(this);
    }

    public String getCategoria() {
        return Categoria;
    }

    public int getHeight() {
        return height;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
