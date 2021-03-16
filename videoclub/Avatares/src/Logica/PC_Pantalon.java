package Logica;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class PC_Pantalon implements ParteDelCuerpoFactory {

    private BufferedImage image;
    private Estilo estilo;

    public PC_Pantalon(Estilo estilo) {
        this.estilo = estilo;
        try {
            image = ImageIO.read(new File(estilo.getUrl()));
        } catch (IOException e) {
            image = null;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (image != null) {
            g.drawImage(image, estilo.getX(), estilo.getY(), estilo.getWidth(), estilo.getHeight(), null);
        }
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    @Override
    public Estilo getEstilo() {
        return estilo;
    }

}
