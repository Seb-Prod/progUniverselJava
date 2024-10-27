package fr.ProgrammeUniversel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Enregistreur {

    private static final Enregistreur instance = new Enregistreur();

    public Enregistreur(){
        super();
    }
    
    public void enregistrer(Container p, String path) throws IOException {
        BufferedImage tamponSauvegarde = new BufferedImage(
                p.getWidth(),
                p.getHeight(),
                BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = tamponSauvegarde.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, p.getSize().width,
                p.getSize().height);
        p.paint(g);
        ImageIO.write(tamponSauvegarde, "JPG", new File(path)); 
    }

    public static Enregistreur getInstance() {
        return instance;
    }

}
